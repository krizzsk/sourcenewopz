package com.microblink.blinkbarcode.secured;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.microblink.blinkbarcode.hardware.camera.lIlIIIIlIl;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
class IlIIIlIIIl implements lIlIIIIlIl {
    private TextureView.SurfaceTextureListener IIlIIIllIl = new IllIIIllII();
    /* access modifiers changed from: private */
    public llIIIlllll IlIllIlIIl;
    /* access modifiers changed from: private */
    public SurfaceTexture IllIIIIllI = null;
    /* access modifiers changed from: private */
    public SurfaceHolder IllIIIllII = null;
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.hardware.camera.llIIIlllll lIlIIIIlIl;
    /* access modifiers changed from: private */
    public boolean llIIIlllll = false;
    private SurfaceHolder.Callback llIIlIIlll = new IlIllIlIIl();
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.util.IllIIIllII llIIlIlIIl;

    /* compiled from: line */
    public class IlIllIlIIl implements SurfaceHolder.Callback {

        /* compiled from: line */
        public class llIIlIlIIl implements Runnable {
            public llIIlIlIIl() {
            }

            public void run() {
                IIlIlIIlll.this.lIIIIIlIlI();
            }
        }

        public IlIllIlIIl() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Log.m40227d(this, "Surface changed to size: {}x{}, format: {}", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
            if ((IlIIIlIIIl.this.lIlIIIIlIl != null && IlIIIlIIIl.this.lIlIIIIlIl.llIIlIlIIl(i2, i3)) && IlIIIlIIIl.this.IllIIIllII != null) {
                Log.m40227d(this, "Setting surface holder fixed size to {}", IlIIIlIIIl.this.lIlIIIIlIl);
                IlIIIlIIIl.this.IllIIIllII.setFixedSize(IlIIIlIIIl.this.lIlIIIIlIl.IlIllIlIIl(), IlIIIlIIIl.this.lIlIIIIlIl.llIIlIlIIl());
                boolean unused = IlIIIlIIIl.this.llIIIlllll = true;
                IlIIIlIIIl.this.llIIlIlIIl.llIIlIlIIl(new llIIlIlIIl());
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.m40231i(this, "Surface has been created!", new Object[0]);
            SurfaceHolder unused = IlIIIlIIIl.this.IllIIIllII = surfaceHolder;
            if (IlIIIlIIIl.this.lIlIIIIlIl != null) {
                IlIIIlIIIl.this.IllIIIllII.setFixedSize(IlIIIlIIIl.this.lIlIIIIlIl.IlIllIlIIl(), IlIIIlIIIl.this.lIlIIIIlIl.llIIlIlIIl());
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Log.m40231i(this, "Surface is being destroyed", new Object[0]);
            if (IlIIIlIIIl.this.IllIIIllII != null) {
                Log.m40231i(this, "Removing callback from surface holder", new Object[0]);
                IlIIIlIIIl.this.IllIIIllII.removeCallback(this);
                SurfaceHolder unused = IlIIIlIIIl.this.IllIIIllII = null;
            }
        }
    }

    /* compiled from: line */
    public class IllIIIllII implements TextureView.SurfaceTextureListener {

        /* compiled from: line */
        public class IlIllIlIIl implements Runnable {
            public final /* synthetic */ SurfaceTexture llIIlIlIIl;

            public IlIllIlIIl(SurfaceTexture surfaceTexture) {
                this.llIIlIlIIl = surfaceTexture;
            }

            public void run() {
                SurfaceTexture unused = IlIIIlIIIl.this.IllIIIIllI = this.llIIlIlIIl;
                IIlIlIIlll.this.lIIIIIlIlI();
            }
        }

        /* renamed from: com.microblink.blinkbarcode.secured.IlIIIlIIIl$IllIIIllII$IllIIIllII  reason: collision with other inner class name */
        /* compiled from: line */
        public class C22034IllIIIllII implements Runnable {
            public C22034IllIIIllII() {
            }

            public void run() {
                IllIIIllII illIIIllII = IllIIIllII.this;
                if (IlIIIlIIIl.this.IllIIIIllI != null) {
                    Log.m40231i(illIIIllII, "Releasing SurfaceTexture", new Object[0]);
                    IlIIIlIIIl.this.IllIIIIllI.release();
                    SurfaceTexture unused = IlIIIlIIIl.this.IllIIIIllI = null;
                }
            }
        }

        /* compiled from: line */
        public class llIIlIlIIl implements Runnable {
            public final /* synthetic */ SurfaceTexture llIIlIlIIl;

            public llIIlIlIIl(SurfaceTexture surfaceTexture) {
                this.llIIlIlIIl = surfaceTexture;
            }

            public void run() {
                SurfaceTexture unused = IlIIIlIIIl.this.IllIIIIllI = this.llIIlIlIIl;
            }
        }

        public IllIIIllII() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Log.m40231i(this, "SurfaceTexture has become available (size: {}x{})", Integer.valueOf(i), Integer.valueOf(i2));
            if (!IIlIlIIlll.this.IlIlIlIIlI.get()) {
                IlIIIlIIIl.this.llIIlIlIIl.llIIlIlIIl(new llIIlIlIIl(surfaceTexture));
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Log.m40231i(this, "SurfaceTexture is about to be destroyed", new Object[0]);
            if (IlIIIlIIIl.this.llIIlIlIIl == null) {
                Log.m40231i(this, "Immediately releasing SurfaceTexture", new Object[0]);
                return true;
            }
            IlIIIlIIIl.this.llIIlIlIIl.llIIlIlIIl(new C22034IllIIIllII());
            return false;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Log.m40231i(this, "SurfaceTexture has changed size (new size: {}x{})", Integer.valueOf(i), Integer.valueOf(i2));
            if (!IIlIlIIlll.this.IlIlIlIIlI.get()) {
                IlIIIlIIIl.this.llIIlIlIIl.llIIlIlIIl(new IlIllIlIIl(surfaceTexture));
            }
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: line */
    public interface llIIIlllll {
    }

    /* compiled from: line */
    public class llIIlIlIIl implements Runnable {
        public llIIlIlIIl() {
        }

        public void run() {
            if (IlIIIlIIIl.this.IllIIIllII != null) {
                IlIIIlIIIl.this.IllIIIllII.setFixedSize(IlIIIlIIIl.this.lIlIIIIlIl.IlIllIlIIl(), IlIIIlIIIl.this.lIlIIIIlIl.llIIlIlIIl());
            }
        }
    }

    public IlIIIlIIIl(com.microblink.blinkbarcode.util.IllIIIllII illIIIllII, llIIIlllll lliiilllll) {
        this.llIIlIlIIl = illIIIllII;
        this.IlIllIlIIl = lliiilllll;
    }

    public TextureView.SurfaceTextureListener IlIllIlIIl() {
        return this.IIlIIIllIl;
    }

    public Surface IllIIIllII() {
        SurfaceHolder surfaceHolder = this.IllIIIllII;
        if (surfaceHolder != null) {
            return surfaceHolder.getSurface();
        }
        this.IllIIIIllI.setDefaultBufferSize(this.lIlIIIIlIl.IlIllIlIIl(), this.lIlIIIIlIl.llIIlIlIIl());
        return new Surface(this.IllIIIIllI);
    }

    public boolean llIIIlllll() {
        return (this.IllIIIllII != null && this.llIIIlllll) || this.IllIIIIllI != null;
    }

    public void llIIlIlIIl(com.microblink.blinkbarcode.hardware.camera.llIIIlllll lliiilllll, com.microblink.blinkbarcode.util.IllIIIllII illIIIllII) {
        this.lIlIIIIlIl = lliiilllll;
        if (this.IllIIIllII != null) {
            illIIIllII.llIIlIlIIl(new llIIlIlIIl());
        }
    }

    public SurfaceHolder.Callback llIIlIlIIl() {
        return this.llIIlIIlll;
    }
}
