package com.cardinalcommerce.p060a;

import com.didichuxing.diface.logger.DiFaceLogger;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.Payment */
public final class Payment extends setLocationDataConsentGiven {

    /* renamed from: a */
    private byte[] f2472a;

    Payment(byte[] bArr) {
        this.f2472a = bArr;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof Payment)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.f2472a, ((Payment) setlocationdataconsentgiven).f2472a);
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        setenabledfsync.configure(23);
        int length = this.f2472a.length;
        setenabledfsync.Cardinal(length);
        for (int i = 0; i != length; i++) {
            setenabledfsync.configure(this.f2472a[i]);
        }
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        int length = this.f2472a.length;
        return KeyAgreementSpi.Cardinal(length) + 1 + length;
    }

    public final String getInstance() {
        StringBuilder sb;
        String substring;
        String cca_continue = setAnimation.cca_continue(this.f2472a);
        if (cca_continue.indexOf(45) >= 0 || cca_continue.indexOf(43) >= 0) {
            int indexOf = cca_continue.indexOf(45);
            if (indexOf < 0) {
                indexOf = cca_continue.indexOf(43);
            }
            if (indexOf == cca_continue.length() - 3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cca_continue);
                sb2.append("00");
                cca_continue = sb2.toString();
            }
            if (indexOf == 10) {
                sb = new StringBuilder();
                sb.append(cca_continue.substring(0, 10));
                sb.append("00GMT");
                sb.append(cca_continue.substring(10, 13));
                sb.append(":");
                substring = cca_continue.substring(13, 15);
            } else {
                sb = new StringBuilder();
                sb.append(cca_continue.substring(0, 12));
                sb.append("GMT");
                sb.append(cca_continue.substring(12, 15));
                sb.append(":");
                substring = cca_continue.substring(15, 17);
            }
        } else if (cca_continue.length() == 11) {
            sb = new StringBuilder();
            sb.append(cca_continue.substring(0, 10));
            substring = "00GMT+00:00";
        } else {
            sb = new StringBuilder();
            sb.append(cca_continue.substring(0, 12));
            substring = "GMT+00:00";
        }
        sb.append(substring);
        return sb.toString();
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.init(this.f2472a);
    }

    public final String init() {
        String instance = getInstance();
        char charAt = instance.charAt(0);
        return (charAt < '5' ? "20" : DiFaceLogger.EVENT_ID_APPEAL_DIALOG_CANCEL).concat(String.valueOf(instance));
    }

    public final String toString() {
        return setAnimation.cca_continue(this.f2472a);
    }
}
