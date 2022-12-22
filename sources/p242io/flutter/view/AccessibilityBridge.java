package p242io.flutter.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import p242io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import p242io.flutter.util.Predicate;
import p242io.flutter.util.ViewUtils;

/* renamed from: io.flutter.view.AccessibilityBridge */
public class AccessibilityBridge extends AccessibilityNodeProvider {

    /* renamed from: a */
    private static final String f57925a = "AccessibilityBridge";

    /* renamed from: b */
    private static final int f57926b = 16908342;

    /* renamed from: c */
    private static final float f57927c = 100000.0f;

    /* renamed from: d */
    private static final float f57928d = 70000.0f;

    /* renamed from: e */
    private static final int f57929e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final int f57930f = (((Action.SCROLL_RIGHT.value | Action.SCROLL_LEFT.value) | Action.SCROLL_UP.value) | Action.SCROLL_DOWN.value);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final int f57931g = (((((((((((Flag.HAS_CHECKED_STATE.value | Flag.IS_CHECKED.value) | Flag.IS_SELECTED.value) | Flag.IS_TEXT_FIELD.value) | Flag.IS_FOCUSED.value) | Flag.HAS_ENABLED_STATE.value) | Flag.IS_ENABLED.value) | Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.value) | Flag.HAS_TOGGLED_STATE.value) | Flag.IS_TOGGLED.value) | Flag.IS_FOCUSABLE.value) | Flag.IS_SLIDER.value);

    /* renamed from: h */
    private static final int f57932h = 65536;

    /* renamed from: i */
    private static int f57933i = 267386881;

    /* renamed from: A */
    private Integer f57934A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public OnAccessibilityChangeListener f57935B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f57936C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public final AccessibilityChannel.AccessibilityMessageHandler f57937D;

    /* renamed from: E */
    private final AccessibilityManager.AccessibilityStateChangeListener f57938E;

    /* renamed from: F */
    private final AccessibilityManager.TouchExplorationStateChangeListener f57939F;

    /* renamed from: G */
    private final ContentObserver f57940G;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final View f57941j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final AccessibilityChannel f57942k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final AccessibilityManager f57943l;

    /* renamed from: m */
    private final AccessibilityViewEmbedder f57944m;

    /* renamed from: n */
    private final PlatformViewsAccessibilityDelegate f57945n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final ContentResolver f57946o;

    /* renamed from: p */
    private final Map<Integer, SemanticsNode> f57947p;

    /* renamed from: q */
    private final Map<Integer, CustomAccessibilityAction> f57948q;

    /* renamed from: r */
    private SemanticsNode f57949r;

    /* renamed from: s */
    private Integer f57950s;

    /* renamed from: t */
    private Integer f57951t;

    /* renamed from: u */
    private int f57952u;

    /* renamed from: v */
    private SemanticsNode f57953v;

    /* renamed from: w */
    private SemanticsNode f57954w;

    /* renamed from: x */
    private SemanticsNode f57955x;

    /* renamed from: y */
    private final List<Integer> f57956y;

    /* renamed from: z */
    private int f57957z;

    /* renamed from: io.flutter.view.AccessibilityBridge$OnAccessibilityChangeListener */
    public interface OnAccessibilityChangeListener {
        void onAccessibilityChanged(boolean z, boolean z2);
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$StringAttributeType */
    private enum StringAttributeType {
        SPELLOUT,
        LOCALE
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m41721a(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        return semanticsNode2 == semanticsNode;
    }

    /* renamed from: a */
    static /* synthetic */ int m41706a(AccessibilityBridge accessibilityBridge, int i) {
        int i2 = i | accessibilityBridge.f57952u;
        accessibilityBridge.f57952u = i2;
        return i2;
    }

    /* renamed from: b */
    static /* synthetic */ int m41723b(AccessibilityBridge accessibilityBridge, int i) {
        int i2 = i & accessibilityBridge.f57952u;
        accessibilityBridge.f57952u = i2;
        return i2;
    }

    public int getHoveredObjectId() {
        return this.f57955x.f57960id;
    }

    public AccessibilityBridge(View view, AccessibilityChannel accessibilityChannel, AccessibilityManager accessibilityManager, ContentResolver contentResolver, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate) {
        this(view, accessibilityChannel, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), platformViewsAccessibilityDelegate);
    }

    public AccessibilityBridge(View view, AccessibilityChannel accessibilityChannel, final AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate) {
        this.f57947p = new HashMap();
        this.f57948q = new HashMap();
        this.f57952u = 0;
        this.f57956y = new ArrayList();
        this.f57957z = 0;
        this.f57934A = 0;
        this.f57936C = false;
        this.f57937D = new AccessibilityChannel.AccessibilityMessageHandler() {
            public void announce(String str) {
                AccessibilityBridge.this.f57941j.announceForAccessibility(str);
            }

            public void onTap(int i) {
                AccessibilityBridge.this.m41712a(i, 1);
            }

            public void onLongPress(int i) {
                AccessibilityBridge.this.m41712a(i, 2);
            }

            public void onTooltip(String str) {
                if (Build.VERSION.SDK_INT < 28) {
                    AccessibilityEvent b = AccessibilityBridge.this.m41724b(0, 32);
                    b.getText().add(str);
                    AccessibilityBridge.this.m41713a(b);
                }
            }

            public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                AccessibilityBridge.this.mo172929a(byteBuffer, strArr);
            }

            public void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                for (ByteBuffer order : byteBufferArr) {
                    order.order(ByteOrder.LITTLE_ENDIAN);
                }
                AccessibilityBridge.this.mo172930a(byteBuffer, strArr, byteBufferArr);
            }
        };
        this.f57938E = new AccessibilityManager.AccessibilityStateChangeListener() {
            public void onAccessibilityStateChanged(boolean z) {
                if (!AccessibilityBridge.this.f57936C) {
                    if (z) {
                        AccessibilityBridge.this.f57942k.setAccessibilityMessageHandler(AccessibilityBridge.this.f57937D);
                        AccessibilityBridge.this.f57942k.onAndroidAccessibilityEnabled();
                    } else {
                        AccessibilityBridge.this.f57942k.setAccessibilityMessageHandler((AccessibilityChannel.AccessibilityMessageHandler) null);
                        AccessibilityBridge.this.f57942k.onAndroidAccessibilityDisabled();
                    }
                    if (AccessibilityBridge.this.f57935B != null) {
                        AccessibilityBridge.this.f57935B.onAccessibilityChanged(z, AccessibilityBridge.this.f57943l.isTouchExplorationEnabled());
                    }
                }
            }
        };
        this.f57940G = new ContentObserver(new Handler()) {
            public void onChange(boolean z) {
                onChange(z, (Uri) null);
            }

            public void onChange(boolean z, Uri uri) {
                String str;
                if (!AccessibilityBridge.this.f57936C) {
                    if (Build.VERSION.SDK_INT < 17) {
                        str = null;
                    } else {
                        str = Settings.Global.getString(AccessibilityBridge.this.f57946o, "transition_animation_scale");
                    }
                    if (str != null && str.equals("0")) {
                        AccessibilityBridge.m41706a(AccessibilityBridge.this, AccessibilityFeature.DISABLE_ANIMATIONS.value);
                    } else {
                        AccessibilityBridge.m41723b(AccessibilityBridge.this, ~AccessibilityFeature.DISABLE_ANIMATIONS.value);
                    }
                    AccessibilityBridge.this.m41731c();
                }
            }
        };
        this.f57941j = view;
        this.f57942k = accessibilityChannel;
        this.f57943l = accessibilityManager;
        this.f57946o = contentResolver;
        this.f57944m = accessibilityViewEmbedder;
        this.f57945n = platformViewsAccessibilityDelegate;
        this.f57938E.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        this.f57943l.addAccessibilityStateChangeListener(this.f57938E);
        if (Build.VERSION.SDK_INT >= 19) {
            C211764 r4 = new AccessibilityManager.TouchExplorationStateChangeListener() {
                public void onTouchExplorationStateChanged(boolean z) {
                    if (!AccessibilityBridge.this.f57936C) {
                        if (z) {
                            AccessibilityBridge.m41706a(AccessibilityBridge.this, AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
                        } else {
                            AccessibilityBridge.this.m41739e();
                            AccessibilityBridge.m41723b(AccessibilityBridge.this, ~AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
                        }
                        AccessibilityBridge.this.m41731c();
                        if (AccessibilityBridge.this.f57935B != null) {
                            AccessibilityBridge.this.f57935B.onAccessibilityChanged(accessibilityManager.isEnabled(), z);
                        }
                    }
                }
            };
            this.f57939F = r4;
            r4.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
            this.f57943l.addTouchExplorationStateChangeListener(this.f57939F);
        } else {
            this.f57939F = null;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f57940G.onChange(false);
            this.f57946o.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, this.f57940G);
        }
        platformViewsAccessibilityDelegate.attachAccessibilityBridge(this);
    }

    public void release() {
        this.f57936C = true;
        this.f57945n.detachAccessibilityBridge();
        setOnAccessibilityChangeListener((OnAccessibilityChangeListener) null);
        this.f57943l.removeAccessibilityStateChangeListener(this.f57938E);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f57943l.removeTouchExplorationStateChangeListener(this.f57939F);
        }
        this.f57946o.unregisterContentObserver(this.f57940G);
        this.f57942k.setAccessibilityMessageHandler((AccessibilityChannel.AccessibilityMessageHandler) null);
    }

    public boolean isAccessibilityEnabled() {
        return this.f57943l.isEnabled();
    }

    public boolean isTouchExplorationEnabled() {
        return this.f57943l.isTouchExplorationEnabled();
    }

    public void setOnAccessibilityChangeListener(OnAccessibilityChangeListener onAccessibilityChangeListener) {
        this.f57935B = onAccessibilityChangeListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m41731c() {
        this.f57942k.setAccessibilityFeatures(this.f57952u);
    }

    /* renamed from: a */
    private boolean m41718a(SemanticsNode semanticsNode) {
        return semanticsNode.scrollChildren > 0 && (SemanticsNode.nullableHasAncestor(this.f57949r, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: RETURN  
              (wrap: boolean : ?: TERNARYnull = (((wrap: int : 0x0000: INVOKE  (r0v0 int) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1400(io.flutter.view.AccessibilityBridge$SemanticsNode):int type: STATIC) > (0 int) && ((wrap: boolean : 0x000d: INVOKE  (r3v2 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0006: IGET  (r0v1 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.r io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs : 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1500(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC) == true || (wrap: boolean : 0x0017: INVOKE  (r3v5 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0013: IGET  (r3v4 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.r io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg-9GDh2xHRo : 0x0015: SGET  (r0v2 io.flutter.view.-$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg-9GDh2xHRo) =  io.flutter.view.-$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg-9GDh2xHRo.INSTANCE io.flutter.view.-$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg-9GDh2xHRo)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1500(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC) == false))) ? true : false)
             in method: io.flutter.view.AccessibilityBridge.a(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes9.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: TERNARYnull = (((wrap: int : 0x0000: INVOKE  (r0v0 int) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1400(io.flutter.view.AccessibilityBridge$SemanticsNode):int type: STATIC) > (0 int) && ((wrap: boolean : 0x000d: INVOKE  (r3v2 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0006: IGET  (r0v1 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.r io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs : 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1500(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC) == true || (wrap: boolean : 0x0017: INVOKE  (r3v5 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0013: IGET  (r3v4 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.r io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg-9GDh2xHRo : 0x0015: SGET  (r0v2 io.flutter.view.-$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg-9GDh2xHRo) =  io.flutter.view.-$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg-9GDh2xHRo.INSTANCE io.flutter.view.-$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg-9GDh2xHRo)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1500(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC) == false))) ? true : false in method: io.flutter.view.AccessibilityBridge.a(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes9.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:314)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	... 29 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  (r3v2 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0006: IGET  (r0v1 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.r io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs : 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR)
             io.flutter.view.AccessibilityBridge.SemanticsNode.access$1500(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC in method: io.flutter.view.AccessibilityBridge.a(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes9.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:95)
            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:117)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
            	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:84)
            	at jadx.core.codegen.ConditionGen.addAndOr(ConditionGen.java:151)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:70)
            	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:84)
            	at jadx.core.codegen.ConditionGen.addAndOr(ConditionGen.java:151)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:70)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
            	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:948)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:476)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 33 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: ONE_ARG  
              (wrap: boolean : 0x0000: INVOKE  (r0v1 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0006: IGET  (r0v1 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.r io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs : 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR)
             io.flutter.view.AccessibilityBridge.SemanticsNode.nullableHasAncestor(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC)
             in method: io.flutter.view.AccessibilityBridge.a(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes9.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:924)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:684)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 48 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: INVOKE  (r0v1 boolean) = 
              (wrap: io.flutter.view.AccessibilityBridge$SemanticsNode : 0x0006: IGET  (r0v1 io.flutter.view.AccessibilityBridge$SemanticsNode) = (r2v0 'this' io.flutter.view.AccessibilityBridge A[THIS]) io.flutter.view.AccessibilityBridge.r io.flutter.view.AccessibilityBridge$SemanticsNode)
              (wrap: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs : 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR)
             io.flutter.view.AccessibilityBridge.SemanticsNode.nullableHasAncestor(io.flutter.view.AccessibilityBridge$SemanticsNode, io.flutter.util.Predicate):boolean type: STATIC in method: io.flutter.view.AccessibilityBridge.a(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes9.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:98)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:480)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 52 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r1v0 io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs) = 
              (r3v0 'semanticsNode' io.flutter.view.AccessibilityBridge$SemanticsNode)
             call: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs.<init>(io.flutter.view.AccessibilityBridge$SemanticsNode):void type: CONSTRUCTOR in method: io.flutter.view.AccessibilityBridge.a(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean, dex: classes9.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 57 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 63 more
            */
        /*
            this = this;
            int r0 = r3.scrollChildren
            if (r0 <= 0) goto L_0x001f
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r2.f57949r
            io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs r1 = new io.flutter.view.-$$Lambda$AccessibilityBridge$c4AybreYHpSYclKR6u7lx_lpBTs
            r1.<init>(r3)
            boolean r3 = p242io.flutter.view.AccessibilityBridge.SemanticsNode.nullableHasAncestor(r0, r1)
            if (r3 != 0) goto L_0x001d
            io.flutter.view.AccessibilityBridge$SemanticsNode r3 = r2.f57949r
            io.flutter.view.-$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg-9GDh2xHRo r0 = p242io.flutter.view.$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg9GDh2xHRo.INSTANCE
            boolean r3 = p242io.flutter.view.AccessibilityBridge.SemanticsNode.nullableHasAncestor(r3, r0)
            if (r3 != 0) goto L_0x001f
        L_0x001d:
            r3 = 1
            goto L_0x0020
        L_0x001f:
            r3 = 0
        L_0x0020:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.view.AccessibilityBridge.m41718a(io.flutter.view.AccessibilityBridge$SemanticsNode):boolean");
    }

    public AccessibilityNodeInfo obtainAccessibilityNodeInfo(View view, int i) {
        return AccessibilityNodeInfo.obtain(view, i);
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        int i2;
        SemanticsNode semanticsNode;
        if (i >= 65536) {
            return this.f57944m.createAccessibilityNodeInfo(i);
        }
        boolean z = false;
        if (i == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.f57941j);
            this.f57941j.onInitializeAccessibilityNodeInfo(obtain);
            if (this.f57947p.containsKey(0)) {
                obtain.addChild(this.f57941j, 0);
            }
            return obtain;
        }
        SemanticsNode semanticsNode2 = this.f57947p.get(Integer.valueOf(i));
        if (semanticsNode2 == null) {
            return null;
        }
        if (semanticsNode2.platformViewId != -1) {
            View platformViewById = this.f57945n.getPlatformViewById(Integer.valueOf(semanticsNode2.platformViewId));
            if (this.f57945n.usesVirtualDisplay(Integer.valueOf(semanticsNode2.platformViewId))) {
                return this.f57944m.getRootNode(platformViewById, semanticsNode2.f57960id, semanticsNode2.getGlobalRect());
            }
        }
        AccessibilityNodeInfo obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(this.f57941j, i);
        String str = "";
        if (Build.VERSION.SDK_INT >= 18) {
            obtainAccessibilityNodeInfo.setViewIdResourceName(str);
        }
        obtainAccessibilityNodeInfo.setPackageName(this.f57941j.getContext().getPackageName());
        obtainAccessibilityNodeInfo.setClassName("android.view.View");
        obtainAccessibilityNodeInfo.setSource(this.f57941j, i);
        obtainAccessibilityNodeInfo.setFocusable(semanticsNode2.isFocusable());
        SemanticsNode semanticsNode3 = this.f57953v;
        if (semanticsNode3 != null) {
            obtainAccessibilityNodeInfo.setFocused(semanticsNode3.f57960id == i);
        }
        SemanticsNode semanticsNode4 = this.f57949r;
        if (semanticsNode4 != null) {
            obtainAccessibilityNodeInfo.setAccessibilityFocused(semanticsNode4.f57960id == i);
        }
        if (semanticsNode2.hasFlag(Flag.IS_TEXT_FIELD)) {
            obtainAccessibilityNodeInfo.setPassword(semanticsNode2.hasFlag(Flag.IS_OBSCURED));
            if (!semanticsNode2.hasFlag(Flag.IS_READ_ONLY)) {
                obtainAccessibilityNodeInfo.setClassName("android.widget.EditText");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                obtainAccessibilityNodeInfo.setEditable(!semanticsNode2.hasFlag(Flag.IS_READ_ONLY));
                if (!(semanticsNode2.textSelectionBase == -1 || semanticsNode2.textSelectionExtent == -1)) {
                    obtainAccessibilityNodeInfo.setTextSelection(semanticsNode2.textSelectionBase, semanticsNode2.textSelectionExtent);
                }
                if (Build.VERSION.SDK_INT > 18 && (semanticsNode = this.f57949r) != null && semanticsNode.f57960id == i) {
                    obtainAccessibilityNodeInfo.setLiveRegion(1);
                }
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                obtainAccessibilityNodeInfo.addAction(256);
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                obtainAccessibilityNodeInfo.addAction(512);
                i2 |= 1;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                obtainAccessibilityNodeInfo.addAction(256);
                i2 |= 2;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                obtainAccessibilityNodeInfo.addAction(512);
                i2 |= 2;
            }
            obtainAccessibilityNodeInfo.setMovementGranularities(i2);
            if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.maxValueLength >= 0) {
                int length = semanticsNode2.value == null ? 0 : semanticsNode2.value.length();
                int unused = semanticsNode2.currentValueLength;
                int unused2 = semanticsNode2.maxValueLength;
                obtainAccessibilityNodeInfo.setMaxTextLength((length - semanticsNode2.currentValueLength) + semanticsNode2.maxValueLength);
            }
        }
        if (Build.VERSION.SDK_INT > 18) {
            if (semanticsNode2.hasAction(Action.SET_SELECTION)) {
                obtainAccessibilityNodeInfo.addAction(131072);
            }
            if (semanticsNode2.hasAction(Action.COPY)) {
                obtainAccessibilityNodeInfo.addAction(16384);
            }
            if (semanticsNode2.hasAction(Action.CUT)) {
                obtainAccessibilityNodeInfo.addAction(65536);
            }
            if (semanticsNode2.hasAction(Action.PASTE)) {
                obtainAccessibilityNodeInfo.addAction(32768);
            }
        }
        if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.hasAction(Action.SET_TEXT)) {
            obtainAccessibilityNodeInfo.addAction(2097152);
        }
        if (semanticsNode2.hasFlag(Flag.IS_BUTTON) || semanticsNode2.hasFlag(Flag.IS_LINK)) {
            obtainAccessibilityNodeInfo.setClassName("android.widget.Button");
        }
        if (semanticsNode2.hasFlag(Flag.IS_IMAGE)) {
            obtainAccessibilityNodeInfo.setClassName("android.widget.ImageView");
        }
        if (Build.VERSION.SDK_INT > 18 && semanticsNode2.hasAction(Action.DISMISS)) {
            obtainAccessibilityNodeInfo.setDismissable(true);
            obtainAccessibilityNodeInfo.addAction(1048576);
        }
        if (semanticsNode2.parent != null) {
            obtainAccessibilityNodeInfo.setParent(this.f57941j, semanticsNode2.parent.f57960id);
        } else {
            obtainAccessibilityNodeInfo.setParent(this.f57941j);
        }
        if (semanticsNode2.previousNodeId != -1 && Build.VERSION.SDK_INT >= 22) {
            obtainAccessibilityNodeInfo.setTraversalAfter(this.f57941j, semanticsNode2.previousNodeId);
        }
        Rect access$1700 = semanticsNode2.getGlobalRect();
        if (semanticsNode2.parent != null) {
            Rect access$17002 = semanticsNode2.parent.getGlobalRect();
            Rect rect = new Rect(access$1700);
            rect.offset(-access$17002.left, -access$17002.top);
            obtainAccessibilityNodeInfo.setBoundsInParent(rect);
        } else {
            obtainAccessibilityNodeInfo.setBoundsInParent(access$1700);
        }
        obtainAccessibilityNodeInfo.setBoundsInScreen(m41707a(access$1700));
        obtainAccessibilityNodeInfo.setVisibleToUser(true);
        obtainAccessibilityNodeInfo.setEnabled(!semanticsNode2.hasFlag(Flag.HAS_ENABLED_STATE) || semanticsNode2.hasFlag(Flag.IS_ENABLED));
        if (semanticsNode2.hasAction(Action.TAP)) {
            if (Build.VERSION.SDK_INT < 21 || semanticsNode2.onTapOverride == null) {
                obtainAccessibilityNodeInfo.addAction(16);
                obtainAccessibilityNodeInfo.setClickable(true);
            } else {
                obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, semanticsNode2.onTapOverride.hint));
                obtainAccessibilityNodeInfo.setClickable(true);
            }
        }
        if (semanticsNode2.hasAction(Action.LONG_PRESS)) {
            if (Build.VERSION.SDK_INT < 21 || semanticsNode2.onLongPressOverride == null) {
                obtainAccessibilityNodeInfo.addAction(32);
                obtainAccessibilityNodeInfo.setLongClickable(true);
            } else {
                obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, semanticsNode2.onLongPressOverride.hint));
                obtainAccessibilityNodeInfo.setLongClickable(true);
            }
        }
        if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_UP) || semanticsNode2.hasAction(Action.SCROLL_RIGHT) || semanticsNode2.hasAction(Action.SCROLL_DOWN)) {
            obtainAccessibilityNodeInfo.setScrollable(true);
            if (semanticsNode2.hasFlag(Flag.HAS_IMPLICIT_SCROLLING)) {
                if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_RIGHT)) {
                    if (Build.VERSION.SDK_INT <= 19 || !m41718a(semanticsNode2)) {
                        obtainAccessibilityNodeInfo.setClassName("android.widget.HorizontalScrollView");
                    } else {
                        obtainAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, semanticsNode2.scrollChildren, false));
                    }
                } else if (Build.VERSION.SDK_INT <= 18 || !m41718a(semanticsNode2)) {
                    obtainAccessibilityNodeInfo.setClassName("android.widget.ScrollView");
                } else {
                    obtainAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(semanticsNode2.scrollChildren, 0, false));
                }
            }
            if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_UP)) {
                obtainAccessibilityNodeInfo.addAction(4096);
            }
            if (semanticsNode2.hasAction(Action.SCROLL_RIGHT) || semanticsNode2.hasAction(Action.SCROLL_DOWN)) {
                obtainAccessibilityNodeInfo.addAction(8192);
            }
        }
        if (semanticsNode2.hasAction(Action.INCREASE) || semanticsNode2.hasAction(Action.DECREASE)) {
            obtainAccessibilityNodeInfo.setClassName("android.widget.SeekBar");
            if (semanticsNode2.hasAction(Action.INCREASE)) {
                obtainAccessibilityNodeInfo.addAction(4096);
            }
            if (semanticsNode2.hasAction(Action.DECREASE)) {
                obtainAccessibilityNodeInfo.addAction(8192);
            }
        }
        if (semanticsNode2.hasFlag(Flag.IS_LIVE_REGION) && Build.VERSION.SDK_INT > 18) {
            obtainAccessibilityNodeInfo.setLiveRegion(1);
        }
        if (semanticsNode2.hasFlag(Flag.IS_TEXT_FIELD)) {
            obtainAccessibilityNodeInfo.setText(semanticsNode2.getValueLabelHint());
        } else if (!semanticsNode2.hasFlag(Flag.SCOPES_ROUTE)) {
            CharSequence access$3100 = semanticsNode2.getValueLabelHint();
            String str2 = access$3100;
            if (Build.VERSION.SDK_INT < 28) {
                str2 = access$3100;
                if (semanticsNode2.tooltip != null) {
                    if (access$3100 != null) {
                        str = access$3100;
                    }
                    str2 = str + "\n" + semanticsNode2.tooltip;
                }
            }
            if (str2 != null) {
                obtainAccessibilityNodeInfo.setContentDescription(str2);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && semanticsNode2.tooltip != null) {
            obtainAccessibilityNodeInfo.setTooltipText(semanticsNode2.tooltip);
        }
        boolean access$1900 = semanticsNode2.hasFlag(Flag.HAS_CHECKED_STATE);
        boolean access$19002 = semanticsNode2.hasFlag(Flag.HAS_TOGGLED_STATE);
        if (access$1900 || access$19002) {
            z = true;
        }
        obtainAccessibilityNodeInfo.setCheckable(z);
        if (access$1900) {
            obtainAccessibilityNodeInfo.setChecked(semanticsNode2.hasFlag(Flag.IS_CHECKED));
            if (semanticsNode2.hasFlag(Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
                obtainAccessibilityNodeInfo.setClassName("android.widget.RadioButton");
            } else {
                obtainAccessibilityNodeInfo.setClassName("android.widget.CheckBox");
            }
        } else if (access$19002) {
            obtainAccessibilityNodeInfo.setChecked(semanticsNode2.hasFlag(Flag.IS_TOGGLED));
            obtainAccessibilityNodeInfo.setClassName("android.widget.Switch");
        }
        obtainAccessibilityNodeInfo.setSelected(semanticsNode2.hasFlag(Flag.IS_SELECTED));
        if (Build.VERSION.SDK_INT >= 28) {
            obtainAccessibilityNodeInfo.setHeading(semanticsNode2.hasFlag(Flag.IS_HEADER));
        }
        SemanticsNode semanticsNode5 = this.f57949r;
        if (semanticsNode5 == null || semanticsNode5.f57960id != i) {
            obtainAccessibilityNodeInfo.addAction(64);
        } else {
            obtainAccessibilityNodeInfo.addAction(128);
        }
        if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.customAccessibilityActions != null) {
            for (CustomAccessibilityAction customAccessibilityAction : semanticsNode2.customAccessibilityActions) {
                obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(customAccessibilityAction.resourceId, customAccessibilityAction.label));
            }
        }
        for (SemanticsNode semanticsNode6 : semanticsNode2.childrenInTraversalOrder) {
            if (!semanticsNode6.hasFlag(Flag.IS_HIDDEN)) {
                if (semanticsNode6.platformViewId != -1) {
                    View platformViewById2 = this.f57945n.getPlatformViewById(Integer.valueOf(semanticsNode6.platformViewId));
                    if (!this.f57945n.usesVirtualDisplay(Integer.valueOf(semanticsNode6.platformViewId))) {
                        obtainAccessibilityNodeInfo.addChild(platformViewById2);
                    }
                }
                obtainAccessibilityNodeInfo.addChild(this.f57941j, semanticsNode6.f57960id);
            }
        }
        return obtainAccessibilityNodeInfo;
    }

    /* renamed from: a */
    private Rect m41707a(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.f57941j.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        if (i >= 65536) {
            boolean performAction = this.f57944m.performAction(i, i2, bundle);
            if (performAction && i2 == 128) {
                this.f57950s = null;
            }
            return performAction;
        }
        SemanticsNode semanticsNode = this.f57947p.get(Integer.valueOf(i));
        boolean z = false;
        if (semanticsNode == null) {
            return false;
        }
        switch (i2) {
            case 16:
                this.f57942k.dispatchSemanticsAction(i, Action.TAP);
                return true;
            case 32:
                this.f57942k.dispatchSemanticsAction(i, Action.LONG_PRESS);
                return true;
            case 64:
                if (this.f57949r == null) {
                    this.f57941j.invalidate();
                }
                this.f57949r = semanticsNode;
                this.f57942k.dispatchSemanticsAction(i, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
                m41712a(i, 32768);
                if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                    m41712a(i, 4);
                }
                return true;
            case 128:
                SemanticsNode semanticsNode2 = this.f57949r;
                if (semanticsNode2 != null && semanticsNode2.f57960id == i) {
                    this.f57949r = null;
                }
                Integer num = this.f57950s;
                if (num != null && num.intValue() == i) {
                    this.f57950s = null;
                }
                this.f57942k.dispatchSemanticsAction(i, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
                m41712a(i, 65536);
                return true;
            case 256:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return m41720a(semanticsNode, i, bundle, true);
            case 512:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return m41720a(semanticsNode, i, bundle, false);
            case 4096:
                if (semanticsNode.hasAction(Action.SCROLL_UP)) {
                    this.f57942k.dispatchSemanticsAction(i, Action.SCROLL_UP);
                } else if (semanticsNode.hasAction(Action.SCROLL_LEFT)) {
                    this.f57942k.dispatchSemanticsAction(i, Action.SCROLL_LEFT);
                } else if (!semanticsNode.hasAction(Action.INCREASE)) {
                    return false;
                } else {
                    String unused = semanticsNode.value = semanticsNode.increasedValue;
                    List unused2 = semanticsNode.valueAttributes = semanticsNode.increasedValueAttributes;
                    m41712a(i, 4);
                    this.f57942k.dispatchSemanticsAction(i, Action.INCREASE);
                }
                return true;
            case 8192:
                if (semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                    this.f57942k.dispatchSemanticsAction(i, Action.SCROLL_DOWN);
                } else if (semanticsNode.hasAction(Action.SCROLL_RIGHT)) {
                    this.f57942k.dispatchSemanticsAction(i, Action.SCROLL_RIGHT);
                } else if (!semanticsNode.hasAction(Action.DECREASE)) {
                    return false;
                } else {
                    String unused3 = semanticsNode.value = semanticsNode.decreasedValue;
                    List unused4 = semanticsNode.valueAttributes = semanticsNode.decreasedValueAttributes;
                    m41712a(i, 4);
                    this.f57942k.dispatchSemanticsAction(i, Action.DECREASE);
                }
                return true;
            case 16384:
                this.f57942k.dispatchSemanticsAction(i, Action.COPY);
                return true;
            case 32768:
                this.f57942k.dispatchSemanticsAction(i, Action.PASTE);
                return true;
            case 65536:
                this.f57942k.dispatchSemanticsAction(i, Action.CUT);
                return true;
            case 131072:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT) && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)) {
                    z = true;
                }
                if (z) {
                    hashMap.put("base", Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT)));
                    hashMap.put("extent", Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)));
                } else {
                    hashMap.put("base", Integer.valueOf(semanticsNode.textSelectionExtent));
                    hashMap.put("extent", Integer.valueOf(semanticsNode.textSelectionExtent));
                }
                this.f57942k.dispatchSemanticsAction(i, Action.SET_SELECTION, hashMap);
                SemanticsNode semanticsNode3 = this.f57947p.get(Integer.valueOf(i));
                int unused5 = semanticsNode3.textSelectionBase = ((Integer) hashMap.get("base")).intValue();
                int unused6 = semanticsNode3.textSelectionExtent = ((Integer) hashMap.get("extent")).intValue();
                return true;
            case 1048576:
                this.f57942k.dispatchSemanticsAction(i, Action.DISMISS);
                return true;
            case 2097152:
                if (Build.VERSION.SDK_INT < 21) {
                    return false;
                }
                return m41719a(semanticsNode, i, bundle);
            case f57926b /*16908342*/:
                this.f57942k.dispatchSemanticsAction(i, Action.SHOW_ON_SCREEN);
                return true;
            default:
                CustomAccessibilityAction customAccessibilityAction = this.f57948q.get(Integer.valueOf(i2 - f57933i));
                if (customAccessibilityAction == null) {
                    return false;
                }
                this.f57942k.dispatchSemanticsAction(i, Action.CUSTOM_ACTION, Integer.valueOf(customAccessibilityAction.f57959id));
                return true;
        }
    }

    /* renamed from: a */
    private boolean m41720a(SemanticsNode semanticsNode, int i, Bundle bundle, boolean z) {
        int i2 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
        boolean z2 = bundle.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
        int access$2000 = semanticsNode.textSelectionBase;
        int access$2100 = semanticsNode.textSelectionExtent;
        m41714a(semanticsNode, i2, z, z2);
        if (!(access$2000 == semanticsNode.textSelectionBase && access$2100 == semanticsNode.textSelectionExtent)) {
            String access$2400 = semanticsNode.value != null ? semanticsNode.value : "";
            AccessibilityEvent b = m41724b(semanticsNode.f57960id, 8192);
            b.getText().add(access$2400);
            b.setFromIndex(semanticsNode.textSelectionBase);
            b.setToIndex(semanticsNode.textSelectionExtent);
            b.setItemCount(access$2400.length());
            m41713a(b);
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 4 || i2 == 8 || i2 == 16) {
                    return true;
                }
                return false;
            } else if (z && semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                this.f57942k.dispatchSemanticsAction(i, Action.MOVE_CURSOR_FORWARD_BY_WORD, Boolean.valueOf(z2));
                return true;
            } else if (z || !semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                return false;
            } else {
                this.f57942k.dispatchSemanticsAction(i, Action.MOVE_CURSOR_BACKWARD_BY_WORD, Boolean.valueOf(z2));
                return true;
            }
        } else if (z && semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
            this.f57942k.dispatchSemanticsAction(i, Action.MOVE_CURSOR_FORWARD_BY_CHARACTER, Boolean.valueOf(z2));
            return true;
        } else if (z || !semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
            return false;
        } else {
            this.f57942k.dispatchSemanticsAction(i, Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER, Boolean.valueOf(z2));
            return true;
        }
    }

    /* renamed from: a */
    private void m41714a(SemanticsNode semanticsNode, int i, boolean z, boolean z2) {
        if (semanticsNode.textSelectionExtent >= 0 && semanticsNode.textSelectionBase >= 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i == 8 || i == 16) {
                            if (z) {
                                int unused = semanticsNode.textSelectionExtent = semanticsNode.value.length();
                            } else {
                                int unused2 = semanticsNode.textSelectionExtent = 0;
                            }
                        }
                    } else if (z && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                        Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(semanticsNode.value.substring(semanticsNode.textSelectionExtent));
                        if (matcher.find()) {
                            SemanticsNode.access$2112(semanticsNode, matcher.start(1));
                        } else {
                            int unused3 = semanticsNode.textSelectionExtent = semanticsNode.value.length();
                        }
                    } else if (!z && semanticsNode.textSelectionExtent > 0) {
                        Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(semanticsNode.value.substring(0, semanticsNode.textSelectionExtent));
                        if (matcher2.find()) {
                            int unused4 = semanticsNode.textSelectionExtent = matcher2.start(1);
                        } else {
                            int unused5 = semanticsNode.textSelectionExtent = 0;
                        }
                    }
                } else if (z && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                    Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(semanticsNode.value.substring(semanticsNode.textSelectionExtent));
                    matcher3.find();
                    if (matcher3.find()) {
                        SemanticsNode.access$2112(semanticsNode, matcher3.start(1));
                    } else {
                        int unused6 = semanticsNode.textSelectionExtent = semanticsNode.value.length();
                    }
                } else if (!z && semanticsNode.textSelectionExtent > 0) {
                    Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(semanticsNode.value.substring(0, semanticsNode.textSelectionExtent));
                    if (matcher4.find()) {
                        int unused7 = semanticsNode.textSelectionExtent = matcher4.start(1);
                    }
                }
            } else if (z && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                SemanticsNode.access$2112(semanticsNode, 1);
            } else if (!z && semanticsNode.textSelectionExtent > 0) {
                SemanticsNode.access$2120(semanticsNode, 1);
            }
            if (!z2) {
                int unused8 = semanticsNode.textSelectionBase = semanticsNode.textSelectionExtent;
            }
        }
    }

    /* renamed from: a */
    private boolean m41719a(SemanticsNode semanticsNode, int i, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE)) ? "" : bundle.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE);
        this.f57942k.dispatchSemanticsAction(i, Action.SET_TEXT, string);
        String unused = semanticsNode.value = string;
        return true;
    }

    public AccessibilityNodeInfo findFocus(int i) {
        if (i == 1) {
            SemanticsNode semanticsNode = this.f57953v;
            if (semanticsNode != null) {
                return createAccessibilityNodeInfo(semanticsNode.f57960id);
            }
            Integer num = this.f57951t;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (i != 2) {
            return null;
        }
        SemanticsNode semanticsNode2 = this.f57949r;
        if (semanticsNode2 != null) {
            return createAccessibilityNodeInfo(semanticsNode2.f57960id);
        }
        Integer num2 = this.f57950s;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    /* renamed from: d */
    private SemanticsNode m41736d() {
        return this.f57947p.get(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public SemanticsNode m41710a(int i) {
        SemanticsNode semanticsNode = this.f57947p.get(Integer.valueOf(i));
        if (semanticsNode != null) {
            return semanticsNode;
        }
        SemanticsNode semanticsNode2 = new SemanticsNode(this);
        int unused = semanticsNode2.f57960id = i;
        this.f57947p.put(Integer.valueOf(i), semanticsNode2);
        return semanticsNode2;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public CustomAccessibilityAction m41726b(int i) {
        CustomAccessibilityAction customAccessibilityAction = this.f57948q.get(Integer.valueOf(i));
        if (customAccessibilityAction != null) {
            return customAccessibilityAction;
        }
        CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction();
        int unused = customAccessibilityAction2.f57959id = i;
        int unused2 = customAccessibilityAction2.resourceId = f57933i + i;
        this.f57948q.put(Integer.valueOf(i), customAccessibilityAction2);
        return customAccessibilityAction2;
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent) {
        if (!this.f57943l.isTouchExplorationEnabled() || this.f57947p.isEmpty()) {
            return false;
        }
        SemanticsNode access$4300 = m41736d().hitTest(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f});
        if (access$4300 != null && access$4300.platformViewId != -1) {
            return this.f57944m.onAccessibilityHoverEvent(access$4300.f57960id, motionEvent);
        }
        if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
            m41711a(motionEvent.getX(), motionEvent.getY());
        } else if (motionEvent.getAction() == 10) {
            m41739e();
        } else {
            Log.m41134d("flutter", "unexpected accessibility hover event: " + motionEvent);
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m41739e() {
        SemanticsNode semanticsNode = this.f57955x;
        if (semanticsNode != null) {
            m41712a(semanticsNode.f57960id, 256);
            this.f57955x = null;
        }
    }

    /* renamed from: a */
    private void m41711a(float f, float f2) {
        SemanticsNode access$4300;
        if (!this.f57947p.isEmpty() && (access$4300 = m41736d().hitTest(new float[]{f, f2, 0.0f, 1.0f})) != this.f57955x) {
            if (access$4300 != null) {
                m41712a(access$4300.f57960id, 128);
            }
            SemanticsNode semanticsNode = this.f57955x;
            if (semanticsNode != null) {
                m41712a(semanticsNode.f57960id, 256);
            }
            this.f57955x = access$4300;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172929a(ByteBuffer byteBuffer, String[] strArr) {
        String str;
        while (byteBuffer.hasRemaining()) {
            CustomAccessibilityAction b = m41726b(byteBuffer.getInt());
            int unused = b.overrideId = byteBuffer.getInt();
            int i = byteBuffer.getInt();
            String str2 = null;
            if (i == -1) {
                str = null;
            } else {
                str = strArr[i];
            }
            String unused2 = b.label = str;
            int i2 = byteBuffer.getInt();
            if (i2 != -1) {
                str2 = strArr[i2];
            }
            String unused3 = b.hint = str2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: io.flutter.view.AccessibilityBridge$SemanticsNode} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo172930a(java.nio.ByteBuffer r9, java.lang.String[] r10, java.nio.ByteBuffer[] r11) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0005:
            boolean r1 = r9.hasRemaining()
            r2 = 0
            if (r1 == 0) goto L_0x005e
            int r1 = r9.getInt()
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r8.m41710a((int) r1)
            r1.updateWith(r9, r10, r11)
            io.flutter.view.AccessibilityBridge$Flag r3 = p242io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r3 = r1.hasFlag(r3)
            if (r3 == 0) goto L_0x0020
            goto L_0x0005
        L_0x0020:
            io.flutter.view.AccessibilityBridge$Flag r3 = p242io.flutter.view.AccessibilityBridge.Flag.IS_FOCUSED
            boolean r3 = r1.hasFlag(r3)
            if (r3 == 0) goto L_0x002a
            r8.f57953v = r1
        L_0x002a:
            boolean r3 = r1.hadPreviousConfig
            if (r3 == 0) goto L_0x0033
            r0.add(r1)
        L_0x0033:
            int r3 = r1.platformViewId
            r4 = -1
            if (r3 == r4) goto L_0x0005
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r3 = r8.f57945n
            int r4 = r1.platformViewId
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r3 = r3.usesVirtualDisplay(r4)
            if (r3 != 0) goto L_0x0005
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r3 = r8.f57945n
            int r1 = r1.platformViewId
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            android.view.View r1 = r3.getPlatformViewById(r1)
            if (r1 == 0) goto L_0x0005
            r1.setImportantForAccessibility(r2)
            goto L_0x0005
        L_0x005e:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            io.flutter.view.AccessibilityBridge$SemanticsNode r10 = r8.m41736d()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r1 = 1
            if (r10 == 0) goto L_0x00c1
            r3 = 16
            float[] r3 = new float[r3]
            android.opengl.Matrix.setIdentityM(r3, r2)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x00bb
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r4 < r5) goto L_0x0087
            boolean r4 = r8.m41741f()
            goto L_0x0088
        L_0x0087:
            r4 = 1
        L_0x0088:
            if (r4 == 0) goto L_0x00bb
            android.view.View r4 = r8.f57941j
            android.view.WindowInsets r4 = r4.getRootWindowInsets()
            if (r4 == 0) goto L_0x00bb
            java.lang.Integer r5 = r8.f57934A
            int r6 = r4.getSystemWindowInsetLeft()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00a8
            boolean unused = r10.globalGeometryDirty = r1
            boolean unused = r10.inverseTransformDirty = r1
        L_0x00a8:
            int r4 = r4.getSystemWindowInsetLeft()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r8.f57934A = r4
            int r4 = r4.intValue()
            float r4 = (float) r4
            r5 = 0
            android.opengl.Matrix.translateM(r3, r2, r4, r5, r5)
        L_0x00bb:
            r10.updateRecursively(r3, r9, r2)
            r10.collectRoutes(r11)
        L_0x00c1:
            java.util.Iterator r10 = r11.iterator()
            r3 = 0
            r4 = r3
        L_0x00c7:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L_0x00e5
            java.lang.Object r5 = r10.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r5 = (p242io.flutter.view.AccessibilityBridge.SemanticsNode) r5
            java.util.List<java.lang.Integer> r6 = r8.f57956y
            int r7 = r5.f57960id
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x00c7
            r4 = r5
            goto L_0x00c7
        L_0x00e5:
            if (r4 != 0) goto L_0x00f9
            int r10 = r11.size()
            if (r10 <= 0) goto L_0x00f9
            int r10 = r11.size()
            int r10 = r10 - r1
            java.lang.Object r10 = r11.get(r10)
            r4 = r10
            io.flutter.view.AccessibilityBridge$SemanticsNode r4 = (p242io.flutter.view.AccessibilityBridge.SemanticsNode) r4
        L_0x00f9:
            if (r4 == 0) goto L_0x0118
            int r10 = r4.f57960id
            int r5 = r8.f57957z
            if (r10 != r5) goto L_0x010f
            int r10 = r11.size()
            java.util.List<java.lang.Integer> r5 = r8.f57956y
            int r5 = r5.size()
            if (r10 == r5) goto L_0x0118
        L_0x010f:
            int r10 = r4.f57960id
            r8.f57957z = r10
            r8.m41727b((p242io.flutter.view.AccessibilityBridge.SemanticsNode) r4)
        L_0x0118:
            java.util.List<java.lang.Integer> r10 = r8.f57956y
            r10.clear()
            java.util.Iterator r10 = r11.iterator()
        L_0x0121:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x013b
            java.lang.Object r11 = r10.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (p242io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            java.util.List<java.lang.Integer> r4 = r8.f57956y
            int r11 = r11.f57960id
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r4.add(r11)
            goto L_0x0121
        L_0x013b:
            java.util.Map<java.lang.Integer, io.flutter.view.AccessibilityBridge$SemanticsNode> r10 = r8.f57947p
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0145:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0164
            java.lang.Object r11 = r10.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r11 = r11.getValue()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (p242io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            boolean r4 = r9.contains(r11)
            if (r4 != 0) goto L_0x0145
            r8.m41733c((p242io.flutter.view.AccessibilityBridge.SemanticsNode) r11)
            r10.remove()
            goto L_0x0145
        L_0x0164:
            r8.m41732c((int) r2)
            java.util.Iterator r9 = r0.iterator()
        L_0x016b:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x034e
            java.lang.Object r10 = r9.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r10 = (p242io.flutter.view.AccessibilityBridge.SemanticsNode) r10
            boolean r11 = r10.didScroll()
            if (r11 == 0) goto L_0x023c
            int r11 = r10.f57960id
            r0 = 4096(0x1000, float:5.74E-42)
            android.view.accessibility.AccessibilityEvent r11 = r8.m41724b((int) r11, (int) r0)
            float r0 = r10.scrollPosition
            float r4 = r10.scrollExtentMax
            float r5 = r10.scrollExtentMax
            boolean r5 = java.lang.Float.isInfinite(r5)
            r6 = 1200142336(0x4788b800, float:70000.0)
            r7 = 1203982336(0x47c35000, float:100000.0)
            if (r5 == 0) goto L_0x01a9
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x01a6
            r0 = 1200142336(0x4788b800, float:70000.0)
        L_0x01a6:
            r4 = 1203982336(0x47c35000, float:100000.0)
        L_0x01a9:
            float r5 = r10.scrollExtentMin
            boolean r5 = java.lang.Float.isInfinite(r5)
            if (r5 == 0) goto L_0x01c0
            float r4 = r4 + r7
            r5 = -947341312(0xffffffffc788b800, float:-70000.0)
            int r6 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r6 >= 0) goto L_0x01be
            r0 = -947341312(0xffffffffc788b800, float:-70000.0)
        L_0x01be:
            float r0 = r0 + r7
            goto L_0x01ca
        L_0x01c0:
            float r5 = r10.scrollExtentMin
            float r4 = r4 - r5
            float r5 = r10.scrollExtentMin
            float r0 = r0 - r5
        L_0x01ca:
            io.flutter.view.AccessibilityBridge$Action r5 = p242io.flutter.view.AccessibilityBridge.Action.SCROLL_UP
            boolean r5 = r10.hadAction(r5)
            if (r5 != 0) goto L_0x01f4
            io.flutter.view.AccessibilityBridge$Action r5 = p242io.flutter.view.AccessibilityBridge.Action.SCROLL_DOWN
            boolean r5 = r10.hadAction(r5)
            if (r5 == 0) goto L_0x01db
            goto L_0x01f4
        L_0x01db:
            io.flutter.view.AccessibilityBridge$Action r5 = p242io.flutter.view.AccessibilityBridge.Action.SCROLL_LEFT
            boolean r5 = r10.hadAction(r5)
            if (r5 != 0) goto L_0x01eb
            io.flutter.view.AccessibilityBridge$Action r5 = p242io.flutter.view.AccessibilityBridge.Action.SCROLL_RIGHT
            boolean r5 = r10.hadAction(r5)
            if (r5 == 0) goto L_0x01fc
        L_0x01eb:
            int r0 = (int) r0
            r11.setScrollX(r0)
            int r0 = (int) r4
            r11.setMaxScrollX(r0)
            goto L_0x01fc
        L_0x01f4:
            int r0 = (int) r0
            r11.setScrollY(r0)
            int r0 = (int) r4
            r11.setMaxScrollY(r0)
        L_0x01fc:
            int r0 = r10.scrollChildren
            if (r0 <= 0) goto L_0x0239
            int r0 = r10.scrollChildren
            r11.setItemCount(r0)
            int r0 = r10.scrollIndex
            r11.setFromIndex(r0)
            java.util.List r0 = r10.childrenInHitTestOrder
            java.util.Iterator r0 = r0.iterator()
            r4 = 0
        L_0x0219:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0230
            java.lang.Object r5 = r0.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r5 = (p242io.flutter.view.AccessibilityBridge.SemanticsNode) r5
            io.flutter.view.AccessibilityBridge$Flag r6 = p242io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r5 = r5.hasFlag(r6)
            if (r5 != 0) goto L_0x0219
            int r4 = r4 + 1
            goto L_0x0219
        L_0x0230:
            int r0 = r10.scrollIndex
            int r0 = r0 + r4
            int r0 = r0 - r1
            r11.setToIndex(r0)
        L_0x0239:
            r8.m41713a((android.view.accessibility.AccessibilityEvent) r11)
        L_0x023c:
            io.flutter.view.AccessibilityBridge$Flag r11 = p242io.flutter.view.AccessibilityBridge.Flag.IS_LIVE_REGION
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x0251
            boolean r11 = r10.didChangeLabel()
            if (r11 == 0) goto L_0x0251
            int r11 = r10.f57960id
            r8.m41732c((int) r11)
        L_0x0251:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.f57949r
            if (r11 == 0) goto L_0x0286
            int r11 = r11.f57960id
            int r0 = r10.f57960id
            if (r11 != r0) goto L_0x0286
            io.flutter.view.AccessibilityBridge$Flag r11 = p242io.flutter.view.AccessibilityBridge.Flag.IS_SELECTED
            boolean r11 = r10.hadFlag(r11)
            if (r11 != 0) goto L_0x0286
            io.flutter.view.AccessibilityBridge$Flag r11 = p242io.flutter.view.AccessibilityBridge.Flag.IS_SELECTED
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x0286
            int r11 = r10.f57960id
            r0 = 4
            android.view.accessibility.AccessibilityEvent r11 = r8.m41724b((int) r11, (int) r0)
            java.util.List r0 = r11.getText()
            java.lang.String r4 = r10.label
            r0.add(r4)
            r8.m41713a((android.view.accessibility.AccessibilityEvent) r11)
        L_0x0286:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.f57953v
            if (r11 == 0) goto L_0x02b6
            int r11 = r11.f57960id
            int r0 = r10.f57960id
            if (r11 != r0) goto L_0x02b6
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.f57954w
            if (r11 == 0) goto L_0x02a4
            int r11 = r11.f57960id
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r8.f57953v
            int r0 = r0.f57960id
            if (r11 == r0) goto L_0x02b6
        L_0x02a4:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.f57953v
            r8.f57954w = r11
            int r11 = r10.f57960id
            r0 = 8
            android.view.accessibility.AccessibilityEvent r11 = r8.m41724b((int) r11, (int) r0)
            r8.m41713a((android.view.accessibility.AccessibilityEvent) r11)
            goto L_0x02bc
        L_0x02b6:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.f57953v
            if (r11 != 0) goto L_0x02bc
            r8.f57954w = r3
        L_0x02bc:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.f57953v
            if (r11 == 0) goto L_0x016b
            int r11 = r11.f57960id
            int r0 = r10.f57960id
            if (r11 != r0) goto L_0x016b
            io.flutter.view.AccessibilityBridge$Flag r11 = p242io.flutter.view.AccessibilityBridge.Flag.IS_TEXT_FIELD
            boolean r11 = r10.hadFlag(r11)
            if (r11 == 0) goto L_0x016b
            io.flutter.view.AccessibilityBridge$Flag r11 = p242io.flutter.view.AccessibilityBridge.Flag.IS_TEXT_FIELD
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x016b
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.f57949r
            if (r11 == 0) goto L_0x02ea
            int r11 = r11.f57960id
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r8.f57953v
            int r0 = r0.f57960id
            if (r11 != r0) goto L_0x016b
        L_0x02ea:
            java.lang.String r11 = r10.previousValue
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x02f7
            java.lang.String r11 = r10.previousValue
            goto L_0x02f8
        L_0x02f7:
            r11 = r0
        L_0x02f8:
            java.lang.String r4 = r10.value
            if (r4 == 0) goto L_0x0302
            java.lang.String r0 = r10.value
        L_0x0302:
            int r4 = r10.f57960id
            android.view.accessibility.AccessibilityEvent r11 = r8.m41709a((int) r4, (java.lang.String) r11, (java.lang.String) r0)
            if (r11 == 0) goto L_0x030f
            r8.m41713a((android.view.accessibility.AccessibilityEvent) r11)
        L_0x030f:
            int r11 = r10.previousTextSelectionBase
            int r4 = r10.textSelectionBase
            if (r11 != r4) goto L_0x0323
            int r11 = r10.previousTextSelectionExtent
            int r4 = r10.textSelectionExtent
            if (r11 == r4) goto L_0x016b
        L_0x0323:
            int r11 = r10.f57960id
            r4 = 8192(0x2000, float:1.14794E-41)
            android.view.accessibility.AccessibilityEvent r11 = r8.m41724b((int) r11, (int) r4)
            java.util.List r4 = r11.getText()
            r4.add(r0)
            int r4 = r10.textSelectionBase
            r11.setFromIndex(r4)
            int r10 = r10.textSelectionExtent
            r11.setToIndex(r10)
            int r10 = r0.length()
            r11.setItemCount(r10)
            r8.m41713a((android.view.accessibility.AccessibilityEvent) r11)
            goto L_0x016b
        L_0x034e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.view.AccessibilityBridge.mo172930a(java.nio.ByteBuffer, java.lang.String[], java.nio.ByteBuffer[]):void");
    }

    /* renamed from: a */
    private AccessibilityEvent m41709a(int i, String str, String str2) {
        AccessibilityEvent b = m41724b(i, 16);
        b.setBeforeText(str);
        b.getText().add(str2);
        int i2 = 0;
        while (i2 < str.length() && i2 < str2.length() && str.charAt(i2) == str2.charAt(i2)) {
            i2++;
        }
        if (i2 >= str.length() && i2 >= str2.length()) {
            return null;
        }
        b.setFromIndex(i2);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i2 && length2 >= i2 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        b.setRemovedCount((length - i2) + 1);
        b.setAddedCount((length2 - i2) + 1);
        return b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41712a(int i, int i2) {
        if (this.f57943l.isEnabled()) {
            m41713a(m41724b(i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41713a(AccessibilityEvent accessibilityEvent) {
        if (this.f57943l.isEnabled()) {
            this.f57941j.getParent().requestSendAccessibilityEvent(this.f57941j, accessibilityEvent);
        }
    }

    /* renamed from: b */
    private void m41727b(SemanticsNode semanticsNode) {
        String access$6400 = semanticsNode.getRouteName();
        if (access$6400 == null) {
            access$6400 = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            m41717a(access$6400);
            return;
        }
        AccessibilityEvent b = m41724b(semanticsNode.f57960id, 32);
        b.getText().add(access$6400);
        m41713a(b);
    }

    /* renamed from: a */
    private void m41717a(String str) {
        this.f57941j.setAccessibilityPaneTitle(str);
    }

    /* renamed from: c */
    private void m41732c(int i) {
        AccessibilityEvent b = m41724b(i, 2048);
        if (Build.VERSION.SDK_INT >= 19) {
            b.setContentChangeTypes(1);
        }
        m41713a(b);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public AccessibilityEvent m41724b(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setPackageName(this.f57941j.getContext().getPackageName());
        obtain.setSource(this.f57941j, i);
        return obtain;
    }

    /* renamed from: f */
    private boolean m41741f() {
        Activity activity = ViewUtils.getActivity(this.f57941j.getContext());
        if (activity == null || activity.getWindow() == null) {
            return false;
        }
        int i = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
        if (i == 2 || i == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private void m41733c(SemanticsNode semanticsNode) {
        View platformViewById;
        Integer num;
        SemanticsNode unused = semanticsNode.parent = null;
        if (!(semanticsNode.platformViewId == -1 || (num = this.f57950s) == null || this.f57944m.platformViewOfNode(num.intValue()) != this.f57945n.getPlatformViewById(Integer.valueOf(semanticsNode.platformViewId)))) {
            m41712a(this.f57950s.intValue(), 65536);
            this.f57950s = null;
        }
        if (!(semanticsNode.platformViewId == -1 || this.f57945n.usesVirtualDisplay(Integer.valueOf(semanticsNode.platformViewId)) || (platformViewById = this.f57945n.getPlatformViewById(Integer.valueOf(semanticsNode.platformViewId))) == null)) {
            platformViewById.setImportantForAccessibility(4);
        }
        SemanticsNode semanticsNode2 = this.f57949r;
        if (semanticsNode2 == semanticsNode) {
            m41712a(semanticsNode2.f57960id, 65536);
            this.f57949r = null;
        }
        if (this.f57953v == semanticsNode) {
            this.f57953v = null;
        }
        if (this.f57955x == semanticsNode) {
            this.f57955x = null;
        }
    }

    public void reset() {
        this.f57947p.clear();
        SemanticsNode semanticsNode = this.f57949r;
        if (semanticsNode != null) {
            m41712a(semanticsNode.f57960id, 65536);
        }
        this.f57949r = null;
        this.f57955x = null;
        m41732c(0);
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$Action */
    public enum Action {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152);
        
        public final int value;

        private Action(int i) {
            this.value = i;
        }
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$Flag */
    enum Flag {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216);
        
        final int value;

        private Flag(int i) {
            this.value = i;
        }
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$AccessibilityFeature */
    private enum AccessibilityFeature {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4);
        
        final int value;

        private AccessibilityFeature(int i) {
            this.value = i;
        }
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$TextDirection */
    private enum TextDirection {
        UNKNOWN,
        LTR,
        RTL;

        public static TextDirection fromInt(int i) {
            if (i == 1) {
                return RTL;
            }
            if (i != 2) {
                return UNKNOWN;
            }
            return LTR;
        }
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$CustomAccessibilityAction */
    private static class CustomAccessibilityAction {
        /* access modifiers changed from: private */
        public String hint;
        /* access modifiers changed from: private */

        /* renamed from: id */
        public int f57959id = -1;
        /* access modifiers changed from: private */
        public String label;
        /* access modifiers changed from: private */
        public int overrideId = -1;
        /* access modifiers changed from: private */
        public int resourceId = -1;

        CustomAccessibilityAction() {
        }
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$StringAttribute */
    private static class StringAttribute {
        int end;
        int start;
        StringAttributeType type;

        private StringAttribute() {
        }
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$SpellOutStringAttribute */
    private static class SpellOutStringAttribute extends StringAttribute {
        private SpellOutStringAttribute() {
            super();
        }
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$LocaleStringAttribute */
    private static class LocaleStringAttribute extends StringAttribute {
        String locale;

        private LocaleStringAttribute() {
            super();
        }
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$SemanticsNode */
    private static class SemanticsNode {
        final AccessibilityBridge accessibilityBridge;
        private int actions;
        private float bottom;
        /* access modifiers changed from: private */
        public List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
        /* access modifiers changed from: private */
        public List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
        /* access modifiers changed from: private */
        public int currentValueLength;
        /* access modifiers changed from: private */
        public List<CustomAccessibilityAction> customAccessibilityActions;
        /* access modifiers changed from: private */
        public String decreasedValue;
        /* access modifiers changed from: private */
        public List<StringAttribute> decreasedValueAttributes;
        private int flags;
        /* access modifiers changed from: private */
        public boolean globalGeometryDirty = true;
        private Rect globalRect;
        private float[] globalTransform;
        /* access modifiers changed from: private */
        public boolean hadPreviousConfig = false;
        private String hint;
        private List<StringAttribute> hintAttributes;
        /* access modifiers changed from: private */

        /* renamed from: id */
        public int f57960id = -1;
        /* access modifiers changed from: private */
        public String increasedValue;
        /* access modifiers changed from: private */
        public List<StringAttribute> increasedValueAttributes;
        private float[] inverseTransform;
        /* access modifiers changed from: private */
        public boolean inverseTransformDirty = true;
        /* access modifiers changed from: private */
        public String label;
        private List<StringAttribute> labelAttributes;
        private float left;
        /* access modifiers changed from: private */
        public int maxValueLength;
        /* access modifiers changed from: private */
        public CustomAccessibilityAction onLongPressOverride;
        /* access modifiers changed from: private */
        public CustomAccessibilityAction onTapOverride;
        /* access modifiers changed from: private */
        public SemanticsNode parent;
        /* access modifiers changed from: private */
        public int platformViewId;
        private int previousActions;
        private int previousFlags;
        private String previousLabel;
        /* access modifiers changed from: private */
        public int previousNodeId = -1;
        private float previousScrollExtentMax;
        private float previousScrollExtentMin;
        private float previousScrollPosition;
        /* access modifiers changed from: private */
        public int previousTextSelectionBase;
        /* access modifiers changed from: private */
        public int previousTextSelectionExtent;
        /* access modifiers changed from: private */
        public String previousValue;
        private float right;
        /* access modifiers changed from: private */
        public int scrollChildren;
        /* access modifiers changed from: private */
        public float scrollExtentMax;
        /* access modifiers changed from: private */
        public float scrollExtentMin;
        /* access modifiers changed from: private */
        public int scrollIndex;
        /* access modifiers changed from: private */
        public float scrollPosition;
        private TextDirection textDirection;
        /* access modifiers changed from: private */
        public int textSelectionBase;
        /* access modifiers changed from: private */
        public int textSelectionExtent;
        /* access modifiers changed from: private */
        public String tooltip;
        private float top;
        private float[] transform;
        /* access modifiers changed from: private */
        public String value;
        /* access modifiers changed from: private */
        public List<StringAttribute> valueAttributes;

        private void log(String str, boolean z) {
        }

        static /* synthetic */ int access$2112(SemanticsNode semanticsNode, int i) {
            int i2 = semanticsNode.textSelectionExtent + i;
            semanticsNode.textSelectionExtent = i2;
            return i2;
        }

        static /* synthetic */ int access$2120(SemanticsNode semanticsNode, int i) {
            int i2 = semanticsNode.textSelectionExtent - i;
            semanticsNode.textSelectionExtent = i2;
            return i2;
        }

        /* access modifiers changed from: private */
        public static boolean nullableHasAncestor(SemanticsNode semanticsNode, Predicate<SemanticsNode> predicate) {
            return (semanticsNode == null || semanticsNode.getAncestor(predicate) == null) ? false : true;
        }

        SemanticsNode(AccessibilityBridge accessibilityBridge2) {
            this.accessibilityBridge = accessibilityBridge2;
        }

        private SemanticsNode getAncestor(Predicate<SemanticsNode> predicate) {
            for (SemanticsNode semanticsNode = this.parent; semanticsNode != null; semanticsNode = semanticsNode.parent) {
                if (predicate.test(semanticsNode)) {
                    return semanticsNode;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public boolean hasAction(Action action) {
            return (action.value & this.actions) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hadAction(Action action) {
            return (action.value & this.previousActions) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hasFlag(Flag flag) {
            return (flag.value & this.flags) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hadFlag(Flag flag) {
            return (flag.value & this.previousFlags) != 0;
        }

        /* access modifiers changed from: private */
        public boolean didScroll() {
            return !Float.isNaN(this.scrollPosition) && !Float.isNaN(this.previousScrollPosition) && this.previousScrollPosition != this.scrollPosition;
        }

        /* access modifiers changed from: private */
        public boolean didChangeLabel() {
            String str;
            if (this.label == null && this.previousLabel == null) {
                return false;
            }
            String str2 = this.label;
            if (str2 == null || (str = this.previousLabel) == null || !str2.equals(str)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public void updateWith(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            this.hadPreviousConfig = true;
            this.previousValue = this.value;
            this.previousLabel = this.label;
            this.previousFlags = this.flags;
            this.previousActions = this.actions;
            this.previousTextSelectionBase = this.textSelectionBase;
            this.previousTextSelectionExtent = this.textSelectionExtent;
            this.previousScrollPosition = this.scrollPosition;
            this.previousScrollExtentMax = this.scrollExtentMax;
            this.previousScrollExtentMin = this.scrollExtentMin;
            this.flags = byteBuffer.getInt();
            this.actions = byteBuffer.getInt();
            this.maxValueLength = byteBuffer.getInt();
            this.currentValueLength = byteBuffer.getInt();
            this.textSelectionBase = byteBuffer.getInt();
            this.textSelectionExtent = byteBuffer.getInt();
            this.platformViewId = byteBuffer.getInt();
            this.scrollChildren = byteBuffer.getInt();
            this.scrollIndex = byteBuffer.getInt();
            this.scrollPosition = byteBuffer.getFloat();
            this.scrollExtentMax = byteBuffer.getFloat();
            this.scrollExtentMin = byteBuffer.getFloat();
            int i = byteBuffer.getInt();
            if (i == -1) {
                str = null;
            } else {
                str = strArr[i];
            }
            this.label = str;
            this.labelAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i2 = byteBuffer.getInt();
            if (i2 == -1) {
                str2 = null;
            } else {
                str2 = strArr[i2];
            }
            this.value = str2;
            this.valueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i3 = byteBuffer.getInt();
            if (i3 == -1) {
                str3 = null;
            } else {
                str3 = strArr[i3];
            }
            this.increasedValue = str3;
            this.increasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i4 = byteBuffer.getInt();
            if (i4 == -1) {
                str4 = null;
            } else {
                str4 = strArr[i4];
            }
            this.decreasedValue = str4;
            this.decreasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i5 = byteBuffer.getInt();
            if (i5 == -1) {
                str5 = null;
            } else {
                str5 = strArr[i5];
            }
            this.hint = str5;
            this.hintAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i6 = byteBuffer.getInt();
            if (i6 == -1) {
                str6 = null;
            } else {
                str6 = strArr[i6];
            }
            this.tooltip = str6;
            this.textDirection = TextDirection.fromInt(byteBuffer.getInt());
            this.left = byteBuffer.getFloat();
            this.top = byteBuffer.getFloat();
            this.right = byteBuffer.getFloat();
            this.bottom = byteBuffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i7 = 0; i7 < 16; i7++) {
                this.transform[i7] = byteBuffer.getFloat();
            }
            this.inverseTransformDirty = true;
            this.globalGeometryDirty = true;
            int i8 = byteBuffer.getInt();
            this.childrenInTraversalOrder.clear();
            this.childrenInHitTestOrder.clear();
            for (int i9 = 0; i9 < i8; i9++) {
                SemanticsNode c = this.accessibilityBridge.m41710a(byteBuffer.getInt());
                c.parent = this;
                this.childrenInTraversalOrder.add(c);
            }
            for (int i10 = 0; i10 < i8; i10++) {
                SemanticsNode c2 = this.accessibilityBridge.m41710a(byteBuffer.getInt());
                c2.parent = this;
                this.childrenInHitTestOrder.add(c2);
            }
            int i11 = byteBuffer.getInt();
            if (i11 == 0) {
                this.customAccessibilityActions = null;
                return;
            }
            List<CustomAccessibilityAction> list = this.customAccessibilityActions;
            if (list == null) {
                this.customAccessibilityActions = new ArrayList(i11);
            } else {
                list.clear();
            }
            for (int i12 = 0; i12 < i11; i12++) {
                CustomAccessibilityAction d = this.accessibilityBridge.m41726b(byteBuffer.getInt());
                if (d.overrideId == Action.TAP.value) {
                    this.onTapOverride = d;
                } else if (d.overrideId == Action.LONG_PRESS.value) {
                    this.onLongPressOverride = d;
                } else {
                    this.customAccessibilityActions.add(d);
                }
                this.customAccessibilityActions.add(d);
            }
        }

        private List<StringAttribute> getStringAttributesFromBuffer(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i = byteBuffer.getInt();
            if (i == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = byteBuffer.getInt();
                int i4 = byteBuffer.getInt();
                StringAttributeType stringAttributeType = StringAttributeType.values()[byteBuffer.getInt()];
                int i5 = C211775.f57958x66a987df[stringAttributeType.ordinal()];
                if (i5 == 1) {
                    byteBuffer.getInt();
                    SpellOutStringAttribute spellOutStringAttribute = new SpellOutStringAttribute();
                    spellOutStringAttribute.start = i3;
                    spellOutStringAttribute.end = i4;
                    spellOutStringAttribute.type = stringAttributeType;
                    arrayList.add(spellOutStringAttribute);
                } else if (i5 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    LocaleStringAttribute localeStringAttribute = new LocaleStringAttribute();
                    localeStringAttribute.start = i3;
                    localeStringAttribute.end = i4;
                    localeStringAttribute.type = stringAttributeType;
                    localeStringAttribute.locale = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(localeStringAttribute);
                }
            }
            return arrayList;
        }

        private void ensureInverseTransform() {
            if (this.inverseTransformDirty) {
                this.inverseTransformDirty = false;
                if (this.inverseTransform == null) {
                    this.inverseTransform = new float[16];
                }
                if (!Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
                    Arrays.fill(this.inverseTransform, 0.0f);
                }
            }
        }

        /* access modifiers changed from: private */
        public Rect getGlobalRect() {
            return this.globalRect;
        }

        /* access modifiers changed from: private */
        public SemanticsNode hitTest(float[] fArr) {
            float f = fArr[3];
            float f2 = fArr[0] / f;
            float f3 = fArr[1] / f;
            if (f2 < this.left || f2 >= this.right || f3 < this.top || f3 >= this.bottom) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (SemanticsNode next : this.childrenInHitTestOrder) {
                if (!next.hasFlag(Flag.IS_HIDDEN)) {
                    next.ensureInverseTransform();
                    Matrix.multiplyMV(fArr2, 0, next.inverseTransform, 0, fArr, 0);
                    SemanticsNode hitTest = next.hitTest(fArr2);
                    if (hitTest != null) {
                        return hitTest;
                    }
                }
            }
            if (isFocusable()) {
                return this;
            }
            return null;
        }

        /* access modifiers changed from: private */
        public boolean isFocusable() {
            String str;
            String str2;
            String str3;
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                return false;
            }
            if (!hasFlag(Flag.IS_FOCUSABLE) && (this.actions & (~AccessibilityBridge.f57930f)) == 0 && (this.flags & AccessibilityBridge.f57931g) == 0 && (((str = this.label) == null || str.isEmpty()) && (((str2 = this.value) == null || str2.isEmpty()) && ((str3 = this.hint) == null || str3.isEmpty())))) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public void collectRoutes(List<SemanticsNode> list) {
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                list.add(this);
            }
            for (SemanticsNode collectRoutes : this.childrenInTraversalOrder) {
                collectRoutes.collectRoutes(list);
            }
        }

        /* access modifiers changed from: private */
        public String getRouteName() {
            String str;
            if (hasFlag(Flag.NAMES_ROUTE) && (str = this.label) != null && !str.isEmpty()) {
                return this.label;
            }
            for (SemanticsNode routeName : this.childrenInTraversalOrder) {
                String routeName2 = routeName.getRouteName();
                if (routeName2 != null && !routeName2.isEmpty()) {
                    return routeName2;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public void updateRecursively(float[] fArr, Set<SemanticsNode> set, boolean z) {
            set.add(this);
            if (this.globalGeometryDirty) {
                z = true;
            }
            if (z) {
                if (this.globalTransform == null) {
                    this.globalTransform = new float[16];
                }
                Matrix.multiplyMM(this.globalTransform, 0, fArr, 0, this.transform, 0);
                float[] fArr2 = new float[4];
                fArr2[2] = 0.0f;
                fArr2[3] = 1.0f;
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                fArr2[0] = this.left;
                fArr2[1] = this.top;
                transformPoint(fArr3, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.top;
                transformPoint(fArr4, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.bottom;
                transformPoint(fArr5, this.globalTransform, fArr2);
                fArr2[0] = this.left;
                fArr2[1] = this.bottom;
                transformPoint(fArr6, this.globalTransform, fArr2);
                if (this.globalRect == null) {
                    this.globalRect = new Rect();
                }
                this.globalRect.set(Math.round(min(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(min(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(max(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(max(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.globalGeometryDirty = false;
            }
            int i = -1;
            for (SemanticsNode next : this.childrenInTraversalOrder) {
                next.previousNodeId = i;
                i = next.f57960id;
                next.updateRecursively(this.globalTransform, set, z);
            }
        }

        private void transformPoint(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f = fArr[3];
            fArr[0] = fArr[0] / f;
            fArr[1] = fArr[1] / f;
            fArr[2] = fArr[2] / f;
            fArr[3] = 0.0f;
        }

        private float min(float f, float f2, float f3, float f4) {
            return Math.min(f, Math.min(f2, Math.min(f3, f4)));
        }

        private float max(float f, float f2, float f3, float f4) {
            return Math.max(f, Math.max(f2, Math.max(f3, f4)));
        }

        /* access modifiers changed from: private */
        public CharSequence getValueLabelHint() {
            CharSequence charSequence = null;
            for (CharSequence charSequence2 : Build.VERSION.SDK_INT < 21 ? new CharSequence[]{this.value, this.label, this.hint} : new CharSequence[]{createSpannableString(this.value, this.valueAttributes), createSpannableString(this.label, this.labelAttributes), createSpannableString(this.hint, this.hintAttributes)}) {
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(new CharSequence[]{charSequence, ", ", charSequence2});
                }
            }
            return charSequence;
        }

        private SpannableString createSpannableString(String str, List<StringAttribute> list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (StringAttribute next : list) {
                    int i = C211775.f57958x66a987df[next.type.ordinal()];
                    if (i == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), next.start, next.end, 0);
                    } else if (i == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((LocaleStringAttribute) next).locale)), next.start, next.end, 0);
                    }
                }
            }
            return spannableString;
        }
    }

    /* renamed from: io.flutter.view.AccessibilityBridge$5 */
    static /* synthetic */ class C211775 {

        /* renamed from: $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType */
        static final /* synthetic */ int[] f57958x66a987df;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.flutter.view.AccessibilityBridge$StringAttributeType[] r0 = p242io.flutter.view.AccessibilityBridge.StringAttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f57958x66a987df = r0
                io.flutter.view.AccessibilityBridge$StringAttributeType r1 = p242io.flutter.view.AccessibilityBridge.StringAttributeType.SPELLOUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f57958x66a987df     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.view.AccessibilityBridge$StringAttributeType r1 = p242io.flutter.view.AccessibilityBridge.StringAttributeType.LOCALE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.view.AccessibilityBridge.C211775.<clinit>():void");
        }
    }

    public boolean externalViewRequestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.f57944m.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.f57944m.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.f57951t = recordFlutterId;
            this.f57953v = null;
            return true;
        } else if (eventType == 128) {
            this.f57955x = null;
            return true;
        } else if (eventType == 32768) {
            this.f57950s = recordFlutterId;
            this.f57949r = null;
            return true;
        } else if (eventType != 65536) {
            return true;
        } else {
            this.f57951t = null;
            this.f57950s = null;
            return true;
        }
    }
}
