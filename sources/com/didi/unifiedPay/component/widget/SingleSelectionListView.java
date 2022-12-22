package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.component.model.PayChannelItem;
import java.util.ArrayList;
import java.util.List;

public class SingleSelectionListView extends ListView implements AdapterView.OnItemClickListener {
    public static final int CHANGE_ITEM_MODE_BLOCK = 1;
    public static final int CHANGE_ITEM_MODE_NORMAL = 0;

    /* renamed from: a */
    private Adapter f44469a;

    /* renamed from: b */
    private OnSelectListener f44470b;

    public interface OnSelectListener<T> {
        void itemClicked(int i, PayChannelItem payChannelItem);

        void onSelect(int i, T t);

        void unSelect(int i, T t);
    }

    public SingleSelectionListView(Context context) {
        super(context);
        m31578a();
    }

    public SingleSelectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31578a();
    }

    public Object getSelected() {
        int selection = this.f44469a.getSelection();
        if (selection == -1) {
            return null;
        }
        return this.f44469a.getItem(selection);
    }

    /* renamed from: a */
    private void m31578a() {
        setDivider((Drawable) null);
        setFooterDividersEnabled(false);
        setOnItemClickListener(this);
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.f44469a = (Adapter) listAdapter;
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.f44470b = onSelectListener;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
        this.f44469a.setSelection(i);
        OnSelectListener onSelectListener = this.f44470b;
        if (onSelectListener != null) {
            onSelectListener.onSelect(i, this.f44469a.getItem(i));
        }
    }

    public static abstract class Adapter<T> extends BaseAdapter {
        private int mBlockItemIndex = -1;
        private int mChangeMode;
        private LayoutInflater mInflater;
        private int mLastSelected = -1;
        private ArrayList<T> mList = new ArrayList<>();
        private int mSelected = -1;

        /* access modifiers changed from: protected */
        public abstract void bindView(View view, T t);

        public long getItemId(int i) {
            return 0;
        }

        /* access modifiers changed from: protected */
        public abstract View getView(LayoutInflater layoutInflater);

        /* access modifiers changed from: protected */
        public void handleDownGradle(View view, int i, boolean z) {
        }

        /* access modifiers changed from: protected */
        public void onBlockSelectChange(View view, int i, boolean z) {
        }

        /* access modifiers changed from: protected */
        public abstract void onSelectChange(View view, int i, boolean z);

        public Adapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        public void setList(List<T> list) {
            if (list != null && list.size() != 0) {
                this.mList.clear();
                this.mList.addAll(list);
                notifyDataSetChanged();
            }
        }

        public List<T> getList() {
            return this.mList;
        }

        public int getCount() {
            return this.mList.size();
        }

        public T getItem(int i) {
            if (i < 0 || i >= this.mList.size()) {
                return null;
            }
            return this.mList.get(i);
        }

        public void onItemClick(int i, int i2, boolean z) {
            this.mLastSelected = this.mSelected;
            this.mChangeMode = i2;
            if (i2 == 1) {
                this.mBlockItemIndex = i;
                notifyDataSetChanged();
            } else if (i2 == 0) {
                if (!z) {
                    i = -1;
                }
                setSelection(i);
            }
        }

        public void setSelection(int i) {
            this.mLastSelected = this.mSelected;
            this.mBlockItemIndex = -1;
            this.mSelected = i;
            notifyDataSetChanged();
        }

        public int getSelection() {
            return this.mSelected;
        }

        public int getLastSelected() {
            return this.mLastSelected;
        }

        public int getBlockItemIndex() {
            return this.mBlockItemIndex;
        }

        public void setChangeMode(int i) {
            this.mChangeMode = i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getView(this.mInflater);
            }
            bindView(view, getItem(i));
            handleItem(view, i);
            return view;
        }

        private void handleItem(View view, int i) {
            int i2 = this.mChangeMode;
            boolean z = false;
            if (i2 == 0) {
                onSelectChange(view, i, this.mSelected == i);
            } else if (i2 == 1) {
                if (this.mBlockItemIndex >= 0 || i != this.mSelected) {
                    onBlockSelectChange(view, i, this.mBlockItemIndex == i);
                } else {
                    onSelectChange(view, i, true);
                }
            }
            if (this.mSelected == i || this.mBlockItemIndex == i) {
                z = true;
            }
            handleDownGradle(view, i, z);
        }

        public int getIndex(T t) {
            if (!(t == null || this.mList == null)) {
                for (int i = 0; i < this.mList.size(); i++) {
                    if (t.equals(this.mList.get(i))) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
}
