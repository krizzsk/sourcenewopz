package com.didiglobal.p205sa.biz.component.sapanel.interfaces;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.interfaces.ISAPanel */
public interface ISAPanel {
    void addCard(SACardProperty sACardProperty, int i);

    void expandPage();

    RecyclerView getContainer();

    View getView();

    void removeCard(int i);

    void resumePageSize();

    void setData(List<SACardProperty> list);

    void updateCard(SACardProperty sACardProperty);
}
