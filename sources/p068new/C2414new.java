package p068new;

import com.iproov.sdk.IProov;
import com.iproov.sdk.core.exception.IProovException;

/* renamed from: new.new */
/* compiled from: ErrorListenerEvent */
public class C2414new extends C2408case {

    /* renamed from: a */
    private final IProovException f5072a;

    public C2414new(IProovException iProovException) {
        this.f5072a = iProovException;
    }

    /* renamed from: do */
    public void mo24584do(IProov.Listener listener) {
        listener.onError(this.f5072a);
    }

    /* renamed from: do */
    public boolean mo24585do() {
        return true;
    }
}
