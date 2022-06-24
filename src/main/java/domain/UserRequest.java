package domain;

public class UserRequest {
    private int elements;

    public UserRequest(int elements) {
        this.elements = elements;
    }

    public UserRequest() {
    }

    public int getElements() {
        return elements;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }
}
