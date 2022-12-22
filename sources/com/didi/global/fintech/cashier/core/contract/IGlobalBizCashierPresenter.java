package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.Payment;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&JI\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0010J+\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0016\u001a\u00020\tH&J\u001c\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u001a\u001a\u00020\tH&J\u0017\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010!0 H'J\u001e\u0010\"\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010!0 H'J\b\u0010#\u001a\u00020\tH&J\b\u0010$\u001a\u00020\tH&J\b\u0010%\u001a\u00020\tH&J\u0010\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0003H&J\b\u0010(\u001a\u00020\tH&J+\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\tH&J\u0010\u0010/\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0003H&J\b\u00100\u001a\u00020\tH&J\u001e\u00101\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010!0 H&J\u001e\u00102\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010!0 H&J\u001e\u00103\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010!0 H&J\u001e\u00104\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010!0 H&J\u001e\u00105\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010!0 H&J\u0010\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u0003H&J\u0010\u00108\u001a\u00020\t2\u0006\u00107\u001a\u00020\u0003H&J\b\u00109\u001a\u00020\tH&J\b\u0010:\u001a\u00020\tH&J\u0016\u0010;\u001a\u00020\t2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H&J\u001a\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020>2\b\b\u0002\u0010A\u001a\u00020\u0007H&J\b\u0010B\u001a\u00020\tH&J\b\u0010C\u001a\u00020\tH&J\b\u0010D\u001a\u00020\tH&J\u001e\u0010E\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010!0 H&J\b\u0010F\u001a\u00020\tH&J\u0010\u0010G\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0007H&J\b\u0010H\u001a\u00020\tH&J\b\u0010I\u001a\u00020\tH&J\b\u0010J\u001a\u00020\tH&J\b\u0010K\u001a\u00020\tH&J\u0010\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0003H&J\b\u0010N\u001a\u00020\tH&¨\u0006O"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayPresenter;", "getOmegaAttr", "", "name", "getString", "id", "", "omega3dsVerifyResultSt", "", "oid", "uid", "auth", "errno", "errno_json", "is_cancel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "omega3dsVerifyServerSt", "result", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "omega3dsVerifySt", "type", "omega99PayUnfoldCk", "omegaAddCardCk", "productId", "appid", "omegaAllInstallmentCk", "omegaChangeInstallmentCk", "number", "(Ljava/lang/Integer;)V", "omegaCheckoutPayFailBtnCk", "param", "", "", "omegaCheckoutPayFailSw", "omegaCheckoutPaySuccessBtnCk", "omegaCheckoutPaySuccessSw", "omegaCheckoutReturnCk", "omegaCheckoutReturnPopupCk", "btnName", "omegaCheckoutReturnPopupSw", "omegaCheckoutSw", "clickable", "", "details", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "omegaCheckoutTopUpCk", "omegaEndsPixCodeBtnCk", "omegaEndsPixCodeSw", "omegaFailDrawerOtherCk", "omegaFailDrawerRcmdCk", "omegaFailDrawerSw", "omegaFailNoDrawerCk", "omegaFailNoDrawerSw", "omegaNetworkErrorSw", "errorCode", "omegaOrderNotExistSw", "omegaPasswordPopupSw", "omegaPasswordPopupYesCk", "omegaPayCk", "list", "", "Lcom/didi/global/fintech/cashier/model/net/response/Payment;", "omegaPayMethodCk", "payment", "selection", "omegaPaySuccessBackCk", "omegaPaySuccessCloseCk", "omegaPaySuccessSw", "omegaPlanCk", "omegaPlanSw", "omegaPolicyCk", "omegaPolicySw", "omegaPolicyToastSw", "omegaThirdUnfoldCk", "omegaTransactionFeeCk", "omegaVersionUpdateBtnCk", "buttonName", "omegaVersionUpdateSw", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPresenters.kt */
public interface IGlobalBizCashierPresenter extends IGlobalCashierPayPresenter {
    String getOmegaAttr(String str);

    String getString(int i);

    void omega3dsVerifyResultSt(String str, String str2, String str3, String str4, String str5, Integer num);

    void omega3dsVerifyServerSt(String str, String str2, Integer num);

    void omega3dsVerifySt(String str, String str2, String str3);

    void omega99PayUnfoldCk();

    void omegaAddCardCk(String str, String str2);

    void omegaAllInstallmentCk();

    void omegaChangeInstallmentCk(Integer num);

    @Deprecated(message = "废弃，但没说彻底废弃")
    void omegaCheckoutPayFailBtnCk(Map<String, ? extends Object> map);

    @Deprecated(message = "废弃，但没说彻底废弃")
    void omegaCheckoutPayFailSw(Map<String, ? extends Object> map);

    void omegaCheckoutPaySuccessBtnCk();

    void omegaCheckoutPaySuccessSw();

    void omegaCheckoutReturnCk();

    void omegaCheckoutReturnPopupCk(String str);

    void omegaCheckoutReturnPopupSw();

    void omegaCheckoutSw(Boolean bool, String str, String str2);

    void omegaCheckoutTopUpCk();

    void omegaEndsPixCodeBtnCk(String str);

    void omegaEndsPixCodeSw();

    void omegaFailDrawerOtherCk(Map<String, ? extends Object> map);

    void omegaFailDrawerRcmdCk(Map<String, ? extends Object> map);

    void omegaFailDrawerSw(Map<String, ? extends Object> map);

    void omegaFailNoDrawerCk(Map<String, ? extends Object> map);

    void omegaFailNoDrawerSw(Map<String, ? extends Object> map);

    void omegaNetworkErrorSw(String str);

    void omegaOrderNotExistSw(String str);

    void omegaPasswordPopupSw();

    void omegaPasswordPopupYesCk();

    void omegaPayCk(List<Payment> list);

    void omegaPayMethodCk(Payment payment, int i);

    void omegaPaySuccessBackCk();

    void omegaPaySuccessCloseCk();

    void omegaPaySuccessSw();

    void omegaPlanCk(Map<String, ? extends Object> map);

    void omegaPlanSw();

    void omegaPolicyCk(int i);

    void omegaPolicySw();

    void omegaPolicyToastSw();

    void omegaThirdUnfoldCk();

    void omegaTransactionFeeCk();

    void omegaVersionUpdateBtnCk(String str);

    void omegaVersionUpdateSw();

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IGlobalCashierPresenters.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void omegaPayMethodCk$default(IGlobalBizCashierPresenter iGlobalBizCashierPresenter, Payment payment, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 2;
                }
                iGlobalBizCashierPresenter.omegaPayMethodCk(payment, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: omegaPayMethodCk");
        }
    }
}
