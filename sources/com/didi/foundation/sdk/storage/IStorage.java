package com.didi.foundation.sdk.storage;

import java.io.Serializable;

public interface IStorage<T> {

    public interface Callback {
        void done(boolean z);
    }

    void clear();

    void commit(Callback callback);

    boolean getBoolean(String str);

    T getData();

    T getData(String str);

    float getFloat(String str);

    int getInt(String str);

    long getLong(String str);

    Serializable getSerializable(String str);

    String getString(String str);

    boolean has(String str);

    void putBoolean(String str, boolean z);

    void putFloat(String str, float f);

    void putInt(String str, int i);

    void putLong(String str, long j);

    void putSerializable(String str, Serializable serializable);

    void putString(String str, String str2);

    void remove(String str);

    IStorage setBoolean(String str, boolean z);

    void setData(T t);

    void setData(String str, T t);

    IStorage setFloat(String str, float f);

    IStorage setInt(String str, int i);

    IStorage setLong(String str, long j);

    IStorage setString(String str, String str2);
}
