package com.didi.addressold.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.addressold.view.FavoritePlaceListAdapter;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class FavoritePlaceListView extends FrameLayout {
    public static final int FAVORITE_PLACE_COUNT_MAX = 10;

    /* renamed from: a */
    private RecyclerView f7909a;

    /* renamed from: b */
    private FavoritePlaceListAdapter f7910b;

    /* renamed from: c */
    private FavoritePlaceListAdapter.OnFavoritePlaceItemClickListener f7911c;

    public FavoritePlaceListView(Context context) {
        super(context);
        m5094a();
    }

    public FavoritePlaceListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5094a();
    }

    /* renamed from: a */
    private void m5094a() {
        LayoutInflater.from(getContext()).inflate(R.layout.old_layout_favorite_place_list, this);
        this.f7909a = (RecyclerView) findViewById(R.id.recycler_view);
        this.f7910b = new FavoritePlaceListAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.f7909a.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(1);
        this.f7909a.setAdapter(this.f7910b);
        FavoritePlaceListAdapter.OnFavoritePlaceItemClickListener onFavoritePlaceItemClickListener = this.f7911c;
        if (onFavoritePlaceItemClickListener != null) {
            this.f7910b.setOnItemClickListener(onFavoritePlaceItemClickListener);
        }
    }

    public void setFavoritePlaceItems(List<RpcCommonPoi> list, int i) {
        this.f7910b.updateItems(m5093a(list, i));
    }

    public void setOnFavoritePlaceItemClickListener(FavoritePlaceListAdapter.OnFavoritePlaceItemClickListener onFavoritePlaceItemClickListener) {
        this.f7911c = onFavoritePlaceItemClickListener;
        FavoritePlaceListAdapter favoritePlaceListAdapter = this.f7910b;
        if (favoritePlaceListAdapter != null) {
            favoritePlaceListAdapter.setOnItemClickListener(onFavoritePlaceItemClickListener);
        }
    }

    /* renamed from: a */
    private List<FavoritePlaceListAdapter.FavoritePlaceModel> m5093a(List<RpcCommonPoi> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            int i2 = 0;
            boolean z = false;
            boolean z2 = false;
            for (RpcCommonPoi next : list) {
                int i3 = next.type;
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            if (i == 0 && !z) {
                                arrayList.add(new FavoritePlaceListAdapter.FavoritePlaceModel(4, getContext().getString(R.string.global_favorite_place_list_header_favorite)));
                                z = true;
                            }
                            if (i == 0 || i == 2) {
                                arrayList.add(new FavoritePlaceListAdapter.FavoritePlaceModel(0, next));
                                i2++;
                            }
                        }
                    } else if (i == 0 || i == 1) {
                        if (!z2) {
                            arrayList.add(new FavoritePlaceListAdapter.FavoritePlaceModel(4, getContext().getString(R.string.global_favorite_place_list_header_home_and_company)));
                            z2 = true;
                        }
                        arrayList.add(new FavoritePlaceListAdapter.FavoritePlaceModel(2, next));
                    }
                } else if (i == 0 || i == 1) {
                    if (!z2) {
                        arrayList.add(new FavoritePlaceListAdapter.FavoritePlaceModel(4, getContext().getString(R.string.global_favorite_place_list_header_home_and_company)));
                        z2 = true;
                    }
                    arrayList.add(new FavoritePlaceListAdapter.FavoritePlaceModel(1, next));
                }
            }
            if (i2 < 10) {
                if (!z && i == 0) {
                    arrayList.add(new FavoritePlaceListAdapter.FavoritePlaceModel(4, getContext().getString(R.string.global_favorite_place_list_header_favorite)));
                }
                arrayList.add(new FavoritePlaceListAdapter.FavoritePlaceModel(3, getContext().getString(R.string.global_favorite_place_list_add_title), getContext().getString(R.string.global_favorite_place_list_add_content)));
            }
        }
        return arrayList;
    }

    public void showListDeleteButton(boolean z) {
        FavoritePlaceListAdapter favoritePlaceListAdapter = this.f7910b;
        if (favoritePlaceListAdapter != null) {
            favoritePlaceListAdapter.showDeleteButton(z);
        }
    }
}
