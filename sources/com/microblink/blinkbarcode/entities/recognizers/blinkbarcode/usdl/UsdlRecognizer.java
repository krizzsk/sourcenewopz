package com.microblink.blinkbarcode.entities.recognizers.blinkbarcode.usdl;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.entities.Entity;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.blinkid.AgeLimitStatus;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;
import com.microblink.blinkbarcode.results.date.Date;
import com.microblink.blinkbarcode.results.date.DateResult;
import com.microblink.blinkbarcode.results.date.DateUtils;
import com.microblink.blinkbarcode.util.StringUtils;

@Deprecated
/* compiled from: line */
public final class UsdlRecognizer extends Recognizer<Result> {
    public static final Parcelable.Creator<UsdlRecognizer> CREATOR = new Parcelable.Creator<UsdlRecognizer>() {
        public UsdlRecognizer createFromParcel(Parcel parcel) {
            return new UsdlRecognizer(parcel, UsdlRecognizer.nativeConstruct());
        }

        public UsdlRecognizer[] newArray(int i) {
            return new UsdlRecognizer[i];
        }
    };

    /* compiled from: line */
    public static final class Result extends Recognizer.Result {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
            public Result createFromParcel(Parcel parcel) {
                Result result = new Result(Result.nativeConstruct());
                result.llIIlIlIIl(parcel);
                return result;
            }

            public Result[] newArray(int i) {
                return new Result[i];
            }
        };

        public Result(long j) {
            super(j);
        }

        private static native String addressNativeGet(long j);

        private static native String cityNativeGet(long j);

        private static native boolean dataIsUncertainNativeGet(long j);

        private static native DateResult dateOfBirthNativeGet(long j);

        private static native DateResult dateOfExpiryNativeGet(long j);

        private static native DateResult dateOfIssueNativeGet(long j);

        private static native String documentNumberNativeGet(long j);

        private static native byte[][] dynamicElementsNativeGet(long j);

        private static native byte[] elementNativeGet(long j, int i);

        private static native String endorsementsNativeGet(long j);

        private static native String firstNameNativeGet(long j);

        private static native String fullNameNativeGet(long j);

        private static native String jurisdictionNativeGet(long j);

        private static native String lastNameNativeGet(long j);

        private static native String middleNameNativeGet(long j);

        private static native String nameSuffixNativeGet(long j);

        /* access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        private static native String pdf417NativeGet(long j);

        private static native String postalCodeNativeGet(long j);

        private static native byte[] rawBytesNativeGet(long j);

        private static native String restrictionsNativeGet(long j);

        private static native String sexNativeGet(long j);

        private static native String streetNativeGet(long j);

        private static native String vehicleClassNativeGet(long j);

        public byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        public String getAddress() {
            return addressNativeGet(getNativeContext());
        }

        public int getAge() {
            Date date = getDateOfBirth().getDate();
            if (date == null) {
                return -1;
            }
            return DateUtils.yearsPassedFrom(date);
        }

        public AgeLimitStatus getAgeLimitStatus(int i) {
            int age = getAge();
            if (age == -1) {
                return AgeLimitStatus.NotAvailable;
            }
            if (age >= i) {
                return AgeLimitStatus.OverAgeLimit;
            }
            return AgeLimitStatus.BelowAgeLimit;
        }

        public String getCity() {
            return cityNativeGet(getNativeContext());
        }

        public DateResult getDateOfBirth() {
            return dateOfBirthNativeGet(getNativeContext());
        }

        public DateResult getDateOfExpiry() {
            return dateOfExpiryNativeGet(getNativeContext());
        }

        public DateResult getDateOfIssue() {
            return dateOfIssueNativeGet(getNativeContext());
        }

        public String getDocumentNumber() {
            return documentNumberNativeGet(getNativeContext());
        }

        public String getEndorsements() {
            return endorsementsNativeGet(getNativeContext());
        }

        public String getField(UsdlKeys usdlKeys) {
            return StringUtils.convertByteArrayToString(elementNativeGet(getNativeContext(), usdlKeys.ordinal()));
        }

        public String getFirstName() {
            return firstNameNativeGet(getNativeContext());
        }

        public String getFullName() {
            return fullNameNativeGet(getNativeContext());
        }

        public String getJurisdiction() {
            return jurisdictionNativeGet(getNativeContext());
        }

        public String getLastName() {
            return lastNameNativeGet(getNativeContext());
        }

        public String getMiddleName() {
            return middleNameNativeGet(getNativeContext());
        }

        public String getNameSuffix() {
            return nameSuffixNativeGet(getNativeContext());
        }

        @Deprecated
        public String[] getOptionalElements() {
            byte[][] dynamicElementsNativeGet = dynamicElementsNativeGet(getNativeContext());
            String[] strArr = new String[dynamicElementsNativeGet.length];
            for (int i = 0; i < dynamicElementsNativeGet.length; i++) {
                strArr[i] = StringUtils.convertByteArrayToString(dynamicElementsNativeGet[i]);
            }
            return strArr;
        }

        public String getPostalCode() {
            return postalCodeNativeGet(getNativeContext());
        }

        public byte[] getRawData() {
            return rawBytesNativeGet(getNativeContext());
        }

        public String getRawStringData() {
            return pdf417NativeGet(getNativeContext());
        }

        public String getRestrictions() {
            return restrictionsNativeGet(getNativeContext());
        }

        public String getSex() {
            return sexNativeGet(getNativeContext());
        }

        public String getStreet() {
            return streetNativeGet(getNativeContext());
        }

        public String getVehicleClass() {
            return vehicleClassNativeGet(getNativeContext());
        }

        public boolean isUncertain() {
            return dataIsUncertainNativeGet(getNativeContext());
        }

        public String toString() {
            return "US Driver's License\n\n" + getRawStringData();
        }

        public void llIIlIlIIl(byte[] bArr) {
            nativeDeserialize(getNativeContext(), bArr);
        }

        public void llIIlIlIIl(long j) {
            nativeDestruct(j);
        }

        public Result clone() {
            return new Result(nativeCopy(getNativeContext()));
        }
    }

    static {
        IlIllIlIIl.llIIlIlIIl();
    }

    private static native boolean enableCompactParserNativeGet(long j);

    private static native void enableCompactParserNativeSet(long j, boolean z);

    /* access modifiers changed from: private */
    public static native long nativeConstruct();

    private static native void nativeConsumeResult(long j, long j2);

    private static native long nativeCopy(long j);

    private static native void nativeDeserialize(long j, byte[] bArr);

    private static native void nativeDestruct(long j);

    private static native byte[] nativeSerialize(long j);

    private static native boolean nullQuietZoneAllowedNativeGet(long j);

    private static native void nullQuietZoneAllowedNativeSet(long j, boolean z);

    private static native boolean uncertainDecodingNativeGet(long j);

    private static native void uncertainDecodingNativeSet(long j, boolean z);

    public void consumeResultFrom(Entity entity) {
        if (this == entity) {
            return;
        }
        if (entity instanceof UsdlRecognizer) {
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
            return;
        }
        throw new IllegalArgumentException("Parameter type has to be UsdlRecognizer");
    }

    public boolean isEnableCompactParser() {
        return enableCompactParserNativeGet(getNativeContext());
    }

    public boolean isNullQuietZoneAllowed() {
        return nullQuietZoneAllowedNativeGet(getNativeContext());
    }

    public boolean isUncertainDecoding() {
        return uncertainDecodingNativeGet(getNativeContext());
    }

    public void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    public void setEnableCompactParser(boolean z) {
        enableCompactParserNativeSet(getNativeContext(), z);
    }

    public void setNullQuietZoneAllowed(boolean z) {
        nullQuietZoneAllowedNativeSet(getNativeContext(), z);
    }

    public void setUncertainDecoding(boolean z) {
        uncertainDecodingNativeSet(getNativeContext(), z);
    }

    public UsdlRecognizer() {
        this(nativeConstruct());
    }

    public byte[] llIIlIlIIl() {
        return nativeSerialize(getNativeContext());
    }

    private UsdlRecognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    public void llIIlIlIIl(byte[] bArr) {
        nativeDeserialize(getNativeContext(), bArr);
    }

    private UsdlRecognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    public UsdlRecognizer clone() {
        return new UsdlRecognizer(nativeCopy(getNativeContext()));
    }
}
