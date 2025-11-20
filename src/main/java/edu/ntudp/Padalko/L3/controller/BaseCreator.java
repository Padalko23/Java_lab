package edu.ntudp.Padalko.L3.controller;

public abstract class BaseCreator<T> implements Creator<T> {
    protected String generateId(String prefix, int number) {
        return prefix + String.format("%03d", number);
    }
}