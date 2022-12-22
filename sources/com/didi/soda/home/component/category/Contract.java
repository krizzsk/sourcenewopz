package com.didi.soda.home.component.category;

import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/Contract;", "", "AbsAllCategoryPresenter", "AbsAllCategoryView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/Contract$AbsAllCategoryView;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/soda/home/component/category/Contract$AbsAllCategoryPresenter;", "()V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsAllCategoryView extends CustomerRecyclerView<AbsAllCategoryPresenter> {
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/Contract$AbsAllCategoryPresenter;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/soda/home/component/category/Contract$AbsAllCategoryView;", "()V", "fromPage", "", "getFromPage", "()Ljava/lang/String;", "setFromPage", "(Ljava/lang/String;)V", "getColumnCount", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsAllCategoryPresenter extends CustomerRecyclerPresenter<AbsAllCategoryView> {
        private String fromPage;

        public abstract int getColumnCount();

        public final String getFromPage() {
            return this.fromPage;
        }

        public final void setFromPage(String str) {
            this.fromPage = str;
        }
    }
}
