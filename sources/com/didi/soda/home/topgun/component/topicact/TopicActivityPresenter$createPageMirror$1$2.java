package com.didi.soda.home.topgun.component.topicact;

import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActivityPresenter.kt */
/* synthetic */ class TopicActivityPresenter$createPageMirror$1$2 extends FunctionReferenceImpl implements Function2<Integer, ActivityInfoEntity, Unit> {
    TopicActivityPresenter$createPageMirror$1$2(Object obj) {
        super(2, obj, TopicActivityPresenter.class, "onPageMirrorPlayBack", "onPageMirrorPlayBack(ILcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;)V", 0);
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (ActivityInfoEntity) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, ActivityInfoEntity activityInfoEntity) {
        ((TopicActivityPresenter) this.receiver).onPageMirrorPlayBack(i, activityInfoEntity);
    }
}
