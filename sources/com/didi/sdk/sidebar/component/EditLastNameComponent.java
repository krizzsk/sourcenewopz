package com.didi.sdk.sidebar.component;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.event.DefaultEvent;
import com.didi.sdk.event.EventReceiver;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.sidebar.account.model.UserSettingInfo;
import com.didi.sdk.sidebar.account.store.AccountStore;
import com.didi.sdk.sidebar.compatible.MsgAndEventUtil;
import com.didi.sdk.sidebar.compatible.SideBarAdapterReceiver;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.EditNameComponetView;
import com.didi.sdk.util.ToastHelper;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;

@ComponentType(name = "account_edit_last_name")
public class EditLastNameComponent extends AbsComponent<EditNameComponetView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditNameComponetView f37203a;

    /* renamed from: b */
    private boolean f37204b;

    public EditLastNameComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
        AccountStore.getInstance().registerReceiver(this);
    }

    /* access modifiers changed from: protected */
    public EditNameComponetView createComponentView() {
        if (this.f37203a == null) {
            this.f37203a = new EditNameComponetView(this.businessContext.getContext());
        }
        return this.f37203a;
    }

    /* access modifiers changed from: protected */
    public void initData(EditNameComponetView editNameComponetView) {
        editNameComponetView.setNameDes(this.sidebarItem.getDes());
        editNameComponetView.setMaxLength(50);
        editNameComponetView.setHint((String) null);
        editNameComponetView.setHint(TextUtils.isEmpty(this.sidebarItem.getName()) ? this.businessContext.getContext().getString(R.string.enter_last_name_hint) : this.sidebarItem.getName());
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(this.businessContext.getContext());
        if (userInfo != null) {
            editNameComponetView.setName(userInfo.getLast_name());
            Logger logger = LoggerFactory.getLogger("user_info_log");
            logger.info("last name = " + userInfo.getLast_name(), new Object[0]);
        }
        editNameComponetView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    if (TextUtils.isEmpty(EditLastNameComponent.this.f37203a.getName())) {
                        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(EditLastNameComponent.this.businessContext.getContext());
                        if (userInfo != null && !TextUtils.isEmpty(userInfo.getLast_name())) {
                            EditLastNameComponent.this.f37203a.setName(userInfo.getLast_name());
                            return;
                        }
                        return;
                    }
                    EditLastNameComponent.this.m26381a();
                }
            }
        });
    }

    public String getName() {
        return this.f37203a.getName().toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26381a() {
        String str;
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(this.businessContext.getContext());
            UserSettingInfo userSettingInfo = new UserSettingInfo();
            if (userInfo == null) {
                str = "";
            } else {
                str = userInfo.getFirst_name();
            }
            userSettingInfo.firstName = str;
            userSettingInfo.lastName = this.f37203a.getName();
            if (!TextUtils.isEmpty(userSettingInfo.lastName)) {
                Logger logger = LoggerFactory.getLogger("user_info_log");
                logger.info("EditLastNameComponent first name  = " + userSettingInfo.firstName + " update last name = " + userSettingInfo.lastName, new Object[0]);
                AccountStore.getInstance().modifyAll((FragmentActivity) this.businessContext.getContext(), userSettingInfo, false);
            }
        }
    }

    @EventReceiver
    public void onReceive(DefaultEvent defaultEvent) {
        if (!this.f37204b && defaultEvent != null) {
            String type = defaultEvent.getType();
            char c = 65535;
            if (type.hashCode() == 2110813523 && type.equals(AccountStore.ACTION_MODIFY_ALL_INFO)) {
                c = 0;
            }
            ModifyAllReceiver modifyAllReceiver = null;
            if (c == 0) {
                modifyAllReceiver = new ModifyAllReceiver();
            }
            if (modifyAllReceiver != null) {
                modifyAllReceiver.onReceive(MsgAndEventUtil.EventToMsg(defaultEvent));
            }
        }
    }

    private class ModifyAllReceiver implements SideBarAdapterReceiver {
        private ModifyAllReceiver() {
        }

        public void onReceive(Message message) {
            UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(EditLastNameComponent.this.businessContext.getContext());
            if (userInfo != null) {
                int i = message.what;
                String str = "";
                if (i == 2 || i == 3) {
                    ToastHelper.showShortCompleted(EditLastNameComponent.this.businessContext.getContext(), (int) R.string.send_faild);
                    EditNameComponetView a = EditLastNameComponent.this.f37203a;
                    if (userInfo != null) {
                        str = userInfo.getLast_name();
                    }
                    a.setName(str);
                } else if (i == 1101) {
                    if (message.obj == null || !(message.obj instanceof BaseObject)) {
                        ToastHelper.showShortCompleted(EditLastNameComponent.this.businessContext.getContext(), (int) R.string.send_faild);
                    } else {
                        ToastHelper.showShortCompleted(EditLastNameComponent.this.businessContext.getContext(), ((BaseObject) message.obj).errmsg);
                        OmegaSDKAdapter.trackEvent("tone_p_x_login_confm_lastname_toast");
                    }
                    EditNameComponetView a2 = EditLastNameComponent.this.f37203a;
                    if (userInfo != null) {
                        str = userInfo.getLast_name();
                    }
                    a2.setName(str);
                }
            }
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        super.onClick(view);
        HashMap hashMap = new HashMap();
        hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
        hashMap.put("country_code", NationTypeUtil.getNationComponentData().getLocCountry());
        OmegaSDKAdapter.trackEvent("pas_profile_lastname_ck");
    }

    public void onDestroy() {
        super.onDestroy();
        AccountStore.getInstance().unregister(this);
        this.f37204b = true;
    }
}
