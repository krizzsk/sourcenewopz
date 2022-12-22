package com.didi.aoe.extensions.support.common;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\fB\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/common/SequentialProcessor;", "T", "Lcom/didi/aoe/extensions/support/common/Processor;", "builder", "Lcom/didi/aoe/extensions/support/common/SequentialProcessor$Builder;", "(Lcom/didi/aoe/extensions/support/common/SequentialProcessor$Builder;)V", "operatorList", "", "Lcom/didi/aoe/extensions/support/common/Operator;", "process", "input", "(Ljava/lang/Object;)Ljava/lang/Object;", "Builder", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: SequentialProcessor.kt */
public class SequentialProcessor<T> implements Processor<T> {

    /* renamed from: a */
    private final List<Operator<T>> f8139a;

    public SequentialProcessor(Builder<T> builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        this.f8139a = builder.getOperatorList();
    }

    public T process(T t) {
        for (Operator<T> apply : this.f8139a) {
            t = apply.apply(t);
        }
        return t;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016R-\u0010\u0004\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/common/SequentialProcessor$Builder;", "T", "", "()V", "operatorList", "Ljava/util/ArrayList;", "Lcom/didi/aoe/extensions/support/common/Operator;", "Lkotlin/collections/ArrayList;", "getOperatorList", "()Ljava/util/ArrayList;", "add", "op", "build", "Lcom/didi/aoe/extensions/support/common/SequentialProcessor;", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: SequentialProcessor.kt */
    public static class Builder<T> {
        private final ArrayList<Operator<T>> operatorList = new ArrayList<>();

        public final ArrayList<Operator<T>> getOperatorList() {
            return this.operatorList;
        }

        public final Builder<T> add(Operator<T> operator) {
            Intrinsics.checkParameterIsNotNull(operator, "op");
            Builder<T> builder = this;
            builder.operatorList.add(operator);
            return builder;
        }

        public SequentialProcessor<T> build() {
            return new SequentialProcessor<>(this);
        }
    }
}
