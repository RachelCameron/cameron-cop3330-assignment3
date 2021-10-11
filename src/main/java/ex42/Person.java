package ex42;

/**
 * Exercise 42.
 *
 * This class represents a person
 * (a single row in the printed table).
 */

public class Person {
    private String first;
    private String last;
    private double salary;

    public Person(String first, String last, double salary) {
        this.first = first;
        this.last = last;
        this.salary = salary;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}