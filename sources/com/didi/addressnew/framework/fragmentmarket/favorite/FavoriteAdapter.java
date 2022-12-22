package com.didi.addressnew.framework.fragmentmarket.favorite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.addressnew.framework.fragmentmarket.favorite.FavoriteSwipeCallback;
import com.didi.autotracker.AutoTrackHelper;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteHolder> implements FavoriteSwipeCallback.OnItemSwipeListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<FavoriteAddressModel> f4410a = new ArrayList();

    /* renamed from: b */
    private boolean f4411b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnFavoriteItemClickListener f4412c;

    /* renamed from: d */
    private OnNoDataListener f4413d;

    public interface OnFavoriteItemClickListener {
        void onAddClick();

        void onDeleteClick(FavoriteAddressModel favoriteAddressModel);

        void onItemClick(FavoriteAddressModel favoriteAddressModel, int i);
    }

    public interface OnNoDataListener {
        void onNoData();
    }

    public void updateData(List<FavoriteAddressModel> list) {
        this.f4410a.clear();
        this.f4410a.addAll(list);
        notifyDataSetChanged();
    }

    public void setOnFavoriteItemClickListener(OnFavoriteItemClickListener onFavoriteItemClickListener) {
        this.f4412c = onFavoriteItemClickListener;
    }

    public void setOnNoDataListener(OnNoDataListener onNoDataListener) {
        this.f4413d = onNoDataListener;
    }

    public void setHasHeaderAndFooter(boolean z) {
        this.f4411b = z;
    }

    public void onItemDimiss(RecyclerView.ViewHolder viewHolder) {
        OnNoDataListener onNoDataListener;
        FavoriteAddressModel favoriteAddressModel = (FavoriteAddressModel) viewHolder.itemView.getTag();
        int indexOf = this.f4410a.indexOf(favoriteAddressModel);
        this.f4410a.remove(favoriteAddressModel);
        notifyItemRemoved(indexOf);
        if (((this.f4411b && this.f4410a.size() == 2) || (!this.f4411b && this.f4410a.size() == 0)) && (onNoDataListener = this.f4413d) != null) {
            onNoDataListener.onNoData();
        }
        OnFavoriteItemClickListener onFavoriteItemClickListener = this.f4412c;
        if (onFavoriteItemClickListener != null) {
            onFavoriteItemClickListener.onDeleteClick(favoriteAddressModel);
        }
    }

    public FavoriteHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_favorite_list_item, viewGroup, false));
        }
        if (i == 3) {
            return new FooterHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_favorite_list_footer, viewGroup, false));
        }
        if (i == 4) {
            return new HeaderHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_favorite_list_header, viewGroup, false));
        }
        if (i == 5) {
            return new EmptyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_favorite_list_empty, viewGroup, false));
        }
        if (i == 6) {
            return new SmallEmptyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_favorite_small_empty, viewGroup, false));
        }
        if (i != 7) {
            return null;
        }
        return new ItemNoArrowHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_favorite_list_item_no_arrow, viewGroup, false));
    }

    public void onBindViewHolder(FavoriteHolder favoriteHolder, int i) {
        favoriteHolder.onBind(i);
    }

    public int getItemCount() {
        List<FavoriteAddressModel> list = this.f4410a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        List<FavoriteAddressModel> list = this.f4410a;
        if (list != null) {
            return list.get(i).type;
        }
        return 0;
    }

    class EmptyHolder extends FavoriteHolder implements View.OnClickListener {
        TextView emptyAddFavorite;

        /* access modifiers changed from: package-private */
        public void onBind(int i) {
        }

        public EmptyHolder(View view) {
            super(view);
            this.emptyAddFavorite = (TextView) view.findViewById(R.id.favorite_empty_add);
            try {
                this.emptyAddFavorite.setTextColor(ContextCompat.getColorStateList(this.emptyAddFavorite.getContext(), DidiThemeManager.getIns().getResPicker(this.emptyAddFavorite.getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
                this.emptyAddFavorite.setBackground(DidiThemeManager.getIns().getResPicker(this.emptyAddFavorite.getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.emptyAddFavorite.setOnClickListener(this);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (FavoriteAdapter.this.f4412c != null) {
                FavoriteAdapter.this.f4412c.onAddClick();
            }
        }
    }

    class SmallEmptyHolder extends FavoriteHolder implements View.OnClickListener {
        TextView emptyAddFavorite;

        /* access modifiers changed from: package-private */
        public void onBind(int i) {
        }

        public SmallEmptyHolder(View view) {
            super(view);
            this.emptyAddFavorite = (TextView) view.findViewById(R.id.favorite_empty_add);
            try {
                this.emptyAddFavorite.setTextColor(ContextCompat.getColorStateList(this.emptyAddFavorite.getContext(), DidiThemeManager.getIns().getResPicker(this.emptyAddFavorite.getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
                this.emptyAddFavorite.setBackground(DidiThemeManager.getIns().getResPicker(this.emptyAddFavorite.getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.emptyAddFavorite.setOnClickListener(this);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (FavoriteAdapter.this.f4412c != null) {
                FavoriteAdapter.this.f4412c.onAddClick();
            }
        }
    }

    class ItemHolder extends FavoriteHolder implements View.OnClickListener {
        TextView mAddressDesc;
        ImageView mAddressIcon;
        TextView mAddressName;
        TextView mDeleteView;

        public ItemHolder(View view) {
            super(view);
            this.mAddressIcon = (ImageView) view.findViewById(R.id.favorite_address_icon);
            this.mDeleteView = (TextView) view.findViewById(R.id.favorite_delete_btn);
            this.mAddressName = (TextView) view.findViewById(R.id.favorite_address_name);
            this.mAddressDesc = (TextView) view.findViewById(R.id.favorite_address_desc);
        }

        /* access modifiers changed from: package-private */
        public void onBind(int i) {
            FavoriteAddressModel favoriteAddressModel = (FavoriteAddressModel) FavoriteAdapter.this.f4410a.get(i);
            RpcCommonPoi rpcCommonPoi = favoriteAddressModel.rpcCommonPoi;
            this.mAddressName.setText(rpcCommonPoi.aliasName);
            this.mAddressDesc.setText(rpcCommonPoi.address);
            ((RequestBuilder) Glide.with(this.itemView.getContext().getApplicationContext()).load(rpcCommonPoi.pre_logo_url).error((int) R.drawable.icon_position)).into(this.mAddressIcon);
            this.itemView.setTag(favoriteAddressModel);
            this.itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (FavoriteAdapter.this.f4412c != null) {
                FavoriteAddressModel favoriteAddressModel = (FavoriteAddressModel) this.itemView.getTag();
                FavoriteAdapter.this.f4412c.onItemClick(favoriteAddressModel, FavoriteAdapter.this.f4410a.indexOf(favoriteAddressModel));
            }
        }
    }

    class ItemNoArrowHolder extends FavoriteHolder implements View.OnClickListener {
        TextView mAddressDesc;
        ImageView mAddressIcon;
        TextView mAddressName;

        public ItemNoArrowHolder(View view) {
            super(view);
            this.mAddressIcon = (ImageView) view.findViewById(R.id.favorite_address_icon);
            this.mAddressName = (TextView) view.findViewById(R.id.favorite_address_name);
            this.mAddressDesc = (TextView) view.findViewById(R.id.favorite_address_desc);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (FavoriteAdapter.this.f4412c != null) {
                FavoriteAddressModel favoriteAddressModel = (FavoriteAddressModel) this.itemView.getTag();
                FavoriteAdapter.this.f4412c.onItemClick(favoriteAddressModel, FavoriteAdapter.this.f4410a.indexOf(favoriteAddressModel));
            }
        }

        /* access modifiers changed from: package-private */
        public void onBind(int i) {
            FavoriteAddressModel favoriteAddressModel = (FavoriteAddressModel) FavoriteAdapter.this.f4410a.get(i);
            RpcCommonPoi rpcCommonPoi = favoriteAddressModel.rpcCommonPoi;
            this.mAddressName.setText(rpcCommonPoi.aliasName);
            this.mAddressDesc.setText(rpcCommonPoi.address);
            ((RequestBuilder) Glide.with(this.itemView.getContext().getApplicationContext()).load(rpcCommonPoi.pre_logo_url).error((int) R.drawable.icon_position)).into(this.mAddressIcon);
            this.itemView.setTag(favoriteAddressModel);
            this.itemView.setOnClickListener(this);
        }
    }

    class HeaderHolder extends FavoriteHolder {
        /* access modifiers changed from: package-private */
        public void onBind(int i) {
        }

        public HeaderHolder(View view) {
            super(view);
        }
    }

    class FooterHolder extends FavoriteHolder implements View.OnClickListener {
        public FooterHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: package-private */
        public void onBind(int i) {
            this.itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (FavoriteAdapter.this.f4412c != null) {
                FavoriteAdapter.this.f4412c.onAddClick();
            }
        }
    }

    abstract class FavoriteHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: package-private */
        public abstract void onBind(int i);

        public FavoriteHolder(View view) {
            super(view);
        }
    }

    public static class FavoriteAddressModel {
        public static final int TYPE_ADD_FAVORITE = 3;
        public static final int TYPE_COMPANY = 2;
        public static final int TYPE_EMPTY = 5;
        public static final int TYPE_FAVORITE = 0;
        public static final int TYPE_FAVORITE_NO_ARROW = 7;
        public static final int TYPE_HEADER = 4;
        public static final int TYPE_HOME = 1;
        public static final int TYPE_SMALL_EMPTY = 6;
        public boolean isShowDelImage = false;
        public RpcCommonPoi rpcCommonPoi;
        public String title;
        public int type = 0;

        public FavoriteAddressModel(int i) {
            this.type = i;
        }

        public FavoriteAddressModel(int i, RpcCommonPoi rpcCommonPoi2) {
            this.type = i;
            this.rpcCommonPoi = rpcCommonPoi2;
        }

        public FavoriteAddressModel(int i, String str) {
            this.type = i;
            this.title = str;
        }

        public FavoriteAddressModel(int i, String str, String str2) {
            this.type = i;
            RpcCommonPoi rpcCommonPoi2 = new RpcCommonPoi();
            rpcCommonPoi2.aliasName = str;
            rpcCommonPoi2.address = str2;
            rpcCommonPoi2.type = 5;
            this.rpcCommonPoi = rpcCommonPoi2;
        }
    }
}
