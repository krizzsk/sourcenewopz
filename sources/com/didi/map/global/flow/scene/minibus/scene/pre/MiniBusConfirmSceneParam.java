package com.didi.map.global.flow.scene.minibus.scene.pre;

import android.content.Context;
import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.minibus.MiniBusMarkerConfig;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.List;

public class MiniBusConfirmSceneParam extends PageSceneParam {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MiniBusParamInterface f26382a;

    private MiniBusConfirmSceneParam(Builder builder) {
        super(builder);
        this.f26382a = builder.miniBusParamInterface;
    }

    public MiniBusParamInterface getMiniBusParamInterface() {
        return new MiniBusParamInterface() {
            public List<CommonLineParam> getMiniBusLineParam() {
                return MiniBusConfirmSceneParam.this.f26382a.getMiniBusLineParam();
            }

            public List<CommonMarkerParam> getMiniBusMarkerParam() {
                return MiniBusMarkerConfig.getConfigMarkerParam(MiniBusConfirmSceneParam.this.f26382a.getMiniBusMarkerParam());
            }
        };
    }

    public void systemOutLog() {
        if (this.f26382a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("marker参数内容");
            for (CommonMarkerParam next : getMiniBusParamInterface().getMiniBusMarkerParam()) {
                if (next != null) {
                    sb.append(next.toString());
                }
            }
            DLog.m7384d("MiniBusConfirmSceneParam->marker->", sb.toString(), new Object[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("line参数内容");
            for (CommonLineParam next2 : getMiniBusParamInterface().getMiniBusLineParam()) {
                if (next2 != null) {
                    sb2.append(next2.toString());
                }
            }
            DLog.m7384d("MiniBusConfirmSceneParam->line->->", sb2.toString(), new Object[0]);
        }
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public MiniBusParamInterface miniBusParamInterface;

        public Builder miniBusParamInterface(MiniBusParamInterface miniBusParamInterface2) {
            this.miniBusParamInterface = miniBusParamInterface2;
            return this;
        }

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public MiniBusConfirmSceneParam build() {
            return new MiniBusConfirmSceneParam(this);
        }
    }
}
