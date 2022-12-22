package com.microblink.blinkbarcode.hardware.accelerometer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.didi.security.wireless.ISecurityConf;
import com.microblink.blinkbarcode.util.Log;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: line */
public class llIIlIlIIl implements SensorEventListener {
    private Timer IIlIIIllIl = null;
    private ShakeCallback IlIllIlIIl = null;
    private SensorManager IllIIIIllI;
    private AtomicBoolean IllIIIllII = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public Handler lIIIIIllll;
    private int lIlIIIIlIl;
    private Sensor llIIIlllll;
    private long llIIlIIlll = -1;
    private IlIllIlIIl llIIlIlIIl;

    /* renamed from: com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl$llIIlIlIIl  reason: collision with other inner class name */
    /* compiled from: line */
    public class C22030llIIlIlIIl extends TimerTask {
        /* access modifiers changed from: private */
        public float[] llIIlIlIIl;

        /* renamed from: com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl$llIIlIlIIl$llIIlIlIIl  reason: collision with other inner class name */
        /* compiled from: line */
        public class C22031llIIlIlIIl implements Runnable {
            public C22031llIIlIlIIl() {
            }

            public void run() {
                C22030llIIlIlIIl lliililiil = C22030llIIlIlIIl.this;
                llIIlIlIIl.this.llIIlIlIIl(lliililiil.llIIlIlIIl);
            }
        }

        public C22030llIIlIlIIl() {
            float[] fArr = new float[3];
            this.llIIlIlIIl = fArr;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
        }

        public void run() {
            llIIlIlIIl.this.lIIIIIllll.post(new C22031llIIlIlIIl());
        }
    }

    public llIIlIlIIl(Context context, IlIllIlIIl ilIllIlIIl, float f) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
        this.IllIIIIllI = sensorManager;
        this.llIIlIlIIl = ilIllIlIIl;
        this.llIIIlllll = sensorManager.getDefaultSensor(1);
        this.lIlIIIIlIl = Math.round(f * 1000.0f) * 1000;
        this.lIIIIIllll = new Handler();
    }

    public boolean IlIllIlIIl() {
        return this.IllIIIllII.get();
    }

    public void IllIIIllII() {
        Log.m40233v(this, "Registering accelerometer sensor listener {}", this);
        boolean registerListener = this.IllIIIIllI.registerListener(this, this.llIIIlllll, this.lIlIIIIlIl);
        llIIlIlIIl(true);
        if (!registerListener) {
            Log.m40229e(this, "unable to register accelerometer sensor with sample period {} microseconds. Trying SENSOR_DELAY_NORMAL...", Integer.valueOf(this.lIlIIIIlIl));
            registerListener = this.IllIIIIllI.registerListener(this, this.llIIIlllll, 3);
            if (!registerListener) {
                Log.m40235w(this, "unable to register accelerometer sensor at all", new Object[0]);
                llIIlIlIIl(false);
            }
        }
        if (registerListener) {
            Timer timer = new Timer("Accelerometer timer");
            this.IIlIIIllIl = timer;
            timer.schedule(new C22030llIIlIlIIl(), 0, (long) this.lIlIIIIlIl);
        }
    }

    public void llIIIlllll() {
        Log.m40233v(this, "Unregistering accelerometer sensor listener {}", this);
        Timer timer = this.IIlIIIllIl;
        if (timer != null) {
            timer.cancel();
            this.IIlIIIllIl = null;
        }
        this.IllIIIIllI.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        Log.m40231i(this, "Accelerometer accuracy has changed", new Object[0]);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        llIIlIlIIl(sensorEvent.values);
    }

    public void llIIlIlIIl(ShakeCallback shakeCallback) {
        this.IlIllIlIIl = shakeCallback;
    }

    /* access modifiers changed from: private */
    public void llIIlIlIIl(float[] fArr) {
        if (this.llIIlIIlll >= 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.llIIlIIlll;
            if (currentTimeMillis > 0) {
                int i = (int) ((((float) this.lIlIIIIlIl) * 0.66f) + (((float) (currentTimeMillis * 1000)) * 0.33999997f));
                this.lIlIIIIlIl = i;
                this.llIIlIlIIl.llIIlIlIIl((((float) i) / 1000.0f) / 1000.0f);
            }
        }
        boolean z = true;
        this.llIIlIlIIl.llIIlIlIIl(fArr[0], fArr[1], fArr[2]);
        if (!this.IllIIIllII.get() && llIIlIlIIl() > 0.47f) {
            llIIlIlIIl(true);
        } else {
            if (!this.IllIIIllII.get() || llIIlIlIIl() >= 0.2f) {
                z = false;
            }
            if (z) {
                llIIlIlIIl(false);
            }
        }
        this.llIIlIIlll = System.currentTimeMillis();
    }

    private float llIIlIlIIl() {
        float llIIlIlIIl2 = this.llIIlIlIIl.llIIlIlIIl();
        float IlIllIlIIl2 = this.llIIlIlIIl.IlIllIlIIl();
        float IllIIIllII2 = this.llIIlIlIIl.IllIIIllII();
        return (float) Math.sqrt((double) ((llIIlIlIIl2 * llIIlIlIIl2) + (IlIllIlIIl2 * IlIllIlIIl2) + (IllIIIllII2 * IllIIIllII2)));
    }

    private void llIIlIlIIl(boolean z) {
        this.IllIIIllII.set(z);
        if (z) {
            this.IlIllIlIIl.onShakingStarted();
        } else {
            this.IlIllIlIIl.onShakingStopped();
        }
    }
}
