package com.didichuxing.util;

import com.didichuxing.request.ServerParam;
import com.didichuxing.upgrade.UpgradeConfig;
import com.didiglobal.enginecore.data.parser.XEParseConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0006\u0010\b\u001a\u00020\u0001\u001a\u0006\u0010\t\u001a\u00020\u0001\u001a\u0006\u0010\n\u001a\u00020\u0001\u001a\u001e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0006\u0010\u0012\u001a\u00020\u0001\u001a\u000e\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0010\u001a\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0006\u0010\u0016\u001a\u00020\u0001¨\u0006\u0017"}, mo175978d2 = {"OmegaTrack_alert_ck", "", "OmegaTrack_alert_ignoe", "OmegaTrack_alert_show", "OmegaTrack_appupdate_guide_gp_acct_ck", "email", "", "OmegaTrack_appupdate_guide_gp_back_ck", "OmegaTrack_appupdate_guide_gp_beta_ck", "OmegaTrack_appupdate_guide_gp_beta_sw", "OmegaTrack_appupdate_iau_req", "OmegaTrack_appupdate_iau_resp", "success", "", "is_update", "versionCode", "", "OmegaTrack_appupdate_iau_update_sw", "OmegaTrack_first_start", "OmegaTrack_request_fail", "errorCode", "OmegaTrack_request_start", "OmegaTrack_request_success", "upgrade_release"}, mo175979k = 2, mo175980mv = {1, 1, 15})
/* compiled from: OmegaUtils.kt */
public final class OmegaUtilsKt {
    public static final void OmegaTrack_first_start() {
        Map hashMap = new HashMap();
        hashMap.put("version_id", Integer.valueOf(UpgradeSp.getVersionId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put("task_id", Integer.valueOf(UpgradeSp.getTaskId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put(XEParseConst.UPDATE_TYPE_TAG, Integer.valueOf(UpgradeSp.getUpdateType$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_init_first_start", hashMap);
    }

    public static final void OmegaTrack_request_start() {
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_request_start", (Map<String, Object>) null);
    }

    public static final void OmegaTrack_request_success() {
        Map hashMap = new HashMap();
        hashMap.put("version_id", Integer.valueOf(UpgradeSp.getVersionId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put("task_id", Integer.valueOf(UpgradeSp.getTaskId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put(XEParseConst.UPDATE_TYPE_TAG, Integer.valueOf(UpgradeSp.getUpdateType$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_request_need_update", hashMap);
    }

    public static final void OmegaTrack_request_fail(int i) {
        Map hashMap = new HashMap();
        hashMap.put("error_code", Integer.valueOf(i));
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_request_fail", hashMap);
    }

    public static final void OmegaTrack_alert_show() {
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_alert_sw", (Map<String, Object>) null);
    }

    public static final void OmegaTrack_alert_ck() {
        Map hashMap = new HashMap();
        hashMap.put("version_id", Integer.valueOf(UpgradeSp.getVersionId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put("task_id", Integer.valueOf(UpgradeSp.getTaskId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put(XEParseConst.UPDATE_TYPE_TAG, Integer.valueOf(UpgradeSp.getUpdateType$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_alert_update_ck", hashMap);
    }

    public static final void OmegaTrack_alert_ignoe() {
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_alert_ignore_ck", (Map<String, Object>) null);
    }

    public static final void OmegaTrack_appupdate_iau_req() {
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_iau_req", (Map<String, Object>) null);
    }

    public static final void OmegaTrack_appupdate_iau_resp(boolean z, boolean z2, int i) {
        Map hashMap = new HashMap();
        hashMap.put("success", Integer.valueOf(z ? 1 : 0));
        hashMap.put("is_update", Integer.valueOf(z2 ? 1 : 0));
        hashMap.put(ServerParam.PARAM_VERSION_CODE, Integer.valueOf(i));
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_iau_resp", hashMap);
    }

    public static final void OmegaTrack_appupdate_guide_gp_beta_sw() {
        Map hashMap = new HashMap();
        hashMap.put("version_id", Integer.valueOf(UpgradeSp.getVersionId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put("task_id", Integer.valueOf(UpgradeSp.getTaskId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put(XEParseConst.UPDATE_TYPE_TAG, Integer.valueOf(UpgradeSp.getUpdateType$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_guide_gp_beta_sw", hashMap);
    }

    public static final void OmegaTrack_appupdate_guide_gp_beta_ck() {
        Map hashMap = new HashMap();
        hashMap.put("version_id", Integer.valueOf(UpgradeSp.getVersionId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put("task_id", Integer.valueOf(UpgradeSp.getTaskId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put(XEParseConst.UPDATE_TYPE_TAG, Integer.valueOf(UpgradeSp.getUpdateType$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_guide_gp_beta_ck", hashMap);
    }

    public static final void OmegaTrack_appupdate_guide_gp_back_ck() {
        Map hashMap = new HashMap();
        hashMap.put("version_id", Integer.valueOf(UpgradeSp.getVersionId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put("task_id", Integer.valueOf(UpgradeSp.getTaskId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put(XEParseConst.UPDATE_TYPE_TAG, Integer.valueOf(UpgradeSp.getUpdateType$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_guide_gp_back_ck", hashMap);
    }

    public static final void OmegaTrack_appupdate_guide_gp_acct_ck(String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        Map hashMap = new HashMap();
        hashMap.put("version_id", Integer.valueOf(UpgradeSp.getVersionId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put("task_id", Integer.valueOf(UpgradeSp.getTaskId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put(XEParseConst.UPDATE_TYPE_TAG, Integer.valueOf(UpgradeSp.getUpdateType$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null)));
        hashMap.put("account", str);
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_guide_gp_acct_ck", hashMap);
    }

    public static final void OmegaTrack_appupdate_iau_update_sw() {
        UpgradeConfig.iConfig.OmegaTrackEvent("appupdate_iau_update_sw", (Map<String, Object>) null);
    }
}
