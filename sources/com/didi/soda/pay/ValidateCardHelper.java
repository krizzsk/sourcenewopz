package com.didi.soda.pay;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.payment.creditcard.open.IGlobalCreditCardApi;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.pay.ValidateCardHelper;
import com.didichuxing.security.cardverify.DiCardVerify;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/pay/ValidateCardHelper;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ValidateCardHelper.kt */
public final class ValidateCardHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f43638a = "ValidateCardHelper";

    @Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nJO\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00060\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/pay/ValidateCardHelper$Companion;", "", "()V", "TAG", "", "validateCard", "", "cardNo", "cardIndex", "requestCode", "", "validateCardV2", "successFunction", "Lkotlin/Function0;", "failedFunction", "Lkotlin/Function1;", "Lcom/didi/soda/customer/foundation/rpc/entity/SceneParamsEntity;", "Lkotlin/ParameterName;", "name", "senceParams", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ValidateCardHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void validateCard(String str, String str2, int i) {
            DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
            verifyCardParam.cardIndex = str2;
            verifyCardParam.cardNo = str;
            verifyCardParam.productId = AppConst.BUSINESS_ID;
            if (GlobalContext.isEmbed()) {
                DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity((Fragment) GlobalContext.getFragment(), i, verifyCardParam);
                return;
            }
            IGlobalCreditCardApi createGlobalCreditCardApi = DidiCreditCardFactory.createGlobalCreditCardApi();
            Context context = GlobalContext.getContext();
            if (context != null) {
                createGlobalCreditCardApi.startVerifyBalanceActivity((FragmentActivity) context, i, verifyCardParam);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }

        public static /* synthetic */ void validateCardV2$default(Companion companion, String str, String str2, Function0 function0, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = ValidateCardHelper$Companion$validateCardV2$1.INSTANCE;
            }
            if ((i & 8) != 0) {
                function1 = ValidateCardHelper$Companion$validateCardV2$2.INSTANCE;
            }
            companion.validateCardV2(str, str2, function0, function1);
        }

        public final void validateCardV2(String str, String str2, Function0<Unit> function0, Function1<? super SceneParamsEntity, Unit> function1) {
            Intrinsics.checkNotNullParameter(function0, "successFunction");
            Intrinsics.checkNotNullParameter(function1, "failedFunction");
            DiCardVerify.globalPayRandomPayVerify(GlobalContext.getContext(), new DiCardVerifyParam.Builder(GlobalContext.getContext()).cardIndex(str2).cardNo(str).productId(AppConst.BUSINESS_ID).terminalId("300106").country(LocationUtil.getPoiCountryCode()).language(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag()).uid(LoginUtil.getUid()).token(LoginUtil.getToken()).latitude(String.valueOf(LocationUtil.getCurrentLat())).longitude(String.valueOf(LocationUtil.getCurrentLng())).mo120734ip(CustomerSystemUtil.getLocalIpAddress(GlobalContext.getContext())).build(), new DiCardVerifyCallback(function1, str) {
                public final /* synthetic */ Function1 f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onCallback(int i, String str) {
                    ValidateCardHelper.Companion.m47031validateCardV2$lambda1(Function0.this, this.f$1, this.f$2, i, str);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: validateCardV2$lambda-1  reason: not valid java name */
        public static final void m47031validateCardV2$lambda1(Function0 function0, Function1 function1, String str, int i, String str2) {
            Intrinsics.checkNotNullParameter(function0, "$successFunction");
            Intrinsics.checkNotNullParameter(function1, "$failedFunction");
            if (i == 0) {
                function0.invoke();
            } else {
                SceneParamsEntity sceneParamsEntity = new SceneParamsEntity();
                sceneParamsEntity.setCode(i);
                sceneParamsEntity.setCardSuffix(str);
                Unit unit = Unit.INSTANCE;
                function1.invoke(sceneParamsEntity);
            }
            String access$getTAG$cp = ValidateCardHelper.f43638a;
            LogUtil.m29104i(access$getTAG$cp, "call back code=" + i + " msg=" + str2);
        }
    }
}
