package com.didi.component.homedestination.spi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.cpf.CPFAuthWebActivity;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.common.model.CPFBlockingModel;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.unifylogin.spi.CPFVerifySerialInterface;
import com.didi.unifylogin.store.LoginStore;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({CPFVerifySerialInterface.class})
public class CPFVerifySerialInterfaceImpl implements CPFVerifySerialInterface {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<Integer> f14124a = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Flutter.EVENT_FLUTTER_CPF_RESULT, CPFVerifySerialInterfaceImpl.this.f14124a);
            if (CPFVerifySerialInterfaceImpl.this.f14125b != null) {
                CPFVerifySerialInterfaceImpl.this.f14125b.onResult(num.intValue(), "");
            }
            CPFVerifySerialInterface.CpfCallback unused = CPFVerifySerialInterfaceImpl.this.f14125b = null;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CPFVerifySerialInterface.CpfCallback f14125b;

    public void getCPFV2Test(Context context, final CPFVerifySerialInterface.TestCallback testCallback) {
        CarRequest.getCPFBlockingSuffixApolloV2(context, new ResponseListener<CPFBlockingModel>() {
            public void onSuccess(CPFBlockingModel cPFBlockingModel) {
                if (CacheApolloUtils.isCPFBlockingTypeV2OpenOnRegist()) {
                    testCallback.onSuccess();
                } else {
                    testCallback.onFailed();
                }
            }

            public void onFail(CPFBlockingModel cPFBlockingModel) {
                testCallback.onFailed();
            }
        });
    }

    public void jump2CpfVerifyPage(Activity activity, Fragment fragment, CPFVerifySerialInterface.CpfCallback cpfCallback, int i) {
        Activity activity2 = fragment != null ? fragment.getActivity() : activity;
        if (activity2 != null) {
            this.f14125b = cpfCallback;
            BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Flutter.EVENT_FLUTTER_CPF_RESULT, this.f14124a);
            String token = NationComponentDataUtil.getToken();
            if (TextUtils.isEmpty(token)) {
                token = LoginStore.getInstance().getTemporaryToken();
            }
            String cpfAuthH5UrlWithSourceAdded = DDTravelConfigStore.getInstance().getCpfAuthH5UrlWithSourceAdded(1, token);
            if (!TextUtils.isEmpty(cpfAuthH5UrlWithSourceAdded)) {
                Intent intent = new Intent(activity2, CPFAuthWebActivity.class);
                intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(cpfAuthH5UrlWithSourceAdded));
                intent.putExtra("CPF_AUTH_SOURCE_KEY", 1);
                if (fragment != null) {
                    fragment.startActivityForResult(intent, i);
                } else {
                    activity.startActivityForResult(intent, i);
                }
            }
        }
    }

    public void flutterOpenCpf(Activity activity, String str, CPFVerifySerialInterface.CpfCallback cpfCallback) {
        this.f14125b = cpfCallback;
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Flutter.EVENT_FLUTTER_CPF_RESULT, this.f14124a);
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(activity, CPFAuthWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(m9870a(str, 1)));
            intent.putExtra("CPF_AUTH_SOURCE_KEY", 1);
            activity.startActivity(intent);
        }
    }

    /* renamed from: a */
    private String m9870a(String str, int i) {
        return str + "?CPFClientFromType=" + i;
    }
}
