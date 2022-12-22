package atd.p017e;

import atd.p010a0.C0956a;
import atd.p046s0.C1172a;
import java.util.Locale;

/* renamed from: atd.e.b */
public enum C1013b {
    SINGLE_TEXT_INPUT(1),
    SINGLE_SELECT(2),
    MULTI_SELECT(3),
    OUT_OF_BAND(4),
    HTML_UI(5);
    
    public static final String MESSAGE_FORMAT_INVALID_ID = null;
    private int mId;

    private C1013b(int i) {
        this.mId = i;
    }

    /* renamed from: a */
    public static C1013b m324a(String str) throws C0956a {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return m323a(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            throw new C0956a(String.format(Locale.ENGLISH, C1172a.m764a(-14032111487662L), new Object[]{str}), e, C1014c.DATA_ELEMENT_INVALID_FORMAT);
        }
    }

    /* renamed from: a */
    public static C1013b m323a(int i) throws C0956a {
        for (C1013b bVar : values()) {
            if (bVar.mId == i) {
                return bVar;
            }
        }
        throw new C0956a(String.format(Locale.ENGLISH, C1172a.m764a(-14096535997102L), new Object[]{Integer.valueOf(i)}), C1014c.DATA_ELEMENT_INVALID_FORMAT);
    }

    /* renamed from: a */
    public int mo13736a() {
        return this.mId;
    }
}
