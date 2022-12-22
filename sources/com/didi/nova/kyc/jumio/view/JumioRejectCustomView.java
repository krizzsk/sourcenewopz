package com.didi.nova.kyc.jumio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.nova.kyc.jumio.module.JumioParams;
import com.didi.nova.kyc.jumio.util.JumioOmegaUtil;
import com.didi.payment.base.utils.UIUtil;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioRejectView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/view/JumioRejectCustomView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "inlineRejectLayout", "Landroid/view/View;", "rejectScan", "rejectSubTitle", "Landroid/widget/TextView;", "rejectTitle", "rejectView", "Lcom/jumio/sdk/views/JumioRejectView;", "attachView", "", "container", "Landroid/view/ViewGroup;", "resetScanPart", "scanPart", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "resetTitle", "data", "", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JumioRejectCustomView.kt */
public final class JumioRejectCustomView extends RelativeLayout {

    /* renamed from: a */
    private View f29369a;

    /* renamed from: b */
    private JumioRejectView f29370b;

    /* renamed from: c */
    private View f29371c;

    /* renamed from: d */
    private TextView f29372d;

    /* renamed from: e */
    private TextView f29373e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JumioRejectCustomView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioRejectCustomView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JumioRejectCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f29369a = LayoutInflater.from(context).inflate(R.layout.jumio_scan_part_regject, this, true);
        this.f29370b = (JumioRejectView) findViewById(R.id.rejectView);
        this.f29372d = (TextView) findViewById(R.id.reject_title);
        this.f29373e = (TextView) findViewById(R.id.reject_sub_title);
        View findViewById = findViewById(R.id.rejectScan);
        this.f29371c = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    JumioRejectCustomView.m20700a(JumioRejectCustomView.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m20700a(JumioRejectCustomView jumioRejectCustomView, View view) {
        Intrinsics.checkNotNullParameter(jumioRejectCustomView, "this$0");
        JumioOmegaUtil.Companion.fin_jumiodocumentreject_button_ck(1);
        jumioRejectCustomView.setVisibility(8);
        JumioRejectView jumioRejectView = jumioRejectCustomView.f29370b;
        if (jumioRejectView != null) {
            jumioRejectView.retake();
        }
    }

    public final void attachView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        viewGroup.addView(this);
    }

    public final void resetScanPart(JumioScanPart jumioScanPart) {
        Intrinsics.checkNotNullParameter(jumioScanPart, "scanPart");
        JumioRejectView jumioRejectView = this.f29370b;
        if (jumioRejectView != null) {
            jumioRejectView.attach(jumioScanPart);
        }
        JumioRejectView jumioRejectView2 = this.f29370b;
        ViewGroup.LayoutParams layoutParams = jumioRejectView2 == null ? null : jumioRejectView2.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (JumioParams.INSTANCE.getAUTO_TYPE() == 2) {
                layoutParams2.width = -1;
                layoutParams2.height = UIUtil.dip2px(getContext(), 358.0f);
                layoutParams2.setMargins(0, UIUtil.dip2px(getContext(), 92.0f), 0, 0);
            } else {
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                layoutParams2.setMargins(0, UIUtil.dip2px(getContext(), 148.0f), 0, 0);
            }
            JumioRejectView jumioRejectView3 = this.f29370b;
            if (jumioRejectView3 != null) {
                jumioRejectView3.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x021a, code lost:
        r2 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void resetTitle(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            android.content.Context r2 = r16.getContext()
            r3 = 2131951741(0x7f13007d, float:1.9539905E38)
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "context.getString(R.stri…ayment_Integration__ertn)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.content.Context r3 = r16.getContext()
            r4 = 2131951749(0x7f130085, float:1.9539921E38)
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "context.getString(R.stri…ayment_Integration__qkTd)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            if (r1 != 0) goto L_0x0028
            goto L_0x021b
        L_0x0028:
            boolean r4 = r1 instanceof java.lang.String
            if (r4 == 0) goto L_0x021b
            java.lang.String r1 = (java.lang.String) r1
            int r4 = r1.hashCode()
            java.lang.String r5 = "context.getString(R.stri…ayment_Integration__jhsh)"
            r6 = 2131951743(0x7f13007f, float:1.953991E38)
            java.lang.String r7 = "context.getString(R.stri…ayment_Integration__VxwT)"
            r8 = 2131951732(0x7f130074, float:1.9539887E38)
            java.lang.String r9 = "context.getString(R.stri…ayment_Integration__BBqh)"
            java.lang.String r11 = "context.getString(R.stri…ayment_Integration__Kove)"
            r12 = 2131951727(0x7f13006f, float:1.9539877E38)
            java.lang.String r13 = "context.getString(R.stri…ayment_Integration__YtZE)"
            r14 = 2131951735(0x7f130077, float:1.9539893E38)
            java.lang.String r15 = "context.getString(R.stri…ayment_Integration__eewu)"
            r10 = 2131951740(0x7f13007c, float:1.9539903E38)
            switch(r4) {
                case 48627: goto L_0x01f8;
                case 48628: goto L_0x01d5;
                case 48629: goto L_0x01b0;
                case 49586: goto L_0x0185;
                case 49587: goto L_0x015e;
                case 49592: goto L_0x0137;
                case 49621: goto L_0x0110;
                case 1537215: goto L_0x00e4;
                case 1537217: goto L_0x00c2;
                case 1537218: goto L_0x00a0;
                case 1537219: goto L_0x007e;
                case 1537220: goto L_0x0052;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x021b
        L_0x0052:
            java.lang.String r4 = "2006"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x005c
            goto L_0x021b
        L_0x005c:
            android.content.Context r1 = r16.getContext()
            r2 = 2131951754(0x7f13008a, float:1.9539931E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.getString(R.stri…ayment_Integration__xBfU)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.content.Context r2 = r16.getContext()
            r3 = 2131951746(0x7f130082, float:1.9539915E38)
            java.lang.String r3 = r2.getString(r3)
            java.lang.String r2 = "context.getString(R.stri…ayment_Integration__lPBV)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            goto L_0x021a
        L_0x007e:
            java.lang.String r4 = "2005"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0088
            goto L_0x021b
        L_0x0088:
            android.content.Context r1 = r16.getContext()
            java.lang.String r1 = r1.getString(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r15)
            android.content.Context r2 = r16.getContext()
            java.lang.String r3 = r2.getString(r14)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            goto L_0x021a
        L_0x00a0:
            java.lang.String r4 = "2004"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00aa
            goto L_0x021b
        L_0x00aa:
            android.content.Context r1 = r16.getContext()
            java.lang.String r1 = r1.getString(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r15)
            android.content.Context r2 = r16.getContext()
            java.lang.String r3 = r2.getString(r14)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            goto L_0x021a
        L_0x00c2:
            java.lang.String r4 = "2003"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00cc
            goto L_0x021b
        L_0x00cc:
            android.content.Context r1 = r16.getContext()
            java.lang.String r1 = r1.getString(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r15)
            android.content.Context r2 = r16.getContext()
            java.lang.String r3 = r2.getString(r14)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            goto L_0x021a
        L_0x00e4:
            java.lang.String r4 = "2001"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00ee
            goto L_0x021b
        L_0x00ee:
            android.content.Context r1 = r16.getContext()
            r2 = 2131951725(0x7f13006d, float:1.9539873E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.getString(R.stri…ayment_Integration__HwAY)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.content.Context r2 = r16.getContext()
            r3 = 2131951731(0x7f130073, float:1.9539885E38)
            java.lang.String r3 = r2.getString(r3)
            java.lang.String r2 = "context.getString(R.stri…ayment_Integration__VftB)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            goto L_0x021a
        L_0x0110:
            java.lang.String r4 = "214"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x011a
            goto L_0x021b
        L_0x011a:
            android.content.Context r1 = r16.getContext()
            r2 = 2131951744(0x7f130080, float:1.9539911E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.getString(R.stri…ayment_Integration__jljy)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.content.Context r2 = r16.getContext()
            java.lang.String r3 = r2.getString(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            goto L_0x021a
        L_0x0137:
            java.lang.String r4 = "206"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0141
            goto L_0x021b
        L_0x0141:
            android.content.Context r1 = r16.getContext()
            r2 = 2131951738(0x7f13007a, float:1.9539899E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.getString(R.stri…ayment_Integration__duBB)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.content.Context r2 = r16.getContext()
            java.lang.String r3 = r2.getString(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            goto L_0x021a
        L_0x015e:
            java.lang.String r4 = "201"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0168
            goto L_0x021b
        L_0x0168:
            android.content.Context r1 = r16.getContext()
            r2 = 2131951750(0x7f130086, float:1.9539923E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.getString(R.stri…ayment_Integration__rcnW)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.content.Context r2 = r16.getContext()
            java.lang.String r3 = r2.getString(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            goto L_0x021a
        L_0x0185:
            java.lang.String r4 = "200"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x018f
            goto L_0x021b
        L_0x018f:
            android.content.Context r1 = r16.getContext()
            r2 = 2131951728(0x7f130070, float:1.9539879E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.getString(R.stri…ayment_Integration__PIiZ)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.content.Context r2 = r16.getContext()
            r3 = 2131951722(0x7f13006a, float:1.9539867E38)
            java.lang.String r3 = r2.getString(r3)
            java.lang.String r2 = "context.getString(R.stri…ayment_Integration__DENu)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            goto L_0x021a
        L_0x01b0:
            java.lang.String r4 = "104"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x01b9
            goto L_0x021b
        L_0x01b9:
            android.content.Context r1 = r16.getContext()
            r2 = 2131951737(0x7f130079, float:1.9539897E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "context.getString(R.stri…ayment_Integration__dVia)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.content.Context r2 = r16.getContext()
            java.lang.String r3 = r2.getString(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            goto L_0x021a
        L_0x01d5:
            java.lang.String r4 = "103"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x01de
            goto L_0x021b
        L_0x01de:
            android.content.Context r1 = r16.getContext()
            java.lang.String r1 = r1.getString(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r11)
            android.content.Context r2 = r16.getContext()
            r4 = 2131951721(0x7f130069, float:1.9539865E38)
            java.lang.String r3 = r2.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)
            goto L_0x021a
        L_0x01f8:
            r4 = 2131951721(0x7f130069, float:1.9539865E38)
            java.lang.String r5 = "102"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0204
            goto L_0x021b
        L_0x0204:
            android.content.Context r1 = r16.getContext()
            java.lang.String r1 = r1.getString(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r11)
            android.content.Context r2 = r16.getContext()
            java.lang.String r3 = r2.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)
        L_0x021a:
            r2 = r1
        L_0x021b:
            android.widget.TextView r1 = r0.f29372d
            if (r1 != 0) goto L_0x0220
            goto L_0x0225
        L_0x0220:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x0225:
            android.widget.TextView r1 = r0.f29373e
            if (r1 != 0) goto L_0x022a
            goto L_0x022f
        L_0x022a:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
        L_0x022f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.nova.kyc.jumio.view.JumioRejectCustomView.resetTitle(java.lang.Object):void");
    }
}
