package com.didi.component.framework.template;

import com.didi.component.business.util.BusinessDataUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.p205sa.biz.component.mapflow.IProductId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider({IProductId.class})
@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/component/framework/template/SaProductIdGetter;", "Lcom/didiglobal/sa/biz/component/mapflow/IProductId;", "()V", "getProductId", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SaProductIdGetter.kt */
public final class SaProductIdGetter implements IProductId {
    public String getProductId() {
        String productId = BusinessDataUtil.getProductId();
        Intrinsics.checkNotNullExpressionValue(productId, "getProductId()");
        return productId;
    }
}
