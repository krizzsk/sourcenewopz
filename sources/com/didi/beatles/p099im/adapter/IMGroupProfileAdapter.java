package com.didi.beatles.p099im.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.views.imageView.IMProfileCircleImageView;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.adapter.IMGroupProfileAdapter */
public class IMGroupProfileAdapter extends RecyclerView.Adapter {

    /* renamed from: c */
    private static final int f9078c = 1;

    /* renamed from: a */
    private List<IMUser> f9079a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f9080b;

    public int getItemViewType(int i) {
        return 1;
    }

    public void setData(List<IMUser> list, Context context) {
        this.f9079a = list;
        this.f9080b = context;
    }

    public void updateData(List<IMUser> list) {
        this.f9079a = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new HeadProfileViewHolder(viewGroup);
        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((HeadProfileViewHolder) viewHolder).bindData(this.f9079a.get(i));
    }

    public int getItemCount() {
        List<IMUser> list = this.f9079a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: com.didi.beatles.im.adapter.IMGroupProfileAdapter$HeadProfileViewHolder */
    public class HeadProfileViewHolder extends RecyclerView.ViewHolder {
        private IMProfileCircleImageView profileCircleIv = ((IMProfileCircleImageView) this.itemView.findViewById(R.id.im_circle_profile_view));

        /* renamed from: tv */
        private TextView f9081tv = ((TextView) this.itemView.findViewById(R.id.profile_item_tv));

        public HeadProfileViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(IMGroupProfileAdapter.this.f9080b).inflate(R.layout.item_profile_circle_view, viewGroup, false));
        }

        public void bindData(IMUser iMUser) {
            if (iMUser != null) {
                if (!TextUtils.isEmpty(iMUser.getAvatarUrl())) {
                    this.profileCircleIv.setImageSrc(iMUser.getAvatarUrl(), R.drawable.bts_im_general_default_avatar);
                }
                this.f9081tv.setText(iMUser.getNickName());
                if (iMUser.getExtendInfo() != null && !TextUtils.isEmpty(iMUser.getExtendInfo().tag)) {
                    this.profileCircleIv.setText(iMUser.getExtendInfo().tag);
                }
            }
        }
    }
}
