package com.didi.soda.bill.view.item;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didi.raven.config.RavenKey;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.PriceInfoModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00103\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010$\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u001a\u0010'\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00064"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillCommonItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mArrowTv", "Lcom/didi/soda/customer/widget/text/IconTextView;", "getMArrowTv", "()Lcom/didi/soda/customer/widget/text/IconTextView;", "setMArrowTv", "(Lcom/didi/soda/customer/widget/text/IconTextView;)V", "mContentTv", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "getMContentTv", "()Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "setMContentTv", "(Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;)V", "mLeftIcon", "Lcom/didi/soda/customer/widget/text/IconRichTextView;", "getMLeftIcon", "()Lcom/didi/soda/customer/widget/text/IconRichTextView;", "setMLeftIcon", "(Lcom/didi/soda/customer/widget/text/IconRichTextView;)V", "mLeftInit", "mTipIcon", "getMTipIcon", "setMTipIcon", "mTitle", "getMTitle", "setMTitle", "mUnderContentTv", "Lcom/didi/soda/customer/widget/text/RichTextView;", "getMUnderContentTv", "()Lcom/didi/soda/customer/widget/text/RichTextView;", "setMUnderContentTv", "(Lcom/didi/soda/customer/widget/text/RichTextView;)V", "initView", "", "setContent", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "setContentByPrice", "setData", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillCommonItemView.kt */
public class BillCommonItemView extends BillItemView<ItemViewCommonLogic> {

    /* renamed from: a */
    private CustomerAppCompatTextView f39198a;
    public IconTextView mArrowTv;
    public CustomerAppCompatTextView mContentTv;
    public IconRichTextView mLeftIcon;
    public IconTextView mTipIcon;
    public CustomerAppCompatTextView mTitle;
    public RichTextView mUnderContentTv;

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

    public final IconTextView getMTipIcon() {
        IconTextView iconTextView = this.mTipIcon;
        if (iconTextView != null) {
            return iconTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTipIcon");
        return null;
    }

    public final void setMTipIcon(IconTextView iconTextView) {
        Intrinsics.checkNotNullParameter(iconTextView, "<set-?>");
        this.mTipIcon = iconTextView;
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

    public final RichTextView getMUnderContentTv() {
        RichTextView richTextView = this.mUnderContentTv;
        if (richTextView != null) {
            return richTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUnderContentTv");
        return null;
    }

    public final void setMUnderContentTv(RichTextView richTextView) {
        Intrinsics.checkNotNullParameter(richTextView, "<set-?>");
        this.mUnderContentTv = richTextView;
    }

    public final IconTextView getMArrowTv() {
        IconTextView iconTextView = this.mArrowTv;
        if (iconTextView != null) {
            return iconTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mArrowTv");
        return null;
    }

    public final void setMArrowTv(IconTextView iconTextView) {
        Intrinsics.checkNotNullParameter(iconTextView, "<set-?>");
        this.mArrowTv = iconTextView;
    }

    public final IconRichTextView getMLeftIcon() {
        IconRichTextView iconRichTextView = this.mLeftIcon;
        if (iconRichTextView != null) {
            return iconRichTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLeftIcon");
        return null;
    }

    public final void setMLeftIcon(IconRichTextView iconRichTextView) {
        Intrinsics.checkNotNullParameter(iconRichTextView, "<set-?>");
        this.mLeftIcon = iconRichTextView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillCommonItemView(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillCommonItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    public void initView() {
        View inflate = View.inflate(getContext(), R.layout.customer_item_bill_common, this);
        View findViewById = inflate.findViewById(R.id.customer_tv_common_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_common_name)");
        setMTitle((CustomerAppCompatTextView) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_tv_common_tip_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_common_tip_icon)");
        setMTipIcon((IconTextView) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_tv_common_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_common_content)");
        setMContentTv((CustomerAppCompatTextView) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.customer_tv_common_under_content);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…_tv_common_under_content)");
        setMUnderContentTv((RichTextView) findViewById4);
        View findViewById5 = inflate.findViewById(R.id.customer_tv_common_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_tv_common_arrow)");
        setMArrowTv((IconTextView) findViewById5);
        View findViewById6 = inflate.findViewById(R.id.customer_tv_common_left_hint);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_tv_common_left_hint)");
        this.f39198a = (CustomerAppCompatTextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_tv_common_left_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_tv_common_left_icon)");
        setMLeftIcon((IconRichTextView) findViewById7);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0046, code lost:
        r0 = r0.getPriceInfoModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.didi.soda.bill.model.ComponentModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = r8.getLeftIcon()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 8
            r2 = 0
            if (r0 != 0) goto L_0x0029
            com.didi.soda.customer.widget.text.IconRichTextView r0 = r7.getMLeftIcon()
            java.lang.String r3 = r8.getLeftIcon()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.didi.soda.customer.widget.text.IconRichTextView r0 = r7.getMLeftIcon()
            r0.setVisibility(r2)
            goto L_0x0030
        L_0x0029:
            com.didi.soda.customer.widget.text.IconRichTextView r0 = r7.getMLeftIcon()
            r0.setVisibility(r1)
        L_0x0030:
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r0 = r7.getMTitle()
            java.lang.String r3 = r8.getName()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.didi.soda.bill.model.ComponentDataModel r0 = r8.getData()
            r3 = 0
            if (r0 != 0) goto L_0x0046
        L_0x0044:
            r0 = r3
            goto L_0x0051
        L_0x0046:
            com.didi.soda.bill.model.datamodel.PriceInfoModel r0 = r0.getPriceInfoModel()
            if (r0 != 0) goto L_0x004d
            goto L_0x0044
        L_0x004d:
            java.lang.String r0 = r0.getPayPriceDisplay()
        L_0x0051:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4 = 1
            if (r0 == 0) goto L_0x005f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r0 = 0
            goto L_0x0060
        L_0x005f:
            r0 = 1
        L_0x0060:
            if (r0 != 0) goto L_0x0066
            r7.setContentByPrice(r8)
            goto L_0x0069
        L_0x0066:
            r7.setContent(r8)
        L_0x0069:
            java.lang.String r0 = r8.getHint()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x008a
            com.didi.soda.customer.widget.text.RichTextView r0 = r7.getMUnderContentTv()
            java.lang.String r3 = r8.getHint()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.didi.soda.customer.widget.text.RichTextView r0 = r7.getMUnderContentTv()
            r0.setVisibility(r2)
            goto L_0x00b5
        L_0x008a:
            java.lang.String r0 = r8.getLeftHint()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00b5
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r0 = r7.f39198a
            java.lang.String r5 = "mLeftInit"
            if (r0 != 0) goto L_0x00a0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r0 = r3
        L_0x00a0:
            java.lang.String r6 = r8.getLeftHint()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r0 = r7.f39198a
            if (r0 != 0) goto L_0x00b1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x00b2
        L_0x00b1:
            r3 = r0
        L_0x00b2:
            r3.setVisibility(r2)
        L_0x00b5:
            int r0 = r8.isCanRedirect()
            if (r0 != r4) goto L_0x00cb
            com.didi.soda.bill.view.item.-$$Lambda$BillCommonItemView$qMw1mD9fzN4xRQhRo3AnlxoS1YQ r0 = new com.didi.soda.bill.view.item.-$$Lambda$BillCommonItemView$qMw1mD9fzN4xRQhRo3AnlxoS1YQ
            r0.<init>(r8)
            r7.setOnClickListener(r0)
            com.didi.soda.customer.widget.text.IconTextView r0 = r7.getMArrowTv()
            r0.setVisibility(r2)
            goto L_0x00d2
        L_0x00cb:
            com.didi.soda.customer.widget.text.IconTextView r0 = r7.getMArrowTv()
            r0.setVisibility(r1)
        L_0x00d2:
            com.didi.soda.bill.model.ComponentDataModel r8 = r8.getData()
            if (r8 != 0) goto L_0x00d9
            goto L_0x0101
        L_0x00d9:
            com.didi.soda.bill.model.datamodel.PriceInfoModel r8 = r8.getPriceInfoModel()
            if (r8 != 0) goto L_0x00e0
            goto L_0x0101
        L_0x00e0:
            com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity r0 = r8.getRuleDesc()
            if (r0 == 0) goto L_0x00ee
            com.didi.soda.customer.widget.text.IconTextView r0 = r7.getMTipIcon()
            r0.setVisibility(r2)
            goto L_0x00f5
        L_0x00ee:
            com.didi.soda.customer.widget.text.IconTextView r0 = r7.getMTipIcon()
            r0.setVisibility(r1)
        L_0x00f5:
            com.didi.soda.customer.widget.text.IconTextView r0 = r7.getMTipIcon()
            com.didi.soda.bill.view.item.-$$Lambda$BillCommonItemView$ODk7Ql5NwKadtZNcc_f8wESHhiA r1 = new com.didi.soda.bill.view.item.-$$Lambda$BillCommonItemView$ODk7Ql5NwKadtZNcc_f8wESHhiA
            r1.<init>()
            r0.setOnClickListener(r1)
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.BillCommonItemView.setData(com.didi.soda.bill.model.ComponentModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27759a(BillCommonItemView billCommonItemView, ComponentModel componentModel, View view) {
        Intrinsics.checkNotNullParameter(billCommonItemView, "this$0");
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        ItemViewCommonLogic itemViewCommonLogic = (ItemViewCommonLogic) billCommonItemView.getLogic();
        if (itemViewCommonLogic != null) {
            ItemViewCommonLogic.onItemClick$default(itemViewCommonLogic, componentModel, (Integer) null, (Bundle) null, (Function1) null, 14, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27758a(PriceInfoModel priceInfoModel, View view) {
        Intrinsics.checkNotNullParameter(priceInfoModel, "$it");
        DiRouter.request().path("priceRuleDescPage").putSerializable("entity", priceInfoModel.getRuleDesc()).open();
    }

    private final void setContentByPrice(ComponentModel componentModel) {
        PriceInfoModel priceInfoModel;
        PriceInfoModel priceInfoModel2;
        CustomerAppCompatTextView mContentTv2 = getMContentTv();
        ComponentDataModel data = componentModel.getData();
        String str = null;
        if (!(data == null || (priceInfoModel2 = data.getPriceInfoModel()) == null)) {
            str = priceInfoModel2.getPayPriceDisplay();
        }
        mContentTv2.setText(str);
        int i = 0;
        getMContentTv().setVisibility(0);
        ComponentDataModel data2 = componentModel.getData();
        if (data2 != null && (priceInfoModel = data2.getPriceInfoModel()) != null) {
            if (priceInfoModel.getPayPrice() < priceInfoModel.getOriPrice()) {
                getMUnderContentTv().setText(priceInfoModel.getOriPriceDisplay());
                getMUnderContentTv().getPaint().setFlags(16);
                RichTextView mUnderContentTv2 = getMUnderContentTv();
                CharSequence oriPriceDisplay = priceInfoModel.getOriPriceDisplay();
                if (oriPriceDisplay == null || oriPriceDisplay.length() == 0) {
                    i = 8;
                }
                mUnderContentTv2.setVisibility(i);
            }
            getMArrowTv().setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            if (priceInfoModel.getHighLight() == 1) {
                getMContentTv().setTextColor(ResourceHelper.getColor(R.color.rf_color_brands_1_100));
            } else {
                getMContentTv().setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            }
        }
    }

    public void setContent(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        if (!TextUtils.isEmpty(componentModel.getContent())) {
            getMContentTv().setText(componentModel.getContent());
            getMContentTv().setVisibility(0);
        } else if (!TextUtils.isEmpty(componentModel.getDefaultContent())) {
            getMUnderContentTv().setText(componentModel.getDefaultContent());
            getMUnderContentTv().setVisibility(0);
            getMArrowTv().setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            if (componentModel.getDefaultContentHighlight() == 1) {
                getMUnderContentTv().setTextColor(ResourceHelper.getColor(R.color.rf_color_brands_1_100));
            } else {
                getMUnderContentTv().setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
            }
        }
    }
}
