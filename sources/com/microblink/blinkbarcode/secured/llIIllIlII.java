package com.microblink.blinkbarcode.secured;

import android.media.Image;
import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import com.microblink.blinkbarcode.secured.IIllIIllll;
import com.microblink.blinkbarcode.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: line */
class llIIllIlII {
    private ImageReader.OnImageAvailableListener IIlIIIllIl = new llIIlIlIIl();
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.util.IllIIIllII IlIllIlIIl;
    /* access modifiers changed from: private */
    public AtomicInteger IllIIIIllI = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public lIlIllIIlI IllIIIllII;
    /* access modifiers changed from: private */
    public IIllIIllll.llIIlIlIIl lIIIIIllll = new IlIllIlIIl();
    /* access modifiers changed from: private */
    public AtomicBoolean lIlIIIIlIl = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public IllIIIllII llIIIlllll;
    private long llIIlIIlll = 0;
    private ImageReader llIIlIlIIl;

    /* compiled from: line */
    public class IlIllIlIIl implements IIllIIllll.llIIlIlIIl {
        public IlIllIlIIl() {
        }

        public void llIIlIlIIl(Image image) {
            image.close();
            int decrementAndGet = llIIllIlII.this.IllIIIIllI.decrementAndGet();
            Log.m40233v(this, "[close] Active images: {}", Integer.valueOf(decrementAndGet));
            if (decrementAndGet != 0 || !llIIllIlII.this.lIlIIIIlIl.get()) {
                llIIllIlII.this.llIIIlllll.IllIIIllII();
                return;
            }
            Log.m40231i(this, "Closing image reader", new Object[0]);
            llIIllIlII.this.llIIlIlIIl();
        }
    }

    /* compiled from: line */
    public interface IllIIIllII {
        boolean IlIllIlIIl();

        void IllIIIllII();

        boolean canReceiveFrame();

        void llIIlIlIIl(llIIlllIll lliilllill);

        boolean llIIlIlIIl();
    }

    /* compiled from: line */
    public class llIIlIlIIl implements ImageReader.OnImageAvailableListener {

        /* renamed from: com.microblink.blinkbarcode.secured.llIIllIlII$llIIlIlIIl$llIIlIlIIl  reason: collision with other inner class name */
        /* compiled from: line */
        public class C22035llIIlIlIIl implements Runnable {
            public final /* synthetic */ IIllIIllll llIIlIlIIl;

            public C22035llIIlIlIIl(IIllIIllll iIllIIllll) {
                this.llIIlIlIIl = iIllIIllll;
            }

            public void run() {
                if (llIIllIlII.this.llIIIlllll.canReceiveFrame()) {
                    llIIllIlII.this.llIIIlllll.llIIlIlIIl(this.llIIlIlIIl);
                } else {
                    this.llIIlIlIIl.IllIIIllII();
                }
            }
        }

        public llIIlIlIIl() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onImageAvailable(android.media.ImageReader r5) {
            /*
                r4 = this;
                r0 = 0
                android.media.Image r5 = r5.acquireNextImage()     // Catch:{ Exception -> 0x007f }
                if (r5 != 0) goto L_0x0008
                return
            L_0x0008:
                com.microblink.blinkbarcode.secured.llIIllIlII r1 = com.microblink.blinkbarcode.secured.llIIllIlII.this     // Catch:{ Exception -> 0x007d }
                java.util.concurrent.atomic.AtomicInteger r1 = r1.IllIIIIllI     // Catch:{ Exception -> 0x007d }
                int r1 = r1.incrementAndGet()     // Catch:{ Exception -> 0x007d }
                java.lang.String r2 = "[acquire] Active images: {}"
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x007d }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x007d }
                r3[r0] = r1     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.util.Log.m40233v(r4, r2, r3)     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII r1 = com.microblink.blinkbarcode.secured.llIIllIlII.this     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII$IllIIIllII r1 = r1.llIIIlllll     // Catch:{ Exception -> 0x007d }
                boolean r1 = r1.canReceiveFrame()     // Catch:{ Exception -> 0x007d }
                if (r1 != 0) goto L_0x0038
                com.microblink.blinkbarcode.secured.llIIllIlII r1 = com.microblink.blinkbarcode.secured.llIIllIlII.this     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.IIllIIllll$llIIlIlIIl r1 = r1.lIIIIIllll     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII$IlIllIlIIl r1 = (com.microblink.blinkbarcode.secured.llIIllIlII.IlIllIlIIl) r1     // Catch:{ Exception -> 0x007d }
                r1.llIIlIlIIl(r5)     // Catch:{ Exception -> 0x007d }
                return
            L_0x0038:
                com.microblink.blinkbarcode.secured.llIIllIlII r1 = com.microblink.blinkbarcode.secured.llIIllIlII.this     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.lIlIllIIlI r1 = r1.IllIIIllII     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.IIllIIllll r1 = r1.llIIlIlIIl()     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII r2 = com.microblink.blinkbarcode.secured.llIIllIlII.this     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.IIllIIllll$llIIlIlIIl r2 = r2.lIIIIIllll     // Catch:{ Exception -> 0x007d }
                r1.llIIlIlIIl(r5, r2)     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII r2 = com.microblink.blinkbarcode.secured.llIIllIlII.this     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII$IllIIIllII r2 = r2.llIIIlllll     // Catch:{ Exception -> 0x007d }
                boolean r2 = r2.llIIlIlIIl()     // Catch:{ Exception -> 0x007d }
                r1.IlIllIlIIl((boolean) r2)     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII r2 = com.microblink.blinkbarcode.secured.llIIllIlII.this     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII$IllIIIllII r2 = r2.llIIIlllll     // Catch:{ Exception -> 0x007d }
                boolean r2 = r2.IlIllIlIIl()     // Catch:{ Exception -> 0x007d }
                r1.llIIlIlIIl((boolean) r2)     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII r2 = com.microblink.blinkbarcode.secured.llIIllIlII.this     // Catch:{ Exception -> 0x007d }
                long r2 = com.microblink.blinkbarcode.secured.llIIllIlII.IllIIIIllI(r2)     // Catch:{ Exception -> 0x007d }
                r1.llIIIlllll(r2)     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII r2 = com.microblink.blinkbarcode.secured.llIIllIlII.this     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.util.IllIIIllII r2 = r2.IlIllIlIIl     // Catch:{ Exception -> 0x007d }
                com.microblink.blinkbarcode.secured.llIIllIlII$llIIlIlIIl$llIIlIlIIl r3 = new com.microblink.blinkbarcode.secured.llIIllIlII$llIIlIlIIl$llIIlIlIIl     // Catch:{ Exception -> 0x007d }
                r3.<init>(r1)     // Catch:{ Exception -> 0x007d }
                r2.llIIlIlIIl(r3)     // Catch:{ Exception -> 0x007d }
                goto L_0x0095
            L_0x007d:
                r1 = move-exception
                goto L_0x0081
            L_0x007f:
                r1 = move-exception
                r5 = 0
            L_0x0081:
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.String r2 = "Failed to acquire latest image!"
                com.microblink.blinkbarcode.util.Log.m40230e(r4, r1, r2, r0)
                if (r5 == 0) goto L_0x0095
                com.microblink.blinkbarcode.secured.llIIllIlII r0 = com.microblink.blinkbarcode.secured.llIIllIlII.this
                com.microblink.blinkbarcode.secured.IIllIIllll$llIIlIlIIl r0 = r0.lIIIIIllll
                com.microblink.blinkbarcode.secured.llIIllIlII$IlIllIlIIl r0 = (com.microblink.blinkbarcode.secured.llIIllIlII.IlIllIlIIl) r0
                r0.llIIlIlIIl(r5)
            L_0x0095:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.secured.llIIllIlII.llIIlIlIIl.onImageAvailable(android.media.ImageReader):void");
        }
    }

    public llIIllIlII(com.microblink.blinkbarcode.util.IllIIIllII illIIIllII, IllIIIllII illIIIllII2) {
        this.llIIIlllll = illIIIllII2;
        this.IlIllIlIIl = illIIIllII;
    }

    public static /* synthetic */ long IllIIIIllI(llIIllIlII lliillilii) {
        long j = lliillilii.llIIlIIlll;
        lliillilii.llIIlIIlll = 1 + j;
        return j;
    }

    public void IlIllIlIIl(lIlIIIlIll liliiilill, int i, llIllllIIl llilllliil) {
        llIIlIlIIl(liliiilill.IllIIIllII(), 35, i, llilllliil);
    }

    public void IllIIIllII() {
        this.lIlIIIIlIl.set(true);
        if (this.IllIIIIllI.get() == 0) {
            llIIlIlIIl();
        }
    }

    public void llIIIlllll() {
        this.lIlIIIIlIl = new AtomicBoolean(false);
    }

    public void llIIlIlIIl(lIlIIIlIll liliiilill, int i, llIllllIIl llilllliil) {
        llIIlIlIIl(liliiilill.IlIllIlIIl(), liliiilill.llIIlIlIIl(), i, llilllliil);
    }

    public Surface IlIllIlIIl() {
        ImageReader imageReader = this.llIIlIlIIl;
        if (imageReader == null) {
            return null;
        }
        return imageReader.getSurface();
    }

    private void llIIlIlIIl(Size size, int i, int i2, llIllllIIl llilllliil) {
        ImageReader newInstance = ImageReader.newInstance(size.getWidth(), size.getHeight(), i, i2);
        this.llIIlIlIIl = newInstance;
        newInstance.setOnImageAvailableListener(this.IIlIIIllIl, this.IlIllIlIIl.llIIlIlIIl());
        this.IllIIIllII = new lIlIllIIlI(i2, llilllliil);
    }

    public void llIIlIlIIl() {
        ImageReader imageReader = this.llIIlIlIIl;
        if (imageReader != null) {
            imageReader.close();
            this.llIIlIlIIl = null;
        }
    }
}
