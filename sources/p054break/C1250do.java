package p054break;

/* renamed from: break.do */
/* compiled from: FadeValueManager */
public class C1250do {

    /* renamed from: a */
    private C1252if f429a;

    /* renamed from: b */
    private final long f430b;

    /* renamed from: c */
    private final long f431c;

    /* renamed from: d */
    private final float[] f432d;

    /* renamed from: e */
    private final float[] f433e;

    public C1250do(long j, long j2, float[] fArr, float[] fArr2) {
        this.f432d = fArr;
        this.f433e = fArr2;
        this.f430b = j;
        this.f431c = j2;
        this.f429a = new C1252if(j, fArr2, fArr);
    }

    /* renamed from: do */
    public float[] mo14071do() {
        return (float[]) this.f429a.mo14074do();
    }

    /* renamed from: for  reason: not valid java name */
    public void m46120for() {
        C1252if ifVar = new C1252if(this.f431c, this.f432d, this.f433e);
        this.f429a = ifVar;
        ifVar.mo14076if();
    }

    /* renamed from: if */
    public void mo14073if() {
        C1252if ifVar = new C1252if(this.f430b, this.f433e, this.f432d);
        this.f429a = ifVar;
        ifVar.mo14076if();
    }
}
