package com.cardinalcommerce.p060a;

import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setTextMetricsParams */
public class setTextMetricsParams {
    protected static String Cardinal = null;

    /* renamed from: b */
    private static volatile setTextMetricsParams f3052b = null;

    /* renamed from: c */
    private static int f3053c = 0;
    protected static String configure = null;

    /* renamed from: d */
    private static int f3054d = 1;
    protected static boolean getInstance;

    /* renamed from: a */
    private final String f3055a = setTextMetricsParams.class.getSimpleName();

    public static setTextMetricsParams getSDKVersion() {
        if (f3052b == null) {
            synchronized (setTextMetricsParams.class) {
                if (f3052b == null) {
                    f3052b = new setTextMetricsParams();
                }
            }
        }
        return f3052b;
    }

    public setTextMetricsParams() {
        getInstance = true;
    }

    public static void cca_continue(boolean z) {
        int i = (f3054d + 2) - 1;
        f3053c = i % 128;
        int i2 = i % 2;
        getInstance = z;
        int i3 = f3054d;
        int i4 = i3 & 87;
        int i5 = (i3 | 87) & (~i4);
        int i6 = i4 << 1;
        int i7 = (i5 & i6) + (i5 | i6);
        f3053c = i7 % 128;
        int i8 = i7 % 2;
    }

    /* renamed from: a */
    private setJustificationMode m2153a(String str, String str2, setLinksClickable setlinksclickable) {
        setJustificationMode configure2 = configure();
        HashMap hashMap = new HashMap();
        hashMap.put("mutator", str2);
        hashMap.put("identifier", str);
        hashMap.put("sessionid", setlinksclickable.f2869b);
        JSONObject cca_continue = configure2.cca_continue((HashMap<String, String>) hashMap, "sessionid");
        Object obj = null;
        if (cca_continue != null) {
            try {
                C2018k kVar = new C2018k(cca_continue);
                kVar.f2601a = setlinksclickable.f2869b;
                kVar.f2602b.put(setlinksclickable.getInstance());
                configure2.cca_continue(cca_continue, kVar.mo18277a());
                int i = f3054d;
                int i2 = ((i | 116) << 1) - (i ^ 116);
                int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
                f3053c = i3 % 128;
                if ((i3 % 2 != 0 ? '6' : 17) == 17) {
                    return configure2;
                }
                super.hashCode();
                return configure2;
            } catch (JSONException e) {
                String str3 = this.f3055a;
                StringBuilder sb = new StringBuilder("Exception during creating logs JSON. Error: ");
                sb.append(e.getLocalizedMessage());
                SystemUtils.log(6, str3, sb.toString(), (Throwable) null, "com.cardinalcommerce.a.setTextMetricsParams", 101);
            }
        }
        if (configure2.length() == 100) {
            configure2 = new setJustificationMode();
            int i4 = f3054d;
            int i5 = (i4 & -10) | ((~i4) & 9);
            int i6 = -(-((i4 & 9) << 1));
            int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
            f3053c = i7 % 128;
            int i8 = i7 % 2;
        }
        C2018k kVar2 = new C2018k(str, str2, setlinksclickable.f2869b);
        kVar2.f2602b.put(setlinksclickable.getInstance());
        configure2.put(kVar2.mo18277a());
        int i9 = (f3053c + 6) - 1;
        f3054d = i9 % 128;
        if (!(i9 % 2 == 0)) {
            return configure2;
        }
        super.hashCode();
        return configure2;
    }

    public setJustificationMode configure() {
        String a = new C2021n().mo18284a();
        if (!a.isEmpty()) {
            try {
                setJustificationMode setjustificationmode = new setJustificationMode(a);
                int i = f3053c;
                int i2 = (i & 67) + (i | 67);
                f3054d = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    return setjustificationmode;
                }
                int i3 = 81 / 0;
                return setjustificationmode;
            } catch (JSONException e) {
                String str = this.f3055a;
                StringBuilder sb = new StringBuilder("Exception during creating logs JSON. Error: ");
                sb.append(e.getLocalizedMessage());
                SystemUtils.log(6, str, sb.toString(), (Throwable) null, "com.cardinalcommerce.a.setTextMetricsParams", 148);
            }
        }
        setJustificationMode setjustificationmode2 = new setJustificationMode();
        int i4 = f3053c;
        int i5 = i4 | 77;
        int i6 = i5 << 1;
        int i7 = -((~(i4 & 77)) & i5);
        int i8 = (i6 & i7) + (i7 | i6);
        f3054d = i8 % 128;
        int i9 = i8 % 2;
        return setjustificationmode2;
    }

    public void configure(String str) {
        String str2;
        if (getInstance) {
            String a = getInstance ? new C2021n().mo18284a() : null;
            if (str != null) {
                boolean z = setHeight.Cardinal;
                if (str.equals("STAGING")) {
                    str2 = "https://cmsdk.cardinalcommerce.com/stag_logs";
                    Cardinal cardinal = new Cardinal(a, str2);
                    cardinal.configure();
                    cardinal.getSDKVersion.execute(new Runnable() {
                        private static int Cardinal;
                        private static int configure;

                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run(
/*
Method generation error in method: com.cardinalcommerce.a.setKeyListener.4.run():void, dex: classes.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
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
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                        
*/
                    });
                }
            }
            str2 = "https://cmsdk.cardinalcommerce.com/prod_logs";
            Cardinal cardinal2 = new Cardinal(a, str2);
            cardinal2.configure();
            cardinal2.getSDKVersion.execute(new Runnable() {
                private static int Cardinal;
                private static int configure;

                /*  JADX ERROR: Method generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
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
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                    */
                /*  JADX ERROR: Method generation error: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
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
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                    */
                public final void run(
/*
Method generation error in method: com.cardinalcommerce.a.setKeyListener.4.run():void, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
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
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                
*/
            });
        }
    }

    /* renamed from: com.cardinalcommerce.a.setTextMetricsParams$Cardinal */
    static class Cardinal extends setKeyListener {
        private static int CardinalError = 0;
        private static int valueOf = 1;

        public final void cca_continue(Exception exc, setMin setmin) {
            int i = (CardinalError + 22) - 1;
            valueOf = i % 128;
            int i2 = i % 2;
        }

        public final void getInstance(String str, int i) {
            int i2 = CardinalError;
            int i3 = (i2 & 64) + (i2 | 64);
            int i4 = (i3 & -1) + (i3 | -1);
            valueOf = i4 % 128;
            int i5 = i4 % 2;
        }

        public Cardinal(String str, String str2) {
            SystemUtils.log(3, "CARDINAL EVENT LOG \n", str, (Throwable) null, "com.cardinalcommerce.a.setTextMetricsParams$Cardinal", 173);
            super.configure(str2, str, 10000);
        }

        public final void cca_continue(String str) {
            int i = valueOf;
            int i2 = i & 73;
            int i3 = (((i ^ 73) | i2) << 1) - ((i | 73) & (~i2));
            CardinalError = i3 % 128;
            int i4 = i3 % 2;
            setTextMetricsParams.getSDKVersion().Cardinal();
            int i5 = CardinalError;
            int i6 = i5 & 103;
            int i7 = i6 + ((i5 ^ 103) | i6);
            valueOf = i7 % 128;
            int i8 = i7 % 2;
        }
    }

    public void configure(String str, String str2, String str3) {
        setLinksClickable setlinksclickable = new setLinksClickable();
        setlinksclickable.f2872e = str;
        setlinksclickable.f2868a = str2;
        setlinksclickable.f2869b = str3;
        setlinksclickable.f2870c = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        setlinksclickable.f2873f = true;
        if ((getInstance ? '9' : 'C') == '9') {
            int i = f3054d;
            int i2 = i ^ 31;
            int i3 = ((i & 31) | i2) << 1;
            int i4 = -i2;
            int i5 = ((i3 | i4) << 1) - (i3 ^ i4);
            f3053c = i5 % 128;
            int i6 = i5 % 2;
            String str4 = Cardinal;
            String str5 = configure;
            if (getInstance) {
                new C2021n().mo18285a(m2153a(str4, str5, setlinksclickable).toString());
                int i7 = f3054d;
                int i8 = (((i7 | 88) << 1) - (i7 ^ 88)) - 1;
                f3053c = i8 % 128;
                int i9 = i8 % 2;
            }
        }
        int i10 = (f3053c + 18) - 1;
        f3054d = i10 % 128;
        int i11 = i10 % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        if (getInstance != false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            com.cardinalcommerce.a.setLinksClickable r0 = new com.cardinalcommerce.a.setLinksClickable
            r0.<init>()
            r0.f2871d = r5
            r0.f2868a = r6
            r0.f2869b = r7
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r6 = java.lang.System.currentTimeMillis()
            long r5 = r5.toSeconds(r6)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.f2870c = r5
            boolean r5 = getInstance
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0023
            r5 = 0
            goto L_0x0024
        L_0x0023:
            r5 = 1
        L_0x0024:
            if (r5 == r7) goto L_0x0083
            int r5 = f3053c
            r1 = r5 ^ 14
            r5 = r5 & 14
            int r5 = r5 << r7
            int r1 = r1 + r5
            int r1 = r1 - r7
            int r5 = r1 % 128
            f3054d = r5
            int r1 = r1 % 2
            r5 = 66
            if (r1 != 0) goto L_0x003c
            r1 = 66
            goto L_0x003e
        L_0x003c:
            r1 = 85
        L_0x003e:
            if (r1 == r5) goto L_0x0049
            java.lang.String r5 = Cardinal
            java.lang.String r6 = configure
            boolean r1 = getInstance
            if (r1 == 0) goto L_0x0083
            goto L_0x0055
        L_0x0049:
            java.lang.String r5 = Cardinal
            java.lang.String r1 = configure
            boolean r2 = getInstance
            r3 = 53
            int r3 = r3 / r6
            if (r2 == 0) goto L_0x0083
            r6 = r1
        L_0x0055:
            com.cardinalcommerce.a.n r1 = new com.cardinalcommerce.a.n
            r1.<init>()
            com.cardinalcommerce.a.setJustificationMode r5 = r4.m2153a(r5, r6, r0)
            java.lang.String r5 = r5.toString()
            r1.mo18285a(r5)
            int r5 = f3053c
            r6 = 99
            r0 = r5 ^ 99
            r1 = r5 & 99
            r0 = r0 | r1
            int r7 = r0 << 1
            r0 = r5 & -100
            int r5 = ~r5
            r5 = r5 & r6
            r5 = r5 | r0
            int r5 = -r5
            r6 = r7 & r5
            r5 = r5 | r7
            int r6 = r6 + r5
            int r5 = r6 % 128
            f3054d = r5
            int r6 = r6 % 2
            goto L_0x0083
        L_0x0081:
            r5 = move-exception
            throw r5
        L_0x0083:
            int r5 = f3054d
            r6 = r5 & 93
            r5 = r5 | 93
            int r6 = r6 + r5
            int r5 = r6 % 128
            f3053c = r5
            int r6 = r6 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextMetricsParams.init(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (getInstance != false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (getInstance != false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Cardinal() {
        /*
            r4 = this;
            int r0 = f3053c
            r1 = r0 ^ 125(0x7d, float:1.75E-43)
            r0 = r0 & 125(0x7d, float:1.75E-43)
            r2 = 1
            int r0 = r0 << r2
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3054d = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 != 0) goto L_0x0014
            r1 = 0
            goto L_0x0015
        L_0x0014:
            r1 = 1
        L_0x0015:
            if (r1 == 0) goto L_0x001c
            boolean r0 = getInstance
            if (r0 == 0) goto L_0x0037
            goto L_0x0023
        L_0x001c:
            boolean r1 = getInstance
            r3 = 81
            int r3 = r3 / r0
            if (r1 == 0) goto L_0x0037
        L_0x0023:
            com.cardinalcommerce.a.n r0 = new com.cardinalcommerce.a.n
            r0.<init>()
            java.lang.String r1 = ""
            r0.mo18285a(r1)
            int r0 = f3054d
            int r0 = r0 + 7
            int r1 = r0 % 128
            f3053c = r1
            int r0 = r0 % 2
        L_0x0037:
            int r0 = f3054d
            r1 = r0 | 72
            int r1 = r1 << r2
            r0 = r0 ^ 72
            int r1 = r1 - r0
            r0 = r1 ^ -1
            r1 = r1 & -1
            int r1 = r1 << r2
            int r0 = r0 + r1
            int r1 = r0 % 128
            f3053c = r1
            int r0 = r0 % 2
            r1 = 54
            if (r0 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r2 = 54
        L_0x0052:
            if (r2 == r1) goto L_0x005b
            r0 = 0
            super.hashCode()     // Catch:{ all -> 0x0059 }
            return
        L_0x0059:
            r0 = move-exception
            throw r0
        L_0x005b:
            return
        L_0x005c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextMetricsParams.Cardinal():void");
    }
}
