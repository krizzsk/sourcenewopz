package jumio.core;

/* renamed from: jumio.core.u0 */
/* compiled from: Version */
public class C21385u0 implements Comparable<C21385u0> {

    /* renamed from: a */
    public final String f59676a;

    public C21385u0(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Version can not be null");
        } else if (str.matches("[0-9]+(\\.[0-9]+)*")) {
            this.f59676a = str;
        } else {
            throw new IllegalArgumentException("Invalid version format");
        }
    }

    /* renamed from: a */
    public final String mo175881a() {
        return this.f59676a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C21385u0.class == obj.getClass() && compareTo((C21385u0) obj) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public int compareTo(C21385u0 u0Var) {
        if (u0Var == null) {
            return 1;
        }
        String[] split = mo175881a().split("\\.");
        String[] split2 = u0Var.mo175881a().split("\\.");
        int max = Math.max(split.length, split2.length);
        int i = 0;
        while (i < max) {
            int parseInt = i < split.length ? Integer.parseInt(split[i]) : 0;
            int parseInt2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if (parseInt < parseInt2) {
                return -1;
            }
            if (parseInt > parseInt2) {
                return 1;
            }
            i++;
        }
        return 0;
    }
}
