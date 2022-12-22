package p234final;

import android.view.Window;
import android.view.WindowManager;

/* renamed from: final.new */
/* compiled from: WindowManager */
public class C20835new {

    /* renamed from: a */
    private Window f57244a;

    public C20835new(Window window) {
        this.f57244a = window;
    }

    /* renamed from: do */
    public void mo170678do(float f) {
        WindowManager.LayoutParams attributes = this.f57244a.getAttributes();
        attributes.screenBrightness = f;
        this.f57244a.setAttributes(attributes);
    }

    /* renamed from: if */
    public void mo170680if(boolean z) {
        WindowManager.LayoutParams attributes = this.f57244a.getAttributes();
        if (z) {
            attributes.screenBrightness = 1.0f;
        } else {
            attributes.screenBrightness = -1.0f;
        }
        this.f57244a.setAttributes(attributes);
    }

    /* renamed from: do */
    public void mo170679do(boolean z) {
        if (z) {
            this.f57244a.addFlags(128);
        } else {
            this.f57244a.clearFlags(128);
        }
    }
}
