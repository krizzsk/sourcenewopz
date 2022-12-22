package com.didi.payment.pix.net.response;

import android.text.TextUtils;
import com.didi.payment.commonsdk.net.IValidator;
import com.didi.payment.commonsdk.net.WBaseRespTemplate;
import com.didi.sdk.util.collection.CollectionUtil;
import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixRefundExtrasResp;", "Lcom/didi/payment/commonsdk/net/WBaseRespTemplate;", "Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$RefundOptions;", "()V", "Payee", "ReasonEntry", "RefundOptions", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixRefundExtrasResp.kt */
public final class PixRefundExtrasResp extends WBaseRespTemplate<RefundOptions> {

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0016J\u0006\u0010*\u001a\u00020+R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001a\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\b¨\u0006,"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$RefundOptions;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "maxRefundAmount", "", "getMaxRefundAmount", "()I", "setMaxRefundAmount", "(I)V", "payeeIconUrl", "", "getPayeeIconUrl", "()Ljava/lang/String;", "setPayeeIconUrl", "(Ljava/lang/String;)V", "payeeName", "getPayeeName", "setPayeeName", "reasons", "", "Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$ReasonEntry;", "getReasons", "()Ljava/util/List;", "setReasons", "(Ljava/util/List;)V", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "transferType", "getTransferType", "setTransferType", "userAvailableAmount", "getUserAvailableAmount", "setUserAvailableAmount", "userBlockAmount", "getUserBlockAmount", "setUserBlockAmount", "valid", "", "validate", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixRefundExtrasResp.kt */
    public static final class RefundOptions implements IValidator {
        private int maxRefundAmount;
        private String payeeIconUrl = "";
        private String payeeName = "";
        @SerializedName("reasonList")
        public List<ReasonEntry> reasons;
        private String subTitle = "";
        private String title = "";
        private String transferType = "";
        private int userAvailableAmount;
        private int userBlockAmount;

        public final void validate() {
        }

        public final List<ReasonEntry> getReasons() {
            List<ReasonEntry> list = this.reasons;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("reasons");
            return null;
        }

        public final void setReasons(List<ReasonEntry> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.reasons = list;
        }

        public final int getMaxRefundAmount() {
            return this.maxRefundAmount;
        }

        public final void setMaxRefundAmount(int i) {
            this.maxRefundAmount = i;
        }

        public final int getUserAvailableAmount() {
            return this.userAvailableAmount;
        }

        public final void setUserAvailableAmount(int i) {
            this.userAvailableAmount = i;
        }

        public final int getUserBlockAmount() {
            return this.userBlockAmount;
        }

        public final void setUserBlockAmount(int i) {
            this.userBlockAmount = i;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final void setSubTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subTitle = str;
        }

        public final String getPayeeIconUrl() {
            return this.payeeIconUrl;
        }

        public final void setPayeeIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.payeeIconUrl = str;
        }

        public final String getPayeeName() {
            return this.payeeName;
        }

        public final void setPayeeName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.payeeName = str;
        }

        public final String getTransferType() {
            return this.transferType;
        }

        public final void setTransferType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.transferType = str;
        }

        public boolean valid() {
            return !CollectionUtil.isEmpty((Collection<?>) getReasons());
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$Payee;", "", "()V", "cpf", "", "getCpf", "()Ljava/lang/String;", "setCpf", "(Ljava/lang/String;)V", "icon_url", "getIcon_url", "setIcon_url", "name", "getName", "setName", "org", "getOrg", "setOrg", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixRefundExtrasResp.kt */
    public static final class Payee {
        public String cpf;
        public String icon_url;
        public String name;

        /* renamed from: org  reason: collision with root package name */
        public String f61868org;

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

        public final String getIcon_url() {
            String str = this.icon_url;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("icon_url");
            return null;
        }

        public final void setIcon_url(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.icon_url = str;
        }

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

        public final String getOrg() {
            String str = this.f61868org;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("org");
            return null;
        }

        public final void setOrg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f61868org = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$ReasonEntry;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "isFocus", "", "()Z", "setFocus", "(Z)V", "typeId", "getTypeId", "setTypeId", "valid", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixRefundExtrasResp.kt */
    public static final class ReasonEntry implements IValidator {
        private String desc = "";
        private boolean isFocus;
        private String typeId = "";

        public final boolean isFocus() {
            return this.isFocus;
        }

        public final void setFocus(boolean z) {
            this.isFocus = z;
        }

        public final String getTypeId() {
            return this.typeId;
        }

        public final void setTypeId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.typeId = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.desc = str;
        }

        public boolean valid() {
            return !TextUtils.isEmpty(this.typeId) && !TextUtils.isEmpty(this.desc);
        }
    }
}
