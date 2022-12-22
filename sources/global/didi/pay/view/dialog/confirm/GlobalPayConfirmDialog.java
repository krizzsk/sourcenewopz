package global.didi.pay.view.dialog.confirm;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.p236ui.theme.UnifiedPayThemeManager;
import global.didi.pay.view.dialog.UnifiedPayDialogConfig;

public class GlobalPayConfirmDialog extends Dialog {
    private View ll_cancel;
    private View ll_confirm;
    private UnifiedPayDialogConfig mConfig;
    /* access modifiers changed from: private */
    public IGlobalPayView.DialogConfirmListener mListener;
    private TextView tv_content;
    private TextView tv_title;

    public void setConfig(UnifiedPayDialogConfig unifiedPayDialogConfig) {
        this.mConfig = unifiedPayDialogConfig;
    }

    public GlobalPayConfirmDialog(Context context) {
        super(context);
    }

    public GlobalPayConfirmDialog(Context context, int i) {
        super(context, i);
    }

    public void setListener(IGlobalPayView.DialogConfirmListener dialogConfirmListener) {
        this.mListener = dialogConfirmListener;
    }

    public static GlobalPayConfirmDialog createDialog(Context context) {
        GlobalPayConfirmDialog globalPayConfirmDialog = new GlobalPayConfirmDialog(context, R.style.pay_dialog_style);
        Window window = globalPayConfirmDialog.getWindow();
        window.setGravity(17);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setWindowAnimations(R.style.pay_dialog_style_animation);
        return globalPayConfirmDialog;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.g_payment_pay_confirm_dialog);
        setCanceledOnTouchOutside(false);
        initView();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = displayMetrics.widthPixels;
        getWindow().setAttributes(attributes);
    }

    private void initView() {
        this.tv_content = (TextView) findViewById(R.id.tv_content);
        this.tv_title = (TextView) findViewById(R.id.tv_title);
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
        this.ll_confirm = findViewById(R.id.ll_confirm);
        this.ll_confirm.setBackground(AppCompatResources.getDrawable(getContext(), UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getNewMainBtnBg()));
        this.ll_cancel = findViewById(R.id.ll_cancel);
        ((TextView) findViewById(R.id.tv_confirm)).setTextColor(getContext().getResources().getColorStateList(UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getPayBtnTxtColor()));
        this.ll_confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalPayConfirmDialog.this.mListener != null) {
                    GlobalPayConfirmDialog.this.dismiss();
                    GlobalPayConfirmDialog.this.mListener.onConfirm();
                }
            }
        });
        this.ll_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalPayConfirmDialog.this.mListener != null) {
                    GlobalPayConfirmDialog.this.dismiss();
                    GlobalPayConfirmDialog.this.mListener.onCancel();
                }
            }
        });
    }
}
