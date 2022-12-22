package com.google.p217ar.core;

import android.graphics.Rect;
import android.media.Image;
import com.google.p217ar.core.exceptions.FatalException;
import java.nio.ByteBuffer;
import p001a.p002a.C0017a;
import p001a.p002a.C0018b;

/* renamed from: com.google.ar.core.ArImage */
public class ArImage extends C0018b {
    long nativeHandle;
    final Session session;

    public ArImage(Session session2, long j) {
        this.session = session2;
        this.nativeHandle = j;
    }

    private native void nativeClose(long j);

    /* access modifiers changed from: private */
    public native ByteBuffer nativeGetBuffer(long j, long j2, int i);

    private native int nativeGetFormat(long j, long j2);

    private native int nativeGetHeight(long j, long j2);

    private native int nativeGetNumberOfPlanes(long j, long j2);

    /* access modifiers changed from: private */
    public native int nativeGetPixelStride(long j, long j2, int i);

    /* access modifiers changed from: private */
    public native int nativeGetRowStride(long j, long j2, int i);

    private native long nativeGetTimestamp(long j, long j2);

    private native int nativeGetWidth(long j, long j2);

    static native void nativeLoadSymbols();

    /* renamed from: com.google.ar.core.ArImage$a */
    class C18626a extends C0017a {

        /* renamed from: a */
        private final long f53442a;

        /* renamed from: b */
        private final int f53443b;

        public C18626a(long j, int i) {
            this.f53442a = j;
            this.f53443b = i;
        }

        public final int getRowStride() {
            ArImage arImage = ArImage.this;
            int access$000 = arImage.nativeGetRowStride(arImage.session.nativeWrapperHandle, this.f53442a, this.f53443b);
            if (access$000 != -1) {
                return access$000;
            }
            throw new FatalException("Unknown error in ArImage.Plane.getRowStride().");
        }

        public final int getPixelStride() {
            ArImage arImage = ArImage.this;
            int access$100 = arImage.nativeGetPixelStride(arImage.session.nativeWrapperHandle, this.f53442a, this.f53443b);
            if (access$100 != -1) {
                return access$100;
            }
            throw new FatalException("Unknown error in ArImage.Plane.getPixelStride().");
        }

        public final ByteBuffer getBuffer() {
            ArImage arImage = ArImage.this;
            return arImage.nativeGetBuffer(arImage.session.nativeWrapperHandle, this.f53442a, this.f53443b).asReadOnlyBuffer();
        }
    }

    public void close() {
        nativeClose(this.nativeHandle);
        this.nativeHandle = 0;
    }

    public int getFormat() {
        int nativeGetFormat = nativeGetFormat(this.session.nativeWrapperHandle, this.nativeHandle);
        if (nativeGetFormat != -1) {
            return nativeGetFormat;
        }
        throw new FatalException("Unknown error in ArImage.getFormat().");
    }

    public long getTimestamp() {
        long nativeGetTimestamp = nativeGetTimestamp(this.session.nativeWrapperHandle, this.nativeHandle);
        if (nativeGetTimestamp != -1) {
            return nativeGetTimestamp;
        }
        throw new FatalException("Unknown error in ArImage.getTimestamp().");
    }

    public int getWidth() {
        int nativeGetWidth = nativeGetWidth(this.session.nativeWrapperHandle, this.nativeHandle);
        if (nativeGetWidth != -1) {
            return nativeGetWidth;
        }
        throw new FatalException("Unknown error in ArImage.getWidth().");
    }

    public int getHeight() {
        int nativeGetHeight = nativeGetHeight(this.session.nativeWrapperHandle, this.nativeHandle);
        if (nativeGetHeight != -1) {
            return nativeGetHeight;
        }
        throw new FatalException("Unknown error in ArImage.getHeight().");
    }

    public Image.Plane[] getPlanes() {
        int nativeGetNumberOfPlanes = nativeGetNumberOfPlanes(this.session.nativeWrapperHandle, this.nativeHandle);
        if (nativeGetNumberOfPlanes != -1) {
            C18626a[] aVarArr = new C18626a[nativeGetNumberOfPlanes];
            for (int i = 0; i < nativeGetNumberOfPlanes; i++) {
                aVarArr[i] = new C18626a(this.nativeHandle, i);
            }
            return aVarArr;
        }
        throw new FatalException("Unknown error in ArImage.getPlanes().");
    }

    public Rect getCropRect() {
        throw new UnsupportedOperationException("Crop rect is unknown in this image.");
    }

    public void setCropRect(Rect rect) {
        throw new UnsupportedOperationException("This is a read-only image.");
    }

    public void setTimestamp(long j) {
        throw new UnsupportedOperationException("This is a read-only image.");
    }
}
