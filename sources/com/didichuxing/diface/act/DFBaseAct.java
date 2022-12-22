package com.didichuxing.diface.act;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.SwitchLangUtil;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.taxis99.R;
import java.util.Locale;

public abstract class DFBaseAct extends DiFaceBaseActivity {
    protected FrameLayout mLayoutBody;
    protected ImageView mLeftTitleBtn;
    protected boolean mRecreated;
    protected TextView mRightTitleBtn;
    protected TextView mTitle;

    /* access modifiers changed from: protected */
    public void customizeActTitle() {
    }

    /* access modifiers changed from: protected */
    public void customizeLeftTitleBtn() {
    }

    /* access modifiers changed from: protected */
    public void customizeRightTitleBtn() {
    }

    /* access modifiers changed from: protected */
    public abstract int getActTitleId();

    /* access modifiers changed from: protected */
    public abstract int getContentLayout();

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void requestDataFromServer() {
    }

    /* access modifiers changed from: protected */
    public abstract void setupSubViews();

    /* access modifiers changed from: protected */
    public void switchStyle() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        switchStyle();
        setContentView((int) R.layout.diface_global_base_act);
        this.mLeftTitleBtn = (ImageView) findViewById(R.id.title_left_btn);
        boolean z = true;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.mLeftTitleBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_arabic));
        }
        this.mLeftTitleBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DFBaseAct.this.onLeftTitleBtnClicked();
            }
        });
        this.mTitle = (TextView) findViewById(R.id.title_center_title);
        this.mRightTitleBtn = (TextView) findViewById(R.id.title_right_btn);
        this.mLayoutBody = (FrameLayout) findViewById(R.id.base_layout_body);
        if (bundle == null) {
            z = false;
        }
        try {
            this.mRecreated = z;
            initDataFromIntent(getIntent());
            customizeLeftTitleBtn();
            setActTitle(getActTitleId());
            customizeActTitle();
            customizeRightTitleBtn();
            m33662a();
            setupSubViews();
            if (needEventBus()) {
                BusUtils.register(this);
            }
            requestDataFromServer();
        } catch (RuntimeException e) {
            LogUtils.logStackTrace(e);
        }
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        finishWithResult(new DiFaceResult(102));
    }

    /* renamed from: a */
    private void m33662a() {
        int contentLayout = getContentLayout();
        if (contentLayout != 0) {
            getLayoutInflater().inflate(contentLayout, this.mLayoutBody, true);
        }
    }

    public void clearContent() {
        this.mLayoutBody.removeAllViews();
    }

    public void hideTitleArea() {
        findViewById(R.id.base_layout_title).setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void setActTitle(int i) {
        if (i != 0) {
            this.mTitle.setText(getResources().getString(i));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (needEventBus()) {
            try {
                BusUtils.unregister(this);
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        SwitchLangUtil.switchLang(this, DiFaceFacade.getInstance().getLanguage());
    }
}
