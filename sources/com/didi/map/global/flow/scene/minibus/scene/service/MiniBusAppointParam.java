package com.didi.map.global.flow.scene.minibus.scene.service;

import android.content.Context;
import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.minibus.MiniBusMarkerConfig;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.List;

public class MiniBusAppointParam extends PageSceneParam {

    /* renamed from: a */
    private MiniBusTripSceneState f26395a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MiniBusParamInterface f26396b;

    private MiniBusAppointParam(Builder builder) {
        super(builder);
        this.f26396b = builder.miniBusParamInterface;
        this.f26395a = builder.sceneState;
    }

    public MiniBusTripSceneState getSceneState() {
        return this.f26395a;
    }

    public MiniBusParamInterface getMiniBusParamInterface() {
        return new MiniBusParamInterface() {
            public List<CommonLineParam> getMiniBusLineParam() {
                return MiniBusAppointParam.this.f26396b.getMiniBusLineParam();
            }

            public List<CommonMarkerParam> getMiniBusMarkerParam() {
                return MiniBusMarkerConfig.getConfigMarkerParam(MiniBusAppointParam.this.f26396b.getMiniBusMarkerParam());
            }
        };
    }

    public void systemOutLog() {
        if (this.f26396b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("marker参数内容");
            for (CommonMarkerParam next : getMiniBusParamInterface().getMiniBusMarkerParam()) {
                if (next != null) {
                    sb.append(next.toString());
                }
            }
            DLog.m7384d("MiniBusAppointParam->marker->", sb.toString(), new Object[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("line参数内容");
            for (CommonLineParam next2 : getMiniBusParamInterface().getMiniBusLineParam()) {
                if (next2 != null) {
                    sb2.append(next2.toString());
                }
            }
            DLog.m7384d("MiniBusAppointParam->line->->", sb2.toString(), new Object[0]);
        }
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public MiniBusParamInterface miniBusParamInterface;
        /* access modifiers changed from: private */
        public MiniBusTripSceneState sceneState;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder miniBusParamInterface(MiniBusParamInterface miniBusParamInterface2) {
            this.miniBusParamInterface = miniBusParamInterface2;
            return this;
        }

        public Builder sceneState(MiniBusTripSceneState miniBusTripSceneState) {
            this.sceneState = miniBusTripSceneState;
            return this;
        }

        public MiniBusAppointParam build() {
            return new MiniBusAppointParam(this);
        }
    }
}
