package com.didi.sdk.sidebar.component;

import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.TextComponentView;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.IOException;

@ComponentType(name = "account_modify_email")
public class LinkedAccounts extends NavigationWithArrowComponent {

    /* renamed from: b */
    private static final int f37207b = 0;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TextComponentView f37208a;

    public LinkedAccounts(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OmegaSDKAdapter.trackEvent("pas_profile_emailedit_ck");
        OneLoginFacade.getAction().go2ModifyEmail(this.businessContext.getContext(), (LoginListeners.ModifyEmailListener) null);
    }

    public void onResume() {
        TextComponentView textComponentView;
        super.onResume();
        String hideEmail = OneLoginFacade.getStore().getHideEmail();
        if (!TextUtils.isEmpty(hideEmail) && (textComponentView = this.f37208a) != null) {
            textComponentView.setRightDes(hideEmail);
        }
        if (OneLoginFacade.getStore().isLoginNow()) {
            OneLoginFacade.getFunction().getEmailStatus(this.businessContext.getContext(), new LoginListeners.EmailStatusListener() {
                public void onFail(IOException iOException) {
                }

                public void onSucc(int i, String str) {
                    if (!TextUtils.isEmpty(str) && i == 0) {
                        LinkedAccounts.this.f37208a.setRightDesTipVisible();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void initData(TextComponentView textComponentView) {
        super.initData(textComponentView);
        this.f37208a = textComponentView;
        String hideEmail = OneLoginFacade.getStore().getHideEmail();
        if (!TextUtils.isEmpty(hideEmail)) {
            textComponentView.setRightDes(hideEmail);
        }
    }
}
