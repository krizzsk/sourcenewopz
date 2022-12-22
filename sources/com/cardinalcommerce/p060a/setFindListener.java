package com.cardinalcommerce.p060a;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.cardinalcommerce.a.setFindListener */
public final class setFindListener extends setWebViewRenderProcessClient<setTransitionGroup> {
    protected setFindListener(setWebContentsDebuggingEnabled setwebcontentsdebuggingenabled) {
        super(setwebcontentsdebuggingenabled);
    }

    public final setWebViewRenderProcessClient<setTransitionGroup> cca_continue(String str) {
        return this.CardinalUiType.getInstance;
    }

    public final setWebViewRenderProcessClient<setTransitionGroup> init(String str) {
        return this.CardinalUiType.getInstance;
    }

    public final void cca_continue(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    public final Object cca_continue() {
        return new LinkedHashMap();
    }

    public final void Cardinal(Object obj, Object obj2) {
        ((setDescendantFocusability) obj).add(obj2);
    }

    public final Object configure() {
        return new setDescendantFocusability();
    }
}
