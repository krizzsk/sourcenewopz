package com.didi.component.evaluate.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.component.evaluate.view.TipView;
import com.didi.component.evaluate.widget.CommentView;
import com.didi.component.evaluate.widget.EvaluateTagListView;
import com.didi.component.evaluate.widget.ISubmitView;
import com.didi.component.evaluate.widget.KeyboardHeightProvider;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class EvaluateView extends AbsEvaluateView implements View.OnLayoutChangeListener {
    protected int mCommentBottomDis;
    protected KeyboardHeightProvider.KeyboardHeightObserver mHeightObserver = new KeyboardHeightProvider.KeyboardHeightObserver() {
        public void onKeyboardHeightChanged(int i, int i2) {
            if (EvaluateView.this.mCommentView != null) {
                boolean z = i > 0;
                EvaluateView.this.mEvaluateRoot.setInterceptTouchEnable(z);
                int onKeyboardHeightChange = EvaluateView.this.mCommentView.onKeyboardHeightChange(i);
                if (z) {
                    int dip2px = ((i + onKeyboardHeightChange) - EvaluateView.this.mCommentBottomDis) + UiUtils.dip2px(EvaluateView.this.mContext, 10.0f);
                    if (dip2px > 0) {
                        EvaluateView.this.mCommentView.setPadding(0, 0, 0, dip2px);
                        if (dip2px - UiUtils.getViewLocation(EvaluateView.this.mEvaluateRoot)[1] > 0) {
                            EvaluateView.this.mOnDrawListener = new ViewTreeObserver.OnDrawListener() {
                                public void onDraw() {
                                    EvaluateView.this.mCommentView.postDelayed(new Runnable() {
                                        public void run() {
                                            EvaluateView.this.mScrollView.scrollTo(0, 10000);
                                            EvaluateView.this.mScrollView.setOnTouchListener(new View.OnTouchListener() {
                                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                                    return true;
                                                }
                                            });
                                            EvaluateView.this.mCommentView.getViewTreeObserver().removeOnDrawListener(EvaluateView.this.mOnDrawListener);
                                        }
                                    }, 0);
                                }
                            };
                            EvaluateView.this.mCommentView.getViewTreeObserver().addOnDrawListener(EvaluateView.this.mOnDrawListener);
                        }
                    }
                } else if (EvaluateView.this.mCommentView.getPaddingBottom() > 0) {
                    EvaluateView.this.mCommentView.setPadding(0, 0, 0, 0);
                    EvaluateView.this.mScrollView.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return false;
                        }
                    });
                    EvaluateView.this.clearCommentViewFocus();
                }
            }
        }
    };
    protected KeyboardHeightProvider mKeyboardHeightDetector;
    protected ViewTreeObserver.OnDrawListener mOnDrawListener;
    protected ISubmitView mSubmitView;
    protected TipView mTipView;

    public void onAdd() {
    }

    public void setOnCancelListener(IEvaluateView.OnCancelListener onCancelListener) {
    }

    public EvaluateView(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public void startKeyboardHeightDetector() {
        KeyboardHeightProvider keyboardHeightProvider = new KeyboardHeightProvider(this.mContext);
        this.mKeyboardHeightDetector = keyboardHeightProvider;
        keyboardHeightProvider.start();
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mTipView = (TipView) findView(R.id.oc_evaluate_tip);
        this.mSubmitView = (ISubmitView) findView(R.id.oc_evaluate_submit);
        startKeyboardHeightDetector();
        initSubmit();
    }

    /* access modifiers changed from: protected */
    public void initSubmit() {
        this.mSubmitView.setEnable(true);
        this.mSubmitView.setOnclickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EvaluateView.this.submit();
            }
        });
    }

    public void onRemove() {
        KeyboardHeightProvider keyboardHeightProvider = this.mKeyboardHeightDetector;
        if (keyboardHeightProvider != null) {
            keyboardHeightProvider.close();
        }
        if (this.mCommentView != null) {
            this.mCommentView.removeOnLayoutChangeListener(this);
        }
    }

    public void setTags(List<EvaluateTag> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mTagList = new ArrayList();
        this.mTagList.addAll(list);
        if (this.mTagListView == null) {
            setTagAreaVisibility(true);
        } else if (this.mTagListView != null) {
            this.mTagListView.updateEvaluateTags(list);
        }
    }

    public void setTagTitle(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.mMainTagTitleTv.setVisibility(8);
        } else {
            this.mMainTagTitleTv.setVisibility(0);
            this.mMainTagTitleTv.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            this.mSubTagTitleTv.setVisibility(8);
            return;
        }
        this.mSubTagTitleTv.setVisibility(0);
        this.mSubTagTitleTv.setText(str2);
    }

    public void showLoading() {
        super.showLoading();
        this.mSubmitView.showLoading();
    }

    public void hideLoading() {
        super.hideLoading();
        this.mSubmitView.hideLoading();
        this.mSubmitView.setEnable(m9134b());
        setCommentAreaVisibility(true);
    }

    /* access modifiers changed from: protected */
    public void setTagAreaVisibility(boolean z) {
        if (z) {
            if (this.mTagArea == null) {
                this.mTagArea = this.mTagAreaStub.inflate();
                this.mTagView = findView(R.id.oc_evaluate_tag_view);
                this.mTagListView = (EvaluateTagListView) this.mTagArea.findViewById(R.id.oc_evaluate_tags_view);
                if (this.mAbsEvaluatePresenter != null) {
                    this.mTagListView.setFlowStyle(this.mAbsEvaluatePresenter.isShowTagInFlow());
                }
                this.mTagListView.setOnTagSelectChangeListener(this);
            } else {
                this.mTagArea.setVisibility(0);
            }
            if (this.mTagList != null) {
                this.mTagListView.updateEvaluateTags(this.mTagList);
            }
            this.mTagListView.setTagSelectable(true);
        } else if (this.mTagView != null) {
            this.mTagView.setVisibility(8);
        }
    }

    public void setCommentAreaVisibility(boolean z) {
        if (z) {
            if (this.mCommentView == null) {
                if (this.mCommentViewStub.getParent() != null) {
                    this.mCommentViewStub.inflate();
                }
                this.mCommentView = (CommentView) findView(R.id.oc_evaluate_comment_area);
                this.mCommentView.setOnContentChangeListener(this);
                this.mEvaluateRoot.setCanTouchView(R.id.oc_evaluate_comment_view);
                if (this.mCommentView != null) {
                    this.mCommentView.addOnLayoutChangeListener(this);
                    return;
                }
                return;
            }
            this.mCommentView.setVisibility(0);
        } else if (this.mCommentView != null) {
            this.mCommentView.setVisibility(8);
        }
    }

    public void setCommentContent(String str) {
        if (this.mCommentView == null) {
            setCommentAreaVisibility(true);
        } else if (this.mCommentView != null) {
            this.mCommentView.setContent(str);
        }
    }

    public void setLevel(int i) {
        super.setLevel(i);
        if (i != 5) {
            this.mTipView.setVisibility(8);
            this.mSubmitView.setTipHint("");
        }
    }

    public void refreshThanksTipData(CarTipInfo carTipInfo) {
        this.mTipInfo = carTipInfo;
        if (carTipInfo == null || this.mLevel != 5) {
            this.mTipView.setVisibility(8);
            this.mSubmitView.setTipHint("");
        } else if (!carTipInfo.isShow()) {
            this.mTipView.setVisibility(8);
        } else if (!carTipInfo.isPay() && carTipInfo.feeItems != null && carTipInfo.feeItems.length > 0) {
            this.mSymbol = carTipInfo.feeItems[0].currency;
            this.mTipView.setTipPriceList(carTipInfo.feeItems, this.mSymbol);
            this.mTipView.setOnTipSelected(new TipView.OnTipSelected() {
                public void onSelected(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        str = EvaluateView.this.mSymbol + str;
                    }
                    EvaluateView.this.mSubmitView.setTipHint(str);
                }
            });
            this.mTipView.setVisibility(0);
        }
    }

    public void setEvaluateListener(IEvaluateView.EvaluateListener evaluateListener) {
        this.mEvaluateListener = evaluateListener;
    }

    public void showSubmitSuccess() {
        this.mSubmitView.submitSuccess();
        close();
    }

    public void showSubmitFail() {
        this.mSubmitView.submitFail();
    }

    public void close() {
        if (this.mOnCloseListener != null) {
            this.mOnCloseListener.onClose();
        }
    }

    public void closeWithoutOmega() {
        if (this.mOnCloseListener != null) {
            this.mOnCloseListener.onCloseWithOutOmega();
        }
    }

    public void onResume() {
        this.mKeyboardHeightDetector.setKeyboardHeightObserver(this.mHeightObserver);
    }

    public void onPause() {
        this.mKeyboardHeightDetector.setKeyboardHeightObserver((KeyboardHeightProvider.KeyboardHeightObserver) null);
    }

    public void onTagSelectChange(View view, EvaluateTag evaluateTag, boolean z) {
        m9133a();
        if (this.mAbsEvaluatePresenter != null) {
            this.mAbsEvaluatePresenter.onTagSelected(evaluateTag, z);
        }
    }

    public void onContentChange(CharSequence charSequence) {
        m9133a();
    }

    /* access modifiers changed from: protected */
    public void clearCommentViewFocus() {
        if (this.mCommentView != null && this.mCommentView.isFocused()) {
            this.mCommentView.clearFocus();
        }
    }

    public void onTouchWhenIntercept() {
        clearCommentViewFocus();
    }

    /* access modifiers changed from: protected */
    public void submit() {
        if (this.mEvaluateListener != null) {
            List<EvaluateTag> list = null;
            if (this.mTagListView != null) {
                list = this.mTagListView.getSelectedTags();
            }
            String str = "";
            String text = this.mCommentView != null ? this.mCommentView.getText() : str;
            TipView tipView = this.mTipView;
            if (!(tipView == null || tipView.getTipValueNum() == 0.0d)) {
                str = this.mTipView.getTipValueNum() + str;
            }
            this.mEvaluateListener.onSubmit(list, text, str);
        }
    }

    public void onCloseBtnClick() {
        clearCommentViewFocus();
        close();
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.mCommentView != null && this.mCommentView.getPaddingBottom() == 0) {
            int[] iArr = new int[2];
            this.mCommentView.getLocationOnScreen(iArr);
            this.mCommentBottomDis = (UiUtils.getWindowHeight(this.mContext) - this.mCommentView.getHeight()) - iArr[1];
        }
    }

    /* access modifiers changed from: protected */
    public void onLevelSet() {
        super.onLevelSet();
        m9133a();
    }

    public void onStarChanged(int i) {
        this.mAbsEvaluatePresenter.setOrderLevel(i);
        this.mLevel = i;
        m9133a();
        refreshThanksTipData(this.mTipInfo);
    }

    /* renamed from: a */
    private void m9133a() {
        this.mSubmitView.setEnable(m9134b());
    }

    /* renamed from: b */
    private boolean m9134b() {
        List<EvaluateTag> selectedTags;
        if (this.mLevel == 5) {
            return true;
        }
        if (this.mTagListView != null && (selectedTags = this.mTagListView.getSelectedTags()) != null && selectedTags.size() > 0) {
            return true;
        }
        if (this.mCommentView == null || TextUtils.isEmpty(this.mCommentView.getText())) {
            return false;
        }
        return true;
    }
}
