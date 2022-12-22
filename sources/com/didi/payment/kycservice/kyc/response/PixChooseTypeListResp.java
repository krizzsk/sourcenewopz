package com.didi.payment.kycservice.kyc.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Data;", "getData", "()Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Data;", "setData", "(Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Data;)V", "Data", "Item", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixChooseTypeListResp.kt */
public final class PixChooseTypeListResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Data;", "", "()V", "isHide", "", "()Z", "setHide", "(Z)V", "keyList", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;", "Lkotlin/collections/ArrayList;", "getKeyList", "()Ljava/util/ArrayList;", "setKeyList", "(Ljava/util/ArrayList;)V", "subTitle", "", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixChooseTypeListResp.kt */
    public static final class Data {
        private boolean isHide;
        private ArrayList<Item> keyList;
        private String subTitle;
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final void setSubTitle(String str) {
            this.subTitle = str;
        }

        public final boolean isHide() {
            return this.isHide;
        }

        public final void setHide(boolean z) {
            this.isHide = z;
        }

        public final ArrayList<Item> getKeyList() {
            return this.keyList;
        }

        public final void setKeyList(ArrayList<Item> arrayList) {
            this.keyList = arrayList;
        }
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e¨\u0006$"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;", "", "()V", "defaultDetail", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item$Detail;", "getDefaultDetail", "()Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item$Detail;", "setDefaultDetail", "(Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item$Detail;)V", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "imgUrl", "getImgUrl", "setImgUrl", "isRecommend", "", "()Z", "setRecommend", "(Z)V", "source", "", "getSource", "()I", "setSource", "(I)V", "type", "getType", "setType", "value", "getValue", "setValue", "Detail", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixChooseTypeListResp.kt */
    public static final class Item {
        private Detail defaultDetail;
        private String desc;
        private String imgUrl;
        private boolean isRecommend;
        private int source;
        private int type;
        private String value = "";

        public final int getType() {
            return this.type;
        }

        public final void setType(int i) {
            this.type = i;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setValue(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.value = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            this.desc = str;
        }

        public final String getImgUrl() {
            return this.imgUrl;
        }

        public final void setImgUrl(String str) {
            this.imgUrl = str;
        }

        public final int getSource() {
            return this.source;
        }

        public final void setSource(int i) {
            this.source = i;
        }

        public final boolean isRecommend() {
            return this.isRecommend;
        }

        public final void setRecommend(boolean z) {
            this.isRecommend = z;
        }

        public final Detail getDefaultDetail() {
            return this.defaultDetail;
        }

        public final void setDefaultDetail(Detail detail) {
            this.defaultDetail = detail;
        }

        @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item$Detail;", "", "title", "", "subTitle", "defaultValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDefaultValue", "()Ljava/lang/String;", "getSubTitle", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: PixChooseTypeListResp.kt */
        public static final class Detail {
            private final String defaultValue;
            private final String subTitle;
            private final String title;

            public static /* synthetic */ Detail copy$default(Detail detail, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = detail.title;
                }
                if ((i & 2) != 0) {
                    str2 = detail.subTitle;
                }
                if ((i & 4) != 0) {
                    str3 = detail.defaultValue;
                }
                return detail.copy(str, str2, str3);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.subTitle;
            }

            public final String component3() {
                return this.defaultValue;
            }

            public final Detail copy(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "subTitle");
                Intrinsics.checkNotNullParameter(str3, "defaultValue");
                return new Detail(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Detail)) {
                    return false;
                }
                Detail detail = (Detail) obj;
                return Intrinsics.areEqual((Object) this.title, (Object) detail.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) detail.subTitle) && Intrinsics.areEqual((Object) this.defaultValue, (Object) detail.defaultValue);
            }

            public int hashCode() {
                return (((this.title.hashCode() * 31) + this.subTitle.hashCode()) * 31) + this.defaultValue.hashCode();
            }

            public String toString() {
                return "Detail(title=" + this.title + ", subTitle=" + this.subTitle + ", defaultValue=" + this.defaultValue + VersionRange.RIGHT_OPEN;
            }

            public Detail(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "subTitle");
                Intrinsics.checkNotNullParameter(str3, "defaultValue");
                this.title = str;
                this.subTitle = str2;
                this.defaultValue = str3;
            }

            public final String getDefaultValue() {
                return this.defaultValue;
            }

            public final String getSubTitle() {
                return this.subTitle;
            }

            public final String getTitle() {
                return this.title;
            }
        }
    }
}
