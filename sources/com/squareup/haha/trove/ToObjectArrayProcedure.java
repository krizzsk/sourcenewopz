package com.squareup.haha.trove;

final class ToObjectArrayProcedure<T> implements TObjectProcedure<T> {
    private int pos;
    private final T[] target;

    public ToObjectArrayProcedure(T[] tArr) {
        this.target = tArr;
    }

    public final boolean execute(T t) {
        T[] tArr = this.target;
        int i = this.pos;
        this.pos = i + 1;
        tArr[i] = t;
        return true;
    }
}
