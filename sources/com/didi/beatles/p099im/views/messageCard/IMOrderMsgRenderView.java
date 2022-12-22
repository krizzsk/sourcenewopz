package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.card.HighlightHelper;
import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.access.style.custom.IMCustomContext;
import com.didi.beatles.p099im.access.style.custom.IMCustomViewHelper;
import com.didi.beatles.p099im.access.style.custom.msgcard.IMSysOrderCusView;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.activity.IMMessageActivity;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.api.entity.IMHelperBody;
import com.didi.beatles.p099im.api.entity.IMOrderStatusChangeBody;
import com.didi.beatles.p099im.api.entity.IMRichInfo;
import com.didi.beatles.p099im.event.IMMessageSysCardShowEvent;
import com.didi.beatles.p099im.event.IMViewStreetImageEvent;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.impl.IMModelProvider;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMExpoMtaManager;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMScreenUtil;
import com.didi.beatles.p099im.utils.IMStreetUtils;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.utils.imageloader.Callback;
import com.didi.beatles.p099im.views.widget.richinfo.IMClickSpanListener;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.taxis99.R;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.messageCard.IMOrderMsgRenderView */
public class IMOrderMsgRenderView extends IMBaseRenderView<IMSysOrderCusView> {

    /* renamed from: a */
    private TextView f10341a;

    /* renamed from: b */
    private TextView f10342b;

    /* renamed from: c */
    private TextView f10343c;

    /* renamed from: d */
    private TextView f10344d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f10345e;

    /* renamed from: f */
    private LinearLayout f10346f;

    /* renamed from: g */
    private View f10347g;

    /* renamed from: h */
    private ImageView f10348h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IMOrderStatusChangeBody f10349i;

    /* renamed from: j */
    private LinearLayout f10350j;

    /* renamed from: k */
    private ImageView f10351k;

    /* renamed from: l */
    private View f10352l;

    /* renamed from: m */
    private TextView f10353m;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public IMOrderMsgRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public IMSysOrderCusView createCustomView(IMBusinessConfig iMBusinessConfig, IMCustomContext iMCustomContext) {
        return IMCustomViewHelper.createSysOrder(iMBusinessConfig, iMCustomContext);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        tryLoadCustomView(viewGroup);
        if (this.mCusContentView != null) {
            return this.mCusContentView;
        }
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            return this.inflater.inflate(R.layout.bts_im_message_sys_global_psg, viewGroup, false);
        }
        return this.inflater.inflate(R.layout.bts_im_message_sys, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        if (!isCustomView()) {
            this.f10350j = (LinearLayout) findViewById(R.id.im_order_message_root);
            this.f10341a = (TextView) findViewById(R.id.im_order_message_title);
            this.f10342b = (TextView) findViewById(R.id.im_order_message_subtitle);
            this.f10343c = (TextView) findViewById(R.id.im_order_message_text);
            this.f10344d = (TextView) findViewById(R.id.im_order_message_text_to);
            this.f10345e = (TextView) findViewById(R.id.im_order_message_link);
            this.f10346f = (LinearLayout) findViewById(R.id.im_order_message_link_linear);
            this.f10347g = findViewById(R.id.divider);
            this.f10348h = (ImageView) findViewById(R.id.im_order_message_icon);
            this.f10342b.setTextColor(IMResource.getColor(R.color.im_color_sys_msg_sub_title));
            this.f10351k = (ImageView) findViewById(R.id.im_order_message_street_image);
            this.f10352l = findViewById(R.id.img_expired_street_view);
            this.f10353m = (TextView) findViewById(R.id.illegalTextOnPicture);
        }
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        if (this.message.getType() == 393219) {
            String content = this.message.getContent();
            if (!TextUtils.isEmpty(content)) {
                content = content.replace("\\n", "\n");
            }
            IMOrderStatusChangeBody iMOrderStatusChangeBody = (IMOrderStatusChangeBody) IMJsonUtil.objectFromJson(content, IMOrderStatusChangeBody.class);
            if (iMOrderStatusChangeBody == null) {
                iMOrderStatusChangeBody = new IMOrderStatusChangeBody().getDefaultBody();
            }
            setBody(iMOrderStatusChangeBody);
        } else if (this.message.getType() == 393220) {
            setBody(helpBodyToOrderBody((IMHelperBody) IMJsonUtil.objectFromJson(this.message.getContent(), IMHelperBody.class)));
        } else {
            IMOrderStatusChangeBody iMOrderStatusChangeBody2 = new IMOrderStatusChangeBody();
            iMOrderStatusChangeBody2.format_type = 1;
            iMOrderStatusChangeBody2.block.text = this.message.getContent();
            setBody(iMOrderStatusChangeBody2);
        }
        IMOrderStatusChangeBody iMOrderStatusChangeBody3 = this.f10349i;
        if (iMOrderStatusChangeBody3 != null) {
            iMMessage.linkType = iMOrderStatusChangeBody3.link_type;
        }
        EventBus.getDefault().post(new IMMessageSysCardShowEvent(iMMessage));
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        String str;
        if (!isCustomView()) {
            int i = 1;
            if (this.f10349i.alignStyle == 1 && this.f10349i.clickType == 1) {
                if (!this.message.isRead()) {
                    this.message.setIsRead(true);
                    this.adapter.updateItemState(this.message);
                    if (IMModelProvider.getInstance().getMessageModule() != null) {
                        IMModelProvider.getInstance().getMessageModule().updateMessageAsync(this.message);
                    }
                } else {
                    return;
                }
            }
            if (this.f10349i.link_type > 0) {
                if (this.f10349i.link_type == 1) {
                    int sourceId = ((IMMessageActivity) this.context).getSourceId();
                    if (this.f10349i.to_user_role == 1) {
                        String routeId = ((IMMessageActivity) this.context).getRouteId();
                        String string = this.context.getString(R.string.im_driver_detail_uri);
                        str = String.format(string, new Object[]{this.f10349i.oid + "", routeId, sourceId + ""});
                    } else {
                        String string2 = this.context.getString(R.string.im_passenger_detail_uri);
                        str = String.format(string2, new Object[]{this.f10349i.oid + "", sourceId + ""});
                    }
                } else if (this.f10349i.link_type == 2) {
                    String encode = Uri.encode(this.f10349i.link);
                    str = String.format(getResources().getString(R.string.im_web_uri), new Object[]{encode});
                } else if (this.f10349i.link_type == 5) {
                    str = this.f10349i.link;
                } else {
                    str = this.f10349i.link;
                }
                IMCommonUtil.startUriActivity(this.context, str, this.f10349i.extend);
            }
            if (this.f10349i.streetImage != null && !TextUtils.isEmpty(this.f10349i.streetImage.imageUrl) && !IMStreetUtils.isExpiredPic(this.message, this.f10349i)) {
                EventBus.getDefault().post(new IMViewStreetImageEvent(this.f10349i));
            }
            IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("ddim_message_sys_item_ck").add("product_id", Integer.valueOf(this.message.getBusinessId())).add("client_type", IMContextInfoHelper.getPackageName()).add("msg_type", Integer.valueOf(this.message.getType()));
            if (this.f10349i.link_type <= 0) {
                i = 0;
            }
            add.add("msg_link", Integer.valueOf(i)).add("send_uid", Long.valueOf(this.message.getSenderUid())).add("activity_id", Long.valueOf(this.message.getActivityId())).report();
        }
    }

    public void setBody(IMOrderStatusChangeBody iMOrderStatusChangeBody) {
        if (isCustomView()) {
            ((IMSysOrderCusView) this.mCusViewRender).bindSysContent(this.message, iMOrderStatusChangeBody);
            return;
        }
        this.f10349i = iMOrderStatusChangeBody;
        if (iMOrderStatusChangeBody != null && iMOrderStatusChangeBody.block != null) {
            if (!TextUtils.isEmpty(this.f10349i.icon)) {
                IMViewUtil.show((View) this.f10348h);
                BtsImageLoader.getInstance().loadInto(this.f10349i.icon, this.f10348h);
            } else {
                IMViewUtil.hide((View) this.f10348h);
            }
            if (!TextUtils.isEmpty(this.f10349i.title)) {
                this.f10341a.setText(this.f10349i.title);
                this.f10341a.setVisibility(0);
            } else {
                this.f10341a.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f10349i.subtitle)) {
                this.f10342b.setText(this.f10349i.subtitle);
                this.f10342b.setVisibility(0);
            } else {
                this.f10342b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f10349i.tcolor)) {
                this.f10341a.setTextColor(Color.parseColor(this.f10349i.tcolor));
            } else {
                this.f10341a.setTextColor(IMResource.getColor(R.color.im_color_sys_msg_title));
            }
            if (this.f10349i.format_type == 1) {
                m7065a(false);
                this.f10343c.setVisibility(8);
                this.f10344d.setPadding(IMViewUtil.dp2px(getContext(), 16.0f), IMViewUtil.dp2px(getContext(), 7.0f), IMViewUtil.dp2px(getContext(), 18.0f), 0);
                this.f10344d.setSingleLine(false);
                this.f10344d.setMaxLines(Integer.MAX_VALUE);
                if (!TextUtils.isEmpty(this.f10349i.block.ext_text)) {
                    this.f10344d.setText(HighlightHelper.processIMHighlight(this.f10349i.block.ext_text));
                } else {
                    this.f10344d.setText(this.f10349i.block.text);
                }
            } else if (this.f10349i.format_type == 2) {
                m7065a(true);
                this.f10343c.setVisibility(0);
                this.f10344d.setPadding(IMViewUtil.dp2px(getContext(), 18.0f), 0, IMViewUtil.dp2px(getContext(), 18.0f), 0);
                this.f10344d.setSingleLine(true);
                this.f10344d.setEllipsize(TextUtils.TruncateAt.END);
                this.f10343c.setText(this.f10349i.block.from);
                this.f10344d.setText(this.f10349i.block.f9127to);
            }
            m7068c();
            m7064a();
        }
    }

    /* renamed from: a */
    private void m7064a() {
        if (this.f10349i.streetImage == null || this.message == null) {
            IMViewUtil.hide((View) this.f10351k);
        } else if (!TextUtils.isEmpty(this.f10349i.streetImage.imageUrl)) {
            this.f10350j.setClickable(true);
            int screenWidth = IMScreenUtil.instance(this.context).getScreenWidth();
            if (IMStreetUtils.isExpiredPic(this.message, this.f10349i)) {
                IMViewUtil.hide((View) this.f10351k);
                IMViewUtil.show(this.f10352l);
                IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.message.getBusinessId());
                if (currentBusinessConfig != null && !TextUtils.isEmpty(currentBusinessConfig.getIllegalTextOnPicture())) {
                    this.f10353m.setText(currentBusinessConfig.getIllegalTextOnPicture());
                }
                if (this.f10349i.streetImage.width != 0) {
                    this.f10352l.getLayoutParams().height = (screenWidth * this.f10349i.streetImage.height) / this.f10349i.streetImage.width;
                    return;
                }
                return;
            }
            IMViewUtil.show((View) this.f10351k);
            IMViewUtil.hide(this.f10352l);
            try {
                if (this.f10349i.streetImage.width != 0) {
                    this.f10351k.getLayoutParams().height = (screenWidth * this.f10349i.streetImage.height) / this.f10349i.streetImage.width;
                }
            } catch (Exception e) {
                String str = TAG;
                IMLog.m6631d(str, "IMOrderMsgRenderView Can't parse streetImage's height Exception " + e.getMessage());
            }
            BtsImageLoader.getInstance().loadInto((Object) this.f10349i.streetImage.imageUrl, (View) this.f10351k, (int) R.drawable.im_picture_ic_image);
            m7067b();
        } else {
            IMViewUtil.hide(this.f10352l);
            IMViewUtil.hide((View) this.f10351k);
        }
    }

    /* renamed from: b */
    private void m7067b() {
        HashMap hashMap = new HashMap();
        hashMap.put("client_type", IMContextInfoHelper.getPackageName());
        IMExpoMtaManager.getInstance().mtaExpo("wyc_ddim_sysmsg_streetview_sw", hashMap);
    }

    /* renamed from: c */
    private void m7068c() {
        if (this.f10349i.alignStyle == 2) {
            m7069d();
            return;
        }
        LinearLayout linearLayout = this.f10346f;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (this.f10349i.link_type <= 0 || TextUtils.isEmpty(this.f10349i.link)) {
            m7071f();
            this.f10350j.setClickable(false);
            return;
        }
        m7070e();
        this.f10345e.setText(this.f10349i.anchor_text);
        this.f10345e.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10345e.getLayoutParams();
        if (this.f10349i.alignStyle == 1) {
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            if (!TextUtils.isEmpty(this.f10349i.anchorIcon) && this.f10349i.clickType == 0) {
                BtsImageLoader.getInstance().download(this.f10349i.anchorIcon, new Callback() {
                    public void onFailed() {
                    }

                    public void onStart() {
                    }

                    public void onSuccess(Bitmap bitmap) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(IMOrderMsgRenderView.this.getResources(), bitmap);
                        bitmapDrawable.setBounds(0, 0, IMViewUtil.dp2px(IMOrderMsgRenderView.this.getContext(), 15.0f), IMViewUtil.dp2px(IMOrderMsgRenderView.this.getContext(), 15.0f));
                        IMOrderMsgRenderView.this.f10345e.setCompoundDrawablePadding(IMViewUtil.dp2px(IMOrderMsgRenderView.this.getContext(), 8.0f));
                        IMOrderMsgRenderView.this.f10345e.setCompoundDrawables(bitmapDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                });
            }
            this.f10345e.setLayoutParams(layoutParams);
            this.f10345e.setTextColor(getResources().getColorStateList(R.color.im_system_action_color_select));
        } else if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            layoutParams.width = -2;
            layoutParams.gravity = 16;
            this.f10345e.setLayoutParams(layoutParams);
            Drawable drawable = getResources().getDrawable(R.drawable.bts_im_order_status_link_global_psg);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.f10345e.setCompoundDrawablePadding(IMViewUtil.dp2px(getContext(), 4.0f));
            this.f10345e.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.f10345e.setTextColor(Color.parseColor("#5C6166"));
        } else {
            layoutParams.width = -1;
            layoutParams.gravity = 16;
            this.f10345e.setLayoutParams(layoutParams);
            Drawable drawable2 = getResources().getDrawable(R.drawable.bts_im_order_status_link);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f10345e.setCompoundDrawablePadding(IMViewUtil.dp2px(getContext(), 8.0f));
            this.f10345e.setCompoundDrawables((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
            this.f10345e.setTextColor(IMResource.getColor(R.color.im_tv_gray_light));
        }
        if (this.message.isRead()) {
            this.f10345e.setEnabled(false);
            this.f10350j.setClickable(false);
            return;
        }
        this.f10345e.setEnabled(true);
        this.f10350j.setClickable(true);
    }

    /* renamed from: d */
    private void m7069d() {
        this.f10345e.setVisibility(8);
        LinearLayout linearLayout = this.f10346f;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.f10346f.removeAllViews();
            if (this.f10349i.btnGroup != null) {
                for (int i = 0; i < this.f10349i.btnGroup.size(); i++) {
                    IMRichInfo iMRichInfo = this.f10349i.btnGroup.get(i);
                    if (iMRichInfo != null) {
                        if (i != 0) {
                            View view = new View(this.context);
                            view.setBackgroundColor(Color.parseColor("#f5f5f5"));
                            this.f10346f.addView(view, new LinearLayout.LayoutParams(2, -1));
                        }
                        TextView textView = new TextView(this.context);
                        iMRichInfo.bindView(textView);
                        textView.setGravity(17);
                        this.f10346f.addView(textView, new LinearLayout.LayoutParams(0, -1, 1.0f));
                        final String str = i + "";
                        iMRichInfo.setClickSpanListener(new IMClickSpanListener() {
                            public void spanClicked(View view, String str) {
                                IMTraceUtil.addBusinessEvent("beat_p_imrpt_succard_ck").add("uid", Long.valueOf(IMContextInfoHelper.getUid())).add("anal_txt", IMOrderMsgRenderView.this.f10349i.extend != null ? IMOrderMsgRenderView.this.f10349i.extend.analTxt : "").add(ParamConst.SUG_CK_INDEX, str).report();
                            }
                        });
                    }
                }
            }
        }
    }

    /* renamed from: e */
    private void m7070e() {
        View view = this.f10347g;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f10345e.setVisibility(0);
    }

    /* renamed from: f */
    private void m7071f() {
        View view = this.f10347g;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f10345e.setVisibility(8);
    }

    /* renamed from: a */
    private void m7065a(boolean z) {
        Resources resources = getResources();
        if (z) {
            Drawable drawable = resources.getDrawable(R.drawable.bts_im_homepage_start_address);
            Drawable drawable2 = resources.getDrawable(R.drawable.bts_im_homepage_end_address);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f10343c.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f10344d.setCompoundDrawables(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.f10344d.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f10343c.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public IMOrderStatusChangeBody helpBodyToOrderBody(IMHelperBody iMHelperBody) {
        IMOrderStatusChangeBody iMOrderStatusChangeBody = new IMOrderStatusChangeBody();
        iMOrderStatusChangeBody.title = iMHelperBody.title;
        iMOrderStatusChangeBody.link_type = iMHelperBody.link_type;
        iMOrderStatusChangeBody.anchor_text = iMHelperBody.anchor_text;
        iMOrderStatusChangeBody.link = iMHelperBody.link;
        iMOrderStatusChangeBody.block.text = iMHelperBody.text;
        iMOrderStatusChangeBody.format_type = 1;
        iMOrderStatusChangeBody.alignStyle = 0;
        return iMOrderStatusChangeBody;
    }
}
