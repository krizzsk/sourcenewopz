package com.didi.sdk.fastframe.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import p241in.srain.cube.views.ptr.PtrClassicFrameLayout;
import p241in.srain.cube.views.ptr.PtrDefaultHandler;
import p241in.srain.cube.views.ptr.PtrFrameLayout;
import p241in.srain.cube.views.ptr.PtrHandler;
import p241in.srain.cube.views.ptr.PtrUIHandler;
import p241in.srain.cube.views.ptr.indicator.PtrIndicator;

public abstract class ListActivity extends BaseActivity implements IListView {

    /* renamed from: b */
    private BaseAdapter f35917b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f35918c = false;

    /* renamed from: d */
    private String f35919d = null;
    protected View mFooterView = null;
    protected ListView mListView = null;
    protected ProgressBar mProgressbarFooter = null;
    protected PtrClassicFrameLayout mPtrFrame = null;
    protected TextView mTxtFooter = null;

    /* access modifiers changed from: protected */
    public abstract void onLoadMore();

    /* access modifiers changed from: protected */
    public abstract void onRefresh();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.one_fastframe_activity_list);
        this.f35919d = getString(R.string.cube_ptr_no_data);
        PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) findViewById(R.id.rprtframe_main);
        this.mPtrFrame = ptrClassicFrameLayout;
        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);
        PtrClassicCustumHeader ptrClassicCustumHeader = new PtrClassicCustumHeader(this);
        this.mPtrFrame.setHeaderView(ptrClassicCustumHeader);
        this.mPtrFrame.addPtrUIHandler(ptrClassicCustumHeader);
        this.mPtrFrame.setPtrHandler(new PtrHandler() {
            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                ListActivity.this.onRefresh();
            }

            public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                return PtrDefaultHandler.checkContentCanBePulledDown(ptrFrameLayout, view, view2);
            }
        });
        ListView listView = (ListView) findViewById(R.id.listview_main);
        this.mListView = listView;
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            private boolean isOnePage = true;

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (this.isOnePage) {
                    ListActivity.this.m25428b();
                } else if (!ListActivity.this.f35918c && i == 0 && absListView.getLastVisiblePosition() >= absListView.getCount() - 1) {
                    ListActivity.this.onLoadMore();
                    ListActivity.this.m25426a();
                }
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.isOnePage = false;
            }
        });
        View inflate = LayoutInflater.from(this).inflate(R.layout.one_fastframe_list_footer, this.mListView, false);
        this.mFooterView = inflate;
        inflate.setVisibility(8);
        this.mProgressbarFooter = (ProgressBar) this.mFooterView.findViewById(R.id.progress_footer);
        this.mTxtFooter = (TextView) this.mFooterView.findViewById(R.id.txt_footer);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(this.mFooterView);
        this.mListView.addFooterView(linearLayout);
    }

    /* access modifiers changed from: protected */
    public void setAdapter(BaseAdapter baseAdapter) {
        this.f35917b = baseAdapter;
        this.mListView.setAdapter(baseAdapter);
    }

    /* access modifiers changed from: protected */
    public BaseAdapter getAdapter() {
        return this.f35917b;
    }

    /* access modifiers changed from: protected */
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mListView.setOnItemClickListener(onItemClickListener);
    }

    /* access modifiers changed from: protected */
    public void notifyDataChanged() {
        BaseAdapter baseAdapter = this.f35917b;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    public void refreshComplete() {
        this.f35918c = false;
        this.mPtrFrame.refreshComplete();
        m25428b();
    }

    /* access modifiers changed from: protected */
    public void autoRefresh() {
        this.mPtrFrame.postDelayed(new Runnable() {
            public void run() {
                ListActivity.this.mPtrFrame.autoRefresh();
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25426a() {
        this.mFooterView.setVisibility(0);
        this.mProgressbarFooter.setVisibility(0);
        this.mTxtFooter.setText(getString(R.string.cube_ptr_refreshing));
        this.mFooterView.setOnClickListener((View.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25428b() {
        this.mFooterView.setVisibility(0);
        this.mProgressbarFooter.setVisibility(8);
        this.mTxtFooter.setText(getString(R.string.cube_ptr_click_load));
        this.mFooterView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ListActivity.this.m25426a();
                ListActivity.this.onLoadMore();
            }
        });
    }

    public void loadComplete() {
        this.f35918c = true;
        this.mFooterView.setVisibility(0);
        this.mProgressbarFooter.setVisibility(8);
        this.mTxtFooter.setText(this.f35919d);
        this.mFooterView.setOnClickListener((View.OnClickListener) null);
    }

    public void setmNoData(String str) {
        this.f35919d = str;
    }

    public static class PtrClassicCustumHeader extends FrameLayout implements PtrUIHandler {
        private static final String KEY_SharedPreferences = "cube_ptr_classic_last_update";
        private static SimpleDateFormat sDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        private RotateAnimation mFlipAnimation;
        private TextView mLastUpdateTextView;
        private long mLastUpdateTime = -1;
        /* access modifiers changed from: private */
        public String mLastUpdateTimeKey;
        private LastUpdateTimeUpdater mLastUpdateTimeUpdater = new LastUpdateTimeUpdater();
        private View mProgressBar;
        private RotateAnimation mReverseFlipAnimation;
        private int mRotateAniTime = 150;
        private View mRotateView;
        private boolean mShouldShowLastUpdate;
        private TextView mTitleTextView;

        public PtrClassicCustumHeader(Context context) {
            super(context);
            initViews((AttributeSet) null);
        }

        public PtrClassicCustumHeader(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            initViews(attributeSet);
        }

        public PtrClassicCustumHeader(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            initViews(attributeSet);
        }

        /* access modifiers changed from: protected */
        public void initViews(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.PtrClassicHeader, 0, 0);
            if (obtainStyledAttributes != null) {
                this.mRotateAniTime = obtainStyledAttributes.getInt(0, this.mRotateAniTime);
            }
            buildAnimation();
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.one_fastframe_ptr_custom_header, this);
            this.mRotateView = inflate.findViewById(R.id.ptr_classic_header_rotate_view);
            this.mTitleTextView = (TextView) inflate.findViewById(R.id.ptr_classic_header_rotate_view_header_title);
            this.mLastUpdateTextView = (TextView) inflate.findViewById(R.id.ptr_classic_header_rotate_view_header_last_update);
            this.mProgressBar = inflate.findViewById(R.id.ptr_classic_header_rotate_view_progressbar);
            resetView();
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            LastUpdateTimeUpdater lastUpdateTimeUpdater = this.mLastUpdateTimeUpdater;
            if (lastUpdateTimeUpdater != null) {
                lastUpdateTimeUpdater.stop();
            }
        }

        public void setRotateAniTime(int i) {
            if (i != this.mRotateAniTime && i != 0) {
                this.mRotateAniTime = i;
                buildAnimation();
            }
        }

        public void setLastUpdateTimeKey(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mLastUpdateTimeKey = str;
            }
        }

        public void setLastUpdateTimeRelateObject(Object obj) {
            setLastUpdateTimeKey(obj.getClass().getName());
        }

        private void buildAnimation() {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.mFlipAnimation = rotateAnimation;
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.mFlipAnimation.setDuration((long) this.mRotateAniTime);
            this.mFlipAnimation.setFillAfter(true);
            RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.mReverseFlipAnimation = rotateAnimation2;
            rotateAnimation2.setInterpolator(new LinearInterpolator());
            this.mReverseFlipAnimation.setDuration((long) this.mRotateAniTime);
            this.mReverseFlipAnimation.setFillAfter(true);
        }

        private void resetView() {
            hideRotateView();
            this.mProgressBar.setVisibility(4);
        }

        private void hideRotateView() {
            this.mRotateView.clearAnimation();
            this.mRotateView.setVisibility(4);
        }

        public void onUIReset(PtrFrameLayout ptrFrameLayout) {
            resetView();
            this.mShouldShowLastUpdate = true;
            tryUpdateLastUpdateTime();
        }

        public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
            this.mShouldShowLastUpdate = true;
            tryUpdateLastUpdateTime();
            this.mLastUpdateTimeUpdater.start();
            this.mProgressBar.setVisibility(4);
            this.mRotateView.setVisibility(0);
            this.mTitleTextView.setVisibility(0);
            if (ptrFrameLayout.isPullToRefresh()) {
                this.mTitleTextView.setText(getResources().getString(R.string.cube_ptr_pull_down_to_refresh));
            } else {
                this.mTitleTextView.setText(getResources().getString(R.string.cube_ptr_pull_down));
            }
        }

        public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            this.mShouldShowLastUpdate = false;
            hideRotateView();
            this.mProgressBar.setVisibility(0);
            this.mTitleTextView.setVisibility(0);
            this.mTitleTextView.setText(R.string.cube_ptr_refreshing);
            tryUpdateLastUpdateTime();
            this.mLastUpdateTimeUpdater.stop();
        }

        public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
            hideRotateView();
            this.mProgressBar.setVisibility(4);
            this.mTitleTextView.setVisibility(0);
            this.mTitleTextView.setText(getResources().getString(R.string.cube_ptr_refresh_complete));
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(getContext(), KEY_SharedPreferences, 0);
            if (!TextUtils.isEmpty(this.mLastUpdateTimeKey)) {
                this.mLastUpdateTime = new Date().getTime();
                sharedPreferences.edit().putLong(this.mLastUpdateTimeKey, this.mLastUpdateTime).commit();
            }
        }

        /* access modifiers changed from: private */
        public void tryUpdateLastUpdateTime() {
            if (TextUtils.isEmpty(this.mLastUpdateTimeKey) || !this.mShouldShowLastUpdate) {
                this.mLastUpdateTextView.setVisibility(8);
                return;
            }
            String lastUpdateTime = getLastUpdateTime();
            if (TextUtils.isEmpty(lastUpdateTime)) {
                this.mLastUpdateTextView.setVisibility(8);
                return;
            }
            this.mLastUpdateTextView.setVisibility(0);
            this.mLastUpdateTextView.setText(lastUpdateTime);
        }

        private String getLastUpdateTime() {
            if (this.mLastUpdateTime == -1 && !TextUtils.isEmpty(this.mLastUpdateTimeKey)) {
                this.mLastUpdateTime = SystemUtils.getSharedPreferences(getContext(), KEY_SharedPreferences, 0).getLong(this.mLastUpdateTimeKey, -1);
            }
            if (this.mLastUpdateTime == -1) {
                return null;
            }
            long time = new Date().getTime() - this.mLastUpdateTime;
            int i = (int) (time / 1000);
            if (time < 0 || i <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(getContext().getString(R.string.cube_ptr_last_update));
            if (i < 60) {
                sb.append(i + getContext().getString(R.string.cube_ptr_seconds_ago));
            } else {
                int i2 = i / 60;
                if (i2 > 60) {
                    int i3 = i2 / 60;
                    if (i3 > 24) {
                        sb.append(sDataFormat.format(new Date(this.mLastUpdateTime)));
                    } else {
                        sb.append(i3 + getContext().getString(R.string.cube_ptr_hours_ago));
                    }
                } else {
                    sb.append(i2 + getContext().getString(R.string.cube_ptr_minutes_ago));
                }
            }
            return sb.toString();
        }

        public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, PtrIndicator ptrIndicator) {
            int offsetToRefresh = ptrFrameLayout.getOffsetToRefresh();
            int currentPosY = ptrIndicator.getCurrentPosY();
            int lastPosY = ptrIndicator.getLastPosY();
            if (currentPosY >= offsetToRefresh || lastPosY < offsetToRefresh) {
                if (currentPosY > offsetToRefresh && lastPosY <= offsetToRefresh && z && b == 2) {
                    crossRotateLineFromTopUnderTouch(ptrFrameLayout);
                    View view = this.mRotateView;
                    if (view != null) {
                        view.clearAnimation();
                        this.mRotateView.startAnimation(this.mFlipAnimation);
                    }
                }
            } else if (z && b == 2) {
                crossRotateLineFromBottomUnderTouch(ptrFrameLayout);
                View view2 = this.mRotateView;
                if (view2 != null) {
                    view2.clearAnimation();
                    this.mRotateView.startAnimation(this.mReverseFlipAnimation);
                }
            }
        }

        private void crossRotateLineFromTopUnderTouch(PtrFrameLayout ptrFrameLayout) {
            if (!ptrFrameLayout.isPullToRefresh()) {
                this.mTitleTextView.setVisibility(0);
                this.mTitleTextView.setText(R.string.cube_ptr_release_to_refresh);
            }
        }

        private void crossRotateLineFromBottomUnderTouch(PtrFrameLayout ptrFrameLayout) {
            this.mTitleTextView.setVisibility(0);
            if (ptrFrameLayout.isPullToRefresh()) {
                this.mTitleTextView.setText(getResources().getString(R.string.cube_ptr_pull_down_to_refresh));
            } else {
                this.mTitleTextView.setText(getResources().getString(R.string.cube_ptr_pull_down));
            }
        }

        private class LastUpdateTimeUpdater implements Runnable {
            private boolean mRunning;

            private LastUpdateTimeUpdater() {
                this.mRunning = false;
            }

            /* access modifiers changed from: private */
            public void start() {
                if (!TextUtils.isEmpty(PtrClassicCustumHeader.this.mLastUpdateTimeKey)) {
                    this.mRunning = true;
                    run();
                }
            }

            /* access modifiers changed from: private */
            public void stop() {
                this.mRunning = false;
                PtrClassicCustumHeader.this.removeCallbacks(this);
            }

            public void run() {
                PtrClassicCustumHeader.this.tryUpdateLastUpdateTime();
                if (this.mRunning) {
                    PtrClassicCustumHeader.this.postDelayed(this, 1000);
                }
            }
        }
    }
}
