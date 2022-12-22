package com.didi.component.estimate.newui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.estimate.newui.view.viewholder.EstimateMessageViewHolder;
import com.didi.component.estimate.newui.view.viewholder.EstimateTransferFlowViewHolder;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.sdk.util.NewUISwitchUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewEstimateMessageView extends FrameLayout {

    /* renamed from: s */
    private static int f13121s = -12;

    /* renamed from: t */
    private static int f13122t = -11;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f13123a;

    /* renamed from: b */
    private EstimateMessageViewHolder f13124b;

    /* renamed from: c */
    private EstimateMessageViewHolder f13125c;

    /* renamed from: d */
    private EstimateTransferFlowViewHolder f13126d;

    /* renamed from: e */
    private EstimateTransferFlowViewHolder f13127e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f13128f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f13129g;

    /* renamed from: h */
    private AnimatorSet f13130h;

    /* renamed from: i */
    private AnimatorSet f13131i;

    /* renamed from: j */
    private AnimatorSet f13132j;

    /* renamed from: k */
    private CarMessageModel f13133k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f13134l = -1;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public CarMessageModel f13135m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f13136n = -1;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public MessageViewClickListener f13137o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f13138p = true;

    /* renamed from: q */
    private RecyclerView f13139q;

    /* renamed from: r */
    private int f13140r;

    public interface MessageViewClickListener {
        void onTransferFlowCloseClick(CarMessageModel carMessageModel);

        void onTransferFlowItemClick(int i);
    }

    public NewEstimateMessageView(Context context) {
        super(context);
        this.f13123a = context;
        initView();
    }

    public NewEstimateMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13123a = context;
        initView();
    }

    public NewEstimateMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13123a = context;
        initView();
    }

    public void initView() {
        C54691 r0 = new EstimateMessageViewHolder.MessageListener() {
            public void onMessageClick(CarMessageModel carMessageModel) {
                if (!TextUtils.isEmpty(carMessageModel.messageLink)) {
                    Intent intent = new Intent(NewEstimateMessageView.this.f13123a, GlobalWebActivity.class);
                    intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(carMessageModel.messageLink));
                    NewEstimateMessageView.this.f13123a.startActivity(intent);
                    GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_bubble_ck", NewEstimateMessageView.this.collectGuideFlowParams(carMessageModel));
                }
            }
        };
        EstimateMessageViewHolder estimateMessageViewHolder = new EstimateMessageViewHolder(this);
        this.f13124b = estimateMessageViewHolder;
        estimateMessageViewHolder.setListener(r0);
        EstimateMessageViewHolder estimateMessageViewHolder2 = new EstimateMessageViewHolder(this);
        this.f13125c = estimateMessageViewHolder2;
        estimateMessageViewHolder2.setListener(r0);
        C54742 r02 = new EstimateTransferFlowViewHolder.TransferFlowListener() {
            public void onTransferFlowClick(CarMessageModel carMessageModel) {
                if (NewEstimateMessageView.this.f13137o != null && NewEstimateMessageView.this.f13134l > -1) {
                    NewEstimateMessageView.this.f13137o.onTransferFlowItemClick(NewEstimateMessageView.this.f13134l);
                    GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_bubble_ck", NewEstimateMessageView.this.collectGuideFlowParams(carMessageModel));
                }
            }

            public void onTransferFlowCloseClick(CarMessageModel carMessageModel) {
                boolean unused = NewEstimateMessageView.this.f13138p = false;
                CarMessageModel unused2 = NewEstimateMessageView.this.f13135m = null;
                int unused3 = NewEstimateMessageView.this.f13136n = -1;
                NewEstimateMessageView newEstimateMessageView = NewEstimateMessageView.this;
                newEstimateMessageView.m8925a((CarMessageModel) null, newEstimateMessageView.f13136n);
                if (NewEstimateMessageView.this.f13137o != null) {
                    NewEstimateMessageView.this.f13137o.onTransferFlowCloseClick(carMessageModel);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_bubble_close_ck", NewEstimateMessageView.this.collectGuideFlowParams(carMessageModel));
            }
        };
        EstimateTransferFlowViewHolder estimateTransferFlowViewHolder = new EstimateTransferFlowViewHolder(this);
        this.f13126d = estimateTransferFlowViewHolder;
        estimateTransferFlowViewHolder.setCarRecyclerView(this.f13139q);
        this.f13126d.setType(this.f13140r);
        this.f13126d.setListener(r02);
        EstimateTransferFlowViewHolder estimateTransferFlowViewHolder2 = new EstimateTransferFlowViewHolder(this);
        this.f13127e = estimateTransferFlowViewHolder2;
        estimateTransferFlowViewHolder2.setCarRecyclerView(this.f13139q);
        this.f13127e.setType(this.f13140r);
        this.f13127e.setListener(r02);
        m8922a();
    }

    /* renamed from: a */
    private void m8922a() {
        ValueAnimator a = m8918a(400, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f13128f != null && NewEstimateMessageView.this.f13128f.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f13128f.setTranslationY(((float) NewEstimateMessageView.this.f13128f.getMeasuredHeight()) * (1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                }
            }
        });
        ValueAnimator a2 = m8918a(300, 100, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f13128f != null && NewEstimateMessageView.this.f13128f.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f13128f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f13130h = animatorSet;
        animatorSet.playTogether(new Animator[]{a, a2});
        this.f13130h.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (NewEstimateMessageView.this.f13128f != null && !NewEstimateMessageView.this.f13128f.isAttachedToWindow()) {
                    NewEstimateMessageView newEstimateMessageView = NewEstimateMessageView.this;
                    newEstimateMessageView.addView(newEstimateMessageView.f13128f);
                }
                NewEstimateMessageView.this.f13128f.setAlpha(0.0f);
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        ValueAnimator a3 = m8918a(400, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f13128f != null && NewEstimateMessageView.this.f13128f.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f13128f.setTranslationY(((float) NewEstimateMessageView.this.f13128f.getMeasuredHeight()) * (1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                }
            }
        });
        ValueAnimator a4 = m8918a(300, 100, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f13128f != null && NewEstimateMessageView.this.f13128f.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f13128f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ValueAnimator a5 = m8918a(400, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f13129g != null && NewEstimateMessageView.this.f13129g.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f13129g.setTranslationY(((float) NewEstimateMessageView.this.f13129g.getMeasuredHeight()) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ValueAnimator a6 = m8918a(200, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f13129g != null && NewEstimateMessageView.this.f13129g.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f13129g.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f13131i = animatorSet2;
        animatorSet2.playTogether(new Animator[]{a3, a4, a5, a6});
        this.f13131i.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (NewEstimateMessageView.this.f13128f == null || !NewEstimateMessageView.this.f13128f.isAttachedToWindow()) {
                    NewEstimateMessageView newEstimateMessageView = NewEstimateMessageView.this;
                    newEstimateMessageView.addView(newEstimateMessageView.f13128f);
                }
                NewEstimateMessageView.this.f13128f.setAlpha(0.0f);
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (NewEstimateMessageView.this.f13129g != null && NewEstimateMessageView.this.f13129g.isAttachedToWindow()) {
                    NewEstimateMessageView newEstimateMessageView = NewEstimateMessageView.this;
                    newEstimateMessageView.removeView(newEstimateMessageView.f13129g);
                }
                View unused = NewEstimateMessageView.this.f13129g = null;
            }
        });
        ValueAnimator a7 = m8918a(400, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f13129g != null && NewEstimateMessageView.this.f13129g.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f13129g.setTranslationY(((float) NewEstimateMessageView.this.f13129g.getMeasuredHeight()) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ValueAnimator a8 = m8918a(200, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f13129g != null && NewEstimateMessageView.this.f13129g.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f13129g.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f13132j = animatorSet3;
        animatorSet3.playTogether(new Animator[]{a7, a8});
        this.f13132j.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (NewEstimateMessageView.this.f13129g != null && NewEstimateMessageView.this.f13129g.isAttachedToWindow()) {
                    NewEstimateMessageView newEstimateMessageView = NewEstimateMessageView.this;
                    newEstimateMessageView.removeView(newEstimateMessageView.f13129g);
                }
                View unused = NewEstimateMessageView.this.f13129g = null;
            }
        });
    }

    public void reset() {
        removeAllViews();
        this.f13128f = null;
        this.f13129g = null;
        this.f13133k = null;
        this.f13134l = -1;
        this.f13135m = null;
        this.f13136n = -1;
    }

    /* renamed from: a */
    private ValueAnimator m8918a(long j, long j2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
        ofFloat.setDuration(j);
        ofFloat.setStartDelay(j2);
        ofFloat.addUpdateListener(animatorUpdateListener);
        return ofFloat;
    }

    public void setCarRecyclerView(RecyclerView recyclerView) {
        this.f13139q = recyclerView;
        this.f13126d.setCarRecyclerView(recyclerView);
        this.f13127e.setCarRecyclerView(recyclerView);
    }

    /* renamed from: a */
    private void m8923a(Animator animator) {
        if (animator != null && animator.isRunning()) {
            animator.end();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8925a(CarMessageModel carMessageModel, int i) {
        if (carMessageModel != this.f13133k) {
            m8923a((Animator) this.f13130h);
            m8923a((Animator) this.f13131i);
            m8923a((Animator) this.f13132j);
            this.f13133k = carMessageModel;
            this.f13134l = i;
            this.f13129g = this.f13128f;
            if (carMessageModel == null) {
                this.f13128f = null;
            } else if (carMessageModel.isTopGuide()) {
                this.f13127e.setData(carMessageModel, i);
                m8929b();
                this.f13128f = this.f13126d.itemView;
            } else {
                this.f13125c.setData(carMessageModel);
                m8931c();
                this.f13128f = this.f13124b.itemView;
            }
            if (this.f13128f != null) {
                if (this.f13129g != null) {
                    this.f13131i.start();
                } else {
                    this.f13130h.start();
                }
            } else if (this.f13129g != null) {
                this.f13132j.start();
            }
            GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_bubble_sw", collectGuideFlowParams(carMessageModel));
        }
    }

    /* renamed from: b */
    private void m8929b() {
        EstimateTransferFlowViewHolder estimateTransferFlowViewHolder = this.f13126d;
        this.f13126d = this.f13127e;
        this.f13127e = estimateTransferFlowViewHolder;
    }

    /* renamed from: c */
    private void m8931c() {
        EstimateMessageViewHolder estimateMessageViewHolder = this.f13124b;
        this.f13124b = this.f13125c;
        this.f13125c = estimateMessageViewHolder;
    }

    public boolean setMessageData(List<EstimateItemModel> list, EstimateItemModel estimateItemModel, boolean z) {
        boolean z2;
        this.f13135m = null;
        this.f13136n = -1;
        if (NewUISwitchUtils.getEstimateNewAbStatus() == 1) {
            z2 = m8927a(list, estimateItemModel, z);
        } else {
            z2 = m8927a(list, estimateItemModel, z);
        }
        m8925a(this.f13135m, this.f13136n);
        return z2;
    }

    /* renamed from: a */
    private boolean m8927a(List<EstimateItemModel> list, EstimateItemModel estimateItemModel, boolean z) {
        EstimateItemModel estimateItemModel2 = null;
        this.f13135m = null;
        this.f13136n = -1;
        if (list != null) {
            estimateItemModel2 = list.get(0);
        }
        if (estimateItemModel2 != null && !CollectionUtils.isEmpty((Collection) estimateItemModel2.carMessage) && estimateItemModel2.carMessage.get(0).isTopGuide()) {
            this.f13135m = estimateItemModel2.carMessage.get(0);
        } else if (estimateItemModel != null && !CollectionUtils.isEmpty((Collection) estimateItemModel.carMessage) && (z || !estimateItemModel.carMessage.get(0).isTopGuide())) {
            this.f13135m = estimateItemModel.carMessage.get(0);
        }
        if (this.f13135m != null) {
            this.f13136n = 0;
        }
        try {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            if (this.f13135m == null) {
                layoutParams.bottomMargin = 0;
            } else if (this.f13135m.isTopGuide()) {
                if (Build.VERSION.SDK_INT >= 21) {
                    setTranslationZ(1.0f);
                }
                layoutParams.bottomMargin = UiUtils.dip2px(this.f13123a, (float) f13122t);
            } else {
                layoutParams.bottomMargin = UiUtils.dip2px(this.f13123a, (float) f13121s);
            }
            setLayoutParams(layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f13135m != null) {
            return true;
        }
        return false;
    }

    public int messageMargin() {
        CarMessageModel carMessageModel = this.f13135m;
        if (carMessageModel == null) {
            return 0;
        }
        if (!carMessageModel.isTopGuide()) {
            return UiUtils.dip2px(this.f13123a, (float) f13121s);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return UiUtils.dip2px(this.f13123a, (float) f13122t);
        }
        return 0;
    }

    public void setMessageViewClickListener(MessageViewClickListener messageViewClickListener) {
        this.f13137o = messageViewClickListener;
    }

    public Map<String, Object> collectGuideFlowParams(CarMessageModel carMessageModel) {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        HashMap hashMap = new HashMap();
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null)) {
            hashMap.put("cartype", Integer.valueOf(newEstimateItem.carConfig.carLevel));
            hashMap.put("bubble_id", newEstimateItem.carConfig.estimateId);
            if (carMessageModel != null && !TextUtils.isEmpty(carMessageModel.messageTypeId)) {
                hashMap.put("id", carMessageModel.messageTypeId);
            }
            if (newEstimateItem.carConfig.guideType != null) {
                hashMap.put(ParamKeys.PARAM_GUIDE_TYPE, newEstimateItem.carConfig.guideType.toString());
            }
            if (newEstimateItem.carConfig.extraData != null) {
                newEstimateItem.carConfig.extraData.putAllExtraLog(hashMap);
            }
        }
        return hashMap;
    }

    public void setType(int i) {
        this.f13140r = i;
        EstimateTransferFlowViewHolder estimateTransferFlowViewHolder = this.f13126d;
        if (estimateTransferFlowViewHolder != null) {
            estimateTransferFlowViewHolder.setType(i);
        }
        EstimateTransferFlowViewHolder estimateTransferFlowViewHolder2 = this.f13127e;
        if (estimateTransferFlowViewHolder2 != null) {
            estimateTransferFlowViewHolder2.setType(this.f13140r);
        }
    }
}
