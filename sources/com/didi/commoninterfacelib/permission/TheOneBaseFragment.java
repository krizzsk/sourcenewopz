package com.didi.commoninterfacelib.permission;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;

public class TheOneBaseFragment extends Fragment implements PermissionContext {
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        PermissionUtil.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void startActivityByPermissionContext(Intent intent) {
        startActivity(intent);
    }

    public void startActivityForResultByPermissionContext(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public Context getContextByPermissionContext() {
        return getActivity();
    }

    public void requestPermissionsByPermissionContext(String[] strArr, int i) {
        requestPermissions(strArr, i);
    }
}
