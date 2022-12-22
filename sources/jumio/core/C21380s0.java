package jumio.core;

import java.io.IOException;

/* renamed from: jumio.core.s0 */
/* compiled from: UnexpectedResponseException */
public class C21380s0 extends IOException {

    /* renamed from: a */
    public int f59671a = 0;

    /* renamed from: b */
    public String f59672b = "";

    public C21380s0(int i, String str) {
        this.f59671a = i;
        this.f59672b = str;
    }

    /* renamed from: a */
    public int mo175871a() {
        return this.f59671a;
    }

    public String getMessage() {
        return this.f59672b;
    }

    /* renamed from: a */
    public void mo175872a(int i) {
        this.f59671a = i;
    }
}
