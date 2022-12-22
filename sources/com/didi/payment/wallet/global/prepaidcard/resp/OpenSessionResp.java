package com.didi.payment.wallet.global.prepaidcard.resp;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp;", "Ljava/io/Serializable;", "()V", "data", "Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp$Data;", "getData", "()Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp$Data;", "setData", "(Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp$Data;)V", "errmsg", "", "getErrmsg", "()Ljava/lang/String;", "setErrmsg", "(Ljava/lang/String;)V", "errno", "", "getErrno", "()Ljava/lang/Integer;", "setErrno", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Data", "ExtraInfo", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OpenSessionResp.kt */
public final class OpenSessionResp implements Serializable {
    private Data data;
    private String errmsg;
    private Integer errno;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    public final String getErrmsg() {
        return this.errmsg;
    }

    public final void setErrmsg(String str) {
        this.errmsg = str;
    }

    public final Integer getErrno() {
        return this.errno;
    }

    public final void setErrno(Integer num) {
        this.errno = num;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp$Data;", "", "()V", "extraInfo", "Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp$ExtraInfo;", "getExtraInfo", "()Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp$ExtraInfo;", "setExtraInfo", "(Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp$ExtraInfo;)V", "noPassInfo", "", "getNoPassInfo", "()Ljava/lang/String;", "setNoPassInfo", "(Ljava/lang/String;)V", "sessionId", "getSessionId", "setSessionId", "status", "getStatus", "setStatus", "verifyType", "getVerifyType", "setVerifyType", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OpenSessionResp.kt */
    public static final class Data {
        private ExtraInfo extraInfo;
        private String noPassInfo;
        private String sessionId;
        private String status;
        private String verifyType;

        public final String getSessionId() {
            return this.sessionId;
        }

        public final void setSessionId(String str) {
            this.sessionId = str;
        }

        public final ExtraInfo getExtraInfo() {
            return this.extraInfo;
        }

        public final void setExtraInfo(ExtraInfo extraInfo2) {
            this.extraInfo = extraInfo2;
        }

        public final String getNoPassInfo() {
            return this.noPassInfo;
        }

        public final void setNoPassInfo(String str) {
            this.noPassInfo = str;
        }

        public final String getStatus() {
            return this.status;
        }

        public final void setStatus(String str) {
            this.status = str;
        }

        public final String getVerifyType() {
            return this.verifyType;
        }

        public final void setVerifyType(String str) {
            this.verifyType = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp$ExtraInfo;", "", "()V", "activatedProgress", "", "getActivatedProgress", "()Ljava/lang/String;", "setActivatedProgress", "(Ljava/lang/String;)V", "applyCardAddressStatus", "getApplyCardAddressStatus", "setApplyCardAddressStatus", "faceBizCode", "getFaceBizCode", "setFaceBizCode", "faceSessionId", "getFaceSessionId", "setFaceSessionId", "kycStatus", "getKycStatus", "setKycStatus", "linkUrl", "getLinkUrl", "setLinkUrl", "paySessionId", "getPaySessionId", "setPaySessionId", "verifyPasswordStatus", "getVerifyPasswordStatus", "setVerifyPasswordStatus", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OpenSessionResp.kt */
    public static final class ExtraInfo {
        private String activatedProgress;
        private String applyCardAddressStatus;
        private String faceBizCode;
        private String faceSessionId;
        private String kycStatus;
        private String linkUrl;
        private String paySessionId;
        private String verifyPasswordStatus;

        public final String getApplyCardAddressStatus() {
            return this.applyCardAddressStatus;
        }

        public final void setApplyCardAddressStatus(String str) {
            this.applyCardAddressStatus = str;
        }

        public final String getKycStatus() {
            return this.kycStatus;
        }

        public final void setKycStatus(String str) {
            this.kycStatus = str;
        }

        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final void setLinkUrl(String str) {
            this.linkUrl = str;
        }

        public final String getFaceSessionId() {
            return this.faceSessionId;
        }

        public final void setFaceSessionId(String str) {
            this.faceSessionId = str;
        }

        public final String getFaceBizCode() {
            return this.faceBizCode;
        }

        public final void setFaceBizCode(String str) {
            this.faceBizCode = str;
        }

        public final String getActivatedProgress() {
            return this.activatedProgress;
        }

        public final void setActivatedProgress(String str) {
            this.activatedProgress = str;
        }

        public final String getPaySessionId() {
            return this.paySessionId;
        }

        public final void setPaySessionId(String str) {
            this.paySessionId = str;
        }

        public final String getVerifyPasswordStatus() {
            return this.verifyPasswordStatus;
        }

        public final void setVerifyPasswordStatus(String str) {
            this.verifyPasswordStatus = str;
        }
    }
}
