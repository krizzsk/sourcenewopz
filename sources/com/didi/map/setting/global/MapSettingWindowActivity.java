package com.didi.map.setting.global;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingBaseActivity;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.map.setting.common.MapSettingNavInfo;
import com.didi.map.setting.common.MapSettingOmega;
import com.didi.map.setting.common.MapSettingViewUtils;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.didi.map.setting.global.NavListView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class MapSettingWindowActivity extends MapSettingBaseActivity implements View.OnClickListener {

    /* renamed from: a */
    private NavListView f28982a;

    /* renamed from: b */
    private List<MapSettingAppInfo> f28983b;

    /* renamed from: c */
    private FrameLayout f28984c;

    /* renamed from: d */
    private ViewStub f28985d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MapSettingNavInfo f28986e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f28987f;

    /* renamed from: g */
    private ImageView f28988g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f28989h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f28990i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f28991j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f28992k;

    /* renamed from: l */
    private BroadcastReceiver f28993l = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && MapSettingNavConstant.BROAD_CAST_TAG.equalsIgnoreCase(intent.getAction())) {
                MapSettingWindowActivity.this.finish();
            }
        }
    };

    public static void startMapSettingWindowActivity(Context context, MapSettingNavInfo mapSettingNavInfo) {
        try {
            Intent intent = new Intent(context, MapSettingWindowActivity.class);
            intent.putExtra(MapSettingNavConstant.SETTING_NAV_SELECTED_KEY, mapSettingNavInfo);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.map_setting_window_layout);
        this.f28987f = this;
        this.f28990i = findViewById(R.id.map_setting_window_layout);
        View findViewById = findViewById(R.id.yandex_tip_layout);
        this.f28991j = findViewById;
        View findViewById2 = findViewById.findViewById(R.id.yandex_tip_confirm_btn);
        this.f28992k = findViewById2;
        findViewById2.setOnClickListener(this);
        this.f28985d = (ViewStub) findViewById(R.id.map_setting_window_title);
        if (getIntent() != null) {
            this.f28986e = (MapSettingNavInfo) getIntent().getParcelableExtra(MapSettingNavConstant.SETTING_NAV_SELECTED_KEY);
        }
        this.f28985d.setLayoutResource(R.layout.map_setting_window_title_one);
        View inflate = this.f28985d.inflate();
        if (this.mPreferences != null) {
            this.f28989h = this.mPreferences.getNavRemember();
        }
        ImageView imageView = (ImageView) findViewById(R.id.map_setting_view_remember_nav);
        this.f28988g = imageView;
        imageView.setOnClickListener(this);
        this.f28982a = (NavListView) findViewById(R.id.map_setting_window_view);
        this.f28984c = (FrameLayout) findViewById(R.id.map_setting_window_close);
        MapSettingNavInfo mapSettingNavInfo = this.f28986e;
        if (mapSettingNavInfo != null && mapSettingNavInfo.shouldHideRememberNavType) {
            this.f28989h = false;
            if (inflate != null) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.map_setting_remember_container);
                ((RelativeLayout) inflate.findViewById(R.id.map_setting_title_container)).setLayoutParams(new RelativeLayout.LayoutParams(-1, MapSettingViewUtils.dp2px(this, 60.0f)));
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, MapSettingViewUtils.dp2px(this, 60.0f)));
                relativeLayout.setVisibility(8);
            }
        }
        findViewById(R.id.shade_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapSettingWindowActivity.this.onBackPressed();
            }
        });
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f28993l, new IntentFilter(MapSettingNavConstant.BROAD_CAST_TAG));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MapSettingNavInfo mapSettingNavInfo = this.f28986e;
        if (mapSettingNavInfo != null) {
            if (mapSettingNavInfo.shouldExcludeInnerNav) {
                this.f28983b = MapSettingNavUtils.getInstalledThirdNav(this, true);
            } else {
                this.f28983b = MapSettingNavUtils.getInstalledThirdNav(this);
            }
            List<MapSettingAppInfo> list = this.f28983b;
            if (list == null || !list.isEmpty()) {
                String navSelectedPath = this.mPreferences.getNavSelectedPath();
                if (!this.f28986e.shouldExcludeInnerNav && !MapSettingUtils.isContainMap(this.f28983b, navSelectedPath)) {
                    this.mPreferences.setNavRemember(false);
                    this.mPreferences.setNavSelectedPath("");
                }
                this.f28982a.initListData(this.f28983b, false);
                this.f28982a.setOnItemClickListener(new NavListView.OnItemClickListener() {
                    public void onItemClick(MapSettingAppInfo mapSettingAppInfo, int i) {
                        if (mapSettingAppInfo != null) {
                            if (MapSettingNavConstant.LOCAL_GOOGLE_NAVI.equals(mapSettingAppInfo.pkgName) || MapSettingUtils.isInstalledApp(MapSettingWindowActivity.this.f28987f, mapSettingAppInfo.pkgName)) {
                                if (MapSettingWindowActivity.this.f28986e != null && MapSettingWindowActivity.this.f28989h) {
                                    MapSettingWindowActivity.this.mPreferences.setNavRemember(true);
                                    MapSettingWindowActivity.this.mPreferences.setNavSelectedPath(mapSettingAppInfo.pkgName);
                                    TraceEvent.trackRememberNav(true, mapSettingAppInfo.pkgName, MapSettingWindowActivity.this.f28986e.isHawaii);
                                }
                                if (MapSettingNavConstant.YANDEX_MAP.equalsIgnoreCase(mapSettingAppInfo.pkgName)) {
                                    if (!MapSettingWindowActivity.this.mPreferences.hasShowYandexMapTips()) {
                                        MapSettingWindowActivity.this.f28990i.setVisibility(8);
                                        MapSettingWindowActivity.this.f28991j.setVisibility(0);
                                        MapSettingWindowActivity.this.f28992k.setTag(mapSettingAppInfo.pkgName);
                                        MapSettingWindowActivity.this.mPreferences.setShowYandexMapTips(true);
                                        return;
                                    }
                                } else if (MapSettingNavConstant.YANDEX_NAV.equalsIgnoreCase(mapSettingAppInfo.pkgName) && !MapSettingWindowActivity.this.mPreferences.hasShowYandexNavTips()) {
                                    MapSettingWindowActivity.this.f28990i.setVisibility(8);
                                    MapSettingWindowActivity.this.f28991j.setVisibility(0);
                                    MapSettingWindowActivity.this.f28992k.setTag(mapSettingAppInfo.pkgName);
                                    MapSettingWindowActivity.this.mPreferences.setShowYandexNavTips(true);
                                    return;
                                }
                                if (mapSettingAppInfo != null) {
                                    MapSettingWindowActivity.this.m20398a(mapSettingAppInfo.pkgName);
                                    return;
                                }
                                return;
                            }
                            SystemUtils.showToast(Toast.makeText(MapSettingWindowActivity.this.f28987f, R.string.map_setting_nav_not_install, 0));
                            MapSettingWindowActivity.this.onBackPressed();
                        }
                    }
                });
                this.f28984c.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        MapSettingWindowActivity.this.onBackPressed();
                        MapSettingOmega.add("map_gd_maplist_close_ck").report();
                    }
                });
                if (this.mPreferences != null) {
                    this.mPreferences.setWindowShow(true);
                    return;
                }
                return;
            }
            MapSettingTipActivity.startMapSettingTipActivity(this);
            this.mPreferences.setNavRemember(false);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f28993l);
        if (this.mPreferences != null) {
            this.mPreferences.setWindowShow(false);
        }
    }

    public void onBackPressed() {
        if (this.mPreferences != null) {
            this.mPreferences.setWindowShow(false);
        }
        super.onBackPressed();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.map_setting_view_remember_nav) {
            boolean z = !this.f28989h;
            this.f28989h = z;
            if (z) {
                this.f28988g.setImageResource(R.drawable.map_setting_switch_on);
            } else {
                this.f28988g.setImageResource(R.drawable.map_setting_switch_off);
            }
        } else if (view.getId() == R.id.yandex_tip_confirm_btn) {
            m20398a(this.f28992k.getTag().toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20398a(String str) {
        Intent intent;
        MapSettingNavInfo mapSettingNavInfo = this.f28986e;
        if (mapSettingNavInfo == null || !mapSettingNavInfo.isOutNav) {
            intent = new Intent(MapSettingNavConstant.BROAD_SELECTED_NAV_TAG);
        } else {
            intent = new Intent(MapSettingNavConstant.BROAD_SELECTED_OUT_NAV_TAG);
        }
        MapSettingNavInfo mapSettingNavInfo2 = this.f28986e;
        if (mapSettingNavInfo2 != null) {
            mapSettingNavInfo2.navPath = str;
        }
        intent.putExtra(MapSettingNavConstant.SETTING_NAV_SELECTED_KEY, this.f28986e);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        onBackPressed();
    }
}
