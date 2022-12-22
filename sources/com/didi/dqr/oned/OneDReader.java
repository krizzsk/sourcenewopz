package com.didi.dqr.oned;

import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.ChecksumException;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Reader;
import com.didi.dqr.ReaderException;
import com.didi.dqr.Result;
import com.didi.dqr.ResultMetadataType;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class OneDReader implements Reader {
    public abstract Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    public void reset() {
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, (DecodeOptions) null);
    }

    public Result decode(BinaryBitmap binaryBitmap, DecodeOptions decodeOptions) throws NotFoundException, FormatException {
        try {
            return m13912a(binaryBitmap, decodeOptions.baseHints);
        } catch (NotFoundException e) {
            if (!(decodeOptions != null && decodeOptions.baseHints.containsKey(DecodeHintType.TRY_HARDER)) || !binaryBitmap.isRotateSupported()) {
                throw e;
            }
            BinaryBitmap rotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
            Result a = m13912a(rotateCounterClockwise, decodeOptions.baseHints);
            Map<ResultMetadataType, Object> resultMetadata = a.getResultMetadata();
            int i = 270;
            if (resultMetadata != null && resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                i = (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
            }
            a.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
            ResultPoint[] resultPoints = a.getResultPoints();
            if (resultPoints != null) {
                int height = rotateCounterClockwise.getHeight();
                for (int i2 = 0; i2 < resultPoints.length; i2++) {
                    resultPoints[i2] = new ResultPoint((((float) height) - resultPoints[i2].getY()) - 1.0f, resultPoints[i2].getX());
                }
            }
            return a;
        }
    }

    /* renamed from: a */
    private Result m13912a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i;
        Map<DecodeHintType, ?> map2;
        EnumMap enumMap = map;
        try {
            return m13913b(binaryBitmap, map);
        } catch (Exception unused) {
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            BitArray bitArray = new BitArray(width);
            char c = 0;
            int i2 = 1;
            boolean z = enumMap != null && enumMap.containsKey(DecodeHintType.TRY_HARDER);
            int max = Math.max(1, height >> (z ? 8 : 5));
            int i3 = z ? height : 15;
            int i4 = height / 2;
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i5 + 1;
                int i7 = i6 / 2;
                if (!((i5 & 1) == 0)) {
                    i7 = -i7;
                }
                int i8 = (i7 * max) + i4;
                if (i8 < 0 || i8 >= height) {
                    break;
                }
                try {
                    bitArray = binaryBitmap.getBlackRow(i8, bitArray);
                    int i9 = 0;
                    while (i9 < 2) {
                        if (i9 == i2) {
                            bitArray.reverse();
                            if (enumMap != null && enumMap.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                                EnumMap enumMap2 = new EnumMap(DecodeHintType.class);
                                enumMap2.putAll(enumMap);
                                enumMap2.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                                enumMap = enumMap2;
                            }
                        }
                        try {
                            Result decodeRow = decodeRow(i8, bitArray, enumMap);
                            if (i9 == i2) {
                                decodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                ResultPoint[] resultPoints = decodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    map2 = enumMap;
                                    float f = (float) width;
                                    try {
                                        i = width;
                                    } catch (ReaderException unused2) {
                                        i = width;
                                        i9++;
                                        enumMap = map2;
                                        width = i;
                                        c = 0;
                                        i2 = 1;
                                    }
                                    try {
                                        resultPoints[0] = new ResultPoint((f - resultPoints[c].getX()) - 1.0f, resultPoints[c].getY());
                                        try {
                                            resultPoints[1] = new ResultPoint((f - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                        } catch (ReaderException unused3) {
                                            continue;
                                        }
                                    } catch (ReaderException unused4) {
                                        i9++;
                                        enumMap = map2;
                                        width = i;
                                        c = 0;
                                        i2 = 1;
                                    }
                                }
                            }
                            return decodeRow;
                        } catch (ReaderException unused5) {
                            map2 = enumMap;
                            i = width;
                            i9++;
                            enumMap = map2;
                            width = i;
                            c = 0;
                            i2 = 1;
                        }
                    }
                    continue;
                } catch (NotFoundException unused6) {
                }
                i5 = i6;
                width = width;
                c = 0;
                i2 = 1;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    /* renamed from: b */
    private Result m13913b(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i;
        Map<DecodeHintType, ?> map2;
        EnumMap enumMap = map;
        int height = binaryBitmap.getHeight();
        int width = binaryBitmap.getWidth();
        BitArray bitArray = new BitArray(height);
        char c = 0;
        int i2 = 1;
        boolean z = enumMap != null && enumMap.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, width >> (z ? 8 : 5));
        int i3 = z ? width : 15;
        int i4 = width / 2;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = i5 + 1;
            int i7 = i6 / 2;
            if (!((i5 & 1) == 0)) {
                i7 = -i7;
            }
            int i8 = (i7 * max) + i4;
            if (i8 < 0 || i8 >= width) {
                break;
            }
            try {
                bitArray = binaryBitmap.getRotatedBlackRow(i8, bitArray);
                int i9 = 0;
                while (i9 < 2) {
                    if (i9 == i2) {
                        bitArray.reverse();
                        if (enumMap != null && enumMap.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap2 = new EnumMap(DecodeHintType.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                            enumMap = enumMap2;
                        }
                    }
                    try {
                        Result decodeRow = decodeRow(i8, bitArray, enumMap);
                        if (i9 == i2) {
                            decodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                            ResultPoint[] resultPoints = decodeRow.getResultPoints();
                            if (resultPoints != null) {
                                map2 = enumMap;
                                float f = (float) height;
                                try {
                                    i = height;
                                } catch (ReaderException unused) {
                                    i = height;
                                    i9++;
                                    enumMap = map2;
                                    height = i;
                                    c = 0;
                                    i2 = 1;
                                }
                                try {
                                    resultPoints[0] = new ResultPoint((f - resultPoints[c].getX()) - 1.0f, resultPoints[c].getY());
                                    try {
                                        resultPoints[1] = new ResultPoint((f - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                    } catch (ReaderException unused2) {
                                        continue;
                                    }
                                } catch (ReaderException unused3) {
                                    i9++;
                                    enumMap = map2;
                                    height = i;
                                    c = 0;
                                    i2 = 1;
                                }
                            }
                        }
                        return decodeRow;
                    } catch (ReaderException unused4) {
                        map2 = enumMap;
                        i = height;
                        i9++;
                        enumMap = map2;
                        height = i;
                        c = 0;
                        i2 = 1;
                    }
                }
                continue;
            } catch (NotFoundException unused5) {
            }
            i5 = i6;
            height = height;
            c = 0;
            i2 = 1;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void recordPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i < size) {
            boolean z = !bitArray.get(i);
            while (i < size) {
                if (bitArray.get(i) != z) {
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                    iArr[i2] = 1;
                    z = !z;
                }
                i++;
            }
            if (i2 == length) {
                return;
            }
            if (i2 != length - 1 || i != size) {
                throw NotFoundException.getNotFoundInstance();
            }
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void recordPatternInReverse(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.get(i) != z) {
                length--;
                z = !z;
            }
        }
        if (length < 0) {
            recordPattern(bitArray, i + 1, iArr);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
