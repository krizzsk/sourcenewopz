package com.didi.addressnew.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.PreferenceUtil;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.widget.EditTextErasable;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.DisplayUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.view.tips.TipsContainer;
import com.didi.sdk.view.tips.TipsView;
import com.sdk.poibase.model.AddressParam;
import com.taxis99.R;

public class SugSearchView extends LinearLayout {
    public static final int TYPE_END = 2;
    public static final int TYPE_START = 1;

    /* renamed from: v */
    private static final String f7539v = "show_global_sug_way_point_tips";

    /* renamed from: A */
    private TextWatcher f7540A = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f7544c);
            if (SugSearchView.this.f7554m != null) {
                SugSearchView.this.f7554m.afterTextChanged(SugSearchView.this.f7544c, 5, editable);
            }
        }
    };

    /* renamed from: B */
    private OnClickSearchButtonListener f7541B;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditTextErasable f7542a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditTextErasable f7543b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditTextErasable f7544c;

    /* renamed from: d */
    private TextView f7545d;

    /* renamed from: e */
    private TextView f7546e;

    /* renamed from: f */
    private TextView f7547f;

    /* renamed from: g */
    private TextView f7548g;

    /* renamed from: h */
    private ViewGroup f7549h;

    /* renamed from: i */
    private ViewGroup f7550i;
    public boolean isStartTextNeedScrollToBottomWhenFocused = false;
    public boolean isStartTextRedColor = false;

    /* renamed from: j */
    private ViewGroup f7551j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ImageView f7552k;

    /* renamed from: l */
    private int f7553l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ISearchViewCallback f7554m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public AddressParam f7555n;

    /* renamed from: o */
    private boolean f7556o;

    /* renamed from: p */
    private boolean f7557p;

    /* renamed from: q */
    private FromType f7558q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View f7559r;

    /* renamed from: s */
    private TextView f7560s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f7561t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public TipsContainer f7562u;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public TextWatcher f7563w = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f7542a);
            if (SugSearchView.this.f7554m != null) {
                SugSearchView.this.f7554m.afterTextChanged(SugSearchView.this.f7542a, 1, editable);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: x */
    public TextWatcher f7564x = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f7543b);
            if (SugSearchView.this.f7554m != null) {
                SugSearchView.this.f7554m.afterTextChanged(SugSearchView.this.f7543b, 2, editable);
            }
        }
    };

    /* renamed from: y */
    private TextWatcher f7565y = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f7544c);
            if (SugSearchView.this.f7554m != null) {
                SugSearchView.this.f7554m.afterTextChanged(SugSearchView.this.f7544c, 3, editable);
            }
        }
    };

    /* renamed from: z */
    private TextWatcher f7566z = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f7544c);
            if (SugSearchView.this.f7554m != null) {
                SugSearchView.this.f7554m.afterTextChanged(SugSearchView.this.f7544c, 4, editable);
            }
        }
    };

    public interface OnClickSearchButtonListener {
        void onClickSearchButton(int i, String str);
    }

    /* access modifiers changed from: private */
    public void setInputtingTextColor(EditTextErasable editTextErasable) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setSearchViewCallback(ISearchViewCallback iSearchViewCallback) {
        this.f7554m = iSearchViewCallback;
    }

    public SugSearchView(Context context) {
        super(context);
        m4757a();
    }

    public SugSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4757a();
    }

    /* renamed from: a */
    private void m4757a() {
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_search_view, this);
        this.f7542a = (EditTextErasable) inflate.findViewById(R.id.et_start);
        this.f7543b = (EditTextErasable) inflate.findViewById(R.id.et_end);
        this.f7544c = (EditTextErasable) inflate.findViewById(R.id.et_common);
        this.f7545d = (TextView) inflate.findViewById(R.id.set_common_title);
        this.f7546e = (TextView) inflate.findViewById(R.id.input_cancel);
        this.f7547f = (TextView) inflate.findViewById(R.id.start_cancel);
        this.f7548g = (TextView) inflate.findViewById(R.id.end_cancel);
        this.f7549h = (ViewGroup) inflate.findViewById(R.id.end_layout);
        this.f7550i = (ViewGroup) inflate.findViewById(R.id.start_layout);
        this.f7551j = (ViewGroup) inflate.findViewById(R.id.common_layout);
        this.f7552k = (ImageView) inflate.findViewById(R.id.enter_way_point);
    }

    public boolean initSugSearchView(SugParams sugParams) {
        if (sugParams == null) {
            return false;
        }
        this.f7555n = sugParams.addressParam;
        this.f7556o = sugParams.enable_way_point;
        this.f7557p = sugParams.is_start_address_new_select;
        FromType fromType = sugParams.fromType;
        this.f7558q = fromType;
        m4758a(fromType, this.f7555n.addressType);
        m4789k();
        m4759a(this.f7558q, this.f7555n.targetAddress, sugParams.endAddress);
        return setStartText(this.f7555n);
    }

    /* renamed from: a */
    private void m4759a(FromType fromType, Address address, Address address2) {
        if (fromType != null) {
            if ((CommonUtils.isFromConfirmPage(fromType) || CommonUtils.isFromGetOnPage(fromType)) && address != null) {
                String str = address.displayName;
                this.f7543b.setText(str);
                if (!TextUtils.isEmpty(str)) {
                    this.f7543b.setSelection(0, str.length());
                }
            }
            if (CommonUtils.isFromNewConfirmPage(fromType) && address2 != null) {
                this.f7543b.setText(address2.displayName);
            }
        }
    }

    /* renamed from: com.didi.addressnew.view.SugSearchView$25 */
    static /* synthetic */ class C336225 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$address$FromType;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.address.FromType[] r0 = com.didi.address.FromType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$address$FromType = r0
                com.didi.address.FromType r1 = com.didi.address.FromType.HOME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.address.FromType r1 = com.didi.address.FromType.CONFIRM_NEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.address.FromType r1 = com.didi.address.FromType.OPEN_RIDE_CONFIRM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.address.FromType r1 = com.didi.address.FromType.CONFIRM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.address.FromType r1 = com.didi.address.FromType.GET_ON     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.address.FromType r1 = com.didi.address.FromType.DRIVING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.address.FromType r1 = com.didi.address.FromType.WAITRSP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.address.FromType r1 = com.didi.address.FromType.ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.address.FromType r1 = com.didi.address.FromType.FROM_CONFIRM_ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.address.FromType r1 = com.didi.address.FromType.FROM_HOME_ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.address.FromType r1 = com.didi.address.FromType.MAP_POINT_SELECT     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.address.FromType r1 = com.didi.address.FromType.SETTING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.view.SugSearchView.C336225.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m4758a(FromType fromType, int i) {
        if (fromType != null) {
            boolean z = true;
            int i2 = 0;
            switch (C336225.$SwitchMap$com$didi$address$FromType[fromType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (!(i == 3 || i == 4)) {
                        z = false;
                    }
                    setCommonVisibility(z ? 0 : 8);
                    this.f7550i.setVisibility(z ? 8 : 0);
                    ViewGroup viewGroup = this.f7549h;
                    if (z) {
                        i2 = 8;
                    }
                    viewGroup.setVisibility(i2);
                    if (z) {
                        setCommonHint(i);
                    }
                    showEnterWayPointView();
                    return;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    setCommonVisibility(8);
                    if (i == 2) {
                        this.f7550i.setVisibility(8);
                        this.f7552k.setVisibility(8);
                        this.f7549h.setVisibility(0);
                        this.f7548g.setVisibility(0);
                        return;
                    } else if (i == 1) {
                        this.f7550i.setVisibility(0);
                        this.f7549h.setVisibility(8);
                        this.f7547f.setVisibility(0);
                        return;
                    } else {
                        this.f7550i.setVisibility(8);
                        this.f7549h.setVisibility(8);
                        setCommonVisibility(0);
                        this.f7544c.setHint(i == 4 ? R.string.global_sug_add_company : R.string.global_sug_input_home);
                        return;
                    }
                case 12:
                    this.f7542a.setVisibility(8);
                    this.f7549h.setVisibility(8);
                    setCommonVisibility(0);
                    setCommonHint(i);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (com.didi.addressnew.util.CommonUtils.isFromConfirmPage(r0) != false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showEnterWayPointView() {
        /*
            r3 = this;
            android.view.ViewGroup r0 = r3.f7549h
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            com.didi.address.FromType r0 = r3.f7558q
            r1 = 0
            if (r0 == 0) goto L_0x0016
            boolean r2 = r3.f7556o
            boolean r0 = com.didi.addressnew.util.CommonUtils.isFromConfirmPage(r0)
            if (r0 == 0) goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            if (r2 != 0) goto L_0x001a
            return
        L_0x001a:
            android.content.Context r0 = r3.getContext()
            r2 = 1113587712(0x42600000, float:56.0)
            int r0 = com.didi.addressnew.util.ViewUtils.dip2px(r0, r2)
            android.widget.ImageView r2 = r3.f7552k
            r2.setVisibility(r1)
            android.view.ViewGroup r1 = r3.f7550i
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            r1.setMarginEnd(r0)
            android.view.ViewGroup r0 = r3.f7550i
            r0.setLayoutParams(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.view.SugSearchView.showEnterWayPointView():void");
    }

    /* renamed from: b */
    private void m4768b() {
        if (PreferenceUtil.getInstance(getContext().getApplicationContext()).getBoolean(f7539v, true)) {
            if (this.f7562u == null) {
                this.f7562u = new TipsContainer((Activity) getContext());
            }
            this.f7562u.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            final TipsView tipsView = new TipsView(getContext());
            tipsView.setTips(getContext().getResources().getString(R.string.global_sug_way_point_tips));
            tipsView.setId(this.f7552k.hashCode());
            tipsView.setCloseListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    PreferenceUtil.getInstance(SugSearchView.this.getContext().getApplicationContext()).put(SugSearchView.f7539v, false);
                    AddressTrack.trackClickWayPointTips();
                }
            });
            this.f7552k.post(new Runnable() {
                public void run() {
                    AddressTrack.trackShowWayPointTips();
                    SugSearchView.this.f7562u.show(tipsView, SugSearchView.this.f7552k, 2, 1, ViewUtils.dip2px(SugSearchView.this.getContext(), 36.0f), ViewUtils.dip2px(SugSearchView.this.getContext(), 10.0f), false);
                }
            });
        }
    }

    public void dismissPopupTips() {
        TipsContainer tipsContainer = this.f7562u;
        if (tipsContainer != null) {
            tipsContainer.clearAllTips();
            this.f7562u.setOnTouchListener((View.OnTouchListener) null);
        }
    }

    public void setOnEnterWayPointViewClickListener(View.OnClickListener onClickListener) {
        this.f7552k.setOnClickListener(onClickListener);
    }

    private void setCommonHint(int i) {
        this.f7544c.setHint(i == 4 ? R.string.GRider_Sug_2020_placeholder_work : i == 3 ? R.string.GRider_Sug_2020_placeholder_home : (i == 6 || i == 101 || i == 102) ? R.string.global_sug_input_stop_hint : i == 5 ? R.string.GRider_Sug_2020_placeholder_favorite : i == 1 ? R.string.GRider_Sug_2020_currentLoc : i == 2 ? R.string.GRider_Sug_2020_placeholder_whereTo : R.string.global_sug_input_home);
    }

    public void addStatusBarHeightView() {
        View view = new View(getContext());
        this.f7553l = ViewUtils.getStatusBarHeight(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f7553l));
        view.setBackgroundColor(-1);
        addView(view, 0);
    }

    public void onStartPoiInfoFetchBefore() {
        this.f7542a.setTextColor(getContext().getResources().getColor(R.color.poi_one_address_hint));
    }

    public void onStartPoiInfoFetchAfter() {
        if (CommonUtils.isFromHomePage(this.f7558q)) {
            getStartEditText().setHighlightColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_normal_hint));
        } else {
            this.f7542a.setTextColor(-16777216);
        }
    }

    public void onEndPoiInfoFetchBefore() {
        this.f7543b.setTextColor(getContext().getResources().getColor(R.color.poi_one_address_hint));
    }

    public void onEndPoiInfoFetchAfter() {
        this.f7543b.setTextColor(-16777216);
    }

    public void makeStartTextFocusedWhenIsRed() {
        EditTextErasable editTextErasable;
        if (CommonUtils.isFromHomePage(this.f7558q) && this.isStartTextRedColor && (editTextErasable = this.f7542a) != null && !TextUtils.isEmpty(editTextErasable.getHint()) && this.f7542a.getHint().toString().equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
            this.f7542a.setHintTextColor(getContext().getResources().getColor(R.color.poi_one_address_hint));
            this.isStartTextNeedScrollToBottomWhenFocused = false;
            this.f7542a.requestFocus();
        }
    }

    public boolean setStartText(AddressParam addressParam) {
        boolean z;
        String str = "";
        if (this.f7555n == null || !this.f7557p) {
            if (CommonUtils.isValidLocation(addressParam.currentAddress) || CommonUtils.isValidLocation(addressParam.targetAddress)) {
                z = this.f7558q == FromType.HOME || this.f7558q == FromType.CONFIRM || CommonUtils.isGetOnFromType(this.f7558q);
                if (addressParam.targetAddress != null) {
                    str = addressParam.targetAddress.displayName;
                }
                if (TextUtils.isEmpty(str)) {
                    str = getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                    if (this.f7558q == FromType.CONFIRM_NEW) {
                        str = getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                    }
                }
                if (addressParam.targetAddress != null) {
                    addressParam.targetAddress.displayName = str;
                }
            } else {
                this.isStartTextRedColor = true;
                this.f7542a.setHint(getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc));
                this.f7542a.setHintTextColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_nogps_hint));
                z = false;
            }
            this.f7542a.setText(str);
            if (CommonUtils.isFromGetOnPage(this.f7558q) && !TextUtils.isEmpty(str)) {
                this.f7542a.setSelection(0, str.length());
            }
            this.f7542a.setTextColor(-16777216);
            if (this.f7555n.addressType == 1 && !TextUtils.isEmpty(str)) {
                this.f7542a.setClearIconVisible(true);
            }
            return z;
        }
        this.f7542a.setText(str);
        return false;
    }

    public EditTextErasable getCommonEditText() {
        return this.f7544c;
    }

    public EditTextErasable getStartEditText() {
        return this.f7542a;
    }

    public EditTextErasable getEndEditText() {
        return this.f7543b;
    }

    /* renamed from: c */
    private void m4772c() {
        if (CommonUtils.isFromHomePage(this.f7558q) || CommonUtils.isFromNewConfirmPage(this.f7558q)) {
            m4775d();
        }
        EditTextErasable editTextErasable = this.f7542a;
        if (editTextErasable != null) {
            editTextErasable.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SugSearchView.this.f7542a.setClearIconVisible(!(SugSearchView.this.f7542a.getText() == null || SugSearchView.this.f7542a.getText().length() == 0));
                    if (SugSearchView.this.f7554m != null) {
                        SugSearchView.this.f7554m.onClick(1);
                    }
                }
            });
            this.f7542a.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear(String str) {
                    if (SugSearchView.this.f7554m != null) {
                        SugSearchView.this.f7554m.onClearClick(1, str);
                    }
                }
            });
        }
        EditTextErasable editTextErasable2 = this.f7543b;
        if (editTextErasable2 != null) {
            editTextErasable2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SugSearchView.this.f7543b.setClearIconVisible(!(SugSearchView.this.f7543b.getText() == null || SugSearchView.this.f7543b.getText().length() == 0));
                    if (SugSearchView.this.f7554m != null) {
                        SugSearchView.this.f7554m.onClick(2);
                    }
                }
            });
            this.f7543b.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear(String str) {
                    if (SugSearchView.this.f7554m != null) {
                        SugSearchView.this.f7554m.onClearClick(2, str);
                    }
                }
            });
        }
        this.f7542a.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    boolean unused = SugSearchView.this.f7561t = true;
                }
                return SugSearchView.super.onTouchEvent(motionEvent);
            }
        });
        this.f7543b.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    boolean unused = SugSearchView.this.f7561t = true;
                }
                return SugSearchView.super.onTouchEvent(motionEvent);
            }
        });
    }

    /* renamed from: d */
    private void m4775d() {
        EditTextErasable editTextErasable = this.f7542a;
        if (editTextErasable != null) {
            editTextErasable.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    boolean z2 = true;
                    if (SugSearchView.this.f7554m != null && SugSearchView.this.f7561t) {
                        SugSearchView.this.f7554m.focusChanged(1, z);
                        boolean unused = SugSearchView.this.f7561t = !z;
                    }
                    if (SugSearchView.this.f7542a != null) {
                        boolean z3 = SugSearchView.this.f7542a.getText() == null || SugSearchView.this.f7542a.getText().length() == 0;
                        EditTextErasable c = SugSearchView.this.f7542a;
                        if (!z || z3) {
                            z2 = false;
                        }
                        c.setClearIconVisible(z2);
                        if (z) {
                            SugSearchView sugSearchView = SugSearchView.this;
                            sugSearchView.resetShadow(sugSearchView.f7542a);
                            return;
                        }
                        SugSearchView.this.f7542a.removeTextChangedListener(SugSearchView.this.f7563w);
                    }
                }
            });
        }
        EditTextErasable editTextErasable2 = this.f7543b;
        if (editTextErasable2 != null) {
            editTextErasable2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (SugSearchView.this.f7554m != null && SugSearchView.this.f7561t) {
                        SugSearchView.this.f7554m.focusChanged(2, z);
                        boolean unused = SugSearchView.this.f7561t = !z;
                    }
                    if (SugSearchView.this.f7543b != null) {
                        boolean z2 = false;
                        boolean z3 = SugSearchView.this.f7543b.getText() == null || SugSearchView.this.f7543b.getText().length() == 0;
                        EditTextErasable e = SugSearchView.this.f7543b;
                        if (z && !z3) {
                            z2 = true;
                        }
                        e.setClearIconVisible(z2);
                        if (z) {
                            SugSearchView sugSearchView = SugSearchView.this;
                            sugSearchView.resetShadow(sugSearchView.f7543b);
                            SugSearchView.this.f7543b.addTextChangedListener(SugSearchView.this.f7564x);
                            return;
                        }
                        SugSearchView.this.f7543b.removeTextChangedListener(SugSearchView.this.f7564x);
                    }
                }
            });
        }
    }

    public void setPressedState(boolean z) {
        this.f7561t = z;
    }

    public void addWatcherForStart() {
        EditTextErasable editTextErasable = this.f7542a;
        if (editTextErasable != null) {
            editTextErasable.addTextChangedListener(this.f7563w);
        }
    }

    public void removeWatcherForStart() {
        EditTextErasable editTextErasable = this.f7542a;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7563w);
        }
    }

    public void setListener(AddressParam addressParam) {
        m4772c();
        m4761a(addressParam);
    }

    /* renamed from: e */
    private void m4777e() {
        EditTextErasable editTextErasable = this.f7544c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7566z);
            this.f7544c.removeTextChangedListener(this.f7540A);
            this.f7544c.addTextChangedListener(this.f7565y);
            this.f7544c.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear(String str) {
                    if (SugSearchView.this.f7554m != null) {
                        SugSearchView.this.f7554m.onClearClick(3, str);
                    }
                }
            });
        }
    }

    /* renamed from: f */
    private void m4778f() {
        EditTextErasable editTextErasable = this.f7544c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7565y);
            this.f7544c.removeTextChangedListener(this.f7540A);
            this.f7544c.addTextChangedListener(this.f7566z);
            this.f7544c.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear(String str) {
                    if (SugSearchView.this.f7554m != null) {
                        SugSearchView.this.f7554m.onClearClick(4, str);
                    }
                }
            });
        }
    }

    /* renamed from: g */
    private void m4781g() {
        EditTextErasable editTextErasable = this.f7544c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7566z);
            this.f7544c.removeTextChangedListener(this.f7565y);
            this.f7544c.addTextChangedListener(this.f7540A);
            this.f7544c.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear(String str) {
                    if (SugSearchView.this.f7554m != null) {
                        SugSearchView.this.f7554m.onClearClick(SugSearchView.this.f7555n != null ? SugSearchView.this.f7555n.addressType : 5, str);
                    }
                }
            });
        }
    }

    public void removeCommonWatcher(AddressParam addressParam) {
        if (addressParam.addressType == 4) {
            m4783h();
        } else if (addressParam.addressType == 3) {
            m4785i();
        } else {
            m4787j();
        }
    }

    /* renamed from: h */
    private void m4783h() {
        EditTextErasable editTextErasable = this.f7544c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7566z);
        }
    }

    /* renamed from: i */
    private void m4785i() {
        EditTextErasable editTextErasable = this.f7544c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7565y);
        }
    }

    /* renamed from: j */
    private void m4787j() {
        EditTextErasable editTextErasable = this.f7544c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7540A);
        }
    }

    /* renamed from: a */
    private void m4761a(AddressParam addressParam) {
        EditTextErasable editTextErasable = this.f7543b;
        if (editTextErasable != null) {
            editTextErasable.addTextChangedListener(this.f7564x);
        }
        if (addressParam.addressType == 4) {
            m4778f();
        } else if (addressParam.addressType == 3) {
            m4777e();
        } else {
            m4781g();
        }
    }

    public void removeEndTextWatcher() {
        EditTextErasable editTextErasable = this.f7543b;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7564x);
        }
    }

    public void addEndTextWatcher() {
        EditTextErasable editTextErasable = this.f7543b;
        if (editTextErasable != null) {
            editTextErasable.addTextChangedListener(this.f7564x);
        }
    }

    /* renamed from: k */
    private void m4789k() {
        EditTextErasable editTextErasable = this.f7542a;
        if (editTextErasable != null) {
            editTextErasable.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return SugSearchView.this.m4762a(textView, i, 1);
                }
            });
        }
        EditTextErasable editTextErasable2 = this.f7543b;
        if (editTextErasable2 != null) {
            editTextErasable2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return SugSearchView.this.m4762a(textView, i, 2);
                }
            });
        }
        EditTextErasable editTextErasable3 = this.f7544c;
        if (editTextErasable3 != null) {
            editTextErasable3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    SugSearchView sugSearchView = SugSearchView.this;
                    return sugSearchView.m4762a(textView, i, sugSearchView.f7555n.addressType);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4762a(TextView textView, int i, int i2) {
        if (i != 3) {
            return false;
        }
        String trim = textView.getText().toString().trim();
        OnClickSearchButtonListener onClickSearchButtonListener = this.f7541B;
        if (onClickSearchButtonListener == null) {
            return true;
        }
        onClickSearchButtonListener.onClickSearchButton(i2, trim);
        return true;
    }

    public void setOnClickSearchButtonListener(OnClickSearchButtonListener onClickSearchButtonListener) {
        this.f7541B = onClickSearchButtonListener;
    }

    /* renamed from: a */
    private int m4755a(View view) {
        if (view.getParent() == getParent()) {
            return view.getTop();
        }
        return view.getTop() + m4755a((View) view.getParent());
    }

    /* renamed from: b */
    private int m4766b(View view) {
        if (view.getParent() == getParent()) {
            return view.getLeft();
        }
        return view.getLeft() + m4766b((View) view.getParent());
    }

    /* renamed from: c */
    private int m4770c(View view) {
        if (view.getParent() == getParent()) {
            return view.getRight();
        }
        return view.getRight() + m4766b(view);
    }

    /* renamed from: d */
    private int m4773d(View view) {
        if (view.getParent() == getParent()) {
            return view.getBottom();
        }
        return view.getBottom() + m4773d((View) view.getParent());
    }

    public void setmShadowView(View view) {
        this.f7559r = view;
    }

    public void resetShadow(View view) {
        FrameLayout.LayoutParams layoutParams;
        if (this.f7559r != null) {
            int height = view.getHeight();
            int dp2px = DisplayUtils.dp2px(getContext(), 40.0f) + height;
            int width = view.getWidth() + DisplayUtils.dp2px(getContext(), 40.0f);
            if (this.f7559r.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f7559r.getLayoutParams();
                layoutParams2.topMargin = m4755a(view) - ((dp2px - height) / 2);
                setShadowViewPosition(view);
                layoutParams = layoutParams2;
            } else if (this.f7559r.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f7559r.getLayoutParams();
                layoutParams3.topMargin = m4755a(view) - ((dp2px - height) / 2);
                setShadowViewPosition(view);
                layoutParams = layoutParams3;
            } else if (this.f7559r.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f7559r.getLayoutParams();
                layoutParams4.topMargin = m4755a(view) - ((dp2px - height) / 2);
                setShadowViewPosition(view);
                layoutParams = layoutParams4;
            } else {
                layoutParams = this.f7559r.getLayoutParams();
            }
            layoutParams.width = width;
            layoutParams.height = dp2px;
            this.f7559r.setLayoutParams(layoutParams);
            this.f7559r.setVisibility(0);
        }
    }

    private void setShadowViewPosition(View view) {
        this.f7559r.setLeft(m4766b(view) - DisplayUtils.dp2px(getContext(), 30.0f));
        this.f7559r.setRight(m4770c(view) + DisplayUtils.dp2px(getContext(), 10.0f));
    }

    public void onResume() {
        postDelayed(new Runnable() {
            public void run() {
                if (SugSearchView.this.f7542a != null && SugSearchView.this.f7542a.isFocused()) {
                    SugSearchView sugSearchView = SugSearchView.this;
                    sugSearchView.resetShadow(sugSearchView.f7542a);
                } else if (SugSearchView.this.f7543b != null && SugSearchView.this.f7543b.isFocused()) {
                    SugSearchView sugSearchView2 = SugSearchView.this;
                    sugSearchView2.resetShadow(sugSearchView2.f7543b);
                } else if (SugSearchView.this.f7544c == null || !SugSearchView.this.f7544c.isFocused()) {
                    SugSearchView.this.f7559r.setVisibility(4);
                } else {
                    SugSearchView sugSearchView3 = SugSearchView.this;
                    sugSearchView3.resetShadow(sugSearchView3.f7544c);
                }
            }
        }, 75);
    }

    public void onSingle(AddressParam addressParam, IAddressResult iAddressResult) {
        if (addressParam != null) {
            int i = addressParam.addressType;
            if (i == 3) {
                setCommonVisibility(0);
                this.f7542a.setVisibility(8);
                this.f7549h.setVisibility(8);
                setCommonHint(addressParam.addressType);
                if (ViewUtils.isRTL()) {
                    this.f7544c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.sug_icon_home), (Drawable) null);
                } else {
                    this.f7544c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.sug_icon_home), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else if (i == 4) {
                setCommonVisibility(0);
                this.f7542a.setVisibility(8);
                this.f7549h.setVisibility(8);
                setCommonHint(addressParam.addressType);
                if (ViewUtils.isRTL()) {
                    this.f7544c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.sug_icon_work), (Drawable) null);
                } else {
                    this.f7544c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.sug_icon_work), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else if (i == 5) {
                setCommonVisibility(0);
                this.f7542a.setVisibility(8);
                this.f7549h.setVisibility(8);
                setCommonHint(addressParam.addressType);
                if (ViewUtils.isRTL()) {
                    this.f7544c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.sug_icon_favorite), (Drawable) null);
                } else {
                    this.f7544c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.sug_icon_favorite), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else if (i == 6 || i == 101 || i == 102) {
                setCommonVisibility(0);
                this.f7542a.setVisibility(8);
                this.f7549h.setVisibility(8);
                setCommonHint(addressParam.addressType);
                if (ViewUtils.isRTL()) {
                    this.f7544c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.waypoint_icon_stop), (Drawable) null);
                } else {
                    this.f7544c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.waypoint_icon_stop), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
            int i2 = C336225.$SwitchMap$com$didi$address$FromType[this.f7558q.ordinal()];
            if (i2 == 1 || i2 == 11) {
                this.f7546e.setVisibility(0);
            } else if (i2 == 12) {
                this.f7546e.setVisibility(8);
            }
            EditTextErasable editTextErasable = this.f7544c;
            if (editTextErasable != null) {
                editTextErasable.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View view, boolean z) {
                        if (z) {
                            SugSearchView sugSearchView = SugSearchView.this;
                            sugSearchView.resetShadow(sugSearchView.f7544c);
                            if (SugSearchView.this.f7554m != null && SugSearchView.this.f7555n != null) {
                                SugSearchView.this.f7554m.focusChanged(SugSearchView.this.f7555n.addressType, z);
                            }
                        }
                    }
                });
            }
            resetShadow(this.f7544c);
        }
    }

    private void setCommonVisibility(int i) {
        ViewGroup viewGroup = this.f7551j;
        if (viewGroup != null && this.f7544c != null) {
            viewGroup.setVisibility(i);
            this.f7544c.setVisibility(i);
        }
    }

    public View getCancel(int i) {
        if (i == 1) {
            return this.f7547f;
        }
        if (i == 2) {
            return this.f7548g;
        }
        return this.f7546e;
    }

    public void setStartAddressDrawableLeftGrey() {
        EditTextErasable editTextErasable = this.f7542a;
        if (editTextErasable != null) {
            editTextErasable.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.waypoint_icon_pick_up_dis), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void addCommonTextWatcher(AddressParam addressParam) {
        if (addressParam.addressType == 4) {
            m4778f();
        } else if (addressParam.addressType == 3) {
            m4777e();
        } else {
            m4781g();
        }
    }

    public int getStartwithEndFullSize() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f7542a.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f7542a.getLayoutParams();
        return layoutParams.bottomMargin + layoutParams.topMargin + layoutParams2.bottomMargin + layoutParams2.topMargin + 12 + 48 + 12 + 48 + 10 + 5;
    }

    public void hideShadow() {
        View view = this.f7559r;
        if (view != null) {
            view.setVisibility(4);
        }
    }
}
