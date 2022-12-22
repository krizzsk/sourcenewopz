package com.didi.soda.datasource.listener;

import com.didi.soda.datasource.page.PageStore;
import java.util.List;

public interface DataSourceListener<Value, Target> {
    void onDataSourceChanged(PageStore<Value, Target> pageStore, List<Target> list);

    void onDataSourceUpdate(List<Target> list);
}
