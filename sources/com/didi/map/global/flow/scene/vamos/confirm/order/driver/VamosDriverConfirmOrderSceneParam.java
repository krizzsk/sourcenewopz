package com.didi.map.global.flow.scene.vamos.confirm.order.driver;

import android.content.Context;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.confirm.normal.StartEndInfo;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;

public class VamosDriverConfirmOrderSceneParam extends BaseVamosPageSceneParam {

    /* renamed from: a */
    private boolean f27100a;

    /* renamed from: b */
    private int f27101b;

    /* renamed from: c */
    private int f27102c;

    /* renamed from: d */
    private StartEndInfo f27103d;

    /* renamed from: e */
    private StartEndInfo f27104e;

    public boolean isDrawLine() {
        return this.f27100a;
    }

    public int getLineColor() {
        return this.f27101b;
    }

    public int getLineWidth() {
        return this.f27102c;
    }

    public StartEndInfo getStartInfo() {
        return this.f27103d;
    }

    public StartEndInfo getEndInfo() {
        return this.f27104e;
    }

    private VamosDriverConfirmOrderSceneParam(Builder builder) {
        super(builder);
        this.f27100a = builder.isDrawLine;
        this.f27101b = builder.lineColor;
        this.f27102c = builder.lineWidth;
        this.f27103d = builder.startInfo;
        this.f27104e = builder.endInfo;
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        /* access modifiers changed from: private */
        public StartEndInfo endInfo;
        /* access modifiers changed from: private */
        public boolean isDrawLine;
        /* access modifiers changed from: private */
        public int lineColor;
        /* access modifiers changed from: private */
        public int lineWidth;
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

        public Builder lineWidth(int i) {
            this.lineWidth = i;
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

        public VamosDriverConfirmOrderSceneParam build() {
            return new VamosDriverConfirmOrderSceneParam(this);
        }
    }
}
