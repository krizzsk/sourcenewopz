package com.didi.soda.home.topgun.component.topicact;

import android.os.Bundle;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.soda.blocks.scope.BlockScopeBase;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/Contract;", "", "AbsTopicActivityPresenter", "AbsTopicActivityView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u001c\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/Contract$AbsTopicActivityView;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/soda/home/topgun/component/topicact/Contract$AbsTopicActivityPresenter;", "()V", "calculateAbnormalHeight", "", "dismissLoadingDialog", "", "fillRecyclerViewContentHeight", "hasMore", "", "intoFloating", "resetStyle", "scrollToFloatingState", "anchorTarget", "isFilterNone", "scrollToLastOffest", "scrollToTop", "setConfigScene", "scene", "setRules", "rules", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;", "activityId", "", "setStyleByColorAndHeader", "color", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$BgColorBean;", "hasHeader", "setTitle", "title", "showLoadingView", "showNavBarWhenError", "showNavBarWhenNormal", "showNetErrorToast", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsTopicActivityView extends CustomerRecyclerView<AbsTopicActivityPresenter> {
        public int calculateAbnormalHeight() {
            return 0;
        }

        public void dismissLoadingDialog() {
        }

        public abstract void fillRecyclerViewContentHeight(boolean z);

        public abstract void intoFloating();

        public void resetStyle() {
        }

        public abstract void scrollToFloatingState(int i, boolean z);

        public void scrollToLastOffest() {
        }

        public void scrollToTop() {
        }

        public void setConfigScene(int i) {
        }

        public void setRules(ActivityInfoEntity.RuleLink ruleLink, String str) {
        }

        public void setStyleByColorAndHeader(ActivityInfoEntity.BgColorBean bgColorBean, boolean z) {
        }

        public void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "title");
        }

        public void showLoadingView() {
        }

        public void showNavBarWhenError() {
        }

        public void showNavBarWhenNormal() {
        }

        public void showNetErrorToast() {
        }
    }

    @Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/Contract$AbsTopicActivityPresenter;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/soda/home/topgun/component/topicact/Contract$AbsTopicActivityView;", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView$LoadMoreListener;", "()V", "mOmegaTabTime", "", "getMOmegaTabTime", "()Ljava/lang/String;", "setMOmegaTabTime", "(Ljava/lang/String;)V", "getScope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "needShowAddressTitleLayout", "", "onHandleBack", "onPageResult", "", "data", "Landroid/os/Bundle;", "onTabSwitched", "tabInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsTopicActivityPresenter extends CustomerRecyclerPresenter<AbsTopicActivityView> implements INovaRecyclerView.LoadMoreListener {
        private String mOmegaTabTime = "";

        public boolean needShowAddressTitleLayout() {
            return false;
        }

        public boolean onHandleBack() {
            return false;
        }

        public void onPageResult(Bundle bundle) {
        }

        public void onTabSwitched(TabInfoEntity tabInfoEntity) {
            Intrinsics.checkNotNullParameter(tabInfoEntity, "tabInfoEntity");
        }

        public final String getMOmegaTabTime() {
            return this.mOmegaTabTime;
        }

        public final void setMOmegaTabTime(String str) {
            this.mOmegaTabTime = str;
        }

        public IBlockScope getScope() {
            return new BlockScopeBase();
        }
    }
}
