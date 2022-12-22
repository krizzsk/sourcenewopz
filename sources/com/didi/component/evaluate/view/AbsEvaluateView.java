package com.didi.component.evaluate.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.animator.GlobalXPanelAnimatorImpl;
import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.didi.component.common.animator.VisibilityChangeListenerAdapter;
import com.didi.component.common.loading.LoadingWrapper;
import com.didi.component.common.widget.loading.DataLoadingView;
import com.didi.component.common.widget.loading.IDataLoadingView;
import com.didi.component.common.widget.loading.OnRetryListener;
import com.didi.component.core.IPresenter;
import com.didi.component.evaluate.EvaluateRootContainer;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.component.evaluate.presenter.AbsCommonEvaluatePresenter;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.component.evaluate.view.widget.FiveStarEvaluatedView;
import com.didi.component.evaluate.widget.CardTitleView;
import com.didi.component.evaluate.widget.CommentView;
import com.didi.component.evaluate.widget.EvaluateTagListView;
import com.didi.component.evaluate.widget.IdentityView;
import com.didi.component.evaluate.widget.ObservableScrollView;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.taxis99.R;
import java.util.List;

public abstract class AbsEvaluateView extends LoadingWrapper implements EvaluateRootContainer.OnTouchWhenInterceptListener, IEvaluateView, FiveStarEvaluatedView.OnStarListener, CardTitleView.CardTitleCloseBtnListener, CommentView.OnContentChangeListener, EvaluateTagListView.OnTagSelectChangeListener, ILoadingHolder {

    /* renamed from: a */
    private FrameLayout f13328a;
    protected IGlobalXPanelAnimator animator = new GlobalXPanelAnimatorImpl();
    protected boolean isInFiveStar;
    protected AbsCommonEvaluatePresenter mAbsEvaluatePresenter;
    protected View mBottom;
    protected CommentView mCommentView;
    protected ViewStub mCommentViewStub;
    protected View mContainer;
    protected Activity mContext;
    protected IDataLoadingView mDataLoadingView;
    protected IEvaluateView.EvaluateListener mEvaluateListener;
    protected EvaluateRootContainer mEvaluateRoot;
    protected FiveStarEvaluatedView mFiveStarEvaluatedView;
    protected IdentityView mIdentity;
    protected int mLevel = 5;
    protected TextView mMainTagTitleTv;
    protected IEvaluateView.OnCloseListener mOnCloseListener;
    protected OnRetryListener mOnRetryListener;
    protected LinearLayout mRootContainer;
    protected ObservableScrollView mScrollView;
    protected TextView mSubTagTitleTv;
    protected String mSymbol;
    protected View mTagArea;
    protected ViewStub mTagAreaStub;
    protected List<EvaluateTag> mTagList;
    protected EvaluateTagListView mTagListView;
    protected View mTagView;
    protected CarTipInfo mTipInfo;
    protected CardTitleView mTitle;
    protected View mTop;
    protected TextView mUnMatchDetail;
    protected RelativeLayout mUnMatchLayout;
    protected TextView mUnMatchResult;
    protected TextView mUnMatchSubmit;
    protected View mView;

    public int getStyle() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onLevelSet() {
    }

    public void setCarEvaluateTags(List<CarNoEvaluateData.CarEvaluateTag> list) {
    }

    public void setRefineGuide(String str) {
    }

    public void setSymbol(String str) {
    }

    public AbsEvaluateView(Activity activity) {
        this.mContext = activity;
        this.mView = LayoutInflater.from(activity).inflate(R.layout.global_evaluate_layout, (ViewGroup) null);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.mEvaluateRoot = (EvaluateRootContainer) findView(R.id.global_evaluate);
        this.mRootContainer = (LinearLayout) findView(R.id.oc_evaluate_root_container);
        FiveStarEvaluatedView fiveStarEvaluatedView = (FiveStarEvaluatedView) findView(R.id.oc_evaluate_five_star_view);
        this.mFiveStarEvaluatedView = fiveStarEvaluatedView;
        fiveStarEvaluatedView.setOnStarListener(this);
        this.mEvaluateRoot.setOnTouchWhenInterceptListener(this);
        this.mTitle = (CardTitleView) findView(R.id.oc_evaluate_title);
        this.mContainer = findView(R.id.oc_evaluate_container);
        this.mScrollView = (ObservableScrollView) findView(R.id.oc_evaluate_scroll);
        this.mTop = findView(R.id.sv_top_line);
        this.mBottom = findView(R.id.sv_bottom_line);
        this.mIdentity = (IdentityView) findView(R.id.oc_evaluate_identity);
        this.mTagAreaStub = (ViewStub) findView(R.id.oc_evaluate_tag_area_stub);
        this.mCommentViewStub = (ViewStub) findView(R.id.oc_evaluate_comment_area_stub);
        this.f13328a = (FrameLayout) findView(R.id.oc_evaluate_loading);
        this.mMainTagTitleTv = (TextView) findView(R.id.tv_evaluate_main);
        this.mSubTagTitleTv = (TextView) findView(R.id.tv_evaluate_sub);
        this.mScrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            public void onScrollChanged(ObservableScrollView observableScrollView, int i, int i2, int i3, int i4) {
                if (i2 == 0) {
                    AbsEvaluateView.this.showSvLine(false);
                } else {
                    AbsEvaluateView.this.showSvLine(true);
                }
            }
        });
        initTitle();
        setIdentityDelayFocus();
        setLoadingShowOn(this);
    }

    public View getFallbackView() {
        return this.f13328a;
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).build();
    }

    public void initIsInFiveStar(boolean z) {
        this.isInFiveStar = z;
    }

    /* access modifiers changed from: protected */
    public void setIdentityDelayFocus() {
        this.mView.postDelayed(new Runnable() {
            public void run() {
                if (!AbsEvaluateView.this.isInFiveStar) {
                    AbsEvaluateView.this.mIdentity.setFocus();
                }
            }
        }, 1000);
    }

    /* access modifiers changed from: protected */
    public void initTitle() {
        this.mTitle.setClosable(true);
        this.mTitle.setCloseIconListener(new CardTitleView.CardTitleCloseBtnListener() {
            public void onCloseBtnClick() {
                if (AbsEvaluateView.this.mOnCloseListener != null) {
                    AbsEvaluateView.this.mOnCloseListener.onClose();
                }
            }
        });
    }

    /* renamed from: a */
    private void m9130a(UnevaluatedViewModel.UnMatchInfo unMatchInfo) {
        if (this.mUnMatchLayout == null) {
            RelativeLayout relativeLayout = (RelativeLayout) findView(R.id.unmatch_layout);
            this.mUnMatchLayout = relativeLayout;
            relativeLayout.setVisibility(0);
            this.mUnMatchDetail = (TextView) findView(R.id.unmatch_detail);
            this.mUnMatchSubmit = (TextView) findView(R.id.unmatch_submit);
            this.mUnMatchResult = (TextView) findView(R.id.unmatch_result_evaluate);
            this.mUnMatchSubmit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    AbsEvaluateView.this.mAbsEvaluatePresenter.submitUnMatch();
                }
            });
            if (unMatchInfo.unMatchGuideMsg != null && !TextUtils.isEmpty(unMatchInfo.unMatchGuideMsg.showMsg) && !TextUtils.isEmpty(unMatchInfo.unMatchGuideMsg.buttonMsg)) {
                this.mUnMatchDetail.setText(unMatchInfo.unMatchGuideMsg.showMsg);
                this.mUnMatchSubmit.setText(unMatchInfo.unMatchGuideMsg.buttonMsg);
                this.mUnMatchResult.setText(unMatchInfo.unMatchGuideMsg.unMatchedMsg);
            }
        }
    }

    public void showUnMatchSubmit(UnevaluatedViewModel.UnMatchInfo unMatchInfo, boolean z) {
        m9130a(unMatchInfo);
        if (z) {
            this.mUnMatchLayout.setBackgroundResource(R.color.oc_color_F3F4F5);
        } else {
            this.mUnMatchLayout.setBackground((Drawable) null);
        }
        this.mUnMatchDetail.setVisibility(0);
        this.mUnMatchSubmit.setVisibility(0);
        this.mUnMatchResult.setVisibility(4);
    }

    public void showUnMatchResult(UnevaluatedViewModel.UnMatchInfo unMatchInfo, boolean z) {
        m9130a(unMatchInfo);
        if (z) {
            this.mUnMatchLayout.setBackgroundColor(this.mContext.getResources().getColor(R.color.oc_color_F3F4F5));
        } else {
            this.mUnMatchLayout.setBackground((Drawable) null);
        }
        this.mUnMatchDetail.setVisibility(4);
        this.mUnMatchSubmit.setVisibility(4);
        this.mUnMatchResult.setVisibility(0);
    }

    public void setPresenter(IPresenter iPresenter) {
        this.mAbsEvaluatePresenter = (AbsCommonEvaluatePresenter) iPresenter;
    }

    /* access modifiers changed from: protected */
    public void showSvLine(boolean z) {
        if (z) {
            this.mTop.setVisibility(0);
            this.mBottom.setVisibility(0);
            return;
        }
        this.mTop.setVisibility(8);
        this.mBottom.setVisibility(8);
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
        this.mOnRetryListener = onRetryListener;
    }

    public void setDefaultDriverIcon(int i) {
        this.mIdentity.setHead(i);
    }

    public void setDriverIconAndName(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.mIdentity.setHead(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.mIdentity.setName(str2);
        }
    }

    /* access modifiers changed from: protected */
    public void hideContainer() {
        this.mRootContainer.setVisibility(8);
        this.mContainer.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void hideHeader() {
        this.mFiveStarEvaluatedView.setVisibility(8);
        this.mIdentity.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void showContainer() {
        this.mRootContainer.setVisibility(0);
        this.mContainer.setVisibility(0);
    }

    public void showHeader() {
        if (this.isInFiveStar) {
            this.mFiveStarEvaluatedView.setVisibility(0);
            this.mIdentity.setVisibility(8);
            return;
        }
        this.mIdentity.setVisibility(0);
        this.mFiveStarEvaluatedView.setVisibility(8);
    }

    public void hideLoading() {
        LinearLayout linearLayout;
        super.hideLoading();
        final View findViewById = this.mRootContainer.findViewById(R.id.evaluate_dialog);
        if (findViewById == null || findViewById.getParent() != (linearLayout = this.mRootContainer)) {
            showContainer();
            showHeader();
            return;
        }
        this.animator.hide(linearLayout, 200, 0, new VisibilityChangeListenerAdapter() {
            public void onHidden() {
                AbsEvaluateView.this.mRootContainer.removeView(findViewById);
                AbsEvaluateView.this.showContainer();
                AbsEvaluateView.this.showHeader();
                AbsEvaluateView.this.mRootContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        AbsEvaluateView.this.mRootContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        AbsEvaluateView.this.showContent();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showContent() {
        this.animator.show(this.mRootContainer, 200, 0, (IGlobalXPanelAnimator.VisibilityChangedListener) null);
    }

    public void showLoadingFail(boolean z) {
        LinearLayout linearLayout;
        View findViewById = this.mRootContainer.findViewById(R.id.evaluate_dialog);
        if (findViewById != null && findViewById.getParent() == (linearLayout = this.mRootContainer)) {
            linearLayout.removeView(findViewById);
        }
        DataLoadingView dataLoadingView = new DataLoadingView(this.mContext);
        this.mDataLoadingView = dataLoadingView;
        dataLoadingView.setId(R.id.evaluate_dialog);
        this.mDataLoadingView.setOnRetryListener(new OnRetryListener() {
            public void onRetry() {
                if (AbsEvaluateView.this.mOnRetryListener != null) {
                    AbsEvaluateView.this.mOnRetryListener.onRetry();
                }
                AbsEvaluateView.this.showLoading();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13, -1);
        this.mRootContainer.addView(this.mDataLoadingView.getView(), layoutParams);
        IDataLoadingView iDataLoadingView = this.mDataLoadingView;
        if (iDataLoadingView != null) {
            iDataLoadingView.showRetry();
        }
    }

    public void setCardTitle(String str) {
        this.mTitle.setTitleText(str);
    }

    public void setLevel(int i) {
        this.mLevel = i;
        this.mIdentity.setLevel(i);
        this.mFiveStarEvaluatedView.showEvaluated(i);
        onLevelSet();
    }

    public View getView() {
        return this.mView;
    }

    public void setOnCloseListener(IEvaluateView.OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findView(int i) {
        return this.mView.findViewById(i);
    }
}
