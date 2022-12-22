package com.didi.addressold.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.util.List;

public class FavoritePlaceListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f7906a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<FavoritePlaceModel> f7907b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnFavoritePlaceItemClickListener f7908c;

    public interface OnFavoritePlaceItemClickListener {
        void onDeleteClick(FavoritePlaceModel favoritePlaceModel);

        void onItemClick(FavoritePlaceModel favoritePlaceModel, int i);
    }

    public FavoritePlaceListAdapter(Context context) {
        this.f7906a = context;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return new FavoritePlaceViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.old_layout_favorite_place_list_item, viewGroup, false));
        }
        if (i != 4) {
            return null;
        }
        return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.old_layout_favorite_place_list_header, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        List<FavoritePlaceModel> list = this.f7907b;
        if (list != null && list.get(i) != null) {
            if (viewHolder instanceof FavoritePlaceViewHolder) {
                FavoritePlaceViewHolder favoritePlaceViewHolder = (FavoritePlaceViewHolder) viewHolder;
                favoritePlaceViewHolder.view.setCommonAddress(this.f7907b.get(i).rpcCommonPoi);
                favoritePlaceViewHolder.view.setDeleteState(this.f7907b.get(i).isShowDelImage);
                favoritePlaceViewHolder.view.setDeleteClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (FavoritePlaceListAdapter.this.f7908c != null) {
                            FavoritePlaceListAdapter.this.f7908c.onDeleteClick((FavoritePlaceModel) FavoritePlaceListAdapter.this.f7907b.get(i));
                            if (((FavoritePlaceModel) FavoritePlaceListAdapter.this.f7907b.get(i)).type == 1) {
                                ((FavoritePlaceModel) FavoritePlaceListAdapter.this.f7907b.get(i)).rpcCommonPoi = CommonAddressActivity.getBaseHome(FavoritePlaceListAdapter.this.f7906a);
                                ((FavoritePlaceModel) FavoritePlaceListAdapter.this.f7907b.get(i)).isShowDelImage = false;
                            } else if (((FavoritePlaceModel) FavoritePlaceListAdapter.this.f7907b.get(i)).type == 2) {
                                ((FavoritePlaceModel) FavoritePlaceListAdapter.this.f7907b.get(i)).rpcCommonPoi = CommonAddressActivity.getBaseCompany(FavoritePlaceListAdapter.this.f7906a);
                                ((FavoritePlaceModel) FavoritePlaceListAdapter.this.f7907b.get(i)).isShowDelImage = false;
                            }
                            FavoritePlaceListAdapter.this.notifyDataSetChanged();
                        }
                    }
                });
                favoritePlaceViewHolder.view.setDragClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (FavoritePlaceListAdapter.this.f7908c != null && !((FavoritePlaceModel) FavoritePlaceListAdapter.this.f7907b.get(i)).isShowDelImage) {
                            FavoritePlaceListAdapter.this.f7908c.onItemClick((FavoritePlaceModel) FavoritePlaceListAdapter.this.f7907b.get(i), i);
                        }
                    }
                });
            } else if (viewHolder instanceof HeaderViewHolder) {
                ((HeaderViewHolder) viewHolder).textView.setText(this.f7907b.get(i).title);
            }
        }
    }

    public int getItemViewType(int i) {
        List<FavoritePlaceModel> list = this.f7907b;
        if (list != null) {
            return list.get(i).type;
        }
        return 0;
    }

    public void updateItems(List<FavoritePlaceModel> list) {
        this.f7907b = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        List<FavoritePlaceModel> list = this.f7907b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void showDeleteButton(boolean z) {
        List<FavoritePlaceModel> list = this.f7907b;
        if (list != null) {
            for (FavoritePlaceModel next : list) {
                boolean z2 = next.rpcCommonPoi != null && (!TextUtils.isEmpty(next.rpcCommonPoi.address) || !TextUtils.isEmpty(next.rpcCommonPoi.addressDetail));
                if (!(next.type == 4 || next.type == 3 || !z2)) {
                    next.isShowDelImage = z;
                }
            }
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnFavoritePlaceItemClickListener onFavoritePlaceItemClickListener) {
        this.f7908c = onFavoritePlaceItemClickListener;
    }

    class FavoritePlaceViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public CommonAddressItemView view;

        public FavoritePlaceViewHolder(View view2) {
            super(view2);
            this.view = (CommonAddressItemView) view2.findViewById(R.id.item_view);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TextView textView;

        public HeaderViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.title);
        }
    }

    public static class FavoritePlaceModel {
        public static final int TYPE_ADD_FAVORITE = 3;
        public static final int TYPE_COMPANY = 2;
        public static final int TYPE_FAVORITE = 0;
        public static final int TYPE_HEADER = 4;
        public static final int TYPE_HOME = 1;
        public boolean isShowDelImage = false;
        public RpcCommonPoi rpcCommonPoi;
        public String title;
        public int type = 0;

        public FavoritePlaceModel(int i, RpcCommonPoi rpcCommonPoi2) {
            this.type = i;
            this.rpcCommonPoi = rpcCommonPoi2;
        }

        public FavoritePlaceModel(int i, String str) {
            this.type = i;
            this.title = str;
        }

        public FavoritePlaceModel(int i, String str, String str2) {
            this.type = i;
            RpcCommonPoi rpcCommonPoi2 = new RpcCommonPoi();
            rpcCommonPoi2.aliasName = str;
            rpcCommonPoi2.address = str2;
            rpcCommonPoi2.type = 5;
            this.rpcCommonPoi = rpcCommonPoi2;
        }
    }
}
