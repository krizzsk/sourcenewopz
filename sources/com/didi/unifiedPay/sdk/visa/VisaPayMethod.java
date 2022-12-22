package com.didi.unifiedPay.sdk.visa;

import androidx.fragment.app.FragmentActivity;
import com.didi.unifiedPay.sdk.internal.PayMethod;
import com.didi.unifiedPay.sdk.internal.UnifiedPayCallback;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.model.SignObj;
import com.didi.unifiedPay.sdk.model.VisaPayModel;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.OmegaUtils;
import com.didi.unifiedPay.util.UniPayParamUtil;
import java.util.HashMap;
import java.util.Map;

public class VisaPayMethod<T extends PrepayInfo> extends PayMethod {

    /* renamed from: a */
    private static final String f44594a = VisaPayMethod.class.getSimpleName();

    /* access modifiers changed from: protected */
    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public boolean supportSign() {
        return true;
    }

    /* access modifiers changed from: protected */
    public <T> boolean checkDataValid(T t) {
        return ((PrepayInfo) t) != null;
    }

    public void startSignPage(FragmentActivity fragmentActivity, SignObj signObj) {
        super.startSignPage(fragmentActivity, signObj);
        m31680a(100);
        HashMap hashMap = new HashMap();
        hashMap.put("city_id", Integer.valueOf(UniPayParamUtil.getStartCityId()));
        hashMap.put("passenger_id", UniPayParamUtil.getUid(this.mActivity));
        OmegaUtils.trackEvent("pas_pay_creditcard_confirm_bind_sw", (Map<String, Object>) hashMap);
    }

    public boolean onPay(PrepayInfo prepayInfo) {
        if (!super.onPay(prepayInfo)) {
            return false;
        }
        VisaPayModel visaPayModel = prepayInfo.visaPayModel;
        if (visaPayModel == null || !visaPayModel.isNeedBindCard) {
            int i = prepayInfo.resultType;
            if (i != 0 && i != 2 && i != 3 && i != 4) {
                return false;
            }
            initPayResultCheckAlarm(prepayInfo);
            return true;
        }
        m31680a(100);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean passwordCheck(PrepayInfo prepayInfo) {
        return (prepayInfo == null || prepayInfo.mPasswordModel == null || prepayInfo.resultType != 6) ? false : true;
    }

    /* renamed from: a */
    private void m31680a(int i) {
        LogUtil.m31684d(f44594a, "startBindCard");
        UnifiedPayCallback.getInstance().registerBindVisaCardCallback(new UnifiedPayCallback.BindCardCallback() {
            public void onFail(int i, String str) {
            }

            public void onSuccess() {
                VisaPayMethod.this.initPayResultCheckAlarm((PrepayInfo) null);
            }
        });
        if (this.mCallback != null) {
            this.mCallback.startBindVisaCard(i);
        }
    }

    /* renamed from: a */
    private void m31682a(boolean z) {
        if (z) {
            OmegaUtils.trackEvent("pas_hk_pay_confirm_ck");
        }
    }
}
