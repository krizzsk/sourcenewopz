package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierThirdChannelViewHolder;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierAllMethodItemViewHolder;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierItemViewHolderFactory;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J,\u0010\u001e\u001a\u00020\u00142\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010 2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0018H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\""}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierThirdChannelViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierThirdChannelViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "allMethodHolder", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierAllMethodItemViewHolder;", "containerView", "Landroidx/appcompat/widget/LinearLayoutCompat;", "itemViewHolders", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder;", "getItemViewHolders", "()Ljava/util/List;", "setItemViewHolders", "(Ljava/util/List;)V", "appendSpreadItem", "", "groupName", "", "click", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "initView", "layout", "", "removeSpreadItem", "updateItems", "items", "", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierThirdChannelViewHolder */
/* compiled from: GlobalCashierThirdChannelViewHolder.kt */
public final class GlobalCashierThirdChannelViewHolder extends GlobalCashierBaseViewHolder implements IGlobalCashierThirdChannelViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private LinearLayoutCompat f21809a;

    /* renamed from: b */
    private GlobalCashierAllMethodItemViewHolder f21810b;

    /* renamed from: c */
    private List<GlobalCashierBaseItemViewHolder> f21811c = new ArrayList();

    public int layout() {
        return R.layout.viewholder_global_cashier_third_channel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierThirdChannelViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierThirdChannelViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierThirdChannelViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierThirdChannelViewHolder$Companion */
    /* compiled from: GlobalCashierThirdChannelViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierThirdChannelViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierThirdChannelViewHolder(context, viewGroup);
        }
    }

    public void initView() {
        super.initView();
        View findViewById = getMRootView().findViewById(R.id.third_channel_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.third_channel_layout)");
        this.f21809a = (LinearLayoutCompat) findViewById;
    }

    public final List<GlobalCashierBaseItemViewHolder> getItemViewHolders() {
        return this.f21811c;
    }

    public final void setItemViewHolders(List<GlobalCashierBaseItemViewHolder> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f21811c = list;
    }

    public void updateItems(List<ChannelItemViewHolderData> list, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        GlobalCashierBaseItemViewHolder globalCashierBaseItemViewHolder;
        ChannelItemViewHolderData channelItemViewHolderData;
        Intrinsics.checkNotNullParameter(function1, "click");
        Iterator it = this.f21811c.iterator();
        int i = 0;
        while (true) {
            GlobalCashierBaseItemViewHolder.ViewType viewType = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GlobalCashierBaseItemViewHolder globalCashierBaseItemViewHolder2 = (GlobalCashierBaseItemViewHolder) next;
            if (i < (list == null ? 0 : list.size())) {
                if (!(list == null || (channelItemViewHolderData = list.get(i)) == null)) {
                    viewType = channelItemViewHolderData.getViewType();
                }
                if (viewType == globalCashierBaseItemViewHolder2.viewType()) {
                    i = i2;
                }
            }
            globalCashierBaseItemViewHolder2.detach();
            i = i2;
        }
        int size = this.f21811c.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                if (!this.f21811c.get(size).getAttached()) {
                    this.f21811c.remove(size);
                }
                if (i3 < 0) {
                    break;
                }
                size = i3;
            }
        }
        if (list != null) {
            int i4 = 0;
            for (Object next2 : list) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ChannelItemViewHolderData channelItemViewHolderData2 = (ChannelItemViewHolderData) next2;
                if (getItemViewHolders().size() <= i4) {
                    GlobalCashierItemViewHolderFactory globalCashierItemViewHolderFactory = GlobalCashierItemViewHolderFactory.INSTANCE;
                    GlobalCashierBaseItemViewHolder.ViewType viewType2 = channelItemViewHolderData2.getViewType();
                    Context context = getContext();
                    LinearLayoutCompat linearLayoutCompat = this.f21809a;
                    if (linearLayoutCompat == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        linearLayoutCompat = null;
                    }
                    globalCashierBaseItemViewHolder = globalCashierItemViewHolderFactory.newInstance(viewType2, context, linearLayoutCompat, function1);
                    GlobalCashierBaseViewHolder.attach$default(globalCashierBaseItemViewHolder, 0, 1, (Object) null);
                    getItemViewHolders().add(globalCashierBaseItemViewHolder);
                } else if (getItemViewHolders().get(i4).viewType() == channelItemViewHolderData2.getViewType()) {
                    globalCashierBaseItemViewHolder = getItemViewHolders().get(i4);
                } else {
                    getItemViewHolders().get(i4).detach();
                    GlobalCashierItemViewHolderFactory globalCashierItemViewHolderFactory2 = GlobalCashierItemViewHolderFactory.INSTANCE;
                    GlobalCashierBaseItemViewHolder.ViewType viewType3 = channelItemViewHolderData2.getViewType();
                    Context context2 = getContext();
                    LinearLayoutCompat linearLayoutCompat2 = this.f21809a;
                    if (linearLayoutCompat2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        linearLayoutCompat2 = null;
                    }
                    GlobalCashierBaseItemViewHolder newInstance = globalCashierItemViewHolderFactory2.newInstance(viewType3, context2, linearLayoutCompat2, function1);
                    newInstance.attach(i4);
                    getItemViewHolders().set(i4, newInstance);
                    globalCashierBaseItemViewHolder = newInstance;
                }
                globalCashierBaseItemViewHolder.bindData(channelItemViewHolderData2);
                i4 = i5;
            }
        }
    }

    public void appendSpreadItem(String str, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "click");
        GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder = this.f21810b;
        if (globalCashierAllMethodItemViewHolder == null) {
            GlobalCashierItemViewHolderFactory globalCashierItemViewHolderFactory = GlobalCashierItemViewHolderFactory.INSTANCE;
            GlobalCashierBaseItemViewHolder.ViewType viewType = GlobalCashierBaseItemViewHolder.ViewType.AllMethod;
            Context context = getContext();
            LinearLayoutCompat linearLayoutCompat = this.f21809a;
            if (linearLayoutCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                linearLayoutCompat = null;
            }
            GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder2 = (GlobalCashierAllMethodItemViewHolder) globalCashierItemViewHolderFactory.newInstance(viewType, context, linearLayoutCompat, function1);
            this.f21810b = globalCashierAllMethodItemViewHolder2;
            if (globalCashierAllMethodItemViewHolder2 != null) {
                GlobalCashierBaseViewHolder.attach$default(globalCashierAllMethodItemViewHolder2, 0, 1, (Object) null);
            }
            GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder3 = this.f21810b;
            if (globalCashierAllMethodItemViewHolder3 != null) {
                ChannelItemViewHolderData all_method = ChannelItemViewHolderData.Companion.getALL_METHOD();
                all_method.setContent(str);
                Unit unit = Unit.INSTANCE;
                globalCashierAllMethodItemViewHolder3.bindData(all_method);
                return;
            }
            return;
        }
        if (globalCashierAllMethodItemViewHolder != null) {
            globalCashierAllMethodItemViewHolder.detach();
        }
        GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder4 = this.f21810b;
        if (globalCashierAllMethodItemViewHolder4 != null) {
            GlobalCashierBaseViewHolder.attach$default(globalCashierAllMethodItemViewHolder4, 0, 1, (Object) null);
        }
    }

    public void removeSpreadItem() {
        GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder = this.f21810b;
        if (globalCashierAllMethodItemViewHolder != null) {
            globalCashierAllMethodItemViewHolder.detach();
        }
        this.f21810b = null;
    }
}
