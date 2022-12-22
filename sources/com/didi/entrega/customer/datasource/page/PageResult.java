package com.didi.entrega.customer.datasource.page;

import java.util.List;

public class PageResult<Value> {
    public static final int RESULT_APPEND = 2;
    public static final int RESULT_INIT = 1;

    /* renamed from: a */
    private int f19871a;

    /* renamed from: b */
    private List<Value> f19872b;

    /* renamed from: c */
    private int f19873c;

    public PageResult(int i, List<Value> list, int i2) {
        this.f19872b = list;
        this.f19871a = i;
        this.f19873c = i2;
    }

    public List<Value> getValueList() {
        return this.f19872b;
    }

    public int getCurrentPage() {
        return this.f19871a;
    }

    public int getResultType() {
        return this.f19873c;
    }

    public boolean isEmpty() {
        List<Value> list = this.f19872b;
        return list == null || list.isEmpty();
    }
}
