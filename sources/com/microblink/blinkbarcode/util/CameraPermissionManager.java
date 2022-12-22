package com.microblink.blinkbarcode.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.microblink.blinkbarcode.library.R;
import com.yanzhenjie.permission.runtime.Permission;

/* compiled from: line */
public class CameraPermissionManager {
    /* access modifiers changed from: private */
    public View IlIllIlIIl = null;
    private View.OnClickListener IllIIIIllI = new IlIllIlIIl();
    private boolean IllIIIllII = false;
    private View.OnClickListener llIIIlllll = new llIIlIlIIl();
    /* access modifiers changed from: private */
    public IllIIIllII llIIlIlIIl;

    /* compiled from: line */
    public class IlIllIlIIl implements View.OnClickListener {

        /* compiled from: line */
        public class llIIlIlIIl implements DialogInterface.OnClickListener {
            public final /* synthetic */ boolean llIIlIlIIl;

            public llIIlIlIIl(boolean z) {
                this.llIIlIlIIl = z;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                dialogInterface.dismiss();
                CameraPermissionManager.this.IlIllIlIIl.setVisibility(8);
                if (!this.llIIlIlIIl) {
                    Context llIIlIlIIl2 = CameraPermissionManager.this.llIIlIlIIl.llIIlIlIIl();
                    llIIlIlIIl2.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + CameraPermissionManager.this.llIIlIlIIl.llIIlIlIIl().getPackageName())));
                }
            }
        }

        public IlIllIlIIl() {
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            Context llIIlIlIIl2 = CameraPermissionManager.this.llIIlIlIIl.llIIlIlIIl();
            AlertDialog.Builder builder = new AlertDialog.Builder(llIIlIlIIl2);
            boolean llIIlIlIIl3 = CameraPermissionManager.llIIlIlIIl(CameraPermissionManager.this, llIIlIlIIl2);
            SystemUtils.showDialog(builder.setCancelable(false).setTitle(R.string.mb_warning_title).setMessage(llIIlIlIIl3 ? R.string.mb_enable_permission_help_instant_app : R.string.mb_enable_permission_help).setNeutralButton(17039370, new llIIlIlIIl(llIIlIlIIl3)).create());
        }
    }

    /* compiled from: line */
    public static final class IllIIIllII {
        private Fragment IlIllIlIIl;
        private androidx.fragment.app.Fragment IllIIIllII;
        private Context llIIIlllll;
        private Activity llIIlIlIIl;

        public IllIIIllII(Activity activity) {
            this.llIIlIlIIl = activity;
            this.llIIIlllll = activity;
        }

        public boolean IlIllIlIIl(String str) {
            Fragment fragment = this.IlIllIlIIl;
            if (fragment != null) {
                return fragment.shouldShowRequestPermissionRationale(str);
            }
            Activity activity = this.llIIlIlIIl;
            if (activity != null) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
            androidx.fragment.app.Fragment fragment2 = this.IllIIIllII;
            return fragment2 != null && fragment2.shouldShowRequestPermissionRationale(str);
        }

        public Context llIIlIlIIl() {
            return this.llIIIlllll;
        }

        public final int llIIlIlIIl(String str) {
            Fragment fragment = this.IlIllIlIIl;
            if (fragment != null) {
                return fragment.getActivity().checkSelfPermission(str);
            }
            Activity activity = this.llIIlIlIIl;
            if (activity != null) {
                return activity.checkSelfPermission(str);
            }
            androidx.fragment.app.Fragment fragment2 = this.IllIIIllII;
            if (fragment2 != null) {
                return fragment2.getActivity().checkSelfPermission(str);
            }
            return -1;
        }

        public IllIIIllII(Fragment fragment) {
            this.IlIllIlIIl = fragment;
            this.llIIIlllll = fragment.getActivity();
        }

        public IllIIIllII(androidx.fragment.app.Fragment fragment) {
            this.IllIIIllII = fragment;
            this.llIIIlllll = fragment.getContext();
        }

        public final void llIIlIlIIl(String[] strArr, int i) {
            Fragment fragment = this.IlIllIlIIl;
            if (fragment != null) {
                fragment.requestPermissions(strArr, i);
            }
            Activity activity = this.llIIlIlIIl;
            if (activity != null) {
                activity.requestPermissions(strArr, i);
            }
            androidx.fragment.app.Fragment fragment2 = this.IllIIIllII;
            if (fragment2 != null) {
                fragment2.requestPermissions(strArr, i);
            }
        }

        public SharedPreferences llIIlIlIIl(String str, int i) {
            Fragment fragment = this.IlIllIlIIl;
            if (fragment != null) {
                return SystemUtils.getSharedPreferences(fragment.getActivity(), str, i);
            }
            Activity activity = this.llIIlIlIIl;
            if (activity != null) {
                return SystemUtils.getSharedPreferences(activity, str, i);
            }
            androidx.fragment.app.Fragment fragment2 = this.IllIIIllII;
            if (fragment2 != null) {
                return SystemUtils.getSharedPreferences(fragment2.getActivity(), str, i);
            }
            return null;
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl implements View.OnClickListener {
        public llIIlIlIIl() {
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CameraPermissionManager.this.llIIlIlIIl();
        }
    }

    public CameraPermissionManager(Activity activity) {
        this.llIIlIlIIl = new IllIIIllII(activity);
        llIIlIlIIl(activity.getLayoutInflater());
    }

    public static boolean llIIlIlIIl(CameraPermissionManager cameraPermissionManager, Context context) {
        cameraPermissionManager.getClass();
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 26) {
            return applicationContext.getPackageManager().isInstantApp();
        }
        try {
            applicationContext.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void askForCameraPermission() {
        if (!hasCameraPermission()) {
            IlIllIlIIl();
            return;
        }
        View view = this.IlIllIlIIl;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public View getAskPermissionOverlay() {
        return this.IlIllIlIIl;
    }

    public boolean hasCameraPermission() {
        if (Build.VERSION.SDK_INT < 23 || this.llIIlIlIIl.llIIlIlIIl(Permission.CAMERA) == 0) {
            return true;
        }
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z;
        this.IllIIIllII = false;
        if (i == 69) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    z = false;
                    break;
                } else if (strArr[i2].equals(Permission.CAMERA)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z || iArr[i2] != 0) {
                llIIlIlIIl(true);
                this.IlIllIlIIl.setVisibility(0);
                View findViewById = this.IlIllIlIIl.findViewById(R.id.camera_ask_permission_button);
                if (this.llIIlIlIIl.IlIllIlIIl(Permission.CAMERA)) {
                    findViewById.setOnClickListener(this.llIIIlllll);
                } else {
                    findViewById.setOnClickListener(this.IllIIIIllI);
                }
            } else {
                llIIlIlIIl(false);
                this.IlIllIlIIl.setVisibility(8);
            }
        }
    }

    public void onResume() {
        if (hasCameraPermission()) {
            llIIlIlIIl(false);
        }
    }

    private void IlIllIlIIl() {
        View findViewById = this.IlIllIlIIl.findViewById(R.id.camera_ask_permission_button);
        if (this.llIIlIlIIl.IlIllIlIIl(Permission.CAMERA)) {
            this.IlIllIlIIl.setVisibility(0);
            findViewById.setOnClickListener(this.llIIIlllll);
        } else if (this.llIIlIlIIl.llIIlIlIIl("CameraPermissionManager.prefs", 0).getBoolean("DeniedPermission", false)) {
            this.IlIllIlIIl.setVisibility(0);
            findViewById.setOnClickListener(this.IllIIIIllI);
        } else {
            this.IlIllIlIIl.setVisibility(8);
            llIIlIlIIl();
        }
    }

    public CameraPermissionManager(Fragment fragment) {
        this.llIIlIlIIl = new IllIIIllII(fragment);
        llIIlIlIIl(fragment.getActivity().getLayoutInflater());
    }

    private void llIIlIlIIl(LayoutInflater layoutInflater) {
        if (Build.VERSION.SDK_INT >= 23) {
            View inflate = layoutInflater.inflate(R.layout.mb_camera_permission_overlay, (ViewGroup) null);
            this.IlIllIlIIl = inflate;
            inflate.setVisibility(8);
        }
    }

    private void llIIlIlIIl(boolean z) {
        SharedPreferences.Editor edit = this.llIIlIlIIl.llIIlIlIIl("CameraPermissionManager.prefs", 0).edit();
        edit.putBoolean("DeniedPermission", z);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void llIIlIlIIl() {
        if (!this.IllIIIllII) {
            this.llIIlIlIIl.llIIlIlIIl(new String[]{Permission.CAMERA}, 69);
            this.IllIIIllII = true;
        }
    }

    public CameraPermissionManager(androidx.fragment.app.Fragment fragment) {
        this.llIIlIlIIl = new IllIIIllII(fragment);
        llIIlIlIIl(fragment.getLayoutInflater());
    }
}
