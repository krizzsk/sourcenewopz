package com.didiglobal.pay.paysecure.p204ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001aH\u0014J\u0006\u0010!\u001a\u00020\u001aJ\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\u001aR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/ui/view/InputPwdView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAdapter", "Lcom/didiglobal/pay/paysecure/ui/view/InputPwdListAdapter;", "mList", "Landroidx/recyclerview/widget/RecyclerView;", "mResultListener", "Lcom/didiglobal/pay/paysecure/ui/view/InputResultListener;", "getMResultListener", "()Lcom/didiglobal/pay/paysecure/ui/view/InputResultListener;", "setMResultListener", "(Lcom/didiglobal/pay/paysecure/ui/view/InputResultListener;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "initView", "", "onCheckIsTextEditor", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onFinishInflate", "reset", "setPwdCount", "pwdCount", "showErr", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.view.InputPwdView */
/* compiled from: InputPwdView.kt */
public final class InputPwdView extends FrameLayout {

    /* renamed from: a */
    private RecyclerView f50460a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public InputPwdListAdapter f50461b;
    public InputResultListener mResultListener;

    public boolean onCheckIsTextEditor() {
        return true;
    }

    public static final /* synthetic */ InputPwdListAdapter access$getMAdapter$p(InputPwdView inputPwdView) {
        InputPwdListAdapter inputPwdListAdapter = inputPwdView.f50461b;
        if (inputPwdListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        }
        return inputPwdListAdapter;
    }

    public final InputResultListener getMResultListener() {
        InputResultListener inputResultListener = this.mResultListener;
        if (inputResultListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mResultListener");
        }
        return inputResultListener;
    }

    public final void setMResultListener(InputResultListener inputResultListener) {
        Intrinsics.checkParameterIsNotNull(inputResultListener, "<set-?>");
        this.mResultListener = inputResultListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputPwdView(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        m36279a(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputPwdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        m36279a(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputPwdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        m36279a(context);
    }

    /* renamed from: a */
    private final void m36279a(Context context) {
        setFocusable(true);
        setFocusableInTouchMode(true);
        LayoutInflater.from(context).inflate(R.layout.view_input_pwd, this, true);
        setOnKeyListener(new InputPwdView$initView$1(this));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.list_pwd_input);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.list_pwd_input)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f50460a = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mList");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView2 = this.f50460a;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mList");
        }
        recyclerView2.addItemDecoration(new SpacesItemDecoration());
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        if (motionEvent == null || motionEvent.getAction() != 0) {
            return true;
        }
        Object systemService = getContext().getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).showSoftInput(this, 2);
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        Intrinsics.checkParameterIsNotNull(editorInfo, "outAttrs");
        BaseInputConnection baseInputConnection = new BaseInputConnection(this, false);
        editorInfo.actionLabel = null;
        editorInfo.inputType = 2;
        editorInfo.imeOptions = 1;
        return baseInputConnection;
    }

    public final void setPwdCount(int i) {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.f50461b = new InputPwdListAdapter(context, i);
        RecyclerView recyclerView = this.f50460a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mList");
        }
        InputPwdListAdapter inputPwdListAdapter = this.f50461b;
        if (inputPwdListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        }
        recyclerView.setAdapter(inputPwdListAdapter);
    }

    public final void showErr() {
        InputPwdListAdapter inputPwdListAdapter = this.f50461b;
        if (inputPwdListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        }
        inputPwdListAdapter.showErr();
    }

    public final void reset() {
        InputPwdListAdapter inputPwdListAdapter = this.f50461b;
        if (inputPwdListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        }
        inputPwdListAdapter.reset();
    }
}
