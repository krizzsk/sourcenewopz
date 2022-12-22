package com.didi.hawaii.p118ar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.hawaii.p118ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p118ar.core.DiARNavController;
import com.didi.hawaii.p118ar.utils.ARRequestUtil;
import com.didi.hawaii.p118ar.utils.ARSharePref;
import com.didi.hawaii.p118ar.utils.BatteryUtil;
import com.didi.hawaii.p118ar.utils.LocationUtil;
import com.didi.hawaii.p118ar.utils.NetStateUtil;
import com.didi.hawaii.p118ar.utils.SensorUtil;
import com.didi.hawaii.p118ar.view.ARGlView;
import com.didi.sdk.util.SystemUtil;

/* renamed from: com.didi.hawaii.ar.DiARNavView */
public class DiARNavView extends FrameLayout {

    /* renamed from: a */
    private ARGlView f22973a;

    /* renamed from: b */
    private Context f22974b;

    public void onRestart() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public DiARNavView(Context context) throws CreateDiARNavViewException {
        super(context);
        this.f22973a = null;
        this.f22974b = null;
        setClickable(true);
        if (!isInEditMode()) {
            mo67587a(context);
        }
    }

    public DiARNavView(Context context, AttributeSet attributeSet) throws CreateDiARNavViewException {
        this(context, attributeSet, 0);
    }

    public DiARNavView(Context context, AttributeSet attributeSet, int i) throws CreateDiARNavViewException {
        super(context, attributeSet, i);
        this.f22973a = null;
        this.f22974b = null;
        setClickable(true);
        if (!isInEditMode()) {
            mo67587a(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67587a(Context context) throws CreateDiARNavViewException {
        ARSharePref.init(context);
        SystemUtil.init(context);
        NetStateUtil.init(context);
        ARRequestUtil.init(context);
        BatteryUtil.init(context);
        SensorUtil.getInstance().init(context);
        LocationUtil.startGetLocation(context);
        SensorUtil.getInstance().startListenRotationVector();
        this.f22974b = context;
        this.f22973a = new ARGlView(context, (ViewGroup) this);
        addView(this.f22973a, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public DiDiAR getDiAR() {
        return new DiDiAR(this, this.f22974b);
    }

    public void onResume() {
        this.f22973a.onResume();
    }

    public void onPause() {
        this.f22973a.onPause();
    }

    public void onDestroy() {
        removeAllViews();
        this.f22973a.onDestroy();
        LocationUtil.stopGetLocation(this.f22974b);
        SensorUtil.getInstance().stopListenRotationVector();
    }

    public DiARNavController getDiARController() {
        return this.f22973a.getDiARController();
    }
}
