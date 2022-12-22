package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzabm implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Object lock = new Object();
    private Bundle metaData = new Bundle();
    private volatile boolean zzcll = false;
    private final ConditionVariable zzcmm = new ConditionVariable();
    /* access modifiers changed from: private */
    public SharedPreferences zzcmn = null;
    private Context zzcmo;
    private JSONObject zzcmp = new JSONObject();
    private volatile boolean zzzq = false;

    public final void initialize(Context context) {
        if (!this.zzzq) {
            synchronized (this.lock) {
                if (!this.zzzq) {
                    if (!this.zzcll) {
                        this.zzcll = true;
                    }
                    Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    this.zzcmo = applicationContext;
                    try {
                        this.metaData = Wrappers.packageManager(applicationContext).getApplicationInfo(this.zzcmo.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (remoteContext == null && context != null) {
                            Context applicationContext2 = context.getApplicationContext();
                            if (applicationContext2 != null) {
                                context = applicationContext2;
                            }
                            remoteContext = context;
                        }
                        if (remoteContext != null) {
                            zzww.zzqy();
                            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(remoteContext, "google_ads_flags", 0);
                            this.zzcmn = sharedPreferences;
                            if (sharedPreferences != null) {
                                sharedPreferences.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzaeb.zza(new zzabr(this));
                            zzsk();
                            this.zzzq = true;
                            this.zzcll = false;
                            this.zzcmm.open();
                        }
                    } finally {
                        this.zzcll = false;
                        this.zzcmm.open();
                    }
                }
            }
        }
    }

    public final <T> T zzd(zzabf<T> zzabf) {
        if (!this.zzcmm.block(5000)) {
            synchronized (this.lock) {
                if (!this.zzcll) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzzq || this.zzcmn == null) {
            synchronized (this.lock) {
                if (this.zzzq) {
                    if (this.zzcmn == null) {
                    }
                }
                T zzsh = zzabf.zzsh();
                return zzsh;
            }
        }
        if (zzabf.getSource() == 2) {
            Bundle bundle = this.metaData;
            if (bundle == null) {
                return zzabf.zzsh();
            }
            return zzabf.zza(bundle);
        } else if (zzabf.getSource() != 1 || !this.zzcmp.has(zzabf.getKey())) {
            return zzbr.zza(new zzabp(this, zzabf));
        } else {
            return zzabf.zzb(this.zzcmp);
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzsk();
        }
    }

    private final void zzsk() {
        if (this.zzcmn != null) {
            try {
                this.zzcmp = new JSONObject((String) zzbr.zza(new zzabo(this)));
            } catch (JSONException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzsl() {
        return this.zzcmn.getString("flag_configuration", "{}");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zze(zzabf zzabf) {
        return zzabf.zza(this.zzcmn);
    }
}
