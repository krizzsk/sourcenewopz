package com.didi.payment.commonsdk.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TransBankListAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private Context f30214a;

    /* renamed from: b */
    private List<String> f30215b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnItemClickListener f30216c;

    public interface OnItemClickListener {
        void onItemClick(String str);
    }

    public TransBankListAdapter(Context context, List<String> list) {
        this.f30214a = context;
        this.f30215b = list == null ? new ArrayList<>() : list;
    }

    public void updateData(List<String> list) {
        this.f30215b.clear();
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f30215b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trans_bank_list_item_lay, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            viewHolder.bind(!CollectionUtil.isEmpty((Collection<?>) this.f30215b) ? this.f30215b.get(i) : null);
        }
    }

    public int getItemCount() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f30215b)) {
            return 0;
        }
        return this.f30215b.size();
    }

    public void setOnItemclickListener(OnItemClickListener onItemClickListener) {
        this.f30216c = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public String data;
        private TextView mNameTv;

        public ViewHolder(View view) {
            super(view);
            this.mNameTv = (TextView) view.findViewById(R.id.trans_bank_list_item_tv);
            view.setOnClickListener(new DoubleCheckOnClickListener(TransBankListAdapter.this) {
                public void doClick(View view) {
                    if (TransBankListAdapter.this.f30216c != null) {
                        TransBankListAdapter.this.f30216c.onItemClick(ViewHolder.this.data);
                    }
                }
            });
        }

        public void bind(String str) {
            this.data = str;
            this.mNameTv.setText(str);
        }
    }
}
