package com.iproov.sdk.face;

import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.face.model.Pose;
import p093switch.C3105break;
import p093switch.C3106case;
import p093switch.C3126this;

public class FaceFeatureSmoother {
    private final C3105break faceBounds;
    private final C3126this normalizedSize;
    public final C3126this pitch;
    public final C3126this roll;
    public final C3126this yaw;

    public FaceFeatureSmoother(double d) {
        this.normalizedSize = new C3126this(d);
        this.faceBounds = new C3105break(d);
        this.roll = new C3126this(d);
        this.yaw = new C3126this(d);
        this.pitch = new C3126this(d);
    }

    public void reset() {
        this.normalizedSize.mo38628if();
        this.faceBounds.mo38612do();
        this.roll.mo38628if();
        this.yaw.mo38628if();
        this.pitch.mo38628if();
    }

    public FaceFeature smooth(FaceFeature faceFeature) {
        StringBuilder sb = new StringBuilder();
        sb.append("WAS faceBounds=");
        sb.append(faceFeature.getFaceBounds());
        this.normalizedSize.mo38627do(Double.valueOf(faceFeature.getNormalizedSize()));
        if (faceFeature.getFaceBounds() != null) {
            this.faceBounds.mo38613do(faceFeature.getFaceBounds());
        }
        Pose pose = null;
        if (faceFeature.getPose() != null) {
            this.roll.mo38627do(Double.valueOf(C3106case.m4003do(faceFeature.getPose().roll)));
            this.yaw.mo38627do(Double.valueOf(C3106case.m4003do(faceFeature.getPose().yaw)));
            this.pitch.mo38627do(Double.valueOf(C3106case.m4003do(faceFeature.getPose().pitch)));
            pose = new Pose(C3106case.m4005do(this.roll.mo38626do().doubleValue()), C3106case.m4005do(this.yaw.mo38626do().doubleValue()), C3106case.m4005do(this.pitch.mo38626do().doubleValue()));
        }
        FaceFeature faceFeature2 = new FaceFeature(this.normalizedSize.mo38626do().doubleValue(), this.faceBounds.mo38614if(), pose);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SMOOTHED faceBounds=");
        sb2.append(faceFeature2.getFaceBounds());
        return faceFeature2;
    }
}
