package com.didi.sdk.sidebar.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.sdk.sidebar.history.adapter.HistoryRecordAdapter;
import com.didi.sdk.sidebar.history.manager.HistoryManagerBuilder;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.sidebar.history.view.DropPinnedHeaderList;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HistoryRecordAdapterImpl extends HistoryRecordAdapter implements DropPinnedHeaderList.PinnedHeaderAdapter {
    public static final int ITEM_TYPE_DATA = 0;
    public static final int ITEM_TYPE_TYPE = 1;

    /* renamed from: a */
    private Context f37295a;

    /* renamed from: b */
    private LayoutInflater f37296b;

    /* renamed from: c */
    private List<AbsHistoryOrder> f37297c;

    /* renamed from: d */
    private List<AbsHistoryOrder> f37298d;

    /* renamed from: e */
    private List<Object> f37299e = new ArrayList();

    /* renamed from: f */
    private boolean f37300f = false;

    /* renamed from: g */
    private boolean f37301g;

    /* renamed from: h */
    private String f37302h = "soda";

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public void init(Context context, List<AbsHistoryOrder> list, List<AbsHistoryOrder> list2, String str) {
        this.f37295a = context;
        this.f37296b = LayoutInflater.from(context);
        this.f37302h = str;
        updateData(list, list2);
    }

    public void updateData(List<AbsHistoryOrder> list, List<AbsHistoryOrder> list2) {
        this.f37297c = list;
        this.f37298d = list2;
        this.f37299e.clear();
        int size = CollectionUtil.size((Collection<?>) list);
        int size2 = CollectionUtil.size((Collection<?>) list2);
        if (size > 0) {
            this.f37299e.add(new Object());
            this.f37299e.addAll(list);
            if (size2 > 0) {
                this.f37299e.add(new Object());
                this.f37299e.addAll(list2);
            }
        } else if (size2 > 0) {
            this.f37299e.add(new Object());
            this.f37299e.addAll(list2);
        }
    }

    public boolean isInvoiceMode() {
        return this.f37301g;
    }

    public void setInvoiceMode(boolean z) {
        this.f37301g = z;
    }

    public List<AbsHistoryOrder> getFinishedOrderList() {
        return this.f37298d;
    }

    public int getCount() {
        int size = CollectionUtil.size((Collection<?>) this.f37298d);
        int size2 = CollectionUtil.size((Collection<?>) this.f37297c);
        int i = 1;
        int i2 = size2 + size + (size > 0 ? 1 : 0);
        if (size2 <= 0) {
            i = 0;
        }
        return i2 + i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TypeViewHolder typeViewHolder;
        Object tag = view == null ? null : view.getTag();
        if (i < this.f37299e.size()) {
            if (getItemViewType(i) == 0) {
                if (tag == null || (tag instanceof TypeViewHolder)) {
                    view = HistoryManagerBuilder.getInstance().createHistoryManager(this.f37302h).getHistoryItemView(this.f37295a);
                }
                HistoryManagerBuilder.getInstance().createHistoryManager(this.f37302h).bindDateForHistoryItemView(getItem(i), view, isInvoiceMode());
            } else {
                if (!(tag instanceof TypeViewHolder) || (typeViewHolder = (TypeViewHolder) tag) == null) {
                    typeViewHolder = new TypeViewHolder();
                    view = this.f37296b.inflate(R.layout.v_history_record_group, (ViewGroup) null);
                    typeViewHolder.typeTV = (TextView) view.findViewById(R.id.status_tv);
                    view.setTag(typeViewHolder);
                }
                typeViewHolder.typeTV.setTextColor(this.f37295a.getResources().getColor(R.color.light_gray));
                if (this.f37297c.size() <= 0 || i != 0) {
                    typeViewHolder.typeTV.setText(R.string.history_record_finished_type);
                } else {
                    typeViewHolder.typeTV.setText(R.string.history_record_unfinished_type);
                }
            }
        }
        return view;
    }

    public int getItemViewType(int i) {
        if (i >= this.f37299e.size()) {
            return 0;
        }
        return (this.f37299e.get(i) instanceof AbsHistoryOrder) ^ true ? 1 : 0;
    }

    public boolean isEmpty() {
        return CollectionUtil.isEmpty((Collection<?>) this.f37297c) && CollectionUtil.isEmpty((Collection<?>) this.f37298d);
    }

    public AbsHistoryOrder getItem(int i) {
        if (getItemViewType(i) != 0 || i >= this.f37299e.size()) {
            return null;
        }
        return (AbsHistoryOrder) this.f37299e.get(i);
    }

    public boolean isEditMode() {
        return this.f37300f;
    }

    public void setEditMode(boolean z) {
        if (this.f37300f != z) {
            this.f37300f = z;
            notifyDataSetChanged();
        }
    }

    public int getPinnedHeaderState(int i) {
        return (this.f37297c.size() <= 0 || i != this.f37297c.size()) ? 1 : 2;
    }

    public void configurePinnedHeader(View view, int i, int i2) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.status_tv);
            if (this.f37297c.size() <= 0 || i >= this.f37297c.size() + 1) {
                textView.setText(R.string.history_record_finished_type);
                textView.setTextColor(this.f37295a.getResources().getColor(R.color.light_gray));
                return;
            }
            textView.setText(R.string.history_record_unfinished_type);
            if (DidiThemeManager.getIns() == null || DidiThemeManager.getIns().getResPicker(this.f37295a) == null) {
                textView.setTextColor(this.f37295a.getResources().getColor(R.color.light_gray));
            } else {
                textView.setTextColor(DidiThemeManager.getIns().getResPicker(this.f37295a).getColor(R.attr.caution_color));
            }
        }
    }

    public void removeItem(int i) {
        List<Object> list = this.f37299e;
        if (list != null && list.size() > i) {
            Object remove = this.f37299e.remove(i);
            if ((remove instanceof AbsHistoryOrder) && this.f37298d.contains(remove)) {
                this.f37298d.remove(remove);
                notifyDataSetChanged();
            }
        }
    }

    public int getOrderCount() {
        return this.f37297c.size() + this.f37298d.size();
    }

    public boolean isFinishOrderByPosition(int i) {
        List<Object> list = this.f37299e;
        if (list == null || list.size() <= i) {
            return false;
        }
        return this.f37298d.contains(this.f37299e.get(i));
    }

    private static class TypeViewHolder {
        TextView typeTV;

        private TypeViewHolder() {
        }
    }
}
