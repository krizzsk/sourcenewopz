package com.didi.sdk.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.netreceiver.NetWorkReceiver;
import com.didi.sdk.util.Utils;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class NetWorkTitleBar extends LinearLayout {

    /* renamed from: a */
    HashMap<String, Object> f37836a = new HashMap<>();

    /* renamed from: b */
    private final String f37837b = "pas_home_error";

    /* renamed from: c */
    private final String f37838c = "network";

    /* renamed from: d */
    private final String f37839d = "location";

    /* renamed from: e */
    private final String f37840e = "privilege";

    /* renamed from: f */
    private final String f37841f = "notice";

    /* renamed from: g */
    private final String f37842g = "0";

    /* renamed from: h */
    private final String f37843h = "1";

    /* renamed from: i */
    private NetWorkReceiver f37844i = NetWorkReceiver.getInstance();

    /* renamed from: j */
    private TextView f37845j;

    /* renamed from: k */
    private String f37846k;

    /* renamed from: l */
    private String f37847l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Logger f37848m = LoggerFactory.getLogger("NetWorkTitleBar");
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f37849n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public OnViewVisibilityChangeListener f37850o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f37851p = false;

    /* renamed from: q */
    private ILocation.ILocateStatusListener f37852q = new ILocation.ILocateStatusListener() {
        public void onStatusUpdate(String str, int i, String str2) {
            boolean z = false;
            if (1 == i) {
                boolean unused = NetWorkTitleBar.this.f37851p = false;
                NetWorkTitleBar.this.m26802c();
                return;
            }
            NetWorkTitleBar netWorkTitleBar = NetWorkTitleBar.this;
            if (i == 512) {
                z = true;
            }
            boolean unused2 = netWorkTitleBar.f37851p = z;
            NetWorkTitleBar.this.m26802c();
        }
    };

    /* renamed from: r */
    private ILocation.ILocationChangedListener f37853r = new ILocation.ILocationChangedListener() {
        public void onLocationChanged(DIDILocation dIDILocation) {
            if (!(dIDILocation == null || dIDILocation.getLatitude() == 0.0d || dIDILocation.getLongitude() == 0.0d)) {
                boolean unused = NetWorkTitleBar.this.f37851p = false;
            }
            NetWorkTitleBar.this.m26802c();
        }
    };

    /* renamed from: s */
    private ILocation.ILocationErrorListener f37854s = new ILocation.ILocationErrorListener() {
        public void onLocationError(int i, ErrInfo errInfo) {
            Logger c = NetWorkTitleBar.this.f37848m;
            c.debug("onLocationError var1:" + i + " vvar2:" + errInfo.getErrNo(), new Object[0]);
            if (errInfo.getErrNo() == 101 || errInfo.getErrNo() == 201) {
                boolean unused = NetWorkTitleBar.this.f37851p = true;
                NetWorkTitleBar.this.m26802c();
                return;
            }
            boolean unused2 = NetWorkTitleBar.this.f37851p = false;
            NetWorkTitleBar.this.m26802c();
        }
    };

    /* renamed from: t */
    private NetWorkReceiver.NetWorkChangedListener f37855t = new NetWorkReceiver.NetWorkChangedListener() {
        public void onChanged(int i) {
            boolean unused = NetWorkTitleBar.this.f37849n = i != 0;
            NetWorkTitleBar.this.m26802c();
        }
    };

    public interface OnViewVisibilityChangeListener {
        void onNetWorkStateChanged(View view);
    }

    public void setOnViewVisibilityChangeListener(OnViewVisibilityChangeListener onViewVisibilityChangeListener) {
        this.f37850o = onViewVisibilityChangeListener;
    }

    public NetWorkTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37846k = context.getString(R.string.common_network_disabled);
        this.f37847l = context.getString(R.string.common_location_disabled);
        LayoutInflater.from(getContext()).inflate(R.layout.f_networktitlebar, this, true);
        TextView textView = (TextView) findViewById(R.id.textviewStatus);
        this.f37845j = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NetWorkTitleBar.this.m26804d();
            }
        });
    }

    /* renamed from: a */
    private boolean m26796a() {
        return this.f37851p;
    }

    public void setVisibility(int i) {
        if (i == 0) {
            super.setVisibility(i);
            OnViewVisibilityChangeListener onViewVisibilityChangeListener = this.f37850o;
            if (onViewVisibilityChangeListener != null) {
                onViewVisibilityChangeListener.onNetWorkStateChanged(this);
                return;
            }
            return;
        }
        m26798b();
    }

    /* renamed from: b */
    private void m26798b() {
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
                    NetWorkTitleBar.this.clearAnimation();
                    NetWorkTitleBar.super.setVisibility(8);
                    if (NetWorkTitleBar.this.f37850o != null) {
                        NetWorkTitleBar.this.f37850o.onNetWorkStateChanged(NetWorkTitleBar.this);
                    }
                }
            });
            startAnimation(animationSet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26802c() {
        boolean isLocatable = LocationPerformer.getInstance().isLocatable();
        Logger logger = this.f37848m;
        logger.info("onStatusChanged: isNetworkEnabled:" + this.f37849n + " isLocationEnabled:  " + isLocatable + "  isGpsDenied:" + this.f37851p, new Object[0]);
        if (!isLocatable && !this.f37849n) {
            this.f37845j.setText(this.f37846k);
            this.f37845j.setBackgroundColor(getResources().getColor(R.color.common_disabled_network));
            setVisibility(0);
            m26795a("1", "1");
            setContentDescription(this.f37846k);
        } else if (!isLocatable && this.f37849n) {
            this.f37845j.setText(this.f37847l);
            this.f37845j.setBackgroundColor(getResources().getColor(R.color.common_disabled_location));
            setVisibility(0);
            m26795a("0", "1");
            setContentDescription(this.f37847l);
        } else if (this.f37849n || !isLocatable) {
            setVisibility(8);
        } else {
            this.f37845j.setText(this.f37846k);
            this.f37845j.setBackgroundColor(getResources().getColor(R.color.common_disabled_network));
            setVisibility(0);
            m26795a("1", "0");
            setContentDescription(this.f37846k);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m26804d() {
        Intent intent = new Intent("android.settings.SETTINGS");
        Context context = getContext();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    private void m26795a(final String str, final String str2) {
        if ("home".equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            final String str3 = this.f37851p ? "1" : "0";
            if (!str3.equals(this.f37836a.get("privilege")) || !str.equals(this.f37836a.get("network")) || !str2.equals(this.f37836a.get("location"))) {
                ApmThreadPool.executeOnSingle(new Runnable() {
                    public void run() {
                        NetWorkTitleBar.this.f37836a.put("network", str);
                        NetWorkTitleBar.this.f37836a.put("location", str2);
                        NetWorkTitleBar.this.f37836a.put("privilege", str3);
                        HashMap<String, Object> hashMap = NetWorkTitleBar.this.f37836a;
                        NetWorkTitleBar netWorkTitleBar = NetWorkTitleBar.this;
                        hashMap.put("notice", Integer.valueOf(netWorkTitleBar.isNotificationAllowed(netWorkTitleBar.getContext())));
                        OmegaSDKAdapter.trackEvent("pas_home_error", (Map<String, Object>) NetWorkTitleBar.this.f37836a);
                        Logger c = NetWorkTitleBar.this.f37848m;
                        c.info("AddLog:" + NetWorkTitleBar.this.f37836a.toString(), new Object[0]);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m26805e();
        NetWorkReceiver.getInstance().register(this.f37855t);
        LocationPerformer.getInstance().addLocateStatusListener(this.f37852q);
        LocationPerformer.getInstance().addLocationErrorListener(this.f37854s);
        LocationPerformer.getInstance().addLocationListener(this.f37853r);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            getContext().unregisterReceiver(this.f37844i);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
        NetWorkReceiver.getInstance().unRegister(this.f37855t);
        LocationPerformer.getInstance().removeLocateStatusListener(this.f37852q);
        LocationPerformer.getInstance().removeLocationErrorListener(this.f37854s);
        LocationPerformer.getInstance().removeLocationListener(this.f37853r);
    }

    /* renamed from: e */
    private void m26805e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        try {
            getContext().registerReceiver(this.f37844i, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public void refreshOnResume() {
        this.f37849n = Utils.isNetworkConnected(getContext());
        m26802c();
    }

    public int isNotificationAllowed(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled() ^ true ? 1 : 0;
        }
        return 0;
    }
}
