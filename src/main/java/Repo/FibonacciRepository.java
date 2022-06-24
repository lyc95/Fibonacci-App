package Repo;

import domain.FibonacciArray;
import helper.FibArrayGenerator;

public class FibonacciRepository {
    FibArrayGenerator generator = new FibArrayGenerator();
    public FibonacciRepository() { }

    public FibonacciArray getFibonacciArray(int size) {
        return new FibonacciArray(generator.getFibArrayWithSize(size), generator.getSortedFibArrayWithSize(size));
    }
}
