package com.didi.addressnew.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class ToastHelper {
    public static final int TYPE_FAIL = 2;
    public static final int TYPE_SUCCESSFUL = 1;

    public ToastHelper(Context context, int i, String str) {
        if (context != null) {
            Toast makeText = Toast.makeText(context, "", 0);
            View inflate = LayoutInflater.from(context).inflate(R.layout.customize_toast_layout, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.toast_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.toast_text);
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
                if (i == 1) {
                    imageView.setImageResource(R.drawable.icon_toast_success);
                } else if (i == 2) {
                    imageView.setImageResource(R.drawable.icon_toast_failure);
                }
                makeText.setDuration(0);
                makeText.setView(inflate);
                SystemUtils.showToast(makeText);
            }
        }
    }

    public static void showSuccessful(Context context, String str) {
        try {
            new ToastHelper(context, 1, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showFail(Context context, String str) {
        try {
            new ToastHelper(context, 2, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
