package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzuh;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcsb {
    private Context context;
    private final zzdtw zzdjf;
    private zzbar zzdvi;
    private final zzf zzeci = zzr.zzkz().zzyl();
    private zzcrl zzgtr;
    private zztz zzgud;
    private final String zzgue;

    public zzcsb(Context context2, zzbar zzbar, zztz zztz, zzcrl zzcrl, String str, zzdtw zzdtw) {
        this.context = context2;
        this.zzdvi = zzbar;
        this.zzgud = zztz;
        this.zzgtr = zzcrl;
        this.zzgue = str;
        this.zzdjf = zzdtw;
    }

    public final void zzbo(boolean z) {
        try {
            this.zzgtr.zza(new zzcsa(this, z));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzd.zzex(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    private static void zza(SQLiteDatabase sQLiteDatabase, ArrayList<zzuh.zzo.zza> arrayList) {
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        long j = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            zzuh.zzo.zza zza = (zzuh.zzo.zza) obj;
            if (zza.zzoz() == zzur.ENUM_TRUE && zza.getTimestamp() > j) {
                j = zza.getTimestamp();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(boolean z, SQLiteDatabase sQLiteDatabase) throws Exception {
        String str;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        if (z) {
            this.context.deleteDatabase("OfflineUpload.db");
            return null;
        }
        int i = 2;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            this.zzdjf.zzb(zzdtx.zzgy("oa_upload").zzw("oa_failed_reqs", String.valueOf(zzcry.zza(sQLiteDatabase2, 0))).zzw("oa_total_reqs", String.valueOf(zzcry.zza(sQLiteDatabase2, 1))).zzw("oa_upload_time", String.valueOf(zzr.zzlc().currentTimeMillis())).zzw("oa_last_successful_time", String.valueOf(zzcry.zzb(sQLiteDatabase2, 2))).zzw("oa_session_id", this.zzeci.zzzn() ? "" : this.zzgue));
            ArrayList<zzuh.zzo.zza> zza = zzcry.zza(sQLiteDatabase);
            zza(sQLiteDatabase2, zza);
            ArrayList arrayList = zza;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                zzuh.zzo.zza zza2 = (zzuh.zzo.zza) obj;
                zzdtx zzgy = zzdtx.zzgy("oa_signals");
                if (this.zzeci.zzzn()) {
                    str = "";
                } else {
                    str = this.zzgue;
                }
                zzdtx zzw = zzgy.zzw("oa_session_id", str);
                zzuh.zzm zzpd = zza2.zzpd();
                zzw.zzw("oa_sig_ts", String.valueOf(zza2.getTimestamp())).zzw("oa_sig_status", String.valueOf(zza2.zzoz().zzv())).zzw("oa_sig_resp_lat", String.valueOf(zza2.zzpa())).zzw("oa_sig_render_lat", String.valueOf(zza2.zzpb())).zzw("oa_sig_formats", zzdzi.zza(zza2.zzpc(), zzcsf.zzebv).toString()).zzw("oa_sig_nw_type", zzpd.zzor() ? String.valueOf(zzpd.zzos().zzv()) : "-1").zzw("oa_sig_wifi", String.valueOf(zza2.zzpe().zzv())).zzw("oa_sig_airplane", String.valueOf(zza2.zzpf().zzv())).zzw("oa_sig_data", String.valueOf(zza2.zzpg().zzv())).zzw("oa_sig_nw_resp", String.valueOf(zza2.zzph())).zzw("oa_sig_offline", String.valueOf(zza2.zzpi().zzv())).zzw("oa_sig_nw_state", String.valueOf(zza2.zzpj().zzv()));
                if (zzpd.zzot() && zzpd.zzor() && zzpd.zzos().equals(zzuh.zzm.zzc.CELL)) {
                    zzw.zzw("oa_sig_cell_type", String.valueOf(zzpd.zzou().zzv()));
                }
                this.zzdjf.zzb(zzw);
            }
        } else {
            ArrayList<zzuh.zzo.zza> zza3 = zzcry.zza(sQLiteDatabase);
            zza(sQLiteDatabase2, zza3);
            this.zzgud.zza((zzty) new zzcsd((zzuh.zzo) ((zzena) zzuh.zzo.zzpm().zzca(this.context.getPackageName()).zzcb(Build.MODEL).zzco(zzcry.zza(sQLiteDatabase2, 0)).zzf(zza3).zzcp(zzcry.zza(sQLiteDatabase2, 1)).zzev(zzr.zzlc().currentTimeMillis()).zzew(zzcry.zzb(sQLiteDatabase2, 2)).zzbjv())));
            zzuh.zzu.zza zzcr = zzuh.zzu.zzpt().zzcq(this.zzdvi.zzeka).zzcr(this.zzdvi.zzekb);
            if (this.zzdvi.zzekc) {
                i = 0;
            }
            this.zzgud.zza((zzty) new zzcsc((zzuh.zzu) ((zzena) zzcr.zzcs(i).zzbjv())));
            this.zzgud.zza(zzub.zza.zzb.OFFLINE_UPLOAD);
        }
        sQLiteDatabase2.delete("offline_signal_contents", (String) null, (String[]) null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", 0);
        sQLiteDatabase2.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("value", 0);
        sQLiteDatabase2.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
