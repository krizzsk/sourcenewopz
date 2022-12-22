package com.microblink.blinkbarcode.image.highres;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.image.Image;
import com.microblink.blinkbarcode.image.ImageBuilder;
import com.microblink.blinkbarcode.secured.IIllIIllll;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: line */
class YuvHighResImageWrapper implements HighResImageWrapper {
    public static final Parcelable.Creator<YuvHighResImageWrapper> CREATOR = new Parcelable.Creator<YuvHighResImageWrapper>() {
        public YuvHighResImageWrapper createFromParcel(Parcel parcel) {
            return new YuvHighResImageWrapper((Image) parcel.readParcelable(Image.class.getClassLoader()));
        }

        public YuvHighResImageWrapper[] newArray(int i) {
            return new YuvHighResImageWrapper[i];
        }
    };
    private boolean IlIllIlIIl;
    private Image llIIlIlIIl;

    public int describeContents() {
        return 0;
    }

    public void dispose() {
        if (!this.IlIllIlIIl) {
            this.IlIllIlIIl = true;
            Image image = this.llIIlIlIIl;
            if (image != null) {
                image.dispose();
                this.llIIlIlIIl = null;
            }
        }
    }

    public Image getImage() {
        if (!this.IlIllIlIIl) {
            return this.llIIlIlIIl;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public void saveToFile(File file) throws IOException {
        if (!this.IlIllIlIIl) {
            Bitmap convertToBitmap = this.llIIlIlIIl.convertToBitmap();
            if (convertToBitmap != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                convertToBitmap.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream);
                fileOutputStream.close();
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Image image;
        if (!this.IlIllIlIIl && (image = this.llIIlIlIIl) != null) {
            parcel.writeParcelable(image, i);
        }
    }

    public YuvHighResImageWrapper(IIllIIllll iIllIIllll, Orientation orientation) {
        this.IlIllIlIIl = false;
        this.llIIlIlIIl = ImageBuilder.buildImageFromCamera2Image(iIllIIllll.llIIlIlIIl, orientation, Rectangle.getDefaultROI()).clone();
    }

    private YuvHighResImageWrapper(Image image) {
        this.IlIllIlIIl = false;
        this.llIIlIlIIl = image;
    }
}
