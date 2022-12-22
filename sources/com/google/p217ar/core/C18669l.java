package com.google.p217ar.core;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.google.p217ar.core.exceptions.UnavailableUserDeclinedInstallationException;

/* renamed from: com.google.ar.core.l */
/* compiled from: InstallActivity */
final class C18669l implements View.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ InstallActivity f53544a;

    C18669l(InstallActivity installActivity) {
        this.f53544a = installActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.f53544a.finishWithFailure(new UnavailableUserDeclinedInstallationException());
    }
}
