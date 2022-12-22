package com.didichuxing.publicservice.resourcecontrol.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.activities.RControlActivity;
import com.didichuxing.publicservice.resourcecontrol.dialogfragments.BaseDialogFragment;
import com.didichuxing.publicservice.resourcecontrol.dialogfragments.DialogFragmentFactory;
import com.didichuxing.publicservice.resourcecontrol.fragments.AssetBasicFragment;
import com.didichuxing.publicservice.resourcecontrol.utils.PublicWebUtils;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.didichuxing.publicservice.webview.BrowserUtil;
import com.didichuxing.publicservice.webview.WebViewListenerHolder;
import java.lang.ref.WeakReference;

public class AssetBaseView extends RelativeLayout {
    public static final String TAG = "AssetBaseView";
    public WeakReference<Activity> activity;
    private DialogFragment dialog;
    protected DialogFragment dialogFragment;
    protected AssetBasicFragment fragment = null;
    protected ConstantUtils.ResourceId resourceId;
    private String token;
    private boolean usedInSDKFragment = false;

    public ConstantUtils.ResourceId getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(ConstantUtils.ResourceId resourceId2) {
        this.resourceId = resourceId2;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public Activity getActivity() {
        return (Activity) this.activity.get();
    }

    public void setActivity(Activity activity2) {
        this.activity = new WeakReference<>(activity2);
    }

    public void setDialogFragment(DialogFragment dialogFragment2) {
        this.dialogFragment = dialogFragment2;
    }

    public AssetBasicFragment getFragment() {
        return this.fragment;
    }

    public void setFragment(AssetBasicFragment assetBasicFragment) {
        this.fragment = assetBasicFragment;
    }

    public void setUsedInSDKFragment(boolean z) {
        this.usedInSDKFragment = z;
    }

    public AssetBaseView(Context context) {
        super(context);
    }

    public AssetBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AssetBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void openView(Context context, Bundle bundle, boolean z) {
        if (!ResourceManager.getManager().isTheOne()) {
            String string = bundle.getString(ConstantUtils.EXTRA_WEBVIEW_URL);
            String string2 = bundle.getString(ConstantUtils.EXTRA_WEBVIEW_TITLE);
            if (!TextUtils.isEmpty(string)) {
                if (WebViewListenerHolder.getListener() != null) {
                    BrowserUtil.startInternalWebActivity(getActivity(), string2, string);
                } else if (z) {
                    Intent intent = new Intent();
                    intent.setClass(context, RControlActivity.class);
                    intent.setPackage(context.getPackageName());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                } else if (bundle != null) {
                    goToFragment(bundle);
                }
            }
        } else if (bundle != null) {
            try {
                String string3 = bundle.getString(ConstantUtils.EXTRA_WEBVIEW_URL);
                if (!TextUtils.isEmpty(string3)) {
                    if (string3.startsWith("http://") || string3.startsWith("https://")) {
                        Intent webActivity = PublicWebUtils.getWebActivity(getContext(), string3);
                        webActivity.putExtra("url", string3);
                        String string4 = bundle.getString(ConstantUtils.EXTRA_WEBVIEW_TITLE);
                        if (!TextUtils.isEmpty(string4)) {
                            webActivity.putExtra("title", string4);
                        }
                        webActivity.setPackage(getActivity().getPackageName());
                        context.startActivity(webActivity);
                        return;
                    }
                    DRouter.build(string3).start(context);
                }
            } catch (RuntimeException e) {
                AppUtils.log("could not find ======== class    didi.passenger.intent.action.WebActivity");
                e.printStackTrace();
            }
        }
    }

    private void goToFragment(Bundle bundle) {
        if (this.usedInSDKFragment && this.activity != null) {
            BaseDialogFragment createDialogFragment = DialogFragmentFactory.createDialogFragment(bundle);
            Activity activity2 = (Activity) this.activity.get();
            if (createDialogFragment != null && activity2 != null && (activity2 instanceof FragmentActivity)) {
                try {
                    DialogFragmentFactory.showDialogFragment(((FragmentActivity) activity2).getSupportFragmentManager(), createDialogFragment, createDialogFragment.getClass().getSimpleName());
                } catch (Exception e) {
                    AppUtils.log("AssetBaseView " + e.toString());
                }
            }
        }
    }
}
