package com.didi.payment.creditcard.global.ocr;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.dialog.GlobalAlertDialog;
import com.didi.payment.creditcard.global.model.bean.OCRVerifyInfo;
import com.taxis99.R;
import java.util.ArrayList;

public class OcrDialogUtil {

    public interface Callback {
        void onCancel();

        void onOk();
    }

    public static void showOrcConfirmDialog(FragmentActivity fragmentActivity, Callback callback) {
        if (fragmentActivity != null && callback != null) {
            GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(fragmentActivity.getString(R.string.one_payment_creditcard_global_ocr_confirm_dialog_positive_btn));
            arrayList2.add(m21342a(0, callback));
            arrayList.add(fragmentActivity.getString(R.string.one_payment_creditcard_global_ocr_confirm_dialog_negative_btn));
            arrayList2.add(m21342a(1, callback));
            globalAlertDialog.setButtons(arrayList);
            globalAlertDialog.setListeners(arrayList2);
            globalAlertDialog.setMsg(fragmentActivity.getString(R.string.one_payment_creditcard_global_ocr_confirm_dialog_content));
            globalAlertDialog.show(fragmentActivity.getSupportFragmentManager(), "ocrDialog");
        }
    }

    public static void showOcrErrorDialog(FragmentActivity fragmentActivity, Callback callback, OCRVerifyInfo oCRVerifyInfo) {
        if (fragmentActivity != null && callback != null) {
            if (oCRVerifyInfo == null || oCRVerifyInfo.action == null || oCRVerifyInfo.action.size() <= 0) {
                oCRVerifyInfo = new OCRVerifyInfo();
                oCRVerifyInfo.errMsg = fragmentActivity.getString(R.string.one_payment_creditcard_global_ocr_error_dialog_content);
                oCRVerifyInfo.action = new ArrayList();
                OCRVerifyInfo.ActionInfo actionInfo = new OCRVerifyInfo.ActionInfo();
                actionInfo.title = fragmentActivity.getString(R.string.one_payment_creditcard_global_ocr_error_dialog_positive_btn);
                actionInfo.method = 0;
                oCRVerifyInfo.action.add(actionInfo);
            }
            GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (OCRVerifyInfo.ActionInfo next : oCRVerifyInfo.action) {
                arrayList.add(next.title);
                arrayList2.add(m21342a(next.method, callback));
            }
            globalAlertDialog.setButtons(arrayList);
            globalAlertDialog.setListeners(arrayList2);
            globalAlertDialog.setMsg(oCRVerifyInfo.errMsg);
            globalAlertDialog.show(fragmentActivity.getSupportFragmentManager(), "ocrResult");
        }
    }

    /* renamed from: a */
    private static GlobalAlertDialog.OnBtnClickListener m21342a(int i, final Callback callback) {
        if (i == 0) {
            return new GlobalAlertDialog.OnBtnClickListener() {
                public void onBtnClick(DialogFragment dialogFragment, int i) {
                    dialogFragment.dismissAllowingStateLoss();
                    Callback.this.onOk();
                }
            };
        }
        if (i == 1 || i == 2) {
            return new GlobalAlertDialog.OnBtnClickListener() {
                public void onBtnClick(DialogFragment dialogFragment, int i) {
                    dialogFragment.dismissAllowingStateLoss();
                    Callback.this.onCancel();
                }
            };
        }
        return null;
    }
}
