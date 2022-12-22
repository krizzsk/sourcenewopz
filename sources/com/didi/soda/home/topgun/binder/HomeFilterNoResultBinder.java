package com.didi.soda.home.topgun.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel;
import com.didi.soda.home.topgun.manager.FilterNoResultLogicRepo;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.widget.HomeFilterNoResultView;

public class HomeFilterNoResultBinder extends CustomerLogicItemBinder<HomeFilterNoResultLogic, HomeNoResultRvModel, ViewHolder> {

    public static abstract class HomeFilterNoResultLogic extends BinderLogic<FilterNoResultLogicRepo> {
        public abstract HomeFilterNoResultView.ResetSizeListener getResetListener();

        public abstract void onButtonClick();
    }

    public HomeFilterNoResultBinder(ComponentLogicUnit componentLogicUnit) {
        super(componentLogicUnit);
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(new HomeFilterNoResultView(viewGroup.getContext()));
    }

    public void bind(ViewHolder viewHolder, HomeNoResultRvModel homeNoResultRvModel) {
        HomeFilterNoResultView homeFilterNoResultView = (HomeFilterNoResultView) viewHolder.itemView;
        homeFilterNoResultView.setResetSizeListener(((HomeFilterNoResultLogic) getBinderLogic()).getResetListener());
        homeFilterNoResultView.reset(homeNoResultRvModel);
        homeFilterNoResultView.show(homeNoResultRvModel);
        viewHolder.mTryButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeFilterNoResultBinder.this.lambda$bind$0$HomeFilterNoResultBinder(view);
            }
        });
        HomeOmegaHelper.getInstance().onFilterNoResultSw(homeNoResultRvModel.mSelectFilter, homeNoResultRvModel.mPage, homeNoResultRvModel.mCateId, homeNoResultRvModel.recId);
    }

    public /* synthetic */ void lambda$bind$0$HomeFilterNoResultBinder(View view) {
        ((HomeFilterNoResultLogic) getBinderLogic()).onButtonClick();
    }

    public Class<HomeNoResultRvModel> bindDataType() {
        return HomeNoResultRvModel.class;
    }

    public HomeFilterNoResultLogic onCreateBinderLogic() {
        return new HomeFilterNoResultLogic() {
            public HomeFilterNoResultView.ResetSizeListener getResetListener() {
                return null;
            }

            public Class<FilterNoResultLogicRepo> bindLogicRepoType() {
                return FilterNoResultLogicRepo.class;
            }

            public void onButtonClick() {
                ((FilterNoResultLogicRepo) ((HomeFilterNoResultLogic) HomeFilterNoResultBinder.this.getBinderLogic()).getLogicRepo()).setValue(1);
            }
        };
    }

    static class ViewHolder extends ItemViewHolder<HomeNoResultRvModel> {
        View mTryButton;

        ViewHolder(View view) {
            super(view);
            this.mTryButton = view.findViewWithTag("RETRY");
        }
    }
}
