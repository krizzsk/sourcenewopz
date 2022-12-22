package com.didi.aoe.extensions.support.image;

import com.didi.aoe.extensions.support.common.SequentialProcessor;
import com.didi.aoe.extensions.support.image.ops.TensorOperatorWrapper;
import com.didi.aoe.extensions.support.tensor.TensorOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/image/ImageProcessor;", "Lcom/didi/aoe/extensions/support/common/SequentialProcessor;", "Lcom/didi/aoe/extensions/support/image/TensorImage;", "builder", "Lcom/didi/aoe/extensions/support/image/ImageProcessor$Builder;", "(Lcom/didi/aoe/extensions/support/image/ImageProcessor$Builder;)V", "Builder", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ImageProcessor.kt */
public final class ImageProcessor extends SequentialProcessor<TensorImage> {
    private ImageProcessor(Builder builder) {
        super(builder);
    }

    public /* synthetic */ ImageProcessor(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/image/ImageProcessor$Builder;", "Lcom/didi/aoe/extensions/support/common/SequentialProcessor$Builder;", "Lcom/didi/aoe/extensions/support/image/TensorImage;", "()V", "add", "op", "Lcom/didi/aoe/extensions/support/image/ImageOperator;", "Lcom/didi/aoe/extensions/support/tensor/TensorOperator;", "build", "Lcom/didi/aoe/extensions/support/image/ImageProcessor;", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ImageProcessor.kt */
    public static final class Builder extends SequentialProcessor.Builder<TensorImage> {
        public final Builder add(ImageOperator imageOperator) {
            Intrinsics.checkParameterIsNotNull(imageOperator, "op");
            Builder builder = this;
            super.add(imageOperator);
            return builder;
        }

        public final Builder add(TensorOperator tensorOperator) {
            Intrinsics.checkParameterIsNotNull(tensorOperator, "op");
            Builder builder = this;
            super.add(new TensorOperatorWrapper(tensorOperator));
            return builder;
        }

        public ImageProcessor build() {
            return new ImageProcessor(this, (DefaultConstructorMarker) null);
        }
    }
}
