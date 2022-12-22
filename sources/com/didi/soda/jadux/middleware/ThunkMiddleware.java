package com.didi.soda.jadux.middleware;

import com.didi.soda.jadux.AbsAction;
import com.didi.soda.jadux.Action;
import com.didi.soda.jadux.ActionFunction;
import com.didi.soda.jadux.function.DispatchFunction;
import com.didi.soda.jadux.function.MiddlewareInnerFunction;
import com.didi.soda.jadux.function.MiddwareFunction;
import com.didi.soda.jadux.function.StateFunction;
import p242io.reactivex.Single;

public class ThunkMiddleware {
    public static MiddwareFunction createThunkMiddleware() {
        return new MiddwareFunction() {
            public MiddlewareInnerFunction apply(final DispatchFunction dispatchFunction, final StateFunction stateFunction) {
                return new MiddlewareInnerFunction() {
                    public DispatchFunction apply(final DispatchFunction dispatchFunction) {
                        return new DispatchFunction() {
                            public Single<AbsAction> apply(AbsAction absAction) {
                                if (absAction instanceof Action) {
                                    return dispatchFunction.apply(absAction);
                                }
                                if (absAction instanceof ActionFunction) {
                                    ((ActionFunction) absAction).apply(dispatchFunction, stateFunction);
                                    return null;
                                }
                                throw new IllegalArgumentException("Action type should be Action or ActionFunction!");
                            }
                        };
                    }
                };
            }
        };
    }
}
