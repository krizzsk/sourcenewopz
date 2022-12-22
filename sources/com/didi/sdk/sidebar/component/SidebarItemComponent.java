package com.didi.sdk.sidebar.component;

import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.remotereslibrary.utils.DLog;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.component.search.city.p148db.DIDIDbTables;
import com.didi.sdk.events.CustomerDataStatus;
import com.didi.sdk.events.IMRefreshEvent;
import com.didi.sdk.events.RedDotStatusChangedEvent;
import com.didi.sdk.events.RedDotStatusEvent;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.data.DataContainer;
import com.didi.sdk.sidebar.data.SideBarDbUtil;
import com.didi.sdk.sidebar.model.RedPoints;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.SideBarNewItemView;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@ComponentType(name = "menu_common_link")
public class SidebarItemComponent extends AbsComponent<SideBarNewItemView> {

    /* renamed from: b */
    private static final int f37212b = 44;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SideBarNewItemView f37213a;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showRedDot(RedDotStatusEvent redDotStatusEvent) {
    }

    public SidebarItemComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    /* access modifiers changed from: protected */
    public void initData(SideBarNewItemView sideBarNewItemView) {
        this.f37213a = sideBarNewItemView;
        if (this.sidebarItem.getId() == 44) {
            EventBus.getDefault().register(this);
        }
        sideBarNewItemView.setName(this.sidebarItem.getName());
        sideBarNewItemView.setIcon(this.sidebarItem.getIconUrl());
        sideBarNewItemView.setMessageRedot(this.sidebarItem.getRedTag());
        RedPoints redPoints = this.sidebarItem.getRedPoints();
        int i = 0;
        sideBarNewItemView.setRedDotVisibility((redPoints == null || redPoints.getIsCLicked() != 0) ? 8 : 0);
        RedPoints fireTorch = this.sidebarItem.getFireTorch();
        if (fireTorch == null || fireTorch.getIsCLicked() != 0) {
            i = 8;
        }
        sideBarNewItemView.setFireTorchVisibility(i);
        sideBarNewItemView.setDiscountMsg(this.sidebarItem.getDiscountMsg());
    }

    /* access modifiers changed from: protected */
    public SideBarNewItemView createComponentView() {
        return new SideBarNewItemView(this.businessContext.getContext());
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        RedPoints redPoints = this.sidebarItem.getRedPoints();
        if (this.sidebarItem != null) {
            int i = 0;
            if (redPoints != null && redPoints.getIsCLicked() == 0) {
                redPoints.setIsCLicked(1);
                this.f37213a.setRedDotVisibility(8);
                SideBarDbUtil.update(DIDIApplication.getAppContext(), redPoints.getId(), 1, DIDIDbTables.SideBarReddotColumn.CONTENT_URI);
                EventBus.getDefault().post(new RedDotStatusChangedEvent(false));
            }
            if (!TextUtils.isEmpty(this.sidebarItem.getRedTag())) {
                DataContainer.getInstance().refreshCache(this.sidebarItem);
                this.sidebarItem.setRedTag("");
                this.f37213a.setMessageRedot("");
                EventBus.getDefault().post(new CustomerDataStatus());
            }
            String traceEvent = this.sidebarItem.getTraceEvent();
            if (!TextUtils.isEmpty(traceEvent)) {
                HashMap hashMap = new HashMap();
                hashMap.put("redpoint", Integer.valueOf((redPoints == null || redPoints.getIsCLicked() != 0) ? 0 : 1));
                hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
                hashMap.put("country_code", NationTypeUtil.getNationComponentData().getLocCountry());
                if (traceEvent.equals("pas_home_message_ck")) {
                    hashMap.put("is_login", 1);
                    if (this.f37213a.getRedDotVisibility() == 0) {
                        i = 1;
                    }
                    hashMap.put("redpoint", Integer.valueOf(i));
                } else if (traceEvent.equals("pas_sidebar_help_ck")) {
                    hashMap.put("number", (this.sidebarItem.getRedTag() == null || this.sidebarItem.getRedTag().isEmpty()) ? "0" : this.sidebarItem.getRedTag());
                }
                if (traceEvent.equals("pas_sidebar_payment_ck")) {
                    hashMap.put("tag", this.sidebarItem.getDiscountMsg());
                }
                OmegaSDKAdapter.trackEvent(traceEvent, (Map<String, Object>) hashMap);
            }
        }
        super.onClick(view);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshIM(IMRefreshEvent iMRefreshEvent) {
        m26391a();
    }

    /* renamed from: a */
    private void m26391a() {
        IMEngine.getAllUnreadMessageCount(new IMSessionUnreadCallback() {
            public void unReadCount(int i) {
                if (i <= 0 || SidebarItemComponent.this.sidebarItem.getId() != 44) {
                    SidebarItemComponent.this.f37213a.setRedDotVisibility(8);
                    EventBus.getDefault().post(new RedDotStatusChangedEvent(false));
                    return;
                }
                DLog.m23371d("redDot", "doIMRefresh");
                SidebarItemComponent.this.f37213a.setRedDotVisibility(0);
                EventBus.getDefault().post(new RedDotStatusChangedEvent(true));
            }
        });
    }
}
