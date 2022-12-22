package com.google.auto.common;

import com.google.auto.common.Overrides;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.SetMultimap;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor6;
import javax.lang.model.util.Types;

public final class MoreElements {
    public static PackageElement getPackage(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    private static final class PackageElementVisitor extends CastingElementVisitor<PackageElement> {
        /* access modifiers changed from: private */
        public static final PackageElementVisitor INSTANCE = new PackageElementVisitor();

        public PackageElement visitPackage(PackageElement packageElement, Void voidR) {
            return packageElement;
        }

        PackageElementVisitor() {
            super("package element");
        }
    }

    public static PackageElement asPackage(Element element) {
        return (PackageElement) element.accept(PackageElementVisitor.INSTANCE, (Object) null);
    }

    private static final class TypeElementVisitor extends CastingElementVisitor<TypeElement> {
        /* access modifiers changed from: private */
        public static final TypeElementVisitor INSTANCE = new TypeElementVisitor();

        public TypeElement visitType(TypeElement typeElement, Void voidR) {
            return typeElement;
        }

        TypeElementVisitor() {
            super("type element");
        }
    }

    public static boolean isType(Element element) {
        return element.getKind().isClass() || element.getKind().isInterface();
    }

    public static TypeElement asType(Element element) {
        return (TypeElement) element.accept(TypeElementVisitor.INSTANCE, (Object) null);
    }

    private static final class VariableElementVisitor extends CastingElementVisitor<VariableElement> {
        /* access modifiers changed from: private */
        public static final VariableElementVisitor INSTANCE = new VariableElementVisitor();

        public VariableElement visitVariable(VariableElement variableElement, Void voidR) {
            return variableElement;
        }

        VariableElementVisitor() {
            super("variable element");
        }
    }

    public static VariableElement asVariable(Element element) {
        return (VariableElement) element.accept(VariableElementVisitor.INSTANCE, (Object) null);
    }

    private static final class ExecutableElementVisitor extends CastingElementVisitor<ExecutableElement> {
        /* access modifiers changed from: private */
        public static final ExecutableElementVisitor INSTANCE = new ExecutableElementVisitor();

        public ExecutableElement visitExecutable(ExecutableElement executableElement, Void voidR) {
            return executableElement;
        }

        ExecutableElementVisitor() {
            super("executable element");
        }
    }

    public static ExecutableElement asExecutable(Element element) {
        return (ExecutableElement) element.accept(ExecutableElementVisitor.INSTANCE, (Object) null);
    }

    public static boolean isAnnotationPresent(Element element, Class<? extends Annotation> cls) {
        return getAnnotationMirror(element, cls).isPresent();
    }

    public static Optional<AnnotationMirror> getAnnotationMirror(Element element, Class<? extends Annotation> cls) {
        String canonicalName = cls.getCanonicalName();
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (asType(annotationMirror.getAnnotationType().asElement()).getQualifiedName().contentEquals(canonicalName)) {
                return Optional.m38344of(annotationMirror);
            }
        }
        return Optional.absent();
    }

    public static <T extends Element> Predicate<T> hasModifiers(Modifier... modifierArr) {
        return hasModifiers((Set<Modifier>) ImmutableSet.copyOf((E[]) modifierArr));
    }

    public static <T extends Element> Predicate<T> hasModifiers(final Set<Modifier> set) {
        return new Predicate<T>() {
            public boolean apply(T t) {
                return t.getModifiers().containsAll(set);
            }
        };
    }

    @Deprecated
    public static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Elements elements) {
        return getLocalAndInheritedMethods(typeElement, (Overrides) new Overrides.NativeOverrides(elements));
    }

    public static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Types types, Elements elements) {
        return getLocalAndInheritedMethods(typeElement, (Overrides) new Overrides.ExplicitOverrides(types));
    }

    private static ImmutableSet<ExecutableElement> getLocalAndInheritedMethods(TypeElement typeElement, Overrides overrides) {
        LinkedHashMultimap create = LinkedHashMultimap.create();
        getLocalAndInheritedMethods(getPackage(typeElement), typeElement, (SetMultimap<String, ExecutableElement>) create);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Collection copyOf : create.asMap().values()) {
            ImmutableList copyOf2 = ImmutableList.copyOf(copyOf);
            int i = 0;
            while (i < copyOf2.size()) {
                ExecutableElement executableElement = (ExecutableElement) copyOf2.get(i);
                i++;
                for (int i2 = i; i2 < copyOf2.size(); i2++) {
                    if (overrides.overrides((ExecutableElement) copyOf2.get(i2), executableElement, typeElement)) {
                        linkedHashSet.add(executableElement);
                    }
                }
            }
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(create.values());
        linkedHashSet2.removeAll(linkedHashSet);
        return ImmutableSet.copyOf(linkedHashSet2);
    }

    private static void getLocalAndInheritedMethods(PackageElement packageElement, TypeElement typeElement, SetMultimap<String, ExecutableElement> setMultimap) {
        for (TypeMirror asTypeElement : typeElement.getInterfaces()) {
            getLocalAndInheritedMethods(packageElement, MoreTypes.asTypeElement(asTypeElement), setMultimap);
        }
        if (typeElement.getSuperclass().getKind() != TypeKind.NONE) {
            getLocalAndInheritedMethods(packageElement, MoreTypes.asTypeElement(typeElement.getSuperclass()), setMultimap);
        }
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            if (!executableElement.getModifiers().contains(Modifier.STATIC) && methodVisibleFromPackage(executableElement, packageElement)) {
                setMultimap.put(executableElement.getSimpleName().toString(), executableElement);
            }
        }
    }

    /* renamed from: com.google.auto.common.MoreElements$2 */
    static /* synthetic */ class C186952 {
        static final /* synthetic */ int[] $SwitchMap$com$google$auto$common$Visibility;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.auto.common.Visibility[] r0 = com.google.auto.common.Visibility.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$auto$common$Visibility = r0
                com.google.auto.common.Visibility r1 = com.google.auto.common.Visibility.PRIVATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$auto$common$Visibility     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.auto.common.Visibility r1 = com.google.auto.common.Visibility.DEFAULT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.auto.common.MoreElements.C186952.<clinit>():void");
        }
    }

    static boolean methodVisibleFromPackage(ExecutableElement executableElement, PackageElement packageElement) {
        int i = C186952.$SwitchMap$com$google$auto$common$Visibility[Visibility.ofElement(executableElement).ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return true;
        }
        return getPackage(executableElement).equals(packageElement);
    }

    private static abstract class CastingElementVisitor<T> extends SimpleElementVisitor6<T, Void> {
        private final String label;

        CastingElementVisitor(String str) {
            this.label = str;
        }

        /* access modifiers changed from: protected */
        public final T defaultAction(Element element, Void voidR) {
            throw new IllegalArgumentException(element + " does not represent a " + this.label);
        }
    }

    private MoreElements() {
    }
}
