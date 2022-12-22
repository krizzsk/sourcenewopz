package com.didi.component.business.util;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.taxis99.R;

public class CarHttpHelper {
    public static boolean validate(FragmentActivity fragmentActivity, BaseObject baseObject) {
        if (baseObject == null || fragmentActivity == null) {
            return false;
        }
        return m7696a(fragmentActivity, baseObject.errno, baseObject.errmsg);
    }

    /* renamed from: a */
    private static boolean m7696a(FragmentActivity fragmentActivity, int i, String str) {
        if (i != -900) {
            if (i == 0) {
                return true;
            }
            if (i != 101) {
                if (i != 596) {
                    if (i != 1011) {
                        if (i != 2008) {
                            if (i == 22133 || i == 22151 || i == 22152) {
                                if (fragmentActivity != null) {
                                    ToastHelper.showShortInfo((Context) fragmentActivity, str, (int) R.drawable.global_toast_error);
                                }
                            } else if (fragmentActivity != null) {
                                if (!TextUtil.isEmpty(str)) {
                                    ToastHelper.showShortCompleted((Context) fragmentActivity, str);
                                } else {
                                    ToastHelper.showShortCompleted((Context) fragmentActivity, (int) R.string.car_service_wander_tip);
                                }
                            }
                        } else if (fragmentActivity == null) {
                            return true;
                        } else {
                            ToastHelper.showShortInfo((Context) fragmentActivity, str);
                            return true;
                        }
                    }
                } else if (fragmentActivity != null) {
                    ToastHelper.showShortInfo((Context) fragmentActivity, ResourcesHelper.getString(fragmentActivity, R.string.global_system_busy_click_toast), (int) R.drawable.global_toast_error);
                }
            }
            if (fragmentActivity != null) {
                NationComponentDataUtil.showLoginDialog(fragmentActivity, str);
            }
        } else if (fragmentActivity != null) {
            UiHelper.showInvalidDataDialog(fragmentActivity, str);
        }
        return false;
    }
}
