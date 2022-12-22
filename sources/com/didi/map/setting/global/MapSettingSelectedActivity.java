package com.didi.map.setting.global;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingBaseActivity;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.didi.map.setting.global.MapSettingSelectedView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class MapSettingSelectedActivity extends MapSettingBaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MapSettingSelectedView f28976a;

    /* renamed from: b */
    private ImageView f28977b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<MapSettingAppInfo> f28978c;

    protected static void startSelectedActivity(MapSettingNavigationActivity mapSettingNavigationActivity) {
        DLog.m20371d("showSettingPage2", new Object[0]);
        mapSettingNavigationActivity.startActivity(new Intent(mapSettingNavigationActivity, MapSettingSelectedActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.map_setting_selected_layout);
        findViewById(R.id.map_setting_title_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapSettingSelectedActivity.this.onBackPressed();
            }
        });
        ((TextView) findViewById(R.id.map_setting_title_text)).setText(getResources().getString(R.string.map_setting_selected_title));
        this.f28976a = (MapSettingSelectedView) findViewById(R.id.map_setting_nav_selected_group);
        ImageView imageView = (ImageView) findViewById(R.id.map_setting_remember_nav);
        this.f28977b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (MapSettingSelectedActivity.this.f28978c == null || !MapSettingSelectedActivity.this.f28978c.isEmpty()) {
                    view.setSelected(!view.isSelected());
                    if (!view.isSelected()) {
                        TraceEvent.trackRememberNav(false, "", false);
                    }
                    if (MapSettingSelectedActivity.this.mPreferences != null) {
                        MapSettingSelectedActivity.this.mPreferences.setNavRemember(view.isSelected());
                    }
                    MapSettingSelectedActivity.this.f28976a.rememberChange(view.isSelected());
                    return;
                }
                MapSettingTipActivity.startMapSettingTipActivity(MapSettingSelectedActivity.this);
                if (MapSettingSelectedActivity.this.mPreferences != null) {
                    MapSettingSelectedActivity.this.mPreferences.setNavRemember(false);
                }
                view.setSelected(false);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f28978c = MapSettingNavUtils.getInstalledThirdNav(this);
        boolean navRemember = this.mPreferences.getNavRemember();
        List<MapSettingAppInfo> list = this.f28978c;
        if (list == null || list.isEmpty()) {
            this.f28977b.setSelected(false);
            if (this.mPreferences != null && navRemember) {
                this.mPreferences.setNavRemember(false);
            }
        } else if (this.mPreferences != null && TextUtils.isEmpty(this.mPreferences.getNavSelectedPath()) && navRemember) {
            this.f28977b.setSelected(false);
            this.mPreferences.setNavRemember(false);
        } else if (this.mPreferences != null) {
            if (MapSettingUtils.isContainMap(this.f28978c, this.mPreferences.getNavSelectedPath()) || !navRemember) {
                this.f28977b.setSelected(this.mPreferences.getNavRemember());
            } else {
                this.f28977b.setSelected(false);
                this.mPreferences.setNavRemember(false);
                this.mPreferences.setNavSelectedPath("");
            }
        }
        if (this.mPreferences != null) {
            this.f28976a.initListData(this.f28978c, this.mPreferences);
        }
        this.f28976a.setOnItemClickListener(new MapSettingSelectedView.OnItemClickListener() {
            public final void onItemClick(MapSettingAppInfo mapSettingAppInfo, int i) {
                MapSettingSelectedActivity.this.m20389a(mapSettingAppInfo, i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m20389a(MapSettingAppInfo mapSettingAppInfo, int i) {
        if (this.mPreferences != null) {
            this.mPreferences.setNavSelectedPath(mapSettingAppInfo.pkgName);
            TraceEvent.trackRememberNav(true, mapSettingAppInfo.pkgName, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        MapSettingSelectedView mapSettingSelectedView = this.f28976a;
        if (mapSettingSelectedView != null) {
            mapSettingSelectedView.clearData();
            this.f28976a.setOnItemClickListener((MapSettingSelectedView.OnItemClickListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        List<MapSettingAppInfo> list = this.f28978c;
        if (list != null) {
            list.clear();
            this.f28978c = null;
        }
        super.onDestroy();
    }
}
