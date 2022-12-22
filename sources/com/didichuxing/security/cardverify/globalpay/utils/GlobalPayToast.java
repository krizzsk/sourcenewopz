package com.didichuxing.security.cardverify.globalpay.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class GlobalPayToast {
    public static void show(Context context, String str) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.didi_security_card_verify_global_pay_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.rf_tv_toast_msg)).setText(str);
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.setGravity(17, 0, 0);
        makeText.setView(inflate);
        SystemUtils.showToast(makeText);
    }
}
