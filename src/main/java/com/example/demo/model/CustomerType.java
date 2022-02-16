package com.example.demo.model;

public enum CustomerType {
    LOYAL, NEW, DISSATISFIED;
 
    public String getValue() {
        return this.toString();
    }
}
