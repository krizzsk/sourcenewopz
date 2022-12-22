package com.didi.payment.kycservice.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/kycservice/utils/KycSPUtils;", "", "()V", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KycSPUtils.kt */
public final class KycSPUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f30930a = "kyc_sp";

    @JvmStatic
    public static final String getApartmentNum(Context context, String str) {
        return Companion.getApartmentNum(context, str);
    }

    @JvmStatic
    public static final String getBirthday(Context context, String str) {
        return Companion.getBirthday(context, str);
    }

    @JvmStatic
    public static final String getCPF(Context context, String str) {
        return Companion.getCPF(context, str);
    }

    @JvmStatic
    public static final String getCity(Context context, String str) {
        return Companion.getCity(context, str);
    }

    @JvmStatic
    public static final String getDistrict(Context context, String str) {
        return Companion.getDistrict(context, str);
    }

    @JvmStatic
    public static final GuidesInfoResp.Income getIncome(Context context) {
        return Companion.getIncome(context);
    }

    @JvmStatic
    public static final String getName(Context context, String str) {
        return Companion.getName(context, str);
    }

    @JvmStatic
    public static final String getOptionalInfo(Context context, String str) {
        return Companion.getOptionalInfo(context, str);
    }

    @JvmStatic
    public static final SharedPreferences getSP(Context context) {
        return Companion.getSP(context);
    }

    @JvmStatic
    public static final String getState(Context context, String str) {
        return Companion.getState(context, str);
    }

    @JvmStatic
    public static final String getStreet(Context context, String str) {
        return Companion.getStreet(context, str);
    }

    @JvmStatic
    public static final String getZipCode(Context context, String str) {
        return Companion.getZipCode(context, str);
    }

    @JvmStatic
    public static final boolean isCheckedTc(Context context, String str) {
        return Companion.isCheckedTc(context, str);
    }

    @JvmStatic
    public static final boolean isMissingMotherName(Context context, String str) {
        return Companion.isMissingMotherName(context, str);
    }

    @JvmStatic
    public static final boolean isNoApartmentNum(Context context, String str) {
        return Companion.isNoApartmentNum(context, str);
    }

    @JvmStatic
    public static final void putApartmentNum(Context context, String str, String str2) {
        Companion.putApartmentNum(context, str, str2);
    }

    @JvmStatic
    public static final void putBirthday(Context context, String str, String str2) {
        Companion.putBirthday(context, str, str2);
    }

    @JvmStatic
    public static final void putCPF(Context context, String str, String str2) {
        Companion.putCPF(context, str, str2);
    }

    @JvmStatic
    public static final void putCity(Context context, String str, String str2) {
        Companion.putCity(context, str, str2);
    }

    @JvmStatic
    public static final void putDistrict(Context context, String str, String str2) {
        Companion.putDistrict(context, str, str2);
    }

    @JvmStatic
    public static final void putIncome(Context context, GuidesInfoResp.Income income) {
        Companion.putIncome(context, income);
    }

    @JvmStatic
    public static final void putName(Context context, String str, String str2) {
        Companion.putName(context, str, str2);
    }

    @JvmStatic
    public static final void putOptionalInfo(Context context, String str, String str2) {
        Companion.putOptionalInfo(context, str, str2);
    }

    @JvmStatic
    public static final void putState(Context context, String str, String str2) {
        Companion.putState(context, str, str2);
    }

    @JvmStatic
    public static final void putStreet(Context context, String str, String str2) {
        Companion.putStreet(context, str, str2);
    }

    @JvmStatic
    public static final void putZipCode(Context context, String str, String str2) {
        Companion.putZipCode(context, str, str2);
    }

    @JvmStatic
    public static final void setIsNoApartmentNum(Context context, String str, boolean z) {
        Companion.setIsNoApartmentNum(context, str, z);
    }

    @JvmStatic
    public static final void setMissingMotherName(Context context, String str, boolean z) {
        Companion.setMissingMotherName(context, str, z);
    }

    @Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J \u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J \u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0007J \u0010!\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0007J \u0010#\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0007J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u000eH\u0007J \u0010'\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0007J \u0010)\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0007J \u0010+\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0007J \u0010-\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0007J \u0010/\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0007J\u001e\u00101\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0017J \u00103\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0017H\u0007J \u00104\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00066"}, mo175978d2 = {"Lcom/didi/payment/kycservice/utils/KycSPUtils$Companion;", "", "()V", "KYC_SP_XML", "", "getApartmentNum", "context", "Landroid/content/Context;", "phone", "getBirthday", "getCPF", "getCity", "getDistrict", "getIncome", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "getName", "getOptionalInfo", "getSP", "Landroid/content/SharedPreferences;", "getState", "getStreet", "getZipCode", "isCheckedTc", "", "isMissingMotherName", "isNoApartmentNum", "putApartmentNum", "", "num", "putBirthday", "birthday", "putCPF", "cpf", "putCity", "city", "putDistrict", "district", "putIncome", "income", "putName", "name", "putOptionalInfo", "optionalInfo", "putState", "state", "putStreet", "street", "putZipCode", "zipcode", "setCheckedTc", "boolean", "setIsNoApartmentNum", "setMissingMotherName", "missing", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: KycSPUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String getName(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_name"), "");
        }

        @JvmStatic
        public final void putName(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(str2, "name");
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_name"), str2).apply();
        }

        @JvmStatic
        public final String getBirthday(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_birthday"), "");
        }

        @JvmStatic
        public final void putBirthday(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(str2, "birthday");
            PayBaseParamUtil.getStringParam(context, "uid");
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_birthday"), str2).apply();
        }

        @JvmStatic
        public final String getCPF(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_cpf"), "");
        }

        @JvmStatic
        public final void putCPF(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(str2, "cpf");
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_cpf"), str2).apply();
        }

        @JvmStatic
        public final GuidesInfoResp.Income getIncome(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_income_type"), "");
            String string2 = getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_income_display"), "");
            GuidesInfoResp.Income income = new GuidesInfoResp.Income();
            income.setType(String.valueOf(string));
            income.setDisplay(String.valueOf(string2));
            return income;
        }

        @JvmStatic
        public final void putIncome(Context context, GuidesInfoResp.Income income) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(income, "income");
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_income_type"), income.getType()).apply();
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_income_display"), income.getDisplay()).apply();
        }

        @JvmStatic
        public final String getZipCode(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_zipcode"), "");
        }

        @JvmStatic
        public final void putZipCode(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(str2, "zipcode");
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_zipcode"), str2).apply();
        }

        @JvmStatic
        public final boolean isMissingMotherName(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getBoolean(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_missing_mother_name"), false);
        }

        @JvmStatic
        public final void setMissingMotherName(Context context, String str, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            getSP(context).edit().putBoolean(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_missing_mother_name"), z).apply();
        }

        @JvmStatic
        public final String getApartmentNum(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_apartment_num"), "");
        }

        @JvmStatic
        public final void putApartmentNum(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(str2, "num");
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_apartment_num"), str2).apply();
        }

        @JvmStatic
        public final boolean isNoApartmentNum(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getBoolean(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_no_number"), false);
        }

        @JvmStatic
        public final void setIsNoApartmentNum(Context context, String str, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            getSP(context).edit().putBoolean(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_no_number"), z).apply();
        }

        @JvmStatic
        public final String getStreet(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_street"), "");
        }

        @JvmStatic
        public final void putStreet(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(str2, "street");
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_street"), str2).apply();
        }

        @JvmStatic
        public final String getOptionalInfo(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_optional_info"), "");
        }

        @JvmStatic
        public final void putOptionalInfo(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(str2, "optionalInfo");
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_optional_info"), str2).apply();
        }

        @JvmStatic
        public final String getDistrict(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_district"), "");
        }

        @JvmStatic
        public final void putDistrict(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(str2, ParamKeys.PARAM_DISTRICT);
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_district"), str2).apply();
        }

        @JvmStatic
        public final String getState(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_state"), "");
        }

        @JvmStatic
        public final void putState(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(str2, "state");
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_state"), str2).apply();
        }

        @JvmStatic
        public final String getCity(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_city"), "");
        }

        @JvmStatic
        public final void putCity(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(str2, "city");
            getSP(context).edit().putString(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_city"), str2).apply();
        }

        @JvmStatic
        public final boolean isCheckedTc(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            return getSP(context).getBoolean(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_tc"), false);
        }

        public final void setCheckedTc(Context context, String str, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "phone");
            getSP(context).edit().putBoolean(Intrinsics.stringPlus(PayBaseParamUtil.getStringParam(context, "uid"), "kyc_tc"), z).apply();
        }

        @JvmStatic
        public final SharedPreferences getSP(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(ApplicationContextProvider.Companion.getContext(), KycSPUtils.f30930a, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "ApplicationContextProvid…ODE_PRIVATE\n            )");
            return sharedPreferences;
        }
    }
}
