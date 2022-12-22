package com.didi.component.imentrance;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.core.IMMessageListener;
import com.didi.beatles.p099im.access.core.IMUnreadMsgLoadCallback;
import com.didi.beatles.p099im.access.msg.IMMsg;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.beatles.p099im.module.IMSessionUnreadSysChatMsgCallback;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSysChatUnreadCount;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.imentrance.IIMEntranceView;
import com.didi.component.imentrance.model.DriverOptionModel;
import com.didi.component.imentrance.model.IMInfo;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.MainActivity;
import com.didi.sdk.util.ResourcesHelper;
import com.didiglobal.travel.util.CollectionUtils;
import com.taxis99.R;
import java.util.List;

public abstract class AbsIMEntrancePresenter extends BaseExpressPresenter<IIMEntranceView> implements IIMEntranceView.OnIMEntranceClickListener {

    /* renamed from: a */
    private static final int f14130a = 5;

    /* renamed from: b */
    private long f14131b;

    /* renamed from: c */
    private IMBusinessParam f14132c;

    /* renamed from: d */
    private boolean f14133d = false;
    protected boolean disable;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f14134e = 0;

    /* renamed from: f */
    private boolean f14135f = false;

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14136g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!TextUtils.isEmpty(str)) {
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -734050502) {
                    if (hashCode == -499998860 && str.equals(BaseEventKeys.C4621IM.KEY_CATEGORY_IM_CLOSE_SESSION)) {
                        c = 0;
                    }
                } else if (str.equals(BaseEventKeys.C4621IM.EVENT_IM_ENTRANCE_CLICK)) {
                    c = 1;
                }
                if (c == 0) {
                    AbsIMEntrancePresenter.this.closeSession();
                } else if (c == 1) {
                    AbsIMEntrancePresenter.this.onIMEntranceClick();
                }
            }
        }
    };

    /* renamed from: h */
    private ActivityLifecycleManager.AbsActivityLifecycleCallbacks f14137h = new ActivityLifecycleManager.AbsActivityLifecycleCallbacks() {
        public void onActivityResumed(Activity activity) {
            if ((AbsIMEntrancePresenter.this.mContext instanceof Application) && activity.getClass() == MainActivity.class) {
                AbsIMEntrancePresenter.this.refreshUI();
            } else if ((AbsIMEntrancePresenter.this.mContext instanceof Activity) && AbsIMEntrancePresenter.this.mContext == activity) {
                AbsIMEntrancePresenter.this.refreshUI();
            }
        }
    };

    /* renamed from: i */
    private IMMessageListener f14138i = new IMMessageListener() {
        public void onMessageArrive() {
            AbsIMEntrancePresenter.this.refreshUI();
        }
    };
    protected DriverOptionModel mIMoption;
    protected String source = "";

    public void notifyShowMsgBubble(boolean z) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AbsIMEntrancePresenter(com.didi.component.core.ComponentParams r3) {
        /*
            r2 = this;
            r2.<init>(r3)
            r0 = 0
            r2.f14133d = r0
            r2.f14134e = r0
            r2.f14135f = r0
            java.lang.String r0 = ""
            r2.source = r0
            com.didi.component.imentrance.AbsIMEntrancePresenter$1 r0 = new com.didi.component.imentrance.AbsIMEntrancePresenter$1
            r0.<init>()
            r2.f14136g = r0
            com.didi.component.imentrance.AbsIMEntrancePresenter$2 r0 = new com.didi.component.imentrance.AbsIMEntrancePresenter$2
            r0.<init>()
            r2.f14137h = r0
            com.didi.component.imentrance.AbsIMEntrancePresenter$3 r0 = new com.didi.component.imentrance.AbsIMEntrancePresenter$3
            r0.<init>()
            r2.f14138i = r0
            java.lang.String r0 = "im_option"
            java.lang.Object r0 = r3.getExtra(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "source"
            java.lang.Object r1 = r3.getExtra(r1)
            java.lang.String r1 = (java.lang.String) r1
            r2.source = r1
            android.os.Bundle r3 = r3.extras
            java.lang.String r1 = "notify_message"
            boolean r3 = r3.getBoolean(r1)
            r2.f14135f = r3
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x004f
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004b }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x004b }
            goto L_0x0050
        L_0x004b:
            r3 = move-exception
            r3.printStackTrace()
        L_0x004f:
            r3 = 0
        L_0x0050:
            if (r3 == 0) goto L_0x005c
            com.didi.component.imentrance.model.DriverOptionModel r0 = new com.didi.component.imentrance.model.DriverOptionModel
            r0.<init>()
            r2.mIMoption = r0
            r0.parse(r3)
        L_0x005c:
            com.didi.component.imentrance.model.DriverOptionModel r3 = r2.mIMoption
            if (r3 == 0) goto L_0x0079
            com.didi.component.imentrance.model.DriverOptionData r3 = r3.data
            if (r3 == 0) goto L_0x0079
            com.didi.component.imentrance.model.DriverOptionModel r3 = r2.mIMoption
            com.didi.component.imentrance.model.DriverOptionData r3 = r3.data
            int r3 = r3.status
            r0 = 6
            if (r3 == r0) goto L_0x0076
            com.didi.component.imentrance.model.DriverOptionModel r3 = r2.mIMoption
            com.didi.component.imentrance.model.DriverOptionData r3 = r3.data
            int r3 = r3.status
            r0 = 2
            if (r3 != r0) goto L_0x0079
        L_0x0076:
            r3 = 1
            r2.f14133d = r3
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.imentrance.AbsIMEntrancePresenter.<init>(com.didi.component.core.ComponentParams):void");
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        DriverOptionModel driverOptionModel = this.mIMoption;
        if (driverOptionModel != null) {
            this.disable = driverOptionModel.clickable != 1;
        }
        if ("far".equals(this.source) || "near".equals(this.source)) {
            this.f14135f = true;
        }
        if (!this.disable && this.f14135f) {
            m9886c();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        ActivityLifecycleManager.getInstance().unregisterActivityLifecycleCallbacks(this.f14137h);
        unsubscribe(BaseEventKeys.C4621IM.KEY_CATEGORY_IM_CLOSE_SESSION, this.f14136g);
        unsubscribe(BaseEventKeys.C4621IM.EVENT_IM_ENTRANCE_CLICK, this.f14136g);
        IMEngine.getInstance(this.mContext).removeMessageListener(this.f14138i);
    }

    public void startIMActivity() {
        if (this.f14132c != null) {
            IMEngine.startChatDetailActivity(this.mContext, this.f14132c);
        }
    }

    /* access modifiers changed from: protected */
    public void onIMUnreadMessageUpdated(int i) {
        ((IIMEntranceView) this.mView).refreshMessageCount(i);
        this.f14134e = i;
    }

    /* access modifiers changed from: protected */
    public void bind(IMInfo iMInfo) {
        if (iMInfo != null) {
            m9881a(iMInfo.bid, iMInfo.uid);
            obtainBusinessParam(iMInfo);
            IMEngine.getInstance(this.mContext).addMessageListener(this.f14138i);
            ActivityLifecycleManager.getInstance().registerActivityLifecycleCallbacks(this.f14137h);
            subscribe(BaseEventKeys.C4621IM.KEY_CATEGORY_IM_CLOSE_SESSION, this.f14136g);
            subscribe(BaseEventKeys.C4621IM.EVENT_IM_ENTRANCE_CLICK, this.f14136g);
            refreshUI();
            return;
        }
        throw new IllegalArgumentException("IMModel is null!");
    }

    /* access modifiers changed from: protected */
    public IMBusinessParam getIMBusinessParam() {
        return this.f14132c;
    }

    /* access modifiers changed from: protected */
    public void setSecret(String str) {
        IMBusinessParam iMBusinessParam = this.f14132c;
        if (iMBusinessParam != null && !this.f14133d) {
            iMBusinessParam.setSecret(str);
        }
    }

    /* access modifiers changed from: protected */
    public String getSecret() {
        IMBusinessParam iMBusinessParam = this.f14132c;
        if (iMBusinessParam == null) {
            return "";
        }
        return iMBusinessParam.getSecret();
    }

    /* access modifiers changed from: protected */
    public boolean isCloseIM() {
        return this.f14133d;
    }

    /* renamed from: a */
    private void m9881a(int i, long j) {
        this.f14131b = IMEngine.generateSessionId(i, j);
    }

    /* access modifiers changed from: protected */
    public void obtainBusinessParam(IMInfo iMInfo) {
        if (this.f14132c == null) {
            this.f14132c = new IMBusinessParam();
        }
        IMBusinessParam iMBusinessParam = this.f14132c;
        iMBusinessParam.setSessionId(this.f14131b);
        iMBusinessParam.setSelfUid(NationComponentDataUtil.getUid());
        iMBusinessParam.setPeerUid(iMInfo.uid);
        iMBusinessParam.setBusinessId(iMInfo.bid);
        iMBusinessParam.setsOrderId(iMInfo.oid);
        iMBusinessParam.setCityID(iMInfo.cid);
        iMBusinessParam.setSecret(iMInfo.secretString);
        iMBusinessParam.setPeerUserName(iMInfo.driverName);
        iMBusinessParam.setPeerEngNickName(iMInfo.driverName);
        iMBusinessParam.setPeerUserAvatar(iMInfo.driverPhoto);
        String userFirstName = NationComponentDataUtil.getUserFirstName();
        if (!TextUtils.isEmpty(userFirstName)) {
            iMBusinessParam.setSelfUserName(userFirstName);
            iMBusinessParam.setSelfEngNickName(userFirstName);
        } else {
            String string = ResourcesHelper.getString(this.mContext, R.string.global_im_default_name_prefix);
            String string2 = ResourcesHelper.getString(this.mContext, R.string.global_im_default_name_prefix_default);
            iMBusinessParam.setSelfUserName(string);
            iMBusinessParam.setSelfEngNickName(string2);
        }
        String userAvatarUrl = NationComponentDataUtil.getUserAvatarUrl(getHost().getContext());
        if (!TextUtils.isEmpty(userAvatarUrl)) {
            iMBusinessParam.setSelfUserAvatar(userAvatarUrl);
        }
    }

    /* access modifiers changed from: protected */
    public void refreshUI() {
        m9882a(!this.f14135f);
    }

    /* renamed from: b */
    private void m9884b() {
        IMEngine.getUnreadSysChatMessageCount(this.f14131b, (IMSessionUnreadSysChatMsgCallback) new IMSessionUnreadSysChatMsgCallback() {
            public void unreadSysChatMsg(IMSysChatUnreadCount iMSysChatUnreadCount) {
                if (iMSysChatUnreadCount != null) {
                    ((IIMEntranceView) AbsIMEntrancePresenter.this.mView).refreshMessageCount(iMSysChatUnreadCount);
                }
            }
        });
    }

    /* renamed from: c */
    private void m9886c() {
        m9882a(false);
    }

    /* renamed from: a */
    private void m9882a(boolean z) {
        if (z) {
            IMManager.getInstance().getUnreadMessageCount(this.f14131b, (IMSessionUnreadCallback) new IMSessionUnreadCallback() {
                public void unReadCount(int i) {
                    AbsIMEntrancePresenter.this.doPublish(BaseEventKeys.C4621IM.EVENT_IM_NEW_MESSAGE, Integer.valueOf(i));
                    AbsIMEntrancePresenter.this.onIMUnreadMessageUpdated(i);
                }
            });
        } else {
            IMEngine.getUnreadMsgInfo(this.f14131b, new IMUnreadMsgLoadCallback() {
                public void onIMMsgLoad(int i, int i2, List<IMMsg> list) {
                    if (list != null && list.size() != 0) {
                        AbsIMEntrancePresenter.this.doPublish(BaseEventKeys.C4621IM.EVENT_IM_NEW_MESSAGE, Integer.valueOf(i));
                        AbsIMEntrancePresenter.this.updateIMMsg(i, list);
                        int unused = AbsIMEntrancePresenter.this.f14134e = i;
                    }
                }
            });
        }
        m9884b();
    }

    /* access modifiers changed from: protected */
    public void updateIMMsg(int i, List<IMMsg> list) {
        ((IIMEntranceView) this.mView).refreshMessageCount(i);
        if (i == 0) {
            ((IIMEntranceView) this.mView).setIMLastMsg((IMMsg) null);
        } else {
            ((IIMEntranceView) this.mView).setIMLastMsg((IMMsg) CollectionUtils.getOrNull(list, 0));
        }
    }

    /* access modifiers changed from: protected */
    public void closeSession() {
        if (this.f14131b > 0) {
            this.f14133d = true;
            this.f14132c.setSecret("");
            IMEngine.closeSession(this.f14131b);
            if (IMEngine.isChatDetailAcvitiyTop(this.f14131b)) {
                IMEngine.finishChatDetailAcvitiy(this.f14131b);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void closeIMActivity() {
        IMEngine.closeSession(this.f14131b);
        if (IMEngine.isChatDetailAcvitiyTop(this.f14131b)) {
            IMEngine.finishChatDetailAcvitiy(this.f14131b);
        }
    }

    /* access modifiers changed from: protected */
    public int getUnreadCount() {
        return this.f14134e;
    }
}
