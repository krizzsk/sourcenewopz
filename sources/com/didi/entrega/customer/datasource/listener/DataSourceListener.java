package com.didi.entrega.customer.datasource.listener;

import com.didi.entrega.customer.datasource.page.PageStore;
import java.util.List;

public interface DataSourceListener<Value, Target> {
    void onDataSourceChanged(PageStore<Value, Target> pageStore, List<Target> list);

    void onDataSourceUpdate(List<Target> list);
}
