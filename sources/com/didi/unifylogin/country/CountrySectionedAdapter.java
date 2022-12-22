package com.didi.unifylogin.country;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.store.LoginStore;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CountrySectionedAdapter extends BaseAdapter {

    /* renamed from: c */
    private static final int f44741c = 2;

    /* renamed from: d */
    private static int f44742d = 1;

    /* renamed from: e */
    private static int f44743e;

    /* renamed from: a */
    List<CountrySectionData> f44744a = new ArrayList();

    /* renamed from: b */
    Context f44745b;

    /* renamed from: f */
    private SparseArray<Integer> f44746f = new SparseArray<>();

    /* renamed from: g */
    private SparseArray<Integer> f44747g = new SparseArray<>();

    /* renamed from: h */
    private SparseArray<Integer> f44748h = new SparseArray<>();

    /* renamed from: i */
    private int f44749i = -1;

    /* renamed from: j */
    private int f44750j = -1;

    public final int getViewTypeCount() {
        return 2;
    }

    public CountrySectionedAdapter(List<CountrySectionData> list, Context context) {
        this.f44744a = list;
        this.f44745b = context;
    }

    public CountrySectionedAdapter setCountrySections(List<CountrySectionData> list) {
        this.f44744a = list;
        return this;
    }

    public int getCountForSection(int i) {
        return this.f44744a.get(i).countryRules.size();
    }

    public View getItemView(int i, int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(R.layout.login_unify_view_country_list_item, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_country_select);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.country_flag);
        imageView2.setBackgroundColor(LoginStore.getContext().getResources().getColor(R.color.login_unify_color_country_placeholder));
        CountrySectionData countrySectionData = this.f44744a.get(i);
        CountryListResponse.CountryRule countryRule = countrySectionData.countryRules.get(i2);
        ((TextView) view.findViewById(R.id.area_code)).setText(countryRule.calling_code);
        ((TextView) view.findViewById(R.id.tv_country_name)).setText(countryRule.name);
        imageView.setVisibility(4);
        Glide.with(this.f44745b).load(countryRule.getNationalFlagUrl()).into(imageView2);
        if (CountryManager.getIns().getDefCountry().country_id == countryRule.country_id) {
            imageView.setVisibility(0);
        }
        View findViewById = view.findViewById(R.id.item_divider);
        if (countrySectionData.countryRules.size() - 1 == i2) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        return view;
    }

    public View getSectionHeaderView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(R.layout.login_unify_view_country_list_item_header, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.textItem)).setText(String.valueOf(this.f44744a.get(i).letter).toUpperCase());
        return view;
    }

    public int getSectionLetterIndex(String str) {
        Iterator<CountrySectionData> it = this.f44744a.iterator();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CountrySectionData next = it.next();
            if (TextUtils.equals(str.toLowerCase(), String.valueOf(next.letter).toLowerCase())) {
                z = true;
                break;
            }
            i = i + next.countryRules.size() + 1;
        }
        if (z) {
            return i;
        }
        return -1;
    }

    public void notifyDataSetChanged() {
        this.f44747g.clear();
        this.f44746f.clear();
        this.f44748h.clear();
        this.f44749i = -1;
        this.f44750j = -1;
        super.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        this.f44747g.clear();
        this.f44746f.clear();
        this.f44748h.clear();
        this.f44749i = -1;
        this.f44750j = -1;
        super.notifyDataSetInvalidated();
    }

    public final int getCount() {
        int i = this.f44749i;
        if (i >= 0) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < m31761a(); i3++) {
            i2 = i2 + m31762a(i3) + 1;
        }
        this.f44749i = i2;
        return i2;
    }

    public final Object getItem(int i) {
        return this.f44744a.get(getSectionForPosition(i)).countryRules.get(getPositionInSectionForPosition(i));
    }

    public final long getItemId(int i) {
        if (isSectionHeader(i)) {
            return (long) i;
        }
        CountryListResponse.CountryRule countryRule = this.f44744a.get(getSectionForPosition(i)).countryRules.get(getPositionInSectionForPosition(i));
        if (countryRule != null) {
            return (long) countryRule.country_id;
        }
        return -1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (isSectionHeader(i)) {
            return getSectionHeaderView(getSectionForPosition(i), view, viewGroup);
        }
        return getItemView(getSectionForPosition(i), getPositionInSectionForPosition(i), view, viewGroup);
    }

    public final int getItemViewType(int i) {
        if (isSectionHeader(i)) {
            return f44742d;
        }
        return f44743e;
    }

    public final int getSectionForPosition(int i) {
        Integer num = this.f44747g.get(i);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < m31761a()) {
            int a = m31762a(i2) + i3 + 1;
            if (i < i3 || i >= a) {
                i2++;
                i3 = a;
            } else {
                this.f44747g.put(i, Integer.valueOf(i2));
                return i2;
            }
        }
        return 0;
    }

    public int getPositionInSectionForPosition(int i) {
        Integer num = this.f44746f.get(i);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < m31761a()) {
            int a = m31762a(i2) + i3 + 1;
            if (i < i3 || i >= a) {
                i2++;
                i3 = a;
            } else {
                int i4 = (i - i3) - 1;
                this.f44746f.put(i, Integer.valueOf(i4));
                return i4;
            }
        }
        return 0;
    }

    public final boolean isSectionHeader(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < m31761a(); i3++) {
            if (i == i2) {
                return true;
            }
            if (i < i2) {
                return false;
            }
            i2 += m31762a(i3) + 1;
        }
        return false;
    }

    /* renamed from: a */
    private int m31762a(int i) {
        Integer num = this.f44748h.get(i);
        if (num != null) {
            return num.intValue();
        }
        int countForSection = getCountForSection(i);
        this.f44748h.put(i, Integer.valueOf(countForSection));
        return countForSection;
    }

    /* renamed from: a */
    private int m31761a() {
        int i = this.f44750j;
        if (i >= 0) {
            return i;
        }
        int size = this.f44744a.size();
        this.f44750j = size;
        return size;
    }
}
