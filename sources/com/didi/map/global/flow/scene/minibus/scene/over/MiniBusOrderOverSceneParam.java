package com.didi.map.global.flow.scene.minibus.scene.over;

import android.content.Context;
import android.view.View;
import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.minibus.MiniBusMarkerConfig;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.List;

public class MiniBusOrderOverSceneParam extends PageSceneParam {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MiniBusParamInterface f26375a;

    /* renamed from: b */
    private SceneOverType f26376b;

    /* renamed from: c */
    private View f26377c;

    /* renamed from: d */
    private OrderOverCommonTypeParam f26378d;

    public enum SceneOverType {
        WALKING_TYPE,
        COMMON_TYPE
    }

    private MiniBusOrderOverSceneParam(Builder builder) {
        super(builder);
        this.f26375a = builder.miniBusParamInterface;
        this.f26376b = builder.sceneType;
        this.f26377c = builder.endNavView;
        this.f26378d = builder.commonTypeParam;
    }

    public MiniBusParamInterface getMiniBusParamInterface() {
        return new MiniBusParamInterface() {
            public List<CommonLineParam> getMiniBusLineParam() {
                return MiniBusOrderOverSceneParam.this.f26375a.getMiniBusLineParam();
            }

            public List<CommonMarkerParam> getMiniBusMarkerParam() {
                return MiniBusMarkerConfig.getConfigMarkerParam(MiniBusOrderOverSceneParam.this.f26375a.getMiniBusMarkerParam());
            }
        };
    }

    public SceneOverType getSceneType() {
        return this.f26376b;
    }

    public View getEndNavView() {
        return this.f26377c;
    }

    public void setEndNavView(View view) {
        this.f26377c = view;
    }

    public OrderOverCommonTypeParam getCommonTypeParam() {
        return this.f26378d;
    }

    public static class OrderOverCommonTypeParam {
        private int bizType;
        private String clientVersion;
        private long driverId;
        private long endTime;
        private String orderId;
        private long startTime;

        public OrderOverCommonTypeParam(long j, int i, long j2, long j3, String str, String str2) {
            this.driverId = j;
            this.bizType = i;
            this.startTime = j2;
            this.endTime = j3;
            this.orderId = str;
            this.clientVersion = str2;
        }

        public long getDriverId() {
            return this.driverId;
        }

        public int getBizType() {
            return this.bizType;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public String getClientVersion() {
            return this.clientVersion;
        }

        public String toString() {
            return "OrderOverCommonTypeParam{driverId=" + this.driverId + ", bizType=" + this.bizType + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", orderId='" + this.orderId + '\'' + ", clientVersion='" + this.clientVersion + '\'' + '}';
        }
    }

    public void systemOutLog() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("MiniBusOrderOverSceneParam{, sceneType=");
        sb.append(this.f26376b);
        sb.append(", endNavView=");
        sb.append(this.f26377c);
        sb.append(", commonTypeParam=");
        OrderOverCommonTypeParam orderOverCommonTypeParam = this.f26378d;
        if (orderOverCommonTypeParam == null) {
            str = "";
        } else {
            str = orderOverCommonTypeParam.toString();
        }
        sb.append(str);
        sb.append('}');
        DLog.m7384d("MiniBusOrderOverSceneParam", sb.toString(), new Object[0]);
        toString();
    }

    public String toString() {
        if (this.f26375a == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("marker参数内容");
        for (CommonMarkerParam next : getMiniBusParamInterface().getMiniBusMarkerParam()) {
            if (next != null) {
                sb.append(next.toString());
            }
        }
        DLog.m7384d("MiniBusOrderOverSceneParam->marker->", sb.toString(), new Object[0]);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("line参数内容");
        for (CommonLineParam next2 : this.f26375a.getMiniBusLineParam()) {
            if (next2 != null) {
                sb2.append(next2.toString());
            }
        }
        DLog.m7384d("MiniBusOrderOverSceneParam->line->->", sb2.toString(), new Object[0]);
        return "";
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public OrderOverCommonTypeParam commonTypeParam;
        /* access modifiers changed from: private */
        public View endNavView;
        /* access modifiers changed from: private */
        public MiniBusParamInterface miniBusParamInterface;
        /* access modifiers changed from: private */
        public SceneOverType sceneType;

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

        public Builder sceneType(SceneOverType sceneOverType) {
            this.sceneType = sceneOverType;
            return this;
        }

        public Builder endNavView(View view) {
            this.endNavView = view;
            return this;
        }

        public Builder commonTypeParam(OrderOverCommonTypeParam orderOverCommonTypeParam) {
            this.commonTypeParam = orderOverCommonTypeParam;
            return this;
        }

        public MiniBusOrderOverSceneParam build() {
            return new MiniBusOrderOverSceneParam(this);
        }
    }
}
