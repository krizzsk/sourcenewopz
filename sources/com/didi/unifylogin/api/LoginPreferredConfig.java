package com.didi.unifylogin.api;

import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.store.LoginStore;
import java.util.List;

public class LoginPreferredConfig {

    /* renamed from: A */
    private static int f44624A = -1;

    /* renamed from: B */
    private static boolean f44625B = false;
    public static final int GRAY_BUTTON = 0;
    public static final int ORANGE_BUTTON = 1;
    public static final int ORANGE_GRADUAL_BUTTON = 2;

    /* renamed from: a */
    private static int f44626a = 0;

    /* renamed from: b */
    private static String f44627b = null;
    public static String brand = "DiDi";

    /* renamed from: c */
    private static String f44628c = null;

    /* renamed from: d */
    private static boolean f44629d = true;

    /* renamed from: e */
    private static boolean f44630e = false;

    /* renamed from: f */
    private static boolean f44631f = true;

    /* renamed from: g */
    private static boolean f44632g = true;

    /* renamed from: h */
    private static boolean f44633h = false;

    /* renamed from: i */
    private static boolean f44634i = false;

    /* renamed from: j */
    private static boolean f44635j = false;

    /* renamed from: k */
    private static int f44636k = 2132017646;

    /* renamed from: l */
    private static int f44637l = 0;

    /* renamed from: m */
    private static boolean f44638m = false;

    /* renamed from: n */
    private static boolean f44639n = true;

    /* renamed from: o */
    private static boolean f44640o = false;

    /* renamed from: p */
    private static List<String> f44641p = null;

    /* renamed from: q */
    private static boolean f44642q = false;

    /* renamed from: r */
    private static boolean f44643r = false;

    /* renamed from: s */
    private static boolean f44644s = false;

    /* renamed from: t */
    private static LoginTextAdapter f44645t = new LoginTextAdapter();

    /* renamed from: u */
    private static int f44646u = -1;

    /* renamed from: v */
    private static boolean f44647v = true;

    /* renamed from: w */
    private static boolean f44648w = false;

    /* renamed from: x */
    private static boolean f44649x = false;

    /* renamed from: y */
    private static boolean f44650y = false;

    /* renamed from: z */
    private static boolean f44651z = false;

    public static String getLawHint() {
        return f44627b;
    }

    public static String getLawUrl() {
        return f44628c;
    }

    public static boolean isCanSwitchCountry() {
        return f44629d;
    }

    public static boolean isHomeCanBacke() {
        return f44630e;
    }

    public static int getButtonStyle() {
        return f44626a;
    }

    public static boolean getIsLawCbUseCache() {
        return f44647v;
    }

    public static void setIsLawCbUseCache(boolean z) {
        f44647v = z;
    }

    public static boolean isDefLawSelected() {
        return f44633h;
    }

    public static void setDefLawSelected(boolean z) {
        f44633h = z;
        if (isDefLawSelected()) {
            LoginStore.getInstance().setLawChecked(true);
        }
    }

    public static void setButtonStyle(int i) {
        f44626a = i;
    }

    public static void setLawHint(String str) {
        f44627b = str;
    }

    public static void setLawUrl(String str) {
        f44628c = str;
    }

    public static void setCanSwitchCountry(boolean z) {
        f44629d = z;
    }

    public static void setHomeCanBacke(boolean z) {
        f44630e = z;
    }

    public static boolean isNeedPrePage() {
        return f44631f;
    }

    public static void setNeedPrePage(boolean z) {
        f44631f = z;
    }

    public static boolean isCloseRetrieve() {
        return f44632g;
    }

    public static void setCloseRetrieve(boolean z) {
        f44632g = z;
    }

    public static void setSupportJump(boolean z) {
        f44634i = z;
    }

    public static boolean isSupportJump() {
        return f44634i;
    }

    public static void setAutoFullCode(boolean z) {
        f44635j = z;
    }

    public static boolean isAutoFullCode() {
        return f44635j;
    }

    public static int getThemeResInt() {
        return f44636k;
    }

    public static void setThemeResInt(int i) {
        f44636k = i;
    }

    public static boolean isExchangeNamePosition() {
        return f44638m;
    }

    public static void setExchangeNamePosition(boolean z) {
        f44638m = z;
    }

    public static boolean isUnifyPwd() {
        return f44639n;
    }

    public static void setUnifyPwd(boolean z) {
        f44639n = z;
    }

    public static void setCancelDescribes(List<String> list) {
        f44641p = list;
    }

    public static List<String> getCancelDescribes() {
        return f44641p;
    }

    public static boolean isAllowOptLoginByCode() {
        return f44640o;
    }

    public static void setAllowOptLoginByCode(boolean z) {
        f44640o = z;
    }

    public static void setUseWeakPwd(boolean z) {
        f44642q = z;
    }

    public static boolean isUseWeakPwd() {
        return f44642q;
    }

    public static boolean isDeleteAccountPageUseTextStyle() {
        return f44643r;
    }

    public static void setDeleteAccountPageUseTextStyle(boolean z) {
        f44643r = z;
    }

    public static boolean isUsePassengerUIStyle() {
        return f44644s;
    }

    public static void setUsePassengerUIStyle(boolean z) {
        f44644s = z;
    }

    public static void setTextAdapter(LoginTextAdapter loginTextAdapter) {
        f44645t = loginTextAdapter;
    }

    public static LoginTextAdapter getTextAdapter(FragmentMessenger fragmentMessenger) {
        if (f44645t == null) {
            f44645t = new LoginTextAdapter();
        }
        f44645t.setMessage(fragmentMessenger);
        return f44645t;
    }

    public static int getCodeReducedTime() {
        return f44646u;
    }

    public static void setCodeReducedTime(int i) {
        f44646u = i;
    }

    public static void setShowEmailLoginEntrance(boolean z) {
        f44649x = z;
    }

    public static boolean getShowEmailEntrance() {
        return f44649x;
    }

    public static boolean isIsShowChangePhoneByIDEntrance() {
        return f44648w;
    }

    public static void setIsShowChangePhoneByIDEntrance(boolean z) {
        f44648w = z;
    }

    public static void setOptionalEmail(boolean z) {
        f44650y = z;
    }

    public static boolean isOptionalEmail() {
        return f44650y;
    }

    public static void setNewUserCpfIntercept(boolean z) {
        f44651z = z;
    }

    public static boolean isNewUserCpfIntercept() {
        return f44651z;
    }

    public static int getDefCountryOldId() {
        return f44624A;
    }

    public static void setDefCountryByOldId(int i) {
        f44624A = i;
    }

    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String str) {
        brand = str;
    }

    public static boolean isPasswordEncrypt() {
        return f44625B;
    }

    public static void setIsPasswordEncrypt(boolean z) {
        f44625B = z;
    }

    public static int getThemeColor() {
        return f44637l;
    }

    public static void setThemeColor(int i) {
        f44637l = i;
    }
}
