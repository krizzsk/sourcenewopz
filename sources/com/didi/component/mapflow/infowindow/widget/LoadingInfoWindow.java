package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.taxis99.R;

public class LoadingInfoWindow extends LinearLayout {

    /* renamed from: a */
    private final int f14297a = 200;

    /* renamed from: b */
    private final int[] f14298b = {R.drawable.global_mapflow_loading_1, R.drawable.global_mapflow_loading_2, R.drawable.global_mapflow_loading_3};

    /* renamed from: c */
    private ImageView f14299c;

    /* renamed from: d */
    private int f14300d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IUpdateCallback f14301e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f14302f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f14303g = 200;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Handler f14304h = new Handler(Looper.getMainLooper());

    /* renamed from: i */
    private Runnable f14305i = new Runnable() {
        public void run() {
            LoadingInfoWindow.this.m9947a();
            if (LoadingInfoWindow.this.f14301e != null) {
                LoadingInfoWindow.this.f14301e.update();
            }
            if (!LoadingInfoWindow.this.f14302f) {
                LoadingInfoWindow.this.f14304h.postDelayed(this, LoadingInfoWindow.this.f14303g);
            }
        }
    };

    public interface IUpdateCallback {
        void update();
    }

    public LoadingInfoWindow(Context context) {
        super(context);
        m9948a(context);
    }

    public LoadingInfoWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9948a(context);
    }

    public LoadingInfoWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9948a(context);
    }

    public LoadingInfoWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m9948a(context);
    }

    /* renamed from: a */
    private void m9948a(Context context) {
        inflate(context, R.layout.global_map_loading_window, this);
        this.f14299c = (ImageView) findViewById(R.id.left_loading);
    }

    public void setUpdateCallback(IUpdateCallback iUpdateCallback) {
        this.f14301e = iUpdateCallback;
    }

    public void setIntervalTime(long j) {
        this.f14303g = j;
    }

    public void showLoading() {
        this.f14302f = false;
        this.f14304h.postDelayed(this.f14305i, this.f14303g);
    }

    public void stopLoading() {
        this.f14302f = true;
        this.f14304h.removeCallbacks(this.f14305i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9947a() {
        int i = this.f14300d + 1;
        this.f14300d = i;
        if (i < 0 || i >= this.f14298b.length) {
            this.f14300d = 0;
        }
        this.f14299c.setImageResource(this.f14298b[this.f14300d]);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopLoading();
    }
}
