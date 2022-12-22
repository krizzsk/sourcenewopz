package com.didi.rfusion.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.didi.passenger.C10448R;
import com.didi.rfusion.widget.RFIconView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u000bJ\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/rfusion/material/internal/RFCheckableIconButton;", "Lcom/didi/rfusion/widget/RFIconView;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkable", "", "checked", "checkedIcon", "", "defaultIcon", "isCheckable", "isChecked", "onRestoreInstanceState", "", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "refreshIconState", "setCheckable", "setChecked", "setIcon", "default", "toggle", "Companion", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFCheckableIconButton.kt */
public final class RFCheckableIconButton extends RFIconView implements Checkable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private boolean f33199a;

    /* renamed from: b */
    private boolean f33200b;

    /* renamed from: c */
    private String f33201c;

    /* renamed from: d */
    private String f33202d;

    /* renamed from: e */
    private HashMap f33203e;

    public RFCheckableIconButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RFCheckableIconButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33203e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33203e == null) {
            this.f33203e = new HashMap();
        }
        View view = (View) this.f33203e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33203e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFCheckableIconButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFCheckableIconButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f33200b = true;
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat(this) {
            final /* synthetic */ RFCheckableIconButton this$0;

            {
                this.this$0 = r1;
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                Intrinsics.checkParameterIsNotNull(view, "host");
                Intrinsics.checkParameterIsNotNull(accessibilityEvent, "event");
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(this.this$0.isChecked());
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Intrinsics.checkParameterIsNotNull(view, "host");
                Intrinsics.checkParameterIsNotNull(accessibilityNodeInfoCompat, "info");
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCheckable(this.this$0.isCheckable());
                accessibilityNodeInfoCompat.setChecked(this.this$0.isChecked());
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RFCheckableIconButton);
        String string = obtainStyledAttributes.getString(0);
        String string2 = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        setIcon(string, string2);
    }

    public final void setIcon(String str, String str2) {
        this.f33201c = str;
        this.f33202d = str2;
        m23377a();
    }

    public final void setCheckable(boolean z) {
        if (this.f33200b != z) {
            this.f33200b = z;
            m23377a();
            sendAccessibilityEvent(0);
        }
    }

    public final boolean isCheckable() {
        return this.f33200b;
    }

    /* renamed from: a */
    private final void m23377a() {
        CharSequence charSequence;
        if (!this.f33200b || !isChecked()) {
            charSequence = this.f33201c;
        } else {
            charSequence = this.f33202d;
        }
        setText(charSequence);
    }

    public void setChecked(boolean z) {
        if (this.f33200b && this.f33199a != z) {
            this.f33199a = z;
            m23377a();
            sendAccessibilityEvent(2048);
        }
    }

    public boolean isChecked() {
        return this.f33199a;
    }

    public void toggle() {
        setChecked(!this.f33199a);
    }

    public Parcelable onSaveInstanceState() {
        Companion.SavedState savedState = new Companion.SavedState(super.onSaveInstanceState());
        savedState.setChecked(this.f33199a);
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.checkParameterIsNotNull(parcelable, "state");
        if (!(parcelable instanceof Companion.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Companion.SavedState savedState = (Companion.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.getChecked());
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/rfusion/material/internal/RFCheckableIconButton$Companion;", "", "()V", "SavedState", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFCheckableIconButton.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/rfusion/material/internal/RFCheckableIconButton$Companion$SavedState;", "Landroidx/customview/view/AbsSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "source", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "checked", "", "getChecked", "()Z", "setChecked", "(Z)V", "readFromParcel", "", "in", "writeToParcel", "out", "flags", "", "CREATOR", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
        /* compiled from: RFCheckableIconButton.kt */
        public static final class SavedState extends AbsSavedState {
            public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
            private boolean checked;

            public final boolean getChecked() {
                return this.checked;
            }

            public final void setChecked(boolean z) {
                this.checked = z;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SavedState(Parcelable parcelable) {
                super(parcelable);
                if (parcelable == null) {
                    Intrinsics.throwNpe();
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                Intrinsics.checkParameterIsNotNull(parcel, "source");
                readFromParcel(parcel);
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkParameterIsNotNull(parcel, "out");
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.checked ? 1 : 0);
            }

            private final void readFromParcel(Parcel parcel) {
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.checked = z;
            }

            @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/rfusion/material/internal/RFCheckableIconButton$Companion$SavedState$CREATOR;", "Landroid/os/Parcelable$ClassLoaderCreator;", "Lcom/didi/rfusion/material/internal/RFCheckableIconButton$Companion$SavedState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "source", "loader", "Ljava/lang/ClassLoader;", "newArray", "", "size", "", "(I)[Lcom/didi/rfusion/material/internal/RFCheckableIconButton$Companion$SavedState;", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
            /* compiled from: RFCheckableIconButton.kt */
            public static final class CREATOR implements Parcelable.ClassLoaderCreator<SavedState> {
                private CREATOR() {
                }

                public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public SavedState createFromParcel(Parcel parcel) {
                    Intrinsics.checkParameterIsNotNull(parcel, "parcel");
                    return new SavedState(parcel, (ClassLoader) null);
                }

                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    Intrinsics.checkParameterIsNotNull(parcel, "source");
                    return new SavedState(parcel, classLoader);
                }

                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            }
        }
    }
}
