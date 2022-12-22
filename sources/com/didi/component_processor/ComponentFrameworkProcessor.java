package com.didi.component_processor;

import com.didi.component_processor.annonation.ComponentName;
import com.didi.component_processor.annonation.NodeName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

public class ComponentFrameworkProcessor extends AbstractProcessor {

    /* renamed from: a */
    private static final String f16219a = "com.didi.component.auto";

    /* renamed from: b */
    private static final String f16220b = "ModuleMap";

    /* renamed from: c */
    private Types f16221c;

    /* renamed from: d */
    private Elements f16222d;

    /* renamed from: e */
    private Filer f16223e;

    /* renamed from: f */
    private Messager f16224f;

    /* renamed from: g */
    private final List<IndexBean> f16225g = new ArrayList();

    /* renamed from: h */
    private final List<IndexBean> f16226h = new ArrayList();

    /* renamed from: i */
    private final List<IndexBean> f16227i = new ArrayList();

    /* renamed from: j */
    private final Map<String, String> f16228j = new LinkedHashMap();

    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        ComponentFrameworkProcessor.super.init(processingEnvironment);
        this.f16221c = this.processingEnv.getTypeUtils();
        this.f16222d = this.processingEnv.getElementUtils();
        this.f16223e = this.processingEnv.getFiler();
        this.f16224f = this.processingEnv.getMessager();
        m11892a(">>> init <<<", new Object[0]);
    }

    public SourceVersion getSupportedSourceVersion() {
        m11892a(">>> getSupportedSourceVersion <<<", new Object[0]);
        return SourceVersion.RELEASE_8;
    }

    public Set<String> getSupportedAnnotationTypes() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(ComponentName.class.getCanonicalName());
        linkedHashSet.add(NodeName.class.getCanonicalName());
        return linkedHashSet;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean process(java.util.Set<? extends javax.lang.model.element.TypeElement> r7, javax.annotation.processing.RoundEnvironment r8) {
        /*
            r6 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = ">>> process is running... <<<"
            r6.m11892a(r2, r1)
            r1 = 1
            if (r7 == 0) goto L_0x0107
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0013
            goto L_0x0107
        L_0x0013:
            java.lang.Object[] r7 = new java.lang.Object[r0]
            java.lang.String r2 = ">>> Found field, start... <<<"
            r6.m11892a(r2, r7)
            java.lang.Class<com.didi.component_processor.annonation.ComponentName> r7 = com.didi.component_processor.annonation.ComponentName.class
            java.util.Set r7 = r8.getElementsAnnotatedWith(r7)
            java.lang.Class<com.didi.component_processor.annonation.NodeName> r2 = com.didi.component_processor.annonation.NodeName.class
            java.util.Set r8 = r8.getElementsAnnotatedWith(r2)
            r2 = 0
            if (r7 == 0) goto L_0x0090
            boolean r3 = r7.isEmpty()
            if (r3 != 0) goto L_0x0090
            java.util.Iterator r7 = r7.iterator()
        L_0x0033:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x0090
            java.lang.Object r3 = r7.next()
            javax.lang.model.element.Element r3 = (javax.lang.model.element.Element) r3
            boolean r4 = r3 instanceof javax.lang.model.element.TypeElement
            if (r4 == 0) goto L_0x0088
            java.lang.Class<com.didi.component_processor.annonation.ComponentName> r4 = com.didi.component_processor.annonation.ComponentName.class
            java.lang.annotation.Annotation r4 = r3.getAnnotation(r4)
            com.didi.component_processor.annonation.ComponentName r4 = (com.didi.component_processor.annonation.ComponentName) r4
            com.didi.component_processor.ComponentFrameworkProcessor$IndexBean r5 = new com.didi.component_processor.ComponentFrameworkProcessor$IndexBean
            r5.<init>()
            javax.lang.model.element.TypeElement r3 = (javax.lang.model.element.TypeElement) r3
            javax.lang.model.element.Name r3 = r3.getQualifiedName()
            java.lang.String r3 = r3.toString()
            r5.className = r3
            java.lang.String r3 = r4.type()
            r5.type = r3
            int r3 = r4.category()
            r5.category = r3
            int r3 = r5.category
            r4 = 2
            r3 = r3 & r4
            if (r3 != r4) goto L_0x0073
            java.util.List<com.didi.component_processor.ComponentFrameworkProcessor$IndexBean> r3 = r6.f16226h
            r3.add(r5)
        L_0x0073:
            int r3 = r5.category
            r3 = r3 & r1
            if (r3 != r1) goto L_0x007d
            java.util.List<com.didi.component_processor.ComponentFrameworkProcessor$IndexBean> r3 = r6.f16225g
            r3.add(r5)
        L_0x007d:
            int r3 = r5.category
            r4 = 4
            r3 = r3 & r4
            if (r3 != r4) goto L_0x0088
            java.util.List<com.didi.component_processor.ComponentFrameworkProcessor$IndexBean> r3 = r6.f16227i
            r3.add(r5)
        L_0x0088:
            java.lang.Object[] r3 = new java.lang.Object[r0]
            java.lang.String r4 = ">>> componentElements is added... <<<"
            r6.m11892a(r4, r3)
            goto L_0x0033
        L_0x0090:
            if (r8 == 0) goto L_0x00cf
            boolean r7 = r8.isEmpty()
            if (r7 != 0) goto L_0x00cf
            java.util.Iterator r7 = r8.iterator()
        L_0x009c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00cf
            java.lang.Object r8 = r7.next()
            javax.lang.model.element.Element r8 = (javax.lang.model.element.Element) r8
            boolean r3 = r8 instanceof javax.lang.model.element.TypeElement
            if (r3 == 0) goto L_0x00c7
            java.lang.Class<com.didi.component_processor.annonation.NodeName> r3 = com.didi.component_processor.annonation.NodeName.class
            java.lang.annotation.Annotation r3 = r8.getAnnotation(r3)
            com.didi.component_processor.annonation.NodeName r3 = (com.didi.component_processor.annonation.NodeName) r3
            javax.lang.model.element.TypeElement r8 = (javax.lang.model.element.TypeElement) r8
            javax.lang.model.element.Name r8 = r8.getQualifiedName()
            java.lang.String r8 = r8.toString()
            java.util.Map<java.lang.String, java.lang.String> r4 = r6.f16228j
            java.lang.String r3 = r3.name()
            r4.put(r3, r8)
        L_0x00c7:
            java.lang.Object[] r8 = new java.lang.Object[r0]
            java.lang.String r3 = ">>> nodeElements is added... <<<"
            r6.m11892a(r3, r8)
            goto L_0x009c
        L_0x00cf:
            javax.annotation.processing.ProcessingEnvironment r7 = r6.processingEnv
            java.util.Map r7 = r7.getOptions()
            if (r7 == 0) goto L_0x00f2
            javax.annotation.processing.ProcessingEnvironment r7 = r6.processingEnv
            java.util.Map r7 = r7.getOptions()
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x00f2
            javax.annotation.processing.ProcessingEnvironment r7 = r6.processingEnv
            java.util.Map r7 = r7.getOptions()
            java.lang.String r8 = "moduleName"
            java.lang.Object r7 = r7.get(r8)
            r2 = r7
            java.lang.String r2 = (java.lang.String) r2
        L_0x00f2:
            if (r2 == 0) goto L_0x00ff
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L_0x00fb
            goto L_0x00ff
        L_0x00fb:
            r6.m11891a(r2)
            return r1
        L_0x00ff:
            java.lang.Object[] r7 = new java.lang.Object[r0]
            java.lang.String r8 = "you need to check the moduleName!"
            r6.m11892a(r8, r7)
            return r1
        L_0x0107:
            java.lang.Object[] r7 = new java.lang.Object[r0]
            java.lang.String r8 = ">>> set is null... <<<"
            r6.m11892a(r8, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component_processor.ComponentFrameworkProcessor.process(java.util.Set, javax.annotation.processing.RoundEnvironment):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x01ad A[SYNTHETIC, Splitter:B:37:0x01ad] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01d0 A[SYNTHETIC, Splitter:B:42:0x01d0] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11891a(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = ">>>finally IOException"
            java.lang.String r1 = "... <<<"
            r2 = 0
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018a }
            r4.<init>()     // Catch:{ IOException -> 0x018a }
            r4.append(r10)     // Catch:{ IOException -> 0x018a }
            java.lang.String r10 = "ModuleMap"
            r4.append(r10)     // Catch:{ IOException -> 0x018a }
            java.lang.String r10 = r4.toString()     // Catch:{ IOException -> 0x018a }
            java.lang.String r4 = ">>> createIndexFile... <<<"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x018a }
            r9.m11892a(r4, r5)     // Catch:{ IOException -> 0x018a }
            javax.annotation.processing.Filer r4 = r9.f16223e     // Catch:{ IOException -> 0x018a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018a }
            r5.<init>()     // Catch:{ IOException -> 0x018a }
            java.lang.String r6 = "com.didi.component.auto."
            r5.append(r6)     // Catch:{ IOException -> 0x018a }
            r5.append(r10)     // Catch:{ IOException -> 0x018a }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x018a }
            javax.lang.model.element.Element[] r6 = new javax.lang.model.element.Element[r2]     // Catch:{ IOException -> 0x018a }
            javax.tools.JavaFileObject r4 = r4.createSourceFile(r5, r6)     // Catch:{ IOException -> 0x018a }
            java.io.BufferedWriter r5 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x018a }
            java.io.Writer r4 = r4.openWriter()     // Catch:{ IOException -> 0x018a }
            r5.<init>(r4)     // Catch:{ IOException -> 0x018a }
            java.lang.String r3 = "package com.didi.component.auto;\n\n"
            r5.write(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = "import com.didi.component.never.core.IComponent;\n"
            r5.write(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = "import com.didi.component.never.core.node.Node;\n\n"
            r5.write(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = "import com.didi.component_processor.annonation.ModuleMap;\n\n"
            r5.write(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = "import java.util.HashMap;\n\n"
            r5.write(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r3.<init>()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = "public class "
            r3.append(r4)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r3.append(r10)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r10 = " {\n"
            r3.append(r10)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r10 = r3.toString()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r5.write(r10)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r10 = "public static void addMap()  {\n\n"
            r5.write(r10)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.util.List<com.didi.component_processor.ComponentFrameworkProcessor$IndexBean> r10 = r9.f16225g     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
        L_0x007d:
            boolean r3 = r10.hasNext()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = ".class);\n"
            java.lang.String r6 = "\", "
            if (r3 == 0) goto L_0x00af
            java.lang.Object r3 = r10.next()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            com.didi.component_processor.ComponentFrameworkProcessor$IndexBean r3 = (com.didi.component_processor.ComponentFrameworkProcessor.IndexBean) r3     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.<init>()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r8 = "        ModuleMap.addStandard(\""
            r7.append(r8)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r8 = r3.type     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r8)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r6)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = r3.className     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r4)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = r7.toString()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r5.write(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            goto L_0x007d
        L_0x00af:
            java.util.List<com.didi.component_processor.ComponentFrameworkProcessor$IndexBean> r10 = r9.f16226h     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
        L_0x00b5:
            boolean r3 = r10.hasNext()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            if (r3 == 0) goto L_0x00e3
            java.lang.Object r3 = r10.next()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            com.didi.component_processor.ComponentFrameworkProcessor$IndexBean r3 = (com.didi.component_processor.ComponentFrameworkProcessor.IndexBean) r3     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.<init>()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r8 = "        ModuleMap.addChild(\""
            r7.append(r8)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r8 = r3.type     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r8)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r6)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = r3.className     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r4)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = r7.toString()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r5.write(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            goto L_0x00b5
        L_0x00e3:
            java.util.List<com.didi.component_processor.ComponentFrameworkProcessor$IndexBean> r10 = r9.f16227i     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
        L_0x00e9:
            boolean r3 = r10.hasNext()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            if (r3 == 0) goto L_0x0117
            java.lang.Object r3 = r10.next()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            com.didi.component_processor.ComponentFrameworkProcessor$IndexBean r3 = (com.didi.component_processor.ComponentFrameworkProcessor.IndexBean) r3     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.<init>()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r8 = "        ModuleMap.addContainer(\""
            r7.append(r8)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r8 = r3.type     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r8)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r6)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = r3.className     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r4)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = r7.toString()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r5.write(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            goto L_0x00e9
        L_0x0117:
            java.util.Map<java.lang.String, java.lang.String> r10 = r9.f16228j     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.util.Set r10 = r10.entrySet()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
        L_0x0121:
            boolean r3 = r10.hasNext()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            if (r3 == 0) goto L_0x0157
            java.lang.Object r3 = r10.next()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.<init>()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r8 = "        ModuleMap.addNode(\""
            r7.append(r8)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.Object r8 = r3.getKey()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r8)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r6)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r7.append(r4)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = r7.toString()     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r5.write(r3)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            goto L_0x0121
        L_0x0157:
            java.lang.String r10 = "    }\n"
            r5.write(r10)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            java.lang.String r10 = "}\n"
            r5.write(r10)     // Catch:{ IOException -> 0x0185, all -> 0x0182 }
            r5.close()     // Catch:{ IOException -> 0x0165 }
            goto L_0x01cd
        L_0x0165:
            r10 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r10 = r10.getMessage()
            r3.append(r10)
            r3.append(r1)
            java.lang.String r10 = r3.toString()
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r9.m11892a(r10, r0)
            goto L_0x01cd
        L_0x0182:
            r10 = move-exception
            r3 = r5
            goto L_0x01ce
        L_0x0185:
            r10 = move-exception
            r3 = r5
            goto L_0x018b
        L_0x0188:
            r10 = move-exception
            goto L_0x01ce
        L_0x018a:
            r10 = move-exception
        L_0x018b:
            r10.printStackTrace()     // Catch:{ all -> 0x0188 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r4.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r5 = ">>> IOException"
            r4.append(r5)     // Catch:{ all -> 0x0188 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0188 }
            r4.append(r10)     // Catch:{ all -> 0x0188 }
            r4.append(r1)     // Catch:{ all -> 0x0188 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x0188 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0188 }
            r9.m11892a(r10, r4)     // Catch:{ all -> 0x0188 }
            if (r3 == 0) goto L_0x01cd
            r3.close()     // Catch:{ IOException -> 0x01b1 }
            goto L_0x01cd
        L_0x01b1:
            r10 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r10 = r10.getMessage()
            r3.append(r10)
            r3.append(r1)
            java.lang.String r10 = r3.toString()
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r9.m11892a(r10, r0)
        L_0x01cd:
            return
        L_0x01ce:
            if (r3 == 0) goto L_0x01f0
            r3.close()     // Catch:{ IOException -> 0x01d4 }
            goto L_0x01f0
        L_0x01d4:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r3.getMessage()
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r9.m11892a(r0, r1)
        L_0x01f0:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component_processor.ComponentFrameworkProcessor.m11891a(java.lang.String):void");
    }

    /* renamed from: a */
    private void m11893a(Element element, String str, Object... objArr) {
        this.f16224f.printMessage(Diagnostic.Kind.ERROR, String.format(str, objArr), element);
    }

    /* renamed from: a */
    private void m11892a(String str, Object... objArr) {
        this.f16224f.printMessage(Diagnostic.Kind.NOTE, String.format(str, objArr));
    }

    private static class IndexBean {
        int category;
        String className;
        String type;

        private IndexBean() {
        }
    }
}
