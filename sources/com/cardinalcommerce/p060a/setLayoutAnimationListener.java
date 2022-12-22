package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.setLayoutAnimationListener */
public final class setLayoutAnimationListener implements setNetworkAvailable<Object> {
    public final <E> void init(E e, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
        setLayoutAnimation.init(appendable);
        boolean z = false;
        for (Object obj : (Object[]) e) {
            if (z) {
                setLayoutAnimation.Cardinal(appendable);
            } else {
                z = true;
            }
            setAddStatesFromChildren.init(obj, appendable, setlayoutanimation);
        }
        setLayoutAnimation.CardinalError(appendable);
    }
}
