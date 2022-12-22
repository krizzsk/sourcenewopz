package com.didichuxing.mlcp.drtc.models;

import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;
import com.didichuxing.mlcp.drtc.enums.DrtcMode;

/* renamed from: com.didichuxing.mlcp.drtc.models.a */
/* compiled from: DrtcMediaConstraints */
public class C15901a {

    /* renamed from: a */
    private boolean f48327a = true;

    /* renamed from: b */
    private boolean f48328b = true;

    /* renamed from: c */
    private boolean f48329c = true;

    /* renamed from: d */
    private boolean f48330d = false;

    /* renamed from: e */
    private DrtcMode f48331e = DrtcMode.Standard;

    /* renamed from: f */
    private DrtcCameraType f48332f = DrtcCameraType.FrontFace;

    /* renamed from: g */
    private C15903c f48333g = new C15903c();

    private C15901a() {
    }

    /* renamed from: i */
    public static C15901a m34545i() {
        return new C15901a();
    }

    /* renamed from: a */
    public void mo118978a(DrtcMode drtcMode) {
        this.f48331e = drtcMode;
        if (drtcMode == DrtcMode.OnlyAudio) {
            mo118979a((C15903c) null);
            mo118984d(true);
            mo118981b(true);
            mo118982c(false);
            this.f48330d = false;
        }
        if (drtcMode == DrtcMode.OnlyVideo) {
            mo118984d(false);
            mo118981b(false);
            this.f48330d = false;
        }
    }

    /* renamed from: b */
    public void mo118981b(boolean z) {
        this.f48329c = z;
    }

    /* renamed from: c */
    public void mo118982c(boolean z) {
        this.f48328b = z;
    }

    /* renamed from: d */
    public void mo118984d(boolean z) {
        this.f48327a = z;
    }

    /* renamed from: e */
    public boolean mo118986e() {
        return this.f48328b;
    }

    /* renamed from: f */
    public boolean mo118987f() {
        return this.f48327a;
    }

    /* renamed from: g */
    public Boolean mo118988g() {
        return Boolean.valueOf(this.f48333g != null);
    }

    /* renamed from: h */
    public C15903c mo118989h() {
        return this.f48333g;
    }

    /* renamed from: b */
    public DrtcCameraType mo118980b() {
        return this.f48332f;
    }

    /* renamed from: c */
    public boolean mo118983c() {
        return this.f48330d;
    }

    /* renamed from: d */
    public boolean mo118985d() {
        return this.f48329c;
    }

    /* renamed from: a */
    public DrtcMode mo118976a() {
        return this.f48331e;
    }

    /* renamed from: a */
    public C15901a mo118977a(boolean z) {
        this.f48330d = z;
        return this;
    }

    /* renamed from: a */
    public void mo118979a(C15903c cVar) {
        this.f48333g = cVar;
    }
}
