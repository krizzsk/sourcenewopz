package com.didi.dimina.container.bridge.permission;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.taxis99.R;
import java.util.HashMap;

public class DiminaPermissionDescDialog extends AlertDialog {
    public static final String PERMISSION_CAMERA_REJECTED_HINT = "请先授予相机权限";
    public static final String PERMISSION_CAMERA_VALUE = "用于向您提供相机相关服务";
    public static final String PERMISSION_CONTACT_REJECTED_HINT = "请先授予联系人权限";
    public static final String PERMISSION_KEYWORD_CAMERA = "相机权限使用说明";
    public static final String PERMISSION_KEYWORD_LOCATION = "位置权限使用说明";
    public static final String PERMISSION_KEYWORD_RECORD = "录音权限使用说明";
    public static final String PERMISSION_KEYWORD_STORAGE = "存储权限使用说明";
    public static final String PERMISSION_LOCATION_REJECTED_HINT = "请先授予定位权限";
    public static final String PERMISSION_LOCATION_VALUE = "用于向您提供定位相关服务，当APP彻底关闭时不会收集您的位置信息";
    public static final String PERMISSION_RECORD_REJECTED_HINT = "请先授予录音权限";
    public static final String PERMISSION_RECORD_VALUE = "用于向您提供录音相关服务";
    public static final String PERMISSION_STORAGE_REJECTED_HINT = "请先授予存储权限";
    public static final String PERMISSION_STORAGE_VALUE = "用于向您提供存储相关服务";

    /* renamed from: a */
    private static final HashMap<String, String> f16750a = new HashMap<>();

    /* renamed from: b */
    private final PermissionDescInfo f16751b;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.dimina.container.bridge.permission.PermissionDescInfo createStorageDescInfo(com.didi.dimina.container.DMMina r2) {
        /*
            if (r2 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r0 = r0.getUIConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r0 = r0.getUIConfig()
            com.didi.dimina.container.bridge.permission.DMPermissionDescConfig r0 = r0.getPermissionDescConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r2 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r2 = r2.getUIConfig()
            com.didi.dimina.container.bridge.permission.DMPermissionDescConfig r2 = r2.getPermissionDescConfig()
            r0 = 2
            java.lang.String r2 = r2.requirePermissionDescription(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            java.lang.String r2 = "用于向您提供存储相关服务"
        L_0x003a:
            com.didi.dimina.container.bridge.permission.PermissionDescInfo r0 = new com.didi.dimina.container.bridge.permission.PermissionDescInfo
            java.lang.String r1 = "存储权限使用说明"
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog.createStorageDescInfo(com.didi.dimina.container.DMMina):com.didi.dimina.container.bridge.permission.PermissionDescInfo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.dimina.container.bridge.permission.PermissionDescInfo createLocationDescInfo(com.didi.dimina.container.DMMina r2) {
        /*
            if (r2 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r0 = r0.getUIConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r0 = r0.getUIConfig()
            com.didi.dimina.container.bridge.permission.DMPermissionDescConfig r0 = r0.getPermissionDescConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r2 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r2 = r2.getUIConfig()
            com.didi.dimina.container.bridge.permission.DMPermissionDescConfig r2 = r2.getPermissionDescConfig()
            r0 = 3
            java.lang.String r2 = r2.requirePermissionDescription(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            java.lang.String r2 = "用于向您提供定位相关服务，当APP彻底关闭时不会收集您的位置信息"
        L_0x003a:
            com.didi.dimina.container.bridge.permission.PermissionDescInfo r0 = new com.didi.dimina.container.bridge.permission.PermissionDescInfo
            java.lang.String r1 = "位置权限使用说明"
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog.createLocationDescInfo(com.didi.dimina.container.DMMina):com.didi.dimina.container.bridge.permission.PermissionDescInfo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.dimina.container.bridge.permission.PermissionDescInfo createCameraDescInfo(com.didi.dimina.container.DMMina r2) {
        /*
            if (r2 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r0 = r0.getUIConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r0 = r0.getUIConfig()
            com.didi.dimina.container.bridge.permission.DMPermissionDescConfig r0 = r0.getPermissionDescConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r2 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r2 = r2.getUIConfig()
            com.didi.dimina.container.bridge.permission.DMPermissionDescConfig r2 = r2.getPermissionDescConfig()
            r0 = 1
            java.lang.String r2 = r2.requirePermissionDescription(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            java.lang.String r2 = "用于向您提供相机相关服务"
        L_0x003a:
            com.didi.dimina.container.bridge.permission.PermissionDescInfo r0 = new com.didi.dimina.container.bridge.permission.PermissionDescInfo
            java.lang.String r1 = "相机权限使用说明"
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog.createCameraDescInfo(com.didi.dimina.container.DMMina):com.didi.dimina.container.bridge.permission.PermissionDescInfo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.dimina.container.bridge.permission.PermissionDescInfo createRecordDescInfo(com.didi.dimina.container.DMMina r2) {
        /*
            if (r2 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r0 = r0.getUIConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r0 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r0 = r0.getUIConfig()
            com.didi.dimina.container.bridge.permission.DMPermissionDescConfig r0 = r0.getPermissionDescConfig()
            if (r0 == 0) goto L_0x0038
            com.didi.dimina.container.DMConfig r2 = r2.getConfig()
            com.didi.dimina.container.DMConfig$UIConfig r2 = r2.getUIConfig()
            com.didi.dimina.container.bridge.permission.DMPermissionDescConfig r2 = r2.getPermissionDescConfig()
            r0 = 4
            java.lang.String r2 = r2.requirePermissionDescription(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            java.lang.String r2 = "用于向您提供录音相关服务"
        L_0x003a:
            com.didi.dimina.container.bridge.permission.PermissionDescInfo r0 = new com.didi.dimina.container.bridge.permission.PermissionDescInfo
            java.lang.String r1 = "录音权限使用说明"
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog.createRecordDescInfo(com.didi.dimina.container.DMMina):com.didi.dimina.container.bridge.permission.PermissionDescInfo");
    }

    public DiminaPermissionDescDialog(Context context, PermissionDescInfo permissionDescInfo) {
        super(context, R.style.DiminaPermissionDescDialog);
        this.f16751b = permissionDescInfo;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutInflater().inflate(R.layout.dimina_container_dialog_permission_desc, (ViewGroup) null));
        TextView textView = (TextView) findViewById(R.id.permission_desc_title);
        PermissionDescInfo permissionDescInfo = this.f16751b;
        if (permissionDescInfo != null && !TextUtils.isEmpty(permissionDescInfo.getTitle())) {
            textView.setText(this.f16751b.getTitle());
        }
        TextView textView2 = (TextView) findViewById(R.id.permission_desc_content);
        PermissionDescInfo permissionDescInfo2 = this.f16751b;
        if (permissionDescInfo2 != null && !TextUtils.isEmpty(permissionDescInfo2.getContent())) {
            textView2.setText(this.f16751b.getContent());
        }
        m12438a();
    }

    /* renamed from: a */
    private void m12438a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.gravity = 48;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    public void show() {
        try {
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
