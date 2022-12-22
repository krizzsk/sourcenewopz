package com.didi.soda.business.component.dynamic.search;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.soda.business.listener.RecommendWordListener;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchHotWordEntity;
import com.didi.soda.customer.foundation.util.ClickUtils;
import java.util.List;

public class BusinessDyHotWordPresent extends IPresenter<BusinessDyHotWordView> {

    /* renamed from: a */
    private RecommendWordListener f39487a;

    /* renamed from: b */
    private List<String> f39488b;

    /* renamed from: c */
    private String f39489c;

    public void setRecommendWordListener(RecommendWordListener recommendWordListener) {
        this.f39487a = recommendWordListener;
    }

    public void clickWord(int i) {
        List<String> list = this.f39488b;
        if (list != null && i >= 0 && i < list.size() && !ClickUtils.isFastClick()) {
            String str = this.f39488b.get(i);
            RecommendWordListener recommendWordListener = this.f39487a;
            if (recommendWordListener != null) {
                recommendWordListener.onRecommendWordSearch(str, this.f39489c);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m28011a();
    }

    /* renamed from: a */
    private void m28011a() {
        BusinessInfoEntity businessInfoEntity = (BusinessInfoEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.SHOP_INFO_ENTITY);
        if (businessInfoEntity == null || businessInfoEntity.recItemSearchWords == null) {
            ((BusinessDyHotWordView) getLogicView()).setHotWords((List<String>) null);
            return;
        }
        BusinessSearchHotWordEntity businessSearchHotWordEntity = businessInfoEntity.recItemSearchWords;
        this.f39488b = businessSearchHotWordEntity.recWords;
        this.f39489c = businessSearchHotWordEntity.recId;
        ((BusinessDyHotWordView) getLogicView()).setHotWords(this.f39488b);
    }
}
