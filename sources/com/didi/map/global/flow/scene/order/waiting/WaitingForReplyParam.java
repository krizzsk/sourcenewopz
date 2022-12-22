package com.didi.map.global.flow.scene.order.waiting;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.flow.model.AddressMarkerParam;
import com.didi.map.global.flow.model.StartEndMarkerModel;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;

public class WaitingForReplyParam extends PageSceneParam {

    /* renamed from: a */
    private final float f26954a;

    /* renamed from: b */
    private final StartEndMarkerModel f26955b;

    /* renamed from: c */
    private boolean f26956c;

    /* renamed from: d */
    private int f26957d;

    /* renamed from: e */
    private AddressMarkerParam f26958e;

    public float getZoomLevel() {
        return this.f26954a;
    }

    public StartEndMarkerModel getStartEndMarkerModel() {
        return this.f26955b;
    }

    public boolean isShowWalkLine() {
        return this.f26956c;
    }

    public int getDottedLineColor() {
        return this.f26957d;
    }

    private WaitingForReplyParam(Builder builder) {
        super(builder);
        this.f26954a = builder.zoomLevel;
        this.f26956c = builder.isShowWalkLine;
        this.f26957d = builder.dottedLineColor;
        AddressMarkerParam access$300 = builder.startParam;
        this.f26958e = access$300;
        this.f26955b = new StartEndMarkerModel(access$300.position, this.f26958e.name, this.f26958e.icon, this.f26958e.anchorU, this.f26958e.anchorV, (LatLng) null, (String) null, (Bitmap) null, 0.0f, 1.0f);
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public int dottedLineColor;
        /* access modifiers changed from: private */
        public boolean isShowWalkLine;
        /* access modifiers changed from: private */
        public AddressMarkerParam startParam;
        /* access modifiers changed from: private */
        public float zoomLevel;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder zoomLevel(float f) {
            this.zoomLevel = f;
            return this;
        }

        public Builder isShowWalkLine(boolean z) {
            this.isShowWalkLine = z;
            return this;
        }

        public Builder dottedLineColor(int i) {
            this.dottedLineColor = i;
            return this;
        }

        public Builder startParam(AddressMarkerParam addressMarkerParam) {
            this.startParam = addressMarkerParam;
            return this;
        }

        public WaitingForReplyParam build() {
            return new WaitingForReplyParam(this);
        }
    }
}
