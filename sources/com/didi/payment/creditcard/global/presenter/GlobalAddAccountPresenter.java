package com.didi.payment.creditcard.global.presenter;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ComponentError;
import com.adyen.checkout.redirect.RedirectUtil;
import com.didi.component.framework.pages.carcheck.CarCheckActivity;
import com.didi.global.fintech.cashier.threeds.cvv.GlobalCashierCVVActivity;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.proxy.FireBaseProxyHolder;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.creditcard.global.contract.CreditCardAddContract;
import com.didi.payment.creditcard.global.model.BrowserInfo;
import com.didi.payment.creditcard.global.model.CreditCardModel;
import com.didi.payment.creditcard.global.model.SignCardParam;
import com.didi.payment.creditcard.global.model.ThreeDSInfo;
import com.didi.payment.creditcard.global.model.bean.OCRVerifyInfo;
import com.didi.payment.creditcard.global.model.bean.PollResult;
import com.didi.payment.creditcard.global.model.bean.PublicKeyInfo;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import com.didi.payment.creditcard.global.model.bean.SignThreeDSResult;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.p130v2.utils.BindCardApolloUtils;
import com.didi.payment.creditcard.global.utils.CardEncryption;
import com.didi.sdk.audiorecorder.helper.AudioUploader;
import com.didi.sdk.p146ad.model.AdParams;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.didi.unifiedPay.util.UnipayAppUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.gbankcard.ocr.ScanCardHelper;
import com.taxis99.R;
import global.didi.pay.threeds.ThreeDSFactory;
import global.didi.pay.threeds.contract.IAdyen3DS;
import global.didi.pay.threeds.contract.ICybs3DS;
import global.didi.pay.threeds.method.adyen.IAdyen3DSListener;
import global.didi.pay.threeds.method.cybs.ICybs3DSListener;
import global.didi.pay.threeds.model.Cybs3DSModel;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import global.didi.pay.threeds.network.model.ThreedsError;
import global.didi.pay.threeds.utils.ThreeDSUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

public class GlobalAddAccountPresenter implements CreditCardAddContract.IPresenter {
    public static final int CARD_FLAG_ADD = 1;
    public static final int CARD_FLAG_REPLACE = 2;

    /* renamed from: l */
    private static String f30403l;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CreditCardAddContract.IView f30404a;

    /* renamed from: b */
    private CreditCardModel f30405b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f30406c;

    /* renamed from: d */
    private long f30407d;

    /* renamed from: e */
    private long f30408e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CountDownTimer f30409f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SignResult f30410g;

    /* renamed from: h */
    private int f30411h = 150;

    /* renamed from: i */
    private int f30412i;

    /* renamed from: j */
    private String f30413j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f30414k;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ThreeDSInfo f30415m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public IAdyen3DS f30416n;

    /* renamed from: o */
    private ICybs3DS f30417o;

    /* renamed from: p */
    private Map<String, Object> f30418p;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m21367a(int i) {
        switch (i) {
            case 16100:
            case 16101:
            case 16102:
            case 16103:
            case 16104:
            case 16105:
            case 16106:
            case 16107:
            case 16108:
                return true;
            default:
                return false;
        }
    }

    public GlobalAddAccountPresenter(CreditCardAddContract.IView iView, String str, int i) {
        this.f30404a = iView;
        this.f30413j = str;
        this.f30414k = i;
        this.f30405b = new CreditCardModel(iView.getContext());
        this.f30407d = System.currentTimeMillis();
    }

    public void requestPublicKey(SignCardParam signCardParam) {
        if (signCardParam == null || signCardParam.isAydenVendor()) {
            this.f30405b.queryPublicKey(this.f30411h, new RpcService.Callback<PublicKeyInfo>() {
                public void onSuccess(PublicKeyInfo publicKeyInfo) {
                    if (publicKeyInfo.errno != 0) {
                        GlobalAddAccountPresenter.this.f30404a.showToast(GlobalAddAccountPresenter.this.f30404a.getContext().getString(R.string.one_payment_creditcard_global_net_connerror));
                    }
                    String unused = GlobalAddAccountPresenter.this.f30406c = publicKeyInfo.publicKey;
                }

                public void onFailure(IOException iOException) {
                    GlobalAddAccountPresenter.this.f30404a.showToast(GlobalAddAccountPresenter.this.f30404a.getContext().getString(R.string.one_payment_creditcard_global_net_connerror));
                }
            });
        }
    }

    public boolean checkPublicKey(SignCardParam signCardParam) {
        if ((signCardParam != null && !signCardParam.isAydenVendor()) || !TextUtils.isEmpty(this.f30406c)) {
            return true;
        }
        requestPublicKey(signCardParam);
        return false;
    }

    public void pollSignResult() {
        SignResult signResult = this.f30410g;
        if (signResult != null) {
            m21359a(signResult.pollingTimes, this.f30410g.pollingFrequency);
        }
    }

    public void ocrVerify(String str, String str2, String str3, int i, boolean z, String str4, String str5, SignCardParam signCardParam, String str6) {
        SignCardParam signCardParam2 = signCardParam;
        m21365a(CardEncryption.getInstance().getEncryptedRiskInfoString(this.f30404a.getContext(), str, str2, str3, i, z, str4, this.f30408e, str5, signCardParam, str6), CardEncryption.getInstance().getEncryptedAesKey(), signCardParam2 != null ? signCardParam2.vendorType : "new");
    }

    public void onDestory() {
        IAdyen3DS iAdyen3DS = this.f30416n;
        if (iAdyen3DS != null) {
            iAdyen3DS.unregisterListener();
        }
        ICybs3DS iCybs3DS = this.f30417o;
        if (iCybs3DS != null) {
            iCybs3DS.unregisterListener();
        }
    }

    public void commit(int i, String str, String str2, String str3, int i2, int i3, boolean z, String str4, SignCardParam signCardParam, String str5, String str6) {
        commit(i, str, str2, str3, i2, i3, z, str4, signCardParam, str5, (ThreedsCybsDataResponse) null, str6);
    }

    public void commit(int i, String str, String str2, String str3, int i2, int i3, boolean z, String str4, SignCardParam signCardParam, String str5, ThreedsCybsDataResponse threedsCybsDataResponse, String str6) {
        String str7;
        String str8 = str;
        String str9 = str2;
        String str10 = str3;
        SignCardParam signCardParam2 = signCardParam;
        this.f30408e = System.currentTimeMillis() - this.f30407d;
        String encryptedAesKey = CardEncryption.getInstance().getEncryptedAesKey();
        if (signCardParam.isAydenVendor()) {
            checkPublicKey(signCardParam2);
            str7 = CardEncryption.getInstance().getAydenEncryptedCardInfoString(this.f30406c, str8, str9, str10);
        } else {
            str7 = CardEncryption.getInstance().getOtherEncryptedCardInfoString(str8, str9, str10);
        }
        m21360a(i, str7, CardEncryption.getInstance().getOtherEncryptedCardInfoString(str8, str9, str10), CardEncryption.getInstance().getEncryptedRiskInfoString(this.f30404a.getContext(), str, str2, str3, i2, z, str4, this.f30408e, "", signCardParam, str6), encryptedAesKey, i3, i2, signCardParam2.bindType > 0 ? signCardParam2.bindType : 5, signCardParam2.vendorType, signCardParam2.isSupportOcrVerify, str5, signCardParam2.appId, signCardParam2.productId, threedsCybsDataResponse);
        this.f30407d = System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m21360a(int i, String str, String str2, String str3, String str4, int i2, int i3, int i4, String str5, boolean z, String str6, String str7, String str8, ThreedsCybsDataResponse threedsCybsDataResponse) {
        this.f30412i = i4;
        CreditCardAddContract.IView iView = this.f30404a;
        iView.showMaskLoadingDialog(iView.getContext().getString(R.string.one_payment_creditcard_global_net_querying));
        if (f30403l == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                BrowserInfo browserInfo = new BrowserInfo();
                WebView webView = new WebView(this.f30404a.getContext());
                browserInfo.userAgent = webView.getSettings().getUserAgentString();
                webView.destroy();
                jSONObject.put(AdParams.USER_AGENT, browserInfo.userAgent);
                jSONObject.put("acceptHeader", browserInfo.acceptHeader);
            } catch (Exception e) {
                e.printStackTrace();
            }
            f30403l = jSONObject.toString();
        }
        HashMap hashMap = new HashMap();
        this.f30418p = hashMap;
        String str9 = str5;
        hashMap.put("vendor_type", str5);
        this.f30418p.put("bind_type", Integer.valueOf(i4));
        this.f30418p.put("channel_id", 150);
        String str10 = str3;
        this.f30418p.put("risk_info", str3);
        String str11 = str;
        this.f30418p.put("bankcard_info", str);
        String str12 = str2;
        this.f30418p.put(GlobalCashierCVVActivity.ARGS_CARD_INFO, str2);
        String str13 = str4;
        this.f30418p.put(AudioUploader.REQ_PARAMS.ENCRYPT_KEY, str4);
        this.f30418p.put("utc_offset", PayBaseParamUtil.getStringParam(this.f30404a.getContext(), "utc_offset"));
        if (i3 > 0) {
            this.f30418p.put(CarCheckActivity.CAR_TYPE, Integer.valueOf(i3));
        }
        if (i2 > 0) {
            this.f30418p.put("card_org", Integer.valueOf(i2));
        }
        if (i >= 0) {
            this.f30418p.put("card_replace", Integer.valueOf(i));
        }
        this.f30418p.put("osChannel", "Android");
        Map<String, Object> map = this.f30418p;
        map.put("returnUrl", RedirectUtil.REDIRECT_RESULT_SCHEME + this.f30404a.getContext().getPackageName());
        this.f30418p.put("browserInfo", f30403l);
        this.f30418p.put("needThreeDS", String.valueOf(ThreeDSUtils.needThreeds()));
        this.f30418p.put("resource_id", str6);
        this.f30418p.put("threeDSSDKVersion", UnipayAppUtil.getMetaDataByKey(this.f30404a.getContext(), "global.didi.pay.threeds.sdk.version"));
        if (threedsCybsDataResponse != null) {
            if (threedsCybsDataResponse.getResultOf3ds() != null) {
                this.f30418p.put("cavv", threedsCybsDataResponse.getResultOf3ds().getCavv());
                this.f30418p.put("eci", threedsCybsDataResponse.getResultOf3ds().getEci());
                this.f30418p.put("xid", threedsCybsDataResponse.getResultOf3ds().getXid());
                this.f30418p.put("transactionId", threedsCybsDataResponse.getResultOf3ds().getTransactionId());
                this.f30418p.put("authenResponse", threedsCybsDataResponse.getResultOf3ds().getAuthenResponse());
            }
            if (!TextUtils.isEmpty(threedsCybsDataResponse.getVersion())) {
                this.f30418p.put("threeDsecureVersion", threedsCybsDataResponse.getVersion());
            }
        }
        ThreeDSInfo threeDSInfo = this.f30415m;
        if (threeDSInfo != null && !TextUtils.isEmpty(threeDSInfo.threeDSVendor)) {
            this.f30418p.put("threeDSVendor", this.f30415m.threeDSVendor);
        }
        final String str14 = str6;
        final String str15 = str7;
        final String str16 = str8;
        final boolean z2 = z;
        this.f30405b.signCard(this.f30418p, new RpcService.Callback<SignResult>() {
            public void onSuccess(SignResult signResult) {
                GlobalAddAccountPresenter.this.m21366a(signResult.errNo == 0, signResult.errNo, str14, GlobalAddAccountPresenter.this.f30414k, str15, str16);
                SignResult unused = GlobalAddAccountPresenter.this.f30410g = signResult;
                if (signResult.extraValueMap != null && !TextUtils.isEmpty(signResult.extraValueMap.threeDSVendor)) {
                    ThreeDSInfo unused2 = GlobalAddAccountPresenter.this.f30415m = signResult.extraValueMap;
                    if ("adyen".equals(signResult.extraValueMap.threeDSVendor)) {
                        GlobalAddAccountPresenter.this.m21358a();
                        try {
                            JSONObject jSONObject = new JSONObject(signResult.extraValueMap.threeDSAction);
                            GlobalAddAccountPresenter.this.f30416n.handleAction(jSONObject);
                            GlobalOmegaUtils.track3dsVerifyST("card", jSONObject.optString("type", ""));
                        } catch (Exception e) {
                            e.printStackTrace();
                            GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                        }
                    } else if (!"cybersource".equals(signResult.extraValueMap.threeDSVendor)) {
                        GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                    } else if (!TextUtils.isEmpty(signResult.extraValueMap.sessionId)) {
                        GlobalAddAccountPresenter.this.m21363a(signResult.extraValueMap.sessionId);
                    } else {
                        GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                    }
                } else if (signResult.errNo == 0) {
                    if (!TextUtil.isEmpty(signResult.newSginUrl)) {
                        GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                        GlobalAddAccountPresenter.this.f30404a.openCreditCardSignPage(signResult.newSginUrl, signResult.signParam, signResult.backUrl);
                        return;
                    }
                    GlobalAddAccountPresenter.this.pollSignResult();
                } else if (signResult.errNo == 10407) {
                    GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                    if (!z2 || !ScanCardHelper.supportScan(GlobalAddAccountPresenter.this.f30404a.getContext())) {
                        GlobalAddAccountPresenter.this.f30404a.onSignFail(signResult);
                    } else {
                        GlobalAddAccountPresenter.this.f30404a.showOcrConfirmDialog();
                    }
                } else if (signResult.errNo == 10608) {
                    GlobalAddAccountPresenter.this.pollSignResult();
                } else if (signResult.errNo == 100010) {
                    GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                    GlobalAddAccountPresenter.this.f30404a.showSignFailureGuideDialog(signResult.dialogTitle, signResult.errMsg, signResult.dialogConfirmBtn, signResult.dialogCancelBtn);
                } else if (signResult.errNo == 12011) {
                    GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                    GlobalAddAccountPresenter.this.f30404a.showCardUpdateConfirmDialog();
                } else if (GlobalAddAccountPresenter.this.m21367a(signResult.errNo)) {
                    GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                    GlobalAddAccountPresenter.this.f30404a.onSignFail(signResult);
                } else {
                    GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                    GlobalAddAccountPresenter.this.f30404a.showBindFailureDialog(signResult);
                }
            }

            public void onFailure(IOException iOException) {
                GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                SignResult signResult = new SignResult();
                signResult.errMsg = GlobalAddAccountPresenter.this.f30404a.getContext().getString(R.string.one_payment_creditcard_global_net_serverbusy);
                signResult.errNo = -1;
                GlobalAddAccountPresenter.this.m21366a(false, signResult.errNo, str14, GlobalAddAccountPresenter.this.f30414k, str15, str16);
                GlobalAddAccountPresenter.this.f30404a.onSignFail(signResult);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21358a() {
        if (this.f30416n == null) {
            IAdyen3DS adyen3DS = ThreeDSFactory.getAdyen3DS((FragmentActivity) this.f30404a.getActivity());
            this.f30416n = adyen3DS;
            adyen3DS.registerListener(new IAdyen3DSListener() {
                public void onSuccess(ActionComponentData actionComponentData) {
                    if (actionComponentData != null) {
                        GlobalAddAccountPresenter.this.m21364a(actionComponentData.getDetails().toString(), actionComponentData.getPaymentData());
                        GlobalOmegaUtils.track3dsVerifyResultEx("", "", "card", actionComponentData.getPaymentData(), 0);
                    }
                }

                public void onFailure(ComponentError componentError) {
                    GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                    if (componentError != null) {
                        GlobalAddAccountPresenter.this.f30404a.showToast(componentError.getErrorMessage());
                    }
                    GlobalOmegaUtils.track3dsVerifyResultEx("", componentError.getErrorMessage(), "card", "", 0);
                }

                public void onCancel() {
                    try {
                        GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                        GlobalAddAccountPresenter.this.f30404a.showToast(GlobalAddAccountPresenter.this.f30404a.getContext().getString(R.string.threeds_fail_message));
                        GlobalOmegaUtils.track3dsVerifyResultEx("", "", "card", "", 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21363a(String str) {
        if (this.f30417o == null) {
            ICybs3DS cybs3DS = ThreeDSFactory.getCybs3DS((FragmentActivity) this.f30404a.getActivity());
            this.f30417o = cybs3DS;
            cybs3DS.registerListener(new ICybs3DSListener() {
                public void onSuccess(ThreedsCybsDataResponse threedsCybsDataResponse) {
                    if (threedsCybsDataResponse == null || threedsCybsDataResponse.getResultOf3ds() == null) {
                        GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                        GlobalAddAccountPresenter.this.f30404a.showToast(GlobalAddAccountPresenter.this.f30404a.getContext().getString(R.string.threeds_fail_message));
                        return;
                    }
                    GlobalAddAccountPresenter.this.f30404a.onCybs3DSSuccess(threedsCybsDataResponse);
                }

                public void onFailure(ThreedsError threedsError) {
                    GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                    if (threedsError != null) {
                        GlobalAddAccountPresenter.this.f30404a.showToast(threedsError.getMessage());
                    }
                    GlobalOmegaUtils.track3dsVerifyResultEx("", threedsError.getMessage(), "card", "", 0);
                }

                public void onCancel() {
                    try {
                        GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                        GlobalAddAccountPresenter.this.f30404a.showToast(GlobalAddAccountPresenter.this.f30404a.getContext().getString(R.string.threeds_fail_message));
                        GlobalOmegaUtils.track3dsVerifyResultEx("", "", "card", "", 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uid", UniPayParamUtil.getUid(this.f30404a.getContext()));
        hashMap.put("scene", "card");
        hashMap.put("order_id", "");
        this.f30417o.updateOmegaAttr(hashMap);
        Cybs3DSModel cybs3DSModel = new Cybs3DSModel();
        cybs3DSModel.sessionId = str;
        this.f30417o.handleModel(cybs3DSModel);
    }

    /* renamed from: a */
    private void m21365a(String str, String str2, String str3) {
        CreditCardAddContract.IView iView = this.f30404a;
        iView.showLoadingDialog(iView.getContext().getString(R.string.one_payment_creditcard_global_net_loading));
        this.f30405b.ocrVerify(str, str2, str3, new RpcService.Callback<OCRVerifyInfo>() {
            public void onSuccess(OCRVerifyInfo oCRVerifyInfo) {
                GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                if (oCRVerifyInfo == null) {
                    GlobalAddAccountPresenter.this.f30404a.onOcrVerifyFailure((OCRVerifyInfo) null);
                    return;
                }
                int i = oCRVerifyInfo.errNo;
                if (i == 0) {
                    GlobalAddAccountPresenter.this.f30404a.onOcrVerifySuccess();
                } else if (i != 10408) {
                    GlobalAddAccountPresenter.this.f30404a.onOcrVerifyFailure(oCRVerifyInfo);
                } else {
                    GlobalAddAccountPresenter.this.f30404a.onOcrVerifyFailure(oCRVerifyInfo);
                }
            }

            public void onFailure(IOException iOException) {
                GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                GlobalAddAccountPresenter.this.f30404a.onOcrVerifyFailure((OCRVerifyInfo) null);
            }
        });
    }

    /* renamed from: a */
    private void m21359a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            CountDownTimer countDownTimer = this.f30409f;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            final int i3 = i;
            this.f30409f = new CountDownTimer((long) (i * i2 * 1000), (long) (i2 * 1000)) {
                int time = 0;

                public void onTick(long j) {
                    int i = this.time + 1;
                    this.time = i;
                    if (i <= i3) {
                        GlobalAddAccountPresenter.this.m21370b(i);
                    }
                }

                public void onFinish() {
                    int i = this.time;
                    int i2 = i3;
                    if (i < i2) {
                        GlobalAddAccountPresenter.this.m21370b(i2);
                    }
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21370b(int i) {
        SignResult signResult = this.f30410g;
        if (signResult != null) {
            this.f30405b.querySignResult(this.f30411h, signResult.cardIndex, i, new RpcService.Callback<PollResult>() {
                public void onFailure(IOException iOException) {
                }

                public void onSuccess(PollResult pollResult) {
                    if (pollResult != null && pollResult.errNo == 0) {
                        int i = pollResult.sign_status;
                        if (i == 1) {
                            GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                            if (BindCardApolloUtils.useNewVersion()) {
                                GlobalAddAccountPresenter.this.f30404a.onSignSuccess(GlobalAddAccountPresenter.this.f30410g.cardIndex, pollResult.hint_msg);
                            } else {
                                GlobalAddAccountPresenter.this.f30404a.showToastCompleted(pollResult.hint_msg);
                                GlobalAddAccountPresenter.this.f30404a.onSignSuccess(GlobalAddAccountPresenter.this.f30410g.cardIndex);
                                EventBus.getDefault().post(new WalletRefreshDataEvent());
                            }
                            GlobalAddAccountPresenter.this.f30409f.cancel();
                        } else if (i == 2) {
                            GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                            if (!TextUtil.isEmpty(GlobalAddAccountPresenter.this.f30404a.getSignH5ErrMsg())) {
                                GlobalAddAccountPresenter.this.f30404a.showToast(GlobalAddAccountPresenter.this.f30404a.getSignH5ErrMsg());
                            } else {
                                GlobalAddAccountPresenter.this.f30404a.showToast(pollResult.hint_msg);
                            }
                            GlobalAddAccountPresenter.this.f30409f.cancel();
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21364a(String str, String str2) {
        CreditCardAddContract.IView iView = this.f30404a;
        iView.showMaskLoadingDialog(iView.getContext().getString(R.string.one_payment_creditcard_global_net_querying));
        this.f30405b.signThreeDSDetails(this.f30418p, PayBaseParamUtil.getStringParam(this.f30404a.getContext(), "token"), this.f30410g.cardIndex, this.f30415m.threeDSVendor, this.f30415m.threeDSShopper, str, str2, new RpcService.Callback<SignThreeDSResult>() {
            public void onSuccess(SignThreeDSResult signThreeDSResult) {
                if (signThreeDSResult != null && signThreeDSResult.extraValueMap != null && !TextUtils.isEmpty(signThreeDSResult.extraValueMap.threeDSShopper)) {
                    ThreeDSInfo unused = GlobalAddAccountPresenter.this.f30415m = signThreeDSResult.extraValueMap;
                    try {
                        GlobalAddAccountPresenter.this.f30416n.handleAction(new JSONObject(signThreeDSResult.extraValueMap.threeDSAction));
                        GlobalOmegaUtils.track3dsVerifyResultServerEx("card", 1);
                    } catch (Exception e) {
                        GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                        e.printStackTrace();
                    }
                } else if (signThreeDSResult.errNo == 0) {
                    GlobalAddAccountPresenter.this.pollSignResult();
                    GlobalOmegaUtils.track3dsVerifyResultServerEx("card", 1);
                } else {
                    GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                    if (!TextUtils.isEmpty(signThreeDSResult.errMsg)) {
                        GlobalAddAccountPresenter.this.f30404a.showToast(signThreeDSResult.errMsg);
                    }
                    GlobalOmegaUtils.track3dsVerifyResultServerEx("card", 2);
                }
            }

            public void onFailure(IOException iOException) {
                GlobalAddAccountPresenter.this.f30404a.dismissLoadingDialog();
                SignResult signResult = new SignResult();
                signResult.errMsg = GlobalAddAccountPresenter.this.f30404a.getContext().getString(R.string.one_payment_creditcard_global_net_serverbusy);
                signResult.errNo = -1;
                GlobalAddAccountPresenter.this.f30404a.onSignFail(signResult);
                GlobalOmegaUtils.track3dsVerifyResultServerEx("card", 0);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21366a(boolean z, int i, String str, int i2, String str2, String str3) {
        GlobalOmegaUtils.trackAddCardPageAddCK(this.f30404a.getContext(), this.f30412i, z ? 1 : 0, this.f30413j, i, str, i2, str2, str3);
        FireBaseProxyHolder.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_ADD_CK, (Map<String, Object>) null);
    }
}
