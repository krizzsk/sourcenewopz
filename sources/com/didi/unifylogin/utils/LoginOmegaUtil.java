package com.didi.unifylogin.utils;

import android.text.TextUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.track.FirebaseEventTrack;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoginOmegaUtil {
    public static final String ACTIONID = "Actionid";
    public static final String ACTIONID_HIDE = "hide";
    public static final String ACTIONID_SW = "sw";
    public static final String APP_ID = "appid";
    public static final String BYID_CK = "tone_p_x_byid_ck";
    public static final String CODEFAIL_BYID_CK = "tone_p_x_codefail_byid_ck";
    public static final String CODEFAIL_BYVCODE_CK = "tone_p_x_codefail_byvcode_ck";
    public static final String CODEFAIL_BYWHATSAPP_CK = "tone_p_x_codefail_bywhatsapp_ck";
    public static final String CODEFAIL_CANCEL_CK = "tone_p_x_codefail_cancel_ck";
    public static final String CONFM_CK = "tone_p_x_login_confm_ck";
    public static final String CONFM_NEWUSER_CK = "tone_p_x_login_confm_newuser_ck";
    public static final String COUNTRY = "country";
    public static final String COUNTRY_CK = "tone_p_x_login_country_ck";
    public static final String COUNTRY_CODE = "country_code";
    public static final String EMAIL_STATUS = "status";
    public static final String ERRNO = "errno";
    public static final String ERROR_TYPE = "error_type";
    public static final String GP_EMAILREGISTERPROMO_DLG_CK = "gp_emailRegisterPromo_dlg_ck";
    public static final String GP_EMAILREGISTERPROMO_DLG_SW = "gp_emailRegisterPromo_dlg_sw";
    public static final String GP_EMAIL_INPUT_CONTEXT = "gp_email_input_context";
    public static final String GP_FIRSTNAME_INPUT_CONTEXT = "gp_firstname_input_context";
    public static final String GP_LASTNAME_INPUT_CONTEXT = "gp_lastname_input_context";
    public static final String GP_NOT_FINISH_INIT = "tech_gp_not_finish_init_login";
    public static final String GP_PHONENUMBER_ET_EVENT = "gp_phonenumber_et_event";
    public static final String GP_RECEIVE_SUCCESS_VIEW_SW = "gp_receivesuccess_view_sw";
    public static final String IBT_DELETE_ACCOUNT_GUIDE_NEXT_CK = "ibt_delete_account_guide_next_ck";
    public static final String IBT_DELETE_ACCOUNT_GUIDE_SW = "ibt_delete_account_guide_sw";
    public static final String IDCHECK_FAIL_SW = "tone_p_x_idcheck_fail_sw";
    public static final String IDCHECK_SUCCESS_SW = "tone_p_x_idcheck_success_sw";
    public static final String ISAPPERRNO = "isAppErrno";
    public static final String LAW_CK = "tone_p_x_login_law_ck";
    public static final String LAW_CONFM_SW = "tone_p_x_law_confm_sw";
    public static final String LOGIN_FAIL_SW = "tone_p_x_login_fail_sw";
    public static final String LOGIN_SUCCESS_SW = "tone_p_x_login_success_sw";
    public static final String NEED_VERIFY_EMAIL = "verify";
    public static final String NEW_USER = "new";
    public static final String NO_EMAIL = "no";
    public static final String OLD_USER = "old";
    public static final String PAGE = "page";
    public static final String PAS_LOGIN_AUTHORITY_SW = "pas_login_authority_sw";
    public static final String PAS_RETURN_CK = "pas_return_ck";
    public static final String PHOECHECK_NOID_SW = "tone_p_x_phoecheck_noid_sw";
    public static final String PHOE_FORGET_CK = "tone_p_x_phoe_forget_ck";
    public static final String PHOE_UNAVAIL_CK = "tone_p_x_phoe_unavail_ck";
    public static final String PSWDCHGE_FORGET_CK = "tone_p_x_pswdchge_forget_ck";
    public static final String PSWDCHGE_NEW_DISPLAY_CK = "tone_p_x_pswdchge_new_display_ck";
    public static final String PSWDCHGE_NEW_MISMATCH_SW = "tone_p_x_pswdchge_new_mismatch_sw";
    public static final String PSWDCHGE_OLD_DISPLAY_CK = "tone_p_x_pswdchge_old_display_ck";
    public static final String PSWDCHGE_OLD_ERROR_SW = "tone_p_x_pswdchge_old_error_sw";
    public static final String PSWDCHGE_SUCCESS_SW = "tone_p_x_pswdchge_success_sw";
    public static final String PSWDINP_DISPLAY_CK = "tone_p_x_pswdinp_display_ck";
    public static final String PSWDINP_FORGET_CK = "tone_p_x_pswdinp_forget_ck";
    public static final String PSWDSET_DISPLAY_CK = "tone_p_x_pswdset_display_ck";
    public static final String PUB_IBTPASLOGIN_COUNTRY_CK = "pub_ibtpaslogin_country_ck";
    public static final String PUB_IBTPASLOGIN_DELETE_CK = "pub_ibtpaslogin_delete_ck";
    public static final String PUB_IBTPASLOGIN_NUMBER_CK = "pub_ibtpaslogin_number_ck";
    public static final String PUB_IBTPASLOGIN_PHOTE_SW = "pub_ibtpaslogin_photo_sw";
    public static final String PUB_IBTPASLOGIN_SOCIAL_CK = "pub_ibtpaslogin_social_ck";
    public static final String ROLE_CANCEL_CK = "tone_p_x_role_cancel_ck";
    public static final String SCENE = "Scene";
    public static final String SMS_GETFAIL_CK = "tone_p_x_sms_getfail_ck";
    public static final String SOCIAL = "social";
    public static final String TECH_PASSPORT_LOGOUT_KICK = "tech_passport_logout_kick";
    public static final String TECH_PASSPORT_LOGOUT_POSITIVE = "tech_passport_logout_positive";
    public static final String TECH_PAX_EVENT_LOGIN_ERROR = "tech_pax_event_login_error";
    public static final String TECH_PAX_EVENT_THIRD_PARTY_TOKEN_ERROR = "tech_pax_event_thirdparty_token_error";
    public static final String TEL = "tel";
    public static final String TONE_P_PROMO_INPUTBOX_CK = "tone_p_x_promo_inputbox_ck";
    public static final String TONE_P_X_ACCGTBACK_UNAVAIL_SW = "tone_p_x_accgtback_unavail_sw";
    public static final String TONE_P_X_ACCOUNT_LOGINFINISH = "tone_p_x_account_loginfinish";
    public static final String TONE_P_X_ACCOUNT_LOGINNEW_SW = "tone_p_x_account_loginnew_sw";
    public static final String TONE_P_X_CODEFAIL_BYEMAIL_CK = "tone_p_x_codefail_byemail_ck";
    public static final String TONE_P_X_CODEFAIL_CHOICE_SW = "tone_p_x_codefail_choice_sw";
    public static final String TONE_P_X_EMAIL_EDIT_SW = "tone_p_x_email_edit_sw";
    public static final String TONE_P_X_EMAIL_INPUTBOX_CK = "tone_p_x_email_inputbox_ck";
    public static final String TONE_P_X_EMAIL_NEW_SW = "tone_p_x_email_new_sw";
    public static final String TONE_P_X_EMAIL_REG = "tone_p_x_email_reg";
    public static final String TONE_P_X_EMAIL_SK = "tone_p_x_email_sk";
    public static final String TONE_P_X_EMAIL_SW = "tone_p_x_email_sw";
    public static final String TONE_P_X_EMAIL_VERIFYCONFIRM_CK = "tone_p_x_email_verifyconfirm_ck";
    public static final String TONE_P_X_EMAIL_VERIFYCONFIRM_SW = "tone_p_x_email_verifyconfirm_sw";
    public static final String TONE_P_X_EMAIL_VERIFY_CK = "tone_p_x_email_verify_ck";
    public static final String TONE_P_X_FNAME_INPUTBOX_CK = "tone_p_x_fname_inputbox_ck";
    public static final String TONE_P_X_LINK_SOCIALLINK_CK = "tone_p_x_link_sociallink_ck";
    public static final String TONE_P_X_LINK_SOCIALUNLINK_CK = "tone_p_x_link_socialunlink_ck";
    public static final String TONE_P_X_LINK_SW = "tone_p_x_link_sw";
    public static final String TONE_P_X_LNAME_INPUTBOX_CK = "tone_p_x_lname_inputbox_ck";
    public static final String TONE_P_X_LOGIN_BACKUP_CK = "tone_p_x_login_backup_ck";
    public static final String TONE_P_X_LOGIN_CODE_CHECK = "tone_p_x_login_code_check";
    public static final String TONE_P_X_LOGIN_CONFM_USERTYPE_CK = "tone_p_x_login_confm_usertype_ck";
    public static final String TONE_P_X_LOGIN_FACE_CK = "tone_p_x_login_face_ck";
    public static final String TONE_P_X_LOGIN_FACE_DESC_CK = "tone_p_x_login_face_desc_ck";
    public static final String TONE_P_X_LOGIN_FACE_DESC_SW = "tone_p_x_login_face_desc_sw";
    public static final String TONE_P_X_LOGIN_FACE_FAILTOAST = "tone_p_x_login_face_failtoast";
    public static final String TONE_P_X_LOGIN_GET_COUNTRY_BY_AREA = "tone_p_x_login_get_country_by_area";
    public static final String TONE_P_X_LOGIN_GET_COUNTRY_BY_SIM = "tone_p_x_login_get_country_by_sim";
    public static final String TONE_P_X_LOGIN_GET_COUNTRY_CHINA = "tone_p_x_login_get_country_china";
    public static final String TONE_P_X_LOGIN_IDENTITY_SW = "login_identity_sw";
    public static final String TONE_P_X_LOGIN_LINKPHONE_SC = "tone_p_x_login_linkphone_sc";
    public static final String TONE_P_X_LOGIN_LINKPHONE_SW = "tone_p_x_login_linkphone_sw";
    public static final String TONE_P_X_LOGIN_PHONE_CHECK = "tone_p_x_login_phone_check";
    public static final String TONE_P_X_LOGIN_PSWDINP_SW = "tone_p_x_login_pswdinp_sw";
    public static final String TONE_P_X_LOGIN_PSWDUPD_SW = "tone_p_x_login_pswdupd_sw";
    public static final String TONE_P_X_LOGIN_PW_SMS_CK = "tone_p_x_login_pw_sms_ck";
    public static final String TONE_P_X_LOGIN_ROLE_SW = "tone_p_x_login_role_sw";
    public static final String TONE_P_X_LOGIN_SOCIAL_CK = "tone_p_x_login_social_ck";
    public static final String TONE_P_X_LOGIN_USERENTER = "tone_p_x_login_user_enter";
    public static final String TONE_P_X_MIGRATION_ERROR = "tone_p_x_migration_error";
    public static final String TONE_P_X_MIGRATION_SUCCESS = "tone_p_x_migration_success";
    public static final String TONE_P_X_ONEKEYLOGIN_AUTHORIZE_SW = "tone_p_x_onekeylogin_authorize_sw";
    public static final String TONE_P_X_ONEKEYLOGIN_FAIL = "tone_p_x_onekeylogin_fail";
    public static final String TONE_P_X_PHOECHECK_NEW_SW = "tone_p_x_phoecheck_new_sw";
    public static final String TONE_P_X_PHOECHECK_OLD_SW = "tone_p_x_phoecheck_old_sw";
    public static final String TONE_P_X_PHOECHECK_PHOEREG_SW = "tone_p_x_phoecheck_phoereg_sw";
    public static final String TONE_P_X_PHOECHGE_CHANGE_CK = "tone_p_x_phoechge_change_ck";
    public static final String TONE_P_X_PHOECHGE_NEW_SW = "tone_p_x_phoechge_new_sw";
    public static final String TONE_P_X_PHOECHGE_PHOEREG_SW = "tone_p_x_phoechge_phoereg_sw";
    public static final String TONE_P_X_PHOECHGE_SC = "tone_p_x_phoechge_sc";
    public static final String TONE_P_X_PHOECHGE_SW = "tone_p_x_phoechge_sw";
    public static final String TONE_P_X_PHOECHGE_TIPS_CANCEL_CK = "tone_p_x_phoechge_tips_cancel_ck";
    public static final String TONE_P_X_PHOECHGE_TIPS_CONFIRM_CK = "tone_p_x_phoechge_tips_confirm_ck";
    public static final String TONE_P_X_PHOECHGE_TIPS_SW = "tone_p_x_phoechge_tips_sw";
    public static final String TONE_P_X_PHOEFGT_SW = "tone_p_x_phoefgt_sw";
    public static final String TONE_P_X_PSWDCHGE_SW = "tone_p_x_pswdchge_sw";
    public static final String TONE_P_X_PSWDSET_SW = "tone_p_x_pswdset_sw";
    public static final String TONE_P_X_REAL_NAME_AUTH_RESUL_SW = "tone_p_x_real_name_auth_result_sw";
    public static final String TONE_P_X_REAL_NAME_AUTH_SW = "tone_p_x_real_name_auth_sw";
    public static final String TONE_P_X_SKIP_CK = "tone_p_x_skip_ck";
    public static final String TONE_P_X_SMS_ANRECEIVE_CK = "tone_p_x_sms_anreceive_ck";
    public static final String TONE_P_X_SMS_ANRECEIVE_SW = "tone_p_x_sms_anreceive_sw";
    public static final String TONE_P_X_SOCIALUNLINK_CANCEL_CK = "tone_p_x_socialunlink_cancel_ck";
    public static final String TONE_P_X_SOCIALUNLINK_CONFIRM_CK = "tone_p_x_socialunlink_confirm_ck";
    public static final String TONE_P_X_SOCIALUNLINK_CONFIRM_SW = "tone_p_x_socialunlink_confirm_sw";
    public static final String TONE_P_X_TOAST_SW = "tone_p_x_toast_sw";
    public static final String TONE_P_X_VCODE_EMAIL_SW = "tone_p_x_vcode_email_sw";
    public static final String TONE_P_X_VCODE_PIC_SW = "tone_p_x_vcode_pic_sw";
    public static final String TONE_P_X_VCODE_SMS_SW = "tone_p_x_vcode_sms_sw";
    public static final String TONE_P_X_VERIFY_EMAIL_HELP_CK = "tone_p_x_verify_email_help_ck";
    public static final String TONE_P_X_VERIFY_EMAIL_HELP_DAILOG = "tone_p_x_verify_email_help_dailog_sw";
    public static final String TONE_P_X_VERIFY_EMAIL_HELP_DAILOG_CALL = "tone_p_x_verify_email_help_dailog_call";
    public static final String TONE_P_X_VERIFY_EMAIL_HELP_DAILOG_CANCEL = "tone_p_x_verify_email_help_dailog_cancel";
    public static final String TONE_P_X_VERIFY_EMAIL_SW = "tone_p_x_verify_email_sw";
    public static final String UID = "uid";
    public static final String USER_TYPE = "user_type";
    public static final String VCODE_VOICE_SW = "tone_p_x_vcode_voice_sw";
    public static final String VERIFYED_EMAIL = "verifyed";

    /* renamed from: c */
    private static FragmentMessenger f44934c;
    public static Map<String, Object> omegaMap;

    /* renamed from: a */
    private String f44935a;

    /* renamed from: b */
    private Map<String, Object> f44936b;

    public static Map<String, Object> getOmegaMap() {
        return omegaMap;
    }

    public static void setOmegaMap(Map<String, Object> map) {
        omegaMap = map;
    }

    public static void addOmegaMap(Map<String, Object> map) {
        if (omegaMap == null) {
            omegaMap = new HashMap();
        }
        omegaMap.putAll(map);
    }

    public static FragmentMessenger getMessenger() {
        return f44934c;
    }

    public static void setMessenger(FragmentMessenger fragmentMessenger) {
        f44934c = fragmentMessenger;
    }

    public static void trackEvent(String str) {
        new LoginOmegaUtil(str).send();
    }

    public LoginOmegaUtil(String str) {
        this.f44935a = str;
        HashMap hashMap = new HashMap();
        this.f44936b = hashMap;
        appendCommonAttrs(hashMap);
    }

    public LoginOmegaUtil(String str, AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        this.f44935a = str;
        HashMap hashMap = new HashMap();
        this.f44936b = hashMap;
        appendCommonAttrs(hashMap);
        if (absThirdPartyLoginBase != null) {
            this.f44936b.put("social", absThirdPartyLoginBase.getChannel());
        }
    }

    public void send() {
        OmegaSDKAdapter.trackEvent(this.f44935a, this.f44936b);
        m32219b();
    }

    public LoginOmegaUtil add(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f44936b.put(str, obj);
        }
        return this;
    }

    public LoginOmegaUtil addAll(Map<String, Object> map) {
        if (map != null) {
            this.f44936b.putAll(map);
        }
        return this;
    }

    /* renamed from: a */
    private String m32218a() {
        try {
            String phone = LoginStore.getInstance().getPhone();
            if (!TextUtil.isEmpty(phone)) {
                return phone;
            }
            String cell = f44934c.getCell();
            return TextUtil.isEmpty(cell) ? f44934c.getNewCell() : cell;
        } catch (Exception unused) {
            return "";
        }
    }

    public void appendCommonAttrs(Map<String, Object> map) {
        if (map != null) {
            Map<String, Object> map2 = omegaMap;
            if (map2 != null) {
                map.putAll(map2);
            }
            map.put("country_code", CountryManager.getIns().getCurrentCountryCode());
            map.put("appid", Integer.valueOf(LoginStore.getInstance().getAppId()));
            map.put("user_type", LoginStore.getInstance().getUserType() == 1 ? "new" : OLD_USER);
            if (!FragmentMessenger.scenesStack.isEmpty()) {
                if (ListenerManager.getParamsListener() != null && !CollectionUtil.isEmpty((Map<?, ?>) ListenerManager.getParamsListener().getOmegaParams())) {
                    map.putAll(ListenerManager.getParamsListener().getOmegaParams());
                }
                LoginScene nowScene = FragmentMessenger.getNowScene();
                map.put("Scene", Integer.valueOf(nowScene.getSceneNum()));
                String pageName = getPageName(nowScene, FragmentMessenger.nowState);
                if (!TextUtil.isEmpty(pageName)) {
                    map.put("page", pageName);
                }
                String a = m32218a();
                if (!TextUtil.isEmpty(a)) {
                    map.put("tel", a);
                }
                map.put("is_release", Integer.valueOf(LoginStore.isDebug ^ true ? 1 : 0));
            }
        }
    }

    /* renamed from: com.didi.unifylogin.utils.LoginOmegaUtil$1 */
    static /* synthetic */ class C146431 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$unifylogin$utils$LoginState;

        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(3:51|52|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.unifylogin.utils.LoginState[] r0 = com.didi.unifylogin.utils.LoginState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$unifylogin$utils$LoginState = r0
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_INFO_ACTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_NEW_CODE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_CODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PASSWORD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_INPUT_PHONE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_CONFIRM_PHONE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_NEW_PHONE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_CAPTCHA     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_SET_PWD     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_SET_PWD     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_VERIFY_OLD_PWD     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_SET_CELL     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_RETRIEVE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_FORGET_CELL     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_NAME_ACTION     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_EMAIL_ACTION     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_BIND_THIRD_PHONE     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_THIRD_PARTY_SET     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_SET_EMAIL     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_NEW_EMAIL     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_CERTIFICATION     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_CONFIRM_SNATCH     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_SETCELL_ERROR     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x012c }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_EMAIL_CODE     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_VERIFY_EMAIL     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.utils.LoginOmegaUtil.C146431.<clinit>():void");
        }
    }

    public static void jump(LoginState loginState) {
        new LoginOmegaUtil(TONE_P_X_SKIP_CK).send();
        if (C146431.$SwitchMap$com$didi$unifylogin$utils$LoginState[loginState.ordinal()] == 1) {
            new LoginOmegaUtil(TONE_P_X_EMAIL_SK).send();
        }
    }

    public static String getPageName(LoginScene loginScene, LoginState loginState) {
        if (loginScene == null || loginState == null) {
            return null;
        }
        switch (C146431.$SwitchMap$com$didi$unifylogin$utils$LoginState[loginState.ordinal()]) {
            case 1:
            case 15:
            case 16:
                return "STATE_INPUT_PROFILE";
            case 2:
            case 3:
                return "STATE_CODE";
            case 4:
                return "STATE_PASSWORD";
            case 5:
                return "STATE_INPUT_PHONE";
            case 6:
                return "STATE_OLD_PHONE";
            case 7:
                return loginScene == LoginScene.SCENE_SET_PHONE ? "STATE_CHANGE_PHONE_NEW" : "STATE_NEW_PHONE";
            case 8:
                return "STATE_CAPTCHA";
            case 9:
                return "STATE_SET_PWD";
            case 10:
                return "STATE_GUIDE_PWDUPD";
            case 11:
                return "STATE_CHANGE_PWD";
            case 12:
                return "STATE_CHANGE_PHONE";
            case 13:
                return "STATE_UNAV_PHONE";
            case 14:
                return "STATE_FORGET_PHONE";
            case 17:
                return "STATE_PHONE_LINK";
            case 18:
                return "STATE_SOCIAL_LIST";
            case 19:
                return "STATE_EDIT_EMAIL";
            case 20:
                return "STATE_EDIT_EMAIL_NEW";
            case 21:
                return "STATE_ACTION_FACESDK";
            case 22:
                return "STATE_CAN_CHANGE_PHONE_INFO";
            case 23:
                return "STATE_CAN_NOT_CHANGE_PHONE_INFO";
            case 24:
                return "STATE_UNKNOWN";
            default:
                return null;
        }
    }

    public static void pageShow(LoginState loginState, FragmentMessenger fragmentMessenger) {
        if (loginState != null) {
            LoginScene loginScene = LoginScene.SCENE_UNDEFINED;
            int i = 0;
            if (fragmentMessenger != null) {
                loginScene = fragmentMessenger.getScene();
                i = fragmentMessenger.getCodeType();
            }
            switch (C146431.$SwitchMap$com$didi$unifylogin$utils$LoginState[loginState.ordinal()]) {
                case 1:
                    new LoginOmegaUtil(TONE_P_X_EMAIL_SW).add("code_type", Integer.valueOf(i)).send();
                    return;
                case 2:
                case 3:
                    new LoginOmegaUtil(TONE_P_X_VCODE_SMS_SW).add("tel", fragmentMessenger.getCell()).send();
                    return;
                case 4:
                    new LoginOmegaUtil(TONE_P_X_LOGIN_PSWDINP_SW).send();
                    return;
                case 5:
                    if (loginScene == LoginScene.SCENE_RETRIEVE) {
                        new LoginOmegaUtil(TONE_P_X_PHOECHECK_OLD_SW).send();
                        return;
                    } else {
                        new LoginOmegaUtil(TONE_P_X_ACCOUNT_LOGINNEW_SW).send();
                        return;
                    }
                case 7:
                    new LoginOmegaUtil(TONE_P_X_PHOECHECK_NEW_SW).send();
                    return;
                case 8:
                    new LoginOmegaUtil(TONE_P_X_VCODE_PIC_SW).send();
                    return;
                case 9:
                    new LoginOmegaUtil(TONE_P_X_PSWDSET_SW).send();
                    return;
                case 10:
                    new LoginOmegaUtil(TONE_P_X_LOGIN_PSWDUPD_SW).send();
                    return;
                case 11:
                    new LoginOmegaUtil(TONE_P_X_PSWDCHGE_SW).send();
                    return;
                case 12:
                    new LoginOmegaUtil(TONE_P_X_PHOECHGE_SW).send();
                    return;
                case 13:
                    new LoginOmegaUtil(TONE_P_X_ACCGTBACK_UNAVAIL_SW).send();
                    return;
                case 14:
                    new LoginOmegaUtil(TONE_P_X_PHOEFGT_SW).send();
                    return;
                case 17:
                    new LoginOmegaUtil(TONE_P_X_LOGIN_LINKPHONE_SW).send();
                    return;
                case 18:
                    new LoginOmegaUtil(TONE_P_X_LINK_SW).send();
                    return;
                case 20:
                    new LoginOmegaUtil(TONE_P_X_EMAIL_NEW_SW).send();
                    return;
                case 21:
                    new LoginOmegaUtil(TONE_P_X_LOGIN_IDENTITY_SW).send();
                    return;
                case 22:
                    new LoginOmegaUtil(TONE_P_X_PHOECHGE_TIPS_SW).send();
                    return;
                case 23:
                    new LoginOmegaUtil(TONE_P_X_PHOECHGE_PHOEREG_SW).send();
                    return;
                case 25:
                    new LoginOmegaUtil(TONE_P_X_VCODE_EMAIL_SW).send();
                    return;
                case 26:
                    new LoginOmegaUtil(TONE_P_X_VERIFY_EMAIL_SW).send();
                    return;
                default:
                    return;
            }
        }
    }

    public static void trackBackEvent() {
        LoginState loginState = FragmentMessenger.nowState;
        HashMap hashMap = new HashMap();
        int i = C146431.$SwitchMap$com$didi$unifylogin$utils$LoginState[loginState.ordinal()];
        if (i == 3) {
            hashMap.put("page", "vcode");
            OmegaSDKAdapter.trackEvent(PAS_RETURN_CK, (Map<String, Object>) hashMap);
        } else if (i == 5) {
            hashMap.put("page", "phone");
            OmegaSDKAdapter.trackEvent(PAS_RETURN_CK, (Map<String, Object>) hashMap);
        } else if (i == 16) {
            hashMap.put("page", "email");
            OmegaSDKAdapter.trackEvent(PAS_RETURN_CK, (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: b */
    private void m32219b() {
        if (TONE_P_X_LOGIN_CODE_CHECK.equals(this.f44935a) && !OLD_USER.equals(this.f44936b.get("user_type")) && this.f44936b.get("errno") != null && ((Integer) this.f44936b.get("errno")).intValue() == 0) {
            Iterator<S> it = ServiceLoader.load(FirebaseEventTrack.class).iterator();
            while (it.hasNext()) {
                ((FirebaseEventTrack) it.next()).trackEvent();
            }
        }
    }

    public static void trackLoginErrorEvent(int i, String str, int i2, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("err_type", Integer.valueOf(i));
        hashMap.put("err_msg", str);
        hashMap.put("err_no", Integer.valueOf(i2));
        hashMap.put(ParamConst.TRACE_ID, str2);
        hashMap.put("api_name", str3);
        hashMap.put("channel", str4);
        OmegaSDKAdapter.trackEvent(TECH_PAX_EVENT_LOGIN_ERROR, (Map<String, Object>) hashMap);
    }
}
