package com.didi.component.newbeecoupon.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.model.HomeNewCouponModel;
import com.didi.component.newbeecoupon.presenter.AbsNewbeeCouponPresenter;
import com.didi.sdk.util.GlobalViewUtils;
import com.didi.sdk.view.LazyInflateView;
import com.taxis99.R;

public class NewNewCouponView extends LazyInflateView implements View.OnClickListener, INewbeeCouponView {

    /* renamed from: a */
    private Context f14689a;

    /* renamed from: b */
    private View f14690b;

    /* renamed from: c */
    private View f14691c;

    /* renamed from: d */
    private RecyclerView f14692d;

    /* renamed from: e */
    private TextView f14693e;

    /* renamed from: f */
    private View f14694f;

    /* renamed from: g */
    private AbsNewbeeCouponPresenter f14695g;

    /* renamed from: h */
    private NewMaskCouponAdapter f14696h;

    /* renamed from: i */
    private PopupWindow f14697i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f14698j;

    /* renamed from: k */
    private View f14699k;

    public NewNewCouponView(Context context) {
        super(context, (ViewGroup) null, R.layout.global_new_coupon_root);
        this.f14689a = context;
    }

    /* access modifiers changed from: protected */
    public void onInflate(View view) {
        this.f14699k = view;
        view.setVisibility(8);
        this.f14690b = LayoutInflater.from(this.f14689a).inflate(R.layout.global_new_user_coupon, (ViewGroup) null);
        this.f14697i = new PopupWindow(this.f14690b, -1, -1);
        this.f14691c = this.f14690b.findViewById(R.id.g_new_coupon_dialog_ll);
        m10480b();
        RecyclerView recyclerView = (RecyclerView) this.f14690b.findViewById(R.id.g_new_coupon_rv);
        this.f14692d = recyclerView;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (i2 != 0 && !NewNewCouponView.this.f14698j) {
                    GlobalOmegaUtils.trackEvent("gp_home_popups_sp");
                    boolean unused = NewNewCouponView.this.f14698j = true;
                }
            }
        });
        this.f14693e = (TextView) this.f14690b.findViewById(R.id.g_new_coupon_dialog_btn);
        m10477a();
        this.f14693e.setOnClickListener(this);
        View findViewById = this.f14690b.findViewById(R.id.g_new_coupon_bottom);
        this.f14694f = findViewById;
        findViewById.setOnClickListener(this);
        this.f14692d.setLayoutManager(new LinearLayoutManager(this.f14689a, 1, false));
        RecyclerView recyclerView2 = this.f14692d;
        NewMaskCouponAdapter newMaskCouponAdapter = new NewMaskCouponAdapter();
        this.f14696h = newMaskCouponAdapter;
        recyclerView2.setAdapter(newMaskCouponAdapter);
    }

    /* renamed from: a */
    private void m10477a() {
        int dipToPx = GlobalViewUtils.dipToPx(this.f14689a, 18);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) dipToPx);
        gradientDrawable.setColor(Color.parseColor("#80ffffff"));
        gradientDrawable.setStroke(UiUtils.dip2px(this.f14689a, 0.5f), Color.parseColor("#FFFFFFFF"));
        this.f14693e.setBackground(gradientDrawable);
        this.f14693e.setTextColor(Color.parseColor("#ffffff"));
    }

    /* renamed from: b */
    private void m10480b() {
        int dipToPx = GlobalViewUtils.dipToPx(this.f14689a, 10);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#fff362"), Color.parseColor("#fd9728")});
        gradientDrawable.setCornerRadius((float) dipToPx);
        this.f14691c.setBackground(gradientDrawable);
    }

    public View getView() {
        return getRealView();
    }

    public void setPresenter(AbsNewbeeCouponPresenter absNewbeeCouponPresenter) {
        this.f14695g = absNewbeeCouponPresenter;
    }

    public void show() {
        super.inflate();
        View view = this.f14699k;
        if (view != null) {
            view.setVisibility(0);
            this.f14697i.showAtLocation(this.f14699k, 17, 0, 0);
        }
    }

    public void dismiss() {
        View view = this.f14699k;
        if (view != null) {
            view.setVisibility(8);
            this.f14697i.dismiss();
        }
    }

    public void setListData(HomeNewCouponModel homeNewCouponModel) {
        NewMaskCouponAdapter newMaskCouponAdapter = this.f14696h;
        if (newMaskCouponAdapter != null) {
            newMaskCouponAdapter.setData(homeNewCouponModel);
            this.f14696h.notifyDataSetChanged();
        }
    }

    public void setButtonText(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f14693e) != null) {
            textView.setText(str);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.g_new_coupon_dialog_btn) {
            GlobalOmegaUtils.trackEvent("gp_home_popups_ck");
            this.f14695g.onOpenSugClick();
        } else if (view.getId() == R.id.g_new_coupon_bottom) {
            this.f14695g.onMaskClicked();
        }
    }
}
