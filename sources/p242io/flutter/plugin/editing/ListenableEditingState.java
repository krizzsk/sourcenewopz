package p242io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import java.util.Iterator;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.systemchannels.TextInputChannel;

/* renamed from: io.flutter.plugin.editing.ListenableEditingState */
class ListenableEditingState extends SpannableStringBuilder {

    /* renamed from: a */
    private static final String f57781a = "ListenableEditingState";

    /* renamed from: b */
    private int f57782b = 0;

    /* renamed from: c */
    private int f57783c = 0;

    /* renamed from: d */
    private ArrayList<EditingStateWatcher> f57784d = new ArrayList<>();

    /* renamed from: e */
    private ArrayList<EditingStateWatcher> f57785e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<TextEditingDelta> f57786f = new ArrayList<>();

    /* renamed from: g */
    private String f57787g;

    /* renamed from: h */
    private String f57788h;

    /* renamed from: i */
    private int f57789i;

    /* renamed from: j */
    private int f57790j;

    /* renamed from: k */
    private int f57791k;

    /* renamed from: l */
    private int f57792l;

    /* renamed from: m */
    private BaseInputConnection f57793m;

    /* renamed from: io.flutter.plugin.editing.ListenableEditingState$EditingStateWatcher */
    interface EditingStateWatcher {
        void didChangeEditingState(boolean z, boolean z2, boolean z3);
    }

    public ListenableEditingState(TextInputChannel.TextEditState textEditState, View view) {
        if (textEditState != null) {
            mo172751a(textEditState);
        }
        this.f57793m = new BaseInputConnection(view, true) {
            public Editable getEditable() {
                return this;
            }
        };
    }

    /* renamed from: a */
    public ArrayList<TextEditingDelta> mo172749a() {
        ArrayList<TextEditingDelta> arrayList = new ArrayList<>(this.f57786f);
        this.f57786f.clear();
        return arrayList;
    }

    /* renamed from: b */
    public void mo172753b() {
        this.f57786f.clear();
    }

    /* renamed from: c */
    public void mo172755c() {
        this.f57782b++;
        if (this.f57783c > 0) {
            Log.m41136e(f57781a, "editing state should not be changed in a listener callback");
        }
        if (this.f57782b == 1 && !this.f57784d.isEmpty()) {
            this.f57788h = toString();
            this.f57789i = mo172757e();
            this.f57790j = mo172758f();
            this.f57791k = mo172759g();
            this.f57792l = mo172760h();
        }
    }

    /* renamed from: d */
    public void mo172756d() {
        int i = this.f57782b;
        if (i == 0) {
            Log.m41136e(f57781a, "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i == 1) {
            Iterator<EditingStateWatcher> it = this.f57785e.iterator();
            while (it.hasNext()) {
                m41526a(it.next(), true, true, true);
            }
            if (!this.f57784d.isEmpty()) {
                Log.m41140v(f57781a, "didFinishBatchEdit with " + String.valueOf(this.f57784d.size()) + " listener(s)");
                boolean equals = toString().equals(this.f57788h) ^ true;
                boolean z = false;
                boolean z2 = (this.f57789i == mo172757e() && this.f57790j == mo172758f()) ? false : true;
                if (!(this.f57791k == mo172759g() && this.f57792l == mo172760h())) {
                    z = true;
                }
                m41527a(equals, z2, z);
            }
        }
        this.f57784d.addAll(this.f57785e);
        this.f57785e.clear();
        this.f57782b--;
    }

    /* renamed from: a */
    public void mo172750a(int i, int i2) {
        if (i < 0 || i >= i2) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f57793m.setComposingRegion(i, i2);
        }
    }

    /* renamed from: a */
    public void mo172751a(TextInputChannel.TextEditState textEditState) {
        mo172755c();
        replace(0, length(), textEditState.text);
        if (textEditState.hasSelection()) {
            Selection.setSelection(this, textEditState.selectionStart, textEditState.selectionEnd);
        } else {
            Selection.removeSelection(this);
        }
        mo172750a(textEditState.composingStart, textEditState.composingEnd);
        mo172753b();
        mo172756d();
    }

    /* renamed from: a */
    public void mo172752a(EditingStateWatcher editingStateWatcher) {
        if (this.f57783c > 0) {
            Log.m41136e(f57781a, "adding a listener " + editingStateWatcher.toString() + " in a listener callback");
        }
        if (this.f57782b > 0) {
            Log.m41142w(f57781a, "a listener was added to EditingState while a batch edit was in progress");
            this.f57785e.add(editingStateWatcher);
            return;
        }
        this.f57784d.add(editingStateWatcher);
    }

    /* renamed from: b */
    public void mo172754b(EditingStateWatcher editingStateWatcher) {
        if (this.f57783c > 0) {
            Log.m41136e(f57781a, "removing a listener " + editingStateWatcher.toString() + " in a listener callback");
        }
        this.f57784d.remove(editingStateWatcher);
        if (this.f57782b > 0) {
            this.f57785e.remove(editingStateWatcher);
        }
    }

    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        boolean z;
        boolean z2;
        if (this.f57783c > 0) {
            Log.m41136e(f57781a, "editing state should not be changed in a listener callback");
        }
        String listenableEditingState = toString();
        int i5 = i2 - i;
        boolean z3 = i5 != i4 - i3;
        for (int i6 = 0; i6 < i5 && !z3; i6++) {
            z3 |= charAt(i + i6) != charSequence.charAt(i3 + i6);
        }
        CharSequence charSequence2 = charSequence;
        if (z3) {
            this.f57787g = null;
        }
        int e = mo172757e();
        int f = mo172758f();
        int g = mo172759g();
        int h = mo172760h();
        SpannableStringBuilder replace = super.replace(i, i2, charSequence, i3, i4);
        TextEditingDelta textEditingDelta = r1;
        boolean z4 = z3;
        int i7 = h;
        TextEditingDelta textEditingDelta2 = new TextEditingDelta(listenableEditingState, i, i2, charSequence, mo172757e(), mo172758f(), mo172759g(), mo172760h());
        this.f57786f.add(textEditingDelta);
        if (this.f57782b > 0) {
            return replace;
        }
        boolean z5 = (mo172757e() == e && mo172758f() == f) ? false : true;
        if (mo172759g() == g && mo172760h() == i7) {
            z = z4;
            z2 = false;
        } else {
            z = z4;
            z2 = true;
        }
        m41527a(z, z5, z2);
        return replace;
    }

    /* renamed from: a */
    private void m41526a(EditingStateWatcher editingStateWatcher, boolean z, boolean z2, boolean z3) {
        this.f57783c++;
        editingStateWatcher.didChangeEditingState(z, z2, z3);
        this.f57783c--;
    }

    /* renamed from: a */
    private void m41527a(boolean z, boolean z2, boolean z3) {
        if (z || z2 || z3) {
            Iterator<EditingStateWatcher> it = this.f57784d.iterator();
            while (it.hasNext()) {
                m41526a(it.next(), z, z2, z3);
            }
        }
    }

    /* renamed from: e */
    public final int mo172757e() {
        return Selection.getSelectionStart(this);
    }

    /* renamed from: f */
    public final int mo172758f() {
        return Selection.getSelectionEnd(this);
    }

    /* renamed from: g */
    public final int mo172759g() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    /* renamed from: h */
    public final int mo172760h() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        super.setSpan(obj, i, i2, i3);
        this.f57786f.add(new TextEditingDelta(toString(), mo172757e(), mo172758f(), mo172759g(), mo172760h()));
    }

    public String toString() {
        String str = this.f57787g;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.f57787g = spannableStringBuilder;
        return spannableStringBuilder;
    }
}
