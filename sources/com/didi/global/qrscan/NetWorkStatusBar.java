package com.didi.global.qrscan;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.global.qrscan.NetWorkReceiver;
import com.didi.sdk.util.Utils;
import com.taxis99.R;

public class NetWorkStatusBar extends LinearLayout {

    /* renamed from: a */
    private NetWorkReceiver f22898a = NetWorkReceiver.getInstance();

    /* renamed from: b */
    private TextView f22899b;

    /* renamed from: c */
    private String f22900c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f22901d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnViewVisibilityChangeListener f22902e;

    /* renamed from: f */
    private NetWorkReceiver.NetWorkChangedListener f22903f = new NetWorkReceiver.NetWorkChangedListener() {
        public void onChanged(int i) {
            boolean unused = NetWorkStatusBar.this.f22901d = i != 0;
            NetWorkStatusBar.this.m16468b();
        }
    };

    public interface OnViewVisibilityChangeListener {
        void onNetWorkStateChanged(View view);
    }

    public void setOnViewVisibilityChangeListener(OnViewVisibilityChangeListener onViewVisibilityChangeListener) {
        this.f22902e = onViewVisibilityChangeListener;
    }

    public NetWorkStatusBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22900c = context.getString(R.string.common_network_disabled);
        LayoutInflater.from(getContext()).inflate(R.layout.global_qrcode_scanner_network_new, this, true);
        TextView textView = (TextView) findViewById(R.id.textviewStatus);
        this.f22899b = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NetWorkStatusBar.this.m16469c();
            }
        });
    }

    public void setVisibility(int i) {
        if (i == 0) {
            super.setVisibility(i);
            OnViewVisibilityChangeListener onViewVisibilityChangeListener = this.f22902e;
            if (onViewVisibilityChangeListener != null) {
                onViewVisibilityChangeListener.onNetWorkStateChanged(this);
                return;
            }
            return;
        }
        m16463a();
    }

    /* renamed from: a */
    private void m16463a() {
        if (getVisibility() != 8) {
            clearAnimation();
            AnimationSet animationSet = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(500);
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    NetWorkStatusBar.this.clearAnimation();
                    NetWorkStatusBar.super.setVisibility(8);
                    if (NetWorkStatusBar.this.f22902e != null) {
                        NetWorkStatusBar.this.f22902e.onNetWorkStateChanged(NetWorkStatusBar.this);
                    }
                }
            });
            startAnimation(animationSet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16468b() {
        if (!this.f22901d) {
            this.f22899b.setText(this.f22900c);
            this.f22899b.setBackgroundColor(getResources().getColor(R.color.common_disabled_network));
            setVisibility(0);
            setContentDescription(this.f22900c);
            return;
        }
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16469c() {
        getContext().startActivity(new Intent("android.settings.SETTINGS"));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m16471d();
        NetWorkReceiver.getInstance().register(this.f22903f);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            getContext().unregisterReceiver(this.f22898a);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
        NetWorkReceiver.getInstance().unRegister(this.f22903f);
    }

    /* renamed from: d */
    private void m16471d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        try {
            getContext().registerReceiver(this.f22898a, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public void refreshOnResume() {
        this.f22901d = Utils.isNetworkConnected(getContext());
        m16468b();
    }
}
