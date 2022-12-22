package com.didi.soda.datasource.page.dynamic;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.scope.BlockScopeBase;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.datasource.page.PageParams;
import com.didi.soda.datasource.page.dynamic.DynamicBaseEntity;
import com.didi.soda.datasource.page.dynamic.DynamicRecycleView;

public abstract class DynamicRecyclePresenter<V extends DynamicRecycleView, Params extends PageParams, Result extends DynamicBaseEntity> extends CustomerRecyclerPresenter<V> {
    private DynamicDataSource<Params, Result> mDataSource = null;
    private IBlockScope scope = null;

    public abstract DynamicDataSource<Params, Result> createDataSource(ScopeContext scopeContext);

    /* access modifiers changed from: protected */
    public void registerScopeActions(IBlockScope iBlockScope) {
    }

    public void onCreate() {
        super.onCreate();
        this.mDataSource = createDataSource(getScopeContext());
        registerScopeActions(getScope());
    }

    public DynamicDataSource<Params, Result> getDataSource() {
        return this.mDataSource;
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
