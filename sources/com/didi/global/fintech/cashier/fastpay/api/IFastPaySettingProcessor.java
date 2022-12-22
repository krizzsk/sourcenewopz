package com.didi.global.fintech.cashier.fastpay.api;

import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayLimitResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayStatusResponse;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH&¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/api/IFastPaySettingProcessor;", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayBaseProcessor;", "onChangeLimitChangeSuccess", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayLimitResponse;", "onPasswordInterpreted", "interpretedType", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPaySettingProcessor$PasswordInterpreted;", "onPayInfoSuccess", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "onSwitchFastPayStatusSuccess", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayStatusResponse;", "PasswordInterpreted", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPaySettingProcessor.kt */
public interface IFastPaySettingProcessor extends IFastPayBaseProcessor {

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/api/IFastPaySettingProcessor$PasswordInterpreted;", "", "(Ljava/lang/String;I)V", "TYPE_LIMIT", "TYPE_SWITCH", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IFastPaySettingProcessor.kt */
    public enum PasswordInterpreted {
        TYPE_LIMIT,
        TYPE_SWITCH
    }

    void onChangeLimitChangeSuccess(ChangePayLimitResponse changePayLimitResponse);

    void onPasswordInterpreted(PasswordInterpreted passwordInterpreted);

    void onPayInfoSuccess(FastPayInfoResponse fastPayInfoResponse);

    void onSwitchFastPayStatusSuccess(FastPayStatusResponse fastPayStatusResponse);
}
