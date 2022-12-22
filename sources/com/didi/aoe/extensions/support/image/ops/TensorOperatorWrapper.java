package com.didi.aoe.extensions.support.image.ops;

import com.didi.aoe.extensions.support.image.ImageOperator;
import com.didi.aoe.extensions.support.image.TensorImage;
import com.didi.aoe.extensions.support.tensor.TensorOperator;
import com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/image/ops/TensorOperatorWrapper;", "Lcom/didi/aoe/extensions/support/image/ImageOperator;", "tensorOp", "Lcom/didi/aoe/extensions/support/tensor/TensorOperator;", "(Lcom/didi/aoe/extensions/support/tensor/TensorOperator;)V", "apply", "Lcom/didi/aoe/extensions/support/image/TensorImage;", "image", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TensorOperatorWrapper.kt */
public final class TensorOperatorWrapper implements ImageOperator {

    /* renamed from: a */
    private final TensorOperator f8142a;

    public TensorOperatorWrapper(TensorOperator tensorOperator) {
        Intrinsics.checkParameterIsNotNull(tensorOperator, "tensorOp");
        this.f8142a = tensorOperator;
    }

    public TensorImage apply(TensorImage tensorImage) {
        Intrinsics.checkParameterIsNotNull(tensorImage, "image");
        tensorImage.load((TensorBuffer) this.f8142a.apply(tensorImage.getTensorBuffer()));
        return tensorImage;
    }
}
