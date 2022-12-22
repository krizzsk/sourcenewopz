package com.didi.component.homedestination.newversion;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.model.HomeCardModel;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.SearchIdUploadManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class HomeDestinationNewRecAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    /* renamed from: a */
    private List<HomeCardModel> f14109a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnItemClickListener f14110b;

    public interface OnItemClickListener {
        void onItemClick(int i, HomeCardModel homeCardModel);
    }

    public int getItemViewType(int i) {
        return 1;
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return new RecViewHolder(viewGroup);
        }
        return new RecViewHolder(viewGroup);
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBindData(i, this.f14109a.get(i));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f14110b = onItemClickListener;
    }

    public int getItemCount() {
        return this.f14109a.size();
    }

    public HomeDestinationNewRecAdapter setDataList(List<HomeCardModel> list) {
        if (list == null) {
            this.f14109a = new ArrayList();
            return this;
        }
        this.f14109a = list;
        return this;
    }

    public void cleanTheData() {
        List<HomeCardModel> list = this.f14109a;
        if (list != null) {
            list.clear();
        }
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIcon;
        public TextView mTitle;

        public BaseViewHolder(View view) {
            super(view);
            this.mIcon = (ImageView) view.findViewById(R.id.oc_home_destination_item_icon);
            this.mTitle = (TextView) view.findViewById(R.id.oc_home_destination_item_title);
        }

        public void onBindData(final int i, final HomeCardModel homeCardModel) {
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (homeCardModel != null && HomeDestinationNewRecAdapter.this.f14110b != null && i != -1) {
                        HomeDestinationNewRecAdapter.this.f14110b.onItemClick(i, homeCardModel);
                        SearchIdUploadManager.getInstance().setEstimateAction("guess_to");
                    }
                }
            });
            this.mTitle.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (homeCardModel != null && HomeDestinationNewRecAdapter.this.f14110b != null && i != -1) {
                        HomeDestinationNewRecAdapter.this.f14110b.onItemClick(i, homeCardModel);
                        SearchIdUploadManager.getInstance().setEstimateAction("guess_to");
                    }
                }
            });
        }
    }

    class RecViewHolder extends BaseViewHolder {
        public RecViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_home_destination_rec_new_item_layout, viewGroup, false));
        }

        public void onBindData(int i, HomeCardModel homeCardModel) {
            super.onBindData(i, homeCardModel);
            if (homeCardModel != null) {
                if (homeCardModel.extend_info == null) {
                    this.mIcon.setImageResource(R.drawable.global_home_one_key);
                    return;
                }
                this.mTitle.setText(homeCardModel.base_info.displayname);
                if (TextUtils.equals(homeCardModel.extend_info.poi_ui_tag, "home")) {
                    this.mIcon.setImageResource(R.drawable.global_home_guess_new_icon_home);
                } else if (TextUtils.equals(homeCardModel.extend_info.poi_ui_tag, ComponentType.COMPANY)) {
                    this.mIcon.setImageResource(R.drawable.global_home_guess_new_icon_company);
                } else {
                    this.mIcon.setImageResource(R.drawable.global_home_guess_icon_new_default);
                }
            }
        }
    }
}
