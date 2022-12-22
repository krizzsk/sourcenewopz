package com.didiglobal.p205sa.biz.component.bizcard;

import android.os.Bundle;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import com.didiglobal.p205sa.biz.component.ComponentType;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/bizcard/BizCardPresenter;", "Lcom/didi/component/never/core/ComponentPresenterImpl;", "Lcom/didiglobal/sa/biz/component/bizcard/BizCardView;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "callback", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "onAdd", "", "arguments", "Landroid/os/Bundle;", "onRemove", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.bizcard.BizCardPresenter */
/* compiled from: BizCardPresenter.kt */
public final class BizCardPresenter extends ComponentPresenterImpl<BizCardView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f50801a = LoggerFactory.getLogger(getClass().getName());

    /* renamed from: b */
    private final XEResponseCallback f50802b = new BizCardPresenter$callback$1(this);

    public BizCardPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.COMPONENT_BIZ_CARD, "sa_home", this.f50802b);
        xERegisterModel.components = new ArrayList();
        xERegisterModel.components.add(new XETemplateComponent("template_sub_biz_card", BizCardTemplateView.class, BizCardTempModel.class));
        XERegister.registerTemplate(xERegisterModel);
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMPONENT_BIZ_CARD);
    }
}
