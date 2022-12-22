package com.didiglobal.p205sa.biz.component.recommend;

import android.os.Bundle;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.partner.SATemplateManager;
import com.didi.sdk.partner.supportcard.TemplateInfo;
import com.didi.sdk.partner.supportcard.TemplateModel;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.recommend.model.RecommendModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u001e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/recommend/RecommendPresenter;", "Lcom/didi/component/never/core/ComponentPresenterImpl;", "Lcom/didiglobal/sa/biz/component/recommend/RecommendView;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "callback", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "paramCallback", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "onAdd", "", "arguments", "Landroid/os/Bundle;", "onRemove", "refreshDataModel", "model", "Lcom/didiglobal/sa/biz/component/recommend/model/RecommendModel;", "list", "", "Lcom/didiglobal/enginecore/component/XEComponent;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.recommend.RecommendPresenter */
/* compiled from: RecommendPresenter.kt */
public final class RecommendPresenter extends ComponentPresenterImpl<RecommendView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f51037a = LoggerFactory.getLogger(getClass().getName());

    /* renamed from: b */
    private final XEResponseCallback f51038b = new RecommendPresenter$callback$1(this);

    /* renamed from: c */
    private final XEReqJSONParamsCallbackImpl f51039c = new RecommendPresenter$paramCallback$1();

    public RecommendPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36573a(RecommendModel recommendModel, List<? extends XEComponent> list) {
        ((RecommendView) this.mView).refreshDataModel(recommendModel, list);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.COMPONENT_RECOMMEND, "sa_home", this.f51038b);
        xERegisterModel.requestParams = this.f51039c;
        if (SATemplateManager.getInstance().hasRegisteredTemplates()) {
            xERegisterModel.components = new ArrayList();
            for (TemplateInfo next : SATemplateManager.getInstance().getSupportCardTemplateInfo()) {
                xERegisterModel.components.add(new XETemplateComponent(next.getTemplate_name(), next.getTemplate_view(), TemplateModel.class));
            }
        }
        XERegister.registerTemplate(xERegisterModel);
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMPONENT_RECOMMEND);
    }
}
