package atd.p011b;

import atd.p009a.C0939c;
import atd.p009a.C0940d;
import atd.p015d.C0988i;
import atd.p015d.C0989j;
import atd.p020f0.C1023a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: atd.b.b */
public final class C0959b {

    /* renamed from: a */
    private final ExecutorService f197a = Executors.newFixedThreadPool(3);

    /* renamed from: b */
    private final C0957a f198b;

    /* renamed from: c */
    private final C0939c<C0989j> f199c;

    public C0959b(String str, C1023a aVar, C0939c<C0989j> cVar) {
        this.f198b = new C0957a(str, aVar);
        this.f199c = cVar;
    }

    /* renamed from: a */
    public void mo13602a(C0988i iVar) {
        this.f197a.submit(new C0940d(this.f199c, this.f198b.mo13599c(iVar)));
    }
}
