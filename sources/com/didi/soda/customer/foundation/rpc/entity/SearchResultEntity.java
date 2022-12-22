package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.datasource.page.dynamic.DynamicBaseEntity;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/SearchResultEntity;", "Lcom/didi/soda/datasource/page/dynamic/DynamicBaseEntity;", "()V", "mBrandList", "Lcom/didi/soda/customer/foundation/rpc/entity/SearchModuleEntity;", "mFilterList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/FilterEntity;", "mIntentionType", "", "mIsDirtyWords", "", "mIsRefresh", "mNoResultData", "mOutRangeData", "mRecId", "", "mRecommendRsp", "mSearchResultData", "operateNum", "getOperateNum", "()I", "outRangeNum", "getOutRangeNum", "searchResultNum", "getSearchResultNum", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultEntity.kt */
public final class SearchResultEntity extends DynamicBaseEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 1898838055774493409L;
    @SerializedName("brandList")
    public SearchModuleEntity mBrandList;
    @SerializedName("filterList")
    public List<? extends FilterEntity> mFilterList;
    @SerializedName("intentionType")
    public int mIntentionType;
    @SerializedName("isDirtyWords")
    public boolean mIsDirtyWords;
    public boolean mIsRefresh;
    @SerializedName("noResult")
    public SearchModuleEntity mNoResultData;
    @SerializedName("outRangeRsp")
    public SearchModuleEntity mOutRangeData;
    @SerializedName("recId")
    public String mRecId;
    @SerializedName("recommendRsp")
    public SearchModuleEntity mRecommendRsp;
    @SerializedName("searchRsp")
    public SearchModuleEntity mSearchResultData;

    public final int getOutRangeNum() {
        List<JsonObject> list;
        SearchModuleEntity searchModuleEntity = this.mOutRangeData;
        if (searchModuleEntity == null || (list = searchModuleEntity.mJsonComponentList) == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r0.mJsonComponentList;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getSearchResultNum() {
        /*
            r3 = this;
            com.didi.soda.customer.foundation.rpc.entity.SearchModuleEntity r0 = r3.mBrandList
            r1 = 0
            if (r0 != 0) goto L_0x0007
        L_0x0005:
            r0 = 0
            goto L_0x0010
        L_0x0007:
            java.util.List<com.google.gson.JsonObject> r0 = r0.mJsonComponentList
            if (r0 != 0) goto L_0x000c
            goto L_0x0005
        L_0x000c:
            int r0 = r0.size()
        L_0x0010:
            int r0 = r0 + r1
            com.didi.soda.customer.foundation.rpc.entity.SearchModuleEntity r2 = r3.mSearchResultData
            if (r2 != 0) goto L_0x0016
            goto L_0x001f
        L_0x0016:
            java.util.List<com.google.gson.JsonObject> r2 = r2.mJsonComponentList
            if (r2 != 0) goto L_0x001b
            goto L_0x001f
        L_0x001b:
            int r1 = r2.size()
        L_0x001f:
            int r0 = r0 + r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity.getSearchResultNum():int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getOperateNum() {
        /*
            r6 = this;
            com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity$operateNum$predicate$1 r0 = com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity$operateNum$predicate$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            com.didi.soda.customer.foundation.rpc.entity.SearchModuleEntity r1 = r6.mBrandList
            r2 = 0
            if (r1 != 0) goto L_0x000b
        L_0x0009:
            r3 = 0
            goto L_0x0043
        L_0x000b:
            java.util.List<com.google.gson.JsonObject> r1 = r1.mJsonComponentList
            if (r1 != 0) goto L_0x0010
            goto L_0x0009
        L_0x0010:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r3 = r1 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0020
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0020
            goto L_0x0009
        L_0x0020:
            java.util.Iterator r1 = r1.iterator()
            r3 = 0
        L_0x0025:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0043
            java.lang.Object r4 = r1.next()
            java.lang.Object r4 = r0.invoke(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0025
            int r3 = r3 + 1
            if (r3 >= 0) goto L_0x0025
            kotlin.collections.CollectionsKt.throwCountOverflow()
            goto L_0x0025
        L_0x0043:
            int r3 = r3 + r2
            com.didi.soda.customer.foundation.rpc.entity.SearchModuleEntity r1 = r6.mSearchResultData
            if (r1 != 0) goto L_0x004a
        L_0x0048:
            r4 = 0
            goto L_0x0082
        L_0x004a:
            java.util.List<com.google.gson.JsonObject> r1 = r1.mJsonComponentList
            if (r1 != 0) goto L_0x004f
            goto L_0x0048
        L_0x004f:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r4 = r1 instanceof java.util.Collection
            if (r4 == 0) goto L_0x005f
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x005f
            goto L_0x0048
        L_0x005f:
            java.util.Iterator r1 = r1.iterator()
            r4 = 0
        L_0x0064:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0082
            java.lang.Object r5 = r1.next()
            java.lang.Object r5 = r0.invoke(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0064
            int r4 = r4 + 1
            if (r4 >= 0) goto L_0x0064
            kotlin.collections.CollectionsKt.throwCountOverflow()
            goto L_0x0064
        L_0x0082:
            int r3 = r3 + r4
            com.didi.soda.customer.foundation.rpc.entity.SearchModuleEntity r1 = r6.mRecommendRsp
            if (r1 != 0) goto L_0x0088
            goto L_0x00bf
        L_0x0088:
            java.util.List<com.google.gson.JsonObject> r1 = r1.mJsonComponentList
            if (r1 != 0) goto L_0x008d
            goto L_0x00bf
        L_0x008d:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r4 = r1 instanceof java.util.Collection
            if (r4 == 0) goto L_0x009d
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x009d
            goto L_0x00bf
        L_0x009d:
            java.util.Iterator r1 = r1.iterator()
        L_0x00a1:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00bf
            java.lang.Object r4 = r1.next()
            java.lang.Object r4 = r0.invoke(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x00a1
            int r2 = r2 + 1
            if (r2 >= 0) goto L_0x00a1
            kotlin.collections.CollectionsKt.throwCountOverflow()
            goto L_0x00a1
        L_0x00bf:
            int r3 = r3 + r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity.getOperateNum():int");
    }

    public String toString() {
        return "SearchResultEntity{, mRecId='" + this.mRecId + "', mBrandList=" + this.mBrandList + ", mSearchResultData=" + this.mSearchResultData + ", mOutRangeData=" + this.mOutRangeData + ", mRecommendRsp=" + this.mRecommendRsp + ", mIsDirtyWords=" + this.mIsDirtyWords + ", mIsRefresh=" + this.mIsRefresh + '}';
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/SearchResultEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SearchResultEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
