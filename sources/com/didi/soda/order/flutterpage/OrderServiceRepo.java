package com.didi.soda.order.flutterpage;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;

public class OrderServiceRepo extends Repo<OrderServiceType> {
    public Subscription subscribe(ScopeContext scopeContext, Action<OrderServiceType> action) {
        return from().shutViscidityNotice().subscribe(scopeContext, action);
    }

    public enum OrderServiceType {
        NONE(0);

        private OrderServiceType(int i) {
        }
    }
}
