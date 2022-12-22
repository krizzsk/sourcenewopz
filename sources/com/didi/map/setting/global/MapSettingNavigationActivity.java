package com.didi.map.setting.global;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.google.model.OmegaTraceEvent;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingBaseActivity;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.map.setting.common.MapSettingOmega;
import com.didi.map.setting.common.apollo.MapSettingApolloUtil;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.taxis99.R;
import java.util.List;

public class MapSettingNavigationActivity extends MapSettingBaseActivity {

    /* renamed from: a */
    private TextView f28964a;

    /* renamed from: b */
    private ImageView f28965b;

    /* renamed from: c */
    private List<MapSettingAppInfo> f28966c;

    /* renamed from: d */
    private boolean f28967d;

    /* renamed from: e */
    private boolean f28968e;

    /* renamed from: f */
    private LinearLayout f28969f;

    /* renamed from: g */
    private ImageView f28970g;

    /* renamed from: h */
    private View f28971h;

    /* renamed from: i */
    private RelativeLayout f28972i;

    /* renamed from: j */
    private ImageView f28973j;

    /* renamed from: k */
    private boolean f28974k;

    /* renamed from: l */
    private boolean f28975l;

    public static void startMapSettingActivity(Context context) {
        DLog.m20371d("showSettingPage1", new Object[0]);
        context.startActivity(new Intent(context, MapSettingNavigationActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.map_setting_navigation_layout);
        DLog.m20371d("the map_setting_navigation_selected = " + getResources().getString(R.string.map_setting_navigation_selected), new Object[0]);
        findViewById(R.id.map_setting_title_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapSettingNavigationActivity.this.onBackPressed();
            }
        });
        ((TextView) findViewById(R.id.map_setting_title_text)).setText(getResources().getString(R.string.map_setting_navigation_title));
        this.f28965b = (ImageView) findViewById(R.id.map_setting_open_navigation);
        this.f28964a = (TextView) findViewById(R.id.map_setting_nav_text);
        this.f28969f = (LinearLayout) findViewById(R.id.map_setting_nav_voice_layout);
        this.f28970g = (ImageView) findViewById(R.id.map_setting_voice_switch);
        this.f28971h = findViewById(R.id.map_setting_nav_day_night_mode_layout);
        this.f28972i = (RelativeLayout) findViewById(R.id.map_setting_traffic_bar_switch_panel);
        this.f28973j = (ImageView) findViewById(R.id.map_setting_traffic_bar_switch);
        if (Apollo.getToggle("global_driver_android_nav_mute").allow()) {
            this.f28969f.setVisibility(0);
        }
        findViewById(R.id.map_setting_item_nav).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapSettingSelectedActivity.startSelectedActivity(MapSettingNavigationActivity.this);
            }
        });
        if (!MapSettingApolloUtil.getTrafficBarEnable() || this.mPreferences == null || !this.mPreferences.isHawaii()) {
            this.f28972i.setVisibility(8);
        } else {
            this.f28972i.setVisibility(0);
        }
        MapSettingUtils.getCurLan(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f28966c = MapSettingNavUtils.getInstalledThirdNav(this);
        m20383b();
        m20385c();
        m20379a();
        m20387d();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (!(this.mPreferences == null || this.f28967d == this.mPreferences.getNavDefaultOpen())) {
            MapSettingOmega.add("com_mapSet_mrdh_ck").add(ParamKeys.PARAM_RES.PARAM_RES_DRIVERID, Long.valueOf(PlatInfo.getInstance().getDriverId())).add("switch", this.mPreferences.getNavDefaultOpen() ? "true" : SDKConsts.BOOLEAN_FALSE).report();
        }
        if (!(this.mPreferences == null || this.f28968e == this.mPreferences.getInAppNavVoiceOpen())) {
            MapSettingOmega.add("map_setting_voiceSwitch_ck").add(ParamKeys.PARAM_RES.PARAM_RES_DRIVERID, Long.valueOf(PlatInfo.getInstance().getDriverId())).add("state", Integer.valueOf(this.mPreferences.getInAppNavVoiceOpen() ? 1 : 0)).add("time", Long.valueOf(System.currentTimeMillis())).report();
        }
        if (MapSettingApolloUtil.getTrafficBarEnable() && this.mPreferences != null && this.mPreferences.isHawaii() && this.f28975l != this.f28974k) {
            MapSettingOmega.add("map_pub_navi_trafficbar_setting_ck").add("bar_state", Integer.valueOf(this.f28975l ? 1 : 0)).add(CarServerParam.PARAM_DRIVER_ID, Long.valueOf(PlatInfo.getInstance().getDriverId())).add("order_id", "").add("timestamp", Long.valueOf(System.currentTimeMillis())).add(OmegaTraceEvent.CommentParamNames.TRIP_STEP, -1).report();
            DLog.m20371d("MapSettingNavigationActivity", "map_pub_navi_trafficbar_setting_ck reported" + this.f28975l);
        }
        super.onDestroy();
    }

    /* renamed from: a */
    private void m20379a() {
        if (this.mPreferences != null) {
            boolean inAppNavVoiceOpen = this.mPreferences.getInAppNavVoiceOpen();
            this.f28968e = inAppNavVoiceOpen;
            this.f28970g.setSelected(inAppNavVoiceOpen);
        }
        this.f28970g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                view.setSelected(!view.isSelected());
                if (MapSettingNavigationActivity.this.mPreferences != null) {
                    MapSettingNavigationActivity.this.mPreferences.setInAppNavVoiceOpen(view.isSelected());
                }
            }
        });
    }

    /* renamed from: b */
    private void m20383b() {
        if (this.mPreferences != null) {
            boolean navDefaultOpen = this.mPreferences.getNavDefaultOpen();
            this.f28967d = navDefaultOpen;
            this.f28965b.setSelected(navDefaultOpen);
        }
        this.f28965b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                view.setSelected(!view.isSelected());
                if (MapSettingNavigationActivity.this.mPreferences != null) {
                    MapSettingNavigationActivity.this.mPreferences.setNavDefaultOpen(view.isSelected());
                }
            }
        });
    }

    /* renamed from: c */
    private void m20385c() {
        if (this.mPreferences == null || !this.mPreferences.getNavRemember()) {
            m20381a("");
            return;
        }
        String navSelectedPath = this.mPreferences.getNavSelectedPath();
        List<MapSettingAppInfo> list = this.f28966c;
        if (list == null || list.isEmpty()) {
            m20381a("");
        } else {
            m20381a(navSelectedPath);
        }
    }

    /* renamed from: d */
    private void m20387d() {
        if (this.mPreferences != null) {
            boolean shouldShowTrafficStatusBar = this.mPreferences.getShouldShowTrafficStatusBar();
            this.f28974k = shouldShowTrafficStatusBar;
            this.f28975l = shouldShowTrafficStatusBar;
            this.f28973j.setSelected(shouldShowTrafficStatusBar);
        }
        this.f28973j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MapSettingNavigationActivity.this.m20380a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m20380a(View view) {
        view.setSelected(!view.isSelected());
        if (this.mPreferences != null) {
            this.f28975l = view.isSelected();
            this.mPreferences.setShouldShowTrafficStatusBar(this.f28975l);
        }
    }

    /* renamed from: a */
    private void m20381a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f28964a.setVisibility(0);
            if (MapSettingNavConstant.LOCAL_GOOGLE_NAVI.equalsIgnoreCase(str)) {
                this.f28964a.setText(getString(R.string.map_setting_navigation_build_in));
                return;
            }
            String isContainPath = MapSettingUtils.isContainPath(this.f28966c, str);
            if (!TextUtils.isEmpty(isContainPath)) {
                this.f28964a.setText(isContainPath);
            } else {
                this.f28964a.setText("");
            }
        } else {
            this.f28964a.setVisibility(4);
        }
    }
}
