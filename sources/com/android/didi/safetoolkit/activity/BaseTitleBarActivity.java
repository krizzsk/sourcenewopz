package com.android.didi.safetoolkit.activity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.android.didi.safetoolkit.widget.topbarview.TopBarView;
import com.android.didi.safetoolkit.widget.topbarview.adapter.BaseTopBarAdapter;
import com.android.didi.safetoolkit.widget.topbarview.adapter.BaseTopBarCenterTextAdapter;
import com.taxis99.R;

public abstract class BaseTitleBarActivity extends BaseActivity {
    protected TopBarView mTopbarView = null;

    /* access modifiers changed from: protected */
    public final int getBasicContentLayoutResId() {
        return R.layout.title_bar_basic_activity_layout;
    }

    /* access modifiers changed from: protected */
    public abstract int getInnerLayoutResId();

    /* access modifiers changed from: protected */
    public void onContentViewLoaded() {
        initTopBarView();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        setTopBarTitle(this.mTopbarView, charSequence);
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        setContentView(getBasicContentLayoutResId());
        this.mInflater = LayoutInflater.from(this);
        this.mInnerLayout = this.mInflater.inflate(getInnerLayoutResId(), (FrameLayout) findViewById(R.id.basic_rootlayout), true);
    }

    /* access modifiers changed from: protected */
    public final void initTopBarView() {
        TopBarView topBarView = (TopBarView) findViewById(R.id.basic_tool_bar);
        this.mTopbarView = topBarView;
        topBarView.setAdapter(new BaseTopBarCenterTextAdapter(this));
        String charSequence = getTitle().toString();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = getString(R.string.app_name);
        }
        setTopBarTitle(this.mTopbarView, charSequence);
    }

    private void setTopBarTitle(TopBarView topBarView, CharSequence charSequence) {
        BaseTopBarAdapter adapter;
        if (topBarView != null && (adapter = topBarView.getAdapter()) != null && (adapter instanceof BaseTopBarCenterTextAdapter)) {
            ((BaseTopBarCenterTextAdapter) adapter).setCenterTextStr(charSequence.toString());
        }
    }

    public View getFallbackView() {
        return this.mTopbarView;
    }
}
