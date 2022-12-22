package com.didi.map.sdk.sharetrack.external.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.map.sdk.sharetrack.external.view.INavigationGuidanceView;
import java.util.HashMap;

public class NavGuidanceView extends FrameLayout implements INavigationGuidanceView {

    /* renamed from: a */
    private static final String f28737a = "NavGuidanceView";

    /* renamed from: b */
    private INavCardView f28738b;

    /* renamed from: c */
    private Context f28739c;

    /* renamed from: d */
    private HashMap<String, INavCardView> f28740d;

    public NavGuidanceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavGuidanceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavGuidanceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20262a(context);
    }

    /* renamed from: a */
    private void m20262a(Context context) {
        if (context != null) {
            this.f28739c = context;
            this.f28740d = new HashMap<>();
        }
    }

    public void setDestinationText(String str) {
        INavCardView iNavCardView = this.f28738b;
        if (iNavCardView != null) {
            iNavCardView.setDestinationText(str);
        }
    }

    public void setEDAETAText(String str) {
        INavCardView iNavCardView = this.f28738b;
        if (iNavCardView != null) {
            iNavCardView.onETAEDAChanged(str);
        }
    }

    public void setOnNavigationBtnClickListener(INavigationGuidanceView.INavigationBtnClickListener iNavigationBtnClickListener) {
        INavCardView iNavCardView = this.f28738b;
        if (iNavCardView != null) {
            iNavCardView.setOnNavigationBtnClickListener(iNavigationBtnClickListener);
        }
    }

    public void setIsInNightModeForcible(boolean z) {
        INavCardView iNavCardView = this.f28738b;
        if (iNavCardView != null) {
            iNavCardView.setIsInNightModeForcible(z);
        }
    }
}
