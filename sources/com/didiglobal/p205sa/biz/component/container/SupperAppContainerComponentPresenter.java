package com.didiglobal.p205sa.biz.component.container;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.container.ContainerPresenter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.taxis99.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J \u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00060\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u000e"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/container/SupperAppContainerComponentPresenter;", "Lcom/didi/component/never/core/container/ContainerPresenter;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "createActivityPanelLp", "Landroid/view/ViewGroup$LayoutParams;", "context", "Landroid/content/Context;", "createMewLayoutParams", "createPanelLayoutParams", "setLayoutParams", "Ljava/util/LinkedHashMap;", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.container.SupperAppContainerComponentPresenter */
/* compiled from: SupperAppContainerComponentPresenter.kt */
public final class SupperAppContainerComponentPresenter extends ContainerPresenter {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SupperAppContainerComponentPresenter(ComponentParams componentParams) {
        super(componentParams);
        Intrinsics.checkNotNullParameter(componentParams, "params");
    }

    public LinkedHashMap<String, ViewGroup.LayoutParams> setLayoutParams(ComponentParams componentParams) {
        Activity activity;
        Activity activity2;
        LinkedHashMap<String, ViewGroup.LayoutParams> linkedHashMap = new LinkedHashMap<>();
        Map map = linkedHashMap;
        Activity activity3 = null;
        map.put(ComponentType.COMPONENT_TOP_BAR, m36488a(componentParams == null ? null : componentParams.getActivity()));
        if (componentParams == null) {
            activity = null;
        } else {
            activity = componentParams.getActivity();
        }
        map.put(ComponentType.COMPONENT_WELCOME, m36488a(activity));
        if (componentParams == null) {
            activity2 = null;
        } else {
            activity2 = componentParams.getActivity();
        }
        map.put(ComponentType.COMPONENT_SA_XPANEL, m36489b(activity2));
        if (componentParams != null) {
            activity3 = componentParams.getActivity();
        }
        map.put(ComponentType.COMPONENT_SA_ACTIVITY_PANEL, m36490c(activity3));
        return linkedHashMap;
    }

    /* renamed from: a */
    private final ViewGroup.LayoutParams m36488a(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.addRule(6);
        return layoutParams;
    }

    /* renamed from: b */
    private final ViewGroup.LayoutParams m36489b(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.addRule(3, R.id.titlebar);
        layoutParams.addRule(6);
        return layoutParams;
    }

    /* renamed from: c */
    private final ViewGroup.LayoutParams m36490c(Context context) {
        return new RelativeLayout.LayoutParams(-1, -1);
    }
}
