package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.setWebViewRenderProcessClient */
public abstract class setWebViewRenderProcessClient<T> {
    private static String getInstance = "Invalid or non Implemented status";
    public final setWebContentsDebuggingEnabled CardinalUiType;

    public T init(Object obj) {
        return obj;
    }

    public setWebViewRenderProcessClient(setWebContentsDebuggingEnabled setwebcontentsdebuggingenabled) {
        this.CardinalUiType = setwebcontentsdebuggingenabled;
    }

    public setWebViewRenderProcessClient<?> cca_continue(String str) throws setCertificate, IOException {
        StringBuilder sb = new StringBuilder(String.valueOf(getInstance));
        sb.append(" startObject(String key) in ");
        sb.append(getClass());
        sb.append(" key=");
        sb.append(str);
        throw new RuntimeException(sb.toString());
    }

    public setWebViewRenderProcessClient<?> init(String str) throws setCertificate, IOException {
        StringBuilder sb = new StringBuilder(String.valueOf(getInstance));
        sb.append(" startArray in ");
        sb.append(getClass());
        sb.append(" key=");
        sb.append(str);
        throw new RuntimeException(sb.toString());
    }

    public void cca_continue(Object obj, String str, Object obj2) throws setCertificate, IOException {
        StringBuilder sb = new StringBuilder(String.valueOf(getInstance));
        sb.append(" setValue in ");
        sb.append(getClass());
        sb.append(" key=");
        sb.append(str);
        throw new RuntimeException(sb.toString());
    }

    public void Cardinal(Object obj, Object obj2) throws setCertificate, IOException {
        StringBuilder sb = new StringBuilder(String.valueOf(getInstance));
        sb.append(" addValue(Object current, Object value) in ");
        sb.append(getClass());
        throw new RuntimeException(sb.toString());
    }

    public Object cca_continue() {
        StringBuilder sb = new StringBuilder(String.valueOf(getInstance));
        sb.append(" createObject() in ");
        sb.append(getClass());
        throw new RuntimeException(sb.toString());
    }

    public Object configure() {
        StringBuilder sb = new StringBuilder(String.valueOf(getInstance));
        sb.append(" createArray() in ");
        sb.append(getClass());
        throw new RuntimeException(sb.toString());
    }
}
