package com.didichuxing.dfbasesdk.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.taxis99.R;

@Deprecated
public abstract class DFBaseAct extends FragmentActivity {
    protected FrameLayout mLayoutBody;
    protected ImageView mLeftTitleBtn;
    protected ProgressDialogFragment mProgress;
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
    public boolean fullScreen() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract int getActTitleId();

    /* access modifiers changed from: protected */
    public int getBgRes() {
        return R.color.df_white_color;
    }

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
    public boolean onBackKeyIntercept() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean progressCancelable() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int progressMsgResId() {
        return R.string.df_loading;
    }

    /* access modifiers changed from: protected */
    public void requestDataFromServer() {
    }

    /* access modifiers changed from: protected */
    public abstract void setupSubViews();

    /* access modifiers changed from: protected */
    public int getProgressDrawable() {
        String packageName = WsgSecInfo.packageName(this);
        if ("com.huaxiaozhu.driver".equalsIgnoreCase(packageName)) {
            return R.drawable.df_loading_hxz;
        }
        if ("com.huaxiaozhu.rider".equalsIgnoreCase(packageName)) {
            return R.drawable.df_loading_hxz_rider;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (fullScreen()) {
            getWindow().setFlags(1024, 1024);
        }
        setContentView((int) R.layout.df_base_act);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.base_layout_root);
        ImageView imageView = (ImageView) findViewById(R.id.title_left_btn);
        this.mLeftTitleBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DFBaseAct.this.onLeftTitleBtnClicked();
            }
        });
        this.mTitle = (TextView) findViewById(R.id.title_center_title);
        this.mRightTitleBtn = (TextView) findViewById(R.id.title_right_btn);
        this.mLayoutBody = (FrameLayout) findViewById(R.id.base_layout_body);
        this.mProgress = new ProgressDialogFragment();
        int progressDrawable = getProgressDrawable();
        if (progressDrawable > 0) {
            this.mProgress.setIndeterminateDrawable(progressDrawable);
        }
        this.mProgress.setContent(getResources().getString(progressMsgResId()), progressCancelable());
        try {
            this.mRecreated = bundle != null;
            initDataFromIntent(getIntent());
            viewGroup.setBackgroundResource(getBgRes());
            customizeLeftTitleBtn();
            setActTitle(getActTitleId());
            customizeActTitle();
            customizeRightTitleBtn();
            m33310a();
            setupSubViews();
            if (needEventBus()) {
                BusUtils.register(this);
            }
            requestDataFromServer();
        } catch (RuntimeException e) {
            LogUtils.logStackTrace(e);
        }
    }

    public void showProgress() {
        this.mProgress.show(getSupportFragmentManager(), "df_progress");
    }

    public void hideProgress() {
        this.mProgress.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        finish();
    }

    /* renamed from: a */
    private void m33310a() {
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

    public void setActTitle(String str) {
        this.mTitle.setText(str);
    }

    public final void onBackPressed() {
        if (!onBackKeyIntercept()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (needEventBus()) {
            BusUtils.unregister(this);
        }
    }
}
