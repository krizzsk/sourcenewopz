package com.didi.soda.customer.component.flutterordermap.data;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;

public class OrderMapStatusRepo extends Repo<OrderMapStatusModel> {
    public Subscription subscribe(ScopeContext scopeContext, Action<OrderMapStatusModel> action) {
        return from().shutViscidityNotice().subscribe(scopeContext, action);
    }
}
