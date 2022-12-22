package com.didi.beatles.p099im.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.activity.IMMessageListActivity;
import com.didi.beatles.p099im.api.entity.IMOrderStatusChangeBody;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMUserInfoCallback;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMSpanny;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.views.imageView.IMCircleImageView;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didi.beatles.im.adapter.ChatAdapter */
public class ChatAdapter extends BaseAdapter {
    public static final int IM_SESSION_HISTORY = 1;
    public static final int IM_SESSION_NORMAL = 0;

    /* renamed from: f */
    private static final int f9035f = 3;

    /* renamed from: g */
    private static final int f9036g = 2;

    /* renamed from: a */
    private LayoutInflater f9037a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<IMSession> f9038b = new ArrayList();

    /* renamed from: c */
    private OnDataListener f9039c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IMMessageListActivity f9040d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public HashMap<Integer, Boolean> f9041e = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f9042h = 0;

    /* renamed from: com.didi.beatles.im.adapter.ChatAdapter$OnDataListener */
    public interface OnDataListener {
        void onDataChange(boolean z);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return 3;
    }

    public ChatAdapter(IMMessageListActivity iMMessageListActivity, OnDataListener onDataListener) {
        this.f9040d = iMMessageListActivity;
        this.f9037a = LayoutInflater.from(iMMessageListActivity);
        this.f9039c = onDataListener;
    }

    public void setData(List<IMSession> list) {
        if (list != null) {
            this.f9038b = new ArrayList(list);
        } else {
            this.f9038b.clear();
        }
        OnDataListener onDataListener = this.f9039c;
        if (onDataListener != null) {
            onDataListener.onDataChange(this.f9038b.size() == 0);
        }
        notifyDataSetChanged();
    }

    public void setIsSelected(HashMap<Integer, Boolean> hashMap) {
        this.f9041e = hashMap;
    }

    public HashMap<Integer, Boolean> getIsSelected() {
        return this.f9041e;
    }

    public boolean isChecked(int i) {
        if (this.f9041e.size() > 0) {
            return this.f9041e.get(Integer.valueOf(i)).booleanValue();
        }
        return false;
    }

    public int getCount() {
        return this.f9038b.size();
    }

    public IMSession getItem(int i) {
        if (i >= this.f9038b.size() || i < 0) {
            return null;
        }
        return this.f9038b.get(i);
    }

    public int getItemViewType(int i) {
        if (i >= this.f9038b.size()) {
            return 0;
        }
        IMSession iMSession = this.f9038b.get(i);
        if (iMSession.getExtendSessionInfo() != null && iMSession.getExtendSessionInfo().istop == 1) {
            return 2;
        }
        if (iMSession.getType() != -1) {
            return 0;
        }
        return 1;
    }

    /* renamed from: com.didi.beatles.im.adapter.ChatAdapter$ContactViewHolder */
    public class ContactViewHolder {
        public IMCircleImageView avatar;
        public TextView bussinessIcon;
        public CheckBox checkBox;
        public View contentView;
        private ImageView forbidIV;
        public TextView lastContent;
        public TextView lastTime;
        public ImageView markIcon;
        public View msgBottomLine;
        public TextView msgCount;
        public TextView msgRedNotify;
        public TextView tvSessionLabel;
        public TextView uname;

        public ContactViewHolder(View view) {
            this.contentView = view;
            this.avatar = (IMCircleImageView) view.findViewById(R.id.contact_portrait);
            this.uname = (TextView) view.findViewById(R.id.shop_name);
            this.lastContent = (TextView) view.findViewById(R.id.message_body);
            this.lastTime = (TextView) view.findViewById(R.id.message_time);
            this.msgCount = (TextView) view.findViewById(R.id.message_count_notify);
            this.msgRedNotify = (TextView) view.findViewById(R.id.message_red_notify);
            this.avatar.setImageResource(R.drawable.bts_im_general_default_avatar);
            this.markIcon = (ImageView) view.findViewById(R.id.im_chat_mark);
            this.bussinessIcon = (TextView) view.findViewById(R.id.im_chat_bussiness_icon);
            this.msgBottomLine = view.findViewById(R.id.message_bottom_line);
            this.checkBox = (CheckBox) view.findViewById(R.id.checkbox_btn);
            this.markIcon.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_chat_user_mark_icon));
            this.checkBox.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_chat_checkbox));
            this.forbidIV = (ImageView) view.findViewById(R.id.forbid_iv);
            this.tvSessionLabel = (TextView) view.findViewById(R.id.tv_session_label);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0182, code lost:
            if (r11 != 16) goto L_0x01d1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x01e3  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01f4  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01fb  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0232  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void bindData(com.didi.beatles.p099im.module.entity.IMSession r10, int r11) {
            /*
                r9 = this;
                com.didi.beatles.im.api.entity.IMSessionExtendInfo r0 = r10.getExtendSessionInfo()
                r1 = 1
                if (r0 == 0) goto L_0x001c
                com.didi.beatles.im.api.entity.IMSessionExtendInfo r0 = r10.getExtendSessionInfo()
                int r0 = r0.istop
                if (r0 != r1) goto L_0x001c
                android.view.View r0 = r9.contentView
                r2 = 2131233971(0x7f080cb3, float:1.8084095E38)
                int r2 = com.didi.beatles.p099im.resource.IMResource.getDrawableID(r2)
                r0.setBackgroundResource(r2)
                goto L_0x0028
            L_0x001c:
                android.view.View r0 = r9.contentView
                r2 = 2131231155(0x7f0801b3, float:1.8078383E38)
                int r2 = com.didi.beatles.p099im.resource.IMResource.getDrawableID(r2)
                r0.setBackgroundResource(r2)
            L_0x0028:
                com.didi.beatles.im.adapter.ChatAdapter r0 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                int r0 = r0.f9042h
                r2 = 8
                r3 = 0
                if (r0 != r1) goto L_0x003e
                android.widget.TextView r0 = r9.lastTime
                r0.setVisibility(r2)
                android.widget.CheckBox r0 = r9.checkBox
                r0.setVisibility(r3)
                goto L_0x0048
            L_0x003e:
                android.widget.TextView r0 = r9.lastTime
                r0.setVisibility(r3)
                android.widget.CheckBox r0 = r9.checkBox
                r0.setVisibility(r2)
            L_0x0048:
                com.didi.beatles.im.adapter.ChatAdapter r0 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                java.util.HashMap r0 = r0.f9041e
                java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
                boolean r0 = r0.containsKey(r4)
                if (r0 == 0) goto L_0x0072
                android.widget.CheckBox r0 = r9.checkBox
                com.didi.beatles.im.adapter.ChatAdapter r4 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                java.util.HashMap r4 = r4.f9041e
                java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
                java.lang.Object r4 = r4.get(r5)
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                r0.setChecked(r4)
                goto L_0x0077
            L_0x0072:
                android.widget.CheckBox r0 = r9.checkBox
                r0.setChecked(r3)
            L_0x0077:
                int r0 = r10.getUnreadCount()
                int r4 = r10.getRedDotCount()
                int r5 = r10.getType()
                r6 = 2
                if (r5 != r6) goto L_0x009e
                boolean r5 = r10.getIsForbid()
                if (r5 == 0) goto L_0x009e
                android.widget.ImageView r5 = r9.forbidIV
                r5.setVisibility(r3)
                android.widget.ImageView r5 = r9.forbidIV
                r7 = 2131233933(0x7f080c8d, float:1.8084017E38)
                int r7 = com.didi.beatles.p099im.resource.IMResource.getDrawableID(r7)
                r5.setImageResource(r7)
                goto L_0x00a3
            L_0x009e:
                android.widget.ImageView r5 = r9.forbidIV
                r5.setVisibility(r2)
            L_0x00a3:
                if (r0 <= 0) goto L_0x00c7
                java.lang.String r5 = java.lang.String.valueOf(r0)
                r7 = 99
                if (r0 <= r7) goto L_0x00af
                java.lang.String r5 = "···"
            L_0x00af:
                android.widget.TextView r7 = r9.msgCount
                r8 = 2131233919(0x7f080c7f, float:1.808399E38)
                r7.setBackgroundResource(r8)
                android.widget.TextView r7 = r9.msgCount
                r7.setVisibility(r3)
                android.widget.TextView r7 = r9.msgRedNotify
                r7.setVisibility(r2)
                android.widget.TextView r7 = r9.msgCount
                r7.setText(r5)
                goto L_0x00d1
            L_0x00c7:
                android.widget.TextView r5 = r9.msgCount
                r5.setVisibility(r2)
                android.widget.TextView r5 = r9.msgRedNotify
                r5.setVisibility(r2)
            L_0x00d1:
                com.didi.beatles.im.adapter.ChatAdapter r5 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                com.didi.beatles.im.activity.IMMessageListActivity r5 = r5.f9040d
                boolean r5 = r5.isValidListUI()
                if (r5 != 0) goto L_0x00e3
                android.view.View r11 = r9.msgBottomLine
                r11.setVisibility(r3)
                goto L_0x013f
            L_0x00e3:
                com.didi.beatles.im.adapter.ChatAdapter r5 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                java.util.List r5 = r5.f9038b
                if (r5 == 0) goto L_0x013a
                com.didi.beatles.im.adapter.ChatAdapter r5 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                java.util.List r5 = r5.f9038b
                int r5 = r5.size()
                if (r5 <= 0) goto L_0x013a
                com.didi.beatles.im.adapter.ChatAdapter r5 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                java.util.List r5 = r5.f9038b
                com.didi.beatles.im.adapter.ChatAdapter r7 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                java.util.List r7 = r7.f9038b
                int r7 = r7.size()
                int r7 = r7 - r1
                java.lang.Object r5 = r5.get(r7)
                com.didi.beatles.im.module.entity.IMSession r5 = (com.didi.beatles.p099im.module.entity.IMSession) r5
                int r5 = r5.getType()
                r7 = -1
                if (r5 != r7) goto L_0x013a
                com.didi.beatles.im.adapter.ChatAdapter r5 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                java.util.List r5 = r5.f9038b
                int r5 = r5.size()
                if (r5 <= r1) goto L_0x0134
                com.didi.beatles.im.adapter.ChatAdapter r5 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                java.util.List r5 = r5.f9038b
                int r5 = r5.size()
                int r5 = r5 - r6
                if (r11 != r5) goto L_0x0134
                android.view.View r11 = r9.msgBottomLine
                r11.setVisibility(r2)
                goto L_0x013f
            L_0x0134:
                android.view.View r11 = r9.msgBottomLine
                r11.setVisibility(r3)
                goto L_0x013f
            L_0x013a:
                android.view.View r11 = r9.msgBottomLine
                r11.setVisibility(r3)
            L_0x013f:
                if (r0 > 0) goto L_0x014d
                if (r4 <= 0) goto L_0x014d
                android.widget.TextView r11 = r9.msgCount
                r11.setVisibility(r2)
                android.widget.TextView r11 = r9.msgRedNotify
                r11.setVisibility(r3)
            L_0x014d:
                com.didi.beatles.im.api.entity.IMSessionExtendInfo r11 = r10.getExtendSessionInfo()
                if (r11 == 0) goto L_0x0170
                com.didi.beatles.im.api.entity.IMSessionExtendInfo r11 = r10.getExtendSessionInfo()
                java.lang.String r11 = r11.label
                boolean r11 = android.text.TextUtils.isEmpty(r11)
                if (r11 != 0) goto L_0x0170
                android.widget.TextView r11 = r9.tvSessionLabel
                r11.setVisibility(r3)
                android.widget.TextView r11 = r9.tvSessionLabel
                com.didi.beatles.im.api.entity.IMSessionExtendInfo r0 = r10.getExtendSessionInfo()
                java.lang.String r0 = r0.label
                r11.setText(r0)
                goto L_0x0175
            L_0x0170:
                android.widget.TextView r11 = r9.tvSessionLabel
                r11.setVisibility(r2)
            L_0x0175:
                int r11 = r10.getType()
                r0 = 4
                if (r11 == r1) goto L_0x01ce
                if (r11 == r6) goto L_0x0185
                if (r11 == r0) goto L_0x01ce
                r4 = 16
                if (r11 == r4) goto L_0x01ce
                goto L_0x01d1
            L_0x0185:
                java.lang.String r4 = r10.getSessionName()
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 == 0) goto L_0x019c
                android.widget.TextView r4 = r9.uname
                r5 = 2131953549(0x7f13078d, float:1.9543572E38)
                java.lang.String r5 = com.didi.beatles.p099im.resource.IMResource.getString(r5)
                r4.setText(r5)
                goto L_0x01a5
            L_0x019c:
                android.widget.TextView r4 = r9.uname
                java.lang.String r5 = r10.getSessionName()
                r4.setText(r5)
            L_0x01a5:
                java.lang.String r4 = r10.getSessionImg()
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                r5 = 2131231152(0x7f0801b0, float:1.8078377E38)
                if (r4 != 0) goto L_0x01c4
                com.didi.beatles.im.utils.imageloader.BtsImageLoader r4 = com.didi.beatles.p099im.utils.imageloader.BtsImageLoader.getInstance()
                java.lang.String r6 = r10.getSessionImg()
                com.didi.beatles.im.views.imageView.IMCircleImageView r7 = r9.avatar
                int r5 = com.didi.beatles.p099im.resource.IMResource.getDrawableID(r5)
                r4.loadInto((java.lang.Object) r6, (android.view.View) r7, (int) r5)
                goto L_0x01d1
            L_0x01c4:
                com.didi.beatles.im.views.imageView.IMCircleImageView r4 = r9.avatar
                int r5 = com.didi.beatles.p099im.resource.IMResource.getDrawableID(r5)
                r4.setImageResource(r5)
                goto L_0x01d1
            L_0x01ce:
                r9.setSingleChatAndHeplerName(r10)
            L_0x01d1:
                com.didi.beatles.im.api.entity.IMSessionExtendInfo r4 = r10.getExtendSessionInfo()
                if (r4 == 0) goto L_0x01f4
                com.didi.beatles.im.api.entity.IMSessionExtendInfo r4 = r10.getExtendSessionInfo()
                java.lang.String r4 = r4.stag
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x01f4
                android.widget.TextView r2 = r9.bussinessIcon
                r2.setVisibility(r3)
                android.widget.TextView r2 = r9.bussinessIcon
                com.didi.beatles.im.api.entity.IMSessionExtendInfo r3 = r10.getExtendSessionInfo()
                java.lang.String r3 = r3.stag
                r2.setText(r3)
                goto L_0x01f9
            L_0x01f4:
                android.widget.TextView r3 = r9.bussinessIcon
                r3.setVisibility(r2)
            L_0x01f9:
                if (r11 != r0) goto L_0x0232
                java.lang.String r11 = r10.getLastMessage()
                java.lang.Class<com.didi.beatles.im.api.entity.IMHelperBody> r2 = com.didi.beatles.p099im.api.entity.IMHelperBody.class
                java.lang.Object r11 = com.didi.beatles.p099im.utils.IMJsonUtil.objectFromJson(r11, r2, r1)
                com.didi.beatles.im.api.entity.IMHelperBody r11 = (com.didi.beatles.p099im.api.entity.IMHelperBody) r11
                if (r11 == 0) goto L_0x020c
                java.lang.String r11 = r11.title
                goto L_0x0226
            L_0x020c:
                java.lang.String r11 = r10.getLastMessage()
                boolean r11 = android.text.TextUtils.isEmpty(r11)
                if (r11 == 0) goto L_0x0222
                android.content.Context r11 = com.didi.beatles.p099im.IMContextInfoHelper.getContext()
                r1 = 2131953519(0x7f13076f, float:1.9543511E38)
                java.lang.String r11 = r11.getString(r1)
                goto L_0x0226
            L_0x0222:
                java.lang.String r11 = r10.getLastMessage()
            L_0x0226:
                boolean r1 = com.didi.beatles.p099im.utils.IMTextUtil.isEmpty((java.lang.String) r11)
                if (r1 != 0) goto L_0x023d
                android.widget.TextView r1 = r9.lastContent
                r1.setText(r11)
                goto L_0x023d
            L_0x0232:
                android.widget.TextView r11 = r9.lastContent
                com.didi.beatles.im.adapter.ChatAdapter r1 = com.didi.beatles.p099im.adapter.ChatAdapter.this
                com.didi.beatles.im.utils.IMSpanny r1 = r1.m6147a((com.didi.beatles.p099im.module.entity.IMSession) r10)
                r11.setText(r1)
            L_0x023d:
                int r11 = r10.getType()
                if (r11 == r0) goto L_0x0276
                java.lang.String r11 = r10.getDraft()
                boolean r11 = com.didi.beatles.p099im.utils.IMTextUtil.isEmpty((java.lang.String) r11)
                if (r11 != 0) goto L_0x0276
                com.didi.beatles.im.utils.IMSpanny r11 = new com.didi.beatles.im.utils.IMSpanny
                android.content.Context r0 = com.didi.beatles.p099im.IMContextInfoHelper.getContext()
                r1 = 2131953520(0x7f130770, float:1.9543513E38)
                java.lang.String r0 = r0.getString(r1)
                android.text.style.ForegroundColorSpan r1 = new android.text.style.ForegroundColorSpan
                r2 = 2131100794(0x7f06047a, float:1.781398E38)
                int r2 = com.didi.beatles.p099im.resource.IMResource.getColor(r2)
                r1.<init>(r2)
                r11.<init>((java.lang.CharSequence) r0, (java.lang.Object) r1)
                java.lang.String r0 = r10.getDraft()
                com.didi.beatles.im.utils.IMSpanny r11 = r11.append((java.lang.CharSequence) r0)
                android.widget.TextView r0 = r9.lastContent
                r0.setText(r11)
            L_0x0276:
                java.util.Date r11 = new java.util.Date
                long r0 = r10.getLastModifyTime()
                r11.<init>(r0)
                android.widget.TextView r10 = r9.lastTime
                java.lang.String r11 = com.didi.beatles.p099im.utils.IMDateUtil.getTimeDiffDesc(r11)
                r10.setText(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.adapter.ChatAdapter.ContactViewHolder.bindData(com.didi.beatles.im.module.entity.IMSession, int):void");
        }

        private void setSingleChatAndHeplerName(final IMSession iMSession) {
            List<Long> userIds = iMSession.getUserIds();
            final int type = iMSession.getType();
            IIMUserModule userModel = IMManager.getInstance().getUserModel();
            if (userModel != null && userIds.size() == 2) {
                final long[] jArr = {userIds.get(0).longValue(), userIds.get(1).longValue()};
                userModel.getUserInfo(jArr, (IMUserInfoCallback) new IMUserInfoCallback() {
                    public void onUserInfoLoaded(HashMap<Long, IMUser> hashMap, long[] jArr) {
                        if (jArr == jArr && ChatAdapter.this.f9040d != null && !ChatAdapter.this.f9040d.isFinishing()) {
                            IMUser iMUser = null;
                            if (hashMap != null) {
                                iMUser = hashMap.get(IMSession.getPeerId(iMSession.getUserIds()));
                            }
                            int i = R.string.bts_im_helper_name_default;
                            if (iMUser == null) {
                                if (type == 4) {
                                    ContactViewHolder.this.uname.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_helper_name_default));
                                    ContactViewHolder.this.avatar.setImageResource(R.drawable.bts_im_general_default_avatar);
                                } else {
                                    ContactViewHolder.this.uname.setText(IMContextInfoHelper.getContext().getString(R.string.bts_user_default_name));
                                    ContactViewHolder.this.avatar.setImageResource(R.drawable.bts_im_general_default_avatar);
                                }
                                ContactViewHolder.this.markIcon.setVisibility(8);
                                return;
                            }
                            if (!TextUtils.isEmpty(iMUser.getNickName())) {
                                ContactViewHolder.this.uname.setText(iMUser.getNickName());
                            } else {
                                TextView textView = ContactViewHolder.this.uname;
                                Context context = IMContextInfoHelper.getContext();
                                if (type != 4) {
                                    i = R.string.bts_user_default_name;
                                }
                                textView.setText(context.getString(i));
                            }
                            if (!TextUtils.isEmpty(iMUser.getAvatarUrl())) {
                                String avatarUrl = iMUser.getAvatarUrl();
                                BtsImageLoader instance = BtsImageLoader.getInstance();
                                IMCircleImageView iMCircleImageView = ContactViewHolder.this.avatar;
                                int i2 = type;
                                instance.loadInto((Object) avatarUrl, (View) iMCircleImageView, (int) R.drawable.bts_im_general_default_avatar);
                            } else {
                                IMCircleImageView iMCircleImageView2 = ContactViewHolder.this.avatar;
                                int i3 = type;
                                iMCircleImageView2.setImageResource(R.drawable.bts_im_general_default_avatar);
                            }
                            if (iMUser.getMIcon() == 1) {
                                ContactViewHolder.this.markIcon.setVisibility(0);
                            } else {
                                ContactViewHolder.this.markIcon.setVisibility(8);
                            }
                        }
                    }
                }, false);
            }
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ContactViewHolder contactViewHolder;
        if (getItemViewType(i) == 1) {
            return this.f9037a.inflate(R.layout.im_check_overdue_message_footer_view, viewGroup, false);
        }
        if (view == null) {
            view = this.f9037a.inflate(R.layout.bts_im_item_chat, viewGroup, false);
            contactViewHolder = new ContactViewHolder(view);
            view.setTag(contactViewHolder);
        } else {
            contactViewHolder = (ContactViewHolder) view.getTag();
        }
        contactViewHolder.bindData(this.f9038b.get(i), i);
        return view;
    }

    public void setChoiceMode(int i) {
        this.f9042h = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public IMSpanny m6147a(IMSession iMSession) {
        String str;
        StringBuilder sb;
        String str2;
        int lastMsgStatus = iMSession.getLastMsgStatus();
        try {
            IMOrderStatusChangeBody iMOrderStatusChangeBody = (IMOrderStatusChangeBody) IMJsonUtil.objectFromJson(iMSession.getLastMessage(), IMOrderStatusChangeBody.class, true);
            if (iMOrderStatusChangeBody == null) {
                str = iMSession.getLastMessage();
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
                str = null;
            }
        } catch (Exception unused) {
            str = iMSession.getLastMessage();
        }
        IMSpanny iMSpanny = new IMSpanny();
        if (lastMsgStatus == 100) {
            iMSpanny.append((CharSequence) str, new ImageSpan(this.f9040d, R.drawable.bts_im_chat_msg_status));
        } else if (lastMsgStatus == 300 || lastMsgStatus == 500) {
            iMSpanny.append((CharSequence) IMContextInfoHelper.getContext().getString(R.string.bts_im_chat_send_fail), (Object) new ForegroundColorSpan(IMResource.getColor(R.color.im_nomix_orange))).append((CharSequence) str);
        } else if (TextUtils.isEmpty(str)) {
            iMSpanny.append((CharSequence) "");
        } else {
            iMSpanny.append((CharSequence) str);
        }
        return iMSpanny;
    }
}
