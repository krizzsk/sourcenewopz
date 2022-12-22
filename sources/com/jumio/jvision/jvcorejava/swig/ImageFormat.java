package com.jumio.jvision.jvcorejava.swig;

public final class ImageFormat {
    public static final ImageFormat BGR;
    public static final ImageFormat BGRA;
    public static final ImageFormat GRAY;
    public static final ImageFormat RGB;
    public static final ImageFormat RGBA;
    public static final ImageFormat YUVNV21;
    public static final ImageFormat YUVYV12;

    /* renamed from: c */
    public static ImageFormat[] f55058c;

    /* renamed from: a */
    public final int f55059a;

    /* renamed from: b */
    public final String f55060b;

    static {
        ImageFormat imageFormat = new ImageFormat("GRAY", JVCoreJavaJNI.ImageFormat_GRAY_get());
        GRAY = imageFormat;
        ImageFormat imageFormat2 = new ImageFormat("RGB", JVCoreJavaJNI.ImageFormat_RGB_get());
        RGB = imageFormat2;
        ImageFormat imageFormat3 = new ImageFormat("BGR", JVCoreJavaJNI.ImageFormat_BGR_get());
        BGR = imageFormat3;
        ImageFormat imageFormat4 = new ImageFormat("RGBA", JVCoreJavaJNI.ImageFormat_RGBA_get());
        RGBA = imageFormat4;
        ImageFormat imageFormat5 = new ImageFormat("BGRA", JVCoreJavaJNI.ImageFormat_BGRA_get());
        BGRA = imageFormat5;
        ImageFormat imageFormat6 = new ImageFormat("YUVNV21", JVCoreJavaJNI.ImageFormat_YUVNV21_get());
        YUVNV21 = imageFormat6;
        ImageFormat imageFormat7 = new ImageFormat("YUVYV12", JVCoreJavaJNI.ImageFormat_YUVYV12_get());
        YUVYV12 = imageFormat7;
        f55058c = new ImageFormat[]{imageFormat, imageFormat2, imageFormat3, imageFormat4, imageFormat5, imageFormat6, imageFormat7};
    }

    public ImageFormat(String str, int i) {
        this.f55060b = str;
        this.f55059a = i;
    }

    public static ImageFormat swigToEnum(int i) {
        ImageFormat[] imageFormatArr = f55058c;
        if (i < imageFormatArr.length && i >= 0 && imageFormatArr[i].f55059a == i) {
            return imageFormatArr[i];
        }
        int i2 = 0;
        while (true) {
            ImageFormat[] imageFormatArr2 = f55058c;
            if (i2 >= imageFormatArr2.length) {
                throw new IllegalArgumentException("No enum " + ImageFormat.class + " with value " + i);
            } else if (imageFormatArr2[i2].f55059a == i) {
                return imageFormatArr2[i2];
            } else {
                i2++;
            }
        }
    }

    public final int swigValue() {
        return this.f55059a;
    }

    public String toString() {
        return this.f55060b;
    }
}
