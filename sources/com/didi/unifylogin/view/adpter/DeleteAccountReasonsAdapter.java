package com.didi.unifylogin.view.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class DeleteAccountReasonsAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<DeleteAccountReason> f45076a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean[] f45077b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f45078c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnOtherReasonItemSelectedChangedListener f45079d;

    public interface OnOtherReasonItemSelectedChangedListener {
        void onOtherReasonItemSelectedChanged(boolean z);
    }

    public DeleteAccountReasonsAdapter(List<DeleteAccountReason> list) {
        if (list != null) {
            this.f45076a = list;
            this.f45077b = new boolean[list.size()];
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (LoginPreferredConfig.isUsePassengerUIStyle()) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.login_unify_item_delete_account_reason_passenger_style, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.login_unify_item_delete_account_reason, viewGroup, false);
        }
        return new ViewHolder(view);
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.titleTv.setText(this.f45076a.get(i).reason);
        viewHolder.reasonCb.setSelected(false);
        this.f45077b[i] = false;
        viewHolder.reasonCb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = !viewHolder.reasonCb.isSelected();
                viewHolder.reasonCb.setSelected(z);
                if (((DeleteAccountReason) DeleteAccountReasonsAdapter.this.f45076a.get(i)).isOtherReason) {
                    boolean unused = DeleteAccountReasonsAdapter.this.f45078c = z;
                    if (DeleteAccountReasonsAdapter.this.f45079d != null) {
                        DeleteAccountReasonsAdapter.this.f45079d.onOtherReasonItemSelectedChanged(z);
                        return;
                    }
                    return;
                }
                DeleteAccountReasonsAdapter.this.f45077b[i] = z;
            }
        });
        if (i == this.f45076a.size() - 1) {
            viewHolder.divider.setVisibility(8);
        }
    }

    public int getItemCount() {
        return this.f45076a.size();
    }

    public List<String> getSelectedReasons() {
        ArrayList arrayList = new ArrayList();
        List<DeleteAccountReason> list = this.f45076a;
        if (!(list == null || this.f45077b == null)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (this.f45077b[i] && !this.f45076a.get(i).isOtherReason) {
                    arrayList.add(this.f45076a.get(i).reason);
                }
            }
        }
        return arrayList;
    }

    public boolean isOtherReasonSelected() {
        return this.f45078c;
    }

    public void setOnOtherReasonItemSelectedChangedListener(OnOtherReasonItemSelectedChangedListener onOtherReasonItemSelectedChangedListener) {
        this.f45079d = onOtherReasonItemSelectedChangedListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View divider;
        ImageView reasonCb;
        TextView titleTv;

        public ViewHolder(View view) {
            super(view);
            this.titleTv = (TextView) view.findViewById(R.id.tv_title);
            this.reasonCb = (ImageView) view.findViewById(R.id.cb_reason);
            this.divider = view.findViewById(R.id.divider);
        }
    }

    public static class DeleteAccountReason {
        boolean isOtherReason;
        String reason;

        public DeleteAccountReason(String str, boolean z) {
            this.reason = str;
            this.isOtherReason = z;
        }
    }
}
