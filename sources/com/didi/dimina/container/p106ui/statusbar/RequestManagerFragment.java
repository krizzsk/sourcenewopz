package com.didi.dimina.container.p106ui.statusbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;

/* renamed from: com.didi.dimina.container.ui.statusbar.RequestManagerFragment */
public final class RequestManagerFragment extends Fragment {

    /* renamed from: a */
    private C7685e f17744a;

    public ImmersionBar get(Object obj) {
        if (this.f17744a == null) {
            this.f17744a = new C7685e(obj);
        }
        return this.f17744a.mo56695a();
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        if (this.f17744a == null) {
            this.f17744a = new C7685e(activity, dialog);
        }
        return this.f17744a.mo56695a();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C7685e eVar = this.f17744a;
        if (eVar != null) {
            eVar.mo56696a(getResources().getConfiguration());
        }
    }

    public void onResume() {
        super.onResume();
        C7685e eVar = this.f17744a;
        if (eVar != null) {
            eVar.mo56697b();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        C7685e eVar = this.f17744a;
        if (eVar != null) {
            eVar.mo56699c();
            this.f17744a = null;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C7685e eVar = this.f17744a;
        if (eVar != null) {
            eVar.mo56698b(configuration);
        }
    }
}
