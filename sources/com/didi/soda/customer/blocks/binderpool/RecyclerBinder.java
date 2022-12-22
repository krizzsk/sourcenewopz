package com.didi.soda.customer.blocks.binderpool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.widget.Buildable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B!\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0002\u0010\tJ#\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0012J \u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u001e\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010\u001f\u001a\u00020 H&J\u0015\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00028\u0000H&¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/binderpool/RecyclerBinder;", "T", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/customer/blocks/binderpool/RecyclerViewHolder;", "()V", "itemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "binderRootconfig", "Lcom/didi/soda/blocks/BinderRootConfig;", "(Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;Lcom/didi/soda/blocks/BinderRootConfig;)V", "binderRecycler", "Lcom/didi/soda/customer/blocks/binderpool/BinderRecycler;", "config", "getConfig", "()Lcom/didi/soda/blocks/BinderRootConfig;", "setConfig", "(Lcom/didi/soda/blocks/BinderRootConfig;)V", "bind", "", "holder", "item", "(Lcom/didi/soda/customer/blocks/binderpool/RecyclerViewHolder;Ljava/lang/Object;)V", "clearCachePool", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "createBinderRoot", "Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "Lcom/didi/soda/blocks/widget/Buildable;", "type", "", "getBinderRootType", "data", "(Ljava/lang/Object;)Ljava/lang/String;", "onRecycled", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RecyclerBinder.kt */
public abstract class RecyclerBinder<T> extends ItemBinder<T, RecyclerViewHolder<T>> {

    /* renamed from: a */
    private BinderRootConfig<T> f40562a;

    /* renamed from: b */
    private final BinderRecycler f40563b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RecyclerBinder(ItemDecorator itemDecorator) {
        this(itemDecorator, (BinderRootConfig) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(itemDecorator, "itemDecorator");
    }

    public abstract BinderRoot<? extends Buildable, T> createBinderRoot(String str);

    public abstract String getBinderRootType(T t);

    /* access modifiers changed from: protected */
    public final BinderRootConfig<T> getConfig() {
        return this.f40562a;
    }

    /* access modifiers changed from: protected */
    public final void setConfig(BinderRootConfig<T> binderRootConfig) {
        this.f40562a = binderRootConfig;
    }

    public RecyclerBinder() {
        this.f40563b = new BinderRecycler();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerBinder(ItemDecorator itemDecorator, BinderRootConfig<T> binderRootConfig) {
        super(itemDecorator);
        Intrinsics.checkNotNullParameter(itemDecorator, "itemDecorator");
        this.f40563b = new BinderRecycler();
        this.f40562a = binderRootConfig;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecyclerBinder(ItemDecorator itemDecorator, BinderRootConfig binderRootConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemDecorator, (i & 2) != 0 ? null : binderRootConfig);
    }

    public final void clearCachePool() {
        this.f40563b.clearCachePool();
    }

    public void onRecycled(RecyclerViewHolder<T> recyclerViewHolder) {
        super.onRecycled(recyclerViewHolder);
        this.f40563b.recycleBinderRoot(recyclerViewHolder);
    }

    public RecyclerViewHolder<T> create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        return new RecyclerViewHolder<>(frameLayout);
    }

    public void bind(RecyclerViewHolder<T> recyclerViewHolder, T t) {
        Intrinsics.checkNotNullParameter(recyclerViewHolder, "holder");
        Context context = recyclerViewHolder.itemView.getContext();
        String binderRootType = getBinderRootType(t);
        BinderRoot<?, ?> viewData = this.f40563b.getViewData(binderRootType);
        if (!(viewData instanceof BinderRoot)) {
            viewData = null;
        }
        boolean z = false;
        if (viewData == null) {
            viewData = createBinderRoot(binderRootType);
            Intrinsics.checkNotNullExpressionValue(context, "ctx");
            viewData.innerCreateView(context, t);
            z = true;
        }
        viewData.setAttached(true);
        recyclerViewHolder.addToItemView(viewData);
        if (!z) {
            viewData.internalBindView(t, recyclerViewHolder.getAdapterPosition());
        }
    }
}
