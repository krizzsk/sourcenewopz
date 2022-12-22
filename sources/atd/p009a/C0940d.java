package atd.p009a;

import android.os.Handler;
import android.os.Looper;
import atd.p015d.C0989j;
import atd.p046s0.C1172a;
import java.util.concurrent.Callable;

/* renamed from: atd.a.d */
public final class C0940d<T extends C0989j> implements Runnable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0939c<T> f157a;

    /* renamed from: b */
    private final Callable<T> f158b;

    /* renamed from: atd.a.d$a */
    class C0941a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0989j f159a;

        C0941a(C0989j jVar) {
            this.f159a = jVar;
        }

        public void run() {
            C0940d.this.f157a.mo13555a(this.f159a);
        }
    }

    /* renamed from: atd.a.d$b */
    class C0942b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Exception f161a;

        /* renamed from: b */
        final /* synthetic */ String f162b;

        C0942b(Exception exc, String str) {
            this.f161a = exc;
            this.f162b = str;
        }

        public void run() {
            C0940d.this.f157a.mo13556a(this.f161a, this.f162b);
        }
    }

    public C0940d(C0939c<T> cVar, Callable<T> callable) {
        this.f157a = cVar;
        this.f158b = callable;
    }

    public void run() {
        try {
            m115a((C0989j) this.f158b.call());
        } catch (Exception e) {
            m116a(e, C1172a.m764a(-2444289723054L));
        }
    }

    /* renamed from: a */
    private void m115a(T t) {
        m117a((Runnable) new C0941a(t));
    }

    /* renamed from: a */
    private void m116a(Exception exc, String str) {
        m117a((Runnable) new C0942b(exc, str));
    }

    /* renamed from: a */
    private void m117a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
