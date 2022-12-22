package com.didi.app.nova.support.view.recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemBinder;
import com.didi.app.nova.support.view.recyclerview.listener.ItemDragListener;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.helper.NovaItemTouchHelper;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;

public class NovaRecyclerView extends RecyclerView implements ItemDragListener, INovaRecyclerView {

    /* renamed from: a */
    private boolean f8615a = false;

    /* renamed from: b */
    private boolean f8616b = false;

    /* renamed from: c */
    private int f8617c = 1;

    /* renamed from: d */
    private boolean f8618d = false;

    /* renamed from: e */
    private INovaLayoutManager f8619e;

    /* renamed from: f */
    private NovaRecyclerAdapter f8620f;

    /* renamed from: g */
    private OnLoadMoreScrollListener f8621g;

    /* renamed from: h */
    private ItemTouchHelper f8622h;

    /* renamed from: i */
    private NovaItemTouchHelper f8623i;

    /* renamed from: j */
    private MvpItemBinder.NovaOnChildAttachStateChangeListener f8624j;

    /* renamed from: k */
    private MvpItemBinder.NovaRecyclerListener f8625k;

    /* renamed from: l */
    private ItemDecorationManager f8626l;

    public NovaRecyclerView(Context context) {
        super(context);
        m5745a();
    }

    public NovaRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5745a();
    }

    public NovaRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5745a();
    }

    /* renamed from: a */
    private void m5745a() {
        this.f8621g = new OnLoadMoreScrollListener();
        this.f8624j = new MvpItemBinder.NovaOnChildAttachStateChangeListener(this);
        this.f8625k = new MvpItemBinder.NovaRecyclerListener(this);
    }

    public void setNovaLayoutManager(INovaLayoutManager iNovaLayoutManager) {
        if (iNovaLayoutManager instanceof RecyclerView.LayoutManager) {
            setLayoutManager((RecyclerView.LayoutManager) iNovaLayoutManager);
            return;
        }
        throw new IllegalStateException("novaLayoutManager must be instance of LayoutManager");
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof INovaLayoutManager) {
            INovaLayoutManager iNovaLayoutManager = (INovaLayoutManager) layoutManager;
            this.f8619e = iNovaLayoutManager;
            NovaRecyclerAdapter novaRecyclerAdapter = this.f8620f;
            if (novaRecyclerAdapter != null) {
                iNovaLayoutManager.init(novaRecyclerAdapter);
            }
            super.setLayoutManager(layoutManager);
            return;
        }
        throw new IllegalStateException("NovaRecyclerView only accept INovaLayoutManager");
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof NovaRecyclerAdapter) {
            NovaRecyclerAdapter novaRecyclerAdapter = (NovaRecyclerAdapter) adapter;
            this.f8620f = novaRecyclerAdapter;
            INovaLayoutManager iNovaLayoutManager = this.f8619e;
            if (iNovaLayoutManager != null) {
                iNovaLayoutManager.init(novaRecyclerAdapter);
            }
            super.setAdapter(this.f8620f);
            return;
        }
        throw new IllegalStateException("NovaRecyclerView only accept NovaRecyclerAdapter");
    }

    public void setFootLoadMoreEnable(boolean z) {
        if (this.f8616b != z) {
            this.f8616b = z;
            if (z) {
                removeOnScrollListener(this.f8621g);
                addOnScrollListener(this.f8621g);
                return;
            }
            removeOnScrollListener(this.f8621g);
        }
    }

    public boolean isScrollable() {
        INovaLayoutManager iNovaLayoutManager = this.f8619e;
        return iNovaLayoutManager != null && iNovaLayoutManager.findFirstCompletelyVisibleItemPosition() > 0;
    }

    public void setLoadMoreListener(INovaRecyclerView.LoadMoreListener loadMoreListener) {
        this.f8621g.setLoadMoreListener(loadMoreListener);
        this.f8620f.setPreLoadMoreListener(loadMoreListener);
    }

    public void setPreLoadNumber(int i) {
        this.f8617c = i;
        this.f8620f.setPreLoadNumber(i);
    }

    public boolean isAutoPreLoad() {
        return this.f8617c > 1;
    }

    public final ItemDecorationManager getItemDecorationManager() {
        if (this.f8626l == null) {
            this.f8626l = new ItemDecorationManager(this.f8620f);
        }
        return this.f8626l;
    }

    public void setItemDecorationEnable(boolean z) {
        if (this.f8615a != z) {
            if (z) {
                addItemDecoration(getItemDecorationManager());
            } else {
                removeItemDecoration(getItemDecorationManager());
            }
            this.f8615a = z;
        }
    }

    public void setItemTouchControlEnable(boolean z) {
        if (z) {
            if (this.f8623i == null) {
                this.f8623i = new NovaItemTouchHelper();
            }
            this.f8623i.attachToRecyclerView(this);
            return;
        }
        NovaItemTouchHelper novaItemTouchHelper = this.f8623i;
        if (novaItemTouchHelper != null) {
            novaItemTouchHelper.detachToRecyclerView();
        }
    }

    public void setItemDragEnable(boolean z) {
        if (z) {
            if (this.f8622h == null) {
                this.f8622h = new ItemTouchHelper(new C3792a(this.f8620f));
            }
            this.f8622h.attachToRecyclerView(this);
            return;
        }
        ItemTouchHelper itemTouchHelper = this.f8622h;
        if (itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView((RecyclerView) null);
        }
    }

    public void setItemMvpEnable(boolean z) {
        if (this.f8618d != z) {
            this.f8618d = z;
            if (z) {
                addOnChildAttachStateChangeListener(this.f8624j);
                super.setRecyclerListener(this.f8625k);
            } else {
                removeOnChildAttachStateChangeListener(this.f8624j);
                if (!this.f8625k.hasRecyclerListener()) {
                    super.setRecyclerListener((RecyclerView.RecyclerListener) null);
                }
            }
            this.f8625k.setItemMvpEnable(z);
        }
    }

    public void setRecyclerListener(RecyclerView.RecyclerListener recyclerListener) {
        if (recyclerListener == null && !this.f8618d) {
            super.setRecyclerListener((RecyclerView.RecyclerListener) null);
        }
        this.f8625k.setRecyclerListener(recyclerListener);
        super.setRecyclerListener(this.f8625k);
    }

    public void smoothScrollToItem(Object obj) {
        int itemPositionForItem = this.f8620f.getItemPositionForItem(obj);
        if (itemPositionForItem >= 0) {
            super.smoothScrollToPosition(itemPositionForItem);
        }
    }

    public void scrollToItem(Object obj) {
        RecyclerView.LayoutManager layoutManager;
        int itemPositionForItem = this.f8620f.getItemPositionForItem(obj);
        if (itemPositionForItem >= 0 && (layoutManager = getLayoutManager()) != null) {
            layoutManager.scrollToPosition(itemPositionForItem);
        }
    }

    public void startDrag(ItemViewHolder itemViewHolder) {
        ItemTouchHelper itemTouchHelper = this.f8622h;
        if (itemTouchHelper != null) {
            itemTouchHelper.startDrag(itemViewHolder);
        }
    }

    private class OnLoadMoreScrollListener extends RecyclerView.OnScrollListener {
        private INovaRecyclerView.LoadMoreListener mLoadMoreListener;

        private OnLoadMoreScrollListener() {
        }

        /* access modifiers changed from: package-private */
        public void setLoadMoreListener(INovaRecyclerView.LoadMoreListener loadMoreListener) {
            this.mLoadMoreListener = loadMoreListener;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (recyclerView.getLayoutManager().getChildCount() > 0 && i == 0 && canTriggerLoadMore(recyclerView)) {
                onLoadMore();
            }
        }

        private boolean canTriggerLoadMore(RecyclerView recyclerView) {
            if (recyclerView.getLayoutManager() instanceof INovaLayoutManager) {
                INovaLayoutManager iNovaLayoutManager = (INovaLayoutManager) recyclerView.getLayoutManager();
                return iNovaLayoutManager.getItemCount() - 1 == iNovaLayoutManager.findLastVisibleItemPosition();
            }
            throw new IllegalStateException("novaLayoutManager must be instance of LayoutManager");
        }

        public void onLoadMore() {
            INovaRecyclerView.LoadMoreListener loadMoreListener = this.mLoadMoreListener;
            if (loadMoreListener != null) {
                loadMoreListener.onLoadMore();
            }
        }
    }
}
