package com.google.android.gms.ads.mediation;

import android.os.Bundle;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface MediationAdapter extends MediationExtrasReceiver {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public static class zza {
        private int zzewy;

        public final zza zzed(int i) {
            this.zzewy = 1;
            return this;
        }

        public final Bundle zzafn() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzewy);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
