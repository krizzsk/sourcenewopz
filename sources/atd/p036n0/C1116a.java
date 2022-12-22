package atd.p036n0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.adyen.threeds2.customization.ButtonCustomization;
import com.adyen.threeds2.customization.Customization;
import com.adyen.threeds2.customization.ExpandableInfoCustomization;
import com.adyen.threeds2.customization.LabelCustomization;
import com.adyen.threeds2.customization.ScreenCustomization;
import com.adyen.threeds2.customization.SelectionItemCustomization;
import com.adyen.threeds2.customization.TextBoxCustomization;
import com.adyen.threeds2.customization.ToolbarCustomization;
import com.adyen.threeds2.customization.UiCustomization;
import com.adyen.threeds2.internal.p059ui.widget.DividerView;
import com.adyen.threeds2.internal.p059ui.widget.ExpandableInfoTextView;
import com.adyen.threeds2.internal.p059ui.widget.ToolbarView;
import com.taxis99.R;

/* renamed from: atd.n0.a */
public final class C1116a {

    /* renamed from: a */
    private final UiCustomization f330a;

    /* renamed from: atd.n0.a$a */
    static /* synthetic */ class C1117a {

        /* renamed from: a */
        static final /* synthetic */ int[] f331a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.threeds2.internal.ui.widget.DividerView$b[] r0 = com.adyen.threeds2.internal.p059ui.widget.DividerView.C1424b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f331a = r0
                com.adyen.threeds2.internal.ui.widget.DividerView$b r1 = com.adyen.threeds2.internal.p059ui.widget.DividerView.C1424b.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f331a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.threeds2.internal.ui.widget.DividerView$b r1 = com.adyen.threeds2.internal.p059ui.widget.DividerView.C1424b.VERTICAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.p036n0.C1116a.C1117a.<clinit>():void");
        }
    }

    public C1116a(UiCustomization uiCustomization) {
        this.f330a = uiCustomization;
    }

    /* renamed from: b */
    private void m629b(Button button, ButtonCustomization buttonCustomization) {
        if (buttonCustomization != null) {
            Integer parseHexColorCode = Customization.parseHexColorCode(buttonCustomization.getBackgroundColor());
            if (parseHexColorCode != null) {
                m614a(button.getBackground(), parseHexColorCode, true);
            }
            m617a(button, buttonCustomization);
        }
    }

    /* renamed from: c */
    private void m630c(Button button, ButtonCustomization buttonCustomization) {
        if (buttonCustomization != null) {
            Integer parseHexColorCode = Customization.parseHexColorCode(buttonCustomization.getBackgroundColor());
            if (parseHexColorCode != null) {
                m613a(button.getBackground(), parseHexColorCode);
            }
            m617a(button, buttonCustomization);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo13845a(Window window) {
        ScreenCustomization screenCustomization;
        Integer parseHexColorCode;
        UiCustomization uiCustomization = this.f330a;
        if (uiCustomization != null && (screenCustomization = uiCustomization.getScreenCustomization()) != null) {
            Integer parseHexColorCode2 = Customization.parseHexColorCode(screenCustomization.getBackgroundColor());
            if (parseHexColorCode2 != null) {
                ColorDrawable colorDrawable = new ColorDrawable(parseHexColorCode2.intValue());
                if (Build.VERSION.SDK_INT >= 21) {
                    colorDrawable.setTint(parseHexColorCode2.intValue());
                }
                window.setBackgroundDrawable(colorDrawable);
            }
            if (Build.VERSION.SDK_INT >= 21 && (parseHexColorCode = Customization.parseHexColorCode(screenCustomization.getStatusBarColor())) != null) {
                window.setStatusBarColor(parseHexColorCode.intValue());
            }
        }
    }

    /* renamed from: b */
    private void m628b(Drawable drawable, Integer num) {
        if (drawable != null && num != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                if (drawable instanceof InsetDrawable) {
                    m628b(((InsetDrawable) drawable).getDrawable(), num);
                } else if (drawable instanceof StateListDrawable) {
                    DrawableContainer.DrawableContainerState drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
                    if (drawableContainerState != null) {
                        for (int i = 0; i < drawableContainerState.getChildren().length; i++) {
                            m628b(drawableContainerState.getChild(i), num);
                        }
                    }
                } else if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setCornerRadius((float) num.intValue());
                }
            }
            if (Build.VERSION.SDK_INT >= 21 && (drawable instanceof RippleDrawable)) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable;
                m628b(rippleDrawable.getNumberOfLayers() > 0 ? rippleDrawable.getDrawable(0) : null, num);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo13844a(View view, AttributeSet attributeSet) {
        if (this.f330a != null) {
            int styleAttribute = attributeSet.getStyleAttribute();
            if (view instanceof ProgressBar) {
                m620a((ProgressBar) view, styleAttribute);
            } else if (view instanceof CompoundButton) {
                m618a((CompoundButton) view);
            } else if (view instanceof Button) {
                m616a((Button) view, styleAttribute);
            } else if (view instanceof EditText) {
                m619a((EditText) view);
            } else if (view instanceof TextView) {
                m621a((TextView) view, styleAttribute);
            } else if (view instanceof ToolbarView) {
                m627a((ToolbarView) view);
            } else if (view instanceof ExpandableInfoTextView) {
                m626a((ExpandableInfoTextView) view);
            } else if (view instanceof DividerView) {
                m624a((DividerView) view);
            } else if (view instanceof ViewGroup) {
                m615a(view, styleAttribute);
            }
        }
    }

    /* renamed from: a */
    private void m620a(ProgressBar progressBar, int i) {
        ToolbarCustomization toolbarCustomization;
        Integer parseHexColorCode;
        if (i == 2132018343 && (toolbarCustomization = this.f330a.getToolbarCustomization()) != null && (parseHexColorCode = Customization.parseHexColorCode(toolbarCustomization.getBackgroundColor())) != null) {
            m613a(progressBar.getIndeterminateDrawable(), parseHexColorCode);
        }
    }

    /* renamed from: a */
    private void m618a(CompoundButton compoundButton) {
        Integer parseHexColorCode;
        SelectionItemCustomization selectionItemCustomization = this.f330a.getSelectionItemCustomization();
        if (selectionItemCustomization != null && Build.VERSION.SDK_INT >= 21 && (parseHexColorCode = Customization.parseHexColorCode(selectionItemCustomization.getSelectionIndicatorTintColor())) != null) {
            compoundButton.setButtonTintList(ColorStateList.valueOf(parseHexColorCode.intValue()));
        }
    }

    /* renamed from: a */
    private void m616a(Button button, int i) {
        if (i == 2132018330) {
            m629b(button, this.f330a.getButtonCustomization(UiCustomization.ButtonType.CANCEL));
        } else if (i == 2132018331) {
            m629b(button, this.f330a.getButtonCustomization(UiCustomization.ButtonType.RESEND));
        } else if (i == 2132018336) {
            m630c(button, this.f330a.getButtonCustomization(UiCustomization.ButtonType.VERIFY));
        } else if (i == 2132018333) {
            m630c(button, this.f330a.getButtonCustomization(UiCustomization.ButtonType.CONTINUE));
        } else if (i == 2132018334) {
            m630c(button, this.f330a.getButtonCustomization(UiCustomization.ButtonType.NEXT));
        }
    }

    /* renamed from: a */
    private void m617a(Button button, ButtonCustomization buttonCustomization) {
        int cornerRadius = buttonCustomization.getCornerRadius();
        if (cornerRadius >= 0) {
            m628b(button.getBackground(), Integer.valueOf(cornerRadius));
        }
        m622a((TextView) button, (Customization) buttonCustomization);
    }

    /* renamed from: a */
    private void m619a(EditText editText) {
        TextBoxCustomization textBoxCustomization = this.f330a.getTextBoxCustomization();
        if (textBoxCustomization != null) {
            Integer parseHexColorCode = Customization.parseHexColorCode(textBoxCustomization.getBorderColor());
            if (parseHexColorCode != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    editText.setBackgroundTintList(ColorStateList.valueOf(parseHexColorCode.intValue()));
                } else {
                    m613a(editText.getBackground(), parseHexColorCode);
                }
            }
            m622a((TextView) editText, (Customization) textBoxCustomization);
        }
    }

    /* renamed from: a */
    private void m621a(TextView textView, int i) {
        if (i == 2132017932) {
            m622a(textView, (Customization) this.f330a.getToolbarCustomization());
        } else if (i == 2132017916) {
            LabelCustomization labelCustomization = this.f330a.getLabelCustomization();
            m623a(textView, labelCustomization.getHeadingTextColor(), labelCustomization.getHeadingTextFontName(), labelCustomization.getHeadingTextFontSize());
        } else if (i == 2132017917) {
            LabelCustomization labelCustomization2 = this.f330a.getLabelCustomization();
            m623a(textView, labelCustomization2.getInputLabelTextColor(), labelCustomization2.getInputLabelTextFontName(), labelCustomization2.getInputLabelTextFontSize());
        } else if (i == 2132017924) {
            m622a(textView, (Customization) this.f330a.getSelectionItemCustomization());
        } else if (i == 2132017930) {
            ExpandableInfoCustomization expandableInfoCustomization = this.f330a.getExpandableInfoCustomization();
            m623a(textView, expandableInfoCustomization.getHeadingTextColor(), expandableInfoCustomization.getHeadingTextFontName(), expandableInfoCustomization.getHeadingTextFontSize());
        } else if (i == 2132017929) {
            m622a(textView, (Customization) this.f330a.getExpandableInfoCustomization());
        } else {
            m622a(textView, (Customization) this.f330a.getLabelCustomization());
        }
    }

    /* renamed from: a */
    private void m622a(TextView textView, Customization customization) {
        if (customization != null) {
            m623a(textView, customization.getTextColor(), customization.getTextFontName(), customization.getTextFontSize());
        }
    }

    /* renamed from: a */
    private void m623a(TextView textView, String str, String str2, int i) {
        Integer parseHexColorCode = Customization.parseHexColorCode(str);
        if (parseHexColorCode != null) {
            textView.setTextColor(parseHexColorCode.intValue());
        }
        Typeface parseTypeface = Customization.parseTypeface(textView.getContext(), str2);
        if (parseTypeface != null) {
            textView.setTypeface(parseTypeface);
        }
        if (i > 0) {
            textView.setTextSize((float) i);
        }
    }

    /* renamed from: a */
    private void m627a(ToolbarView toolbarView) {
        ToolbarCustomization toolbarCustomization = this.f330a.getToolbarCustomization();
        if (toolbarCustomization != null) {
            Integer parseHexColorCode = Customization.parseHexColorCode(toolbarCustomization.getBackgroundColor());
            if (parseHexColorCode != null) {
                toolbarView.setBackgroundColor(parseHexColorCode.intValue());
            }
            String headerText = toolbarCustomization.getHeaderText();
            if (!TextUtils.isEmpty(headerText)) {
                toolbarView.setTitle(headerText);
            }
            String buttonText = toolbarCustomization.getButtonText();
            if (!TextUtils.isEmpty(buttonText)) {
                toolbarView.setCancelButtonText(buttonText);
            }
            Integer parseHexColorCode2 = Customization.parseHexColorCode(toolbarCustomization.getTextColor());
            if (parseHexColorCode2 != null) {
                toolbarView.setTitleTextColor(parseHexColorCode2.intValue());
                toolbarView.setCancelButtonTextColor(parseHexColorCode2.intValue());
            }
            Typeface parseTypeface = Customization.parseTypeface(toolbarView.getContext(), toolbarCustomization.getTextFontName());
            if (parseTypeface != null) {
                toolbarView.setTitleTypeface(parseTypeface);
                toolbarView.setCancelButtonTextTypeface(parseTypeface);
            }
            int textFontSize = toolbarCustomization.getTextFontSize();
            if (textFontSize > 0) {
                toolbarView.setTitleFontSize(Integer.valueOf(textFontSize));
            }
        }
    }

    /* renamed from: a */
    private void m626a(ExpandableInfoTextView expandableInfoTextView) {
        ExpandableInfoCustomization expandableInfoCustomization = this.f330a.getExpandableInfoCustomization();
        if (expandableInfoCustomization != null) {
            Integer parseHexColorCode = Customization.parseHexColorCode(expandableInfoCustomization.getHighlightedBackgroundColor());
            if (parseHexColorCode != null) {
                expandableInfoTextView.setHeaderBackgroundColor(parseHexColorCode.intValue());
            }
            Integer parseHexColorCode2 = Customization.parseHexColorCode(expandableInfoCustomization.getExpandedStateIndicatorColor());
            if (parseHexColorCode2 != null) {
                expandableInfoTextView.setStateIndicatorColor(parseHexColorCode2.intValue());
            }
        }
    }

    /* renamed from: a */
    private void m615a(View view, int i) {
        SelectionItemCustomization selectionItemCustomization;
        Integer parseHexColorCode;
        if (i == 2132018345 && (selectionItemCustomization = this.f330a.getSelectionItemCustomization()) != null && (parseHexColorCode = Customization.parseHexColorCode(selectionItemCustomization.getHighlightedBackgroundColor())) != null) {
            m614a(view.getBackground(), parseHexColorCode, true);
        }
    }

    /* renamed from: a */
    private void m624a(DividerView dividerView) {
        ExpandableInfoCustomization expandableInfoCustomization;
        int id = dividerView.getId();
        if (id == R.id.dividerView_info) {
            ExpandableInfoCustomization expandableInfoCustomization2 = this.f330a.getExpandableInfoCustomization();
            if (expandableInfoCustomization2 != null) {
                m625a(dividerView, expandableInfoCustomization2.getBorderColor(), expandableInfoCustomization2.getBorderWidth());
            }
        } else if (id == R.id.dividerView_select) {
            SelectionItemCustomization selectionItemCustomization = this.f330a.getSelectionItemCustomization();
            if (selectionItemCustomization != null) {
                m625a(dividerView, selectionItemCustomization.getBorderColor(), selectionItemCustomization.getBorderWidth());
            }
        } else if (id == R.id.dividerView_logos && (expandableInfoCustomization = this.f330a.getExpandableInfoCustomization()) != null) {
            m625a(dividerView, expandableInfoCustomization.getBorderColor(), expandableInfoCustomization.getBorderWidth());
        }
    }

    /* renamed from: a */
    private void m625a(DividerView dividerView, String str, int i) {
        Integer parseHexColorCode = Customization.parseHexColorCode(str);
        if (parseHexColorCode != null) {
            dividerView.setColor(parseHexColorCode.intValue());
        }
        if (i >= 0) {
            int i2 = C1117a.f331a[dividerView.getOrientation().ordinal()];
            if (i2 == 1) {
                dividerView.setThickness(i);
            } else if (i2 == 2) {
                dividerView.setThickness(i);
            }
        }
    }

    /* renamed from: a */
    private void m613a(Drawable drawable, Integer num) {
        m614a(drawable, num, false);
    }

    /* renamed from: a */
    private void m614a(Drawable drawable, Integer num, boolean z) {
        if (drawable != null && num != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (drawable instanceof RippleDrawable) {
                    RippleDrawable rippleDrawable = (RippleDrawable) drawable;
                    if (z) {
                        rippleDrawable.setColor(ColorStateList.valueOf(num.intValue()));
                    }
                    m613a(rippleDrawable.getNumberOfLayers() > 0 ? rippleDrawable.getDrawable(0) : null, num);
                } else if (drawable instanceof InsetDrawable) {
                    m613a(((InsetDrawable) drawable).getDrawable(), num);
                } else if (drawable instanceof ColorDrawable) {
                    ColorDrawable colorDrawable = (ColorDrawable) drawable;
                    colorDrawable.setTint(num.intValue());
                    colorDrawable.setColor(num.intValue());
                } else {
                    drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
                }
            } else if (drawable instanceof ColorDrawable) {
                ((ColorDrawable) drawable).setColor(num.intValue());
            } else {
                drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            }
        }
    }
}
