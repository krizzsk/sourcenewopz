package com.didi.soda.customer.biz.popdialog;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.component.framework.pages.promo.helper.PromoCodeInterceptor;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogHelper;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.Clock;
import com.didi.soda.customer.foundation.rpc.entity.NAPopUpParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromoCodeEntity;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class PromoCodeRepo extends Repo<PromoCodeEntity> {

    /* renamed from: a */
    private static final String f40477a = "PromoCodeRepo";

    /* renamed from: b */
    private long f40478b = -1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AtomicBoolean f40479c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f40480d = new Runnable() {
        public void run() {
            PromoCodeRepo.this.f40479c.set(true);
            NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
            nAPopUpParamsEntity.position = 1;
            PopDialogHelper.triggerNAPopFetch(nAPopUpParamsEntity);
        }
    };

    public void fetchHomePopInfo() {
        PromoCodeEntity data = ((PromoCodeStorage) SingletonFactory.get(PromoCodeStorage.class)).getData();
        m28704a("fetchHomePopInfo promoCode = ", data.firstFetch + data.promoCode).build().info();
        if (CustomerApolloUtil.isSkipPromoCode() || !data.firstFetch || GlobalContext.isEmbed()) {
            NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
            nAPopUpParamsEntity.position = 1;
            PopDialogHelper.triggerNAPopFetch(nAPopUpParamsEntity);
        } else {
            m28706a();
        }
        data.firstFetch = false;
        ((PromoCodeStorage) SingletonFactory.get(PromoCodeStorage.class)).setData(data);
    }

    public SimpleAFConversionListener initAppsFlyer(final boolean z) {
        PromoCodeEntity data = ((PromoCodeStorage) SingletonFactory.get(PromoCodeStorage.class)).getData();
        if (data != null && (!TextUtils.isEmpty(data.promoCode) || !data.firstFetch)) {
            return null;
        }
        PerformanceOmegaHelper.getInstance().appsflyerTracker(ParamConst.PARAM_APPSFLYER_REGISTER, (String) null);
        C136352 r0 = new SimpleAFConversionListener() {
            public void onConversionDataSuccess(Map<String, Object> map) {
                String str;
                String str2;
                if (map != null) {
                    str2 = String.valueOf(map.get(PromoCodeInterceptor.PROMO_CODE));
                    str = String.valueOf(map.get("af_status"));
                } else {
                    str2 = null;
                    str = "";
                }
                AppsFlyersLauncherKt.appFlyersDataTrack(map);
                PerformanceOmegaHelper.getInstance().appsflyerTracker(ParamConst.PARAM_PROMOCODE_RECEIVED, str2);
                PromoCodeRepo.this.m28704a("onInstallConversionDataLoaded = ", str2).build().info();
                PromoCodeRepo.this.m28708a(str2);
                UiHandlerUtil.removeCallbacks(PromoCodeRepo.this.f40480d);
                if (!PromoCodeRepo.this.f40479c.get()) {
                    NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
                    nAPopUpParamsEntity.position = 1;
                    PopDialogHelper.triggerNAPopFetch(nAPopUpParamsEntity);
                }
                if (AppsFlyerHelperKt.doInstantUri(map, true) || z) {
                    LogUtil.m29104i("initAppsFlyer", "从外链打开APP");
                } else if (str.equalsIgnoreCase("organic")) {
                    OrganicManager.Companion.doDispatch();
                } else {
                    AppsFlyersLauncherKt.appFlyersLaunch(map);
                }
            }
        };
        this.f40478b = Clock.timeAtSeconds();
        return r0;
    }

    /* renamed from: a */
    private void m28706a() {
        long timeAtSeconds = Clock.timeAtSeconds() - this.f40478b;
        m28704a("delayFetchHomePopInfo ", String.valueOf(timeAtSeconds)).build().info();
        if (this.f40478b <= 0 || timeAtSeconds <= 0 || timeAtSeconds > 5) {
            NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
            nAPopUpParamsEntity.position = 1;
            PopDialogHelper.triggerNAPopFetch(nAPopUpParamsEntity);
            return;
        }
        UiHandlerUtil.postDelayed(this.f40480d, timeAtSeconds * 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28708a(String str) {
        PromoCodeEntity promoCodeEntity = new PromoCodeEntity();
        promoCodeEntity.promoCode = str;
        if (!TextUtils.isEmpty(promoCodeEntity.promoCode)) {
            ((PromoCodeStorage) SingletonFactory.get(PromoCodeStorage.class)).setData(promoCodeEntity);
        }
        setValue(promoCodeEntity);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RecordTracker.Builder m28704a(String... strArr) {
        return RecordTracker.Builder.create().setTag(f40477a).setLogModule("m-home|").setMessage(Arrays.toString(strArr)).setLogCategory("c-data|");
    }
}
