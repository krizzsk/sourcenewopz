package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.IValidator;
import com.didi.payment.commonsdk.net.WBaseRespTemplate;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixBankOptionResp;", "Lcom/didi/payment/commonsdk/net/WBaseRespTemplate;", "Lcom/didi/payment/kycservice/net/response/PixBankOptionResp$DataEntry;", "()V", "AccountTypeEntry", "DataEntry", "LastHistory", "PspEntry", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixBankOptionResp.kt */
public final class PixBankOptionResp extends WBaseRespTemplate<DataEntry> {

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\n¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixBankOptionResp$DataEntry;", "Ljava/io/Serializable;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "accountTypes", "", "Lcom/didi/payment/kycservice/net/response/PixBankOptionResp$AccountTypeEntry;", "getAccountTypes", "()Ljava/util/List;", "setAccountTypes", "(Ljava/util/List;)V", "lastHistory", "Lcom/didi/payment/kycservice/net/response/PixBankOptionResp$LastHistory;", "getLastHistory", "()Lcom/didi/payment/kycservice/net/response/PixBankOptionResp$LastHistory;", "setLastHistory", "(Lcom/didi/payment/kycservice/net/response/PixBankOptionResp$LastHistory;)V", "pspList", "Lcom/didi/payment/kycservice/net/response/PixBankOptionResp$PspEntry;", "getPspList", "setPspList", "valid", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixBankOptionResp.kt */
    public static final class DataEntry implements IValidator, Serializable {
        public List<AccountTypeEntry> accountTypes;
        private LastHistory lastHistory;
        public List<PspEntry> pspList;

        public final List<AccountTypeEntry> getAccountTypes() {
            List<AccountTypeEntry> list = this.accountTypes;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("accountTypes");
            return null;
        }

        public final void setAccountTypes(List<AccountTypeEntry> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.accountTypes = list;
        }

        public final List<PspEntry> getPspList() {
            List<PspEntry> list = this.pspList;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pspList");
            return null;
        }

        public final void setPspList(List<PspEntry> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.pspList = list;
        }

        public final LastHistory getLastHistory() {
            return this.lastHistory;
        }

        public final void setLastHistory(LastHistory lastHistory2) {
            this.lastHistory = lastHistory2;
        }

        public boolean valid() {
            return !CollectionUtil.isEmpty((Collection<?>) getAccountTypes()) && !CollectionUtil.isEmpty((Collection<?>) getPspList());
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixBankOptionResp$AccountTypeEntry;", "Ljava/io/Serializable;", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "typeId", "", "getTypeId", "()I", "setTypeId", "(I)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixBankOptionResp.kt */
    public static final class AccountTypeEntry implements Serializable {
        public String name;
        private int typeId;

        public final int getTypeId() {
            return this.typeId;
        }

        public final void setTypeId(int i) {
            this.typeId = i;
        }

        public final String getName() {
            String str = this.name;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("name");
            return null;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixBankOptionResp$PspEntry;", "Ljava/io/Serializable;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "country", "", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "name", "getName", "setName", "pspId", "getPspId", "setPspId", "valid", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixBankOptionResp.kt */
    public static final class PspEntry implements IValidator, Serializable {
        public String country;
        public String name;
        public String pspId;

        public final String getPspId() {
            String str = this.pspId;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pspId");
            return null;
        }

        public final void setPspId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pspId = str;
        }

        public final String getName() {
            String str = this.name;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("name");
            return null;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getCountry() {
            String str = this.country;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("country");
            return null;
        }

        public final void setCountry(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.country = str;
        }

        public boolean valid() {
            return !TextUtil.isEmpty(getPspId()) && !TextUtil.isEmpty(getName());
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixBankOptionResp$LastHistory;", "Ljava/io/Serializable;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "accountId", "", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "accountType", "getAccountType", "setAccountType", "agency", "getAgency", "setAgency", "cpf", "getCpf", "setCpf", "name", "getName", "setName", "pspId", "getPspId", "setPspId", "pspName", "getPspName", "setPspName", "valid", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixBankOptionResp.kt */
    public static final class LastHistory implements IValidator, Serializable {
        public String accountId;
        public String accountType;
        public String agency;
        public String cpf;
        public String name;
        public String pspId;
        public String pspName;

        public final String getCpf() {
            String str = this.cpf;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("cpf");
            return null;
        }

        public final void setCpf(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cpf = str;
        }

        public final String getName() {
            String str = this.name;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("name");
            return null;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getAccountId() {
            String str = this.accountId;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("accountId");
            return null;
        }

        public final void setAccountId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.accountId = str;
        }

        public final String getAgency() {
            String str = this.agency;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("agency");
            return null;
        }

        public final void setAgency(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.agency = str;
        }

        public final String getPspId() {
            String str = this.pspId;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pspId");
            return null;
        }

        public final void setPspId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pspId = str;
        }

        public final String getPspName() {
            String str = this.pspName;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pspName");
            return null;
        }

        public final void setPspName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pspName = str;
        }

        public final String getAccountType() {
            String str = this.accountType;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("accountType");
            return null;
        }

        public final void setAccountType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.accountType = str;
        }

        public boolean valid() {
            return !TextUtil.isEmpty(getCpf()) && !TextUtil.isEmpty(getAccountId()) && !TextUtil.isEmpty(getPspId());
        }
    }
}
