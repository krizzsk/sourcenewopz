package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.access.style.custom.IMCustomContext;
import com.didi.beatles.p099im.access.style.custom.msgcard.IMMsgCardCusView;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.api.entity.IMConfig;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.protocol.plugin.IIMPluginCardView;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.views.custom.IIMBackgroundCardView;
import com.didi.beatles.p099im.views.custom.IMDynamicRegisterCard;
import com.didi.beatles.p099im.views.imageView.IMProfileCircleImageView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMBaseRenderView */
public abstract class IMBaseRenderView<T extends IMMsgCardCusView> extends FrameLayout {
    public static String TAG = "IMBaseRenderView";
    public static final int VIEW_LOCATION_LEFT = 0;
    public static final int VIEW_LOCATION_MIDDLE = 1;
    public static final int VIEW_LOCATION_RIGHT = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f10312a;
    protected MessageAdapter adapter;

    /* renamed from: b */
    private TextView f10313b;

    /* renamed from: c */
    private TextView f10314c;
    protected View contentLayout;
    protected Context context;
    protected IMCustomContext cusContext;
    protected IMUser imUser;
    protected LayoutInflater inflater;
    protected boolean isMine;
    protected boolean isShowOtherAvatar;
    protected MessageListItemListener itemListener;
    protected ProgressBar loadingProgressBar;
    protected View mCusContentView;
    protected T mCusViewRender;
    protected int mViewLocation;
    protected IMMessage message;
    protected ImageView messageFailed;
    protected LinearLayout messageLayout;
    protected TextView nickName;
    protected int position;
    protected View rootView;
    protected LinearLayout statuslayout;
    protected IMProfileCircleImageView userHead;

    /* renamed from: com.didi.beatles.im.views.messageCard.IMBaseRenderView$MessageListItemListener */
    public interface MessageListItemListener {
        boolean onBubbleClick(IMMessage iMMessage);

        void onBubbleLongClick(View view, int i, IMMessage iMMessage);

        void onEggsMsgRender(IMConfig.EggsInfo eggsInfo);

        void onResendClick(IMMessage iMMessage);
    }

    /* access modifiers changed from: protected */
    public T createCustomView(IMBusinessConfig iMBusinessConfig, IMCustomContext iMCustomContext) {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void onFindViewById();

    /* access modifiers changed from: protected */
    public abstract View onInflatView(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract void onSetUpView(IMMessage iMMessage);

    /* access modifiers changed from: protected */
    public abstract void onUpdateView();

    /* access modifiers changed from: protected */
    public abstract void onViewClick();

    public IMBaseRenderView(Context context2) {
        super(context2);
    }

    public IMBaseRenderView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
    }

    public IMBaseRenderView(Context context2, int i, MessageAdapter messageAdapter) {
        this(context2, i, messageAdapter, false);
    }

    public IMBaseRenderView(Context context2, int i, MessageAdapter messageAdapter, boolean z) {
        super(context2);
        this.f10312a = z;
        this.context = context2;
        this.adapter = messageAdapter;
        this.mViewLocation = i;
        if (messageAdapter != null) {
            this.cusContext = messageAdapter.imCustomContext;
        }
        if (i == 0) {
            this.isMine = false;
        } else if (i == 2) {
            this.isMine = true;
        }
        this.inflater = LayoutInflater.from(context2);
        if (!this.f10312a) {
            m7039a();
            m7041b();
        }
    }

    /* renamed from: a */
    private void m7039a() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int i = this.mViewLocation;
        if (i == 0) {
            if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
                this.rootView = inflate(this.context, R.layout.bts_im_base_other_base_item_global_psg, this);
            } else {
                this.rootView = inflate(this.context, R.layout.bts_im_base_other_base_item, this);
            }
            this.userHead = (IMProfileCircleImageView) this.rootView.findViewById(R.id.user_portrait);
            this.statuslayout = (LinearLayout) this.rootView.findViewById(R.id.im_status_layout);
            this.messageFailed = (ImageView) this.rootView.findViewById(R.id.message_state_failed);
            this.loadingProgressBar = (ProgressBar) this.rootView.findViewById(R.id.progressBar1);
            this.messageLayout = (LinearLayout) this.rootView.findViewById(R.id.content_layout);
            this.f10314c = (TextView) this.rootView.findViewById(R.id.user_name);
        } else if (i == 1) {
            View inflate = inflate(this.context, R.layout.bts_im_base_middle_base_item, this);
            this.rootView = inflate;
            this.messageLayout = (LinearLayout) inflate.findViewById(R.id.content_layout);
        } else if (i == 2) {
            if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
                this.rootView = inflate(this.context, R.layout.bts_im_base_mine_base_item_global_psg, this);
            } else {
                this.rootView = inflate(this.context, R.layout.bts_im_base_mine_base_item, this);
            }
            this.userHead = (IMProfileCircleImageView) this.rootView.findViewById(R.id.user_portrait);
            this.statuslayout = (LinearLayout) this.rootView.findViewById(R.id.im_status_layout);
            this.messageFailed = (ImageView) this.rootView.findViewById(R.id.message_state_failed);
            this.loadingProgressBar = (ProgressBar) this.rootView.findViewById(R.id.progressBar1);
            this.f10313b = (TextView) this.rootView.findViewById(R.id.msg_read_status);
            this.messageLayout = (LinearLayout) this.rootView.findViewById(R.id.content_layout);
        }
    }

    /* renamed from: b */
    private void m7041b() {
        addMessageLayout();
        onFindViewById();
    }

    public void addRegisterView(View view, int i) {
        this.mViewLocation = i;
        m7039a();
        if (view != null) {
            if (!(view instanceof IIMBackgroundCardView) || !((IIMBackgroundCardView) view).setBackground(i)) {
                int i2 = this.mViewLocation;
                if (i2 == 2) {
                    view.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_right_white_bubble_selector));
                } else if (i2 == 0) {
                    view.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_left_bubble_selector));
                }
            }
            this.contentLayout = view;
            this.messageLayout.addView(view);
        }
    }

    public void setUpView(IMMessage iMMessage, IMUser iMUser, MessageListItemListener messageListItemListener, int i) {
        IMLog.m6630d("setUpView " + getClass().getSimpleName());
        this.message = iMMessage;
        this.itemListener = messageListItemListener;
        this.imUser = iMUser;
        this.position = i;
        render(iMMessage, iMUser);
        setClickListener(iMUser);
        onSetUpView(iMMessage);
    }

    /* access modifiers changed from: protected */
    public void addMessageLayout() {
        View onInflatView = onInflatView(this.messageLayout);
        this.contentLayout = onInflatView;
        if (this.mViewLocation == 1 && onInflatView != null) {
            String str = TAG;
            IMLog.m6631d(str, "addMessageLayout child width is " + this.contentLayout.getLayoutParams().width + " height is " + this.contentLayout.getLayoutParams().height);
        }
        this.messageLayout.addView(this.contentLayout);
    }

    /* access modifiers changed from: protected */
    public MessageListItemListener getClickListener() {
        return this.itemListener;
    }

    /* access modifiers changed from: protected */
    public void msgSendinging() {
        if (this.message.getType() == 196608) {
            this.messageFailed.setVisibility(8);
            this.loadingProgressBar.setVisibility(8);
        }
        this.messageFailed.setVisibility(8);
        this.loadingProgressBar.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void msgFailure(boolean z) {
        this.messageFailed.setVisibility(0);
        this.messageFailed.setEnabled(z);
        this.loadingProgressBar.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void msgSuccess() {
        this.messageFailed.setVisibility(8);
        this.loadingProgressBar.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void render(IMMessage iMMessage, IMUser iMUser) {
        if (this.mViewLocation != 1 && this.adapter != null) {
            int status = iMMessage.getStatus();
            if (iMUser == null) {
                iMUser = this.adapter.getUserModel(this.message.getSenderUid());
            }
            if (iMUser != null) {
                if (IMContextInfoHelper.getUid() == this.message.getSenderUid() || this.isShowOtherAvatar) {
                    this.userHead.setImageSrc(iMUser.getAvatarUrl(), R.drawable.bts_im_general_default_avatar);
                }
                if (TextUtils.isEmpty(iMMessage.getNickName())) {
                    this.userHead.setContentDescription(iMMessage.getNickName());
                } else {
                    this.userHead.setContentDescription(IMResource.getString(R.string.im_accessibility_avatar));
                }
                if (!TextUtils.isEmpty(iMUser.getUserTag())) {
                    this.userHead.setText(iMUser.getUserTag());
                } else {
                    this.userHead.setText((String) null);
                }
            }
            if (status == 200) {
                msgSuccess();
            } else if (status == 300) {
                msgFailure(true);
                if (this.mViewLocation == 2) {
                    this.f10313b.setVisibility(4);
                }
            } else if (status != 500) {
                msgSendinging();
                if (this.mViewLocation == 2) {
                    this.f10313b.setVisibility(4);
                }
            } else {
                msgFailure(false);
                if (this.mViewLocation == 2) {
                    this.f10313b.setVisibility(4);
                }
            }
            MessageAdapter messageAdapter = this.adapter;
            if (messageAdapter != null && messageAdapter.getSupportStatus() && status == 200 && this.message.isSupportReadStatus() && this.mViewLocation == 2) {
                this.f10313b.setVisibility(0);
                if (iMMessage.isRead()) {
                    this.f10313b.setText(IMResource.getString(R.string.im_msg_status_has_read));
                    this.f10313b.setTextColor(IMResource.getColor(R.color.im_color_msg_has_read));
                } else {
                    this.f10313b.setText(IMResource.getString(R.string.im_msg_status_un_read));
                    this.f10313b.setTextColor(IMResource.getColor(R.color.im_color_msg_un_read));
                }
            }
            if (this.f10314c == null) {
                return;
            }
            if (this.adapter.getSessionType() != 2 || iMUser == null) {
                this.f10314c.setVisibility(8);
                return;
            }
            this.f10314c.setVisibility(0);
            this.f10314c.setText(iMUser.getNickName());
        }
    }

    public void setShowUserAvatar(boolean z) {
        this.isShowOtherAvatar = z;
    }

    private void setClickListener(final IMUser iMUser) {
        if (this.contentLayout != null) {
            if (!(this.message.getType() == 393217 || this.message.getType() == 393219 || this.message.getType() == 393220 || this.message.getType() == 393224)) {
                this.contentLayout.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        if (IMBaseRenderView.this.itemListener == null) {
                            return true;
                        }
                        IMBaseRenderView.this.itemListener.onBubbleLongClick(IMBaseRenderView.this.contentLayout, IMBaseRenderView.this.position, IMBaseRenderView.this.message);
                        return true;
                    }
                });
            }
            this.contentLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMBaseRenderView.this.onViewClick();
                    if (!IMBaseRenderView.this.f10312a) {
                        return;
                    }
                    if ((IMBaseRenderView.this.contentLayout instanceof IMDynamicRegisterCard) && ((IMDynamicRegisterCard) IMBaseRenderView.this.contentLayout).getOnClickListener() != null) {
                        ((IMDynamicRegisterCard) IMBaseRenderView.this.contentLayout).getOnClickListener().onClick(view);
                    } else if (IMBaseRenderView.this.contentLayout instanceof IIMPluginCardView) {
                        ((IIMPluginCardView) IMBaseRenderView.this.contentLayout).onCardClick(view);
                    }
                }
            });
        }
        IMProfileCircleImageView iMProfileCircleImageView = this.userHead;
        if (iMProfileCircleImageView != null) {
            iMProfileCircleImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMUser iMUser = iMUser;
                    if (iMUser != null && iMUser.getExtendInfo() != null) {
                        String str = iMUser.getExtendInfo().ulink;
                        if (!TextUtils.isEmpty(str)) {
                            IMCommonUtil.startUriActivity(IMBaseRenderView.this.context, str);
                        }
                    }
                }
            });
        }
        ImageView imageView = this.messageFailed;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (IMBaseRenderView.this.itemListener != null) {
                        IMBaseRenderView.this.itemListener.onResendClick(IMBaseRenderView.this.message);
                    }
                }
            });
        }
    }

    public View getCardView() {
        return this.contentLayout;
    }

    /* access modifiers changed from: protected */
    public ProgressBar getLoadingProgressBar() {
        return this.loadingProgressBar;
    }

    /* access modifiers changed from: protected */
    public ImageView getMessageFailed() {
        return this.messageFailed;
    }

    /* access modifiers changed from: protected */
    public final View tryLoadCustomView(ViewGroup viewGroup) {
        IMSession session;
        T createCustomView;
        View layoutView;
        IMCustomContext iMCustomContext = this.cusContext;
        if (iMCustomContext == null || (session = iMCustomContext.getSession()) == null || (createCustomView = createCustomView(IMEngine.getInstance(getContext()).getCurrentBusinessConfig(session.getBusinessId()), this.cusContext)) == null || (layoutView = createCustomView.layoutView(viewGroup, this.isMine)) == null) {
            return null;
        }
        this.mCusViewRender = createCustomView;
        this.mCusContentView = layoutView;
        return layoutView;
    }

    /* access modifiers changed from: protected */
    public boolean isCustomView() {
        return (this.mCusViewRender == null || this.mCusContentView == null) ? false : true;
    }
}
