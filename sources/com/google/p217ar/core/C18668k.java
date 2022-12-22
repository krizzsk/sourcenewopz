package com.google.p217ar.core;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

/* renamed from: com.google.ar.core.k */
/* compiled from: InstallActivity */
final class C18668k implements View.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ InstallActivity f53543a;

    C18668k(InstallActivity installActivity) {
        this.f53543a = installActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.f53543a.animateToSpinner();
        this.f53543a.startInstaller();
    }
}
