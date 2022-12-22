package com.didi.map.global.flow.scene.vamos.orderpreview.param;

import android.content.Context;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;
import com.didi.map.global.flow.scene.vamos.model.VamosMarkerModel;
import com.didi.map.global.flow.scene.vamos.model.VamosMultiLineModel;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;

public class VamosOrderPreviewParams extends BaseVamosPageSceneParam {

    /* renamed from: a */
    private VamosMarkerModel f27109a;

    /* renamed from: b */
    private VamosMultiLineModel f27110b;

    /* renamed from: c */
    private float f27111c;

    /* renamed from: d */
    private IEtaEdaCallback f27112d;

    /* renamed from: e */
    private OrderInfo f27113e;

    public VamosMarkerModel getVamosMarkerModel() {
        return this.f27109a;
    }

    public VamosMultiLineModel getVamosMultiLineModel() {
        return this.f27110b;
    }

    public IEtaEdaCallback getEtaEdaCallback() {
        return this.f27112d;
    }

    public float getMaxMapZoomLevel() {
        return this.f27111c;
    }

    public OrderInfo getOrderInfo() {
        return this.f27113e;
    }

    private VamosOrderPreviewParams(Builder builder) {
        super(builder);
        this.f27111c = 16.7f;
        this.f27112d = builder.etaEdaCallback;
        this.f27111c = builder.mMaxMapZoomLevel;
        this.f27109a = builder.mVamosMarkerModel;
        this.f27110b = builder.mVamosMultiLineModel;
        this.f27113e = builder.orderInfo;
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        /* access modifiers changed from: private */
        public IEtaEdaCallback etaEdaCallback;
        /* access modifiers changed from: private */
        public float mMaxMapZoomLevel = 16.7f;
        /* access modifiers changed from: private */
        public VamosMarkerModel mVamosMarkerModel = new VamosMarkerModel();
        /* access modifiers changed from: private */
        public VamosMultiLineModel mVamosMultiLineModel = new VamosMultiLineModel();
        /* access modifiers changed from: private */
        public OrderInfo orderInfo;

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

        public Builder maxMapZoomLevel(float f) {
            this.mMaxMapZoomLevel = f;
            return this;
        }

        public Builder etaEdaCallback(IEtaEdaCallback iEtaEdaCallback) {
            this.etaEdaCallback = iEtaEdaCallback;
            return this;
        }

        public Builder orderInfo(OrderInfo orderInfo2) {
            this.orderInfo = orderInfo2;
            return this;
        }

        public VamosOrderPreviewParams build() {
            return new VamosOrderPreviewParams(this);
        }
    }
}
