package com.didi.soda.business.component.search;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.soda.business.listener.RecommendWordListener;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchHotWordEntity;
import com.didi.soda.customer.foundation.util.ClickUtils;
import java.util.List;

public class BusinessHotWordPresent extends IPresenter<BusinessHotWordView> {

    /* renamed from: a */
    private RecommendWordListener f39627a;

    /* renamed from: b */
    private List<String> f39628b;

    /* renamed from: c */
    private String f39629c;

    public void setRecommendWordListener(RecommendWordListener recommendWordListener) {
        this.f39627a = recommendWordListener;
    }

    public void clickWord(int i) {
        List<String> list = this.f39628b;
        if (list != null && i >= 0 && i < list.size() && !ClickUtils.isFastClick()) {
            String str = this.f39628b.get(i);
            RecommendWordListener recommendWordListener = this.f39627a;
            if (recommendWordListener != null) {
                recommendWordListener.onRecommendWordSearch(str, this.f39629c);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m28188a();
    }

    /* renamed from: a */
    private void m28188a() {
        BusinessInfoEntity businessInfoEntity = (BusinessInfoEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.SHOP_INFO_ENTITY);
        if (businessInfoEntity == null || businessInfoEntity.recItemSearchWords == null) {
            ((BusinessHotWordView) getLogicView()).setHotWords((List<String>) null);
            return;
        }
        BusinessSearchHotWordEntity businessSearchHotWordEntity = businessInfoEntity.recItemSearchWords;
        this.f39628b = businessSearchHotWordEntity.recWords;
        this.f39629c = businessSearchHotWordEntity.recId;
        ((BusinessHotWordView) getLogicView()).setHotWords(this.f39628b);
    }
}
