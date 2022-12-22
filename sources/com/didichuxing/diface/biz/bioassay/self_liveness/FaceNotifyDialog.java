package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.taxis99.R;

public class FaceNotifyDialog {

    /* renamed from: a */
    private Context f47305a;

    /* renamed from: b */
    private int f47306b;

    /* renamed from: c */
    private CharSequence f47307c;

    /* renamed from: d */
    private final BottomSheetDialog f47308d;

    /* renamed from: e */
    private int f47309e;

    /* renamed from: f */
    private View.OnClickListener f47310f;

    /* renamed from: g */
    private int f47311g;

    /* renamed from: h */
    private View.OnClickListener f47312h;

    public FaceNotifyDialog(Context context, int i, String str) {
        this.f47305a = context;
        this.f47306b = i;
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.MyDialogStyle);
        this.f47308d = bottomSheetDialog;
        bottomSheetDialog.setContentView((int) R.layout.diface_notify_dialog_layout);
        this.f47308d.setCancelable(false);
    }

    public FaceNotifyDialog setMsg(CharSequence charSequence) {
        this.f47307c = charSequence;
        return this;
    }

    public FaceNotifyDialog setMsg(int i) {
        this.f47307c = this.f47305a.getString(i);
        return this;
    }

    public FaceNotifyDialog setMainBtnInfo(int i, View.OnClickListener onClickListener) {
        this.f47309e = i;
        this.f47310f = onClickListener;
        return this;
    }

    public FaceNotifyDialog setSecondaryBtnInfo(int i, View.OnClickListener onClickListener) {
        this.f47311g = i;
        this.f47312h = onClickListener;
        return this;
    }

    public void show() {
        SystemUtils.showDialog(this.f47308d);
        ((TextView) this.f47308d.findViewById(R.id.dialog_title)).setText(this.f47306b);
        TextView textView = (TextView) this.f47308d.findViewById(R.id.dialog_msg);
        if (!TextUtils.isEmpty(this.f47307c)) {
            textView.setText(this.f47307c);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        Button button = (Button) this.f47308d.findViewById(R.id.main_btn);
        int i = this.f47309e;
        if (i != 0) {
            button.setText(i);
            button.setOnClickListener(this.f47310f);
        }
        Button button2 = (Button) this.f47308d.findViewById(R.id.secondary_btn);
        int i2 = this.f47311g;
        if (i2 != 0) {
            button2.setText(i2);
            button2.setVisibility(0);
            button2.setOnClickListener(this.f47312h);
            return;
        }
        button2.setVisibility(8);
    }

    public void dismiss() {
        this.f47308d.dismiss();
    }
}
