package p235for;

import p239if.C21002new;

/* renamed from: for.do */
/* compiled from: FlashComponent */
public final class C20836do {

    /* renamed from: a */
    private char f57245a;

    public C20836do(char c) {
        this.f57245a = c;
    }

    /* renamed from: a */
    private String m41046a() {
        char c = this.f57245a;
        if (c == '0') {
            return "⬛️";
        }
        if (c == '1') {
            return "⬜️";
        }
        if (c == 'b') {
            return "🟦";
        }
        if (c == 'c') {
            return "🎽";
        }
        if (c == 'g') {
            return "🟩";
        }
        if (c == 'm') {
            return "🟪";
        }
        if (c == 'r') {
            return "🟥";
        }
        if (c != 'y') {
            return null;
        }
        return "🟨";
    }

    /* renamed from: do */
    public int mo170682do() {
        return C21002new.m41067do(this.f57245a);
    }

    public String toString() {
        return m41046a() + this.f57245a;
    }
}
