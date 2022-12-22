package net.sourceforge.pinyin4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class ChineseToPinyinResource {

    /* renamed from: a */
    private Properties f5054a;

    /* renamed from: a */
    private void m3269a(Properties properties) {
        this.f5054a = properties;
    }

    /* renamed from: b */
    private Properties m3272b() {
        return this.f5054a;
    }

    private ChineseToPinyinResource() {
        this.f5054a = null;
        m3273c();
    }

    /* renamed from: c */
    private void m3273c() {
        try {
            m3269a(new Properties());
            m3272b().load(C2406e.m3294a("/pinyindb/unicode_to_hanyu_pinyin.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String[] mo24519a(char c) {
        String b = m3271b(c);
        if (b == null) {
            return null;
        }
        return b.substring(b.indexOf("(") + 1, b.lastIndexOf(")")).split(",");
    }

    /* renamed from: a */
    private boolean m3270a(String str) {
        return str != null && !str.equals("(none0)") && str.startsWith("(") && str.endsWith(")");
    }

    /* renamed from: b */
    private String m3271b(char c) {
        String property = m3272b().getProperty(Integer.toHexString(c).toUpperCase());
        if (m3270a(property)) {
            return property;
        }
        return null;
    }

    /* renamed from: a */
    static ChineseToPinyinResource m3268a() {
        return ChineseToPinyinResourceHolder.theInstance;
    }

    private static class ChineseToPinyinResourceHolder {
        static final ChineseToPinyinResource theInstance = new ChineseToPinyinResource();

        private ChineseToPinyinResourceHolder() {
        }
    }

    class Field {
        static final String COMMA = ",";
        static final String LEFT_BRACKET = "(";
        static final String RIGHT_BRACKET = ")";

        Field() {
        }
    }
}
