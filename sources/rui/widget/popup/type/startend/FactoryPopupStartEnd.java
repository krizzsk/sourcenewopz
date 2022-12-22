package rui.widget.popup.type.startend;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.util.List;
import rui.base.BaseViews;
import rui.internal.loopview.LoopView;
import rui.internal.loopview.OnItemSelectedListener;
import rui.util.ViewUtils;
import rui.widget.button.ButtonStyles;
import rui.widget.popup.PopupView;
import rui.widget.popup.base.IPopupFactory;
import rui.widget.popup.base.PopupViews;

public class FactoryPopupStartEnd implements IPopupFactory<PopupStartEnd> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Button f6834a;

    /* renamed from: b */
    private Button f6835b;

    /* renamed from: c */
    private Button f6836c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f6837d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f6838e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f6839f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f6840g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f6841h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LoopView f6842i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LoopView f6843j;

    public void create(PopupView popupView, final PopupStartEnd popupStartEnd) {
        Context context = popupView.getContext();
        this.f6841h = popupStartEnd.defaultTab;
        View createTabTwo = PopupViews.createTabTwo(context, popupStartEnd.startTitle, popupStartEnd.endTitle, true);
        this.f6835b = (Button) createTabTwo.findViewById(R.id.tv_left_tab);
        this.f6836c = (Button) createTabTwo.findViewById(R.id.tv_right_tab);
        createTabTwo.findViewById(R.id.rui_ct_roller_picker_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (popupStartEnd.listener != null) {
                    popupStartEnd.listener.onCloseClicked();
                }
            }
        });
        this.f6835b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FactoryPopupStartEnd.this.f6842i.setItems(popupStartEnd.startDataLeft);
                FactoryPopupStartEnd.this.f6843j.setItems(popupStartEnd.startDataRight);
                FactoryPopupStartEnd.this.selectTab("left");
            }
        });
        this.f6836c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FactoryPopupStartEnd.this.f6842i.setItems(popupStartEnd.endDataLeft);
                FactoryPopupStartEnd.this.f6843j.setItems(popupStartEnd.endDataRight);
                FactoryPopupStartEnd.this.selectTab("right");
            }
        });
        popupView.addView(createTabTwo);
        View createSplit = BaseViews.createSplit(context);
        popupView.addView(createSplit);
        ((ViewGroup.MarginLayoutParams) createSplit.getLayoutParams()).topMargin = (int) ViewUtils.m3859dp(context, 18.0f);
        final View createLoopContainer = PopupViews.createLoopContainer(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.f6842i = PopupViews.createLoopView(context);
        this.f6843j = PopupViews.createLoopView(context);
        C30344 r3 = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    FactoryPopupStartEnd.this.f6834a.setEnabled(false);
                }
                return false;
            }
        };
        this.f6842i.setOnTouchListener(r3);
        this.f6843j.setOnTouchListener(r3);
        this.f6842i.setListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                FactoryPopupStartEnd.this.f6834a.setEnabled(true);
                if ("left".equals(FactoryPopupStartEnd.this.f6841h)) {
                    int unused = FactoryPopupStartEnd.this.f6837d = i;
                } else if ("right".equals(FactoryPopupStartEnd.this.f6841h)) {
                    int unused2 = FactoryPopupStartEnd.this.f6839f = i;
                }
                if (popupStartEnd.listener != null) {
                    popupStartEnd.listener.onUpdate(popupStartEnd.startDataLeft.get(FactoryPopupStartEnd.this.f6837d), popupStartEnd.startDataRight.get(FactoryPopupStartEnd.this.f6838e), popupStartEnd.endDataLeft.get(FactoryPopupStartEnd.this.f6839f), popupStartEnd.endDataRight.get(FactoryPopupStartEnd.this.f6840g));
                }
            }
        });
        this.f6843j.setListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                FactoryPopupStartEnd.this.f6834a.setEnabled(true);
                if ("left".equals(FactoryPopupStartEnd.this.f6841h)) {
                    int unused = FactoryPopupStartEnd.this.f6838e = i;
                } else if ("right".equals(FactoryPopupStartEnd.this.f6841h)) {
                    int unused2 = FactoryPopupStartEnd.this.f6840g = i;
                }
                if (popupStartEnd.listener != null) {
                    popupStartEnd.listener.onUpdate(popupStartEnd.startDataLeft.get(FactoryPopupStartEnd.this.f6837d), popupStartEnd.startDataRight.get(FactoryPopupStartEnd.this.f6838e), popupStartEnd.endDataLeft.get(FactoryPopupStartEnd.this.f6839f), popupStartEnd.endDataRight.get(FactoryPopupStartEnd.this.f6840g));
                }
            }
        });
        m3871a(this.f6841h, popupStartEnd, this.f6842i, this.f6843j);
        this.f6842i.setDecoratorLineLocationListener(new LoopView.DecoratorLineLocationListener() {
            public void onLineLocationChange(int i, int i2) {
                ((ViewGroup.MarginLayoutParams) createLoopContainer.findViewWithTag("split1").getLayoutParams()).topMargin = i;
                ((ViewGroup.MarginLayoutParams) createLoopContainer.findViewWithTag("split2").getLayoutParams()).topMargin = i2;
            }
        });
        ((LinearLayout) createLoopContainer.findViewWithTag("content")).addView(this.f6842i, layoutParams);
        ((LinearLayout) createLoopContainer.findViewWithTag("content")).addView(this.f6843j, layoutParams);
        popupView.addView(createLoopContainer);
        LinearLayout createButtonContainer = PopupViews.createButtonContainer(context);
        Button createButton = BaseViews.createButton(context, TextUtils.isEmpty(popupStartEnd.buttonTitle) ? "确定" : popupStartEnd.buttonTitle, ButtonStyles.BUTTON_MAIN_ORANGE, Integer.MIN_VALUE, (View.OnClickListener) null);
        this.f6834a = createButton;
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (popupStartEnd.listener != null) {
                    popupStartEnd.listener.onConfirm(popupStartEnd.startDataLeft.get(FactoryPopupStartEnd.this.f6837d), popupStartEnd.startDataRight.get(FactoryPopupStartEnd.this.f6838e), popupStartEnd.endDataLeft.get(FactoryPopupStartEnd.this.f6839f), popupStartEnd.endDataRight.get(FactoryPopupStartEnd.this.f6840g));
                }
            }
        });
        createButtonContainer.addView(this.f6834a);
        popupView.addView(createButtonContainer);
        m3872a(popupStartEnd);
        selectTab(this.f6841h);
    }

    public void updateConfirmTitle(String str) {
        Button button = this.f6834a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void selectTab(String str) {
        if ("left".equals(str)) {
            this.f6835b.setSelected(true);
            this.f6836c.setSelected(false);
            this.f6841h = "left";
            this.f6842i.setCurrentPosition(this.f6837d);
            this.f6843j.setCurrentPosition(this.f6838e);
        } else if ("right".equals(str)) {
            this.f6835b.setSelected(false);
            this.f6836c.setSelected(true);
            this.f6841h = "right";
            this.f6842i.setCurrentPosition(this.f6839f);
            this.f6843j.setCurrentPosition(this.f6840g);
        }
    }

    /* renamed from: a */
    private void m3872a(PopupStartEnd popupStartEnd) {
        this.f6837d = m3868a(popupStartEnd.defaultStartLeft, popupStartEnd.startDataLeft);
        this.f6838e = m3868a(popupStartEnd.defaultStartRight, popupStartEnd.startDataRight);
        this.f6839f = m3868a(popupStartEnd.defaultEndLeft, popupStartEnd.endDataLeft);
        this.f6840g = m3868a(popupStartEnd.defaultEndRight, popupStartEnd.endDataRight);
    }

    /* renamed from: a */
    private static int m3868a(String str, List<String> list) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty() && (indexOf = list.indexOf(str)) != -1) {
            return indexOf;
        }
        return 0;
    }

    /* renamed from: a */
    private static void m3871a(String str, PopupStartEnd popupStartEnd, LoopView loopView, LoopView loopView2) {
        List<String> list;
        List<String> list2 = null;
        if ("left".equals(str)) {
            list2 = popupStartEnd.startDataLeft;
            list = popupStartEnd.startDataRight;
        } else if ("right".equals(str)) {
            list2 = popupStartEnd.endDataLeft;
            list = popupStartEnd.endDataRight;
        } else {
            list = null;
        }
        if (list2 != null && list != null) {
            loopView.setItems(list2);
            loopView2.setItems(list);
        }
    }
}
