package com.didi.unifylogin.view.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.net.pojo.response.GetDeleteAccountManualResponse;
import com.didi.unifylogin.utils.HighlightUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class DeleteAccountWarningAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private List<GetDeleteAccountManualResponse.DeleteContent> f45080a = new ArrayList();

    public DeleteAccountWarningAdapter(List<GetDeleteAccountManualResponse.DeleteContent> list) {
        if (list != null) {
            this.f45080a = list;
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (LoginPreferredConfig.isUsePassengerUIStyle()) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.login_unify_item_delete_account_manual_texts_passenger_style, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.login_unify_item_delete_account_manual_texts, viewGroup, false);
        }
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        GetDeleteAccountManualResponse.DeleteContent deleteContent = this.f45080a.get(i);
        viewHolder.titleTv.setText(HighlightUtil.highlight(deleteContent.getTag()));
        viewHolder.desTv.setText(HighlightUtil.highlight(deleteContent.getDesc()));
    }

    public int getItemCount() {
        return this.f45080a.size();
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
