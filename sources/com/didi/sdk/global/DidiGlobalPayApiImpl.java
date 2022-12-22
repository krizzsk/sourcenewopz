package com.didi.sdk.global;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.paymethod.open.DidiSignFactory;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.SignParam;
import com.didi.payment.wallet.global.proxy.PayPalProxy;
import com.didi.payment.wallet.open.DidiWalletFactory;
import com.didi.payment.wallet.open.param.GlobalWalletParam;
import com.didi.sdk.fastframe.entity.RpcBase;
import com.didi.sdk.global.DidiGlobalCardExpireInterceptData;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.DidiGlobalPayPalData;
import com.didi.sdk.global.DidiGlobalPayPayData;
import com.didi.sdk.global.cardexpire.CardExpireInterceptDialog;
import com.didi.sdk.global.cardexpire.CardExpiredDialog;
import com.didi.sdk.global.constant.GlobalServer;
import com.didi.sdk.global.enterprise.activity.EnterprisePaymentActivity;
import com.didi.sdk.global.paypal.activity.PayPalRouter;
import com.didi.sdk.global.paypal.model.PayPalModel;
import com.didi.sdk.global.sign.activity.GlobalPayMethodSelectActivity;
import com.didi.sdk.global.sign.activity.GlobalPayMethodSettingActivity;
import com.didi.sdk.global.sign.payselect.PayMethodSelActivity;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;
import com.didi.sdk.global.utilities.IUtilitiesProxy;
import com.didi.sdk.payment.util.NetConstant;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.io.IOException;

public class DidiGlobalPayApiImpl implements IDidiGlobalPayApi {
    public DidiGlobalPayApiImpl() {
        NetConstant.initUrl();
        GlobalServer.initUrl();
    }

    public void startPayMethodListActivity(Activity activity, int i, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        if (activity != null && payMethodListParam != null) {
            Intent intent = new Intent();
            int i2 = C1223311.f36008x8a3a0836[payMethodListParam.from.ordinal()];
            if (i2 == 1) {
                intent.setClass(activity, GlobalPayMethodSettingActivity.class);
            } else if (i2 == 2 || i2 == 3) {
                m25473a(activity, payMethodListParam.configInfo != null ? payMethodListParam.configInfo.extOmegaAttrs : "");
                return;
            } else if (i2 == 4 || i2 == 5) {
                intent.setClass(activity, GlobalPayMethodSelectActivity.class);
            }
            intent.putExtra("pay_method_list_param", payMethodListParam);
            activity.startActivityForResult(intent, i);
        }
    }

    /* renamed from: com.didi.sdk.global.DidiGlobalPayApiImpl$11 */
    static /* synthetic */ class C1223311 {

        /* renamed from: $SwitchMap$com$didi$sdk$global$DidiGlobalPayMethodListData$Entrance */
        static final /* synthetic */ int[] f36008x8a3a0836;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance[] r0 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f36008x8a3a0836 = r0
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_GUIDE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f36008x8a3a0836     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f36008x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_H5     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f36008x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f36008x8a3a0836     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_UNIFIED_PAY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.DidiGlobalPayApiImpl.C1223311.<clinit>():void");
        }
    }

    public void startPayMethodListActivity(Fragment fragment, int i, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        startPayMethodListActivity(fragment, i, payMethodListParam, (PayMethodSelectAdapter) null);
    }

    public void startPayMethodListActivity(Fragment fragment, int i, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam, PayMethodSelectAdapter payMethodSelectAdapter) {
        if (fragment != null && payMethodListParam != null) {
            Intent intent = new Intent();
            int i2 = C1223311.f36008x8a3a0836[payMethodListParam.from.ordinal()];
            boolean z = true;
            if (i2 == 1) {
                intent.setClass(fragment.getActivity(), GlobalPayMethodSettingActivity.class);
            } else if (i2 == 2 || i2 == 3) {
                m25473a(fragment.getContext(), (String) null);
                return;
            } else if (i2 == 4 || i2 == 5) {
                if (payMethodListParam == null || payMethodListParam.groupList == null || payMethodListParam.groupList.size() <= 0 || payMethodListParam.groupList.get(0).channelIds == null || payMethodListParam.groupList.get(0).channelIds.length <= 0) {
                    z = false;
                }
                if (payMethodListParam.from != DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION || !WalletApolloUtil.isNewPaySelPage() || payMethodSelectAdapter == null || !z) {
                    intent.setClass(fragment.getActivity(), GlobalPayMethodSelectActivity.class);
                } else {
                    intent.setClass(fragment.getActivity(), PayMethodSelActivity.class);
                }
            }
            intent.putExtra("pay_method_list_param", payMethodListParam);
            GlobalPayMethodSelectActivity.sAdapter = payMethodSelectAdapter;
            fragment.startActivityForResult(intent, i);
        }
    }

    /* renamed from: a */
    private void m25473a(Context context, String str) {
        GlobalWalletParam globalWalletParam = new GlobalWalletParam();
        globalWalletParam.extOmegaAttrs = str;
        PayPalProxy.setProxy(new PayPalProxy.IPayPalProxy() {
            public void startPayPalActivity(Activity activity, int i) {
                PayPalRouter.launchAddPayPalActivity(activity, i, true);
            }

            public void startPayPalDetailActivity(Activity activity, int i) {
                PayPalRouter.launchPayPalDetailActivity(activity, i);
            }
        });
        DidiWalletFactory.createGlobalWalletApi().openWallet(context, globalWalletParam);
    }

    public void startAddCreditCardActivity(Activity activity, int i, DidiGlobalAddCardData.AddCardParam addCardParam) {
        DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity(activity, i, addCardParam);
    }

    public void startAddCreditCardActivity(Fragment fragment, int i, DidiGlobalAddCardData.AddCardParam addCardParam) {
        DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity(fragment, i, addCardParam);
    }

    public void startPayPalActivity(Activity activity, int i, DidiGlobalPayPalData.AddPayPalParam addPayPalParam) {
        if (activity != null && addPayPalParam != null) {
            PayPalRouter.launchAddPayPalActivity(activity, i, addPayPalParam.isShowLoading);
        }
    }

    public void startPayPalActivity(Fragment fragment, int i, DidiGlobalPayPalData.AddPayPalParam addPayPalParam) {
        if (fragment != null && addPayPalParam != null) {
            PayPalRouter.launchAddPayPalActivity(fragment, i, addPayPalParam.isShowLoading);
        }
    }

    public void verifyPayPal(Context context, String str, final DidiGlobalPayPalData.PayPalVerifyCallback payPalVerifyCallback) {
        if (context != null && !TextUtils.isEmpty(str) && payPalVerifyCallback != null) {
            new PayPalModel(context).verifyPayPal(str, new RpcService.Callback<RpcBase>() {
                public void onSuccess(RpcBase rpcBase) {
                    if (rpcBase == null) {
                        payPalVerifyCallback.onResult(1, "");
                    }
                    if (rpcBase.errno == 0) {
                        payPalVerifyCallback.onResult(0, rpcBase.errmsg);
                    } else {
                        payPalVerifyCallback.onResult(1, rpcBase.errmsg);
                    }
                }

                public void onFailure(IOException iOException) {
                    payPalVerifyCallback.onResult(1, "");
                }
            });
        }
    }

    public void startEnterprisePaymentActivity(Activity activity, int i) {
        EnterprisePaymentActivity.launch(activity, i);
    }

    public void startEnterprisePaymentActivity(Fragment fragment, int i) {
        EnterprisePaymentActivity.launch(fragment, i);
    }

    public void startAddPayPayActivity(Activity activity, DidiGlobalPayPayData.AddPayPayParam addPayPayParam, final DidiGlobalPayPayData.PayPayCallback payPayCallback) {
        if (activity != null && addPayPayParam != null && payPayCallback != null) {
            SignParam signParam = new SignParam();
            signParam.bindType = addPayPayParam.bindType;
            signParam.channelId = 182;
            DidiSignFactory.createSignApi().sign(activity, signParam, (SignCallback) new SignCallback() {
                public void onPullStart() {
                }

                public void onResult(int i, String str, String str2) {
                    payPayCallback.onResult(i, str);
                }
            });
        }
    }

    public void startAddPayPayActivity(Fragment fragment, DidiGlobalPayPayData.AddPayPayParam addPayPayParam, final DidiGlobalPayPayData.PayPayCallback payPayCallback) {
        if (fragment != null && addPayPayParam != null && payPayCallback != null) {
            SignParam signParam = new SignParam();
            signParam.bindType = addPayPayParam.bindType;
            signParam.channelId = 182;
            DidiSignFactory.createSignApi().sign(fragment, signParam, (SignCallback) new SignCallback() {
                public void onPullStart() {
                }

                public void onResult(int i, String str, String str2) {
                    payPayCallback.onResult(i, str);
                }
            });
        }
    }

    public void startAddNewPayPalActivity(Activity activity, DidiGlobalPayPalData.AddPayPalParam addPayPalParam, final DidiGlobalPayPalData.PayPalCallback payPalCallback) {
        SignParam signParam = new SignParam();
        signParam.bindType = addPayPalParam.bindType;
        signParam.channelId = 183;
        DidiSignFactory.createSignApi().sign(activity, signParam, (SignCallback) new SignCallback() {
            public void onPullStart() {
            }

            public void onResult(int i, String str, String str2) {
                payPalCallback.onResult(i, str);
            }
        });
    }

    public void startAddNewPayPalActivity(Fragment fragment, DidiGlobalPayPalData.AddPayPalParam addPayPalParam, final DidiGlobalPayPalData.PayPalCallback payPalCallback) {
        SignParam signParam = new SignParam();
        signParam.bindType = addPayPalParam.bindType;
        signParam.channelId = 183;
        DidiSignFactory.createSignApi().sign(fragment, signParam, (SignCallback) new SignCallback() {
            public void onPullStart() {
            }

            public void onResult(int i, String str, String str2) {
                payPalCallback.onResult(i, str);
            }
        });
    }

    public void startCardExpireIntercept(Activity activity, DidiGlobalCardExpireInterceptData.CardExpireInterceptParam cardExpireInterceptParam, final DidiGlobalCardExpireInterceptData.CardExpireInterceptCallback cardExpireInterceptCallback) {
        if (activity != null && cardExpireInterceptParam != null && cardExpireInterceptCallback != null) {
            if (activity instanceof FragmentActivity) {
                new CardExpiredDialog.Builder().setIcon(cardExpireInterceptParam.icon).setCardNo(cardExpireInterceptParam.cardNo).setUpdateCardListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        cardExpireInterceptCallback.onClick(0);
                    }
                }).setChangePaymentMethodListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        cardExpireInterceptCallback.onClick(1);
                    }
                }).builder().show(((FragmentActivity) activity).getSupportFragmentManager(), "card_expired_dialog");
            } else {
                new CardExpireInterceptDialog.Builder(activity).setIcon(cardExpireInterceptParam.icon).setCardNo(cardExpireInterceptParam.cardNo).setUpdateCardListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        cardExpireInterceptCallback.onClick(0);
                    }
                }).setChangePaymentMethodListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        cardExpireInterceptCallback.onClick(1);
                    }
                }).builder().show();
            }
        }
    }

    public void startCardExpireIntercept(Fragment fragment, DidiGlobalCardExpireInterceptData.CardExpireInterceptParam cardExpireInterceptParam, DidiGlobalCardExpireInterceptData.CardExpireInterceptCallback cardExpireInterceptCallback) {
        if (fragment != null && cardExpireInterceptParam != null && cardExpireInterceptCallback != null) {
            startCardExpireIntercept((Activity) fragment.getActivity(), cardExpireInterceptParam, cardExpireInterceptCallback);
        }
    }

    public void startUtilitiesEntranceActivity(Activity activity) {
        IUtilitiesProxy iUtilitiesProxy;
        if (activity != null && (iUtilitiesProxy = (IUtilitiesProxy) ServiceLoader.load(IUtilitiesProxy.class).get()) != null) {
            iUtilitiesProxy.startUtilitiesEntranceActivity(activity);
        }
    }
}
