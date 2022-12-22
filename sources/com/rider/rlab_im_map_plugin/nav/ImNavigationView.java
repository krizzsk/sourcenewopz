package com.rider.rlab_im_map_plugin.nav;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.google.android.libraries.navigation.NavigationView;
import com.google.android.libraries.navigation.StylingOptions;
import com.rider.rlab_im_map_plugin.channel.MapIMPluginHelper;
import com.taxis99.R;

public class ImNavigationView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public NavigationView f55935a;

    /* renamed from: b */
    private final Logger f55936b;

    /* renamed from: c */
    private float f55937c;

    /* renamed from: d */
    private float f55938d;

    /* renamed from: e */
    private int f55939e;

    /* renamed from: f */
    private final ComponentCallbacks2 f55940f;

    public ImNavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f55936b = LoggerFactory.getLogger("RiderNavigationView");
        this.f55937c = 0.0f;
        this.f55938d = 0.0f;
        this.f55939e = 0;
        this.f55940f = new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration configuration) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i) {
                if (ImNavigationView.this.f55935a != null) {
                    ImNavigationView.this.f55935a.onTrimMemory(i);
                }
            }
        };
        m40284a(context);
    }

    /* renamed from: a */
    private void m40284a(Context context) {
        setOrientation(1);
        StatusBarView statusBarView = new StatusBarView(context);
        statusBarView.setBackgroundColor(getContext().getResources().getColor(R.color.rider_color_08AE67));
        addView(statusBarView);
        NavigationView navigationView = new NavigationView(context);
        this.f55935a = navigationView;
        addView(navigationView);
        setNavigationView(context);
    }

    public NavigationView getNavigationView() {
        return this.f55935a;
    }

    private void setNavigationView(Context context) {
        m40283a(0);
        this.f55935a.setEtaCardEnabled(false);
        this.f55935a.setRecenterButtonEnabled(false);
        this.f55935a.setForceNightMode(1);
        this.f55935a.setStylingOptions(new StylingOptions().headerDistanceUnitsTextColor(-1).primaryDayModeThemeColor(Integer.valueOf(context.getResources().getColor(R.color.rider_color_08AE67))).primaryNightModeThemeColor(Integer.valueOf(context.getResources().getColor(R.color.rider_color_08AE67))).secondaryDayModeThemeColor(Integer.valueOf(context.getResources().getColor(R.color.rider_color_008751))).secondaryNightModeThemeColor(Integer.valueOf(context.getResources().getColor(R.color.rider_color_008751))));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f55939e == 0) {
            this.f55939e = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f55937c = motionEvent.getX();
            this.f55938d = motionEvent.getY();
        } else if (action == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float f = x - this.f55937c;
            float f2 = y - this.f55938d;
            if (Math.abs(f) > ((float) this.f55939e) || Math.abs(f2) > ((float) this.f55939e)) {
                MapIMPluginHelper.setMapNavigationDragDidChange();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void showOverView() {
        NavigationView navigationView = this.f55935a;
        if (navigationView != null) {
            navigationView.getCamera().showRouteOverview();
        }
    }

    public void showCurrentView() {
        NavigationView navigationView = this.f55935a;
        if (navigationView != null) {
            navigationView.getCamera().followMyLocation(0);
        }
    }

    public void setMapPadding(int i, int i2, int i3, int i4) {
        NavigationView navigationView = this.f55935a;
        if (navigationView != null) {
            navigationView.getMap().setPadding(i, i2, i3, i4);
        }
    }

    public void onCreate(Bundle bundle) {
        NavigationView navigationView = this.f55935a;
        if (navigationView != null) {
            navigationView.onCreate(bundle);
            getContext().registerComponentCallbacks(this.f55940f);
        }
    }

    public void onStart() {
        NavigationView navigationView = this.f55935a;
        if (navigationView != null) {
            navigationView.onStart();
        }
    }

    public void onResume() {
        NavigationView navigationView = this.f55935a;
        if (navigationView != null) {
            navigationView.onResume();
        }
    }

    public void onPause() {
        NavigationView navigationView = this.f55935a;
        if (navigationView != null) {
            navigationView.onPause();
        }
    }

    public void onStop() {
        NavigationView navigationView = this.f55935a;
        if (navigationView != null) {
            navigationView.onStop();
        }
    }

    public void onDestroy() {
        if (getContext() != null) {
            getContext().unregisterComponentCallbacks(this.f55940f);
        }
        try {
            this.f55935a.onDestroy();
        } catch (Exception e) {
            this.f55936b.error("navigationView destroy throw exception：", (Throwable) e);
        }
    }

    /* renamed from: a */
    private void m40283a(int i) {
        this.f55935a.getCamera().followMyLocation(i);
    }
}
