package com.didi.app.nova.support.view.recyclerview.binder.mvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemUnit;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import java.util.HashMap;
import java.util.List;

public abstract class MvpItemBinder<T, VH extends ItemViewHolder<T>, U extends MvpItemUnit> extends ItemBinder<T, VH> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HashMap<RecyclerView.ViewHolder, U> f8596a = new HashMap<>();

    /* access modifiers changed from: protected */
    public abstract Class<VH> bindHolderType();

    /* access modifiers changed from: protected */
    public abstract int getItemViewLayoutId();

    /* access modifiers changed from: protected */
    public abstract U onCreateItemUnit();

    /* access modifiers changed from: protected */
    public abstract RvLifecycleObservable onCreateRvContainerLifecycle();

    /* access modifiers changed from: protected */
    public void setupItemUnit(U u) {
    }

    public MvpItemBinder() {
        m5708a();
    }

    public MvpItemBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
        m5708a();
    }

    /* renamed from: a */
    private void m5708a() {
        onCreateRvContainerLifecycle().subscribe(new RvLifecycleObserver() {
            public void onAttach() {
                for (MvpItemUnit mvpItemUnit : MvpItemBinder.this.f8596a.values()) {
                    if (mvpItemUnit.isAttached() && !mvpItemUnit.hasAttachFlag()) {
                        mvpItemUnit.mo41321a();
                    }
                }
            }

            public void onDetach() {
                for (MvpItemUnit mvpItemUnit : MvpItemBinder.this.f8596a.values()) {
                    if (mvpItemUnit.hasAttachFlag()) {
                        mvpItemUnit.mo41323b();
                    }
                }
            }

            public void onDestroy() {
                MvpItemBinder.this.m5716c();
            }
        });
    }

    public boolean canBindHolder(RecyclerView.ViewHolder viewHolder) {
        return bindHolderType().equals(viewHolder.getClass());
    }

    /* renamed from: b */
    private U m5712b() {
        U onCreateItemUnit = onCreateItemUnit();
        setupItemUnit(onCreateItemUnit);
        return onCreateItemUnit;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m5709a(RecyclerView.ViewHolder viewHolder) {
        m5719d(viewHolder).mo41321a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5713b(RecyclerView.ViewHolder viewHolder) {
        m5719d(viewHolder).mo41323b();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5717c(RecyclerView.ViewHolder viewHolder) {
        m5719d(viewHolder).mo41324c();
        this.f8596a.remove(viewHolder);
    }

    /* renamed from: d */
    private U m5719d(RecyclerView.ViewHolder viewHolder) {
        U u = (MvpItemUnit) this.f8596a.get(viewHolder);
        if (u != null) {
            return u;
        }
        U b = m5712b();
        this.f8596a.put(viewHolder, b);
        return b;
    }

    public void bind(VH vh, T t) {
        m5719d(vh).mo41322a(vh);
    }

    /* access modifiers changed from: protected */
    public final View getItemView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(getItemViewLayoutId(), viewGroup, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5716c() {
        for (U c : this.f8596a.values()) {
            c.mo41324c();
        }
        this.f8596a.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static MvpItemBinder m5711b(NovaRecyclerView novaRecyclerView, RecyclerView.ViewHolder viewHolder) {
        List<ItemBinder> registeredBinderList = ((NovaRecyclerAdapter) novaRecyclerView.getAdapter()).getRegisteredBinderList();
        int size = registeredBinderList.size();
        for (int i = 0; i < size; i++) {
            ItemBinder itemBinder = registeredBinderList.get(i);
            if (itemBinder instanceof MvpItemBinder) {
                MvpItemBinder mvpItemBinder = (MvpItemBinder) itemBinder;
                if (mvpItemBinder.canBindHolder(viewHolder)) {
                    return mvpItemBinder;
                }
            }
        }
        return null;
    }

    public static class NovaOnChildAttachStateChangeListener implements RecyclerView.OnChildAttachStateChangeListener {
        private NovaRecyclerView mRecyclerView;

        public NovaOnChildAttachStateChangeListener(NovaRecyclerView novaRecyclerView) {
            this.mRecyclerView = novaRecyclerView;
        }

        public void onChildViewAttachedToWindow(View view) {
            RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
            MvpItemBinder a = MvpItemBinder.m5711b(this.mRecyclerView, childViewHolder);
            if (a != null) {
                a.m5709a(childViewHolder);
            }
        }

        public void onChildViewDetachedFromWindow(View view) {
            RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
            MvpItemBinder a = MvpItemBinder.m5711b(this.mRecyclerView, childViewHolder);
            if (a != null) {
                a.m5713b(childViewHolder);
            }
        }
    }

    public static class NovaRecyclerListener implements RecyclerView.RecyclerListener {
        private boolean mItemMvpEnable;
        private RecyclerView.RecyclerListener mRecyclerListener;
        private NovaRecyclerView mRecyclerView;

        public NovaRecyclerListener(NovaRecyclerView novaRecyclerView) {
            this.mRecyclerView = novaRecyclerView;
        }

        public void setRecyclerListener(RecyclerView.RecyclerListener recyclerListener) {
            this.mRecyclerListener = recyclerListener;
        }

        public void setItemMvpEnable(boolean z) {
            this.mItemMvpEnable = z;
        }

        public boolean hasRecyclerListener() {
            return this.mRecyclerListener != null;
        }

        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            MvpItemBinder a;
            RecyclerView.RecyclerListener recyclerListener = this.mRecyclerListener;
            if (recyclerListener != null) {
                recyclerListener.onViewRecycled(viewHolder);
            }
            if (this.mItemMvpEnable && (a = MvpItemBinder.m5711b(this.mRecyclerView, viewHolder)) != null) {
                a.m5717c(viewHolder);
            }
        }
    }
}
