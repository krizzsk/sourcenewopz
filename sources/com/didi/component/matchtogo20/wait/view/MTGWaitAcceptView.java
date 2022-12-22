package com.didi.component.matchtogo20.wait.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.matchtogo20.wait.AbsMTGWaitAcceptPresenter;
import com.didi.component.matchtogo20.wait.model.WaitAcceptModel;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIBaseApplication;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.taxis99.R;

public class MTGWaitAcceptView implements IMTGWaitAcceptView {

    /* renamed from: a */
    private AbsMTGWaitAcceptPresenter f14569a;

    /* renamed from: b */
    private View f14570b;

    /* renamed from: c */
    private Context f14571c;

    /* renamed from: d */
    private TextView f14572d;

    /* renamed from: e */
    private TextView f14573e = ((TextView) this.f14570b.findViewById(R.id.tv_sub_title));

    /* renamed from: f */
    private TextView f14574f = ((TextView) this.f14570b.findViewById(R.id.tv_main_content));

    /* renamed from: g */
    private TextView f14575g = ((TextView) this.f14570b.findViewById(R.id.tv_sub_content));

    /* renamed from: h */
    private SimpleDraweeView f14576h = ((SimpleDraweeView) this.f14570b.findViewById(R.id.iv_main_icon));

    /* renamed from: i */
    private ImageView f14577i = ((ImageView) this.f14570b.findViewById(R.id.iv_sub_icon));

    /* renamed from: j */
    private long f14578j;

    public void updateWaitTime(int i) {
    }

    public MTGWaitAcceptView(Activity activity, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.match_to_go_wait_accept_layout_20, viewGroup, false);
        this.f14570b = inflate;
        this.f14572d = (TextView) inflate.findViewById(R.id.tv_title);
    }

    public View getView() {
        return this.f14570b;
    }

    public void setPresenter(AbsMTGWaitAcceptPresenter absMTGWaitAcceptPresenter) {
        this.f14569a = absMTGWaitAcceptPresenter;
    }

    public void setWaitAccept(WaitAcceptModel waitAcceptModel) {
        if (waitAcceptModel == null) {
            SystemUtils.log(6, "mtg", "wait accept data is null", (Throwable) null, "com.didi.component.matchtogo20.wait.view.MTGWaitAcceptView", 62);
            return;
        }
        this.f14572d.setText(waitAcceptModel.title);
        if (TextUtils.isEmpty(waitAcceptModel.sub_title)) {
            this.f14573e.setVisibility(8);
        } else {
            this.f14573e.setVisibility(0);
            this.f14573e.setText(waitAcceptModel.sub_title);
        }
        this.f14574f.setText(waitAcceptModel.main_content);
        this.f14575g.setText(HighlightUtil.highlight((CharSequence) waitAcceptModel.sub_content, Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON), false));
        this.f14576h.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(Uri.parse("res://" + this.f14570b.getContext().getPackageName() + "/" + R.drawable.webp_cab)).setAutoPlayAnimations(true)).build());
        ((RequestBuilder) Glide.with((Context) DIDIBaseApplication.getAppContext()).asBitmap().load(waitAcceptModel.sub_icon_url).error((int) R.drawable.global_driver_car_default_avatar)).into(this.f14577i);
        this.f14578j = waitAcceptModel.call_match_on_trip_time;
    }
}
