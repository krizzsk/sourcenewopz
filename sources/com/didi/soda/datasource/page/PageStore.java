package com.didi.soda.datasource.page;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.datasource.listener.DataMapFunction;
import com.didi.soda.datasource.listener.DataSourceListener;
import com.didi.soda.datasource.page.UpdateUtils;
import java.util.ArrayList;
import java.util.List;

public class PageStore<Value, Target> {

    /* renamed from: a */
    private static final String f42272a = "PageStore";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ArrayList<Target> f42273b = new ArrayList<>();

    /* renamed from: c */
    private DataMapFunction<Value, Target> f42274c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DataSourceListener<Value, Target> f42275d;

    public PageStore(DataMapFunction<Value, Target> dataMapFunction, DataSourceListener<Value, Target> dataSourceListener) {
        this.f42274c = dataMapFunction;
        this.f42275d = dataSourceListener;
    }

    public void insert(int i, Target target) {
        if (i <= this.f42273b.size() && i >= 0) {
            this.f42273b.add(i, target);
            DataSourceListener<Value, Target> dataSourceListener = this.f42275d;
            if (dataSourceListener != null) {
                dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f42273b));
            }
        }
    }

    public void insert(int i, List<Target> list) {
        if (i <= this.f42273b.size() && i >= 0) {
            this.f42273b.addAll(i, list);
            DataSourceListener<Value, Target> dataSourceListener = this.f42275d;
            if (dataSourceListener != null) {
                dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f42273b));
            }
        }
    }

    public void update(UpdateUtils.DiffCallback<Target> diffCallback, UpdateUtils.UpdateCallback<Target> updateCallback) {
        UpdateUtils.dispatchUpdate(diffCallback, updateCallback, new UpdateUtils.UpdateCompleteCallback<Target>() {
            public void onCompleted(List<Target> list) {
                if (PageStore.this.f42275d != null) {
                    PageStore.this.f42275d.onDataSourceUpdate(list);
                }
            }
        }, this.f42273b);
    }

    public int find(UpdateUtils.DiffCallback<Target> diffCallback) {
        return UpdateUtils.find(diffCallback, this.f42273b);
    }

    public void remove(UpdateUtils.DiffCallback<Target> diffCallback) {
        UpdateUtils.dispatchRemove(diffCallback, new UpdateUtils.UpdateCompleteCallback<Target>() {
            public void onCompleted(List<Target> list) {
                if (PageStore.this.f42275d != null) {
                    PageStore.this.f42275d.onDataSourceChanged(PageStore.this, new ArrayList(PageStore.this.f42273b));
                }
            }
        }, this.f42273b);
    }

    public boolean contains(UpdateUtils.DiffCallback<Target> diffCallback) {
        return UpdateUtils.contains(diffCallback, this.f42273b);
    }

    public List<Target> getTargetList() {
        return new ArrayList(this.f42273b);
    }

    public void receivePageResult(PageResult<Value> pageResult) {
        List<Target> mapData = this.f42274c.mapData(pageResult.getCurrentPage(), pageResult.getValueList());
        if (mapData == null || mapData.size() == 0) {
            LogUtil.m29102e(f42272a, "mapList 返回的数据列表为空，列表不会有任何变化，请返回一个数组，我才知道刷新列表数据");
        }
        if (pageResult.getResultType() == 1) {
            if (mapData != null) {
                this.f42273b.clear();
                this.f42273b.addAll(mapData);
            }
        } else if (pageResult.getResultType() == 2 && mapData != null) {
            this.f42273b.addAll(mapData);
        }
        DataSourceListener<Value, Target> dataSourceListener = this.f42275d;
        if (dataSourceListener != null) {
            dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f42273b));
        }
    }

    public void provideStoredData() {
        DataSourceListener<Value, Target> dataSourceListener;
        ArrayList<Target> arrayList = this.f42273b;
        if (arrayList != null && arrayList.size() > 0 && (dataSourceListener = this.f42275d) != null) {
            dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f42273b));
        }
    }
}
