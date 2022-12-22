package com.didi.sdk.app;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.rfusion.config.RFLocale;
import com.didi.sdk.lawpop.LawPreposeDialogHelper;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.sdk.util.ApkUtils;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.GlobalCountryCode;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didiglobal.privacy.disclosure.PositiveResultReason;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureLocalManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.didiglobal.privacy.disclosure.param.GlobalPassenger99InitParam;
import com.didiglobal.privacy.disclosure.param.GlobalPassengerGlobalInitParam;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DidiLoadDexActivity extends DidiLoadBaseDexActivity {
    public static final String PARAM_LOCATION_ALLOW = "is_location_allow";

    /* renamed from: b */
    private static final int f35171b = 201;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String[] f35172c = {Permission.ACCESS_FINE_LOCATION, Permission.READ_PHONE_STATE};

    /* renamed from: d */
    private AlertDialog.Builder f35173d = null;

    /* renamed from: e */
    private Locale f35174e;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
    }

    /* access modifiers changed from: protected */
    public boolean requestLawAgreement() {
        String countryIsoCodeFromDevice = LawPreposeDialogHelper.getCountryIsoCodeFromDevice();
        if (!LawPreposeDialogHelper.isNeedShowPreposeDialog(this, countryIsoCodeFromDevice)) {
            return true;
        }
        m24854a(countryIsoCodeFromDevice);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean requestPrivacyDisclosure() {
        m24857b();
        m24851a();
        if (PrivacyDisclosureLocalManager.getInstance().isNeedOpenPrivacyDisclosureDialog(this, PrivacyTypeEnum.LOCATION)) {
            PrivacyDisclosureLocalManager.getInstance().openPrivacyDisclosureDialog(this, PrivacyTypeEnum.LOCATION, new PrivacyDisclosureBaseDialog.Callback() {
                public void onPositiveResult(PositiveResultReason positiveResultReason) {
                    DidiLoadDexActivity.this.m24858c();
                    DidiLoadDexActivity.this.startSplashActivity(false, false);
                }

                public void onNegativeResult() {
                    DidiLoadDexActivity.this.m24858c();
                    String[] unused = DidiLoadDexActivity.this.f35172c = new String[]{Permission.READ_PHONE_STATE};
                    Log.d("DidiLoadBaseDexActivity", "PrivacyDisclosure location access denied");
                    DidiLoadDexActivity.this.startSplashActivity(false, false);
                }
            });
            return false;
        }
        m24858c();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean requestPermissions() {
        if (PermissionUtil.checkPermissionAllGranted((Context) this, this.f35172c)) {
            return true;
        }
        PermissionUtil.requestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                Log.d("DidiLoadBaseDexActivity", "isAllGranted:" + z);
                int i = 0;
                if (!z && strArr != null && strArr.length > 0) {
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (Permission.ACCESS_FINE_LOCATION.equals(strArr[i2])) {
                            Log.d("DidiLoadBaseDexActivity", "location access denied");
                            break;
                        } else {
                            i2++;
                        }
                    }
                    DidiLoadDexActivity.this.m24855a(z, strArr, i);
                    DidiLoadDexActivity.this.toSplashActivity(i);
                }
                i = 1;
                DidiLoadDexActivity.this.m24855a(z, strArr, i);
                DidiLoadDexActivity.this.toSplashActivity(i);
            }
        }, this.f35172c, false);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24855a(boolean z, String[] strArr, int i) {
        if (z) {
            HashMap hashMap = new HashMap();
            hashMap.put("action", 1);
            hashMap.put("type", 0);
            GlobalOmegaUtils.trackEvent("map_loc_permission_ck", hashMap);
        } else if (i == 0) {
            HashMap hashMap2 = new HashMap();
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Permission.ACCESS_FINE_LOCATION)) {
                hashMap2.put("action", 0);
            } else {
                hashMap2.put("action", -1);
            }
            hashMap2.put("type", 0);
            GlobalOmegaUtils.trackEvent("map_loc_permission_ck", hashMap2);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 201) {
            startSplashActivity(0);
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void toSplashActivity(int i) {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.putExtra(PARAM_LOCATION_ALLOW, i);
        intent.setComponent(new ComponentName(this, "com.didi.sdk.splash.SplashActivity"));
        startActivity(intent);
        finish();
    }

    /* renamed from: a */
    private void m24854a(String str) {
        Configuration b = m24857b();
        LawPreposeDialogHelper.showPreposeDialog(this, str, b.locale.getLanguage() + "-" + b.locale.getCountry(), new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DidiLoadDexActivity.this.m24858c();
                DidiLoadDexActivity.this.startSplashActivity(false, true);
            }
        }, new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DidiLoadDexActivity.this.finish();
            }
        });
    }

    /* renamed from: a */
    private void m24851a() {
        if (AppUtils.isBrazilApp(this)) {
            PrivacyDisclosureLocalManager.init(new GlobalPassenger99InitParam() {
                public int getAppId() {
                    return AppUtils.getAppId(DidiLoadDexActivity.this);
                }

                public Map<String, String> getPrivacyTypeIdDescMap() {
                    HashMap hashMap = new HashMap();
                    String typeId = PrivacyTypeEnum.LOCATION.getTypeId();
                    DidiLoadDexActivity didiLoadDexActivity = DidiLoadDexActivity.this;
                    hashMap.put(typeId, didiLoadDexActivity.getString(R.string.GRider_transformation_The_DiDi_aLxC, new Object[]{ApkUtils.getAppName(didiLoadDexActivity)}));
                    return hashMap;
                }
            });
        } else {
            PrivacyDisclosureLocalManager.init(new GlobalPassengerGlobalInitParam() {
                public int getAppId() {
                    return AppUtils.getAppId(DidiLoadDexActivity.this);
                }

                public Map<String, String> getPrivacyTypeIdDescMap() {
                    HashMap hashMap = new HashMap();
                    String typeId = PrivacyTypeEnum.LOCATION.getTypeId();
                    DidiLoadDexActivity didiLoadDexActivity = DidiLoadDexActivity.this;
                    hashMap.put(typeId, didiLoadDexActivity.getString(R.string.GRider_transformation_The_DiDi_aLxC, new Object[]{ApkUtils.getAppName(didiLoadDexActivity)}));
                    return hashMap;
                }
            });
        }
    }

    /* renamed from: b */
    private Configuration m24857b() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f35174e = LocaleList.getDefault().get(0);
        } else {
            this.f35174e = Locale.getDefault();
        }
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        if (AppUtils.isBrazilApp(this)) {
            if ("pt".equals(this.f35174e.getLanguage())) {
                configuration.locale = new Locale("pt", "BR");
            } else {
                configuration.locale = new Locale("en", GlobalCountryCode.AMERICA);
            }
        } else if ("en".equals(this.f35174e.getLanguage())) {
            if ("AU".equals(this.f35174e.getCountry()) || GlobalCountryCode.ENGLAND.equals(this.f35174e.getCountry()) || HistoryRecordFragment.COUNTRY_CODE_NZ.equals(this.f35174e.getCountry()) || HistoryRecordFragment.COUNTRY_CODE_ZA.equals(this.f35174e.getCountry())) {
                configuration.locale = new Locale("en", "AU");
            } else {
                configuration.locale = new Locale("en", GlobalCountryCode.AMERICA);
            }
        } else if ("pt".equals(this.f35174e.getLanguage())) {
            configuration.locale = new Locale("en", GlobalCountryCode.AMERICA);
        } else if (RFLocale.CHINESE.equals(this.f35174e.getLanguage())) {
            configuration.locale = new Locale("en", GlobalCountryCode.AMERICA);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return configuration;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m24858c() {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = this.f35174e;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
