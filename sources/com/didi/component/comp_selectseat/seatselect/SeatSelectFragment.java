package com.didi.component.comp_selectseat.seatselect;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.activity.SeatSelectActivity;
import com.didi.component.comp_selectseat.adapter.LoadingTimeOutListener;
import com.didi.component.comp_selectseat.adapter.SeatSelectItemClickListener;
import com.didi.component.comp_selectseat.adapter.SeatsSelectedAdapter;
import com.didi.component.comp_selectseat.model.SeatOptionsModel;
import com.didi.component.core.PresenterGroup;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatSelectFragment extends AbsNormalFragment implements ISeatSelectView {

    /* renamed from: b */
    private static final String f12406b = "SeatSelectFragment";

    /* renamed from: A */
    private final LoadingTimeOutListener f12407A = new LoadingTimeOutListener() {
        public void showLoadingTimeoutView() {
            SeatSelectFragment.this.showOrHideLoadingTimeoutView(0);
        }
    };

    /* renamed from: a */
    float f12408a;

    /* renamed from: c */
    private String f12409c;

    /* renamed from: d */
    private View f12410d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f12411e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SeatSelectTopPresenter f12412f;

    /* renamed from: g */
    private TextView f12413g;

    /* renamed from: h */
    private TextView f12414h;

    /* renamed from: i */
    private RecyclerView f12415i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public SeatsSelectedAdapter f12416j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SeatSelectActivity f12417k;

    /* renamed from: l */
    private Button f12418l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Button f12419m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LinearLayout f12420n;

    /* renamed from: o */
    private RelativeLayout f12421o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f12422p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f12423q;

    /* renamed from: r */
    private ImageView f12424r;

    /* renamed from: s */
    private boolean f12425s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f12426t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f12427u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public ObjectAnimator f12428v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public JsonObject f12429w;

    /* renamed from: x */
    private JsonObject f12430x;

    /* renamed from: y */
    private final RecyclerView.OnScrollListener f12431y = new RecyclerView.OnScrollListener() {
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            SeatSelectFragment.m8431a(SeatSelectFragment.this, (float) i2);
            if (SeatSelectFragment.this.f12411e != null) {
                if (SeatSelectFragment.this.f12428v != null && SeatSelectFragment.this.f12428v.isRunning()) {
                    SeatSelectFragment.this.f12428v.cancel();
                }
                SeatSelectFragment.this.f12411e.setTranslationY(SeatSelectFragment.this.f12426t);
            }
        }
    };

    /* renamed from: z */
    private final SeatSelectItemClickListener f12432z = new SeatSelectItemClickListener() {
        public void seatSelectListener(int i, int i2, JsonObject jsonObject, float f) {
            if (SeatSelectFragment.this.f12412f != null) {
                int unused = SeatSelectFragment.this.f12422p = i;
                int unused2 = SeatSelectFragment.this.f12423q = i2;
                float unused3 = SeatSelectFragment.this.f12427u = f;
                JsonObject unused4 = SeatSelectFragment.this.f12429w = jsonObject;
                SeatSelectFragment.this.f12412f.onItemClick(i, i2);
                SeatSelectFragment seatSelectFragment = SeatSelectFragment.this;
                seatSelectFragment.slideItemBg(seatSelectFragment.f12426t, SeatSelectFragment.this.f12427u);
                SeatSelectFragment.this.f12419m.setEnabled(false);
            }
        }
    };

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 0;
    }

    /* renamed from: a */
    static /* synthetic */ float m8431a(SeatSelectFragment seatSelectFragment, float f) {
        float f2 = seatSelectFragment.f12426t - f;
        seatSelectFragment.f12426t = f2;
        return f2;
    }

    public static SeatSelectFragment newInstance(String str) {
        SeatSelectFragment seatSelectFragment = new SeatSelectFragment();
        Bundle bundle = new Bundle();
        bundle.putString("uniqueId", str);
        seatSelectFragment.setArguments(bundle);
        return seatSelectFragment;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12410d = layoutInflater.inflate(R.layout.seat_select_layout, viewGroup, false);
        m8435a();
        m8442c();
        return this.f12410d;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f12417k = (SeatSelectActivity) context;
    }

    public void onDetach() {
        super.onDetach();
        GLog.m7968e(f12406b, "onDetach");
    }

    public void onDestroy() {
        super.onDestroy();
        GLog.m7968e(f12406b, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
    }

    /* renamed from: a */
    private void m8435a() {
        Button button = (Button) this.f12410d.findViewById(R.id.btn_next);
        this.f12419m = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (!Utils.isFastDoubleClick()) {
                    SeatSelectFragment.this.f12417k.toNext(SeatSelectFragment.this.f12429w);
                    SeatSelectFragment.this.m8441b();
                }
            }
        });
        ImageView imageView = (ImageView) this.f12410d.findViewById(R.id.btn_back);
        this.f12424r = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SeatSelectFragment.this.m8437a("ibt_gp_minibus_seats_return_ck", "click", "return");
                SeatSelectFragment.this.f12417k.onBackPressed();
            }
        });
        this.f12413g = (TextView) this.f12410d.findViewById(R.id.tv_mainTitle);
        this.f12414h = (TextView) this.f12410d.findViewById(R.id.tv_subTitle);
        View findViewById = this.f12410d.findViewById(R.id.v_slideBg);
        this.f12411e = findViewById;
        findViewById.post(new Runnable() {
            public void run() {
                GLog.m7972v(SeatSelectFragment.f12406b, "run: " + SeatSelectFragment.this.f12411e.getY());
                SeatSelectFragment seatSelectFragment = SeatSelectFragment.this;
                seatSelectFragment.f12408a = seatSelectFragment.f12411e.getY();
            }
        });
        this.f12416j = new SeatsSelectedAdapter(this.f12417k, this.f12432z, this.f12407A);
        RecyclerView recyclerView = (RecyclerView) this.f12410d.findViewById(R.id.rv_select_seat);
        this.f12415i = recyclerView;
        recyclerView.setOnScrollListener(this.f12431y);
        this.f12415i.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f12415i.setAdapter(this.f12416j);
        this.f12421o = (RelativeLayout) this.f12410d.findViewById(R.id.rl_seat_select_content);
        this.f12420n = (LinearLayout) this.f12410d.findViewById(R.id.ll_net_error);
        Button button2 = (Button) this.f12410d.findViewById(R.id.btn_retry);
        this.f12418l = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SeatSelectFragment.this.f12420n.setVisibility(8);
                SeatSelectFragment.this.f12412f.singleCompRefresh(SeatSelectFragment.this.f12423q);
            }
        });
        ((ImageView) this.f12410d.findViewById(R.id.btn_loading_error_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SeatSelectFragment.this.f12417k.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8441b() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, GPageIdConstant.G_PAGE_ID_CONF);
        hashMap.put(RavenKey.VERSION, "next");
        this.f12412f.trackEventEstimateId(hashMap, "nextClickTrackEvent");
        if (this.f12430x != null) {
            try {
                HashMap hashMap2 = (HashMap) new Gson().fromJson((JsonElement) this.f12430x, new TypeToken<HashMap<String, Object>>() {
                }.getType());
                if (!CollectionUtils.isEmpty((Map) hashMap2)) {
                    hashMap.putAll(hashMap2);
                }
            } catch (JsonSyntaxException e) {
                GLog.m7968e(f12406b, "cardClickUseTrackEvent " + e.toString());
            }
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_minibus_seats_next_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8437a(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", str2);
        hashMap.put(RavenKey.VERSION, str3);
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }

    public void slideItemBg(float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f12411e, "translationY", new float[]{f, f2});
        this.f12428v = ofFloat;
        ofFloat.setDuration(500);
        if (!this.f12428v.isRunning()) {
            this.f12428v.start();
            this.f12426t = this.f12427u;
            this.f12428v.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (SeatSelectFragment.this.f12416j != null) {
                        SeatSelectFragment.this.f12416j.showLoadingStatus();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        SeatSelectTopPresenter seatSelectTopPresenter = new SeatSelectTopPresenter(getContext(), getArguments());
        this.f12412f = seatSelectTopPresenter;
        return seatSelectTopPresenter;
    }

    /* access modifiers changed from: protected */
    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        GLog.m7968e(f12406b, "onDestroyViewImpl");
        ObjectAnimator objectAnimator = this.f12428v;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.f12410d = null;
        this.f12412f = null;
    }

    public void setSeatsData(List<SeatOptionsModel> list) {
        showOrHideLoadingTimeoutView(8);
        SeatOptionsModel seatOptionsModel = list.get(this.f12422p);
        if (seatOptionsModel != null) {
            this.f12429w = seatOptionsModel.paramsModel;
            if (seatOptionsModel.mExtension != null) {
                this.f12430x = seatOptionsModel.mExtension.mLogData;
            }
        }
        if (this.f12425s) {
            this.f12416j.setDate(list, true);
            this.f12425s = false;
        } else {
            this.f12416j.setDate(list, false);
        }
        this.f12419m.setEnabled(true);
    }

    public View getView() {
        return this.f12410d;
    }

    public void setMainTitle(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f12413g.setText(str);
        }
    }

    public void setSubTitle(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f12414h.setText(str);
        }
    }

    /* renamed from: c */
    private void m8442c() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("uniqueId");
            this.f12409c = string;
            if (!TextUtils.isEmpty(string)) {
                this.f12412f.setmUniqueId(this.f12409c);
            }
            this.f12412f.setSeatData(FormStore.getInstance().getSelectedSeat(), true);
            return;
        }
        GLog.m7968e(f12406b, "setData() >> bundle is null");
        showOrHideLoadingTimeoutView(0);
    }

    public void showOrHideLoadingTimeoutView(int i) {
        if (i == 0) {
            this.f12424r.setVisibility(8);
            this.f12413g.setVisibility(8);
            this.f12414h.setVisibility(8);
            this.f12421o.setVisibility(8);
            this.f12419m.setVisibility(8);
        } else {
            this.f12424r.setVisibility(0);
            this.f12413g.setVisibility(0);
            this.f12414h.setVisibility(0);
            this.f12421o.setVisibility(0);
            this.f12419m.setVisibility(0);
        }
        this.f12420n.setVisibility(i);
    }

    public void resetSlideBgView() {
        this.f12411e.setY(this.f12408a);
        this.f12426t = 0.0f;
        this.f12427u = 0.0f;
        this.f12422p = 0;
        this.f12423q = 0;
        this.f12425s = true;
    }

    public void onBackPress() {
        SeatSelectActivity seatSelectActivity = this.f12417k;
        if (seatSelectActivity != null) {
            seatSelectActivity.finish();
        }
    }
}
