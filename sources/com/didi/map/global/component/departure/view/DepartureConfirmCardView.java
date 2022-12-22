package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.taxis99.R;

public class DepartureConfirmCardView extends FrameLayout {

    /* renamed from: a */
    private TextView f25319a;

    /* renamed from: b */
    private TextView f25320b;

    /* renamed from: c */
    private TextView f25321c;

    /* renamed from: d */
    private View f25322d;

    /* renamed from: e */
    private TextView f25323e;

    /* renamed from: f */
    private TextView f25324f;

    /* renamed from: g */
    private boolean f25325g;

    public @interface DepartureMapPoiSelectCardStyle {
        public static final int SELECT_COMPANY = 6;
        public static final int SELECT_END = 2;
        public static final int SELECT_FAVORITE = 7;
        public static final int SELECT_HOME = 5;
        public static final int SELECT_START = 1;
        public static final int SELECT_WAYPOINT_1 = 3;
        public static final int SELECT_WAYPOINT_2 = 4;
    }

    public DepartureConfirmCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DepartureConfirmCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DepartureConfirmCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f25325g = true;
        m18121a(context);
    }

    /* renamed from: a */
    private void m18121a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_view_pickup_spot_layout, this);
        this.f25319a = (TextView) inflate.findViewById(R.id.tv_confirm_departure_point_title);
        this.f25320b = (TextView) inflate.findViewById(R.id.tv_confirm_departure_point_subtitle);
        this.f25323e = (TextView) inflate.findViewById(R.id.tvInputAddress);
        this.f25324f = (TextView) inflate.findViewById(R.id.tvSearch);
        this.f25321c = (TextView) inflate.findViewById(R.id.btnPoiSelect);
        this.f25322d = inflate.findViewById(R.id.vAddrPrefixImg);
        try {
            this.f25321c.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f25321c.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoiSelectButtonText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f25321c.setText(str);
        }
    }

    public void requestPoiSelectCardFeature(int i) {
        switch (i) {
            case 1:
                this.f25319a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_pickup));
                this.f25321c.setText(getResources().getString(R.string.GRider_page_Order_tfYG));
                setInputDotIconGrren();
                return;
            case 2:
                this.f25319a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_whereTo));
                this.f25321c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_whereTo));
                setInputDotIconOrange();
                return;
            case 3:
                this.f25319a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_stop1));
                this.f25321c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_stop1));
                setInputDotIconOrange();
                return;
            case 4:
                this.f25319a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_stop2));
                this.f25321c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_stop2));
                setInputDotIconOrange();
                return;
            case 5:
                this.f25319a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_home));
                this.f25321c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_home));
                setInputDotIconGrren();
                return;
            case 6:
                this.f25319a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_work));
                this.f25321c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_work));
                setInputDotIconGrren();
                return;
            case 7:
                this.f25319a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_favorite));
                this.f25321c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_favorite));
                setInputDotIconGrren();
                return;
            default:
                return;
        }
    }

    public void setSearchOnClickListener(View.OnClickListener onClickListener) {
        this.f25324f.setOnClickListener(onClickListener);
        this.f25323e.setOnClickListener(onClickListener);
    }

    public void setButtonOnClickListener(View.OnClickListener onClickListener) {
        this.f25321c.setOnClickListener(m18119a(onClickListener));
    }

    /* renamed from: a */
    private View.OnClickListener m18119a(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            return new View.OnClickListener(onClickListener) {
                public final /* synthetic */ View.OnClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    DepartureConfirmCardView.this.m18122a(this.f$1, view);
                }
            };
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18122a(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null && this.f25325g) {
            onClickListener.onClick(view);
        }
    }

    public void setInputDotIcon(int i) {
        this.f25322d.setBackgroundResource(i);
    }

    public void setInputDotIconGrren() {
        this.f25322d.setBackgroundResource(R.drawable.com_icon_pickup);
    }

    public void setInputDotIconOrange() {
        this.f25322d.setBackgroundResource(R.drawable.com_icon_dest);
    }

    public void setInputDotIconDisable() {
        this.f25322d.setBackgroundResource(R.drawable.map_input_icon_pick_up_dis);
    }

    public void setStationBroadOtherTitleNames() {
        this.f25319a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_pickup));
        this.f25320b.setText(getResources().getString(R.string.GRider_Pickuppage0811_Drag_the_ISEY));
    }

    public void setMainTitleDefault() {
        this.f25319a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_pickup));
    }

    public void setLoadding(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f25323e.setText(str);
        }
        m18120a();
    }

    /* renamed from: a */
    private void m18120a() {
        this.f25321c.setEnabled(false);
        this.f25325g = false;
    }

    /* renamed from: b */
    private void m18123b() {
        this.f25321c.setEnabled(true);
        this.f25325g = true;
    }

    public void setMainTitle(CharSequence charSequence) {
        if (charSequence != null) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(charSequence.toString());
            richTextInfo.bindTo(this.f25319a);
            return;
        }
        this.f25319a.setText("");
    }

    public void setSubTitle(CharSequence charSequence) {
        if (charSequence != null) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(charSequence.toString());
            richTextInfo.bindTo(this.f25320b);
            return;
        }
        this.f25320b.setText("");
    }

    public void setAddress(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f25323e.setText(charSequence);
            this.f25323e.setTextColor(getResources().getColor(R.color.confirm_departure_point_color));
            m18123b();
        }
    }

    public void showLoadding(CharSequence charSequence, int i) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f25323e.setText(charSequence);
            if (i != 0) {
                this.f25323e.setTextColor(i);
            }
            m18120a();
        }
    }

    public void showLoadding() {
        showLoadding(getResources().getString(R.string.GRider_Sug_2020_map_searchingAddress), getResources().getColor(R.color.light_gray));
    }

    public void showNoParking() {
        showNoParking(getResources().getString(R.string.GRider_Homepage0714_No_parking_JAWz), -65536);
    }

    public void showNoParking(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f25323e.setText(str);
            if (i != 0) {
                this.f25323e.setTextColor(i);
            } else {
                this.f25323e.setTextColor(-65536);
            }
        }
    }

    public TextView getMainTitle() {
        return this.f25319a;
    }

    public TextView getSubtitle() {
        return this.f25320b;
    }

    public TextView getButton() {
        return this.f25321c;
    }

    public TextView getSearchButton() {
        return this.f25324f;
    }
}
