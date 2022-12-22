package com.didi.payment.pix.net.response;

import com.didi.payment.base.service.IWalletService;
import com.didi.payment.commonsdk.net.WBaseResp;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixCreate99PayAccountResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/pix/net/response/PixCreate99PayAccountResp$DataBean;", "getData", "()Lcom/didi/payment/pix/net/response/PixCreate99PayAccountResp$DataBean;", "setData", "(Lcom/didi/payment/pix/net/response/PixCreate99PayAccountResp$DataBean;)V", "DataBean", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixCreate99PayAccountResp.kt */
public final class PixCreate99PayAccountResp extends WBaseResp {
    private DataBean data;

    public final DataBean getData() {
        return this.data;
    }

    public final void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixCreate99PayAccountResp$DataBean;", "", "()V", "accountStatus", "Lcom/didi/payment/base/service/IWalletService$AccountInfo;", "getAccountStatus", "()Lcom/didi/payment/base/service/IWalletService$AccountInfo;", "setAccountStatus", "(Lcom/didi/payment/base/service/IWalletService$AccountInfo;)V", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixCreate99PayAccountResp.kt */
    public static final class DataBean {
        private IWalletService.AccountInfo accountStatus;

        public final IWalletService.AccountInfo getAccountStatus() {
            return this.accountStatus;
        }

        public final void setAccountStatus(IWalletService.AccountInfo accountInfo) {
            this.accountStatus = accountInfo;
        }
    }
}
