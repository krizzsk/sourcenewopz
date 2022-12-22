package p242io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import kotlinx.coroutines.DebugKt;
import p242io.flutter.Log;
import p242io.flutter.embedding.android.KeyboardManager;
import p242io.flutter.embedding.engine.FlutterJNI;
import p242io.flutter.embedding.engine.systemchannels.TextInputChannel;
import p242io.flutter.plugin.editing.ListenableEditingState;

/* renamed from: io.flutter.plugin.editing.b */
/* compiled from: InputConnectionAdaptor */
class C21107b extends BaseInputConnection implements ListenableEditingState.EditingStateWatcher {

    /* renamed from: a */
    private static final String f57826a = "InputConnectionAdaptor";

    /* renamed from: b */
    private final View f57827b;

    /* renamed from: c */
    private final int f57828c;

    /* renamed from: d */
    private final TextInputChannel f57829d;

    /* renamed from: e */
    private final ListenableEditingState f57830e;

    /* renamed from: f */
    private final EditorInfo f57831f;

    /* renamed from: g */
    private ExtractedTextRequest f57832g;

    /* renamed from: h */
    private boolean f57833h;

    /* renamed from: i */
    private CursorAnchorInfo.Builder f57834i;

    /* renamed from: j */
    private ExtractedText f57835j;

    /* renamed from: k */
    private InputMethodManager f57836k;

    /* renamed from: l */
    private final Layout f57837l;

    /* renamed from: m */
    private C21106a f57838m;

    /* renamed from: n */
    private final KeyboardManager f57839n;

    /* renamed from: o */
    private int f57840o;

    public C21107b(View view, int i, TextInputChannel textInputChannel, KeyboardManager keyboardManager, ListenableEditingState listenableEditingState, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.f57833h = false;
        this.f57835j = new ExtractedText();
        this.f57840o = 0;
        this.f57827b = view;
        this.f57828c = i;
        this.f57829d = textInputChannel;
        this.f57830e = listenableEditingState;
        listenableEditingState.mo172752a((ListenableEditingState.EditingStateWatcher) this);
        this.f57831f = editorInfo;
        this.f57839n = keyboardManager;
        this.f57838m = new C21106a(flutterJNI);
        this.f57837l = new DynamicLayout(this.f57830e, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f57836k = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    public C21107b(View view, int i, TextInputChannel textInputChannel, KeyboardManager keyboardManager, ListenableEditingState listenableEditingState, EditorInfo editorInfo) {
        this(view, i, textInputChannel, keyboardManager, listenableEditingState, editorInfo, new FlutterJNI());
    }

    /* renamed from: a */
    private ExtractedText m41577a(ExtractedTextRequest extractedTextRequest) {
        CharSequence charSequence;
        this.f57835j.startOffset = 0;
        this.f57835j.partialStartOffset = -1;
        this.f57835j.partialEndOffset = -1;
        this.f57835j.selectionStart = this.f57830e.mo172757e();
        this.f57835j.selectionEnd = this.f57830e.mo172758f();
        ExtractedText extractedText = this.f57835j;
        if (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) {
            charSequence = this.f57830e.toString();
        } else {
            charSequence = this.f57830e;
        }
        extractedText.text = charSequence;
        return this.f57835j;
    }

    /* renamed from: a */
    private CursorAnchorInfo m41576a() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        CursorAnchorInfo.Builder builder = this.f57834i;
        if (builder == null) {
            this.f57834i = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.f57834i.setSelectionRange(this.f57830e.mo172757e(), this.f57830e.mo172758f());
        int g = this.f57830e.mo172759g();
        int h = this.f57830e.mo172760h();
        if (g < 0 || h <= g) {
            this.f57834i.setComposingText(-1, "");
        } else {
            this.f57834i.setComposingText(g, this.f57830e.toString().subSequence(g, h));
        }
        return this.f57834i.build();
    }

    public Editable getEditable() {
        return this.f57830e;
    }

    public boolean beginBatchEdit() {
        this.f57830e.mo172755c();
        this.f57840o++;
        return super.beginBatchEdit();
    }

    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.f57840o--;
        this.f57830e.mo172756d();
        return endBatchEdit;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        return super.commitText(charSequence, i);
    }

    public boolean deleteSurroundingText(int i, int i2) {
        if (this.f57830e.mo172757e() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i, i2);
    }

    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return super.deleteSurroundingTextInCodePoints(i, i2);
    }

    public boolean setComposingRegion(int i, int i2) {
        return super.setComposingRegion(i, i2);
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        boolean z;
        beginBatchEdit();
        if (charSequence.length() == 0) {
            z = super.commitText(charSequence, i);
        } else {
            z = super.setComposingText(charSequence, i);
        }
        endBatchEdit();
        return z;
    }

    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = true;
        boolean z2 = (i & 1) != 0;
        if (this.f57832g != null) {
            z = false;
        }
        if (z2 == z) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z2 ? "on" : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            Log.m41134d(f57826a, sb.toString());
        }
        this.f57832g = z2 ? extractedTextRequest : null;
        return m41577a(extractedTextRequest);
    }

    public boolean requestCursorUpdates(int i) {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if ((i & 1) != 0) {
            this.f57836k.updateCursorAnchorInfo(this.f57827b, m41576a());
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if (z != this.f57833h) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z ? "on" : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            Log.m41134d(f57826a, sb.toString());
        }
        this.f57833h = z;
        return true;
    }

    public boolean clearMetaKeyStates(int i) {
        return super.clearMetaKeyStates(i);
    }

    public void closeConnection() {
        super.closeConnection();
        this.f57830e.mo172754b(this);
        while (this.f57840o > 0) {
            endBatchEdit();
            this.f57840o--;
        }
    }

    public boolean setSelection(int i, int i2) {
        beginBatchEdit();
        boolean selection = super.setSelection(i, i2);
        endBatchEdit();
        return selection;
    }

    /* renamed from: a */
    private static int m41575a(int i, Editable editable) {
        int max = Math.max(0, Math.min(editable.length(), i));
        if (max != i) {
            Log.m41134d("flutter", "Text selection index was clamped (" + i + "->" + max + ") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
        }
        return max;
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.f57839n.handleEvent(keyEvent);
    }

    /* renamed from: a */
    public boolean mo172802a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 21) {
                return m41579a(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 22) {
                return m41579a(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 19) {
                return m41580b(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 20) {
                return m41580b(false, keyEvent.isShiftPressed());
            }
            if ((keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) && (131072 & this.f57831f.inputType) == 0) {
                performEditorAction(this.f57831f.imeOptions & 255);
                return true;
            }
            int selectionStart = Selection.getSelectionStart(this.f57830e);
            int selectionEnd = Selection.getSelectionEnd(this.f57830e);
            int unicodeChar = keyEvent.getUnicodeChar();
            if (selectionStart < 0 || selectionEnd < 0 || unicodeChar == 0) {
                return false;
            }
            int min = Math.min(selectionStart, selectionEnd);
            int max = Math.max(selectionStart, selectionEnd);
            beginBatchEdit();
            if (min != max) {
                this.f57830e.delete(min, max);
            }
            this.f57830e.insert(min, String.valueOf((char) unicodeChar));
            int i = min + 1;
            setSelection(i, i);
            endBatchEdit();
            return true;
        } else if (keyEvent.getAction() != 1 || (keyEvent.getKeyCode() != 59 && keyEvent.getKeyCode() != 60)) {
            return false;
        } else {
            int selectionEnd2 = Selection.getSelectionEnd(this.f57830e);
            setSelection(selectionEnd2, selectionEnd2);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m41579a(boolean z, boolean z2) {
        int i;
        int selectionStart = Selection.getSelectionStart(this.f57830e);
        int selectionEnd = Selection.getSelectionEnd(this.f57830e);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (z) {
            i = Math.max(this.f57838m.mo172793a(this.f57830e, selectionEnd), 0);
        } else {
            i = Math.min(this.f57838m.mo172795b(this.f57830e, selectionEnd), this.f57830e.length());
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        if (z3) {
            setSelection(i, i);
        } else {
            setSelection(selectionStart, i);
        }
        return true;
    }

    /* renamed from: b */
    private boolean m41580b(boolean z, boolean z2) {
        int selectionStart = Selection.getSelectionStart(this.f57830e);
        int selectionEnd = Selection.getSelectionEnd(this.f57830e);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        beginBatchEdit();
        if (z3) {
            if (z) {
                Selection.moveUp(this.f57830e, this.f57837l);
            } else {
                Selection.moveDown(this.f57830e, this.f57837l);
            }
            int selectionStart2 = Selection.getSelectionStart(this.f57830e);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z) {
                Selection.extendUp(this.f57830e, this.f57837l);
            } else {
                Selection.extendDown(this.f57830e, this.f57837l);
            }
            setSelection(Selection.getSelectionStart(this.f57830e), Selection.getSelectionEnd(this.f57830e));
        }
        endBatchEdit();
        return true;
    }

    public boolean performContextMenuAction(int i) {
        beginBatchEdit();
        boolean a = m41578a(i);
        endBatchEdit();
        return a;
    }

    /* renamed from: a */
    private boolean m41578a(int i) {
        if (i == 16908319) {
            setSelection(0, this.f57830e.length());
            return true;
        } else if (i == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.f57830e);
            int selectionEnd = Selection.getSelectionEnd(this.f57830e);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.f57827b.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f57830e.subSequence(min, max)));
                this.f57830e.delete(min, max);
                setSelection(min, min);
            }
            return true;
        } else if (i == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.f57830e);
            int selectionEnd2 = Selection.getSelectionEnd(this.f57830e);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.f57827b.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f57830e.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        } else if (i != 16908322) {
            return false;
        } else {
            ClipData primaryClip = ((ClipboardManager) this.f57827b.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null) {
                CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.f57827b.getContext());
                int max2 = Math.max(0, Selection.getSelectionStart(this.f57830e));
                int max3 = Math.max(0, Selection.getSelectionEnd(this.f57830e));
                int min2 = Math.min(max2, max3);
                int max4 = Math.max(max2, max3);
                if (min2 != max4) {
                    this.f57830e.delete(min2, max4);
                }
                this.f57830e.insert(min2, coerceToText);
                int length = min2 + coerceToText.length();
                setSelection(length, length);
            }
            return true;
        }
    }

    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.f57829d.performPrivateCommand(this.f57828c, str, bundle);
        return true;
    }

    public boolean performEditorAction(int i) {
        if (i == 0) {
            this.f57829d.unspecifiedAction(this.f57828c);
        } else if (i == 1) {
            this.f57829d.newline(this.f57828c);
        } else if (i == 2) {
            this.f57829d.mo172681go(this.f57828c);
        } else if (i == 3) {
            this.f57829d.search(this.f57828c);
        } else if (i == 4) {
            this.f57829d.send(this.f57828c);
        } else if (i == 5) {
            this.f57829d.next(this.f57828c);
        } else if (i != 7) {
            this.f57829d.done(this.f57828c);
        } else {
            this.f57829d.previous(this.f57828c);
        }
        return true;
    }

    public void didChangeEditingState(boolean z, boolean z2, boolean z3) {
        this.f57836k.updateSelection(this.f57827b, this.f57830e.mo172757e(), this.f57830e.mo172758f(), this.f57830e.mo172759g(), this.f57830e.mo172760h());
        if (Build.VERSION.SDK_INT >= 21) {
            ExtractedTextRequest extractedTextRequest = this.f57832g;
            if (extractedTextRequest != null) {
                this.f57836k.updateExtractedText(this.f57827b, extractedTextRequest.token, m41577a(this.f57832g));
            }
            if (this.f57833h) {
                this.f57836k.updateCursorAnchorInfo(this.f57827b, m41576a());
            }
        }
    }
}
