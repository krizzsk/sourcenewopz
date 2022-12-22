package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixTempInfoResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/net/response/PixTempInfoResp$Data;", "getData", "()Lcom/didi/payment/kycservice/net/response/PixTempInfoResp$Data;", "setData", "(Lcom/didi/payment/kycservice/net/response/PixTempInfoResp$Data;)V", "Data", "Item", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTempInfoResp.kt */
public final class PixTempInfoResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixTempInfoResp$Data;", "", "()V", "isHide", "", "()Z", "setHide", "(Z)V", "keyList", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/net/response/PixTempInfoResp$Item;", "Lkotlin/collections/ArrayList;", "getKeyList", "()Ljava/util/ArrayList;", "setKeyList", "(Ljava/util/ArrayList;)V", "subTitle", "", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixTempInfoResp.kt */
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

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006!"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixTempInfoResp$Item;", "", "type", "", "value", "", "desc", "imgUrl", "isRecommend", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getImgUrl", "()Z", "getType", "()I", "setType", "(I)V", "getValue", "setValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixTempInfoResp.kt */
    public static final class Item {
        private String desc;
        private final String imgUrl;
        private final boolean isRecommend;
        private int type;
        private String value;

        public static /* synthetic */ Item copy$default(Item item, int i, String str, String str2, String str3, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = item.type;
            }
            if ((i2 & 2) != 0) {
                str = item.value;
            }
            String str4 = str;
            if ((i2 & 4) != 0) {
                str2 = item.desc;
            }
            String str5 = str2;
            if ((i2 & 8) != 0) {
                str3 = item.imgUrl;
            }
            String str6 = str3;
            if ((i2 & 16) != 0) {
                z = item.isRecommend;
            }
            return item.copy(i, str4, str5, str6, z);
        }

        public final int component1() {
            return this.type;
        }

        public final String component2() {
            return this.value;
        }

        public final String component3() {
            return this.desc;
        }

        public final String component4() {
            return this.imgUrl;
        }

        public final boolean component5() {
            return this.isRecommend;
        }

        public final Item copy(int i, String str, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "value");
            Intrinsics.checkNotNullParameter(str3, "imgUrl");
            return new Item(i, str, str2, str3, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return this.type == item.type && Intrinsics.areEqual((Object) this.value, (Object) item.value) && Intrinsics.areEqual((Object) this.desc, (Object) item.desc) && Intrinsics.areEqual((Object) this.imgUrl, (Object) item.imgUrl) && this.isRecommend == item.isRecommend;
        }

        public int hashCode() {
            int hashCode = ((this.type * 31) + this.value.hashCode()) * 31;
            String str = this.desc;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.imgUrl.hashCode()) * 31;
            boolean z = this.isRecommend;
            if (z) {
                z = true;
            }
            return hashCode2 + (z ? 1 : 0);
        }

        public String toString() {
            return "Item(type=" + this.type + ", value=" + this.value + ", desc=" + this.desc + ", imgUrl=" + this.imgUrl + ", isRecommend=" + this.isRecommend + VersionRange.RIGHT_OPEN;
        }

        public Item(int i, String str, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "value");
            Intrinsics.checkNotNullParameter(str3, "imgUrl");
            this.type = i;
            this.value = str;
            this.desc = str2;
            this.imgUrl = str3;
            this.isRecommend = z;
        }

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

        public final boolean isRecommend() {
            return this.isRecommend;
        }
    }
}
