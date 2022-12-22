package com.didi.unifylogin.view.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.unifylogin.base.net.pojo.response.DeleteUserResponse;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class DeleteAccountFailedTextsAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private List<DeleteUserResponse.DeleteContent> f45075a = new ArrayList();

    public DeleteAccountFailedTextsAdapter(List<DeleteUserResponse.DeleteContent> list) {
        if (list != null) {
            this.f45075a = list;
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.login_unify_item_delete_account_failed_texts, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        DeleteUserResponse.DeleteContent deleteContent = this.f45075a.get(i);
        viewHolder.titleTv.setText(deleteContent.getTag());
        viewHolder.desTv.setText(deleteContent.getDesc());
    }

    public int getItemCount() {
        return this.f45075a.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView desTv;
        TextView titleTv;

        public ViewHolder(View view) {
            super(view);
            this.titleTv = (TextView) view.findViewById(R.id.tv_title);
            this.desTv = (TextView) view.findViewById(R.id.tv_des);
        }
    }
}
