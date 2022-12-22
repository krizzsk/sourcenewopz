package com.didi.entrega.customer.flutter.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.LocalPermissionHelper;
import com.didi.entrega.uni_entrega_business.privacy.GLEUniPrivcyService;
import com.didichuxing.sofa.permission.PermissionHelper;
import com.yanzhenjie.permission.runtime.Permission;

public class PrivacyServiceImp implements GLEUniPrivcyService {

    enum PrivacyType {
        local,
        gps,
        camera,
        photoAlbum,
        notification,
        microphone,
        phoneState,
        overLay,
        contact
    }

    public void isLocalPrivacyEnable(GLEUniPrivcyService.Result<Boolean> result) {
        result.success(Boolean.valueOf(m14732a(new String[]{Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_COARSE_LOCATION})));
    }

    public void isGpsPrivacyEnabled(GLEUniPrivcyService.Result<Boolean> result) {
        result.success(Boolean.valueOf(CustomerSystemUtil.isGpsEnabled(GlobalContext.getContext())));
    }

    public void setPrivacy(long j, long j2, GLEUniPrivcyService.Result<Boolean> result) {
        if (j2 == ((long) PrivacyType.overLay.ordinal())) {
            Context context = GlobalContext.getContext();
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        } else if (j2 == ((long) PrivacyType.gps.ordinal())) {
            CustomerSystemUtil.openLocationSettingActivity((Activity) GlobalContext.getContext());
        } else {
            LocalPermissionHelper.openPermissionSetting((Activity) GlobalContext.getContext());
        }
    }

    /* renamed from: a */
    private boolean m14732a(String[] strArr) {
        Activity activity = (Activity) GlobalContext.getContext();
        if (activity == null || !PermissionHelper.isPermissionsGranted(activity, strArr)) {
            return false;
        }
        return true;
    }
}
