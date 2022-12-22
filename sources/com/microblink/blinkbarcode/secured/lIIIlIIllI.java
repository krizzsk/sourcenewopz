package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.hardware.Camera;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.hardware.camera.VideoResolutionPreset;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.util.llIIlIlIIl;

/* compiled from: line */
public class lIIIlIIllI extends IlIIIIIlll {
    private VideoResolutionPreset IllIIIIllI;

    public lIIIlIIllI(Camera camera, int i, Context context, VideoResolutionPreset videoResolutionPreset) {
        super(camera, i, context);
        this.IllIIIIllI = videoResolutionPreset;
    }

    public void IlIllIlIIl() {
        Log.m40231i(this, "Using VideoPreset strategy with preset: {}", this.IllIIIIllI);
    }

    public double llIIlIlIIl(Camera.Size size, double d, long j, CameraType cameraType) {
        if (!llIIlIlIIl(size, cameraType)) {
            return Double.POSITIVE_INFINITY;
        }
        return (Math.abs(((((double) size.width) * ((double) size.height)) / ((double) j)) - 1.0d) * 1200.0d) + (Math.abs((((double) size.width) / ((double) size.height)) - d) * 1100.0d);
    }

    public Camera.Size llIIlIlIIl(int i, int i2, CameraType cameraType) {
        Camera.Size llIIlIlIIl;
        Camera.Size size = null;
        if (this.IlIllIlIIl == null) {
            return null;
        }
        Log.m40233v(this, "surface size is: {}x{}", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.IllIIIIllI == VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT && (llIIlIlIIl = llIIlIlIIl(cameraType)) != null) {
            return llIIlIlIIl;
        }
        llIIlIlIIl.llIIlIlIIl();
        VideoResolutionPreset videoResolutionPreset = this.IllIIIIllI;
        if (videoResolutionPreset != VideoResolutionPreset.VIDEO_RESOLUTION_MAX_AVAILABLE) {
            long round = Math.round(((double) videoResolutionPreset.getIdealHeight()) * 1.7777777777777777d);
            Log.m40231i(this, "Ideal camera resolution is {}x{}", Long.valueOf(round), Integer.valueOf(this.IllIIIIllI.getIdealHeight()));
            return llIIlIlIIl(this.IlIllIlIIl, 1.7777777777777777d, round * ((long) this.IllIIIIllI.getIdealHeight()), cameraType);
        }
        long j = 0;
        for (Camera.Size next : this.IlIllIlIIl) {
            int i3 = next.width;
            if (i3 % 4 == 0) {
                long j2 = ((long) i3) * ((long) next.height);
                if (j2 > j) {
                    size = next;
                    j = j2;
                }
            }
        }
        return size;
    }
}
