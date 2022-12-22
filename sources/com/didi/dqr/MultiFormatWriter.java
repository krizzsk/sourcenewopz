package com.didi.dqr;

import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.oned.CodaBarWriter;
import com.didi.dqr.oned.Code128Writer;
import com.didi.dqr.oned.Code39Writer;
import com.didi.dqr.oned.Code93Writer;
import com.didi.dqr.oned.EAN13Writer;
import com.didi.dqr.oned.EAN8Writer;
import com.didi.dqr.oned.ITFWriter;
import com.didi.dqr.oned.UPCAWriter;
import com.didi.dqr.oned.UPCEWriter;
import com.didi.dqr.qrcode.QRCodeWriter;
import java.util.Map;

public final class MultiFormatWriter implements Writer {
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, (Map<EncodeHintType, ?>) null);
    }

    /* renamed from: com.didi.dqr.MultiFormatWriter$1 */
    static /* synthetic */ class C78261 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$dqr$BarcodeFormat;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.dqr.BarcodeFormat[] r0 = com.didi.dqr.BarcodeFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$dqr$BarcodeFormat = r0
                com.didi.dqr.BarcodeFormat r1 = com.didi.dqr.BarcodeFormat.EAN_8     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$dqr$BarcodeFormat     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.dqr.BarcodeFormat r1 = com.didi.dqr.BarcodeFormat.UPC_E     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$dqr$BarcodeFormat     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.dqr.BarcodeFormat r1 = com.didi.dqr.BarcodeFormat.EAN_13     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$dqr$BarcodeFormat     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.dqr.BarcodeFormat r1 = com.didi.dqr.BarcodeFormat.UPC_A     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$dqr$BarcodeFormat     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.dqr.BarcodeFormat r1 = com.didi.dqr.BarcodeFormat.QR_CODE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$dqr$BarcodeFormat     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.dqr.BarcodeFormat r1 = com.didi.dqr.BarcodeFormat.CODE_39     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$dqr$BarcodeFormat     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.dqr.BarcodeFormat r1 = com.didi.dqr.BarcodeFormat.CODE_93     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$dqr$BarcodeFormat     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.dqr.BarcodeFormat r1 = com.didi.dqr.BarcodeFormat.CODE_128     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$dqr$BarcodeFormat     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.dqr.BarcodeFormat r1 = com.didi.dqr.BarcodeFormat.ITF     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$didi$dqr$BarcodeFormat     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.dqr.BarcodeFormat r1 = com.didi.dqr.BarcodeFormat.CODABAR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.MultiFormatWriter.C78261.<clinit>():void");
        }
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        Writer writer;
        switch (C78261.$SwitchMap$com$didi$dqr$BarcodeFormat[barcodeFormat.ordinal()]) {
            case 1:
                writer = new EAN8Writer();
                break;
            case 2:
                writer = new UPCEWriter();
                break;
            case 3:
                writer = new EAN13Writer();
                break;
            case 4:
                writer = new UPCAWriter();
                break;
            case 5:
                writer = new QRCodeWriter();
                break;
            case 6:
                writer = new Code39Writer();
                break;
            case 7:
                writer = new Code93Writer();
                break;
            case 8:
                writer = new Code128Writer();
                break;
            case 9:
                writer = new ITFWriter();
                break;
            case 10:
                writer = new CodaBarWriter();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return writer.encode(str, barcodeFormat, i, i2, map);
    }
}
