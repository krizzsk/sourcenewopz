package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SAPanelAdapter */
public class SAPanelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    private List<SACardProperty> f51138a;

    /* renamed from: b */
    private HashMap<Integer, SACardProperty> f51139b = new HashMap<>();

    /* renamed from: c */
    private Logger f51140c = LoggerFactory.getLogger("SAPanelAdapter");

    /* renamed from: d */
    private HashMap<Integer, Integer> f51141d = new HashMap<>();

    /* renamed from: e */
    private Context f51142e;

    public SAPanelAdapter(Context context) {
        this.f51142e = context;
        this.f51138a = new ArrayList();
    }

    public List<SACardProperty> getmCardList() {
        return this.f51138a;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        SACardProperty sACardProperty = this.f51139b.get(Integer.valueOf(i));
        PanelItemContainer panelItemContainer = new PanelItemContainer(sACardProperty.getId(), this.f51141d.get(Integer.valueOf(i)).intValue(), this.f51142e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (sACardProperty.getView().getParent() != null && (sACardProperty.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) sACardProperty.getView().getParent()).removeAllViews();
        }
        panelItemContainer.addView(sACardProperty.getView(), layoutParams);
        return new SAViewHolder(panelItemContainer);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        SACardProperty sACardProperty = this.f51138a.get(i);
        if (sACardProperty.getListener() != null) {
            sACardProperty.getListener().cardWillDisplay();
        }
    }

    /* renamed from: a */
    private int m36639a(SACardProperty sACardProperty) {
        if (sACardProperty == null || sACardProperty.getView() == null) {
            return -1;
        }
        return sACardProperty.getView().hashCode();
    }

    public int getItemCount() {
        return this.f51138a.size();
    }

    public int getItemViewType(int i) {
        int a = m36639a(this.f51138a.get(i));
        this.f51141d.put(Integer.valueOf(a), Integer.valueOf(i));
        return a;
    }

    public void updateCard(SACardProperty sACardProperty) {
        int i = 0;
        while (i < this.f51138a.size()) {
            SACardProperty sACardProperty2 = this.f51138a.get(i);
            if (sACardProperty.getId() == null || !sACardProperty2.getId().equals(sACardProperty2.getId())) {
                i++;
            } else {
                sACardProperty2.setView(sACardProperty.getView());
                notifyItemChanged(i);
                return;
            }
        }
    }

    public void setCardPropertyList(List<SACardProperty> list) {
        this.f51138a.clear();
        this.f51139b.clear();
        this.f51141d.clear();
        this.f51138a.addAll(list);
        Logger logger = this.f51140c;
        logger.info("modelist size: " + this.f51138a.size(), new Object[0]);
        for (SACardProperty next : list) {
            Logger logger2 = this.f51140c;
            logger2.info("cardid: " + next.getId(), new Object[0]);
            this.f51139b.put(Integer.valueOf(m36639a(next)), next);
        }
        notifyDataSetChanged();
    }

    public void addCard(SACardProperty sACardProperty, int i) {
        this.f51138a.add(i, sACardProperty);
        this.f51139b.put(Integer.valueOf(m36639a(sACardProperty)), sACardProperty);
        this.f51141d.put(Integer.valueOf(m36639a(sACardProperty)), Integer.valueOf(i));
        notifyItemInserted(i);
    }

    public void removeCard(int i) {
        this.f51138a.remove(i);
        this.f51139b.remove(Integer.valueOf(m36639a(this.f51138a.get(i))));
        notifyItemRemoved(i);
    }
}
