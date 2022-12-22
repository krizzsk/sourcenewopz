package com.didi.dimina.container.p106ui.statusbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* renamed from: com.didi.dimina.container.ui.statusbar.SupportRequestManagerFragment */
public final class SupportRequestManagerFragment extends Fragment {

    /* renamed from: a */
    private C7685e f17751a;

    public ImmersionBar get(Object obj) {
        if (this.f17751a == null) {
            this.f17751a = new C7685e(obj);
        }
        return this.f17751a.mo56695a();
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        if (this.f17751a == null) {
            this.f17751a = new C7685e(activity, dialog);
        }
        return this.f17751a.mo56695a();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C7685e eVar = this.f17751a;
        if (eVar != null) {
            eVar.mo56696a(getResources().getConfiguration());
        }
    }

    public void onResume() {
        super.onResume();
        C7685e eVar = this.f17751a;
        if (eVar != null) {
            eVar.mo56697b();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        C7685e eVar = this.f17751a;
        if (eVar != null) {
            eVar.mo56699c();
            this.f17751a = null;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C7685e eVar = this.f17751a;
        if (eVar != null) {
            eVar.mo56698b(configuration);
        }
    }
}
