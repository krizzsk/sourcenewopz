package com.didichuxing.diface.biz.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.biz.preguide.DFPreGuideAct;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashMap;

public class PermissionActivity extends DiFaceBaseActivity {

    /* renamed from: a */
    private static final int f47471a = 1;

    /* renamed from: b */
    private static final String f47472b = "face_param";

    /* renamed from: c */
    private DiFaceParam f47473c;

    public static void start(Context context, DiFaceParam diFaceParam) {
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra(f47472b, diFaceParam);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        DiFaceFacade.getInstance().report("5");
        this.f47473c = (DiFaceParam) getIntent().getSerializableExtra(f47472b);
        ActivityCompat.requestPermissions(this, DiFaceFacade.PERMISSIONS_FACE, 1);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        LogUtils.m33563d("permissons===" + Arrays.toString(strArr));
        LogUtils.m33563d("grantResults===" + Arrays.toString(iArr));
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (iArr[i2] != 0) {
                    sb.append(strArr[i2]);
                    sb.append(" not granted,");
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                LogUtils.m33563d(sb2);
                HashMap hashMap = new HashMap();
                hashMap.put("permissionsDenied", sb2);
                DiFaceFacade.getInstance().report("4", (HashMap<String, Object>) null, (HashMap<String, Object>) hashMap);
                new AlertDialogFragment.Builder(this).setTitle(getResources().getText(R.string.df_dialog_camera_permission_title)).setMessage(getResources().getText(R.string.df_dialog_camera_permission_content)).setIcon((int) R.drawable.df_dialog_camera_permissio_icon).setPositiveButton(getResources().getText(R.string.df_dialog_camera_permission_setting), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                    public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                        alertDialogFragment.dismiss();
                        PermissionActivity.this.m33984a();
                        DiFaceFacade.getInstance().notifyCallback(new DiFaceResult(110));
                        PermissionActivity.this.finish();
                    }
                }).setPositiveButtonDefault().setCancelable(false).setNegativeButton(getResources().getText(R.string.df_dialog_camera_permission_cancel), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                    public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                        alertDialogFragment.dismiss();
                        DiFaceFacade.getInstance().notifyCallback(new DiFaceResult(110));
                        PermissionActivity.this.finish();
                    }
                }).create().show(getSupportFragmentManager(), "");
                return;
            }
            DFPreGuideAct.start(this, this.f47473c);
            finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33984a() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setFlags(268435456);
            intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent("android.settings.SETTINGS");
                intent2.setFlags(268435456);
                if (intent2.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
