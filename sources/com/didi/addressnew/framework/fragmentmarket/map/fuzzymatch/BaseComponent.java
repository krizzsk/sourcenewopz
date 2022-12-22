package com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.Padding;
import java.util.List;

public interface BaseComponent<T> {
    void create(Context context, Map map);

    void doBestView(Padding padding);

    List<IMapElement> getAllElements();

    void onDestroy();

    void onMapVisible(boolean z);

    void setPadding(Padding padding);

    void setParamConfig(FuzzyMatchParam fuzzyMatchParam);
}
