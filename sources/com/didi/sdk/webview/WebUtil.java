package com.didi.sdk.webview;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.app.ActivityLifecycleManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/sdk/webview/WebUtil;", "", "()V", "getCurrentFragment", "Landroidx/fragment/app/Fragment;", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WebUtil.kt */
public final class WebUtil {
    public static final WebUtil INSTANCE = new WebUtil();

    private WebUtil() {
    }

    public final Fragment getCurrentFragment() {
        Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
        if (!(currentActivity instanceof FragmentActivity)) {
            return null;
        }
        FragmentManager supportFragmentManager = ((FragmentActivity) currentActivity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "currentActivity.supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragmentManager.fragments");
        int size = fragments.size() - 1;
        if (size < 0) {
            return null;
        }
        while (true) {
            int i = size - 1;
            Fragment fragment = fragments.get(size);
            if (fragment.isVisible() && fragment.getUserVisibleHint()) {
                return fragment;
            }
            if (i < 0) {
                return null;
            }
            size = i;
        }
    }
}
