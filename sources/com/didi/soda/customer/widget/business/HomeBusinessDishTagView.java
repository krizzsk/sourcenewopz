package com.didi.soda.customer.widget.business;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016J/\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/business/HomeBusinessDishTagView;", "Lcom/didi/soda/customer/widget/business/BaseTagView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLimitedMaxWidth", "setData", "", "bgColorStrs", "", "", "content", "angle", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseTagView.kt */
public final class HomeBusinessDishTagView extends BaseTagView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessDishTagView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessDishTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeBusinessDishTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBusinessDishTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setMaxLines(1);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.BOLD);
    }

    public int getLimitedMaxWidth() {
        return ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_208);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025 A[Catch:{ Exception -> 0x005a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setData(java.util.List<java.lang.String> r6, java.lang.String r7, java.lang.Integer r8) {
        /*
            r5 = this;
            android.content.Context r0 = r5.getContext()
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131232310(0x7f080636, float:1.8080726E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
            if (r0 == 0) goto L_0x0065
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r1 = r6
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ Exception -> 0x005a }
            r2 = 0
            if (r1 == 0) goto L_0x0022
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x005a }
            if (r1 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r1 = 0
            goto L_0x0023
        L_0x0022:
            r1 = 1
        L_0x0023:
            if (r1 != 0) goto L_0x005e
            int r1 = r6.size()     // Catch:{ Exception -> 0x005a }
            int[] r1 = new int[r1]     // Catch:{ Exception -> 0x005a }
            if (r6 != 0) goto L_0x002e
            goto L_0x004f
        L_0x002e:
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ Exception -> 0x005a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x005a }
        L_0x0034:
            boolean r3 = r6.hasNext()     // Catch:{ Exception -> 0x005a }
            if (r3 == 0) goto L_0x004f
            java.lang.Object r3 = r6.next()     // Catch:{ Exception -> 0x005a }
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x0045
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch:{ Exception -> 0x005a }
        L_0x0045:
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x005a }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ Exception -> 0x005a }
            r1[r2] = r3     // Catch:{ Exception -> 0x005a }
            r2 = r4
            goto L_0x0034
        L_0x004f:
            r0.setColors(r1)     // Catch:{ Exception -> 0x005a }
            android.graphics.drawable.GradientDrawable$Orientation r6 = com.didi.soda.customer.foundation.util.ExtentionsKt.updateAngle(r0, r8)     // Catch:{ Exception -> 0x005a }
            r0.setOrientation(r6)     // Catch:{ Exception -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005e:
            r6 = 0
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            r5.bindData(r6, r0, r7)
            return
        L_0x0065:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.business.HomeBusinessDishTagView.setData(java.util.List, java.lang.String, java.lang.Integer):void");
    }
}
