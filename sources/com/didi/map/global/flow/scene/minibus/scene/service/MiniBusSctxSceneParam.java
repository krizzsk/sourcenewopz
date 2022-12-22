package com.didi.map.global.flow.scene.minibus.scene.service;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.minibus.MiniBusMarkerConfig;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.order.serving.IOraOrderStageCallback;
import com.didi.map.global.flow.scene.order.serving.ISctxStateCallback;
import com.didi.map.global.flow.scene.order.serving.param.ClientParams;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.List;

public class MiniBusSctxSceneParam extends PageSceneParam {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MiniBusSctxParamInterface f26408a;

    /* renamed from: b */
    private IEtaEdaCallback f26409b;

    /* renamed from: c */
    private ISctxStateCallback f26410c;

    /* renamed from: d */
    private IOraOrderStageCallback f26411d;

    private MiniBusSctxSceneParam(Builder builder) {
        super(builder);
        this.f26408a = builder.paramInterface;
        this.f26409b = builder.etaEdaCallback;
        this.f26410c = builder.sctxStateCallback;
        this.f26411d = builder.oraSyncOrderStageCallback;
    }

    public MiniBusSctxParamInterface getParamInterface() {
        if (this.f26408a == null) {
            return null;
        }
        return new MiniBusSctxParamInterface() {
            public OrderParams getOrderParams() {
                return MiniBusSctxSceneParam.this.f26408a.getOrderParams();
            }

            public ICarBitmapDescriptor getCarMarkerBitmap() {
                return MiniBusSctxSceneParam.this.f26408a.getCarMarkerBitmap();
            }

            public ClientParams getClientParam() {
                return MiniBusSctxSceneParam.this.f26408a.getClientParam();
            }

            public List<CommonMarkerParam> getMarkerParams() {
                return MiniBusMarkerConfig.getConfigMarkerParam(MiniBusSctxSceneParam.this.f26408a.getMarkerParams());
            }

            public List<CommonLineParam> getLineParams() {
                return MiniBusSctxSceneParam.this.f26408a.getLineParams();
            }

            public Bitmap getWayPointIcon() {
                return MiniBusSctxSceneParam.this.f26408a.getWayPointIcon();
            }

            public MiniBusStreetParam getStreetParam() {
                return MiniBusSctxSceneParam.this.f26408a.getStreetParam();
            }
        };
    }

    public IEtaEdaCallback getEtaEdaCallback() {
        return this.f26409b;
    }

    public ISctxStateCallback getSctxStateCallback() {
        return this.f26410c;
    }

    public IOraOrderStageCallback getOraSyncOrderStageCallback() {
        return this.f26411d;
    }

    public void systemOutLog() {
        if (this.f26408a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("marker参数内容");
            for (CommonMarkerParam next : this.f26408a.getMarkerParams()) {
                if (next != null) {
                    sb.append(next.toString());
                }
            }
            DLog.m7384d("MiniBusSctxSceneParam->marker->", sb.toString(), new Object[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("line 参数内容");
            for (CommonLineParam next2 : this.f26408a.getLineParams()) {
                if (next2 != null) {
                    sb2.append(next2.toString());
                }
            }
            DLog.m7384d("MiniBusSctxSceneParam->line->", sb2.toString(), new Object[0]);
            StringBuilder sb3 = new StringBuilder();
            String str = "";
            sb3.append(str);
            sb3.append(this.f26408a.getCarMarkerBitmap());
            DLog.m7384d("MiniBusSctxSceneParam->carBitmap->", sb3.toString(), new Object[0]);
            DLog.m7384d("MiniBusSctxSceneParam->waypointIcon->", str + this.f26408a.getWayPointIcon(), new Object[0]);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(this.f26408a.getOrderParams() == null ? str : this.f26408a.getOrderParams().toString());
            DLog.m7384d("MiniBusSctxSceneParam->orderParam->", sb4.toString(), new Object[0]);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            if (this.f26408a.getClientParam() != null) {
                str = this.f26408a.getClientParam().toString();
            }
            sb5.append(str);
            DLog.m7384d("MiniBusSctxSceneParam->clientParam->", sb5.toString(), new Object[0]);
        }
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public IEtaEdaCallback etaEdaCallback;
        /* access modifiers changed from: private */
        public IOraOrderStageCallback oraSyncOrderStageCallback;
        /* access modifiers changed from: private */
        public MiniBusSctxParamInterface paramInterface;
        /* access modifiers changed from: private */
        public ISctxStateCallback sctxStateCallback;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder paramInterface(MiniBusSctxParamInterface miniBusSctxParamInterface) {
            this.paramInterface = miniBusSctxParamInterface;
            return this;
        }

        public Builder etaEdaCallback(IEtaEdaCallback iEtaEdaCallback) {
            this.etaEdaCallback = iEtaEdaCallback;
            return this;
        }

        public Builder sctxStateCallback(ISctxStateCallback iSctxStateCallback) {
            this.sctxStateCallback = iSctxStateCallback;
            return this;
        }

        public Builder oraSyncOrderStageCallback(IOraOrderStageCallback iOraOrderStageCallback) {
            this.oraSyncOrderStageCallback = iOraOrderStageCallback;
            return this;
        }

        public MiniBusSctxSceneParam build() {
            return new MiniBusSctxSceneParam(this);
        }
    }
}
