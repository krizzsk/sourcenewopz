package com.didi.global.fintech.cashier.p117ui.viewholder.item;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import com.didi.global.fintech.cashier.p117ui.widget.LabelsView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020\tH\u0016J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020;H\u0016R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u001a\u00102\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001c¨\u0006="}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierCardChannelItemViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "setArrow", "(Landroid/widget/ImageView;)V", "cb", "Landroid/widget/CheckBox;", "getCb", "()Landroid/widget/CheckBox;", "setCb", "(Landroid/widget/CheckBox;)V", "installmentLabelTV", "Landroid/widget/TextView;", "getInstallmentLabelTV", "()Landroid/widget/TextView;", "setInstallmentLabelTV", "(Landroid/widget/TextView;)V", "installmentRCV", "Landroidx/recyclerview/widget/RecyclerView;", "getInstallmentRCV", "()Landroidx/recyclerview/widget/RecyclerView;", "setInstallmentRCV", "(Landroidx/recyclerview/widget/RecyclerView;)V", "labelsView", "Lcom/didi/global/fintech/cashier/ui/widget/LabelsView;", "getLabelsView", "()Lcom/didi/global/fintech/cashier/ui/widget/LabelsView;", "setLabelsView", "(Lcom/didi/global/fintech/cashier/ui/widget/LabelsView;)V", "plansInfoLayout", "Landroid/widget/LinearLayout;", "getPlansInfoLayout", "()Landroid/widget/LinearLayout;", "setPlansInfoLayout", "(Landroid/widget/LinearLayout;)V", "tvChannelName", "getTvChannelName", "setTvChannelName", "tvChannelSubName", "getTvChannelSubName", "setTvChannelSubName", "bindData", "d", "initView", "layout", "", "viewType", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierCardChannelItemViewHolder */
/* compiled from: GlobalCashierCardChannelItemViewHolder.kt */
public final class GlobalCashierCardChannelItemViewHolder extends GlobalCashierBaseItemViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public ImageView arrow;

    /* renamed from: cb */
    public CheckBox f21862cb;
    public TextView installmentLabelTV;
    public RecyclerView installmentRCV;
    public LabelsView labelsView;
    public LinearLayout plansInfoLayout;
    public TextView tvChannelName;
    public TextView tvChannelSubName;

    public int layout() {
        return R.layout.viewholder_global_cashier_card_channel_item;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierCardChannelItemViewHolder(Context context, ViewGroup viewGroup, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, (i & 4) != 0 ? null : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierCardChannelItemViewHolder(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        super(context, viewGroup, function1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierCardChannelItemViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierCardChannelItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierCardChannelItemViewHolder$Companion */
    /* compiled from: GlobalCashierCardChannelItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierCardChannelItemViewHolder newInstance(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierCardChannelItemViewHolder(context, viewGroup, function1);
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
        CheckBox checkBox = this.f21862cb;
        if (checkBox != null) {
            return checkBox;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cb");
        return null;
    }

    public final void setCb(CheckBox checkBox) {
        Intrinsics.checkNotNullParameter(checkBox, "<set-?>");
        this.f21862cb = checkBox;
    }

    public final ImageView getArrow() {
        ImageView imageView = this.arrow;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("arrow");
        return null;
    }

    public final void setArrow(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.arrow = imageView;
    }

    public final TextView getInstallmentLabelTV() {
        TextView textView = this.installmentLabelTV;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("installmentLabelTV");
        return null;
    }

    public final void setInstallmentLabelTV(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.installmentLabelTV = textView;
    }

    public final RecyclerView getInstallmentRCV() {
        RecyclerView recyclerView = this.installmentRCV;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("installmentRCV");
        return null;
    }

    public final void setInstallmentRCV(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.installmentRCV = recyclerView;
    }

    public final LinearLayout getPlansInfoLayout() {
        LinearLayout linearLayout = this.plansInfoLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("plansInfoLayout");
        return null;
    }

    public final void setPlansInfoLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.plansInfoLayout = linearLayout;
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
        setArrow((ImageView) getView(R.id.iv_arrow_icon));
        setInstallmentLabelTV((TextView) getView(R.id.tv_name_label));
        setInstallmentRCV((RecyclerView) getView(R.id.installment_rcv));
        setPlansInfoLayout((LinearLayout) getView(R.id.installment_plan_layout));
    }

    public GlobalCashierBaseItemViewHolder.ViewType viewType() {
        return GlobalCashierBaseItemViewHolder.ViewType.Card;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.didi.global.fintech.cashier.ui.viewholder.item.InstallmentVo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.didi.global.fintech.cashier.ui.viewholder.item.InstallmentVo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: com.didi.global.fintech.cashier.ui.viewholder.item.InstallmentVo} */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0143, code lost:
        if ((r5 == null || r5.isEmpty()) == false) goto L_0x0147;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindData(com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData r11) {
        /*
            r10 = this;
            java.lang.String r0 = "d"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            super.bindData(r11)
            android.widget.TextView r0 = r10.getTvChannelName()
            java.lang.String r1 = r11.getContent()
            com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt.content(r0, r1)
            android.widget.TextView r0 = r10.getTvChannelSubName()
            java.lang.String r1 = r11.getSubContent()
            com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt.content(r0, r1)
            android.widget.CheckBox r0 = r10.getCb()
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation r1 = r11.getOperatorType()
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation r2 = com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData.Operation.OPERATION_CHECK
            r3 = 8
            r4 = 0
            if (r1 != r2) goto L_0x002f
            r1 = 0
            goto L_0x0031
        L_0x002f:
            r1 = 8
        L_0x0031:
            r0.setVisibility(r1)
            android.widget.ImageView r0 = r10.getArrow()
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation r1 = r11.getOperatorType()
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation r2 = com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData.Operation.OPERATION_ARROW
            if (r1 != r2) goto L_0x0042
            r1 = 0
            goto L_0x0044
        L_0x0042:
            r1 = 8
        L_0x0044:
            r0.setVisibility(r1)
            java.util.List r0 = r11.getTags()
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            r5 = 0
            if (r1 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r0 = r5
        L_0x0059:
            if (r0 != 0) goto L_0x005d
            r0 = r5
            goto L_0x0074
        L_0x005d:
            com.didi.global.fintech.cashier.ui.widget.LabelsView r1 = r10.getLabelsView()
            r1.setVisibility(r4)
            com.didi.global.fintech.cashier.ui.widget.LabelsView r1 = r10.getLabelsView()
            java.util.List r6 = r11.getTags()
            com.didi.global.fintech.cashier.ui.viewholder.item.-$$Lambda$GlobalCashierCardChannelItemViewHolder$vv-mPxs2HeOuJhcefE79AALh144 r7 = new com.didi.global.fintech.cashier.ui.viewholder.item.-$$Lambda$GlobalCashierCardChannelItemViewHolder$vv-mPxs2HeOuJhcefE79AALh144
            r7.<init>()
            r1.setLabels(r6, r7)
        L_0x0074:
            if (r0 != 0) goto L_0x0080
            r0 = r10
            com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierCardChannelItemViewHolder r0 = (com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierCardChannelItemViewHolder) r0
            com.didi.global.fintech.cashier.ui.widget.LabelsView r0 = r0.getLabelsView()
            r0.setVisibility(r3)
        L_0x0080:
            android.widget.CheckBox r0 = r10.getCb()
            boolean r1 = r11.checked()
            r0.setChecked(r1)
            com.didi.global.fintech.cashier.ui.viewholder.item.InstallmentVo r0 = r11.getInstallment()
            if (r0 == 0) goto L_0x0093
            r1 = 1
            goto L_0x0094
        L_0x0093:
            r1 = 0
        L_0x0094:
            if (r1 == 0) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r0 = r5
        L_0x0098:
            if (r0 != 0) goto L_0x009c
            goto L_0x0166
        L_0x009c:
            android.widget.TextView r1 = r10.getInstallmentLabelTV()
            android.view.View r1 = (android.view.View) r1
            boolean r6 = r0.isSupport()
            if (r6 == 0) goto L_0x00aa
            r6 = 0
            goto L_0x00ac
        L_0x00aa:
            r6 = 8
        L_0x00ac:
            r1.setVisibility(r6)
            android.widget.TextView r1 = r10.getInstallmentLabelTV()
            java.lang.String r6 = r0.getTitle()
            com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt.content(r1, r6)
            androidx.recyclerview.widget.RecyclerView r1 = r10.getInstallmentRCV()
            android.view.View r1 = (android.view.View) r1
            boolean r6 = r0.isSupport()
            if (r6 == 0) goto L_0x00dc
            java.util.List r6 = r0.getSuggestPlans()
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x00d7
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00d5
            goto L_0x00d7
        L_0x00d5:
            r6 = 0
            goto L_0x00d8
        L_0x00d7:
            r6 = 1
        L_0x00d8:
            if (r6 != 0) goto L_0x00dc
            r6 = 1
            goto L_0x00dd
        L_0x00dc:
            r6 = 0
        L_0x00dd:
            if (r6 == 0) goto L_0x00e1
            r6 = 0
            goto L_0x00e3
        L_0x00e1:
            r6 = 8
        L_0x00e3:
            r1.setVisibility(r6)
            com.didi.global.fintech.cashier.ui.viewholder.adapter.InstallmentAdapter r1 = new com.didi.global.fintech.cashier.ui.viewholder.adapter.InstallmentAdapter
            com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierCardChannelItemViewHolder$bindData$5$adapter$1 r6 = new com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierCardChannelItemViewHolder$bindData$5$adapter$1
            r6.<init>(r11)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r1.<init>(r6)
            java.util.List r6 = r0.getSuggestPlans()
            if (r6 != 0) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.List r5 = kotlin.collections.CollectionsKt.toMutableList(r6)
        L_0x00ff:
            r1.updateData(r5)
            androidx.recyclerview.widget.RecyclerView r5 = r10.getInstallmentRCV()
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = (androidx.recyclerview.widget.RecyclerView.Adapter) r1
            r5.setAdapter(r1)
            androidx.recyclerview.widget.RecyclerView r1 = r10.getInstallmentRCV()
            int r1 = r1.getItemDecorationCount()
            if (r1 != 0) goto L_0x0125
            androidx.recyclerview.widget.RecyclerView r1 = r10.getInstallmentRCV()
            com.didi.global.fintech.cashier.ui.viewholder.divider.GridGapDecoration r5 = new com.didi.global.fintech.cashier.ui.viewholder.divider.GridGapDecoration
            r6 = 20
            r5.<init>(r6, r6)
            androidx.recyclerview.widget.RecyclerView$ItemDecoration r5 = (androidx.recyclerview.widget.RecyclerView.ItemDecoration) r5
            r1.addItemDecoration(r5)
        L_0x0125:
            android.widget.LinearLayout r1 = r10.getPlansInfoLayout()
            android.view.View r1 = (android.view.View) r1
            boolean r5 = r0.isSupport()
            if (r5 == 0) goto L_0x0146
            java.util.List r5 = r0.getSuggestPlans()
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x0142
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0140
            goto L_0x0142
        L_0x0140:
            r5 = 0
            goto L_0x0143
        L_0x0142:
            r5 = 1
        L_0x0143:
            if (r5 != 0) goto L_0x0146
            goto L_0x0147
        L_0x0146:
            r2 = 0
        L_0x0147:
            if (r2 == 0) goto L_0x014a
            goto L_0x014c
        L_0x014a:
            r4 = 8
        L_0x014c:
            r1.setVisibility(r4)
            android.widget.LinearLayout r1 = r10.getPlansInfoLayout()
            r4 = r1
            android.view.View r4 = (android.view.View) r4
            r5 = 0
            com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierCardChannelItemViewHolder$bindData$5$1 r1 = new com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierCardChannelItemViewHolder$bindData$5$1
            r1.<init>(r11, r0)
            r7 = r1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8 = 1
            r9 = 0
            com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt.click$default(r4, r5, r7, r8, r9)
            r5 = r0
        L_0x0166:
            if (r5 != 0) goto L_0x0186
            r11 = r10
            com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierCardChannelItemViewHolder r11 = (com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierCardChannelItemViewHolder) r11
            android.widget.TextView r0 = r11.getInstallmentLabelTV()
            android.view.View r0 = (android.view.View) r0
            r0.setVisibility(r3)
            androidx.recyclerview.widget.RecyclerView r0 = r11.getInstallmentRCV()
            android.view.View r0 = (android.view.View) r0
            r0.setVisibility(r3)
            android.widget.LinearLayout r11 = r11.getPlansInfoLayout()
            android.view.View r11 = (android.view.View) r11
            r11.setVisibility(r3)
        L_0x0186:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierCardChannelItemViewHolder.bindData(com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final CharSequence m15839a(GlobalCashierCardChannelItemViewHolder globalCashierCardChannelItemViewHolder, TextView textView, int i, PaymentLabel paymentLabel) {
        String str;
        Intrinsics.checkNotNullParameter(globalCashierCardChannelItemViewHolder, "this$0");
        if (textView != null && Intrinsics.areEqual((Object) paymentLabel.getType(), (Object) TagType.TYPE_WARNING.getType())) {
            textView.setBackground(ContextCompat.getDrawable(globalCashierCardChannelItemViewHolder.getContext(), R.drawable.shape_label_warning_bg));
            textView.setTextColor(ContextCompat.getColor(globalCashierCardChannelItemViewHolder.getContext(), R.color.white));
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
