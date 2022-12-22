package com.didi.global.fintech.cashier.p117ui.viewholder.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierAllMethodItemViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "textTV", "Landroid/widget/TextView;", "bindData", "d", "initView", "layout", "", "viewType", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierAllMethodItemViewHolder */
/* compiled from: GlobalCashierAllMethodItemViewHolder.kt */
public final class GlobalCashierAllMethodItemViewHolder extends GlobalCashierBaseItemViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f21856a;

    public int layout() {
        return R.layout.view_all_payment_method_item;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierAllMethodItemViewHolder(Context context, ViewGroup viewGroup, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, (i & 4) != 0 ? null : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierAllMethodItemViewHolder(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        super(context, viewGroup, function1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierAllMethodItemViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierAllMethodItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierAllMethodItemViewHolder$Companion */
    /* compiled from: GlobalCashierAllMethodItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ GlobalCashierAllMethodItemViewHolder newInstance$default(Companion companion, Context context, ViewGroup viewGroup, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                function1 = null;
            }
            return companion.newInstance(context, viewGroup, function1);
        }

        public final GlobalCashierAllMethodItemViewHolder newInstance(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierAllMethodItemViewHolder(context, viewGroup, function1);
        }
    }

    public void initView() {
        super.initView();
        SystemUtils.log(4, "Arirus", "initView: ", (Throwable) null, "com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierAllMethodItemViewHolder", 30);
        View findViewById = getMRootView().findViewById(R.id.tv_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.tv_text)");
        this.f21856a = (TextView) findViewById;
    }

    public GlobalCashierBaseItemViewHolder.ViewType viewType() {
        return GlobalCashierBaseItemViewHolder.ViewType.AllMethod;
    }

    public void bindData(ChannelItemViewHolderData channelItemViewHolderData) {
        Intrinsics.checkNotNullParameter(channelItemViewHolderData, "d");
        super.bindData(channelItemViewHolderData);
        TextView textView = this.f21856a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textTV");
            textView = null;
        }
        Context context = getContext();
        Object[] objArr = new Object[1];
        String content = channelItemViewHolderData.getContent();
        if (content == null) {
            content = "";
        }
        objArr[0] = content;
        textView.setText(context.getString(R.string.Wallet_App_V2_All_payment_xiGu, objArr));
    }
}
