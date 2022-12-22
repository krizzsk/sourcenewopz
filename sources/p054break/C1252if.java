package p054break;

/* renamed from: break.if */
/* compiled from: FloatArrayInterpolator */
public class C1252if extends C1251for<float[]> {
    public C1252if(long j, float[] fArr, float[] fArr2) {
        super(j, fArr, fArr2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: if */
    public float[] mo14075do(float f) {
        int length = ((float[]) this.f434a).length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            float f2 = ((float[]) this.f434a)[i];
            fArr[i] = f2 + ((((float[]) this.f435b)[i] - f2) * f);
        }
        return fArr;
    }
}
