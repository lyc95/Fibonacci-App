import React, {Component} from 'react';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import {FormErrors} from "./FormErrors";
class Main extends Component {
    emptyItem = {
        elements: ''
    };
    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem,
            elementsValid: false,
            formValid: false,
            fibonacci: [],
            sorted: [],
            formErrors: {
                elements: ''
            }
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    async componentDidMount() {
        this.setState({formValid: false});
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item},
            () => {this.validateField(name, value)});
    }
    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let elementsValid = this.state.elementsValid;
        switch(fieldName) {
            case 'elements':
                elementsValid = value > 0 && value <= 100;
                fieldValidationErrors.elements = elementsValid ? '' : 'The valid input needs to be from 1 to 100';
                break;
            default:
                break;
        }
        this.setState({formErrors: fieldValidationErrors,
            elementsValid: elementsValid,
        }, this.validateForm);
    }
    validateForm() {
        this.setState({formValid: this.state.elementsValid});
    }
    errorClass(error) {
        return(error.length === 0 ? '' : 'has-error');
    }
    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch(`/fibonacci/${item.elements}`)
        .then(response => response.json())
            .then(data => this.setState({fibonacci: data.fibonacci, sorted: data.sorted}));
    }

    render (){
        const {item} = this.state;
        const title =
            <div>
                <h2>Welcome to Fibonacci Application!</h2>
                <h3>PLease input size to get Fibonacci Array(1-100)</h3>
            </div>;
        const {fibonacci, sorted} = this.state;

        const showArray = (array, title) => {
          if(array.length === 0) {
              return (
                <div></div>
              );
          }
          let items = ' ';
          array.map(num =>{
              items = items + num + ' ';
          });
          items = '[' + items + ']';
          return (
            <div>
                <strong>{title}</strong>:  {items}
            </div>
          );
        };
        const normalArray = showArray(fibonacci, 'Fibonacci Array');
        const sortedArray = showArray(sorted, 'Sorted Fibonacci Array');
        return(
            <Container className="mt-5">
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup className={`${this.errorClass(this.state.formErrors.elements)}`}>
                        <Label for="elements">Size of Fibonacci Array</Label>
                        <Input type="number" name="elements" id="elements" value={item.elements || ''}
                               onChange={this.handleChange} />
                    </FormGroup>
                    <div className="panel panel-default">
                        <FormErrors formErrors={this.state.formErrors} />
                    </div>
                    <FormGroup >
                        <Button color="primary" type="submit" disabled = {!this.state.formValid}>Click to get Fibonacci Array!</Button>
                    </FormGroup>
                </Form>

                <div>
                    {normalArray}
                </div>
                <div>
                    {sortedArray}
                </div>
            </Container>
        )
    }
}
export default Main;