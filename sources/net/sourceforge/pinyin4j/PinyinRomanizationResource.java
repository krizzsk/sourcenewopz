package net.sourceforge.pinyin4j;

import com.p222hp.hpl.sparta.Document;
import com.p222hp.hpl.sparta.ParseException;
import com.p222hp.hpl.sparta.Parser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class PinyinRomanizationResource {

    /* renamed from: a */
    private Document f5056a;

    /* renamed from: a */
    private void m3284a(Document document) {
        this.f5056a = document;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Document mo24521a() {
        return this.f5056a;
    }

    private PinyinRomanizationResource() {
        m3286c();
    }

    /* renamed from: c */
    private void m3286c() {
        try {
            m3284a(Parser.parse("", (InputStream) C2406e.m3294a("/pinyindb/pinyin_mapping.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ParseException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: b */
    static PinyinRomanizationResource m3285b() {
        return PinyinRomanizationSystemResourceHolder.theInstance;
    }

    private static class PinyinRomanizationSystemResourceHolder {
        static final PinyinRomanizationResource theInstance = new PinyinRomanizationResource();

        private PinyinRomanizationSystemResourceHolder() {
        }
    }
}
