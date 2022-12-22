package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.api.entity.IMPrivateOrderEntity;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMDateUtil;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMParseUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMOrderPrivateRenderView */
public class IMOrderPrivateRenderView extends IMBaseRenderView {

    /* renamed from: a */
    private TextView f10354a;

    /* renamed from: b */
    private TextView f10355b;

    /* renamed from: c */
    private TextView f10356c;

    /* renamed from: d */
    private TextView f10357d;

    /* renamed from: e */
    private TextView f10358e;

    /* renamed from: f */
    private TextView f10359f;

    /* renamed from: g */
    private TextView f10360g;

    /* renamed from: h */
    private TextView f10361h;

    /* renamed from: i */
    private TextView f10362i;

    /* renamed from: j */
    private IMPrivateOrderEntity f10363j;

    public IMOrderPrivateRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        View inflate = this.inflater.inflate(R.layout.bts_im_mine_private_order, viewGroup, false);
        if (this.isMine) {
            inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_right_white_bubble_selector));
        } else {
            inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_left_bubble_selector));
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10354a = (TextView) findViewById(R.id.order_title);
        this.f10355b = (TextView) findViewById(R.id.order_time);
        this.f10356c = (TextView) findViewById(R.id.order_start_address);
        this.f10357d = (TextView) findViewById(R.id.order_people);
        this.f10358e = (TextView) findViewById(R.id.order_end_address);
        this.f10359f = (TextView) findViewById(R.id.order_start_subddress);
        this.f10360g = (TextView) findViewById(R.id.order_end_subddress);
        this.f10361h = (TextView) findViewById(R.id.order_detail);
        this.f10362i = (TextView) findViewById(R.id.order_price);
    }

    /* access modifiers changed from: protected */
    public void onUpdateView() {
        this.adapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        IMPrivateOrderEntity iMPrivateOrderEntity = (IMPrivateOrderEntity) IMJsonUtil.objectFromJson(this.message.getContent(), IMPrivateOrderEntity.class);
        this.f10363j = iMPrivateOrderEntity;
        if (iMPrivateOrderEntity != null) {
            this.f10354a.setText(iMPrivateOrderEntity.title);
            this.f10355b.setText(IMDateUtil.getDateDetail(getContext(), this.f10363j.time));
            this.f10357d.setText(this.f10363j.passenger_num);
            this.f10356c.setText(this.f10363j.from);
            this.f10358e.setText(this.f10363j.f9128to);
            this.f10359f.setText(this.f10363j.distance);
            this.f10360g.setText(this.f10363j.business_area);
            this.f10361h.setText(this.f10363j.anchor_text);
            if (TextUtils.isEmpty(this.f10363j.price)) {
                this.f10362i.setVisibility(8);
            } else {
                this.f10362i.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        String str;
        String str2 = this.f10363j.order_id;
        if (IMParseUtil.parseInt(this.f10363j.to_user_role) == 2) {
            str = String.format(this.context.getString(R.string.im_passenger_waiting_order_uri), new Object[]{str2});
        } else {
            str = String.format(this.context.getString(R.string.im_driver_waiting_order_uri), new Object[]{str2, this.f10363j.route_id});
        }
        IMCommonUtil.startUriActivity(this.context, str);
    }
}
