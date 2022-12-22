package net.sourceforge.pinyin4j;

import com.p222hp.hpl.sparta.Document;
import com.p222hp.hpl.sparta.ParseException;
import com.p222hp.hpl.sparta.Parser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class GwoyeuRomatzyhResource {

    /* renamed from: a */
    private Document f5055a;

    /* renamed from: a */
    private void m3275a(Document document) {
        this.f5055a = document;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Document mo24520a() {
        return this.f5055a;
    }

    private GwoyeuRomatzyhResource() {
        m3277c();
    }

    /* renamed from: c */
    private void m3277c() {
        try {
            m3275a(Parser.parse("", (InputStream) C2406e.m3294a("/pinyindb/pinyin_gwoyeu_mapping.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ParseException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: b */
    static GwoyeuRomatzyhResource m3276b() {
        return GwoyeuRomatzyhSystemResourceHolder.theInstance;
    }

    private static class GwoyeuRomatzyhSystemResourceHolder {
        static final GwoyeuRomatzyhResource theInstance = new GwoyeuRomatzyhResource();

        private GwoyeuRomatzyhSystemResourceHolder() {
        }
    }
}
