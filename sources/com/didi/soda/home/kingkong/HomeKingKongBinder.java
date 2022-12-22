package com.didi.soda.home.kingkong;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.util.CustomeRvExposeUtil;
import com.didi.soda.customer.foundation.util.CustomeRvExposeUtilOnlyNew;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.UrlBuilder;
import com.didi.soda.home.kingkong.HomeKingKongBinder;
import com.didi.soda.home.kingkong.HomeKingKongItemAdapter;
import com.didi.soda.home.manager.KingKongOmegaHelper;
import com.didi.soda.home.topgun.widget.HorizontalRecyclerView;
import com.taxis99.R;

public class HomeKingKongBinder extends CustomerLogicItemBinder<HomeKingKongBinderLogic, KingKongModel, ViewHolder> {
    public String TAG = getClass().getName();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f42650a = false;

    /* renamed from: b */
    private HomeKingKongItemAdapter.OnItemClickListener f42651b;

    public static abstract class HomeKingKongBinderLogic extends BinderLogic<EmptyLogicRepo> {
        public abstract void onItemViewVisible(KingKongItemModel kingKongItemModel, int i);
    }

    public void setOnItemClickListener(HomeKingKongItemAdapter.OnItemClickListener onItemClickListener) {
        this.f42651b = onItemClickListener;
    }

    public HomeKingKongBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    public HomeKingKongBinder() {
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_king_kong, viewGroup, false));
    }

    public HomeKingKongBinderLogic onCreateBinderLogic() {
        return new HomeKingKongBinderLogicImpl();
    }

    public void bind(ViewHolder viewHolder, KingKongModel kingKongModel) {
        if (kingKongModel != null && kingKongModel.getItems() != null) {
            if (viewHolder.mItemAdapter != null) {
                viewHolder.mItemAdapter.setData(kingKongModel.getItems());
            }
            viewHolder.mRv.scrollToPosition(0);
            viewHolder.setOnItemClickListener(this.f42651b);
            for (int i = 0; i < kingKongModel.getItems().size(); i++) {
                if (kingKongModel.getItems().get(i) != null && kingKongModel.getItems().get(i).getSelected().intValue() == 1) {
                    viewHolder.mRv.post(new Runnable(viewHolder, i) {
                        public final /* synthetic */ HomeKingKongBinder.ViewHolder f$1;
                        public final /* synthetic */ int f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            HomeKingKongBinder.this.m30132a(this.f$1, this.f$2);
                        }
                    });
                }
            }
            new CustomeRvExposeUtilOnlyNew().setRecyclerItemExposeListener(viewHolder.mRv, new CustomeRvExposeUtil.OnItemExposeListener(kingKongModel) {
                public final /* synthetic */ KingKongModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onItemViewVisible(int i) {
                    HomeKingKongBinder.this.m30133a(this.f$1, i);
                }
            });
            KingKongOmegaHelper.onKingKongShow(kingKongModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30132a(ViewHolder viewHolder, int i) {
        m30131a((RecyclerView) viewHolder.mRv, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30133a(KingKongModel kingKongModel, int i) {
        ((HomeKingKongBinderLogic) getBinderLogic()).onItemViewVisible(kingKongModel.getItems().get(i), i);
    }

    /* renamed from: a */
    private void m30131a(final RecyclerView recyclerView, final int i) {
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                        super.onScrollStateChanged(recyclerView, i);
                    }

                    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                        super.onScrolled(recyclerView, i, i2);
                        if (HomeKingKongBinder.this.f42650a) {
                            boolean unused = HomeKingKongBinder.this.f42650a = false;
                            RecyclerView recyclerView2 = recyclerView;
                            recyclerView2.post(new Runnable(recyclerView2, linearLayoutManager, i) {
                                public final /* synthetic */ RecyclerView f$1;
                                public final /* synthetic */ LinearLayoutManager f$2;
                                public final /* synthetic */ int f$3;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                    this.f$3 = r4;
                                }

                                public final void run() {
                                    HomeKingKongBinder.C139801.this.lambda$onScrolled$0$HomeKingKongBinder$1(this.f$1, this.f$2, this.f$3);
                                }
                            });
                        }
                    }

                    public /* synthetic */ void lambda$onScrolled$0$HomeKingKongBinder$1(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager, int i) {
                        HomeKingKongBinder.this.scrollToMiddle(recyclerView, linearLayoutManager, i);
                    }
                });
                if (isVisible(linearLayoutManager, i)) {
                    scrollToMiddle(recyclerView, linearLayoutManager, i);
                    return;
                }
                recyclerView.scrollToPosition(i);
                this.f42650a = true;
                return;
            }
            recyclerView.getLayoutManager().scrollToPosition(i);
        }
    }

    public void scrollToMiddle(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager, int i) {
        double width = (double) (recyclerView.getWidth() - ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_158));
        if (recyclerView.getChildAt(i) != null) {
            width = (double) recyclerView.getChildAt(i).getLeft();
        }
        double width2 = width - (((double) recyclerView.getWidth()) / 2.0d);
        String str = this.TAG;
        Log.d(str, " position:" + i + " left:" + width);
        String str2 = this.TAG;
        Log.d(str2, " position:" + i + " distance:" + width2);
        recyclerView.scrollBy((int) (width2 + ((double) (ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_158) / 2)) + ((double) (((FrameLayout.LayoutParams) recyclerView.getLayoutParams()).leftMargin / 2))), 0);
    }

    public boolean isVisible(LinearLayoutManager linearLayoutManager, int i) {
        return i <= linearLayoutManager.findLastVisibleItemPosition() && i >= linearLayoutManager.findFirstVisibleItemPosition();
    }

    public void accessUrl(KingKongItemModel kingKongItemModel, String str, ScopeContext scopeContext) {
        if (kingKongItemModel != null && kingKongItemModel.getUrl() != null) {
            UrlBuilder create = UrlBuilder.create(kingKongItemModel.getUrl());
            if (kingKongItemModel.getSubItems() != null) {
                create.appendParam(Const.PageParams.SUB_ITEMS, GsonUtil.toJson(kingKongItemModel.getSubItems()));
            }
            if (kingKongItemModel.getPayload() != null && !TextUtils.isEmpty(kingKongItemModel.getPayload().mRecId)) {
                create.appendParam("recid", kingKongItemModel.getPayload().mRecId);
            }
            if (!TextUtils.isEmpty(kingKongItemModel.getCateId())) {
                create.appendParam(Const.PageParams.KEY_CATE_ID, kingKongItemModel.getCateId());
            }
            create.appendParam(Const.PageParams.ALL_CATEGORY_PAGE_OPEN_SOURCE, "homepage");
            create.appendParam("homepage_source", "2");
            SchemeHelper.dispatchMsgForPageResultByPage(create.buildUri(), str, "", scopeContext, false);
        }
    }

    public Class<KingKongModel> bindDataType() {
        return KingKongModel.class;
    }

    static class ViewHolder extends ItemViewHolder<KingKongModel> {
        /* access modifiers changed from: private */
        public final HomeKingKongItemAdapter mItemAdapter = new HomeKingKongItemAdapter();
        /* access modifiers changed from: private */
        public final HorizontalRecyclerView mRv = ((HorizontalRecyclerView) findViewById(R.id.customer_rv_scroll_topic));

        ViewHolder(View view) {
            super(view);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
            linearLayoutManager.setOrientation(0);
            this.mRv.setLayoutManager(linearLayoutManager);
            this.mRv.setAdapter(this.mItemAdapter);
            this.mRv.setHasFixedSize(true);
            this.mRv.setNestedScrollingEnabled(false);
        }

        public void setOnItemClickListener(HomeKingKongItemAdapter.OnItemClickListener onItemClickListener) {
            this.mItemAdapter.setOnItemClickListener(onItemClickListener);
        }
    }

    public static class HomeKingKongBinderLogicImpl extends HomeKingKongBinderLogic {
        public Class<EmptyLogicRepo> bindLogicRepoType() {
            return EmptyLogicRepo.class;
        }

        public void onItemViewVisible(KingKongItemModel kingKongItemModel, int i) {
            KingKongOmegaHelper.onKingKongItemShow(kingKongItemModel, i);
        }
    }
}
