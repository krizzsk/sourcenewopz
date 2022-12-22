package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.setVerticalScrollbarOverlay;
import java.io.IOException;
import java.util.Iterator;

/* renamed from: com.cardinalcommerce.a.setAddStatesFromChildren */
public final class setAddStatesFromChildren {

    /* renamed from: a */
    private static setVerticalScrollbarOverlay f2664a = new setVerticalScrollbarOverlay();
    public static final setWebContentsDebuggingEnabled configure = new setWebContentsDebuggingEnabled();
    public static setLayoutAnimation init = setLayoutAnimation.init;

    public static void init(Object obj, Appendable appendable, setLayoutAnimation setlayoutanimation) throws IOException {
        if (obj == null) {
            appendable.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        setNetworkAvailable setnetworkavailable = f2664a.cca_continue.get(cls);
        if (setnetworkavailable == null) {
            if (cls.isArray()) {
                setnetworkavailable = setVerticalScrollbarOverlay.cleanup;
            } else {
                setVerticalScrollbarOverlay setverticalscrollbaroverlay = f2664a;
                Class<?> cls2 = obj.getClass();
                Iterator<setVerticalScrollbarOverlay.C2126init> it = setverticalscrollbaroverlay.configure.iterator();
                while (true) {
                    if (it.hasNext()) {
                        setVerticalScrollbarOverlay.C2126init next = it.next();
                        if (next.init.isAssignableFrom(cls2)) {
                            setnetworkavailable = next.cca_continue;
                            break;
                        }
                    } else {
                        setnetworkavailable = null;
                        break;
                    }
                }
                if (setnetworkavailable == null) {
                    setnetworkavailable = setVerticalScrollbarOverlay.init;
                }
            }
            f2664a.configure(setnetworkavailable, cls);
        }
        setnetworkavailable.init(obj, appendable, setlayoutanimation);
    }

    public static String configure(String str) {
        setLayoutAnimation setlayoutanimation = init;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        setlayoutanimation.f2840a.cca_continue(str, sb);
        return sb.toString();
    }

    public static void configure(String str, Appendable appendable, setLayoutAnimation setlayoutanimation) {
        if (str != null) {
            setlayoutanimation.f2840a.cca_continue(str, appendable);
        }
    }
}
