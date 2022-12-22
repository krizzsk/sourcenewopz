package com.didi.hawaii.p118ar.core.p119zg;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.hawaii.p118ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p118ar.utils.ARSharePref;
import com.didi.hawaii.p118ar.utils.LocationUtil;
import com.didi.hawaii.p118ar.utils.SensorUtil;

/* renamed from: com.didi.hawaii.ar.core.zg.DiARZGNavView */
public class DiARZGNavView extends FrameLayout {

    /* renamed from: a */
    DiARZGNavController f23141a;

    /* renamed from: b */
    private CameraSurfaceView f23142b;

    /* renamed from: c */
    private Context f23143c;

    public DiARZGNavView(Context context) throws CreateDiARNavViewException {
        super(context);
        this.f23142b = null;
        this.f23141a = null;
        this.f23143c = null;
        setClickable(true);
        if (!isInEditMode()) {
            mo67773a(context);
        }
    }

    public DiARZGNavView(Context context, AttributeSet attributeSet) throws CreateDiARNavViewException {
        this(context, attributeSet, 0);
    }

    public DiARZGNavView(Context context, AttributeSet attributeSet, int i) throws CreateDiARNavViewException {
        super(context, attributeSet, i);
        this.f23142b = null;
        this.f23141a = null;
        this.f23143c = null;
        setClickable(true);
        if (!isInEditMode()) {
            mo67773a(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67773a(Context context) throws CreateDiARNavViewException {
        this.f23143c = context;
        ARSharePref.init(context);
        this.f23141a = new DiARZGNavController(context, this);
        LocationUtil.startGetLocation(context);
        LocationUtil.setNotifyLocationListener(this.f23141a);
        SensorUtil.getInstance().init(this.f23143c);
        initCameraView(this.f23143c);
    }

    public void initCameraView(Context context) {
        if (this.f23142b == null) {
            this.f23142b = new CameraSurfaceView(context);
            addView(this.f23142b, 0, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void openCamera() {
        CameraSurfaceView cameraSurfaceView = this.f23142b;
        if (cameraSurfaceView != null) {
            cameraSurfaceView.openCamera();
        }
    }

    public void setUiManagerListener(ZGUIListener zGUIListener) {
        DiARZGNavController diARZGNavController = this.f23141a;
        if (diARZGNavController != null) {
            diARZGNavController.setUiManagerListener(zGUIListener);
        }
    }

    public void onDriverArrived(String str) {
        DiARZGNavController diARZGNavController = this.f23141a;
        if (diARZGNavController != null) {
            diARZGNavController.onDriverArrived(str);
        }
    }

    public void activeZGNav() {
        DiARZGNavController diARZGNavController = this.f23141a;
        if (diARZGNavController != null) {
            diARZGNavController.activeZGNav();
        }
    }

    public void onRestart() {
        DiARZGNavController diARZGNavController = this.f23141a;
        if (diARZGNavController != null) {
            diARZGNavController.onRestart();
        }
    }

    public void onResume() {
        DiARZGNavController diARZGNavController = this.f23141a;
        if (diARZGNavController != null) {
            diARZGNavController.onResume();
        }
        SensorUtil.getInstance().startZGSensor(this.f23141a);
    }

    public void onStart() {
        DiARZGNavController diARZGNavController = this.f23141a;
        if (diARZGNavController != null) {
            diARZGNavController.onStart();
        }
    }

    public void onStop() {
        DiARZGNavController diARZGNavController = this.f23141a;
        if (diARZGNavController != null) {
            diARZGNavController.onStop();
        }
    }

    public void onPause() {
        DiARZGNavController diARZGNavController = this.f23141a;
        if (diARZGNavController != null) {
            diARZGNavController.onPause();
        }
        SensorUtil.getInstance().stopZGSensor();
    }

    public void onDestroy() {
        removeAllViews();
        LocationUtil.setNotifyLocationListener((LocationUtil.NotifyLocationListener) null);
        LocationUtil.stopGetLocation(this.f23143c);
        DiARZGNavController diARZGNavController = this.f23141a;
        if (diARZGNavController != null) {
            diARZGNavController.onDestroy();
            this.f23141a = null;
        }
        if (this.f23142b != null) {
            this.f23142b = null;
        }
        CameraSurfaceView cameraSurfaceView = this.f23142b;
        if (cameraSurfaceView != null) {
            cameraSurfaceView.onDestroy();
        }
    }
}
