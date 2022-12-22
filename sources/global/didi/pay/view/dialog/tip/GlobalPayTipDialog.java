package global.didi.pay.view.dialog.tip;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.p236ui.theme.UnifiedPayThemeManager;
import global.didi.pay.view.dialog.UnifiedPayDialogConfig;

public class GlobalPayTipDialog extends Dialog {
    private View g_payment_tip_dialog_close;
    private View ll_submit;
    private UnifiedPayDialogConfig mConfig;
    /* access modifiers changed from: private */
    public IGlobalPayView.DialogTipsListener mListener;
    private TextView tv_content;
    private TextView tv_subContent;
    private TextView tv_submit;

    public GlobalPayTipDialog(Context context) {
        super(context);
    }

    public GlobalPayTipDialog(Context context, int i) {
        super(context, i);
    }

    protected GlobalPayTipDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public static GlobalPayTipDialog createDialog(Context context) {
        GlobalPayTipDialog globalPayTipDialog = new GlobalPayTipDialog(context, R.style.pay_dialog_style_2);
        Window window = globalPayTipDialog.getWindow();
        window.setGravity(17);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = UIUtils.getScreenWidth(context);
        window.setAttributes(attributes);
        return globalPayTipDialog;
    }

    public static GlobalPayTipDialog createTransDialog(Context context) {
        GlobalPayTipDialog globalPayTipDialog = new GlobalPayTipDialog(context, R.style.pay_dialog_style);
        Window window = globalPayTipDialog.getWindow();
        window.setGravity(17);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = UIUtils.getScreenWidth(context);
        window.setAttributes(attributes);
        return globalPayTipDialog;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.g_payment_pay_tip_dialog);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView() {
        this.g_payment_tip_dialog_close = findViewById(R.id.g_payment_tip_dialog_close);
        this.tv_content = (TextView) findViewById(R.id.tv_content);
        this.tv_subContent = (TextView) findViewById(R.id.tv_sub_content);
        this.ll_submit = findViewById(R.id.ll_submit);
        this.ll_submit.setBackground(AppCompatResources.getDrawable(getContext(), UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getNewMainBtnBg()));
        TextView textView = (TextView) findViewById(R.id.tv_submit);
        this.tv_submit = textView;
        textView.setTextColor(getContext().getResources().getColorStateList(UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getPayBtnTxtColor()));
        UnifiedPayDialogConfig unifiedPayDialogConfig = this.mConfig;
        if (unifiedPayDialogConfig != null) {
            if (!TextUtils.isEmpty(unifiedPayDialogConfig.getContent())) {
                this.tv_content.setText(this.mConfig.getContent());
            } else if (this.mConfig.getContentRes() != null) {
                this.tv_content.setText(this.mConfig.getContentRes().intValue());
            } else {
                this.tv_content.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mConfig.getSubContent())) {
                this.tv_subContent.setText(this.mConfig.getSubContent());
            } else if (this.mConfig.getSubContentRes() != null) {
                this.tv_subContent.setText(this.mConfig.getSubContentRes().intValue());
            } else {
                this.tv_subContent.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mConfig.getBtnTxt())) {
                this.tv_submit.setText(this.mConfig.getBtnTxt());
            } else if (this.mConfig.getBtnTxtRes() != null) {
                this.tv_submit.setText(this.mConfig.getBtnTxtRes().intValue());
            }
            this.g_payment_tip_dialog_close.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (GlobalPayTipDialog.this.mListener != null) {
                        GlobalPayTipDialog.this.mListener.onConfirm();
                    }
                    GlobalPayTipDialog.this.dismiss();
                }
            });
            this.ll_submit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (GlobalPayTipDialog.this.mListener != null) {
                        GlobalPayTipDialog.this.mListener.onConfirm();
                    }
                    GlobalPayTipDialog.this.dismiss();
                }
            });
        }
    }

    public void setTipsDialogListener(IGlobalPayView.DialogTipsListener dialogTipsListener) {
        this.mListener = dialogTipsListener;
    }

    public void setConfig(UnifiedPayDialogConfig unifiedPayDialogConfig) {
        this.mConfig = unifiedPayDialogConfig;
    }
}
