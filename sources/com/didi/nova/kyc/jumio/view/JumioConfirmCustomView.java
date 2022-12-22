package com.didi.nova.kyc.jumio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.didi.nova.kyc.jumio.DDCustomActivity;
import com.didi.nova.kyc.jumio.module.JumioParams;
import com.didi.payment.base.utils.UIUtil;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioConfirmationView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/view/JumioConfirmCustomView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Lcom/didi/nova/kyc/jumio/DDCustomActivity;", "confirmListener", "Lcom/didi/nova/kyc/jumio/view/JumioConfirmCustomView$JumioBtnClick;", "confirmScan", "Landroid/view/View;", "confirmationView", "Lcom/jumio/sdk/views/JumioConfirmationView;", "inlineConfirmLayout", "retryListener", "retryScan", "attachView", "", "container", "Landroid/view/ViewGroup;", "resetScanPart", "scanPart", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "JumioBtnClick", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JumioConfirmCustomView.kt */
public final class JumioConfirmCustomView extends RelativeLayout {

    /* renamed from: a */
    private View f29362a;

    /* renamed from: b */
    private View f29363b;

    /* renamed from: c */
    private JumioConfirmationView f29364c;

    /* renamed from: d */
    private View f29365d;

    /* renamed from: e */
    private JumioBtnClick f29366e;

    /* renamed from: f */
    private JumioBtnClick f29367f;

    /* renamed from: g */
    private DDCustomActivity f29368g;

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/view/JumioConfirmCustomView$JumioBtnClick;", "", "onClick", "", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: JumioConfirmCustomView.kt */
    public interface JumioBtnClick {
        void onClick();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JumioConfirmCustomView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioConfirmCustomView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JumioConfirmCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f29362a = LayoutInflater.from(context).inflate(R.layout.jumio_scan_part_confirm, this, true);
        this.f29363b = findViewById(R.id.retryScan);
        this.f29364c = (JumioConfirmationView) findViewById(R.id.confirmationView);
        this.f29365d = findViewById(R.id.confirmScan);
        View view = this.f29363b;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    JumioConfirmCustomView.m20698a(JumioConfirmCustomView.this, view);
                }
            });
        }
        View view2 = this.f29365d;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    JumioConfirmCustomView.m20699b(JumioConfirmCustomView.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m20698a(JumioConfirmCustomView jumioConfirmCustomView, View view) {
        Intrinsics.checkNotNullParameter(jumioConfirmCustomView, "this$0");
        JumioConfirmationView jumioConfirmationView = jumioConfirmCustomView.f29364c;
        if (jumioConfirmationView != null) {
            jumioConfirmationView.retake();
        }
        JumioBtnClick jumioBtnClick = jumioConfirmCustomView.f29366e;
        if (jumioBtnClick != null) {
            jumioBtnClick.onClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m20699b(JumioConfirmCustomView jumioConfirmCustomView, View view) {
        Intrinsics.checkNotNullParameter(jumioConfirmCustomView, "this$0");
        JumioConfirmationView jumioConfirmationView = jumioConfirmCustomView.f29364c;
        if (jumioConfirmationView != null) {
            jumioConfirmationView.confirm();
        }
        JumioBtnClick jumioBtnClick = jumioConfirmCustomView.f29367f;
        if (jumioBtnClick != null) {
            jumioBtnClick.onClick();
        }
    }

    public final void resetScanPart(JumioScanPart jumioScanPart) {
        Intrinsics.checkNotNullParameter(jumioScanPart, "scanPart");
        JumioConfirmationView jumioConfirmationView = this.f29364c;
        if (jumioConfirmationView != null) {
            jumioConfirmationView.attach(jumioScanPart);
        }
        JumioConfirmationView jumioConfirmationView2 = this.f29364c;
        ViewGroup.LayoutParams layoutParams = jumioConfirmationView2 == null ? null : jumioConfirmationView2.getLayoutParams();
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
            JumioConfirmationView jumioConfirmationView3 = this.f29364c;
            if (jumioConfirmationView3 != null) {
                jumioConfirmationView3.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final void attachView(ViewGroup viewGroup, JumioBtnClick jumioBtnClick, JumioBtnClick jumioBtnClick2) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(jumioBtnClick, "retryListener");
        Intrinsics.checkNotNullParameter(jumioBtnClick2, "confirmListener");
        viewGroup.addView(this);
        Context context = getContext();
        if (context != null) {
            this.f29368g = (DDCustomActivity) context;
            this.f29366e = jumioBtnClick;
            this.f29367f = jumioBtnClick2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.nova.kyc.jumio.DDCustomActivity");
    }
}
