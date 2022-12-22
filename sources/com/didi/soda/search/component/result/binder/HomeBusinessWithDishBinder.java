package com.didi.soda.search.component.result.binder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.widget.dish.HomeBusinessWithDishNewItemView;

public class HomeBusinessWithDishBinder extends CustomerLogicItemBinder<HomeBusinessDishItemBinderLogic, HomeBusinessInfoRvModel, ViewHolder> {

    public static abstract class HomeBusinessDishItemBinderLogic extends BinderLogic<EmptyLogicRepo> implements HomeBusinessItemBinder.HomeBusinessOmegaInterface {
        public abstract void onDishImageClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, int i);

        public abstract void onDishItemShown(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, boolean z);

        public abstract void onShopClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel);
    }

    public boolean extraCanBindCondition(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        return homeBusinessInfoRvModel != null && TextUtils.equals(homeBusinessInfoRvModel.mComponentType, "4");
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(new HomeBusinessWithDishNewItemView(viewGroup.getContext()));
    }

    public Class<HomeBusinessInfoRvModel> bindDataType() {
        return HomeBusinessInfoRvModel.class;
    }

    public void bind(ViewHolder viewHolder, HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        ((HomeBusinessWithDishNewItemView) viewHolder.itemView).bindData(homeBusinessInfoRvModel, (HomeBusinessDishItemBinderLogic) getBinderLogic());
        ((HomeBusinessDishItemBinderLogic) getBinderLogic()).onOmegaBusinessSw(homeBusinessInfoRvModel, false);
    }

    public HomeBusinessDishItemBinderLogic onCreateBinderLogic() {
        return new HomeBusinessWithDishBinderLogic();
    }

    static class ViewHolder extends ItemViewHolder<HomeBusinessInfoRvModel> {
        ViewHolder(View view) {
            super(view);
        }
    }
}
