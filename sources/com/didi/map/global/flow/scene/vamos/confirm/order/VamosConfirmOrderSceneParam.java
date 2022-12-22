package com.didi.map.global.flow.scene.vamos.confirm.order;

import android.content.Context;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.confirm.normal.StartEndInfo;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;

public class VamosConfirmOrderSceneParam extends BaseVamosPageSceneParam {

    /* renamed from: a */
    private boolean f27090a;

    /* renamed from: b */
    private int f27091b;

    /* renamed from: c */
    private double f27092c;

    /* renamed from: d */
    private StartEndInfo f27093d;

    /* renamed from: e */
    private StartEndInfo f27094e;

    public boolean isDrawLine() {
        return this.f27090a;
    }

    public int getLineColor() {
        return this.f27091b;
    }

    public double getLineWidth() {
        return this.f27092c;
    }

    public StartEndInfo getStartInfo() {
        return this.f27093d;
    }

    public StartEndInfo getEndInfo() {
        return this.f27094e;
    }

    private VamosConfirmOrderSceneParam(Builder builder) {
        super(builder);
        this.f27090a = builder.isDrawLine;
        this.f27091b = builder.lineColor;
        this.f27092c = builder.lineWidth;
        this.f27093d = builder.startInfo;
        this.f27094e = builder.endInfo;
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        /* access modifiers changed from: private */
        public StartEndInfo endInfo;
        /* access modifiers changed from: private */
        public boolean isDrawLine;
        /* access modifiers changed from: private */
        public int lineColor;
        /* access modifiers changed from: private */
        public double lineWidth;
        /* access modifiers changed from: private */
        public StartEndInfo startInfo;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder actorGetter(IActorGetter iActorGetter) {
            return (Builder) super.actorGetter(iActorGetter);
        }

        public Builder travelId(String str) {
            return (Builder) super.travelId(str);
        }

        public Builder drawLine(boolean z) {
            this.isDrawLine = z;
            return this;
        }

        public Builder lineColor(int i) {
            this.lineColor = i;
            return this;
        }

        public Builder lineWidth(double d) {
            this.lineWidth = d;
            return this;
        }

        public Builder startInfo(StartEndInfo startEndInfo) {
            this.startInfo = startEndInfo;
            return this;
        }

        public Builder endInfo(StartEndInfo startEndInfo) {
            this.endInfo = startEndInfo;
            return this;
        }

        public VamosConfirmOrderSceneParam build() {
            return new VamosConfirmOrderSceneParam(this);
        }
    }
}
