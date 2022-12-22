package com.didi.sdk.sidebar.templet;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.IComponent;
import com.didi.sdk.app.IStatusBar;
import com.didi.sdk.events.SettingsLoadingEvent;
import com.didi.sdk.monitor.SaQualityCheckTrack;
import com.didi.sdk.sidebar.BottomFragmentViewAssembler;
import com.didi.sdk.sidebar.PageAssembler;
import com.didi.sdk.sidebar.PageDecorator;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.ViewAssembler;
import com.didi.sdk.sidebar.data.DataContainer;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.view.GlobalTitleBar;
import com.taxis99.R;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BottomTitleFragment extends BaseSidebarFragment implements IComponent, IStatusBar {

    /* renamed from: a */
    private BaseBusinessContext f37451a;

    /* renamed from: b */
    private GlobalTitleBar f37452b;

    /* renamed from: c */
    private ViewAssembler f37453c;
    protected SidebarPage sidebarPage;

    public boolean showStatusBar() {
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f_sidebar_list_container, (ViewGroup) null);
        DataContainer instance = DataContainer.getInstance();
        Bundle arguments = getArguments();
        String string = arguments.getString("page");
        String string2 = arguments.getString("level");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            if (SaApolloUtil.INSTANCE.getSaUserTabShow()) {
                if (string.equals("account")) {
                    this.sidebarPage = DataContainer.getInstance().getAccountData();
                } else {
                    this.sidebarPage = DataContainer.getInstance().getSettingData();
                }
                if (this.sidebarPage == null) {
                    this.sidebarPage = instance.getPageData(string2, string);
                    SaQualityCheckTrack.trackError(SaQualityCheckTrack.TagType.sa_mine, 4, new HashMap());
                }
            } else {
                this.sidebarPage = instance.getPageData(string2, string);
            }
            this.f37452b = (GlobalTitleBar) inflate.findViewById(R.id.title_bar);
            new PageAssembler(this.f37453c).assemble(this.sidebarPage, new PageDecorator.PageDecoratorBuilder((ViewGroup) inflate.findViewById(R.id.container)).setGlobalTitleView(this.f37452b).build(), this.f37451a);
        }
        inflate.setFocusableInTouchMode(true);
        inflate.requestFocus();
        inflate.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                BottomTitleFragment.this.onBack();
                return false;
            }
        });
        EventBus.getDefault().register(this);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoadingRequested(SettingsLoadingEvent settingsLoadingEvent) {
        if (settingsLoadingEvent != null) {
            if (!settingsLoadingEvent.visible) {
                hideLoading();
            } else if (settingsLoadingEvent.withMask) {
                showMaskLayerLoading();
            } else {
                showLoading();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onBack() {
        EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.OPEN_SIDEBAR));
    }

    /* access modifiers changed from: protected */
    public ViewAssembler createViewAssembler() {
        if (this.f37453c == null) {
            this.f37453c = new BottomFragmentViewAssembler();
        }
        return this.f37453c;
    }

    public BaseBusinessContext getBusinessContext() {
        return this.f37451a;
    }

    public void setBusinessContext(BaseBusinessContext baseBusinessContext) {
        this.f37451a = baseBusinessContext;
    }

    public View getFallbackView() {
        return this.f37452b.getContentView();
    }
}
