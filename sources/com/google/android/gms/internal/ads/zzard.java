package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzard implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzara zzdri;
    private final /* synthetic */ String zzdrj;
    private final /* synthetic */ String zzdrk;

    zzard(zzara zzara, String str, String str2) {
        this.zzdri = zzara;
        this.zzdrj = str;
        this.zzdrk = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        DownloadManager downloadManager = (DownloadManager) this.zzdri.context.getSystemService(HotpatchStateConst.DOWNLOAD);
        try {
            String str = this.zzdrj;
            String str2 = this.zzdrk;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzr.zzkv();
            zzj.zza(request);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzdri.zzdt("Could not store picture.");
        }
    }
}
