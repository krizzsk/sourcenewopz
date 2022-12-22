package p233else;

import com.iproov.sdk.face.model.Pose;
import p096try.C3136do;

/* renamed from: else.for */
/* compiled from: PoseManager */
public class C20828for {

    /* renamed from: a */
    private final Float f57226a;

    /* renamed from: b */
    private final Float f57227b;

    /* renamed from: c */
    private final Float f57228c;

    public C20828for(Float f, Float f2, Float f3) {
        this.f57226a = f;
        this.f57227b = f2;
        this.f57228c = f3;
    }

    /* renamed from: do */
    public C3136do mo170661do(Pose pose) {
        Float f = this.f57226a;
        if (f != null) {
            if (pose.roll > f.floatValue()) {
                return C3136do.ROLL_TOO_HIGH;
            }
            if ((-pose.roll) > this.f57226a.floatValue()) {
                return C3136do.ROLL_TOO_LOW;
            }
        }
        Float f2 = this.f57227b;
        if (f2 != null) {
            if (pose.yaw > f2.floatValue()) {
                return C3136do.YAW_TOO_HIGH;
            }
            if ((-pose.yaw) > this.f57227b.floatValue()) {
                return C3136do.YAW_TOO_LOW;
            }
        }
        Float f3 = this.f57228c;
        if (f3 == null) {
            return null;
        }
        if (pose.pitch > f3.floatValue()) {
            return C3136do.PITCH_TOO_HIGH;
        }
        if ((-pose.pitch) > this.f57228c.floatValue()) {
            return C3136do.PITCH_TOO_LOW;
        }
        return null;
    }
}
