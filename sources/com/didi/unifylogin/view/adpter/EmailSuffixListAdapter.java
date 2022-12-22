package com.didi.unifylogin.view.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.util.List;

public class EmailSuffixListAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private List<String> f45083a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EmailSellectCallback f45084b;

    public interface EmailSellectCallback {
        void emailSelect(String str);
    }

    public void setmEmailSuffix(List<String> list) {
        this.f45083a = list;
        notifyDataSetChanged();
    }

    public void setCallback(EmailSellectCallback emailSellectCallback) {
        this.f45084b = emailSellectCallback;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.login_unify_item_email_suffix, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mEmailTv.setText(this.f45083a.get(i));
    }

    public int getItemCount() {
        return this.f45083a.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mEmailTv;

        ViewHolder(View view) {
            super(view);
            this.mEmailTv = (TextView) view.findViewById(R.id.email_with_suffix);
            view.setOnClickListener(new View.OnClickListener(EmailSuffixListAdapter.this) {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    EmailSuffixListAdapter.this.f45084b.emailSelect(ViewHolder.this.mEmailTv.getText().toString());
                }
            });
        }
    }
}
