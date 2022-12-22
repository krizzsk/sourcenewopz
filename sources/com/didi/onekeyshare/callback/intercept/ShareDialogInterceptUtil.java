package com.didi.onekeyshare.callback.intercept;

import androidx.fragment.app.FragmentActivity;
import com.didi.onekeyshare.callback.intercept.impl.SystemShareDialogInterceptImpl;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.util.ShareConvertCompat;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class ShareDialogInterceptUtil {
    /* renamed from: a */
    private static boolean m20888a(FragmentActivity fragmentActivity, OneKeyShareInfo oneKeyShareInfo) {
        SystemUtils.log(6, "yq", "--intercept---xxx-----" + oneKeyShareInfo.type, (Throwable) null, "com.didi.onekeyshare.callback.intercept.ShareDialogInterceptUtil", 23);
        if (!IShareDialogIntercept.SYSTEM_SHARE_DIALOG.equals(oneKeyShareInfo.type)) {
            return false;
        }
        SystemShareDialogInterceptImpl systemShareDialogInterceptImpl = new SystemShareDialogInterceptImpl();
        SystemUtils.log(6, "yq", "--intercept---yyy---call system dialog--", (Throwable) null, "com.didi.onekeyshare.callback.intercept.ShareDialogInterceptUtil", 26);
        return systemShareDialogInterceptImpl.intercept(fragmentActivity, oneKeyShareInfo);
    }

    public static boolean intercept(FragmentActivity fragmentActivity, ArrayList<OneKeyShareInfo> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return m20888a(fragmentActivity, arrayList.get(0));
    }

    public static boolean intercept(FragmentActivity fragmentActivity, ShareInfo shareInfo) {
        List<OneKeyShareInfo> convert = ShareConvertCompat.convert(shareInfo);
        if (convert.size() <= 0) {
            return false;
        }
        SystemUtils.log(6, "yq", "--intercept---3-----" + convert, (Throwable) null, "com.didi.onekeyshare.callback.intercept.ShareDialogInterceptUtil", 42);
        return m20888a(fragmentActivity, convert.get(0));
    }
}
