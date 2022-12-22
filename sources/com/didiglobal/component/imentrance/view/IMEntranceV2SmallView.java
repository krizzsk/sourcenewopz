package com.didiglobal.component.imentrance.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.beatles.p099im.access.msg.IMMsg;
import com.didi.beatles.p099im.access.msg.IMMsgType;
import com.didi.beatles.p099im.module.entity.IMSysChatUnreadCount;
import com.didi.component.core.ComponentParams;
import com.didi.component.imentrance.AbsIMEntrancePresenter;
import com.didi.component.imentrance.impl.IMEntranceViewBase;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0010H\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0010H\u0016J\u0012\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010&\u001a\u00020\u001bH\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didiglobal/component/imentrance/view/IMEntranceV2SmallView;", "Lcom/didi/component/imentrance/impl/IMEntranceViewBase;", "params", "Lcom/didi/component/core/ComponentParams;", "context", "Landroid/content/Context;", "container", "Landroid/view/ViewGroup;", "(Lcom/didi/component/core/ComponentParams;Landroid/content/Context;Landroid/view/ViewGroup;)V", "imIcon", "Landroid/widget/ImageView;", "getImIcon", "()Landroid/widget/ImageView;", "lastMessage", "Lcom/didi/beatles/im/access/msg/IMMsg;", "messageBubbleAnchor", "", "messageBubbleHelper", "Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper;", "messageBubbleTint", "notifyLastMessage", "", "checkNewMessage", "message", "findBubbleAnchorView", "Landroid/view/View;", "hide", "", "inflateContentView", "viewGroup", "refreshMessageCount", "unreadCount", "Lcom/didi/beatles/im/module/entity/IMSysChatUnreadCount;", "count", "setIMEntranceIcon", "rid", "setIMLastMsg", "msg", "show", "comp-imentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IMEntranceV2SmallView.kt */
public final class IMEntranceV2SmallView extends IMEntranceViewBase {

    /* renamed from: a */
    private IMMsg f49848a;

    /* renamed from: b */
    private boolean f49849b;

    /* renamed from: c */
    private int f49850c;

    /* renamed from: d */
    private int f49851d;

    /* renamed from: e */
    private MessageBubbleHelper f49852e;

    public void refreshMessageCount(int i) {
    }

    public void setIMEntranceIcon(int i) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IMEntranceV2SmallView(ComponentParams componentParams, Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(componentParams, "params");
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = componentParams.extras;
        this.f49849b = bundle.getBoolean("notify_message");
        this.f49850c = bundle.getInt("message_anchor_view");
        this.f49851d = bundle.getInt("message_bubble_tint_color");
        if (this.f49849b) {
            this.f49852e = new MessageBubbleHelper();
        }
    }

    /* renamed from: a */
    private final ImageView m35937a() {
        return (ImageView) findView(R.id.im_entrance_icon);
    }

    /* access modifiers changed from: protected */
    public ViewGroup inflateContentView(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_im_entrance_v2_small_layout, viewGroup, false);
        if (inflate != null) {
            return (ViewGroup) inflate;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public void show() {
        super.show();
        ImageView a = m35937a();
        if (a != null) {
            a.setEnabled(true);
        }
        this.mIMCount.setVisibility(0);
        this.mView.setOnClickListener(this);
    }

    public void hide() {
        super.hide();
        ImageView a = m35937a();
        if (a != null) {
            a.setEnabled(false);
        }
        this.mIMCount.setVisibility(8);
        this.mView.setOnClickListener((View.OnClickListener) null);
    }

    public void setIMLastMsg(IMMsg iMMsg) {
        MessageBubbleHelper messageBubbleHelper;
        if (iMMsg == null || !this.f49849b || this.f49850c == 0) {
            AbsIMEntrancePresenter absIMEntrancePresenter = this.mPresenter;
            if (absIMEntrancePresenter != null) {
                absIMEntrancePresenter.notifyShowMsgBubble(false);
            }
        } else if (m35938a(iMMsg) && iMMsg.type != IMMsgType.TYPE_SYSTEM && iMMsg.type != IMMsgType.TYPE_ORDER_STATUS_CHANGE) {
            this.f49848a = iMMsg;
            AbsIMEntrancePresenter absIMEntrancePresenter2 = this.mPresenter;
            if (absIMEntrancePresenter2 != null) {
                absIMEntrancePresenter2.notifyShowMsgBubble(true);
            }
            View b = m35939b();
            if (b != null && (messageBubbleHelper = this.f49852e) != null) {
                Context context = this.mContext;
                Intrinsics.checkNotNullExpressionValue(context, "mContext");
                messageBubbleHelper.popupMessage(context, iMMsg, b, this.f49851d, new IMEntranceV2SmallView$setIMLastMsg$1$1(this));
            }
        }
    }

    public void refreshMessageCount(IMSysChatUnreadCount iMSysChatUnreadCount) {
        Intrinsics.checkNotNullParameter(iMSysChatUnreadCount, "unreadCount");
        refreshMessageCount(this.mIMCount, iMSysChatUnreadCount);
    }

    /* renamed from: b */
    private final View m35939b() {
        View findViewById;
        ViewGroup viewGroup = this.mView;
        Void voidR = null;
        if (viewGroup != null) {
            ViewParent parent = viewGroup.getParent();
            while (parent != null) {
                if ((parent instanceof ViewGroup) && (findViewById = ((ViewGroup) parent).findViewById(this.f49850c)) != null) {
                    return findViewById;
                }
                parent = parent.getParent();
                if ((parent instanceof FrameLayout) && ((FrameLayout) parent).getId() == 16908290) {
                    return null;
                }
            }
            voidR = null;
        }
        return (View) voidR;
    }

    /* renamed from: a */
    private final boolean m35938a(IMMsg iMMsg) {
        IMMsg iMMsg2 = this.f49848a;
        boolean z = false;
        if (iMMsg2 != null) {
            if (!(iMMsg2.messageId != iMMsg.messageId)) {
                z = true;
            }
        }
        return !z;
    }
}
