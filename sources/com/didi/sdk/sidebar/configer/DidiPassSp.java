package com.didi.sdk.sidebar.configer;

import android.content.Context;

public class DidiPassSp {
    public static final String DIDI_PASS_DATA_GET_PROFILE = "didi_pass_data_get_profile";

    /* renamed from: a */
    private static SharedPrefercencesHelper f37224a = null;

    /* renamed from: b */
    private static final String f37225b = "didi_pass_data_sp";

    private DidiPassSp() {
    }

    public static SharedPrefercencesHelper getIns(Context context) {
        if (f37224a == null) {
            synchronized (DidiPassSp.class) {
                if (f37224a == null) {
                    f37224a = new SharedPrefercencesHelper(context, f37225b);
                }
            }
        }
        return f37224a;
    }
}
