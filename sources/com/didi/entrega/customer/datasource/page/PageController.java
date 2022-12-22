package com.didi.entrega.customer.datasource.page;

import com.didi.entrega.customer.datasource.listener.PageEventListener;
import java.util.ArrayList;
import java.util.List;

public class PageController<Param, Value> {

    /* renamed from: a */
    private int f19867a;

    /* renamed from: b */
    private int f19868b;

    /* renamed from: c */
    private PageEventListener<Param> f19869c;

    /* renamed from: d */
    private PageStore<Value, ?> f19870d;

    public void initialize(int i, PageEventListener<Param> pageEventListener, PageStore pageStore) {
        this.f19867a = i;
        this.f19868b = i;
        this.f19869c = pageEventListener;
        this.f19870d = pageStore;
    }

    public void loadInit() {
        loadInit((Object) null);
    }

    public void loadInit(Param param) {
        int i = this.f19867a;
        this.f19868b = i;
        PageEventListener<Param> pageEventListener = this.f19869c;
        if (pageEventListener != null) {
            pageEventListener.onPageLoad(i, param);
        }
    }

    public int loadNextPage() {
        return loadNextPage((Object) null);
    }

    public int loadNextPage(Param param) {
        int i = this.f19868b;
        PageEventListener<Param> pageEventListener = this.f19869c;
        if (pageEventListener != null) {
            pageEventListener.onPageLoad(i, param);
        }
        return i;
    }

    public PageResult<Value> receiveResult(List<Value> list, int i) {
        int i2 = i == this.f19867a ? 1 : 2;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        PageResult<Value> pageResult = new PageResult<>(this.f19868b, arrayList, i2);
        this.f19870d.receivePageResult(pageResult);
        this.f19868b = i + 1;
        return pageResult;
    }
}
