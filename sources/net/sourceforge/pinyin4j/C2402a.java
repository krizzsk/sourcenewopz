package net.sourceforge.pinyin4j;

import com.p222hp.hpl.sparta.Element;
import com.p222hp.hpl.sparta.ParseException;

/* renamed from: net.sourceforge.pinyin4j.a */
/* compiled from: GwoyeuRomatzyhTranslator */
class C2402a {

    /* renamed from: a */
    private static String[] f5057a = {"_I", "_II", "_III", "_IV", "_V"};

    C2402a() {
    }

    /* renamed from: a */
    static String m3288a(String str) {
        String b = C2407f.m3296b(str);
        String a = C2407f.m3295a(str);
        try {
            Element xpathSelectElement = GwoyeuRomatzyhResource.m3276b().mo24520a().xpathSelectElement("//" + C2405d.f5058a.mo24522a() + "[text()='" + b + "']");
            if (xpathSelectElement == null) {
                return null;
            }
            return xpathSelectElement.xpathSelectString("../" + C2405d.f5063f.mo24522a() + f5057a[Integer.parseInt(a) - 1] + "/text()");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
