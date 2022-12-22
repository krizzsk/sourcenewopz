package com.didi.global.fintech.cashier.model.strategy;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0007J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy;", "T", "", "handle", "Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy$Result;", "model", "(Ljava/lang/Object;)Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy$Result;", "Result", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseStrategy.kt */
public interface BaseStrategy<T> {

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy$Result;", "", "Ljava/io/Serializable;", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "CONTINUE", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BaseStrategy.kt */
    public enum Result implements Serializable {
        SUCCESS,
        FAILED,
        CONTINUE
    }

    Result handle(T t);
}
