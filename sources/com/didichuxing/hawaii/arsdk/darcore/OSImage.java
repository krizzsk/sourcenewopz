package com.didichuxing.hawaii.arsdk.darcore;

import android.media.Image;
import android.os.Build;
import java.nio.ByteBuffer;

public class OSImage {
    private long mNativeContext;

    private native long nativeCreateContext(int i, int i2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i3, int i4, int i5);

    private native void nativeDestroyContext(long j);

    public OSImage(Image image) {
        int i;
        int i2;
        int i3;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        int i4;
        int i5;
        if (Build.VERSION.SDK_INT >= 19) {
            int width = image.getWidth();
            int height = image.getHeight();
            ByteBuffer buffer = image.getPlanes()[0].getBuffer();
            if (!buffer.isDirect()) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(buffer.capacity());
                allocateDirect.put(buffer);
                buffer = allocateDirect;
            }
            ByteBuffer buffer2 = image.getPlanes()[1].getBuffer();
            if (!buffer2.isDirect()) {
                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(buffer2.capacity());
                allocateDirect2.put(buffer2);
                buffer2 = allocateDirect2;
            }
            ByteBuffer buffer3 = image.getPlanes()[2].getBuffer();
            if (!buffer3.isDirect()) {
                ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(buffer3.capacity());
                allocateDirect3.put(buffer3);
                buffer3 = allocateDirect3;
            }
            int rowStride = image.getPlanes()[0].getRowStride();
            int rowStride2 = image.getPlanes()[1].getRowStride();
            i5 = width;
            i4 = height;
            i3 = rowStride;
            byteBuffer3 = buffer;
            byteBuffer2 = buffer2;
            i = image.getPlanes()[1].getPixelStride();
            byteBuffer = buffer3;
            i2 = rowStride2;
        } else {
            byteBuffer3 = null;
            byteBuffer2 = null;
            byteBuffer = null;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        this.mNativeContext = nativeCreateContext(i5, i4, byteBuffer3, byteBuffer2, byteBuffer, i3, i2, i);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        nativeDestroyContext(this.mNativeContext);
        super.finalize();
    }

    public long getNativeContext() {
        return this.mNativeContext;
    }
}
