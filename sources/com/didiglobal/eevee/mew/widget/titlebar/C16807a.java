package com.didiglobal.eevee.mew.widget.titlebar;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.component.never.base.PageFragment;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.IComponentEx;
import com.didi.xengine.register.XERegister;
import com.didiglobal.common.business.constant.ComponentType;
import com.didiglobal.common.common.never.component.EeveeCompPresenterImpl;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.lang.ref.WeakReference;

/* renamed from: com.didiglobal.eevee.mew.widget.titlebar.a */
/* compiled from: EeveeTopBarPresenter */
class C16807a extends EeveeCompPresenterImpl<EeveeTopBarView> {

    /* renamed from: a */
    private WeakReference<Activity> f50090a;

    /* renamed from: b */
    private WeakReference<Fragment> f50091b;

    /* renamed from: c */
    private IComponentEx f50092c;

    /* renamed from: d */
    private XEResponseCallback f50093d = new EeveeTopBarPresenter$1(this);

    public C16807a(ComponentParams componentParams) {
        super(componentParams);
        this.f50090a = new WeakReference<>(componentParams.getActivity());
        this.f50091b = new WeakReference<>(componentParams.getFragment());
    }

    /* renamed from: a */
    public void mo122485a() {
        ((Fragment) this.f50091b.get()).getFragmentManager().popBackStack();
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegister.registerTemplate(new XERegisterModel(ComponentType.COMP_TOP_BAR, getNodeEeveeID(), this.f50093d));
        WeakReference<Fragment> weakReference = this.f50091b;
        if (weakReference != null && weakReference.get() != null && bundle != null && !bundle.getBoolean("is_sa")) {
            Fragment fragment = (Fragment) this.f50091b.get();
            if ((fragment instanceof PageFragment) || this.f50092c != null) {
                ((PageFragment) fragment).invisibleComponent(this.f50092c);
            }
        }
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMP_TOP_BAR);
    }

    /* renamed from: a */
    public void mo122486a(IComponentEx iComponentEx) {
        this.f50092c = iComponentEx;
    }
}
