package com.didi.component.evaluate.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.ImageUtils;
import com.didi.component.business.util.SourceUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.loading.OnRetryListener;
import com.didi.component.core.IPresenter;
import com.didi.component.evaluate.EvaluateRootContainer;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.component.evaluate.presenter.AbsCommonEvaluatePresenter;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.component.evaluate.view.TipInputPopWindow;
import com.didi.component.evaluate.view.widget.AbsBaseTagLayout;
import com.didi.component.evaluate.view.widget.EvaluateTagImageLayout;
import com.didi.component.evaluate.view.widget.EvaluateTagTextLayout;
import com.didi.component.evaluate.view.widget.FiveStarEvaluatedView;
import com.didi.component.evaluate.view.widget.NewEvaluateTipsView;
import com.didi.component.evaluate.view.widget.NewFiveStarEvaluatedView;
import com.didi.component.evaluate.widget.KeyboardHeightProvider;
import com.didi.component.evaluate.widget.NewCommentView;
import com.didi.trackupload.sdk.Constants;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.google.android.flexbox.FlexboxLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewEvaluateView extends AbsNewEvaluateView implements EvaluateRootContainer.OnTouchWhenInterceptListener, IEvaluateView, FiveStarEvaluatedView.OnStarListener {

    /* renamed from: a */
    private static final int f13347a = 11;

    /* renamed from: b */
    private static final int f13348b = 6;

    /* renamed from: c */
    private static final int f13349c = 7;

    /* renamed from: d */
    private static final float[] f13350d = {100.0f, 90.0f, 80.0f, 90.0f, 160.0f, 182.0f, 119.0f};

    /* renamed from: e */
    private static final int f13351e = 228;

    /* renamed from: A */
    private List<CarNoEvaluateData.CarEvaluateTag> f13352A;

    /* renamed from: B */
    private CarNoEvaluateData.CarEvaluateTag f13353B;

    /* renamed from: C */
    private IEvaluateView.EvaluateListener f13354C;

    /* renamed from: D */
    private boolean f13355D = false;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public ScrollView f13356E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public ViewTreeObserver.OnDrawListener f13357F;

    /* renamed from: G */
    private KeyboardHeightProvider f13358G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public String f13359H = "";

    /* renamed from: I */
    private NewEvaluateScrollView f13360I;

    /* renamed from: J */
    private FrameLayout f13361J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public RelativeLayout f13362K;

    /* renamed from: L */
    private int f13363L;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f13364f;

    /* renamed from: g */
    private ImageView f13365g;

    /* renamed from: h */
    private TextView f13366h;

    /* renamed from: i */
    private View f13367i;

    /* renamed from: j */
    private ImageView f13368j;

    /* renamed from: k */
    private NewFiveStarEvaluatedView f13369k;

    /* renamed from: l */
    private ImageView f13370l;

    /* renamed from: m */
    private FlexboxLayout f13371m;
    protected NewCommentView mCommentView;
    protected EvaluateRootContainer mEvaluateRoot;
    protected KeyboardHeightProvider.KeyboardHeightObserver mHeightObserver = new KeyboardHeightProvider.KeyboardHeightObserver() {
        public void onKeyboardHeightChanged(int i, int i2) {
            if (NewEvaluateView.this.mCommentView != null) {
                boolean z = i > 0;
                NewEvaluateView.this.mCommentView.onKeyboardHeightChange(i);
                if (z) {
                    int bottom = i - NewEvaluateView.this.mCommentView.getBottom();
                    if (bottom > 0) {
                        NewEvaluateView.this.mCommentView.setPadding(0, 0, 0, bottom + 200);
                        if (bottom - UiUtils.getViewLocation(NewEvaluateView.this.mEvaluateRoot)[1] > 0) {
                            ViewTreeObserver.OnDrawListener unused = NewEvaluateView.this.f13357F = new ViewTreeObserver.OnDrawListener() {
                                public void onDraw() {
                                    NewEvaluateView.this.mCommentView.post(new Runnable() {
                                        public void run() {
                                            NewEvaluateView.this.f13356E.scrollTo(0, 10000);
                                            NewEvaluateView.this.f13356E.setOnTouchListener(new View.OnTouchListener() {
                                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                                    NewEvaluateView.this.mCommentView.hideSoftInput();
                                                    return false;
                                                }
                                            });
                                            NewEvaluateView.this.mCommentView.getViewTreeObserver().removeOnDrawListener(NewEvaluateView.this.f13357F);
                                        }
                                    });
                                }
                            };
                            NewEvaluateView.this.mCommentView.getViewTreeObserver().addOnDrawListener(NewEvaluateView.this.f13357F);
                        }
                    }
                } else if (NewEvaluateView.this.mCommentView.getPaddingBottom() > 0) {
                    NewEvaluateView.this.mCommentView.setPadding(0, 0, 0, 0);
                    NewEvaluateView.this.f13356E.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return false;
                        }
                    });
                    NewEvaluateView.this.clearCommentViewFocus();
                }
            }
        }
    };
    protected IEvaluateView.OnCloseListener mOnCloseListener;

    /* renamed from: n */
    private RelativeLayout f13372n;

    /* renamed from: o */
    private RelativeLayout f13373o;

    /* renamed from: p */
    private RelativeLayout f13374p;

    /* renamed from: q */
    private ImageView f13375q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public TextView f13376r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public TextView f13377s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public LinearLayout f13378t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public TextView f13379u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public TextView f13380v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public LinearLayout f13381w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public View f13382x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public PopupWindow f13383y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public ImageView f13384z;

    private interface AnimateFinishListener {
        void onFinish();
    }

    private interface SubmitSuccessListener {
        void onSuccess();
    }

    public void hideLoading() {
    }

    public void initIsInFiveStar(boolean z) {
    }

    public void onAdd() {
    }

    public void onTouchWhenIntercept() {
    }

    public void setCardTitle(String str) {
    }

    public void setCommentAreaVisibility(boolean z) {
    }

    public void setCommentContent(String str) {
    }

    public void setDefaultDriverIcon(int i) {
    }

    public void setOnCancelListener(IEvaluateView.OnCancelListener onCancelListener) {
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
    }

    public void setSymbol(String str) {
    }

    public void setTagTitle(String str, String str2) {
    }

    public void setTags(List<EvaluateTag> list) {
    }

    public void showHeader() {
    }

    public void showLoading() {
    }

    public void showLoadingFail(boolean z) {
    }

    public NewEvaluateView(Context context, int i) {
        this.f13364f = context;
        this.f13363L = i;
        this.mRootView = LayoutInflater.from(context).inflate(i == 1 ? R.layout.g_xp_evaluate_layout : R.layout.global_new_evaluate_layout, (ViewGroup) null);
        m9140a();
    }

    /* renamed from: a */
    private void m9140a() {
        this.f13365g = (ImageView) this.mRootView.findViewById(R.id.driver_image);
        this.f13366h = (TextView) this.mRootView.findViewById(R.id.evalute_refine_guide);
        this.f13367i = this.mRootView.findViewById(R.id.evalute_refine_guide_loading);
        this.f13369k = (NewFiveStarEvaluatedView) this.mRootView.findViewById(R.id.five_star_view);
        this.f13370l = (ImageView) this.mRootView.findViewById(R.id.five_star_mask);
        this.f13369k.setMargin(11);
        this.f13369k.setOnStarListener(this);
        this.f13371m = (FlexboxLayout) this.mRootView.findViewById(R.id.evaluate_tag_layout);
        this.f13378t = (LinearLayout) this.mRootView.findViewById(R.id.evaluate_tips_layout);
        this.f13361J = (FrameLayout) this.mRootView.findViewById(R.id.tip_container_fl);
        this.f13379u = (TextView) this.mRootView.findViewById(R.id.evaluate_tips_title);
        this.f13380v = (TextView) this.mRootView.findViewById(R.id.evaluate_tips_sub_title);
        this.f13362K = (RelativeLayout) this.mRootView.findViewById(R.id.tip_title_ll);
        this.f13384z = (ImageView) this.mRootView.findViewById(R.id.tip_edit_icon);
        this.f13381w = (LinearLayout) this.mRootView.findViewById(R.id.tips_container);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.f13368j = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewEvaluateView.this.close();
            }
        });
        this.f13372n = (RelativeLayout) this.mRootView.findViewById(R.id.load_layout);
        this.f13373o = (RelativeLayout) this.mRootView.findViewById(R.id.load_ing_icon_layout);
        this.f13374p = (RelativeLayout) this.mRootView.findViewById(R.id.load_success_icon_layout);
        this.f13375q = (ImageView) this.mRootView.findViewById(R.id.load_icon);
        this.f13376r = (TextView) this.mRootView.findViewById(R.id.load_text);
        this.f13382x = this.mRootView.findViewById(R.id.tips_bg);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.submit_btn);
        this.f13377s = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewEvaluateView.this.submit();
            }
        });
        this.f13377s.setEnabled(false);
        this.f13356E = (ScrollView) this.mRootView.findViewById(R.id.evaluate_comment_scroll_view);
        this.mEvaluateRoot = (EvaluateRootContainer) this.mRootView.findViewById(R.id.global_evaluate);
        NewCommentView newCommentView = (NewCommentView) this.mRootView.findViewById(R.id.new_evaluate_comment_view);
        this.mCommentView = newCommentView;
        newCommentView.setEnabled(false);
        this.mEvaluateRoot.setCanTouchView(R.id.oc_evaluate_comment_view);
        NewEvaluateScrollView newEvaluateScrollView = (NewEvaluateScrollView) this.mRootView.findViewById(R.id.evaluate_tag_scroll_view);
        this.f13360I = newEvaluateScrollView;
        newEvaluateScrollView.setMaxHeight(UIUtils.dip2pxInt(this.f13364f, 228.0f));
        m9150b();
        startKeyboardHeightDetector();
    }

    /* access modifiers changed from: protected */
    public void submit() {
        String str;
        if (this.f13354C != null) {
            NewCommentView newCommentView = this.mCommentView;
            if (newCommentView != null) {
                str = newCommentView.getText();
            } else {
                str = "";
            }
            LinearLayout linearLayout = this.f13381w;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                int i = 0;
                while (true) {
                    if (i >= this.f13381w.getChildCount()) {
                        break;
                    }
                    View childAt = this.f13381w.getChildAt(i);
                    if (childAt instanceof NewEvaluateTipsView) {
                        double tips = ((NewEvaluateTipsView) childAt).getTips();
                        if (childAt.isSelected() && tips > 0.0d) {
                            this.f13359H = tips + "";
                            break;
                        }
                    }
                    i++;
                }
            }
            this.f13354C.onSubmit(m9160e(), str, this.f13359H);
            showLoadingView();
            m9148a(str, m9160e(), this.f13359H);
        }
    }

    /* renamed from: a */
    private void m9148a(String str, List<EvaluateTag> list, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("rate", Integer.valueOf(this.f13369k.getCurrentStar()));
        String str3 = "";
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                str3 = str3 + list.get(i).getText();
                if (i < list.size() - 1) {
                    str3 = str3 + ";";
                }
            }
        }
        hashMap.put("tag", str3);
        hashMap.put("comment", str);
        hashMap.put("tip", str2);
        hashMap.put("source", Integer.valueOf(SourceUtils.getSource()));
        GlobalOmegaUtils.trackEvent("pas_starratecard_submit_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m9150b() {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(SourceUtils.getSource()));
        GlobalOmegaUtils.trackEvent("pas_starratecard_detail_sw", (Map<String, Object>) hashMap);
    }

    public void onRemove() {
        KeyboardHeightProvider keyboardHeightProvider = this.f13358G;
        if (keyboardHeightProvider != null) {
            keyboardHeightProvider.close();
        }
    }

    public void setLevel(int i) {
        NewFiveStarEvaluatedView newFiveStarEvaluatedView = this.f13369k;
        if (newFiveStarEvaluatedView != null) {
            newFiveStarEvaluatedView.setVisibility(0);
            this.f13369k.showEvaluated(i);
            m9155c(i);
        }
    }

    public void setDriverIconAndName(String str, String str2) {
        if (this.f13365g != null && !TextUtils.isEmpty(str)) {
            ImageUtils.glideLoad(this.f13365g.getContext(), str, this.f13365g);
        }
    }

    public void setCarEvaluateTags(List<CarNoEvaluateData.CarEvaluateTag> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        this.f13352A = arrayList;
        arrayList.addAll(list);
        onStarChanged(this.f13369k.getCurrentStar());
        hideLoadingView();
    }

    public void setRefineGuide(String str) {
        if (this.f13366h != null && !TextUtils.isEmpty(str)) {
            this.f13366h.setVisibility(0);
            this.f13367i.setVisibility(8);
            this.f13366h.setText(str);
        }
    }

    public void refreshThanksTipData(final CarTipInfo carTipInfo) {
        if (carTipInfo == null) {
            this.f13378t.setVisibility(8);
        } else if (!carTipInfo.isShow() || carTipInfo.feeItems == null || carTipInfo.feeItems.length <= 0) {
            this.f13378t.setVisibility(8);
        } else {
            this.f13378t.setVisibility(0);
            if (!carTipInfo.isPay()) {
                this.f13361J.setVisibility(0);
                this.f13381w.removeAllViews();
                this.f13378t.post(new Runnable() {
                    public void run() {
                        if (!carTipInfo.title.isEmpty() || !carTipInfo.tipSubTitle.isEmpty()) {
                            NewEvaluateView.this.f13362K.setVisibility(0);
                            if (!TextUtils.isEmpty(carTipInfo.title)) {
                                NewEvaluateView.this.f13379u.setVisibility(0);
                                NewEvaluateView.this.f13379u.setText(carTipInfo.title);
                            } else {
                                NewEvaluateView.this.f13379u.setVisibility(8);
                            }
                            if (!carTipInfo.tipSubTitle.isEmpty()) {
                                NewEvaluateView.this.f13380v.setVisibility(0);
                                NewEvaluateView.this.f13380v.setText(carTipInfo.tipSubTitle);
                            } else {
                                NewEvaluateView.this.f13380v.setVisibility(8);
                            }
                        } else {
                            NewEvaluateView.this.f13362K.setVisibility(8);
                        }
                        int width = NewEvaluateView.this.f13378t.getWidth() / carTipInfo.feeItems.length;
                        ((FrameLayout.LayoutParams) NewEvaluateView.this.f13382x.getLayoutParams()).width = width;
                        for (int i = 0; i < carTipInfo.feeItems.length; i++) {
                            CarTipInfo.FeeItem feeItem = carTipInfo.feeItems[i];
                            NewEvaluateTipsView newEvaluateTipsView = new NewEvaluateTipsView(NewEvaluateView.this.f13364f);
                            if (!carTipInfo.isShowCustomizeTip() || i != carTipInfo.feeItems.length - 1) {
                                newEvaluateTipsView.setCurrency(feeItem.currency);
                            } else if (feeItem.tipString.isEmpty()) {
                                feeItem.tipString = NewEvaluateView.this.f13364f.getString(R.string.GRider_starratePage_tip_options_other);
                            }
                            newEvaluateTipsView.setTips(feeItem.tipString, feeItem.tipNum);
                            NewEvaluateView.this.f13381w.addView(newEvaluateTipsView);
                            newEvaluateTipsView.setWidth(width);
                            newEvaluateTipsView.setIndex(i);
                            if (i == 0) {
                                newEvaluateTipsView.setLineVisibility(8);
                            } else {
                                newEvaluateTipsView.setLineVisibility(0);
                            }
                            newEvaluateTipsView.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    final View view2 = view;
                                    AutoTrackHelper.trackViewOnClick(view);
                                    NewEvaluateTipsView newEvaluateTipsView = (NewEvaluateTipsView) view2;
                                    int index = newEvaluateTipsView.getIndex();
                                    if (view.isSelected()) {
                                        if (NewEvaluateView.this.f13382x.getTag() != null) {
                                            NewEvaluateView.this.m9151b(((Integer) NewEvaluateView.this.f13382x.getTag()).intValue());
                                        }
                                        NewEvaluateView.this.f13382x.setVisibility(8);
                                        view2.setSelected(false);
                                        String unused = NewEvaluateView.this.f13359H = "";
                                        NewEvaluateView.this.m9145a(NewEvaluateView.this.f13377s, NewEvaluateView.this.f13364f.getString(R.string.global_new_evaluate_submit), 100);
                                        return;
                                    }
                                    if (NewEvaluateView.this.f13382x.getVisibility() == 0) {
                                        for (int i = 0; i < NewEvaluateView.this.f13381w.getChildCount(); i++) {
                                            View childAt = NewEvaluateView.this.f13381w.getChildAt(i);
                                            if ((childAt instanceof NewEvaluateTipsView) && childAt.isSelected()) {
                                                childAt.setSelected(false);
                                            }
                                        }
                                        if (NewEvaluateView.this.f13382x.getTag() != null) {
                                            NewEvaluateView.this.m9151b(((Integer) NewEvaluateView.this.f13382x.getTag()).intValue());
                                        }
                                    }
                                    if (carTipInfo.isShowCustomizeTip() && index == carTipInfo.feeItems.length - 1) {
                                        View inflate = LayoutInflater.from(NewEvaluateView.this.f13364f).inflate(R.layout.global_new_evaluate_custom_tip, (ViewGroup) null);
                                        double tips = newEvaluateTipsView.getTips();
                                        String tipText = newEvaluateTipsView.getTipText();
                                        new TipInputPopWindow(inflate, -1, -1, NewEvaluateView.this.f13364f, carTipInfo, tips, tipText, new TipInputPopWindow.ConfirmButtonClickListener() {
                                            public void confirmClick(String str, Double d) {
                                                if (!str.isEmpty()) {
                                                    NewEvaluateView newEvaluateView = NewEvaluateView.this;
                                                    String unused = newEvaluateView.f13359H = d + "";
                                                    NewEvaluateView.this.f13382x.setX(view2.getX());
                                                    ((NewEvaluateTipsView) view2).setTips(str, d.doubleValue());
                                                    ((NewEvaluateTipsView) view2).setCurrency(carTipInfo.currency);
                                                    view2.setSelected(true);
                                                    NewEvaluateView.this.f13384z.setVisibility(0);
                                                    NewEvaluateView.this.m9145a(NewEvaluateView.this.f13377s, NewEvaluateView.this.f13364f.getString(R.string.global_new_evaluate_submit_with_tips), 100);
                                                    return;
                                                }
                                                NewEvaluateView.this.f13382x.setX(view2.getX());
                                                view2.setSelected(true);
                                            }
                                        }).show();
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("source", "starratedetail");
                                        if (tips == 0.0d) {
                                            hashMap.put("type", "0");
                                        } else {
                                            hashMap.put("type", "1");
                                        }
                                        GlobalOmegaUtils.trackEvent("ibt_gp_starratecard_detai_tipmount_ck", (Map<String, Object>) hashMap);
                                    }
                                    NewEvaluateView.this.f13382x.setX(view.getX());
                                    view2.setSelected(true);
                                    double tips2 = newEvaluateTipsView.getTips();
                                    NewEvaluateView newEvaluateView = NewEvaluateView.this;
                                    String unused2 = newEvaluateView.f13359H = tips2 + "";
                                    NewEvaluateView.this.m9141a(index);
                                    NewEvaluateView.this.f13382x.setTag(Integer.valueOf(index));
                                    if (!(NewEvaluateView.this.f13359H == null || NewEvaluateView.this.f13359H.isEmpty() || tips2 == 0.0d)) {
                                        NewEvaluateView.this.m9145a(NewEvaluateView.this.f13377s, NewEvaluateView.this.f13364f.getString(R.string.global_new_evaluate_submit_with_tips), 100);
                                    }
                                    NewEvaluateView.this.f13382x.setVisibility(0);
                                }
                            });
                        }
                    }
                });
                return;
            }
            this.f13361J.setVisibility(8);
            if (!TextUtils.isEmpty(carTipInfo.title)) {
                this.f13379u.setText(carTipInfo.title);
            }
            if (!carTipInfo.tipSubTitle.isEmpty()) {
                this.f13380v.setVisibility(0);
                this.f13380v.setText(carTipInfo.tipSubTitle);
                return;
            }
            this.f13380v.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9141a(int i) {
        if (i < this.f13381w.getChildCount()) {
            ((NewEvaluateTipsView) this.f13381w.getChildAt(i)).setLineVisibility(8);
        }
        int i2 = i + 1;
        if (i2 < this.f13381w.getChildCount()) {
            ((NewEvaluateTipsView) this.f13381w.getChildAt(i2)).setLineVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9151b(int i) {
        if (i != 0 && i < this.f13381w.getChildCount()) {
            ((NewEvaluateTipsView) this.f13381w.getChildAt(i)).setLineVisibility(0);
        }
        int i2 = i + 1;
        if (i2 < this.f13381w.getChildCount()) {
            ((NewEvaluateTipsView) this.f13381w.getChildAt(i2)).setLineVisibility(0);
        }
    }

    /* renamed from: a */
    private void m9143a(final View view, final float f, final AnimateFinishListener animateFinishListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(view.getX(), f, 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.clearAnimation();
                View view = view;
                view.layout((int) f, view.getTop(), ((int) f) + view.getWidth(), view.getBottom());
                AnimateFinishListener animateFinishListener = animateFinishListener;
                if (animateFinishListener != null) {
                    animateFinishListener.onFinish();
                }
            }
        });
        view.startAnimation(translateAnimation);
    }

    /* renamed from: a */
    private void m9142a(final View view, float f, float f2) {
        view.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(f, f2, 0.0f, 0.0f);
        translateAnimation.setDuration(1000);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
            }
        });
        view.startAnimation(translateAnimation);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9145a(final TextView textView, String str, int i) {
        String charSequence = textView.getText().toString();
        if (!charSequence.endsWith(str)) {
            int abs = Math.abs(charSequence.length() - str.length());
            int i2 = i / abs;
            if (charSequence.length() > str.length()) {
                int i3 = 0;
                while (i3 <= abs) {
                    final String substring = charSequence.substring(0, charSequence.length() - i3);
                    i3++;
                    textView.postDelayed(new Runnable() {
                        public void run() {
                            textView.setText(substring);
                        }
                    }, (long) (i2 * i3));
                }
            } else if (charSequence.length() < str.length()) {
                int i4 = 0;
                while (i4 <= abs) {
                    final String substring2 = str.substring(0, charSequence.length() + i4);
                    i4++;
                    textView.postDelayed(new Runnable() {
                        public void run() {
                            textView.setText(substring2);
                        }
                    }, (long) (i2 * i4));
                }
            }
        }
    }

    public void setEvaluateListener(IEvaluateView.EvaluateListener evaluateListener) {
        this.f13354C = evaluateListener;
    }

    public void showSubmitSuccess() {
        if (TextUtils.isEmpty(this.f13359H)) {
            m9144a((View) this.f13373o, (View) this.f13374p, (SubmitSuccessListener) new SubmitSuccessListener() {
                public void onSuccess() {
                    NewEvaluateView.this.f13376r.setVisibility(0);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public void run() {
                            if (NewEvaluateView.this.mOnCloseListener != null) {
                                NewEvaluateView.this.mOnCloseListener.onCloseWithOutOmega();
                            }
                        }
                    }, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
                }
            });
            return;
        }
        IEvaluateView.OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onCloseWithOutOmega();
        }
    }

    public void showSubmitFail() {
        hideLoadingView();
    }

    public void showLoadingView() {
        this.f13372n.setVisibility(0);
        this.f13377s.setVisibility(8);
        this.f13376r.setVisibility(8);
        m9154c();
    }

    public void hideLoadingView() {
        this.f13372n.setVisibility(8);
        this.f13377s.setVisibility(0);
    }

    /* renamed from: c */
    private void m9154c() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(10);
        this.f13375q.setAnimation(rotateAnimation);
    }

    public void setOnCloseListener(IEvaluateView.OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void close() {
        NewCommentView newCommentView;
        NewCommentView newCommentView2 = this.mCommentView;
        if (newCommentView2 != null && newCommentView2.isFocused()) {
            this.mCommentView.clearFocus();
        } else if (m9160e().size() > 0 || ((newCommentView = this.mCommentView) != null && !TextUtils.isEmpty(newCommentView.getText()))) {
            showBackDialog(true);
        } else {
            IEvaluateView.OnCloseListener onCloseListener = this.mOnCloseListener;
            if (onCloseListener != null) {
                onCloseListener.onClose();
            }
        }
    }

    public void closeWithoutOmega() {
        NewCommentView newCommentView;
        if (m9160e().size() > 0 || ((newCommentView = this.mCommentView) != null && !TextUtils.isEmpty(newCommentView.getText()))) {
            showBackDialog(false);
            return;
        }
        IEvaluateView.OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onCloseWithOutOmega();
        }
    }

    public void onResume() {
        this.f13358G.setKeyboardHeightObserver(this.mHeightObserver);
    }

    public void onPause() {
        this.f13358G.setKeyboardHeightObserver((KeyboardHeightProvider.KeyboardHeightObserver) null);
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(IPresenter iPresenter) {
        this.mAbsEvaluatePresenter = (AbsCommonEvaluatePresenter) iPresenter;
    }

    public void onStarChanged(int i) {
        this.mAbsEvaluatePresenter.setOrderLevel(i);
        List<CarNoEvaluateData.CarEvaluateTag> list = this.f13352A;
        if (list != null) {
            for (CarNoEvaluateData.CarEvaluateTag next : list) {
                if (next.level == i) {
                    this.f13353B = next;
                    m9157d();
                }
            }
        }
        m9158d(i);
        if (i == 5) {
            m9142a((View) this.f13370l, this.f13369k.getX() - ((float) this.f13370l.getWidth()), this.f13369k.getX() + ((float) this.f13369k.getWidth()));
        }
    }

    /* renamed from: c */
    private void m9155c(int i) {
        AbsBaseTagLayout absBaseTagLayout;
        this.f13371m.removeAllViews();
        int i2 = i >= 5 ? 6 : 7;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i == 5) {
                absBaseTagLayout = new EvaluateTagImageLayout(this.f13364f);
                if ((i3 + 1) % 3 == 0) {
                    absBaseTagLayout.setMarginRight(0);
                }
            } else {
                absBaseTagLayout = new EvaluateTagTextLayout(this.f13364f);
                absBaseTagLayout.setLoadingWidth(UIUtils.dip2pxInt(this.f13364f, f13350d[i3]));
            }
            absBaseTagLayout.setLoading(true);
            this.f13371m.addView(absBaseTagLayout);
        }
    }

    /* renamed from: d */
    private void m9157d() {
        AbsBaseTagLayout absBaseTagLayout;
        this.f13355D = true;
        setRefineGuide(this.f13353B.refine_guide);
        this.f13371m.removeAllViews();
        for (int i = 0; i < this.f13353B.tag_list.size(); i++) {
            CarNoEvaluateData.EvaluateTagImpl evaluateTagImpl = this.f13353B.tag_list.get(i);
            if (this.f13353B.level == 5) {
                absBaseTagLayout = new EvaluateTagImageLayout(this.f13364f);
            } else {
                absBaseTagLayout = new EvaluateTagTextLayout(this.f13364f);
                absBaseTagLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (NewEvaluateView.this.m9160e().size() > 0 || !TextUtils.isEmpty(NewEvaluateView.this.mCommentView.getText())) {
                            NewEvaluateView.this.f13377s.setEnabled(true);
                        } else {
                            NewEvaluateView.this.f13377s.setEnabled(false);
                        }
                    }
                });
            }
            absBaseTagLayout.setTagModel(evaluateTagImpl);
            this.f13371m.addView(absBaseTagLayout);
        }
        m9158d(this.f13353B.level);
        this.mCommentView.setEnabled(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public List<EvaluateTag> m9160e() {
        CarNoEvaluateData.EvaluateTagImpl tagModel;
        ArrayList arrayList = new ArrayList();
        if (this.f13371m != null) {
            for (int i = 0; i < this.f13371m.getChildCount(); i++) {
                View childAt = this.f13371m.getChildAt(i);
                if (childAt instanceof AbsBaseTagLayout) {
                    AbsBaseTagLayout absBaseTagLayout = (AbsBaseTagLayout) childAt;
                    if (absBaseTagLayout.isSelected() && (tagModel = absBaseTagLayout.getTagModel()) != null) {
                        arrayList.add(new EvaluateTag(tagModel.getText(), tagModel.getId(), tagModel.getIcon()));
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private void m9158d(int i) {
        if (i < 5 || !this.f13355D) {
            this.f13377s.setEnabled(false);
        } else {
            this.f13377s.setEnabled(true);
        }
    }

    /* renamed from: a */
    private void m9144a(final View view, final View view2, final SubmitSuccessListener submitSuccessListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
                view2.setVisibility(0);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(300);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        if (submitSuccessListener != null) {
                            submitSuccessListener.onSuccess();
                        }
                    }
                });
                view2.startAnimation(scaleAnimation);
            }
        });
        view.startAnimation(scaleAnimation);
    }

    public void showBackDialog(final boolean z) {
        PopupWindow popupWindow = this.f13383y;
        if (popupWindow == null || !popupWindow.isShowing()) {
            int windowHeight = this.f13364f.getApplicationInfo().targetSdkVersion >= 22 ? -1 : UiUtils.getWindowHeight((Activity) this.mRootView.getContext());
            View inflate = LayoutInflater.from(getView().getContext()).inflate(R.layout.global_new_evaluate_close_dialog_layout, (ViewGroup) null);
            PopupWindow popupWindow2 = new PopupWindow(inflate, -1, windowHeight);
            this.f13383y = popupWindow2;
            popupWindow2.setSoftInputMode(16);
            this.f13383y.setOutsideTouchable(false);
            this.f13383y.setClippingEnabled(false);
            this.f13383y.setFocusable(true);
            int navigationBarHeight = UiUtils.getNavigationBarHeight(this.f13364f);
            if (this.f13363L == 1) {
                inflate.findViewById(R.id.ll_g_close_dialog_container).setBackgroundResource(R.drawable.g_xp_evaluate_background);
            }
            ((TextView) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    NewEvaluateView.this.f13383y.dismiss();
                }
            });
            ((TextView) inflate.findViewById(R.id.ok_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    NewEvaluateView.this.f13383y.dismiss();
                    if (NewEvaluateView.this.mOnCloseListener == null) {
                        return;
                    }
                    if (z) {
                        NewEvaluateView.this.mOnCloseListener.onClose();
                    } else {
                        NewEvaluateView.this.mOnCloseListener.onCloseWithOutOmega();
                    }
                }
            });
            this.f13383y.showAtLocation(this.mRootView, 80, 0, navigationBarHeight);
        }
    }

    /* access modifiers changed from: protected */
    public void clearCommentViewFocus() {
        NewCommentView newCommentView = this.mCommentView;
        if (newCommentView != null && newCommentView.isFocused()) {
            this.mCommentView.clearFocus();
        }
    }

    /* access modifiers changed from: protected */
    public void startKeyboardHeightDetector() {
        KeyboardHeightProvider keyboardHeightProvider = new KeyboardHeightProvider((Activity) this.f13364f);
        this.f13358G = keyboardHeightProvider;
        keyboardHeightProvider.start();
    }

    public int getStyle() {
        return this.f13363L;
    }
}
