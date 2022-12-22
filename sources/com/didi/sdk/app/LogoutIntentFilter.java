package com.didi.sdk.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.util.Constant;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

@ServiceProvider({MainActivityIntentFilter.class})
public class LogoutIntentFilter implements MainActivityIntentFilter {
    public boolean doFilter(Intent intent, Activity activity, BusinessContextHelper businessContextHelper) {
        if (!intent.getBooleanExtra(Constant.LOGOUT_KEY, false) && !intent.getBooleanExtra(Constant.AUTH_FAILED_KEY, false)) {
            return false;
        }
        EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.CLOSE_SIDEBAR));
        businessContextHelper.popBackStack(2);
        m24859a(activity.getString(intent.getBooleanExtra(Constant.LOGOUT_REASON_SWITCH_SUFFIX_KEY, false) ? R.string.GRider_V3_No_account_rdcA : R.string.GRider_optimization_Login_failed_kwOs), activity, businessContextHelper);
        return true;
    }

    /* renamed from: a */
    private void m24859a(String str, final Activity activity, final BusinessContextHelper businessContextHelper) {
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(activity);
        builder.setMessage(str);
        builder.setCancelable(false);
        builder.setPositiveButtonDefault().setPositiveButton((int) R.string.fine, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                BusinessContextHelper businessContextHelper = businessContextHelper;
                if (businessContextHelper != null) {
                    businessContextHelper.popBackStack(2);
                }
                OneLoginFacade.getAction().go2Login(activity);
                businessContextHelper.dismissDialog(alertDialogFragment);
            }
        });
        final AlertDialogFragment create = builder.create();
        businessContextHelper.showDialog(create);
        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
            public void onCancel() {
            }

            public void onSuccess(Activity activity, String str) {
                OneLoginFacade.getFunction().removeLoginListener(this);
                Dialog dialog = create.getDialog();
                if (dialog != null && dialog.isShowing()) {
                    BusinessContextHelper businessContextHelper = businessContextHelper;
                    if (businessContextHelper != null) {
                        businessContextHelper.popBackStack(2);
                    }
                    businessContextHelper.dismissDialog(create);
                }
            }
        });
    }
}
