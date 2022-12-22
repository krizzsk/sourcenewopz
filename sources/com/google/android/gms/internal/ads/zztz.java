package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzuh;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zztz {
    private final zzue zzbwr;
    private final zzuh.zzi.zza zzbws;
    private final boolean zzbwt;

    public static zztz zznl() {
        return new zztz();
    }

    public zztz(zzue zzue) {
        this.zzbws = zzuh.zzi.zzom();
        this.zzbwr = zzue;
        this.zzbwt = ((Boolean) zzww.zzra().zzd(zzabq.zzcwb)).booleanValue();
    }

    private zztz() {
        this.zzbws = zzuh.zzi.zzom();
        this.zzbwt = false;
        this.zzbwr = new zzue();
    }

    public final synchronized void zza(zzub.zza.zzb zzb) {
        if (this.zzbwt) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwc)).booleanValue()) {
                zzc(zzb);
            } else {
                zzb(zzb);
            }
        }
    }

    private final synchronized void zzb(zzub.zza.zzb zzb) {
        this.zzbws.zzoi().zza((Iterable<? extends Long>) zznm());
        this.zzbwr.zzf(((zzuh.zzi) ((zzena) this.zzbws.zzbjv())).toByteArray()).zzby(zzb.zzv()).log();
        String valueOf = String.valueOf(Integer.toString(zzb.zzv(), 10));
        zzd.zzed(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void zzc(zzub.zza.zzb zzb) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = SystemUtils.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzd(zzb).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzd.zzed("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzd.zzed("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzd.zzed("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zzd.zzed("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zzd.zzed("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized String zzd(zzub.zza.zzb zzb) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzbws.zzoh(), Long.valueOf(zzr.zzlc().elapsedRealtime()), Integer.valueOf(zzb.zzv()), Base64.encodeToString(((zzuh.zzi) ((zzena) this.zzbws.zzbjv())).toByteArray(), 3)});
    }

    public final synchronized void zza(zzty zzty) {
        if (this.zzbwt) {
            try {
                zzty.zza(this.zzbws);
            } catch (NullPointerException e) {
                zzr.zzkz().zza(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    private static List<Long> zznm() {
        List<String> zzsj = zzabq.zzsj();
        ArrayList arrayList = new ArrayList();
        for (String split : zzsj) {
            for (String valueOf : split.split(",")) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (NumberFormatException unused) {
                    zzd.zzed("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }
}
