package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.animation.LayoutTransition;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCardChannelViewHolder;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
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

@Metadata(mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001f0#H\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\u001c\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010!2\b\u0010+\u001a\u0004\u0018\u00010!H\u0016J,\u0010,\u001a\u00020\u001f2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010.2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001f0#H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00060"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCardChannelViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "allMethodHolder", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierAllMethodItemViewHolder;", "containerView", "iconGroup", "Landroid/widget/ImageView;", "getIconGroup", "()Landroid/widget/ImageView;", "setIconGroup", "(Landroid/widget/ImageView;)V", "itemViewHolders", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder;", "getItemViewHolders", "()Ljava/util/List;", "setItemViewHolders", "(Ljava/util/List;)V", "nameGroup", "Landroid/widget/TextView;", "getNameGroup", "()Landroid/widget/TextView;", "setNameGroup", "(Landroid/widget/TextView;)V", "appendSpreadItem", "", "groupName", "", "click", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "initView", "layout", "", "removeSpreadItem", "updateHeader", "name", "icon", "updateItems", "items", "", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierCardChannelViewHolder */
/* compiled from: GlobalCashierCardChannelViewHolder.kt */
public final class GlobalCashierCardChannelViewHolder extends GlobalCashierBaseViewHolder implements IGlobalCashierCardChannelViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ViewGroup f21788a;

    /* renamed from: b */
    private GlobalCashierAllMethodItemViewHolder f21789b;

    /* renamed from: c */
    private List<GlobalCashierBaseItemViewHolder> f21790c = new ArrayList();
    public ImageView iconGroup;
    public TextView nameGroup;

    public int layout() {
        return R.layout.viewholder_global_cashier_card_channel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierCardChannelViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCardChannelViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCardChannelViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierCardChannelViewHolder$Companion */
    /* compiled from: GlobalCashierCardChannelViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierCardChannelViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierCardChannelViewHolder(context, viewGroup);
        }
    }

    public final ImageView getIconGroup() {
        ImageView imageView = this.iconGroup;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iconGroup");
        return null;
    }

    public final void setIconGroup(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.iconGroup = imageView;
    }

    public final TextView getNameGroup() {
        TextView textView = this.nameGroup;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nameGroup");
        return null;
    }

    public final void setNameGroup(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.nameGroup = textView;
    }

    public final List<GlobalCashierBaseItemViewHolder> getItemViewHolders() {
        return this.f21790c;
    }

    public final void setItemViewHolders(List<GlobalCashierBaseItemViewHolder> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f21790c = list;
    }

    public void initView() {
        super.initView();
        View findViewById = getMRootView().findViewById(R.id.card_channel_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R…d.card_channel_container)");
        this.f21788a = (ViewGroup) findViewById;
        View findViewById2 = getMRootView().findViewById(R.id.icon_group);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.icon_group)");
        setIconGroup((ImageView) findViewById2);
        View findViewById3 = getMRootView().findViewById(R.id.name_group);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.name_group)");
        setNameGroup((TextView) findViewById3);
        ViewGroup viewGroup = this.f21788a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            viewGroup = null;
        }
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(2, 1000);
        Unit unit = Unit.INSTANCE;
        viewGroup.setLayoutTransition(layoutTransition);
    }

    public void updateHeader(String str, String str2) {
        ViewKtxKt.content(getNameGroup(), str);
        ViewKtxKt.load(getIconGroup(), str2);
    }

    public void updateItems(List<ChannelItemViewHolderData> list, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        GlobalCashierBaseItemViewHolder globalCashierBaseItemViewHolder;
        ChannelItemViewHolderData channelItemViewHolderData;
        Intrinsics.checkNotNullParameter(function1, "click");
        Iterator it = this.f21790c.iterator();
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
        int size = this.f21790c.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                if (!this.f21790c.get(size).getAttached()) {
                    this.f21790c.remove(size);
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
                    ViewGroup viewGroup = this.f21788a;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        viewGroup = null;
                    }
                    globalCashierBaseItemViewHolder = globalCashierItemViewHolderFactory.newInstance(viewType2, context, viewGroup, function1);
                    GlobalCashierBaseViewHolder.attach$default(globalCashierBaseItemViewHolder, 0, 1, (Object) null);
                    getItemViewHolders().add(globalCashierBaseItemViewHolder);
                } else if (getItemViewHolders().get(i4).viewType() == channelItemViewHolderData2.getViewType()) {
                    globalCashierBaseItemViewHolder = getItemViewHolders().get(i4);
                } else {
                    getItemViewHolders().get(i4).detach();
                    GlobalCashierItemViewHolderFactory globalCashierItemViewHolderFactory2 = GlobalCashierItemViewHolderFactory.INSTANCE;
                    GlobalCashierBaseItemViewHolder.ViewType viewType3 = channelItemViewHolderData2.getViewType();
                    Context context2 = getContext();
                    ViewGroup viewGroup2 = this.f21788a;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        viewGroup2 = null;
                    }
                    GlobalCashierBaseItemViewHolder newInstance = globalCashierItemViewHolderFactory2.newInstance(viewType3, context2, viewGroup2, function1);
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
        GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder = this.f21789b;
        if (globalCashierAllMethodItemViewHolder == null) {
            GlobalCashierItemViewHolderFactory globalCashierItemViewHolderFactory = GlobalCashierItemViewHolderFactory.INSTANCE;
            GlobalCashierBaseItemViewHolder.ViewType viewType = GlobalCashierBaseItemViewHolder.ViewType.AllMethod;
            Context context = getContext();
            ViewGroup viewGroup = this.f21788a;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                viewGroup = null;
            }
            GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder2 = (GlobalCashierAllMethodItemViewHolder) globalCashierItemViewHolderFactory.newInstance(viewType, context, viewGroup, function1);
            this.f21789b = globalCashierAllMethodItemViewHolder2;
            if (globalCashierAllMethodItemViewHolder2 != null) {
                GlobalCashierBaseViewHolder.attach$default(globalCashierAllMethodItemViewHolder2, 0, 1, (Object) null);
            }
            GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder3 = this.f21789b;
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
        GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder4 = this.f21789b;
        if (globalCashierAllMethodItemViewHolder4 != null) {
            GlobalCashierBaseViewHolder.attach$default(globalCashierAllMethodItemViewHolder4, 0, 1, (Object) null);
        }
    }

    public void removeSpreadItem() {
        GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder = this.f21789b;
        if (globalCashierAllMethodItemViewHolder != null) {
            globalCashierAllMethodItemViewHolder.detach();
        }
        this.f21789b = null;
    }
}
