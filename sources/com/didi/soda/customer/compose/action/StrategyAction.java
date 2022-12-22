package com.didi.soda.customer.compose.action;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ComposeActionEntity;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/customer/compose/action/StrategyAction;", "", "()V", "doStrategy", "", "strategyTarget", "Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo$Strategy;", "tag", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComposeActionType.kt */
public final class StrategyAction {
    public static final StrategyAction INSTANCE = new StrategyAction();

    private StrategyAction() {
    }

    public static /* synthetic */ boolean doStrategy$default(StrategyAction strategyAction, ComposeActionEntity.RetainInfo.Strategy strategy, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "doStrategy";
        }
        return strategyAction.doStrategy(strategy, str);
    }

    public final boolean doStrategy(ComposeActionEntity.RetainInfo.Strategy strategy, String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        if (strategy == null) {
            StrategyAction strategyAction = this;
            return true;
        }
        StrategyStore strategyStore = (StrategyStore) SingletonFactory.get(StrategyStore.class);
        StrategyConfig data = strategyStore.getData(strategy.getUniqueId());
        if (data == null || data.getMShowCount() < strategy.getNum() || System.currentTimeMillis() - data.getMBeginShowTime() >= ((long) (strategy.getCycle() * 86400 * 1000))) {
            if (data == null) {
                data = new StrategyConfig();
                data.setMUniqueId(strategy.getUniqueId());
                data.setMShowCount(1);
                data.setMBeginShowTime(System.currentTimeMillis());
            } else if (System.currentTimeMillis() - data.getMBeginShowTime() >= ((long) (strategy.getCycle() * 86400 * 1000))) {
                data.setMShowCount(1);
                data.setMBeginShowTime(System.currentTimeMillis());
            } else {
                data.setMShowCount(data.getMShowCount() + 1);
            }
            strategyStore.setData(strategy.getUniqueId(), data);
            return true;
        }
        LogUtil.m29104i(str, "dialog no show because hit strategy , config.mShowCount = " + data.getMShowCount() + "show time distance = " + (((System.currentTimeMillis() - data.getMBeginShowTime()) / ((long) 86400)) * ((long) 1000)));
        return false;
    }
}
