package rui.config.parser;

import rui.config.RConfigConstants;

/* renamed from: rui.config.parser.a */
/* compiled from: RParserHelper */
final class C3016a {
    private C3016a() {
    }

    /* renamed from: a */
    static boolean m3847a(String str) {
        return str.contains(RConfigConstants.KEYWORD_GRADIENT);
    }

    /* renamed from: b */
    static boolean m3848b(String str) {
        return !m3847a(str) && str.contains(RConfigConstants.KEYWORD_COLOR_SIGN);
    }

    /* renamed from: c */
    static boolean m3849c(String str) {
        return !m3847a(str) && !m3848b(str);
    }
}
