package com.didi.entrega.customer.foundation.storage;

public interface CreateInstance<T> {
    T create(Class<T> cls);
}
