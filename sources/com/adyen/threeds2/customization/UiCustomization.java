package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.util.Preconditions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class UiCustomization {

    /* renamed from: a */
    private final Map<ButtonType, ButtonCustomization> f991a = new HashMap();

    /* renamed from: b */
    private final Map<Class<? extends Customization>, Customization> f992b = new HashMap();

    public enum ButtonType {
        VERIFY,
        CONTINUE,
        NEXT,
        CANCEL,
        RESEND
    }

    /* renamed from: com.adyen.threeds2.customization.UiCustomization$a */
    static /* synthetic */ class C1393a {

        /* renamed from: a */
        static final /* synthetic */ int[] f993a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.threeds2.customization.UiCustomization$ButtonType[] r0 = com.adyen.threeds2.customization.UiCustomization.ButtonType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f993a = r0
                com.adyen.threeds2.customization.UiCustomization$ButtonType r1 = com.adyen.threeds2.customization.UiCustomization.ButtonType.CANCEL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f993a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.threeds2.customization.UiCustomization$ButtonType r1 = com.adyen.threeds2.customization.UiCustomization.ButtonType.RESEND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.threeds2.customization.UiCustomization.C1393a.<clinit>():void");
        }
    }

    /* renamed from: a */
    private ButtonCustomization m1094a(ButtonType buttonType) {
        ButtonCustomization buttonCustomization = this.f991a.get(buttonType);
        if (buttonCustomization != null) {
            return buttonCustomization;
        }
        ButtonCustomization buttonCustomization2 = new ButtonCustomization();
        this.f991a.put(buttonType, buttonCustomization2);
        return buttonCustomization2;
    }

    public ButtonCustomization getButtonCustomization(ButtonType buttonType) throws InvalidInputException {
        Preconditions.requireNonNull("buttonType", buttonType);
        return m1094a(buttonType);
    }

    public ExpandableInfoCustomization getExpandableInfoCustomization() {
        return (ExpandableInfoCustomization) m1095a(ExpandableInfoCustomization.class);
    }

    public LabelCustomization getLabelCustomization() {
        return (LabelCustomization) m1095a(LabelCustomization.class);
    }

    public ScreenCustomization getScreenCustomization() {
        return (ScreenCustomization) m1095a(ScreenCustomization.class);
    }

    public SelectionItemCustomization getSelectionItemCustomization() {
        return (SelectionItemCustomization) m1095a(SelectionItemCustomization.class);
    }

    public TextBoxCustomization getTextBoxCustomization() {
        return (TextBoxCustomization) m1095a(TextBoxCustomization.class);
    }

    public ToolbarCustomization getToolbarCustomization() {
        return (ToolbarCustomization) m1095a(ToolbarCustomization.class);
    }

    public void setBorderColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((TextBoxCustomization) m1095a(TextBoxCustomization.class)).setBorderColor(str);
        ((SelectionItemCustomization) m1095a(SelectionItemCustomization.class)).setBorderColor(str);
        ((ExpandableInfoCustomization) m1095a(ExpandableInfoCustomization.class)).setBorderColor(str);
    }

    public void setButtonCustomization(ButtonCustomization buttonCustomization, ButtonType buttonType) throws InvalidInputException {
        Preconditions.requireNonNull("buttonType", buttonType);
        this.f991a.put(buttonType, buttonCustomization);
    }

    public void setExpandableInfoCustomization(ExpandableInfoCustomization expandableInfoCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("expandableInfoCustomization", expandableInfoCustomization);
        this.f992b.put(ExpandableInfoCustomization.class, expandableInfoCustomization);
    }

    public void setHighlightedBackgroundColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((SelectionItemCustomization) m1095a(SelectionItemCustomization.class)).setHighlightedBackgroundColor(str);
        ((ExpandableInfoCustomization) m1095a(ExpandableInfoCustomization.class)).setHighlightedBackgroundColor(str);
        for (ButtonType a : Arrays.asList(new ButtonType[]{ButtonType.CANCEL, ButtonType.RESEND})) {
            m1094a(a).setBackgroundColor(str);
        }
    }

    public void setLabelCustomization(LabelCustomization labelCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("labelCustomization", labelCustomization);
        this.f992b.put(LabelCustomization.class, labelCustomization);
    }

    public void setScreenBackgroundColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((ScreenCustomization) m1095a(ScreenCustomization.class)).setBackgroundColor(str);
    }

    public void setScreenCustomization(ScreenCustomization screenCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("screenCustomization", screenCustomization);
        this.f992b.put(ScreenCustomization.class, screenCustomization);
    }

    public void setSelectionItemCustomization(SelectionItemCustomization selectionItemCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("selectionItemCustomization", selectionItemCustomization);
        this.f992b.put(SelectionItemCustomization.class, selectionItemCustomization);
    }

    public void setStatusBarColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((ScreenCustomization) m1095a(ScreenCustomization.class)).setStatusBarColor(str);
    }

    public void setTextBoxCustomization(TextBoxCustomization textBoxCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("textBoxCustomization", textBoxCustomization);
        this.f992b.put(TextBoxCustomization.class, textBoxCustomization);
    }

    public void setTextColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((ScreenCustomization) m1095a(ScreenCustomization.class)).setTextColor(str);
        ((ToolbarCustomization) m1095a(ToolbarCustomization.class)).setTextColor(str);
        m1094a(ButtonType.CANCEL).setTextColor(str);
        LabelCustomization labelCustomization = (LabelCustomization) m1095a(LabelCustomization.class);
        labelCustomization.setTextColor(str);
        labelCustomization.setHeadingTextColor(str);
        labelCustomization.setInputLabelTextColor(str);
        ((TextBoxCustomization) m1095a(TextBoxCustomization.class)).setTextColor(str);
        ((SelectionItemCustomization) m1095a(SelectionItemCustomization.class)).setTextColor(str);
        ExpandableInfoCustomization expandableInfoCustomization = (ExpandableInfoCustomization) m1095a(ExpandableInfoCustomization.class);
        expandableInfoCustomization.setTextColor(str);
        expandableInfoCustomization.setHeadingTextColor(str);
        expandableInfoCustomization.setExpandStateIndicatorColor(str);
    }

    public void setTintColor(String str) throws InvalidInputException {
        Preconditions.requireNonEmpty("hexColorCode", str);
        ((ToolbarCustomization) m1095a(ToolbarCustomization.class)).setBackgroundColor(str);
        ((SelectionItemCustomization) m1095a(SelectionItemCustomization.class)).setSelectionIndicatorTintColor(str);
        for (ButtonType buttonType : ButtonType.values()) {
            ButtonCustomization a = m1094a(buttonType);
            int i = C1393a.f993a[buttonType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    a.setBackgroundColor(str);
                } else {
                    a.setTextColor(str);
                }
            }
        }
    }

    public void setToolbarCustomization(ToolbarCustomization toolbarCustomization) throws InvalidInputException {
        Preconditions.requireNonNull("toolbarCustomization", toolbarCustomization);
        this.f992b.put(ToolbarCustomization.class, toolbarCustomization);
    }

    public void setToolbarTitle(String str) {
        Preconditions.requireNonEmpty("title", str);
        ((ToolbarCustomization) m1095a(ToolbarCustomization.class)).setHeaderText(str);
    }

    /* renamed from: a */
    private <T extends Customization> T m1095a(Class<T> cls) {
        T t = (Customization) this.f992b.get(cls);
        if (t != null) {
            return t;
        }
        try {
            T t2 = (Customization) cls.newInstance();
            this.f992b.put(cls, t2);
            return t2;
        } catch (InstantiationException e) {
            throw new RuntimeException("Could not instantiate " + cls.getSimpleName(), e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Could not access constructor of " + cls.getSimpleName(), e2);
        }
    }
}
