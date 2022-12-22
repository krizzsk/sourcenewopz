package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.common.net.HttpHeaders;
import com.taxis99.R;
import java.util.Map;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaqu extends zzarj {
    /* access modifiers changed from: private */
    public final Context context;
    private final Map<String, String> zzdcn;
    private String zzdql = zzdr("description");
    private long zzdqm = zzds("start_ticks");
    private long zzdqn = zzds("end_ticks");
    private String zzdqo = zzdr(ErrorBundle.SUMMARY_ENTRY);
    private String zzdqp = zzdr("location");

    public zzaqu(zzbfi zzbfi, Map<String, String> map) {
        super(zzbfi, "createCalendarEvent");
        this.zzdcn = map;
        this.context = zzbfi.zzabx();
    }

    private final String zzdr(String str) {
        return TextUtils.isEmpty(this.zzdcn.get(str)) ? "" : this.zzdcn.get(str);
    }

    private final long zzds(String str) {
        String str2 = this.zzdcn.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final void execute() {
        if (this.context == null) {
            zzdt("Activity context is not available.");
            return;
        }
        zzr.zzkv();
        if (!zzj.zzar(this.context).zzsg()) {
            zzdt("This feature is not available on the device.");
            return;
        }
        zzr.zzkv();
        AlertDialog.Builder zzaq = zzj.zzaq(this.context);
        Resources resources = zzr.zzkz().getResources();
        zzaq.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzaq.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzaq.setPositiveButton(resources != null ? resources.getString(R.string.s3) : HttpHeaders.ACCEPT, new zzaqx(this));
        zzaq.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzaqw(this));
        SystemUtils.showDialog(zzaq.create());
    }

    /* access modifiers changed from: package-private */
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzdql);
        data.putExtra("eventLocation", this.zzdqp);
        data.putExtra("description", this.zzdqo);
        long j = this.zzdqm;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdqn;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }
}
