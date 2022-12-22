package com.didi.global.fintech.cashier.p117ui.viewholder.item;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006%"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierThirdChannelItemViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "cb", "Landroid/widget/CheckBox;", "getCb", "()Landroid/widget/CheckBox;", "setCb", "(Landroid/widget/CheckBox;)V", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "setIvIcon", "(Landroid/widget/ImageView;)V", "tvChannelName", "Landroid/widget/TextView;", "getTvChannelName", "()Landroid/widget/TextView;", "setTvChannelName", "(Landroid/widget/TextView;)V", "bindData", "d", "initView", "layout", "", "viewType", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierThirdChannelItemViewHolder */
/* compiled from: GlobalCashierThirdChannelItemViewHolder.kt */
public final class GlobalCashierThirdChannelItemViewHolder extends GlobalCashierBaseItemViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: cb */
    public CheckBox f21873cb;
    public ImageView ivIcon;
    public TextView tvChannelName;

    public int layout() {
        return R.layout.viewholder_global_cashier_third_channel_item;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierThirdChannelItemViewHolder(Context context, ViewGroup viewGroup, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, (i & 4) != 0 ? null : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierThirdChannelItemViewHolder(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        super(context, viewGroup, function1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierThirdChannelItemViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierThirdChannelItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierThirdChannelItemViewHolder$Companion */
    /* compiled from: GlobalCashierThirdChannelItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ GlobalCashierThirdChannelItemViewHolder newInstance$default(Companion companion, Context context, ViewGroup viewGroup, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                function1 = null;
            }
            return companion.newInstance(context, viewGroup, function1);
        }

        public final GlobalCashierThirdChannelItemViewHolder newInstance(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierThirdChannelItemViewHolder(context, viewGroup, function1);
        }
    }

    public final TextView getTvChannelName() {
        TextView textView = this.tvChannelName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvChannelName");
        return null;
    }

    public final void setTvChannelName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvChannelName = textView;
    }

    public final ImageView getIvIcon() {
        ImageView imageView = this.ivIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        return null;
    }

    public final void setIvIcon(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivIcon = imageView;
    }

    public final CheckBox getCb() {
        CheckBox checkBox = this.f21873cb;
        if (checkBox != null) {
            return checkBox;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cb");
        return null;
    }

    public final void setCb(CheckBox checkBox) {
        Intrinsics.checkNotNullParameter(checkBox, "<set-?>");
        this.f21873cb = checkBox;
    }

    public void initView() {
        super.initView();
        setTvChannelName((TextView) getView(R.id.iv_name));
        addColorChangeView(getTvChannelName());
        setIvIcon((ImageView) getView(R.id.iv_icon));
        setCb((CheckBox) getView(R.id.cb_status));
        addColorChangeView(getCb());
    }

    public GlobalCashierBaseItemViewHolder.ViewType viewType() {
        return GlobalCashierBaseItemViewHolder.ViewType.Third;
    }

    public void bindData(ChannelItemViewHolderData channelItemViewHolderData) {
        Intrinsics.checkNotNullParameter(channelItemViewHolderData, "d");
        super.bindData(channelItemViewHolderData);
        ViewKtxKt.content(getTvChannelName(), channelItemViewHolderData.getContent());
        ViewKtxKt.load(getIvIcon(), channelItemViewHolderData.getIcon());
        getCb().setChecked(channelItemViewHolderData.checked());
    }
}
