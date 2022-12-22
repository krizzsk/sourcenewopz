package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.common.net.HttpHeaders;
import com.taxis99.R;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzara extends zzarj {
    /* access modifiers changed from: private */
    public final Context context;
    private final Map<String, String> zzdcn;

    public zzara(zzbfi zzbfi, Map<String, String> map) {
        super(zzbfi, "storePicture");
        this.zzdcn = map;
        this.context = zzbfi.zzabx();
    }

    public final void execute() {
        if (this.context == null) {
            zzdt("Activity context is not available");
            return;
        }
        zzr.zzkv();
        if (!zzj.zzar(this.context).zzsf()) {
            zzdt("Feature is not supported by the device.");
            return;
        }
        String str = this.zzdcn.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzdt("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzdt(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzr.zzkv();
            if (!zzj.zzej(lastPathSegment)) {
                String valueOf2 = String.valueOf(lastPathSegment);
                zzdt(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                return;
            }
            Resources resources = zzr.zzkz().getResources();
            zzr.zzkv();
            AlertDialog.Builder zzaq = zzj.zzaq(this.context);
            zzaq.setTitle(resources != null ? resources.getString(R.string.s1) : "Save image");
            zzaq.setMessage(resources != null ? resources.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
            zzaq.setPositiveButton(resources != null ? resources.getString(R.string.s3) : HttpHeaders.ACCEPT, new zzard(this, str, lastPathSegment));
            zzaq.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzarc(this));
            SystemUtils.showDialog(zzaq.create());
        }
    }
}
