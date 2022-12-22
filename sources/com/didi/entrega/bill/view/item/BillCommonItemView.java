package com.didi.entrega.bill.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.entrega.bill.model.ComponentModel;
import com.didi.entrega.bill.model.PriceInfoModel;
import com.didi.entrega.bill.view.BillItemView;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/entrega/bill/view/item/BillCommonItemView;", "Lcom/didi/entrega/bill/view/BillItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowTv", "Lcom/didi/rfusion/widget/RFIconView;", "contentTv", "Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;", "leftHint", "tipIcon", "title", "underContentTv", "initView", "", "setContent", "componentModel", "Lcom/didi/entrega/bill/model/ComponentModel;", "setData", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillCommonItemView.kt */
public final class BillCommonItemView extends BillItemView {

    /* renamed from: a */
    private CustomerAppCompatTextView f19594a;

    /* renamed from: b */
    private RFIconView f19595b;

    /* renamed from: c */
    private CustomerAppCompatTextView f19596c;

    /* renamed from: d */
    private CustomerAppCompatTextView f19597d;

    /* renamed from: e */
    private RFIconView f19598e;

    /* renamed from: f */
    private CustomerAppCompatTextView f19599f;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillCommonItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillCommonItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillCommonItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    public void initView() {
        View inflate = View.inflate(getContext(), R.layout.entrega_bill_item_common, this);
        View findViewById = inflate.findViewById(R.id.entrega_customer_tv_common_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.entrega_customer_tv_common_name)");
        this.f19594a = (CustomerAppCompatTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.entrega_customer_tv_common_tip_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.entreg…tomer_tv_common_tip_icon)");
        this.f19595b = (RFIconView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.entrega_customer_tv_common_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.entreg…stomer_tv_common_content)");
        this.f19596c = (CustomerAppCompatTextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.entrega_customer_tv_common_under_content);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.entreg…_tv_common_under_content)");
        this.f19597d = (CustomerAppCompatTextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.entrega_customer_tv_common_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.entreg…customer_tv_common_arrow)");
        this.f19598e = (RFIconView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.entrega_tv_common_left_hint);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.entrega_tv_common_left_hint)");
        this.f19599f = (CustomerAppCompatTextView) findViewById6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        r0 = r0.getPriceInfoModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.didi.entrega.bill.model.ComponentModel r10) {
        /*
            r9 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19594a
            java.lang.String r1 = "title"
            r2 = 0
            if (r0 != 0) goto L_0x0011
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0011:
            java.lang.String r3 = r10.getName()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            java.lang.Class<com.didi.entrega.customer.service.IToolsService> r0 = com.didi.entrega.customer.service.IToolsService.class
            com.didi.entrega.customer.service.IService r0 = com.didi.entrega.customer.service.CustomerServiceManager.getService(r0)
            com.didi.entrega.customer.service.IToolsService r0 = (com.didi.entrega.customer.service.IToolsService) r0
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r3 = r9.f19594a
            if (r3 != 0) goto L_0x002a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r3 = r2
        L_0x002a:
            android.widget.TextView r3 = (android.widget.TextView) r3
            com.didi.entrega.customer.service.IToolsService$FontType r1 = com.didi.entrega.customer.service.IToolsService.FontType.MEDIUM
            r0.setTypeface(r3, r1)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19596c
            java.lang.String r1 = "contentTv"
            if (r0 != 0) goto L_0x003b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x003b:
            java.lang.String r3 = r10.getContent()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19597d
            java.lang.String r3 = "underContentTv"
            if (r0 != 0) goto L_0x004f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x004f:
            java.lang.String r4 = r10.getUnderContentDesc()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19599f
            java.lang.String r4 = "leftHint"
            if (r0 != 0) goto L_0x0062
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r2
        L_0x0062:
            java.lang.String r5 = r10.getLeftHint()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            com.didi.entrega.bill.model.ComponentDataModel r0 = r10.getData()
            if (r0 != 0) goto L_0x0073
        L_0x0071:
            r0 = r2
            goto L_0x007e
        L_0x0073:
            com.didi.entrega.bill.model.PriceInfoModel r0 = r0.getPriceInfoModel()
            if (r0 != 0) goto L_0x007a
            goto L_0x0071
        L_0x007a:
            java.lang.String r0 = r0.getPayPriceDisplay()
        L_0x007e:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5 = 1
            r6 = 0
            if (r0 == 0) goto L_0x008d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r0 = 0
            goto L_0x008e
        L_0x008d:
            r0 = 1
        L_0x008e:
            r7 = 8
            if (r0 != 0) goto L_0x011e
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19596c
            if (r0 != 0) goto L_0x009a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x009a:
            r0.setVisibility(r6)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19597d
            if (r0 != 0) goto L_0x00a5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x00a5:
            android.text.TextPaint r0 = r0.getPaint()
            r8 = 16
            r0.setFlags(r8)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19597d
            if (r0 != 0) goto L_0x00b6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x00b6:
            com.didi.entrega.bill.model.ComponentDataModel r8 = r10.getData()
            if (r8 != 0) goto L_0x00be
        L_0x00bc:
            r8 = r2
            goto L_0x00c9
        L_0x00be:
            com.didi.entrega.bill.model.PriceInfoModel r8 = r8.getPriceInfoModel()
            if (r8 != 0) goto L_0x00c5
            goto L_0x00bc
        L_0x00c5:
            java.lang.String r8 = r8.getOriPriceDisplay()
        L_0x00c9:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x00d6
            int r8 = r8.length()
            if (r8 != 0) goto L_0x00d4
            goto L_0x00d6
        L_0x00d4:
            r8 = 0
            goto L_0x00d7
        L_0x00d6:
            r8 = 1
        L_0x00d7:
            if (r8 == 0) goto L_0x00dc
            r8 = 8
            goto L_0x00dd
        L_0x00dc:
            r8 = 0
        L_0x00dd:
            r0.setVisibility(r8)
            com.didi.entrega.bill.model.ComponentDataModel r0 = r10.getData()
            if (r0 != 0) goto L_0x00e8
        L_0x00e6:
            r0 = 0
            goto L_0x00f6
        L_0x00e8:
            com.didi.entrega.bill.model.PriceInfoModel r0 = r0.getPriceInfoModel()
            if (r0 != 0) goto L_0x00ef
            goto L_0x00e6
        L_0x00ef:
            int r0 = r0.getHighLight()
            if (r0 != r5) goto L_0x00e6
            r0 = 1
        L_0x00f6:
            if (r0 == 0) goto L_0x010b
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19596c
            if (r0 != 0) goto L_0x0100
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0100:
            r1 = 2131101459(0x7f060713, float:1.7815328E38)
            int r1 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r1)
            r0.setTextColor(r1)
            goto L_0x0121
        L_0x010b:
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19596c
            if (r0 != 0) goto L_0x0113
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0113:
            r1 = 2131101490(0x7f060732, float:1.7815391E38)
            int r1 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r1)
            r0.setTextColor(r1)
            goto L_0x0121
        L_0x011e:
            r9.setContent(r10)
        L_0x0121:
            java.lang.String r0 = r10.getHint()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0132
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0130
            goto L_0x0132
        L_0x0130:
            r0 = 0
            goto L_0x0133
        L_0x0132:
            r0 = 1
        L_0x0133:
            if (r0 != 0) goto L_0x0141
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19597d
            if (r0 != 0) goto L_0x013d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x013d:
            r0.setVisibility(r6)
            goto L_0x0160
        L_0x0141:
            java.lang.String r0 = r10.getLeftHint()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0152
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0150
            goto L_0x0152
        L_0x0150:
            r0 = 0
            goto L_0x0153
        L_0x0152:
            r0 = 1
        L_0x0153:
            if (r0 != 0) goto L_0x0160
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r9.f19599f
            if (r0 != 0) goto L_0x015d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r2
        L_0x015d:
            r0.setVisibility(r6)
        L_0x0160:
            int r0 = r10.isCanRedirect()
            java.lang.String r1 = "arrowTv"
            if (r0 != r5) goto L_0x0174
            com.didi.rfusion.widget.RFIconView r0 = r9.f19598e
            if (r0 != 0) goto L_0x0170
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0170:
            r0.setVisibility(r6)
            goto L_0x0182
        L_0x0174:
            r9.setEnabled(r6)
            com.didi.rfusion.widget.RFIconView r0 = r9.f19598e
            if (r0 != 0) goto L_0x017f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x017f:
            r0.setVisibility(r7)
        L_0x0182:
            com.didi.entrega.bill.model.ComponentDataModel r0 = r10.getData()
            if (r0 != 0) goto L_0x0189
            goto L_0x01b8
        L_0x0189:
            com.didi.entrega.bill.model.PriceInfoModel r0 = r0.getPriceInfoModel()
            if (r0 != 0) goto L_0x0190
            goto L_0x01b8
        L_0x0190:
            com.didi.rfusion.widget.RFIconView r1 = r9.f19595b
            java.lang.String r3 = "tipIcon"
            if (r1 != 0) goto L_0x019b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r1 = r2
        L_0x019b:
            com.didi.entrega.customer.foundation.rpc.entity.RuleDesc r4 = r0.getRuleDesc()
            if (r4 == 0) goto L_0x01a2
            goto L_0x01a4
        L_0x01a2:
            r6 = 8
        L_0x01a4:
            r1.setVisibility(r6)
            com.didi.rfusion.widget.RFIconView r1 = r9.f19595b
            if (r1 != 0) goto L_0x01af
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x01b0
        L_0x01af:
            r2 = r1
        L_0x01b0:
            com.didi.entrega.bill.view.item.-$$Lambda$BillCommonItemView$NdNDMJ8rBdeC5JiM4cU3bFzBIkg r1 = new com.didi.entrega.bill.view.item.-$$Lambda$BillCommonItemView$NdNDMJ8rBdeC5JiM4cU3bFzBIkg
            r1.<init>(r9)
            r2.setOnClickListener(r1)
        L_0x01b8:
            com.didi.entrega.bill.view.item.-$$Lambda$BillCommonItemView$8h_BgGyq8470qMDhCiMZZEiSB50 r0 = new com.didi.entrega.bill.view.item.-$$Lambda$BillCommonItemView$8h_BgGyq8470qMDhCiMZZEiSB50
            r0.<init>()
            r9.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.bill.view.item.BillCommonItemView.setData(com.didi.entrega.bill.model.ComponentModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14621a(PriceInfoModel priceInfoModel, BillCommonItemView billCommonItemView, View view) {
        Intrinsics.checkNotNullParameter(priceInfoModel, "$it");
        Intrinsics.checkNotNullParameter(billCommonItemView, "this$0");
        Function1<View, Unit> onTipIconClick = priceInfoModel.getOnTipIconClick();
        if (onTipIconClick != null) {
            RFIconView rFIconView = billCommonItemView.f19595b;
            if (rFIconView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipIcon");
                rFIconView = null;
            }
            onTipIconClick.invoke(rFIconView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14620a(ComponentModel componentModel, View view) {
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        Function1<View, Unit> onCardClick = componentModel.getOnCardClick();
        if (onCardClick != null) {
            Intrinsics.checkNotNullExpressionValue(view, "it");
            onCardClick.invoke(view);
        }
    }

    private final void setContent(ComponentModel componentModel) {
        CharSequence content = componentModel.getContent();
        CustomerAppCompatTextView customerAppCompatTextView = null;
        if (!(content == null || content.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView2 = this.f19596c;
            if (customerAppCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentTv");
            } else {
                customerAppCompatTextView = customerAppCompatTextView2;
            }
            customerAppCompatTextView.setVisibility(0);
            return;
        }
        CharSequence defaultContent = componentModel.getDefaultContent();
        if (!(defaultContent == null || defaultContent.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView3 = this.f19597d;
            if (customerAppCompatTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("underContentTv");
                customerAppCompatTextView3 = null;
            }
            customerAppCompatTextView3.setVisibility(0);
            if (componentModel.getDefaultContentHighlight() == 1) {
                CustomerAppCompatTextView customerAppCompatTextView4 = this.f19597d;
                if (customerAppCompatTextView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("underContentTv");
                } else {
                    customerAppCompatTextView = customerAppCompatTextView4;
                }
                customerAppCompatTextView.setTextColor(ResourceHelper.getColor(R.color.rf_color_brands_1_100));
                return;
            }
            CustomerAppCompatTextView customerAppCompatTextView5 = this.f19597d;
            if (customerAppCompatTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("underContentTv");
            } else {
                customerAppCompatTextView = customerAppCompatTextView5;
            }
            customerAppCompatTextView.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
        }
    }
}
