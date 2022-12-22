package com.didi.component.imentrance.impl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.msg.IMMsg;
import com.didi.beatles.p099im.access.msg.IMMsgType;
import com.didi.beatles.p099im.module.entity.IMSysChatUnreadCount;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.imentrance.model.DriverOptionModel;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class IMEntranceV2NearView extends IMEntranceViewBase {
    public static final int ANIMATION_TIME = 400;
    public static final int ANIMATION_TIME_SHORT = 300;

    /* renamed from: a */
    AnimatorSet f14143a = new AnimatorSet();

    /* renamed from: b */
    private TextView f14144b = ((TextView) findView(R.id.im_entrance_default_tv));
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ValueAnimator f14145c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout f14146d;
    protected ImageView mIMIcon = ((ImageView) findView(R.id.im_entrance_icon));
    protected TextView mMsgTv = ((TextView) findView(R.id.im_bubble_msg));
    protected FrameLayout msgContainer = ((FrameLayout) findView(R.id.driver_card_message_container));

    public void refreshMessageCount(int i) {
    }

    public void setIMEntranceIcon(int i) {
    }

    public IMEntranceV2NearView(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        FrameLayout frameLayout = (FrameLayout) findView(R.id.im_bubble_msg_container);
        this.f14146d = frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMEntranceV2NearView.this.mPresenter.startIMActivity();
                IMEntranceV2NearView.this.f14146d.setVisibility(8);
                GlobalOmegaUtils.trackEvent("ibt_gp_driverimnotice_ck", "type", "1");
            }
        });
    }

    /* access modifiers changed from: protected */
    public ViewGroup inflateContentView(Context context, ViewGroup viewGroup) {
        return (ViewGroup) LayoutInflater.from(context).inflate(R.layout.global_im_entrance_v2_near_layout, viewGroup, false);
    }

    public void show() {
        super.show();
        this.mIMIcon.setEnabled(true);
        this.mView.setOnClickListener(this);
    }

    public void hide() {
        super.hide();
        this.mIMIcon.setEnabled(false);
        this.mView.setOnClickListener((View.OnClickListener) null);
        this.mIMCount.setVisibility(8);
        this.f14143a.cancel();
    }

    public void refreshMessageCount(IMSysChatUnreadCount iMSysChatUnreadCount) {
        if (this.mIMCount != null) {
            int i = 0;
            this.mIMCount.setVisibility(iMSysChatUnreadCount.chatMsgUnreadCount + iMSysChatUnreadCount.sysMsgUnreadCount > 0 ? 0 : 8);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_IM_REDDOT, Boolean.valueOf(this.mIMCount.getVisibility() == 0));
            if (iMSysChatUnreadCount.chatMsgUnreadCount > 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mIMCount.getLayoutParams();
                int dp2px = ResUtils.dp2px(15.0f);
                int dp2px2 = ResUtils.dp2px(4.0f);
                int dp2px3 = ResUtils.dp2px(4.0f);
                if (iMSysChatUnreadCount.chatMsgUnreadCount > 99) {
                    dp2px = ResUtils.dp2px(25.0f);
                } else if (iMSysChatUnreadCount.chatMsgUnreadCount > 9) {
                    dp2px = ResUtils.dp2px(20.0f);
                    i = ResUtils.dp2px(2.0f);
                } else {
                    i = dp2px3;
                }
                layoutParams.width = dp2px;
                layoutParams.height = ResUtils.dp2px(15.0f);
                layoutParams.rightMargin = i;
                layoutParams.topMargin = dp2px2;
                this.mIMCount.setLayoutParams(layoutParams);
                this.mIMCount.setText(iMSysChatUnreadCount.chatMsgUnreadCount > 99 ? "99+" : String.valueOf(iMSysChatUnreadCount.chatMsgUnreadCount));
            } else if (iMSysChatUnreadCount.sysMsgUnreadCount > 0) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mIMCount.getLayoutParams();
                int dp2px4 = ResUtils.dp2px(8.0f);
                layoutParams2.width = dp2px4;
                layoutParams2.height = dp2px4;
                layoutParams2.rightMargin = ResUtils.dp2px(8.0f);
                layoutParams2.topMargin = ResUtils.dp2px(10.0f);
                this.mIMCount.setLayoutParams(layoutParams2);
                this.mIMCount.setText("");
            }
        }
    }

    public void setData(DriverOptionModel driverOptionModel) {
        super.setData(driverOptionModel);
        if (driverOptionModel.data != null && driverOptionModel.data.imMotionStatus > 0) {
            int i = driverOptionModel.data.imMotionDuration;
            if (i <= 0) {
                i = 10;
            }
            if (i > 1) {
                i--;
            }
            m9893a(i);
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", driverOptionModel.data.oid);
            hashMap.put("trigger_datetime", Long.valueOf(System.currentTimeMillis() / 1000));
            GlobalOmegaUtils.trackEvent("map_paxcommunication2_hint_change_bt", (Map<String, Object>) hashMap);
        }
    }

    public void setIMLastMsg(IMMsg iMMsg) {
        if (iMMsg == null) {
            ((RelativeLayout.LayoutParams) this.msgContainer.getLayoutParams()).width = UiUtils.dip2px(this.mContext, 255.0f);
            this.f14144b.setAlpha(1.0f);
            this.f14146d.setVisibility(8);
        } else if (iMMsg.type != IMMsgType.TYPE_SYSTEM && iMMsg.type != IMMsgType.TYPE_ORDER_STATUS_CHANGE) {
            if (this.f14146d.getVisibility() != 0) {
                updateText(iMMsg);
                this.f14146d.setVisibility(4);
                m9894a(true);
                return;
            }
            this.f14146d.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.msgContainer.getLayoutParams()).width = UiUtils.dip2px(this.mContext, 40.0f);
            this.mMsgTv.setAlpha(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mMsgTv, "alpha", new float[]{0.0f, 1.0f});
            ofFloat.setDuration(400);
            ofFloat.start();
            updateText(iMMsg);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        super.onClick(view);
        this.f14143a.cancel();
    }

    /* renamed from: a */
    private void m9893a(int i) {
        ObjectAnimator a = m9890a(this.msgContainer, i, "scaleX", 0.9f, 1.0f);
        ObjectAnimator a2 = m9890a(this.msgContainer, i, "scaleY", 0.9f, 1.0f);
        this.f14143a.playTogether(new Animator[]{a, a2});
        this.f14143a.setDuration(1000);
        this.f14143a.setInterpolator(new BounceInterpolator());
        this.f14143a.start();
    }

    /* renamed from: a */
    private ObjectAnimator m9890a(View view, int i, String str, float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, new float[]{f, f2});
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(i);
        return ofFloat;
    }

    /* renamed from: a */
    private void m9894a(final boolean z) {
        ValueAnimator valueAnimator;
        ObjectAnimator objectAnimator;
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.msgContainer.getLayoutParams();
        if (z) {
            valueAnimator = ValueAnimator.ofInt(new int[]{UiUtils.dip2px(this.mContext, 255.0f), UiUtils.dip2px(this.mContext, 40.0f)});
        } else {
            valueAnimator = ValueAnimator.ofInt(new int[]{UiUtils.dip2px(this.mContext, 40.0f), UiUtils.dip2px(this.mContext, 255.0f)});
        }
        valueAnimator.setDuration(400);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                IMEntranceV2NearView.this.msgContainer.setLayoutParams(layoutParams);
            }
        });
        if (z) {
            objectAnimator = ObjectAnimator.ofFloat(this.f14144b, "alpha", new float[]{1.0f, 0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(this.f14144b, "alpha", new float[]{0.0f, 1.0f});
        }
        objectAnimator.setDuration(300);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{valueAnimator, objectAnimator});
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (z) {
                    IMEntranceV2NearView.this.f14146d.setVisibility(0);
                }
            }
        });
        final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f14146d.getLayoutParams();
        this.f14146d.post(new Runnable() {
            public void run() {
                if (z) {
                    IMEntranceV2NearView iMEntranceV2NearView = IMEntranceV2NearView.this;
                    ValueAnimator unused = iMEntranceV2NearView.f14145c = ValueAnimator.ofInt(new int[]{UiUtils.dip2px(iMEntranceV2NearView.mContext, 30.0f), UiUtils.dip2px(IMEntranceV2NearView.this.mContext, 209.0f)});
                } else {
                    IMEntranceV2NearView iMEntranceV2NearView2 = IMEntranceV2NearView.this;
                    ValueAnimator unused2 = iMEntranceV2NearView2.f14145c = ValueAnimator.ofInt(new int[]{UiUtils.dip2px(iMEntranceV2NearView2.mContext, 209.0f), 0});
                }
                IMEntranceV2NearView.this.f14145c.setDuration(400);
                IMEntranceV2NearView.this.f14145c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        layoutParams2.width = intValue;
                        IMEntranceV2NearView.this.f14146d.setLayoutParams(layoutParams2);
                        if (!z && intValue == 0) {
                            IMEntranceV2NearView.this.f14146d.setVisibility(8);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                if (z) {
                    animatorSet.playSequentially(new Animator[]{animatorSet, IMEntranceV2NearView.this.f14145c});
                } else {
                    animatorSet.playSequentially(new Animator[]{IMEntranceV2NearView.this.f14145c, animatorSet});
                }
                animatorSet.start();
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean updateText(IMMsg iMMsg) {
        if (iMMsg.type == IMMsgType.TYPE_TEXT_RECOMMEND || iMMsg.type == IMMsgType.TYPE_TEXT) {
            this.mMsgTv.setText(iMMsg.textContent);
            return true;
        } else if (iMMsg.type != IMMsgType.TYPE_VOICE) {
            return true;
        } else {
            this.mMsgTv.setText(this.mContext.getResources().getText(R.string.GR_Pick_and_OnTrip_2020_drvCard_im_voiceMessage_contentBubble));
            return true;
        }
    }
}
