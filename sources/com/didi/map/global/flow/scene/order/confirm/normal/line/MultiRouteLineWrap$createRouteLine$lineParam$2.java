package com.didi.map.global.flow.scene.order.confirm.normal.line;

import com.didi.map.global.flow.scene.order.confirm.component.LineParam;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineShowListener;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/confirm/normal/line/MultiRouteLineWrap$createRouteLine$lineParam$2", "Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineShowListener;", "show", "", "multiLine", "", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MultiRouteLineWrap.kt */
public final class MultiRouteLineWrap$createRouteLine$lineParam$2 implements ILineShowListener {
    final /* synthetic */ MultiRouteLineWrap this$0;

    MultiRouteLineWrap$createRouteLine$lineParam$2(MultiRouteLineWrap multiRouteLineWrap) {
        this.this$0 = multiRouteLineWrap;
    }

    public void show(boolean z, boolean z2) {
        long j;
        if (z && z2) {
            List access$getMLineParams$p = this.this$0.f26701n;
            String str = null;
            Integer valueOf = access$getMLineParams$p == null ? null : Integer.valueOf(access$getMLineParams$p.size());
            if (valueOf != null && valueOf.intValue() == 2) {
                List access$getMLineParams$p2 = this.this$0.f26701n;
                LineParam lineParam = access$getMLineParams$p2 == null ? null : (LineParam) access$getMLineParams$p2.get(0);
                List access$getMLineParams$p3 = this.this$0.f26701n;
                LineParam lineParam2 = access$getMLineParams$p3 == null ? null : (LineParam) access$getMLineParams$p3.get(1);
                long j2 = 0;
                if (lineParam == null) {
                    j = 0;
                } else {
                    j = lineParam.getLineId();
                }
                String lineBubbleContent = lineParam == null ? null : lineParam.getLineBubbleContent();
                if (lineParam2 != null) {
                    j2 = lineParam2.getLineId();
                }
                long j3 = j2;
                if (lineParam2 != null) {
                    str = lineParam2.getLineBubbleContent();
                }
                MapFlowOmegaUtil.onOptionLineShow(j, lineBubbleContent, j3, str, this.this$0.f26704q);
            }
        }
    }
}
