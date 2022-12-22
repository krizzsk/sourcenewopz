package com.microblink.blinkbarcode.image.highres;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.image.Image;
import com.microblink.blinkbarcode.image.ImageBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: line */
class JpegHighResImageWrapper implements HighResImageWrapper {
    public static final Parcelable.Creator<JpegHighResImageWrapper> CREATOR = new Parcelable.Creator<JpegHighResImageWrapper>() {
        public JpegHighResImageWrapper createFromParcel(Parcel parcel) {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new JpegHighResImageWrapper(bArr, parcel.readInt());
        }

        public JpegHighResImageWrapper[] newArray(int i) {
            return new JpegHighResImageWrapper[i];
        }
    };
    private byte[] IlIllIlIIl;
    private int IllIIIllII;
    private boolean llIIIlllll;
    private Image llIIlIlIIl;

    public int describeContents() {
        return 0;
    }

    public void dispose() {
        if (!this.llIIIlllll) {
            this.llIIIlllll = true;
            Image image = this.llIIlIlIIl;
            if (image != null) {
                image.dispose();
                this.llIIlIlIIl = null;
            }
            this.IlIllIlIIl = null;
        }
    }

    public Image getImage() {
        if (!this.llIIIlllll) {
            if (this.llIIlIlIIl == null) {
                this.llIIlIlIIl = ImageBuilder.buildImageFromJpegBytes(this.IlIllIlIIl, this.IllIIIllII);
            }
            return this.llIIlIlIIl;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public void saveToFile(File file) throws IOException {
        if (!this.llIIIlllll) {
            FileChannel channel = new FileOutputStream(file, false).getChannel();
            channel.write(ByteBuffer.wrap(this.IlIllIlIIl));
            channel.close();
            return;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (!this.llIIIlllll) {
            parcel.writeInt(this.IlIllIlIIl.length);
            parcel.writeByteArray(this.IlIllIlIIl);
            parcel.writeInt(this.IllIIIllII);
        }
    }

    public JpegHighResImageWrapper(byte[] bArr, Orientation orientation) {
        this(bArr, orientation.intValue());
    }

    private JpegHighResImageWrapper(byte[] bArr, int i) {
        this.llIIIlllll = false;
        this.IlIllIlIIl = bArr;
        this.IllIIIllII = i;
    }
}
