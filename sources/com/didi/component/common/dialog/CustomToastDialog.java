package com.didi.component.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.component.common.util.UIUtils;
import com.taxis99.R;

public class CustomToastDialog extends Dialog {

    /* renamed from: a */
    private int f11530a;

    /* renamed from: b */
    private Drawable f11531b;

    /* renamed from: c */
    private String f11532c;

    /* renamed from: d */
    private boolean f11533d;

    public CustomToastDialog(Context context) {
        super(context, R.style.CompToastDialogStyle);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.comp_dialog_custom_toast, (ViewGroup) null));
        ImageView imageView = (ImageView) findViewById(R.id.imgViewIcon);
        int i = this.f11530a;
        if (i >= 0) {
            imageView.setImageResource(i);
        } else {
            Drawable drawable = this.f11531b;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        ((TextView) findViewById(R.id.txtViewContent)).setText(this.f11532c);
        m7815a(getWindow().getAttributes());
    }

    /* renamed from: a */
    private void m7815a(WindowManager.LayoutParams layoutParams) {
        layoutParams.gravity = 81;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.y = (UIUtils.getScreenHeight(getContext()) / 5) * 2;
    }

    public void setIcon(int i) {
        this.f11530a = i;
    }

    public void setIcon(Drawable drawable) {
        this.f11531b = drawable;
    }

    public void setMessage(String str) {
        this.f11532c = str;
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.f11533d = z;
    }

    public boolean isCancelable() {
        return this.f11533d;
    }
}
