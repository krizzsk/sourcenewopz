package com.didi.aoe.extensions.support.image.ops;

import com.didi.aoe.extensions.support.image.ImageOperator;
import com.didi.aoe.extensions.support.image.TensorImage;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/image/ops/RotateOp;", "Lcom/didi/aoe/extensions/support/image/ImageOperator;", "()V", "apply", "Lcom/didi/aoe/extensions/support/image/TensorImage;", "x", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: RotateOp.kt */
public final class RotateOp implements ImageOperator {
    public TensorImage apply(TensorImage tensorImage) {
        Intrinsics.checkParameterIsNotNull(tensorImage, "x");
        throw new NotImplementedError("An operation is not implemented: " + "not implemented");
    }
}
