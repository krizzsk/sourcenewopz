package com.didi.aoe.extensions.support.image;

import android.graphics.Bitmap;
import com.didi.aoe.extensions.support.common.DataType;
import com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/image/ImageConversions;", "", "()V", "Companion", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ImageConversions.kt */
public final class ImageConversions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final void convertBitmapToTensorBuffer(Bitmap bitmap, TensorBuffer tensorBuffer) {
        Companion.convertBitmapToTensorBuffer(bitmap, tensorBuffer);
    }

    @JvmStatic
    public static final void convertTensorBufferToBitmap(TensorBuffer tensorBuffer, Bitmap bitmap) {
        Companion.convertTensorBufferToBitmap(tensorBuffer, bitmap);
    }

    private ImageConversions() {
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\n"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/image/ImageConversions$Companion;", "", "()V", "convertBitmapToTensorBuffer", "", "bitmap", "Landroid/graphics/Bitmap;", "buffer", "Lcom/didi/aoe/extensions/support/tensor/buffer/TensorBuffer;", "convertTensorBufferToBitmap", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ImageConversions.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void convertTensorBufferToBitmap(TensorBuffer tensorBuffer, Bitmap bitmap) {
            Intrinsics.checkParameterIsNotNull(tensorBuffer, "buffer");
            Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
            if (tensorBuffer.getDataType() == DataType.UINT8) {
                int[] shape = tensorBuffer.getShape();
                int i = 0;
                if (shape.length != 3 || shape[0] <= 0 || shape[1] <= 0 || shape[2] != 3) {
                    String arrays = Arrays.toString(shape);
                    Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
                    throw new IllegalArgumentException(String.format("Buffer shape %s is not valid. 3D TensorBuffer with shape [w, h, 3] is required", new Object[]{arrays}));
                }
                int i2 = shape[0];
                int i3 = shape[1];
                if (bitmap.getWidth() != i3 || bitmap.getHeight() != i2) {
                    String arrays2 = Arrays.toString(new int[]{bitmap.getWidth(), bitmap.getHeight()});
                    Intrinsics.checkExpressionValueIsNotNull(arrays2, "java.util.Arrays.toString(this)");
                    String arrays3 = Arrays.toString(new int[]{i3, i2});
                    Intrinsics.checkExpressionValueIsNotNull(arrays3, "java.util.Arrays.toString(this)");
                    throw new IllegalArgumentException(String.format("Given bitmap has different width or height %s with the expected ones %s.", new Object[]{arrays2, arrays3}));
                } else if (bitmap.isMutable()) {
                    int i4 = i3 * i2;
                    int[] iArr = new int[i4];
                    int[] intArray = tensorBuffer.getIntArray();
                    int i5 = 0;
                    while (i < i4) {
                        int i6 = i5 + 1;
                        int i7 = i6 + 1;
                        iArr[i] = (intArray[i5] << 16) | (intArray[i6] << 8) | intArray[i7];
                        i++;
                        i5 = i7 + 1;
                    }
                    bitmap.setPixels(iArr, 0, i3, 0, 0, i3, i2);
                } else {
                    throw new IllegalArgumentException("Given bitmap is not mutable");
                }
            } else {
                throw new UnsupportedOperationException("Converting TensorBuffer of type " + tensorBuffer.getDataType() + " to Bitmap is not supported yet.");
            }
        }

        @JvmStatic
        public final void convertBitmapToTensorBuffer(Bitmap bitmap, TensorBuffer tensorBuffer) {
            Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
            Intrinsics.checkParameterIsNotNull(tensorBuffer, "buffer");
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int[] iArr2 = new int[(i * 3)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                iArr2[i3] = (iArr[i2] >> 16) & 255;
                int i5 = i4 + 1;
                iArr2[i4] = (iArr[i2] >> 8) & 255;
                iArr2[i5] = iArr[i2] & 255;
                i2++;
                i3 = i5 + 1;
            }
            tensorBuffer.loadArray(iArr2, new int[]{height, width, 3});
        }
    }
}
