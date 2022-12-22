package com.didi.beatles.p099im.views.feed;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMDateUtil;
import com.didi.beatles.p099im.views.feed.IMListChatVHolder.ClickListener;
import com.didi.beatles.p099im.views.imageView.IMCircleImageView;
import com.taxis99.R;
import java.util.Date;

/* renamed from: com.didi.beatles.im.views.feed.IMListChatVHolder */
public abstract class IMListChatVHolder<T extends ClickListener> extends IMListTraceVHolder {

    /* renamed from: a */
    Activity f10254a;

    /* renamed from: b */
    TextView f10255b;

    /* renamed from: c */
    TextView f10256c;

    /* renamed from: d */
    TextView f10257d;

    /* renamed from: e */
    IMCircleImageView f10258e;

    /* renamed from: f */
    ImageView f10259f;

    /* renamed from: g */
    ImageView f10260g;

    /* renamed from: h */
    IMSession f10261h;

    /* renamed from: i */
    int f10262i;

    /* renamed from: j */
    T f10263j;

    /* renamed from: k */
    private TextView f10264k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TextView f10265l;

    /* renamed from: m */
    private TextView f10266m;

    /* renamed from: n */
    private View f10267n;

    /* renamed from: o */
    private TextView f10268o;

    /* renamed from: com.didi.beatles.im.views.feed.IMListChatVHolder$AnimationCallback */
    public interface AnimationCallback {
        void finishAnimation();
    }

    /* renamed from: com.didi.beatles.im.views.feed.IMListChatVHolder$ClickListener */
    interface ClickListener {
        void onClick(View view, IMSession iMSession);
    }

    public void traceHolder() {
    }

    IMListChatVHolder(Activity activity, ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_list_item_chat, viewGroup, false));
        this.f10254a = activity;
        m6993c();
    }

    /* renamed from: c */
    private void m6993c() {
        this.f10258e = (IMCircleImageView) this.itemView.findViewById(R.id.contact_portrait);
        this.f10255b = (TextView) this.itemView.findViewById(R.id.shop_name);
        this.f10256c = (TextView) this.itemView.findViewById(R.id.message_body);
        this.f10257d = (TextView) this.itemView.findViewById(R.id.message_time);
        this.f10265l = (TextView) this.itemView.findViewById(R.id.message_count_notify);
        this.f10266m = (TextView) this.itemView.findViewById(R.id.message_red_notify);
        this.f10259f = (ImageView) this.itemView.findViewById(R.id.im_chat_mark);
        this.f10264k = (TextView) this.itemView.findViewById(R.id.im_chat_bussiness_icon);
        this.f10267n = this.itemView.findViewById(R.id.message_bottom_line);
        this.f10260g = (ImageView) this.itemView.findViewById(R.id.forbid_iv);
        this.f10268o = (TextView) this.itemView.findViewById(R.id.tv_session_label);
        this.f10258e.setImageResource(R.drawable.bts_im_general_default_avatar);
        this.f10259f.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_chat_user_mark_icon));
    }

    public void bindData(IMSession iMSession, int i, boolean z, T t) {
        this.f10261h = iMSession;
        this.f10262i = i;
        this.f10263j = t;
        m6994d();
        m6995e();
        mo44252a();
        mo44253b();
        this.f10267n.setVisibility(z ? 8 : 0);
        this.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMListChatVHolder.this.f10263j != null) {
                    IMListChatVHolder.this.f10263j.onClick(IMListChatVHolder.this.itemView, IMListChatVHolder.this.f10261h);
                }
            }
        });
    }

    /* renamed from: d */
    private void m6994d() {
        this.f10265l.clearAnimation();
        int unreadCount = this.f10261h.getUnreadCount();
        if (unreadCount <= 0) {
            unreadCount = this.f10261h.getRedDotCount();
        }
        if (unreadCount > 0) {
            String valueOf = String.valueOf(unreadCount);
            if (unreadCount > 99) {
                valueOf = "···";
            }
            this.f10265l.setBackgroundResource(R.drawable.im_dots_with_number);
            this.f10265l.setVisibility(0);
            this.f10266m.setVisibility(8);
            this.f10265l.setText(valueOf);
            return;
        }
        this.f10265l.setVisibility(8);
        this.f10266m.setVisibility(8);
    }

    /* renamed from: e */
    private void m6995e() {
        if (this.f10261h.getExtendSessionInfo() == null || TextUtils.isEmpty(this.f10261h.getExtendSessionInfo().stag)) {
            this.f10264k.setVisibility(8);
            return;
        }
        this.f10264k.setVisibility(0);
        this.f10264k.setText(this.f10261h.getExtendSessionInfo().stag);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44252a() {
        this.f10257d.setText(IMDateUtil.getListTimeDiffDesc(this.itemView.getContext(), new Date(this.f10261h.getLastModifyTime())));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo44253b() {
        if (this.f10261h.getExtendSessionInfo() == null || TextUtils.isEmpty(this.f10261h.getExtendSessionInfo().label)) {
            this.f10268o.setVisibility(8);
            return;
        }
        this.f10268o.setVisibility(0);
        this.f10268o.setText(this.f10261h.getExtendSessionInfo().label);
    }

    public void clearAnimation(Interpolator interpolator, final AnimationCallback animationCallback) {
        if (this.f10265l.getVisibility() != 8) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(400);
            scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    IMListChatVHolder.this.f10265l.setVisibility(8);
                    AnimationCallback animationCallback = animationCallback;
                    if (animationCallback != null) {
                        animationCallback.finishAnimation();
                    }
                }
            });
            scaleAnimation.setInterpolator(interpolator);
            this.f10265l.startAnimation(scaleAnimation);
        }
    }
}
