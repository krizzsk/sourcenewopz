package com.didi.app.nova.support.view.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.data.BaseDataManager;
import com.didi.app.nova.support.view.recyclerview.util.RecyclerDataParser;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class NovaRecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f8588a = 1;

    /* renamed from: b */
    private List<BaseDataManager> f8589b = new ArrayList();

    /* renamed from: c */
    private List<BaseDataManager> f8590c = new ArrayList();

    /* renamed from: d */
    private List<ItemBinder> f8591d = new ArrayList();

    /* renamed from: e */
    private int f8592e = 1;

    /* renamed from: f */
    private INovaRecyclerView.LoadMoreListener f8593f;

    /* renamed from: g */
    private final GridLayoutManager.SpanSizeLookup f8594g = new GridLayoutManager.SpanSizeLookup() {
        public int getSpanSize(int i) {
            return NovaRecyclerAdapter.this.f8588a / NovaRecyclerAdapter.this.getBinderForPosition(i).getColumnCount();
        }
    };

    public final ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.f8591d.get(i).create(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    public final void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        INovaRecyclerView.LoadMoreListener loadMoreListener;
        itemViewHolder.itemView.setTag(R.id.nova_support_nova_recycler_view_tag, itemViewHolder);
        this.f8591d.get(itemViewHolder.getItemViewType()).bindViewHolder(itemViewHolder, getItem(i), getItemPositionInDataManager(i));
        if (this.f8592e > 1 && getItemCount() > this.f8592e && i == getItemCount() - this.f8592e && (loadMoreListener = this.f8593f) != null) {
            loadMoreListener.onLoadMore();
        }
    }

    public void onViewRecycled(ItemViewHolder itemViewHolder) {
        this.f8591d.get(itemViewHolder.getItemViewType()).onRecycled(itemViewHolder);
        super.onViewRecycled(itemViewHolder);
    }

    public final int getItemCount() {
        int i = 0;
        for (BaseDataManager count : this.f8589b) {
            i += count.getCount();
        }
        return i;
    }

    public final int getItemViewType(int i) {
        ItemBinder binderForPosition = getBinderForPosition(i);
        if (binderForPosition != null) {
            return this.f8591d.indexOf(binderForPosition);
        }
        return super.getItemViewType(i);
    }

    public final void addDataManager(BaseDataManager baseDataManager) {
        this.f8589b.add(m5703a(), baseDataManager);
        notifyDataSetChanged();
    }

    public final void addDataManagers(BaseDataManager... baseDataManagerArr) {
        for (BaseDataManager add : baseDataManagerArr) {
            this.f8589b.add(m5703a(), add);
        }
        notifyDataSetChanged();
    }

    public final void addDataManagers(List<BaseDataManager> list) {
        this.f8589b.addAll(m5703a(), list);
        notifyDataSetChanged();
    }

    public final void addDataManagersWithoutNotify(List<BaseDataManager> list) {
        this.f8589b.addAll(m5703a(), list);
    }

    public void setPreLoadNumber(int i) {
        this.f8592e = Math.max(1, i);
    }

    public void setPreLoadMoreListener(INovaRecyclerView.LoadMoreListener loadMoreListener) {
        this.f8593f = loadMoreListener;
    }

    /* renamed from: a */
    private int m5703a() {
        return this.f8589b.size() - this.f8590c.size();
    }

    public final void addFootDataManager(BaseDataManager baseDataManager) {
        this.f8589b.add(baseDataManager);
        this.f8590c.add(baseDataManager);
        notifyDataSetChanged();
    }

    public final void clearDataManagers() {
        this.f8589b.clear();
        this.f8590c.clear();
        notifyDataSetChanged();
    }

    public final void registerBinder(ItemBinder itemBinder) {
        if (!this.f8591d.contains(itemBinder)) {
            this.f8591d.add(itemBinder);
        }
    }

    public List<ItemBinder> getRegisteredBinderList() {
        return this.f8591d;
    }

    /* renamed from: b */
    private int m5705b() {
        int i = 1;
        for (ItemBinder columnCount : this.f8591d) {
            i *= columnCount.getColumnCount();
        }
        return i;
    }

    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        return this.f8594g;
    }

    public final int getSpanCount() {
        int b = m5705b();
        this.f8588a = b;
        return b;
    }

    public void moveData(int i, int i2) {
        BaseDataManager dataManager;
        BaseDataManager dataManager2;
        if (i >= 0 && i2 >= 0 && (dataManager = getDataManager(i)) == (dataManager2 = getDataManager(i2))) {
            int itemPositionInDataManager = getItemPositionInDataManager(i);
            int itemPositionInDataManager2 = getItemPositionInDataManager(i2);
            if (dataManager.equals(dataManager2)) {
                dataManager.move(itemPositionInDataManager, itemPositionInDataManager2);
            }
        }
    }

    public <T> T getItem(int i) {
        return RecyclerDataParser.getItemForPosition(this.f8589b, i);
    }

    public <T extends BaseDataManager> T getDataManager(int i) {
        return RecyclerDataParser.getDataManagerForPosition(this.f8589b, i);
    }

    public ItemBinder getBinderForPosition(int i) {
        return RecyclerDataParser.getBinderForPosition(this.f8589b, this.f8591d, i);
    }

    public int getItemPositionInDataManager(int i) {
        return RecyclerDataParser.getPositionInDataManager(this.f8589b, i);
    }

    public int getItemPositionForItem(Object obj) {
        return RecyclerDataParser.getPositionForItem(this.f8589b, obj);
    }

    public final void notifyBinderItemRangeChanged(BaseDataManager baseDataManager, int i, int i2, Object obj) {
        notifyItemRangeChanged(RecyclerDataParser.getItemPositionInRV(this.f8589b, baseDataManager, i), i2, obj);
    }

    public final void notifyBinderItemMoved(BaseDataManager baseDataManager, int i, int i2) {
        notifyItemMoved(RecyclerDataParser.getItemPositionInRV(this.f8589b, baseDataManager, i), RecyclerDataParser.getItemPositionInRV(this.f8589b, baseDataManager, i2));
    }

    public final void notifyBinderItemRangeInserted(BaseDataManager baseDataManager, int i, int i2) {
        notifyItemRangeInserted(RecyclerDataParser.getItemPositionInRV(this.f8589b, baseDataManager, i), i2);
    }

    public final void notifyBinderItemRangeRemoved(BaseDataManager baseDataManager, int i, int i2) {
        notifyItemRangeRemoved(RecyclerDataParser.getItemPositionInRV(this.f8589b, baseDataManager, i), i2);
    }
}
