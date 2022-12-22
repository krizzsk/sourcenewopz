package com.didi.hawaii.p118ar.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.hawaii.p118ar.utils.DisplayUtils;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.view.AlertDialogGlobal */
public class AlertDialogGlobal extends AlertDialog {
    public AlertDialogGlobal(Context context) {
        super(context);
    }

    public AlertDialogGlobal builder(int i) {
        if (this.dialog != null && this.dialog.isShowing()) {
            dismiss();
        }
        this.showTitle = false;
        this.showMsg = false;
        this.showPosBtn = false;
        this.showNegBtn = false;
        this.curAlertType = i;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.view_alertdialog_global, (ViewGroup) null);
        this.txt_title = (TextView) inflate.findViewById(R.id.txt_title);
        this.txt_title.setVisibility(8);
        this.txt_msg = (TextView) inflate.findViewById(R.id.txt_msg);
        this.txt_msg.setVisibility(8);
        this.btn_neg = (Button) inflate.findViewById(R.id.btn_neg);
        this.btn_neg.setVisibility(8);
        this.btn_pos = inflate.findViewById(R.id.btn_pos);
        this.btn_pos.setVisibility(8);
        this.img_line = (TextView) inflate.findViewById(R.id.img_line);
        this.img_line.setVisibility(8);
        this.mbtnPos = (TextView) inflate.findViewById(R.id.btn);
        this.countDownView = (TextView) inflate.findViewById(R.id.jishi);
        this.countDownView.setVisibility(8);
        int i2 = this.curAlertType;
        if (i2 == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.txt_msg.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + DisplayUtils.dip2px(this.context, 10.0f), layoutParams.rightMargin, layoutParams.bottomMargin);
            this.txt_msg.setLayoutParams(layoutParams);
        } else if (i2 == 3) {
            this.txt_msg.setTextSize(1, 14.0f);
        }
        if (this.dialog == null) {
            this.dialog = new Dialog(this.context, R.style.AlertDialogStyle);
        }
        this.dialog.setContentView(inflate);
        return this;
    }
}
