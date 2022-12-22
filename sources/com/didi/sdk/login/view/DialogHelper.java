package com.didi.sdk.login.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.login.view.CommonDialog;

@Deprecated
public class DialogHelper {

    /* renamed from: a */
    private CommonDialog f36719a = null;

    /* renamed from: b */
    private Context f36720b;

    public static abstract class DialogHelperListener implements CommonDialog.CommonDialogListener {
        public void cancel() {
        }

        public void firstClick() {
        }

        public void secondClick() {
        }

        public void submit() {
        }

        public void submitOnly() {
        }

        public void thirdClick() {
        }
    }

    public DialogHelper(Context context) {
        this.f36720b = context;
        this.f36719a = new CommonDialog(context);
        setCheckboxVisibility(false);
    }

    public static void loadingDialog(Context context, String str, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        if (context != null) {
            try {
                if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                    CommonDialog.loadingDialog(context, str, z, onCancelListener);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void removeLoadingDialog() {
        try {
            CommonDialog.removeLoadingDialog();
        } catch (Exception unused) {
        }
    }

    public static boolean isLoadingDialogShown() {
        return CommonDialog.isLoading();
    }

    public void setTitleContent(String str, String str2) {
        this.f36719a.setTitleContent(str, str2);
    }

    public void setTitleContent(String str, String[] strArr) {
        this.f36719a.setTitleContent(str, strArr);
    }

    public void setTitleContent(int i, int i2) {
        this.f36719a.setTitleContent(this.f36720b.getString(i), this.f36720b.getString(i2));
    }

    public void setIconType(CommonDialog.IconType iconType) {
        this.f36719a.setIconType(iconType);
    }

    public void setCheckboxVisibility(boolean z) {
        this.f36719a.setCheckboxVisibility(z);
    }

    public boolean isChecked() {
        CommonDialog commonDialog = this.f36719a;
        if (commonDialog == null) {
            return false;
        }
        return commonDialog.isChecked();
    }

    public void updatePinkIconShow(String str) {
        this.f36719a.updatePinkIconShow(str);
    }

    public void setButtonType(CommonDialog.ButtonType buttonType) {
        this.f36719a.setButtonType(buttonType);
    }

    public void setListener(CommonDialog.CommonDialogListener commonDialogListener) {
        this.f36719a.setListener(commonDialogListener);
    }

    public void setSubmitBtnText(String str) {
        this.f36719a.setSubmitBtnText(str);
    }

    public void setSubmitBtnText(int i) {
        this.f36719a.setSubmitBtnText(this.f36720b.getString(i));
    }

    public void setCancelBtnText(String str) {
        this.f36719a.setCancelBtnText(str);
    }

    public void setCancelBtnText(int i) {
        this.f36719a.setCancelBtnText(this.f36720b.getString(i));
    }

    public void setThreeBtnText(String str, String str2, String str3) {
        this.f36719a.setThreeBtnText(str, str2, str3);
    }

    public void setThreeBtnText(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f36719a.setThreeBtnText(charSequence, charSequence2, charSequence3);
    }

    public void setThreeBtnText(int i, int i2, int i3) {
        this.f36719a.setThreeBtnText(this.f36720b.getString(i), this.f36720b.getString(i2), this.f36720b.getString(i3));
    }

    public void setCancelable(boolean z) {
        this.f36719a.setCancelable(z);
    }

    public void dismiss() {
        try {
            this.f36719a.dismiss();
        } catch (Exception unused) {
        }
    }

    public boolean isShowing() {
        return this.f36719a.isShowing();
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.f36719a.setCanceledOnTouchOutside(z);
    }

    public void setCloseDialogVisiblity(boolean z) {
        this.f36719a.setCloseDialogVisiblity(z);
    }

    public void show() {
        if (this.f36720b != null) {
            try {
                SystemUtils.showDialog(this.f36719a);
            } catch (Exception unused) {
            }
        }
    }

    public void setIconVisible(boolean z) {
        this.f36719a.setIconVisible(z);
    }

    public void cancel() {
        CommonDialog commonDialog = this.f36719a;
        if (commonDialog != null && commonDialog.isShowing()) {
            try {
                this.f36719a.cancel();
            } catch (Exception unused) {
            }
        }
    }
}
