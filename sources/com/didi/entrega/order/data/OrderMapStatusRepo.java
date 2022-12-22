package com.didi.entrega.order.data;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.entrega.order.data.model.OrderMapStatusModel;

public class OrderMapStatusRepo extends Repo<OrderMapStatusModel> {
    public Subscription subscribe(ScopeContext scopeContext, Action<OrderMapStatusModel> action) {
        return from().shutViscidityNotice().subscribe(scopeContext, action);
    }
}
