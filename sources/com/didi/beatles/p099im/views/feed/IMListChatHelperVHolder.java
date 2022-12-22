package com.didi.beatles.p099im.views.feed;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.api.entity.IMHelperBody;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMUserInfoCallback;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.views.feed.IMListChatVHolder;
import com.didi.beatles.p099im.views.popup.IMSessionDeletePopup;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.feed.IMListChatHelperVHolder */
public class IMListChatHelperVHolder extends IMListChatVHolder<ChatHelperListener> {
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ChatHelperListener f10250k;

    /* renamed from: l */
    private ChatHelperListener f10251l = new ChatHelperListener() {
        public void deleteHelper(View view, IMSession iMSession) {
            if (IMListChatHelperVHolder.this.f10250k != null) {
                IMListChatHelperVHolder.this.f10250k.deleteHelper(view, iMSession);
            }
        }

        public void openNotify(View view, IMSession iMSession, boolean z) {
            if (IMListChatHelperVHolder.this.f10250k != null) {
                IMListChatHelperVHolder.this.f10250k.openNotify(view, iMSession, z);
            }
        }

        public void onClick(View view, IMSession iMSession) {
            IMTraceUtil.addBusinessEvent("ddim_service_list_ck").add("product_id", Integer.valueOf(iMSession.getBusinessId())).add("no_appid", Long.valueOf(iMSession.getPeerUid())).add("type", Integer.valueOf(iMSession.getIsHelperForbid() ? 1 : 0)).add("position", Integer.valueOf(IMListChatHelperVHolder.this.f10262i)).report();
            if (IMListChatHelperVHolder.this.f10250k != null) {
                IMListChatHelperVHolder.this.f10250k.onClick(view, iMSession);
            }
        }
    };

    /* renamed from: com.didi.beatles.im.views.feed.IMListChatHelperVHolder$ChatHelperListener */
    public interface ChatHelperListener extends IMListChatVHolder.ClickListener {
        void deleteHelper(View view, IMSession iMSession);

        void openNotify(View view, IMSession iMSession, boolean z);
    }

    public IMListChatHelperVHolder(Activity activity, ViewGroup viewGroup) {
        super(activity, viewGroup);
        this.f10259f.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_list_top_star));
    }

    public void bindData(IMSession iMSession, int i, boolean z, ChatHelperListener chatHelperListener) {
        super.bindData(iMSession, i, z, this.f10251l);
        this.f10250k = chatHelperListener;
        m6980c();
        m6981d();
        m6982e();
        this.f10260g.setVisibility(this.f10261h.getIsHelperForbid() ? 0 : 8);
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                IMListChatHelperVHolder.this.m6983f();
                return true;
            }
        });
    }

    /* renamed from: c */
    private void m6980c() {
        if (this.f10261h.getExtendSessionInfo() == null || this.f10261h.getExtendSessionInfo().istop != 1) {
            this.f10259f.setVisibility(8);
        } else {
            this.f10259f.setVisibility(0);
        }
    }

    /* renamed from: d */
    private void m6981d() {
        List<Long> userIds = this.f10261h.getUserIds();
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userIds.size() == 2 && userModel != null) {
            userModel.getUserInfo(new long[]{userIds.get(0).longValue(), userIds.get(1).longValue()}, (IMUserInfoCallback) new IMUserInfoCallback() {
                public void onUserInfoLoaded(HashMap<Long, IMUser> hashMap, long[] jArr) {
                    if (jArr.length == 2 && IMListChatHelperVHolder.this.f10261h.getUserIds().size() == 2 && jArr[0] == IMListChatHelperVHolder.this.f10261h.getUserIds().get(0).longValue() && jArr[1] == IMListChatHelperVHolder.this.f10261h.getUserIds().get(1).longValue() && IMListChatHelperVHolder.this.f10254a != null && !IMListChatHelperVHolder.this.f10254a.isFinishing()) {
                        IMUser iMUser = null;
                        if (hashMap != null) {
                            iMUser = hashMap.get(IMSession.getPeerId(IMListChatHelperVHolder.this.f10261h.getUserIds()));
                        }
                        if (iMUser == null) {
                            IMListChatHelperVHolder.this.f10255b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_helper_name_default));
                            IMListChatHelperVHolder.this.f10258e.setImageResource(R.drawable.bts_im_general_default_avatar);
                            return;
                        }
                        if (!TextUtils.isEmpty(iMUser.getNickName())) {
                            IMListChatHelperVHolder.this.f10255b.setText(iMUser.getNickName());
                        } else {
                            IMListChatHelperVHolder.this.f10255b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_helper_name_default));
                        }
                        if (!TextUtils.isEmpty(iMUser.getAvatarUrl())) {
                            BtsImageLoader.getInstance().loadInto((Object) iMUser.getAvatarUrl(), (View) IMListChatHelperVHolder.this.f10258e, (int) R.drawable.bts_im_general_default_avatar);
                            return;
                        }
                        IMListChatHelperVHolder.this.f10258e.setImageResource(R.drawable.bts_im_general_default_avatar);
                    }
                }
            }, false);
        }
    }

    /* renamed from: e */
    private void m6982e() {
        String str;
        IMHelperBody iMHelperBody = (IMHelperBody) IMJsonUtil.objectFromJson(this.f10261h.getLastMessage(), IMHelperBody.class);
        if (iMHelperBody != null) {
            str = iMHelperBody.title;
        } else if (TextUtils.isEmpty(this.f10261h.getLastMessage())) {
            str = IMContextInfoHelper.getContext().getString(R.string.bts_im_chat_last_msg);
        } else {
            str = this.f10261h.getLastMessage();
        }
        this.f10256c.setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m6983f() {
        final boolean z = !this.f10261h.getIsHelperForbid();
        final ArrayList arrayList = new ArrayList();
        if (this.f10261h.getIsHelperCanForbid()) {
            arrayList.add(new IMSessionDeletePopup.TextConfig() {
                public String getContent() {
                    return IMListChatHelperVHolder.this.itemView.getResources().getString(!z ? R.string.im_feed_notify_open : R.string.im_feed_notify_close);
                }

                public int getTextColor() {
                    return IMListChatHelperVHolder.this.itemView.getResources().getColor(R.color.bts_im_color_gray);
                }
            });
        }
        arrayList.add(new IMSessionDeletePopup.TextConfig() {
            public String getContent() {
                return IMListChatHelperVHolder.this.itemView.getContext().getString(R.string.im_pop_delete);
            }

            public int getTextColor() {
                return Color.parseColor("#EB4D3D");
            }
        });
        new IMSessionDeletePopup(this.f10254a).show(this.f10255b, arrayList, new IMSessionDeletePopup.PopupOnClickListener() {
            public void onItemClick(int i) {
                if (arrayList.size() > 1 && i == 0) {
                    IMTraceUtil.addBusinessEvent(z ? "ddim_service_list_notice_off_ck" : "ddim_service_list_notice_on_ck").add("product_id", Integer.valueOf(IMListChatHelperVHolder.this.f10261h.getBusinessId())).add("no_appid", Long.valueOf(IMListChatHelperVHolder.this.f10261h.getPeerUid())).report();
                    if (IMListChatHelperVHolder.this.f10263j != null) {
                        ((ChatHelperListener) IMListChatHelperVHolder.this.f10263j).openNotify(IMListChatHelperVHolder.this.itemView, IMListChatHelperVHolder.this.f10261h, true ^ z);
                    }
                } else if ((arrayList.size() == 1 || i == 1) && IMListChatHelperVHolder.this.f10263j != null) {
                    ((ChatHelperListener) IMListChatHelperVHolder.this.f10263j).deleteHelper(IMListChatHelperVHolder.this.itemView, IMListChatHelperVHolder.this.f10261h);
                }
            }
        });
    }
}
