package com.didi.sdk.sidebar.account;

import android.view.inputmethod.InputMethodManager;
import com.didi.sdk.sidebar.templet.BottomTitleFragment;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;

public class EditAccountFragment extends BottomTitleFragment {
    /* access modifiers changed from: protected */
    public void onBack() {
        if ("level2".equals(this.sidebarPage.getSubLevel())) {
            super.onBack();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        m26355a();
    }

    public void onResume() {
        super.onResume();
        OmegaSDKAdapter.trackEvent("pas_profile_sw");
    }

    /* renamed from: a */
    private void m26355a() {
        if (getActivity() != null) {
            try {
                ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
