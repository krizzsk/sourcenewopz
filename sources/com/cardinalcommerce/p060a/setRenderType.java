package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSTU4145;
import java.io.IOException;
import java.text.ParseException;
import java.util.TimeZone;

/* renamed from: com.cardinalcommerce.a.setRenderType */
public class setRenderType extends setLocationDataConsentGiven {
    protected byte[] init;

    setRenderType(byte[] bArr) {
        this.init = bArr;
    }

    private boolean configure(int i) {
        byte[] bArr = this.init;
        return bArr.length > i && bArr[i] >= 48 && bArr[i] <= 57;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof setRenderType)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.init, ((setRenderType) setlocationdataconsentgiven).init);
    }

    /* access modifiers changed from: protected */
    public final boolean CardinalError() {
        return configure(12) && configure(13);
    }

    /* access modifiers changed from: protected */
    public final boolean cca_continue() {
        int i = 0;
        while (true) {
            byte[] bArr = this.init;
            if (i == bArr.length) {
                return false;
            }
            if (bArr[i] == 46 && i == 14) {
                return true;
            }
            i++;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean cleanup() {
        return configure(10) && configure(11);
    }

    /* access modifiers changed from: package-private */
    public int configure() {
        int length = this.init.length;
        return KeyAgreementSpi.Cardinal(length) + 1 + length;
    }

    public final String getInstance() {
        String cca_continue = setAnimation.cca_continue(this.init);
        if (cca_continue.charAt(cca_continue.length() - 1) == 'Z') {
            StringBuilder sb = new StringBuilder();
            sb.append(cca_continue.substring(0, cca_continue.length() - 1));
            sb.append("GMT+00:00");
            return sb.toString();
        }
        int length = cca_continue.length() - 5;
        char charAt = cca_continue.charAt(length);
        if (charAt == '-' || charAt == '+') {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cca_continue.substring(0, length));
            sb2.append("GMT");
            int i = length + 3;
            sb2.append(cca_continue.substring(length, i));
            sb2.append(":");
            sb2.append(cca_continue.substring(i));
            return sb2.toString();
        }
        int length2 = cca_continue.length() - 3;
        char charAt2 = cca_continue.charAt(length2);
        if (charAt2 == '-' || charAt2 == '+') {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cca_continue.substring(0, length2));
            sb3.append("GMT");
            sb3.append(cca_continue.substring(length2));
            sb3.append(":00");
            return sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(cca_continue);
        sb4.append(CardinalUiType());
        return sb4.toString();
    }

    /* access modifiers changed from: package-private */
    public final setLocationDataConsentGiven getSDKVersion() {
        return new DSTU4145.Mappings(this.init);
    }

    public int hashCode() {
        return setForegroundTintBlendMode.init(this.init);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Date init() throws java.text.ParseException {
        /*
            r9 = this;
            byte[] r0 = r9.init
            java.lang.String r0 = com.cardinalcommerce.p060a.setAnimation.cca_continue(r0)
            java.lang.String r1 = "Z"
            boolean r2 = r0.endsWith(r1)
            r3 = 0
            if (r2 == 0) goto L_0x004a
            boolean r2 = r9.cca_continue()
            if (r2 == 0) goto L_0x001d
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHmmss.SSS'Z'"
            r2.<init>(r4)
            goto L_0x0040
        L_0x001d:
            boolean r2 = r9.CardinalError()
            if (r2 == 0) goto L_0x002b
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHmmss'Z'"
            r2.<init>(r4)
            goto L_0x0040
        L_0x002b:
            boolean r2 = r9.cleanup()
            if (r2 == 0) goto L_0x0039
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHmm'Z'"
            r2.<init>(r4)
            goto L_0x0040
        L_0x0039:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHH'Z'"
            r2.<init>(r4)
        L_0x0040:
            java.util.SimpleTimeZone r4 = new java.util.SimpleTimeZone
            r4.<init>(r3, r1)
        L_0x0045:
            r2.setTimeZone(r4)
            goto L_0x00db
        L_0x004a:
            r2 = 45
            int r2 = r0.indexOf(r2)
            if (r2 > 0) goto L_0x009f
            r2 = 43
            int r2 = r0.indexOf(r2)
            if (r2 <= 0) goto L_0x005b
            goto L_0x009f
        L_0x005b:
            boolean r1 = r9.cca_continue()
            if (r1 == 0) goto L_0x006a
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyyMMddHHmmss.SSS"
            r1.<init>(r2)
        L_0x0068:
            r2 = r1
            goto L_0x008e
        L_0x006a:
            boolean r1 = r9.CardinalError()
            if (r1 == 0) goto L_0x0078
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyyMMddHHmmss"
            r1.<init>(r2)
            goto L_0x0068
        L_0x0078:
            boolean r1 = r9.cleanup()
            if (r1 == 0) goto L_0x0086
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyyMMddHHmm"
            r1.<init>(r2)
            goto L_0x0068
        L_0x0086:
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyyMMddHH"
            r1.<init>(r2)
            goto L_0x0068
        L_0x008e:
            java.util.SimpleTimeZone r1 = new java.util.SimpleTimeZone
            java.util.TimeZone r4 = java.util.TimeZone.getDefault()
            java.lang.String r4 = r4.getID()
            r1.<init>(r3, r4)
            r2.setTimeZone(r1)
            goto L_0x00db
        L_0x009f:
            java.lang.String r0 = r9.getInstance()
            boolean r2 = r9.cca_continue()
            if (r2 == 0) goto L_0x00b1
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHmmss.SSSz"
            r2.<init>(r4)
            goto L_0x00d4
        L_0x00b1:
            boolean r2 = r9.CardinalError()
            if (r2 == 0) goto L_0x00bf
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHmmssz"
            r2.<init>(r4)
            goto L_0x00d4
        L_0x00bf:
            boolean r2 = r9.cleanup()
            if (r2 == 0) goto L_0x00cd
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHmmz"
            r2.<init>(r4)
            goto L_0x00d4
        L_0x00cd:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHz"
            r2.<init>(r4)
        L_0x00d4:
            java.util.SimpleTimeZone r4 = new java.util.SimpleTimeZone
            r4.<init>(r3, r1)
            goto L_0x0045
        L_0x00db:
            boolean r1 = r9.cca_continue()
            if (r1 == 0) goto L_0x0178
            r1 = 14
            java.lang.String r4 = r0.substring(r1)
            r5 = 1
            r6 = 1
        L_0x00e9:
            int r7 = r4.length()
            if (r6 >= r7) goto L_0x00fe
            char r7 = r4.charAt(r6)
            r8 = 48
            if (r8 > r7) goto L_0x00fe
            r8 = 57
            if (r7 > r8) goto L_0x00fe
            int r6 = r6 + 1
            goto L_0x00e9
        L_0x00fe:
            int r7 = r6 + -1
            r8 = 3
            if (r7 <= r8) goto L_0x012f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r7 = 4
            java.lang.String r7 = r4.substring(r3, r7)
            r5.append(r7)
            java.lang.String r4 = r4.substring(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L_0x0120:
            java.lang.String r0 = r0.substring(r3, r1)
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = r5.toString()
            goto L_0x0178
        L_0x012f:
            if (r7 != r5) goto L_0x0153
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r4.substring(r3, r6)
            r5.append(r7)
            java.lang.String r7 = "00"
            r5.append(r7)
            java.lang.String r4 = r4.substring(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L_0x0120
        L_0x0153:
            r5 = 2
            if (r7 != r5) goto L_0x0178
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r4.substring(r3, r6)
            r5.append(r7)
            java.lang.String r7 = "0"
            r5.append(r7)
            java.lang.String r4 = r4.substring(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L_0x0120
        L_0x0178:
            java.util.Date r0 = r2.parse(r0)
            java.util.Date r0 = com.cardinalcommerce.p060a.IESCipher.IES.getInstance(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setRenderType.init():java.util.Date");
    }

    private String CardinalUiType() {
        String str;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str = "-";
        } else {
            str = "+";
        }
        int i = rawOffset / 3600000;
        int i2 = (rawOffset - (((i * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(init())) {
                i += str.equals("+") ? 1 : -1;
            }
        } catch (ParseException unused) {
        }
        StringBuilder sb = new StringBuilder("GMT");
        sb.append(str);
        sb.append(i < 10 ? "0".concat(String.valueOf(i)) : Integer.toString(i));
        sb.append(":");
        sb.append(i2 < 10 ? "0".concat(String.valueOf(i2)) : Integer.toString(i2));
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] bArr = this.init;
        setenabledfsync.configure(24);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }
}
