package com.didi.unifylogin.base.view;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;

public class BaseViewUtil {
    public static void showInfoDialog(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        AlertDialogFragment.Builder positiveButton = new AlertDialogFragment.Builder(fragmentActivity).setPositiveButtonDefault().setIcon(AlertController.IconType.INFO).setSupprtMullineTitle(true).setTitle(str).setMessage(str2).setCancelable(false).setPositiveButton((CharSequence) str3, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                if (alertDialogFragment != null) {
                    alertDialogFragment.dismiss();
                }
                View.OnClickListener onClickListener = View.OnClickListener.this;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        if (!TextUtil.isEmpty(str4)) {
            positiveButton.setNegativeButton((CharSequence) str4, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    if (alertDialogFragment != null) {
                        alertDialogFragment.dismiss();
                    }
                    View.OnClickListener onClickListener = View.OnClickListener.this;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        }
        if (!fragmentActivity.isFinishing()) {
            positiveButton.create().show(fragmentActivity.getSupportFragmentManager(), (String) null);
        }
    }

    public static void showDialog(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        AlertDialogFragment.Builder positiveButton = new AlertDialogFragment.Builder(fragmentActivity).setPositiveButtonDefault().setSupprtMullineTitle(true).setTitle(str).setMessage(str2).setCancelable(false).setPositiveButton((CharSequence) str3, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                if (alertDialogFragment != null) {
                    alertDialogFragment.dismiss();
                }
                View.OnClickListener onClickListener = View.OnClickListener.this;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        if (!TextUtil.isEmpty(str4)) {
            positiveButton.setNegativeButton((CharSequence) str4, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    if (alertDialogFragment != null) {
                        alertDialogFragment.dismiss();
                    }
                    View.OnClickListener onClickListener = View.OnClickListener.this;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        }
        if (!fragmentActivity.isFinishing()) {
            positiveButton.create().show(fragmentActivity.getSupportFragmentManager(), (String) null);
        }
    }

    public static void showMultipleDialog(FragmentActivity fragmentActivity, String str, String str2, DialogItem dialogItem, DialogItem dialogItem2, DialogItem dialogItem3) {
        AlertDialogFragment.Builder cancelable = new AlertDialogFragment.Builder(fragmentActivity).setTitle(str).setMessage(str2).setCancelable(false);
        cancelable.setPositiveButton((CharSequence) dialogItem.btnStr, dialogItem.listener);
        cancelable.setNeutralButton((CharSequence) dialogItem2.btnStr, dialogItem2.listener);
        cancelable.setNegativeButton((CharSequence) dialogItem3.btnStr, dialogItem3.listener);
        cancelable.setPositiveButtonDefault().hideDiverContentLine();
        AlertDialogFragment create = cancelable.create();
        if (!fragmentActivity.isFinishing()) {
            create.show(fragmentActivity.getSupportFragmentManager(), (String) null);
        }
    }

    public static class DialogItem {
        String btnStr;
        AlertDialogFragment.OnClickListener listener;

        public DialogItem(String str, AlertDialogFragment.OnClickListener onClickListener) {
            this.btnStr = str;
            this.listener = onClickListener;
        }
    }
}
