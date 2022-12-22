package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.minidev.asm.Accessor;
import com.cardinalcommerce.dependencies.internal.minidev.asm.BeansAccess;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.setHorizontalScrollbarOverlay */
public final class setHorizontalScrollbarOverlay implements setNetworkAvailable<Object> {
    public final <E> void init(E e, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
        try {
            BeansAccess beansAccess = BeansAccess.get(e.getClass(), setClipChildren.getInstance);
            appendable.append('{');
            boolean z = false;
            for (Accessor accessor : beansAccess.getAccessors()) {
                Object obj = beansAccess.get(e, accessor.getIndex());
                if (obj != null || !setlayoutanimation.cca_continue()) {
                    if (z) {
                        appendable.append(',');
                    } else {
                        z = true;
                    }
                    setLayoutTransition.init(accessor.getName(), obj, appendable, setlayoutanimation);
                }
            }
            appendable.append('}');
        } catch (IOException e2) {
            throw e2;
        }
    }
}
