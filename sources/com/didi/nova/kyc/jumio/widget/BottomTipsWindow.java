package com.didi.nova.kyc.jumio.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.nova.kyc.jumio.util.JumioOmegaUtil;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.spi.DDCustomViewData;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/widget/BottomTipsWindow;", "", "()V", "closeView", "Landroid/view/View;", "context", "Landroid/content/Context;", "rootView", "tipsLayout", "Landroid/widget/RelativeLayout;", "windowView", "Landroid/widget/PopupWindow;", "closeWindow", "", "initRecyclerView", "showWindow", "", "parent", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BottomTipsWindow.kt */
public final class BottomTipsWindow {

    /* renamed from: a */
    private PopupWindow f29395a;

    /* renamed from: b */
    private View f29396b;

    /* renamed from: c */
    private View f29397c;

    /* renamed from: d */
    private Context f29398d;

    /* renamed from: e */
    private RelativeLayout f29399e;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m20703a(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARNING: type inference failed for: r0v16, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean showWindow(android.content.Context r5, android.view.View r6) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r4.f29398d = r5
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r5)
            r1 = 2131625634(0x7f0e06a2, float:1.8878481E38)
            r2 = 0
            r3 = 0
            android.view.View r0 = r0.inflate(r1, r2, r3)
            r4.f29396b = r0
            if (r0 != 0) goto L_0x001f
            r0 = r2
            goto L_0x0026
        L_0x001f:
            r1 = 2131428217(0x7f0b0379, float:1.8478072E38)
            android.view.View r0 = r0.findViewById(r1)
        L_0x0026:
            r4.f29397c = r0
            android.view.View r0 = r4.f29396b
            if (r0 != 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            r1 = 2131434578(0x7f0b1c52, float:1.8490974E38)
            android.view.View r0 = r0.findViewById(r1)
            r2 = r0
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
        L_0x0037:
            r4.f29399e = r2
            if (r2 != 0) goto L_0x003c
            goto L_0x0041
        L_0x003c:
            com.didi.nova.kyc.jumio.widget.-$$Lambda$BottomTipsWindow$FY_Czkunb404E3Av6EDHKv1ZcWs r0 = com.didi.nova.kyc.jumio.widget.$$Lambda$BottomTipsWindow$FY_Czkunb404E3Av6EDHKv1ZcWs.INSTANCE
            r2.setOnTouchListener(r0)
        L_0x0041:
            android.view.View r0 = r4.f29397c
            if (r0 != 0) goto L_0x0046
            goto L_0x004e
        L_0x0046:
            com.didi.nova.kyc.jumio.widget.-$$Lambda$BottomTipsWindow$HHbm-tdBvL9BlGQe4gnqE2sBKrY r1 = new com.didi.nova.kyc.jumio.widget.-$$Lambda$BottomTipsWindow$HHbm-tdBvL9BlGQe4gnqE2sBKrY
            r1.<init>()
            r0.setOnClickListener(r1)
        L_0x004e:
            android.widget.PopupWindow r0 = r4.f29395a
            if (r0 != 0) goto L_0x005c
            android.widget.PopupWindow r0 = new android.widget.PopupWindow
            android.view.View r1 = r4.f29396b
            r2 = -1
            r0.<init>(r1, r2, r2)
            r4.f29395a = r0
        L_0x005c:
            r4.m20701a()
            android.widget.PopupWindow r0 = r4.f29395a
            r1 = 1
            if (r0 != 0) goto L_0x0065
            goto L_0x0068
        L_0x0065:
            r0.setOutsideTouchable(r1)
        L_0x0068:
            android.widget.PopupWindow r0 = r4.f29395a
            if (r0 != 0) goto L_0x006d
            goto L_0x0070
        L_0x006d:
            r0.setTouchable(r1)
        L_0x0070:
            android.widget.PopupWindow r0 = r4.f29395a
            if (r0 != 0) goto L_0x0075
            goto L_0x0078
        L_0x0075:
            r0.setFocusable(r1)
        L_0x0078:
            android.widget.PopupWindow r0 = r4.f29395a
            if (r0 != 0) goto L_0x007d
            goto L_0x0080
        L_0x007d:
            r0.setClippingEnabled(r3)
        L_0x0080:
            android.widget.PopupWindow r0 = r4.f29395a
            if (r0 != 0) goto L_0x0085
            goto L_0x0093
        L_0x0085:
            android.content.res.Resources r5 = r5.getResources()
            r2 = 2131235088(0x7f081110, float:1.808636E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r2)
            r0.setBackgroundDrawable(r5)
        L_0x0093:
            com.didi.nova.kyc.jumio.util.JumioOmegaUtil$Companion r5 = com.didi.nova.kyc.jumio.util.JumioOmegaUtil.Companion
            r5.fin_jumiodocument_tip_sw()
            android.widget.PopupWindow r5 = r4.f29395a
            if (r5 != 0) goto L_0x009d
            goto L_0x00a2
        L_0x009d:
            r0 = 80
            r5.showAtLocation(r6, r0, r3, r3)
        L_0x00a2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.nova.kyc.jumio.widget.BottomTipsWindow.showWindow(android.content.Context, android.view.View):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m20702a(BottomTipsWindow bottomTipsWindow, View view) {
        Intrinsics.checkNotNullParameter(bottomTipsWindow, "this$0");
        JumioOmegaUtil.Companion.fin_jumiodocument_tipbutton_ck();
        bottomTipsWindow.closeWindow();
    }

    /* renamed from: a */
    private final void m20701a() {
        View view = this.f29396b;
        TextView textView = view == null ? null : (TextView) view.findViewById(R.id.tips_title);
        View view2 = this.f29396b;
        LinearLayout linearLayout = view2 == null ? null : (LinearLayout) view2.findViewById(R.id.container_view);
        if (textView != null) {
            textView.setText(DDCustomViewData.INSTANCE.getTipsTitle());
        }
        List<String> tipsList = DDCustomViewData.INSTANCE.getTipsList();
        if (tipsList != null) {
            for (String text : tipsList) {
                TextView textView2 = new TextView(this.f29398d);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                layoutParams.setMargins(0, UIUtil.dip2px(this.f29398d, 16.0f), 0, 0);
                layoutParams.gravity = 3;
                textView2.setLayoutParams(layoutParams);
                textView2.setTextColor(-16777216);
                textView2.setTextSize(14.0f);
                textView2.setText(text);
                Context context = this.f29398d;
                textView2.setCompoundDrawablesWithIntrinsicBounds(context == null ? null : context.getDrawable(R.drawable.kyc_tips_itme_point_bg), (Drawable) null, (Drawable) null, (Drawable) null);
                textView2.setCompoundDrawablePadding(UIUtil.dip2px(this.f29398d, 8.0f));
                if (linearLayout != null) {
                    linearLayout.addView(textView2);
                }
            }
        }
    }

    public final void closeWindow() {
        PopupWindow popupWindow = this.f29395a;
        if (popupWindow != null) {
            boolean z = false;
            if (popupWindow != null && popupWindow.isShowing()) {
                z = true;
            }
            if (z) {
                PopupWindow popupWindow2 = this.f29395a;
                if (popupWindow2 != null) {
                    popupWindow2.dismiss();
                }
                this.f29395a = null;
            }
        }
    }
}
