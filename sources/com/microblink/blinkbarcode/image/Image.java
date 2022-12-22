package com.microblink.blinkbarcode.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import java.nio.ByteBuffer;

/* compiled from: line */
public class Image implements Parcelable {
    public static final Parcelable.Creator<Image> CREATOR = new llIIlIlIIl();
    private ByteBuffer IIlIIIllIl;
    private Integer IlIllIlIIl;
    private boolean IlIllIlllI = false;
    private String IllIIIIllI;
    private ImageType IllIIIllII;
    private Integer lIIIIIllll;
    private Rect lIlIIIIlIl;
    private ImageFormat llIIIlllll;
    private Orientation llIIlIIlll;
    private Integer llIIlIlIIl;
    public long lllIIIlIlI = 0;
    public Object lllIlIlIIl;

    /* compiled from: line */
    public static class llIIlIlIIl implements Parcelable.Creator<Image> {
        public Object createFromParcel(Parcel parcel) {
            return new Image(parcel);
        }

        public Object[] newArray(int i) {
            return new Image[i];
        }
    }

    public Image(long j, boolean z) {
        this.lllIIIlIlI = j;
        this.IlIllIlllI = z;
    }

    private static native long deserialize(byte[] bArr);

    private static native long nativeClone(long j);

    private static native boolean nativeCopyPixelsToBitmap(long j, Bitmap bitmap);

    private static native void nativeDestruct(long j);

    private static native int nativeGetHeight(long j);

    private static native int nativeGetImageFormat(long j);

    private static native String nativeGetImageName(long j);

    private static native int nativeGetImageOrientation(long j);

    private static native int nativeGetImageType(long j);

    private static native ByteBuffer nativeGetPixelBuffer(long j);

    private static native void nativeGetRoi(long j, int[] iArr);

    private static native int nativeGetRowStride(long j);

    private static native int nativeGetWidth(long j);

    private static native void nativeSetImageOrientation(long j, int i);

    private static native void nativeSetRoi(long j, int i, int i2, int i3, int i4);

    private static native byte[] serialize(long j);

    public Bitmap convertToBitmap() {
        if (this.lllIIIlIlI != 0) {
            Rect rawROI = getRawROI();
            Bitmap createBitmap = Bitmap.createBitmap(rawROI.width(), rawROI.height(), Bitmap.Config.ARGB_8888);
            if (nativeCopyPixelsToBitmap(this.lllIIIlIlI, createBitmap)) {
                return createBitmap;
            }
            return null;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public int describeContents() {
        return 0;
    }

    public void dispose() {
        long j = this.lllIIIlIlI;
        if (j != 0 && this.IlIllIlllI) {
            nativeDestruct(j);
        }
        this.lllIIIlIlI = 0;
    }

    public void finalize() throws Throwable {
        super.finalize();
        dispose();
    }

    public ByteBuffer getBuffer() {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            if (this.IIlIIIllIl == null) {
                this.IIlIIIllIl = nativeGetPixelBuffer(j);
            }
            return this.IIlIIIllIl;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public int getHeight() {
        if (getImageOrientation().isHorizontal()) {
            return getRawHeight();
        }
        return getRawWidth();
    }

    public ImageFormat getImageFormat() {
        if (this.lllIIIlIlI != 0) {
            if (this.llIIIlllll == null) {
                this.llIIIlllll = ImageFormat.values()[nativeGetImageFormat(this.lllIIIlIlI)];
            }
            return this.llIIIlllll;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    @Deprecated
    public String getImageName() {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            if (this.IllIIIIllI == null) {
                this.IllIIIIllI = nativeGetImageName(j);
            }
            return this.IllIIIIllI;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public Orientation getImageOrientation() {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            if (this.llIIlIIlll == null) {
                this.llIIlIIlll = Orientation.fromInt(nativeGetImageOrientation(j));
            }
            return this.llIIlIIlll;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public ImageType getImageType() {
        if (this.lllIIIlIlI != 0) {
            if (this.IllIIIllII == null) {
                this.IllIIIllII = ImageType.values()[nativeGetImageType(this.lllIIIlIlI)];
            }
            return this.IllIIIllII;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public int getPixelStride() {
        if (this.lllIIIlIlI != 0) {
            return 1;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public Rect getROI() {
        Rect rawROI = getRawROI();
        int ordinal = getImageOrientation().ordinal();
        if (ordinal == 0) {
            return new Rect(getRawHeight() - rawROI.bottom, rawROI.left, getRawHeight() - rawROI.top, rawROI.right);
        }
        if (ordinal == 2) {
            return new Rect(rawROI.top, getRawWidth() - rawROI.right, rawROI.bottom, getRawWidth() - rawROI.left);
        }
        if (ordinal != 3) {
            return rawROI;
        }
        return new Rect(getRawWidth() - rawROI.right, getRawHeight() - rawROI.bottom, getRawWidth() - rawROI.left, getRawHeight() - rawROI.top);
    }

    public int getRawHeight() {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            if (this.IlIllIlIIl == null) {
                this.IlIllIlIIl = Integer.valueOf(nativeGetHeight(j));
            }
            return this.IlIllIlIIl.intValue();
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public Rect getRawROI() {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            if (this.lIlIIIIlIl == null) {
                int[] iArr = new int[4];
                nativeGetRoi(j, iArr);
                this.lIlIIIIlIl = new Rect(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
            return this.lIlIIIIlIl;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public int getRawWidth() {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            if (this.llIIlIlIIl == null) {
                this.llIIlIlIIl = Integer.valueOf(nativeGetWidth(j));
            }
            return this.llIIlIlIIl.intValue();
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public int getRowStride() {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            if (this.lIIIIIllll == null) {
                this.lIIIIIllll = Integer.valueOf(nativeGetRowStride(j));
            }
            return this.lIIIIIllll.intValue();
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public int getWidth() {
        if (getImageOrientation().isHorizontal()) {
            return getRawWidth();
        }
        return getRawHeight();
    }

    public boolean isDisposed() {
        return this.lllIIIlIlI == 0;
    }

    public void setImageOrientation(Orientation orientation) {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            this.llIIlIIlll = orientation;
            nativeSetImageOrientation(j, orientation.intValue());
            return;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public void setROI(Rect rect) {
        Rect rect2;
        if (this.lllIIIlIlI == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        } else if (rect.left < 0 || rect.right > getWidth() || rect.top < 0 || rect.bottom > getHeight()) {
            throw new IllegalArgumentException("Given ROI is not inside image!");
        } else {
            int ordinal = getImageOrientation().ordinal();
            if (ordinal == 0) {
                rect2 = new Rect(rect.top, getRawHeight() - rect.right, rect.bottom, getRawHeight() - rect.left);
            } else if (ordinal != 2) {
                if (ordinal == 3) {
                    rect2 = new Rect(getRawWidth() - rect.right, getRawHeight() - rect.bottom, getRawWidth() - rect.left, getRawHeight() - rect.top);
                }
                this.lIlIIIIlIl = rect;
                nativeSetRoi(this.lllIIIlIlI, rect.left, rect.top, rect.right, rect.bottom);
            } else {
                rect2 = new Rect(getRawWidth() - rect.bottom, rect.left, getRawWidth() - rect.top, rect.right);
            }
            rect = rect2;
            this.lIlIIIIlIl = rect;
            nativeSetRoi(this.lllIIIlIlI, rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            byte[] serialize = serialize(j);
            parcel.writeInt(serialize.length);
            parcel.writeByteArray(serialize);
            return;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public Image clone() {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            return new Image(nativeClone(j), true);
        }
        throw new IllegalStateException("Cannot clone disposed image!");
    }

    public Image(Parcel parcel) {
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        this.lllIIIlIlI = deserialize(bArr);
        this.IlIllIlllI = true;
    }
}
