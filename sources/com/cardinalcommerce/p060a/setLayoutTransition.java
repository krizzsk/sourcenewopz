package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* renamed from: com.cardinalcommerce.a.setLayoutTransition */
public class setLayoutTransition extends HashMap<String, Object> implements setClipToPadding, setTransitionGroup {
    public setLayoutTransition() {
    }

    public static String cca_continue(String str) {
        return setAddStatesFromChildren.configure(str);
    }

    public static String Cardinal(Map<String, ? extends Object> map, setLayoutAnimation setlayoutanimation) {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            try {
                sb.append("null");
            } catch (IOException unused) {
            }
        } else {
            setVerticalScrollbarOverlay.getInstance.init(map, sb, setlayoutanimation);
        }
        return sb.toString();
    }

    public static void init(String str, Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
        if (str == null) {
            appendable.append("null");
        } else if (!setlayoutanimation.Cardinal(str)) {
            appendable.append(str);
        } else {
            appendable.append(Typography.quote);
            setAddStatesFromChildren.configure(str, appendable, setlayoutanimation);
            appendable.append(Typography.quote);
        }
        appendable.append(':');
        if (obj instanceof String) {
            setlayoutanimation.Cardinal(appendable, (String) obj);
        } else {
            setAddStatesFromChildren.init(obj, appendable, setlayoutanimation);
        }
    }

    public setLayoutTransition(Map<String, ?> map) {
        super(map);
    }

    public final void Cardinal(Appendable appendable) throws IOException {
        setVerticalScrollbarOverlay.getInstance.init(this, appendable, setAddStatesFromChildren.init);
    }

    public final String configure() {
        return Cardinal(this, setAddStatesFromChildren.init);
    }

    public final String Cardinal(setLayoutAnimation setlayoutanimation) {
        return Cardinal(this, setlayoutanimation);
    }

    public String toString() {
        return Cardinal(this, setAddStatesFromChildren.init);
    }

    public final void init(Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
        setVerticalScrollbarOverlay.getInstance.init(this, appendable, setlayoutanimation);
    }
}
