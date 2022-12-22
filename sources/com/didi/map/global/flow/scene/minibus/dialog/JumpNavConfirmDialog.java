package com.didi.map.global.flow.scene.minibus.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class JumpNavConfirmDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private TextView f26359a;

    /* renamed from: b */
    private OnConfirmClickListener f26360b;

    public interface OnConfirmClickListener {
        void onConfirm();
    }

    public JumpNavConfirmDialog(Context context) {
        this(context, R.style.popupDialog);
    }

    public JumpNavConfirmDialog(Context context, int i) {
        super(context, i);
        m18685a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.addFlags(2);
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
    }

    /* renamed from: a */
    private void m18685a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.jump_nav_confirm_dialog_layout, (ViewGroup) null);
        this.f26359a = (TextView) inflate.findViewById(R.id.dialog_title);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_confirm);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_cancel);
        try {
            textView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.jump_nav_confirm_btn_bg));
            textView.setTextColor(Color.parseColor("#ffffff"));
            textView2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.jump_nav_cancel_btn_bg));
            textView2.setTextColor(Color.parseColor("#000000"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        inflate.findViewById(R.id.dialog_cancel).setOnClickListener(this);
        inflate.findViewById(R.id.dialog_confirm).setOnClickListener(this);
        setContentView(inflate);
    }

    public void setTitle(String str) {
        if (this.f26359a != null && !TextUtils.isEmpty(str)) {
            this.f26359a.setText(str);
        }
    }

    public void onClick(View view) {
        OnConfirmClickListener onConfirmClickListener;
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.dialog_cancel) {
            dismiss();
        }
        if (id == R.id.dialog_confirm && (onConfirmClickListener = this.f26360b) != null) {
            onConfirmClickListener.onConfirm();
        }
    }

    public void setOnConfirmClickListener(OnConfirmClickListener onConfirmClickListener) {
        this.f26360b = onConfirmClickListener;
    }
}
