package com.didi.soda.home.component.policy;

import android.os.Bundle;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.storage.PrivacyContentStorage;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.component.policy.Contract;
import com.didi.soda.home.policy.model.PrivacyContentEntity;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.manager.HomePolicyUpdateRepo;
import com.didi.soda.router.DiRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/home/component/policy/PolicyUpdatePresenter;", "Lcom/didi/soda/home/component/policy/Contract$AbsPolicyUpdatePresenter;", "()V", "mPrivacyContentData", "Lcom/didi/soda/home/policy/model/PrivacyContentEntity;", "confirmPolicy", "", "onCreate", "showPolicyDetail", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PolicyUpdatePresenter.kt */
public final class PolicyUpdatePresenter extends Contract.AbsPolicyUpdatePresenter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PRIVACY_UPDATE_CONFIRM = "privacyUpdateConfirm";

    /* renamed from: a */
    private PrivacyContentEntity f42616a;

    public void showPolicyDetail() {
        String url;
        PrivacyContentEntity privacyContentEntity = this.f42616a;
        if (privacyContentEntity != null && (url = privacyContentEntity.getUrl()) != null) {
            DiRouter.request().path("webPage").putString("url", url).putBoolean(Const.PageParams.POLICY_DETAIL_PAGE, true).open();
            HomeOmegaHelper.getInstance().trackLawDialogPolicyClick(1);
        }
    }

    public void confirmPolicy() {
        HomePolicyUpdateRepo homePolicyUpdateRepo = (HomePolicyUpdateRepo) RepoFactory.getRepo(HomePolicyUpdateRepo.class);
        PrivacyContentEntity privacyContentEntity = this.f42616a;
        if (privacyContentEntity != null) {
            homePolicyUpdateRepo.setPolicyUpdateConfirmTime(privacyContentEntity.getUpdatePrivacyTime());
        }
        HomeOmegaHelper.getInstance().trackLawDialogClick(true, 1);
        Bundle bundle = new Bundle();
        bundle.putBoolean(PRIVACY_UPDATE_CONFIRM, true);
        getScopeContext().getNavigator().finish(bundle);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        PrivacyContentEntity data = ((PrivacyContentStorage) SingletonFactory.get(PrivacyContentStorage.class)).getData();
        this.f42616a = data;
        if (data != null) {
            ((Contract.AbsPolicyUpdateView) getLogicView()).updatePolicyContent(data.getReviseInfo());
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/home/component/policy/PolicyUpdatePresenter$Companion;", "", "()V", "PRIVACY_UPDATE_CONFIRM", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PolicyUpdatePresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
