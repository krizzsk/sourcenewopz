package com.microblink.blinkbarcode.image.highres;

import android.os.Parcelable;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.image.Image;
import com.microblink.blinkbarcode.secured.IIllIIllll;
import com.microblink.blinkbarcode.secured.llIIlllIll;
import com.microblink.blinkbarcode.secured.lllIIlIIlI;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: line */
public interface HighResImageWrapper extends Parcelable {

    /* compiled from: line */
    public static final class Factory {
        public static HighResImageWrapper createFromFrame(llIIlllIll lliilllill, Orientation orientation) {
            if (orientation == null || orientation == Orientation.ORIENTATION_UNKNOWN) {
                throw new IllegalArgumentException("Image orientation cannot be null nor unknown");
            }
            if (lliilllill instanceof IIllIIllll) {
                IIllIIllll iIllIIllll = (IIllIIllll) lliilllill;
                int format = iIllIIllll.llIIlIlIIl.getFormat();
                if (format == 35) {
                    return new YuvHighResImageWrapper(iIllIIllll, orientation);
                }
                if (format == 256) {
                    ByteBuffer buffer = iIllIIllll.llIIlIlIIl.getPlanes()[0].getBuffer();
                    byte[] bArr = new byte[buffer.capacity()];
                    buffer.get(bArr);
                    return new JpegHighResImageWrapper(bArr, orientation);
                }
            } else if (lliilllill instanceof lllIIlIIlI) {
                return new JpegHighResImageWrapper(((lllIIlIIlI) lliilllill).llIIlIIlll(), orientation);
            }
            throw new IllegalArgumentException("Camera image must be in YUV_420_888 or JPEG format. Other formats are not supported!");
        }
    }

    void dispose();

    Image getImage();

    void saveToFile(File file) throws IOException;
}
