package com.didi.sdk.sidebar.component;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.templet.AutoLinker;
import com.didi.sdk.sidebar.templet.LinkUri;
import com.didi.sdk.sidebar.templet.ManualLinker;
import com.didi.sdk.sidebar.view.ComponentView;
import com.didi.sdk.util.EventKeys;
import java.lang.reflect.Method;
import org.greenrobot.eventbus.EventBus;

public abstract class AbsComponent<T extends ComponentView> implements View.OnClickListener {
    protected BaseBusinessContext businessContext;
    protected T componentView;
    protected View realView;
    protected SidebarItem sidebarItem;
    protected String subLevel;

    /* access modifiers changed from: protected */
    public abstract T createComponentView();

    /* access modifiers changed from: protected */
    public abstract void initData(T t);

    public void notifyPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public AbsComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem2, String str) {
        this.businessContext = baseBusinessContext;
        this.sidebarItem = sidebarItem2;
        this.subLevel = str;
        T createComponentView = createComponentView();
        this.componentView = createComponentView;
        View createView = createComponentView.createView();
        this.realView = createView;
        createView.setOnClickListener(this);
        initData(this.componentView);
    }

    public View getView() {
        return this.realView;
    }

    public int getComponentId() {
        return this.sidebarItem.getId();
    }

    /* access modifiers changed from: protected */
    public T getComponentView() {
        return this.componentView;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!m26360a() && !m26361b()) {
            m26359a(this.sidebarItem, this.businessContext);
        }
    }

    public void notifyDataChange(SidebarItem sidebarItem2, String str) {
        this.subLevel = str;
        this.sidebarItem = sidebarItem2;
        initData(this.componentView);
    }

    /* renamed from: a */
    private boolean m26360a() {
        return AutoLinker.getLinker().linkToTarget(this.sidebarItem, this.businessContext, this.subLevel);
    }

    /* renamed from: b */
    private boolean m26361b() {
        ManualLinker manualLinker = new ManualLinker();
        for (Method method : manualLinker.getClass().getDeclaredMethods()) {
            LinkUri linkUri = (LinkUri) method.getAnnotation(LinkUri.class);
            if (linkUri != null) {
                String[] uris = linkUri.uris();
                int length = uris.length;
                int i = 0;
                while (i < length) {
                    if (TextUtils.equals(this.sidebarItem.getUrl(), uris[i])) {
                        try {
                            method.invoke(manualLinker, new Object[]{this.businessContext});
                            return true;
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        i++;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m26359a(SidebarItem sidebarItem2, BaseBusinessContext baseBusinessContext) {
        String url;
        Uri parse;
        String str;
        if (sidebarItem2 != null && baseBusinessContext != null && (url = sidebarItem2.getUrl()) != null && !url.isEmpty() && (parse = Uri.parse(url)) != null) {
            String query = parse.getQuery();
            if (query == null || query.isEmpty()) {
                str = parse.toString() + "?title=" + sidebarItem2.getName();
            } else {
                str = parse.toString() + "&title=" + sidebarItem2.getName();
            }
            DRouter.build(str).start(baseBusinessContext.getContext());
            EventBus.getDefault().post(EventKeys.Sidebar.CLOSE_SIDEBAR);
        }
    }
}
