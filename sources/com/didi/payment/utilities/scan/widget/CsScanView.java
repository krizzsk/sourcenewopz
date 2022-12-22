package com.didi.payment.utilities.scan.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.didi.payment.utilities.scan.widget.CsViewFinderView;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import p065me.dm7.barcodescanner.core.IViewFinder;

public class CsScanView extends CsI25ZBarScannerView {

    /* renamed from: a */
    private CsViewFinderView f31717a;

    /* renamed from: b */
    private float f31718b;

    public CsScanView(Context context) {
        super(context);
    }

    public CsScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public IViewFinder createViewFinderView(Context context) {
        CsViewFinderView csViewFinderView = new CsViewFinderView(context);
        this.f31717a = csViewFinderView;
        csViewFinderView.setBorderColor(Integer.MIN_VALUE);
        this.f31717a.setBorderStrokeWidth(UIUtils.dip2px(getContext(), 4.0f));
        this.f31717a.setBorderLineLength(UIUtils.dip2px(getContext(), 32.0f));
        this.f31717a.setBorderCornerRounded(false);
        this.f31717a.setBorderCornerRadius(0);
        this.f31717a.setLaserEnabled(true);
        this.f31717a.setLaserColor(getResources().getColor(R.color.wallet_color_FF6F26));
        this.f31717a.setMaskColor(-436207616);
        this.f31717a.setSquareViewFinder(false);
        this.f31717a.setViewFinderOffset(0);
        return this.f31717a;
    }

    public void startCamera() {
        super.startCamera();
    }

    public void stopCamera() {
        super.stopCamera();
    }

    public void setOnFrameUpdatedListener(CsViewFinderView.OnFrameRectUpdatedListener onFrameRectUpdatedListener) {
        CsViewFinderView csViewFinderView = this.f31717a;
        if (csViewFinderView != null) {
            csViewFinderView.setOnFrameRectUpdatedListener(onFrameRectUpdatedListener);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float a = m22495a(motionEvent);
            float f = this.f31718b;
            if (a > f) {
                setZoom(true);
            } else if (a < f) {
                setZoom(false);
            }
            this.f31718b = a;
        } else if (action == 5) {
            this.f31718b = m22495a(motionEvent);
        }
        return true;
    }

    /* renamed from: a */
    private static float m22495a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }
}
