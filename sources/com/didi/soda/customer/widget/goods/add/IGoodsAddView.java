package com.didi.soda.customer.widget.goods.add;

import com.didi.soda.customer.widget.goods.add.C13842a;
import java.io.Serializable;

public interface IGoodsAddView<T extends C13842a> {

    public enum AddType implements Serializable {
        NORMAL,
        BUY_GIFT
    }

    AddType getAddType();

    void updateViewModel(T t);
}
