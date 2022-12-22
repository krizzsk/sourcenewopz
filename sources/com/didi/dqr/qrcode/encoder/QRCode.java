package com.didi.dqr.qrcode.encoder;

import com.didi.dqr.qrcode.decoder.ErrorCorrectionLevel;
import com.didi.dqr.qrcode.decoder.Mode;
import com.didi.dqr.qrcode.decoder.Version;

public final class QRCode {
    public static final int NUM_MASK_PATTERNS = 8;

    /* renamed from: a */
    private Mode f19085a;

    /* renamed from: b */
    private ErrorCorrectionLevel f19086b;

    /* renamed from: c */
    private Version f19087c;

    /* renamed from: d */
    private int f19088d = -1;

    /* renamed from: e */
    private ByteMatrix f19089e;

    public static boolean isValidMaskPattern(int i) {
        return i >= 0 && i < 8;
    }

    public Mode getMode() {
        return this.f19085a;
    }

    public ErrorCorrectionLevel getECLevel() {
        return this.f19086b;
    }

    public Version getVersion() {
        return this.f19087c;
    }

    public int getMaskPattern() {
        return this.f19088d;
    }

    public ByteMatrix getMatrix() {
        return this.f19089e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f19085a);
        sb.append("\n ecLevel: ");
        sb.append(this.f19086b);
        sb.append("\n version: ");
        sb.append(this.f19087c);
        sb.append("\n maskPattern: ");
        sb.append(this.f19088d);
        if (this.f19089e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f19089e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public void setMode(Mode mode) {
        this.f19085a = mode;
    }

    public void setECLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f19086b = errorCorrectionLevel;
    }

    public void setVersion(Version version) {
        this.f19087c = version;
    }

    public void setMaskPattern(int i) {
        this.f19088d = i;
    }

    public void setMatrix(ByteMatrix byteMatrix) {
        this.f19089e = byteMatrix;
    }
}
