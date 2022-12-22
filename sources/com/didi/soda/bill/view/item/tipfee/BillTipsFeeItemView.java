package com.didi.soda.bill.view.item.tipfee;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.PriceInfoModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewTipsFeeLogic;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.home.topgun.widget.HorizontalRecyclerView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u0006+"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/tipfee/BillTipsFeeItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewTipsFeeLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mAdapter", "Lcom/didi/soda/bill/view/item/tipfee/BillTipsFeeListItemAdapter;", "mContentTv", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "getMContentTv", "()Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "setMContentTv", "(Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;)V", "mTipFeeListRv", "Lcom/didi/soda/home/topgun/widget/HorizontalRecyclerView;", "getMTipFeeListRv", "()Lcom/didi/soda/home/topgun/widget/HorizontalRecyclerView;", "setMTipFeeListRv", "(Lcom/didi/soda/home/topgun/widget/HorizontalRecyclerView;)V", "mTipIcon", "Lcom/didi/rfusion/widget/RFIconView;", "getMTipIcon", "()Lcom/didi/rfusion/widget/RFIconView;", "setMTipIcon", "(Lcom/didi/rfusion/widget/RFIconView;)V", "mTitle", "getMTitle", "setMTitle", "initView", "", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "TipsFeeItemDecorator", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTipsFeeItemView.kt */
public class BillTipsFeeItemView extends BillItemView<ItemViewTipsFeeLogic> {

    /* renamed from: a */
    private BillTipsFeeListItemAdapter f39252a;
    public CustomerAppCompatTextView mContentTv;
    public HorizontalRecyclerView mTipFeeListRv;
    public RFIconView mTipIcon;
    public CustomerAppCompatTextView mTitle;

    public void _$_clearFindViewByIdCache() {
    }

    public final CustomerAppCompatTextView getMTitle() {
        CustomerAppCompatTextView customerAppCompatTextView = this.mTitle;
        if (customerAppCompatTextView != null) {
            return customerAppCompatTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
        return null;
    }

    public final void setMTitle(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.mTitle = customerAppCompatTextView;
    }

    public final RFIconView getMTipIcon() {
        RFIconView rFIconView = this.mTipIcon;
        if (rFIconView != null) {
            return rFIconView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTipIcon");
        return null;
    }

    public final void setMTipIcon(RFIconView rFIconView) {
        Intrinsics.checkNotNullParameter(rFIconView, "<set-?>");
        this.mTipIcon = rFIconView;
    }

    public final CustomerAppCompatTextView getMContentTv() {
        CustomerAppCompatTextView customerAppCompatTextView = this.mContentTv;
        if (customerAppCompatTextView != null) {
            return customerAppCompatTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContentTv");
        return null;
    }

    public final void setMContentTv(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.mContentTv = customerAppCompatTextView;
    }

    public final HorizontalRecyclerView getMTipFeeListRv() {
        HorizontalRecyclerView horizontalRecyclerView = this.mTipFeeListRv;
        if (horizontalRecyclerView != null) {
            return horizontalRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTipFeeListRv");
        return null;
    }

    public final void setMTipFeeListRv(HorizontalRecyclerView horizontalRecyclerView) {
        Intrinsics.checkNotNullParameter(horizontalRecyclerView, "<set-?>");
        this.mTipFeeListRv = horizontalRecyclerView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTipsFeeItemView(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTipsFeeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTipsFeeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTipsFeeItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    public void initView() {
        View inflate = View.inflate(getContext(), R.layout.customer_item_bill_tip_fee, this);
        View findViewById = inflate.findViewById(R.id.customer_tv_bill_tip_fee_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_bill_tip_fee_name)");
        setMTitle((CustomerAppCompatTextView) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_tv_bill_tip_fee_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_bill_tip_fee_icon)");
        setMTipIcon((RFIconView) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_tv_bill_tip_fee_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…_tv_bill_tip_fee_content)");
        setMContentTv((CustomerAppCompatTextView) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.customer_rv_bill_tip_fee_list);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_rv_bill_tip_fee_list)");
        setMTipFeeListRv((HorizontalRecyclerView) findViewById4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        getMTipFeeListRv().setLayoutManager(linearLayoutManager);
        getMTipFeeListRv().addItemDecoration(new TipsFeeItemDecorator());
        setClipChildren(false);
        setClipToPadding(false);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.didi.soda.bill.model.ComponentModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r0 = r7.getMTitle()
            java.lang.String r1 = r8.getName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            java.lang.String r0 = r8.getLeftHint()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 8
            r2 = 0
            if (r0 != 0) goto L_0x0036
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r0 = r7.getMContentTv()
            java.lang.String r3 = r8.getLeftHint()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r0 = r7.getMContentTv()
            r0.setVisibility(r2)
            goto L_0x003d
        L_0x0036:
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r0 = r7.getMContentTv()
            r0.setVisibility(r1)
        L_0x003d:
            com.didi.soda.bill.model.ComponentDataModel r0 = r8.getData()
            if (r0 != 0) goto L_0x0044
            goto L_0x0078
        L_0x0044:
            com.didi.soda.bill.model.datamodel.PriceInfoModel r0 = r0.getPriceInfoModel()
            if (r0 != 0) goto L_0x004b
            goto L_0x0078
        L_0x004b:
            com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity r3 = r0.getRuleDesc()
            if (r3 == 0) goto L_0x0059
            com.didi.rfusion.widget.RFIconView r3 = r7.getMTipIcon()
            r3.setVisibility(r2)
            goto L_0x0060
        L_0x0059:
            com.didi.rfusion.widget.RFIconView r3 = r7.getMTipIcon()
            r3.setVisibility(r1)
        L_0x0060:
            com.didi.rfusion.widget.RFIconView r3 = r7.getMTipIcon()
            com.didi.soda.bill.view.item.tipfee.-$$Lambda$BillTipsFeeItemView$BjQBEdeBe3ZfHOPOP9O1qh_66e4 r4 = new com.didi.soda.bill.view.item.tipfee.-$$Lambda$BillTipsFeeItemView$BjQBEdeBe3ZfHOPOP9O1qh_66e4
            r4.<init>(r0)
            r3.setOnClickListener(r4)
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r3 = r7.getMTitle()
            com.didi.soda.bill.view.item.tipfee.-$$Lambda$BillTipsFeeItemView$1HhqWyJSMucP3Irlar7XZ1_JRcc r4 = new com.didi.soda.bill.view.item.tipfee.-$$Lambda$BillTipsFeeItemView$1HhqWyJSMucP3Irlar7XZ1_JRcc
            r4.<init>(r0)
            r3.setOnClickListener(r4)
        L_0x0078:
            com.didi.soda.bill.model.ComponentDataModel r0 = r8.getData()
            r3 = 0
            if (r0 != 0) goto L_0x0081
            goto L_0x0134
        L_0x0081:
            com.didi.soda.bill.model.datamodel.BillTipModel r0 = r0.getTipModel()
            if (r0 != 0) goto L_0x0089
            goto L_0x0134
        L_0x0089:
            java.util.List r0 = r0.getTipConfigList()
            if (r0 != 0) goto L_0x0091
            goto L_0x0134
        L_0x0091:
            com.didi.soda.home.topgun.widget.HorizontalRecyclerView r4 = r7.getMTipFeeListRv()
            r4.setVisibility(r2)
            com.didi.soda.bill.view.item.tipfee.BillTipsFeeListItemAdapter r4 = new com.didi.soda.bill.view.item.tipfee.BillTipsFeeListItemAdapter
            com.didi.soda.bill.view.item.logic.ItemViewAbsLogic r5 = r7.getLogic()
            com.didi.soda.bill.view.item.logic.ItemViewTipsFeeLogic r5 = (com.didi.soda.bill.view.item.logic.ItemViewTipsFeeLogic) r5
            if (r5 != 0) goto L_0x00a4
            r5 = r3
            goto L_0x00a8
        L_0x00a4:
            com.didi.app.nova.skeleton.ScopeContext r5 = r5.getScopeContext()
        L_0x00a8:
            r4.<init>(r5)
            com.didi.soda.bill.model.ComponentDataModel r5 = r8.getData()
            if (r5 != 0) goto L_0x00b3
            r5 = r3
            goto L_0x00b7
        L_0x00b3:
            com.didi.soda.bill.model.datamodel.BillTipModel r5 = r5.getTipModel()
        L_0x00b7:
            java.lang.String r6 = r8.getCurrency()
            r4.setData(r5, r6)
            com.didi.soda.bill.view.item.tipfee.-$$Lambda$BillTipsFeeItemView$XyizBOSnkt2PHG8Jy6vRH-V-ydA r5 = new com.didi.soda.bill.view.item.tipfee.-$$Lambda$BillTipsFeeItemView$XyizBOSnkt2PHG8Jy6vRH-V-ydA
            r5.<init>(r8)
            r4.setOnItemClickListener(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r7.f39252a = r4
            com.didi.soda.home.topgun.widget.HorizontalRecyclerView r4 = r7.getMTipFeeListRv()
            com.didi.soda.bill.view.item.tipfee.BillTipsFeeListItemAdapter r5 = r7.f39252a
            androidx.recyclerview.widget.RecyclerView$Adapter r5 = (androidx.recyclerview.widget.RecyclerView.Adapter) r5
            r4.setAdapter(r5)
            com.didi.soda.bill.model.ComponentDataModel r4 = r8.getData()
            if (r4 != 0) goto L_0x00dd
        L_0x00db:
            r4 = r3
            goto L_0x00ec
        L_0x00dd:
            com.didi.soda.bill.model.datamodel.BillTipModel r4 = r4.getTipModel()
            if (r4 != 0) goto L_0x00e4
            goto L_0x00db
        L_0x00e4:
            long r4 = r4.getTipFeeValue()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
        L_0x00ec:
            int r0 = kotlin.collections.CollectionsKt.indexOf(r0, r4)
            if (r0 < 0) goto L_0x00fc
            com.didi.soda.home.topgun.widget.HorizontalRecyclerView r4 = r7.getMTipFeeListRv()
            if (r4 != 0) goto L_0x00f9
            goto L_0x00fc
        L_0x00f9:
            r4.scrollToPosition(r0)
        L_0x00fc:
            com.didi.soda.bill.model.ComponentDataModel r0 = r8.getData()
            r4 = 1
            if (r0 != 0) goto L_0x0104
            goto L_0x0112
        L_0x0104:
            com.didi.soda.bill.model.datamodel.BillTipModel r0 = r0.getTipModel()
            if (r0 != 0) goto L_0x010b
            goto L_0x0112
        L_0x010b:
            boolean r0 = r0.getMBillTipSWTracked()
            if (r0 != 0) goto L_0x0112
            r2 = 1
        L_0x0112:
            if (r2 == 0) goto L_0x0132
            com.didi.soda.bill.BillOmegaHelper$Companion r0 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r2 = r8.getCartId()
            java.lang.String r5 = r8.getShopId()
            r0.traceBillOrderDetailTipsSW(r2, r5)
            com.didi.soda.bill.model.ComponentDataModel r8 = r8.getData()
            if (r8 != 0) goto L_0x0128
            goto L_0x012c
        L_0x0128:
            com.didi.soda.bill.model.datamodel.BillTipModel r3 = r8.getTipModel()
        L_0x012c:
            if (r3 != 0) goto L_0x012f
            goto L_0x0132
        L_0x012f:
            r3.setMBillTipSWTracked(r4)
        L_0x0132:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0134:
            if (r3 != 0) goto L_0x0140
            r8 = r7
            com.didi.soda.bill.view.item.tipfee.BillTipsFeeItemView r8 = (com.didi.soda.bill.view.item.tipfee.BillTipsFeeItemView) r8
            com.didi.soda.home.topgun.widget.HorizontalRecyclerView r8 = r8.getMTipFeeListRv()
            r8.setVisibility(r1)
        L_0x0140:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.tipfee.BillTipsFeeItemView.setData(com.didi.soda.bill.model.ComponentModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27810a(BillTipsFeeItemView billTipsFeeItemView, PriceInfoModel priceInfoModel, View view) {
        Intrinsics.checkNotNullParameter(billTipsFeeItemView, "this$0");
        Intrinsics.checkNotNullParameter(priceInfoModel, "$it");
        ItemViewTipsFeeLogic itemViewTipsFeeLogic = (ItemViewTipsFeeLogic) billTipsFeeItemView.getLogic();
        if (itemViewTipsFeeLogic != null) {
            itemViewTipsFeeLogic.handleTipsIConClick(priceInfoModel.getRuleDesc());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27811b(BillTipsFeeItemView billTipsFeeItemView, PriceInfoModel priceInfoModel, View view) {
        Intrinsics.checkNotNullParameter(billTipsFeeItemView, "this$0");
        Intrinsics.checkNotNullParameter(priceInfoModel, "$it");
        ItemViewTipsFeeLogic itemViewTipsFeeLogic = (ItemViewTipsFeeLogic) billTipsFeeItemView.getLogic();
        if (itemViewTipsFeeLogic != null) {
            itemViewTipsFeeLogic.handleTipsIConClick(priceInfoModel.getRuleDesc());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27809a(BillTipsFeeItemView billTipsFeeItemView, ComponentModel componentModel, Long l, int i, int i2) {
        Intrinsics.checkNotNullParameter(billTipsFeeItemView, "this$0");
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        ItemViewTipsFeeLogic itemViewTipsFeeLogic = (ItemViewTipsFeeLogic) billTipsFeeItemView.getLogic();
        if (itemViewTipsFeeLogic != null) {
            Intrinsics.checkNotNullExpressionValue(l, Const.BundleKey.SELECT_TIP_FEE);
            itemViewTipsFeeLogic.handleTipsFeeViewClick(componentModel, l.longValue(), i, i2);
        }
    }

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/tipfee/BillTipsFeeItemView$TipsFeeItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillTipsFeeItemView.kt */
    public static final class TipsFeeItemDecorator extends RecyclerView.ItemDecoration {
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(rect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(recyclerView, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            float f = 12.0f;
            float f2 = childLayoutPosition == 0 ? 12.0f : 5.0f;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            boolean z = true;
            if (adapter == null || childLayoutPosition != adapter.getItemCount() - 1) {
                z = false;
            }
            if (!z) {
                f = 5.0f;
            }
            rect.set(DisplayUtils.dip2px(GlobalContext.getContext(), f2), 0, DisplayUtils.dip2px(GlobalContext.getContext(), f), 0);
        }
    }
}
