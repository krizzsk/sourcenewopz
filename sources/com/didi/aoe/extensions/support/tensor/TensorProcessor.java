package com.didi.aoe.extensions.support.tensor;

import com.didi.aoe.extensions.support.common.SequentialProcessor;
import com.didi.aoe.extensions.support.tensor.buffer.TensorBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/tensor/TensorProcessor;", "Lcom/didi/aoe/extensions/support/common/SequentialProcessor;", "Lcom/didi/aoe/extensions/support/tensor/buffer/TensorBuffer;", "builder", "Lcom/didi/aoe/extensions/support/tensor/TensorProcessor$Builder;", "(Lcom/didi/aoe/extensions/support/tensor/TensorProcessor$Builder;)V", "Builder", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TensorProcessor.kt */
public final class TensorProcessor extends SequentialProcessor<TensorBuffer> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TensorProcessor(Builder builder) {
        super(builder);
        Intrinsics.checkParameterIsNotNull(builder, "builder");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/tensor/TensorProcessor$Builder;", "Lcom/didi/aoe/extensions/support/common/SequentialProcessor$Builder;", "Lcom/didi/aoe/extensions/support/tensor/buffer/TensorBuffer;", "()V", "add", "op", "Lcom/didi/aoe/extensions/support/tensor/TensorOperator;", "build", "Lcom/didi/aoe/extensions/support/tensor/TensorProcessor;", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: TensorProcessor.kt */
    public static final class Builder extends SequentialProcessor.Builder<TensorBuffer> {
        public final Builder add(TensorOperator tensorOperator) {
            Intrinsics.checkParameterIsNotNull(tensorOperator, "op");
            Builder builder = this;
            super.add(tensorOperator);
            return builder;
        }

        public TensorProcessor build() {
            return new TensorProcessor(this);
        }
    }
}
