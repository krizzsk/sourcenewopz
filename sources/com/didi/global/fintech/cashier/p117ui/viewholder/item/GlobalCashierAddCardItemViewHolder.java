package com.didi.global.fintech.cashier.p117ui.viewholder.item;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import com.didi.global.fintech.cashier.p117ui.widget.LabelsView;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierAddCardItemViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "ivArrow", "Landroid/widget/ImageView;", "labelsView", "Lcom/didi/global/fintech/cashier/ui/widget/LabelsView;", "tvName", "Landroid/widget/TextView;", "bindData", "d", "initView", "layout", "", "viewType", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierAddCardItemViewHolder */
/* compiled from: GlobalCashierAddCardItemViewHolder.kt */
public final class GlobalCashierAddCardItemViewHolder extends GlobalCashierBaseItemViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private LabelsView f21853a;

    /* renamed from: b */
    private TextView f21854b;

    /* renamed from: c */
    private ImageView f21855c;

    public int layout() {
        return R.layout.viewholder_global_cashier_add_card_item;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierAddCardItemViewHolder(Context context, ViewGroup viewGroup, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, (i & 4) != 0 ? null : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierAddCardItemViewHolder(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        super(context, viewGroup, function1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierAddCardItemViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierAddCardItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierAddCardItemViewHolder$Companion */
    /* compiled from: GlobalCashierAddCardItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ GlobalCashierAddCardItemViewHolder newInstance$default(Companion companion, Context context, ViewGroup viewGroup, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                function1 = null;
            }
            return companion.newInstance(context, viewGroup, function1);
        }

        public final GlobalCashierAddCardItemViewHolder newInstance(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierAddCardItemViewHolder(context, viewGroup, function1);
        }
    }

    public void initView() {
        super.initView();
        this.f21853a = (LabelsView) getView(R.id.label_rcv);
        this.f21854b = (TextView) getView(R.id.tv_name);
        this.f21855c = (ImageView) getView(R.id.iv_arrow_icon);
        TextView textView = this.f21854b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvName");
            textView = null;
        }
        addColorChangeView(textView);
    }

    public GlobalCashierBaseItemViewHolder.ViewType viewType() {
        return GlobalCashierBaseItemViewHolder.ViewType.AddCard;
    }

    public void bindData(ChannelItemViewHolderData channelItemViewHolderData) {
        Intrinsics.checkNotNullParameter(channelItemViewHolderData, "d");
        super.bindData(channelItemViewHolderData);
        List<PaymentLabel> tags = channelItemViewHolderData.getTags();
        TextView textView = null;
        if (!(!tags.isEmpty())) {
            tags = null;
        }
        if (tags == null) {
            tags = null;
        } else {
            LabelsView labelsView = this.f21853a;
            if (labelsView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelsView");
                labelsView = null;
            }
            labelsView.setVisibility(0);
            LabelsView labelsView2 = this.f21853a;
            if (labelsView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelsView");
                labelsView2 = null;
            }
            labelsView2.setLabels(channelItemViewHolderData.getTags(), new LabelsView.LabelTextProvider() {
                public final CharSequence getLabelText(TextView textView, int i, Object obj) {
                    return GlobalCashierAddCardItemViewHolder.m15836a(GlobalCashierAddCardItemViewHolder.this, textView, i, (PaymentLabel) obj);
                }
            });
        }
        if (tags == null) {
            LabelsView labelsView3 = this.f21853a;
            if (labelsView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelsView");
                labelsView3 = null;
            }
            labelsView3.setVisibility(8);
        }
        TextView textView2 = this.f21854b;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvName");
        } else {
            textView = textView2;
        }
        ViewKtxKt.content(textView, channelItemViewHolderData.getContent());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final CharSequence m15836a(GlobalCashierAddCardItemViewHolder globalCashierAddCardItemViewHolder, TextView textView, int i, PaymentLabel paymentLabel) {
        String str;
        Intrinsics.checkNotNullParameter(globalCashierAddCardItemViewHolder, "this$0");
        if (textView != null && Intrinsics.areEqual((Object) paymentLabel.getType(), (Object) TagType.TYPE_WARNING.getType())) {
            textView.setBackground(ContextCompat.getDrawable(globalCashierAddCardItemViewHolder.getContext(), R.drawable.shape_label_warning_bg));
            textView.setTextColor(ContextCompat.getColor(globalCashierAddCardItemViewHolder.getContext(), R.color.white));
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
