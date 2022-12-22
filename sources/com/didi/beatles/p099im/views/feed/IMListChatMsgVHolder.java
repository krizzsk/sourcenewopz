package com.didi.beatles.p099im.views.feed;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.api.entity.IMOrderStatusChangeBody;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMUserInfoCallback;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.omega.OmegaUtil;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMSpanny;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.views.feed.IMListChatVHolder;
import com.didi.beatles.p099im.views.popup.IMSessionDeletePopup;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.feed.IMListChatMsgVHolder */
public class IMListChatMsgVHolder extends IMListChatVHolder<ChatMsgListener> {
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ChatMsgListener f10252k;

    /* renamed from: l */
    private ChatMsgListener f10253l = new ChatMsgListener() {
        public void deleteMsg(View view, IMSession iMSession) {
            if (IMListChatMsgVHolder.this.f10252k != null) {
                IMListChatMsgVHolder.this.f10252k.deleteMsg(view, iMSession);
            }
        }

        public void onClick(View view, IMSession iMSession) {
            IMTraceUtil.addBusinessEvent("ddim_message_list_item_ck").add("send_uid", Long.valueOf(iMSession.getPeerUid())).report();
            if (IMListChatMsgVHolder.this.f10252k != null) {
                IMListChatMsgVHolder.this.f10252k.onClick(view, iMSession);
            }
        }
    };

    /* renamed from: com.didi.beatles.im.views.feed.IMListChatMsgVHolder$ChatMsgListener */
    public interface ChatMsgListener extends IMListChatVHolder.ClickListener {
        void deleteMsg(View view, IMSession iMSession);
    }

    public IMListChatMsgVHolder(Activity activity, ViewGroup viewGroup) {
        super(activity, viewGroup);
    }

    public void bindData(IMSession iMSession, int i, boolean z, ChatMsgListener chatMsgListener) {
        super.bindData(iMSession, i, z, this.f10253l);
        this.f10252k = chatMsgListener;
        m6986c();
        if (this.f10261h.getType() != 2) {
            m6987d();
        } else {
            m6988e();
        }
        m6989f();
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                IMListChatMsgVHolder.this.m6991h();
                return true;
            }
        });
    }

    /* renamed from: c */
    private void m6986c() {
        if (this.f10261h.getType() != 2 || !this.f10261h.getIsForbid()) {
            this.f10260g.setVisibility(8);
            return;
        }
        this.f10260g.setVisibility(0);
        this.f10260g.setImageResource(IMResource.getDrawableID(R.drawable.im_forbid_trouble));
    }

    /* renamed from: d */
    private void m6987d() {
        List<Long> userIds = this.f10261h.getUserIds();
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userIds.size() == 2 && userModel != null) {
            userModel.getUserInfo(new long[]{userIds.get(0).longValue(), userIds.get(1).longValue()}, (IMUserInfoCallback) new IMUserInfoCallback() {
                public void onUserInfoLoaded(HashMap<Long, IMUser> hashMap, long[] jArr) {
                    if (jArr.length == 2 && IMListChatMsgVHolder.this.f10261h.getUserIds().size() == 2 && jArr[0] == IMListChatMsgVHolder.this.f10261h.getUserIds().get(0).longValue() && jArr[1] == IMListChatMsgVHolder.this.f10261h.getUserIds().get(1).longValue() && IMListChatMsgVHolder.this.f10254a != null && !IMListChatMsgVHolder.this.f10254a.isFinishing()) {
                        IMUser iMUser = null;
                        if (hashMap != null) {
                            iMUser = hashMap.get(IMSession.getPeerId(IMListChatMsgVHolder.this.f10261h.getUserIds()));
                        }
                        if (iMUser == null) {
                            IMListChatMsgVHolder.this.f10255b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_user_default_name));
                            IMListChatMsgVHolder.this.f10258e.setImageResource(R.drawable.bts_im_general_default_avatar);
                            IMListChatMsgVHolder.this.f10259f.setVisibility(8);
                            return;
                        }
                        if (!TextUtils.isEmpty(iMUser.getNickName())) {
                            OmegaUtil.trackTitleNamePath(iMUser.getNickName(), IMListChatMsgVHolder.this.f10261h, 3);
                            IMListChatMsgVHolder.this.f10255b.setText(iMUser.getNickName());
                        } else {
                            IMListChatMsgVHolder.this.f10255b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_user_default_name));
                        }
                        if (!TextUtils.isEmpty(iMUser.getAvatarUrl())) {
                            BtsImageLoader.getInstance().loadInto((Object) iMUser.getAvatarUrl(), (View) IMListChatMsgVHolder.this.f10258e, (int) R.drawable.bts_im_general_default_avatar);
                        } else {
                            IMListChatMsgVHolder.this.f10258e.setImageResource(R.drawable.bts_im_general_default_avatar);
                        }
                        if (iMUser.getMIcon() == 1) {
                            IMListChatMsgVHolder.this.f10259f.setVisibility(0);
                        } else {
                            IMListChatMsgVHolder.this.f10259f.setVisibility(8);
                        }
                    }
                }
            }, false);
        }
    }

    /* renamed from: e */
    private void m6988e() {
        if (TextUtils.isEmpty(this.f10261h.getSessionName())) {
            this.f10255b.setText(IMResource.getString(R.string.bts_user_default_name));
        } else {
            this.f10255b.setText(this.f10261h.getSessionName());
        }
        if (!TextUtils.isEmpty(this.f10261h.getSessionImg())) {
            BtsImageLoader.getInstance().loadInto((Object) this.f10261h.getSessionImg(), (View) this.f10258e, IMResource.getDrawableID(R.drawable.bts_im_general_default_avatar));
        } else {
            this.f10258e.setImageResource(IMResource.getDrawableID(R.drawable.bts_im_general_default_avatar));
        }
    }

    /* renamed from: f */
    private void m6989f() {
        if (!IMTextUtil.isEmpty(this.f10261h.getDraft())) {
            this.f10256c.setText(new IMSpanny((CharSequence) IMContextInfoHelper.getContext().getString(R.string.bts_im_chat_save), (Object) new ForegroundColorSpan(IMResource.getColor(R.color.im_nomix_orange))).append((CharSequence) this.f10261h.getDraft()));
            return;
        }
        this.f10256c.setText(m6990g());
    }

    /* renamed from: g */
    private IMSpanny m6990g() {
        String str;
        StringBuilder sb;
        String str2;
        int lastMsgStatus = this.f10261h.getLastMsgStatus();
        try {
            IMOrderStatusChangeBody iMOrderStatusChangeBody = (IMOrderStatusChangeBody) IMJsonUtil.objectFromJson(this.f10261h.getLastMessage(), IMOrderStatusChangeBody.class, true);
            if (iMOrderStatusChangeBody == null) {
                str = this.f10261h.getLastMessage();
            } else if (iMOrderStatusChangeBody.format_type == 1) {
                if (IMTextUtil.isEmpty(iMOrderStatusChangeBody.title)) {
                    str = iMOrderStatusChangeBody.block.text;
                } else {
                    str = Const.jaLeft + iMOrderStatusChangeBody.title + Const.jaRight + iMOrderStatusChangeBody.block.text;
                }
            } else if (iMOrderStatusChangeBody.format_type == 2) {
                if (IMTextUtil.isEmpty(iMOrderStatusChangeBody.title)) {
                    sb = new StringBuilder();
                    sb.append(iMOrderStatusChangeBody.block.from);
                    sb.append("-");
                    str2 = iMOrderStatusChangeBody.block.f9127to;
                } else {
                    sb = new StringBuilder();
                    sb.append(Const.jaLeft);
                    sb.append(iMOrderStatusChangeBody.title);
                    sb.append(Const.jaRight);
                    sb.append(iMOrderStatusChangeBody.block.from);
                    sb.append("-");
                    str2 = iMOrderStatusChangeBody.block.f9127to;
                }
                sb.append(str2);
                str = sb.toString();
            } else {
                str = "";
            }
        } catch (Exception unused) {
            str = this.f10261h.getLastMessage();
        }
        IMSpanny iMSpanny = new IMSpanny();
        if (lastMsgStatus == 100) {
            iMSpanny.append((CharSequence) str, new ImageSpan(this.f10254a, R.drawable.bts_im_chat_msg_status));
        } else if (lastMsgStatus == 300 || lastMsgStatus == 500) {
            iMSpanny.append((CharSequence) IMContextInfoHelper.getContext().getString(R.string.bts_im_chat_send_fail), (Object) new ForegroundColorSpan(IMResource.getColor(R.color.im_nomix_orange))).append((CharSequence) str);
        } else if (TextUtils.isEmpty(str)) {
            iMSpanny.append((CharSequence) "");
        } else {
            iMSpanny.append((CharSequence) str);
        }
        return iMSpanny;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m6991h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IMSessionDeletePopup.TextConfig() {
            public String getContent() {
                return IMListChatMsgVHolder.this.itemView.getContext().getString(R.string.im_pop_delete);
            }

            public int getTextColor() {
                return Color.parseColor("#EB4D3D");
            }
        });
        new IMSessionDeletePopup(this.f10254a).show(this.f10255b, arrayList, new IMSessionDeletePopup.PopupOnClickListener() {
            public void onItemClick(int i) {
                if (i == 0 && IMListChatMsgVHolder.this.f10263j != null) {
                    ((ChatMsgListener) IMListChatMsgVHolder.this.f10263j).deleteMsg(IMListChatMsgVHolder.this.itemView, IMListChatMsgVHolder.this.f10261h);
                }
            }
        });
    }
}
