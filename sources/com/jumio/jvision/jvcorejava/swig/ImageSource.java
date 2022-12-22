package com.jumio.jvision.jvcorejava.swig;

public class ImageSource {

    /* renamed from: a */
    public transient long f55061a;
    public transient boolean swigCMemOwn;

    public ImageSource(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55061a = j;
    }

    public static ImageSource CreateFromEncodedByteArray(byte[] bArr) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_CreateFromEncodedByteArray(bArr), true);
    }

    public static ImageSource CreateFromFileSystem(String str) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_CreateFromFileSystem(str), true);
    }

    public static ImageSource CreateFromUncompressedByteArray(byte[] bArr, int i, int i2, ImageFormat imageFormat, int i3) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_CreateFromUncompressedByteArray(bArr, i, i2, imageFormat.swigValue(), i3), true);
    }

    public static ImageSource Crop(ImageSource imageSource, Rect2i rect2i) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_Crop(getCPtr(imageSource), imageSource, Rect2i.getCPtr(rect2i), rect2i), true);
    }

    public static ImageSource CropRotate(ImageSource imageSource, Rect2i rect2i, int i) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_CropRotate(getCPtr(imageSource), imageSource, Rect2i.getCPtr(rect2i), rect2i, i), true);
    }

    public static ImageSource CropRotateScale(ImageSource imageSource, Rect2i rect2i, int i, Size2i size2i) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_CropRotateScale(getCPtr(imageSource), imageSource, Rect2i.getCPtr(rect2i), rect2i, i, Size2i.getCPtr(size2i), size2i), true);
    }

    public static ImageSource Rotate(ImageSource imageSource, int i) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_Rotate(getCPtr(imageSource), imageSource, i), true);
    }

    public static ImageSource Warp(ImageSource imageSource, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, Size2i size2i) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_Warp__SWIG_0(getCPtr(imageSource), imageSource, f, f2, f3, f4, f5, f6, f7, f8, Size2i.getCPtr(size2i), size2i), true);
    }

    public static long getCPtr(ImageSource imageSource) {
        if (imageSource == null) {
            return 0;
        }
        return imageSource.f55061a;
    }

    public int Height() {
        return JVCoreJavaJNI.ImageSource_Height(this.f55061a, this);
    }

    public int Length() {
        return JVCoreJavaJNI.ImageSource_Length(this.f55061a, this);
    }

    public int Stride() {
        return JVCoreJavaJNI.ImageSource_Stride(this.f55061a, this);
    }

    public int Width() {
        return JVCoreJavaJNI.ImageSource_Width(this.f55061a, this);
    }

    public synchronized void delete() {
        long j = this.f55061a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_ImageSource(j);
            }
            this.f55061a = 0;
        }
    }

    public boolean empty() {
        return JVCoreJavaJNI.ImageSource_empty(this.f55061a, this);
    }

    public void finalize() {
        delete();
    }

    public Image getGray() {
        return new Image(JVCoreJavaJNI.ImageSource_getGray(this.f55061a, this), true);
    }

    public Image getImage() {
        return new Image(JVCoreJavaJNI.ImageSource_getImage(this.f55061a, this), true);
    }

    public Image getRGB() {
        return new Image(JVCoreJavaJNI.ImageSource_getRGB(this.f55061a, this), true);
    }

    public static ImageSource Warp(ImageSource imageSource, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, Size2i size2i) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_Warp__SWIG_1(getCPtr(imageSource), imageSource, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, Size2i.getCPtr(size2i), size2i), true);
    }

    public ImageSource() {
        this(JVCoreJavaJNI.new_ImageSource__SWIG_0(), true);
    }

    public ImageSource(ImageSource imageSource) {
        this(JVCoreJavaJNI.new_ImageSource__SWIG_1(getCPtr(imageSource), imageSource), true);
    }
}
