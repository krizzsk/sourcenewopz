package com.didi.addressnew.framework.fragmentmarket.favorite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.addressnew.framework.fragmentmarket.favorite.FavoriteAdapter;
import com.didi.addressnew.util.ViewUtils;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class FavoriteListView extends FrameLayout implements FavoriteAdapter.OnNoDataListener {
    public static final int MAX_FAVORITE_CNT = 10;

    /* renamed from: a */
    private int f4418a;

    /* renamed from: b */
    private RecyclerView f4419b;

    /* renamed from: c */
    private FavoriteAdapter f4420c;

    /* renamed from: d */
    private View f4421d;

    /* renamed from: e */
    private boolean f4422e;

    /* renamed from: f */
    private FavoriteAdapter.OnFavoriteItemClickListener f4423f;

    public FavoriteListView(Context context) {
        this(context, (AttributeSet) null, -1);
    }

    public FavoriteListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public FavoriteListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2754a();
    }

    /* renamed from: a */
    private void m2754a() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_favorite_list, this);
        this.f4419b = (RecyclerView) findViewById(R.id.recycler_view);
        this.f4420c = new FavoriteAdapter();
        this.f4419b.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f4419b.setAdapter(this.f4420c);
        this.f4420c.setOnNoDataListener(this);
        FavoriteSwipeCallback favoriteSwipeCallback = new FavoriteSwipeCallback(0.27f, ViewUtils.dip2px(getContext(), 94.0f));
        favoriteSwipeCallback.setOnItemSwipeListener(this.f4420c);
        new ItemTouchHelper(favoriteSwipeCallback).attachToRecyclerView(this.f4419b);
    }

    public void setOnFavoriteItemClickListener(FavoriteAdapter.OnFavoriteItemClickListener onFavoriteItemClickListener) {
        this.f4423f = onFavoriteItemClickListener;
        FavoriteAdapter favoriteAdapter = this.f4420c;
        if (favoriteAdapter != null) {
            favoriteAdapter.setOnFavoriteItemClickListener(onFavoriteItemClickListener);
        }
    }

    public void setHasHeaderAndFooter(boolean z) {
        this.f4422e = z;
        FavoriteAdapter favoriteAdapter = this.f4420c;
        if (favoriteAdapter != null) {
            favoriteAdapter.setHasHeaderAndFooter(z);
        }
    }

    public void setAddFavoriteBtn(View view) {
        this.f4421d = view;
    }

    public int getTotalFavoriteCnt() {
        return this.f4422e ? this.f4420c.getItemCount() - 2 : this.f4420c.getItemCount();
    }

    public void setFavoriteItems(List<RpcCommonPoi> list) {
        this.f4418a = 0;
        this.f4420c.updateData(m2753a(list));
    }

    /* renamed from: a */
    private List<FavoriteAdapter.FavoriteAddressModel> m2753a(List<RpcCommonPoi> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (RpcCommonPoi next : list) {
                if (next.type == 5) {
                    if (this.f4422e) {
                        arrayList.add(new FavoriteAdapter.FavoriteAddressModel(0, next));
                    } else {
                        arrayList.add(new FavoriteAdapter.FavoriteAddressModel(7, next));
                    }
                    this.f4418a++;
                }
            }
            if (this.f4422e) {
                arrayList.add(0, new FavoriteAdapter.FavoriteAddressModel(4));
                arrayList.add(this.f4418a + 1, new FavoriteAdapter.FavoriteAddressModel(3));
            }
            View view = this.f4421d;
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (list.size() == 0) {
            if (this.f4422e) {
                arrayList.add(new FavoriteAdapter.FavoriteAddressModel(6));
            } else {
                arrayList.add(new FavoriteAdapter.FavoriteAddressModel(5));
            }
            View view2 = this.f4421d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        return arrayList;
    }

    public void onNoData() {
        setFavoriteItems(new ArrayList());
    }
}
