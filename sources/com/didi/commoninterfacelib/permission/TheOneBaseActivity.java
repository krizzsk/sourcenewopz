package com.didi.commoninterfacelib.permission;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

public class TheOneBaseActivity extends FragmentActivity implements PermissionContext {
    public Context getContextByPermissionContext() {
        return this;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

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

    public void requestPermissionsByPermissionContext(String[] strArr, int i) {
        ActivityCompat.requestPermissions(this, strArr, i);
    }
}
