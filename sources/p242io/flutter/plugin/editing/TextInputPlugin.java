package p242io.flutter.plugin.editing;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;
import java.util.HashMap;
import p242io.flutter.Log;
import p242io.flutter.embedding.android.KeyboardManager;
import p242io.flutter.embedding.engine.systemchannels.TextInputChannel;
import p242io.flutter.plugin.editing.ListenableEditingState;
import p242io.flutter.plugin.platform.PlatformViewsController;

/* renamed from: io.flutter.plugin.editing.TextInputPlugin */
public class TextInputPlugin implements ListenableEditingState.EditingStateWatcher {

    /* renamed from: a */
    private static final String f57803a = "TextInputPlugin";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final View f57804b;

    /* renamed from: c */
    private final InputMethodManager f57805c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AutofillManager f57806d;

    /* renamed from: e */
    private final TextInputChannel f57807e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public InputTarget f57808f = new InputTarget(InputTarget.Type.NO_TARGET, 0);

    /* renamed from: g */
    private TextInputChannel.Configuration f57809g;

    /* renamed from: h */
    private SparseArray<TextInputChannel.Configuration> f57810h;

    /* renamed from: i */
    private ListenableEditingState f57811i;

    /* renamed from: j */
    private boolean f57812j;

    /* renamed from: k */
    private InputConnection f57813k;

    /* renamed from: l */
    private PlatformViewsController f57814l;

    /* renamed from: m */
    private Rect f57815m;

    /* renamed from: n */
    private ImeSyncDeferringInsetsCallback f57816n;

    /* renamed from: o */
    private TextInputChannel.TextEditState f57817o;

    /* renamed from: p */
    private boolean f57818p;

    /* renamed from: io.flutter.plugin.editing.TextInputPlugin$MinMax */
    private interface MinMax {
        void inspect(double d, double d2);
    }

    public TextInputPlugin(View view, TextInputChannel textInputChannel, PlatformViewsController platformViewsController) {
        int i = 0;
        this.f57804b = view;
        this.f57811i = new ListenableEditingState((TextInputChannel.TextEditState) null, this.f57804b);
        this.f57805c = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f57806d = (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
        } else {
            this.f57806d = null;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            i = (this.f57804b.getWindowSystemUiVisibility() & 2) == 0 ? 0 | WindowInsets.Type.navigationBars() : i;
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, (this.f57804b.getWindowSystemUiVisibility() & 4) == 0 ? i | WindowInsets.Type.statusBars() : i, WindowInsets.Type.ime());
            this.f57816n = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.f57807e = textInputChannel;
        textInputChannel.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() {
            public void show() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.mo172777a(textInputPlugin.f57804b);
            }

            public void hide() {
                if (TextInputPlugin.this.f57808f.type == InputTarget.Type.HC_PLATFORM_VIEW) {
                    TextInputPlugin.this.m41559g();
                    return;
                }
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.m41552b(textInputPlugin.f57804b);
            }

            public void requestAutofill() {
                TextInputPlugin.this.m41558f();
            }

            public void finishAutofillContext(boolean z) {
                if (Build.VERSION.SDK_INT >= 26 && TextInputPlugin.this.f57806d != null) {
                    if (z) {
                        TextInputPlugin.this.f57806d.commit();
                    } else {
                        TextInputPlugin.this.f57806d.cancel();
                    }
                }
            }

            public void setClient(int i, TextInputChannel.Configuration configuration) {
                TextInputPlugin.this.mo172776a(i, configuration);
            }

            public void setPlatformViewClient(int i, boolean z) {
                TextInputPlugin.this.m41544a(i, z);
            }

            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.mo172778a(textInputPlugin.f57804b, textEditState);
            }

            public void setEditableSizeAndTransform(double d, double d2, double[] dArr) {
                TextInputPlugin.this.m41543a(d, d2, dArr);
            }

            public void clearClient() {
                TextInputPlugin.this.mo172781c();
            }

            public void sendAppPrivateCommand(String str, Bundle bundle) {
                TextInputPlugin.this.sendTextInputAppPrivateCommand(str, bundle);
            }
        });
        textInputChannel.requestExistingInputState();
        this.f57814l = platformViewsController;
        platformViewsController.attachTextInputPlugin(this);
    }

    public InputMethodManager getInputMethodManager() {
        return this.f57805c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Editable mo172775a() {
        return this.f57811i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ImeSyncDeferringInsetsCallback mo172780b() {
        return this.f57816n;
    }

    public void lockPlatformViewInputConnection() {
        if (this.f57808f.type == InputTarget.Type.VD_PLATFORM_VIEW) {
            this.f57818p = true;
        }
    }

    public void unlockPlatformViewInputConnection() {
        this.f57818p = false;
    }

    public void destroy() {
        this.f57814l.detachTextInputPlugin();
        this.f57807e.setTextInputMethodHandler((TextInputChannel.TextInputMethodHandler) null);
        m41559g();
        this.f57811i.mo172754b(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.f57816n;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    /* renamed from: a */
    private static int m41541a(TextInputChannel.InputType inputType, boolean z, boolean z2, boolean z3, boolean z4, TextInputChannel.TextCapitalization textCapitalization) {
        int i;
        if (inputType.type == TextInputChannel.TextInputType.DATETIME) {
            return 4;
        }
        if (inputType.type == TextInputChannel.TextInputType.NUMBER) {
            int i2 = 2;
            if (inputType.isSigned) {
                i2 = 4098;
            }
            return inputType.isDecimal ? i2 | 8192 : i2;
        } else if (inputType.type == TextInputChannel.TextInputType.PHONE) {
            return 3;
        } else {
            if (inputType.type == TextInputChannel.TextInputType.NONE) {
                return 0;
            }
            int i3 = 1;
            if (inputType.type == TextInputChannel.TextInputType.MULTILINE) {
                i3 = 131073;
            } else if (inputType.type == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
                i3 = 33;
            } else if (inputType.type == TextInputChannel.TextInputType.URL) {
                i3 = 17;
            } else if (inputType.type == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
                i3 = 145;
            } else if (inputType.type == TextInputChannel.TextInputType.NAME) {
                i3 = 97;
            } else if (inputType.type == TextInputChannel.TextInputType.POSTAL_ADDRESS) {
                i3 = 113;
            }
            if (z) {
                i = 524288 | i3 | 128;
            } else {
                if (z2) {
                    i3 |= 32768;
                }
                i = !z3 ? 524288 | i3 : i3;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.CHARACTERS) {
                return i | 4096;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.WORDS) {
                return i | 8192;
            }
            return textCapitalization == TextInputChannel.TextCapitalization.SENTENCES ? i | 16384 : i;
        }
    }

    public InputConnection createInputConnection(View view, KeyboardManager keyboardManager, EditorInfo editorInfo) {
        int i;
        if (this.f57808f.type == InputTarget.Type.NO_TARGET) {
            this.f57813k = null;
            return null;
        } else if (this.f57808f.type == InputTarget.Type.HC_PLATFORM_VIEW) {
            return null;
        } else {
            if (this.f57808f.type != InputTarget.Type.VD_PLATFORM_VIEW) {
                editorInfo.inputType = m41541a(this.f57809g.inputType, this.f57809g.obscureText, this.f57809g.autocorrect, this.f57809g.enableSuggestions, this.f57809g.enableIMEPersonalizedLearning, this.f57809g.textCapitalization);
                editorInfo.imeOptions = 33554432;
                if (Build.VERSION.SDK_INT >= 26 && !this.f57809g.enableIMEPersonalizedLearning) {
                    editorInfo.imeOptions |= 16777216;
                }
                if (this.f57809g.inputAction == null) {
                    i = (131072 & editorInfo.inputType) != 0 ? 1 : 6;
                } else {
                    i = this.f57809g.inputAction.intValue();
                }
                if (this.f57809g.actionLabel != null) {
                    editorInfo.actionLabel = this.f57809g.actionLabel;
                    editorInfo.actionId = i;
                }
                editorInfo.imeOptions = i | editorInfo.imeOptions;
                C21107b bVar = new C21107b(view, this.f57808f.f57819id, this.f57807e, keyboardManager, this.f57811i, editorInfo);
                editorInfo.initialSelStart = this.f57811i.mo172757e();
                editorInfo.initialSelEnd = this.f57811i.mo172758f();
                this.f57813k = bVar;
                return bVar;
            } else if (this.f57818p) {
                return this.f57813k;
            } else {
                InputConnection onCreateInputConnection = this.f57814l.getPlatformViewById(Integer.valueOf(this.f57808f.f57819id)).onCreateInputConnection(editorInfo);
                this.f57813k = onCreateInputConnection;
                return onCreateInputConnection;
            }
        }
    }

    public InputConnection getLastInputConnection() {
        return this.f57813k;
    }

    public void clearPlatformViewClient(int i) {
        if ((this.f57808f.type == InputTarget.Type.VD_PLATFORM_VIEW || this.f57808f.type == InputTarget.Type.HC_PLATFORM_VIEW) && this.f57808f.f57819id == i) {
            this.f57808f = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            m41559g();
            this.f57805c.hideSoftInputFromWindow(this.f57804b.getApplicationWindowToken(), 0);
            this.f57805c.restartInput(this.f57804b);
            this.f57812j = false;
        }
    }

    public void sendTextInputAppPrivateCommand(String str, Bundle bundle) {
        this.f57805c.sendAppPrivateCommand(this.f57804b, str, bundle);
    }

    /* renamed from: d */
    private boolean m41555d() {
        TextInputChannel.Configuration configuration = this.f57809g;
        if (configuration == null || configuration.inputType == null || this.f57809g.inputType.type != TextInputChannel.TextInputType.NONE) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172777a(View view) {
        if (m41555d()) {
            view.requestFocus();
            this.f57805c.showSoftInput(view, 0);
            return;
        }
        m41552b(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41552b(View view) {
        m41559g();
        this.f57805c.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172776a(int i, TextInputChannel.Configuration configuration) {
        m41559g();
        this.f57809g = configuration;
        if (m41555d()) {
            this.f57808f = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i);
        } else {
            this.f57808f = new InputTarget(InputTarget.Type.NO_TARGET, i);
        }
        this.f57811i.mo172754b(this);
        this.f57811i = new ListenableEditingState(configuration.autofill != null ? configuration.autofill.editState : null, this.f57804b);
        m41545a(configuration);
        this.f57812j = true;
        unlockPlatformViewInputConnection();
        this.f57815m = null;
        this.f57811i.mo172752a((ListenableEditingState.EditingStateWatcher) this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41544a(int i, boolean z) {
        if (z) {
            this.f57804b.requestFocus();
            this.f57808f = new InputTarget(InputTarget.Type.VD_PLATFORM_VIEW, i);
            this.f57805c.restartInput(this.f57804b);
            this.f57812j = false;
            return;
        }
        this.f57808f = new InputTarget(InputTarget.Type.HC_PLATFORM_VIEW, i);
        this.f57813k = null;
    }

    /* renamed from: a */
    private static boolean m41550a(TextInputChannel.TextEditState textEditState, TextInputChannel.TextEditState textEditState2) {
        int i = textEditState.composingEnd - textEditState.composingStart;
        if (i != textEditState2.composingEnd - textEditState2.composingStart) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (textEditState.text.charAt(textEditState.composingStart + i2) != textEditState2.text.charAt(textEditState2.composingStart + i2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172778a(View view, TextInputChannel.TextEditState textEditState) {
        TextInputChannel.TextEditState textEditState2;
        if (!this.f57812j && (textEditState2 = this.f57817o) != null && textEditState2.hasComposing()) {
            boolean a = m41550a(this.f57817o, textEditState);
            this.f57812j = a;
            if (a) {
                Log.m41138i(f57803a, "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.f57817o = textEditState;
        this.f57811i.mo172751a(textEditState);
        if (this.f57812j) {
            this.f57805c.restartInput(view);
            this.f57812j = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41543a(double d, double d2, double[] dArr) {
        double d3 = d;
        double d4 = d2;
        final double[] dArr2 = dArr;
        final double[] dArr3 = new double[4];
        final boolean z = dArr2[3] == 0.0d && dArr2[7] == 0.0d && dArr2[15] == 1.0d;
        double d5 = dArr2[12] / dArr2[15];
        dArr3[1] = d5;
        dArr3[0] = d5;
        double d6 = dArr2[13] / dArr2[15];
        dArr3[3] = d6;
        dArr3[2] = d6;
        C211052 r10 = new MinMax() {
            public void inspect(double d, double d2) {
                double d3 = 1.0d;
                if (!z) {
                    double[] dArr = dArr2;
                    d3 = 1.0d / (((dArr[3] * d) + (dArr[7] * d2)) + dArr[15]);
                }
                double[] dArr2 = dArr2;
                double d4 = ((dArr2[0] * d) + (dArr2[4] * d2) + dArr2[12]) * d3;
                double d5 = ((dArr2[1] * d) + (dArr2[5] * d2) + dArr2[13]) * d3;
                double[] dArr3 = dArr3;
                if (d4 < dArr3[0]) {
                    dArr3[0] = d4;
                } else if (d4 > dArr3[1]) {
                    dArr3[1] = d4;
                }
                double[] dArr4 = dArr3;
                if (d5 < dArr4[2]) {
                    dArr4[2] = d5;
                } else if (d5 > dArr4[3]) {
                    dArr4[3] = d5;
                }
            }
        };
        r10.inspect(d3, 0.0d);
        r10.inspect(d3, d4);
        r10.inspect(0.0d, d4);
        Float valueOf = Float.valueOf(this.f57804b.getContext().getResources().getDisplayMetrics().density);
        this.f57815m = new Rect((int) (dArr3[0] * ((double) valueOf.floatValue())), (int) (dArr3[2] * ((double) valueOf.floatValue())), (int) Math.ceil(dArr3[1] * ((double) valueOf.floatValue())), (int) Math.ceil(dArr3[3] * ((double) valueOf.floatValue())));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo172781c() {
        if (this.f57808f.type != InputTarget.Type.VD_PLATFORM_VIEW) {
            this.f57811i.mo172754b(this);
            m41559g();
            m41545a((TextInputChannel.Configuration) null);
            this.f57808f = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            unlockPlatformViewInputConnection();
            this.f57815m = null;
        }
    }

    /* renamed from: io.flutter.plugin.editing.TextInputPlugin$InputTarget */
    private static class InputTarget {

        /* renamed from: id */
        int f57819id;
        Type type;

        /* renamed from: io.flutter.plugin.editing.TextInputPlugin$InputTarget$Type */
        enum Type {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VD_PLATFORM_VIEW,
            HC_PLATFORM_VIEW
        }

        public InputTarget(Type type2, int i) {
            this.type = type2;
            this.f57819id = i;
        }
    }

    public boolean handleKeyEvent(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!getInputMethodManager().isAcceptingText() || (inputConnection = this.f57813k) == null) {
            return false;
        }
        if (inputConnection instanceof C21107b) {
            return ((C21107b) inputConnection).mo172802a(keyEvent);
        }
        return inputConnection.sendKeyEvent(keyEvent);
    }

    public void didChangeEditingState(boolean z, boolean z2, boolean z3) {
        if (z) {
            m41549a(this.f57811i.toString());
        }
        int e = this.f57811i.mo172757e();
        int f = this.f57811i.mo172758f();
        int g = this.f57811i.mo172759g();
        int h = this.f57811i.mo172760h();
        ArrayList<TextEditingDelta> a = this.f57811i.mo172749a();
        if (!(this.f57817o == null || (this.f57811i.toString().equals(this.f57817o.text) && e == this.f57817o.selectionStart && f == this.f57817o.selectionEnd && g == this.f57817o.composingStart && h == this.f57817o.composingEnd))) {
            Log.m41140v(f57803a, "send EditingState to flutter: " + this.f57811i.toString());
            if (this.f57809g.enableDeltaModel) {
                this.f57807e.updateEditingStateWithDeltas(this.f57808f.f57819id, a);
                this.f57811i.mo172753b();
            } else {
                this.f57807e.updateEditingState(this.f57808f.f57819id, this.f57811i.toString(), e, f, g, h);
            }
            this.f57817o = new TextInputChannel.TextEditState(this.f57811i.toString(), e, f, g, h);
            return;
        }
        this.f57811i.mo172753b();
    }

    /* renamed from: e */
    private boolean m41557e() {
        return this.f57810h != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m41558f() {
        if (Build.VERSION.SDK_INT >= 26 && this.f57806d != null && m41557e()) {
            String str = this.f57809g.autofill.uniqueIdentifier;
            int[] iArr = new int[2];
            this.f57804b.getLocationOnScreen(iArr);
            Rect rect = new Rect(this.f57815m);
            rect.offset(iArr[0], iArr[1]);
            this.f57806d.notifyViewEntered(this.f57804b, str.hashCode(), rect);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m41559g() {
        TextInputChannel.Configuration configuration;
        if (Build.VERSION.SDK_INT >= 26 && this.f57806d != null && (configuration = this.f57809g) != null && configuration.autofill != null && m41557e()) {
            this.f57806d.notifyViewExited(this.f57804b, this.f57809g.autofill.uniqueIdentifier.hashCode());
        }
    }

    /* renamed from: a */
    private void m41549a(String str) {
        if (Build.VERSION.SDK_INT >= 26 && this.f57806d != null && m41557e()) {
            this.f57806d.notifyValueChanged(this.f57804b, this.f57809g.autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(str));
        }
    }

    /* renamed from: a */
    private void m41545a(TextInputChannel.Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (configuration == null || configuration.autofill == null) {
                this.f57810h = null;
                return;
            }
            TextInputChannel.Configuration[] configurationArr = configuration.fields;
            SparseArray<TextInputChannel.Configuration> sparseArray = new SparseArray<>();
            this.f57810h = sparseArray;
            if (configurationArr == null) {
                sparseArray.put(configuration.autofill.uniqueIdentifier.hashCode(), configuration);
                return;
            }
            for (TextInputChannel.Configuration configuration2 : configurationArr) {
                TextInputChannel.Configuration.Autofill autofill = configuration2.autofill;
                if (autofill != null) {
                    this.f57810h.put(autofill.uniqueIdentifier.hashCode(), configuration2);
                    this.f57806d.notifyValueChanged(this.f57804b, autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(autofill.editState.text));
                }
            }
        }
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        Rect rect;
        ViewStructure viewStructure2 = viewStructure;
        if (Build.VERSION.SDK_INT >= 26 && m41557e()) {
            String str = this.f57809g.autofill.uniqueIdentifier;
            AutofillId autofillId = viewStructure.getAutofillId();
            for (int i2 = 0; i2 < this.f57810h.size(); i2++) {
                int keyAt = this.f57810h.keyAt(i2);
                TextInputChannel.Configuration.Autofill autofill = this.f57810h.valueAt(i2).autofill;
                if (autofill != null) {
                    viewStructure2.addChildCount(1);
                    ViewStructure newChild = viewStructure2.newChild(i2);
                    newChild.setAutofillId(autofillId, keyAt);
                    newChild.setAutofillHints(autofill.hints);
                    newChild.setAutofillType(1);
                    newChild.setVisibility(0);
                    if (autofill.hintText != null) {
                        newChild.setHint(autofill.hintText);
                    }
                    if (str.hashCode() != keyAt || (rect = this.f57815m) == null) {
                        ViewStructure viewStructure3 = newChild;
                        viewStructure3.setDimens(0, 0, 0, 0, 1, 1);
                        viewStructure3.setAutofillValue(AutofillValue.forText(autofill.editState.text));
                    } else {
                        newChild.setDimens(rect.left, this.f57815m.top, 0, 0, this.f57815m.width(), this.f57815m.height());
                        newChild.setAutofillValue(AutofillValue.forText(this.f57811i));
                    }
                }
            }
        }
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        TextInputChannel.Configuration.Autofill autofill;
        if (Build.VERSION.SDK_INT >= 26 && (autofill = this.f57809g.autofill) != null) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                TextInputChannel.Configuration configuration = this.f57810h.get(sparseArray.keyAt(i));
                if (!(configuration == null || configuration.autofill == null)) {
                    TextInputChannel.Configuration.Autofill autofill2 = configuration.autofill;
                    String charSequence = sparseArray.valueAt(i).getTextValue().toString();
                    TextInputChannel.TextEditState textEditState = new TextInputChannel.TextEditState(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                    if (autofill2.uniqueIdentifier.equals(autofill.uniqueIdentifier)) {
                        this.f57811i.mo172751a(textEditState);
                    } else {
                        hashMap.put(autofill2.uniqueIdentifier, textEditState);
                    }
                }
            }
            this.f57807e.updateEditingStateWithTag(this.f57808f.f57819id, hashMap);
        }
    }
}
