package com.didi.soda.home.topgun.component.topicact.title;

import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.widget.scroll.CustomerNavScrollListener;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/title/ITitleLayout;", "", "attachTo", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "parent", "Landroid/view/ViewGroup;", "getScrollCallback", "Lcom/didi/soda/customer/widget/scroll/CustomerNavScrollListener$Callback;", "getTitleLayout", "Landroid/view/View;", "scrollToTop", "setOnBackClickListener", "listener", "Landroid/view/View$OnClickListener;", "setRules", "rules", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;", "activityId", "", "setTitle", "title", "showNavBarWhenError", "showNavBarWhenNormal", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ITitleLayout.kt */
public interface ITitleLayout {
    void attachTo(ScopeContext scopeContext, ViewGroup viewGroup);

    CustomerNavScrollListener.Callback getScrollCallback();

    View getTitleLayout();

    void scrollToTop();

    void setOnBackClickListener(View.OnClickListener onClickListener);

    void setRules(ActivityInfoEntity.RuleLink ruleLink, String str);

    void setTitle(String str);

    void showNavBarWhenError();

    void showNavBarWhenNormal();
}
