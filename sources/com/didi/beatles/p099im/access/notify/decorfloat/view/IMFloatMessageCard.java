package com.didi.beatles.p099im.access.notify.decorfloat.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.notify.NotificationAdapter;
import com.didi.beatles.p099im.access.notify.decorfloat.IIMDecorFloatMsg;
import com.didi.beatles.p099im.access.notify.decorfloat.IIMDecorFloatView;
import com.didi.beatles.p099im.access.notify.decorfloat.IMDecorFloatController;
import com.didi.beatles.p099im.access.utils.Parser;
import com.didi.beatles.p099im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p099im.common.widget.IMOnAntiShakeClickListener;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMMessageReadStatusManager;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMMessageCallback;
import com.didi.beatles.p099im.module.IMSendMessageCallback;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.omega.IMMessageTraceUtil;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.omega.OmegaUtil;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.views.IMInterceptEventLinearLayout;
import com.didi.beatles.p099im.views.imageView.IMRoundedImageView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.access.notify.decorfloat.view.IMFloatMessageCard */
public class IMFloatMessageCard extends FrameLayout implements LifecycleObserver, IIMDecorFloatView {

    /* renamed from: a */
    private static final String f8817a = IMFloatMessageCard.class.getSimpleName();

    /* renamed from: b */
    private static final int f8818b = 0;

    /* renamed from: c */
    private static final int f8819c = 1;

    /* renamed from: d */
    private static final int f8820d = 2;

    /* renamed from: e */
    private static final int f8821e = 122;

    /* renamed from: f */
    private static final int f8822f = 78;

    /* renamed from: k */
    private static final int f8823k = 0;

    /* renamed from: l */
    private static final int f8824l = 1;

    /* renamed from: m */
    private static final int f8825m = 2;

    /* renamed from: n */
    private static final int f8826n = 1000;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IIMDecorFloatMsg.RequestCallback f8827g;

    /* renamed from: h */
    private IMMessageCallback f8828h;

    /* renamed from: i */
    private long f8829i;

    /* renamed from: j */
    private IMMessage f8830j;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f8831o;

    /* renamed from: p */
    private View f8832p;

    public IMFloatMessageCard(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMFloatMessageCard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMFloatMessageCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8828h = null;
        this.f8829i = 0;
    }

    public void setRequestCallback(IIMDecorFloatMsg.RequestCallback requestCallback) {
        this.f8827g = requestCallback;
    }

    /* renamed from: a */
    private void m5889a() {
        if (getContext() == null || !(getContext() instanceof FragmentActivity) || ((FragmentActivity) getContext()).getLifecycle() == null) {
            String str = f8817a;
            IMLog.m6632e(str, "[addLifecycleObserver] invalid activity context->" + getContext());
            return;
        }
        ((FragmentActivity) getContext()).getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestroy() {
        IMLog.m6631d(f8817a, "[onActivityDestroy]");
        m5890a(0);
        long j = this.f8829i;
        if (j > 0) {
            m5901b(j);
        }
    }

    /* renamed from: b */
    private void m5900b() {
        if (getContext() == null || !(getContext() instanceof FragmentActivity) || ((FragmentActivity) getContext()).getLifecycle() == null) {
            String str = f8817a;
            IMLog.m6632e(str, "[removeLifecycleObserver] invalid activity context->" + getContext());
            return;
        }
        ((FragmentActivity) getContext()).getLifecycle().removeObserver(this);
    }

    public boolean bind(final IMMessage iMMessage) {
        ViewGroup.LayoutParams layoutParams;
        if (this.f8832p != null) {
            IMLog.m6632e(f8817a, "[bind] remove all views");
            removeAllViews();
            this.f8832p = null;
        }
        IMResource.setBusinessId(iMMessage.getBusinessId());
        View a = m5886a(iMMessage, iMMessage.showFailedMsg);
        this.f8832p = a;
        if (a == null) {
            return false;
        }
        this.f8830j = iMMessage;
        m5896a(iMMessage);
        if (!m5903b(iMMessage) || iMMessage.showFailedMsg) {
            layoutParams = m5887a((ViewGroup.LayoutParams) null, 2);
        } else {
            layoutParams = m5887a((ViewGroup.LayoutParams) null, 0);
        }
        OmegaUtil.trackExtendMsg("ddim_msg_all_display_sw", iMMessage, (Map<String, Object>) null);
        this.f8832p.setOnClickListener(new IMOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                IMFloatMessageCard.this.m5897a(iMMessage, 2);
                IMMessageTraceUtil.trackMessageCoreEvent("ddim_push_all_ck", iMMessage).add("push_type", 1).add("push_type_new", 1).report();
                IMTraceUtil.addBusinessEvent("msg_remind_ck").add("business_id", Integer.valueOf(iMMessage.getBusinessId())).add("type", 0).add("msg_id", Long.valueOf(iMMessage.getMid())).report();
            }
        });
        ((IMInterceptEventLinearLayout) this.f8832p).setSlideListener(new IMInterceptEventLinearLayout.SlideListener() {
            public void onSlideDown() {
            }

            public void onSlideUp() {
                IMFloatMessageCard.this.m5890a(1);
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_upcls_ck", iMMessage);
            }
        });
        addView(this.f8832p, layoutParams);
        IMMessageTraceUtil.trackMessageCoreEvent("ddim_push_all_sw", iMMessage).add("push_type", 1).add("push_type_new", 1).report();
        IMTraceUtil.addBusinessEvent("msg_remind_sw").add("business_id", Integer.valueOf(iMMessage.getBusinessId())).add("type", 0).add("msg_id", Long.valueOf(iMMessage.getMid())).report();
        m5889a();
        return true;
    }

    /* renamed from: a */
    private void m5896a(IMMessage iMMessage) {
        if (iMMessage != null && IMContextInfoHelper.getContext() != null && "com.sdu.didi.gsui".equals(IMContextInfoHelper.getContext().getPackageName()) && iMMessage.mact == 1) {
            IMMessageReadStatusManager.getInstance().ackHasReadMsg(iMMessage);
        }
    }

    /* renamed from: a */
    private ViewGroup.LayoutParams m5887a(ViewGroup.LayoutParams layoutParams, int i) {
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        if (i == 0) {
            layoutParams.height = IMViewUtil.dp2px(getContext(), 122.0f);
        } else if (i == 1) {
            layoutParams.height = -1;
        } else if (i == 2) {
            layoutParams.height = IMViewUtil.dp2px(getContext(), 78.0f);
        }
        return layoutParams;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5905c() {
        try {
            if (this.f8832p != null) {
                this.f8832p.setLayoutParams(m5887a(this.f8832p.getLayoutParams(), 1));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private View m5886a(final IMMessage iMMessage, boolean z) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.im_message_push_noti_view, (ViewGroup) null);
        inflate.setBackgroundColor(IMResource.getColor(R.color.im_float_cover_color));
        inflate.findViewById(R.id.im_float_info_rl).setBackgroundColor(IMResource.getColor(R.color.im_nomix_color_float_window_back));
        TextView textView = (TextView) inflate.findViewById(R.id.im_content);
        TextView textView2 = (TextView) inflate.findViewById(R.id.im_push_nick);
        IMRoundedImageView iMRoundedImageView = (IMRoundedImageView) inflate.findViewById(R.id.contact_portrait);
        if (z) {
            if (!TextUtils.isEmpty(iMMessage.pushText)) {
                textView2.setText(iMMessage.pushText);
            }
            iMRoundedImageView.setImageResource(IMResource.getDrawableID(R.drawable.im_send_failed_icon));
            textView.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
            textView.setText(R.string.im_float_widow_send_failed_title);
            return inflate;
        }
        if (!TextUtils.isEmpty(iMMessage.floatPushText)) {
            textView2.setText(iMMessage.floatPushText);
        }
        if (!TextUtils.isEmpty(iMMessage.getNickName())) {
            textView.setText(iMMessage.getNickName());
        }
        if (IMEngine.getInstance(getContext()).getCurrentBusinessConfig(iMMessage.getSidType(), iMMessage.getBusinessId()).isShowPeerAvatar()) {
            if (TextUtils.isEmpty(iMMessage.getHeadUrl())) {
                m5899a(iMRoundedImageView, iMMessage.getSenderUid());
            } else {
                BtsImageLoader.getInstance().loadInto(iMMessage.getHeadUrl(), iMRoundedImageView);
            }
        }
        if (!m5903b(iMMessage)) {
            return inflate;
        }
        m5891a(iMMessage.getSid());
        inflate.findViewById(R.id.push_noti_line).setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        inflate.findViewById(R.id.im_float_quick_reply).setBackgroundColor(IMResource.getColor(R.color.im_nomix_color_float_window_back));
        final View findViewById = inflate.findViewById(R.id.reply_container);
        final TextView textView3 = (TextView) inflate.findViewById(R.id.reply_txt);
        textView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMMessageReadStatusManager.getInstance().ackHasReadMsg(iMMessage);
                textView3.setVisibility(8);
                findViewById.setVisibility(0);
                if (IMFloatMessageCard.this.f8827g != null) {
                    IMFloatMessageCard.this.f8827g.requestCancelDismissTask();
                }
                IMFloatMessageCard.this.m5905c();
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_qkrply_ck", iMMessage);
            }
        });
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        final NotificationAdapter notificationAdapter = new NotificationAdapter(getContext(), IMContextInfoHelper.getQuickReplyList(iMMessage.getBusinessId()));
        notificationAdapter.setOnItemClickListener(new NotificationAdapter.MyItemClickListener() {
            public void onItemClick(final NotificationAdapter.ViewHolder viewHolder, String str) {
                IMFloatMessageCard.this.m5898a(iMMessage, str);
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        notificationAdapter.showHasSend(viewHolder);
                    }
                }, 200);
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        IMFloatMessageCard.this.m5890a(0);
                    }
                }, 1000);
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_qkmsg_ck", iMMessage);
            }
        });
        recyclerView.setAdapter(notificationAdapter);
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.im_notify_list_footer, recyclerView, false);
        inflate2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_other_ck", iMMessage);
                IMFloatMessageCard.this.m5897a(iMMessage, 1);
            }
        });
        inflate.findViewById(R.id.reply_float_cover).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_mencng_ck", iMMessage);
                IMFloatMessageCard.this.m5890a(0);
            }
        });
        notificationAdapter.setFooterView(inflate2);
        ((IMInterceptEventLinearLayout) inflate.findViewById(R.id.notifloat_intercept_ll)).registerInterceptListener(new IMInterceptEventLinearLayout.InterceptCallback() {
            public boolean shouldIntercept() {
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                ArrayList<String> quickReplyList = IMContextInfoHelper.getQuickReplyList(iMMessage.getBusinessId());
                return quickReplyList != null && quickReplyList.size() <= findLastVisibleItemPosition;
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5890a(int i) {
        IIMDecorFloatMsg.RequestCallback requestCallback = this.f8827g;
        if (requestCallback != null) {
            requestCallback.requestDismiss(i);
            this.f8832p = null;
        }
        m5900b();
    }

    public void onFloatViewRemoved(int i) {
        this.f8832p = null;
        m5900b();
        long j = this.f8829i;
        if (j > 0) {
            m5901b(j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5897a(IMMessage iMMessage, int i) {
        m5890a(2);
        String dispatchMessageActionUrl = Parser.getDispatchMessageActionUrl(iMMessage);
        if (!TextUtils.isEmpty(dispatchMessageActionUrl)) {
            String str = f8817a;
            IMLog.m6631d(str, "IM Push Log Open Uri:" + dispatchMessageActionUrl);
            IMCommonUtil.startUriActivity(getContext(), dispatchMessageActionUrl, (Object) null);
            return;
        }
        IMBusinessParam iMBusinessParam = new IMBusinessParam();
        iMBusinessParam.setSessionId(iMMessage.getSid());
        iMBusinessParam.setSelfUid(IMContextInfoHelper.getUid());
        iMBusinessParam.setPeerUid(iMMessage.getSenderUid());
        iMBusinessParam.setBusinessId(iMMessage.getBusinessId());
        iMBusinessParam.setOrderId(iMMessage.getoId());
        iMBusinessParam.setRouteId(iMMessage.getRouteId());
        iMBusinessParam.setSessionType(iMMessage.getSidType());
        iMBusinessParam.setBottomInputConfig(i);
        IMEngine.startIMActivityWithNewTaskFlag(getContext(), iMBusinessParam, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5898a(IMMessage iMMessage, String str) {
        if (iMMessage != null) {
            this.f8831o = iMMessage.nickName;
            IMUser iMUser = new IMUser();
            iMUser.setUid(IMContextInfoHelper.getUid());
            IMUser iMUser2 = new IMUser();
            iMUser2.setUid(iMMessage.getSenderUid());
            ArrayList arrayList = new ArrayList();
            arrayList.add(iMUser);
            arrayList.add(iMUser2);
            IMBusinessParam iMBusinessParam = new IMBusinessParam();
            iMBusinessParam.setIsQuick(1);
            IMSession iMSession = new IMSession();
            iMSession.setSessionId(iMMessage.getSid());
            iMSession.setUserInfos(arrayList);
            iMSession.setBusinessId(iMMessage.getBusinessId());
            if (IMManager.getInstance().getMessageModel() != null) {
                IMManager.getInstance().getMessageModel().sendTextMessage(str, 65536, iMBusinessParam, iMSession, (Object) null, 0, (IMSendMessageCallback) null);
                OmegaUtil.trackSendMsgOmega(iMMessage.getBusinessId(), iMMessage.getSid(), 1);
                return;
            }
            IMLog.m6632e(f8817a, "send message failed since messageModel is null");
        }
    }

    /* renamed from: a */
    private void m5891a(long j) {
        this.f8829i = j;
        this.f8828h = new IMMessageCallback() {
            public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
            }

            public void onReadStatusChange(List<IMMessage> list, boolean z) {
            }

            public void onReceive(List<IMMessage> list) {
            }

            public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                IMFloatMessageCard.this.m5901b(iMMessage.getSid());
                if (i == 202) {
                    iMMessage.setPushText(String.format(IMFloatMessageCard.this.getContext().getString(R.string.im_float_widow_send_failed_content), new Object[]{IMFloatMessageCard.this.f8831o}));
                    iMMessage.showFailedMsg = true;
                    IMDecorFloatController.getInstance().add(iMMessage);
                }
            }
        };
        if (IMManager.getInstance().getMessageModel() != null) {
            IMManager.getInstance().getMessageModel().registerMessageCallback(this.f8828h, j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5901b(long j) {
        if (IMManager.getInstance().getMessageModel() != null) {
            IMManager.getInstance().getMessageModel().unregisterMessageCallback(j);
        }
    }

    /* renamed from: a */
    private void m5899a(IMRoundedImageView iMRoundedImageView, long j) {
        IMUser userInfoFromCache;
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userModel != null && (userInfoFromCache = userModel.getUserInfoFromCache(j)) != null && !TextUtils.isEmpty(userInfoFromCache.getAvatarUrl())) {
            BtsImageLoader.getInstance().loadInto(userInfoFromCache.getAvatarUrl(), iMRoundedImageView);
        }
    }

    /* renamed from: b */
    private boolean m5903b(IMMessage iMMessage) {
        int businessId = iMMessage.getBusinessId();
        if (!IMEngine.getInstance(getContext()).getCurrentBusinessConfig(iMMessage.getSidType(), businessId).isFloatShowQuickButton()) {
            IMLog.m6632e(f8817a, "The Apollo key isQuickButtonShow is off");
            return false;
        } else if (iMMessage.getType() != 65536) {
            IMLog.m6632e(f8817a, "msg type not text");
            return false;
        } else if (IMContextInfoHelper.getQuickReplyList(businessId) != null) {
            return true;
        } else {
            IMLog.m6632e(f8817a, "quick reply list is null");
            return false;
        }
    }
}
