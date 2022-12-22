package com.didi.component.common.pininput;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.pininput.PinUploader;
import com.didi.component.common.util.GLog;
import com.didi.component.core.PresenterGroup;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class PinInputPresenter extends PresenterGroup<IPinInputView> {
    public static final int PIN_LENGTH = 3;

    /* renamed from: a */
    private static final String f11670a = "PinInputPresenter";

    /* renamed from: b */
    private boolean f11671b;

    public PinInputPresenter(Context context, Bundle bundle) {
        super(context, bundle);
    }

    public synchronized void createPin(String str) {
        if (m7895a(str) && !this.f11671b) {
            ((IPinInputView) this.mView).showUploadingDialog();
            m7894a(NationComponentDataUtil.getToken(), str);
        }
    }

    /* renamed from: a */
    private boolean m7895a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches("^\\d{3}$");
        }
        return false;
    }

    /* renamed from: a */
    private void m7894a(final String str, String str2) {
        new PinUploader(this.mContext).uploadPin(str2, new RpcService.Callback<PinUploader.Response>() {
            public void onSuccess(PinUploader.Response response) {
                GLog.m7965d(PinInputPresenter.f11670a, "upload pin response: " + response);
                if (response == null || response.code != 0) {
                    PinInputPresenter.this.m7898c();
                    return;
                }
                UserCenterFacade.getIns().fetchUserInfo(PinInputPresenter.this.mContext, str, NationComponentDataUtil.getCurrentLan(), new RpcService.Callback<UserInfo>() {
                    public void onSuccess(UserInfo userInfo) {
                        GLog.m7965d(PinInputPresenter.f11670a, "fetchUserInfo onSuccess: " + userInfo);
                        if (!TextUtils.isEmpty(userInfo.getPin())) {
                            PinInputPresenter.this.m7896b();
                        } else {
                            PinInputPresenter.this.m7898c();
                        }
                    }

                    public void onFailure(IOException iOException) {
                        GLog.m7966d(PinInputPresenter.f11670a, "fetchUserInfo onFail", iOException);
                        PinInputPresenter.this.m7898c();
                    }
                });
            }

            public void onFailure(IOException iOException) {
                GLog.m7966d(PinInputPresenter.f11670a, "upload pin failed", iOException);
                PinInputPresenter.this.m7898c();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m7896b() {
        ((IPinInputView) this.mView).dismissUploadingDialog();
        ((IPinInputView) this.mView).showPinCreatedView();
        this.f11671b = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m7898c() {
        ((IPinInputView) this.mView).dismissUploadingDialog();
        ((IPinInputView) this.mView).showUploadFailedToast();
        this.f11671b = false;
    }
}
