package p068new;

import com.iproov.sdk.IProov;

/* renamed from: new.goto */
/* compiled from: SuccessListenerEvent */
public class C2412goto extends C2408case {

    /* renamed from: a */
    private final IProov.SuccessResult f5071a;

    public C2412goto(IProov.SuccessResult successResult) {
        this.f5071a = successResult;
    }

    /* renamed from: do */
    public void mo24584do(IProov.Listener listener) {
        listener.onSuccess(this.f5071a);
    }

    /* renamed from: do */
    public boolean mo24585do() {
        return true;
    }
}
