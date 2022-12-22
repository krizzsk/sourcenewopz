package com.microblink.blinkbarcode.secured;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.WindowManager;
import com.microblink.blinkbarcode.hardware.camera.lIlIIIIlIl;
import com.microblink.blinkbarcode.util.Log;
import java.io.IOException;

/* compiled from: line */
public class lllIlIlIIl implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, lIlIIIIlIl {
    private com.microblink.blinkbarcode.util.IllIIIllII IlIllIlIIl;
    /* access modifiers changed from: private */
    public int IllIIIIllI = 0;
    /* access modifiers changed from: private */
    public llIIIlllll IllIIIllII;
    private SurfaceHolder lIlIIIIlIl = null;
    /* access modifiers changed from: private */
    public int llIIIlllll = 0;
    /* access modifiers changed from: private */
    public SurfaceTexture llIIlIIlll = null;
    private com.microblink.blinkbarcode.hardware.IllIIIllII llIIlIlIIl;

    /* compiled from: line */
    public class IlIllIlIIl implements Runnable {
        public final /* synthetic */ int IlIllIlIIl;
        public final /* synthetic */ int IllIIIllII;
        public final /* synthetic */ SurfaceTexture llIIlIlIIl;

        public IlIllIlIIl(SurfaceTexture surfaceTexture, int i, int i2) {
            this.llIIlIlIIl = surfaceTexture;
            this.IlIllIlIIl = i;
            this.IllIIIllII = i2;
        }

        public void run() {
            SurfaceTexture unused = lllIlIlIIl.this.llIIlIIlll = this.llIIlIlIIl;
            int unused2 = lllIlIlIIl.this.llIIIlllll = this.IlIllIlIIl;
            int unused3 = lllIlIlIIl.this.IllIIIIllI = this.IllIIIllII;
            ((lIIIIIllll) lllIlIlIIl.this.IllIIIllII).llIIlIlIIl();
        }
    }

    /* compiled from: line */
    public class IllIIIllII implements Runnable {
        public IllIIIllII() {
        }

        public void run() {
            if (lllIlIlIIl.this.llIIlIIlll != null) {
                Log.m40231i(this, "Releasing SurfaceTexture", new Object[0]);
                lllIlIlIIl.this.llIIlIIlll.release();
                SurfaceTexture unused = lllIlIlIIl.this.llIIlIIlll = null;
            }
        }
    }

    /* compiled from: line */
    public interface llIIIlllll {
    }

    /* compiled from: line */
    public class llIIlIlIIl implements Runnable {
        public final /* synthetic */ int IlIllIlIIl;
        public final /* synthetic */ int IllIIIllII;
        public final /* synthetic */ SurfaceTexture llIIlIlIIl;

        public llIIlIlIIl(SurfaceTexture surfaceTexture, int i, int i2) {
            this.llIIlIlIIl = surfaceTexture;
            this.IlIllIlIIl = i;
            this.IllIIIllII = i2;
        }

        public void run() {
            SurfaceTexture unused = lllIlIlIIl.this.llIIlIIlll = this.llIIlIlIIl;
            int unused2 = lllIlIlIIl.this.llIIIlllll = this.IlIllIlIIl;
            int unused3 = lllIlIlIIl.this.IllIIIIllI = this.IllIIIllII;
            ((lIIIIIllll) lllIlIlIIl.this.IllIIIllII).llIIlIlIIl();
        }
    }

    public lllIlIlIIl(com.microblink.blinkbarcode.hardware.IllIIIllII illIIIllII, com.microblink.blinkbarcode.util.IllIIIllII illIIIllII2, llIIIlllll lliiilllll) {
        this.llIIlIlIIl = illIIIllII;
        this.IlIllIlIIl = illIIIllII2;
        this.IllIIIllII = lliiilllll;
    }

    public TextureView.SurfaceTextureListener IlIllIlIIl() {
        return this;
    }

    public boolean IllIIIIllI() {
        if (!((this.lIlIIIIlIl == null && this.llIIlIIlll == null) ? false : true) || this.llIIIlllll <= 0 || this.IllIIIIllI <= 0) {
            return false;
        }
        return true;
    }

    public int IllIIIllII() {
        return this.IllIIIIllI;
    }

    public int llIIIlllll() {
        return this.llIIIlllll;
    }

    public SurfaceHolder.Callback llIIlIlIIl() {
        return this;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.m40231i(this, "SurfaceTexture has become available (size: {}x{})", Integer.valueOf(i), Integer.valueOf(i2));
        if (!((lIIIIIllll) this.IllIIIllII).llIIlIlIIl.lIlIIIIlIl) {
            this.IlIllIlIIl.llIIlIlIIl(new llIIlIlIIl(surfaceTexture, i, i2));
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.m40231i(this, "SurfaceTexture is about to be destroyed", new Object[0]);
        com.microblink.blinkbarcode.util.IllIIIllII illIIIllII = this.IlIllIlIIl;
        if (illIIIllII != null) {
            illIIIllII.llIIlIlIIl(new IllIIIllII());
            return false;
        }
        Log.m40231i(this, "Immediately releasing SurfaceTexture", new Object[0]);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.m40231i(this, "SurfaceTexture has changed size (new size: {}x{})", Integer.valueOf(i), Integer.valueOf(i2));
        if (!((lIIIIIllll) this.IllIIIllII).llIIlIlIIl.lIlIIIIlIl) {
            this.IlIllIlIIl.llIIlIlIIl(new IlIllIlIIl(surfaceTexture, i, i2));
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.m40227d(this, "Surface changed to size: {}x{}, format: {}", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.m40231i(this, "Surface has been created!", new Object[0]);
        Display defaultDisplay = ((WindowManager) this.llIIlIlIIl.llIIIlllll().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.x;
        int i2 = point.y;
        this.lIlIIIIlIl = surfaceHolder;
        this.llIIIlllll = i;
        this.IllIIIIllI = i2;
        ((lIIIIIllll) this.IllIIIllII).llIIlIlIIl();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.m40231i(this, "Surface is being destroyed", new Object[0]);
        if (this.lIlIIIIlIl != null) {
            Log.m40231i(this, "Removing callback from surface holder", new Object[0]);
            this.lIlIIIIlIl.removeCallback(this);
            this.lIlIIIIlIl = null;
        }
    }

    public void llIIlIlIIl(Camera camera) throws IOException {
        SurfaceHolder surfaceHolder = this.lIlIIIIlIl;
        if (surfaceHolder != null) {
            camera.setPreviewDisplay(surfaceHolder);
        } else {
            camera.setPreviewTexture(this.llIIlIIlll);
        }
    }
}
