package com.didi.payment.kycservice.key.list.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$Data;", "getData", "()Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$Data;", "setData", "(Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$Data;)V", "Data", "Detail", "KeyItem", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyListResp.kt */
public final class PixKeyListResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001c\u0010#\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001c\u0010&\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001c\u0010)\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014¨\u0006,"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$Data;", "", "()V", "activeCount", "", "getActiveCount", "()I", "setActiveCount", "(I)V", "canRegister", "", "getCanRegister", "()Z", "setCanRegister", "(Z)V", "defaultKey", "", "getDefaultKey", "()Ljava/lang/String;", "setDefaultKey", "(Ljava/lang/String;)V", "keyList", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$KeyItem;", "Lkotlin/collections/ArrayList;", "getKeyList", "()Ljava/util/ArrayList;", "setKeyList", "(Ljava/util/ArrayList;)V", "pendingCount", "getPendingCount", "setPendingCount", "portabilityCount", "getPortabilityCount", "setPortabilityCount", "portabilityMessage", "getPortabilityMessage", "setPortabilityMessage", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyListResp.kt */
    public static final class Data {
        private int activeCount;
        private boolean canRegister;
        private String defaultKey;
        private ArrayList<KeyItem> keyList;
        private int pendingCount;
        private int portabilityCount;
        private String portabilityMessage;
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

        public final int getPortabilityCount() {
            return this.portabilityCount;
        }

        public final void setPortabilityCount(int i) {
            this.portabilityCount = i;
        }

        public final int getActiveCount() {
            return this.activeCount;
        }

        public final void setActiveCount(int i) {
            this.activeCount = i;
        }

        public final int getPendingCount() {
            return this.pendingCount;
        }

        public final void setPendingCount(int i) {
            this.pendingCount = i;
        }

        public final String getDefaultKey() {
            return this.defaultKey;
        }

        public final void setDefaultKey(String str) {
            this.defaultKey = str;
        }

        public final String getPortabilityMessage() {
            return this.portabilityMessage;
        }

        public final void setPortabilityMessage(String str) {
            this.portabilityMessage = str;
        }

        public final boolean getCanRegister() {
            return this.canRegister;
        }

        public final void setCanRegister(boolean z) {
            this.canRegister = z;
        }

        public final ArrayList<KeyItem> getKeyList() {
            return this.keyList;
        }

        public final void setKeyList(ArrayList<KeyItem> arrayList) {
            this.keyList = arrayList;
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\b\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003JS\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015¨\u0006/"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$KeyItem;", "", "type", "", "value", "", "desc", "imgUrl", "isDefault", "", "status", "defaultDetail", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$Detail;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILcom/didi/payment/kycservice/key/list/response/PixKeyListResp$Detail;)V", "getDefaultDetail", "()Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$Detail;", "setDefaultDetail", "(Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$Detail;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getImgUrl", "setImgUrl", "()Z", "setDefault", "(Z)V", "getStatus", "()I", "setStatus", "(I)V", "getType", "setType", "getValue", "setValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyListResp.kt */
    public static final class KeyItem {
        private Detail defaultDetail;
        private String desc;
        private String imgUrl;
        private boolean isDefault;
        private int status;
        private int type;
        private String value;

        public KeyItem() {
            this(0, (String) null, (String) null, (String) null, false, 0, (Detail) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ KeyItem copy$default(KeyItem keyItem, int i, String str, String str2, String str3, boolean z, int i2, Detail detail, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = keyItem.type;
            }
            if ((i3 & 2) != 0) {
                str = keyItem.value;
            }
            String str4 = str;
            if ((i3 & 4) != 0) {
                str2 = keyItem.desc;
            }
            String str5 = str2;
            if ((i3 & 8) != 0) {
                str3 = keyItem.imgUrl;
            }
            String str6 = str3;
            if ((i3 & 16) != 0) {
                z = keyItem.isDefault;
            }
            boolean z2 = z;
            if ((i3 & 32) != 0) {
                i2 = keyItem.status;
            }
            int i4 = i2;
            if ((i3 & 64) != 0) {
                detail = keyItem.defaultDetail;
            }
            return keyItem.copy(i, str4, str5, str6, z2, i4, detail);
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
            return this.isDefault;
        }

        public final int component6() {
            return this.status;
        }

        public final Detail component7() {
            return this.defaultDetail;
        }

        public final KeyItem copy(int i, String str, String str2, String str3, boolean z, int i2, Detail detail) {
            Intrinsics.checkNotNullParameter(str, "value");
            Intrinsics.checkNotNullParameter(str3, "imgUrl");
            return new KeyItem(i, str, str2, str3, z, i2, detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof KeyItem)) {
                return false;
            }
            KeyItem keyItem = (KeyItem) obj;
            return this.type == keyItem.type && Intrinsics.areEqual((Object) this.value, (Object) keyItem.value) && Intrinsics.areEqual((Object) this.desc, (Object) keyItem.desc) && Intrinsics.areEqual((Object) this.imgUrl, (Object) keyItem.imgUrl) && this.isDefault == keyItem.isDefault && this.status == keyItem.status && Intrinsics.areEqual((Object) this.defaultDetail, (Object) keyItem.defaultDetail);
        }

        public int hashCode() {
            int hashCode = ((this.type * 31) + this.value.hashCode()) * 31;
            String str = this.desc;
            int i = 0;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.imgUrl.hashCode()) * 31;
            boolean z = this.isDefault;
            if (z) {
                z = true;
            }
            int i2 = (((hashCode2 + (z ? 1 : 0)) * 31) + this.status) * 31;
            Detail detail = this.defaultDetail;
            if (detail != null) {
                i = detail.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            return "KeyItem(type=" + this.type + ", value=" + this.value + ", desc=" + this.desc + ", imgUrl=" + this.imgUrl + ", isDefault=" + this.isDefault + ", status=" + this.status + ", defaultDetail=" + this.defaultDetail + VersionRange.RIGHT_OPEN;
        }

        public KeyItem(int i, String str, String str2, String str3, boolean z, int i2, Detail detail) {
            Intrinsics.checkNotNullParameter(str, "value");
            Intrinsics.checkNotNullParameter(str3, "imgUrl");
            this.type = i;
            this.value = str;
            this.desc = str2;
            this.imgUrl = str3;
            this.isDefault = z;
            this.status = i2;
            this.defaultDetail = detail;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ KeyItem(int r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, boolean r10, int r11, com.didi.payment.kycservice.key.list.response.PixKeyListResp.Detail r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
            /*
                r5 = this;
                r14 = r13 & 1
                if (r14 == 0) goto L_0x0006
                r6 = -100
            L_0x0006:
                r14 = r13 & 2
                java.lang.String r0 = ""
                if (r14 == 0) goto L_0x000e
                r14 = r0
                goto L_0x000f
            L_0x000e:
                r14 = r7
            L_0x000f:
                r7 = r13 & 4
                r1 = 0
                if (r7 == 0) goto L_0x0016
                r2 = r1
                goto L_0x0017
            L_0x0016:
                r2 = r8
            L_0x0017:
                r7 = r13 & 8
                if (r7 == 0) goto L_0x001c
                goto L_0x001d
            L_0x001c:
                r0 = r9
            L_0x001d:
                r7 = r13 & 16
                r8 = 0
                if (r7 == 0) goto L_0x0024
                r3 = 0
                goto L_0x0025
            L_0x0024:
                r3 = r10
            L_0x0025:
                r7 = r13 & 32
                if (r7 == 0) goto L_0x002b
                r4 = 0
                goto L_0x002c
            L_0x002b:
                r4 = r11
            L_0x002c:
                r7 = r13 & 64
                if (r7 == 0) goto L_0x0031
                goto L_0x0032
            L_0x0031:
                r1 = r12
            L_0x0032:
                r7 = r5
                r8 = r6
                r9 = r14
                r10 = r2
                r11 = r0
                r12 = r3
                r13 = r4
                r14 = r1
                r7.<init>(r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.key.list.response.PixKeyListResp.KeyItem.<init>(int, java.lang.String, java.lang.String, java.lang.String, boolean, int, com.didi.payment.kycservice.key.list.response.PixKeyListResp$Detail, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

        public final void setImgUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imgUrl = str;
        }

        public final boolean isDefault() {
            return this.isDefault;
        }

        public final void setDefault(boolean z) {
            this.isDefault = z;
        }

        public final int getStatus() {
            return this.status;
        }

        public final void setStatus(int i) {
            this.status = i;
        }

        public final Detail getDefaultDetail() {
            return this.defaultDetail;
        }

        public final void setDefaultDetail(Detail detail) {
            this.defaultDetail = detail;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$Detail;", "", "title", "", "subTitle", "defaultValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDefaultValue", "()Ljava/lang/String;", "getSubTitle", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyListResp.kt */
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
