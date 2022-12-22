package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixQrChannelResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/net/response/PixQrChannelResp$Data;", "getData", "()Lcom/didi/payment/kycservice/net/response/PixQrChannelResp$Data;", "setData", "(Lcom/didi/payment/kycservice/net/response/PixQrChannelResp$Data;)V", "Data", "Entry", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixQrChannelResp.kt */
public final class PixQrChannelResp extends WBaseResp {
    @SerializedName("data")
    public Data data;

    public final Data getData() {
        Data data2 = this.data;
        if (data2 != null) {
            return data2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final void setData(Data data2) {
        Intrinsics.checkNotNullParameter(data2, "<set-?>");
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixQrChannelResp$Data;", "", "()V", "entryList", "", "Lcom/didi/payment/kycservice/net/response/PixQrChannelResp$Entry;", "getEntryList", "()Ljava/util/List;", "setEntryList", "(Ljava/util/List;)V", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "productLine", "", "getProductLine", "()Ljava/lang/Integer;", "setProductLine", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "title", "getTitle", "setTitle", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixQrChannelResp.kt */
    public static final class Data {
        private List<Entry> entryList;
        @SerializedName("iconUrl")
        private String iconUrl;
        @SerializedName("productLine")
        private Integer productLine;
        @SerializedName("title")
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final void setIconUrl(String str) {
            this.iconUrl = str;
        }

        public final Integer getProductLine() {
            return this.productLine;
        }

        public final void setProductLine(Integer num) {
            this.productLine = num;
        }

        public final List<Entry> getEntryList() {
            return this.entryList;
        }

        public final void setEntryList(List<Entry> list) {
            this.entryList = list;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixQrChannelResp$Entry;", "", "()V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "linkUrl", "getLinkUrl", "setLinkUrl", "name", "getName", "setName", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixQrChannelResp.kt */
    public static final class Entry {
        @SerializedName("icon")
        private String icon;
        @SerializedName("linkUrl")
        private String linkUrl;
        @SerializedName("name")
        private String name;

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

        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final void setLinkUrl(String str) {
            this.linkUrl = str;
        }
    }
}
