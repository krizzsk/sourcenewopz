package com.didichuxing.diface.appeal;

import android.text.TextUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.taxis99.R;

public class AppealCanceledEvent {

    /* renamed from: a */
    private String f46967a;

    public AppealCanceledEvent() {
    }

    public AppealCanceledEvent(String str) {
        this.f46967a = str;
    }

    public String getMsg() {
        if (TextUtils.isEmpty(this.f46967a)) {
            this.f46967a = ResUtils.getString(R.string.df_bi_failed_act_compare_failed_title);
        }
        return this.f46967a;
    }
}
