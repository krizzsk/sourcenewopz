package com.didi.entrega.info.component;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.info.helper.InfoOmegaHelper;
import com.didi.entrega.info.model.StuffRemarkModel;
import com.didi.entrega.info.model.StuffRuleModel;
import com.didi.entrega.info.model.StuffTypeModel;
import com.didi.entrega.info.repo.InfoComponentRepo;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.entrega.manager.base.ICustomerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/info/component/StuffConstract;", "", "AbsCommonStuffPresenter", "AbsCommonStuffView", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StuffConstract.kt */
public interface StuffConstract {

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/info/component/StuffConstract$AbsCommonStuffView;", "Lcom/didi/entrega/info/component/AbsInfoView;", "()V", "initItemData", "", "model", "Lcom/didi/entrega/info/model/StuffTypeModel;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StuffConstract.kt */
    public static abstract class AbsCommonStuffView extends AbsInfoView {
        public abstract void initItemData(StuffTypeModel stuffTypeModel);
    }

    @Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00102\u001a\u000200H\u0014R\"\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00063"}, mo175978d2 = {"Lcom/didi/entrega/info/component/StuffConstract$AbsCommonStuffPresenter;", "Lcom/didi/entrega/info/component/AbsInfoPresenter;", "Lcom/didi/entrega/info/component/StuffConstract$AbsCommonStuffView;", "()V", "componentRepo", "Lcom/didi/entrega/info/repo/InfoComponentRepo;", "kotlin.jvm.PlatformType", "getComponentRepo", "()Lcom/didi/entrega/info/repo/InfoComponentRepo;", "setComponentRepo", "(Lcom/didi/entrega/info/repo/InfoComponentRepo;)V", "eventSource", "", "getEventSource", "()I", "setEventSource", "(I)V", "fusionChannel", "getFusionChannel", "setFusionChannel", "infoManager", "Lcom/didi/entrega/manager/base/ICustomerContactManager;", "getInfoManager", "()Lcom/didi/entrega/manager/base/ICustomerContactManager;", "setInfoManager", "(Lcom/didi/entrega/manager/base/ICustomerContactManager;)V", "pageSource", "getPageSource", "setPageSource", "stuffRemarkModel", "Lcom/didi/entrega/info/model/StuffRemarkModel;", "getStuffRemarkModel", "()Lcom/didi/entrega/info/model/StuffRemarkModel;", "setStuffRemarkModel", "(Lcom/didi/entrega/info/model/StuffRemarkModel;)V", "stuffRuleModel", "Lcom/didi/entrega/info/model/StuffRuleModel;", "getStuffRuleModel", "()Lcom/didi/entrega/info/model/StuffRuleModel;", "setStuffRuleModel", "(Lcom/didi/entrega/info/model/StuffRuleModel;)V", "stuffTypeModel", "Lcom/didi/entrega/info/model/StuffTypeModel;", "getStuffTypeModel", "()Lcom/didi/entrega/info/model/StuffTypeModel;", "setStuffTypeModel", "(Lcom/didi/entrega/info/model/StuffTypeModel;)V", "handleBack", "", "onCreate", "onResume", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StuffConstract.kt */
    public static abstract class AbsCommonStuffPresenter extends AbsInfoPresenter<AbsCommonStuffView> {
        private InfoComponentRepo componentRepo = ((InfoComponentRepo) RepoFactory.getRepo(InfoComponentRepo.class));
        private int eventSource;
        private int fusionChannel = 2;
        public ICustomerContactManager infoManager;
        private int pageSource;
        private StuffRemarkModel stuffRemarkModel;
        private StuffRuleModel stuffRuleModel;
        private StuffTypeModel stuffTypeModel;

        public final ICustomerContactManager getInfoManager() {
            ICustomerContactManager iCustomerContactManager = this.infoManager;
            if (iCustomerContactManager != null) {
                return iCustomerContactManager;
            }
            Intrinsics.throwUninitializedPropertyAccessException("infoManager");
            return null;
        }

        public final void setInfoManager(ICustomerContactManager iCustomerContactManager) {
            Intrinsics.checkNotNullParameter(iCustomerContactManager, "<set-?>");
            this.infoManager = iCustomerContactManager;
        }

        public final int getPageSource() {
            return this.pageSource;
        }

        public final void setPageSource(int i) {
            this.pageSource = i;
        }

        public final int getFusionChannel() {
            return this.fusionChannel;
        }

        public final void setFusionChannel(int i) {
            this.fusionChannel = i;
        }

        public final int getEventSource() {
            return this.eventSource;
        }

        public final void setEventSource(int i) {
            this.eventSource = i;
        }

        public final InfoComponentRepo getComponentRepo() {
            return this.componentRepo;
        }

        public final void setComponentRepo(InfoComponentRepo infoComponentRepo) {
            this.componentRepo = infoComponentRepo;
        }

        public final StuffTypeModel getStuffTypeModel() {
            return this.stuffTypeModel;
        }

        public final void setStuffTypeModel(StuffTypeModel stuffTypeModel2) {
            this.stuffTypeModel = stuffTypeModel2;
        }

        public final StuffRemarkModel getStuffRemarkModel() {
            return this.stuffRemarkModel;
        }

        public final void setStuffRemarkModel(StuffRemarkModel stuffRemarkModel2) {
            this.stuffRemarkModel = stuffRemarkModel2;
        }

        public final StuffRuleModel getStuffRuleModel() {
            return this.stuffRuleModel;
        }

        public final void setStuffRuleModel(StuffRuleModel stuffRuleModel2) {
            this.stuffRuleModel = stuffRuleModel2;
        }

        public void onCreate() {
            Bundle bundle;
            super.onCreate();
            ICustomerManager loadManager = CustomerManagerLoader.loadManager(ICustomerContactManager.class);
            Intrinsics.checkNotNullExpressionValue(loadManager, "loadManager(ICustomerContactManager::class.java)");
            setInfoManager((ICustomerContactManager) loadManager);
            this.pageSource = getScopeContext().getBundle().getInt("page_source", 1);
            int i = 2;
            this.eventSource = getScopeContext().getBundle().getInt(ParamConst.InfoOmega.EVENT_SOURCE, 2);
            ScopeContext scopeContext = getScopeContext();
            if (!(scopeContext == null || (bundle = scopeContext.getBundle()) == null)) {
                i = bundle.getInt(ParamConst.InfoOmega.FUSION_CHANNEL, 2);
            }
            this.fusionChannel = i;
        }

        /* access modifiers changed from: protected */
        public void onResume() {
            super.onResume();
            InfoOmegaHelper.INSTANCE.trackStufSw(this);
        }

        public void handleBack() {
            InfoOmegaHelper.INSTANCE.trackStuffReturnCk(this);
        }
    }
}
