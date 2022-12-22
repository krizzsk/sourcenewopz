package com.didi.component.business.commonlist;

import android.view.View;
import com.didi.component.business.commonlist.item.CommonListCardProperty;
import java.util.List;

public interface ICommonListInterface {
    void addCard(CommonListCardProperty commonListCardProperty, int i);

    View getCardContainer();

    List<CommonListCardProperty> getCardPropertyList();

    void removeCard(int i);

    void removeCard(View view);

    void removeCard(CommonListCardProperty commonListCardProperty);

    void setData(List<CommonListCardProperty> list);
}
