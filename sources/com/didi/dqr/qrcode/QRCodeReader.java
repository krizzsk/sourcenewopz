package com.didi.dqr.qrcode;

import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.ChecksumException;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Reader;
import com.didi.dqr.Result;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.qrcode.decoder.Decoder;
import com.didi.dqr.qrcode.detector.FinderPattern;
import com.didi.dqr.qrcode.detector.FinderPatternInfo;

public class QRCodeReader implements Reader {

    /* renamed from: a */
    private static final ResultPoint[] f19012a = new ResultPoint[0];

    /* renamed from: b */
    private final Decoder f19013b = new Decoder();

    public void reset() {
    }

    /* access modifiers changed from: protected */
    public final Decoder getDecoder() {
        return this.f19013b;
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, (DecodeOptions) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.didi.dqr.common.DetectorResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.didi.dqr.common.DecoderResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.didi.dqr.common.DetectorResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.didi.dqr.common.DetectorResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: com.didi.dqr.common.DecoderResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: com.didi.dqr.common.DecoderResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.didi.dqr.common.DetectorResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.didi.dqr.common.DetectorResult} */
    /* JADX WARNING: type inference failed for: r1v4, types: [com.didi.dqr.common.DecoderResult] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.dqr.Result decode(com.didi.dqr.BinaryBitmap r7, com.didi.dqr.DecodeOptions r8) throws com.didi.dqr.NotFoundException, com.didi.dqr.ChecksumException, com.didi.dqr.FormatException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            if (r8 == 0) goto L_0x0021
            java.util.Map<com.didi.dqr.DecodeHintType, ?> r2 = r8.baseHints
            com.didi.dqr.DecodeHintType r3 = com.didi.dqr.DecodeHintType.PURE_BARCODE
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x0021
            com.didi.dqr.common.BitMatrix r7 = r7.getBlackMatrix()
            com.didi.dqr.common.BitMatrix r7 = m14197a(r7)
            com.didi.dqr.qrcode.decoder.Decoder r2 = r6.f19013b
            java.util.Map<com.didi.dqr.DecodeHintType, ?> r8 = r8.baseHints
            com.didi.dqr.common.DecoderResult r7 = r2.decode((com.didi.dqr.common.BitMatrix) r7, (java.util.Map<com.didi.dqr.DecodeHintType, ?>) r8)
            com.didi.dqr.ResultPoint[] r8 = f19012a
            goto L_0x006d
        L_0x0021:
            com.didi.dqr.task.base.DqrTaskData r2 = new com.didi.dqr.task.base.DqrTaskData     // Catch:{ Exception -> 0x005f }
            r2.<init>()     // Catch:{ Exception -> 0x005f }
            r2.setDecodeOptions(r8)     // Catch:{ Exception -> 0x005f }
            r2.setBinaryBitmap(r7)     // Catch:{ Exception -> 0x005f }
            com.didi.dqr.LuminanceSource r7 = r7.getSource()     // Catch:{ Exception -> 0x005f }
            r2.setSource(r7)     // Catch:{ Exception -> 0x005f }
            com.didi.dqr.task.base.TaskExecutor r7 = new com.didi.dqr.task.base.TaskExecutor     // Catch:{ Exception -> 0x005f }
            r7.<init>()     // Catch:{ Exception -> 0x005f }
            com.didi.dqr.task.detector.DetectorTask r8 = new com.didi.dqr.task.detector.DetectorTask     // Catch:{ Exception -> 0x005f }
            r8.<init>()     // Catch:{ Exception -> 0x005f }
            com.didi.dqr.task.base.TaskExecutor r7 = r7.addTask(r8)     // Catch:{ Exception -> 0x005f }
            com.didi.dqr.task.decoder.DecoderTask r8 = new com.didi.dqr.task.decoder.DecoderTask     // Catch:{ Exception -> 0x005f }
            r8.<init>()     // Catch:{ Exception -> 0x005f }
            com.didi.dqr.task.base.TaskExecutor r7 = r7.addTask(r8)     // Catch:{ Exception -> 0x005f }
            com.didi.dqr.task.base.DqrTaskData r7 = r7.run(r2)     // Catch:{ Exception -> 0x005f }
            com.didi.dqr.common.MultiDetectorResult r8 = r7.getDetectorResult()     // Catch:{ Exception -> 0x005f }
            java.util.List<com.didi.dqr.common.DetectorResult> r8 = r8.detectorResults     // Catch:{ Exception -> 0x005f }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ Exception -> 0x005f }
            com.didi.dqr.common.DetectorResult r8 = (com.didi.dqr.common.DetectorResult) r8     // Catch:{ Exception -> 0x005f }
            com.didi.dqr.common.DecoderResult r1 = r7.getDecoderResult()     // Catch:{ Exception -> 0x0060 }
            goto L_0x0065
        L_0x005f:
            r8 = r1
        L_0x0060:
            java.lang.String r7 = "dqr_scan_get_qr"
            com.didi.dqrutil.analysis.AnalysisManager.report(r7)
        L_0x0065:
            r7 = r1
            r1 = r8
            if (r1 == 0) goto L_0x00e2
            com.didi.dqr.ResultPoint[] r8 = r1.getPoints()
        L_0x006d:
            java.lang.String r2 = "dqr_scan_decode_success"
            com.didi.dqrutil.analysis.AnalysisManager.report(r2)
            if (r7 == 0) goto L_0x00dd
            java.lang.Object r2 = r7.getOther()
            boolean r2 = r2 instanceof com.didi.dqr.qrcode.decoder.QRCodeDecoderMetaData
            if (r2 == 0) goto L_0x0085
            java.lang.Object r2 = r7.getOther()
            com.didi.dqr.qrcode.decoder.QRCodeDecoderMetaData r2 = (com.didi.dqr.qrcode.decoder.QRCodeDecoderMetaData) r2
            r2.applyMirroredCorrection(r8)
        L_0x0085:
            com.didi.dqr.Result r2 = new com.didi.dqr.Result
            java.lang.String r3 = r7.getText()
            byte[] r4 = r7.getRawBytes()
            com.didi.dqr.BarcodeFormat r5 = com.didi.dqr.BarcodeFormat.QR_CODE
            r2.<init>(r3, r4, r8, r5)
            com.didi.dqr.ResultPoint[] r3 = f19012a
            if (r8 != r3) goto L_0x009b
            r2.isQRCode = r0
            goto L_0x00a6
        L_0x009b:
            r8 = 1
            r2.isQRCode = r8
            int r8 = r1.contourDilateCount
            r2.contourDilateCount = r8
            int r8 = r1.realContourDilateCount
            r2.realContourDilateCount = r8
        L_0x00a6:
            java.util.List r8 = r7.getByteSegments()
            if (r8 == 0) goto L_0x00b1
            com.didi.dqr.ResultMetadataType r0 = com.didi.dqr.ResultMetadataType.BYTE_SEGMENTS
            r2.putMetadata(r0, r8)
        L_0x00b1:
            java.lang.String r8 = r7.getECLevel()
            if (r8 == 0) goto L_0x00bc
            com.didi.dqr.ResultMetadataType r0 = com.didi.dqr.ResultMetadataType.ERROR_CORRECTION_LEVEL
            r2.putMetadata(r0, r8)
        L_0x00bc:
            boolean r8 = r7.hasStructuredAppend()
            if (r8 == 0) goto L_0x00dc
            com.didi.dqr.ResultMetadataType r8 = com.didi.dqr.ResultMetadataType.STRUCTURED_APPEND_SEQUENCE
            int r0 = r7.getStructuredAppendSequenceNumber()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.putMetadata(r8, r0)
            com.didi.dqr.ResultMetadataType r8 = com.didi.dqr.ResultMetadataType.STRUCTURED_APPEND_PARITY
            int r7 = r7.getStructuredAppendParity()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r2.putMetadata(r8, r7)
        L_0x00dc:
            return r2
        L_0x00dd:
            com.didi.dqr.NotFoundException r7 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r7
        L_0x00e2:
            com.didi.dqr.NotFoundException r7 = com.didi.dqr.NotFoundException.getNotFoundInstance()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.qrcode.QRCodeReader.decode(com.didi.dqr.BinaryBitmap, com.didi.dqr.DecodeOptions):com.didi.dqr.Result");
    }

    /* renamed from: a */
    private FinderPattern[] m14198a(FinderPatternInfo finderPatternInfo, int i, int i2) {
        FinderPattern[] finderPatternArr = new FinderPattern[3];
        System.arraycopy(finderPatternInfo.getPatternCenters(), 0, finderPatternArr, 0, 3);
        FinderPattern finderPattern = finderPatternArr[i];
        finderPatternArr[i] = finderPatternArr[i2];
        finderPatternArr[i2] = finderPattern;
        return finderPatternArr;
    }

    /* renamed from: a */
    private static BitMatrix m14197a(BitMatrix bitMatrix) throws NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float a = m14196a(topLeftOnBit, bitMatrix);
        int i = topLeftOnBit[1];
        int i2 = bottomRightOnBit[1];
        int i3 = topLeftOnBit[0];
        int i4 = bottomRightOnBit[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        if (i5 == i4 - i3 || (i4 = i3 + i5) < bitMatrix.getWidth()) {
            int round = Math.round(((float) ((i4 - i3) + 1)) / a);
            int round2 = Math.round(((float) (i5 + 1)) / a);
            if (round <= 0 || round2 <= 0) {
                throw NotFoundException.getNotFoundInstance();
            } else if (round2 == round) {
                int i6 = (int) (a / 2.0f);
                int i7 = i + i6;
                int i8 = i3 + i6;
                int i9 = (((int) (((float) (round - 1)) * a)) + i8) - i4;
                if (i9 > 0) {
                    if (i9 <= i6) {
                        i8 -= i9;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                int i10 = (((int) (((float) (round2 - 1)) * a)) + i7) - i2;
                if (i10 > 0) {
                    if (i10 <= i6) {
                        i7 -= i10;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                BitMatrix bitMatrix2 = new BitMatrix(round, round2);
                for (int i11 = 0; i11 < round2; i11++) {
                    int i12 = ((int) (((float) i11) * a)) + i7;
                    for (int i13 = 0; i13 < round; i13++) {
                        if (bitMatrix.get(((int) (((float) i13) * a)) + i8, i12)) {
                            bitMatrix2.set(i13, i11);
                        }
                    }
                }
                return bitMatrix2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    /* renamed from: a */
    private static float m14196a(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i < width && i2 < height) {
            if (z != bitMatrix.get(i, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z = !z;
            }
            i++;
            i2++;
        }
        if (i != width && i2 != height) {
            return ((float) (i - iArr[0])) / 7.0f;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
