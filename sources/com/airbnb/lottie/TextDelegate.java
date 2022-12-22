package com.airbnb.lottie;

import java.util.HashMap;
import java.util.Map;

public class TextDelegate {

    /* renamed from: a */
    private final Map<String, String> f1177a;

    /* renamed from: b */
    private final LottieAnimationView f1178b;

    /* renamed from: c */
    private final LottieDrawable f1179c;

    /* renamed from: d */
    private boolean f1180d;

    /* renamed from: a */
    private String m1257a(String str) {
        return str;
    }

    TextDelegate() {
        this.f1177a = new HashMap();
        this.f1180d = true;
        this.f1178b = null;
        this.f1179c = null;
    }

    public TextDelegate(LottieAnimationView lottieAnimationView) {
        this.f1177a = new HashMap();
        this.f1180d = true;
        this.f1178b = lottieAnimationView;
        this.f1179c = null;
    }

    public TextDelegate(LottieDrawable lottieDrawable) {
        this.f1177a = new HashMap();
        this.f1180d = true;
        this.f1179c = lottieDrawable;
        this.f1178b = null;
    }

    public void setText(String str, String str2) {
        this.f1177a.put(str, str2);
        m1258a();
    }

    public void setCacheText(boolean z) {
        this.f1180d = z;
    }

    public void invalidateText(String str) {
        this.f1177a.remove(str);
        m1258a();
    }

    public void invalidateAllText() {
        this.f1177a.clear();
        m1258a();
    }

    public final String getTextInternal(String str) {
        if (this.f1180d && this.f1177a.containsKey(str)) {
            return this.f1177a.get(str);
        }
        String a = m1257a(str);
        if (this.f1180d) {
            this.f1177a.put(str, a);
        }
        return a;
    }

    /* renamed from: a */
    private void m1258a() {
        LottieAnimationView lottieAnimationView = this.f1178b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        LottieDrawable lottieDrawable = this.f1179c;
        if (lottieDrawable != null) {
            lottieDrawable.invalidateSelf();
        }
    }
}
