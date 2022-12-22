package com.wujie.dimina.bridge.plugin.contact;

public interface IContactCallback<T> {
    void onAdd(T t);

    void onCancel(T t);

    void onUpdate(T t);
}
