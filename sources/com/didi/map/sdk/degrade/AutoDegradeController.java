package com.didi.map.sdk.degrade;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.map.sdk.navtracker.TrackerPreference;
import com.didi.map.sdk.navtracker.log.DLog;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AutoDegradeController {

    /* renamed from: a */
    private static String f28078a = "sp_map_degrade";

    /* renamed from: b */
    private static String f28079b = "sp_map_degrade_data_didi";

    /* renamed from: c */
    private static String f28080c = "sp_map_degrade_data_google";

    /* renamed from: d */
    private static AutoDegradeController f28081d;

    /* renamed from: e */
    private Context f28082e;

    /* renamed from: f */
    private ApolloGetter f28083f = ApolloGetter.get();

    /* renamed from: g */
    private boolean f28084g;

    /* renamed from: h */
    private ICrashMonitor f28085h;

    /* renamed from: i */
    private DegradeCacheData f28086i;

    /* renamed from: j */
    private DegradeMode f28087j = DegradeMode.GOOGLE;

    private AutoDegradeController(Context context) {
        this.f28082e = context.getApplicationContext();
        if (this.f28083f != null) {
            DLog.m20199d("ccc", "mApolloGetter:" + this.f28083f.toString(), new Object[0]);
            return;
        }
        DLog.m20199d("ccc", "mApolloGetter is null, break", new Object[0]);
    }

    public static AutoDegradeController getInstance(Context context) {
        if (f28081d == null) {
            synchronized (AutoDegradeController.class) {
                if (f28081d == null) {
                    f28081d = new AutoDegradeController(context);
                }
            }
        }
        return f28081d;
    }

    public ApolloGetter getApolloGetter() {
        return this.f28083f;
    }

    public boolean isNeedDegradeToLaunch(DegradeMode degradeMode) {
        long j;
        long j2;
        if (this.f28083f == null) {
            DLog.m20199d("ccc", "mApolloGetter is null return false", new Object[0]);
            return false;
        }
        DLog.m20199d("ccc", "isNeedDegradeToLaunch:" + degradeMode.toString(), new Object[0]);
        this.f28087j = degradeMode;
        String str = "";
        if (degradeMode == DegradeMode.DIDI) {
            str = SystemUtils.getSharedPreferences(this.f28082e, f28078a, 0).getString(f28079b, str);
        } else if (degradeMode == DegradeMode.GOOGLE) {
            str = SystemUtils.getSharedPreferences(this.f28082e, f28078a, 0).getString(f28080c, str);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                DegradeCacheData degradeCacheData = (DegradeCacheData) new Gson().fromJson(str, DegradeCacheData.class);
                this.f28086i = degradeCacheData;
                degradeCacheData.doLog();
                if (this.f28083f.valid_time != -1) {
                    j = this.f28086i.createTime;
                    j2 = (long) (this.f28083f.valid_time * 1000);
                } else {
                    j = this.f28086i.createTime;
                    j2 = this.f28086i.validTime * 1000 * 60 * 10;
                }
                long j3 = j + j2;
                if (this.f28086i.tag && j3 > System.currentTimeMillis()) {
                    return true;
                }
                if (this.f28086i.tag && j3 <= System.currentTimeMillis()) {
                    DLog.m20199d("ccc", "isNeedDegrade: 恢复", new Object[0]);
                    m19957a();
                }
            } catch (Exception e) {
                DLog.m20199d("ccc", "isNeedDegrade: " + e.toString(), new Object[0]);
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m19957a() {
        if (this.f28082e != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("time", Long.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put("app_name", this.f28082e.getPackageName());
            hashMap.put("os", 1);
            hashMap.put("phone_num", TrackerPreference.getPhoneNum(this.f28082e));
            hashMap.put("country_code", TrackerPreference.getCountryCode(this.f28082e));
            hashMap.put("app_version", TrackerPreference.getAppVersion(this.f28082e));
            hashMap.put("user_id", TrackerPreference.getUserId(this.f28082e));
            OmegaSDKAdapter.trackEvent("tech_global_map_degrade_stop", (Map<String, Object>) hashMap);
            DLog.m20199d("ccc", "triggered tech_global_map_degrade_stop", new Object[0]);
        }
    }

    public void onAppLaunched(DegradeMode degradeMode) {
        DegradeCacheData degradeCacheData;
        DLog.m20199d("ccc", "onAppLaunched", new Object[0]);
        if (this.f28083f == null) {
            DLog.m20199d("ccc", "onAppLaunched but apollo is null", new Object[0]);
        } else if (this.f28087j == DegradeMode.GOOGLE && this.f28083f.down_gmap_mode != 1) {
            DLog.m20199d("ccc", "onAppLaunched but GoogleMap should not auto degrade", new Object[0]);
        } else if (this.f28087j != DegradeMode.DIDI || this.f28083f.down_dmap_mode == 1) {
            if (!this.f28084g && this.f28087j == degradeMode && (degradeCacheData = this.f28086i) != null) {
                if (degradeCacheData.launch_near_time != -1) {
                    this.f28086i.list = null;
                    this.f28086i.validTime = -1;
                    this.f28086i.createTime = -1;
                    this.f28086i.tag = false;
                    this.f28086i.count = 0;
                }
                this.f28086i.launch_near_time = System.currentTimeMillis();
                SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f28082e, f28078a, 0).edit();
                DLog.m20199d("ccc", "onAppLaunched-doLog", new Object[0]);
                this.f28086i.doLog();
                if (this.f28087j == DegradeMode.DIDI) {
                    edit.putString(f28079b, new Gson().toJson((Object) this.f28086i));
                } else if (this.f28087j == DegradeMode.GOOGLE) {
                    edit.putString(f28080c, new Gson().toJson((Object) this.f28086i));
                }
                edit.apply();
            }
            this.f28084g = true;
            if (this.f28087j == degradeMode) {
                m19959b();
            }
        } else {
            DLog.m20199d("ccc", "onAppLaunched but DDMap should not auto degrade", new Object[0]);
        }
    }

    public boolean isDebug(Context context) {
        return (context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    /* renamed from: b */
    private void m19959b() {
        Context context;
        if (this.f28084g && (context = this.f28082e) != null) {
            if (this.f28085h == null) {
                this.f28085h = CrashMonitorFactory.create(context);
            }
            this.f28085h.start(new ICrashListener() {
                public final void onCrashed(String str) {
                    AutoDegradeController.this.m19958a(str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m19958a(String str) {
        if (this.f28083f == null) {
            DLog.m20199d("ccc", "mApolloGetter is null and do not monitor", new Object[0]);
            return;
        }
        if (this.f28086i == null) {
            this.f28086i = new DegradeCacheData();
        }
        DLog.m20199d("ccc", "startCrashMonitor---1 reason:" + str, new Object[0]);
        this.f28086i.launch_near_time = -1;
        if (this.f28086i.list == null) {
            this.f28086i.list = new ArrayList();
        }
        this.f28086i.list.add(new CrashDetail(System.currentTimeMillis(), str));
        DLog.m20199d("ccc", "startCrashMonitor---2 crash item size: " + this.f28086i.list.size(), new Object[0]);
        int i = 0;
        for (int size = this.f28086i.list.size() - 1; size >= 0; size--) {
            DLog.m20199d("ccc", "startCrashMonitor---3", new Object[0]);
            CrashDetail crashDetail = this.f28086i.list.get(size);
            if (crashDetail != null) {
                if (System.currentTimeMillis() - crashDetail.time > ((long) (this.f28083f.time_range * 1000))) {
                    this.f28086i.list.remove(crashDetail);
                    DLog.m20199d("ccc", "startCrashMonitor---4", new Object[0]);
                } else if (!TextUtils.isEmpty(this.f28083f.key)) {
                    DLog.m20199d("ccc", "startCrashMonitor---5", new Object[0]);
                    if (!TextUtils.isEmpty(crashDetail.stack)) {
                        DLog.m20199d("ccc", "startCrashMonitor---6", new Object[0]);
                        if (crashDetail.stack.contains(this.f28083f.key)) {
                            DLog.m20199d("ccc", "startCrashMonitor---7", new Object[0]);
                            i++;
                        }
                    }
                } else {
                    DLog.m20199d("ccc", "startCrashMonitor---8", new Object[0]);
                }
            }
        }
        DLog.m20199d("ccc", "count =" + i, new Object[0]);
        if (i >= this.f28083f.crash_count) {
            DLog.m20199d("ccc", "startCrashMonitor---9", new Object[0]);
            this.f28086i.list = null;
            this.f28086i.tag = true;
            this.f28086i.count++;
            this.f28086i.createTime = System.currentTimeMillis();
            DegradeCacheData degradeCacheData = this.f28086i;
            degradeCacheData.validTime = (long) (degradeCacheData.count * 2);
        }
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f28082e, f28078a, 0).edit();
        DLog.m20199d("ccc", "startCrashMonitor--11", new Object[0]);
        this.f28086i.doLog();
        if (this.f28087j == DegradeMode.DIDI) {
            edit.putString(f28079b, new Gson().toJson((Object) this.f28086i));
        } else if (this.f28087j == DegradeMode.GOOGLE) {
            edit.putString(f28080c, new Gson().toJson((Object) this.f28086i));
        }
        edit.commit();
    }

    public void clearAllCachedData(DegradeMode degradeMode) {
        try {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f28082e, f28078a, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (degradeMode == DegradeMode.DIDI) {
                    edit.putString(f28079b, "").apply();
                } else if (degradeMode == DegradeMode.GOOGLE) {
                    edit.putString(f28080c, "").apply();
                }
                DLog.m20199d("ccc", "all data delete", new Object[0]);
            }
        } catch (Exception unused) {
        }
    }
}
