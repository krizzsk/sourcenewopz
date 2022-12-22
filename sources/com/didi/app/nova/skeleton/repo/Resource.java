package com.didi.app.nova.skeleton.repo;

public class Resource<T> {
    public static final int CODE_UNKNOWN = -1;
    public final int code;
    public final T data;
    public final String message;
    public final Status status;

    public enum Status {
        SUCCESS,
        ERROR,
        LOADING,
        CHANGE
    }

    protected Resource(Status status2, T t, int i, String str) {
        this.status = status2;
        this.data = t;
        this.code = i;
        this.message = str;
    }

    public static <T> Resource<T> success(T t) {
        return new Resource<>(Status.SUCCESS, t, -1, (String) null);
    }

    public static <T> Resource<T> error(String str) {
        return error(-1, str);
    }

    public static <T> Resource<T> error(int i, String str) {
        return new Resource<>(Status.ERROR, (Object) null, i, str);
    }

    public static <T> Resource<T> loading() {
        return new Resource<>(Status.LOADING, (Object) null, -1, (String) null);
    }

    public static <T> Resource<T> change(T t) {
        return new Resource<>(Status.CHANGE, t, -1, (String) null);
    }
}
