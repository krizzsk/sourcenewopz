package com.didi.soda.business.component.category;

import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/Contract;", "", "AbsCategoryPresenter", "AbsCategoryView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH&¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/Contract$AbsCategoryPresenter;", "Lcom/didi/soda/customer/base/ICustomerPresenter;", "Lcom/didi/soda/business/component/category/Contract$AbsCategoryView;", "()V", "dismissCategory", "", "onDismiss", "type", "", "onItemClick", "index", "item", "Lcom/didi/soda/business/model/BusinessCategoryRvModel;", "onItemExposure", "selectedCategory", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsCategoryPresenter extends ICustomerPresenter<AbsCategoryView> {
        public abstract void dismissCategory();

        public abstract void onDismiss(int i);

        public abstract void onItemClick(int i, BusinessCategoryRvModel businessCategoryRvModel);

        public abstract void onItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel);

        public abstract void selectedCategory(int i);
    }

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/Contract$AbsCategoryView;", "Lcom/didi/soda/customer/base/ICustomerView;", "Lcom/didi/soda/business/component/category/Contract$AbsCategoryPresenter;", "()V", "bindCategoryList", "", "categoryList", "", "Lcom/didi/soda/business/model/BusinessCategoryRvModel;", "dismissCategory", "setShopName", "shopName", "", "updateContainerTopPadding", "isShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsCategoryView extends ICustomerView<AbsCategoryPresenter> {
        public abstract void bindCategoryList(List<? extends BusinessCategoryRvModel> list);

        public abstract void dismissCategory();

        public abstract void setShopName(String str);

        public abstract void updateContainerTopPadding(boolean z);
    }
}
