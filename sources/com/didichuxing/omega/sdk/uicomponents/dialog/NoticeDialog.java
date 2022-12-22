package com.didichuxing.omega.sdk.uicomponents.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewConfig;
import com.taxis99.R;

public class NoticeDialog extends Dialog {
    /* access modifiers changed from: private */
    public TextView cancelBtn = ((TextView) findViewById(R.id.omega_uic_dia_cancel));
    private TextView confirmBtn = ((TextView) findViewById(R.id.omega_uic_dia_confirm));
    private TextView content = ((TextView) findViewById(R.id.omega_uic_dia_content));

    public NoticeDialog(Context context, final View.OnClickListener onClickListener) {
        super(context, R.style.omega_uic_NoticeDialog);
        setContentView(R.layout.omega_uic_fragment_dialog);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        if (FloatingViewConfig.iConfig != null) {
            this.content.setText(FloatingViewConfig.iConfig.getDialogContent());
            this.confirmBtn.setText(FloatingViewConfig.iConfig.getDialogCancel());
            this.cancelBtn.setText(FloatingViewConfig.iConfig.getDialogConfirm());
        }
        this.cancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NoticeDialog.this.cancel();
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(NoticeDialog.this.cancelBtn);
                }
            }
        });
        this.confirmBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NoticeDialog.this.cancel();
            }
        });
    }
}
