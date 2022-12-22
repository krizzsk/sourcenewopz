package com.didi.unifylogin.utils.simplifycode;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import com.didi.unifylogin.store.LoginStore;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public abstract class LoginServiceCallback<T extends BaseResponse> implements RpcService.Callback<T> {

    /* renamed from: a */
    private ILoginBaseFragment f45004a;

    /* renamed from: b */
    private Context f45005b;

    /* renamed from: c */
    private boolean f45006c = true;

    /* access modifiers changed from: protected */
    public abstract boolean handleResponse(T t);

    public LoginServiceCallback(ILoginBaseFragment iLoginBaseFragment) {
        init(iLoginBaseFragment, true);
    }

    public LoginServiceCallback(ILoginBaseFragment iLoginBaseFragment, boolean z) {
        init(iLoginBaseFragment, z);
    }

    public void init(ILoginBaseFragment iLoginBaseFragment, boolean z) {
        this.f45004a = iLoginBaseFragment;
        this.f45006c = z;
        AbsLoginBaseActivity baseActivity = iLoginBaseFragment.getBaseActivity();
        if (baseActivity != null) {
            this.f45005b = baseActivity.getApplicationContext();
        } else {
            this.f45005b = LoginStore.getContext();
        }
    }

    public void onSuccess(T t) {
        String str;
        if (this.f45006c) {
            this.f45004a.hideLoading();
        }
        if (t == null) {
            this.f45004a.showError((int) R.string.login_unify_net_error);
        } else if (!handleResponse(t)) {
            ILoginBaseFragment iLoginBaseFragment = this.f45004a;
            if (!TextUtils.isEmpty(t.error)) {
                str = t.error;
            } else {
                str = this.f45005b.getResources().getString(R.string.login_unify_net_error);
            }
            iLoginBaseFragment.showError(str);
        }
    }

    public void onFailure(IOException iOException) {
        this.f45004a.hideLoading();
        this.f45004a.showError((int) R.string.login_unify_net_error);
    }
}
