package com.didi.payment.pix.key.detail.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp$Data;", "getData", "()Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp$Data;", "setData", "(Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp$Data;)V", "Data", "Item", "UnbindingDlgInfo", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyDetailResp.kt */
public final class PixKeyDetailResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R2\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00178\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, mo175978d2 = {"Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp$Data;", "", "()V", "dlgInfo", "Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp$UnbindingDlgInfo;", "getDlgInfo", "()Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp$UnbindingDlgInfo;", "setDlgInfo", "(Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp$UnbindingDlgInfo;)V", "imgUrl", "", "getImgUrl", "()Ljava/lang/String;", "setImgUrl", "(Ljava/lang/String;)V", "isDefault", "", "()Z", "setDefault", "(Z)V", "items", "Ljava/util/ArrayList;", "Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp$Item;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "keyInfo", "getKeyInfo", "setKeyInfo", "status", "", "getStatus", "()I", "setStatus", "(I)V", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyDetailResp.kt */
    public static final class Data {
        @SerializedName("deleteDetail")
        private UnbindingDlgInfo dlgInfo;
        private String imgUrl;
        private boolean isDefault;
        @SerializedName("keyDetail")
        private ArrayList<Item> items;
        private String keyInfo;
        private int status;

        public final String getKeyInfo() {
            return this.keyInfo;
        }

        public final void setKeyInfo(String str) {
            this.keyInfo = str;
        }

        public final String getImgUrl() {
            return this.imgUrl;
        }

        public final void setImgUrl(String str) {
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

        public final ArrayList<Item> getItems() {
            return this.items;
        }

        public final void setItems(ArrayList<Item> arrayList) {
            this.items = arrayList;
        }

        public final UnbindingDlgInfo getDlgInfo() {
            return this.dlgInfo;
        }

        public final void setDlgInfo(UnbindingDlgInfo unbindingDlgInfo) {
            this.dlgInfo = unbindingDlgInfo;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp$Item;", "", "item", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getItem", "()Ljava/lang/String;", "setItem", "(Ljava/lang/String;)V", "getValue", "setValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyDetailResp.kt */
    public static final class Item {
        private String item;
        private String value;

        public static /* synthetic */ Item copy$default(Item item2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = item2.item;
            }
            if ((i & 2) != 0) {
                str2 = item2.value;
            }
            return item2.copy(str, str2);
        }

        public final String component1() {
            return this.item;
        }

        public final String component2() {
            return this.value;
        }

        public final Item copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "item");
            Intrinsics.checkNotNullParameter(str2, "value");
            return new Item(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item2 = (Item) obj;
            return Intrinsics.areEqual((Object) this.item, (Object) item2.item) && Intrinsics.areEqual((Object) this.value, (Object) item2.value);
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            return "Item(item=" + this.item + ", value=" + this.value + VersionRange.RIGHT_OPEN;
        }

        public Item(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "item");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.item = str;
            this.value = str2;
        }

        public final String getItem() {
            return this.item;
        }

        public final void setItem(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.item = str;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setValue(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.value = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/payment/pix/key/detail/response/PixKeyDetailResp$UnbindingDlgInfo;", "", "deleteTitle", "", "deleteSubTitle", "deleteButton", "cancelButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCancelButton", "()Ljava/lang/String;", "setCancelButton", "(Ljava/lang/String;)V", "getDeleteButton", "setDeleteButton", "getDeleteSubTitle", "setDeleteSubTitle", "getDeleteTitle", "setDeleteTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyDetailResp.kt */
    public static final class UnbindingDlgInfo {
        private String cancelButton;
        private String deleteButton;
        private String deleteSubTitle;
        private String deleteTitle;

        public static /* synthetic */ UnbindingDlgInfo copy$default(UnbindingDlgInfo unbindingDlgInfo, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unbindingDlgInfo.deleteTitle;
            }
            if ((i & 2) != 0) {
                str2 = unbindingDlgInfo.deleteSubTitle;
            }
            if ((i & 4) != 0) {
                str3 = unbindingDlgInfo.deleteButton;
            }
            if ((i & 8) != 0) {
                str4 = unbindingDlgInfo.cancelButton;
            }
            return unbindingDlgInfo.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.deleteTitle;
        }

        public final String component2() {
            return this.deleteSubTitle;
        }

        public final String component3() {
            return this.deleteButton;
        }

        public final String component4() {
            return this.cancelButton;
        }

        public final UnbindingDlgInfo copy(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "deleteTitle");
            Intrinsics.checkNotNullParameter(str2, "deleteSubTitle");
            Intrinsics.checkNotNullParameter(str3, "deleteButton");
            Intrinsics.checkNotNullParameter(str4, "cancelButton");
            return new UnbindingDlgInfo(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UnbindingDlgInfo)) {
                return false;
            }
            UnbindingDlgInfo unbindingDlgInfo = (UnbindingDlgInfo) obj;
            return Intrinsics.areEqual((Object) this.deleteTitle, (Object) unbindingDlgInfo.deleteTitle) && Intrinsics.areEqual((Object) this.deleteSubTitle, (Object) unbindingDlgInfo.deleteSubTitle) && Intrinsics.areEqual((Object) this.deleteButton, (Object) unbindingDlgInfo.deleteButton) && Intrinsics.areEqual((Object) this.cancelButton, (Object) unbindingDlgInfo.cancelButton);
        }

        public int hashCode() {
            return (((((this.deleteTitle.hashCode() * 31) + this.deleteSubTitle.hashCode()) * 31) + this.deleteButton.hashCode()) * 31) + this.cancelButton.hashCode();
        }

        public String toString() {
            return "UnbindingDlgInfo(deleteTitle=" + this.deleteTitle + ", deleteSubTitle=" + this.deleteSubTitle + ", deleteButton=" + this.deleteButton + ", cancelButton=" + this.cancelButton + VersionRange.RIGHT_OPEN;
        }

        public UnbindingDlgInfo(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "deleteTitle");
            Intrinsics.checkNotNullParameter(str2, "deleteSubTitle");
            Intrinsics.checkNotNullParameter(str3, "deleteButton");
            Intrinsics.checkNotNullParameter(str4, "cancelButton");
            this.deleteTitle = str;
            this.deleteSubTitle = str2;
            this.deleteButton = str3;
            this.cancelButton = str4;
        }

        public final String getDeleteTitle() {
            return this.deleteTitle;
        }

        public final void setDeleteTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.deleteTitle = str;
        }

        public final String getDeleteSubTitle() {
            return this.deleteSubTitle;
        }

        public final void setDeleteSubTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.deleteSubTitle = str;
        }

        public final String getDeleteButton() {
            return this.deleteButton;
        }

        public final void setDeleteButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.deleteButton = str;
        }

        public final String getCancelButton() {
            return this.cancelButton;
        }

        public final void setCancelButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cancelButton = str;
        }
    }
}
