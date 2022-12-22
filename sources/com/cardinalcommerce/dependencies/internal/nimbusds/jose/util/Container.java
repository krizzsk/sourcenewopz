package com.cardinalcommerce.dependencies.internal.nimbusds.jose.util;

public class Container<T> {
    public T getInstance;

    public Container() {
    }

    public Container(T t) {
        this.getInstance = t;
    }
}
