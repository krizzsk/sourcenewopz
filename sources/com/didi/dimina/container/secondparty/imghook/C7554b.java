package com.didi.dimina.container.secondparty.imghook;

import java.util.Locale;

/* renamed from: com.didi.dimina.container.secondparty.imghook.b */
/* compiled from: ImageCheck */
class C7554b {
    C7554b() {
    }

    /* renamed from: a */
    static boolean m12760a(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        return !lowerCase.contains("text/") && !lowerCase.contains("application/") && !lowerCase.contains("audio/") && !lowerCase.contains("video/") && lowerCase.contains("image/");
    }
}
