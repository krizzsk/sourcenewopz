package com.didi.soda.business.component.dynamic.category;

import com.didi.soda.business.model.BusinessCategoryMenuRvModel;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/category/Contract;", "", "AbsCategoryPresenter", "AbsCategoryView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/category/Contract$AbsCategoryPresenter;", "Lcom/didi/soda/customer/base/ICustomerPresenter;", "Lcom/didi/soda/business/component/dynamic/category/Contract$AbsCategoryView;", "()V", "getDefaultSelectedIndex", "", "onDismiss", "", "type", "onItemClick", "index", "item", "Lcom/didi/soda/business/model/BusinessCategoryMenuRvModel;", "onItemExposure", "selectedCategory", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsCategoryPresenter extends ICustomerPresenter<AbsCategoryView> {
        public abstract int getDefaultSelectedIndex();

        public abstract void onDismiss(int i);

        public abstract void onItemClick(int i, BusinessCategoryMenuRvModel businessCategoryMenuRvModel);

        public abstract void onItemExposure(int i, BusinessCategoryMenuRvModel businessCategoryMenuRvModel);

        public abstract void selectedCategory(int i);
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/category/Contract$AbsCategoryView;", "Lcom/didi/soda/customer/base/ICustomerView;", "Lcom/didi/soda/business/component/dynamic/category/Contract$AbsCategoryPresenter;", "()V", "bindCategoryList", "", "categoryList", "", "Lcom/didi/soda/business/model/BusinessCategoryMenuRvModel;", "dismissCategory", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsCategoryView extends ICustomerView<AbsCategoryPresenter> {
        public abstract void bindCategoryList(List<? extends BusinessCategoryMenuRvModel> list);

        public abstract void dismissCategory();
    }
}
