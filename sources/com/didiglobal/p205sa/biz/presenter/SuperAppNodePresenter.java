package com.didiglobal.p205sa.biz.presenter;

import android.os.Bundle;
import com.didi.component.never.core.node.NodePresenterImpl;
import com.didi.sdk.util.SaApolloUtil;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.formstore.IClearFormSore;
import com.didiglobal.p205sa.biz.node.SuperAppNode;
import com.didiglobal.p205sa.biz.tab.manager.SaTabUserCenterDemoteManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016¨\u0006\u0017"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/presenter/SuperAppNodePresenter;", "Lcom/didi/component/never/core/node/NodePresenterImpl;", "Lcom/didiglobal/sa/biz/formstore/IClearFormSore;", "node", "Lcom/didiglobal/sa/biz/node/SuperAppNode;", "bundle", "Landroid/os/Bundle;", "(Lcom/didiglobal/sa/biz/node/SuperAppNode;Landroid/os/Bundle;)V", "clearFromStore", "", "initComponents", "", "", "onAdd", "arguments", "onPageHiddenChanged", "hidden", "", "onPagePause", "onPageResume", "onPageStart", "onPageStop", "onRemove", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.presenter.SuperAppNodePresenter */
/* compiled from: SuperAppNodePresenter.kt */
public final class SuperAppNodePresenter extends NodePresenterImpl implements IClearFormSore {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperAppNodePresenter(SuperAppNode superAppNode, Bundle bundle) {
        super(superAppNode, bundle);
        Intrinsics.checkNotNullParameter(superAppNode, "node");
    }

    public List<String> initComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ComponentType.COMPONENT_SAXEngine);
        arrayList.add(ComponentType.COMPONENT_INTERACTIVIE_DIALOG);
        arrayList.add(ComponentType.COMPONENT_CONTAINER);
        if (!SaApolloUtil.INSTANCE.getSaOneState()) {
            arrayList.add(ComponentType.COMPONENT_TOP_BAR);
        } else if (SaTabUserCenterDemoteManager.INSTANCE.hideUserCenter()) {
            arrayList.add(ComponentType.COMPONENT_TOP_BAR);
        } else {
            arrayList.add(ComponentType.COMPONENT_WELCOME);
        }
        arrayList.add(ComponentType.COMPONENT_SA_XPANEL);
        arrayList.add("map_flow");
        return arrayList;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    public void onPageHiddenChanged(boolean z) {
        super.onPageHiddenChanged(z);
        if (!z) {
            clearFromStore();
        }
    }

    public void onPagePause() {
        super.onPagePause();
    }

    public void onPageStart() {
        super.onPageStart();
    }

    public void onPageStop() {
        super.onPageStop();
    }

    public void onRemove() {
        super.onRemove();
    }

    public void onPageResume() {
        super.onPageResume();
    }

    public void clearFromStore() {
        IClearFormSore iClearFormSore = (IClearFormSore) ServiceLoader.load(IClearFormSore.class).get();
        if (iClearFormSore != null) {
            iClearFormSore.clearFromStore();
        }
    }
}
