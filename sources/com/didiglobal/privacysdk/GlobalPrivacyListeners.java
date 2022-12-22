package com.didiglobal.privacysdk;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.taxis99.R;

public class GlobalPrivacyListeners {

    public static abstract class AbstractPrivacyStrings implements IPrivacyStrings {
        public int getDiscountDescRes() {
            return 0;
        }

        public int getDiscountDialogDescRes() {
            return R.string.GDriver_update_discount_promotion_mVOg;
        }

        public int getDiscountDialogTitleRes() {
            return R.string.Global_Driver_LGPD_Translation_Requirements_notice_discount_OrCt;
        }

        public int getDiscountTitleRes() {
            return R.string.Global_Driver_LGPD_Translation_Requirements_Discount_information_gPDH;
        }
    }

    public interface BaseActivityDelegate {
        Context getAttachBaseContext(Context context, FragmentActivity fragmentActivity);
    }

    public interface GetCommonInfoListener {
        String getAccountType();

        String getAppId(Context context);

        String getAppType(Context context);

        String getToken();

        String getUserId();
    }

    public interface IAppInfo {
        IPrivacyStrings getIPrivacyStrings();

        ItemDisplayListener getItemDisplayListener();
    }

    public interface IPrivacyStrings {
        int getAlbumPermissionDisableDescRes();

        int getAlbumPermissionEnableDescRes();

        int getCameraPermissionDisableDescRes();

        int getCameraPermissionEnableDescRes();

        int getContactsPermissionDisableDescRes();

        int getContactsPermissionEnableDescRes();

        int getDiscountDescRes();

        int getDiscountDialogDescRes();

        int getDiscountDialogTitleRes();

        int getDiscountTitleRes();

        int getLocationPermissionDisableDescRes();

        int getLocationPermissionEnableDescRes();

        int getMicrophonePermissionDisableDescRes();

        int getMicrophonePermissionEnableDescRes();
    }

    public interface ItemDisplayListener {
        boolean displayDeleteAccount();

        boolean displayDiscountEmail();

        boolean displayDiscountPush();

        boolean displayDownloadData();

        boolean displayLocationShare();

        boolean displaySms();

        boolean displaySystemPermission();
    }

    public interface OnItemClickedListener {
        void onDeleteAccountItemClicked(Activity activity);
    }

    public interface WebViewListener {
        void jumpWebViewPage(Context context, String str);
    }
}
