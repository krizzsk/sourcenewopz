package com.didi.nova.assembly.country.inner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CountrySectionedAdapter extends BaseAdapter {

    /* renamed from: a */
    private static final int f29177a = 2;

    /* renamed from: b */
    private static int f29178b = 1;

    /* renamed from: c */
    private static int f29179c;

    /* renamed from: d */
    private SparseArray<Integer> f29180d = new SparseArray<>();

    /* renamed from: e */
    private SparseArray<Integer> f29181e = new SparseArray<>();

    /* renamed from: f */
    private SparseArray<Integer> f29182f = new SparseArray<>();

    /* renamed from: g */
    private int f29183g = -1;

    /* renamed from: h */
    private int f29184h = -1;

    /* renamed from: i */
    private List<CountrySectionModel> f29185i = new ArrayList();

    /* renamed from: j */
    private Context f29186j;

    /* renamed from: k */
    private int f29187k;

    public long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public CountrySectionedAdapter(Context context) {
        this.f29186j = context;
    }

    public void setStyle(int i) {
        this.f29187k = i;
    }

    public CountrySectionedAdapter setCountrySections(List<CountrySectionModel> list) {
        this.f29185i = list;
        return this;
    }

    /* renamed from: b */
    private int m20582b(int i) {
        return this.f29185i.get(i).countryModelList.size();
    }

    /* renamed from: a */
    private View m20581a(int i, int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f29186j).inflate(R.layout.nova_assembly_item_country, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_select);
        CountrySectionModel countrySectionModel = this.f29185i.get(i);
        CountryModel countryModel = countrySectionModel.countryModelList.get(i2);
        ((TextView) view.findViewById(R.id.tv_calling_code)).setText(countryModel.callingCode);
        ((TextView) view.findViewById(R.id.tv_name)).setText(countryModel.name);
        imageView.setVisibility(4);
        if (this.f29187k <= 0) {
            this.f29187k = R.style.NovaAssemblyCountryStyleOrange;
        }
        TypedArray obtainStyledAttributes = this.f29186j.obtainStyledAttributes(this.f29187k, C10448R.styleable.CountryList);
        if (obtainStyledAttributes != null) {
            imageView.setImageResource(obtainStyledAttributes.getResourceId(0, R.drawable.nova_assembly_ic_selected_orange));
            obtainStyledAttributes.recycle();
        }
        if (countryModel.isSelected) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
        View findViewById = view.findViewById(R.id.item_divider);
        if (countrySectionModel.countryModelList.size() - 1 == i2) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo80143a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f29186j).inflate(R.layout.nova_assembly_layout_country_item_header, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.tv_name)).setText(String.valueOf(this.f29185i.get(i).sortKey).toUpperCase());
        return view;
    }

    public void notifyDataSetChanged() {
        this.f29181e.clear();
        this.f29180d.clear();
        this.f29182f.clear();
        this.f29183g = -1;
        this.f29184h = -1;
        super.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        this.f29181e.clear();
        this.f29180d.clear();
        this.f29182f.clear();
        this.f29183g = -1;
        this.f29184h = -1;
        super.notifyDataSetInvalidated();
    }

    public final int getCount() {
        int i = this.f29183g;
        if (i >= 0) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < m20580a(); i3++) {
            i2 = i2 + m20584d(i3) + 1;
        }
        this.f29183g = i2;
        return i2;
    }

    public final Object getItem(int i) {
        return this.f29185i.get(mo80142a(i)).countryModelList.get(m20583c(i));
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return isSectionHeader(i) ? mo80143a(mo80142a(i), view, viewGroup) : m20581a(mo80142a(i), m20583c(i), view, viewGroup);
    }

    public final int getItemViewType(int i) {
        return isSectionHeader(i) ? f29178b : f29179c;
    }

    public int getPositionForSection(int i) {
        List<CountrySectionModel> list = this.f29185i;
        int i2 = -1;
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            CountrySectionModel countrySectionModel = this.f29185i.get(i3);
            if (countrySectionModel.sortKey.charAt(0) == i) {
                return i2 + i3 + 1;
            }
            i2 += countrySectionModel.countryModelList.size();
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo80142a(int i) {
        Integer num = this.f29181e.get(i);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < m20580a()) {
            int d = m20584d(i2) + i3 + 1;
            if (i < i3 || i >= d) {
                i2++;
                i3 = d;
            } else {
                this.f29181e.put(i, Integer.valueOf(i2));
                return i2;
            }
        }
        return 0;
    }

    /* renamed from: c */
    private int m20583c(int i) {
        Integer num = this.f29180d.get(i);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < m20580a()) {
            int d = m20584d(i2) + i3 + 1;
            if (i < i3 || i >= d) {
                i2++;
                i3 = d;
            } else {
                int i4 = (i - i3) - 1;
                this.f29180d.put(i, Integer.valueOf(i4));
                return i4;
            }
        }
        return 0;
    }

    public final boolean isSectionHeader(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < m20580a(); i3++) {
            if (i == i2) {
                return true;
            }
            if (i < i2) {
                return false;
            }
            i2 += m20584d(i3) + 1;
        }
        return false;
    }

    /* renamed from: d */
    private int m20584d(int i) {
        Integer num = this.f29182f.get(i);
        if (num != null) {
            return num.intValue();
        }
        int b = m20582b(i);
        this.f29182f.put(i, Integer.valueOf(b));
        return b;
    }

    /* renamed from: a */
    private int m20580a() {
        int i = this.f29184h;
        if (i >= 0) {
            return i;
        }
        int size = this.f29185i.size();
        this.f29184h = size;
        return size;
    }
}
