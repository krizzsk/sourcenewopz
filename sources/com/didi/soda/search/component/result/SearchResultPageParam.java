package com.didi.soda.search.component.result;

import com.didi.soda.datasource.page.PageParams;
import com.didi.soda.search.repo.SearchWordModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00102\u001a\u00020\u0010J\b\u00103\u001a\u000204H\u0016J\u000e\u00105\u001a\u0002042\u0006\u00106\u001a\u00020%R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001c\u0010)\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001c\u0010,\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001c\u0010/\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\b¨\u00068"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/SearchResultPageParam;", "Lcom/didi/soda/datasource/page/PageParams;", "()V", "filterParams", "", "getFilterParams", "()Ljava/lang/String;", "setFilterParams", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "highRatingRecallNumm", "", "getHighRatingRecallNumm", "()I", "setHighRatingRecallNumm", "(I)V", "intentionType", "getIntentionType", "setIntentionType", "lastBusinessId", "getLastBusinessId", "setLastBusinessId", "lastQuery", "getLastQuery", "setLastQuery", "pageType", "getPageType", "setPageType", "queryCkJson", "getQueryCkJson", "setQueryCkJson", "searchFrom", "Lcom/didi/soda/search/repo/SearchWordModel$SearchFrom;", "searchTag", "getSearchTag", "setSearchTag", "sugCkJson", "getSugCkJson", "setSugCkJson", "sugId", "getSugId", "setSugId", "traceId", "getTraceId", "setTraceId", "getSearchFrom", "reset", "", "setSearchFrom", "from", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultPageParam.kt */
public final class SearchResultPageParam extends PageParams {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAGETYPE_RECOMMMEND = 1;
    public static final int PAGETYPE_SEARCH = 0;

    /* renamed from: a */
    private boolean f43730a;

    /* renamed from: b */
    private String f43731b;

    /* renamed from: c */
    private String f43732c = "";

    /* renamed from: d */
    private String f43733d = "0";

    /* renamed from: e */
    private SearchWordModel.SearchFrom f43734e = SearchWordModel.SearchFrom.EDIT;

    /* renamed from: f */
    private int f43735f;

    /* renamed from: g */
    private String f43736g;

    /* renamed from: h */
    private String f43737h;

    /* renamed from: i */
    private String f43738i;

    /* renamed from: j */
    private String f43739j;

    /* renamed from: k */
    private String f43740k;

    /* renamed from: l */
    private int f43741l;

    /* renamed from: m */
    private int f43742m;

    public boolean getHasMore() {
        return this.f43730a;
    }

    public void setHasMore(boolean z) {
        this.f43730a = z;
    }

    public final String getSearchTag() {
        return this.f43731b;
    }

    public final void setSearchTag(String str) {
        this.f43731b = str;
    }

    public final String getFilterParams() {
        return this.f43732c;
    }

    public final void setFilterParams(String str) {
        this.f43732c = str;
    }

    public final String getLastBusinessId() {
        return this.f43733d;
    }

    public final void setLastBusinessId(String str) {
        this.f43733d = str;
    }

    public final int getPageType() {
        return this.f43735f;
    }

    public final void setPageType(int i) {
        this.f43735f = i;
    }

    public final String getSugId() {
        return this.f43736g;
    }

    public final void setSugId(String str) {
        this.f43736g = str;
    }

    public final String getSugCkJson() {
        return this.f43737h;
    }

    public final void setSugCkJson(String str) {
        this.f43737h = str;
    }

    public final String getQueryCkJson() {
        return this.f43738i;
    }

    public final void setQueryCkJson(String str) {
        this.f43738i = str;
    }

    public final String getLastQuery() {
        return this.f43739j;
    }

    public final void setLastQuery(String str) {
        this.f43739j = str;
    }

    public final String getTraceId() {
        return this.f43740k;
    }

    public final void setTraceId(String str) {
        this.f43740k = str;
    }

    public final int getIntentionType() {
        return this.f43741l;
    }

    public final void setIntentionType(int i) {
        this.f43741l = i;
    }

    public final int getHighRatingRecallNumm() {
        return this.f43742m;
    }

    public final void setHighRatingRecallNumm(int i) {
        this.f43742m = i;
    }

    public final void setSearchFrom(SearchWordModel.SearchFrom searchFrom) {
        Intrinsics.checkNotNullParameter(searchFrom, "from");
        this.f43734e = searchFrom;
    }

    public final int getSearchFrom() {
        return this.f43734e.ordinal();
    }

    public void reset() {
        super.reset();
        this.f43732c = "";
        this.f43733d = "0";
        this.f43734e = SearchWordModel.SearchFrom.EDIT;
        this.f43735f = 0;
        this.f43736g = null;
        this.f43737h = null;
        this.f43738i = null;
        this.f43739j = null;
        this.f43740k = "";
        this.f43741l = 0;
        this.f43742m = 0;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/SearchResultPageParam$Companion;", "", "()V", "PAGETYPE_RECOMMMEND", "", "PAGETYPE_SEARCH", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SearchResultPageParam.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
