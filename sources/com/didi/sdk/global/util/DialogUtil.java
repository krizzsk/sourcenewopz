package com.didi.sdk.global.util;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.pay.base.PayCommonParamsUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class DialogUtil {
    public static final int TYPE_CANCEL_SIGN_FAILED = 1;
    public static final int TYPE_NORMAL = 0;

    public interface Callback {
        void onCancel();

        void onOk();
    }

    public static void showDialog(FragmentActivity fragmentActivity, int i, Object... objArr) {
        showDialog(fragmentActivity, i, (Callback) null, objArr);
    }

    public static void showDialog(FragmentActivity fragmentActivity, int i, Callback callback, Object... objArr) {
        if (i == 0) {
            showOneButtonDialog(fragmentActivity, objArr[0], callback);
        } else if (i == 1) {
            showCancelSignFailDialog(fragmentActivity, objArr[0], objArr[1], callback);
        }
    }

    public static void showOneButtonDialog(FragmentActivity fragmentActivity, String str) {
        new AlertDialogFragment.Builder(fragmentActivity).setIcon(AlertController.IconType.INFO).setNeutralButtonDefault().setMessage(str).setNeutralButton((int) R.string.confirm, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
            }
        }).create().show(fragmentActivity.getSupportFragmentManager(), "tag");
    }

    public static void showOneButtonDialog(final FragmentActivity fragmentActivity, String str, final boolean z) {
        new AlertDialogFragment.Builder(fragmentActivity).setNeutralButtonDefault().setIcon(AlertController.IconType.INFO).setMessage(str).setNeutralButton((int) R.string.guide_i_know, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                if (z) {
                    fragmentActivity.finish();
                }
            }
        }).create().show(fragmentActivity.getSupportFragmentManager(), "tag");
    }

    public static void showOneButtonDialog(FragmentActivity fragmentActivity, String str, final Callback callback) {
        new AlertDialogFragment.Builder(fragmentActivity).setNeutralButtonDefault().setIcon((int) R.drawable.one_payment_pay_dialog_icon_correct).setMessage(str).setNeutralButton((int) R.string.guide_i_know, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                Callback callback = Callback.this;
                if (callback != null) {
                    callback.onOk();
                }
            }
        }).create().show(fragmentActivity.getSupportFragmentManager(), "tag");
    }

    public static void showCancelSignConfirmDialog(FragmentActivity fragmentActivity, String str, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final AlertDialogFragment create = new AlertDialogFragment.Builder(fragmentActivity).setMessage(str).setIcon(AlertController.IconType.INFO).setPositiveButtonDefault().setDefaultButtonTxtColor(R.color.one_payment_orange).setNegativeButton((int) R.string.one_payment_global_detail_page_credit_card_dialog_remove_card_negative, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                View.OnClickListener onClickListener = View.OnClickListener.this;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }).setPositiveButton((int) R.string.one_payment_global_detail_page_credit_card_dialog_remove_card_positive, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                View.OnClickListener onClickListener = View.OnClickListener.this;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }).create();
        create.show(fragmentActivity.getSupportFragmentManager(), "tag");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                if (AlertDialogFragment.this.getDialog() != null) {
                    AlertDialogFragment.this.getDialog().setCanceledOnTouchOutside(false);
                }
            }
        }, 500);
    }

    public static void showCancelSignFailDialog(FragmentActivity fragmentActivity, String str, String str2, final Callback callback) {
        if (TextUtils.isEmpty(str2)) {
            str2 = fragmentActivity.getString(R.string.one_payment_pay_cancel_sign_fail);
        }
        new AlertDialogFragment.Builder(fragmentActivity).setTitle(str).setMessage(str2).setIcon(AlertController.IconType.INFO).setPositiveButtonDefault().setDefaultButtonTxtColor(R.color.one_payment_orange).setNegativeButton((int) R.string.one_payment_pay_close_txt, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
            }
        }).setPositiveButton((int) R.string.one_payment_wxagent_binded_fail_retry, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                Callback callback = Callback.this;
                if (callback != null) {
                    callback.onOk();
                }
            }
        }).create().show(fragmentActivity.getSupportFragmentManager(), "tag");
    }

    public static void promptLoginDialog(final FragmentActivity fragmentActivity, String str) {
        if (!TextUtil.isEmpty(str)) {
            new AlertDialogFragment.Builder(fragmentActivity).setNeutralButtonDefault().setIcon(AlertController.IconType.INFO).setMessage(str).setNeutralButton((int) R.string.one_payment_confirm, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    alertDialogFragment.dismiss();
                    FragmentActivity.this.finish();
                    PayCommonParamsUtil.getInstance().startLogin(FragmentActivity.this);
                }
            }).create().show(fragmentActivity.getSupportFragmentManager(), "tag");
        }
    }
}
