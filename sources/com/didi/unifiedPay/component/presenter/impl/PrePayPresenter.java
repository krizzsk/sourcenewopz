package com.didi.unifiedPay.component.presenter.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.activity.WebActivityIntent;
import com.didi.unifiedPay.component.model.BackKeyType;
import com.didi.unifiedPay.component.model.DownGradeInfo;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.component.model.PayState;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.presenter.AbsPaymentPresenter;
import com.didi.unifiedPay.component.presenter.PayInfoManager;
import com.didi.unifiedPay.component.view.IPrePayView;
import com.didi.unifiedPay.component.view.PayBtnState;
import com.didi.unifiedPay.component.widget.loading.FailStateDialog;
import com.didi.unifiedPay.sdk.internal.PayError;
import com.didi.unifiedPay.sdk.model.BasicBill;
import com.didi.unifiedPay.sdk.model.DetailBill;
import com.didi.unifiedPay.sdk.model.ExternalPayChannel;
import com.didi.unifiedPay.sdk.model.InternalPayChannel;
import com.didi.unifiedPay.sdk.model.PasswordModel;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayParamObject;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;
import global.didi.pay.model.LoadingState;
import global.didi.pay.threeds.model.Adyen3DSModel;
import global.didi.pay.threeds.model.Cybs3DSModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrePayPresenter extends AbsPaymentPresenter<IPrePayView> implements IPrePayView.PayViewListener {

    /* renamed from: a */
    private static final String f44381a = "PrePayPresenter";

    /* renamed from: b */
    private static final int f44382b = 1;

    /* renamed from: c */
    private static final int f44383c = 2;

    /* renamed from: d */
    private static final int f44384d = 3;

    /* renamed from: e */
    private static final int f44385e = 4;

    /* renamed from: f */
    private static final String f44386f = "ex_prepay_title_text";

    /* renamed from: g */
    private static final String f44387g = "ex_prepay_subtitle_text";

    /* renamed from: h */
    private IViewCallback f44388h;

    /* renamed from: i */
    private boolean f44389i;

    /* renamed from: j */
    private PayParam f44390j;

    /* access modifiers changed from: protected */
    public int getBid() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public String getOrderId() {
        return "";
    }

    /* access modifiers changed from: protected */
    public void initPayApi() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void onAdyenThreeDSAction(Adyen3DSModel adyen3DSModel) {
    }

    /* access modifiers changed from: protected */
    public void onCybsThreeDSAction(Cybs3DSModel cybs3DSModel) {
    }

    /* access modifiers changed from: protected */
    public void onPasswordModel(PasswordModel passwordModel) {
    }

    /* access modifiers changed from: protected */
    public void onPixCode(String str) {
    }

    /* access modifiers changed from: protected */
    public void onStartPay() {
    }

    public PrePayPresenter(Context context, FragmentManager fragmentManager, IViewCallback iViewCallback) {
        super(context, fragmentManager);
        this.f44388h = iViewCallback;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        ((IPrePayView) this.mView).onPageLoadingStart();
        if (bundle != null) {
            this.f44390j = (PayParam) bundle.getSerializable("pay_param");
        }
        getPayInfo();
    }

    public void onPageResume() {
        super.onPageResume();
        ((IPrePayView) this.mView).onPayLoadingEnd();
        ((IPrePayView) this.mView).enableAllViews(true);
    }

    /* access modifiers changed from: protected */
    public void requestPayInfoResult(boolean z, PayInfo payInfo, String str, int i) {
        ((IPrePayView) this.mView).onPageLoadingEnd();
        ((IPrePayView) this.mView).enableAllViews(true);
        if (z) {
            LogUtil.m31684d(f44381a, "PayServiceCallback onSuccess");
            m31525a(true);
            m31523a(payInfo);
            return;
        }
        LogUtil.m31684d(f44381a, "PayServiceCallback onFail");
        m31525a(false);
        m31520a(2, str, ResourcesHelper.getString(this.mContext, R.string.oc_fail_state_retry), ResourcesHelper.getString(this.mContext, R.string.oc_fail_state_cancel));
    }

    /* renamed from: a */
    private void m31525a(boolean z) {
        if (this.f44389i) {
            this.f44389i = false;
            ((IPrePayView) this.mView).onPayMethodSelected(z);
        }
    }

    /* renamed from: a */
    private void m31523a(PayInfo payInfo) {
        LogUtil.m31684d(f44381a, "handlePayInfo payInfo.payStatus = " + payInfo.payStatus + " mCurrentState = " + this.mCurrentState);
        if (this.mCurrentState != PayState.PaySuccess) {
            int i = payInfo.payStatus;
            if (i == 0) {
                m31520a(2, ResourcesHelper.getString(this.mContext, R.string.oc_pay_bill_refresh_failed));
            } else if (i == 1) {
                updatePrePaymentView(payInfo);
            } else if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        updatePrePaymentView(payInfo);
                        return;
                    } else if (i != 5) {
                        return;
                    }
                }
                onPaySuccessed(payInfo.payStatus, payInfo.statusMsg);
            } else {
                updatePrePaymentView(payInfo);
                doLoopRequest();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onQueryResult(boolean z, LoadingState loadingState, int i) {
        ((IPrePayView) this.mView).onPayLoadingStart();
    }

    public void onCloseBtnClick() {
        if (((IPrePayView) this.mView).isCloseEnabled()) {
            String lang = UniPayParamUtil.getLang();
            PayInfo payInfo = PayInfoManager.getInstance(lang).getPayInfo(getOrderId());
            if (payInfo != null && payInfo.payStatus == 2) {
                PayInfoManager.getInstance(lang).clearData();
            }
            m31519a(2, "");
        }
    }

    public void onSelectPayMethod(int i, PayChannelItem payChannelItem) {
        changePayChannel(payChannelItem.channelId, "");
        this.f44389i = true;
        LogUtil.m31684d(f44381a, "onPayItemSelected changePayInfo");
        changePayInfo(1);
    }

    public void onUnSelectPayMethod(int i, PayChannelItem payChannelItem) {
        LogUtil.m31684d(f44381a, "unSelectThirdPartItem changePayChannel");
        changePayChannel(payChannelItem.channelId, "");
        this.f44389i = true;
        LogUtil.m31684d(f44381a, "unSelectThirdPartItem changePayInfo");
        changePayInfo(1);
    }

    public void onProtocolBtnClick() {
        LogUtil.m31684d(f44381a, "onProtocolBtnClick");
        WebActivityIntent webActivityIntent = new WebActivityIntent();
        if ("zh-CN".equals(UniPayParamUtil.getLang())) {
            webActivityIntent.setWebUrl("");
        } else {
            webActivityIntent.setWebUrl("");
        }
        webActivityIntent.addFlags(268435456);
        IViewCallback iViewCallback = this.f44388h;
        if (iViewCallback != null) {
            iViewCallback.callStartActivity(webActivityIntent);
        }
    }

    public void onPayBtnClick() {
        LogUtil.m31684d(f44381a, "onPayButtonClick doPay");
        ((IPrePayView) this.mView).setPayBtnState(PayBtnState.LOADING);
        doPay(m31518a());
    }

    public void startActivityForResult(Intent intent, int i) {
        IViewCallback iViewCallback = this.f44388h;
        if (iViewCallback != null) {
            iViewCallback.callStartActivityForResult(intent, i);
        }
    }

    public boolean onBackPressed(BackKeyType backKeyType) {
        onCloseBtnClick();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPaySuccessed(int i, String str) {
        LogUtil.m31684d(f44381a, "paySuccessTraceEvent PayState = " + this.mCurrentState);
        ((IPrePayView) this.mView).onPayLoadingEnd();
        ((IPrePayView) this.mView).onPaySuccess();
        if (this.mCurrentState == PayState.PaySuccess) {
            LogUtil.m31684d(f44381a, "mCurrentState is already PaySuccess");
        } else {
            this.mCurrentState = PayState.PaySuccess;
            PayInfoManager.getInstance(UniPayParamUtil.getLang()).clearData();
        }
        m31519a(1, "");
    }

    /* access modifiers changed from: protected */
    public void onPayFailed(PayError payError, String str) {
        ((IPrePayView) this.mView).onPayLoadingEnd();
        switch (payError.errorCode) {
            case 1:
                return;
            case 2:
                if (TextUtil.isEmpty(str)) {
                    str = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_not_support);
                }
                m31520a(1, str);
                return;
            case 3:
                m31520a(4, ResourcesHelper.getString(this.mContext, R.string.scar_pay_stop_content));
                return;
            case 4:
                m31520a(1, ResourcesHelper.getString(this.mContext, R.string.oc_pay_select_channel));
                return;
            case 5:
                m31520a(3, ResourcesHelper.getString(this.mContext, R.string.oc_uni_pre_pay_retry));
                return;
            case 6:
                m31520a(1, ResourcesHelper.getString(this.mContext, R.string.oc_pay_closed));
                return;
            default:
                m31520a(3, ResourcesHelper.getString(this.mContext, R.string.oc_uni_pre_pay_retry));
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onPrePayFailed(int i, String str) {
        LogUtil.m31684d(f44381a, "PayCallback onPrePayFail = " + i);
        ((IPrePayView) this.mView).onPayLoadingEnd();
        if (i == 11) {
            m31520a(1, str);
        } else if (i == 500101) {
            m31520a(2, str);
        } else if (i == 82153) {
            m31520a(2, str);
        } else {
            m31520a(1, str);
        }
    }

    /* access modifiers changed from: protected */
    public void updatePrePaymentView(PayInfo payInfo) {
        if (payInfo == null || payInfo.billBasic == null || payInfo.billDetail == null) {
            LogUtil.m31684d(f44381a, "payInfo  is null,return");
            return;
        }
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).setPayInfo(getOrderId(), payInfo);
        BasicBill basicBill = payInfo.billBasic;
        DetailBill detailBill = payInfo.billDetail;
        m31522a(basicBill);
        m31529b(basicBill);
        m31526a(detailBill.externalChannels);
        m31524a(detailBill.payBtnTitle, detailBill.payEnable > 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31519a(int i, String str) {
        if (this.mContext instanceof Activity) {
            LogUtil.m31684d(f44381a, "setActivityResult code = " + i + " msg = " + str);
            Activity activity = (Activity) this.mContext;
            Intent intent = new Intent();
            intent.putExtra("code", i);
            intent.putExtra("message", str);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    /* renamed from: a */
    private void m31522a(BasicBill basicBill) {
        HashMap hashMap = basicBill.extra;
        if (hashMap != null && hashMap.size() > 0) {
            ((IPrePayView) this.mView).setTitle((String) hashMap.get(f44386f), (String) hashMap.get(f44387g));
        }
    }

    /* renamed from: b */
    private void m31529b(BasicBill basicBill) {
        String leftDes = basicBill.getLeftDes();
        String rightDes = basicBill.getRightDes();
        String format = UnipayTextUtil.format(basicBill.totalFee);
        if (!TextUtils.isEmpty(leftDes) || !TextUtils.isEmpty(rightDes)) {
            ((IPrePayView) this.mView).setFee(leftDes + format + rightDes);
            return;
        }
        String valueOf = UnipayTextUtil.valueOf((float) basicBill.totalFee);
        ((IPrePayView) this.mView).setFee(this.mContext.getString(R.string.oc_pay_total_fee_str, new Object[]{valueOf}));
    }

    /* renamed from: a */
    private void m31524a(String str, boolean z) {
        if (z) {
            ((IPrePayView) this.mView).setPayBtnState(PayBtnState.ENABLE);
        } else {
            ((IPrePayView) this.mView).setPayBtnState(PayBtnState.DISABLE);
        }
        ((IPrePayView) this.mView).setPayBtnText(str);
    }

    /* renamed from: a */
    private void m31526a(ExternalPayChannel[] externalPayChannelArr) {
        if (externalPayChannelArr == null || externalPayChannelArr.length <= 0) {
            ((IPrePayView) this.mView).enableChangeChannel(false);
            return;
        }
        ((IPrePayView) this.mView).updateThirdPartPayView(m31527b(externalPayChannelArr), m31530c(externalPayChannelArr), true);
    }

    /* renamed from: a */
    private PayParamObject m31518a() {
        PayTypes payMethodTypes = ((IPrePayView) this.mView).getPayMethodTypes();
        PayParamObject payParamObject = new PayParamObject();
        payParamObject.canUseEntraprisepay = payMethodTypes.canUseEntraprisepay;
        payParamObject.thirdPayType = payMethodTypes.thirdPartPayType;
        payParamObject.checkPayResultSilent = true;
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo != null && payInfo.billDetail != null) {
            DetailBill detailBill = payInfo.billDetail;
            ExternalPayChannel[] externalPayChannelArr = detailBill.externalChannels;
            int i = 0;
            if (externalPayChannelArr != null) {
                int i2 = 0;
                while (true) {
                    if (i2 < externalPayChannelArr.length) {
                        ExternalPayChannel externalPayChannel = externalPayChannelArr[i2];
                        if (externalPayChannel != null && externalPayChannel.channel_id == payParamObject.thirdPayType) {
                            payParamObject.needSign = externalPayChannel.needSign;
                            payParamObject.signData = externalPayChannel.signObj;
                            payParamObject.needInputPwd = externalPayChannel.needPasswd;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            InternalPayChannel[] internalPayChannelArr = detailBill.internalChannels;
            if (internalPayChannelArr != null) {
                while (true) {
                    if (i < internalPayChannelArr.length) {
                        InternalPayChannel internalPayChannel = internalPayChannelArr[i];
                        if (internalPayChannel != null && internalPayChannel.needPasswd == 1) {
                            payParamObject.needInputPwd = internalPayChannel.needPasswd;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        return payParamObject;
    }

    /* renamed from: a */
    private void m31520a(final int i, String... strArr) {
        if (strArr == null) {
            ((IPrePayView) this.mView).onPayFailure((FailStateDialog.Config) null);
        }
        final FailStateDialog.Config config = new FailStateDialog.Config();
        config.listener = new FailStateDialog.onClickListener() {
            public void onCancel() {
                PrePayPresenter.this.m31519a(3, "");
            }

            public void onConfirm() {
                int i = i;
                if (i == 2) {
                    config.confirmText = ResourcesHelper.getString(PrePayPresenter.this.mContext, R.string.oc_fail_state_retry);
                    PrePayPresenter.this.getPayInfo();
                } else if (i == 3) {
                    PrePayPresenter.this.onPayBtnClick();
                } else if (i == 4) {
                    PrePayPresenter.this.doLoopRequest();
                }
            }
        };
        if (strArr.length == 1) {
            config.message = strArr[0];
            config.singleButton = true;
        } else if (strArr.length == 2) {
            config.message = strArr[0];
            config.confirmText = strArr[1];
            config.singleButton = true;
        } else if (strArr.length == 3) {
            config.message = strArr[0];
            config.confirmText = strArr[1];
            config.cancelText = strArr[2];
            config.singleButton = false;
        }
        ((IPrePayView) this.mView).onPayFailure(config);
    }

    /* renamed from: b */
    private List<PayChannelItem> m31527b(ExternalPayChannel[] externalPayChannelArr) {
        DownGradeInfo downGradeInfo;
        ArrayList arrayList = new ArrayList();
        for (ExternalPayChannel externalPayChannel : externalPayChannelArr) {
            PayChannelItem payChannelItem = new PayChannelItem();
            payChannelItem.payName = externalPayChannel.name;
            payChannelItem.detail = externalPayChannel.info;
            if (3 == externalPayChannel.level) {
                downGradeInfo = new DownGradeInfo(DownGradeInfo.DownGrade.NOT_USEABLE, externalPayChannel.extension);
            } else if (1 == externalPayChannel.level) {
                downGradeInfo = new DownGradeInfo(DownGradeInfo.DownGrade.NOT_STABLE, externalPayChannel.extension);
            } else {
                downGradeInfo = new DownGradeInfo(DownGradeInfo.DownGrade.NORMAL, "");
            }
            payChannelItem.downGradeInfo = downGradeInfo;
            payChannelItem.channelId = externalPayChannel.channel_id;
            payChannelItem.isHide = false;
            payChannelItem.marketing_text = externalPayChannel.marketing_text;
            arrayList.add(payChannelItem);
        }
        return arrayList;
    }

    /* renamed from: c */
    private int m31530c(ExternalPayChannel[] externalPayChannelArr) {
        for (int i = 0; i < externalPayChannelArr.length; i++) {
            ExternalPayChannel externalPayChannel = externalPayChannelArr[i];
            if (externalPayChannel != null && externalPayChannel.selected == 1) {
                return i;
            }
        }
        return -1;
    }
}
