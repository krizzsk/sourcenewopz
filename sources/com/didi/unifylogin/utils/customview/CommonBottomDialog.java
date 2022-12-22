package com.didi.unifylogin.utils.customview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class CommonBottomDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private TextView f44972a;

    /* renamed from: b */
    private TextView f44973b;

    /* renamed from: c */
    private Button f44974c;

    /* renamed from: d */
    private Button f44975d;

    /* renamed from: e */
    private View f44976e;

    /* renamed from: f */
    private String f44977f;

    /* renamed from: g */
    private String f44978g;

    /* renamed from: h */
    private String f44979h;

    /* renamed from: i */
    private String f44980i;

    /* renamed from: j */
    private ImageView f44981j;

    /* renamed from: k */
    private BottomDialogInterface f44982k;

    public static abstract class BottomDialogInterface {
        public abstract void onCancelClicked(CommonBottomDialog commonBottomDialog);

        public void onCloseDialog(CommonBottomDialog commonBottomDialog) {
        }

        public abstract void onConfirmClicked(CommonBottomDialog commonBottomDialog);
    }

    public CommonBottomDialog(Context context) {
        super(context, R.style.CustomDialog);
        init();
    }

    public void show(String str, String str2, String str3, View view, BottomDialogInterface bottomDialogInterface) {
        show(str, str2, str3, (String) null, view, bottomDialogInterface);
    }

    public void show(String str, String str2, String str3, String str4, View view, BottomDialogInterface bottomDialogInterface) {
        this.f44977f = str;
        this.f44978g = str2;
        this.f44979h = str3;
        this.f44980i = str4;
        this.f44982k = bottomDialogInterface;
        this.f44976e = view;
        m32242b();
        m32240a();
    }

    public void setCloseDialogIconVisible() {
        this.f44981j.setVisibility(0);
    }

    public void setConfirmBtnEnabled(boolean z) {
        this.f44974c.setEnabled(z);
    }

    /* renamed from: a */
    private void m32240a() {
        if (!(getContext() instanceof Activity) || !m32241a((Activity) getContext())) {
            try {
                super.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    /* renamed from: a */
    private static boolean m32241a(Activity activity) {
        if (Build.VERSION.SDK_INT < 17) {
            return activity.isFinishing();
        }
        return activity.isFinishing() || activity.isDestroyed();
    }

    /* access modifiers changed from: protected */
    public void init() {
        setContentView(R.layout.login_sdk_common_bottom_dialog);
        this.f44972a = (TextView) findViewById(R.id.title);
        this.f44981j = (ImageView) findViewById(R.id.close_dialog);
        this.f44973b = (TextView) findViewById(R.id.content);
        this.f44974c = (Button) findViewById(R.id.confirm_btn);
        this.f44975d = (Button) findViewById(R.id.cancel_btn);
        this.f44974c.setOnClickListener(this);
        this.f44975d.setOnClickListener(this);
        this.f44981j.setOnClickListener(this);
    }

    /* renamed from: b */
    private void m32242b() {
        this.f44972a.setText(this.f44977f);
        this.f44973b.setText(this.f44978g);
        if (!TextUtils.isEmpty(this.f44979h)) {
            this.f44974c.setText(this.f44979h);
        } else {
            this.f44974c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f44980i)) {
            this.f44975d.setText(this.f44980i);
        } else {
            this.f44975d.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.extra_content);
        if (this.f44976e != null) {
            updateExtraLayout(linearLayout);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getWindow().setLayout(-1, -2);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        getWindow().setAttributes(attributes);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.f44982k == null) {
            dismiss();
        } else if (view.getId() == R.id.confirm_btn) {
            this.f44982k.onConfirmClicked(this);
        } else if (view.getId() == R.id.cancel_btn) {
            this.f44982k.onCancelClicked(this);
        } else if (view.getId() == R.id.close_dialog) {
            this.f44982k.onCloseDialog(this);
        }
    }

    /* access modifiers changed from: protected */
    public void updateExtraLayout(LinearLayout linearLayout) {
        linearLayout.setVisibility(0);
        linearLayout.addView(this.f44976e);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }
}
