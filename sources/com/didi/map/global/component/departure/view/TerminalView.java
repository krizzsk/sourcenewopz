package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.departure.model.SPoi;
import com.didi.map.global.component.departure.model.SpecialPois;
import com.didi.map.global.component.departure.view.ITerminalView;
import com.didi.map.global.component.departure.wheel.WheelView;
import com.didiglobal.font.DIDIFontUtils;
import com.sdk.poibase.model.RpcPoi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TerminalView extends LinearLayout implements ITerminalView {

    /* renamed from: a */
    private TextView f25350a;

    /* renamed from: b */
    private TextView f25351b;

    /* renamed from: c */
    private View f25352c;

    /* renamed from: d */
    private TextView f25353d;

    /* renamed from: e */
    private TextView f25354e;

    /* renamed from: f */
    private WheelView<C9454a> f25355f;

    /* renamed from: g */
    private TextView f25356g;

    /* renamed from: h */
    private TextView f25357h;

    /* renamed from: i */
    private SpecialPois f25358i;

    /* renamed from: j */
    private List<SPoi> f25359j;

    /* renamed from: k */
    private List<C9454a> f25360k;

    /* renamed from: l */
    private SPoi f25361l;

    /* renamed from: m */
    private boolean f25362m;

    /* renamed from: n */
    private boolean f25363n;

    /* renamed from: o */
    private ITerminalView.Callback f25364o;

    /* renamed from: p */
    private boolean f25365p;

    /* renamed from: q */
    private int f25366q;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m18148a(View view, MotionEvent motionEvent) {
        return true;
    }

    public TerminalView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TerminalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TerminalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f25366q = 0;
        m18145a(context);
    }

    /* renamed from: a */
    private void m18145a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_map_departure_terminal, this);
        this.f25350a = (TextView) inflate.findViewById(R.id.terminal_title);
        this.f25351b = (TextView) inflate.findViewById(R.id.warning_text);
        this.f25352c = inflate.findViewById(R.id.terminal_area);
        this.f25353d = (TextView) inflate.findViewById(R.id.terminal_area_name);
        this.f25354e = (TextView) inflate.findViewById(R.id.change_terminal_area);
        this.f25355f = (WheelView) inflate.findViewById(R.id.wheelView);
        this.f25356g = (TextView) inflate.findViewById(R.id.confirm_pickup);
        this.f25357h = (TextView) inflate.findViewById(R.id.select_other_area);
        Drawable drawable = inflate.getResources().getDrawable(R.drawable.map_departure_right_arrow);
        drawable.setAutoMirrored(true);
        this.f25357h.setCompoundDrawablePadding(DisplayUtils.dp2px(inflate.getContext(), 4.0f));
        this.f25357h.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        DIDIFontUtils.Companion.setTypeface(context, this.f25350a);
        DIDIFontUtils.Companion.setTypeface(context, this.f25351b);
        DIDIFontUtils.Companion.setTypeface(context, this.f25353d);
        DIDIFontUtils.Companion.setTypeface(context, this.f25354e);
        DIDIFontUtils.Companion.setTypeface(context, this.f25356g);
        DIDIFontUtils.Companion.setTypeface(context, this.f25357h);
        m18143a();
        inflate.setOnTouchListener($$Lambda$TerminalView$CXB_dQoIeNY_ipBmMDXYbRDPQXg.INSTANCE);
        try {
            this.f25356g.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f25356g.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f25354e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TerminalView.this.m18153c(view);
            }
        });
        this.f25356g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TerminalView.this.m18152b(view);
            }
        });
        this.f25357h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TerminalView.this.m18146a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m18153c(View view) {
        this.f25363n = true;
        ITerminalView.Callback callback = this.f25364o;
        if (callback != null) {
            callback.onClickChange(this.f25358i);
        }
        m18151b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18152b(View view) {
        if (this.f25363n) {
            SPoi a = m18141a(this.f25355f.getSelection());
            if (a != null) {
                this.f25363n = false;
                this.f25361l = a;
                ITerminalView.Callback callback = this.f25364o;
                if (callback != null) {
                    callback.onClickNext(a);
                }
                setSelectedArea(a);
                return;
            }
            return;
        }
        ITerminalView.Callback callback2 = this.f25364o;
        if (callback2 != null) {
            callback2.onClickConfirmPickup(m18150b(this.f25355f.getSelection()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18146a(View view) {
        ITerminalView.Callback callback = this.f25364o;
        if (callback != null) {
            callback.onClickBroadOther();
        }
    }

    /* renamed from: a */
    private void m18143a() {
        this.f25355f.setWheelAdapter(new TerminalWheelAdapter(getContext()));
        this.f25355f.setWheelSize(3);
        this.f25355f.setWheelClickable(false);
        WheelView.WheelViewStyle wheelViewStyle = new WheelView.WheelViewStyle();
        wheelViewStyle.backgroundColor = -1;
        wheelViewStyle.textColor = Color.parseColor("#303030");
        wheelViewStyle.selectedTextColor = Color.parseColor("#000000");
        wheelViewStyle.selectedTextBold = false;
        wheelViewStyle.selectedTextSize = getResources().getInteger(R.integer.i_16);
        wheelViewStyle.textSize = getResources().getInteger(R.integer.i_14);
        wheelViewStyle.holoBorderColor = Color.parseColor("#1A000000");
        wheelViewStyle.holoBorderWidth = 1;
        wheelViewStyle.textAlpha = 0.3f;
        this.f25355f.setStyle(wheelViewStyle);
        this.f25355f.setClickToPosition(true);
        this.f25355f.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
            public final void onItemSelected(int i, Object obj, int i2) {
                TerminalView.this.m18144a(i, (C9454a) obj, i2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18144a(int i, C9454a aVar, int i2) {
        ITerminalView.Callback callback = this.f25364o;
        if (callback == null) {
            return;
        }
        if (this.f25363n) {
            SPoi a = m18141a(i);
            this.f25361l = a;
            this.f25364o.onTerminalAreaSelected(a, i2);
            return;
        }
        callback.onDepartureSelected(m18150b(i), i2);
    }

    public void setCardStyle(int i) {
        this.f25366q = i;
    }

    public void setShowBroadOtherInAreaCard(boolean z) {
        this.f25365p = z;
        this.f25357h.setVisibility(z ? 0 : 8);
    }

    public void setCallback(ITerminalView.Callback callback) {
        this.f25364o = callback;
    }

    public void setData(SpecialPois specialPois) {
        if (specialPois == null || specialPois.area == null || CollectionUtil.isEmpty((Collection<?>) specialPois.pois)) {
            this.f25362m = false;
            return;
        }
        m18147a(specialPois);
        if (!CollectionUtil.isEmpty((Collection<?>) this.f25359j) || !CollectionUtil.isEmpty((Collection<?>) this.f25360k) || this.f25361l != null) {
            this.f25362m = true;
            SPoi sPoi = this.f25361l;
            if (sPoi != null) {
                this.f25363n = false;
                setSelectedArea(sPoi);
                return;
            }
            this.f25363n = true;
            m18151b();
            return;
        }
        this.f25362m = false;
    }

    public void setPickupPoiNotice(String str) {
        if (!TextUtils.isEmpty(str)) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(str);
            richTextInfo.bindTo(this.f25351b);
            this.f25351b.setVisibility(0);
            return;
        }
        this.f25351b.setText("");
        this.f25351b.setVisibility(8);
    }

    public View getView() {
        if (isValid()) {
            return this;
        }
        return null;
    }

    public boolean isValid() {
        return this.f25362m;
    }

    public boolean isTerminal() {
        return this.f25363n;
    }

    public void setSelectedTerminalArea(SPoi sPoi) {
        if (isValid() && sPoi != null && sPoi.area != null) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 < this.f25358i.pois.size()) {
                    SPoi sPoi2 = this.f25358i.pois.get(i2);
                    if (sPoi2 != null && sPoi2.area != null && sPoi2.area.f25199id != null && sPoi2.area.f25199id.equals(sPoi.area.f25199id)) {
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            this.f25355f.setSelection(i);
            setPickupPoiNotice("");
        }
    }

    public void performSelectedArea(SPoi sPoi, RpcPoi rpcPoi) {
        if (sPoi != null) {
            this.f25361l = sPoi;
            setSelectedArea(sPoi);
            this.f25355f.setSelection(m18140a(sPoi, rpcPoi));
        }
    }

    public SPoi getSelectedTerminalArea() {
        return m18141a(m18149b(this.f25361l));
    }

    public void setSelectedDeparture(RpcPoi rpcPoi) {
        SPoi sPoi;
        if (isValid() && rpcPoi != null) {
            int i = 0;
            if (rpcPoi.base_info != null && !TextUtils.isEmpty(rpcPoi.base_info.poi_id) && (sPoi = this.f25361l) != null && sPoi.list != null) {
                int i2 = 0;
                while (true) {
                    if (i2 < this.f25361l.list.size()) {
                        RpcPoi rpcPoi2 = this.f25361l.list.get(i2);
                        if (rpcPoi2 != null && rpcPoi2.base_info != null && rpcPoi.base_info.poi_id.equals(rpcPoi2.base_info.poi_id)) {
                            i = i2;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            this.f25355f.setSelection(i);
        }
    }

    public RpcPoi getSelectedDeparture() {
        return m18150b(this.f25355f.getSelection());
    }

    /* renamed from: b */
    private void m18151b() {
        this.f25357h.setVisibility(this.f25365p ? 0 : 8);
        this.f25352c.setVisibility(8);
        this.f25350a.setText(R.string.GRider_Homepage0714_Get_in_rhbS);
        this.f25356g.setText(R.string.GRider_Homepage0714_Next_step_vpJv);
        this.f25355f.setWheelData(this.f25360k);
        this.f25355f.setSelection(m18149b(this.f25361l));
        setPickupPoiNotice("");
    }

    private void setSelectedArea(SPoi sPoi) {
        this.f25357h.setVisibility(8);
        int i = 0;
        this.f25352c.setVisibility(0);
        this.f25353d.setText(sPoi.area.name);
        if (this.f25366q == 1) {
            this.f25350a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_pickup));
            this.f25356g.setText(getResources().getString(R.string.GRider_page_Order_tfYG));
        } else {
            this.f25350a.setText(R.string.GRider_Homepage0714_Go_to_cqWv);
            this.f25356g.setText(R.string.GRider_Homepage0714_Get_on_TWaG);
        }
        List<C9454a> a = m18142a(sPoi);
        if (!CollectionUtil.isEmpty((Collection<?>) a)) {
            this.f25355f.setWheelData(a);
            int i2 = 0;
            while (true) {
                if (i2 < a.size()) {
                    C9454a aVar = a.get(i2);
                    if (aVar != null && aVar.f25382d) {
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            this.f25355f.setSelection(i);
        }
    }

    /* renamed from: a */
    private SPoi m18141a(int i) {
        List<C9454a> list = this.f25360k;
        if (list == null || i >= list.size() || this.f25360k.get(i) == null) {
            return null;
        }
        String str = this.f25360k.get(i).f25381c;
        for (SPoi next : this.f25359j) {
            if (!TextUtils.isEmpty(str) && str.equals(next.area.f25199id)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: b */
    private RpcPoi m18150b(int i) {
        SPoi sPoi = this.f25361l;
        if (sPoi == null || sPoi.list == null || i >= this.f25361l.list.size()) {
            return null;
        }
        return this.f25361l.list.get(i);
    }

    /* renamed from: a */
    private void m18147a(SpecialPois specialPois) {
        this.f25358i = specialPois;
        if (specialPois != null) {
            this.f25361l = null;
            List<SPoi> list = this.f25359j;
            if (list == null) {
                this.f25359j = new ArrayList();
            } else {
                list.clear();
            }
            List<C9454a> list2 = this.f25360k;
            if (list2 == null) {
                this.f25360k = new ArrayList();
            } else {
                list2.clear();
            }
            for (SPoi next : this.f25358i.pois) {
                if (next != null && next.area != null && !TextUtils.isEmpty(next.area.name) && !TextUtils.isEmpty(next.area.f25199id) && !CollectionUtil.isEmpty((Collection<?>) next.list)) {
                    this.f25359j.add(next);
                    this.f25360k.add(new C9454a(next.area.name, next.area.f25199id, false, false));
                    if (this.f25361l == null && specialPois.area != null && specialPois.area.point_first == 1 && next != null && next.area != null && next.area.is_nearest == 1) {
                        this.f25361l = next;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private List<C9454a> m18142a(SPoi sPoi) {
        ArrayList arrayList = new ArrayList();
        for (RpcPoi next : sPoi.list) {
            if (!(next == null || next.base_info == null || TextUtils.isEmpty(next.base_info.poi_id))) {
                String str = next.base_info.displayname;
                String str2 = next.base_info.poi_id;
                boolean z = false;
                boolean z2 = next.base_info.is_nearest == 1;
                if (next.base_info.is_recommend_absorb == 1) {
                    z = true;
                }
                arrayList.add(new C9454a(str, str2, z2, z));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private int m18149b(SPoi sPoi) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f25359j)) {
            int i = 0;
            for (SPoi next : this.f25359j) {
                if (sPoi != null && sPoi.area != null && sPoi.area.f25199id != null && next != null && next.area != null && sPoi.area.f25199id.equals(next.area.f25199id)) {
                    return i;
                }
                i++;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private int m18140a(SPoi sPoi, RpcPoi rpcPoi) {
        if (!(sPoi == null || sPoi.area == null || rpcPoi == null || rpcPoi.base_info == null || CollectionUtil.isEmpty((Collection<?>) sPoi.list))) {
            int i = 0;
            for (RpcPoi next : sPoi.list) {
                if (next != null && next.base_info != null && next.base_info.lat == rpcPoi.base_info.lat && next.base_info.lng == rpcPoi.base_info.lng) {
                    return i;
                }
                i++;
            }
        }
        return 0;
    }
}
