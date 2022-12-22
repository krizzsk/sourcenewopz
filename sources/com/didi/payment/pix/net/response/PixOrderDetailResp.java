package com.didi.payment.pix.net.response;

import android.text.TextUtils;
import com.didi.payment.base.finResource.CommonResourceState;
import com.didi.payment.commonsdk.net.IValidator;
import com.didi.payment.commonsdk.net.WBaseRespTemplate;
import com.didi.sdk.util.collection.CollectionUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixOrderDetailResp;", "Lcom/didi/payment/commonsdk/net/WBaseRespTemplate;", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$OrderDetail;", "()V", "Companion", "DialogInfo", "NameValuePair", "OrderDetail", "RefoundData", "RuleLimitDetailVo", "SectionEntry", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixOrderDetailResp.kt */
public final class PixOrderDetailResp extends WBaseRespTemplate<OrderDetail> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static int ORDER_STATUS_FAIL = 2;
    /* access modifiers changed from: private */
    public static int ORDER_STATUS_PENDING = 3;
    /* access modifiers changed from: private */
    public static int ORDER_STATUS_SUCCESS = 1;

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixOrderDetailResp$Companion;", "", "()V", "ORDER_STATUS_FAIL", "", "getORDER_STATUS_FAIL", "()I", "setORDER_STATUS_FAIL", "(I)V", "ORDER_STATUS_PENDING", "getORDER_STATUS_PENDING", "setORDER_STATUS_PENDING", "ORDER_STATUS_SUCCESS", "getORDER_STATUS_SUCCESS", "setORDER_STATUS_SUCCESS", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixOrderDetailResp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getORDER_STATUS_SUCCESS() {
            return PixOrderDetailResp.ORDER_STATUS_SUCCESS;
        }

        public final void setORDER_STATUS_SUCCESS(int i) {
            PixOrderDetailResp.ORDER_STATUS_SUCCESS = i;
        }

        public final int getORDER_STATUS_FAIL() {
            return PixOrderDetailResp.ORDER_STATUS_FAIL;
        }

        public final void setORDER_STATUS_FAIL(int i) {
            PixOrderDetailResp.ORDER_STATUS_FAIL = i;
        }

        public final int getORDER_STATUS_PENDING() {
            return PixOrderDetailResp.ORDER_STATUS_PENDING;
        }

        public final void setORDER_STATUS_PENDING(int i) {
            PixOrderDetailResp.ORDER_STATUS_PENDING = i;
        }
    }

    @Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010A\u001a\u00020\u001eJ\u0006\u0010B\u001a\u00020\u001eJ\u0006\u0010C\u001a\u00020\u001eJ\u0006\u0010D\u001a\u00020\u001eJ\u0006\u0010E\u001a\u00020\u0005J\b\u0010F\u001a\u00020\u001eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R \u00102\u001a\u0004\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u001a\u0010;\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010)\"\u0004\b=\u0010+R\u001a\u0010>\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0007\"\u0004\b@\u0010\t¨\u0006H"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixOrderDetailResp$OrderDetail;", "Ljava/io/Serializable;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "amount", "", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "commonResourceState", "Lcom/didi/payment/base/finResource/CommonResourceState;", "getCommonResourceState", "()Lcom/didi/payment/base/finResource/CommonResourceState;", "setCommonResourceState", "(Lcom/didi/payment/base/finResource/CommonResourceState;)V", "dialog", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$DialogInfo;", "getDialog", "()Lcom/didi/payment/pix/net/response/PixOrderDetailResp$DialogInfo;", "setDialog", "(Lcom/didi/payment/pix/net/response/PixOrderDetailResp$DialogInfo;)V", "entryList", "", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$SectionEntry;", "getEntryList", "()Ljava/util/List;", "setEntryList", "(Ljava/util/List;)V", "hasRefund", "", "getHasRefund", "()Z", "setHasRefund", "(Z)V", "orderId", "getOrderId", "setOrderId", "refund", "", "getRefund", "()I", "setRefund", "(I)V", "refundSection", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$RefoundData;", "getRefundSection", "()Lcom/didi/payment/pix/net/response/PixOrderDetailResp$RefoundData;", "setRefundSection", "(Lcom/didi/payment/pix/net/response/PixOrderDetailResp$RefoundData;)V", "ruleLimitDetail", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$RuleLimitDetailVo;", "getRuleLimitDetail", "()Lcom/didi/payment/pix/net/response/PixOrderDetailResp$RuleLimitDetailVo;", "setRuleLimitDetail", "(Lcom/didi/payment/pix/net/response/PixOrderDetailResp$RuleLimitDetailVo;)V", "share", "getShare", "setShare", "status", "getStatus", "setStatus", "title", "getTitle", "setTitle", "canRefund", "canRetry", "canShare", "isDialogBlock", "oId", "valid", "Companion", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixOrderDetailResp.kt */
    public static final class OrderDetail implements IValidator, Serializable {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static int STATUS_FAIL = 2;
        /* access modifiers changed from: private */
        public static int STATUS_PENDING = 3;
        /* access modifiers changed from: private */
        public static int STATUS_SUCCESS = 1;
        public String amount;
        @SerializedName("commonResourceState")
        private CommonResourceState commonResourceState;
        private DialogInfo dialog;
        public List<SectionEntry> entryList;
        private boolean hasRefund;
        private String orderId = "";
        private int refund;
        public RefoundData refundSection;
        @SerializedName("ruleLimitDetail")
        private RuleLimitDetailVo ruleLimitDetail;
        private boolean share;
        private int status;
        public String title;

        @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixOrderDetailResp$OrderDetail$Companion;", "", "()V", "STATUS_FAIL", "", "getSTATUS_FAIL", "()I", "setSTATUS_FAIL", "(I)V", "STATUS_PENDING", "getSTATUS_PENDING", "setSTATUS_PENDING", "STATUS_SUCCESS", "getSTATUS_SUCCESS", "setSTATUS_SUCCESS", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: PixOrderDetailResp.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public int getSTATUS_SUCCESS() {
                return OrderDetail.STATUS_SUCCESS;
            }

            public void setSTATUS_SUCCESS(int i) {
                OrderDetail.STATUS_SUCCESS = i;
            }

            public int getSTATUS_FAIL() {
                return OrderDetail.STATUS_FAIL;
            }

            public void setSTATUS_FAIL(int i) {
                OrderDetail.STATUS_FAIL = i;
            }

            public int getSTATUS_PENDING() {
                return OrderDetail.STATUS_PENDING;
            }

            public void setSTATUS_PENDING(int i) {
                OrderDetail.STATUS_PENDING = i;
            }
        }

        public final String getOrderId() {
            return this.orderId;
        }

        public final void setOrderId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.orderId = str;
        }

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

        public final String getAmount() {
            String str = this.amount;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("amount");
            return null;
        }

        public final void setAmount(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.amount = str;
        }

        public final int getRefund() {
            return this.refund;
        }

        public final void setRefund(int i) {
            this.refund = i;
        }

        public final boolean getHasRefund() {
            return this.hasRefund;
        }

        public final void setHasRefund(boolean z) {
            this.hasRefund = z;
        }

        public final boolean getShare() {
            return this.share;
        }

        public final void setShare(boolean z) {
            this.share = z;
        }

        public final List<SectionEntry> getEntryList() {
            List<SectionEntry> list = this.entryList;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("entryList");
            return null;
        }

        public final void setEntryList(List<SectionEntry> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.entryList = list;
        }

        public final RefoundData getRefundSection() {
            RefoundData refoundData = this.refundSection;
            if (refoundData != null) {
                return refoundData;
            }
            Intrinsics.throwUninitializedPropertyAccessException("refundSection");
            return null;
        }

        public final void setRefundSection(RefoundData refoundData) {
            Intrinsics.checkNotNullParameter(refoundData, "<set-?>");
            this.refundSection = refoundData;
        }

        public final DialogInfo getDialog() {
            return this.dialog;
        }

        public final void setDialog(DialogInfo dialogInfo) {
            this.dialog = dialogInfo;
        }

        public final RuleLimitDetailVo getRuleLimitDetail() {
            return this.ruleLimitDetail;
        }

        public final void setRuleLimitDetail(RuleLimitDetailVo ruleLimitDetailVo) {
            this.ruleLimitDetail = ruleLimitDetailVo;
        }

        public final CommonResourceState getCommonResourceState() {
            return this.commonResourceState;
        }

        public final void setCommonResourceState(CommonResourceState commonResourceState2) {
            this.commonResourceState = commonResourceState2;
        }

        public final boolean canRefund() {
            return this.refund == 1 || this.hasRefund;
        }

        public final boolean canRetry() {
            return this.status == STATUS_PENDING;
        }

        public final boolean canShare() {
            return this.share;
        }

        public final String oId() {
            return this.orderId;
        }

        public final boolean isDialogBlock() {
            DialogInfo dialogInfo = this.dialog;
            if (dialogInfo != null) {
                Intrinsics.checkNotNull(dialogInfo);
                if (dialogInfo.valid()) {
                    return true;
                }
            }
            return false;
        }

        public boolean valid() {
            return !CollectionUtil.isEmpty((Collection<?>) getEntryList());
        }
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixOrderDetailResp$SectionEntry;", "Ljava/io/Serializable;", "()V", "items", "", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$NameValuePair;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixOrderDetailResp.kt */
    public static final class SectionEntry implements Serializable {
        @SerializedName("data")
        public List<NameValuePair> items;
        public String title;

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

        public final List<NameValuePair> getItems() {
            List<NameValuePair> list = this.items;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException(FirebaseAnalytics.Param.ITEMS);
            return null;
        }

        public final void setItems(List<NameValuePair> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.items = list;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixOrderDetailResp$NameValuePair;", "Ljava/io/Serializable;", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "value", "getValue", "setValue", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixOrderDetailResp.kt */
    public static final class NameValuePair implements Serializable {
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

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixOrderDetailResp$RefoundData;", "Ljava/io/Serializable;", "()V", "linkUrl", "", "getLinkUrl", "()Ljava/lang/String;", "setLinkUrl", "(Ljava/lang/String;)V", "maxRefundAmount", "", "getMaxRefundAmount", "()I", "setMaxRefundAmount", "(I)V", "refundLabel", "getRefundLabel", "setRefundLabel", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixOrderDetailResp.kt */
    public static final class RefoundData implements Serializable {
        public String linkUrl;
        private int maxRefundAmount;
        public String refundLabel;

        public final String getRefundLabel() {
            String str = this.refundLabel;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("refundLabel");
            return null;
        }

        public final void setRefundLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.refundLabel = str;
        }

        public final String getLinkUrl() {
            String str = this.linkUrl;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("linkUrl");
            return null;
        }

        public final void setLinkUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.linkUrl = str;
        }

        public final int getMaxRefundAmount() {
            return this.maxRefundAmount;
        }

        public final void setMaxRefundAmount(int i) {
            this.maxRefundAmount = i;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixOrderDetailResp$DialogInfo;", "Ljava/io/Serializable;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "considerBtn", "", "getConsiderBtn", "()Ljava/lang/String;", "setConsiderBtn", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "ignoreBtn", "getIgnoreBtn", "setIgnoreBtn", "linkUrl", "getLinkUrl", "setLinkUrl", "title", "getTitle", "setTitle", "valid", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixOrderDetailResp.kt */
    public static final class DialogInfo implements IValidator, Serializable {
        private String considerBtn = "";
        private String desc = "";
        private String ignoreBtn = "";
        private String linkUrl = "";
        private String title = "";

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.desc = str;
        }

        public final String getConsiderBtn() {
            return this.considerBtn;
        }

        public final void setConsiderBtn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.considerBtn = str;
        }

        public final String getIgnoreBtn() {
            return this.ignoreBtn;
        }

        public final void setIgnoreBtn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ignoreBtn = str;
        }

        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final void setLinkUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.linkUrl = str;
        }

        public boolean valid() {
            return !TextUtils.isEmpty(this.title) && !TextUtils.isEmpty(this.considerBtn);
        }
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixOrderDetailResp$RuleLimitDetailVo;", "Ljava/io/Serializable;", "text", "", "link", "(Ljava/lang/String;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "getText", "setText", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixOrderDetailResp.kt */
    public static final class RuleLimitDetailVo implements Serializable {
        @SerializedName("link")
        private String link;
        @SerializedName("text")
        private String text;

        public RuleLimitDetailVo() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ RuleLimitDetailVo copy$default(RuleLimitDetailVo ruleLimitDetailVo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ruleLimitDetailVo.text;
            }
            if ((i & 2) != 0) {
                str2 = ruleLimitDetailVo.link;
            }
            return ruleLimitDetailVo.copy(str, str2);
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.link;
        }

        public final RuleLimitDetailVo copy(String str, String str2) {
            return new RuleLimitDetailVo(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RuleLimitDetailVo)) {
                return false;
            }
            RuleLimitDetailVo ruleLimitDetailVo = (RuleLimitDetailVo) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) ruleLimitDetailVo.text) && Intrinsics.areEqual((Object) this.link, (Object) ruleLimitDetailVo.link);
        }

        public int hashCode() {
            String str = this.text;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.link;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "RuleLimitDetailVo(text=" + this.text + ", link=" + this.link + VersionRange.RIGHT_OPEN;
        }

        public RuleLimitDetailVo(String str, String str2) {
            this.text = str;
            this.link = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RuleLimitDetailVo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            this.text = str;
        }

        public final String getLink() {
            return this.link;
        }

        public final void setLink(String str) {
            this.link = str;
        }
    }
}
