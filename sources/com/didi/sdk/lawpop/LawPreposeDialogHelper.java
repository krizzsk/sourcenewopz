package com.didi.sdk.lawpop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.GlobalCountryCode;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.sdk.webview.WebViewModel;
import com.didiglobal.privacysdk.law.lawurl.LawUrlBuilder;
import com.didiglobal.privacysdk.law.prepose.LawPreposeDialogManager;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class LawPreposeDialogHelper {
    public static boolean isNeedShowPreposeDialog(Context context, String str) {
        boolean z = GlobalCountryCode.ENGLAND.equals(str) && !hasAgreeFor(context, str);
        boolean z2 = AppUtils.isBrazilApp(context) && !hasAgreeForApp(context);
        if (z || z2) {
            return true;
        }
        return false;
    }

    public static void showPreposeDialog(FragmentActivity fragmentActivity, String str, String str2, AlertDialogFragment.OnClickListener onClickListener, AlertDialogFragment.OnClickListener onClickListener2) {
        LawPreposeDialogManager.showPreposeDialog(fragmentActivity, str, str2, onClickListener, onClickListener2, new SimpleWebActivityLinkListener(fragmentActivity, new LawUrlBuilder().setAppId(String.valueOf(AppUtils.getAppId(fragmentActivity))).setPhoneCountry(str).setLang(str2).buildForPreposeDialog()));
    }

    public static boolean isNeedShowLocationChangedLawDialog(Context context, String str) {
        if (LawPreposeDialogManager.isLocationChangedDialogShowingForSameCountry(str)) {
            return false;
        }
        boolean hasAgreeFor = hasAgreeFor(context, str);
        if (!GlobalCountryCode.ENGLAND.equals(str) || hasAgreeFor) {
            return false;
        }
        return true;
    }

    public static void showLocationChangeLawDialog(FragmentActivity fragmentActivity, String str, AlertDialogFragment.OnClickListener onClickListener, AlertDialogFragment.OnClickListener onClickListener2) {
        String build = new LawUrlBuilder().build();
        LawPreposeReplaceParams lawPreposeReplaceParams = new LawPreposeReplaceParams();
        lawPreposeReplaceParams.replaceParamMap.put("location_country", str);
        LawPreposeDialogManager.showLocationChangeLawDialog(fragmentActivity, str, onClickListener, onClickListener2, new TipLinkListener(fragmentActivity, build, "", lawPreposeReplaceParams));
    }

    public static String getCountryIsoCodeFromDevice() {
        return AppUtils.getCountryCodeISO3166();
    }

    public static String getCountryIsoCodeFromLocation() {
        CountryInfo countryInfo = ConfProxy.getInstance().getCountryInfo();
        return countryInfo != null ? countryInfo.getCountryIsoCode() : "";
    }

    public static boolean hasAgreeFor(Context context, String str) {
        return LawPreposeDialogManager.hasAgreeFor(context, str);
    }

    public static boolean hasAgreeForApp(Context context) {
        return LawPreposeDialogManager.hasAgreeForApp(context);
    }

    public static long getAgreeTimeForApp(Context context) {
        return LawPreposeDialogManager.getAgreeTimeForApp(context);
    }

    static class TipLinkListener implements View.OnClickListener {
        private String linkStr;
        private WeakReference<Activity> mActivity;
        private LawPreposeReplaceParams replaceParams;
        private String url;

        public TipLinkListener(Activity activity, String str, String str2, LawPreposeReplaceParams lawPreposeReplaceParams) {
            this.mActivity = new WeakReference<>(activity);
            this.url = str;
            this.linkStr = str2;
            this.replaceParams = lawPreposeReplaceParams;
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            Activity activity = (Activity) this.mActivity.get();
            if (activity != null) {
                WebViewModel webViewModel = new WebViewModel();
                webViewModel.url = this.url;
                webViewModel.title = this.linkStr;
                Intent intent = new Intent(activity, LawPreposeWebActivity.class);
                intent.putExtra("web_view_model", webViewModel);
                intent.putExtra(LawPreposeWebActivity.INTENT_REPLACE_PARAMS, this.replaceParams);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.right_slide_in, 0);
            }
        }
    }

    static class SimpleWebActivityLinkListener implements View.OnClickListener {
        private WeakReference<Activity> mActivity;
        private String url;

        public SimpleWebActivityLinkListener(Activity activity, String str) {
            this.mActivity = new WeakReference<>(activity);
            this.url = str;
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            Activity activity = (Activity) this.mActivity.get();
            if (activity != null) {
                Intent intent = new Intent(activity, SimpleWebActivity.class);
                intent.putExtra(SimpleWebActivity.INTENT_URL, this.url);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.right_slide_in, 0);
            }
        }
    }
}
