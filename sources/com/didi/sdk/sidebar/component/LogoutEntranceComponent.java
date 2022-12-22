package com.didi.sdk.sidebar.component;

import android.app.NotificationManager;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.login.LoginReason;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.TextComponentView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;

@ComponentType(name = "menu_setting_logout")
public class LogoutEntranceComponent extends NavigationWithArrowComponent {

    /* renamed from: a */
    AlertDialogFragment f37210a;

    public LogoutEntranceComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    /* access modifiers changed from: protected */
    public void initData(TextComponentView textComponentView) {
        super.initData(textComponentView);
        textComponentView.setRightArrowVisible(8);
    }

    /* renamed from: a */
    private void m26389a(final BaseBusinessContext baseBusinessContext) {
        if (!NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            NotificationManager notificationManager = (NotificationManager) baseBusinessContext.getContext().getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancelAll();
            }
            baseBusinessContext.getNavigation().popBackStack();
        } else if (baseBusinessContext.getContext() instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) baseBusinessContext.getContext()).getSupportFragmentManager();
            AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(baseBusinessContext.getContext());
            builder.setIcon((int) R.drawable.common_dialog_icon_info).setMessage(ResourcesHelper.getString(baseBusinessContext.getContext(), R.string.exit_tips)).setPositiveButton((int) R.string.exit_confirm, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    LogoutEntranceComponent.this.f37210a.dismiss();
                    baseBusinessContext.getNavigation().popBackStack();
                    OneLoginFacade.getAction().activeLogout(baseBusinessContext.getContext(), LoginReason.SIGN_IN_OR_SIGN_OFF_ACTIVE_SIGN_OFF);
                    NotificationManager notificationManager = (NotificationManager) baseBusinessContext.getContext().getSystemService("notification");
                    if (notificationManager != null) {
                        notificationManager.cancelAll();
                    }
                    NationTypeUtil.getNationComponentData().getLoginAction().go2Login();
                }
            }).setPositiveButtonDefault().setNegativeButton((int) R.string.exit_cancel, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    LogoutEntranceComponent.this.f37210a.dismiss();
                }
            });
            AlertDialogFragment create = builder.create();
            this.f37210a = create;
            try {
                create.show(supportFragmentManager, (String) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OmegaSDKAdapter.trackEvent("pas_setting_logout_ck");
        m26389a(this.businessContext);
    }
}
