package com.didi.payment.pix.net.response;

import com.didi.payment.commonsdk.net.IValidator;
import com.didi.payment.commonsdk.net.WBaseRespTemplate;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixKeyVerifyResp;", "Lcom/didi/payment/commonsdk/net/WBaseRespTemplate;", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PixKeyList;", "()V", "DialogInfo", "PixAccount", "PixKeyList", "PspInfo", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyVerifyResp.kt */
public final class PixKeyVerifyResp extends WBaseRespTemplate<PixKeyList> {

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PixKeyList;", "Lcom/didi/payment/commonsdk/net/IValidator;", "Ljava/io/Serializable;", "()V", "dialogInfo", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$DialogInfo;", "getDialogInfo", "()Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$DialogInfo;", "setDialogInfo", "(Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$DialogInfo;)V", "isDoubleCheck", "", "()Ljava/lang/Boolean;", "setDoubleCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "keyList", "", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PixAccount;", "getKeyList", "()Ljava/util/List;", "setKeyList", "(Ljava/util/List;)V", "notExistLabel", "", "getNotExistLabel", "()Ljava/lang/String;", "setNotExistLabel", "(Ljava/lang/String;)V", "valid", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyVerifyResp.kt */
    public static final class PixKeyList implements IValidator, Serializable {
        private DialogInfo dialogInfo;
        private Boolean isDoubleCheck = true;
        @SerializedName("pixKeyList")
        private List<PixAccount> keyList;
        private String notExistLabel;

        public final Boolean isDoubleCheck() {
            return this.isDoubleCheck;
        }

        public final void setDoubleCheck(Boolean bool) {
            this.isDoubleCheck = bool;
        }

        public final String getNotExistLabel() {
            return this.notExistLabel;
        }

        public final void setNotExistLabel(String str) {
            this.notExistLabel = str;
        }

        public final DialogInfo getDialogInfo() {
            return this.dialogInfo;
        }

        public final void setDialogInfo(DialogInfo dialogInfo2) {
            this.dialogInfo = dialogInfo2;
        }

        public final List<PixAccount> getKeyList() {
            return this.keyList;
        }

        public final void setKeyList(List<PixAccount> list) {
            this.keyList = list;
        }

        public boolean valid() {
            return !CollectionUtil.isEmpty((Collection<?>) this.keyList) || !TextUtil.isEmpty(this.notExistLabel);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$DialogInfo;", "", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyVerifyResp.kt */
    public static final class DialogInfo {
        private String content;
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }
    }

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u00101\u001a\u00020\u001aJ\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\u001aH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\t¨\u00065"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PixAccount;", "Lcom/didi/payment/commonsdk/net/IValidator;", "Ljava/io/Serializable;", "()V", "branch", "", "getBranch", "()Ljava/lang/String;", "setBranch", "(Ljava/lang/String;)V", "cpf", "getCpf", "setCpf", "creationDate", "getCreationDate", "setCreationDate", "dialogBtn", "getDialogBtn", "setDialogBtn", "endToEndId", "getEndToEndId", "setEndToEndId", "icon", "getIcon", "setIcon", "isSameCpf", "", "()Ljava/lang/Boolean;", "setSameCpf", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "key", "getKey", "setKey", "keyType", "getKeyType", "setKeyType", "name", "getName", "setName", "psp", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PspInfo;", "getPsp", "()Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PspInfo;", "setPsp", "(Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PspInfo;)V", "showKey", "getShowKey", "setShowKey", "accountExist", "toBizContent", "Lorg/json/JSONObject;", "valid", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyVerifyResp.kt */
    public static final class PixAccount implements IValidator, Serializable {
        public String branch;
        private String cpf;
        public String creationDate;
        public String dialogBtn;
        public String endToEndId;
        public String icon;
        private Boolean isSameCpf = false;
        private String key;
        public String keyType;
        private String name;
        @SerializedName("pspInfo")
        public PspInfo psp;
        private String showKey;

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
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

        public final String getKeyType() {
            String str = this.keyType;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("keyType");
            return null;
        }

        public final void setKeyType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.keyType = str;
        }

        public final String getIcon() {
            String str = this.icon;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            return null;
        }

        public final void setIcon(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.icon = str;
        }

        public final String getCpf() {
            return this.cpf;
        }

        public final void setCpf(String str) {
            this.cpf = str;
        }

        public final String getDialogBtn() {
            String str = this.dialogBtn;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dialogBtn");
            return null;
        }

        public final void setDialogBtn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.dialogBtn = str;
        }

        public final String getBranch() {
            String str = this.branch;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("branch");
            return null;
        }

        public final void setBranch(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.branch = str;
        }

        public final String getEndToEndId() {
            String str = this.endToEndId;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("endToEndId");
            return null;
        }

        public final void setEndToEndId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.endToEndId = str;
        }

        public final String getCreationDate() {
            String str = this.creationDate;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("creationDate");
            return null;
        }

        public final void setCreationDate(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.creationDate = str;
        }

        public final PspInfo getPsp() {
            PspInfo pspInfo = this.psp;
            if (pspInfo != null) {
                return pspInfo;
            }
            Intrinsics.throwUninitializedPropertyAccessException("psp");
            return null;
        }

        public final void setPsp(PspInfo pspInfo) {
            Intrinsics.checkNotNullParameter(pspInfo, "<set-?>");
            this.psp = pspInfo;
        }

        public final Boolean isSameCpf() {
            return this.isSameCpf;
        }

        public final void setSameCpf(Boolean bool) {
            this.isSameCpf = bool;
        }

        public boolean valid() {
            return !TextUtil.isEmpty(this.key);
        }

        public final boolean accountExist() {
            return !TextUtil.isEmpty(this.name) || !TextUtil.isEmpty(this.key) || !TextUtil.isEmpty(this.cpf);
        }

        public final JSONObject toBizContent() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("order_type", 0);
            jSONObject.put("key", this.key);
            jSONObject.put("toIconUrl", getIcon());
            return jSONObject;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PspInfo;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyVerifyResp.kt */
    public static final class PspInfo implements Serializable {

        /* renamed from: id */
        private String f31090id;
        private String name;

        public final String getId() {
            return this.f31090id;
        }

        public final void setId(String str) {
            this.f31090id = str;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }
    }
}
