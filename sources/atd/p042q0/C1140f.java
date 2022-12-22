package atd.p042q0;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import atd.p015d.C0998o;
import atd.p015d.C1000p;
import atd.p040p0.C1130d;
import atd.p046s0.C1172a;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: atd.q0.f */
public final class C1140f extends C1138d<C0998o, C1130d> implements View.OnClickListener {

    /* renamed from: m */
    private final Set<C1000p> f357m;

    /* renamed from: n */
    private final ListView f358n;

    /* renamed from: o */
    private final Button f359o;

    /* renamed from: atd.q0.f$a */
    class C1141a extends C1145e {
        C1141a(List list) {
            super(C1140f.this, list);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1149h mo13899a(ViewGroup viewGroup) {
            return new C1148g(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a3ds2_view_single_select_item, viewGroup, false));
        }
    }

    /* renamed from: atd.q0.f$b */
    class C1142b extends C1145e {
        C1142b(List list) {
            super(C1140f.this, list);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1149h mo13899a(ViewGroup viewGroup) {
            return new C1144d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a3ds2_view_multi_select_item, viewGroup, false));
        }
    }

    /* renamed from: atd.q0.f$c */
    static /* synthetic */ class C1143c {

        /* renamed from: a */
        static final /* synthetic */ int[] f362a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                atd.e.b[] r0 = atd.p017e.C1013b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f362a = r0
                atd.e.b r1 = atd.p017e.C1013b.SINGLE_SELECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f362a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.e.b r1 = atd.p017e.C1013b.MULTI_SELECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.p042q0.C1140f.C1143c.<clinit>():void");
        }
    }

    /* renamed from: atd.q0.f$d */
    final class C1144d extends C1149h {
        C1144d(View view) {
            super(view);
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AutoTrackHelper.trackViewOnClick(compoundButton, z);
            C1000p pVar = (C1000p) compoundButton.getTag();
            if (z) {
                C1140f.this.mo13891a(pVar);
            } else {
                C1140f.this.mo13896d(pVar);
            }
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CompoundButton compoundButton = this.f369c;
            compoundButton.setChecked(!compoundButton.isChecked());
        }
    }

    /* renamed from: atd.q0.f$e */
    private abstract class C1145e extends BaseAdapter {

        /* renamed from: a */
        private final List<C1000p> f364a;

        C1145e(C1140f fVar, List<C1000p> list) {
            this.f364a = list;
        }

        /* renamed from: a */
        public C1000p getItem(int i) {
            return this.f364a.get(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C1149h mo13899a(ViewGroup viewGroup);

        public int getCount() {
            return this.f364a.size();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1149h a = mo13899a(viewGroup);
            a.mo13915a(getItem(i));
            return a.f367a;
        }
    }

    /* renamed from: atd.q0.f$f */
    private static final class C1146f extends View.BaseSavedState {
        public static final Parcelable.Creator<C1146f> CREATOR = new C1147a();

        /* renamed from: a */
        private Set<C1000p> f365a = new LinkedHashSet();

        /* renamed from: atd.q0.f$f$a */
        static class C1147a implements Parcelable.Creator<C1146f> {
            C1147a() {
            }

            /* renamed from: a */
            public C1146f createFromParcel(Parcel parcel) {
                return new C1146f(parcel);
            }

            /* renamed from: a */
            public C1146f[] newArray(int i) {
                return new C1146f[i];
            }
        }

        C1146f(Parcelable parcelable) {
            super(parcelable);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Set<C1000p> mo13906a() {
            return this.f365a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelableArray((C1000p[]) this.f365a.toArray(new C1000p[0]), i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo13907a(Set<C1000p> set) {
            this.f365a = set;
        }

        C1146f(Parcel parcel) {
            super(parcel);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(C1000p.class.getClassLoader());
            if (readParcelableArray != null) {
                for (Parcelable parcelable : readParcelableArray) {
                    this.f365a.add((C1000p) parcelable);
                }
            }
        }
    }

    /* renamed from: atd.q0.f$g */
    final class C1148g extends C1149h {
        C1148g(View view) {
            super(view);
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AutoTrackHelper.trackViewOnClick(compoundButton, z);
            if (z) {
                C1000p pVar = (C1000p) compoundButton.getTag();
                C1140f.this.mo13892b();
                C1140f.this.mo13891a(pVar);
                C1140f.this.mo13894c();
                C1140f.this.mo13893b(pVar);
            }
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (!this.f369c.isChecked()) {
                this.f369c.setChecked(true);
            }
        }
    }

    /* renamed from: atd.q0.f$h */
    private abstract class C1149h implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        final View f367a;

        /* renamed from: b */
        final TextView f368b;

        /* renamed from: c */
        final CompoundButton f369c;

        C1149h(View view) {
            this.f367a = view;
            view.setOnClickListener(this);
            this.f368b = (TextView) view.findViewById(R.id.textView_value);
            CompoundButton compoundButton = (CompoundButton) view.findViewById(R.id.checkBox_selected);
            this.f369c = compoundButton;
            compoundButton.setOnCheckedChangeListener(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo13915a(C1000p pVar) {
            this.f368b.setText(pVar.mo13716b());
            this.f369c.setTag(pVar);
            this.f369c.setChecked(C1140f.this.mo13895c(pVar));
        }
    }

    public C1140f(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setState(C1146f fVar) {
        mo13892b();
        for (C1000p a : fVar.mo13906a()) {
            mo13891a(a);
        }
        mo13894c();
        for (C1000p b : this.f357m) {
            mo13893b(b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13882b(C0998o oVar) {
        int i = C1143c.f362a[oVar.mo13625a().ordinal()];
        if (i == 1) {
            m685c(oVar);
        } else if (i == 2) {
            m684b(oVar);
        } else {
            throw new RuntimeException(C1172a.m764a(-727473423993518L) + oVar.mo13625a());
        }
        this.f359o.setText(oVar.mo13697n());
        this.f359o.setOnClickListener(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo13895c(C1000p pVar) {
        return this.f357m.contains(pVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo13896d(C1000p pVar) {
        this.f357m.remove(pVar);
    }

    /* access modifiers changed from: protected */
    public int getChallengeLayoutId() {
        return R.layout.a3ds2_view_challenge_select;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        super.onClick(view);
        if (getChallengeListener() != null && view.equals(this.f359o)) {
            this.f359o.setEnabled(false);
            List<String> a = m683a(this.f357m);
            if (a.isEmpty()) {
                ((C1130d) getChallengeListener()).mo13859b();
            } else {
                ((C1130d) getChallengeListener()).mo13865a(a, getWhitelistStatus());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        setState((C1146f) parcelable);
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C1146f fVar = new C1146f(super.onSaveInstanceState());
        fVar.mo13907a(this.f357m);
        return fVar;
    }

    public C1140f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo13892b() {
        this.f357m.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo13894c() {
        for (int i = 0; i < this.f358n.getChildCount(); i++) {
            CompoundButton compoundButton = (CompoundButton) ((ViewGroup) this.f358n.getChildAt(i)).findViewById(R.id.checkBox_selected);
            if (compoundButton.isChecked()) {
                compoundButton.setChecked(false);
            }
        }
    }

    public C1140f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f357m = new LinkedHashSet();
        setId(R.id.selectChallengeView);
        this.f358n = (ListView) findViewById(R.id.listView_selectInfoItems);
        this.f359o = (Button) findViewById(R.id.button_next);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo13893b(C1000p pVar) {
        for (int i = 0; i < this.f358n.getChildCount(); i++) {
            CompoundButton compoundButton = (CompoundButton) ((ViewGroup) this.f358n.getChildAt(i)).findViewById(R.id.checkBox_selected);
            if (compoundButton.getTag().equals(pVar)) {
                compoundButton.setChecked(true);
            }
        }
    }

    /* renamed from: c */
    private void m685c(C0998o oVar) {
        List<C1000p> o = oVar.mo13710o();
        mo13892b();
        mo13891a(o.get(0));
        this.f358n.setAdapter(new C1141a(o));
    }

    /* renamed from: b */
    private void m684b(C0998o oVar) {
        List<C1000p> o = oVar.mo13710o();
        mo13892b();
        this.f358n.setAdapter(new C1142b(o));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo13891a(C1000p pVar) {
        this.f357m.add(pVar);
    }

    /* renamed from: a */
    private List<String> m683a(Set<C1000p> set) {
        ArrayList arrayList = new ArrayList();
        for (C1000p a : set) {
            arrayList.add(a.mo13715a());
        }
        return arrayList;
    }
}
