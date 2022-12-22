package com.didi.component.service.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.didi.component.business.recovery.GlobalOrderRecovery;
import com.didi.component.business.util.UiHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class SendOrderTipDialogHelper {
    public static AlertDialogFragment showOrderFailDialog(Context context, FragmentManager fragmentManager, String str) {
        AlertDialogFragment.Builder alertDialogBuilder = UiHelper.getAlertDialogBuilder(context);
        alertDialogBuilder.setMessage(str).setIcon(-1).setPositiveButton((CharSequence) context.getString(R.string.guide_i_know));
        alertDialogBuilder.setCancelable(true);
        AlertDialogFragment create = alertDialogBuilder.create();
        if (fragmentManager != null) {
            create.show(fragmentManager, "showOrderFailDialog");
        }
        return create;
    }

    public static AlertDialogFragment showOverdraftOrderDialog(Context context, FragmentManager fragmentManager, final BusinessContext businessContext, String str, final String str2, final int i) {
        if (context == null || fragmentManager == null) {
            return null;
        }
        AlertDialogFragment.Builder alertDialogBuilder = UiHelper.getAlertDialogBuilder(context);
        alertDialogBuilder.setTitle(context.getString(R.string.car_unpay_title)).setMessage(str).setIcon(AlertController.IconType.PAY).setPositiveButtonDefault().setPositiveButton((CharSequence) context.getString(R.string.car_unpay_confirm), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                StringBuilder sb = new StringBuilder();
                sb.append("oid:");
                String str = str2;
                if (str == null) {
                    str = "overdraftOid is Null";
                }
                sb.append(str);
                SystemUtils.log(6, "OidNullCheck", sb.toString(), new Exception(), "com.didi.component.service.util.SendOrderTipDialogHelper$1", 45);
                if (!TextUtils.isEmpty(str2)) {
                    new GlobalOrderRecovery(businessContext).recovery(i, str2, 2);
                }
            }
        }).setNegativeButton((CharSequence) context.getString(R.string.cancel));
        alertDialogBuilder.setCancelable(false);
        AlertDialogFragment create = alertDialogBuilder.create();
        if (fragmentManager != null) {
            create.show(fragmentManager, "showOverdraftOrderDialog");
        }
        return create;
    }
}
