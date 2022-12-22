package com.didi.component.common.router;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.common.util.DateConverUtils;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.travel.psnger.model.response.estimate.CarPayGroupInfoModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.URLDecoder;
import java.util.List;

public class EntregaToPaywayListHandler implements IRouterHandler {

    /* renamed from: a */
    private static final int f11708a = 3;

    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        if (uri != null) {
            try {
                String queryParameter = uri.getQueryParameter("user_pay_group_string");
                String queryParameter2 = uri.getQueryParameter("user_pay_info_string");
                m7934a(uri, URLDecoder.decode(queryParameter2, "utf-8"), URLDecoder.decode(queryParameter, "utf-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m7934a(Uri uri, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
                payMethodListParam.list = DateConverUtils.convertCarPayInfoToPayMethodList(str);
                payMethodListParam.groupList = DateConverUtils.convertPayGroupInfoList((List) new Gson().fromJson(str2, new TypeToken<List<CarPayGroupInfoModel>>() {
                }.getType()));
                payMethodListParam.resourceId = "110";
                DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity(m7933a(), 3, payMethodListParam);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private Fragment m7933a() {
        Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
        if (!(currentActivity instanceof FragmentActivity)) {
            return null;
        }
        List<Fragment> fragments = ((FragmentActivity) currentActivity).getSupportFragmentManager().getFragments();
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment.isVisible() && fragment.getUserVisibleHint()) {
                return fragment;
            }
        }
        return null;
    }
}
