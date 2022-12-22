package com.didi.sdk.sidebar.templet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.UrlUtils;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public class AutoLinker {

    /* renamed from: c */
    private static final AutoLinker f37446c = new AutoLinker();

    /* renamed from: d */
    private static final int f37447d = 35;

    /* renamed from: a */
    Map<String, Class<? extends Fragment>> f37448a = new HashMap();

    /* renamed from: b */
    Map<String, String> f37449b = new HashMap();

    public static AutoLinker getLinker() {
        return f37446c;
    }

    private AutoLinker() {
    }

    public void registerFragment(String str, Class<? extends Fragment> cls) {
        this.f37448a.put(str, cls);
    }

    /* renamed from: a */
    private Fragment m26611a(String str) {
        Class cls = this.f37448a.get(str);
        if (cls != null) {
            try {
                return (Fragment) cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public boolean linkToTarget(SidebarItem sidebarItem, BaseBusinessContext baseBusinessContext, String str) {
        String url = sidebarItem.getUrl();
        String subPage = sidebarItem.getSubPage();
        if (url == null || (!url.startsWith("http:") && !url.startsWith("https:"))) {
            Fragment a = m26611a(url);
            if (a != null) {
                Intent intent = new Intent(baseBusinessContext.getContext(), a.getClass());
                Bundle bundle = new Bundle();
                bundle.putSerializable("page", subPage);
                bundle.putCharSequence("level", str);
                intent.putExtras(bundle);
                baseBusinessContext.getNavigation().transition(baseBusinessContext, intent, new INavigation.TransactionAnimation(R.anim.slide_in, 0, 0, R.anim.slide_out));
                EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.CLOSE_SIDEBAR));
            } else {
                String str2 = this.f37449b.get(url);
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                Intent intent2 = new Intent(str2);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("page", subPage);
                intent2.putExtras(bundle2);
                Context context = baseBusinessContext.getContext();
                context.startActivity(intent2);
                if (context instanceof Activity) {
                    ((Activity) context).overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                }
            }
        } else {
            Intent intent3 = new Intent(baseBusinessContext.getContext(), BaseWebActivity.class);
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.url = UrlUtils.addParam(UrlUtils.addParam(url, "biz_value", ConfProxy.getInstance().getSelectedType()), "phone_country", AppUtils.getCountryCodeISO3166());
            webViewModel.title = sidebarItem.getName();
            webViewModel.canChangeWebViewTitle = true;
            intent3.putExtra("web_view_model", webViewModel);
            baseBusinessContext.getContext().startActivity(intent3);
            if (sidebarItem.getId() == 35) {
                OmegaSDKAdapter.trackEvent("gp_setting_legal_ck");
            }
        }
        return true;
    }
}
