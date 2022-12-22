package com.didi.soda.compose.event;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;

public class ComposeStore extends Repo<ComposeAction> {
    public Subscription subscribe(ScopeContext scopeContext, Action<ComposeAction> action) {
        return from().shutViscidityNotice().subscribe(scopeContext, action);
    }
}
