package com.google.android.play.core.missingsplits;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18478bz;

public class PlayCoreMissingSplitsActivity extends Activity implements DialogInterface.OnClickListener {
    /* renamed from: a */
    private final String m38008a() {
        return getApplicationInfo().loadLabel(getPackageManager()).toString();
    }

    /* renamed from: a */
    private final void m38009a(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 66);
        sb.append("market://details?id=");
        sb.append(str);
        sb.append("&referrer=utm_source%3Dplay.core.missingsplits");
        try {
            startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(sb.toString())).setPackage("com.android.vending"));
        } catch (ActivityNotFoundException e) {
            new C18432ag(getClass().getName()).mo149082a((Throwable) e, "Couldn't start missing splits activity for %s", str);
        }
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        if (i == -1) {
            m38009a(getPackageName());
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        AlertDialog.Builder neutralButton = new AlertDialog.Builder(this).setTitle("Installation failed").setCancelable(false).setNeutralButton("Close", this);
        if (C18478bz.m37892a(this)) {
            String a = m38008a();
            StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 91);
            sb.append("The app ");
            sb.append(a);
            sb.append(" is missing required components and must be reinstalled from the Google Play Store.");
            neutralButton.setMessage(sb.toString()).setPositiveButton("Reinstall", this);
        } else {
            String a2 = m38008a();
            StringBuilder sb2 = new StringBuilder(String.valueOf(a2).length() + 87);
            sb2.append("The app ");
            sb2.append(a2);
            sb2.append(" is missing required components and must be reinstalled from an official store.");
            neutralButton.setMessage(sb2.toString());
        }
        SystemUtils.showDialog(neutralButton.create());
    }
}
