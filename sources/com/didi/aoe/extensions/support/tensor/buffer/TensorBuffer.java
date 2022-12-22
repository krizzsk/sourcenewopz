package com.didi.aoe.extensions.support.tensor.buffer;

import com.didi.aoe.extensions.support.common.DataType;
import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\b\b&\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u0004H&J\b\u0010 \u001a\u00020\rH&J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H&J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010#\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0004H\u0004R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@DX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@DX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0005¨\u0006&"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/tensor/buffer/TensorBuffer;", "", "()V", "shape", "", "([I)V", "<set-?>", "Ljava/nio/ByteBuffer;", "buffer", "getBuffer", "()Ljava/nio/ByteBuffer;", "setBuffer", "(Ljava/nio/ByteBuffer;)V", "", "flatSize", "getFlatSize", "()I", "setFlatSize", "(I)V", "isDynamic", "", "()Z", "getShape", "()[I", "setShape", "allocateMemory", "", "getDataType", "Lcom/didi/aoe/extensions/support/common/DataType;", "getFloatArray", "", "getIntArray", "getTypeSize", "loadArray", "src", "loadBuffer", "resize", "Companion", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TensorBuffer.kt */
public abstract class TensorBuffer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private int f8143a = -1;

    /* renamed from: b */
    private final boolean f8144b = true;
    protected ByteBuffer buffer;
    protected int[] shape;

    @JvmStatic
    /* renamed from: b */
    private static final boolean m5290b(int[] iArr) {
        return Companion.isShapeValid(iArr);
    }

    @JvmStatic
    public static final int computeFlatSize(int[] iArr) {
        return Companion.computeFlatSize(iArr);
    }

    @JvmStatic
    public static final TensorBuffer createDynamic(DataType dataType) {
        return Companion.createDynamic(dataType);
    }

    @JvmStatic
    public static final TensorBuffer createFixedSize(int[] iArr, DataType dataType) {
        return Companion.createFixedSize(iArr, dataType);
    }

    public abstract DataType getDataType();

    public abstract float[] getFloatArray();

    public abstract int[] getIntArray();

    public abstract int getTypeSize();

    public abstract void loadArray(float[] fArr, int[] iArr);

    public abstract void loadArray(int[] iArr, int[] iArr2);

    public final ByteBuffer getBuffer() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buffer");
        }
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public final void setBuffer(ByteBuffer byteBuffer) {
        Intrinsics.checkParameterIsNotNull(byteBuffer, "<set-?>");
        this.buffer = byteBuffer;
    }

    public final int[] getShape() {
        int[] iArr = this.shape;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shape");
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public final void setShape(int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "<set-?>");
        this.shape = iArr;
    }

    public final int getFlatSize() {
        return this.f8143a;
    }

    /* access modifiers changed from: protected */
    public final void setFlatSize(int i) {
        this.f8143a = i;
    }

    public final boolean isDynamic() {
        return this.f8144b;
    }

    public TensorBuffer() {
        m5289a(new int[1]);
    }

    public TensorBuffer(int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "shape");
        m5289a(iArr);
    }

    public final void loadBuffer(ByteBuffer byteBuffer) {
        Intrinsics.checkParameterIsNotNull(byteBuffer, "buffer");
        int[] iArr = this.shape;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shape");
        }
        loadBuffer(byteBuffer, iArr);
    }

    public final void loadBuffer(ByteBuffer byteBuffer, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(byteBuffer, "buffer");
        Intrinsics.checkParameterIsNotNull(iArr, "shape");
        int computeFlatSize = Companion.computeFlatSize(iArr);
        boolean z = true;
        if (byteBuffer.limit() == getTypeSize() * computeFlatSize) {
            if (this.f8144b) {
                this.f8143a = computeFlatSize;
            } else {
                if (this.f8143a != computeFlatSize) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalStateException("The size of byte buffer and the size of the tensor buffer do not match.".toString());
                }
            }
            this.shape = (int[]) iArr.clone();
            byteBuffer.rewind();
            this.buffer = byteBuffer;
            return;
        }
        throw new IllegalStateException("The size of byte buffer and the shape do not match.".toString());
    }

    /* access modifiers changed from: protected */
    public final void resize(int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "shape");
        if (this.f8144b) {
            m5289a(iArr);
            return;
        }
        if (this.f8143a == Companion.computeFlatSize(iArr)) {
            this.shape = (int[]) iArr.clone();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: a */
    private final void m5289a(int[] iArr) {
        int computeFlatSize = Companion.computeFlatSize(iArr);
        if (this.f8143a != computeFlatSize) {
            this.f8143a = computeFlatSize;
            this.shape = (int[]) iArr.clone();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f8143a * getTypeSize());
            Intrinsics.checkExpressionValueIsNotNull(allocateDirect, "ByteBuffer.allocateDirec…flatSize * getTypeSize())");
            this.buffer = allocateDirect;
            if (allocateDirect == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buffer");
            }
            allocateDirect.order(ByteOrder.nativeOrder());
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0003¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/tensor/buffer/TensorBuffer$Companion;", "", "()V", "computeFlatSize", "", "shape", "", "createDynamic", "Lcom/didi/aoe/extensions/support/tensor/buffer/TensorBuffer;", "dataType", "Lcom/didi/aoe/extensions/support/common/DataType;", "createFixedSize", "isShapeValid", "", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: TensorBuffer.kt */
    public static final class Companion {

        @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 15})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[DataType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[DataType.FLOAT32.ordinal()] = 1;
                $EnumSwitchMapping$0[DataType.UINT8.ordinal()] = 2;
                int[] iArr2 = new int[DataType.values().length];
                $EnumSwitchMapping$1 = iArr2;
                iArr2[DataType.FLOAT32.ordinal()] = 1;
                $EnumSwitchMapping$1[DataType.UINT8.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TensorBuffer createFixedSize(int[] iArr, DataType dataType) {
            Intrinsics.checkParameterIsNotNull(iArr, "shape");
            Intrinsics.checkParameterIsNotNull(dataType, ParamsHelper.DATA_TYPE);
            int i = WhenMappings.$EnumSwitchMapping$0[dataType.ordinal()];
            if (i == 1) {
                return new TensorBufferFloat(iArr);
            }
            if (i == 2) {
                return new TensorBufferUint8(iArr);
            }
            throw new IllegalStateException("TensorBuffer does not support data type: " + dataType);
        }

        @JvmStatic
        public final TensorBuffer createDynamic(DataType dataType) {
            Intrinsics.checkParameterIsNotNull(dataType, ParamsHelper.DATA_TYPE);
            int i = WhenMappings.$EnumSwitchMapping$1[dataType.ordinal()];
            if (i == 1) {
                return new TensorBufferFloat();
            }
            if (i == 2) {
                return new TensorBufferUint8();
            }
            throw new IllegalStateException("TensorBuffer does not support data type: " + dataType);
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final boolean isShapeValid(int[] iArr) {
            if (iArr.length == 0) {
                return true;
            }
            for (int i : iArr) {
                if (i < 0) {
                    return false;
                }
            }
            return true;
        }

        @JvmStatic
        public final int computeFlatSize(int[] iArr) {
            Intrinsics.checkParameterIsNotNull(iArr, "shape");
            int i = 1;
            for (int i2 : iArr) {
                i *= i2;
            }
            return i;
        }
    }
}
