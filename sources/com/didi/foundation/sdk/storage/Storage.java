package com.didi.foundation.sdk.storage;

import android.content.Context;
import android.os.Parcelable;
import com.didi.foundation.sdk.storage.IStorage;
import java.io.Serializable;

public abstract class Storage<T extends Parcelable> implements IStorage<T> {

    /* renamed from: a */
    private IStorage f21320a;

    public Storage() {
        this.f21320a = new C8386a(getClass().getName());
    }

    public Storage(String str) {
        this.f21320a = new C8386a(str);
    }

    public Storage(Context context) {
        this.f21320a = new C8386a(getClass().getName(), context);
    }

    public Storage(String str, Context context) {
        this.f21320a = new C8386a(str, context);
    }

    public T getData(String str) {
        return (Parcelable) this.f21320a.getData(str);
    }

    public void setData(String str, T t) {
        this.f21320a.setData(str, t);
    }

    public void setData(T t) {
        this.f21320a.setData(t);
    }

    public T getData() {
        return (Parcelable) this.f21320a.getData();
    }

    public void clear() {
        this.f21320a.clear();
    }

    public boolean has(String str) {
        return this.f21320a.has(str);
    }

    public void remove(String str) {
        this.f21320a.remove(str);
    }

    public boolean getBoolean(String str) {
        return this.f21320a.getBoolean(str);
    }

    public void putBoolean(String str, boolean z) {
        this.f21320a.putBoolean(str, z);
    }

    public IStorage setBoolean(String str, boolean z) {
        return this.f21320a.setBoolean(str, z);
    }

    public int getInt(String str) {
        return this.f21320a.getInt(str);
    }

    public void putInt(String str, int i) {
        this.f21320a.putInt(str, i);
    }

    public IStorage setInt(String str, int i) {
        return this.f21320a.setInt(str, i);
    }

    public float getFloat(String str) {
        return this.f21320a.getFloat(str);
    }

    public void putFloat(String str, float f) {
        this.f21320a.putFloat(str, f);
    }

    public IStorage setFloat(String str, float f) {
        return this.f21320a.setFloat(str, f);
    }

    public long getLong(String str) {
        return this.f21320a.getLong(str);
    }

    public void putLong(String str, long j) {
        this.f21320a.putLong(str, j);
    }

    public IStorage setLong(String str, long j) {
        return this.f21320a.setLong(str, j);
    }

    public String getString(String str) {
        return this.f21320a.getString(str);
    }

    public void putString(String str, String str2) {
        this.f21320a.putString(str, str2);
    }

    public IStorage setString(String str, String str2) {
        return this.f21320a.setString(str, str2);
    }

    public Serializable getSerializable(String str) {
        return this.f21320a.getSerializable(str);
    }

    public void putSerializable(String str, Serializable serializable) {
        this.f21320a.putSerializable(str, serializable);
    }

    public void commit(IStorage.Callback callback) {
        this.f21320a.commit(callback);
    }
}
