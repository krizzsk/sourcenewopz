package net.sourceforge.pinyin4j;

import com.p222hp.hpl.sparta.Element;
import com.p222hp.hpl.sparta.ParseException;

/* renamed from: net.sourceforge.pinyin4j.c */
/* compiled from: PinyinRomanizationTranslator */
class C2404c {
    C2404c() {
    }

    /* renamed from: a */
    static String m3291a(String str, C2405d dVar, C2405d dVar2) {
        String b = C2407f.m3296b(str);
        String a = C2407f.m3295a(str);
        try {
            Element xpathSelectElement = PinyinRomanizationResource.m3285b().mo24521a().xpathSelectElement("//" + dVar.mo24522a() + "[text()='" + b + "']");
            if (xpathSelectElement == null) {
                return null;
            }
            String xpathSelectString = xpathSelectElement.xpathSelectString("../" + dVar2.mo24522a() + "/text()");
            return xpathSelectString + a;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
