package com.didi.global.fintech.cashier.p117ui.viewholder.item;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import com.didi.global.fintech.cashier.p117ui.widget.LabelsView;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"¨\u00061"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBalanceItemViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "cb", "Landroid/widget/CheckBox;", "getCb", "()Landroid/widget/CheckBox;", "setCb", "(Landroid/widget/CheckBox;)V", "labelsView", "Lcom/didi/global/fintech/cashier/ui/widget/LabelsView;", "getLabelsView", "()Lcom/didi/global/fintech/cashier/ui/widget/LabelsView;", "setLabelsView", "(Lcom/didi/global/fintech/cashier/ui/widget/LabelsView;)V", "switcher", "Landroidx/appcompat/widget/SwitchCompat;", "getSwitcher", "()Landroidx/appcompat/widget/SwitchCompat;", "setSwitcher", "(Landroidx/appcompat/widget/SwitchCompat;)V", "tvChannelName", "Landroid/widget/TextView;", "getTvChannelName", "()Landroid/widget/TextView;", "setTvChannelName", "(Landroid/widget/TextView;)V", "tvChannelSubName", "getTvChannelSubName", "setTvChannelSubName", "tvTopUp", "getTvTopUp", "setTvTopUp", "bindData", "d", "initView", "layout", "", "viewType", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierBalanceItemViewHolder */
/* compiled from: GlobalCashierBalanceItemViewHolder.kt */
public final class GlobalCashierBalanceItemViewHolder extends GlobalCashierBaseItemViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: cb */
    public CheckBox f21857cb;
    public LabelsView labelsView;
    public SwitchCompat switcher;
    public TextView tvChannelName;
    public TextView tvChannelSubName;
    public TextView tvTopUp;

    public int layout() {
        return R.layout.viewholder_global_cashier_balance_channel_item;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierBalanceItemViewHolder(Context context, ViewGroup viewGroup, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, (i & 4) != 0 ? null : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierBalanceItemViewHolder(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        super(context, viewGroup, function1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBalanceItemViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBalanceItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierBalanceItemViewHolder$Companion */
    /* compiled from: GlobalCashierBalanceItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierBalanceItemViewHolder newInstance(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierBalanceItemViewHolder(context, viewGroup, function1);
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

    public final TextView getTvChannelSubName() {
        TextView textView = this.tvChannelSubName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvChannelSubName");
        return null;
    }

    public final void setTvChannelSubName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvChannelSubName = textView;
    }

    public final LabelsView getLabelsView() {
        LabelsView labelsView2 = this.labelsView;
        if (labelsView2 != null) {
            return labelsView2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("labelsView");
        return null;
    }

    public final void setLabelsView(LabelsView labelsView2) {
        Intrinsics.checkNotNullParameter(labelsView2, "<set-?>");
        this.labelsView = labelsView2;
    }

    public final CheckBox getCb() {
        CheckBox checkBox = this.f21857cb;
        if (checkBox != null) {
            return checkBox;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cb");
        return null;
    }

    public final void setCb(CheckBox checkBox) {
        Intrinsics.checkNotNullParameter(checkBox, "<set-?>");
        this.f21857cb = checkBox;
    }

    public final SwitchCompat getSwitcher() {
        SwitchCompat switchCompat = this.switcher;
        if (switchCompat != null) {
            return switchCompat;
        }
        Intrinsics.throwUninitializedPropertyAccessException("switcher");
        return null;
    }

    public final void setSwitcher(SwitchCompat switchCompat) {
        Intrinsics.checkNotNullParameter(switchCompat, "<set-?>");
        this.switcher = switchCompat;
    }

    public final TextView getTvTopUp() {
        TextView textView = this.tvTopUp;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTopUp");
        return null;
    }

    public final void setTvTopUp(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTopUp = textView;
    }

    public void initView() {
        super.initView();
        setTvChannelName((TextView) getView(R.id.tv_channel_name));
        addColorChangeView(getTvChannelName());
        setLabelsView((LabelsView) getView(R.id.channel_label_view));
        setTvChannelSubName((TextView) getView(R.id.tv_sub_head_display));
        addColorChangeView(getTvChannelSubName());
        setCb((CheckBox) getView(R.id.cb_status));
        addColorChangeView(getCb());
        setSwitcher((SwitchCompat) getView(R.id.balance_switch));
        setTvTopUp((TextView) getView(R.id.btn_top_up));
    }

    public GlobalCashierBaseItemViewHolder.ViewType viewType() {
        return GlobalCashierBaseItemViewHolder.ViewType.Balance;
    }

    public void bindData(ChannelItemViewHolderData channelItemViewHolderData) {
        Intrinsics.checkNotNullParameter(channelItemViewHolderData, "d");
        super.bindData(channelItemViewHolderData);
        ViewKtxKt.content(getTvChannelName(), channelItemViewHolderData.getContent());
        ViewKtxKt.content(getTvChannelSubName(), channelItemViewHolderData.getSubContent());
        getCb().setVisibility(channelItemViewHolderData.getOperatorType() == ChannelItemViewHolderData.Operation.OPERATION_CHECK ? 0 : 8);
        getSwitcher().setVisibility(channelItemViewHolderData.getOperatorType() == ChannelItemViewHolderData.Operation.OPERATION_SWITCH ? 0 : 8);
        getTvTopUp().setVisibility(channelItemViewHolderData.getOperatorType() == ChannelItemViewHolderData.Operation.OPERATION_TOP_UP ? 0 : 8);
        List<PaymentLabel> tags = channelItemViewHolderData.getTags();
        List<PaymentLabel> list = null;
        if (!(!tags.isEmpty())) {
            tags = null;
        }
        if (tags != null) {
            getLabelsView().setVisibility(0);
            getLabelsView().setLabels(channelItemViewHolderData.getTags(), new LabelsView.LabelTextProvider() {
                public final CharSequence getLabelText(TextView textView, int i, Object obj) {
                    return GlobalCashierBalanceItemViewHolder.m15837a(GlobalCashierBalanceItemViewHolder.this, textView, i, (PaymentLabel) obj);
                }
            });
            list = tags;
        }
        if (list == null) {
            getLabelsView().setVisibility(8);
        }
        getCb().setChecked(channelItemViewHolderData.checked());
        getSwitcher().setChecked(channelItemViewHolderData.checked());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final CharSequence m15837a(GlobalCashierBalanceItemViewHolder globalCashierBalanceItemViewHolder, TextView textView, int i, PaymentLabel paymentLabel) {
        String str;
        Intrinsics.checkNotNullParameter(globalCashierBalanceItemViewHolder, "this$0");
        if (textView != null && Intrinsics.areEqual((Object) paymentLabel.getType(), (Object) TagType.TYPE_WARNING.getType())) {
            textView.setBackground(ContextCompat.getDrawable(globalCashierBalanceItemViewHolder.getContext(), R.drawable.shape_label_warning_bg));
            textView.setTextColor(ContextCompat.getColor(globalCashierBalanceItemViewHolder.getContext(), R.color.white));
        }
        if (paymentLabel == null) {
            str = null;
        } else {
            str = paymentLabel.getMessage();
        }
        if (str == null) {
            str = "";
        }
        return str;
    }
}
