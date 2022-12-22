package com.didi.map.global.flow.scene.vamos.orderwait.param;

import android.content.Context;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;
import com.didi.map.global.flow.scene.vamos.model.VamosMarkerModel;
import com.didi.map.global.flow.scene.vamos.model.VamosMultiLineModel;

public class VamosOrderWaitParams extends BaseVamosPageSceneParam {

    /* renamed from: a */
    private VamosMarkerModel f27123a;

    /* renamed from: b */
    private VamosMultiLineModel f27124b;

    /* renamed from: c */
    private IEtaEdaCallback f27125c;

    public VamosMarkerModel getVamosMarkerModel() {
        return this.f27123a;
    }

    public VamosMultiLineModel getVamosMultiLineModel() {
        return this.f27124b;
    }

    public IEtaEdaCallback getEtaEdaCallback() {
        return this.f27125c;
    }

    private VamosOrderWaitParams(Builder builder) {
        super(builder);
        this.f27125c = builder.etaEdaCallback;
        this.f27123a = builder.mVamosMarkerModel;
        this.f27124b = builder.mVamosMultiLineModel;
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        /* access modifiers changed from: private */
        public IEtaEdaCallback etaEdaCallback;
        /* access modifiers changed from: private */
        public VamosMarkerModel mVamosMarkerModel;
        /* access modifiers changed from: private */
        public VamosMultiLineModel mVamosMultiLineModel;

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

        public Builder vamosMarkerModel(VamosMarkerModel vamosMarkerModel) {
            this.mVamosMarkerModel = vamosMarkerModel;
            return this;
        }

        public Builder vamosMultiLineModel(VamosMultiLineModel vamosMultiLineModel) {
            this.mVamosMultiLineModel = vamosMultiLineModel;
            return this;
        }

        public Builder etaEdaCallback(IEtaEdaCallback iEtaEdaCallback) {
            this.etaEdaCallback = iEtaEdaCallback;
            return this;
        }

        public VamosOrderWaitParams build() {
            return new VamosOrderWaitParams(this);
        }
    }
}
