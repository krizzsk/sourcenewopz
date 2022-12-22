package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeAmountStatus;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001e\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010!\"\u0004\b<\u0010#R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010!\"\u0004\bE\u0010#R \u0010F\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\f\"\u0004\bN\u0010\u000eR\u001e\u0010O\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bP\u00100\"\u0004\bQ\u00102R\u001c\u0010R\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\f\"\u0004\bT\u0010\u000eR\u001c\u0010U\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\f\"\u0004\bW\u0010\u000eR\u001c\u0010X\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\f\"\u0004\bZ\u0010\u000eR\u0013\u0010[\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b\\\u0010!R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001e\u0010i\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bj\u00100\"\u0004\bk\u00102¨\u0006l"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountSection;", "Ljava/io/Serializable;", "()V", "accountBalance", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountBalance;", "getAccountBalance", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountBalance;", "setAccountBalance", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountBalance;)V", "accountSectionName", "", "getAccountSectionName", "()Ljava/lang/String;", "setAccountSectionName", "(Ljava/lang/String;)V", "accountStatus", "Lcom/didi/payment/base/service/IWalletService$AccountInfo;", "getAccountStatus", "()Lcom/didi/payment/base/service/IWalletService$AccountInfo;", "setAccountStatus", "(Lcom/didi/payment/base/service/IWalletService$AccountInfo;)V", "accountStatusMessage", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountStatusMessage;", "getAccountStatusMessage", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountStatusMessage;", "setAccountStatusMessage", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountStatusMessage;)V", "authenticationStatus", "getAuthenticationStatus", "setAuthenticationStatus", "awardMessage", "Lcom/didi/payment/base/view/PayRichInfo;", "getAwardMessage", "()Lcom/didi/payment/base/view/PayRichInfo;", "setAwardMessage", "(Lcom/didi/payment/base/view/PayRichInfo;)V", "bankCard", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BankCard;", "getBankCard", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BankCard;", "setBankCard", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BankCard;)V", "bgPicUrl", "getBgPicUrl", "setBgPicUrl", "bhasInterest", "", "getBhasInterest", "()Ljava/lang/Boolean;", "setBhasInterest", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "button", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Button;", "getButton", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Button;", "setButton", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Button;)V", "cashBackMessage", "getCashBackMessage", "setCashBackMessage", "coupon", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Coupon;", "getCoupon", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Coupon;", "setCoupon", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Coupon;)V", "detailsMessage", "getDetailsMessage", "setDetailsMessage", "disposalSection", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/DisposalSection;", "getDisposalSection", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/DisposalSection;", "setDisposalSection", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/DisposalSection;)V", "fullKycStatus", "getFullKycStatus", "setFullKycStatus", "hiddenDetailMessage", "getHiddenDetailMessage", "setHiddenDetailMessage", "interestDetailMsg", "getInterestDetailMsg", "setInterestDetailMsg", "interestStatus", "getInterestStatus", "setInterestStatus", "kycStatus", "getKycStatus", "setKycStatus", "localDetailMessage", "getLocalDetailMessage", "marketingArea", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/PrepaidStatus;", "getMarketingArea", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/PrepaidStatus;", "setMarketingArea", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/PrepaidStatus;)V", "prepaidCardInfo", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/PrepaidInfo;", "getPrepaidCardInfo", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/PrepaidInfo;", "setPrepaidCardInfo", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/PrepaidInfo;)V", "supportFullKyc", "getSupportFullKyc", "setSupportFullKyc", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection */
/* compiled from: WalletHomeModel.kt */
public final class AccountSection implements Serializable {
    private AccountBalance accountBalance;
    private String accountSectionName;
    private IWalletService.AccountInfo accountStatus;
    private AccountStatusMessage accountStatusMessage;
    private String authenticationStatus;
    private PayRichInfo awardMessage;
    private BankCard bankCard;
    private String bgPicUrl;
    private Boolean bhasInterest;
    private Button button;
    private PayRichInfo cashBackMessage;
    private Coupon coupon;
    private PayRichInfo detailsMessage;
    @SerializedName("disposalInfo")
    private DisposalSection disposalSection;
    private String fullKycStatus;
    private Boolean hiddenDetailMessage;
    private String interestDetailMsg;
    private String interestStatus;
    private String kycStatus;
    private PrepaidStatus marketingArea;
    private PrepaidInfo prepaidCardInfo;
    private Boolean supportFullKyc;

    public final AccountBalance getAccountBalance() {
        return this.accountBalance;
    }

    public final void setAccountBalance(AccountBalance accountBalance2) {
        this.accountBalance = accountBalance2;
    }

    public final String getAccountSectionName() {
        return this.accountSectionName;
    }

    public final void setAccountSectionName(String str) {
        this.accountSectionName = str;
    }

    public final AccountStatusMessage getAccountStatusMessage() {
        return this.accountStatusMessage;
    }

    public final void setAccountStatusMessage(AccountStatusMessage accountStatusMessage2) {
        this.accountStatusMessage = accountStatusMessage2;
    }

    public final BankCard getBankCard() {
        return this.bankCard;
    }

    public final void setBankCard(BankCard bankCard2) {
        this.bankCard = bankCard2;
    }

    public final String getBgPicUrl() {
        return this.bgPicUrl;
    }

    public final void setBgPicUrl(String str) {
        this.bgPicUrl = str;
    }

    public final Button getButton() {
        return this.button;
    }

    public final void setButton(Button button2) {
        this.button = button2;
    }

    public final Coupon getCoupon() {
        return this.coupon;
    }

    public final void setCoupon(Coupon coupon2) {
        this.coupon = coupon2;
    }

    public final DisposalSection getDisposalSection() {
        return this.disposalSection;
    }

    public final void setDisposalSection(DisposalSection disposalSection2) {
        this.disposalSection = disposalSection2;
    }

    public final PayRichInfo getDetailsMessage() {
        return this.detailsMessage;
    }

    public final void setDetailsMessage(PayRichInfo payRichInfo) {
        this.detailsMessage = payRichInfo;
    }

    public final PayRichInfo getLocalDetailMessage() {
        if (WalletHomeAmountStatus.Companion.isShowAmount()) {
            return this.detailsMessage;
        }
        if (!Intrinsics.areEqual((Object) this.hiddenDetailMessage, (Object) true)) {
            return this.detailsMessage;
        }
        PayRichInfo payRichInfo = new PayRichInfo();
        payRichInfo.text = WalletHomeAmountStatus.Companion.getEncryptionStr(3);
        PayRichInfo detailsMessage2 = getDetailsMessage();
        payRichInfo.infoList = detailsMessage2 == null ? null : detailsMessage2.infoList;
        return payRichInfo;
    }

    public final String getFullKycStatus() {
        return this.fullKycStatus;
    }

    public final void setFullKycStatus(String str) {
        this.fullKycStatus = str;
    }

    public final String getInterestDetailMsg() {
        return this.interestDetailMsg;
    }

    public final void setInterestDetailMsg(String str) {
        this.interestDetailMsg = str;
    }

    public final String getKycStatus() {
        return this.kycStatus;
    }

    public final void setKycStatus(String str) {
        this.kycStatus = str;
    }

    public final IWalletService.AccountInfo getAccountStatus() {
        return this.accountStatus;
    }

    public final void setAccountStatus(IWalletService.AccountInfo accountInfo) {
        this.accountStatus = accountInfo;
    }

    public final String getAuthenticationStatus() {
        return this.authenticationStatus;
    }

    public final void setAuthenticationStatus(String str) {
        this.authenticationStatus = str;
    }

    public final String getInterestStatus() {
        return this.interestStatus;
    }

    public final void setInterestStatus(String str) {
        this.interestStatus = str;
    }

    public final Boolean getSupportFullKyc() {
        return this.supportFullKyc;
    }

    public final void setSupportFullKyc(Boolean bool) {
        this.supportFullKyc = bool;
    }

    public final Boolean getBhasInterest() {
        return this.bhasInterest;
    }

    public final void setBhasInterest(Boolean bool) {
        this.bhasInterest = bool;
    }

    public final Boolean getHiddenDetailMessage() {
        return this.hiddenDetailMessage;
    }

    public final void setHiddenDetailMessage(Boolean bool) {
        this.hiddenDetailMessage = bool;
    }

    public final PayRichInfo getAwardMessage() {
        return this.awardMessage;
    }

    public final void setAwardMessage(PayRichInfo payRichInfo) {
        this.awardMessage = payRichInfo;
    }

    public final PayRichInfo getCashBackMessage() {
        return this.cashBackMessage;
    }

    public final void setCashBackMessage(PayRichInfo payRichInfo) {
        this.cashBackMessage = payRichInfo;
    }

    public final PrepaidStatus getMarketingArea() {
        return this.marketingArea;
    }

    public final void setMarketingArea(PrepaidStatus prepaidStatus) {
        this.marketingArea = prepaidStatus;
    }

    public final PrepaidInfo getPrepaidCardInfo() {
        return this.prepaidCardInfo;
    }

    public final void setPrepaidCardInfo(PrepaidInfo prepaidInfo) {
        this.prepaidCardInfo = prepaidInfo;
    }
}
