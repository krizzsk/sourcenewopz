package com.cardinalcommerce.p060a;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import rui.config.RConfigConstants;

/* renamed from: com.cardinalcommerce.a.getString */
public abstract class getString extends setLocationDataConsentGiven implements getExtendedData {
    private static final char[] Cardinal = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final byte[] cca_continue;
    protected final int configure;

    public getString(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("data cannot be null");
        } else if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        } else if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        } else {
            this.cca_continue = setForegroundTintBlendMode.cca_continue(bArr);
            this.configure = i;
        }
    }

    protected static byte[] Cardinal(byte[] bArr, int i) {
        byte[] cca_continue2 = setForegroundTintBlendMode.cca_continue(bArr);
        if (i > 0) {
            int length = bArr.length - 1;
            cca_continue2[length] = (byte) ((255 << i) & cca_continue2[length]);
        }
        return cca_continue2;
    }

    static getString init(int i, InputStream inputStream) throws IOException {
        if (i > 0) {
            int read = inputStream.read();
            int i2 = i - 1;
            byte[] bArr = new byte[i2];
            if (i2 != 0) {
                if (setTooltipText.init(inputStream, bArr) != i2) {
                    throw new EOFException("EOF encountered in middle of BIT STRING");
                } else if (read > 0 && read < 8) {
                    int i3 = i2 - 1;
                    if (bArr[i3] != ((byte) (bArr[i3] & (255 << read)))) {
                        return new AlgorithmParametersSpi(bArr, read);
                    }
                }
            }
            return new PrivateKeyInfo(bArr, read);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    /* access modifiers changed from: protected */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof getString)) {
            return false;
        }
        getString getstring = (getString) setlocationdataconsentgiven;
        return this.configure == getstring.configure && setForegroundTintBlendMode.Cardinal(getInstance(), getstring.getInstance());
    }

    /* access modifiers changed from: package-private */
    public abstract void cca_continue(setEnableDFSync setenabledfsync) throws IOException;

    public final byte[] cca_continue() {
        if (this.configure == 0) {
            return setForegroundTintBlendMode.cca_continue(this.cca_continue);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public final int cleanup() {
        return this.configure;
    }

    public final byte[] getInstance() {
        return Cardinal(this.cca_continue, this.configure);
    }

    /* access modifiers changed from: package-private */
    public final setLocationDataConsentGiven getSDKVersion() {
        return new PrivateKeyInfo(this.cca_continue, this.configure);
    }

    /* access modifiers changed from: package-private */
    public final setLocationDataConsentGiven getWarnings() {
        return new AlgorithmParametersSpi(this.cca_continue, this.configure);
    }

    public int hashCode() {
        return this.configure ^ setForegroundTintBlendMode.init(getInstance());
    }

    public final String init() {
        StringBuffer stringBuffer = new StringBuffer(RConfigConstants.KEYWORD_COLOR_SIGN);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new setEnableDFSync(byteArrayOutputStream).init(this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i = 0; i != byteArray.length; i++) {
                stringBuffer.append(Cardinal[(byteArray[i] >>> 4) & 15]);
                stringBuffer.append(Cardinal[byteArray[i] & Ascii.f53593SI]);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder("Internal error encoding BitString: ");
            sb.append(e.getMessage());
            throw new setUICustomization(sb.toString(), e);
        }
    }

    public String toString() {
        return init();
    }
}
