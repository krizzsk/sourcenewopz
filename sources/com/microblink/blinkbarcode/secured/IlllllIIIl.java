package com.microblink.blinkbarcode.secured;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.microblink.blinkbarcode.hardware.SuccessCallback;
import com.microblink.blinkbarcode.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: line */
class IlllllIIIl {
    private AtomicReference<SuccessCallback> IlIllIlIIl = new AtomicReference<>((Object) null);
    private AtomicBoolean IllIIIllII;
    private AtomicInteger llIIIlllll;
    private boolean llIIlIlIIl = false;

    public IlllllIIIl() {
        IlIllIlIIl();
    }

    public void IlIllIlIIl() {
        this.IllIIIllII = new AtomicBoolean(false);
        this.llIIIlllll = new AtomicInteger(0);
    }

    public boolean llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    public void llIIlIlIIl(CameraCharacteristics cameraCharacteristics) {
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool != null) {
            this.llIIlIlIIl = bool.booleanValue();
            return;
        }
        throw new RuntimeException("Unable to obtain information about LED torch availability. This is a bug in device!");
    }

    public void llIIlIlIIl(boolean z, SuccessCallback successCallback) {
        this.IllIIIllII.set(z);
        this.IlIllIlIIl.set(successCallback);
        this.llIIIlllll.set(0);
    }

    public void llIIlIlIIl(TotalCaptureResult totalCaptureResult) {
        if (this.IlIllIlIIl.get() != null) {
            int incrementAndGet = this.llIIIlllll.incrementAndGet();
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
            Log.m40227d(this, "Torch state is {}", num);
            if (num == null || num.intValue() == 2) {
                if (!this.IllIIIllII.get()) {
                    this.IlIllIlIIl.getAndSet((Object) null).onOperationDone(true);
                } else if (incrementAndGet > 30) {
                    this.IllIIIllII.set(true);
                    this.IlIllIlIIl.getAndSet((Object) null).onOperationDone(false);
                }
            } else if (num.intValue() != 3) {
            } else {
                if (this.IllIIIllII.get()) {
                    this.IlIllIlIIl.getAndSet((Object) null).onOperationDone(true);
                } else if (incrementAndGet > 30) {
                    this.IllIIIllII.set(false);
                    this.IlIllIlIIl.getAndSet((Object) null).onOperationDone(false);
                }
            }
        }
    }
}
