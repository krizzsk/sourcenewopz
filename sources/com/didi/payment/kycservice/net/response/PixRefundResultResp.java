package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.IValidator;
import com.didi.payment.commonsdk.net.WBaseRespTemplate;
import com.didi.sdk.util.collection.CollectionUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixRefundResultResp;", "Lcom/didi/payment/commonsdk/net/WBaseRespTemplate;", "Lcom/didi/payment/kycservice/net/response/PixRefundResultResp$OrderRefundDetails;", "()V", "Entry", "OrderRefundDetails", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixRefundResultResp.kt */
public final class PixRefundResultResp extends WBaseRespTemplate<OrderRefundDetails> {

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u001a\u001a\u00020\u001bH\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixRefundResultResp$OrderRefundDetails;", "Ljava/io/Serializable;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "entryList", "", "Lcom/didi/payment/kycservice/net/response/PixRefundResultResp$Entry;", "getEntryList", "()Ljava/util/List;", "setEntryList", "(Ljava/util/List;)V", "status", "", "getStatus", "()I", "setStatus", "(I)V", "subTitle", "", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "valid", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixRefundResultResp.kt */
    public static final class OrderRefundDetails implements IValidator, Serializable {
        public List<Entry> entryList;
        private int status;
        public String subTitle;
        public String title;

        public final int getStatus() {
            return this.status;
        }

        public final void setStatus(int i) {
            this.status = i;
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

        public final String getSubTitle() {
            String str = this.subTitle;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subTitle");
            return null;
        }

        public final void setSubTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subTitle = str;
        }

        public final List<Entry> getEntryList() {
            List<Entry> list = this.entryList;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("entryList");
            return null;
        }

        public final void setEntryList(List<Entry> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.entryList = list;
        }

        public final String subTitle() {
            return getSubTitle();
        }

        public boolean valid() {
            return !CollectionUtil.isEmpty((Collection<?>) getEntryList());
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixRefundResultResp$Entry;", "Ljava/io/Serializable;", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "value", "getValue", "setValue", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixRefundResultResp.kt */
    public static final class Entry implements Serializable {
        public String key;
        public String value;

        public final String getKey() {
            String str = this.key;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("key");
            return null;
        }

        public final void setKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.key = str;
        }

        public final String getValue() {
            String str = this.value;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("value");
            return null;
        }

        public final void setValue(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.value = str;
        }
    }
}
