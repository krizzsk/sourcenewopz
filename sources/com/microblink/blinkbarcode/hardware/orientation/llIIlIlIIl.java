package com.microblink.blinkbarcode.hardware.orientation;

import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.microblink.blinkbarcode.hardware.IllIIIllII;
import com.microblink.blinkbarcode.secured.llIllIIlll;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class llIIlIlIIl extends OrientationEventListener {
    private Orientation IlIllIlIIl;
    private int IllIIIllII;
    private OrientationChangeListener llIIlIlIIl;

    public llIIlIlIIl(IllIIIllII illIIIllII, OrientationChangeListener orientationChangeListener) {
        super(illIIIllII.llIIIlllll());
        this.llIIlIlIIl = orientationChangeListener;
        int rotation = ((WindowManager) illIIIllII.llIIIlllll().getApplicationContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (llIllIIlll.llIIlIlIIl(illIIIllII.llIIIlllll())) {
            Log.m40227d(this, "Screen is in portrait", new Object[0]);
            if (rotation == 0) {
                Log.m40227d(this, "Screen orientation is 0", new Object[0]);
                this.IllIIIllII = 0;
            } else if (rotation == 2) {
                Log.m40227d(this, "Screen orientation is 180", new Object[0]);
                this.IllIIIllII = 0;
            } else if (rotation == 3) {
                Log.m40227d(this, "Screen orientation is 270", new Object[0]);
                this.IllIIIllII = 270;
            } else {
                Log.m40227d(this, "Screen orientation is 90", new Object[0]);
                this.IllIIIllII = 270;
            }
        } else {
            Log.m40227d(this, "Screen is in landscape", new Object[0]);
            if (rotation == 1) {
                Log.m40227d(this, "Screen orientation is 90", new Object[0]);
                this.IllIIIllII = 0;
            } else if (rotation == 3) {
                Log.m40227d(this, "Screen orientation is 270", new Object[0]);
                this.IllIIIllII = 0;
            } else if (rotation == 0) {
                Log.m40227d(this, "Screen orientation is 0", new Object[0]);
                this.IllIIIllII = 270;
            } else {
                Log.m40227d(this, "Screen orientation is 180", new Object[0]);
                this.IllIIIllII = 270;
            }
        }
        Log.m40227d(this, "Calculated degrees offset: {}", Integer.valueOf(this.IllIIIllII));
        if (this.IllIIIllII == 270) {
            Log.m40227d(this, "Natural Orientation is landscape", new Object[0]);
            if (illIIIllII.IlIlllllII()) {
                this.IllIIIllII = 90;
            } else {
                this.IllIIIllII = 270;
            }
        } else {
            Log.m40227d(this, "Natural Orientation is portrait", new Object[0]);
        }
        this.IlIllIlIIl = Orientation.ORIENTATION_UNKNOWN;
    }

    public void onOrientationChanged(int i) {
        Orientation orientation;
        OrientationChangeListener orientationChangeListener = this.llIIlIlIIl;
        if (orientationChangeListener != null && i != -1) {
            int i2 = (i + this.IllIIIllII) % 360;
            if (i2 < 0) {
                orientation = this.IlIllIlIIl;
            } else if (i2 >= 315 || i2 < 45) {
                orientation = Orientation.ORIENTATION_PORTRAIT;
            } else if (i2 >= 45 && i2 < 135) {
                orientation = Orientation.ORIENTATION_LANDSCAPE_LEFT;
            } else if (i2 >= 135 && i2 < 225) {
                orientation = Orientation.ORIENTATION_PORTRAIT_UPSIDE;
            } else if (i2 < 225 || i2 >= 315) {
                orientation = this.IlIllIlIIl;
            } else {
                orientation = Orientation.ORIENTATION_LANDSCAPE_RIGHT;
            }
            if (orientation != this.IlIllIlIIl) {
                this.IlIllIlIIl = orientation;
                orientationChangeListener.onOrientationChange(orientation);
            }
        }
    }
}
