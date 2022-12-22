package p055case;

/* renamed from: case.try */
/* compiled from: EncoderOutput */
public class C1277try {

    /* renamed from: do */
    public final byte[] f473do;

    /* renamed from: if */
    public final C1278do f474if;

    /* renamed from: case.try$do */
    /* compiled from: EncoderOutput */
    public enum C1278do {
        CODEC_CONFIG,
        FRAME;

        /* renamed from: do */
        public static C1278do m996do(int i) {
            if ((i & 2) != 0) {
                return CODEC_CONFIG;
            }
            return FRAME;
        }
    }

    public C1277try(byte[] bArr, int i) {
        this.f473do = bArr;
        C1278do doVar = C1278do.m996do(i);
        this.f474if = doVar;
        StringBuilder sb = new StringBuilder();
        sb.append("🚚 new EncoderOutput size=");
        sb.append(bArr.length);
        sb.append(" ------------ ");
        sb.append(doVar);
        sb.append(" ");
        sb.append(i);
    }

    /* renamed from: do */
    public boolean mo14148do() {
        return this.f474if == C1278do.CODEC_CONFIG;
    }
}
