package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.api.entity.IMRichInfoMsgBody;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMParseUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMRichInfoRenderView */
public class IMRichInfoRenderView extends IMBaseRenderView {

    /* renamed from: a */
    private TextView f10364a;

    /* renamed from: b */
    private TextView f10365b;

    /* renamed from: c */
    private View f10366c;

    /* renamed from: d */
    private TextView f10367d;

    /* renamed from: e */
    private IMRichInfoMsgBody f10368e;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public IMRichInfoRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        View inflate = this.inflater.inflate(R.layout.im_rich_info_msg_view, viewGroup, false);
        if (inflate != null) {
            if (this.isMine) {
                inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_right_white_bubble_selector));
            } else {
                inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_left_bubble_selector));
            }
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10364a = (TextView) findViewById(R.id.im_rich_info_title);
        this.f10365b = (TextView) findViewById(R.id.im_rich_info_content);
        this.f10366c = findViewById(R.id.im_rich_info_divider);
        this.f10367d = (TextView) findViewById(R.id.im_rich_info_anchor);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        IMRichInfoMsgBody iMRichInfoMsgBody = (IMRichInfoMsgBody) IMJsonUtil.objectFromJson(this.message.getContent(), IMRichInfoMsgBody.class);
        this.f10368e = iMRichInfoMsgBody;
        if (iMRichInfoMsgBody == null) {
            this.f10364a.setVisibility(8);
            this.f10366c.setVisibility(8);
            this.f10367d.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(iMRichInfoMsgBody.title)) {
            this.f10364a.setVisibility(0);
            int parseColor = IMParseUtil.parseColor(iMRichInfoMsgBody.titleColor);
            if (parseColor > 0) {
                this.f10364a.setTextColor(parseColor);
            }
            this.f10364a.setText(iMRichInfoMsgBody.title);
        } else {
            this.f10364a.setVisibility(8);
        }
        if (!iMRichInfoMsgBody.isEmpty()) {
            this.f10365b.setVisibility(0);
            iMRichInfoMsgBody.bindView(this.f10365b);
        } else {
            this.f10365b.setText("");
        }
        if (iMRichInfoMsgBody.linkInfo == null || TextUtils.isEmpty(iMRichInfoMsgBody.linkInfo.uri)) {
            this.f10366c.setVisibility(8);
            this.f10367d.setVisibility(8);
            return;
        }
        this.f10366c.setVisibility(0);
        this.f10367d.setVisibility(0);
        int parseColor2 = IMParseUtil.parseColor(iMRichInfoMsgBody.linkInfo.anchorColor);
        if (parseColor2 > 0) {
            this.f10367d.setTextColor(parseColor2);
        }
        this.f10367d.setText(iMRichInfoMsgBody.linkInfo.anchor);
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        IMRichInfoMsgBody iMRichInfoMsgBody = this.f10368e;
        if (iMRichInfoMsgBody != null && iMRichInfoMsgBody.linkInfo != null) {
            IMCommonUtil.startUriActivity(this.context, this.f10368e.linkInfo.uri, (Object) null);
        }
    }
}
