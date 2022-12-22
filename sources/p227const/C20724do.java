package p227const;

import android.graphics.Rect;
import p094this.C3131do;
import p232do.C20817break;

/* renamed from: const.do */
/* compiled from: CroppingParams */
public class C20724do {

    /* renamed from: a */
    private float f56296a = 1.0f;

    /* renamed from: b */
    private float f56297b = 1.0f;

    /* renamed from: c */
    private float f56298c = 0.5f;

    /* renamed from: d */
    private float f56299d = 0.5f;

    /* renamed from: a */
    private int m40536a() {
        return C3131do.m4096if();
    }

    /* renamed from: case  reason: not valid java name */
    public float m47603case() {
        return this.f56297b;
    }

    /* renamed from: do */
    public float mo169167do() {
        return this.f56298c;
    }

    /* renamed from: for  reason: not valid java name */
    public void m47604for(float f) {
        this.f56299d = f;
    }

    /* renamed from: if */
    public void mo169171if(float f) {
        this.f56298c = f;
    }

    /* renamed from: try  reason: not valid java name */
    public float m47605try() {
        return this.f56296a;
    }

    /* renamed from: b */
    private int m40538b() {
        return C3131do.m4094do();
    }

    /* renamed from: do */
    public void mo169168do(Rect rect, C20817break breakR) {
        m40537a(((float) breakR.mo170629do()) / ((float) rect.height()));
        float f = 0.0f;
        float f2 = 0.5f;
        if (((float) m40536a()) / ((float) m40538b()) < ((float) breakR.mo170632if()) / ((float) breakR.mo170629do())) {
            if (rect.left != 0) {
                f = rect.right == breakR.mo170632if() ? 1.0f : 0.5f;
            }
            float b = (((float) m40538b()) - (((((float) breakR.mo170629do()) * 1.0f) * ((float) m40536a())) / ((float) breakR.mo170632if()))) / (((float) m40538b()) * 2.0f);
            if (rect.top == 0) {
                f2 = 1.0f - b;
            } else if (rect.bottom == breakR.mo170629do()) {
                f2 = b;
            }
        } else {
            if (rect.top == 0) {
                f = 1.0f;
            } else if (rect.bottom != breakR.mo170629do()) {
                f = 0.5f;
            }
            float a = (((float) m40536a()) - (((((float) breakR.mo170632if()) * 1.0f) * ((float) m40538b())) / ((float) breakR.mo170629do()))) / (((float) m40536a()) * 2.0f);
            if (rect.left == 0) {
                f2 = f;
                f = a;
            } else if (rect.right == breakR.mo170632if()) {
                f2 = f;
                f = 1.0f - a;
            } else {
                f2 = f;
                f = 0.5f;
            }
        }
        m47604for(f2);
        mo169171if(f);
    }

    /* renamed from: if */
    public float mo169170if() {
        return this.f56299d;
    }

    /* renamed from: a */
    private void m40537a(float f) {
        this.f56296a = f;
        this.f56297b = f;
    }
}
