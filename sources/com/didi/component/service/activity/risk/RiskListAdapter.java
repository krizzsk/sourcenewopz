package com.didi.component.service.activity.risk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.service.activity.risk.RiskViewHolder;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class RiskListAdapter extends RecyclerView.Adapter<RiskViewHolder> implements RiskViewHolder.OnClickListener {

    /* renamed from: a */
    private List<AbsRiskItem> f15677a = new ArrayList();

    /* renamed from: b */
    private AbsRiskItem f15678b;

    public RiskListAdapter(List<AbsRiskItem> list) {
        this.f15677a = list;
    }

    public RiskViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RiskViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.risk_user_item_layout, viewGroup, false));
    }

    public void onBindViewHolder(RiskViewHolder riskViewHolder, int i) {
        riskViewHolder.setOnClickListener(this);
        if (riskViewHolder.itemView != null && riskViewHolder.itemView.getContext() != null) {
            Context context = riskViewHolder.itemView.getContext();
            AbsRiskItem absRiskItem = this.f15677a.get(i);
            if (absRiskItem.isCustomItem()) {
                if (!TextUtils.isEmpty(absRiskItem.getItemTitleStr())) {
                    riskViewHolder.f15685b.setText(absRiskItem.getItemTitleStr());
                } else {
                    riskViewHolder.f15685b.setText(absRiskItem.getItemTitleRes());
                }
                ((RequestBuilder) ((RequestBuilder) Glide.with(context).asBitmap().load(absRiskItem.getItemIconUrl()).error(absRiskItem.getItemIconRes())).fallback(absRiskItem.getItemIconRes())).into(riskViewHolder.f15684a);
            } else {
                riskViewHolder.f15685b.setText(absRiskItem.getItemTitleRes());
                riskViewHolder.f15684a.setImageResource(absRiskItem.getItemIconRes());
            }
            riskViewHolder.itemView.setEnabled(absRiskItem.isItemEnable());
            if (absRiskItem.isItemEnable()) {
                riskViewHolder.f15686c.setVisibility(4);
                riskViewHolder.f15686c.setText("");
                return;
            }
            riskViewHolder.f15686c.setVisibility(0);
            if (absRiskItem.hasEnableItem()) {
                riskViewHolder.f15686c.setText(R.string.risk_error_label);
            } else {
                riskViewHolder.f15686c.setText(R.string.risk_error_no_choose_label);
            }
        }
    }

    public int getItemCount() {
        return this.f15677a.size();
    }

    public void onClick(View view, RiskViewHolder riskViewHolder, int i) {
        AbsRiskItem absRiskItem = this.f15677a.get(i);
        this.f15678b = absRiskItem;
        absRiskItem.onClick(this, view, riskViewHolder, i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AbsRiskItem absRiskItem = this.f15678b;
        if (absRiskItem != null) {
            absRiskItem.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        for (AbsRiskItem onDestroy : this.f15677a) {
            onDestroy.onDestroy();
        }
    }

    public void addItem(AbsRiskItem absRiskItem) {
        this.f15677a.add(absRiskItem);
        notifyItemInserted(this.f15677a.size() - 1);
    }

    public void removeItem(AbsRiskItem absRiskItem) {
        this.f15677a.remove(absRiskItem);
    }

    public boolean hasEnableItem() {
        for (AbsRiskItem isItemEnable : this.f15677a) {
            if (isItemEnable.isItemEnable()) {
                return true;
            }
        }
        return false;
    }
}
