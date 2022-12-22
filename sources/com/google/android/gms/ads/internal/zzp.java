package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzei;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzp extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzl zzbqf;

    private zzp(zzl zzl) {
        this.zzbqf = zzl;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            zzei unused = this.zzbqf.zzbqd = (zzei) this.zzbqf.zzbpz.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzbao.zzd("", e);
        }
        return this.zzbqf.zzkp();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.zzbqf.zzbqb != null && str != null) {
            this.zzbqf.zzbqb.loadUrl(str);
        }
    }

    /* synthetic */ zzp(zzl zzl, zzo zzo) {
        this(zzl);
    }
}
