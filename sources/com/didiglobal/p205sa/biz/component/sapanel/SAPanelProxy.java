package com.didiglobal.p205sa.biz.component.sapanel;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ISAPanel;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import com.didiglobal.p205sa.biz.component.sapanel.view.SAPanelRecView;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.SAPanelProxy */
public class SAPanelProxy implements ISAPanel {

    /* renamed from: a */
    private Context f51096a;

    /* renamed from: b */
    private SAPanelRecView f51097b;

    public SAPanelProxy(Activity activity) {
        this.f51096a = activity;
        this.f51097b = new SAPanelRecView(activity);
    }

    public void setData(List<SACardProperty> list) {
        this.f51097b.setData(list);
    }

    public void addCard(SACardProperty sACardProperty, int i) {
        this.f51097b.addCard(sACardProperty, i);
    }

    public RecyclerView getContainer() {
        return this.f51097b.getContainer();
    }

    public void removeCard(int i) {
        this.f51097b.removeCard(i);
    }

    public void updateCard(SACardProperty sACardProperty) {
        this.f51097b.updateCard(sACardProperty);
    }

    public View getView() {
        return this.f51097b.getView();
    }

    public void resumePageSize() {
        this.f51097b.resumePageSize();
    }

    public void expandPage() {
        this.f51097b.expandPage();
    }

    public void scrollTop(int i) {
        this.f51097b.scrollTop(i);
    }
}
