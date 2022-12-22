package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.rfusion.config.RFLocale;
import com.didi.unifylogin.base.api.BaseListenerContainer;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginNetParamListener;
import com.didi.unifylogin.base.net.pojo.request.SimpleParam;
import com.didi.unifylogin.base.net.pojo.response.IdentityStatusResponse;
import com.didi.unifylogin.base.presenter.LoginBaseFillerPresenter;
import com.didi.unifylogin.base.view.ability.ILoginBaseFillerFragment;
import com.didi.unifylogin.presenter.ability.IPreCertificationPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.CertificationController;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;

public class PreCertificationPresenter extends LoginBaseFillerPresenter<ILoginBaseFillerFragment> implements IPreCertificationPresenter {

    /* renamed from: a */
    private long f44845a = 0;

    public PreCertificationPresenter(ILoginBaseFillerFragment iLoginBaseFillerFragment, Context context) {
        super(iLoginBaseFillerFragment, context);
    }

    public void openCertification(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            ((ILoginBaseFillerFragment) this.view).showError((int) R.string.login_unify_net_error);
            LoginLog.write(this.TAG + "openCertification() url is empty");
        } else if (System.currentTimeMillis() - this.f44845a >= 500) {
            this.f44845a = System.currentTimeMillis();
            LoginNetParamListener netParamListener = BaseListenerContainer.getNetParamListener();
            if (netParamListener != null) {
                str2 = netParamListener.getLanguage();
                if (!TextUtils.isEmpty(str2) && str2.length() > 2) {
                    str2 = str2.substring(0, 2);
                }
            } else {
                str2 = RFLocale.CHINESE;
            }
            CertificationController.openCertification(((ILoginBaseFillerFragment) this.view).getBaseActivity(), str, LoginStore.getInstance().getTemporaryToken(), str2, this.messenger.getCell());
        }
    }

    public void checkResult() {
        ((ILoginBaseFillerFragment) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).getUserIdentityStatus(new SimpleParam(this.context, getSceneNum()).setTicket(LoginStore.getInstance().getTemporaryToken()), new LoginServiceCallbackV2<IdentityStatusResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(IdentityStatusResponse identityStatusResponse, int i, String str) {
                if (identityStatusResponse.errno != 0) {
                    return false;
                }
                if (identityStatusResponse.status != 0) {
                    return true;
                }
                PreCertificationPresenter.this.goFillNextInfo();
                return true;
            }
        });
    }
}
