package com.didiglobal.privacysdk;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class GlobalOmegaUtils {

    /* renamed from: a */
    private static final String f50559a = "ibt_gd_profile_setting_privacy_center_entrance_ck";

    /* renamed from: b */
    private static final String f50560b = "ibt_gd_profile_setting_privacy_center_personal_data_download_entrance_ck";

    /* renamed from: c */
    private static final String f50561c = "ibt_gd_profile_setting_privacy_center_system_permission_entrance_ck";

    /* renamed from: d */
    private static final String f50562d = "ibt_gd_profile_setting_shared_position_switch_status_sw";

    /* renamed from: e */
    private static final String f50563e = "ibt_gd_profile_setting_shared_position_comfirm_close_ck";

    /* renamed from: f */
    private static final String f50564f = "ibt_gd_profile_setting_discount_and_information_switch_status_sw";

    /* renamed from: g */
    private static final String f50565g = "ibt_ibt_gd_profile_setting_discount_and_information_confirm_close_ck";

    /* renamed from: h */
    private static final String f50566h = "ibt_gd_profile_setting_position_authority_switch_status_sw";

    /* renamed from: i */
    private static final String f50567i = "ibt_gd_profile_setting_camera_authority_switch_status_sw";

    /* renamed from: j */
    private static final String f50568j = "ibt_gd_profile_setting_address_book_swich_status_sw";

    /* renamed from: k */
    private static final String f50569k = "ibt_gd_profile_setting_album_authorityn_switch_status_sw";

    /* renamed from: l */
    private static final String f50570l = "ibt_gd_profile_setting_microphone_authority_switch_status_sw";

    /* renamed from: m */
    private static final String f50571m = "account_type";

    /* renamed from: n */
    private static final String f50572n = "user_id";

    /* renamed from: o */
    private static final String f50573o = "type";

    /* renamed from: p */
    private static final String f50574p = "channel";

    /* renamed from: q */
    private static final int f50575q = 1;

    /* renamed from: r */
    private static final int f50576r = 2;

    /* renamed from: a */
    private static int m36337a(boolean z) {
        return z ? 1 : 2;
    }

    public static void sendSettingPrivacyEntranceClick() {
        m36340a(f50559a, new HashMap());
    }

    public static void sendDataDownloadEntranceCK() {
        m36340a(f50560b, new HashMap());
    }

    public static void sendSystemPermissionEntranceCK() {
        m36340a(f50561c, new HashMap());
    }

    public static void sendSharedPositionSwitchStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m36337a(z)));
        m36340a(f50562d, hashMap);
    }

    public static void sendSharedPositionConfirmCloseCk() {
        m36340a(f50563e, new HashMap());
    }

    public static void sendDiscountSwitchStatusSw(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("channel", str);
        hashMap.put("type", Integer.valueOf(m36337a(z)));
        m36340a(f50564f, hashMap);
    }

    public static void sendDiscountSwitchConfirmCloseCk(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("channel", str);
        m36340a(f50565g, hashMap);
    }

    public static void sendPositionAuthorityStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m36337a(z)));
        m36340a(f50566h, hashMap);
    }

    public static void sendCameraAuthorityStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m36337a(z)));
        m36340a(f50567i, hashMap);
    }

    public static void sendAddressBookAuthorityStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m36337a(z)));
        m36340a(f50568j, hashMap);
    }

    public static void sendAlbumAuthorityStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m36337a(z)));
        m36340a(f50569k, hashMap);
    }

    public static void sendMicrophoneAuthorityStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m36337a(z)));
        m36340a(f50570l, hashMap);
    }

    /* renamed from: a */
    private static String m36338a() {
        return GlobalPrivacySDK.getAccountType();
    }

    /* renamed from: b */
    private static String m36341b() {
        return GlobalPrivacySDK.getUserId();
    }

    /* renamed from: a */
    private static void m36340a(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(f50571m, m36338a());
        map.put("user_id", m36341b());
        m36339a(str, (String) null, map);
    }

    /* renamed from: a */
    private static void m36339a(String str, String str2, Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent(str, str2, map);
    }
}
