package resource;

import Repo.FibonacciRepository;
import domain.FibonacciArray;
import domain.UserRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Produces(MediaType.APPLICATION_JSON)
@Path("/fibonacci")
public class FibonacciResource {
    private final String welcomeMsg;
    private final FibonacciRepository fibonacciRepository;

    public FibonacciResource(String welcomeMsg, FibonacciRepository fibonacciRepository) {
        this.welcomeMsg = welcomeMsg;
        this.fibonacciRepository = fibonacciRepository;
    }

    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public FibonacciArray getFibBySize(UserRequest userRequest) {
        int size = userRequest.getElements();
        if(size > 0 && size<= 100) {
            return fibonacciRepository.getFibonacciArray(size);
        }
        else {
            return null;
        }
    }
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{size}")
    public FibonacciArray getFibBySize(@PathParam("size") int size) {
        if(size > 0 && size<= 100) {
            return fibonacciRepository.getFibonacciArray(size);
        }
        else {
            return null;
        }
    }

}
