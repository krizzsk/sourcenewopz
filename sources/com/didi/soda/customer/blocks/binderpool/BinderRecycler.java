package com.didi.soda.customer.blocks.binderpool;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/binderpool/BinderRecycler;", "", "()V", "scrapDataMap", "", "", "Lcom/didi/soda/customer/blocks/binderpool/BinderRecycler$ScrapData;", "clearCachePool", "", "getViewData", "Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "type", "recycleBinderRoot", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recycleView", "binderRoot", "ScrapData", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BinderRecycler.kt */
public final class BinderRecycler {

    /* renamed from: a */
    private final Map<String, ScrapData> f40556a = new LinkedHashMap();

    public final void recycleBinderRoot(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof RecyclerViewHolder) {
            RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) viewHolder;
            BinderRoot binderRoot = recyclerViewHolder.getBinderRoot();
            if (binderRoot != null) {
                binderRoot.internalRest();
                m28807a(binderRoot);
                recyclerViewHolder.removeFromItemView();
                return;
            }
            throw new IllegalStateException("holder 没有绑定 binderRoot");
        }
    }

    public final void clearCachePool() {
        this.f40556a.clear();
    }

    public final BinderRoot<?, ?> getViewData(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        ScrapData scrapData = this.f40556a.get(str);
        if (scrapData == null) {
            return null;
        }
        if (scrapData.getList().isEmpty()) {
            return null;
        }
        return scrapData.getList().remove(CollectionsKt.getLastIndex(scrapData.getList()));
    }

    /* renamed from: a */
    private final void m28807a(BinderRoot<?, ?> binderRoot) {
        ScrapData scrapData = this.f40556a.get(binderRoot.getType());
        if (scrapData == null) {
            scrapData = new ScrapData();
            this.f40556a.put(binderRoot.getType(), scrapData);
        }
        if (scrapData.getList().size() < scrapData.getMax()) {
            scrapData.getList().add(binderRoot);
        } else {
            LogUtil.m29100d("TAG", ">>>>> 达到存储上限 <<<<<");
        }
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/binderpool/BinderRecycler$ScrapData;", "", "()V", "list", "", "Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "getList", "()Ljava/util/List;", "max", "", "getMax", "()I", "setMax", "(I)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BinderRecycler.kt */
    private static final class ScrapData {
        private final List<BinderRoot<?, ?>> list = new ArrayList();
        private int max = 7;

        public final List<BinderRoot<?, ?>> getList() {
            return this.list;
        }

        public final int getMax() {
            return this.max;
        }

        public final void setMax(int i) {
            this.max = i;
        }
    }
}
