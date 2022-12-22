package com.didi.component.estimate.newui.view.vertical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.VerticalDataUpdateEvent;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.widget.NewBubbleHelper;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.estimate.model.EstimateState;
import com.didi.component.estimate.newui.presenter.NewEstimatePresenter;
import com.didi.component.estimate.newui.view.CarEstimateOptionsView;
import com.didi.component.estimate.newui.view.IV2EstimateView;
import com.didi.component.estimate.newui.view.NewCarDetailPopUp;
import com.didi.component.estimate.newui.view.NewEstimateAbnormalView;
import com.didi.component.estimate.newui.view.NewEstimateMessageView;
import com.didi.component.estimate.newui.view.one.NewEstimateChooseOneCarView;
import com.didi.component.estimate.newui.view.vertical.VerticalSelectAnimation;
import com.didi.component.estimate.newui.view.viewholder.ItemClickListener;
import com.didi.component.estimate.presenter.AbsEstimatePresenter;
import com.didi.component.utils.EstimateTrackEventUtils;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.DebugUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.estimate.CarDetailInfoListModel;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.didi.travel.psnger.model.response.estimate.EstimateAbnormalModel;
import com.didi.travel.psnger.model.response.estimate.EstimateGlobalConfigModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NewVerticalEstimateView implements IViewContainer, IV2EstimateView {
    public static final int DETAIL_SOURCE_ONE_CAR = 2;
    public static final int DETAIL_SOURCE_RECOMMEND = 1;

    /* renamed from: a */
    private static final String f13156a = "NewVerticalEstimate";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f13157A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final ViewTreeObserver.OnGlobalLayoutListener f13158B = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (NewVerticalEstimateView.this.f13168k != null && NewVerticalEstimateView.this.f13173p != null) {
                int height = NewVerticalEstimateView.this.f13173p.getHeight() + UiUtils.dip2px(NewVerticalEstimateView.this.f13165h, 22.0f);
                if (NewVerticalEstimateView.this.f13178u) {
                    height += NewVerticalEstimateView.this.f13170m.messageMargin();
                }
                NewVerticalEstimateView.this.f13168k.setOneCarItemHeight(NewVerticalEstimateView.this.f13165h, height, NewVerticalEstimateView.this.f13178u);
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, Integer.valueOf(height + CardHeightConstant.BOTTOM_CONFIRM_LAYOUT_HEIGHT));
                NewVerticalEstimateView.this.f13173p.getViewTreeObserver().removeOnGlobalLayoutListener(NewVerticalEstimateView.this.f13158B);
            }
        }
    };

    /* renamed from: b */
    private boolean f13159b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecyclerView f13160c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RecommendVerticalAdapter f13161d;

    /* renamed from: e */
    private RecyclerView f13162e;

    /* renamed from: f */
    private AllVerticalAdapter f13163f;

    /* renamed from: g */
    private View f13164g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Context f13165h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final ViewGroup f13166i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AbsEstimatePresenter<?> f13167j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public NewEstimatePresenter f13168k;

    /* renamed from: l */
    private ImageView f13169l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public NewEstimateMessageView f13170m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ConstraintLayout f13171n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public NewEstimateAbnormalView f13172o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public NewEstimateChooseOneCarView f13173p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CarEstimateOptionsView f13174q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public VerticalSelectAnimation f13175r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public View f13176s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f13177t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f13178u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Space f13179v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public LEGOBubble f13180w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public LEGOBubble f13181x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public NewBubbleHelper f13182y;

    /* renamed from: z */
    private boolean f13183z = true;

    public static class CardHeightConstant {
        public static final int BOTTOM_CONFIRM_LAYOUT_HEIGHT = UiUtils.dip2px(DIDIApplication.getAppContext(), 129.0f);
    }

    public NewVerticalEstimateView(Context context, ViewGroup viewGroup) {
        this.f13165h = (Context) Objects.requireNonNull(context);
        this.f13166i = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.global_new_estimate_vertical, viewGroup, false);
        m8942a();
        m8949b();
    }

    public void showLoading() {
        this.f13183z = true;
        if (this.f13177t) {
            this.f13173p.showLoading();
            EstimateState.INSTANCE.setInOneCarPage(true);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            EstimateItemModel estimateItemModel = new EstimateItemModel();
            estimateItemModel.viewType = 12;
            if (i == 0) {
                estimateItemModel.viewType = 13;
                estimateItemModel.isSelected = true;
            }
            arrayList.add(estimateItemModel);
        }
        RecommendVerticalAdapter recommendVerticalAdapter = this.f13161d;
        if (recommendVerticalAdapter != null) {
            recommendVerticalAdapter.setData(arrayList);
        }
        this.f13160c.setVisibility(0);
        this.f13162e.setVisibility(8);
        this.f13164g.setVisibility(8);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_BOTTOM);
        this.f13170m.reset();
        hideMessageView();
        this.f13175r.resetShadow();
        UiThreadHandler.post(new Runnable() {
            public void run() {
                if (NewVerticalEstimateView.this.f13168k != null) {
                    NewVerticalEstimateView.this.f13168k.setRecommendItemHeight(NewVerticalEstimateView.this.m8951c(), false, false);
                }
            }
        });
        EstimateState.INSTANCE.setInOneCarPage(false);
    }

    public void hideLoading() {
        this.f13183z = false;
        if (this.f13177t) {
            this.f13173p.hideLoading();
        }
    }

    public void dismissTips() {
        closeTipBubble();
    }

    /* renamed from: a */
    private void m8942a() {
        this.f13171n = (ConstraintLayout) this.f13166i.findViewById(R.id.new_estimate_real_data_container);
        this.f13179v = (Space) this.f13166i.findViewById(R.id.space);
        this.f13176s = this.f13166i.findViewById(R.id.new_estimate_magnifier);
        this.f13172o = (NewEstimateAbnormalView) this.f13166i.findViewById(R.id.new_estimate_abnormal);
        this.f13160c = (RecyclerView) this.f13166i.findViewById(R.id.new_estimate_recommend_list);
        this.f13162e = (RecyclerView) this.f13166i.findViewById(R.id.new_estimate_all_list);
        this.f13164g = this.f13166i.findViewById(R.id.new_estimate_list_empty_view);
        this.f13169l = (ImageView) this.f13166i.findViewById(R.id.bb_pull_up_view);
        this.f13173p = (NewEstimateChooseOneCarView) this.f13166i.findViewById(R.id.new_estimate_one_car_view);
        NewEstimateMessageView newEstimateMessageView = (NewEstimateMessageView) this.f13166i.findViewById(R.id.new_estimate_guide_list);
        this.f13170m = newEstimateMessageView;
        newEstimateMessageView.setMessageViewClickListener(new NewEstimateMessageView.MessageViewClickListener() {
            public void onTransferFlowItemClick(int i) {
            }

            public void onTransferFlowCloseClick(CarMessageModel carMessageModel) {
                if (NewVerticalEstimateView.this.f13177t) {
                    NewVerticalEstimateView.this.f13168k.setOneCarItemHeight(NewVerticalEstimateView.this.f13165h, NewVerticalEstimateView.this.f13173p.getHeight(), false);
                    return;
                }
                NewEstimatePresenter a = NewVerticalEstimateView.this.f13168k;
                NewVerticalEstimateView newVerticalEstimateView = NewVerticalEstimateView.this;
                a.setRecommendItemHeight(newVerticalEstimateView.m8940a(newVerticalEstimateView.f13168k.recommendsList), false, true);
            }
        });
        this.f13174q = (CarEstimateOptionsView) this.f13166i.findViewById(R.id.new_estimate_horizontal_operation_list);
        C54953 r0 = new ItemClickListener() {
            public void itemClick(EstimateItemModel estimateItemModel, int i, boolean z) {
                if (NewVerticalEstimateView.this.f13168k == null) {
                    return;
                }
                if (estimateItemModel.isSelected) {
                    NewVerticalEstimateView.this.showDetailPop(estimateItemModel, z, 1);
                    return;
                }
                NewVerticalEstimateView newVerticalEstimateView = NewVerticalEstimateView.this;
                newVerticalEstimateView.setRecommendData(newVerticalEstimateView.f13168k.updateRecommendsByModel(estimateItemModel, false), NewVerticalEstimateView.this.f13168k.getAllModels(), NewVerticalEstimateView.this.f13168k.getSelectModel(), NewVerticalEstimateView.this.f13168k.globalConfigModel);
                NewVerticalEstimateView.this.f13160c.smoothScrollToPosition(i);
                NewVerticalEstimateView.this.sendEventChangeSelectCar();
            }
        };
        C54964 r1 = new ItemClickListener() {
            public void itemClick(EstimateItemModel estimateItemModel, int i, boolean z) {
                if (NewVerticalEstimateView.this.f13168k != null) {
                    boolean unused = NewVerticalEstimateView.this.f13177t = true;
                    NewVerticalEstimateView newVerticalEstimateView = NewVerticalEstimateView.this;
                    newVerticalEstimateView.setRecommendData(newVerticalEstimateView.f13168k.updateRecommendsByModel(estimateItemModel, false), NewVerticalEstimateView.this.f13168k.getAllModels(), NewVerticalEstimateView.this.f13168k.getSelectModel(), NewVerticalEstimateView.this.f13168k.globalConfigModel);
                    EstimateState.INSTANCE.setInOneCarPage(true);
                }
            }
        };
        this.f13161d = new RecommendVerticalAdapter(this.f13165h, r0);
        this.f13160c.setLayoutManager(new LinearLayoutManager(this.f13165h, 1, false));
        this.f13160c.setAdapter(this.f13161d);
        this.f13160c.setHasFixedSize(true);
        this.f13160c.setNestedScrollingEnabled(false);
        this.f13160c.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    EstimateTrackEventUtils.trackConfirmModeSwitch();
                }
            }
        });
        this.f13163f = new AllVerticalAdapter(this.f13165h, r1);
        this.f13162e.setLayoutManager(new LinearLayoutManager(this.f13165h, 1, false));
        this.f13162e.setAdapter(this.f13163f);
        this.f13162e.setHasFixedSize(true);
        this.f13162e.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    EstimateTrackEventUtils.trackConfirmModeSwitch();
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                NewVerticalEstimateView.this.closeTipBubble();
            }
        });
        this.f13166i.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewDetachedFromWindow(View view) {
            }

            public void onViewAttachedToWindow(View view) {
                if (NewVerticalEstimateView.this.f13166i != null && (NewVerticalEstimateView.this.f13166i.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) NewVerticalEstimateView.this.f13166i.getParent()).setClipToPadding(false);
                    ((ViewGroup) NewVerticalEstimateView.this.f13166i.getParent()).setClipChildren(false);
                }
            }
        });
        setVerticalView();
    }

    public void setVerticalView() {
        this.f13169l.setVisibility(0);
        this.f13174q.setVisibility(8);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_VERTICAL_DATA_UPDATE, new VerticalDataUpdateEvent(m8940a((List<EstimateItemModel>) null), CardHeightConstant.BOTTOM_CONFIRM_LAYOUT_HEIGHT, true, false));
        VerticalSelectAnimation verticalSelectAnimation = new VerticalSelectAnimation(this.f13165h);
        this.f13175r = verticalSelectAnimation;
        verticalSelectAnimation.setAnimationEndCallBack(new VerticalSelectAnimation.SelectAnimationEndCallBack() {
            public void selectAnimationEnd() {
                if (!NewVerticalEstimateView.this.f13157A) {
                    NewVerticalEstimateView.this.m8954d();
                }
            }
        });
        this.f13175r.setRecyclerView(this.f13160c, this.f13161d, this.f13176s, this.f13171n);
        this.f13161d.setVerticalSelectAnimation(this.f13175r);
        this.f13170m.setCarRecyclerView(this.f13160c);
        this.f13170m.setType(1);
    }

    /* renamed from: b */
    private void m8949b() {
        this.f13172o.setClickListener(new NewEstimateAbnormalView.BtnClickListener() {
            public void click() {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM);
                NewVerticalEstimateView.this.f13171n.setVisibility(0);
                NewVerticalEstimateView.this.m8946a(true);
                NewVerticalEstimateView.this.showLoading();
                NewVerticalEstimateView.this.f13172o.setVisibility(8);
                NewVerticalEstimateView.this.f13167j.reEstimate();
            }
        });
        this.f13173p.setSelectItemListener(new NewEstimateChooseOneCarView.SelectItemListener() {
            public void selectItem(EstimateItemModel estimateItemModel, boolean z) {
                NewVerticalEstimateView.this.showDetailPop(estimateItemModel, z, 2);
            }
        });
    }

    public void setRecommendData(List<EstimateItemModel> list, List<EstimateItemModel> list2, EstimateItemModel estimateItemModel, EstimateGlobalConfigModel estimateGlobalConfigModel) {
        this.f13172o.setVisibility(8);
        this.f13162e.setVisibility(0);
        this.f13164g.setVisibility(0);
        this.f13171n.setVisibility(0);
        m8946a(true);
        try {
            for (EstimateItemModel estimateItemModel2 : list2) {
                estimateItemModel2.viewType = 1;
            }
            for (EstimateItemModel estimateItemModel3 : list) {
                estimateItemModel3.viewType = 2;
            }
            m8945a(list, list2, estimateItemModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8944a(EstimateItemModel estimateItemModel, AbsEstimatePresenter<?> absEstimatePresenter) {
        this.f13177t = true;
        EstimateState.INSTANCE.setInOneCarPage(true);
        estimateItemModel.isSelected = true;
        this.f13160c.setVisibility(8);
        this.f13162e.setVisibility(8);
        this.f13164g.setVisibility(8);
        this.f13169l.setVisibility(8);
        m8946a(false);
        this.f13173p.setVisibility(0);
        this.f13159b = true;
        this.f13173p.setData(estimateItemModel, absEstimatePresenter);
        this.f13174q.setData(estimateItemModel);
        this.f13178u = this.f13170m.setMessageData((List<EstimateItemModel>) null, estimateItemModel, true);
        this.f13173p.getViewTreeObserver().addOnGlobalLayoutListener(this.f13158B);
        this.f13168k.mOneCarItemModel = estimateItemModel;
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.EVENT_ESTIMATE_IS_ONE_CAR, true);
    }

    /* renamed from: a */
    private void m8945a(final List<EstimateItemModel> list, List<EstimateItemModel> list2, EstimateItemModel estimateItemModel) {
        if (this.f13177t) {
            m8944a(estimateItemModel, this.f13167j);
            return;
        }
        final boolean z = false;
        EstimateState.INSTANCE.setInOneCarPage(false);
        this.f13175r.setItemModel(estimateItemModel, this.f13168k.getLastSelectedItemModel());
        this.f13161d.setData(list);
        this.f13163f.setData(list2);
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            z = this.f13170m.setMessageData(list, estimateItemModel, false);
        }
        this.f13166i.post(new Runnable() {
            public void run() {
                if (NewVerticalEstimateView.this.f13168k != null) {
                    NewVerticalEstimateView.this.f13168k.setRecommendItemHeight(NewVerticalEstimateView.this.m8940a((List<EstimateItemModel>) list), z, true);
                }
                NewVerticalEstimateView.this.f13175r.startAnimation();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m8940a(List<EstimateItemModel> list) {
        int i;
        if (list == null || list.size() == 0) {
            return m8951c();
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            EstimateItemModel estimateItemModel = list.get(i3);
            if (estimateItemModel.viewType != 2) {
                break;
            }
            if (!estimateItemModel.isSelected) {
                i = UiUtils.dip2px(DIDIApplication.getAppContext(), 85.0f);
            } else if (CollectionUtil.isEmpty((Collection<?>) estimateItemModel.carOperation)) {
                i = UiUtils.dip2px(DIDIApplication.getAppContext(), 100.0f);
            } else {
                i = UiUtils.dip2px(DIDIApplication.getAppContext(), 135.0f);
            }
            if (i3 == 2 && !estimateItemModel.isSelected) {
                i = (i / 3) * 2;
            }
            i2 += i;
        }
        GLog.m7965d(f13156a, "measureFirstPageHeight:" + i2);
        int dip2px = i2 + UiUtils.dip2px(this.f13165h, 22.0f);
        return FormStore.getInstance().ismGroupFormViewChanged() ? dip2px + UiUtils.dip2px(this.f13165h, 15.0f) : dip2px;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m8951c() {
        return UiUtils.dip2px(DIDIApplication.getAppContext(), 270.0f);
    }

    public void setEstimatePresenter(NewEstimatePresenter newEstimatePresenter) {
        this.f13168k = newEstimatePresenter;
        newEstimatePresenter.setView(this);
    }

    public void setAbnormalView(List<EstimateAbnormalModel> list) {
        this.f13171n.setVisibility(8);
        m8946a(false);
        this.f13172o.setVisibility(0);
        this.f13172o.setData(list);
        NewEstimatePresenter newEstimatePresenter = this.f13168k;
        if (newEstimatePresenter != null) {
            newEstimatePresenter.hideBottomBar();
            this.f13168k.setAbnormalViewHeight((int) this.f13165h.getResources().getDimension(R.dimen.new_estimate_abnormal_view_height));
        }
    }

    public void backToRecommendData() {
        this.f13177t = false;
        this.f13178u = false;
        this.f13160c.setVisibility(0);
        this.f13162e.setVisibility(0);
        this.f13164g.setVisibility(0);
        this.f13169l.setVisibility(0);
        m8946a(true);
        this.f13173p.setVisibility(8);
        this.f13173p.leave();
        NewEstimatePresenter newEstimatePresenter = this.f13168k;
        newEstimatePresenter.setRecommendItemHeight(newEstimatePresenter.mRecommendsItemHeight, true, true);
        this.f13168k.scrollEstimateViewTop();
        EstimateState.INSTANCE.setInOneCarPage(false);
        NewEstimatePresenter newEstimatePresenter2 = this.f13168k;
        setRecommendData(newEstimatePresenter2.updateRecommendsByModel(newEstimatePresenter2.mOneCarItemModel, true), this.f13168k.getAllModels(), this.f13168k.getSelectModel(), this.f13168k.globalConfigModel);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.EVENT_ESTIMATE_IS_ONE_CAR, false);
    }

    public void updateSelectItem() {
        NewEstimatePresenter newEstimatePresenter = this.f13168k;
        if (newEstimatePresenter != null) {
            int indexOf = newEstimatePresenter.recommendsList.indexOf(this.f13168k.getSelectModel());
            if (indexOf > -1) {
                this.f13161d.notifyItemChanged(indexOf);
            }
            NewEstimateChooseOneCarView newEstimateChooseOneCarView = this.f13173p;
            if (newEstimateChooseOneCarView != null && newEstimateChooseOneCarView.getVisibility() == 0) {
                this.f13173p.updateItems();
            }
            CarEstimateOptionsView carEstimateOptionsView = this.f13174q;
            if (carEstimateOptionsView != null && carEstimateOptionsView.getVisibility() == 0) {
                this.f13174q.setData(this.f13168k.getSelectModel());
            }
        }
    }

    public void changeMargin(boolean z) {
        if ((this.f13171n.getLayoutParams() instanceof FrameLayout.LayoutParams) && (this.f13160c.getLayoutParams() instanceof ConstraintLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13171n.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f13160c.getLayoutParams();
            if (z) {
                layoutParams.leftMargin = UiUtils.dip2px(this.f13165h, 10.0f);
                layoutParams.rightMargin = UiUtils.dip2px(this.f13165h, 10.0f);
                layoutParams2.leftMargin = UiUtils.dip2px(this.f13165h, 0.0f);
                layoutParams2.rightMargin = UiUtils.dip2px(this.f13165h, 0.0f);
            } else {
                layoutParams.leftMargin = UiUtils.dip2px(this.f13165h, 0.0f);
                layoutParams.rightMargin = UiUtils.dip2px(this.f13165h, 0.0f);
                layoutParams2.leftMargin = UiUtils.dip2px(this.f13165h, 10.0f);
                layoutParams2.rightMargin = UiUtils.dip2px(this.f13165h, 10.0f);
            }
            this.f13171n.setLayoutParams(layoutParams);
            this.f13160c.setLayoutParams(layoutParams2);
        } else if (DebugUtils.isDebug()) {
            throw new RuntimeException("estimateDataContainer LayoutParams or mRecommendListView LayoutParams not correct");
        }
    }

    public void recommandSlide(final float f) {
        this.f13160c.post(new Runnable() {
            public void run() {
                if (NewVerticalEstimateView.this.f13179v.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) NewVerticalEstimateView.this.f13179v.getLayoutParams();
                    int measuredHeight = (int) (((float) NewVerticalEstimateView.this.f13160c.getMeasuredHeight()) * (1.0f - f));
                    layoutParams.bottomMargin = measuredHeight;
                    NewVerticalEstimateView.this.f13161d.updateRecommandBg(128 - ((int) (f * 128.0f)));
                    NewVerticalEstimateView.this.f13179v.setLayoutParams(layoutParams);
                    if (NewVerticalEstimateView.this.f13175r == null) {
                        return;
                    }
                    if (NewVerticalEstimateView.this.f13176s.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        NewVerticalEstimateView.this.f13175r.setMoveMargin(measuredHeight);
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) NewVerticalEstimateView.this.f13176s.getLayoutParams();
                        layoutParams2.topMargin = NewVerticalEstimateView.this.f13175r.getmMagnifierViewTopMargin() - measuredHeight;
                        NewVerticalEstimateView.this.f13176s.setLayoutParams(layoutParams2);
                    } else if (DebugUtils.isDebug()) {
                        throw new RuntimeException("mMagnifierView LayoutParams LayoutParams not correct");
                    }
                } else if (DebugUtils.isDebug()) {
                    throw new RuntimeException("Space LayoutParams LayoutParams not correct");
                }
            }
        });
    }

    public void closeTipBubble() {
        LEGOBubble lEGOBubble = this.f13180w;
        if (lEGOBubble != null) {
            lEGOBubble.dismiss();
            this.f13180w = null;
        }
        LEGOBubble lEGOBubble2 = this.f13181x;
        if (lEGOBubble2 != null) {
            lEGOBubble2.dismiss();
        }
    }

    public void showTipBubble(boolean z, boolean z2) {
        LEGOBubble lEGOBubble = this.f13180w;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            this.f13180w.dismiss();
            this.f13180w = null;
        }
        if (z || z2) {
            m8954d();
            this.f13157A = true;
            return;
        }
        this.f13157A = false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r1 = new com.didi.travel.psnger.datasource.BubbleSourceManager(r11.f13165h);
        r0 = r1.getBubble(3, r0.carBubbleModule, false);
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8954d() {
        /*
            r11 = this;
            com.didi.global.globaluikit.popup.LEGOBubble r0 = r11.f13180w
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isShowing()
            if (r0 == 0) goto L_0x0012
            com.didi.global.globaluikit.popup.LEGOBubble r0 = r11.f13180w
            r0.dismiss()
            r0 = 0
            r11.f13180w = r0
        L_0x0012:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r0 = r0.getNewEstimateItem()
            if (r0 == 0) goto L_0x00fd
            com.didi.travel.psnger.model.response.estimate.CarBubbleModule r1 = r0.carBubbleModule
            if (r1 == 0) goto L_0x00fd
            com.didi.travel.psnger.datasource.BubbleSourceManager r1 = new com.didi.travel.psnger.datasource.BubbleSourceManager
            android.content.Context r2 = r11.f13165h
            r1.<init>(r2)
            r2 = 3
            com.didi.travel.psnger.model.response.estimate.CarBubbleModule r0 = r0.carBubbleModule
            r3 = 0
            com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel r0 = r1.getBubble(r2, r0, r3)
            if (r0 == 0) goto L_0x00fd
            java.lang.String r2 = r0.bubbleId
            int r3 = r0.showCount
            boolean r2 = r1.isShowBubble(r2, r3)
            if (r2 == 0) goto L_0x00fd
            com.didi.component.common.widget.NewBubbleHelper r2 = new com.didi.component.common.widget.NewBubbleHelper
            android.content.Context r3 = r11.f13165h
            r2.<init>(r3, r0)
            r11.f13182y = r2
            com.didi.global.globaluikit.popup.LEGOBubble$Builder r2 = r2.getmBuilder()
            com.didi.component.estimate.newui.view.vertical.NewVerticalEstimateView$14 r3 = new com.didi.component.estimate.newui.view.vertical.NewVerticalEstimateView$14
            r3.<init>(r1, r0)
            r2.setContentViewOnClick(r3)
            com.didi.component.estimate.newui.view.one.NewEstimateChooseOneCarView r0 = r11.f13173p
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x00fd
            android.view.View r0 = r11.f13176s
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x00fd
            boolean r0 = r11.f13183z
            if (r0 != 0) goto L_0x00fd
            com.didi.component.estimate.newui.presenter.NewEstimatePresenter r0 = r11.f13168k
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r0 = r0.getSelectModel()
            r1 = -1
            if (r0 == 0) goto L_0x0076
            com.didi.component.estimate.newui.presenter.NewEstimatePresenter r3 = r11.f13168k
            java.util.List<com.didi.travel.psnger.model.response.estimate.EstimateItemModel> r3 = r3.recommendsList
            int r0 = r3.indexOf(r0)
            goto L_0x0077
        L_0x0076:
            r0 = -1
        L_0x0077:
            com.didi.component.estimate.newui.presenter.NewEstimatePresenter r3 = r11.f13168k
            java.util.List<com.didi.travel.psnger.model.response.estimate.EstimateItemModel> r3 = r3.recommendsList
            com.didi.component.estimate.newui.presenter.NewEstimatePresenter r4 = r11.f13168k
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r4 = r4.getSelectModel()
            int r3 = r3.indexOf(r4)
            androidx.recyclerview.widget.RecyclerView r4 = r11.f13160c
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = r4.getLayoutManager()
            android.view.View r3 = r4.findViewByPosition(r3)
            r4 = 1999(0x7cf, float:2.801E-42)
            r5 = -2
            r6 = 1132068864(0x437a0000, float:250.0)
            r7 = 2
            if (r0 <= r1) goto L_0x00c4
            if (r0 >= r7) goto L_0x00c4
            java.lang.String r1 = "top_right"
            r2.setDirection(r1)
            android.content.Context r1 = r11.f13165h
            int r1 = com.didi.component.business.util.UiUtils.dip2px(r1, r6)
            r2.setWidthAndHeight(r1, r5)
            com.didi.global.globaluikit.popup.LEGOBubble r1 = r2.build()
            r11.f13180w = r1
            if (r3 == 0) goto L_0x00c4
            android.content.Context r8 = r11.f13165h
            r9 = 1121714176(0x42dc0000, float:110.0)
            int r8 = com.didi.component.business.util.UiUtils.dip2px(r8, r9)
            android.content.Context r9 = r11.f13165h
            r10 = 1095761920(0x41500000, float:13.0)
            int r9 = com.didi.component.business.util.UiUtils.dip2px(r9, r10)
            int r9 = -r9
            r1.show(r3, r8, r9, r4)
        L_0x00c4:
            if (r0 != r7) goto L_0x00fd
            java.lang.String r0 = "bottom_right"
            r2.setDirection(r0)
            android.content.Context r0 = r11.f13165h
            int r0 = com.didi.component.business.util.UiUtils.dip2px(r0, r6)
            r2.setWidthAndHeight(r0, r5)
            com.didi.global.globaluikit.popup.LEGOBubble r0 = r2.build()
            r11.f13180w = r0
            int[] r0 = r0.getMeasureWidthAndHeight()
            r1 = 1
            r0 = r0[r1]
            android.view.View r1 = r11.f13176s
            int r1 = r1.getMeasuredHeight()
            int r1 = r1 + r0
            android.content.Context r0 = r11.f13165h
            r2 = 1108082688(0x420c0000, float:35.0)
            int r0 = com.didi.component.business.util.UiUtils.dip2px(r0, r2)
            int r1 = r1 - r0
            com.didi.global.globaluikit.popup.LEGOBubble r0 = r11.f13180w
            android.view.View r2 = r11.f13176s
            int r3 = r11.m8955e()
            int r1 = -r1
            r0.show(r2, r3, r1, r4)
        L_0x00fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.estimate.newui.view.vertical.NewVerticalEstimateView.m8954d():void");
    }

    /* renamed from: e */
    private int m8955e() {
        return (this.f13176s.getMeasuredWidth() - UiUtils.dip2px(this.f13165h, 250.0f)) - UiUtils.dip2px(this.f13165h, 28.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r2 = new com.didi.travel.psnger.datasource.BubbleSourceManager(r5.f13165h);
        r0 = r2.getBubble(3, r1.carBubbleModule, false);
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8958f() {
        /*
            r5 = this;
            r0 = 0
            r5.f13159b = r0
            com.didi.global.globaluikit.popup.LEGOBubble r1 = r5.f13181x
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.isShowing()
            if (r1 == 0) goto L_0x0012
            com.didi.global.globaluikit.popup.LEGOBubble r1 = r5.f13181x
            r1.dismiss()
        L_0x0012:
            com.didi.component.business.data.form.FormStore r1 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r1 = r1.getNewEstimateItem()
            if (r1 == 0) goto L_0x008e
            com.didi.travel.psnger.model.response.estimate.CarBubbleModule r2 = r1.carBubbleModule
            if (r2 == 0) goto L_0x008e
            com.didi.travel.psnger.datasource.BubbleSourceManager r2 = new com.didi.travel.psnger.datasource.BubbleSourceManager
            android.content.Context r3 = r5.f13165h
            r2.<init>(r3)
            r3 = 3
            com.didi.travel.psnger.model.response.estimate.CarBubbleModule r1 = r1.carBubbleModule
            com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel r0 = r2.getBubble(r3, r1, r0)
            if (r0 == 0) goto L_0x008e
            java.lang.String r1 = r0.bubbleId
            int r3 = r0.showCount
            boolean r1 = r2.isShowBubble(r1, r3)
            if (r1 == 0) goto L_0x008e
            com.didi.global.globaluikit.popup.LEGOBubble r1 = r5.f13181x
            if (r1 != 0) goto L_0x0068
            com.didi.component.common.widget.NewBubbleHelper r1 = new com.didi.component.common.widget.NewBubbleHelper
            android.content.Context r3 = r5.f13165h
            java.lang.String r4 = "top_right"
            r1.<init>(r3, r0, r4)
            r5.f13182y = r1
            com.didi.global.globaluikit.popup.LEGOBubble$Builder r1 = r1.getmBuilder()
            android.content.Context r3 = r5.f13165h
            r4 = 1132068864(0x437a0000, float:250.0)
            int r3 = com.didi.component.business.util.UiUtils.dip2px(r3, r4)
            r4 = -2
            r1.setWidthAndHeight(r3, r4)
            com.didi.component.estimate.newui.view.vertical.NewVerticalEstimateView$15 r3 = new com.didi.component.estimate.newui.view.vertical.NewVerticalEstimateView$15
            r3.<init>(r2, r0)
            r1.setContentViewOnClick(r3)
            com.didi.global.globaluikit.popup.LEGOBubble r0 = r1.build()
            r5.f13181x = r0
        L_0x0068:
            com.didi.global.globaluikit.popup.LEGOBubble r0 = r5.f13181x
            boolean r0 = r0.isShowing()
            if (r0 != 0) goto L_0x008e
            boolean r0 = r5.f13183z
            if (r0 != 0) goto L_0x008e
            com.didi.global.globaluikit.popup.LEGOBubble r0 = r5.f13181x
            com.didi.component.estimate.newui.view.one.NewEstimateChooseOneCarView r1 = r5.f13173p
            android.content.Context r2 = r5.f13165h
            r3 = 1117126656(0x42960000, float:75.0)
            int r2 = com.didi.component.business.util.UiUtils.dip2px(r2, r3)
            android.content.Context r3 = r5.f13165h
            r4 = 1097859072(0x41700000, float:15.0)
            int r3 = com.didi.component.business.util.UiUtils.dip2px(r3, r4)
            int r3 = -r3
            r4 = 1999(0x7cf, float:2.801E-42)
            r0.show(r1, r2, r3, r4)
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.estimate.newui.view.vertical.NewVerticalEstimateView.m8958f():void");
    }

    public View getView() {
        return this.f13166i;
    }

    public void setPresenter(AbsEstimatePresenter absEstimatePresenter) {
        this.f13167j = absEstimatePresenter;
        this.f13161d.setPresenter(absEstimatePresenter);
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f13167j.setComponentCreator(iComponentCreator);
    }

    public void showDetailPop(EstimateItemModel estimateItemModel, boolean z, final int i) {
        sendOmegaEventDetailClick(estimateItemModel, z);
        if (estimateItemModel.carDetail != null) {
            CarDetailInfoListModel carDetailInfoListModel = null;
            if (estimateItemModel.carDetail.size() > 1 && z) {
                carDetailInfoListModel = estimateItemModel.carDetail.get(1);
            } else if (estimateItemModel.carDetail.size() > 0) {
                carDetailInfoListModel = estimateItemModel.carDetail.get(0);
            }
            if (carDetailInfoListModel != null && !CollectionUtil.isEmpty((Collection<?>) carDetailInfoListModel.carDetailModels)) {
                new NewCarDetailPopUp(this.f13165h, this.f13168k.collectDetailList(), carDetailInfoListModel, estimateItemModel, (NewCarDetailPopUp.DetailSelectChangeListener) new NewCarDetailPopUp.DetailSelectChangeListener() {
                    public void detailSelectItem(String str, boolean z) {
                        EstimateTrackEventUtils.trackEstimateShow(NewVerticalEstimateView.this.f13165h);
                        if (i == 2) {
                            EstimateItemModel estimateItemByUid = NewVerticalEstimateView.this.f13168k.getEstimateItemByUid(str, z);
                            NewVerticalEstimateView newVerticalEstimateView = NewVerticalEstimateView.this;
                            newVerticalEstimateView.m8944a(estimateItemByUid, (AbsEstimatePresenter<?>) newVerticalEstimateView.f13167j);
                            NewVerticalEstimateView.this.f13168k.updateRecommendsByModel(estimateItemByUid, true);
                            return;
                        }
                        EstimateItemModel selectModel = NewVerticalEstimateView.this.f13168k.getSelectModel();
                        if (selectModel == null || selectModel.carConfig == null || !str.equals(selectModel.carConfig.uniqueId)) {
                            List<EstimateItemModel> updateRecommendsByUid = NewVerticalEstimateView.this.f13168k.updateRecommendsByUid(str, z, true);
                            EstimateItemModel selectModel2 = NewVerticalEstimateView.this.f13168k.getSelectModel();
                            NewVerticalEstimateView newVerticalEstimateView2 = NewVerticalEstimateView.this;
                            newVerticalEstimateView2.setRecommendData(updateRecommendsByUid, newVerticalEstimateView2.f13168k.getAllModels(), selectModel2, NewVerticalEstimateView.this.f13168k.globalConfigModel);
                            return;
                        }
                        if (selectModel.twoPriceChoice != null) {
                            selectModel.twoPriceChoice.selectedValue = z ? "1" : "0";
                        }
                        if (NewVerticalEstimateView.this.f13174q != null && NewVerticalEstimateView.this.f13174q.getVisibility() == 0) {
                            NewVerticalEstimateView.this.f13174q.setData(selectModel);
                        }
                    }
                }).show();
                AbsEstimatePresenter<?> absEstimatePresenter = this.f13167j;
                if (absEstimatePresenter != null) {
                    absEstimatePresenter.hideGuidePopUp();
                }
                sendOmegaEventDetailShow(carDetailInfoListModel, estimateItemModel);
            }
        }
    }

    public void sendOmegaEventDetailShow(CarDetailInfoListModel carDetailInfoListModel, EstimateItemModel estimateItemModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", carDetailInfoListModel.hasCoupon() ? "1" : "2");
        if (!(estimateItemModel == null || estimateItemModel.carConfig == null)) {
            hashMap.put("cartype", Integer.valueOf(estimateItemModel.carConfig.carLevel));
            if (estimateItemModel.carConfig.extraData != null) {
                estimateItemModel.carConfig.extraData.putAllExtraLog(hashMap);
            }
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_cartypedetail_sw", (Map<String, Object>) hashMap);
    }

    public void sendOmegaEventDetailClick(EstimateItemModel estimateItemModel, boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_shareprice_ck");
        } else if (estimateItemModel != null && estimateItemModel.carConfig != null) {
            hashMap.put("price_type", Integer.valueOf(estimateItemModel.carConfig.countPriceType));
            hashMap.put("bubble_id", estimateItemModel.carConfig.estimateId);
            hashMap.put("estimate_trace_id", FormStore.getInstance().getEstimateModelTraceId());
            hashMap.put("cartype", Integer.valueOf(estimateItemModel.carConfig.carLevel));
            hashMap.put("combotype", Integer.valueOf(FormStore.getInstance().getCurrentComboType()));
            GlobalOmegaUtils.trackEvent("pas_orderconfirm_price_ck", (Map<String, Object>) hashMap);
        }
    }

    public int getMessageViewHeight() {
        return this.f13170m.getMeasuredHeight();
    }

    public void sendEventChangeSelectCar() {
        EstimateItemModel estimateItemModel = this.f13168k.lastSelectModel;
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        HashMap hashMap = new HashMap();
        if (!(estimateItemModel == null || newEstimateItem == null)) {
            if (estimateItemModel.carConfig != null) {
                hashMap.put("b_carlevel", Integer.valueOf(estimateItemModel.carConfig.carLevel));
                hashMap.put("b_comboType", Integer.valueOf(estimateItemModel.carConfig.carComboType));
                if (estimateItemModel.carConfig.guideType != null) {
                    hashMap.put("b_guide_type", estimateItemModel.carConfig.guideType.toString());
                }
                hashMap.put("b_default_select", estimateItemModel.carConfig.selectDefault);
            }
            if (newEstimateItem.carConfig != null) {
                hashMap.put("carlevel", Integer.valueOf(newEstimateItem.carConfig.carLevel));
                hashMap.put("comboType", Integer.valueOf(newEstimateItem.carConfig.carComboType));
                if (newEstimateItem.carConfig != null) {
                    hashMap.put(ParamKeys.PARAM_GUIDE_TYPE, newEstimateItem.carConfig.guideType.toString());
                }
                hashMap.put("bubble_id", newEstimateItem.carConfig.estimateId);
            }
            hashMap.put("estimate_trace_id", FormStore.getInstance().getEstimateModelTraceId());
            if (!(newEstimateItem.carConfig == null || newEstimateItem.carConfig.extraData == null)) {
                newEstimateItem.carConfig.extraData.putAllExtraLog(hashMap);
            }
        }
        GlobalOmegaUtils.trackEvent("pas_orderconfirm_mode_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8946a(boolean z) {
        int i = 8;
        if (this.f13173p.getVisibility() == 0) {
            this.f13176s.setVisibility(8);
            return;
        }
        View view = this.f13176s;
        if (z) {
            i = 0;
        }
        view.setVisibility(i);
    }

    public void setScrollToTop() {
        m8946a(false);
        this.f13170m.setVisibility(8);
        closeTipBubble();
    }

    public void setScrollToBottom() {
        m8946a(true);
        if (!this.f13177t) {
            this.f13160c.setVisibility(0);
        }
        this.f13170m.setVisibility(0);
        m8954d();
        if (this.f13159b) {
            m8958f();
        }
    }

    public void hideMessageView() {
        this.f13170m.setVisibility(8);
    }
}
