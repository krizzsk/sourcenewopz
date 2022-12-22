package com.didi.soda.home.topgun.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.foundation.login.LoginListener;
import com.didi.soda.home.component.feed.adapter.HomeEfoListAdapter;
import com.didi.soda.home.topgun.binder.model.HomeEfoRvModel;
import com.didi.soda.home.topgun.manager.HomeEfoJumpHelper;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.widget.HomeEfoListView;
import com.didi.soda.home.topgun.widget.HomeSceneView;

public class HomeEfoBinder extends CustomerLogicItemBinder<HomeEfoBinderLogic, HomeEfoRvModel, ViewHolder> {

    /* renamed from: a */
    ScopeContext f42753a;

    public HomeEfoBinder(ScopeContext scopeContext, ItemDecorator itemDecorator) {
        super(itemDecorator);
        this.f42753a = scopeContext;
    }

    public HomeEfoBinderLogic onCreateBinderLogic() {
        return new HomeEfoBinderLogicImpl();
    }

    public Class<HomeEfoRvModel> bindDataType() {
        return HomeEfoRvModel.class;
    }

    public void bind(ViewHolder viewHolder, HomeEfoRvModel homeEfoRvModel) {
        HomeOmegaHelper.getInstance().trackHomeEfoSw(homeEfoRvModel);
        ((HomeSceneView) viewHolder.itemView).bindData(homeEfoRvModel);
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(new HomeSceneView(viewGroup.getContext()) {
            public void onTitleClicked(View view, HomeEfoRvModel homeEfoRvModel) {
                ((HomeEfoBinderLogic) HomeEfoBinder.this.getBinderLogic()).onEfoPageEntered(1, homeEfoRvModel);
            }

            public void bindContentView(View view, Context context, HomeEfoRvModel homeEfoRvModel) {
                if (homeEfoRvModel != null && homeEfoRvModel.mEfoGoodsList != null && homeEfoRvModel.mEfoGoodsList.size() > 0) {
                    ((HomeEfoListView) view).bindData(homeEfoRvModel, new HomeEfoListAdapter.EfoListener() {
                        public void onEfoItemExposured(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                            ((HomeEfoBinderLogic) HomeEfoBinder.this.getBinderLogic()).onEfoItemExposured(i, businessGoodsItemRvModel);
                        }

                        public void onEfoItemClicked(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                            ((HomeEfoBinderLogic) HomeEfoBinder.this.getBinderLogic()).onEfoItemClicked(i, businessGoodsItemRvModel);
                        }

                        public void onEfoBuyButtonClicked(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                            ((HomeEfoBinderLogic) HomeEfoBinder.this.getBinderLogic()).onEfoBuyButtonClicked(i, businessGoodsItemRvModel);
                        }

                        public void onEfoMoreClicked(HomeEfoRvModel homeEfoRvModel) {
                            ((HomeEfoBinderLogic) HomeEfoBinder.this.getBinderLogic()).onEfoPageEntered(2, homeEfoRvModel);
                        }
                    });
                }
            }

            public View generateContentView(Context context) {
                return new HomeEfoListView(context);
            }
        });
    }

    class ViewHolder extends ItemViewHolder<HomeEfoRvModel> {
        ViewHolder(View view) {
            super(view);
        }
    }

    abstract class HomeEfoBinderLogic extends BinderLogic<EmptyLogicRepo> {
        /* access modifiers changed from: package-private */
        public abstract void onEfoBuyButtonClicked(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel);

        /* access modifiers changed from: package-private */
        public abstract void onEfoItemClicked(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel);

        /* access modifiers changed from: package-private */
        public abstract void onEfoItemExposured(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel);

        /* access modifiers changed from: package-private */
        public abstract void onEfoPageEntered(int i, HomeEfoRvModel homeEfoRvModel);

        HomeEfoBinderLogic() {
        }
    }

    private class HomeEfoBinderLogicImpl extends HomeEfoBinderLogic {
        private HomeEfoBinderLogicImpl() {
            super();
        }

        public Class<EmptyLogicRepo> bindLogicRepoType() {
            return EmptyLogicRepo.class;
        }

        /* access modifiers changed from: package-private */
        public void onEfoItemExposured(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
            HomeOmegaHelper.getInstance().trackEfoItemExposure(i, businessGoodsItemRvModel);
        }

        /* access modifiers changed from: package-private */
        public void onEfoItemClicked(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
            HomeOmegaHelper.getInstance().trackEfoItemCk(i, businessGoodsItemRvModel);
            HomeEfoJumpHelper.handleEfoItemClicked(HomeEfoBinder.this.f42753a, 7, businessGoodsItemRvModel.mBusinessId, businessGoodsItemRvModel.mGoodsId, (LoginListener) null);
        }

        /* access modifiers changed from: package-private */
        public void onEfoBuyButtonClicked(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
            HomeOmegaHelper.getInstance().trackEfoBuyButtonCk(i, businessGoodsItemRvModel);
            HomeEfoJumpHelper.handleEfoItemBuyClicked(HomeEfoBinder.this.f42753a, 7, businessGoodsItemRvModel, (HomeEfoBinder.this.f42753a == null || HomeEfoBinder.this.f42753a.getObject("PageName") == null) ? "" : (String) HomeEfoBinder.this.f42753a.getObject("PageName"), (LoginListener) null);
        }

        /* access modifiers changed from: package-private */
        public void onEfoPageEntered(int i, HomeEfoRvModel homeEfoRvModel) {
            HomeOmegaHelper.getInstance().trackEfoPageEntered(i, homeEfoRvModel);
            HomeEfoJumpHelper.goToEfoPage(homeEfoRvModel, i);
        }
    }
}
