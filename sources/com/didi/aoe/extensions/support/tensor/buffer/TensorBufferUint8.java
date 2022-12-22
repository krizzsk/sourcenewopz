package com.didi.aoe.extensions.support.tensor.buffer;

import com.didi.aoe.extensions.support.common.DataType;
import com.didi.soda.blocks.constant.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/tensor/buffer/TensorBufferUint8;", "Lcom/didi/aoe/extensions/support/tensor/buffer/TensorBuffer;", "()V", "shape", "", "([I)V", "getDataType", "Lcom/didi/aoe/extensions/support/common/DataType;", "getFloatArray", "", "getIntArray", "getTypeSize", "", "loadArray", "", "src", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TensorBufferUint8.kt */
public final class TensorBufferUint8 extends TensorBuffer {
    public TensorBufferUint8() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TensorBufferUint8(int[] iArr) {
        super(iArr);
        Intrinsics.checkParameterIsNotNull(iArr, "shape");
    }

    public DataType getDataType() {
        return DataType.UINT8;
    }

    public int[] getIntArray() {
        getBuffer().rewind();
        int flatSize = getFlatSize();
        int[] iArr = new int[flatSize];
        for (int i = 0; i < flatSize; i++) {
            iArr[i] = (byte) (getBuffer().get() & ((byte) 255));
        }
        return iArr;
    }

    public float[] getFloatArray() {
        getBuffer().rewind();
        int flatSize = getFlatSize();
        float[] fArr = new float[flatSize];
        for (int i = 0; i < flatSize; i++) {
            fArr[i] = (float) ((byte) (getBuffer().get() & ((byte) 255)));
        }
        return fArr;
    }

    public int getTypeSize() {
        return DataType.UINT8.byteSize();
    }

    public void loadArray(int[] iArr, int[] iArr2) {
        Intrinsics.checkParameterIsNotNull(iArr, Const.BlockParamConst.SRC);
        Intrinsics.checkParameterIsNotNull(iArr2, "shape");
        if (iArr.length == TensorBuffer.Companion.computeFlatSize(iArr2)) {
            resize(iArr2);
            getBuffer().rewind();
            for (int i : iArr) {
                getBuffer().put((byte) ((int) Math.max(Math.min((double) i, 255.0d), 0.0d)));
            }
            return;
        }
        throw new IllegalStateException("The size of the array to be loaded does not match the specified shape.".toString());
    }

    public void loadArray(float[] fArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(fArr, Const.BlockParamConst.SRC);
        Intrinsics.checkParameterIsNotNull(iArr, "shape");
        if (fArr.length == TensorBuffer.Companion.computeFlatSize(iArr)) {
            resize(iArr);
            getBuffer().rewind();
            for (float f : fArr) {
                getBuffer().put((byte) Math.max(Math.min((int) f, 255), 0));
            }
            return;
        }
        throw new IllegalStateException("The size of the array to be loaded does not match the specified shape.".toString());
    }
}
