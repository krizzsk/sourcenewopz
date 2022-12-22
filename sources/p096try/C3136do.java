package p096try;

/* renamed from: try.do */
/* compiled from: CannyState */
public enum C3136do {
    NO_FACE_PATH("no_face_path", false),
    FACE_PATH("face_path", false),
    END_FACE_PATH("end_face_path", false, true),
    TOO_FAR_FACE_PATH("too_far_face_path"),
    TOO_CLOSE_FACE_PATH("too_close_face_path"),
    NO_FACE("no_face", false),
    TOO_FAR("face_too_small"),
    TOO_CLOSE("face_too_big"),
    TOO_BRIGHT("too_bright"),
    ROLL_TOO_HIGH("roll_too_high"),
    ROLL_TOO_LOW("roll_too_low"),
    YAW_TOO_HIGH("yaw_too_high"),
    YAW_TOO_LOW("yaw_too_low"),
    PITCH_TOO_HIGH("pitch_too_high"),
    PITCH_TOO_LOW("pitch_too_low"),
    READY("ready");
    

    /* renamed from: do */
    private String f6983do;

    /* renamed from: for  reason: not valid java name */
    private boolean f61726for;

    /* renamed from: if */
    private boolean f6984if;

    private C3136do(String str) {
        this.f6983do = str;
        this.f61726for = true;
        this.f6984if = false;
    }

    /* renamed from: do */
    public String mo38657do() {
        return this.f6983do;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m46215for() {
        return this.f61726for;
    }

    /* renamed from: if */
    public boolean mo38659if() {
        return this.f6984if;
    }

    private C3136do(String str, boolean z) {
        this.f6983do = str;
        this.f61726for = z;
        this.f6984if = false;
    }

    private C3136do(String str, boolean z, boolean z2) {
        this.f6983do = str;
        this.f61726for = z;
        this.f6984if = z2;
    }
}
