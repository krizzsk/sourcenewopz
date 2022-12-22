package rui.widget.popup;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import rui.util.ViewUtils;
import rui.widget.popup.base.BasePopupModel;

public class PopupView extends LinearLayout {
    public PopupView(Context context) {
        super(context);
        m3863a(context);
    }

    public PopupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3863a(context);
    }

    public PopupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3863a(context);
    }

    /* renamed from: a */
    private void m3863a(Context context) {
        setOrientation(1);
        int dp = (int) ViewUtils.m3859dp(context, 20.0f);
        setPadding(0, dp, 0, dp);
        setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.rui_color_white, (Resources.Theme) null));
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        setLayoutParams(layoutParams);
    }

    @Deprecated
    public void update(BasePopupModel basePopupModel) {
        removeAllViews();
        basePopupModel.getFactory().create(this, basePopupModel);
    }

    public void init(BasePopupModel basePopupModel) {
        removeAllViews();
        basePopupModel.getFactory().create(this, basePopupModel);
    }
}
