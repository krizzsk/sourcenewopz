package com.didi.universal.pay.biz.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.universal.pay.biz.manager.UniversalPayPollManager;
import com.didi.universal.pay.biz.manager.UniversalPayPushManager;
import com.didi.universal.pay.biz.manager.listener.IUniversalPayBizManager;
import com.didi.universal.pay.biz.model.PayStatusModel;
import com.didi.universal.pay.biz.model.PollState;
import com.didi.universal.pay.biz.model.UniversalViewModel;
import com.didi.universal.pay.biz.p172ui.IUniversalPayView;
import com.didi.universal.pay.biz.util.UniversalPaymentOmegaEvents;
import com.didi.universal.pay.sdk.method.change.ChangePayMethod;
import com.didi.universal.pay.sdk.method.internal.PayMethod;
import com.didi.universal.pay.sdk.method.internal.PayMethodFactory;
import com.didi.universal.pay.sdk.method.internal.PayServiceCallback;
import com.didi.universal.pay.sdk.method.model.DetailBill;
import com.didi.universal.pay.sdk.method.model.PayBillDetail;
import com.didi.universal.pay.sdk.method.model.PayInfo;
import com.didi.universal.pay.sdk.method.model.PayParamObject;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;
import com.didi.universal.pay.sdk.method.model.UniversalPayChannelResponse;
import com.didi.universal.pay.sdk.method.model.VisaPayModel;
import com.didi.universal.pay.sdk.model.PayResult;
import com.didi.universal.pay.sdk.model.ThirdPayResult;
import com.didi.universal.pay.sdk.model.UniversalPayParams;
import com.didi.universal.pay.sdk.net.IUniversalPayHttp;
import com.didi.universal.pay.sdk.net.UniversalPayHttpFactory;
import com.didi.universal.pay.sdk.net.model.Error;
import com.didi.universal.pay.sdk.util.JsonUtil;
import com.didi.universal.pay.sdk.util.LogUtil;
import com.didi.universal.pay.sdk.util.OmegaUtils;
import com.didi.universal.pay.sdk.util.UniversalSignUtil;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class UniversalPayBizManager implements IUniversalPayBizManager {
    /* access modifiers changed from: private */
    public static final String TAG = UniversalPayBizManager.class.getSimpleName();
    private boolean firstShow = true;
    /* access modifiers changed from: private */
    public boolean isSyncByPool = false;
    /* access modifiers changed from: private */
    public boolean isSyncByTcp = false;
    private Activity mActivity;
    /* access modifiers changed from: private */
    public IUniversalPayBizManager.Result mCallBack;
    private Context mContext;
    /* access modifiers changed from: private */
    public IUniversalPayHttp mHttpManager;
    protected UniversalPayOmegaManager mOmegaManager;
    /* access modifiers changed from: private */
    public UniversalPayParams mParams;
    /* access modifiers changed from: private */
    public PayInfo mPayInfoCache;
    protected PayServiceCallback<PayInfo> mPayInfoCallback = new PayServiceCallback<PayInfo>() {
        public void onSuccess(PayInfo payInfo) {
            LogUtil.m32408d(UniversalPayBizManager.TAG, "getPayInfo onSuccess");
            UniversalPayBizManager.this.setStateToNormal();
            PayStatusModel payStatusModel = new PayStatusModel();
            payStatusModel.payStatus = payInfo.payStatus;
            payStatusModel.payStatusDetail = payInfo.payStatusDetail;
            payStatusModel.statusMsg = payInfo.statusMsg;
            if (UniversalPayBizManager.this.mCallBack != null) {
                UniversalPayBizManager.this.mCallBack.onBizFail(IUniversalPayBizManager.Action.GET_PAY_INFO, payStatusModel);
            }
            UniversalPayBizManager.this.handlePayInfo(payInfo);
            if (payInfo != null && !TextUtils.isEmpty(payInfo.toast_message)) {
                ToastHelper.showLongInfo(UniversalPayBizManager.this.getApplicationContext(), payInfo.toast_message);
            }
        }

        public void onFail(Error error) {
            LogUtil.m32408d(UniversalPayBizManager.TAG, "getPayInfo onFail");
            UniversalPayBizManager.this.setStateToNormal();
            PayInfo unused = UniversalPayBizManager.this.mPayInfoCache = null;
            UniversalPayBizManager.this.payFail(IUniversalPayBizManager.Action.GET_PAY_INFO, error);
        }
    };
    /* access modifiers changed from: private */
    public PayMethod mPayMethod;
    /* access modifiers changed from: private */
    public PayMethod.PayMethodCallback mPayMethodCallback = new PayMethod.PayMethodCallback() {
        public void onStart() {
            if (UniversalPayBizManager.this.mCallBack != null) {
                UniversalPayBizManager.this.mCallBack.onThirdPayStart(UniversalPayBizManager.this.mPayMethod.getChannelID());
            }
        }

        public void onComplete() {
            if (UniversalPayBizManager.this.mCallBack != null) {
                UniversalPayBizManager.this.mCallBack.onThirdPayComplete(UniversalPayBizManager.this.mPayMethod.getChannelID());
            }
        }

        public void onError(int i, String str) {
            UniversalPayBizManager.this.payFail(IUniversalPayBizManager.Action.PAY, new Error(i, str));
        }

        public void onPayResult(ThirdPayResult thirdPayResult) {
            UniversalPayBizManager.this.mOmegaManager.addThirdPayPoint(UniversalPaymentOmegaEvents.PAY_THIRD_PAYMENT_RESULT, thirdPayResult);
        }

        public void doSign() {
            UniversalPayBizManager universalPayBizManager = UniversalPayBizManager.this;
            universalPayBizManager.gotoSign(universalPayBizManager.mPayMethod.getChannelID());
        }

        public void startPoll() {
            UniversalPayBizManager.this.doPoll(IUniversalPayView.Action.GET_PAY_STATUS);
        }

        public void prepay(String str) {
            UniversalPayBizManager.this.mHttpManager.prepay(UniversalPayBizManager.this.mParams.wxAppid, str, UniversalPayBizManager.this.mPrepayCallback);
        }

        public void startActivityForResult(Intent intent, int i) {
            if (UniversalPayBizManager.this.mCallBack != null) {
                UniversalPayBizManager.this.mCallBack.startActivityForResult(intent, i);
            }
        }
    };
    private UniversalPayPollManager mPollManager;
    /* access modifiers changed from: private */
    public PayServiceCallback<PrepayInfo> mPrepayCallback = new PayServiceCallback<PrepayInfo>() {
        public void onSuccess(PrepayInfo prepayInfo) {
            UniversalPayBizManager.this.setStateToNormal();
            if (prepayInfo == null && UniversalPayBizManager.this.mPayMethod == null) {
                UniversalPayBizManager.this.payFail(IUniversalPayBizManager.Action.PREPAY, new Error(5, UniversalPayBizManager.this.getApplicationContext().getString(R.string.univeral_pay_fail)));
                return;
            }
            String access$1100 = UniversalPayBizManager.TAG;
            LogUtil.m32410fi(access$1100, "mPrepayCallback " + JsonUtil.jsonFromObject(prepayInfo));
            if (UniversalPayBizManager.this.hasPayed(prepayInfo)) {
                UniversalPayBizManager.this.paySuccess();
            } else if (UniversalPayBizManager.this.hasClosed(prepayInfo)) {
                UniversalPayBizManager.this.payFail(IUniversalPayBizManager.Action.PREPAY, new Error(6, UniversalPayBizManager.this.getApplicationContext().getResources().getString(R.string.universal_fail_closed)));
            } else if (!UniversalPayBizManager.this.mPayMethod.checkDataValid(prepayInfo)) {
                UniversalPayBizManager.this.payFail(IUniversalPayBizManager.Action.PREPAY, new Error(5, ""));
            } else if (!UniversalPayBizManager.this.mPayMethod.checkPaySupport(prepayInfo)) {
                UniversalPayBizManager.this.payFail(IUniversalPayBizManager.Action.PREPAY, new Error(2, UniversalPayBizManager.this.getApplicationContext().getString(R.string.universal_pay_not_support)));
            } else {
                UniversalPayBizManager.this.mPayMethod.dopay(prepayInfo);
            }
        }

        public void onFail(Error error) {
            UniversalPayBizManager.this.setStateToNormal();
            if (error == null) {
                return;
            }
            if (error.code == 80200) {
                VisaPayModel visaPayModel = new VisaPayModel();
                visaPayModel.isNeedBindCard = true;
                PrepayInfo prepayInfo = new PrepayInfo();
                prepayInfo.visaPayModel = visaPayModel;
                UniversalPayBizManager.this.mPrepayCallback.onSuccess(prepayInfo);
            } else if (error.code == 12004) {
                PrepayInfo prepayInfo2 = new PrepayInfo();
                prepayInfo2.resultType = 0;
                onSuccess(prepayInfo2);
            } else if (error.code == 10902 || error.code == 2184) {
                PrepayInfo prepayInfo3 = new PrepayInfo();
                prepayInfo3.resultType = -1;
                onSuccess(prepayInfo3);
            } else {
                UniversalPayBizManager.this.payFail(IUniversalPayBizManager.Action.PREPAY, new Error(error.code, error.msg));
            }
        }
    };
    /* access modifiers changed from: private */
    public UniversalPayPushManager mPushManager;
    /* access modifiers changed from: private */
    public IUniversalPayView mView;
    private UniversalViewModel mViewModel;

    public UniversalPayBizManager(Activity activity, UniversalPayParams universalPayParams, IUniversalPayView iUniversalPayView) {
        this.mParams = universalPayParams;
        this.mActivity = activity;
        this.mView = iUniversalPayView;
        init(activity);
    }

    public UniversalPayBizManager(Fragment fragment, UniversalPayParams universalPayParams, IUniversalPayView iUniversalPayView) {
        this.mParams = universalPayParams;
        this.mActivity = fragment.getActivity();
        this.mView = iUniversalPayView;
        init(fragment.getContext());
    }

    private void init(Context context) {
        this.mContext = context.getApplicationContext();
        UniversalPayPushManager universalPayPushManager = new UniversalPayPushManager(context);
        this.mPushManager = universalPayPushManager;
        universalPayPushManager.addListener(new UniversalPayPushManager.Listener() {
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
                if (r4 != 4) goto L_0x0059;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onReceive(java.lang.String r3, int r4, java.lang.String r5) {
                /*
                    r2 = this;
                    com.didi.universal.pay.biz.manager.UniversalPayBizManager r0 = com.didi.universal.pay.biz.manager.UniversalPayBizManager.this
                    com.didi.universal.pay.sdk.model.UniversalPayParams r0 = r0.mParams
                    if (r0 != 0) goto L_0x0009
                    return
                L_0x0009:
                    com.didi.universal.pay.biz.manager.UniversalPayBizManager r0 = com.didi.universal.pay.biz.manager.UniversalPayBizManager.this
                    com.didi.universal.pay.sdk.model.UniversalPayParams r0 = r0.mParams
                    java.lang.String r0 = r0.oid
                    boolean r0 = com.didi.sdk.util.TextUtil.isEmpty(r0)
                    if (r0 != 0) goto L_0x0026
                    com.didi.universal.pay.biz.manager.UniversalPayBizManager r0 = com.didi.universal.pay.biz.manager.UniversalPayBizManager.this
                    com.didi.universal.pay.sdk.model.UniversalPayParams r0 = r0.mParams
                    java.lang.String r0 = r0.oid
                    boolean r3 = r0.equals(r3)
                    if (r3 != 0) goto L_0x0026
                    return
                L_0x0026:
                    r3 = 1
                    if (r4 == r3) goto L_0x0054
                    r0 = 2
                    if (r4 == r0) goto L_0x0041
                    r0 = 3
                    if (r4 == r0) goto L_0x0033
                    r5 = 4
                    if (r4 == r5) goto L_0x0041
                    goto L_0x0059
                L_0x0033:
                    com.didi.universal.pay.biz.manager.UniversalPayBizManager r3 = com.didi.universal.pay.biz.manager.UniversalPayBizManager.this
                    com.didi.universal.pay.biz.manager.listener.IUniversalPayBizManager$Action r4 = com.didi.universal.pay.biz.manager.listener.IUniversalPayBizManager.Action.GET_PAY_INFO
                    com.didi.universal.pay.sdk.net.model.Error r0 = new com.didi.universal.pay.sdk.net.model.Error
                    r1 = 0
                    r0.<init>(r1, r5)
                    r3.payFail(r4, r0)
                    goto L_0x0059
                L_0x0041:
                    com.didi.universal.pay.biz.manager.UniversalPayBizManager r4 = com.didi.universal.pay.biz.manager.UniversalPayBizManager.this
                    boolean r4 = r4.isSyncByPool
                    if (r4 != 0) goto L_0x0059
                    com.didi.universal.pay.biz.manager.UniversalPayBizManager r4 = com.didi.universal.pay.biz.manager.UniversalPayBizManager.this
                    boolean unused = r4.isSyncByTcp = r3
                    com.didi.universal.pay.biz.manager.UniversalPayBizManager r3 = com.didi.universal.pay.biz.manager.UniversalPayBizManager.this
                    r3.paySuccess()
                    goto L_0x0059
                L_0x0054:
                    com.didi.universal.pay.biz.manager.UniversalPayBizManager r3 = com.didi.universal.pay.biz.manager.UniversalPayBizManager.this
                    r3.getPayInfo()
                L_0x0059:
                    com.didi.universal.pay.biz.manager.UniversalPayBizManager r3 = com.didi.universal.pay.biz.manager.UniversalPayBizManager.this
                    com.didi.universal.pay.biz.manager.UniversalPayPushManager r3 = r3.mPushManager
                    r3.release()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.universal.pay.biz.manager.UniversalPayBizManager.C147741.onReceive(java.lang.String, int, java.lang.String):void");
            }
        });
        this.mOmegaManager = new UniversalPayOmegaManager(getApplicationContext(), this.mParams);
        this.mHttpManager = UniversalPayHttpFactory.get(getApplicationContext(), this.mParams);
        UniversalPayPollManager universalPayPollManager = new UniversalPayPollManager(getApplicationContext(), this.mHttpManager);
        this.mPollManager = universalPayPollManager;
        universalPayPollManager.addListener(new UniversalPayPollManager.CallBack() {
            public void onSuccess() {
                LogUtil.m32409fi("mPollManager onSuccess");
                UniversalPayBizManager.this.paySuccess();
            }

            public void onFail(int i, PayStatusModel payStatusModel, String str) {
                LogUtil.m32409fi("mPollManager onFail-> errorCode: " + i + ", msg: " + str);
                UniversalPayBizManager.this.payFail(IUniversalPayBizManager.Action.PAY, payStatusModel, new Error(i, str), i == 3);
            }

            public void onBizFail(PayStatusModel payStatusModel) {
                if (payStatusModel == null) {
                    UniversalPayBizManager.this.mView.showContent();
                    return;
                }
                if (payStatusModel != null && payStatusModel.payStatus > 0) {
                    if (payStatusModel.payStatus == 2) {
                        UniversalPayBizManager.this.mView.showLoading(IUniversalPayView.Action.GET_PAY_STATUS, UniversalPayBizManager.this.getApplicationContext().getResources().getString(R.string.universal_paying));
                    } else if (payStatusModel.payStatus == 8) {
                        UniversalPayBizManager.this.mView.showLoading(IUniversalPayView.Action.GET_PAY_STATUS, UniversalPayBizManager.this.getApplicationContext().getResources().getString(R.string.universal_pay_getting_bill));
                    }
                }
                if (UniversalPayBizManager.this.mCallBack != null) {
                    UniversalPayBizManager.this.mCallBack.onBizFail(IUniversalPayBizManager.Action.GET_PAY_STATUS, payStatusModel);
                }
            }

            public void onPolling(int i) {
                LogUtil.m32409fi("mPollManager onPolling-> count: " + i);
            }
        });
    }

    /* access modifiers changed from: private */
    public void getPayInfo() {
        LogUtil.m32410fi(TAG, "UniversalPayBizManager getPayInfo ");
        setStateToLoading(IUniversalPayView.Action.GET_PAY_INFO, getApplicationContext().getString(R.string.universal_loading_bill));
        this.mHttpManager.getPayInfo(this.mPayInfoCallback);
    }

    public void doGetPayInfo() {
        LogUtil.m32410fi(TAG, "UniversalPayBizManager doGetPayInfo ");
        getPayInfo();
    }

    public void setCouponID(String str) {
        String str2 = TAG;
        LogUtil.m32410fi(str2, "UniversalPayBizManager setCouponID : " + str);
        this.mHttpManager.setCouponID(str);
    }

    public void setMonthlyCardIDandDeduction(String str, int i) {
        String str2 = TAG;
        LogUtil.m32410fi(str2, "UniversalPayBizManager setMonthlyCardIDandDeduction, monthlyCardID: " + str + ",deduction: " + i);
        this.mHttpManager.setMonthlyCardIDandDeduction(str, i);
    }

    public void setEnterprisePayType(int i) {
        String str = TAG;
        LogUtil.m32410fi(str, "UniversalPayBizManager setEnterprisePayType, enterprisePayType: " + i);
        this.mHttpManager.setEnterprisePayType(i);
    }

    public void setPayMethod(int i, String str) {
        String str2 = TAG;
        LogUtil.m32410fi(str2, "UniversalPayBizManager setPayMethod, channel: " + i + ", subChannel: " + str);
        this.mHttpManager.setPayMethod(i, str);
        doOmegaEvent("payCard_switchChannels_ck", i);
    }

    public void changePayInfo(int i) {
        if (i == 2) {
            setStateToLoading(IUniversalPayView.Action.CHANGE_PAY_INFO, getApplicationContext().getString(R.string.universal_loading_bill));
        }
        this.mHttpManager.changePayInfo(i, this.mPayInfoCallback);
        String str = TAG;
        LogUtil.m32410fi(str, "UniversalPayBizManager changePayInfo, changeType: " + i);
    }

    public void doPay(final IUniversalPayView.Action action) {
        doOmegaEvent("payCard_pay");
        this.mHttpManager.getPayInfo(new PayServiceCallback<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                LogUtil.m32408d(UniversalPayBizManager.TAG, "getPayInfo onSuccess");
                PayInfo unused = UniversalPayBizManager.this.mPayInfoCache = payInfo;
                PayParamObject access$1300 = UniversalPayBizManager.this.createPrePayRequestParam();
                UniversalPayBizManager universalPayBizManager = UniversalPayBizManager.this;
                PayMethod unused2 = universalPayBizManager.mPayMethod = PayMethodFactory.getMethod(universalPayBizManager.getActivity(), access$1300);
                UniversalPayBizManager.this.mPayMethod.setCallbackListener(UniversalPayBizManager.this.mPayMethodCallback);
                if (!UniversalPayBizManager.this.mPayMethod.supportSign() || access$1300.needSign != 1) {
                    UniversalPayBizManager.this.setStateToLoading(action, "");
                    if (!(UniversalPayBizManager.this.mPayMethod instanceof ChangePayMethod) || access$1300.needPwd != 1) {
                        UniversalPayBizManager.this.mHttpManager.prepay(access$1300.wxAppId, (String) null, UniversalPayBizManager.this.mPrepayCallback);
                        return;
                    }
                    PrepayInfo prepayInfo = new PrepayInfo();
                    prepayInfo.resultType = -1;
                    UniversalPayBizManager.this.mPayMethod.dopay(prepayInfo);
                    return;
                }
                UniversalPayBizManager universalPayBizManager2 = UniversalPayBizManager.this;
                universalPayBizManager2.gotoSign(universalPayBizManager2.mPayMethod.getChannelID());
            }

            public void onFail(Error error) {
                LogUtil.m32408d(UniversalPayBizManager.TAG, "getPayInfo onFail");
                PayInfo unused = UniversalPayBizManager.this.mPayInfoCache = null;
                UniversalPayBizManager.this.payFail(IUniversalPayBizManager.Action.GET_PAY_INFO, error);
            }
        });
    }

    public void doPoll(IUniversalPayView.Action action) {
        doPoll(action, PollState.OTHER);
    }

    public void doPoll(IUniversalPayView.Action action, PollState pollState) {
        if (!this.isSyncByTcp) {
            String str = null;
            int i = C1477712.$SwitchMap$com$didi$universal$pay$biz$model$PollState[pollState.ordinal()];
            if (i == 1) {
                str = getApplicationContext().getResources().getString(R.string.universal_paying);
            } else if (i == 2) {
                str = getApplicationContext().getResources().getString(R.string.universal_pay_getting_bill);
            } else if (i == 3) {
                str = getApplicationContext().getResources().getString(R.string.universal_loading_result);
            }
            this.isSyncByPool = true;
            setStateToLoading(action, str);
            this.mPollManager.start(pollState);
            doOmegaEvent("payCard_resultwait_sw");
        }
    }

    /* renamed from: com.didi.universal.pay.biz.manager.UniversalPayBizManager$12 */
    static /* synthetic */ class C1477712 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$universal$pay$biz$model$PollState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.universal.pay.biz.model.PollState[] r0 = com.didi.universal.pay.biz.model.PollState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$universal$pay$biz$model$PollState = r0
                com.didi.universal.pay.biz.model.PollState r1 = com.didi.universal.pay.biz.model.PollState.PAYING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$universal$pay$biz$model$PollState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.universal.pay.biz.model.PollState r1 = com.didi.universal.pay.biz.model.PollState.QUERY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$universal$pay$biz$model$PollState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.universal.pay.biz.model.PollState r1 = com.didi.universal.pay.biz.model.PollState.OTHER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.universal.pay.biz.manager.UniversalPayBizManager.C1477712.<clinit>():void");
        }
    }

    public void doQuit(boolean z) {
        this.mPayInfoCache = null;
        this.mPushManager.release();
        this.mHttpManager.onDestroy();
        if (z) {
            doOmegaEvent("payCard_close");
        }
    }

    public void addCallBack(IUniversalPayBizManager.Result result) {
        this.mCallBack = result;
    }

    public void getBillDetail(final IUniversalPayBizManager.BillCallback billCallback) {
        this.mHttpManager.getBillDetail(new PayServiceCallback<PayBillDetail>() {
            public void onSuccess(PayBillDetail payBillDetail) {
                IUniversalPayBizManager.BillCallback billCallback = billCallback;
                if (billCallback != null) {
                    billCallback.success(payBillDetail);
                }
            }

            public void onFail(Error error) {
                IUniversalPayBizManager.BillCallback billCallback = billCallback;
                if (billCallback != null) {
                    billCallback.fail();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void handlePayInfo(PayInfo payInfo) {
        this.mOmegaManager.initBaseParam(payInfo);
        this.mPayInfoCache = payInfo;
        onRequestPayInfoSuccess(payInfo);
        if (!isBalanceSufficient(payInfo)) {
            payFail(IUniversalPayBizManager.Action.GET_PAY_INFO, new Error(100, payInfo.statusMsg));
            return;
        }
        switch (payInfo.payStatus) {
            case 1:
                payFail(IUniversalPayBizManager.Action.GET_PAY_INFO, new Error(-1, payInfo.statusMsg));
                return;
            case 2:
                doPoll(IUniversalPayView.Action.GET_PAY_INFO, PollState.PAYING);
                return;
            case 3:
            case 5:
                paySuccess();
                return;
            case 4:
                payFail(IUniversalPayBizManager.Action.GET_PAY_INFO, new Error(4, payInfo.statusMsg));
                return;
            case 7:
                payClosed(payInfo.statusMsg);
                return;
            case 8:
                doPoll(IUniversalPayView.Action.GET_PAY_INFO, PollState.QUERY);
                return;
            default:
                payFail(IUniversalPayBizManager.Action.GET_PAY_INFO, new Error(0, payInfo.statusMsg));
                return;
        }
    }

    private void onRequestPayInfoSuccess(PayInfo payInfo) {
        if (payInfo == null || payInfo.billBasic == null || payInfo.billDetail == null) {
            LogUtil.m32408d(TAG, "payinfo  is null,return");
            return;
        }
        UniversalViewModel universalViewModel = new UniversalViewModel();
        this.mViewModel = universalViewModel;
        universalViewModel.title = UniversalViewModelManager.getTitleModel(getApplicationContext(), payInfo);
        this.mViewModel.subTitle = UniversalViewModelManager.getSubTitleModel(payInfo);
        this.mViewModel.mTotalFeeList = UniversalViewModelManager.getTotalFeeList(getApplicationContext(), this.mViewModel, payInfo);
        UniversalViewModel universalViewModel2 = this.mViewModel;
        universalViewModel2.mAboveFeeMessage = UniversalViewModelManager.getAboveLabelModel(universalViewModel2, payInfo.billDetail);
        this.mViewModel.mShowPayFee = UniversalViewModelManager.getFeeModel(payInfo.billBasic);
        this.mViewModel.paychannelsModel = UniversalViewModelManager.getPayChannelsModel(getApplicationContext(), payInfo.billDetail);
        this.mViewModel.mJumplistModel = UniversalViewModelManager.getJumpListModel(payInfo.billBasic, this.mViewModel);
        this.mViewModel.mPayModel = UniversalViewModelManager.getPayBtnModel(payInfo.billDetail, this.mViewModel);
        IUniversalPayBizManager.Result result = this.mCallBack;
        if (result != null) {
            result.onRequestPayInfoSuccess(this.mViewModel);
        }
        if (this.firstShow) {
            this.firstShow = false;
            doOmegaEvent("payCard_sw");
        }
    }

    /* access modifiers changed from: private */
    public void gotoSign(final int i) {
        doOmegaEvent(UniversalPaymentOmegaEvents.PAY_CHANNEL_SIGN_CK);
        if (i == 161) {
            UniversalSignUtil.goSignDDCredit((FragmentActivity) getActivity(), new UniversalSignUtil.SignCallback() {
                public void onResult(boolean z, String str) {
                    if (z) {
                        UniversalPayBizManager.this.setPayMethod(161, "");
                        UniversalPayBizManager.this.changePayInfo(1);
                    }
                }
            });
        } else if (i == 162) {
            UniversalSignUtil.goSignZft((FragmentActivity) getActivity(), new UniversalSignUtil.SignCallback() {
                public void onResult(boolean z, String str) {
                    if (z) {
                        UniversalPayBizManager.this.setPayMethod(162, "");
                        UniversalPayBizManager.this.changePayInfo(1);
                    }
                }
            });
        } else if (i == 150 || i == 192) {
            UniversalSignUtil.goSignVisa((FragmentActivity) getActivity(), i, this.mParams.terminalId, this.mParams.oid, this.mParams.bid, this.mParams.domain, new UniversalSignUtil.SignCallback() {
                public void onResult(boolean z, String str) {
                    if (z) {
                        UniversalPayBizManager.this.refreshOrderBillAndAutoPay(i);
                    }
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put("city_id", PayBaseParamUtil.getStringParam(getApplicationContext(), "city_id"));
            hashMap.put("passenger_id", PayBaseParamUtil.getStringParam(getApplicationContext(), "uid"));
            OmegaUtils.trackEvent("pas_pay_creditcard_confirm_bind_sw", (Map<String, Object>) hashMap);
        } else if (i == 152) {
            UniversalSignUtil.goSignPayPal((FragmentActivity) getActivity(), new UniversalSignUtil.SignCallback() {
                public void onResult(boolean z, String str) {
                    if (z) {
                        UniversalPayBizManager.this.refreshOrderBillAndAutoPay(152);
                    }
                }
            });
        } else if (i == 190) {
            UniversalSignUtil.goSignNineNinePay();
        }
    }

    /* access modifiers changed from: private */
    public void refreshOrderBillAndAutoPay(int i) {
        setStateToLoading(IUniversalPayView.Action.GET_PAY_INFO, getApplicationContext().getString(R.string.universal_loading_bill));
        setPayMethod(i, "");
        changePayInfo(1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (i == 104) {
            if (i2 != -1) {
                payFail(IUniversalPayBizManager.Action.PAY, new Error(1, getApplicationContext().getResources().getString(R.string.universal_pay_fail_title)));
            } else if (extras != null) {
                PayResult payResult = (PayResult) extras.getSerializable("BANK_PAY_RESULT");
                if (payResult.result == 1) {
                    doPoll(IUniversalPayView.Action.GET_PAY_INFO);
                } else if (payResult.result == 2) {
                    payFail(IUniversalPayBizManager.Action.PAY, new Error(5, getApplicationContext().getResources().getString(R.string.universal_pay_fail_title)));
                }
            }
        }
    }

    public UniversalPayParams getPayParams() {
        return this.mParams;
    }

    public PayInfo getPayInfoCache() {
        return this.mPayInfoCache;
    }

    /* access modifiers changed from: private */
    public void setStateToLoading(IUniversalPayView.Action action, String str) {
        LogUtil.m32409fi("setStateToLoading action: " + action);
        this.mView.showLoading(action, str);
    }

    /* access modifiers changed from: private */
    public void setStateToNormal() {
        LogUtil.m32409fi("setStateToNormal");
        this.mView.showContent();
    }

    /* access modifiers changed from: private */
    public PayParamObject createPrePayRequestParam() {
        PayParamObject payParamObject = new PayParamObject();
        payParamObject.wxAppId = this.mParams.wxAppid;
        PayInfo payInfo = this.mPayInfoCache;
        if (!(payInfo == null || payInfo.billDetail == null)) {
            DetailBill detailBill = this.mPayInfoCache.billDetail;
            UniversalPayChannelResponse[] universalPayChannelResponseArr = detailBill.internalChannels;
            if (universalPayChannelResponseArr != null) {
                for (UniversalPayChannelResponse universalPayChannelResponse : universalPayChannelResponseArr) {
                    if (universalPayChannelResponse.selected == 1 && universalPayChannelResponse.canSelect == 1) {
                        payParamObject.channelId = universalPayChannelResponse.channel_id;
                        payParamObject.needPwd = universalPayChannelResponse.needPasswd;
                    }
                }
            }
            UniversalPayChannelResponse[] universalPayChannelResponseArr2 = detailBill.externalChannels;
            if (universalPayChannelResponseArr2 != null) {
                for (UniversalPayChannelResponse universalPayChannelResponse2 : universalPayChannelResponseArr2) {
                    if (universalPayChannelResponse2.selected == 1 && universalPayChannelResponse2.canSelect == 1) {
                        payParamObject.channelId = universalPayChannelResponse2.channel_id;
                        payParamObject.needSign = universalPayChannelResponse2.needSign;
                        payParamObject.signData = universalPayChannelResponse2.signObj;
                        payParamObject.needPwd = universalPayChannelResponse2.needPasswd;
                    }
                }
            }
        }
        LogUtil.m32410fi(TAG, "getPayObject " + JsonUtil.jsonFromObject(payParamObject));
        return payParamObject;
    }

    /* access modifiers changed from: private */
    public boolean hasPayed(PrepayInfo prepayInfo) {
        if (prepayInfo == null) {
            return false;
        }
        return prepayInfo.resultType == 4 || prepayInfo.resultType == 2;
    }

    /* access modifiers changed from: private */
    public boolean hasClosed(PrepayInfo prepayInfo) {
        return prepayInfo != null && prepayInfo.resultType == 5;
    }

    /* access modifiers changed from: private */
    public Activity getActivity() {
        return this.mActivity;
    }

    /* access modifiers changed from: private */
    public Context getApplicationContext() {
        return this.mContext;
    }

    /* access modifiers changed from: private */
    public synchronized void paySuccess() {
        if (this.mCallBack != null) {
            this.mCallBack.onPaySuccess();
        }
        doOmegaEvent("payCard_suc");
    }

    private void payClosed(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getApplicationContext().getResources().getString(R.string.universal_pay_closed);
        }
        payFail(IUniversalPayBizManager.Action.CLOSED, new Error(6, str));
    }

    /* access modifiers changed from: private */
    public void payFail(IUniversalPayBizManager.Action action, Error error) {
        payFail(action, (PayStatusModel) null, error, false);
    }

    /* access modifiers changed from: private */
    public void payFail(IUniversalPayBizManager.Action action, PayStatusModel payStatusModel, Error error, boolean z) {
        IUniversalPayBizManager.Result result = this.mCallBack;
        if (result != null) {
            result.fail(action, payStatusModel, error);
        }
        doOmegaEvent("payCard_ab_sw", z);
    }

    public void doOmegaEvent(String str) {
        this.mOmegaManager.addNormalPoint(str);
    }

    public void doOmegaEvent(String str, boolean z) {
        this.mOmegaManager.addFailPoint(str, z);
    }

    public void doOmegaEvent(String str, int i) {
        UniversalViewModel universalViewModel = this.mViewModel;
        if (universalViewModel == null) {
            this.mOmegaManager.addChangePoint(str, "", "");
            return;
        }
        this.mOmegaManager.addChangePoint(str, UniversalPayMethodManager.getPayMethod(universalViewModel.paychannelsModel), UniversalPayMethodManager.getNewPayMethod(this.mViewModel.paychannelsModel, i));
    }

    private boolean isBalanceSufficient(PayInfo payInfo) {
        if (payInfo == null || payInfo.billDetail == null || payInfo.billDetail.externalChannels == null) {
            return true;
        }
        boolean z = true;
        for (UniversalPayChannelResponse universalPayChannelResponse : payInfo.billDetail.externalChannels) {
            if (universalPayChannelResponse != null && universalPayChannelResponse.selected == 1 && (universalPayChannelResponse.deposit_status == 2 || universalPayChannelResponse.deposit_status == 3)) {
                z = false;
            }
        }
        return z;
    }
}
