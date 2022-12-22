package com.didi.payment.kycservice.net.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.payment.commonsdk.net.IValidator;
import com.didi.payment.commonsdk.net.WBaseRespTemplate;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp;", "Lcom/didi/payment/commonsdk/net/WBaseRespTemplate;", "Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$QRCodePageData;", "()V", "DetailItem", "KeyValuePair", "QRCodePageData", "QRDataInfo", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixQrCodeGenResp.kt */
public final class PixQrCodeGenResp extends WBaseRespTemplate<QRCodePageData> {

    @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$QRCodePageData;", "Ljava/io/Serializable;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "detailItems", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$DetailItem;", "Lkotlin/collections/ArrayList;", "getDetailItems", "()Ljava/util/ArrayList;", "setDetailItems", "(Ljava/util/ArrayList;)V", "qrDataInfo", "Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$QRDataInfo;", "getQrDataInfo", "()Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$QRDataInfo;", "setQrDataInfo", "(Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$QRDataInfo;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "valid", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixQrCodeGenResp.kt */
    public static final class QRCodePageData implements IValidator, Serializable {
        @SerializedName("detailData")
        public ArrayList<DetailItem> detailItems;
        public QRDataInfo qrDataInfo;
        public String title;

        public boolean valid() {
            return true;
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

        public final QRDataInfo getQrDataInfo() {
            QRDataInfo qRDataInfo = this.qrDataInfo;
            if (qRDataInfo != null) {
                return qRDataInfo;
            }
            Intrinsics.throwUninitializedPropertyAccessException("qrDataInfo");
            return null;
        }

        public final void setQrDataInfo(QRDataInfo qRDataInfo) {
            Intrinsics.checkNotNullParameter(qRDataInfo, "<set-?>");
            this.qrDataInfo = qRDataInfo;
        }

        public final ArrayList<DetailItem> getDetailItems() {
            ArrayList<DetailItem> arrayList = this.detailItems;
            if (arrayList != null) {
                return arrayList;
            }
            Intrinsics.throwUninitializedPropertyAccessException("detailItems");
            return null;
        }

        public final void setDetailItems(ArrayList<DetailItem> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.detailItems = arrayList;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006#"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$QRDataInfo;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "QRCode", "", "getQRCode", "()Ljava/lang/String;", "setQRCode", "(Ljava/lang/String;)V", "QRImage", "getQRImage", "setQRImage", "amount", "getAmount", "setAmount", "desc", "getDesc", "setDesc", "key", "getKey", "setKey", "maxAmount", "", "getMaxAmount", "()I", "setMaxAmount", "(I)V", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "valid", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixQrCodeGenResp.kt */
    public static final class QRDataInfo implements IValidator {
        public String QRCode;
        public String QRImage;
        private String amount = "";
        private String desc;
        private String key = "";
        private int maxAmount = 500000;
        public String subTitle;
        public String title;

        public boolean valid() {
            return true;
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

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            this.desc = str;
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

        public final String getQRCode() {
            String str = this.QRCode;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("QRCode");
            return null;
        }

        public final void setQRCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.QRCode = str;
        }

        public final String getQRImage() {
            String str = this.QRImage;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("QRImage");
            return null;
        }

        public final void setQRImage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.QRImage = str;
        }

        public final String getAmount() {
            return this.amount;
        }

        public final void setAmount(String str) {
            this.amount = str;
        }

        public final int getMaxAmount() {
            return this.maxAmount;
        }

        public final void setMaxAmount(int i) {
            this.maxAmount = i;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }
    }

    @Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$DetailItem;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "data", "", "Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$KeyValuePair;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixQrCodeGenResp.kt */
    public static final class DetailItem implements Parcelable, Serializable {
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
        public List<KeyValuePair> data;
        public String title;

        public int describeContents() {
            return 0;
        }

        public DetailItem() {
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

        public final List<KeyValuePair> getData() {
            List<KeyValuePair> list = this.data;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("data");
            return null;
        }

        public final void setData(List<KeyValuePair> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.data = list;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public DetailItem(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            setTitle(readString == null ? "" : readString);
            parcel.readTypedList(getData(), KeyValuePair.CREATOR);
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(getTitle());
            parcel.writeTypedList(getData());
        }

        @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$DetailItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$DetailItem;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$DetailItem;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: PixQrCodeGenResp.kt */
        public static final class CREATOR implements Parcelable.Creator<DetailItem> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            public DetailItem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DetailItem(parcel);
            }

            public DetailItem[] newArray(int i) {
                return new DetailItem[i];
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$KeyValuePair;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "value", "getValue", "setValue", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixQrCodeGenResp.kt */
    public static final class KeyValuePair implements Parcelable, Serializable {
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
        public String title;
        public String value;

        public int describeContents() {
            return 0;
        }

        public KeyValuePair() {
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

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public KeyValuePair(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String str = "";
            setTitle(readString == null ? str : readString);
            String readString2 = parcel.readString();
            setValue(readString2 != null ? readString2 : str);
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(getTitle());
            parcel.writeString(getValue());
        }

        @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$KeyValuePair$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$KeyValuePair;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/payment/kycservice/net/response/PixQrCodeGenResp$KeyValuePair;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: PixQrCodeGenResp.kt */
        public static final class CREATOR implements Parcelable.Creator<KeyValuePair> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            public KeyValuePair createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new KeyValuePair(parcel);
            }

            public KeyValuePair[] newArray(int i) {
                return new KeyValuePair[i];
            }
        }
    }
}
