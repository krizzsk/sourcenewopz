package com.didi.entrega.customer.datasource.page;

import com.didi.entrega.customer.datasource.listener.DataMapFunction;
import com.didi.entrega.customer.datasource.listener.DataSourceListener;
import com.didi.entrega.customer.datasource.page.UpdateUtils;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

public class PageStore<Value, Target> {

    /* renamed from: a */
    private static final String f19874a = "PageStore";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ArrayList<Target> f19875b = new ArrayList<>();

    /* renamed from: c */
    private DataMapFunction<Value, Target> f19876c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DataSourceListener<Value, Target> f19877d;

    public PageStore(DataMapFunction<Value, Target> dataMapFunction, DataSourceListener<Value, Target> dataSourceListener) {
        this.f19876c = dataMapFunction;
        this.f19877d = dataSourceListener;
    }

    public void insert(int i, Target target) {
        if (i <= this.f19875b.size() && i >= 0) {
            this.f19875b.add(i, target);
            DataSourceListener<Value, Target> dataSourceListener = this.f19877d;
            if (dataSourceListener != null) {
                dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f19875b));
            }
        }
    }

    public void update(UpdateUtils.DiffCallback<Target> diffCallback, UpdateUtils.UpdateCallback<Target> updateCallback) {
        UpdateUtils.dispatchUpdate(diffCallback, updateCallback, new UpdateUtils.UpdateCompleteCallback<Target>() {
            public void onCompleted(List<Target> list) {
                if (PageStore.this.f19877d != null) {
                    PageStore.this.f19877d.onDataSourceUpdate(list);
                }
            }
        }, this.f19875b);
    }

    public int find(UpdateUtils.DiffCallback<Target> diffCallback) {
        return UpdateUtils.find(diffCallback, this.f19875b);
    }

    public void remove(UpdateUtils.DiffCallback<Target> diffCallback) {
        UpdateUtils.dispatchRemove(diffCallback, new UpdateUtils.UpdateCompleteCallback<Target>() {
            public void onCompleted(List<Target> list) {
                if (PageStore.this.f19877d != null) {
                    PageStore.this.f19877d.onDataSourceChanged(PageStore.this, new ArrayList(PageStore.this.f19875b));
                }
            }
        }, this.f19875b);
    }

    public boolean contains(UpdateUtils.DiffCallback<Target> diffCallback) {
        return UpdateUtils.contains(diffCallback, this.f19875b);
    }

    public List<Target> getTargetList() {
        return new ArrayList(this.f19875b);
    }

    public void receivePageResult(PageResult<Value> pageResult) {
        List<Target> mapData = this.f19876c.mapData(pageResult.getCurrentPage(), pageResult.getValueList());
        if (mapData == null || mapData.size() == 0) {
            LogUtil.m14763e(f19874a, "mapList 返回的数据列表为空，列表不会有任何变化，请返回一个数组，我才知道刷新列表数据");
        }
        if (pageResult.getResultType() == 1) {
            if (mapData != null) {
                this.f19875b.clear();
                this.f19875b.addAll(mapData);
            }
        } else if (pageResult.getResultType() == 2 && mapData != null) {
            this.f19875b.addAll(mapData);
        }
        DataSourceListener<Value, Target> dataSourceListener = this.f19877d;
        if (dataSourceListener != null) {
            dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f19875b));
        }
    }

    public void provideStoredData() {
        DataSourceListener<Value, Target> dataSourceListener;
        ArrayList<Target> arrayList = this.f19875b;
        if (arrayList != null && arrayList.size() > 0 && (dataSourceListener = this.f19877d) != null) {
            dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f19875b));
        }
    }
}
