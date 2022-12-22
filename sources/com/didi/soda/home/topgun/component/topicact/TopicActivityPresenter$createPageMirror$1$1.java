package com.didi.soda.home.topgun.component.topicact;

import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActivityPresenter.kt */
/* synthetic */ class TopicActivityPresenter$createPageMirror$1$1 extends FunctionReferenceImpl implements Function5<Integer, String, ActivityInfoEntity, SFRpcException, Boolean, Unit> {
    TopicActivityPresenter$createPageMirror$1$1(Object obj) {
        super(5, obj, TopicActivityPresenter.class, "onPageResult", "onPageResult(ILjava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;Z)V", 0);
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        invoke(((Number) obj).intValue(), (String) obj2, (ActivityInfoEntity) obj3, (SFRpcException) obj4, ((Boolean) obj5).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, String str, ActivityInfoEntity activityInfoEntity, SFRpcException sFRpcException, boolean z) {
        ((TopicActivityPresenter) this.receiver).onPageResult(i, str, activityInfoEntity, sFRpcException, z);
    }
}
