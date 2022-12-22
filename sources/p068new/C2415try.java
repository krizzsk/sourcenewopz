package p068new;

import com.iproov.sdk.IProov;

/* renamed from: new.try */
/* compiled from: FailureListenerEvent */
public class C2415try extends C2408case {

    /* renamed from: a */
    private final IProov.FailureResult f5073a;

    public C2415try(IProov.FailureResult failureResult) {
        this.f5073a = failureResult;
    }

    /* renamed from: do */
    public void mo24584do(IProov.Listener listener) {
        listener.onFailure(this.f5073a);
    }

    /* renamed from: do */
    public boolean mo24585do() {
        return true;
    }
}
