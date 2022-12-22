package p068new;

import com.iproov.sdk.IProov;

/* renamed from: new.else */
/* compiled from: ProcessingListenerEvent */
public class C2410else extends C2408case {

    /* renamed from: a */
    private final double f5069a;

    /* renamed from: b */
    private final String f5070b;

    public C2410else(double d, String str) {
        this.f5069a = d;
        this.f5070b = str;
    }

    /* renamed from: do */
    public void mo24584do(IProov.Listener listener) {
        listener.onProcessing(this.f5069a, this.f5070b);
    }
}
