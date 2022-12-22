package com.didi.soda.datasource.page;

import com.didi.soda.datasource.listener.PageEventListener;
import java.util.ArrayList;
import java.util.List;

public class PageController<Param, Value> {

    /* renamed from: a */
    private int f42262a;

    /* renamed from: b */
    private int f42263b;

    /* renamed from: c */
    private PageEventListener<Param> f42264c;

    /* renamed from: d */
    private PageStore<Value, ?> f42265d;

    public void initialize(int i, PageEventListener<Param> pageEventListener, PageStore pageStore) {
        this.f42262a = i;
        this.f42263b = i;
        this.f42264c = pageEventListener;
        this.f42265d = pageStore;
    }

    public void loadInit() {
        loadInit((Object) null);
    }

    public void loadInit(Param param) {
        int i = this.f42262a;
        this.f42263b = i;
        PageEventListener<Param> pageEventListener = this.f42264c;
        if (pageEventListener != null) {
            pageEventListener.onPageLoad(i, param);
        }
    }

    public int loadNextPage() {
        return loadNextPage((Object) null);
    }

    public int loadNextPage(Param param) {
        int i = this.f42263b;
        PageEventListener<Param> pageEventListener = this.f42264c;
        if (pageEventListener != null) {
            pageEventListener.onPageLoad(i, param);
        }
        return i;
    }

    public PageResult<Value> receiveResult(List<Value> list, int i) {
        int i2 = i == this.f42262a ? 1 : 2;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        PageResult<Value> pageResult = new PageResult<>(this.f42263b, arrayList, i2);
        this.f42265d.receivePageResult(pageResult);
        this.f42263b = i + 1;
        return pageResult;
    }
}
