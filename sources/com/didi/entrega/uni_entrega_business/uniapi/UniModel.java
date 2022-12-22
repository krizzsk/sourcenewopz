package com.didi.entrega.uni_entrega_business.uniapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class UniModel {

    public interface Lambda<From, To> {
        To run(From from);
    }

    public abstract Map<String, Object> toMap();

    public static <From, To> List<To> map(List<From> list, Lambda<From, To> lambda) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (From run : list) {
                arrayList.add(lambda.run(run));
            }
        }
        return arrayList;
    }
}
