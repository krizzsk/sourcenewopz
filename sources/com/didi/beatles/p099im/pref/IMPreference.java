package com.didi.beatles.p099im.pref;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.beatles.im.pref.IMPreference */
public class IMPreference {
    public static String CHECK_RECORD_PERMISSION = "check_record_permission";
    public static final String IM_RED_DOT = "im_red_dot";
    public static final String SURFIX_MAX = "_max_single";
    public static final String TAB_POINT_NUMBER = "tab_point_number";
    public static String USER_CUSTOM_USEFUL_EXPRESSION = "user_custom_useful_expression";

    /* renamed from: a */
    private static IMPreference f9543a = null;

    /* renamed from: b */
    private static final String f9544b = "should_show_add_word_guide";

    /* renamed from: c */
    private static final String f9545c = "should_show_delete_word_guide";

    /* renamed from: d */
    private static final String f9546d = "should_driver_word_guide";

    /* renamed from: e */
    private static final String f9547e = "top_guide_view";

    /* renamed from: f */
    private static final String f9548f = "use_inner_file";

    /* renamed from: g */
    private static final String f9549g = "use_move_file_";

    /* renamed from: h */
    private static final String f9550h = "url_type";

    /* renamed from: i */
    private static final String f9551i = "off_line_ip";

    /* renamed from: j */
    private static final String f9552j = "list_show_feed";

    /* renamed from: k */
    private static final String f9553k = "notify_close_time";

    /* renamed from: l */
    private static final String f9554l = "take_photo_action_tip_";

    /* renamed from: m */
    private static final String f9555m = "more_btn_take_photo_guide_";

    /* renamed from: n */
    private static final String f9556n = "sql_cipher_enable_count";

    /* renamed from: o */
    private static final String f9557o = "crash_count_new_in";

    /* renamed from: p */
    private static final String f9558p = "p_ext_act_red_dot_count_";

    /* renamed from: q */
    private static final String f9559q = "btm_tab_red_dot_count_";

    /* renamed from: r */
    private static final String f9560r = "p_robot_slide_guide_tip_";

    /* renamed from: s */
    private static final String f9561s = "p_robot_click_robot_guide_tip_";

    /* renamed from: t */
    private static final String f9562t = "sys_audio_auto_play_count_";

    /* renamed from: u */
    private static final String f9563u = "bottom_tab_select_plugin_id_";

    /* renamed from: v */
    private static final String f9564v = "phone_guide_toast_show_";

    /* renamed from: w */
    private static final String f9565w = "complaint_guide_toast_show_";

    /* renamed from: x */
    private SharedPreferences f9566x;

    private IMPreference(Context context) {
        this.f9566x = SystemUtils.getSharedPreferences(context, "didi_im_v1", 0);
    }

    public static IMPreference getInstance(Context context) {
        if (f9543a == null) {
            f9543a = new IMPreference(context);
        }
        return f9543a;
    }

    public long getMaxSingleId(long j) {
        IMLog.m6631d("IMPreference", "uid is " + j + " all preference is " + this.f9566x.getAll());
        SharedPreferences sharedPreferences = this.f9566x;
        return sharedPreferences.getLong(String.valueOf(j) + SURFIX_MAX, 0);
    }

    public void saveMaxSingleId(long j, long j2) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putLong(String.valueOf(j) + SURFIX_MAX, j2);
        edit.apply();
    }

    public void saveTabNumber(int i) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(TAB_POINT_NUMBER, i);
        edit.apply();
    }

    public boolean getImLocationPageGuide() {
        return this.f9566x.getBoolean("ImLocationPageGuide", true);
    }

    public void setImLocationPageGuide() {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putBoolean("ImLocationPageGuide", false);
        edit.apply();
    }

    public int getTabNumber() {
        return this.f9566x.getInt(TAB_POINT_NUMBER, 0);
    }

    public void setIsHaveRedDot(boolean z) {
        if (this.f9566x.getBoolean(IM_RED_DOT, false) && z) {
            return;
        }
        if (this.f9566x.getBoolean(IM_RED_DOT, false) || z) {
            SharedPreferences.Editor edit = this.f9566x.edit();
            edit.putBoolean(IM_RED_DOT, z);
            edit.apply();
        }
    }

    public boolean isHaveRedDot() {
        return this.f9566x.getBoolean(IM_RED_DOT, false);
    }

    public void setCheckRecord(int i) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(CHECK_RECORD_PERMISSION, i);
        edit.apply();
    }

    public int isNotNeedCheckRecord() {
        return this.f9566x.getInt(CHECK_RECORD_PERMISSION, 0);
    }

    public void saveStringValue(String str, String str2) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public String getStringValue(String str, String str2) {
        return this.f9566x.getString(str, str2);
    }

    public boolean shouldShowAddWordGuide() {
        return this.f9566x.getBoolean(f9544b, true);
    }

    public boolean shouldShowDelteWordGuide() {
        return this.f9566x.getBoolean(f9545c, true);
    }

    public boolean shouldDriverWordGuide() {
        return this.f9566x.getBoolean(f9546d, true);
    }

    public void showedDriverWordGuide() {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putBoolean(f9546d, false);
        edit.apply();
    }

    public void showedAddWordGuide() {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putBoolean(f9544b, false);
        edit.apply();
    }

    public void showedDeleteWordGuide() {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putBoolean(f9545c, false);
        edit.apply();
    }

    public boolean shouldShowTopGuide() {
        return this.f9566x.getBoolean(f9547e, true);
    }

    public void hasShowTopViewGuide() {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putBoolean(f9547e, false);
        edit.apply();
    }

    public void setUseInnerFile() {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putBoolean(f9548f, true);
        edit.apply();
    }

    public boolean isUseInnerFile() {
        return this.f9566x.getBoolean(f9548f, false);
    }

    public void setUrlType(int i) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(f9550h, i);
        edit.apply();
    }

    public int getUrlType() {
        return this.f9566x.getInt(f9550h, 0);
    }

    public void setOffLineIp(String str) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putString(f9551i, str);
        edit.apply();
    }

    public String getOffLineIp() {
        return this.f9566x.getString(f9551i, "");
    }

    public void setListShowFeed(boolean z) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putBoolean(f9552j, z);
        edit.apply();
    }

    public boolean isListShowFeed(boolean z) {
        return this.f9566x.getBoolean(f9552j, z);
    }

    public void setNotifyCloseTime(long j) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putLong(f9553k, j);
        edit.apply();
    }

    public long getNotifyCloseTime() {
        return this.f9566x.getLong(f9553k, 0);
    }

    public Set<String> getTakPhotoActionTip(long j) {
        SharedPreferences sharedPreferences = this.f9566x;
        return sharedPreferences.getStringSet(f9554l + j, new HashSet());
    }

    public void setTakePhotoActionTip(long j, Set<String> set) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putStringSet(f9554l + j, set);
        edit.apply();
    }

    public int getCrashCount() {
        return this.f9566x.getInt(f9557o, 0);
    }

    public void increaseCrashCount() {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(f9557o, getCrashCount() + 1);
        edit.apply();
    }

    public void decreaseCrashCount() {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(f9557o, getCrashCount() - 1);
        edit.apply();
    }

    public int getPluginExtendActionRedDotShowedCount(long j, int i) {
        SharedPreferences sharedPreferences = this.f9566x;
        return sharedPreferences.getInt(f9558p + j + "_" + i, 0);
    }

    public void savePluginExtendActionRedDotShowedCount(long j, int i, int i2) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(f9558p + j + "_" + i, i2);
        edit.apply();
    }

    public int getBtmTabRedDotShowedCount(long j, int i) {
        SharedPreferences sharedPreferences = this.f9566x;
        return sharedPreferences.getInt(f9559q + j + "_" + i, 0);
    }

    public void saveBtmTabRedDotShowedCount(long j, int i, int i2) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(f9559q + j + "_" + i, i2);
        edit.apply();
    }

    public Set<String> getRobotSlideGuideTip(long j) {
        SharedPreferences sharedPreferences = this.f9566x;
        return sharedPreferences.getStringSet(f9560r + j, new HashSet());
    }

    public void setRobotSlideGuideTip(long j, Set<String> set) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putStringSet(f9560r + j, set);
        edit.apply();
    }

    public void setInValue(String str, int i) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public int getInValue(String str, int i) {
        return this.f9566x.getInt(str, i);
    }

    public void setSetValue(String str, Set<String> set) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    public Set<String> getSetValue(String str, Set<String> set) {
        return this.f9566x.getStringSet(str, set);
    }

    public int getRobotClickRobotGuideTip(long j) {
        SharedPreferences sharedPreferences = this.f9566x;
        return sharedPreferences.getInt(f9561s + j, 0);
    }

    public void setRobotClickRobotGuideTip(long j, int i) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(f9561s + j, i);
        edit.apply();
    }

    public int getSysAudioAutoPlayCount(long j) {
        SharedPreferences sharedPreferences = this.f9566x;
        return sharedPreferences.getInt(f9562t + j, 0);
    }

    public void setSysAudioAutoPlayCount(long j, int i) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(f9562t + j, i);
        edit.apply();
    }

    public int getBottomTabSelectPluginId(long j, int i) {
        SharedPreferences sharedPreferences = this.f9566x;
        return sharedPreferences.getInt(f9563u + j, i);
    }

    public void setBottomTabSelectPluginId(long j, int i) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putInt(f9563u + j, i);
        edit.apply();
    }

    public boolean isPhoneGuideShow(long j) {
        SharedPreferences sharedPreferences = this.f9566x;
        return sharedPreferences.getBoolean(f9564v + j, false);
    }

    public void setPhoneGuideShow(long j) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putBoolean(f9564v + j, true);
        edit.apply();
    }

    public boolean isComplaintGuideShow(long j) {
        SharedPreferences sharedPreferences = this.f9566x;
        return sharedPreferences.getBoolean(f9565w + j, false);
    }

    public void setComplaintGuideShow(long j) {
        SharedPreferences.Editor edit = this.f9566x.edit();
        edit.putBoolean(f9565w + j, true);
        edit.apply();
    }
}
