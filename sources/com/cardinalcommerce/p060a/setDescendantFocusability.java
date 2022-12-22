package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cardinalcommerce.a.setDescendantFocusability */
public class setDescendantFocusability extends ArrayList<Object> implements setClipToPadding, setTransitionGroup, List<Object> {
    private static String configure(List<? extends Object> list, setLayoutAnimation setlayoutanimation) {
        StringBuilder sb = new StringBuilder();
        try {
            setVerticalScrollbarOverlay.Cardinal.init(list, sb, setlayoutanimation);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public final String configure() {
        return configure(this, setAddStatesFromChildren.init);
    }

    public final String Cardinal(setLayoutAnimation setlayoutanimation) {
        return configure(this, setlayoutanimation);
    }

    public final void Cardinal(Appendable appendable) throws IOException {
        setVerticalScrollbarOverlay.Cardinal.init(this, appendable, setAddStatesFromChildren.init);
    }

    public String toString() {
        return configure(this, setAddStatesFromChildren.init);
    }

    public final void init(Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
        setVerticalScrollbarOverlay.Cardinal.init(this, appendable, setlayoutanimation);
    }
}
