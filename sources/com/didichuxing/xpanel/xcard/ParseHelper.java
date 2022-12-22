package com.didichuxing.xpanel.xcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.agent.net.XPanelAgentData;
import com.didichuxing.xpanel.log.ImgLoadTracker;
import com.didichuxing.xpanel.util.Utils;
import com.didichuxing.xpanel.xcard.XCardRenderer;
import com.didichuxing.xpanel.xcard.view.Border;
import com.didichuxing.xpanel.xcard.view.Corner;
import com.didichuxing.xpanel.xcard.view.XPanelHorizontalScrollView;
import com.didichuxing.xpanel.xcard.view.XPanelImageView;
import com.didichuxing.xpanel.xcard.view.XPanelProgressBar;
import com.didichuxing.xpanel.xcard.view.XPanelRoundColorDrawable;
import com.didichuxing.xpanel.xcard.view.XPanelRoundDrawable;
import com.didichuxing.xpanel.xcard.view.XPanelTextView;
import com.didichuxing.xpanel.xcard.view.XPanelYogaLayout;
import com.didichuxing.xpanel.xcard.view.recyclerview.XPanelHorizontalRecyclerView;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;
import com.taxis99.R;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlinx.coroutines.DebugKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

@Deprecated
public class ParseHelper {
    public static final String TAG = "ParseHelper";
    public static final String XCARD_VERSION = "1.1.1";

    /* renamed from: a */
    private Context f49598a;

    /* renamed from: b */
    private ViewGroup f49599b = null;

    /* renamed from: c */
    private boolean f49600c = true;

    /* renamed from: d */
    private XmlPullParser f49601d;

    /* renamed from: e */
    private float f49602e;

    /* renamed from: f */
    private IXPanelAgentClickListener f49603f;

    /* renamed from: g */
    private XPanelAgentData f49604g;
    public int mXpanelMargin;

    public ParseHelper(Context context) {
        XCardRenderer.ContextLoader.loadOnce(context);
        this.f49602e = XCardRenderer.ContextLoader.getDensity();
        this.f49598a = context;
        try {
            this.f49601d = XmlPullParserFactory.newInstance().newPullParser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bindAgentClickListener(IXPanelAgentClickListener iXPanelAgentClickListener) {
        this.f49603f = iXPanelAgentClickListener;
    }

    public void setInputStream(String str) {
        try {
            if (this.f49601d != null) {
                this.f49601d.setInput(new ByteArrayInputStream(Base64.decode(str, 0)), "UTF-8");
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    public void setString(String str) {
        try {
            if (this.f49601d != null) {
                this.f49601d.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public View parseXmlToView(XPanelCardDataHelper xPanelCardDataHelper) {
        try {
            int eventType = this.f49601d.getEventType();
            Stack stack = new Stack();
            xPanelCardDataHelper.bindAgentClickListener(this.f49603f);
            m35801a(eventType, (Stack<ViewGroup>) stack, xPanelCardDataHelper);
            return this.f49599b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m35801a(int i, Stack<ViewGroup> stack, XPanelCardDataHelper xPanelCardDataHelper) throws XmlPullParserException, IOException {
        while (i != 1) {
            if (i == 2) {
                if (this.f49600c) {
                    this.f49600c = false;
                    String name = this.f49601d.getName();
                    if (!name.equals("card")) {
                        throw new IllegalArgumentException("xml's tag must start with card ,but now is " + name);
                    }
                }
                XmlPullParser xmlPullParser = this.f49601d;
                m35809a(xmlPullParser, stack, xmlPullParser.getName(), xPanelCardDataHelper);
            } else if (i == 3 && (this.f49601d.getName().equals("card") || this.f49601d.getName().equals("view") || this.f49601d.getName().equals("scrollview") || this.f49601d.getName().equals("scroll"))) {
                ViewGroup pop = stack.pop();
                if (stack.isEmpty()) {
                    this.f49599b = pop;
                } else if (!this.f49601d.getName().equals("scrollview") && !this.f49601d.getName().equals("scroll")) {
                    stack.peek().addView(pop);
                }
            }
            i = this.f49601d.next();
        }
    }

    /* renamed from: a */
    private void m35809a(XmlPullParser xmlPullParser, Stack<ViewGroup> stack, String str, XPanelCardDataHelper xPanelCardDataHelper) {
        YogaNode yogaNode = null;
        ViewGroup peek = !stack.isEmpty() ? stack.peek() : null;
        IParser a = m35799a(str, xmlPullParser, xPanelCardDataHelper);
        if (a != null) {
            if (!(a instanceof XPanelYogaLayout)) {
                if ((a instanceof XPanelHorizontalScrollView) || (a instanceof XPanelHorizontalRecyclerView)) {
                    peek.addView(a.getView());
                    stack.push((ViewGroup) a);
                } else {
                    peek.addView(a.getView());
                }
                if (peek instanceof XPanelYogaLayout) {
                    yogaNode = ((XPanelYogaLayout) peek).getYogaNodeForView(a.getView());
                }
            } else {
                yogaNode = ((XPanelYogaLayout) a).getYogaNode();
                stack.push((ViewGroup) a);
            }
            m35808a(xmlPullParser, a, yogaNode, str, xPanelCardDataHelper);
        }
    }

    /* renamed from: a */
    private IParser m35799a(String str, XmlPullParser xmlPullParser, XPanelCardDataHelper xPanelCardDataHelper) {
        if ("view".equals(str) || "card".equals(str)) {
            XPanelYogaLayout xPanelYogaLayout = new XPanelYogaLayout(this.f49598a);
            if ("card".equals(str)) {
                m35803a((View) xPanelYogaLayout, "", "card", xPanelCardDataHelper);
            }
            return xPanelYogaLayout;
        } else if ("image".equals(str)) {
            if (!TextUtils.isEmpty(xmlPullParser.getAttributeValue((String) null, "url"))) {
                return new XPanelImageView(this.f49598a);
            }
            return null;
        } else if ("label".equals(str)) {
            if (!TextUtils.isEmpty(xmlPullParser.getAttributeValue((String) null, "text"))) {
                return new XPanelTextView(this.f49598a);
            }
            return null;
        } else if ("progressBar".equals(str)) {
            return new XPanelProgressBar(this.f49598a);
        } else {
            if ("scrollview".equals(str)) {
                return new XPanelHorizontalScrollView(this.f49598a);
            }
            if ("scroll".equals(str)) {
                XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView = new XPanelHorizontalRecyclerView(this.f49598a);
                xPanelHorizontalRecyclerView.setParseHelper(this);
                xPanelHorizontalRecyclerView.setCardDataHelper(xPanelCardDataHelper);
                return xPanelHorizontalRecyclerView;
            }
            throw new IllegalArgumentException("Unknown view type: " + str);
        }
    }

    public void setLeftRightMargin(int i) {
        this.mXpanelMargin = i;
    }

    /* renamed from: a */
    private void m35808a(XmlPullParser xmlPullParser, IParser iParser, YogaNode yogaNode, String str, XPanelCardDataHelper xPanelCardDataHelper) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        IParser iParser2 = iParser;
        Corner corner = new Corner();
        Border border = new Border();
        String str2 = "";
        String str3 = str2;
        String str4 = null;
        int i = 0;
        String str5 = null;
        String str6 = null;
        while (i < xmlPullParser.getAttributeCount()) {
            String attributeName = xmlPullParser2.getAttributeName(i);
            String attributeValue = xmlPullParser2.getAttributeValue(i);
            String str7 = attributeValue;
            String str8 = attributeName;
            String str9 = str4;
            int i2 = i;
            String str10 = str2;
            String str11 = str3;
            if (m35810a(attributeName, attributeValue, iParser.getView(), yogaNode, corner, border, str, xPanelCardDataHelper)) {
                YogaNode yogaNode2 = yogaNode;
            } else if ("selectedColor".equals(str8)) {
                YogaNode yogaNode3 = yogaNode;
                str6 = str7;
            } else if ("backgroundColor".equals(str8)) {
                str4 = getRealColorString(str7);
                YogaNode yogaNode4 = yogaNode;
                str2 = str10;
                str3 = str11;
                i = i2 + 1;
            } else if ("url".equals(str8)) {
                YogaNode yogaNode5 = yogaNode;
                str5 = str7;
            } else if ("startColor".equals(str8)) {
                YogaNode yogaNode6 = yogaNode;
                str3 = XPanelProgressBar.getFullColorString(str7);
                str4 = str9;
                str2 = str10;
                i = i2 + 1;
            } else if ("endColor".equals(str8)) {
                YogaNode yogaNode7 = yogaNode;
                str2 = str7;
                str4 = str9;
                str3 = str11;
                i = i2 + 1;
            } else {
                if (iParser2 instanceof XPanelProgressBar) {
                    ((XPanelProgressBar) iParser2).setStartColor(Color.parseColor(str9));
                }
                iParser2.parse(str8, str7, yogaNode);
            }
            str4 = str9;
            str2 = str10;
            str3 = str11;
            i = i2 + 1;
        }
        YogaNode yogaNode8 = yogaNode;
        String str12 = str4;
        String str13 = str2;
        String str14 = str3;
        if (str5 != null) {
            m35807a(str5, (XPanelImageView) iParser.getView(), yogaNode, corner, border);
        } else {
            String str15 = str12;
            if (str15 != null || (!TextUtils.isEmpty(str14) && !TextUtils.isEmpty(str13))) {
                Drawable a = m35798a(corner, str14, str13, str15);
                StateListDrawable stateListDrawable = new StateListDrawable();
                if (str6 != null) {
                    int[] iArr = {16842919};
                    stateListDrawable.addState(iArr, new XPanelRoundColorDrawable(Color.parseColor(str6), corner));
                }
                stateListDrawable.addState(new int[0], a);
                IView iView = (IView) iParser2;
                iView.setBorder(border);
                iView.setCorner(corner);
                if ("default".equals(xmlPullParser2.getAttributeValue((String) null, "shadow"))) {
                    iParser.getView().setBackground(this.f49598a.getResources().getDrawable(R.drawable.oc_x_panel_card_bg));
                } else {
                    iParser.getView().setBackground(stateListDrawable);
                }
            }
        }
        iParser.onParseEnd();
    }

    /* renamed from: a */
    private Drawable m35798a(Corner corner, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new XPanelRoundColorDrawable(Color.parseColor(str3), corner);
        }
        int[] iArr = {getRealColor(str), getRealColor(str2)};
        float[] fArr = {corner.getLeftTopCorner(), corner.getLeftTopCorner(), corner.getRightTopCorner(), corner.getRightTopCorner(), corner.getRightBottomCorner(), corner.getRightBottomCorner(), corner.getLeftBottomCorner(), corner.getLeftBottomCorner()};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    public static String getRealColorString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() == 8) {
            return "#0" + str.substring(1, str.length());
        } else if (str.length() != 2) {
            return str;
        } else {
            return "#0000000" + str.substring(1, str.length());
        }
    }

    public static int getRealColor(String str) {
        try {
            return Color.parseColor(getRealColorString(str));
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private void m35807a(String str, XPanelImageView xPanelImageView, YogaNode yogaNode, Corner corner, Border border) {
        String str2 = str;
        if (this.f49598a != null) {
            final XPanelImageView xPanelImageView2 = xPanelImageView;
            xPanelImageView.setTag(str);
            final Map<String, Object> mapFromAgentData = ImgLoadTracker.getMapFromAgentData(this.f49604g);
            final long currentTimeMillis = System.currentTimeMillis();
            ImgLoadTracker.loadUrlOmega(str, mapFromAgentData);
            final String str3 = str;
            final Corner corner2 = corner;
            final Border border2 = border;
            final YogaNode yogaNode2 = yogaNode;
            Glide.with(this.f49598a).asBitmap().load(str).into(new CustomTarget<Bitmap>() {
                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    if (str3.equals(xPanelImageView2.getTag())) {
                        ImgLoadTracker.loadUrlRetOmega(str3, mapFromAgentData, 0, currentTimeMillis);
                        XPanelRoundDrawable fromBitmap = XPanelRoundDrawable.fromBitmap(bitmap, corner2);
                        fromBitmap.setBorderColor(border2.getBorderColor());
                        fromBitmap.setBorderWidth(border2.getBorderWidth());
                        xPanelImageView2.setImageDrawable(fromBitmap);
                    }
                }

                public void onLoadCleared(Drawable drawable) {
                    ImgLoadTracker.loadUrlRetOmega(str3, mapFromAgentData, 1, currentTimeMillis);
                    yogaNode2.setHeight(0.0f);
                    yogaNode2.setWidth(0.0f);
                    yogaNode2.setMargin(YogaEdge.END, 0.0f);
                    yogaNode2.setMargin(YogaEdge.START, 0.0f);
                    yogaNode2.setMargin(YogaEdge.TOP, 0.0f);
                    yogaNode2.setMargin(YogaEdge.BOTTOM, 0.0f);
                    xPanelImageView2.setVisibility(8);
                }
            });
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m35810a(java.lang.String r4, java.lang.String r5, android.view.View r6, com.facebook.yoga.YogaNode r7, com.didichuxing.xpanel.xcard.view.Corner r8, com.didichuxing.xpanel.xcard.view.Border r9, java.lang.String r10, com.didichuxing.xpanel.xcard.XPanelCardDataHelper r11) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1802976921: goto L_0x0193;
                case -1546463658: goto L_0x0188;
                case -1502084711: goto L_0x017d;
                case -1454606755: goto L_0x0172;
                case -1383228885: goto L_0x0167;
                case -1367605173: goto L_0x015c;
                case -1336101728: goto L_0x0151;
                case -1221029593: goto L_0x0147;
                case -1089145580: goto L_0x013c;
                case -1081309778: goto L_0x0131;
                case -887955139: goto L_0x0126;
                case -806339567: goto L_0x011a;
                case -506906468: goto L_0x010e;
                case -396426912: goto L_0x0102;
                case -278063181: goto L_0x00f6;
                case -80043069: goto L_0x00ea;
                case -62830230: goto L_0x00de;
                case -39712434: goto L_0x00d2;
                case 3355: goto L_0x00c7;
                case 115029: goto L_0x00bb;
                case 3145721: goto L_0x00af;
                case 3317767: goto L_0x00a3;
                case 92909918: goto L_0x0097;
                case 108511772: goto L_0x008b;
                case 113126854: goto L_0x0080;
                case 143541095: goto L_0x0074;
                case 583595847: goto L_0x0068;
                case 593989127: goto L_0x005c;
                case 679766083: goto L_0x0050;
                case 722830999: goto L_0x0044;
                case 741115130: goto L_0x0038;
                case 747804969: goto L_0x002c;
                case 941004998: goto L_0x0021;
                case 1970025654: goto L_0x0016;
                case 2086035242: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x019e
        L_0x000b:
            java.lang.String r0 = "margin-bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 7
            goto L_0x019f
        L_0x0016:
            java.lang.String r0 = "margin-top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 6
            goto L_0x019f
        L_0x0021:
            java.lang.String r0 = "margin-left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 4
            goto L_0x019f
        L_0x002c:
            java.lang.String r0 = "position"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 13
            goto L_0x019f
        L_0x0038:
            java.lang.String r0 = "borderWidth"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 19
            goto L_0x019f
        L_0x0044:
            java.lang.String r0 = "borderColor"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 18
            goto L_0x019f
        L_0x0050:
            java.lang.String r0 = "padding-left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 9
            goto L_0x019f
        L_0x005c:
            java.lang.String r0 = "leftBottomCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 21
            goto L_0x019f
        L_0x0068:
            java.lang.String r0 = "cornerRadius"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 24
            goto L_0x019f
        L_0x0074:
            java.lang.String r0 = "padding-bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 12
            goto L_0x019f
        L_0x0080:
            java.lang.String r0 = "width"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 1
            goto L_0x019f
        L_0x008b:
            java.lang.String r0 = "right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 15
            goto L_0x019f
        L_0x0097:
            java.lang.String r0 = "alpha"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 32
            goto L_0x019f
        L_0x00a3:
            java.lang.String r0 = "left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 14
            goto L_0x019f
        L_0x00af:
            java.lang.String r0 = "flex"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 28
            goto L_0x019f
        L_0x00bb:
            java.lang.String r0 = "top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 16
            goto L_0x019f
        L_0x00c7:
            java.lang.String r0 = "id"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 0
            goto L_0x019f
        L_0x00d2:
            java.lang.String r0 = "rightTopCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 22
            goto L_0x019f
        L_0x00de:
            java.lang.String r0 = "flex-basis"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 27
            goto L_0x019f
        L_0x00ea:
            java.lang.String r0 = "leftTopCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 20
            goto L_0x019f
        L_0x00f6:
            java.lang.String r0 = "outsideMargin"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 34
            goto L_0x019f
        L_0x0102:
            java.lang.String r0 = "padding-right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 10
            goto L_0x019f
        L_0x010e:
            java.lang.String r0 = "rightBottomCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 23
            goto L_0x019f
        L_0x011a:
            java.lang.String r0 = "padding"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 8
            goto L_0x019f
        L_0x0126:
            java.lang.String r0 = "margin-right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 5
            goto L_0x019f
        L_0x0131:
            java.lang.String r0 = "margin"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 3
            goto L_0x019f
        L_0x013c:
            java.lang.String r0 = "align-self"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 31
            goto L_0x019f
        L_0x0147:
            java.lang.String r0 = "height"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 2
            goto L_0x019f
        L_0x0151:
            java.lang.String r0 = "onTouch"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 30
            goto L_0x019f
        L_0x015c:
            java.lang.String r0 = "cardId"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 33
            goto L_0x019f
        L_0x0167:
            java.lang.String r0 = "bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 17
            goto L_0x019f
        L_0x0172:
            java.lang.String r0 = "flex-shrink"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 26
            goto L_0x019f
        L_0x017d:
            java.lang.String r0 = "padding-top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 11
            goto L_0x019f
        L_0x0188:
            java.lang.String r0 = "aspect-ratio"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 29
            goto L_0x019f
        L_0x0193:
            java.lang.String r0 = "flex-grow"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x019e
            r4 = 25
            goto L_0x019f
        L_0x019e:
            r4 = -1
        L_0x019f:
            r0 = 2131428078(0x7f0b02ee, float:1.847779E38)
            switch(r4) {
                case 0: goto L_0x02b3;
                case 1: goto L_0x02af;
                case 2: goto L_0x02ab;
                case 3: goto L_0x02a5;
                case 4: goto L_0x029f;
                case 5: goto L_0x0299;
                case 6: goto L_0x0293;
                case 7: goto L_0x028d;
                case 8: goto L_0x0287;
                case 9: goto L_0x0281;
                case 10: goto L_0x027b;
                case 11: goto L_0x0275;
                case 12: goto L_0x026f;
                case 13: goto L_0x0267;
                case 14: goto L_0x0261;
                case 15: goto L_0x025b;
                case 16: goto L_0x0255;
                case 17: goto L_0x024e;
                case 18: goto L_0x0245;
                case 19: goto L_0x023c;
                case 20: goto L_0x022f;
                case 21: goto L_0x0222;
                case 22: goto L_0x0215;
                case 23: goto L_0x0208;
                case 24: goto L_0x01ff;
                case 25: goto L_0x01f6;
                case 26: goto L_0x01ed;
                case 27: goto L_0x01e4;
                case 28: goto L_0x01db;
                case 29: goto L_0x01d2;
                case 30: goto L_0x01cd;
                case 31: goto L_0x01c4;
                case 32: goto L_0x01bb;
                case 33: goto L_0x01b6;
                case 34: goto L_0x01a6;
                default: goto L_0x01a5;
            }
        L_0x01a5:
            return r2
        L_0x01a6:
            r4 = 2131433102(0x7f0b168e, float:1.848798E38)
            float r5 = r3.m35811b(r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r6.setTag(r4, r5)
            goto L_0x02b6
        L_0x01b6:
            r6.setTag(r0, r5)
            goto L_0x02b6
        L_0x01bb:
            float r4 = java.lang.Float.parseFloat(r5)
            r6.setAlpha(r4)
            goto L_0x02b6
        L_0x01c4:
            com.facebook.yoga.YogaAlign r4 = r3.m35814c(r5)
            r7.setAlignSelf(r4)
            goto L_0x02b6
        L_0x01cd:
            r3.m35803a((android.view.View) r6, (java.lang.String) r5, (java.lang.String) r10, (com.didichuxing.xpanel.xcard.XPanelCardDataHelper) r11)
            goto L_0x02b6
        L_0x01d2:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setAspectRatio(r4)
            goto L_0x02b6
        L_0x01db:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlex(r4)
            goto L_0x02b6
        L_0x01e4:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlexBasis(r4)
            goto L_0x02b6
        L_0x01ed:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlexShrink(r4)
            goto L_0x02b6
        L_0x01f6:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlexGrow(r4)
            goto L_0x02b6
        L_0x01ff:
            float r4 = r3.m35811b(r5)
            r8.setCorners(r4)
            goto L_0x02b6
        L_0x0208:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f49602e
            float r4 = r4 * r5
            r8.setRightBottomCorner(r4)
            goto L_0x02b6
        L_0x0215:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f49602e
            float r4 = r4 * r5
            r8.setRightTopCorner(r4)
            goto L_0x02b6
        L_0x0222:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f49602e
            float r4 = r4 * r5
            r8.setLeftBottomCorner(r4)
            goto L_0x02b6
        L_0x022f:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f49602e
            float r4 = r4 * r5
            r8.setLeftTopCorner(r4)
            goto L_0x02b6
        L_0x023c:
            float r4 = java.lang.Float.parseFloat(r5)
            r9.setBorderWidth(r4)
            goto L_0x02b6
        L_0x0245:
            int r4 = android.graphics.Color.parseColor(r5)
            r9.setBorderColor(r4)
            goto L_0x02b6
        L_0x024e:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.BOTTOM
            r3.m35812b(r4, r7, r5)
            goto L_0x02b6
        L_0x0255:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.TOP
            r3.m35812b(r4, r7, r5)
            goto L_0x02b6
        L_0x025b:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.END
            r3.m35812b(r4, r7, r5)
            goto L_0x02b6
        L_0x0261:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.START
            r3.m35812b(r4, r7, r5)
            goto L_0x02b6
        L_0x0267:
            com.facebook.yoga.YogaPositionType r4 = r3.m35800a(r5)
            r7.setPositionType(r4)
            goto L_0x02b6
        L_0x026f:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.BOTTOM
            r3.m35805a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x02b6
        L_0x0275:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.TOP
            r3.m35805a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x02b6
        L_0x027b:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.END
            r3.m35805a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x02b6
        L_0x0281:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.START
            r3.m35805a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x02b6
        L_0x0287:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.ALL
            r3.m35805a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x02b6
        L_0x028d:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.BOTTOM
            r3.m35804a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x02b6
        L_0x0293:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.TOP
            r3.m35804a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x02b6
        L_0x0299:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.END
            r3.m35804a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x02b6
        L_0x029f:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.START
            r3.m35804a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x02b6
        L_0x02a5:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.ALL
            r3.m35804a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x02b6
        L_0x02ab:
            r3.m35806a(r7, r5)
            goto L_0x02b6
        L_0x02af:
            r3.m35813b(r7, r5)
            goto L_0x02b6
        L_0x02b3:
            r6.setTag(r0, r5)
        L_0x02b6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.xcard.ParseHelper.m35810a(java.lang.String, java.lang.String, android.view.View, com.facebook.yoga.YogaNode, com.didichuxing.xpanel.xcard.view.Corner, com.didichuxing.xpanel.xcard.view.Border, java.lang.String, com.didichuxing.xpanel.xcard.XPanelCardDataHelper):boolean");
    }

    /* renamed from: a */
    private void m35804a(YogaEdge yogaEdge, YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setMarginPercent(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setMargin(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setMargin(yogaEdge, Float.parseFloat(str) * this.f49602e);
        }
    }

    /* renamed from: a */
    private void m35805a(YogaEdge yogaEdge, YogaNode yogaNode, String str, View view) {
        if ((view instanceof XPanelHorizontalRecyclerView) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setPaddingPercent(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            int parseFloat = (int) Float.parseFloat(str.substring(0, str.length() - 2));
            yogaNode.setPadding(yogaEdge, (float) parseFloat);
            m35802a(view, yogaEdge, parseFloat);
        } else {
            int parseFloat2 = (int) (Float.parseFloat(str) * this.f49602e);
            yogaNode.setPadding(yogaEdge, (float) parseFloat2);
            m35802a(view, yogaEdge, parseFloat2);
        }
    }

    /* renamed from: b */
    private void m35812b(YogaEdge yogaEdge, YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setPositionPercent(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setPosition(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setPosition(yogaEdge, Float.parseFloat(str) * this.f49602e);
        }
    }

    /* renamed from: a */
    private void m35802a(View view, YogaEdge yogaEdge, int i) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        switch (C165853.$SwitchMap$com$facebook$yoga$YogaEdge[yogaEdge.ordinal()]) {
            case 1:
                view.setPadding(i, i, i, i);
                return;
            case 2:
            case 3:
                view.setPadding(i, paddingTop, paddingRight, paddingBottom);
                return;
            case 4:
                view.setPadding(paddingLeft, i, paddingRight, paddingBottom);
                return;
            case 5:
            case 6:
                view.setPadding(paddingLeft, paddingTop, i, paddingBottom);
                return;
            case 7:
                view.setPadding(paddingLeft, paddingTop, paddingRight, i);
                return;
            default:
                return;
        }
    }

    /* renamed from: com.didichuxing.xpanel.xcard.ParseHelper$3 */
    static /* synthetic */ class C165853 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaEdge;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.yoga.YogaEdge[] r0 = com.facebook.yoga.YogaEdge.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$yoga$YogaEdge = r0
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.ALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.END     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.RIGHT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.xcard.ParseHelper.C165853.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m35803a(View view, String str, String str2, XPanelCardDataHelper xPanelCardDataHelper) {
        view.setTag(str);
        if (("card".equals(str2) || !TextUtils.isEmpty(str)) && !"scroll".equals(str2)) {
            final XPanelCardDataHelper xPanelCardDataHelper2 = xPanelCardDataHelper;
            final String str3 = str;
            final View view2 = view;
            final String str4 = str2;
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    xPanelCardDataHelper2.onClick(str3);
                    HashMap hashMap = new HashMap();
                    hashMap.put(Const.BUTTON_ID, (String) view2.getTag(R.id.cardId));
                    xPanelCardDataHelper2.clickOmega(str4, hashMap);
                }
            });
        }
    }

    /* renamed from: a */
    private YogaPositionType m35800a(String str) {
        if (TextUtils.isEmpty(str) || !Constants.PATH_TYPE_ABSOLUTE.equals(str)) {
            return YogaPositionType.RELATIVE;
        }
        return YogaPositionType.ABSOLUTE;
    }

    /* renamed from: a */
    private void m35806a(YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setHeightPercent(Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setHeight(Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setHeight((float) ((int) (Float.parseFloat(str) * this.f49602e)));
        }
    }

    /* renamed from: b */
    private void m35813b(YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setWidthPercent(Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setWidth(Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setWidth((float) ((int) (Float.parseFloat(str) * this.f49602e)));
        }
    }

    /* renamed from: b */
    private float m35811b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        if (str.endsWith("px")) {
            return Float.parseFloat(str.substring(0, str.length() - 2));
        }
        return (float) ((int) (Float.parseFloat(str) * this.f49602e));
    }

    public static float getNumValue(Context context, String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        if (str.endsWith("px")) {
            return Float.parseFloat(str.substring(0, str.length() - 2));
        }
        return (float) Utils.dip2px(context, (float) ((int) Float.parseFloat(str)));
    }

    /* renamed from: c */
    private YogaAlign m35814c(String str) {
        if (TextUtils.isEmpty(str)) {
            return YogaAlign.AUTO;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c = 4;
                    break;
                }
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    c = 5;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c = 2;
                    break;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    c = 1;
                    break;
                }
                break;
            case 3005871:
                if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    c = 0;
                    break;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c == 0) {
            return YogaAlign.AUTO;
        }
        if (c == 1) {
            return YogaAlign.FLEX_START;
        }
        if (c == 2) {
            return YogaAlign.CENTER;
        }
        if (c == 3) {
            return YogaAlign.FLEX_END;
        }
        if (c == 4) {
            return YogaAlign.STRETCH;
        }
        if (c != 5) {
            return YogaAlign.AUTO;
        }
        return YogaAlign.BASELINE;
    }

    public void setAgentData(XPanelAgentData xPanelAgentData) {
        this.f49604g = xPanelAgentData;
    }
}
