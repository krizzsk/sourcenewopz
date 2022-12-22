package com.didi.soda.datasource.page;

import java.util.List;

public class PageResult<Value> {
    public static final int RESULT_APPEND = 2;
    public static final int RESULT_INIT = 1;

    /* renamed from: a */
    private int f42269a;

    /* renamed from: b */
    private List<Value> f42270b;

    /* renamed from: c */
    private int f42271c;

    public PageResult(int i, List<Value> list, int i2) {
        this.f42270b = list;
        this.f42269a = i;
        this.f42271c = i2;
    }

    public List<Value> getValueList() {
        return this.f42270b;
    }

    public int getCurrentPage() {
        return this.f42269a;
    }

    public int getResultType() {
        return this.f42271c;
    }

    public boolean isEmpty() {
        List<Value> list = this.f42270b;
        return list == null || list.isEmpty();
    }
}
