package com.didi.component.comp_selectseat.ticket;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.util.GLog;
import com.didi.component.core.IPresenter;
import com.didi.component.core.PresenterGroup;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.taxis99.R;

public class TicketFragment extends AbsNormalFragment implements View.OnClickListener, ITicketView {

    /* renamed from: a */
    private static final String f12479a = "TicketFragment";

    /* renamed from: b */
    private TicketPresenter f12480b;

    /* renamed from: c */
    private View f12481c;

    /* renamed from: d */
    private TextView f12482d;

    /* renamed from: e */
    private TextView f12483e;

    /* renamed from: f */
    private TextView f12484f;

    /* renamed from: g */
    private TextView f12485g;

    /* renamed from: h */
    private TextView f12486h;

    /* renamed from: i */
    private TextView f12487i;

    /* renamed from: j */
    private TextView f12488j;

    /* renamed from: k */
    private TextView f12489k;

    /* renamed from: l */
    private TextView f12490l;

    /* renamed from: m */
    private TextView f12491m;

    /* renamed from: n */
    private View f12492n;

    /* renamed from: o */
    private RelativeLayout f12493o;

    /* renamed from: p */
    private RelativeLayout f12494p;

    /* renamed from: q */
    private ImageView f12495q;

    /* renamed from: r */
    private ImageView f12496r;

    /* renamed from: s */
    private TicketActivity f12497s;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 0;
    }

    public void setPresenter(IPresenter iPresenter) {
    }

    public static TicketFragment newInstance(String str) {
        TicketFragment ticketFragment = new TicketFragment();
        Bundle bundle = new Bundle();
        bundle.putString("detail_data", str);
        ticketFragment.setArguments(bundle);
        return ticketFragment;
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        TicketPresenter ticketPresenter = new TicketPresenter(getContext(), getArguments());
        this.f12480b = ticketPresenter;
        return ticketPresenter;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f12497s = (TicketActivity) context;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f12497s = null;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12481c = layoutInflater.inflate(R.layout.ticket_layout, viewGroup, false);
        m8487b();
        m8486a();
        return this.f12481c;
    }

    /* renamed from: a */
    private void m8486a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12480b.setData(arguments.getString("detail_data"));
            return;
        }
        GLog.m7968e(f12479a, "setData>> bundle is null");
    }

    /* renamed from: b */
    private void m8487b() {
        this.f12482d = (TextView) this.f12481c.findViewById(R.id.tv_titleBar);
        this.f12483e = (TextView) this.f12481c.findViewById(R.id.tv_payment);
        this.f12484f = (TextView) this.f12481c.findViewById(R.id.tv_price);
        this.f12492n = this.f12481c.findViewById(R.id.fl_title_hide_shadow);
        this.f12493o = (RelativeLayout) this.f12481c.findViewById(R.id.rl_title_head);
        this.f12494p = (RelativeLayout) this.f12481c.findViewById(R.id.rl_ticket_body);
        this.f12485g = (TextView) this.f12481c.findViewById(R.id.tv_ticket_num);
        this.f12486h = (TextView) this.f12481c.findViewById(R.id.tv_name);
        this.f12487i = (TextView) this.f12481c.findViewById(R.id.tv_role);
        this.f12488j = (TextView) this.f12481c.findViewById(R.id.tv_seat_num);
        this.f12489k = (TextView) this.f12481c.findViewById(R.id.tv_seat_units);
        ImageView imageView = (ImageView) this.f12481c.findViewById(R.id.btn_back);
        this.f12495q = imageView;
        imageView.setOnClickListener(this);
        this.f12496r = (ImageView) this.f12481c.findViewById(R.id.iv_monetary_unit);
        TextView textView = (TextView) this.f12481c.findViewById(R.id.tv_next);
        this.f12490l = textView;
        textView.setOnClickListener(this);
        this.f12491m = (TextView) this.f12481c.findViewById(R.id.tv_ticket_intro);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.btn_back) {
            this.f12497s.finish();
        } else if (view.getId() == R.id.tv_next) {
            this.f12497s.finish();
        }
    }

    public void setTitleBarText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12482d.setText(str);
        } else {
            GLog.m7968e(f12479a, "setTitleBarText>> title is null");
        }
    }

    public void setPayment(LEGORichInfo lEGORichInfo) {
        if (lEGORichInfo == null || TextUtils.isEmpty(lEGORichInfo.getContent())) {
            GLog.m7968e(f12479a, "setPayment>> payment is null");
        } else {
            lEGORichInfo.bindTextView(this.f12483e);
        }
    }

    public void setPrice(LEGORichInfo lEGORichInfo) {
        if (lEGORichInfo == null || TextUtils.isEmpty(lEGORichInfo.getContent())) {
            GLog.m7968e(f12479a, "setPrice>> price is null");
        } else {
            lEGORichInfo.bindTextView(this.f12484f);
        }
    }

    public void setTicketHeadBgColor(String str) {
        int i;
        if (!TextUtils.isEmpty(str)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            try {
                i = Color.parseColor(str);
            } catch (Exception e) {
                int parseColor = Color.parseColor("#1F2B4D");
                e.printStackTrace();
                GLog.m7968e(f12479a, "setTicketHeadBgColor>> " + str);
                i = parseColor;
            }
            if (getContext() != null) {
                gradientDrawable.setCornerRadius((float) UiUtils.dip2px(getContext(), 20.0f));
                float dip2px = (float) UiUtils.dip2px(getContext(), 20.0f);
                gradientDrawable.setCornerRadii(new float[]{dip2px, dip2px, dip2px, dip2px, 0.0f, 0.0f, 0.0f, 0.0f});
                gradientDrawable.setColor(i);
                this.f12493o.setBackground(gradientDrawable);
                return;
            }
            return;
        }
        GLog.m7968e(f12479a, "setTicketHeadBgColor>> color is null");
    }

    public void showPaymentMark(String str) {
        if (TextUtils.isEmpty(str) || getContext() == null) {
            this.f12496r.setVisibility(8);
            return;
        }
        this.f12496r.setVisibility(0);
        Glide.with(getContext()).asBitmap().load((Object) new GlideUrl(str)).into(this.f12496r);
    }

    public void setTicketNum(String str) {
        this.f12485g.setText(str);
    }

    public void setTicketIntro(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12491m.setText(str);
        } else {
            GLog.m7968e(f12479a, "setTicketIntro>> intro is null");
        }
    }

    public void setName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12486h.setText(str);
        } else {
            GLog.m7968e(f12479a, "setName>> name is null");
        }
    }

    public void setRole(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12487i.setText(str);
        } else {
            GLog.m7968e(f12479a, "setRole>> role is null");
        }
    }

    public void setSeatNum(int i) {
        this.f12488j.setText(String.valueOf(i));
    }

    public void setSeatUnits(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12489k.setText(str);
        } else {
            GLog.m7968e(f12479a, "setSeatUnits>> seatUnits is null");
        }
    }
}
