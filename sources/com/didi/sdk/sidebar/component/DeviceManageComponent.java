package com.didi.sdk.sidebar.component;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.TextComponentView;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;

@ComponentType(name = "account_device_management")
public class DeviceManageComponent extends NavigationWithArrowComponent {

    /* renamed from: a */
    private static final String f37197a = "5";

    public DeviceManageComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Context context = this.businessContext.getContext();
        String token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.url = this.sidebarItem != null ? this.sidebarItem.getUrl() : "";
        webViewModel.isAddCommonParam = true;
        webViewModel.addParam("appid", String.valueOf(m26372a()));
        webViewModel.addParam("device_name", Build.DEVICE);
        webViewModel.addParam("token", token);
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("web_view_model", webViewModel);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* renamed from: a */
    private int m26372a() {
        return "5".equals(NationTypeUtil.getNationComponentData().getOriginID()) ? 60004 : 60000;
    }

    /* access modifiers changed from: protected */
    public void initData(TextComponentView textComponentView) {
        super.initData(textComponentView);
    }
}
