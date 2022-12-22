package com.microblink.blinkbarcode.fragment.overlay.components;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;
import com.microblink.blinkbarcode.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.blinkbarcode.hardware.camera.CameraResolutionTooSmallException;
import com.microblink.blinkbarcode.library.R;
import com.microblink.blinkbarcode.licence.exception.LicenceLockedException;
import com.microblink.blinkbarcode.licence.exception.RemoteLicenceCheckException;
import com.microblink.blinkbarcode.recognition.FeatureNotSupportedException;
import com.microblink.blinkbarcode.recognition.RecognizerError;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.NotSupportedReason;

/* compiled from: line */
public class ErrorDialogFactory {

    /* renamed from: com.microblink.blinkbarcode.fragment.overlay.components.ErrorDialogFactory$2 */
    /* compiled from: line */
    public static /* synthetic */ class C182372 {
        public static final /* synthetic */ int[] llIIlIlIIl;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|5|6|7|8|9|10|11|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0020 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0017 */
        static {
            /*
                com.microblink.blinkbarcode.view.NotSupportedReason.values()
                r0 = 6
                int[] r1 = new int[r0]
                llIIlIlIIl = r1
                r2 = 1
                r3 = 4
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000c }
            L_0x000c:
                r1 = 2
                r4 = 3
                int[] r5 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0012 }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r5 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0017 }
                r6 = 0
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r4 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x001b }
                r4[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001b }
            L_0x001b:
                r1 = 5
                int[] r3 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0020 }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0020 }
            L_0x0020:
                int[] r2 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.fragment.overlay.components.ErrorDialogFactory.C182372.<clinit>():void");
        }
    }

    private AlertDialog llIIlIlIIl(Activity activity, final Runnable runnable, String str, String str2) {
        return new AlertDialog.Builder(activity).setTitle(str).setMessage(str2).setNeutralButton(activity.getString(R.string.mb_dismiss_error_dialog), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface dialogInterface, int i) {
                AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                runnable.run();
            }
        }).setCancelable(false).create();
    }

    public AlertDialog createErrorDialog(Activity activity, Throwable th, Runnable runnable) {
        String string = activity.getString(R.string.mb_warning_title);
        if (th instanceof CameraResolutionTooSmallException) {
            Log.m40230e(this, th, "Camera resolution too low!", new Object[0]);
            return llIIlIlIIl(activity, runnable, string, activity.getString(R.string.mb_feature_unsupported_device));
        } else if (th instanceof RecognizerError) {
            Log.m40230e(this, th, "There was an error starting a native recognizer. Reason: {}", th.getMessage());
            return llIIlIlIIl(activity, runnable, string, activity.getString(R.string.mb_error_initializing));
        } else if (th instanceof UnsatisfiedLinkError) {
            Log.m40230e(this, th, "Native library not loaded!", new Object[0]);
            return llIIlIlIIl(activity, runnable, string, activity.getString(R.string.mb_error_initializing));
        } else if (th instanceof AutoFocusRequiredButNotSupportedException) {
            Log.m40230e(this, th, "Autofocus required, but not supported!", new Object[0]);
            return llIIlIlIIl(activity, runnable, string, activity.getString(R.string.mb_feature_unsupported_autofocus));
        } else if (th instanceof FeatureNotSupportedException) {
            return llIIlIlIIl(activity, runnable, string, llIIlIlIIl(activity, ((FeatureNotSupportedException) th).getReason()));
        } else {
            if (th instanceof SecurityException) {
                Log.m40230e(this, th, "Camera permission not given!", new Object[0]);
                return llIIlIlIIl(activity, runnable, string, activity.getString(R.string.mb_camera_not_allowed));
            } else if (th instanceof LicenceLockedException) {
                return llIIlIlIIl(activity, runnable, "", activity.getString(R.string.mb_licence_locked));
            } else {
                if (th instanceof RemoteLicenceCheckException) {
                    return llIIlIlIIl(activity, runnable, "", activity.getString(R.string.mb_licence_check_failed));
                }
                return llIIlIlIIl(activity, runnable, string, activity.getString(R.string.mb_camera_not_ready));
            }
        }
    }

    private String llIIlIlIIl(Context context, NotSupportedReason notSupportedReason) {
        int ordinal = notSupportedReason.ordinal();
        if (ordinal == 0) {
            return context.getString(R.string.mb_feature_unsupported_android_version);
        }
        if (!(ordinal == 1 || ordinal == 2)) {
            if (ordinal == 3) {
                return context.getString(R.string.mb_invalid_license);
            }
            if (ordinal == 4) {
                return context.getString(R.string.mb_custom_ui_forbidden);
            }
            if (ordinal != 5) {
                return null;
            }
        }
        return context.getString(R.string.mb_feature_unsupported_device);
    }
}
