package com.didi.hawaii.p118ar.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.hawaii.p118ar.utils.DisplayUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.view.AlertDialog */
public class AlertDialog {
    public static final int ITILE_ALERT = 2;
    public static final int JISHI15_ALERT = 4;
    public static final int MIANZE_ALERT = 3;
    public static final int NOTITILE_ALERT = 1;
    protected Button btn_neg;
    protected View btn_pos;
    protected Context context;
    protected TextView countDownView;
    protected int curAlertType = 2;
    protected int curTime = 15;
    protected Dialog dialog;
    protected TextView img_line;
    protected TextView mbtnPos;
    protected boolean showMsg = false;
    protected boolean showNegBtn = false;
    protected boolean showPosBtn = false;
    protected boolean showTitle = false;
    protected TextView txt_msg;
    protected TextView txt_title;
    protected Handler uiHandler = new Handler(Looper.getMainLooper());

    public AlertDialog(Context context2) {
        this.context = context2;
    }

    public AlertDialog builder(int i) {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null && dialog2.isShowing()) {
            dismiss();
        }
        this.showTitle = false;
        this.showMsg = false;
        this.showPosBtn = false;
        this.showNegBtn = false;
        this.curAlertType = i;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.view_alertdialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_title);
        this.txt_title = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) inflate.findViewById(R.id.txt_msg);
        this.txt_msg = textView2;
        textView2.setVisibility(8);
        Button button = (Button) inflate.findViewById(R.id.btn_neg);
        this.btn_neg = button;
        button.setVisibility(8);
        View findViewById = inflate.findViewById(R.id.btn_pos);
        this.btn_pos = findViewById;
        findViewById.setVisibility(8);
        TextView textView3 = (TextView) inflate.findViewById(R.id.img_line);
        this.img_line = textView3;
        textView3.setVisibility(8);
        this.mbtnPos = (TextView) inflate.findViewById(R.id.btn);
        TextView textView4 = (TextView) inflate.findViewById(R.id.jishi);
        this.countDownView = textView4;
        textView4.setVisibility(8);
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

    public AlertDialog setTitle(String str) {
        if (this.curAlertType == 1) {
            return this;
        }
        this.showTitle = true;
        if ("".equals(str)) {
            this.txt_title.setText("标题");
        } else {
            this.txt_title.setText(str);
        }
        return this;
    }

    public AlertDialog setMsg(String str) {
        this.showMsg = true;
        if ("".equals(str)) {
            this.txt_msg.setText("内容");
        } else {
            this.txt_msg.setText(str);
        }
        return this;
    }

    public AlertDialog setCancelable(boolean z) {
        this.dialog.setCancelable(z);
        return this;
    }

    public AlertDialog setPositiveButton(String str, final View.OnClickListener onClickListener) {
        this.showPosBtn = true;
        if ("".equals(str)) {
            this.mbtnPos.setText(this.context.getString(R.string.i_can));
        } else {
            this.mbtnPos.setText(str);
        }
        this.btn_pos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                onClickListener.onClick(view);
                AlertDialog.this.dismiss();
            }
        });
        return this;
    }

    public AlertDialog setNegativeButton(String str, final View.OnClickListener onClickListener) {
        this.showNegBtn = true;
        if ("".equals(str)) {
            this.btn_neg.setText(this.context.getString(R.string.i_cancle));
        } else {
            this.btn_neg.setText(str);
        }
        this.btn_neg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                onClickListener.onClick(view);
                AlertDialog.this.dismiss();
            }
        });
        return this;
    }

    public AlertDialog setCountDownTime(int i) {
        if (this.curAlertType == 4) {
            this.curTime = i;
            this.countDownView.setVisibility(0);
            TextView textView = this.countDownView;
            textView.setText("（" + i + "s）");
        }
        return this;
    }

    /* renamed from: a */
    private void m16725a() {
        TextView textView;
        if (!this.showTitle && !this.showMsg) {
            this.txt_title.setText("提示");
            this.txt_title.setVisibility(0);
        }
        if (this.showTitle) {
            this.txt_title.setVisibility(0);
        }
        if (this.showMsg) {
            this.txt_msg.setVisibility(0);
        }
        if (!this.showPosBtn && !this.showNegBtn) {
            this.btn_pos.setVisibility(0);
            this.btn_pos.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    AlertDialog.this.dismiss();
                }
            });
        }
        if (this.showPosBtn && this.showNegBtn) {
            this.btn_pos.setVisibility(0);
            this.btn_neg.setVisibility(0);
            this.img_line.setVisibility(0);
        }
        if (this.showPosBtn && !this.showNegBtn) {
            this.btn_pos.setVisibility(0);
        }
        if (!this.showPosBtn && this.showNegBtn) {
            this.btn_neg.setVisibility(0);
        }
        if (this.curAlertType == 4) {
            this.btn_pos.setClickable(false);
            this.btn_pos.getBackground().setAlpha(102);
            if (this.countDownView != null && (textView = this.mbtnPos) != null) {
                textView.setAlpha(0.4f);
                this.countDownView.setAlpha(1.0f);
                this.uiHandler.postDelayed(new Runnable() {
                    public void run() {
                        AlertDialog.this.curTime--;
                        if (AlertDialog.this.curTime <= 0) {
                            AlertDialog.this.btn_pos.setClickable(true);
                            AlertDialog.this.btn_pos.getBackground().setAlpha(255);
                            AlertDialog.this.mbtnPos.setAlpha(1.0f);
                            AlertDialog.this.countDownView.setVisibility(8);
                            return;
                        }
                        AlertDialog.this.countDownView.setText("（" + AlertDialog.this.curTime + "s）");
                        AlertDialog.this.uiHandler.postDelayed(this, 1000);
                    }
                }, 1000);
            }
        }
    }

    public void dismiss() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        this.uiHandler.removeCallbacksAndMessages((Object) null);
    }

    public void show() {
        if (this.dialog != null) {
            m16725a();
            SystemUtils.showDialog(this.dialog);
        }
    }

    public boolean isShowing() {
        Dialog dialog2 = this.dialog;
        return dialog2 != null && dialog2.isShowing();
    }
}
