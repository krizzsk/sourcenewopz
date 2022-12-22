package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.widget.CircleImageView;
import com.didi.component.evaluateentrance.evaluate.model.GXPCarTipInfo;
import com.didi.component.evaluateentrance.evaluate.presenter.AbsEvaluatePresenter;
import com.didi.component.evaluateentrance.evaluate.view.GXPTipInputPopWindow;
import com.didi.component.evaluateentrance.impl.newView.NewEvaluateTipsView;
import com.didi.global.globalgenerickit.drawer.GGKAbsDrawer;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class GXPEvaluateTipPayDrawer extends GGKAbsDrawer {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LinearLayout f13537a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f13538b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f13539c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AbsEvaluatePresenter f13540d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GXPCarTipInfo f13541e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f13542f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f13543g = "";

    /* renamed from: h */
    private String f13544h = "";

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.g_xp_evaluate_tip_pay_drawer_layout;
    }

    public GXPEvaluateTipPayDrawer(Context context, AbsEvaluatePresenter absEvaluatePresenter, GXPCarTipInfo gXPCarTipInfo, String str, String str2) {
        super(context);
        this.f13542f = context;
        this.f13540d = absEvaluatePresenter;
        this.f13541e = gXPCarTipInfo;
        this.f13543g = str;
        this.f13544h = str2;
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        if (this.f13541e == null) {
            return false;
        }
        setBackPressedEnabled(true);
        this.f13537a = (LinearLayout) findViewById(R.id.tips_container);
        final View findViewById = findViewById(R.id.tips_bg);
        final ImageView imageView = (ImageView) findViewById(R.id.editIcon);
        this.f13539c = (TextView) findViewById(R.id.submit_btn);
        if (this.f13541e.isShow() && this.f13541e.feeItems != null && this.f13541e.feeItems.length > 0 && !this.f13541e.isPay()) {
            this.f13537a.removeAllViews();
            this.f13537a.post(new Runnable() {
                public void run() {
                    int width = GXPEvaluateTipPayDrawer.this.f13537a.getWidth() / GXPEvaluateTipPayDrawer.this.f13541e.feeItems.length;
                    ((FrameLayout.LayoutParams) findViewById.getLayoutParams()).width = width;
                    for (int i = 0; i < GXPEvaluateTipPayDrawer.this.f13541e.feeItems.length; i++) {
                        GXPCarTipInfo.FeeItem feeItem = GXPEvaluateTipPayDrawer.this.f13541e.feeItems[i];
                        NewEvaluateTipsView newEvaluateTipsView = new NewEvaluateTipsView(GXPEvaluateTipPayDrawer.this.f13542f);
                        if (!GXPEvaluateTipPayDrawer.this.f13541e.isShowCustomizeTip() || i != GXPEvaluateTipPayDrawer.this.f13541e.feeItems.length - 1) {
                            newEvaluateTipsView.setCurrency(feeItem.currency);
                        } else if (feeItem.tipString.isEmpty()) {
                            feeItem.tipString = GXPEvaluateTipPayDrawer.this.f13542f.getString(R.string.GRider_starratePage_tip_options_other);
                        }
                        newEvaluateTipsView.setTips(feeItem.tipString, feeItem.tipNum);
                        GXPEvaluateTipPayDrawer.this.f13537a.addView(newEvaluateTipsView);
                        newEvaluateTipsView.setWidth(width);
                        newEvaluateTipsView.setIndex(i);
                        if (i == 0) {
                            newEvaluateTipsView.setLineVisibility(8);
                        } else {
                            newEvaluateTipsView.setLineVisibility(0);
                        }
                        newEvaluateTipsView.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                final View view2 = view;
                                AutoTrackHelper.trackViewOnClick(view);
                                NewEvaluateTipsView newEvaluateTipsView = (NewEvaluateTipsView) view2;
                                int index = newEvaluateTipsView.getIndex();
                                if (view.isSelected()) {
                                    if (findViewById.getTag() != null) {
                                        GXPEvaluateTipPayDrawer.this.m9292b(((Integer) findViewById.getTag()).intValue());
                                    }
                                    findViewById.setVisibility(8);
                                    view2.setSelected(false);
                                    GXPEvaluateTipPayDrawer.this.f13539c.setEnabled(false);
                                    return;
                                }
                                if (findViewById.getVisibility() == 0) {
                                    for (int i = 0; i < GXPEvaluateTipPayDrawer.this.f13537a.getChildCount(); i++) {
                                        View childAt = GXPEvaluateTipPayDrawer.this.f13537a.getChildAt(i);
                                        if ((childAt instanceof NewEvaluateTipsView) && childAt.isSelected()) {
                                            childAt.setSelected(false);
                                        }
                                    }
                                    if (findViewById.getTag() != null) {
                                        GXPEvaluateTipPayDrawer.this.m9292b(((Integer) findViewById.getTag()).intValue());
                                    }
                                }
                                if (GXPEvaluateTipPayDrawer.this.f13541e.isShowCustomizeTip() && index == GXPEvaluateTipPayDrawer.this.f13541e.feeItems.length - 1) {
                                    View inflate = LayoutInflater.from(GXPEvaluateTipPayDrawer.this.f13542f).inflate(R.layout.global_evaluate_entrance_custom_tip, (ViewGroup) null);
                                    double tips = newEvaluateTipsView.getTips();
                                    double d = tips;
                                    new GXPTipInputPopWindow(inflate, -1, -1, GXPEvaluateTipPayDrawer.this.f13542f, GXPEvaluateTipPayDrawer.this.f13541e, d, newEvaluateTipsView.getTipText(), new GXPTipInputPopWindow.ConfirmButtonClickListener() {
                                        public void confirmClick(String str, Double d) {
                                            if (!str.isEmpty()) {
                                                String unused = GXPEvaluateTipPayDrawer.this.f13538b = d.toString();
                                                findViewById.setX(view2.getX());
                                                ((NewEvaluateTipsView) view2).setTips(str, d.doubleValue());
                                                ((NewEvaluateTipsView) view2).setCurrency(GXPEvaluateTipPayDrawer.this.f13541e.currency);
                                                view2.setSelected(true);
                                                imageView.setVisibility(0);
                                                GXPEvaluateTipPayDrawer.this.f13539c.setEnabled(true);
                                                return;
                                            }
                                            findViewById.setX(view2.getX());
                                            view2.setSelected(true);
                                        }
                                    }).show();
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("source", "tipentrance");
                                    if (tips == 0.0d) {
                                        hashMap.put("type", "0");
                                    } else {
                                        hashMap.put("type", "1");
                                    }
                                    GlobalOmegaUtils.trackEvent("ibt_gp_starratecard_detai_tipmount_ck", (Map<String, Object>) hashMap);
                                }
                                findViewById.setX(view.getX());
                                view2.setSelected(true);
                                double tips2 = newEvaluateTipsView.getTips();
                                GXPEvaluateTipPayDrawer gXPEvaluateTipPayDrawer = GXPEvaluateTipPayDrawer.this;
                                String unused = gXPEvaluateTipPayDrawer.f13538b = tips2 + "";
                                GXPEvaluateTipPayDrawer.this.m9289a(index);
                                findViewById.setTag(Integer.valueOf(index));
                                if (tips2 == 0.0d) {
                                    GXPEvaluateTipPayDrawer.this.f13539c.setEnabled(false);
                                } else {
                                    GXPEvaluateTipPayDrawer.this.f13539c.setEnabled(true);
                                }
                                findViewById.setVisibility(0);
                            }
                        });
                    }
                }
            });
        }
        ((ImageView) findViewById(R.id.close_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GXPEvaluateTipPayDrawer.this.dismiss();
                if (!GXPEvaluateTipPayDrawer.this.f13543g.isEmpty()) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_tipentrance_close_ck", "source", GXPEvaluateTipPayDrawer.this.f13543g);
                }
            }
        });
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.f13542f).asBitmap().load(this.f13544h).placeholder((int) R.drawable.global_xp_driver_car_default_avatar)).error((int) R.drawable.global_xp_driver_car_default_avatar)).into((ImageView) (CircleImageView) findViewById(R.id.tip_pay_drawer_head_img));
        TextView textView = (TextView) findViewById(R.id.tip_pay_drawer_title);
        if (!this.f13541e.title.isEmpty()) {
            textView.setVisibility(0);
            textView.setText(this.f13541e.title);
        } else {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(R.id.tip_pay_drawer_subtitle);
        if (!this.f13541e.tipSubTitle.isEmpty()) {
            textView2.setVisibility(0);
            textView2.setText(this.f13541e.tipSubTitle);
        } else {
            textView2.setVisibility(8);
        }
        this.f13539c.setEnabled(false);
        this.f13539c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GXPEvaluateTipPayDrawer.this.f13540d.prePayTips(GXPEvaluateTipPayDrawer.this.f13538b);
                HashMap hashMap = new HashMap(2);
                hashMap.put("source", GXPEvaluateTipPayDrawer.this.f13543g);
                hashMap.put(CarServerParam.PARAM_FEE, GXPEvaluateTipPayDrawer.this.f13538b);
                GlobalOmegaUtils.trackEvent("ibt_gp_tipentrance_submit_ck", (Map<String, Object>) hashMap);
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9289a(int i) {
        if (i < this.f13537a.getChildCount()) {
            ((NewEvaluateTipsView) this.f13537a.getChildAt(i)).setLineVisibility(8);
        }
        int i2 = i + 1;
        if (i2 < this.f13537a.getChildCount()) {
            ((NewEvaluateTipsView) this.f13537a.getChildAt(i2)).setLineVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9292b(int i) {
        if (i != 0 && i < this.f13537a.getChildCount()) {
            ((NewEvaluateTipsView) this.f13537a.getChildAt(i)).setLineVisibility(0);
        }
        int i2 = i + 1;
        if (i2 < this.f13537a.getChildCount()) {
            ((NewEvaluateTipsView) this.f13537a.getChildAt(i2)).setLineVisibility(0);
        }
    }

    public String getTips() {
        return this.f13538b;
    }
}
