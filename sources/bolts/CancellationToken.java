package bolts;

import java.util.Locale;
import java.util.concurrent.CancellationException;

public class CancellationToken {

    /* renamed from: a */
    private final CancellationTokenSource f402a;

    CancellationToken(CancellationTokenSource cancellationTokenSource) {
        this.f402a = cancellationTokenSource;
    }

    public boolean isCancellationRequested() {
        return this.f402a.isCancellationRequested();
    }

    public CancellationTokenRegistration register(Runnable runnable) {
        return this.f402a.mo14011a(runnable);
    }

    public void throwIfCancellationRequested() throws CancellationException {
        this.f402a.mo14012a();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.f402a.isCancellationRequested())});
    }
}
