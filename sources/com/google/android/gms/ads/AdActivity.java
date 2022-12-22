package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzash;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzash zzacs;

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        zzash zzb = zzww.zzqx().zzb((Activity) this);
        this.zzacs = zzb;
        if (zzb == null) {
            zzbao.zze("#007 Could not call remote method.", (Throwable) null);
            finish();
            return;
        }
        try {
            zzb.onCreate(bundle);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            if (this.zzacs != null) {
                this.zzacs.onRestart();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            if (this.zzacs != null) {
                this.zzacs.onStart();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            if (this.zzacs != null) {
                this.zzacs.onUserLeaveHint();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            if (this.zzacs != null) {
                this.zzacs.onResume();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            if (this.zzacs != null) {
                this.zzacs.onPause();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzacs != null) {
                this.zzacs.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            if (this.zzacs != null) {
                this.zzacs.onStop();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            if (this.zzacs != null) {
                this.zzacs.onDestroy();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    private final void zzdq() {
        zzash zzash = this.zzacs;
        if (zzash != null) {
            try {
                zzash.zzdq();
            } catch (RemoteException e) {
                zzbao.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zzdq();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        zzdq();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzdq();
    }

    public final void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzacs != null) {
                z = this.zzacs.zzwh();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
            try {
                if (this.zzacs != null) {
                    this.zzacs.onBackPressed();
                }
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.zzacs != null) {
                this.zzacs.onActivityResult(i, i2, intent);
            }
        } catch (Exception e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            if (this.zzacs != null) {
                this.zzacs.zzae(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }
}
