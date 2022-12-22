package com.didi.addressold.view;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.addressold.util.AddressTrack;
import com.didi.addressold.util.CommonUtils;
import com.didi.addressold.util.PreferenceUtil;
import com.didi.addressold.util.ViewUtils;
import com.didi.addressold.view.tips.TipsContainer;
import com.didi.addressold.view.tips.TipsView;
import com.didi.addressold.widget.EditTextErasable;
import com.didi.autotracker.AutoTrackHelper;
import com.sdk.poibase.model.AddressParam;
import com.taxis99.R;

public class SugSearchView extends LinearLayout {
    public static final int TYPE_END = 2;
    public static final int TYPE_START = 1;

    /* renamed from: k */
    private static final String f7952k = "show_global_sug_way_point_tips";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditTextErasable f7953a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditTextErasable f7954b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditTextErasable f7955c;

    /* renamed from: d */
    private TextView f7956d;

    /* renamed from: e */
    private ViewGroup f7957e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ImageView f7958f;

    /* renamed from: g */
    private int f7959g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ISearchViewCallback f7960h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SugParams f7961i;
    public boolean isStartTextNeedScrollToBottomWhenFocused = false;
    public boolean isStartTextRedColor = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public TipsContainer f7962j;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TextWatcher f7963l = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f7953a);
            if (SugSearchView.this.f7960h != null) {
                SugSearchView.this.f7960h.afterTextChanged(SugSearchView.this.f7953a, 1, editable);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: m */
    public TextWatcher f7964m = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f7954b);
            if (SugSearchView.this.f7960h != null) {
                SugSearchView.this.f7960h.afterTextChanged(SugSearchView.this.f7954b, 2, editable);
            }
        }
    };

    /* renamed from: n */
    private TextWatcher f7965n = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f7955c);
            if (SugSearchView.this.f7960h != null) {
                SugSearchView.this.f7960h.afterTextChanged(SugSearchView.this.f7955c, 3, editable);
            }
        }
    };

    /* renamed from: o */
    private TextWatcher f7966o = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f7955c);
            if (SugSearchView.this.f7960h != null) {
                SugSearchView.this.f7960h.afterTextChanged(SugSearchView.this.f7955c, 4, editable);
            }
        }
    };

    /* renamed from: p */
    private TextWatcher f7967p = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            SugSearchView sugSearchView = SugSearchView.this;
            sugSearchView.setInputtingTextColor(sugSearchView.f7955c);
            if (SugSearchView.this.f7960h != null) {
                SugSearchView.this.f7960h.afterTextChanged(SugSearchView.this.f7955c, 5, editable);
            }
        }
    };

    /* renamed from: q */
    private OnClickSearchButtonListener f7968q;

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
        this.f7960h = iSearchViewCallback;
    }

    public SugSearchView(Context context) {
        super(context);
        m5131a();
    }

    public SugSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5131a();
    }

    /* renamed from: a */
    private void m5131a() {
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.old_layout_search_view, this);
        this.f7953a = (EditTextErasable) inflate.findViewById(R.id.et_start);
        this.f7954b = (EditTextErasable) inflate.findViewById(R.id.et_end);
        this.f7955c = (EditTextErasable) inflate.findViewById(R.id.et_common);
        this.f7956d = (TextView) inflate.findViewById(R.id.set_common_title);
        this.f7957e = (ViewGroup) inflate.findViewById(R.id.end_layout);
        this.f7958f = (ImageView) inflate.findViewById(R.id.enter_way_point);
    }

    public boolean initSugSearchView(SugParams sugParams) {
        this.f7961i = sugParams;
        m5132a(sugParams.fromType, sugParams.addressParam.addressType);
        m5154j();
        m5135a(this.f7961i.addressParam, this.f7961i.fromType);
        return setStartText(this.f7961i);
    }

    /* renamed from: a */
    private void m5135a(AddressParam addressParam, FromType fromType) {
        if (addressParam != null) {
            if ((CommonUtils.isFromConfirmPage(fromType) || CommonUtils.isFromGetOnPage(fromType)) && addressParam.targetAddress != null) {
                String str = addressParam.targetAddress.displayName;
                this.f7954b.setText(str);
                if (!TextUtils.isEmpty(str)) {
                    this.f7954b.setSelection(0, str.length());
                }
            }
        }
    }

    /* renamed from: com.didi.addressold.view.SugSearchView$18 */
    static /* synthetic */ class C351918 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$address$FromType;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
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
                com.didi.address.FromType r1 = com.didi.address.FromType.CONFIRM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.address.FromType r1 = com.didi.address.FromType.GET_ON     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.address.FromType r1 = com.didi.address.FromType.DRIVING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.address.FromType r1 = com.didi.address.FromType.WAITRSP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.address.FromType r1 = com.didi.address.FromType.SETTING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.address.FromType r1 = com.didi.address.FromType.ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.address.FromType r1 = com.didi.address.FromType.FROM_CONFIRM_ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.address.FromType r1 = com.didi.address.FromType.FROM_HOME_ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.addressold.view.SugSearchView.C351918.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m5132a(FromType fromType, int i) {
        if (fromType != null) {
            boolean z = true;
            int i2 = 0;
            switch (C351918.$SwitchMap$com$didi$address$FromType[fromType.ordinal()]) {
                case 1:
                    if (!(i == 3 || i == 4)) {
                        z = false;
                    }
                    this.f7955c.setVisibility(z ? 0 : 8);
                    this.f7953a.setVisibility(z ? 8 : 0);
                    ViewGroup viewGroup = this.f7957e;
                    if (z) {
                        i2 = 8;
                    }
                    viewGroup.setVisibility(i2);
                    if (z) {
                        setCommonHint(i);
                        setTitle(i);
                    }
                    showEnterWayPointView();
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    this.f7955c.setVisibility(8);
                    if (i == 2) {
                        this.f7953a.setVisibility(8);
                        this.f7957e.setVisibility(0);
                    } else if (i == 1) {
                        this.f7953a.setVisibility(0);
                        this.f7957e.setVisibility(8);
                    } else {
                        this.f7953a.setVisibility(8);
                        this.f7957e.setVisibility(8);
                        this.f7955c.setVisibility(0);
                        this.f7955c.setHint(i == 4 ? R.string.global_sug_add_company : R.string.global_sug_input_home);
                    }
                    showEnterWayPointView();
                    return;
                case 6:
                    setTitle(i);
                    this.f7953a.setVisibility(8);
                    this.f7957e.setVisibility(8);
                    this.f7955c.setVisibility(0);
                    setCommonHint(i);
                    return;
                case 7:
                case 8:
                case 9:
                    this.f7956d.setVisibility(8);
                    this.f7953a.setVisibility(8);
                    this.f7957e.setVisibility(8);
                    this.f7955c.setVisibility(0);
                    setCommonHint(i);
                    if (i == 1) {
                        this.f7955c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.old_report_green_dot), (Drawable) null, (Drawable) null, (Drawable) null);
                        return;
                    } else if (i == 2) {
                        this.f7955c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.old_report_brown_dot), (Drawable) null, (Drawable) null, (Drawable) null);
                        return;
                    } else if (i == 6) {
                        this.f7955c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.old_report_black_dot), (Drawable) null, (Drawable) null, (Drawable) null);
                        return;
                    } else {
                        this.f7955c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        if (com.didi.addressold.util.CommonUtils.isFromConfirmPage(r4.f7961i.fromType) != false) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showEnterWayPointView() {
        /*
            r4 = this;
            android.view.ViewGroup r0 = r4.f7957e
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            com.didi.address.model.SugParams r0 = r4.f7961i
            r1 = 0
            if (r0 == 0) goto L_0x001a
            boolean r0 = r0.enable_way_point
            com.didi.address.model.SugParams r2 = r4.f7961i
            com.didi.address.FromType r2 = r2.fromType
            boolean r2 = com.didi.addressold.util.CommonUtils.isFromConfirmPage(r2)
            if (r2 == 0) goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            if (r0 != 0) goto L_0x001e
            return
        L_0x001e:
            android.content.res.Resources r0 = r4.getResources()
            r2 = 2131165405(0x7f0700dd, float:1.7945026E38)
            float r0 = r0.getDimension(r2)
            int r0 = (int) r0
            android.content.Context r2 = r4.getContext()
            r3 = 1107296256(0x42000000, float:32.0)
            int r2 = com.didi.addressold.util.ViewUtils.dip2px(r2, r3)
            int r0 = r0 + r2
            android.widget.ImageView r2 = r4.f7958f
            r2.setVisibility(r1)
            com.didi.addressold.widget.EditTextErasable r1 = r4.f7953a
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            r1.setMarginEnd(r0)
            com.didi.addressold.widget.EditTextErasable r2 = r4.f7953a
            r2.setLayoutParams(r1)
            com.didi.addressold.widget.EditTextErasable r1 = r4.f7955c
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            r1.setMarginEnd(r0)
            com.didi.addressold.widget.EditTextErasable r0 = r4.f7955c
            r0.setLayoutParams(r1)
            r4.m5139b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressold.view.SugSearchView.showEnterWayPointView():void");
    }

    /* renamed from: b */
    private void m5139b() {
        if (PreferenceUtil.getInstance(getContext().getApplicationContext()).getBoolean(f7952k, true)) {
            if (this.f7962j == null) {
                this.f7962j = new TipsContainer((Activity) getContext());
            }
            this.f7962j.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    SugSearchView.this.dismissPopupTips();
                    return false;
                }
            });
            final TipsView tipsView = new TipsView(getContext());
            tipsView.setTips(getResources().getString(R.string.global_sug_way_point_tips));
            tipsView.setId(this.f7958f.hashCode());
            tipsView.setCloseListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    PreferenceUtil.getInstance(SugSearchView.this.getContext().getApplicationContext()).put(SugSearchView.f7952k, false);
                    AddressTrack.trackClickWayPointTips();
                }
            });
            this.f7958f.post(new Runnable() {
                public void run() {
                    AddressTrack.trackShowWayPointTips(SugSearchView.this.f7961i.addressParam);
                    int dip2px = ViewUtils.dip2px(SugSearchView.this.getContext(), 10.0f);
                    if (ViewUtils.isRTL()) {
                        SugSearchView.this.f7962j.show(tipsView, SugSearchView.this.f7958f, 2, 1, ViewUtils.getScreenWidth(SugSearchView.this.getContext()), dip2px, false);
                        return;
                    }
                    SugSearchView.this.f7962j.show(tipsView, SugSearchView.this.f7958f, 2, 1, ViewUtils.dip2px(SugSearchView.this.getContext(), 36.0f), dip2px, false);
                }
            });
        }
    }

    public void dismissPopupTips() {
        TipsContainer tipsContainer = this.f7962j;
        if (tipsContainer != null) {
            tipsContainer.clearAllTips();
            this.f7962j.setOnTouchListener((View.OnTouchListener) null);
        }
    }

    public void setOnEnterWayPointViewClickListener(View.OnClickListener onClickListener) {
        this.f7958f.setOnClickListener(onClickListener);
    }

    private void setTitle(int i) {
        this.f7956d.setVisibility(0);
        if (i == 4) {
            this.f7956d.setText(R.string.global_sug_add_company);
        } else if (i == 3) {
            this.f7956d.setText(R.string.global_sug_add_home);
        } else if (i == 5) {
            this.f7956d.setText(R.string.global_edit_favorite_place_title_add);
        } else {
            this.f7956d.setText(R.string.global_sug_add_home);
        }
    }

    private void setCommonHint(int i) {
        int i2 = R.string.global_sug_input_home;
        if (i == 4) {
            i2 = R.string.global_sug_input_company;
        } else if (i != 3) {
            if (i == 6) {
                i2 = R.string.global_sug_input_stop_hint;
            } else if (i == 5) {
                i2 = R.string.global_sug_input_favorite;
            } else if (i == 1) {
                i2 = R.string.global_sug_to_departure;
            } else if (i == 2) {
                i2 = R.string.global_sug_to_go;
            }
        }
        this.f7955c.setHint(i2);
    }

    public void addStatusBarHeightView() {
        View view = new View(getContext());
        this.f7959g = ViewUtils.getStatusBarHeight(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f7959g));
        view.setBackgroundColor(-1);
        addView(view, 0);
    }

    public void onStartPoiInfoFetchBefore() {
        this.f7953a.setTextColor(getResources().getColor(R.color.poi_one_address_hint));
    }

    public void onStartPoiInfoFetchAfter() {
        if (CommonUtils.isFromHomePage(this.f7961i.fromType)) {
            getStartEditText().setTextColor(getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
            getStartEditText().setHighlightColor(getResources().getColor(R.color.poi_one_address_text_start_normal_hint));
            return;
        }
        this.f7953a.setTextColor(-16777216);
    }

    public void onEndPoiInfoFetchBefore() {
        this.f7954b.setTextColor(getResources().getColor(R.color.poi_one_address_hint));
    }

    public void onEndPoiInfoFetchAfter() {
        this.f7954b.setTextColor(-16777216);
    }

    public void makeStartTextFocusedWhenIsRed() {
        EditTextErasable editTextErasable;
        if (CommonUtils.isFromHomePage(this.f7961i.fromType) && this.isStartTextRedColor && (editTextErasable = this.f7953a) != null && !TextUtils.isEmpty(editTextErasable.getHint()) && this.f7953a.getHint().toString().equals(getResources().getString(R.string.global_sug_to_departure))) {
            this.f7953a.setHintTextColor(getResources().getColor(R.color.poi_one_address_hint));
            this.isStartTextNeedScrollToBottomWhenFocused = false;
            this.f7953a.requestFocus();
        }
    }

    public boolean setStartText(SugParams sugParams) {
        boolean z;
        String str = "";
        boolean z2 = true;
        if (CommonUtils.isValidLocation(sugParams.addressParam.currentAddress) || CommonUtils.isValidLocation(sugParams.addressParam.targetAddress)) {
            z = sugParams.fromType == FromType.HOME || sugParams.fromType == FromType.CONFIRM || CommonUtils.isGetOnFromType(sugParams.fromType);
            if (sugParams.addressParam.targetAddress != null) {
                str = sugParams.addressParam.targetAddress.displayName;
            }
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(R.string.global_sug_to_departure);
            } else {
                z2 = false;
            }
            if (sugParams.addressParam.targetAddress != null) {
                sugParams.addressParam.targetAddress.displayName = str;
            }
        } else {
            this.isStartTextRedColor = true;
            this.f7953a.setHint(getResources().getString(R.string.global_sug_to_departure));
            this.f7953a.setHintTextColor(getResources().getColor(R.color.poi_one_address_text_start_nogps_hint));
            z = false;
            z2 = false;
        }
        this.f7953a.setText(str);
        if (CommonUtils.isFromGetOnPage(sugParams.fromType) && !TextUtils.isEmpty(str)) {
            this.f7953a.setSelection(0, str.length());
        }
        this.f7953a.setTextColor(z2 ? getResources().getColor(R.color.poi_one_address_text_start_noname_hint) : -16777216);
        if (CommonUtils.isFromHomePage(this.f7961i.fromType)) {
            getStartEditText().setTextColor(getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
            getStartEditText().setHighlightColor(getResources().getColor(R.color.poi_one_address_text_start_normal_hint));
        }
        return z;
    }

    public EditTextErasable getCommonEditText() {
        return this.f7955c;
    }

    public EditTextErasable getStartEditText() {
        return this.f7953a;
    }

    public EditTextErasable getEndEditText() {
        return this.f7954b;
    }

    private void setListeners(FromType fromType) {
        if (CommonUtils.isFromHomePage(fromType)) {
            m5141c();
        }
        EditTextErasable editTextErasable = this.f7953a;
        if (editTextErasable != null) {
            editTextErasable.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SugSearchView.this.f7953a.setClearIconVisible(!(SugSearchView.this.f7953a.getText() == null || SugSearchView.this.f7953a.getText().length() == 0));
                    if (SugSearchView.this.f7960h != null) {
                        SugSearchView.this.f7960h.onClick(1);
                    }
                }
            });
            this.f7953a.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear() {
                    if (SugSearchView.this.f7960h != null) {
                        SugSearchView.this.f7960h.onClearClick(1);
                    }
                }
            });
        }
        EditTextErasable editTextErasable2 = this.f7954b;
        if (editTextErasable2 != null) {
            editTextErasable2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SugSearchView.this.f7954b.setClearIconVisible(!(SugSearchView.this.f7954b.getText() == null || SugSearchView.this.f7954b.getText().length() == 0));
                    if (SugSearchView.this.f7960h != null) {
                        SugSearchView.this.f7960h.onClick(2);
                    }
                }
            });
            this.f7954b.setOnClearListener(new EditTextErasable.OnClearListener() {
                public void onClear() {
                    if (SugSearchView.this.f7960h != null) {
                        SugSearchView.this.f7960h.onClearClick(2);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    private void m5141c() {
        EditTextErasable editTextErasable = this.f7953a;
        if (editTextErasable != null) {
            editTextErasable.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    boolean z2 = true;
                    if (SugSearchView.this.f7960h != null) {
                        SugSearchView.this.f7960h.focusChanged(1, z);
                    }
                    if (SugSearchView.this.f7953a != null) {
                        boolean z3 = SugSearchView.this.f7953a.getText() == null || SugSearchView.this.f7953a.getText().length() == 0;
                        EditTextErasable d = SugSearchView.this.f7953a;
                        if (!z || z3) {
                            z2 = false;
                        }
                        d.setClearIconVisible(z2);
                        if (!z) {
                            SugSearchView.this.f7953a.removeTextChangedListener(SugSearchView.this.f7963l);
                        }
                    }
                }
            });
        }
        EditTextErasable editTextErasable2 = this.f7954b;
        if (editTextErasable2 != null) {
            editTextErasable2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (SugSearchView.this.f7960h != null) {
                        SugSearchView.this.f7960h.focusChanged(2, z);
                    }
                    if (SugSearchView.this.f7954b != null) {
                        boolean z2 = false;
                        boolean z3 = SugSearchView.this.f7954b.getText() == null || SugSearchView.this.f7954b.getText().length() == 0;
                        EditTextErasable f = SugSearchView.this.f7954b;
                        if (z && !z3) {
                            z2 = true;
                        }
                        f.setClearIconVisible(z2);
                        if (z) {
                            SugSearchView.this.f7954b.addTextChangedListener(SugSearchView.this.f7964m);
                        } else {
                            SugSearchView.this.f7954b.removeTextChangedListener(SugSearchView.this.f7964m);
                        }
                    }
                }
            });
        }
    }

    public void addWatcherForStart() {
        EditTextErasable editTextErasable = this.f7953a;
        if (editTextErasable != null) {
            editTextErasable.addTextChangedListener(this.f7963l);
        }
    }

    public void removeWatcherForStart() {
        EditTextErasable editTextErasable = this.f7953a;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7963l);
        }
    }

    public void setListener(SugParams sugParams) {
        setListeners(sugParams.fromType);
        m5134a(sugParams.addressParam);
    }

    /* renamed from: d */
    private void m5143d() {
        EditTextErasable editTextErasable = this.f7955c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7966o);
            this.f7955c.removeTextChangedListener(this.f7967p);
            this.f7955c.addTextChangedListener(this.f7965n);
        }
    }

    /* renamed from: e */
    private void m5145e() {
        EditTextErasable editTextErasable = this.f7955c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7965n);
            this.f7955c.removeTextChangedListener(this.f7967p);
            this.f7955c.addTextChangedListener(this.f7966o);
        }
    }

    /* renamed from: f */
    private void m5147f() {
        EditTextErasable editTextErasable = this.f7955c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7966o);
            this.f7955c.removeTextChangedListener(this.f7965n);
            this.f7955c.addTextChangedListener(this.f7967p);
        }
    }

    public void removeCommonWatcher(AddressParam addressParam) {
        if (addressParam.addressType == 4) {
            m5149g();
        } else if (addressParam.addressType == 3) {
            m5151h();
        } else {
            m5153i();
        }
    }

    /* renamed from: g */
    private void m5149g() {
        EditTextErasable editTextErasable = this.f7955c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7966o);
        }
    }

    /* renamed from: h */
    private void m5151h() {
        EditTextErasable editTextErasable = this.f7955c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7965n);
        }
    }

    /* renamed from: i */
    private void m5153i() {
        EditTextErasable editTextErasable = this.f7955c;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7967p);
        }
    }

    /* renamed from: a */
    private void m5134a(AddressParam addressParam) {
        EditTextErasable editTextErasable = this.f7954b;
        if (editTextErasable != null) {
            editTextErasable.addTextChangedListener(this.f7964m);
        }
        if (addressParam.addressType == 4) {
            m5145e();
        } else if (addressParam.addressType == 3) {
            m5143d();
        } else {
            m5147f();
        }
    }

    public void removeEndTextWatcher() {
        EditTextErasable editTextErasable = this.f7954b;
        if (editTextErasable != null) {
            editTextErasable.removeTextChangedListener(this.f7964m);
        }
    }

    public void addEndTextWatcher() {
        EditTextErasable editTextErasable = this.f7954b;
        if (editTextErasable != null) {
            editTextErasable.addTextChangedListener(this.f7964m);
        }
    }

    /* renamed from: j */
    private void m5154j() {
        EditTextErasable editTextErasable = this.f7953a;
        if (editTextErasable != null) {
            editTextErasable.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return SugSearchView.this.m5136a(textView, i, 1);
                }
            });
        }
        EditTextErasable editTextErasable2 = this.f7954b;
        if (editTextErasable2 != null) {
            editTextErasable2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return SugSearchView.this.m5136a(textView, i, 2);
                }
            });
        }
        EditTextErasable editTextErasable3 = this.f7955c;
        if (editTextErasable3 != null) {
            editTextErasable3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    SugSearchView sugSearchView = SugSearchView.this;
                    return sugSearchView.m5136a(textView, i, sugSearchView.f7961i.addressParam.addressType);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5136a(TextView textView, int i, int i2) {
        if (i != 3) {
            return false;
        }
        String trim = textView.getText().toString().trim();
        OnClickSearchButtonListener onClickSearchButtonListener = this.f7968q;
        if (onClickSearchButtonListener == null) {
            return true;
        }
        onClickSearchButtonListener.onClickSearchButton(i2, trim);
        return true;
    }

    public void setOnClickSearchButtonListener(OnClickSearchButtonListener onClickSearchButtonListener) {
        this.f7968q = onClickSearchButtonListener;
    }
}
