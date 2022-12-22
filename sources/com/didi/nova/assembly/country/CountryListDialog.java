package com.didi.nova.assembly.country;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AppCompatDialog;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.nova.assembly.country.inner.CountryModel;
import com.didi.nova.assembly.country.inner.CountrySectionModel;
import com.didi.nova.assembly.country.inner.CountrySectionedAdapter;
import com.didi.nova.assembly.country.inner.PinnedHeaderListView;
import com.didi.nova.assembly.country.inner.SideBar;
import com.didi.nova.assembly.serial.Dispatcher;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.nova.assembly.serial.Task;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.taxis99.R;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CountryListDialog extends Dialog implements TextWatcher, View.OnClickListener {

    /* renamed from: a */
    private static final String f29150a = "CountryListDialogTAG";

    /* renamed from: b */
    private static final String f29151b = "nova_assembly_country_zh_CN.json";

    /* renamed from: c */
    private static final String f29152c = "nova_assembly_country_en_US.json";

    /* renamed from: d */
    private static final String f29153d = "nova_assembly_country_es_MX.json";

    /* renamed from: e */
    private static final String f29154e = "nova_assembly_country_es_419.json";

    /* renamed from: f */
    private static final String f29155f = "nova_assembly_country_pt_BR.json";

    /* renamed from: g */
    private static final String f29156g = "nova_assembly_country_ja_JP.json";

    /* renamed from: h */
    private static final String f29157h = "zh-CN";

    /* renamed from: i */
    private static final String f29158i = "en-US";

    /* renamed from: j */
    private static final String f29159j = "es-MX";

    /* renamed from: k */
    private static final String f29160k = "es-419";

    /* renamed from: l */
    private static final String f29161l = "es-CO";

    /* renamed from: m */
    private static final String f29162m = "pt-BR";

    /* renamed from: n */
    private static final String f29163n = "ja-JP";

    /* renamed from: A */
    private ITransformAnimation f29164A;

    /* renamed from: o */
    private List<CountryModel> f29165o = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public OnCountrySelectListener f29166p;

    /* renamed from: q */
    private OnCountryCloseListener f29167q;

    /* renamed from: r */
    private SerialTaskQueue f29168r = new SerialTaskQueue();

    /* renamed from: s */
    private String f29169s;

    /* renamed from: t */
    private int f29170t;

    /* renamed from: u */
    private int f29171u;

    /* renamed from: v */
    private int f29172v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public CountrySectionedAdapter f29173w;

    /* renamed from: x */
    private EditText f29174x;

    /* renamed from: y */
    private ImageView f29175y;

    /* renamed from: z */
    private View f29176z;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public static void show(ScopeContext scopeContext, OnCountrySelectListener onCountrySelectListener, int i, String str, int i2, int i3) {
        show(scopeContext, onCountrySelectListener, i, str, i2, i3, (ITransformAnimation) null);
    }

    public static void show(ScopeContext scopeContext, OnCountrySelectListener onCountrySelectListener, int i, String str, int i2, int i3, ITransformAnimation iTransformAnimation) {
        if (scopeContext != null) {
            scopeContext.getNavigator().showDialog(new CountryListDialog(onCountrySelectListener, i, str, i2, i3, iTransformAnimation), f29150a);
            return;
        }
        throw null;
    }

    public static void show(Context context, final OnCountrySelectListener onCountrySelectListener, int i, String str, int i2, int i3) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(context, R.style.CountryListDialog);
        CountryListDialog countryListDialog = new CountryListDialog(new OnCountrySelectListener() {
            public void onSelect(String str, int i) {
                OnCountrySelectListener onCountrySelectListener = onCountrySelectListener;
                if (onCountrySelectListener != null) {
                    onCountrySelectListener.onSelect(str, i);
                }
                appCompatDialog.dismiss();
            }
        }, i, str, i2, i3, (ITransformAnimation) null);
        View onCreateView = countryListDialog.onCreateView(LayoutInflater.from(context));
        countryListDialog.setCountryCloseListener(new OnCountryCloseListener() {
            public void onDismiss(CountryListDialog countryListDialog) {
                appCompatDialog.dismiss();
            }
        });
        appCompatDialog.supportRequestWindowFeature(1);
        appCompatDialog.addContentView(onCreateView, new FrameLayout.LayoutParams(-1, -1));
        Window window = appCompatDialog.getWindow();
        window.clearFlags(2);
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        SystemUtils.showDialog(appCompatDialog);
    }

    CountryListDialog(OnCountrySelectListener onCountrySelectListener, int i, String str, int i2, int i3, ITransformAnimation iTransformAnimation) {
        this.f29166p = onCountrySelectListener;
        this.f29170t = i;
        this.f29169s = str;
        this.f29171u = i2;
        this.f29172v = i3;
        this.f29164A = iTransformAnimation;
    }

    public void setCountryCloseListener(OnCountryCloseListener onCountryCloseListener) {
        this.f29167q = onCountryCloseListener;
    }

    public View onCreateView(LayoutInflater layoutInflater) {
        this.f29176z = layoutInflater.inflate(R.layout.nova_assembly_page_country_list, (ViewGroup) null);
        m20576f();
        m20578h();
        return this.f29176z;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f29176z = layoutInflater.inflate(R.layout.nova_assembly_page_country_list, viewGroup, false);
        m20576f();
        m20578h();
        return this.f29176z;
    }

    public void onDestroy() {
        EditText editText = this.f29174x;
        if (editText != null) {
            editText.removeTextChangedListener(this);
        }
    }

    public TransformAnimation getEnterAnimation() {
        ITransformAnimation iTransformAnimation = this.f29164A;
        if (iTransformAnimation != null) {
            return iTransformAnimation.getEnterAnimation();
        }
        return null;
    }

    public TransformAnimation getExitAnimation() {
        ITransformAnimation iTransformAnimation = this.f29164A;
        if (iTransformAnimation != null) {
            return iTransformAnimation.getExitAnimation();
        }
        return null;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.iv_back) {
            m20575e();
        } else if (id == R.id.iv_clear) {
            this.f29174x.setText("");
        }
    }

    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable)) {
            this.f29175y.setVisibility(8);
        } else {
            this.f29175y.setVisibility(0);
        }
        m20568a(editable.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m20575e() {
        OnCountryCloseListener onCountryCloseListener = this.f29167q;
        if (onCountryCloseListener != null) {
            onCountryCloseListener.onDismiss(this);
        } else {
            dismiss();
        }
    }

    /* renamed from: f */
    private void m20576f() {
        this.f29174x = (EditText) this.f29176z.findViewById(R.id.et_search);
        this.f29175y = (ImageView) this.f29176z.findViewById(R.id.iv_clear);
        final PinnedHeaderListView pinnedHeaderListView = (PinnedHeaderListView) this.f29176z.findViewById(R.id.lv_country);
        this.f29175y.setOnClickListener(this);
        ((ImageView) this.f29176z.findViewById(R.id.iv_back)).setOnClickListener(this);
        this.f29174x.addTextChangedListener(this);
        CountrySectionedAdapter countrySectionedAdapter = new CountrySectionedAdapter(this.f29176z.getContext());
        this.f29173w = countrySectionedAdapter;
        countrySectionedAdapter.setStyle(this.f29172v);
        this.f29176z.setOnClickListener(this);
        pinnedHeaderListView.setAdapter((ListAdapter) this.f29173w);
        pinnedHeaderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (!CountryListDialog.this.f29173w.isSectionHeader(i)) {
                    CountryModel countryModel = (CountryModel) CountryListDialog.this.f29173w.getItem(i);
                    if (CountryListDialog.this.f29166p != null) {
                        CountryListDialog.this.f29166p.onSelect(countryModel.callingCode, countryModel.countryId);
                    }
                    CountryListDialog.this.m20575e();
                }
            }
        });
        ((SideBar) this.f29176z.findViewById(R.id.sb_index)).setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            public void onTouchingLetterChanged(String str) {
                int positionForSection = CountryListDialog.this.f29173w.getPositionForSection(str.charAt(0));
                if (positionForSection >= 0) {
                    pinnedHeaderListView.setSelection(positionForSection);
                }
            }
        });
        m20577g();
    }

    /* renamed from: g */
    private void m20577g() {
        View view = this.f29176z;
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), this.f29171u, view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    /* renamed from: h */
    private void m20578h() {
        Dispatcher.async((Dispatcher.DispatchRunnable) new Dispatcher.DispatchRunnable() {
            private List<CountrySectionModel> countrySectionData;

            public void onWorkThread() {
                CountryListDialog.this.m20579i();
                this.countrySectionData = CountryListDialog.this.m20572c((String) null);
            }

            public void onMainThread() {
                CountryListDialog.this.m20569a(this.countrySectionData);
            }
        });
    }

    /* renamed from: a */
    private void m20568a(final String str) {
        this.f29168r.append(new Task() {
            private List<CountrySectionModel> countrySectionData;

            public void onCancel() {
            }

            public void onWorkThread() {
                this.countrySectionData = CountryListDialog.this.m20572c(str);
            }

            public void onMainThread() {
                CountryListDialog.this.m20569a(this.countrySectionData);
            }
        }, SerialTaskQueue.AppendMode.ReplaceStrict);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20569a(List<CountrySectionModel> list) {
        this.f29173w.setCountrySections(list);
        this.f29173w.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m20579i() {
        if (TextUtils.isEmpty(this.f29169s)) {
            this.f29169s = "en-US";
        }
        String str = this.f29169s;
        char c = 65535;
        switch (str.hashCode()) {
            case -1295825987:
                if (str.equals("es-419")) {
                    c = 2;
                    break;
                }
                break;
            case 96598594:
                if (str.equals("en-US")) {
                    c = 6;
                    break;
                }
                break;
            case 96746987:
                if (str.equals(f29161l)) {
                    c = 3;
                    break;
                }
                break;
            case 96747306:
                if (str.equals("es-MX")) {
                    c = 1;
                    break;
                }
                break;
            case 100828572:
                if (str.equals("ja-JP")) {
                    c = 0;
                    break;
                }
                break;
            case 106935481:
                if (str.equals("pt-BR")) {
                    c = 5;
                    break;
                }
                break;
            case 115813226:
                if (str.equals("zh-CN")) {
                    c = 4;
                    break;
                }
                break;
        }
        try {
            JSONArray jSONArray = new JSONArray(m20565a(this.f29176z.getContext(), c != 0 ? c != 1 ? (c == 2 || c == 3) ? f29154e : c != 4 ? c != 5 ? f29152c : f29155f : f29151b : f29153d : f29156g));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                CountryModel countryModel = new CountryModel(jSONObject.optInt("country_id"), jSONObject.optString("name"), jSONObject.optString(ParamConst.PARAM_CALLING_CODE), jSONObject.getString("sort_key"));
                countryModel.isSelected = countryModel.countryId == this.f29170t;
                this.f29165o.add(countryModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private List<CountryModel> m20571b(String str) {
        ArrayList arrayList = new ArrayList();
        for (CountryModel next : this.f29165o) {
            if (!TextUtils.isEmpty(next.name)) {
                if (TextUtils.isEmpty(str)) {
                    arrayList.add(next);
                } else if (next.name.toUpperCase().contains(str.toUpperCase().trim())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<CountrySectionModel> m20572c(String str) {
        ArrayList arrayList = new ArrayList();
        List<CountryModel> b = m20571b(str);
        if (b != null && !b.isEmpty()) {
            Collections.sort(b, new Comparator<CountryModel>() {
                public int compare(CountryModel countryModel, CountryModel countryModel2) {
                    if (TextUtils.isEmpty(countryModel.sortKey) || TextUtils.isEmpty(countryModel2.sortKey)) {
                        return 0;
                    }
                    return countryModel.sortKey.compareTo(countryModel2.sortKey);
                }
            });
            CountrySectionModel countrySectionModel = new CountrySectionModel();
            for (CountryModel next : b) {
                if (!TextUtils.isEmpty(next.sortKey)) {
                    if (!next.sortKey.equalsIgnoreCase(countrySectionModel.sortKey)) {
                        countrySectionModel = new CountrySectionModel();
                        countrySectionModel.sortKey = next.sortKey;
                        arrayList.add(countrySectionModel);
                    }
                    countrySectionModel.countryModelList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private String m20565a(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            String str2 = new String(bArr, Charset.forName("UTF-8"));
            if (inputStream == null) {
                return str2;
            }
            try {
                inputStream.close();
                return str2;
            } catch (IOException e) {
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return "";
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
