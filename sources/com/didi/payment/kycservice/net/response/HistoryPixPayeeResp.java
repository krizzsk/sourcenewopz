package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.sdk.util.collection.CollectionUtil;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/HistoryPixPayeeResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/net/response/HistoryPixPayeeResp$HistoryData;", "getData", "()Lcom/didi/payment/kycservice/net/response/HistoryPixPayeeResp$HistoryData;", "setData", "(Lcom/didi/payment/kycservice/net/response/HistoryPixPayeeResp$HistoryData;)V", "isDataValid", "", "HistoryData", "KeyInfo", "Payee", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HistoryPixPayeeResp.kt */
public final class HistoryPixPayeeResp extends WBaseResp {
    public HistoryData data;

    public HistoryData getData() {
        HistoryData historyData = this.data;
        if (historyData != null) {
            return historyData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public void setData(HistoryData historyData) {
        Intrinsics.checkNotNullParameter(historyData, "<set-?>");
        this.data = historyData;
    }

    public final boolean isDataValid() {
        return !CollectionUtil.isEmpty((Collection<?>) getData().getPayeeList());
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/HistoryPixPayeeResp$HistoryData;", "", "()V", "nextIndex", "", "getNextIndex", "()I", "setNextIndex", "(I)V", "payeeList", "", "Lcom/didi/payment/kycservice/net/response/HistoryPixPayeeResp$Payee;", "getPayeeList", "()Ljava/util/List;", "setPayeeList", "(Ljava/util/List;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HistoryPixPayeeResp.kt */
    public static final class HistoryData {
        private int nextIndex;
        public List<Payee> payeeList;
        public String title;

        public final int getNextIndex() {
            return this.nextIndex;
        }

        public final void setNextIndex(int i) {
            this.nextIndex = i;
        }

        public final String getTitle() {
            String str = this.title;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("title");
            return null;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final List<Payee> getPayeeList() {
            List<Payee> list = this.payeeList;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("payeeList");
            return null;
        }

        public final void setPayeeList(List<Payee> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.payeeList = list;
        }
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/HistoryPixPayeeResp$Payee;", "", "()V", "cpf", "", "getCpf", "()Ljava/lang/String;", "setCpf", "(Ljava/lang/String;)V", "icon", "getIcon", "setIcon", "keyList", "", "Lcom/didi/payment/kycservice/net/response/HistoryPixPayeeResp$KeyInfo;", "getKeyList", "()Ljava/util/List;", "setKeyList", "(Ljava/util/List;)V", "name", "getName", "setName", "showCpf", "getShowCpf", "setShowCpf", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HistoryPixPayeeResp.kt */
    public static final class Payee {
        private String cpf;
        private String icon;
        private List<KeyInfo> keyList;
        private String name;
        public String showCpf;

        public final String getCpf() {
            return this.cpf;
        }

        public final void setCpf(String str) {
            this.cpf = str;
        }

        public final String getShowCpf() {
            String str = this.showCpf;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("showCpf");
            return null;
        }

        public final void setShowCpf(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.showCpf = str;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final List<KeyInfo> getKeyList() {
            return this.keyList;
        }

        public final void setKeyList(List<KeyInfo> list) {
            this.keyList = list;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006'"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/HistoryPixPayeeResp$KeyInfo;", "", "()V", "accountType", "", "getAccountType", "()I", "setAccountType", "(I)V", "cardId", "", "getCardId", "()Ljava/lang/String;", "setCardId", "(Ljava/lang/String;)V", "key", "getKey", "setKey", "orgCode", "getOrgCode", "setOrgCode", "pspId", "getPspId", "setPspId", "pspName", "getPspName", "setPspName", "showCardId", "getShowCardId", "setShowCardId", "showKey", "getShowKey", "setShowKey", "type", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HistoryPixPayeeResp.kt */
    public static final class KeyInfo {
        private int accountType;
        private String cardId;
        private String key;
        private String orgCode;
        private String pspId;
        private String pspName;
        public String showCardId;
        private String showKey;
        private Integer type;

        public final Integer getType() {
            return this.type;
        }

        public final void setType(Integer num) {
            this.type = num;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final String getShowKey() {
            return this.showKey;
        }

        public final void setShowKey(String str) {
            this.showKey = str;
        }

        public final String getOrgCode() {
            return this.orgCode;
        }

        public final void setOrgCode(String str) {
            this.orgCode = str;
        }

        public final String getPspId() {
            return this.pspId;
        }

        public final void setPspId(String str) {
            this.pspId = str;
        }

        public final String getPspName() {
            return this.pspName;
        }

        public final void setPspName(String str) {
            this.pspName = str;
        }

        public final String getCardId() {
            return this.cardId;
        }

        public final void setCardId(String str) {
            this.cardId = str;
        }

        public final String getShowCardId() {
            String str = this.showCardId;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("showCardId");
            return null;
        }

        public final void setShowCardId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.showCardId = str;
        }

        public final int getAccountType() {
            return this.accountType;
        }

        public final void setAccountType(int i) {
            this.accountType = i;
        }
    }
}
