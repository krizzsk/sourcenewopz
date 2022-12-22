package com.didi.component.openride.newscan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.bff.BFFStore;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.util.AppUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didiglobal.scan.GlobalScan;
import com.didiglobal.scan.data.ManualInputInfoItem;
import com.didiglobal.scan.delegate.ScanSchemeDispatcherDelegate;
import com.didiglobal.scan.view.activity.GlobalScanActivity;
import java.util.ArrayList;

public class GlobalQRScanActivity extends GlobalScanActivity {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14736a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_SUG_PAGE.equals(str)) {
                GlobalQRScanActivity.this.finish();
            }
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14737b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_BIND_CARD.equals(str)) {
                DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                addCardParam.bindType = 1;
                addCardParam.resourceId = ScarShareReportModel.CHANNEL_MESSENGER;
                DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity((Activity) GlobalQRScanActivity.this, 100, addCardParam);
            }
        }
    };

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, GlobalQRScanActivity.class);
        ArrayList arrayList = new ArrayList();
        ManualInputInfoItem manualInputInfoItem = new ManualInputInfoItem();
        manualInputInfoItem.setActionType(ScanSchemeDispatcherDelegate.ActionType.OPENRIDE.getType());
        String str = FormStore.getInstance().getOpenRideHasOnlinePayAbility() ? "1" : "0";
        String str2 = "taxis99OneTravel://one/openridemanulinputpage?pay_method_check_result=" + str;
        String str3 = "globalOneTravel://one/openridemanulinputpage?pay_method_check_result=" + str;
        if (AppUtils.isBrazilApp(context)) {
            manualInputInfoItem.setScheme(str2);
        } else {
            manualInputInfoItem.setScheme(str3);
        }
        arrayList.add(manualInputInfoItem);
        intent.putExtras(GlobalScan.INSTANCE.getScanExtra(GlobalScan.ScanFrom.SIDEBAR, BFFStore.getCarWanliuUserType(context), arrayList));
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_SUG_PAGE, this.f14736a);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_BIND_CARD, this.f14737b);
        GlobalOmegaUtils.trackEvent("Pas_99GO_qrcode_sw");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                FormStore.getInstance().setIsOpenRideFromDeepLinkBindCardSuc(true);
                FormStore.getInstance().setOpenRideHasOnlinePayAbility(true);
                return;
            }
            if (FormStore.getInstance().isOpenRideFromDeepLink()) {
                FormStore.getInstance().setIsOpenRideFromDeepLink(false);
            }
            FormStore.getInstance().setIsFromOpenRide(false);
        }
    }

    public void onBackPress() {
        GlobalOmegaUtils.trackEvent("Pas_99GO_qrcode_back");
        PinCodeInfoResult driverInfo = FormStore.getInstance().getDriverInfo();
        if (driverInfo != null) {
            m10542a(2, driverInfo.driverId);
        }
        FormStore.getInstance().clear();
        finish();
    }

    /* renamed from: a */
    private void m10542a(int i, String str) {
        CarRequest.notifyDriverStateOfPsg(this, i, str, (ResponseListener<BaseObject>) null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_SUG_PAGE, this.f14736a);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_BIND_CARD, this.f14737b);
    }
}
