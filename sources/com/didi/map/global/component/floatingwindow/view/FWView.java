package com.didi.map.global.component.floatingwindow.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.map.global.component.floatingwindow.IFWController;
import com.didi.map.global.component.floatingwindow.util.ExpandWidth;
import com.didi.map.global.component.floatingwindow.util.ViewExtKt;
import com.didi.map.global.component.floatingwindow.view.IFWView;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.font.DiDiTypeface;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0017J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/view/FWView;", "Landroid/widget/FrameLayout;", "Lcom/didi/map/global/component/floatingwindow/view/IFWView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "carView", "Landroid/widget/ImageView;", "constraintLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "expandImageView", "logoImageView", "logoLayout", "lottieLayout", "mainTextView", "Landroid/widget/TextView;", "maskView", "Landroid/view/View;", "rollImageView", "subTextView", "titleLayout", "Landroid/widget/LinearLayout;", "initView", "", "setCarBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setMainTitle", "mainTitle", "", "setMaskVisible", "visible", "", "setSubTitle", "subTitle", "setTouchListener", "listener", "Landroid/view/View$OnTouchListener;", "updateMaskState", "isShow", "alpha", "", "updateViewBackground", "colorState", "Lcom/didi/map/global/component/floatingwindow/IFWController$Style;", "shapeState", "Lcom/didi/map/global/component/floatingwindow/view/IFWView$FWShapeState;", "Companion", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FWView.kt */
public final class FWView extends FrameLayout implements IFWView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float HANDLE_BOTTOM = 30.0f;
    public static final float HANDLE_LEFT = 4.5f;
    public static final float HANDLE_RIGHT = 8.0f;
    public static final float HANDLE_TOP = 30.0f;
    public static final String TAG = "FWView";

    /* renamed from: a */
    private View f25617a;

    /* renamed from: b */
    private ConstraintLayout f25618b;

    /* renamed from: c */
    private FrameLayout f25619c;

    /* renamed from: d */
    private ImageView f25620d;

    /* renamed from: e */
    private LinearLayout f25621e;

    /* renamed from: f */
    private ImageView f25622f;

    /* renamed from: g */
    private ImageView f25623g;

    /* renamed from: h */
    private TextView f25624h;

    /* renamed from: i */
    private TextView f25625i;

    /* renamed from: j */
    private ImageView f25626j;

    /* renamed from: k */
    private FrameLayout f25627k;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FWView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[IFWController.Style.values().length];
            iArr[IFWController.Style.Grey.ordinal()] = 1;
            iArr[IFWController.Style.Gradient.ordinal()] = 2;
            iArr[IFWController.Style.Orange.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IFWView.FWShapeState.values().length];
            iArr2[IFWView.FWShapeState.EXPAND.ordinal()] = 1;
            iArr2[IFWView.FWShapeState.EXPAND_NORMAL_DRAG.ordinal()] = 2;
            iArr2[IFWView.FWShapeState.EXPAND_HANDLE_DRAG.ordinal()] = 3;
            iArr2[IFWView.FWShapeState.ROLL.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FWView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FWView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FWView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/view/FWView$Companion;", "", "()V", "HANDLE_BOTTOM", "", "HANDLE_LEFT", "HANDLE_RIGHT", "HANDLE_TOP", "TAG", "", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FWView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FWView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.map_comp_layout_fw_container, this, true);
        m18308a();
    }

    /* renamed from: a */
    private final void m18308a() {
        this.f25618b = (ConstraintLayout) findViewById(R.id.fw_constraintLayout);
        this.f25623g = (ImageView) findViewById(R.id.fw_roll_arrow_view);
        this.f25617a = findViewById(R.id.fw_image_mask);
        TextView textView = (TextView) findViewById(R.id.fw_tv_mainTitle);
        this.f25624h = textView;
        ViewExtKt.setDidiTypeFont(textView, DiDiTypeface.FONT_BOLD);
        TextView textView2 = (TextView) findViewById(R.id.fw_tv_subTitle);
        this.f25625i = textView2;
        ViewExtKt.setDidiTypeFont(textView2, DiDiTypeface.FONT_REGULAR);
        this.f25626j = (ImageView) findViewById(R.id.fw_image_car);
        this.f25619c = (FrameLayout) findViewById(R.id.fw_image_frameLayout);
        this.f25620d = (ImageView) findViewById(R.id.fw_image_logo);
        this.f25621e = (LinearLayout) findViewById(R.id.fw_linearLayout);
        this.f25622f = (ImageView) findViewById(R.id.fw_expand_arrow_view);
        this.f25627k = (FrameLayout) findViewById(R.id.fw_lottie_frameLayout);
        ImageView imageView = this.f25622f;
        if (imageView != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            ViewExtKt.setViewTouchDelegate(imageView, new ExpandWidth((int) ViewExtKt.dp2px(context, 14.5f), (int) ViewExtKt.dp2px(context2, 40.0f), (int) ViewExtKt.dp2px(context3, 8.0f), (int) ViewExtKt.dp2px(context4, 40.0f)));
        }
    }

    public void updateViewBackground(IFWController.Style style, IFWView.FWShapeState fWShapeState) {
        Intrinsics.checkNotNullParameter(style, "colorState");
        Intrinsics.checkNotNullParameter(fWShapeState, "shapeState");
        SystemUtils.log(3, TAG, "updateViewBackground: shapeState=" + fWShapeState + ", colorState=" + style, (Throwable) null, "com.didi.map.global.component.floatingwindow.view.FWView", 93);
        int i = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
        if (i == 1) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[fWShapeState.ordinal()];
            if (i2 == 1) {
                ImageView imageView = this.f25623g;
                if (imageView != null) {
                    ViewExtKt.gone(imageView);
                }
                ImageView imageView2 = this.f25622f;
                if (imageView2 != null) {
                    ViewExtKt.show(imageView2);
                }
                ConstraintLayout constraintLayout = this.f25618b;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundResource(R.drawable.map_comp_fw_bg_adsorption_white);
                }
            } else if (i2 == 2) {
                ImageView imageView3 = this.f25622f;
                if (imageView3 != null) {
                    ViewExtKt.gone(imageView3);
                }
                ImageView imageView4 = this.f25623g;
                if (imageView4 != null) {
                    ViewExtKt.gone(imageView4);
                }
                ConstraintLayout constraintLayout2 = this.f25618b;
                if (constraintLayout2 != null) {
                    constraintLayout2.setBackgroundResource(R.drawable.map_comp_fw_bg_drag_white);
                }
            } else if (i2 == 3) {
                ImageView imageView5 = this.f25623g;
                if (imageView5 != null) {
                    ViewExtKt.gone(imageView5);
                }
                ImageView imageView6 = this.f25622f;
                if (imageView6 != null) {
                    ViewExtKt.show(imageView6);
                }
                ConstraintLayout constraintLayout3 = this.f25618b;
                if (constraintLayout3 != null) {
                    constraintLayout3.setBackgroundResource(R.drawable.map_comp_fw_bg_adsorption_white);
                }
            } else if (i2 == 4) {
                ImageView imageView7 = this.f25622f;
                if (imageView7 != null) {
                    ViewExtKt.gone(imageView7);
                }
                ImageView imageView8 = this.f25623g;
                if (imageView8 != null) {
                    ViewExtKt.show(imageView8);
                }
                ConstraintLayout constraintLayout4 = this.f25618b;
                if (constraintLayout4 != null) {
                    constraintLayout4.setBackgroundResource(R.drawable.map_comp_fw_bg_adsorption_white);
                }
            }
            FrameLayout frameLayout = this.f25627k;
            if (frameLayout != null) {
                ViewExtKt.gone(frameLayout);
            }
            ConstraintLayout constraintLayout5 = this.f25618b;
            if (constraintLayout5 != null) {
                constraintLayout5.setAlpha(1.0f);
            }
            View view = this.f25617a;
            if (view != null) {
                view.setBackgroundResource(R.drawable.map_comp_fw_mask_white);
            }
            ImageView imageView9 = this.f25623g;
            if (imageView9 != null) {
                imageView9.setImageResource(R.drawable.map_comp_fw_arrow_black);
            }
            ImageView imageView10 = this.f25620d;
            if (imageView10 != null) {
                imageView10.setImageResource(R.drawable.map_comp_fw_car_logo_white);
            }
        } else if (i == 2) {
            int i3 = WhenMappings.$EnumSwitchMapping$1[fWShapeState.ordinal()];
            if (i3 == 1) {
                ImageView imageView11 = this.f25623g;
                if (imageView11 != null) {
                    ViewExtKt.gone(imageView11);
                }
                ImageView imageView12 = this.f25622f;
                if (imageView12 != null) {
                    ViewExtKt.show(imageView12);
                }
                ConstraintLayout constraintLayout6 = this.f25618b;
                if (constraintLayout6 != null) {
                    constraintLayout6.setBackgroundResource(R.drawable.map_comp_fw_bg_adsorption_light_gradient);
                }
                FrameLayout frameLayout2 = this.f25627k;
                if (frameLayout2 != null) {
                    ViewExtKt.gone(frameLayout2);
                }
                ConstraintLayout constraintLayout7 = this.f25618b;
                if (constraintLayout7 != null) {
                    constraintLayout7.setAlpha(1.0f);
                }
            } else if (i3 == 2) {
                ImageView imageView13 = this.f25622f;
                if (imageView13 != null) {
                    ViewExtKt.gone(imageView13);
                }
                ImageView imageView14 = this.f25623g;
                if (imageView14 != null) {
                    ViewExtKt.gone(imageView14);
                }
                ConstraintLayout constraintLayout8 = this.f25618b;
                if (constraintLayout8 != null) {
                    constraintLayout8.setBackgroundResource(R.drawable.map_comp_fw_bg_drag_light_gradient);
                }
                FrameLayout frameLayout3 = this.f25627k;
                if (frameLayout3 != null) {
                    ViewExtKt.gone(frameLayout3);
                }
                ConstraintLayout constraintLayout9 = this.f25618b;
                if (constraintLayout9 != null) {
                    constraintLayout9.setAlpha(1.0f);
                }
            } else if (i3 == 3) {
                ImageView imageView15 = this.f25623g;
                if (imageView15 != null) {
                    ViewExtKt.gone(imageView15);
                }
                ImageView imageView16 = this.f25622f;
                if (imageView16 != null) {
                    ViewExtKt.show(imageView16);
                }
                ConstraintLayout constraintLayout10 = this.f25618b;
                if (constraintLayout10 != null) {
                    constraintLayout10.setBackgroundResource(R.drawable.map_comp_fw_bg_adsorption_light_gradient);
                }
                FrameLayout frameLayout4 = this.f25627k;
                if (frameLayout4 != null) {
                    ViewExtKt.gone(frameLayout4);
                }
                ConstraintLayout constraintLayout11 = this.f25618b;
                if (constraintLayout11 != null) {
                    constraintLayout11.setAlpha(1.0f);
                }
            } else if (i3 == 4) {
                ImageView imageView17 = this.f25622f;
                if (imageView17 != null) {
                    ViewExtKt.gone(imageView17);
                }
                ImageView imageView18 = this.f25623g;
                if (imageView18 != null) {
                    ViewExtKt.show(imageView18);
                }
                ConstraintLayout constraintLayout12 = this.f25618b;
                if (constraintLayout12 != null) {
                    constraintLayout12.setBackgroundResource(R.drawable.map_comp_fw_bg_adsorption_light_gradient);
                }
                FrameLayout frameLayout5 = this.f25627k;
                if (frameLayout5 != null) {
                    ViewExtKt.show(frameLayout5);
                }
                ConstraintLayout constraintLayout13 = this.f25618b;
                if (constraintLayout13 != null) {
                    constraintLayout13.setAlpha(0.0f);
                }
            }
            View view2 = this.f25617a;
            if (view2 != null) {
                view2.setBackgroundResource(R.drawable.map_comp_fw_mask_light_gradient);
            }
            ImageView imageView19 = this.f25623g;
            if (imageView19 != null) {
                imageView19.setImageResource(R.drawable.map_comp_fw_arrow_black);
            }
            ImageView imageView20 = this.f25620d;
            if (imageView20 != null) {
                imageView20.setImageResource(R.drawable.map_comp_fw_car_logo_light_gradient);
            }
        } else if (i == 3) {
            int i4 = WhenMappings.$EnumSwitchMapping$1[fWShapeState.ordinal()];
            if (i4 == 1) {
                ImageView imageView21 = this.f25623g;
                if (imageView21 != null) {
                    ViewExtKt.gone(imageView21);
                }
                ImageView imageView22 = this.f25622f;
                if (imageView22 != null) {
                    ViewExtKt.show(imageView22);
                }
                ConstraintLayout constraintLayout14 = this.f25618b;
                if (constraintLayout14 != null) {
                    constraintLayout14.setBackgroundResource(R.drawable.map_comp_fw_bg_adsorption_deep_gradient);
                }
            } else if (i4 == 2) {
                ImageView imageView23 = this.f25622f;
                if (imageView23 != null) {
                    ViewExtKt.gone(imageView23);
                }
                ImageView imageView24 = this.f25623g;
                if (imageView24 != null) {
                    ViewExtKt.gone(imageView24);
                }
                ConstraintLayout constraintLayout15 = this.f25618b;
                if (constraintLayout15 != null) {
                    constraintLayout15.setBackgroundResource(R.drawable.map_comp_fw_bg_drag_deep_gradient);
                }
            } else if (i4 == 3) {
                ImageView imageView25 = this.f25623g;
                if (imageView25 != null) {
                    ViewExtKt.gone(imageView25);
                }
                ImageView imageView26 = this.f25622f;
                if (imageView26 != null) {
                    ViewExtKt.show(imageView26);
                }
                ConstraintLayout constraintLayout16 = this.f25618b;
                if (constraintLayout16 != null) {
                    constraintLayout16.setBackgroundResource(R.drawable.map_comp_fw_bg_adsorption_deep_gradient);
                }
            } else if (i4 == 4) {
                ImageView imageView27 = this.f25622f;
                if (imageView27 != null) {
                    ViewExtKt.gone(imageView27);
                }
                ImageView imageView28 = this.f25623g;
                if (imageView28 != null) {
                    ViewExtKt.show(imageView28);
                }
                ConstraintLayout constraintLayout17 = this.f25618b;
                if (constraintLayout17 != null) {
                    constraintLayout17.setBackgroundResource(R.drawable.map_comp_fw_bg_roll_lag);
                }
            }
            FrameLayout frameLayout6 = this.f25627k;
            if (frameLayout6 != null) {
                ViewExtKt.gone(frameLayout6);
            }
            ConstraintLayout constraintLayout18 = this.f25618b;
            if (constraintLayout18 != null) {
                constraintLayout18.setAlpha(1.0f);
            }
            View view3 = this.f25617a;
            if (view3 != null) {
                view3.setBackgroundResource(R.drawable.map_comp_fw_mask_deep_gradient);
            }
            ImageView imageView29 = this.f25623g;
            if (imageView29 != null) {
                imageView29.setImageResource(R.drawable.map_comp_fw_arrow_white);
            }
            ImageView imageView30 = this.f25620d;
            if (imageView30 != null) {
                imageView30.setImageResource(R.drawable.map_comp_fw_car_logo_deep_gradient);
            }
        }
    }

    public void setTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            SystemUtils.log(3, TAG, "setTouchListener", (Throwable) null, "com.didi.map.global.component.floatingwindow.view.FWView", 194);
            ImageView imageView = this.f25622f;
            if (imageView != null) {
                imageView.setOnTouchListener(onTouchListener);
            }
            setOnTouchListener(onTouchListener);
        }
    }

    public void setMainTitle(String str) {
        if (str != null) {
            SystemUtils.log(3, TAG, Intrinsics.stringPlus("setMainTitle: mainTitle=", str), (Throwable) null, "com.didi.map.global.component.floatingwindow.view.FWView", 201);
            TextView textView = this.f25624h;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public void setSubTitle(String str) {
        if (str != null) {
            SystemUtils.log(3, TAG, Intrinsics.stringPlus("setSubTitle: subTitle=", str), (Throwable) null, "com.didi.map.global.component.floatingwindow.view.FWView", 207);
            TextView textView = this.f25625i;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public void setCarBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            SystemUtils.log(3, TAG, "setCarBitmap", (Throwable) null, "com.didi.map.global.component.floatingwindow.view.FWView", 213);
            ImageView imageView = this.f25626j;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public void updateMaskState(boolean z, float f) {
        if (z) {
            View view = this.f25617a;
            ViewGroup.LayoutParams layoutParams = null;
            Integer valueOf = view == null ? null : Integer.valueOf(view.getVisibility());
            if (valueOf != null && valueOf.intValue() == 0) {
                View view2 = this.f25617a;
                if (view2 != null) {
                    view2.setAlpha(f);
                }
            } else {
                View view3 = this.f25617a;
                if (view3 != null) {
                    layoutParams = view3.getLayoutParams();
                }
                if (layoutParams != null) {
                    layoutParams.width = getWidth();
                }
                if (layoutParams != null) {
                    layoutParams.height = getHeight();
                }
                View view4 = this.f25617a;
                if (view4 != null) {
                    view4.setLayoutParams(layoutParams);
                }
                View view5 = this.f25617a;
                if (view5 != null) {
                    view5.setAlpha(f);
                }
                View view6 = this.f25617a;
                if (view6 != null) {
                    ViewExtKt.show(view6);
                }
            }
            ImageView imageView = this.f25622f;
            if (imageView != null) {
                imageView.setAlpha(((float) 1) - f);
            }
            FrameLayout frameLayout = this.f25619c;
            if (frameLayout != null) {
                frameLayout.setAlpha(((float) 1) - f);
            }
            LinearLayout linearLayout = this.f25621e;
            if (linearLayout != null) {
                linearLayout.setAlpha(((float) 1) - f);
                return;
            }
            return;
        }
        ImageView imageView2 = this.f25622f;
        if (imageView2 != null) {
            imageView2.setAlpha(1.0f);
        }
        FrameLayout frameLayout2 = this.f25619c;
        if (frameLayout2 != null) {
            frameLayout2.setAlpha(1.0f);
        }
        LinearLayout linearLayout2 = this.f25621e;
        if (linearLayout2 != null) {
            linearLayout2.setAlpha(1.0f);
        }
        View view7 = this.f25617a;
        if (view7 != null) {
            ViewExtKt.gone(view7);
        }
    }

    public void setMaskVisible(boolean z) {
        if (z) {
            View view = this.f25617a;
            if (view != null) {
                ViewExtKt.show(view);
                return;
            }
            return;
        }
        View view2 = this.f25617a;
        if (view2 != null) {
            ViewExtKt.gone(view2);
        }
    }
}
