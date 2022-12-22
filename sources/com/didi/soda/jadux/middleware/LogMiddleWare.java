package com.didi.soda.jadux.middleware;

import com.didi.soda.jadux.AbsAction;
import com.didi.soda.jadux.Action;
import com.didi.soda.jadux.ActionFunction;
import com.didi.soda.jadux.function.DispatchFunction;
import com.didi.soda.jadux.function.MiddlewareInnerFunction;
import com.didi.soda.jadux.function.MiddwareFunction;
import com.didi.soda.jadux.function.StateFunction;
import p242io.reactivex.Single;

public class LogMiddleWare {
    public static MiddwareFunction createLogMiddleware() {
        return new MiddwareFunction() {
            public MiddlewareInnerFunction apply(DispatchFunction dispatchFunction, StateFunction stateFunction) {
                return new MiddlewareInnerFunction() {
                    public DispatchFunction apply(final DispatchFunction dispatchFunction) {
                        return new DispatchFunction() {
                            public Single<AbsAction> apply(AbsAction absAction) {
                                if (absAction instanceof Action) {
                                    return dispatchFunction.apply(absAction);
                                }
                                if (absAction instanceof ActionFunction) {
                                    throw new IllegalArgumentException("Please include ThunkMiddleware to deal with ActionFunction!");
                                }
                                throw new IllegalArgumentException("Action should be Action or ActionFunction!");
                            }
                        };
                    }
                };
            }
        };
    }
}
