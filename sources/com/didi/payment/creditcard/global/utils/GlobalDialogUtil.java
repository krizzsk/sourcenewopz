package com.didi.payment.creditcard.global.utils;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.creditcard.global.utils.GlobalCreditPayTipDialogFragment;
import com.didi.payment.creditcard.global.widget.CardUpdateConfirmFragment;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class GlobalDialogUtil {
    public static void showCancelSignConfirmDialog(FragmentActivity fragmentActivity, String str, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final AlertDialogFragment create = new AlertDialogFragment.Builder(fragmentActivity).setMessage(str).setIcon(AlertController.IconType.INFO).setPositiveButtonDefault().setDefaultButtonTxtColor(R.color.one_payment_creditcard_text_orange).setNegativeButton((int) R.string.one_payment_creditcard_global_detail_page_dialog_remove_card_negative, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                View.OnClickListener onClickListener = View.OnClickListener.this;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }).setPositiveButton((int) R.string.one_payment_creditcard_global_detail_page_dialog_remove_card_positive, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
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

    public static void showVerifyConfirmDialog(FragmentActivity fragmentActivity, String str, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final AlertDialogFragment create = new AlertDialogFragment.Builder(fragmentActivity).setMessage(str).setIcon(AlertController.IconType.INFO).setPositiveButtonDefault().setDefaultButtonTxtColor(R.color.one_payment_creditcard_text_orange).setNegativeButton((int) R.string.one_payment_creditcard_global_verify_confirm_dialog_negative, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                View.OnClickListener onClickListener = View.OnClickListener.this;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }).setPositiveButton((int) R.string.one_payment_creditcard_global_verify_confirm_dialog_positive, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
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

    public static void showVerifyFailureDialog(FragmentActivity fragmentActivity, String str, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        String string = fragmentActivity.getResources().getString(R.string.one_payment_creditcard_global_verify_failure_dialog_title);
        String string2 = fragmentActivity.getResources().getString(R.string.one_payment_creditcard_global_verify_failure_dialog_negative);
        String string3 = fragmentActivity.getResources().getString(R.string.one_payment_creditcard_global_verify_failure_dialog_positive);
        final GlobalVerticalOptionDialogFragment globalVerticalOptionDialogFragment = new GlobalVerticalOptionDialogFragment();
        globalVerticalOptionDialogFragment.setTitle(string);
        globalVerticalOptionDialogFragment.setContent(str);
        globalVerticalOptionDialogFragment.setNegativeButton(string2, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = View.OnClickListener.this;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        globalVerticalOptionDialogFragment.setPositiveButton(string3, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = View.OnClickListener.this;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        globalVerticalOptionDialogFragment.show(fragmentActivity.getSupportFragmentManager(), "tag");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                if (GlobalVerticalOptionDialogFragment.this.getDialog() != null) {
                    GlobalVerticalOptionDialogFragment.this.getDialog().setCanceledOnTouchOutside(false);
                }
            }
        }, 500);
    }

    public static void showPayTipDialog(FragmentActivity fragmentActivity, String str, String str2, GlobalCreditPayTipDialogFragment.PayTipDialogEventListener payTipDialogEventListener) {
        final GlobalCreditPayTipDialogFragment globalCreditPayTipDialogFragment = new GlobalCreditPayTipDialogFragment();
        globalCreditPayTipDialogFragment.setContent(str);
        globalCreditPayTipDialogFragment.setTip(str2);
        globalCreditPayTipDialogFragment.setPayTipDialogEventListener(payTipDialogEventListener);
        globalCreditPayTipDialogFragment.show(fragmentActivity.getSupportFragmentManager(), "tag");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                if (GlobalCreditPayTipDialogFragment.this.getDialog() != null) {
                    GlobalCreditPayTipDialogFragment.this.getDialog().setCanceledOnTouchOutside(false);
                }
            }
        }, 500);
    }

    public static void showAddCardFailureGuideDialog(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final GlobalAddCardFailureDialogFragment globalAddCardFailureDialogFragment = new GlobalAddCardFailureDialogFragment();
        globalAddCardFailureDialogFragment.setTitle(str);
        globalAddCardFailureDialogFragment.setContent(str2);
        globalAddCardFailureDialogFragment.setPositiveButton(str3, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalAddCardFailureDialogFragment.this.dismiss();
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        globalAddCardFailureDialogFragment.setNegativeButton(str4, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalAddCardFailureDialogFragment.this.dismiss();
                View.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        globalAddCardFailureDialogFragment.show(fragmentActivity.getSupportFragmentManager(), "tag");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                if (GlobalAddCardFailureDialogFragment.this.getDialog() != null) {
                    GlobalAddCardFailureDialogFragment.this.getDialog().setCanceledOnTouchOutside(false);
                }
            }
        }, 500);
    }

    public static void showCardUpdateDialog(FragmentActivity fragmentActivity, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final CardUpdateConfirmFragment cardUpdateConfirmFragment = new CardUpdateConfirmFragment();
        cardUpdateConfirmFragment.setConfirmClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardUpdateConfirmFragment.this.dismiss();
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        cardUpdateConfirmFragment.setCancelClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardUpdateConfirmFragment.this.dismiss();
                View.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        cardUpdateConfirmFragment.show(fragmentActivity.getSupportFragmentManager(), "tag");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                if (CardUpdateConfirmFragment.this.getDialog() != null) {
                    CardUpdateConfirmFragment.this.getDialog().setCanceledOnTouchOutside(false);
                }
            }
        }, 500);
    }
}
