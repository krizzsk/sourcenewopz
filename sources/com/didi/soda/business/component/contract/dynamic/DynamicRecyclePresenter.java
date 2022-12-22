package com.didi.soda.business.component.contract.dynamic;

import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.scope.BlockScopeBase;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.business.component.contract.dynamic.DynamicRecycleView;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;

public abstract class DynamicRecyclePresenter<V extends DynamicRecycleView> extends CustomerRecyclerPresenter<V> {
    private IBlockScope scope = null;

    /* access modifiers changed from: protected */
    public void registerScopeActions(IBlockScope iBlockScope) {
    }

    public void onCreate() {
        super.onCreate();
        registerScopeActions(getScope());
    }

    public IBlockScope getScope() {
        if (this.scope == null) {
            BlockScopeBase createBlockScope = BlocksEngine.Companion.getInstance().createBlockScope();
            this.scope = createBlockScope;
            createBlockScope.attach(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT, getScopeContext());
        }
        return this.scope;
    }
}
