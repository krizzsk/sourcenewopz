package com.didiglobal.travel.biz.callback;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"simpleRespListener", "Lcom/didi/travel/psnger/common/net/base/ResponseListener;", "T", "Lcom/didi/travel/psnger/common/net/base/BaseObject;", "Lcom/didiglobal/travel/biz/callback/LoadCallbackWrapper;", "common_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LoadCallbackWrapper.kt */
public final class LoadCallbackWrapperKt {
    public static final <T extends BaseObject> ResponseListener<T> simpleRespListener(LoadCallbackWrapper<T> loadCallbackWrapper) {
        Intrinsics.checkNotNullParameter(loadCallbackWrapper, "<this>");
        return new LoadCallbackWrapperKt$simpleRespListener$1(loadCallbackWrapper);
    }
}
