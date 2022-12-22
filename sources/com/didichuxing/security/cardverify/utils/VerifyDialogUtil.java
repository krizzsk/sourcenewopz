package com.didichuxing.security.cardverify.utils;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.taxis99.R;

public class VerifyDialogUtil {
    public static LEGODrawer showCancelSignConfirmDialog(FragmentActivity fragmentActivity, String str, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        String string = fragmentActivity.getResources().getString(R.string.didi_security_card_verify_dialog_remove_card_positive);
        String string2 = fragmentActivity.getResources().getString(R.string.didi_security_card_verify_dialog_remove_card_negative);
        C163892 r6 = new LEGOBaseDrawerModel(str, new LEGOBtnTextAndCallback(string, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                DiCardVerifyTracker.trackRemoveConfirm(2);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        })) {
            /* access modifiers changed from: protected */
            public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
                lEGODrawerModel.clickOutsideCanCancel = false;
                lEGODrawerModel.isTwoBtnHorizontal = true;
                return lEGODrawerModel;
            }
        };
        r6.addMinorBtn(new LEGOBtnTextAndCallback(string2, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                DiCardVerifyTracker.trackRemoveConfirm(3);
                View.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }));
        r6.setmBackPressedEnabled(false);
        DiCardVerifyTracker.trackRemoveConfirm(1);
        return LEGOUICreator.showDrawerTemplate(fragmentActivity, r6);
    }

    public static LEGODrawer showVerifyConfirmDialog(FragmentActivity fragmentActivity, final String str, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        String string = fragmentActivity.getResources().getString(R.string.didi_security_card_verify_pay_confirm_dialog_title);
        String string2 = fragmentActivity.getResources().getString(R.string.didi_security_card_verify_pay_confirm_dialog_negative);
        String string3 = fragmentActivity.getResources().getString(R.string.didi_security_card_verify_pay_confirm_dialog_positive);
        C163914 r3 = new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                DiCardVerifyTracker.trackDeduct(2);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        };
        LEGOBtnTextAndCallback lEGOBtnTextAndCallback = new LEGOBtnTextAndCallback(string2, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                DiCardVerifyTracker.trackDeduct(3);
                View.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        C163936 r8 = new LEGOBaseDrawerModel(string, new LEGOBtnTextAndCallback(string3, r3)) {
            /* access modifiers changed from: protected */
            public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
                lEGODrawerModel.clickOutsideCanCancel = false;
                lEGODrawerModel.isTwoBtnHorizontal = true;
                lEGODrawerModel.subTitle = new LEGODrawerModel.WidgetModel();
                lEGODrawerModel.subTitle.text = str;
                return lEGODrawerModel;
            }
        };
        r8.addMinorBtn(lEGOBtnTextAndCallback);
        r8.setmBackPressedEnabled(false);
        DiCardVerifyTracker.trackDeduct(1);
        return LEGOUICreator.showDrawerTemplate(fragmentActivity, r8);
    }

    public static LEGODrawer showVerifyFailureDialog(FragmentActivity fragmentActivity, final String str, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2, final View.OnClickListener onClickListener3) {
        String string = fragmentActivity.getResources().getString(R.string.didi_security_card_verify_verify_failure_dialog_title);
        String string2 = fragmentActivity.getResources().getString(R.string.didi_security_card_verify_verify_failure_dialog_negative);
        String string3 = fragmentActivity.getResources().getString(R.string.didi_security_card_verify_verify_failure_dialog_positive);
        C163947 r3 = new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                DiCardVerifyTracker.trackFailedService(2);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        };
        LEGOBtnTextAndCallback lEGOBtnTextAndCallback = new LEGOBtnTextAndCallback(string2, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                DiCardVerifyTracker.trackFailedService(3);
                View.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        C163969 r8 = new LEGOBaseDrawerModel(string, new LEGOBtnTextAndCallback(string3, r3)) {
            /* access modifiers changed from: protected */
            public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
                lEGODrawerModel.isTwoBtnHorizontal = false;
                lEGODrawerModel.clickOutsideCanCancel = false;
                lEGODrawerModel.isShowCloseImg = true;
                lEGODrawerModel.mCloseImgListener = new LEGOOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        if (onClickListener3 != null) {
                            onClickListener3.onClick(view);
                        }
                    }
                };
                lEGODrawerModel.subTitle = new LEGODrawerModel.WidgetModel();
                lEGODrawerModel.subTitle.text = str;
                return lEGODrawerModel;
            }
        };
        r8.addMinorBtn(lEGOBtnTextAndCallback);
        r8.setmBackPressedEnabled(false);
        DiCardVerifyTracker.trackFailedService(1);
        return LEGOUICreator.showDrawerTemplate(fragmentActivity, r8);
    }
}
