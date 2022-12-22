package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.animatable.a */
/* compiled from: BaseAnimatableValue */
abstract class C1485a<V, O> implements AnimatableValue<V, O> {

    /* renamed from: a */
    final List<Keyframe<V>> f1401a;

    C1485a(V v) {
        this(Collections.singletonList(new Keyframe(v)));
    }

    C1485a(List<Keyframe<V>> list) {
        this.f1401a = list;
    }

    public List<Keyframe<V>> getKeyframes() {
        return this.f1401a;
    }

    public boolean isStatic() {
        return this.f1401a.isEmpty() || (this.f1401a.size() == 1 && this.f1401a.get(0).isStatic());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f1401a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f1401a.toArray()));
        }
        return sb.toString();
    }
}
