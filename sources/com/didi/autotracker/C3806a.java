package com.didi.autotracker;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.SwitchCompat;

/* renamed from: com.didi.autotracker.a */
/* compiled from: Utils */
class C3806a {
    C3806a() {
    }

    /* renamed from: a */
    public static String m5812a(View view) {
        try {
            if (view.getId() != -1) {
                return view.getContext().getResources().getResourceEntryName(view.getId());
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m5814b(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof CheckBox) {
            return "CheckBox";
        }
        if (view instanceof SwitchCompat) {
            return "SwitchCompat";
        }
        if (view instanceof RadioButton) {
            return "RadioButton";
        }
        if (view instanceof ToggleButton) {
            return "ToggleButton";
        }
        if (view instanceof Button) {
            return "Button";
        }
        if (view instanceof CheckedTextView) {
            return "CheckedTextView";
        }
        if (view instanceof TextView) {
            return "TextView";
        }
        if (view instanceof ImageButton) {
            return "ImageButton";
        }
        if (view instanceof ImageView) {
            return "ImageView";
        }
        if (view instanceof RatingBar) {
            return "RatingBar";
        }
        if (view instanceof SeekBar) {
            return "SeekBar";
        }
        return null;
    }

    /* renamed from: a */
    public static String m5813a(StringBuilder sb, ViewGroup viewGroup) {
        CharSequence charSequence;
        if (viewGroup == null) {
            try {
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return sb.toString();
            }
        } else {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    if (childAt instanceof ViewGroup) {
                        m5813a(sb, (ViewGroup) childAt);
                    } else {
                        CharSequence charSequence2 = null;
                        if (childAt instanceof CheckBox) {
                            charSequence2 = ((CheckBox) childAt).getText();
                        } else if (childAt instanceof SwitchCompat) {
                            charSequence2 = ((SwitchCompat) childAt).getTextOn();
                        } else if (childAt instanceof RadioButton) {
                            charSequence2 = ((RadioButton) childAt).getText();
                        } else if (childAt instanceof ToggleButton) {
                            ToggleButton toggleButton = (ToggleButton) childAt;
                            if (toggleButton.isChecked()) {
                                charSequence = toggleButton.getTextOn();
                            } else {
                                charSequence = toggleButton.getTextOff();
                            }
                            charSequence2 = charSequence;
                        } else if (childAt instanceof Button) {
                            charSequence2 = ((Button) childAt).getText();
                        } else if (childAt instanceof CheckedTextView) {
                            charSequence2 = ((CheckedTextView) childAt).getText();
                        } else if (childAt instanceof TextView) {
                            charSequence2 = ((TextView) childAt).getText();
                        } else if (childAt instanceof ImageView) {
                            ImageView imageView = (ImageView) childAt;
                            if (!TextUtils.isEmpty(imageView.getContentDescription())) {
                                charSequence2 = imageView.getContentDescription().toString();
                            }
                        }
                        if (!TextUtils.isEmpty(charSequence2)) {
                            sb.append(charSequence2.toString());
                            sb.append("-");
                        }
                    }
                }
            }
            return sb.toString();
        }
    }

    /* renamed from: c */
    public static String m5815c(View view) {
        CharSequence charSequence;
        if (view == null) {
            return null;
        }
        if (view instanceof CheckBox) {
            charSequence = ((CheckBox) view).getText();
        } else if (view instanceof SwitchCompat) {
            charSequence = ((SwitchCompat) view).getTextOn();
        } else if (view instanceof RadioButton) {
            charSequence = ((RadioButton) view).getText();
        } else if (view instanceof ToggleButton) {
            ToggleButton toggleButton = (ToggleButton) view;
            charSequence = toggleButton.isChecked() ? toggleButton.getTextOn() : toggleButton.getTextOff();
        } else if (view instanceof Button) {
            charSequence = ((Button) view).getText();
        } else if (view instanceof CheckedTextView) {
            charSequence = ((CheckedTextView) view).getText();
        } else if (view instanceof TextView) {
            charSequence = ((TextView) view).getText();
        } else if (view instanceof SeekBar) {
            charSequence = String.valueOf(((SeekBar) view).getProgress());
        } else {
            charSequence = view instanceof RatingBar ? String.valueOf(((RatingBar) view).getRating()) : null;
        }
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* renamed from: d */
    public static Activity m5816d(View view) {
        Activity activity;
        if (view == null) {
            return null;
        }
        try {
            Context context = view.getContext();
            if (context == null) {
                return null;
            }
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else if (!(context instanceof ContextWrapper)) {
                return null;
            } else {
                while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
                if (!(context instanceof Activity)) {
                    return null;
                }
                activity = (Activity) context;
            }
            return activity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Activity m5811a(Context context) {
        Activity activity;
        if (context == null) {
            return null;
        }
        try {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else if (!(context instanceof ContextWrapper)) {
                return null;
            } else {
                while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
                if (!(context instanceof Activity)) {
                    return null;
                }
                activity = (Activity) context;
            }
            return activity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
