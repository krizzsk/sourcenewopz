package com.didiglobal.p205sa.biz.presenter;

import android.os.Bundle;
import com.didi.component.never.core.node.NodePresenterImpl;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.node.SuperActivityNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016¨\u0006\u0015"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/presenter/SuperAppActivityPresenter;", "Lcom/didi/component/never/core/node/NodePresenterImpl;", "node", "Lcom/didiglobal/sa/biz/node/SuperActivityNode;", "bundle", "Landroid/os/Bundle;", "(Lcom/didiglobal/sa/biz/node/SuperActivityNode;Landroid/os/Bundle;)V", "initComponents", "", "", "onAdd", "", "arguments", "onPageHiddenChanged", "hidden", "", "onPagePause", "onPageResume", "onPageStart", "onPageStop", "onRemove", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.presenter.SuperAppActivityPresenter */
/* compiled from: SuperAppActivityPresenter.kt */
public final class SuperAppActivityPresenter extends NodePresenterImpl {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperAppActivityPresenter(SuperActivityNode superActivityNode, Bundle bundle) {
        super(superActivityNode, bundle);
        Intrinsics.checkNotNullParameter(superActivityNode, "node");
    }

    public List<String> initComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ComponentType.COMPONENT_SAXEngine);
        arrayList.add(ComponentType.COMPONENT_INTERACTIVIE_DIALOG);
        arrayList.add(ComponentType.COMPONENT_CONTAINER);
        arrayList.add(ComponentType.COMPONENT_SA_ACTIVITY_PANEL);
        return arrayList;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    public void onPageHiddenChanged(boolean z) {
        super.onPageHiddenChanged(z);
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
}
