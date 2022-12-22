package com.didichuxing.publicservice.resourcecontrol.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.pojo.RCRequestParams;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;

public class AssetRedRingView extends ImageView {
    private static final String TAG = AssetRedRingView.class.getSimpleName();
    private String isOnline = LoginOmegaUtil.OLD_USER;
    private RCRequestParams rcRequestParams;

    public AssetRedRingView(Context context) {
        super(context);
    }

    public AssetRedRingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AssetRedRingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void initView(ConstantUtils.ResourceId resourceId, String str) {
        this.isOnline = str;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ResourceManager.isFastClick()) {
                }
            }
        });
    }
}
