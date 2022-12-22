package com.didi.component.imentrance.impl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.msg.IMMsg;
import com.didi.beatles.p099im.access.msg.IMMsgType;
import com.didi.beatles.p099im.module.entity.IMSysChatUnreadCount;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.imentrance.model.DriverOptionModel;
import com.taxis99.R;

public class IMEntranceV2FarView extends IMEntranceViewBase {
    public static final int ANIMATION_TIME = 400;
    public static final int ANIMATION_TIME_SHORT = 300;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f14139a = findView(R.id.driver_card_message_container_near);

    /* renamed from: b */
    private TextView f14140b = ((TextView) findView(R.id.im_entrance_msg_near));
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FrameLayout f14141c = ((FrameLayout) findView(R.id.im_bubble_msg_container));

    /* renamed from: d */
    private boolean f14142d = false;
    protected ImageView mIMIcon = ((ImageView) findView(R.id.im_entrance_icon));
    protected TextView mMsgTv = ((TextView) findView(R.id.im_bubble_msg));

    public void refreshMessageCount(int i) {
    }

    public void setData(DriverOptionModel driverOptionModel) {
    }

    public void setIMEntranceIcon(int i) {
    }

    public IMEntranceV2FarView(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.mMsgTv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMEntranceV2FarView.this.mPresenter.startIMActivity();
                IMEntranceV2FarView.this.f14141c.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) IMEntranceV2FarView.this.f14141c.getLayoutParams();
                layoutParams.height = 0;
                layoutParams.bottomMargin = 0;
                IMEntranceV2FarView.this.f14141c.setLayoutParams(layoutParams);
                IMEntranceV2FarView.this.mPresenter.notifyShowMsgBubble(false);
                GlobalOmegaUtils.trackEvent("ibt_gp_driverimnotice_ck", "type", "2");
            }
        });
        this.mIMIcon.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public ViewGroup inflateContentView(Context context, ViewGroup viewGroup) {
        return (ViewGroup) LayoutInflater.from(context).inflate(R.layout.global_im_entrance_v2_far_layout, viewGroup, false);
    }

    public void refreshMessageCount(IMSysChatUnreadCount iMSysChatUnreadCount) {
        if (this.f14142d) {
            this.mIMCount.setVisibility(8);
            return;
        }
        refreshMessageCount(this.mIMCount, iMSysChatUnreadCount);
        refreshMessageCount(this.f14140b, iMSysChatUnreadCount);
    }

    public void show() {
        super.show();
        this.mIMIcon.setEnabled(true);
        this.f14141c.setVisibility(4);
        ((RelativeLayout.LayoutParams) this.f14141c.getLayoutParams()).bottomMargin = 0;
        this.mView.setOnClickListener(this);
    }

    public void hide() {
        super.hide();
        this.mIMIcon.setEnabled(false);
        this.mView.setOnClickListener((View.OnClickListener) null);
        this.f14141c.setVisibility(4);
        ((RelativeLayout.LayoutParams) this.f14141c.getLayoutParams()).bottomMargin = 0;
        this.mIMCount.setVisibility(8);
    }

    public void nearPickupShow() {
        super.nearPickupShow();
        this.f14142d = true;
        this.f14141c.setVisibility(4);
        ((RelativeLayout.LayoutParams) this.f14141c.getLayoutParams()).bottomMargin = 0;
        this.mIMIcon.setVisibility(8);
        this.mIMCount.setVisibility(8);
        this.f14139a.setVisibility(0);
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14139a.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{UiUtils.dip2px(this.mContext, 40.0f), UiUtils.dip2px(this.mContext, 255.0f)});
        ofInt.setDuration(400);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                IMEntranceV2FarView.this.f14139a.setLayoutParams(layoutParams);
            }
        });
        ofInt.start();
    }

    public void setIMLastMsg(IMMsg iMMsg) {
        if (iMMsg == null || this.f14142d) {
            this.f14141c.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14141c.getLayoutParams();
            layoutParams.height = 0;
            layoutParams.bottomMargin = 0;
            this.f14141c.setLayoutParams(layoutParams);
            this.mPresenter.notifyShowMsgBubble(false);
        } else if (iMMsg.type != IMMsgType.TYPE_SYSTEM && iMMsg.type != IMMsgType.TYPE_ORDER_STATUS_CHANGE) {
            this.mPresenter.notifyShowMsgBubble(true);
            updateText(iMMsg);
            ViewGroup.LayoutParams layoutParams2 = this.f14141c.getLayoutParams();
            layoutParams2.height = -2;
            this.f14141c.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean updateText(final IMMsg iMMsg) {
        if (this.f14141c.getVisibility() != 0) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f14141c, "alpha", new float[]{0.0f, 1.0f});
            ofFloat.setDuration(400);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{UiUtils.dip2px(this.mContext, -5.0f), UiUtils.dip2px(this.mContext, 4.0f)});
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14141c.getLayoutParams();
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    IMEntranceV2FarView.this.f14141c.setLayoutParams(layoutParams);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            ofInt.setDuration(300);
            animatorSet.playTogether(new Animator[]{ofFloat, ofInt});
            animatorSet.start();
            this.f14141c.setVisibility(0);
            if (iMMsg.type == IMMsgType.TYPE_TEXT_RECOMMEND || iMMsg.type == IMMsgType.TYPE_TEXT) {
                this.mMsgTv.setText(iMMsg.textContent);
            } else if (iMMsg.type == IMMsgType.TYPE_VOICE) {
                this.mMsgTv.setText(this.mContext.getResources().getText(R.string.global_im_content_voice));
            }
        } else {
            this.f14141c.post(new Runnable() {
                public void run() {
                    IMEntranceV2FarView.this.mMsgTv.setAlpha(0.0f);
                    IMEntranceV2FarView.this.f14141c.setVisibility(4);
                    final int measuredWidth = IMEntranceV2FarView.this.f14141c.getMeasuredWidth();
                    if (iMMsg.type == IMMsgType.TYPE_TEXT_RECOMMEND || iMMsg.type == IMMsgType.TYPE_TEXT) {
                        IMEntranceV2FarView.this.mMsgTv.setText(iMMsg.textContent);
                    } else if (iMMsg.type == IMMsgType.TYPE_VOICE) {
                        IMEntranceV2FarView.this.mMsgTv.setText(IMEntranceV2FarView.this.mContext.getResources().getText(R.string.global_im_content_voice));
                    }
                    IMEntranceV2FarView.this.f14141c.post(new Runnable() {
                        public void run() {
                            final int measuredWidth = IMEntranceV2FarView.this.f14141c.getMeasuredWidth();
                            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{measuredWidth, measuredWidth});
                            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) IMEntranceV2FarView.this.f14141c.getLayoutParams();
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    layoutParams.width = intValue;
                                    if (intValue == measuredWidth) {
                                        layoutParams.width = -2;
                                    }
                                    if (IMEntranceV2FarView.this.f14141c.getVisibility() != 0) {
                                        IMEntranceV2FarView.this.f14141c.setVisibility(0);
                                    }
                                    IMEntranceV2FarView.this.f14141c.setLayoutParams(layoutParams);
                                }
                            });
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(IMEntranceV2FarView.this.mMsgTv, "alpha", new float[]{0.0f, 1.0f});
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.setDuration(400);
                            animatorSet.playTogether(new Animator[]{ofFloat, ofInt});
                            animatorSet.start();
                        }
                    });
                }
            });
        }
        return true;
    }
}
