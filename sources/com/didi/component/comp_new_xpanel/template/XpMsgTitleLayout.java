package com.didi.component.comp_new_xpanel.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.business.xengine.model.XpTemplateMsgModel;
import com.didi.sdk.app.DIDIBaseApplication;
import com.taxis99.R;

public class XpMsgTitleLayout extends LinearLayout {

    /* renamed from: a */
    private View f12298a;

    /* renamed from: b */
    private TextView f12299b;

    /* renamed from: c */
    private ImageView f12300c;

    /* renamed from: d */
    private ImageView f12301d;

    /* renamed from: e */
    private TimeTracker f12302e = new TimeTracker();

    public XpMsgTitleLayout(Context context) {
        super(context);
        m8345a(context);
    }

    /* renamed from: a */
    private void m8345a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_xp_msg_title_layout, this);
        this.f12298a = inflate;
        this.f12299b = (TextView) inflate.findViewById(R.id.xp_msg_title);
        this.f12300c = (ImageView) this.f12298a.findViewById(R.id.xp_msg_left_to_title_img);
        this.f12301d = (ImageView) this.f12298a.findViewById(R.id.xp_msg_right_to_title_img);
    }

    public boolean isTitleEmpty() {
        return TextUtils.isEmpty(this.f12299b.getText().toString());
    }

    public void update(XpTemplateMsgModel.MsgTemplateData msgTemplateData) {
        if (msgTemplateData.title != null) {
            this.f12299b.setVisibility(0);
            msgTemplateData.title.bindTextView(this.f12299b);
            this.f12302e.trackNullTitle(msgTemplateData.title.getContent());
        } else {
            this.f12299b.setVisibility(8);
        }
        if (!TextUtils.isEmpty(msgTemplateData.titleLeftIcon)) {
            this.f12300c.setVisibility(0);
            Glide.with((Context) DIDIBaseApplication.getAppContext()).load(msgTemplateData.titleLeftIcon).into(this.f12300c);
        } else {
            this.f12300c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(msgTemplateData.titleRightIcon)) {
            this.f12301d.setVisibility(0);
            Glide.with((Context) DIDIBaseApplication.getAppContext()).load(msgTemplateData.titleRightIcon).into(this.f12301d);
            return;
        }
        this.f12301d.setVisibility(8);
    }
}
