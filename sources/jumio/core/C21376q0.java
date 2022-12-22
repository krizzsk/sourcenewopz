package jumio.core;

import com.jumio.ale.swig.ALECore;
import com.jumio.ale.swig.ALERequest;
import com.jumio.ale.swig.ALESettings;

/* renamed from: jumio.core.q0 */
/* compiled from: SynchronizedAleCore */
public class C21376q0 extends ALECore {

    /* renamed from: b */
    public final Object f59669b = new Object();

    /* renamed from: c */
    public boolean f59670c = true;

    public C21376q0(ALESettings aLESettings) {
        super(aLESettings);
    }

    public ALERequest createRequest() throws Exception {
        ALERequest createRequest;
        synchronized (this.f59669b) {
            if (this.f59670c) {
                createRequest = super.createRequest();
            } else {
                throw new Exception("AleCore instance not valid");
            }
        }
        return createRequest;
    }

    public synchronized void delete() {
        synchronized (this.f59669b) {
            this.f59670c = false;
            super.delete();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(1:5)(2:6|7)|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void destroyRequest(com.jumio.ale.swig.ALERequest r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f59669b
            monitor-enter(r0)
            boolean r1 = r2.f59670c     // Catch:{ all -> 0x0010 }
            if (r1 == 0) goto L_0x000b
            super.destroyRequest(r3)     // Catch:{ all -> 0x0010 }
            goto L_0x000e
        L_0x000b:
            r3.delete()     // Catch:{ Exception -> 0x000e }
        L_0x000e:
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            return
        L_0x0010:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21376q0.destroyRequest(com.jumio.ale.swig.ALERequest):void");
    }
}
