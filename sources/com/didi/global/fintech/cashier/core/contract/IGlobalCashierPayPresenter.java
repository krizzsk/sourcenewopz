package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.request.CVVCardInfo;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.model.net.response.PolicyData;
import com.didi.global.fintech.cashier.model.strategy.PayInfoStrategy;
import com.didi.global.fintech.cashier.model.strategy.SyncStatusStrategy;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001'J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0003H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\u001c\u0010\"\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0007H&¨\u0006("}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter;", "doPay", "", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "getFromType", "", "getPolicy", "getUniqueId", "init", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "refreshPayInfo", "afterSelectPayment", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "request3DSDetails", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "requestCVVInfo", "cardInfo", "Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "requestConfirmPolicy", "agreePolicy", "Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;", "requestPayInfo", "strategy", "Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "requestSuccessInfo", "startSyncPayResult", "Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "stopSyncPayResult", "updateBoletoConfirm", "updateCybs3DS", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "cvv", "updatePasswordToken", "token", "SyncStatusScene", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPresenters.kt */
public interface IGlobalCashierPayPresenter extends IGlobalCashierNetPresenter {

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayPresenter$SyncStatusScene;", "", "(Ljava/lang/String;I)V", "PAY", "FAST_PAY", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IGlobalCashierPresenters.kt */
    public enum SyncStatusScene {
        PAY,
        FAST_PAY
    }

    void doPay(CashierAction cashierAction);

    String getFromType();

    void getPolicy();

    String getUniqueId();

    void init(CashierParam cashierParam);

    void refreshPayInfo(List<? extends BasicPayment> list);

    void request3DSDetails(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel);

    void requestCVVInfo(CVVCardInfo cVVCardInfo);

    void requestConfirmPolicy(PolicyData policyData);

    void requestPayInfo(PayInfoStrategy payInfoStrategy);

    void requestSuccessInfo();

    void startSyncPayResult(SyncStatusStrategy syncStatusStrategy);

    void stopSyncPayResult();

    void updateBoletoConfirm();

    void updateCybs3DS(PrepayRequest.ThreeDSV2 threeDSV2, String str);

    void updatePasswordToken(String str);
}
