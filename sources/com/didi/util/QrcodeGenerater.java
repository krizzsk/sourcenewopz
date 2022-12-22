package com.didi.util;

import android.graphics.Bitmap;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.EncodeHintType;
import com.didi.dqr.MultiFormatWriter;
import com.didi.dqr.WriterException;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.qrcode.decoder.ErrorCorrectionLevel;
import java.util.EnumMap;
import java.util.Map;

public class QrcodeGenerater {

    /* renamed from: a */
    private static final int f45165a = -1;

    /* renamed from: b */
    private static final int f45166b = -16777216;

    /* renamed from: c */
    private static final String f45167c = "UTF-8";

    public static Bitmap encodeAsBitmap(String str, BarcodeFormat barcodeFormat, Map<EncodeHintType, Object> map, int i, int i2, int i3, int i4) throws WriterException {
        if (str == null) {
            return null;
        }
        if (map == null) {
            map = new EnumMap<>(EncodeHintType.class);
            map.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        }
        try {
            BitMatrix encode = new MultiFormatWriter().encode(str, barcodeFormat, i, i2, map);
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[(width * height)];
            for (int i5 = 0; i5 < height; i5++) {
                int i6 = i5 * width;
                for (int i7 = 0; i7 < width; i7++) {
                    iArr[i6 + i7] = encode.get(i7, i5) ? i4 : i3;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return createBitmap;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static Bitmap encodeQrCode(String str, int i, ErrorCorrectionLevel errorCorrectionLevel) {
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel);
            enumMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            enumMap.put(EncodeHintType.MARGIN, 0);
            return encodeAsBitmap(str, BarcodeFormat.QR_CODE, enumMap, i, i, -1, -16777216);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap encodeQrCode(String str, int i) {
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            enumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            enumMap.put(EncodeHintType.MARGIN, 0);
            return encodeAsBitmap(str, BarcodeFormat.QR_CODE, enumMap, i, i, -1, -16777216);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap encodeCODE_128(String str, int i, int i2) {
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            enumMap.put(EncodeHintType.MARGIN, 0);
            return encodeAsBitmap(str, BarcodeFormat.CODE_128, (Map<EncodeHintType, Object>) null, i, i2, -1, -16777216);
        } catch (Exception unused) {
            return null;
        }
    }
}
