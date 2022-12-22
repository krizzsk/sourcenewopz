package com.didiglobal.privacy.disclosure;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;

public abstract class PrivacyDisclosureBaseManager {

    /* renamed from: a */
    private static final String f50488a = "PrivacyDisclosure";
    protected static BasePrivacyDisclosureInitParam initParam;

    /* access modifiers changed from: protected */
    public abstract PrivacyDisclosureBaseDialog createDialog();

    /* access modifiers changed from: protected */
    public abstract int getMostDisclosureTimes(Context context);

    /* access modifiers changed from: protected */
    public abstract boolean isEnabledByApollo(Context context, IPrivacyType iPrivacyType);

    public static void init(BasePrivacyDisclosureInitParam basePrivacyDisclosureInitParam) {
        initParam = basePrivacyDisclosureInitParam;
    }

    public static BasePrivacyDisclosureInitParam getInitParam() {
        return initParam;
    }

    public boolean isNeedOpenPrivacyDisclosureDialog(FragmentActivity fragmentActivity, IPrivacyType iPrivacyType) {
        return isNeedOpenPrivacyDisclosureDialog(fragmentActivity, iPrivacyType, iPrivacyType != null ? iPrivacyType.getPermissions() : new String[0]);
    }

    public boolean isNeedOpenPrivacyDisclosureDialog(FragmentActivity fragmentActivity, IPrivacyType iPrivacyType, String[] strArr) {
        return m36310a(fragmentActivity, iPrivacyType, strArr) == null;
    }

    public void openPrivacyDisclosureDialog(FragmentActivity fragmentActivity, IPrivacyType iPrivacyType, PrivacyDisclosureBaseDialog.Callback callback) {
        openPrivacyDisclosureDialog(fragmentActivity, iPrivacyType, iPrivacyType != null ? iPrivacyType.getPermissions() : new String[0], callback);
    }

    public void openPrivacyDisclosureDialog(FragmentActivity fragmentActivity, IPrivacyType iPrivacyType, String[] strArr, PrivacyDisclosureBaseDialog.Callback callback) {
        if (callback == null) {
            Log.e(f50488a, "openPrivacyDisclosureDialog failed: callback is null.");
            return;
        }
        PositiveResultReason a = m36309a(fragmentActivity, iPrivacyType);
        if (a != null) {
            callback.onPositiveResult(a);
            Log.d(f50488a, "no need openPrivacyDisclosureDialog : " + a);
            return;
        }
        PrivacyDisclosureBaseDialog.Builder builder = new PrivacyDisclosureBaseDialog.Builder();
        builder.setPrivacyType(iPrivacyType).setCallback(callback).setPositiveBtnResInt(initParam.getPositiveBtnResInt()).setNegativeBtnResInt(initParam.getNegativeBtnResInt()).setPositiveBtnTextColor(initParam.getPositionBtnTextColor()).setNegativeBtnTextColor(initParam.getNegativeBtnTextColor()).setUploadParam(m36311a((Context) fragmentActivity, iPrivacyType, strArr));
        createDialog().show(fragmentActivity.getSupportFragmentManager(), "", builder);
        DisclosureSpUtils.m36301c(fragmentActivity, iPrivacyType);
        Log.d(f50488a, "openPrivacyDisclosureDialog: show dialog.");
    }

    /* renamed from: a */
    private PositiveResultReason m36309a(FragmentActivity fragmentActivity, IPrivacyType iPrivacyType) {
        return m36310a(fragmentActivity, iPrivacyType, iPrivacyType != null ? iPrivacyType.getPermissions() : new String[0]);
    }

    /* renamed from: a */
    private PositiveResultReason m36310a(FragmentActivity fragmentActivity, IPrivacyType iPrivacyType, String[] strArr) {
        if (initParam == null) {
            Log.e(f50488a, "PositiveResultReason error : ERROR_NO_INIT_PARAM");
            return PositiveResultReason.ERROR_NO_INIT_PARAM;
        } else if (TextUtils.isEmpty(iPrivacyType.getDialogDesc())) {
            Log.e(f50488a, "PositiveResultReason error : ERROR_DESC_TXT_EMPTY");
            return PositiveResultReason.ERROR_DESC_TXT_EMPTY;
        } else if (!isEnabledByApollo(fragmentActivity, iPrivacyType)) {
            return PositiveResultReason.DISABLED_DISCLOSURE_BY_APOLLO;
        } else {
            if (m36312a((Context) fragmentActivity, iPrivacyType) && m36313a((Context) fragmentActivity, strArr)) {
                return PositiveResultReason.ALREADY_AGREED;
            }
            if (m36314b(fragmentActivity, iPrivacyType)) {
                return PositiveResultReason.ALREADY_DISCLOSURE_ENOUGH_TIMES;
            }
            return null;
        }
    }

    /* renamed from: a */
    private boolean m36312a(Context context, IPrivacyType iPrivacyType) {
        return DisclosureSpUtils.m36294a(context, iPrivacyType);
    }

    /* renamed from: a */
    private boolean m36313a(Context context, String[] strArr) {
        if (!(Build.VERSION.SDK_INT < 23 || strArr == null || strArr.length == 0)) {
            for (String checkSelfPermission : strArr) {
                if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    private boolean m36314b(Context context, IPrivacyType iPrivacyType) {
        int mostDisclosureTimes = getMostDisclosureTimes(context);
        if (mostDisclosureTimes >= 0 && DisclosureSpUtils.m36295b(context, iPrivacyType) >= mostDisclosureTimes) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private UploadParam m36311a(Context context, IPrivacyType iPrivacyType, String[] strArr) {
        UploadParam uploadParam = new UploadParam();
        uploadParam.setPopTime(System.currentTimeMillis() / 1000).setAppId(getInitParam().getAppId()).setPermissionType(iPrivacyType.getTypeId()).setCurrentPermissionStatus(m36313a(context, strArr) ? 1 : 2).setPopContent(iPrivacyType.getDialogDesc());
        return uploadParam;
    }
}
