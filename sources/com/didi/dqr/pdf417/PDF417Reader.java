package com.didi.dqr.pdf417;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.ChecksumException;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Reader;
import com.didi.dqr.Result;
import com.didi.dqr.ResultMetadataType;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.multi.MultipleBarcodeReader;
import com.didi.dqr.pdf417.decoder.PDF417ScanningDecoder;
import com.didi.dqr.pdf417.detector.Detector;
import com.didi.dqr.pdf417.detector.PDF417DetectorResult;
import java.util.ArrayList;
import java.util.Map;

public final class PDF417Reader implements Reader, MultipleBarcodeReader {

    /* renamed from: a */
    private static final Result[] f18866a = new Result[0];

    public void reset() {
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException, ChecksumException {
        return decode(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public Result decode(BinaryBitmap binaryBitmap, DecodeOptions decodeOptions) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, decodeOptions != null ? decodeOptions.baseHints : null);
    }

    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        Result[] a = m14039a(binaryBitmap, map, false);
        if (a.length != 0 && a[0] != null) {
            return a[0];
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, DecodeOptions decodeOptions) throws NotFoundException {
        return decodeMultiple(binaryBitmap, decodeOptions != null ? decodeOptions.baseHints : null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        try {
            return m14039a(binaryBitmap, map, true);
        } catch (ChecksumException | FormatException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    /* renamed from: a */
    private static Result[] m14039a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException, FormatException, ChecksumException {
        ArrayList arrayList = new ArrayList();
        PDF417DetectorResult detect = Detector.detect(binaryBitmap, map, z);
        for (ResultPoint[] next : detect.getPoints()) {
            DecoderResult decode = PDF417ScanningDecoder.decode(detect.getBits(), next[4], next[5], next[6], next[7], m14041b(next), m14038a(next));
            Result result = new Result(decode.getText(), decode.getRawBytes(), next, BarcodeFormat.PDF_417);
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, decode.getECLevel());
            PDF417ResultMetadata pDF417ResultMetadata = (PDF417ResultMetadata) decode.getOther();
            if (pDF417ResultMetadata != null) {
                result.putMetadata(ResultMetadataType.PDF417_EXTRA_METADATA, pDF417ResultMetadata);
            }
            arrayList.add(result);
        }
        return (Result[]) arrayList.toArray(f18866a);
    }

    /* renamed from: a */
    private static int m14037a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return 0;
        }
        return (int) Math.abs(resultPoint.getX() - resultPoint2.getX());
    }

    /* renamed from: b */
    private static int m14040b(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(resultPoint.getX() - resultPoint2.getX());
    }

    /* renamed from: a */
    private static int m14038a(ResultPoint[] resultPointArr) {
        return Math.max(Math.max(m14037a(resultPointArr[0], resultPointArr[4]), (m14037a(resultPointArr[6], resultPointArr[2]) * 17) / 18), Math.max(m14037a(resultPointArr[1], resultPointArr[5]), (m14037a(resultPointArr[7], resultPointArr[3]) * 17) / 18));
    }

    /* renamed from: b */
    private static int m14041b(ResultPoint[] resultPointArr) {
        return Math.min(Math.min(m14040b(resultPointArr[0], resultPointArr[4]), (m14040b(resultPointArr[6], resultPointArr[2]) * 17) / 18), Math.min(m14040b(resultPointArr[1], resultPointArr[5]), (m14040b(resultPointArr[7], resultPointArr[3]) * 17) / 18));
    }
}
