package com.didi.soda.bill.view.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillTitleInfoItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mSectionDescContainer", "Landroid/widget/LinearLayout;", "mSectionDescIcon", "Landroid/widget/ImageView;", "mSectionDescTv", "Landroid/widget/TextView;", "mSectionTitleTv", "initView", "", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTitleInfoItemView.kt */
public final class BillTitleInfoItemView extends BillItemView<ItemViewCommonLogic> {

    /* renamed from: a */
    private LinearLayout f39237a;

    /* renamed from: b */
    private ImageView f39238b;

    /* renamed from: c */
    private TextView f39239c;

    /* renamed from: d */
    private TextView f39240d;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTitleInfoItemView(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        View inflate = View.inflate(getContext(), R.layout.customer_item_bill_section_title, this);
        View findViewById = inflate.findViewById(R.id.customer_cl_section_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_cl_section_desc)");
        this.f39237a = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_iv_section_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_iv_section_icon)");
        this.f39238b = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_bill_tv_section_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_bill_tv_section_desc)");
        this.f39239c = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_bill_tv_section_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_bill_tv_section_title)");
        this.f39240d = (TextView) findViewById4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [android.widget.LinearLayout] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.didi.soda.bill.model.ComponentModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = r8.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0018
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r0 = 0
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            java.lang.String r3 = "mSectionTitleTv"
            r4 = 8
            r5 = 0
            if (r0 == 0) goto L_0x002c
            android.widget.TextView r0 = r7.f39240d
            if (r0 != 0) goto L_0x0028
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r5
        L_0x0028:
            r0.setVisibility(r4)
            goto L_0x0048
        L_0x002c:
            android.widget.TextView r0 = r7.f39240d
            if (r0 != 0) goto L_0x0034
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r5
        L_0x0034:
            r0.setVisibility(r2)
            android.widget.TextView r0 = r7.f39240d
            if (r0 != 0) goto L_0x003f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r5
        L_0x003f:
            java.lang.String r3 = r8.getName()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x0048:
            java.lang.String r0 = r8.getLeftHint()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0058
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            java.lang.String r0 = "mSectionDescTv"
            java.lang.String r3 = "mSectionDescContainer"
            if (r1 == 0) goto L_0x0077
            android.widget.LinearLayout r8 = r7.f39237a
            if (r8 != 0) goto L_0x0066
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r8 = r5
        L_0x0066:
            r8.setVisibility(r4)
            android.widget.TextView r8 = r7.f39239c
            if (r8 != 0) goto L_0x0071
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x0072
        L_0x0071:
            r5 = r8
        L_0x0072:
            r5.setVisibility(r4)
            goto L_0x0171
        L_0x0077:
            android.widget.LinearLayout r1 = r7.f39237a
            if (r1 != 0) goto L_0x007f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r1 = r5
        L_0x007f:
            r1.setVisibility(r2)
            android.widget.TextView r1 = r7.f39239c
            if (r1 != 0) goto L_0x008a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r1 = r5
        L_0x008a:
            r1.setVisibility(r2)
            android.widget.TextView r1 = r7.f39239c
            if (r1 != 0) goto L_0x0095
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r1 = r5
        L_0x0095:
            java.lang.String r0 = r8.getLeftHint()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            com.didi.soda.bill.model.ComponentDataModel r0 = r8.getData()
            if (r0 != 0) goto L_0x00a6
        L_0x00a4:
            r0 = r5
            goto L_0x00b1
        L_0x00a6:
            com.didi.soda.bill.model.datamodel.TitleInfoModel r0 = r0.getTitleInfoModel()
            if (r0 != 0) goto L_0x00ad
            goto L_0x00a4
        L_0x00ad:
            java.lang.String r0 = r0.getLeftPicUrl()
        L_0x00b1:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "mSectionDescIcon"
            if (r0 == 0) goto L_0x00c7
            android.widget.ImageView r0 = r7.f39238b
            if (r0 != 0) goto L_0x00c3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r5
        L_0x00c3:
            r0.setVisibility(r4)
            goto L_0x0103
        L_0x00c7:
            android.widget.ImageView r0 = r7.f39238b
            if (r0 != 0) goto L_0x00cf
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r5
        L_0x00cf:
            r0.setVisibility(r2)
            android.content.Context r0 = r7.getContext()
            com.didi.soda.bill.model.ComponentDataModel r4 = r8.getData()
            if (r4 != 0) goto L_0x00de
        L_0x00dc:
            r4 = r5
            goto L_0x00e9
        L_0x00de:
            com.didi.soda.bill.model.datamodel.TitleInfoModel r4 = r4.getTitleInfoModel()
            if (r4 != 0) goto L_0x00e5
            goto L_0x00dc
        L_0x00e5:
            java.lang.String r4 = r4.getLeftPicUrl()
        L_0x00e9:
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImageUnspecified((android.content.Context) r0, (java.lang.String) r4)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.centerCrop()
            r4 = 2131232330(0x7f08064a, float:1.8080766E38)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.error((int) r4)
            android.widget.ImageView r4 = r7.f39238b
            if (r4 != 0) goto L_0x0100
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r4 = r5
        L_0x0100:
            r0.into((android.widget.ImageView) r4)
        L_0x0103:
            android.content.Context r0 = r7.getContext()
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131232278(0x7f080616, float:1.808066E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
            if (r0 == 0) goto L_0x0172
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            com.didi.soda.bill.model.ComponentDataModel r8 = r8.getData()
            if (r8 != 0) goto L_0x011d
            goto L_0x0163
        L_0x011d:
            com.didi.soda.bill.model.datamodel.TitleInfoModel r8 = r8.getTitleInfoModel()
            if (r8 != 0) goto L_0x0124
            goto L_0x0163
        L_0x0124:
            java.util.List r8 = r8.getLeftHintColor()
            if (r8 != 0) goto L_0x012b
            goto L_0x0163
        L_0x012b:
            r1 = r8
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ Exception -> 0x015f }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x015f }
            if (r1 != 0) goto L_0x0163
            int r1 = r8.size()     // Catch:{ Exception -> 0x015f }
            int[] r1 = new int[r1]     // Catch:{ Exception -> 0x015f }
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ Exception -> 0x015f }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x015f }
        L_0x0140:
            boolean r4 = r8.hasNext()     // Catch:{ Exception -> 0x015f }
            if (r4 == 0) goto L_0x015b
            java.lang.Object r4 = r8.next()     // Catch:{ Exception -> 0x015f }
            int r6 = r2 + 1
            if (r2 >= 0) goto L_0x0151
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch:{ Exception -> 0x015f }
        L_0x0151:
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x015f }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x015f }
            r1[r2] = r4     // Catch:{ Exception -> 0x015f }
            r2 = r6
            goto L_0x0140
        L_0x015b:
            r0.setColors(r1)     // Catch:{ Exception -> 0x015f }
            goto L_0x0163
        L_0x015f:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0163:
            android.widget.LinearLayout r8 = r7.f39237a
            if (r8 != 0) goto L_0x016b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x016c
        L_0x016b:
            r5 = r8
        L_0x016c:
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            r5.setBackground(r0)
        L_0x0171:
            return
        L_0x0172:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.BillTitleInfoItemView.setData(com.didi.soda.bill.model.ComponentModel):void");
    }
}
