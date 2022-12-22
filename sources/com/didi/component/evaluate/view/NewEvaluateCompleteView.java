package com.didi.component.evaluate.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.ImageUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.loading.OnRetryListener;
import com.didi.component.core.IPresenter;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.component.evaluate.presenter.AbsCommonEvaluatePresenter;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.component.evaluate.view.widget.AbsBaseTagLayout;
import com.didi.component.evaluate.view.widget.EvaluateTagImageLayout;
import com.didi.component.evaluate.view.widget.EvaluateTagTextLayout;
import com.didi.component.evaluate.view.widget.NewFiveStarEvaluatedView;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.android.flexbox.FlexboxLayout;
import com.taxis99.R;
import java.util.List;

public class NewEvaluateCompleteView extends AbsNewEvaluateView implements IEvaluateView {

    /* renamed from: a */
    private static final int f13332a = 4;

    /* renamed from: b */
    private Context f13333b;

    /* renamed from: c */
    private ImageView f13334c;

    /* renamed from: d */
    private TextView f13335d;

    /* renamed from: e */
    private TextView f13336e;

    /* renamed from: f */
    private LinearLayout f13337f;

    /* renamed from: g */
    private TextView f13338g;

    /* renamed from: h */
    private TextView f13339h;

    /* renamed from: i */
    private LinearLayout f13340i;

    /* renamed from: j */
    private ImageView f13341j;

    /* renamed from: k */
    private NewFiveStarEvaluatedView f13342k;

    /* renamed from: l */
    private FlexboxLayout f13343l;

    /* renamed from: m */
    private NewEvaluateScrollView f13344m;
    protected IEvaluateView.OnCloseListener mOnCloseListener;

    /* renamed from: n */
    private int f13345n = 0;

    public void hideLoading() {
    }

    public void initIsInFiveStar(boolean z) {
    }

    public void onAdd() {
    }

    public void onPause() {
    }

    public void onRemove() {
    }

    public void onResume() {
    }

    public void setCarEvaluateTags(List<CarNoEvaluateData.CarEvaluateTag> list) {
    }

    public void setCardTitle(String str) {
    }

    public void setCommentAreaVisibility(boolean z) {
    }

    public void setDefaultDriverIcon(int i) {
    }

    public void setEvaluateListener(IEvaluateView.EvaluateListener evaluateListener) {
    }

    public void setOnCancelListener(IEvaluateView.OnCancelListener onCancelListener) {
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
    }

    public void setSymbol(String str) {
    }

    public void setTagTitle(String str, String str2) {
    }

    public void showHeader() {
    }

    public void showLoading() {
    }

    public void showLoadingFail(boolean z) {
    }

    public void showSubmitFail() {
    }

    public void showSubmitSuccess() {
    }

    public NewEvaluateCompleteView(Context context, int i) {
        this.f13333b = context;
        this.f13345n = i;
        this.mRootView = LayoutInflater.from(context).inflate(i == 1 ? R.layout.g_xp_evaluate_complete_layout : R.layout.global_new_evaluate_complete_layout, (ViewGroup) null);
        m9136a();
    }

    /* renamed from: a */
    private void m9136a() {
        this.f13334c = (ImageView) this.mRootView.findViewById(R.id.driver_image);
        this.f13335d = (TextView) this.mRootView.findViewById(R.id.evalute_refine_guide);
        this.f13336e = (TextView) this.mRootView.findViewById(R.id.evaluate_content);
        this.f13337f = (LinearLayout) this.mRootView.findViewById(R.id.evaluate_content_layout);
        this.f13338g = (TextView) this.mRootView.findViewById(R.id.tips_fee);
        this.f13339h = (TextView) this.mRootView.findViewById(R.id.tips_currency);
        this.f13340i = (LinearLayout) this.mRootView.findViewById(R.id.evaluate_tips_layout);
        NewFiveStarEvaluatedView newFiveStarEvaluatedView = (NewFiveStarEvaluatedView) this.mRootView.findViewById(R.id.five_star_view);
        this.f13342k = newFiveStarEvaluatedView;
        newFiveStarEvaluatedView.setMargin(4);
        this.f13342k.setEnable(false);
        this.f13342k.setIsHideUnselect(true);
        this.f13343l = (FlexboxLayout) this.mRootView.findViewById(R.id.evaluate_tag_layout);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.f13341j = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewEvaluateCompleteView.this.mOnCloseListener != null) {
                    NewEvaluateCompleteView.this.mOnCloseListener.onClose();
                }
            }
        });
        NewEvaluateScrollView newEvaluateScrollView = (NewEvaluateScrollView) this.mRootView.findViewById(R.id.evaluate_scroll_view);
        this.f13344m = newEvaluateScrollView;
        newEvaluateScrollView.setMaxHeight(UIUtils.getScreenWidth(this.f13333b));
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            setDriverIconAndName(order.carDriver.avatarUrl, order.carDriver.name);
        }
    }

    public void setLevel(int i) {
        NewFiveStarEvaluatedView newFiveStarEvaluatedView = this.f13342k;
        if (newFiveStarEvaluatedView != null) {
            newFiveStarEvaluatedView.setVisibility(0);
            this.f13342k.showEvaluated(i);
        }
    }

    public void setDriverIconAndName(String str, String str2) {
        if (this.f13334c != null && !TextUtils.isEmpty(str)) {
            ImageUtils.glideLoad(this.f13334c.getContext(), str, this.f13334c);
        }
    }

    public void setTags(List<EvaluateTag> list) {
        AbsBaseTagLayout absBaseTagLayout;
        this.f13343l.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            EvaluateTag evaluateTag = list.get(i);
            if (this.f13342k.getCurrentStar() == 5) {
                absBaseTagLayout = new EvaluateTagImageLayout(this.f13333b);
            } else {
                absBaseTagLayout = new EvaluateTagTextLayout(this.f13333b);
            }
            absBaseTagLayout.setTagModel(evaluateTag);
            absBaseTagLayout.setSelected(true);
            absBaseTagLayout.setEnable(false);
            this.f13343l.addView(absBaseTagLayout);
        }
    }

    public void setCommentContent(String str) {
        if (this.f13336e != null && !TextUtils.isEmpty(str)) {
            this.f13336e.setText(str);
            this.f13337f.setVisibility(0);
        }
    }

    public void setRefineGuide(String str) {
        if (this.f13335d != null && !TextUtils.isEmpty(str)) {
            this.f13335d.setText(str);
        }
    }

    public void refreshThanksTipData(CarTipInfo carTipInfo) {
        if (carTipInfo != null && this.f13338g != null && carTipInfo.isShow() && carTipInfo.isPay()) {
            if (TextUtils.isEmpty(carTipInfo.msg)) {
                this.f13340i.setVisibility(8);
                return;
            }
            this.f13340i.setVisibility(0);
            String str = carTipInfo.msg;
            String a = m9135a(str, "(", ")");
            String a2 = m9135a(str, Const.joLeft, "}");
            this.f13339h.setText(a);
            this.f13338g.setText(a2);
        }
    }

    /* renamed from: a */
    private String m9135a(String str, String str2, String str3) {
        return str.substring(str.indexOf(str2) + 1, str.indexOf(str3));
    }

    public void setOnCloseListener(IEvaluateView.OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void close() {
        IEvaluateView.OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onClose();
        }
    }

    public void closeWithoutOmega() {
        IEvaluateView.OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onCloseWithOutOmega();
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(IPresenter iPresenter) {
        this.mAbsEvaluatePresenter = (AbsCommonEvaluatePresenter) iPresenter;
    }

    public int getStyle() {
        return this.f13345n;
    }
}
