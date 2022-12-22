package com.didi.hawaii.p118ar;

import android.content.Context;
import com.didi.hawaii.p118ar.core.AlertUiManager;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.hawaii.ar.DiDiAR */
public class DiDiAR {

    /* renamed from: a */
    private WeakReference<DiARNavView> f22975a = null;

    /* renamed from: b */
    private Context f22976b = null;

    public DiDiAR(DiARNavView diARNavView, Context context) {
        this.f22975a = new WeakReference<>(diARNavView);
        this.f22976b = context;
    }

    public void setUiManagerListener(AlertUiManager.UIListener uIListener) {
        WeakReference<DiARNavView> weakReference = this.f22975a;
        if (weakReference != null && weakReference.get() != null) {
            ((DiARNavView) this.f22975a.get()).getDiARController().setUiManagerListener(uIListener);
        }
    }

    public void startAR() {
        WeakReference<DiARNavView> weakReference = this.f22975a;
        if (weakReference != null && weakReference.get() != null) {
            ((DiARNavView) this.f22975a.get()).getDiARController().start();
        }
    }

    public void recoveryARUI() {
        WeakReference<DiARNavView> weakReference = this.f22975a;
        if (weakReference != null && weakReference.get() != null) {
            ((DiARNavView) this.f22975a.get()).getDiARController().recoveryARUI();
        }
    }

    public void exitOfOrderCancell() {
        WeakReference<DiARNavView> weakReference = this.f22975a;
        if (weakReference != null && weakReference.get() != null) {
            ((DiARNavView) this.f22975a.get()).getDiARController().exitOfOrderCancell();
        }
    }

    public void hideARNavUI() {
        WeakReference<DiARNavView> weakReference = this.f22975a;
        if (weakReference != null && weakReference.get() != null) {
            ((DiARNavView) this.f22975a.get()).getDiARController().hideARNavUI();
        }
    }

    public float distanceOfEnd() {
        WeakReference<DiARNavView> weakReference = this.f22975a;
        if (weakReference == null || weakReference.get() == null) {
            return -1.0f;
        }
        return ((DiARNavView) this.f22975a.get()).getDiARController().distanceOfEnd();
    }

    public float[] getCurrentLocationInModle() {
        WeakReference<DiARNavView> weakReference = this.f22975a;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return ((DiARNavView) this.f22975a.get()).getDiARController().currentLocation();
    }

    public int getCurARStatus() {
        WeakReference<DiARNavView> weakReference = this.f22975a;
        if (weakReference == null || weakReference.get() == null) {
            return -1;
        }
        return ((DiARNavView) this.f22975a.get()).getDiARController().getCurARStatus();
    }

    public void onRestart() {
        DiARNavView diARNavView = (DiARNavView) this.f22975a.get();
        if (diARNavView != null) {
            diARNavView.onRestart();
        }
    }

    public void onResume() {
        DiARNavView diARNavView = (DiARNavView) this.f22975a.get();
        if (diARNavView != null) {
            diARNavView.onResume();
        }
    }

    public void onStart() {
        DiARNavView diARNavView = (DiARNavView) this.f22975a.get();
        if (diARNavView != null) {
            diARNavView.onStart();
        }
    }

    public void onStop() {
        DiARNavView diARNavView = (DiARNavView) this.f22975a.get();
        if (diARNavView != null) {
            diARNavView.onStop();
        }
    }

    public void onPause() {
        DiARNavView diARNavView = (DiARNavView) this.f22975a.get();
        if (diARNavView != null) {
            diARNavView.onPause();
        }
    }

    public void onDestroy() {
        DiARNavView diARNavView = (DiARNavView) this.f22975a.get();
        if (diARNavView != null) {
            diARNavView.onDestroy();
        }
    }
}
