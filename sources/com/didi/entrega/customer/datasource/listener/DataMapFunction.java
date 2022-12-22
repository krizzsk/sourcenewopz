package com.didi.entrega.customer.datasource.listener;

import java.util.List;

public interface DataMapFunction<Source, Target> {
    List<Target> mapData(int i, List<Source> list);
}
