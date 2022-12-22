package com.didi.soda.home.topgun.binder;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.nova.assembly.p127ui.banner.OnBannerClickListener;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.util.CustomeRvExposeUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CustomerIndicator;
import com.didi.soda.customer.widget.scroll.HomeTopicSnapHelper;
import com.didi.soda.home.component.feed.adapter.HomeHorizontalScrollTopicAdapter;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel;
import com.didi.soda.home.topgun.manager.HomeBusinessPool;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.widget.HorizontalRecyclerView;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;

public class HomeHorizontalScrollTopicBinder extends CustomerLogicItemBinder<HomeHorizontalScrollTopicBinderLogic, HomeHorizontalScrollTopicRvModel, ViewHolder> {

    public static abstract class HomeHorizontalScrollTopicBinderLogic extends BinderLogic<EmptyLogicRepo> {
        public abstract void onItemViewVisible(HomeBusinessInfoRvModel homeBusinessInfoRvModel);

        public abstract void onTopicItemClicked(HomeBusinessInfoRvModel homeBusinessInfoRvModel);

        public abstract void onTopicShowAllClicked(HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel);
    }

    public HomeHorizontalScrollTopicBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    public HomeHorizontalScrollTopicBinderLogic onCreateBinderLogic() {
        return new HomeTopicOperationBinderLogicImpl();
    }

    public Class<HomeHorizontalScrollTopicRvModel> bindDataType() {
        return HomeHorizontalScrollTopicRvModel.class;
    }

    public void bind(final ViewHolder viewHolder, final HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel) {
        viewHolder.mTopicTitle.setText(homeHorizontalScrollTopicRvModel.mModuleTitle);
        if (((HomeHorizontalScrollTopicRvModel) viewHolder.getItem()).mMaxBusinessHeight > 0) {
            ViewGroup.LayoutParams layoutParams = viewHolder.mTopicRv.getLayoutParams();
            layoutParams.height = DisplayUtils.dip2px(viewHolder.itemView.getContext(), (float) ((HomeHorizontalScrollTopicRvModel) viewHolder.getItem()).mMaxBusinessHeight);
            viewHolder.mTopicRv.setLayoutParams(layoutParams);
        }
        C139951 r0 = new OnBannerClickListener() {
            public void onBannerClick(int i) {
                ((HomeHorizontalScrollTopicBinderLogic) HomeHorizontalScrollTopicBinder.this.getBinderLogic()).onTopicItemClicked(homeHorizontalScrollTopicRvModel.mBusinessInfoRvModels.get(i));
            }

            public void onBannerPageSelected(int i) {
                viewHolder.mTopicIndicator.setSelectedPage((i / 2) + (i % 2));
            }
        };
        HomeHorizontalScrollTopicAdapter homeHorizontalScrollTopicAdapter = new HomeHorizontalScrollTopicAdapter(r0, viewHolder.itemView.getContext());
        homeHorizontalScrollTopicAdapter.setData(homeHorizontalScrollTopicRvModel.mBusinessInfoRvModels);
        viewHolder.mTopicRv.setAdapter(homeHorizontalScrollTopicAdapter);
        if (viewHolder.mTopicRv.getOnFlingListener() == null) {
            new HomeTopicSnapHelper(r0).attachToRecyclerView(viewHolder.mTopicRv);
        }
        viewHolder.mTopicHeader.setOnClickListener(new View.OnClickListener(homeHorizontalScrollTopicRvModel) {
            public final /* synthetic */ HomeHorizontalScrollTopicRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeHorizontalScrollTopicBinder.this.m30187a(this.f$1, view);
            }
        });
        int size = homeHorizontalScrollTopicRvModel.mBusinessInfoRvModels.size();
        viewHolder.mTopicIndicator.initIndicator((size / 2) + (size % 2));
        new CustomeRvExposeUtil().setRecyclerItemExposeListener(viewHolder.mTopicRv, new CustomeRvExposeUtil.OnItemExposeListener(homeHorizontalScrollTopicRvModel) {
            public final /* synthetic */ HomeHorizontalScrollTopicRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemViewVisible(int i) {
                HomeHorizontalScrollTopicBinder.this.m30186a(this.f$1, i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30187a(HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel, View view) {
        ((HomeHorizontalScrollTopicBinderLogic) getBinderLogic()).onTopicShowAllClicked(homeHorizontalScrollTopicRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30186a(HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel, int i) {
        ((HomeHorizontalScrollTopicBinderLogic) getBinderLogic()).onItemViewVisible(homeHorizontalScrollTopicRvModel.mBusinessInfoRvModels.get(i));
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_item_home_scroll_topic, viewGroup, false));
    }

    class ViewHolder extends ItemViewHolder<HomeHorizontalScrollTopicRvModel> {
        /* access modifiers changed from: private */
        public final LinearLayout mTopicHeader;
        /* access modifiers changed from: private */
        public final CustomerIndicator mTopicIndicator;
        /* access modifiers changed from: private */
        public final HorizontalRecyclerView mTopicRv;
        private final TextView mTopicShowAll = ((TextView) findViewById(R.id.customer_tv_topic_show_all));
        /* access modifiers changed from: private */
        public final TextView mTopicTitle = ((TextView) findViewById(R.id.customer_tv_topic_title));

        ViewHolder(View view) {
            super(view);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mTopicTitle, IToolsService.FontType.LIGHT);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mTopicShowAll, IToolsService.FontType.LIGHT);
            this.mTopicHeader = (LinearLayout) findViewById(R.id.customer_ll_topic_header);
            this.mTopicRv = (HorizontalRecyclerView) findViewById(R.id.customer_rv_scroll_topic);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
            linearLayoutManager.setOrientation(0);
            this.mTopicRv.setLayoutManager(linearLayoutManager);
            this.mTopicRv.addItemDecoration(new TopicItemDecoration());
            this.mTopicIndicator = (CustomerIndicator) findViewById(R.id.customer_custom_indicator);
        }
    }

    static class TopicItemDecoration extends RecyclerView.ItemDecoration {
        TopicItemDecoration() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int dimensionPixelOffset = GlobalContext.getContext().getResources().getDimensionPixelOffset(R.dimen.customer_9px);
            if (((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition() == recyclerView.getAdapter().getItemCount() - 1) {
                int i = dimensionPixelOffset * 2;
                rect.set(i, 0, i, 0);
                return;
            }
            rect.set(dimensionPixelOffset * 2, 0, 0, 0);
        }
    }

    public static class HomeTopicOperationBinderLogicImpl extends HomeHorizontalScrollTopicBinderLogic {
        public Class<EmptyLogicRepo> bindLogicRepoType() {
            return EmptyLogicRepo.class;
        }

        public void onTopicItemClicked(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
            String str;
            HomeOmegaHelper.getInstance().setOmegaGuideParam(homeBusinessInfoRvModel);
            HomeOmegaHelper.getInstance().onOmegaBusinessCk(homeBusinessInfoRvModel, false);
            if (homeBusinessInfoRvModel.mPageId.equals("homePage") || homeBusinessInfoRvModel.mPageId.equals("showAll")) {
                str = HomeOmegaHelper.getInstance().getBusinessBiData(homeBusinessInfoRvModel);
            } else {
                str = null;
            }
            DiRouter.request().path(RoutePath.BUSINESS_HOME).putString(Const.PageParams.SHOP_ID, homeBusinessInfoRvModel.mShopId).putSerializable(Const.PageParams.SHOP_INFO_ENTITY, HomeBusinessPool.getPool().getBusiness(homeBusinessInfoRvModel.mShopId)).putString(Const.PageParams.BIDATA, str).open();
        }

        public void onTopicShowAllClicked(HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel) {
            DiRouter.request().path(RoutePath.TOPIC_PAGE).putString(Const.PageParams.HOME_COMPONENT_ID, homeHorizontalScrollTopicRvModel.mComponentId).putString(Const.PageParams.HOME_COMPONENT_TITLE, homeHorizontalScrollTopicRvModel.mModuleTitle).open();
            HomeOmegaHelper.getInstance().trackShowAllClick();
        }

        public void onItemViewVisible(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
            HomeOmegaHelper.getInstance().onOmegaBusinessSw(homeBusinessInfoRvModel, false);
        }
    }
}
