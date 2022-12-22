package com.didi.universal.pay.sdk.util;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.feature.DidiAddCardData;
import com.didi.payment.paymethod.open.DidiSignFactory;
import com.didi.payment.paymethod.open.param.SignParam;

public class UniversalSignUtil {

    public interface SignCallback {
        void onResult(boolean z, String str);
    }

    public static void goSignVisa(FragmentActivity fragmentActivity, int i, int i2, String str, int i3, int i4, final SignCallback signCallback) {
        if (fragmentActivity != null && signCallback != null) {
            if (i2 == 7) {
                SignParam signParam = new SignParam();
                signParam.bindType = 4;
                signParam.channelId = i;
                DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                addCardParam.bindType = 4;
                addCardParam.orderId = str;
                addCardParam.isSignAfterOrder = true;
                addCardParam.productLine = "" + i3;
                signParam.globalCreditCardParam = addCardParam;
                DidiSignFactory.createSignApi().sign((Activity) fragmentActivity, signParam, (com.didi.payment.paymethod.open.callback.SignCallback) new com.didi.payment.paymethod.open.callback.SignCallback() {
                    public void onPullStart() {
                    }

                    public void onResult(int i, String str, String str2) {
                        if (i == 0) {
                            signCallback.onResult(true, str);
                        } else {
                            signCallback.onResult(false, str);
                        }
                    }
                });
                return;
            }
            SignParam signParam2 = new SignParam();
            signParam2.bindType = 4;
            signParam2.channelId = i;
            DidiAddCardData.Param param = new DidiAddCardData.Param();
            param.bindType = 4;
            param.orderId = str;
            param.isSignAfterOrder = true;
            param.productLine = "" + i3;
            signParam2.creditCardParam = param;
            DidiSignFactory.createSignApi().sign((Activity) fragmentActivity, signParam2, (com.didi.payment.paymethod.open.callback.SignCallback) new com.didi.payment.paymethod.open.callback.SignCallback() {
                public void onPullStart() {
                }

                public void onResult(int i, String str, String str2) {
                    if (i == 0) {
                        signCallback.onResult(true, str);
                    } else {
                        signCallback.onResult(false, str);
                    }
                }
            });
        }
    }

    public static void goSignZft(FragmentActivity fragmentActivity, final SignCallback signCallback) {
        if (fragmentActivity != null && signCallback != null) {
            SignParam signParam = new SignParam();
            signParam.bindType = 4;
            signParam.channelId = 162;
            DidiSignFactory.createSignApi().sign((Activity) fragmentActivity, signParam, (com.didi.payment.paymethod.open.callback.SignCallback) new com.didi.payment.paymethod.open.callback.SignCallback() {
                public void onPullStart() {
                }

                public void onResult(int i, String str, String str2) {
                    if (i == 0) {
                        signCallback.onResult(true, str);
                    } else {
                        signCallback.onResult(false, str);
                    }
                }
            });
        }
    }

    public static void goSignPayPal(FragmentActivity fragmentActivity, final SignCallback signCallback) {
        if (fragmentActivity != null && signCallback != null) {
            SignParam signParam = new SignParam();
            signParam.bindType = 4;
            signParam.channelId = 152;
            DidiSignFactory.createSignApi().sign((Activity) fragmentActivity, signParam, (com.didi.payment.paymethod.open.callback.SignCallback) new com.didi.payment.paymethod.open.callback.SignCallback() {
                public void onPullStart() {
                }

                public void onResult(int i, String str, String str2) {
                    if (i == 0) {
                        signCallback.onResult(true, str);
                    } else {
                        signCallback.onResult(false, str);
                    }
                }
            });
        }
    }

    public static void goSignDDCredit(FragmentActivity fragmentActivity, final SignCallback signCallback) {
        SignParam signParam = new SignParam();
        signParam.bindType = 4;
        signParam.channelId = 161;
        DidiSignFactory.createSignApi().sign((Activity) fragmentActivity, signParam, (com.didi.payment.paymethod.open.callback.SignCallback) new com.didi.payment.paymethod.open.callback.SignCallback() {
            public void onPullStart() {
            }

            public void onResult(int i, String str, String str2) {
                if (i == 0) {
                    signCallback.onResult(true, str);
                } else {
                    signCallback.onResult(false, str);
                }
            }
        });
    }

    public static void goSignNineNinePay() {
        DRouter.build("99OneTravel://one/nativeWallet").start();
    }
}
