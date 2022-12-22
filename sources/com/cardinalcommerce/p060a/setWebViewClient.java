package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setWebViewClient */
public final class setWebViewClient<T> extends setWebViewRenderProcessClient<T> {
    protected setWebViewClient(setWebContentsDebuggingEnabled setwebcontentsdebuggingenabled) {
        super(setwebcontentsdebuggingenabled);
    }

    public final setWebViewRenderProcessClient<setTransitionGroup> cca_continue(String str) {
        return this.CardinalUiType.cca_continue;
    }

    public final setWebViewRenderProcessClient<setTransitionGroup> init(String str) {
        return this.CardinalUiType.cca_continue;
    }

    public final Object cca_continue() {
        return new setLayoutTransition();
    }

    public final Object configure() {
        return new setDescendantFocusability();
    }

    public final void cca_continue(Object obj, String str, Object obj2) {
        ((setLayoutTransition) obj).put(str, obj2);
    }

    public final void Cardinal(Object obj, Object obj2) {
        ((setDescendantFocusability) obj).add(obj2);
    }
}
