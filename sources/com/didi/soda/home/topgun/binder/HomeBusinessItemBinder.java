package com.didi.soda.home.topgun.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.manager.HomeBusinessPool;
import com.didi.soda.home.topgun.manager.HomeLogTrackerHelper;
import com.didi.soda.home.topgun.widget.HomeBusinessItemView;
import com.didi.soda.router.DiRouter;
import java.util.HashMap;

public class HomeBusinessItemBinder extends CustomerLogicItemBinder<HomeBusinessItemBinderLogic, HomeBusinessInfoRvModel, ViewHolder> {

    public static abstract class HomeBusinessItemBinderLogic extends BinderLogic<EmptyLogicRepo> implements HomeBusinessOmegaInterface {
        public abstract void onItemClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel);

        public abstract void setBusinessOmegaInterface(HomeBusinessOmegaInterface homeBusinessOmegaInterface);
    }

    public interface HomeBusinessOmegaInterface {
        String getBusinessBiData(HomeBusinessInfoRvModel homeBusinessInfoRvModel);

        void onOmegaBusinessCk(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z);

        void onOmegaBusinessSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z);

        void setOmegaGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel);
    }

    public HomeBusinessItemBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    public HomeBusinessItemBinder(ItemDecorator itemDecorator, HomeBusinessOmegaInterface homeBusinessOmegaInterface) {
        super(itemDecorator);
        ((HomeBusinessItemBinderLogic) getBinderLogic()).setBusinessOmegaInterface(homeBusinessOmegaInterface);
    }

    public HomeBusinessItemBinderLogic onCreateBinderLogic() {
        return new HomeBusinessItemBinderLogicImpl();
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(new HomeBusinessItemView(viewGroup.getContext()));
    }

    public void bind(ViewHolder viewHolder, HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        ((HomeBusinessItemView) viewHolder.itemView).bindData(homeBusinessInfoRvModel, (HomeBusinessItemBinderLogic) getBinderLogic());
        ((HomeBusinessItemBinderLogic) getBinderLogic()).onOmegaBusinessSw(homeBusinessInfoRvModel, false);
    }

    public Class<HomeBusinessInfoRvModel> bindDataType() {
        return HomeBusinessInfoRvModel.class;
    }

    static class ViewHolder extends ItemViewHolder<HomeBusinessInfoRvModel> {
        ViewHolder(View view) {
            super(view);
        }
    }

    public static class HomeBusinessItemBinderLogicImpl extends HomeBusinessItemBinderLogic {
        private HomeBusinessOmegaInterface mOmegaImpl;

        public Class<EmptyLogicRepo> bindLogicRepoType() {
            return EmptyLogicRepo.class;
        }

        public void onItemClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
            setOmegaGuideParam(homeBusinessInfoRvModel);
            onOmegaBusinessCk(homeBusinessInfoRvModel, false);
            openBusinessHomePage(homeBusinessInfoRvModel);
        }

        public void openBusinessHomePage(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
            String str;
            if (homeBusinessInfoRvModel.mPageId.equals("homePage") || homeBusinessInfoRvModel.mPageId.equals("showAll")) {
                str = getBusinessBiData(homeBusinessInfoRvModel);
            } else {
                str = null;
            }
            DiRouter.request().path(RoutePath.BUSINESS_HOME).putString(Const.PageParams.SHOP_ID, homeBusinessInfoRvModel.mShopId).putSerializable(Const.PageParams.SHOP_INFO_ENTITY, HomeBusinessPool.getPool().getBusiness(homeBusinessInfoRvModel.mShopId)).putString(Const.PageParams.BIDATA, str).open();
            HashMap hashMap = new HashMap();
            hashMap.put("shopId", homeBusinessInfoRvModel.mShopId);
            hashMap.put("shopName", homeBusinessInfoRvModel.mShopName);
            HomeLogTrackerHelper.setLogTracker("onBusinessClick", "c-act|", hashMap);
        }

        public void setBusinessOmegaInterface(HomeBusinessOmegaInterface homeBusinessOmegaInterface) {
            this.mOmegaImpl = homeBusinessOmegaInterface;
        }

        public void onOmegaBusinessSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
            this.mOmegaImpl.onOmegaBusinessSw(homeBusinessInfoRvModel, z);
        }

        public void onOmegaBusinessCk(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
            this.mOmegaImpl.onOmegaBusinessCk(homeBusinessInfoRvModel, z);
        }

        public void setOmegaGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
            this.mOmegaImpl.setOmegaGuideParam(homeBusinessInfoRvModel);
        }

        public String getBusinessBiData(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
            return this.mOmegaImpl.getBusinessBiData(homeBusinessInfoRvModel);
        }
    }
}
