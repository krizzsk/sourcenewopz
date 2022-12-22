package com.didi.aoe.extensions.support.image;

import android.graphics.Bitmap;
import com.didi.aoe.extensions.support.common.DataType;
import com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer;
import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0013\u001a\u00020\u00162\b\b\u0001\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/image/TensorImage;", "", "dataType", "Lcom/didi/aoe/extensions/support/common/DataType;", "(Lcom/didi/aoe/extensions/support/common/DataType;)V", "container", "Lcom/didi/aoe/extensions/support/image/TensorImage$ImageContainer;", "getDataType", "()Lcom/didi/aoe/extensions/support/common/DataType;", "getBitmap", "Landroid/graphics/Bitmap;", "getBuffer", "Ljava/nio/ByteBuffer;", "getTensorBuffer", "Lcom/didi/aoe/extensions/support/tensor/buffer/TensorBuffer;", "load", "", "bitmap", "buffer", "pixels", "", "shape", "", "ImageContainer", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TensorImage.kt */
public final class TensorImage {

    /* renamed from: a */
    private final ImageContainer f8140a;

    /* renamed from: b */
    private final DataType f8141b;

    public TensorImage(DataType dataType) {
        Intrinsics.checkParameterIsNotNull(dataType, ParamsHelper.DATA_TYPE);
        this.f8141b = dataType;
        if (dataType == DataType.UINT8 || this.f8141b == DataType.FLOAT32) {
            this.f8140a = new ImageContainer(this.f8141b);
            return;
        }
        throw new IllegalStateException("Illegal data type for TensorImage: Only FLOAT32 and UINT8 are accepted".toString());
    }

    public final DataType getDataType() {
        return this.f8141b;
    }

    public final void load(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            this.f8140a.set(bitmap);
            return;
        }
        throw new IllegalStateException("Only supports loading ARGB_8888 bitmaps.".toString());
    }

    public final void load(float[] fArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "pixels");
        Intrinsics.checkParameterIsNotNull(iArr, "shape");
        if (iArr.length == 3 && iArr[2] == 3) {
            TensorBuffer createDynamic = TensorBuffer.Companion.createDynamic(this.f8141b);
            createDynamic.loadArray(fArr, iArr);
            load(createDynamic);
            return;
        }
        throw new IllegalStateException("Only supports image shape in (h, w, c), and channels representing R, G, B in order.".toString());
    }

    public final void load(int[] iArr, int[] iArr2) {
        Intrinsics.checkParameterIsNotNull(iArr, "pixels");
        Intrinsics.checkParameterIsNotNull(iArr2, "shape");
        if (iArr2.length == 3 && iArr2[2] == 3) {
            TensorBuffer createDynamic = TensorBuffer.Companion.createDynamic(this.f8141b);
            createDynamic.loadArray(iArr, iArr2);
            load(createDynamic);
            return;
        }
        throw new IllegalStateException("Only supports image shape in (h, w, c), and channels representing R, G, B in order.".toString());
    }

    public final void load(TensorBuffer tensorBuffer) {
        Intrinsics.checkParameterIsNotNull(tensorBuffer, "buffer");
        this.f8140a.set(tensorBuffer);
    }

    public final Bitmap getBitmap() {
        return this.f8140a.getBitmap();
    }

    public final TensorBuffer getTensorBuffer() {
        return this.f8140a.getTensorBuffer();
    }

    public final ByteBuffer getBuffer() {
        return getTensorBuffer().getBuffer();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/image/TensorImage$ImageContainer;", "", "dataType", "Lcom/didi/aoe/extensions/support/common/DataType;", "(Lcom/didi/aoe/extensions/support/common/DataType;)V", "ARGB_8888_ELEMENT_BYTES", "", "bitmapImage", "Landroid/graphics/Bitmap;", "bufferImage", "Lcom/didi/aoe/extensions/support/tensor/buffer/TensorBuffer;", "isBitmapUpdated", "", "isBufferUpdated", "getBitmap", "getDataType", "getTensorBuffer", "set", "", "bitmap", "buffer", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: TensorImage.kt */
    private static final class ImageContainer {
        private final int ARGB_8888_ELEMENT_BYTES = 4;
        private Bitmap bitmapImage;
        private TensorBuffer bufferImage;
        private final DataType dataType;
        private boolean isBitmapUpdated;
        private boolean isBufferUpdated;

        public ImageContainer(DataType dataType2) {
            Intrinsics.checkParameterIsNotNull(dataType2, ParamsHelper.DATA_TYPE);
            this.dataType = dataType2;
        }

        public final void set(Bitmap bitmap) {
            Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
            this.bitmapImage = bitmap;
            this.isBufferUpdated = false;
            this.isBitmapUpdated = true;
        }

        public final void set(TensorBuffer tensorBuffer) {
            Intrinsics.checkParameterIsNotNull(tensorBuffer, "buffer");
            this.bufferImage = tensorBuffer;
            this.isBitmapUpdated = false;
            this.isBufferUpdated = true;
        }

        public final DataType getDataType() {
            return this.dataType;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
            if (com.didi.aoe.extensions.support.utils.BitmapExtKt.getCompatAllocationByteCount(r1) < r0) goto L_0x0043;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.graphics.Bitmap getBitmap() {
            /*
                r4 = this;
                boolean r0 = r4.isBitmapUpdated
                if (r0 == 0) goto L_0x000c
                android.graphics.Bitmap r0 = r4.bitmapImage
                if (r0 != 0) goto L_0x000b
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x000b:
                return r0
            L_0x000c:
                boolean r0 = r4.isBufferUpdated
                if (r0 == 0) goto L_0x0085
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer r0 = r4.bufferImage
                if (r0 == 0) goto L_0x0019
                com.didi.aoe.extensions.support.common.DataType r0 = r0.getDataType()
                goto L_0x001a
            L_0x0019:
                r0 = 0
            L_0x001a:
                com.didi.aoe.extensions.support.common.DataType r1 = com.didi.aoe.extensions.support.common.DataType.UINT8
                r2 = 0
                r3 = 1
                if (r0 != r1) goto L_0x0022
                r0 = 1
                goto L_0x0023
            L_0x0022:
                r0 = 0
            L_0x0023:
                if (r0 == 0) goto L_0x0077
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer r0 = r4.bufferImage
                if (r0 != 0) goto L_0x002c
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x002c:
                int r0 = r0.getFlatSize()
                int r1 = r4.ARGB_8888_ELEMENT_BYTES
                int r0 = r0 * r1
                android.graphics.Bitmap r1 = r4.bitmapImage
                if (r1 == 0) goto L_0x0043
                if (r1 != 0) goto L_0x003d
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x003d:
                int r1 = com.didi.aoe.extensions.support.utils.BitmapExtKt.getCompatAllocationByteCount(r1)
                if (r1 >= r0) goto L_0x005a
            L_0x0043:
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer r0 = r4.bufferImage
                if (r0 != 0) goto L_0x004a
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x004a:
                int[] r0 = r0.getShape()
                r1 = r0[r2]
                r0 = r0[r3]
                android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
                android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r0, r2)
                r4.bitmapImage = r0
            L_0x005a:
                com.didi.aoe.extensions.support.image.ImageConversions$Companion r0 = com.didi.aoe.extensions.support.image.ImageConversions.Companion
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer r1 = r4.bufferImage
                if (r1 != 0) goto L_0x0063
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0063:
                android.graphics.Bitmap r2 = r4.bitmapImage
                if (r2 != 0) goto L_0x006a
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x006a:
                r0.convertTensorBufferToBitmap(r1, r2)
                r4.isBitmapUpdated = r3
                android.graphics.Bitmap r0 = r4.bitmapImage
                if (r0 != 0) goto L_0x0076
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0076:
                return r0
            L_0x0077:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "TensorImage is holding a float-value image which is not able to convert a Bitmap."
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            L_0x0085:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Both buffer and bitmap data are obsolete."
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.extensions.support.image.TensorImage.ImageContainer.getBitmap():android.graphics.Bitmap");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
            if (r1.getFlatSize() != r0) goto L_0x0046;
         */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer getTensorBuffer() {
            /*
                r3 = this;
                boolean r0 = r3.isBufferUpdated
                if (r0 == 0) goto L_0x000c
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer r0 = r3.bufferImage
                if (r0 != 0) goto L_0x000b
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x000b:
                return r0
            L_0x000c:
                boolean r0 = r3.isBitmapUpdated
                if (r0 == 0) goto L_0x006e
                android.graphics.Bitmap r0 = r3.bitmapImage
                if (r0 != 0) goto L_0x0017
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0017:
                int r0 = r0.getWidth()
                android.graphics.Bitmap r1 = r3.bitmapImage
                if (r1 != 0) goto L_0x0022
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0022:
                int r1 = r1.getHeight()
                int r0 = r0 * r1
                int r0 = r0 * 3
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer r1 = r3.bufferImage
                if (r1 == 0) goto L_0x0046
                if (r1 != 0) goto L_0x0033
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0033:
                boolean r1 = r1.isDynamic()
                if (r1 != 0) goto L_0x0050
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer r1 = r3.bufferImage
                if (r1 != 0) goto L_0x0040
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0040:
                int r1 = r1.getFlatSize()
                if (r1 == r0) goto L_0x0050
            L_0x0046:
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer$Companion r0 = com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer.Companion
                com.didi.aoe.extensions.support.common.DataType r1 = r3.dataType
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer r0 = r0.createDynamic(r1)
                r3.bufferImage = r0
            L_0x0050:
                com.didi.aoe.extensions.support.image.ImageConversions$Companion r0 = com.didi.aoe.extensions.support.image.ImageConversions.Companion
                android.graphics.Bitmap r1 = r3.bitmapImage
                if (r1 != 0) goto L_0x0059
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0059:
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer r2 = r3.bufferImage
                if (r2 != 0) goto L_0x0060
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0060:
                r0.convertBitmapToTensorBuffer(r1, r2)
                r0 = 1
                r3.isBufferUpdated = r0
                com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer r0 = r3.bufferImage
                if (r0 != 0) goto L_0x006d
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x006d:
                return r0
            L_0x006e:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Both buffer and bitmap data are obsolete."
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.extensions.support.image.TensorImage.ImageContainer.getTensorBuffer():com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer");
        }
    }
}
