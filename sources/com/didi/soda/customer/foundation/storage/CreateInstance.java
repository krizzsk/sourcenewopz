package com.didi.soda.customer.foundation.storage;

public interface CreateInstance<T> {
    T create(Class<T> cls);
}
