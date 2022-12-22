package com.didi.sdk.app.prehot;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.webview.WebViewModel;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import org.json.JSONException;
import org.json.JSONObject;

public class PreHotStore {
    public static boolean shouldPreHotFullScreen(String str) {
        CarGrop groupByType = ConfProxy.getInstance().getGroupByType(str);
        if (groupByType != null) {
            return groupByType.getOpenStatus() == 0 || groupByType.getOpenStatus() == 1;
        }
        return false;
    }

    public static PreHotWebFragment buildWebFragment(String str, String str2) {
        CarGrop groupByType = ConfProxy.getInstance().getGroupByType(str);
        String h5link = (groupByType.getWarmupActivity() == null || groupByType.getOpenStatus() != 0) ? null : groupByType.getWarmupActivity().getH5link();
        if (TextUtils.isEmpty(h5link)) {
            SystemUtils.log(3, "PreHotWebFragment", "服务端返回link为空", (Throwable) null, "com.didi.sdk.app.prehot.PreHotStore", 41);
            h5link = getPrehotH5Link(str);
        }
        if (!TextUtils.isEmpty(h5link)) {
            return buildWebFragmentByUrl(h5link, str2);
        }
        SystemUtils.log(3, "PreHotWebFragment", "阿波罗读取link为空", (Throwable) null, "com.didi.sdk.app.prehot.PreHotStore", 45);
        return null;
    }

    /* renamed from: a */
    private static String m24947a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri parse = Uri.parse(str2);
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        if (parse.getQueryParameterNames().size() == 0) {
            return str;
        }
        for (String next : parse.getQueryParameterNames()) {
            if (!next.equals("groupType")) {
                buildUpon.appendQueryParameter(next, parse.getQueryParameter(next));
            }
        }
        return buildUpon.build().toString();
    }

    public static String getPrehotH5Link(String str) {
        IToggle toggle = Apollo.getToggle("prehot_config");
        if (!toggle.allow()) {
            return null;
        }
        try {
            return new JSONObject((String) toggle.getExperiment().getParam(GPageIdConstant.G_PAGE_ID_CONF, "")).optString(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PreHotWebFragment buildWebFragmentByUrl(String str, String str2) {
        WebViewModel webViewModel = new WebViewModel();
        String a = m24947a(str, str2);
        if (a != null && !a.contains("product_id=")) {
            StringBuilder sb = new StringBuilder(a);
            if (!a.contains("?")) {
                sb.append("?");
            } else if (!a.endsWith(ParamKeys.SIGN_AND)) {
                sb.append(ParamKeys.SIGN_AND);
            }
            sb.append("product_id=");
            sb.append(ConfProxy.getInstance().getSelectedGroupId());
            a = sb.toString();
        }
        webViewModel.url = a;
        webViewModel.isAddCommonParam = true;
        PreHotWebFragment preHotWebFragment = new PreHotWebFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("web_view_model", webViewModel);
        preHotWebFragment.setArguments(bundle);
        return preHotWebFragment;
    }
}
