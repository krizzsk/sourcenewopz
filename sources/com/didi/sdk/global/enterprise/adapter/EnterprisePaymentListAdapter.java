package com.didi.sdk.global.enterprise.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.global.enterprise.model.data.EnterpriseItem;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class EnterprisePaymentListAdapter extends RecyclerView.Adapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<EnterpriseItem> f36151a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnItemSelectListener f36152b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f36153c = -1;

    public interface OnItemSelectListener {
        void onItemSelect(int i, EnterpriseItem enterpriseItem, boolean z);
    }

    /* renamed from: a */
    private void m25545a(String str) {
        if (str == null) {
            this.f36153c = -1;
            return;
        }
        int i = 0;
        Iterator<EnterpriseItem> it = this.f36151a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getId().equals(str)) {
                this.f36153c = i;
                break;
            } else {
                i++;
            }
        }
        if (i >= this.f36151a.size()) {
            this.f36153c = -1;
        }
    }

    public void refresh(List<EnterpriseItem> list, String str) {
        if (list != null) {
            this.f36151a.clear();
            this.f36151a.addAll(list);
            m25545a(str);
            notifyDataSetChanged();
        }
    }

    public void setItemSelectListener(OnItemSelectListener onItemSelectListener) {
        this.f36152b = onItemSelectListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_payment_adapter_enterprise_list_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            ((ViewHolder) viewHolder).bind(i);
        }
    }

    public int getItemCount() {
        return this.f36151a.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivCheck;
        private TextView tvTitle;

        public ViewHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
            this.ivCheck = (ImageView) view.findViewById(R.id.iv_check);
            view.setOnClickListener(this);
        }

        public void bind(int i) {
            this.tvTitle.setText(((EnterpriseItem) EnterprisePaymentListAdapter.this.f36151a.get(i)).getName());
            this.ivCheck.setImageResource(EnterprisePaymentListAdapter.this.f36153c == i ? R.drawable.one_payment_global_list_select : 0);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            boolean z = EnterprisePaymentListAdapter.this.f36153c == getAdapterPosition();
            if (!z) {
                int unused = EnterprisePaymentListAdapter.this.f36153c = getAdapterPosition();
                EnterprisePaymentListAdapter.this.notifyDataSetChanged();
            }
            if (EnterprisePaymentListAdapter.this.f36152b != null) {
                EnterprisePaymentListAdapter.this.f36152b.onItemSelect(EnterprisePaymentListAdapter.this.f36153c, (EnterpriseItem) EnterprisePaymentListAdapter.this.f36151a.get(EnterprisePaymentListAdapter.this.f36153c), z);
            }
        }
    }
}
