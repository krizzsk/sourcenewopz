package com.didiglobal.mew.framework.widget.p201ff;

import android.view.View;
import java.util.List;

/* renamed from: com.didiglobal.mew.framework.widget.ff.IMFallsFlowAbility */
public interface IMFallsFlowAbility {
    void addCard(MFFCardProperty mFFCardProperty);

    void addCard(MFFCardProperty mFFCardProperty, int i);

    View getView();

    void removeCard(int i);

    void removeCard(MFFCardProperty mFFCardProperty);

    void setData(List<MFFCardProperty> list);
}
