package com.didi.soda.customer.widget.goodsV2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.foundation.rpc.entity.ActTagEntity;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/goodsV2/GoodActTagLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setActTag", "", "actTag", "Lcom/didi/soda/customer/foundation/rpc/entity/ActTagEntity;", "Lcom/didi/soda/goodsV2/model/GoodsPurchaseHeaderRvModel$ActTagModel;", "state", "Lcom/didi/soda/goods/contract/GoodsItemState;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GoodActTagLayout.kt */
public final class GoodActTagLayout extends LinearLayout {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GoodActTagLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GoodActTagLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoodActTagLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodActTagLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setGravity(16);
        setOrientation(0);
        setPadding(DisplayUtils.dip2px(getContext(), 8.0f), DisplayUtils.dip2px(getContext(), 3.0f), DisplayUtils.dip2px(getContext(), 8.0f), DisplayUtils.dip2px(getContext(), 3.0f));
        LayoutInflater.from(context).inflate(R.layout.customer_widget_goods_act_tag_layout_v2, this);
        setBackground(context.getDrawable(R.drawable.customer_goods_purchasel_tag_bg));
    }

    public final void setActTag(ActTagEntity actTagEntity) {
        Intrinsics.checkNotNullParameter(actTagEntity, "actTag");
        ((RFIconView) findViewById(R.id.customer_tv_icon_view)).setText(actTagEntity.icon);
        ((RichTextView) findViewById(R.id.customer_tv_tag_view)).setText(actTagEntity.content);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        r1 = r3.icon;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setActTag(com.didi.soda.goodsV2.model.GoodsPurchaseHeaderRvModel.ActTagModel r3, com.didi.soda.goods.contract.GoodsItemState r4) {
        /*
            r2 = this;
            r4 = 2131429758(0x7f0b097e, float:1.8481198E38)
            android.view.View r4 = r2.findViewById(r4)
            com.didi.rfusion.widget.RFIconView r4 = (com.didi.rfusion.widget.RFIconView) r4
            java.lang.String r0 = ""
            if (r3 != 0) goto L_0x0011
        L_0x000d:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x0018
        L_0x0011:
            java.lang.String r1 = r3.icon
            if (r1 != 0) goto L_0x0016
            goto L_0x000d
        L_0x0016:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0018:
            r4.setText(r1)
            r4 = 2131429869(0x7f0b09ed, float:1.8481423E38)
            android.view.View r1 = r2.findViewById(r4)
            com.didi.soda.customer.widget.text.RichTextView r1 = (com.didi.soda.customer.widget.text.RichTextView) r1
            if (r3 != 0) goto L_0x0029
        L_0x0026:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x0031
        L_0x0029:
            android.text.SpannableString r3 = r3.content
            if (r3 != 0) goto L_0x002e
            goto L_0x0026
        L_0x002e:
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x0031:
            r1.setText(r0)
            java.lang.Class<com.didi.soda.customer.service.IToolsService> r3 = com.didi.soda.customer.service.IToolsService.class
            com.didi.soda.customer.service.IService r3 = com.didi.soda.customer.service.CustomerServiceManager.getService(r3)
            com.didi.soda.customer.service.IToolsService r3 = (com.didi.soda.customer.service.IToolsService) r3
            android.view.View r4 = r2.findViewById(r4)
            com.didi.soda.customer.widget.text.RichTextView r4 = (com.didi.soda.customer.widget.text.RichTextView) r4
            android.widget.TextView r4 = (android.widget.TextView) r4
            com.didi.soda.customer.service.IToolsService$FontType r0 = com.didi.soda.customer.service.IToolsService.FontType.NORMAL
            r3.setTypeface(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.goodsV2.GoodActTagLayout.setActTag(com.didi.soda.goodsV2.model.GoodsPurchaseHeaderRvModel$ActTagModel, com.didi.soda.goods.contract.GoodsItemState):void");
    }
}
