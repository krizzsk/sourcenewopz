package com.didi.map.global.flow.scene.order.confirm.component;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.flow.scene.order.confirm.component.CalculateTask;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/confirm/component/MultiLineComponent$start$1", "Lcom/didi/map/global/flow/scene/order/confirm/component/CalculateTask$CalculateTaskCallBack;", "onCalculateSuccess", "", "result", "Ljava/util/HashMap;", "", "Lcom/didi/common/map/model/LatLng;", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MultiLineComponent.kt */
public final class MultiLineComponent$start$1 implements CalculateTask.CalculateTaskCallBack {
    final /* synthetic */ MultiLineComponent this$0;

    MultiLineComponent$start$1(MultiLineComponent multiLineComponent) {
        this.this$0 = multiLineComponent;
    }

    public void onCalculateSuccess(HashMap<Long, LatLng> hashMap) {
        SystemUtils.log(6, "CollideStrategyV2", "异步计算锚点 结束", (Throwable) null, "com.didi.map.global.flow.scene.order.confirm.component.MultiLineComponent$start$1", 224);
        this.this$0.m18836a(hashMap);
    }
}
