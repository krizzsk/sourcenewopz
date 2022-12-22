package com.didi.soda.bill.repo;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;

public class CartInfoConfirmRepo extends Repo<Integer> {
    public Subscription subscribe(ScopeContext scopeContext, Action<Integer> action) {
        return from().shutViscidityNotice().subscribe(scopeContext, action);
    }
}
