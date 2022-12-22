package com.jumio.jvision.jvcorejava.swig;

public class Image {

    /* renamed from: a */
    public transient long f55057a;
    public transient boolean swigCMemOwn;

    public Image(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55057a = j;
    }

    public static long getCPtr(Image image) {
        if (image == null) {
            return 0;
        }
        return image.f55057a;
    }

    public int channelDepth() {
        return JVCoreJavaJNI.Image_channelDepth(this.f55057a, this);
    }

    public int channels() {
        return JVCoreJavaJNI.Image_channels(this.f55057a, this);
    }

    public synchronized void delete() {
        long j = this.f55057a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Image(j);
            }
            this.f55057a = 0;
        }
    }

    public boolean empty() {
        return JVCoreJavaJNI.Image_empty(this.f55057a, this);
    }

    public void finalize() {
        delete();
    }

    public ImageFormat format() {
        return ImageFormat.swigToEnum(JVCoreJavaJNI.Image_format(this.f55057a, this));
    }

    public void getBytes(byte[] bArr) {
        JVCoreJavaJNI.Image_getBytes(this.f55057a, this, bArr);
    }

    public int height() {
        return JVCoreJavaJNI.Image_height(this.f55057a, this);
    }

    public int length() {
        return JVCoreJavaJNI.Image_length(this.f55057a, this);
    }

    public int stride() {
        return JVCoreJavaJNI.Image_stride(this.f55057a, this);
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[length()];
        getBytes(bArr);
        return bArr;
    }

    public int width() {
        return JVCoreJavaJNI.Image_width(this.f55057a, this);
    }

    public Image() {
        this(JVCoreJavaJNI.new_Image(), true);
    }
}
