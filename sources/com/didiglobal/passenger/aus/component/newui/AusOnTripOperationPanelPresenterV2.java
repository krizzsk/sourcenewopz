package com.didiglobal.passenger.aus.component.newui;

import com.didi.component.business.sharetrip.CommonTripShareManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.operationpanel.impl.newui.presenter.GlobalOnTripOperationPanelPresenterV2;
import com.didi.onekeyshare.entity.SharePlatform;
import java.util.ArrayList;

public class AusOnTripOperationPanelPresenterV2 extends GlobalOnTripOperationPanelPresenterV2 {
    public AusOnTripOperationPanelPresenterV2(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onShareItemClicked() {
        if (this.mShareManager == null) {
            this.mShareManager = new CommonTripShareManager(m36223b());
        }
        super.onShareItemClicked();
    }

    /* renamed from: b */
    private ArrayList<SharePlatform> m36223b() {
        ArrayList<SharePlatform> arrayList = new ArrayList<>();
        arrayList.add(SharePlatform.FACEBOOK_PLATFORM);
        arrayList.add(SharePlatform.EMAIL_PLATFORM);
        arrayList.add(SharePlatform.SYSTEM_MESSAGE);
        arrayList.add(SharePlatform.TWITTER_PLATFORM);
        arrayList.add(SharePlatform.WHATSAPP_PLATFORM);
        arrayList.add(SharePlatform.LINE_PLATFORM);
        return arrayList;
    }
}
