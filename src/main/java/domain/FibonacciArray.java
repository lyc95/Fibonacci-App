package domain;

import helper.FibArrayGenerator;

public class FibonacciArray {
    private final String[] fibonacci;
    private final String[] sorted;
    public FibonacciArray(String[] fibonacci, String[] sorted) {
        this.fibonacci = fibonacci;
        this.sorted = sorted;
    }

    public String[] getFibonacci() {
        return fibonacci;
    }

    public String[] getSorted() {
        return sorted;
    }
}
