package com.didi.universal.pay.biz.manager;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.didi.universal.pay.biz.manager.listener.IUniversalPayBizManager;
import com.didi.universal.pay.biz.p172ui.IUniversalPayView;
import com.didi.universal.pay.sdk.model.UniversalPayParams;

public class UniversalBizManagerFactory {
    public static IUniversalPayBizManager get(Activity activity, UniversalPayParams universalPayParams, IUniversalPayView iUniversalPayView) {
        return new UniversalPayBizManager(activity, universalPayParams, iUniversalPayView);
    }

    public static IUniversalPayBizManager get(Fragment fragment, UniversalPayParams universalPayParams, IUniversalPayView iUniversalPayView) {
        return new UniversalPayBizManager(fragment, universalPayParams, iUniversalPayView);
    }
}
