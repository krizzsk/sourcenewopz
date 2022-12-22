package global.didi.pay.view.dialog.password;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.util.OmegaUtils;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.p236ui.theme.UnifiedPayThemeManager;
import global.didi.pay.view.dialog.UnifiedPayDialogConfig;

public class GlobalPayPasswordDialog extends Dialog {
    private View ll_cancel;
    private View ll_confirm;
    private UnifiedPayDialogConfig mConfig;
    /* access modifiers changed from: private */
    public IGlobalPayView.DialogConfirmListener mListener;
    private TextView tv_cancel;
    private TextView tv_confirm;
    private TextView tv_content;
    private TextView tv_title;

    public GlobalPayPasswordDialog(Context context) {
        super(context);
    }

    public GlobalPayPasswordDialog(Context context, int i) {
        super(context, i);
    }

    public void setListener(IGlobalPayView.DialogConfirmListener dialogConfirmListener) {
        this.mListener = dialogConfirmListener;
    }

    public static GlobalPayPasswordDialog createDialog(Context context) {
        GlobalPayPasswordDialog globalPayPasswordDialog = new GlobalPayPasswordDialog(context, R.style.pay_dialog_style);
        Window window = globalPayPasswordDialog.getWindow();
        window.setGravity(17);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = UIUtils.getScreenWidth(context);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.pay_dialog_style_animation);
        return globalPayPasswordDialog;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.g_payment_pay_password_dialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        if (this.mConfig != null) {
            initView();
            OmegaUtils.trackEvent("ibt_password_paying_bottom_popoup_sw");
        }
    }

    private void initView() {
        this.tv_content = (TextView) findViewById(R.id.tv_content);
        this.tv_title = (TextView) findViewById(R.id.tv_title);
        this.ll_confirm = findViewById(R.id.ll_confirm);
        this.ll_cancel = findViewById(R.id.ll_cancel);
        this.ll_confirm.setBackground(AppCompatResources.getDrawable(getContext(), UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getNewMainBtnBg()));
        this.ll_cancel.setBackground(AppCompatResources.getDrawable(getContext(), UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getOtherBtnBg()));
        this.tv_confirm = (TextView) findViewById(R.id.tv_confirm);
        this.tv_cancel = (TextView) findViewById(R.id.tv_cancel);
        this.tv_confirm.setTextColor(getContext().getResources().getColorStateList(UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getPayBtnTxtColor()));
        if (!TextUtils.isEmpty(this.mConfig.getContent())) {
            this.tv_title.setText(this.mConfig.getContent());
        } else if (this.mConfig.getContentRes() != null) {
            this.tv_title.setText(this.mConfig.getContentRes().intValue());
        } else {
            this.tv_title.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mConfig.getSubContent())) {
            this.tv_content.setText(this.mConfig.getSubContent());
        } else if (this.mConfig.getSubContentRes() != null) {
            this.tv_content.setText(this.mConfig.getSubContentRes().intValue());
        } else {
            this.tv_content.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mConfig.getBtnTxt())) {
            this.tv_confirm.setText(this.mConfig.getBtnTxt());
        } else if (this.mConfig.getBtnTxtRes() != null) {
            this.tv_confirm.setText(this.mConfig.getBtnTxtRes().intValue());
        } else {
            this.tv_confirm.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mConfig.getBtnTxt2())) {
            this.tv_cancel.setText(this.mConfig.getBtnTxt2());
        } else if (this.mConfig.getBtnTxtRes2() != null) {
            this.tv_cancel.setText(this.mConfig.getBtnTxtRes2().intValue());
        } else {
            this.tv_cancel.setVisibility(8);
        }
        this.ll_confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalPayPasswordDialog.this.mListener != null) {
                    OmegaUtils.trackEvent("ibt_password_paying_bottom_popoup_yes_ck");
                    GlobalPayPasswordDialog.this.dismiss();
                    GlobalPayPasswordDialog.this.mListener.onConfirm();
                }
            }
        });
        this.ll_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalPayPasswordDialog.this.mListener != null) {
                    GlobalPayPasswordDialog.this.dismiss();
                    GlobalPayPasswordDialog.this.mListener.onCancel();
                }
            }
        });
    }

    public void setConfig(UnifiedPayDialogConfig unifiedPayDialogConfig) {
        this.mConfig = unifiedPayDialogConfig;
    }
}
