package com.didi.map.setting.global;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingFactory;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.map.setting.common.MapSettingNavInfo;
import com.didi.map.setting.common.MapSettingOmega;
import com.didi.map.setting.common.MapSettingViewUtils;
import com.didi.map.setting.common.apollo.MapSettingApolloUtil;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.didi.map.setting.global.NavListView;
import com.didi.map.setting.global.diversion.NavDiversionPloyImpl;
import com.didi.map.setting.widget.SimpleDialog;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class MapSettingWindowView implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IMapSettingPreferences f28994a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f28995b;

    /* renamed from: c */
    private NavListView f28996c;

    /* renamed from: d */
    private List<MapSettingAppInfo> f28997d;

    /* renamed from: e */
    private ImageView f28998e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f28999f;

    /* renamed from: g */
    private FrameLayout f29000g;

    /* renamed from: h */
    private ViewStub f29001h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Context f29002i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public MapSettingNavInfo f29003j;

    /* renamed from: k */
    private View f29004k;

    /* renamed from: l */
    private SimpleDialog f29005l;

    /* renamed from: m */
    private BroadcastReceiver f29006m = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equalsIgnoreCase(MapSettingNavConstant.BROAD_CAST_TAG)) {
                MapSettingWindowView.this.hide();
            }
        }
    };

    public MapSettingWindowView(Context context) {
        this.f29002i = context;
        this.f28994a = MapSettingFactory.createMapPreferences(context);
    }

    public void setParentView(ViewGroup viewGroup) {
        this.f28995b = viewGroup;
    }

    public void setNavInfo(MapSettingNavInfo mapSettingNavInfo) {
        this.f29003j = mapSettingNavInfo;
    }

    public void show() {
        show(false, true);
    }

    public void show(boolean z) {
        show(z, false);
    }

    public void show(final boolean z, final boolean z2) {
        if (this.f29004k == null && this.f28995b != null) {
            DLog.m20371d("showNavList", new Object[0]);
            this.f29004k = LayoutInflater.from(this.f28995b.getContext()).inflate(R.layout.map_setting_window_view_layout, (ViewGroup) null);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.f28999f = this.f28994a.getNavRemember();
            ViewStub viewStub = (ViewStub) this.f29004k.findViewById(R.id.map_setting_window_title);
            this.f29001h = viewStub;
            viewStub.setLayoutResource(R.layout.map_setting_window_title_one);
            this.f29001h.inflate();
            ImageView imageView = (ImageView) this.f29004k.findViewById(R.id.map_setting_view_remember_nav);
            this.f28998e = imageView;
            imageView.setOnClickListener(this);
            RelativeLayout relativeLayout = (RelativeLayout) this.f29004k.findViewById(R.id.map_setting_remember_container);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.f29004k.findViewById(R.id.map_setting_title_container);
            if (z) {
                relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, MapSettingViewUtils.dp2px(this.f28995b.getContext(), 60.0f)));
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, MapSettingViewUtils.dp2px(this.f28995b.getContext(), 60.0f)));
                relativeLayout.setVisibility(8);
            } else {
                relativeLayout.setVisibility(0);
            }
            this.f28996c = (NavListView) this.f29004k.findViewById(R.id.nav_list);
            this.f29000g = (FrameLayout) this.f29004k.findViewById(R.id.map_setting_window_close);
            this.f29004k.findViewById(R.id.shade_view).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    MapSettingWindowView.this.hide();
                }
            });
            List<MapSettingAppInfo> installedThirdNav = MapSettingNavUtils.getInstalledThirdNav(this.f29002i, z);
            this.f28997d = installedThirdNav;
            if (installedThirdNav == null || !installedThirdNav.isEmpty()) {
                String navSelectedPath = this.f28994a.getNavSelectedPath();
                if (!z && this.f28999f && !TextUtils.isEmpty(navSelectedPath) && !MapSettingUtils.isContainMap(this.f28997d, navSelectedPath)) {
                    this.f28994a.setNavRemember(false);
                    this.f28994a.setNavSelectedPath("");
                    this.f28999f = false;
                }
                NavListView navListView = this.f28996c;
                List<MapSettingAppInfo> list = this.f28997d;
                MapSettingNavInfo mapSettingNavInfo = this.f29003j;
                navListView.initListData(list, mapSettingNavInfo != null && mapSettingNavInfo.needDiversion);
                this.f28996c.setOnItemClickListener(new NavListView.OnItemClickListener() {
                    public void onItemClick(final MapSettingAppInfo mapSettingAppInfo, int i) {
                        if (mapSettingAppInfo != null) {
                            boolean z = false;
                            if (MapSettingNavConstant.LOCAL_GOOGLE_NAVI.equals(mapSettingAppInfo.pkgName) || MapSettingUtils.isInstalledApp(MapSettingWindowView.this.f29002i, mapSettingAppInfo.pkgName)) {
                                if (MapSettingWindowView.this.f29003j != null && MapSettingWindowView.this.f28999f && z2) {
                                    MapSettingWindowView.this.f28994a.setNavRemember(true);
                                    MapSettingWindowView.this.f28994a.setNavSelectedPath(mapSettingAppInfo.pkgName);
                                    TraceEvent.trackRememberNav(true, mapSettingAppInfo.pkgName, MapSettingWindowView.this.f29003j.isHawaii);
                                }
                                if (!z && MapSettingApolloUtil.isAutoOpenNav() && MapSettingWindowView.this.f28994a != null && !TextUtils.isEmpty(mapSettingAppInfo.pkgName) && !MapSettingWindowView.this.f28994a.hasUserSettingNav()) {
                                    if (mapSettingAppInfo.pkgName.equals(MapSettingWindowView.this.f28994a.getLastSelectedNav())) {
                                        MapSettingWindowView.this.f28994a.setNavRemember(true);
                                        MapSettingWindowView.this.f28994a.setNavSelectedPath(mapSettingAppInfo.pkgName);
                                        MapSettingWindowView.this.f28994a.setLastSelectedNav("");
                                        String str = mapSettingAppInfo.pkgName;
                                        if (MapSettingWindowView.this.f29003j != null && MapSettingWindowView.this.f29003j.isHawaii) {
                                            z = true;
                                        }
                                        TraceEvent.trackRememberNav(true, str, z);
                                    } else {
                                        MapSettingWindowView.this.f28994a.setLastSelectedNav(mapSettingAppInfo.pkgName);
                                    }
                                }
                                if (MapSettingNavConstant.YANDEX_MAP.equals(mapSettingAppInfo.pkgName) || (!MapSettingApolloUtil.isShowYandexNavTimes() && MapSettingNavConstant.YANDEX_NAV.equals(mapSettingAppInfo.pkgName))) {
                                    YandexTipsView yandexTipsView = new YandexTipsView(MapSettingWindowView.this.f29002i);
                                    yandexTipsView.setParentView(MapSettingWindowView.this.f28995b);
                                    if (yandexTipsView.show(mapSettingAppInfo.pkgName)) {
                                        yandexTipsView.setOkClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                AutoTrackHelper.trackViewOnClick(view);
                                                MapSettingWindowView.this.m20413a(mapSettingAppInfo);
                                            }
                                        });
                                        MapSettingWindowView.this.hide();
                                        return;
                                    }
                                }
                                MapSettingWindowView.this.hide();
                                MapSettingWindowView.this.m20413a(mapSettingAppInfo);
                                return;
                            }
                            SystemUtils.showToast(Toast.makeText(MapSettingWindowView.this.f29002i, R.string.map_setting_nav_not_install, 0));
                            MapSettingWindowView.this.hide();
                        }
                    }
                });
                this.f29000g.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        MapSettingOmega.add("map_gd_maplist_close_ck").report();
                        MapSettingWindowView.this.hide();
                    }
                });
                LocalBroadcastManager.getInstance(this.f29002i).registerReceiver(this.f29006m, new IntentFilter(MapSettingNavConstant.BROAD_CAST_TAG));
                IMapSettingPreferences iMapSettingPreferences = this.f28994a;
                if (iMapSettingPreferences != null) {
                    iMapSettingPreferences.setWindowShow(true);
                }
                Activity a = m20410a((View) this.f28995b);
                if (a != null) {
                    this.f29004k.setBackgroundColor(0);
                    SimpleDialog simpleDialog = new SimpleDialog(a);
                    this.f29005l = simpleDialog;
                    simpleDialog.setCancelable(true);
                    this.f29005l.setCanceledOnTouchOutside(false);
                    this.f29005l.setContentView(this.f29004k);
                    this.f29005l.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            MapSettingWindowView.this.m20412a(dialogInterface);
                        }
                    });
                    SystemUtils.showDialog(this.f29005l);
                    return;
                }
                this.f28995b.addView(this.f29004k, layoutParams);
                this.f29004k.bringToFront();
                return;
            }
            MapSettingTipActivity.startMapSettingTipActivity(this.f29002i);
            if (this.f28999f && z) {
                this.f28994a.setNavRemember(false);
                this.f28999f = false;
            }
            hide();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m20412a(DialogInterface dialogInterface) {
        if (this.f29005l != null) {
            hide();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20413a(MapSettingAppInfo mapSettingAppInfo) {
        Intent intent;
        MapSettingNavInfo mapSettingNavInfo = this.f29003j;
        if (mapSettingNavInfo == null || !mapSettingNavInfo.isOutNav) {
            intent = new Intent(MapSettingNavConstant.BROAD_SELECTED_NAV_TAG);
        } else {
            intent = new Intent(MapSettingNavConstant.BROAD_SELECTED_OUT_NAV_TAG);
        }
        MapSettingNavInfo mapSettingNavInfo2 = this.f29003j;
        if (!(mapSettingNavInfo2 == null || mapSettingAppInfo == null)) {
            mapSettingNavInfo2.navPath = mapSettingAppInfo.pkgName;
        }
        intent.putExtra(MapSettingNavConstant.SETTING_NAV_SELECTED_KEY, this.f29003j);
        LocalBroadcastManager.getInstance(this.f29002i).sendBroadcast(intent);
        if (mapSettingAppInfo != null) {
            String str = mapSettingAppInfo.navType;
            if (TextUtils.isEmpty(str)) {
                str = MapSettingNavUtils.getNavTypeByPkgName(mapSettingAppInfo.pkgName);
            }
            NavDiversionPloyImpl.newInstance(this.f29002i).startNav(str);
        }
    }

    /* renamed from: a */
    private Activity m20410a(View view) {
        for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            Context context = ((ViewGroup) parent).getContext();
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public void hide() {
        DLog.m20371d("hideNavList  Dialog = " + this.f29005l, new Object[0]);
        Context context = this.f29002i;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f29006m);
        }
        try {
            if (!(this.f28995b == null || this.f29004k == null)) {
                this.f28995b.removeView(this.f29004k);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        IMapSettingPreferences iMapSettingPreferences = this.f28994a;
        if (iMapSettingPreferences != null) {
            iMapSettingPreferences.setWindowShow(false);
        }
        try {
            if (this.f29005l != null) {
                this.f29005l.dismiss();
                this.f29005l = null;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f29004k = null;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.map_setting_view_remember_nav) {
            boolean z = !this.f28999f;
            this.f28999f = z;
            if (z) {
                this.f28998e.setImageResource(R.drawable.map_setting_switch_on);
            } else {
                this.f28998e.setImageResource(R.drawable.map_setting_switch_off);
            }
        }
    }
}
