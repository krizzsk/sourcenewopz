package com.didi.hawaii.p118ar.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.view.CustomToast */
public class CustomToast {

    /* renamed from: a */
    private Context f23397a;

    /* renamed from: b */
    private Dialog f23398b;

    /* renamed from: c */
    private TextView f23399c;

    /* renamed from: d */
    private int f23400d;

    /* renamed from: e */
    private int f23401e;

    public CustomToast(Context context) {
        this.f23397a = context;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f23400d = windowManager.getDefaultDisplay().getWidth();
        this.f23401e = windowManager.getDefaultDisplay().getHeight();
    }

    public CustomToast builder() {
        Button button = new Button(this.f23397a);
        this.f23399c = button;
        button.setBackgroundResource(R.mipmap.toast_bg);
        Dialog dialog = new Dialog(this.f23397a, R.style.ActionSheetDialogStyle);
        this.f23398b = dialog;
        dialog.setContentView(this.f23399c);
        Window window = this.f23398b.getWindow();
        window.setGravity(81);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 100;
        window.setAttributes(attributes);
        this.f23398b.setCancelable(false);
        return this;
    }

    public CustomToast setMsg(String str) {
        this.f23399c.setVisibility(0);
        this.f23399c.setText(str);
        return this;
    }

    public void show() {
        Dialog dialog = this.f23398b;
        if (dialog != null) {
            SystemUtils.showDialog(dialog);
        }
    }

    public void dismiss() {
        this.f23398b.dismiss();
    }
}
