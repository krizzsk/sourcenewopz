package com.didi.soda.datasource.page;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/datasource/page/PageParams;", "", "()V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "pageIndex", "", "getPageIndex", "()I", "setPageIndex", "(I)V", "recId", "", "getRecId", "()Ljava/lang/String;", "setRecId", "(Ljava/lang/String;)V", "reset", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PageParams.kt */
public class PageParams {

    /* renamed from: a */
    private int f42266a;

    /* renamed from: b */
    private String f42267b;

    /* renamed from: c */
    private boolean f42268c;

    public final int getPageIndex() {
        return this.f42266a;
    }

    public final void setPageIndex(int i) {
        this.f42266a = i;
    }

    public final String getRecId() {
        return this.f42267b;
    }

    public final void setRecId(String str) {
        this.f42267b = str;
    }

    public boolean getHasMore() {
        return this.f42268c;
    }

    public void setHasMore(boolean z) {
        this.f42268c = z;
    }

    public void reset() {
        this.f42266a = 0;
        this.f42267b = "";
        setHasMore(false);
    }
}
