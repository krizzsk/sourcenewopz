package com.didi.nova.assembly.components.recyclerview;

import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.mark.ItemDraggable;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaGridLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.nova.assembly.components.recyclerview.BaseRecyclerPresenter;

public abstract class BaseRecyclerView<P extends BaseRecyclerPresenter> extends IView<P> {
    private boolean mInitialized = false;
    private INovaLayoutManager mNovaLayoutManager;
    private NovaRecyclerView mNovaRecyclerView;
    private NovaRecyclerAdapter mRecyclerAdapter;

    /* access modifiers changed from: protected */
    public abstract INovaRecyclerView generateNovaRecyclerView();

    /* access modifiers changed from: protected */
    public abstract void initItemBinders();

    /* access modifiers changed from: protected */
    public void setupNovaLayoutManager(INovaLayoutManager iNovaLayoutManager) {
    }

    /* access modifiers changed from: protected */
    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
    }

    /* access modifiers changed from: protected */
    public boolean useLinearLayout() {
        return false;
    }

    public void onCreate() {
        super.onCreate();
        initNovaRecyclerView();
    }

    public void onPause() {
        super.onPause();
        this.mNovaLayoutManager.release();
    }

    private void initNovaRecyclerView() {
        INovaRecyclerView generateNovaRecyclerView = generateNovaRecyclerView();
        if (generateNovaRecyclerView instanceof NovaRecyclerView) {
            this.mNovaRecyclerView = (NovaRecyclerView) generateNovaRecyclerView;
            this.mRecyclerAdapter = new NovaRecyclerAdapter();
            initItemBinders();
            INovaLayoutManager generateNovaLayoutManager = generateNovaLayoutManager();
            this.mNovaLayoutManager = generateNovaLayoutManager;
            setupNovaLayoutManager(generateNovaLayoutManager);
            this.mNovaRecyclerView.setAdapter(this.mRecyclerAdapter);
            this.mNovaRecyclerView.setNovaLayoutManager(this.mNovaLayoutManager);
            setupNovaRecyclerView(this.mNovaRecyclerView);
            this.mInitialized = true;
            return;
        }
        throw new IllegalStateException("Result of generateNovaRecyclerView must be instanceof NovaRecyclerView");
    }

    /* access modifiers changed from: protected */
    public INovaLayoutManager generateNovaLayoutManager() {
        if (useLinearLayout()) {
            return new NovaLinearLayoutManager(getContext());
        }
        return new NovaGridLayoutManager(getContext());
    }

    /* access modifiers changed from: protected */
    public final void registerBinder(ItemBinder itemBinder) {
        if (!this.mInitialized) {
            if (itemBinder instanceof ItemDraggable) {
                itemBinder.setItemDragListener(this.mNovaRecyclerView);
            }
            this.mRecyclerAdapter.registerBinder(itemBinder);
            return;
        }
        throw new IllegalStateException("RecyclerAdapter has Attached To WrapperAdapter, disable for registerBinder. itemBinder = " + itemBinder);
    }

    public final NovaRecyclerView getNovaRecyclerView() {
        return this.mNovaRecyclerView;
    }

    /* access modifiers changed from: package-private */
    public final NovaRecyclerAdapter getNovaRecyclerAdapter() {
        return this.mRecyclerAdapter;
    }

    public final INovaLayoutManager getNovaLayoutManager() {
        return this.mNovaLayoutManager;
    }
}
