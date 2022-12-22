package com.didi.soda.jadux.function;

import com.didi.soda.jadux.AbsAction;
import p242io.reactivex.Single;

public interface DispatchFunction {
    Single<AbsAction> apply(AbsAction absAction);
}
