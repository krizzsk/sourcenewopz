package com.didi.soda.search.component.result;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/SearchResultPayLoad;", "Ljava/io/Serializable;", "()V", "mCateId", "", "getMCateId", "()Ljava/lang/String;", "setMCateId", "(Ljava/lang/String;)V", "mComponentIndex", "", "getMComponentIndex", "()I", "setMComponentIndex", "(I)V", "mPageFilter", "getMPageFilter", "setMPageFilter", "mPageId", "getMPageId", "setMPageId", "mPageIndex", "getMPageIndex", "setMPageIndex", "mRecId", "getMRecId", "setMRecId", "mTraceId", "getMTraceId", "setMTraceId", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultPayLoad.kt */
public final class SearchResultPayLoad implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -7390589692390809788L;
    private String mCateId = "";
    private int mComponentIndex;
    private String mPageFilter = "";
    private String mPageId = "";
    private int mPageIndex;
    private String mRecId = "";
    private String mTraceId = "";

    public final String getMPageId() {
        return this.mPageId;
    }

    public final void setMPageId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mPageId = str;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }

    public final String getMPageFilter() {
        return this.mPageFilter;
    }

    public final void setMPageFilter(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mPageFilter = str;
    }

    public final String getMRecId() {
        return this.mRecId;
    }

    public final void setMRecId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mRecId = str;
    }

    public final int getMComponentIndex() {
        return this.mComponentIndex;
    }

    public final void setMComponentIndex(int i) {
        this.mComponentIndex = i;
    }

    public final String getMTraceId() {
        return this.mTraceId;
    }

    public final void setMTraceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTraceId = str;
    }

    public final String getMCateId() {
        return this.mCateId;
    }

    public final void setMCateId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCateId = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/SearchResultPayLoad$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SearchResultPayLoad.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
