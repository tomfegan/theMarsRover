package org.northcoders.marsroverproject;

public record PlateauSize(int rows, int columns) {
    /* Plateau size is final and using a record (instead of a class) enforces its
    immutability (e.g., no setters) and reduces boilerplate for easier reading
    and maintenance */

    @Override
    public String toString() {
        return String.format("%d by %d plateau", rows, columns);
    }
}