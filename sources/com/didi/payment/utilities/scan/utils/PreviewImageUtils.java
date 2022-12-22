package com.didi.payment.utilities.scan.utils;

import android.graphics.Rect;
import com.didi.dqr.SoLoader;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.RotatedRect;
import org.opencv.imgproc.Imgproc;

public class PreviewImageUtils {

    /* renamed from: a */
    private static final int f31696a = 50;

    /* renamed from: b */
    private static final double f31697b = 0.04d;

    /* renamed from: c */
    private static final double f31698c = 0.26d;

    /* renamed from: d */
    private static final double f31699d = 15.0d;

    /* renamed from: e */
    private static final int f31700e = 10;

    /* renamed from: f */
    private static final int f31701f = 70;

    public static class BarcodeFeatureModel {
        public boolean hasBarcodeFeature;
        public Rect rect;
    }

    static {
        SoLoader.load();
    }

    public static BarcodeFeatureModel checkOneBarcodeFeature(byte[] bArr, int i, int i2) {
        Mat a = m22481a(bArr, i, i2);
        if (a == null) {
            return null;
        }
        return m22480a(a, i, i2);
    }

    /* renamed from: a */
    private static Mat m22481a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (i % 2 != 0) {
            i++;
        }
        if (i2 % 2 != 0) {
            i2++;
        }
        Mat mat = new Mat(i2 + (i2 / 2), i, CvType.CV_8UC1);
        mat.put(0, 0, bArr);
        return mat;
    }

    /* renamed from: a */
    private static BarcodeFeatureModel m22480a(Mat mat, int i, int i2) {
        Imgproc.cvtColor(mat, mat, 106);
        Imgproc.adaptiveThreshold(mat, mat, 255.0d, 0, 1, 11, 1.0d);
        Imgproc.dilate(mat, mat, new Mat());
        ArrayList arrayList = new ArrayList();
        Imgproc.findContours(mat, arrayList, mat, 0, 1);
        ArrayList arrayList2 = new ArrayList();
        double d = 0.0d;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            RotatedRect minAreaRect = Imgproc.minAreaRect(new MatOfPoint2f(((MatOfPoint) arrayList.get(i3)).toArray()));
            if (m22482a(minAreaRect)) {
                arrayList2.add(minAreaRect);
                d += minAreaRect.center.f6685y;
            }
        }
        return m22479a(arrayList2, d, i, i2);
    }

    /* renamed from: a */
    private static boolean m22482a(RotatedRect rotatedRect) {
        if (rotatedRect == null || rotatedRect.size == null || rotatedRect.center == null || rotatedRect.size.width == 0.0d || rotatedRect.size.height == 0.0d || rotatedRect.center.f6685y == 0.0d || rotatedRect.size.height < 50.0d) {
            return false;
        }
        double d = rotatedRect.size.width / rotatedRect.size.height;
        if (d > f31698c || d < f31697b) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static BarcodeFeatureModel m22479a(List<RotatedRect> list, double d, int i, int i2) {
        if (d == 0.0d || list.isEmpty()) {
            return null;
        }
        BarcodeFeatureModel barcodeFeatureModel = new BarcodeFeatureModel();
        int a = m22478a(list, d);
        int size = list.size();
        boolean z = false;
        if (size > 10 && a > 0) {
            barcodeFeatureModel.rect = new Rect(0, Math.max(0, a - 100), i, Math.min(i2, Math.max(0, a + 100)));
        }
        if (size <= 70 && size >= 10) {
            z = true;
        }
        barcodeFeatureModel.hasBarcodeFeature = z;
        return barcodeFeatureModel;
    }

    /* renamed from: a */
    private static int m22478a(List<RotatedRect> list, double d) {
        int size = list.size();
        while (true) {
            double d2 = d / ((double) size);
            if (list.isEmpty()) {
                return -1;
            }
            RotatedRect rotatedRect = null;
            double d3 = 0.0d;
            for (RotatedRect next : list) {
                double abs = Math.abs(next.center.f6685y - d2);
                if (abs > f31699d && abs > d3) {
                    rotatedRect = next;
                    d3 = abs;
                }
            }
            if (rotatedRect == null) {
                return (int) d2;
            }
            list.remove(rotatedRect);
            d -= rotatedRect.center.f6685y;
            size = list.size();
        }
    }

    public static byte[] clipData(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 > i || i4 > i2 || i3 + i5 > i || i4 + i6 > i2) {
            return null;
        }
        int i7 = (i3 / 4) * 4;
        int i8 = (i4 / 4) * 4;
        int i9 = (i5 / 4) * 4;
        int i10 = (i6 / 4) * 4;
        int i11 = i9 * i10;
        byte[] bArr2 = new byte[((i11 / 2) + i11)];
        int i12 = i11 - ((i8 / 2) * i9);
        int i13 = (i2 * i) + i7;
        for (int i14 = i8; i14 < i8 + i10; i14++) {
            System.arraycopy(bArr, (i14 * i) + i7, bArr2, (i14 - i8) * i9, i9);
            if (i14 % 2 == 0) {
                int i15 = i14 >> 1;
                System.arraycopy(bArr, (i15 * i) + i13, bArr2, (i15 * i9) + i12, i9);
            }
        }
        return bArr2;
    }
}
