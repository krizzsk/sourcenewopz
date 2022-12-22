package com.google.auto.common;

import com.google.common.base.Equivalence;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleTypeVisitor6;
import javax.lang.model.util.Types;

public final class MoreTypes {
    private static final Method GET_BOUNDS;
    private static final int HASH_MULTIPLIER = 31;
    private static final int HASH_SEED = 17;
    private static final Class<?> INTERSECTION_TYPE;

    private static final class TypeEquivalence extends Equivalence<TypeMirror> {
        /* access modifiers changed from: private */
        public static final TypeEquivalence INSTANCE = new TypeEquivalence();

        private TypeEquivalence() {
        }

        /* access modifiers changed from: protected */
        public boolean doEquivalent(TypeMirror typeMirror, TypeMirror typeMirror2) {
            return MoreTypes.equal(typeMirror, typeMirror2, ImmutableSet.m38415of());
        }

        /* access modifiers changed from: protected */
        public int doHash(TypeMirror typeMirror) {
            return MoreTypes.hash(typeMirror, ImmutableSet.m38415of());
        }
    }

    public static Equivalence<TypeMirror> equivalence() {
        return TypeEquivalence.INSTANCE;
    }

    private static final class EqualVisitorParam {
        TypeMirror type;
        Set<ComparedElements> visiting;

        private EqualVisitorParam() {
        }
    }

    private static class ComparedElements {

        /* renamed from: a */
        final Element f53581a;
        final ImmutableList<TypeMirror> aArguments;

        /* renamed from: b */
        final Element f53582b;
        final ImmutableList<TypeMirror> bArguments;

        ComparedElements(Element element, ImmutableList<TypeMirror> immutableList, Element element2, ImmutableList<TypeMirror> immutableList2) {
            this.f53581a = element;
            this.aArguments = immutableList;
            this.f53582b = element2;
            this.bArguments = immutableList2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ComparedElements) {
                ComparedElements comparedElements = (ComparedElements) obj;
                int size = this.aArguments.size();
                if (this.f53581a.equals(comparedElements.f53581a) && this.f53582b.equals(comparedElements.f53582b) && size == this.bArguments.size()) {
                    for (int i = 0; i < size; i++) {
                        if (this.aArguments.get(i) != this.bArguments.get(i)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f53581a.hashCode() * 31) + this.f53582b.hashCode();
        }
    }

    private static final class EqualVisitor extends SimpleTypeVisitor6<Boolean, EqualVisitorParam> {
        /* access modifiers changed from: private */
        public static final EqualVisitor INSTANCE = new EqualVisitor();

        private EqualVisitor() {
        }

        /* access modifiers changed from: protected */
        public Boolean defaultAction(TypeMirror typeMirror, EqualVisitorParam equalVisitorParam) {
            return Boolean.valueOf(typeMirror.getKind().equals(equalVisitorParam.type.getKind()));
        }

        public Boolean visitArray(ArrayType arrayType, EqualVisitorParam equalVisitorParam) {
            if (equalVisitorParam.type.getKind().equals(TypeKind.ARRAY)) {
                return Boolean.valueOf(MoreTypes.equal(arrayType.getComponentType(), equalVisitorParam.type.getComponentType(), equalVisitorParam.visiting));
            }
            return false;
        }

        public Boolean visitDeclared(DeclaredType declaredType, EqualVisitorParam equalVisitorParam) {
            boolean z = false;
            if (!equalVisitorParam.type.getKind().equals(TypeKind.DECLARED)) {
                return false;
            }
            DeclaredType declaredType2 = equalVisitorParam.type;
            Element asElement = declaredType.asElement();
            Element asElement2 = declaredType2.asElement();
            Set<ComparedElements> visitingSetPlus = visitingSetPlus(equalVisitorParam.visiting, asElement, declaredType.getTypeArguments(), asElement2, declaredType2.getTypeArguments());
            if (visitingSetPlus.equals(equalVisitorParam.visiting)) {
                return true;
            }
            if (asElement.equals(asElement2) && MoreTypes.equal(MoreTypes.enclosingType(declaredType), MoreTypes.enclosingType(declaredType2), visitingSetPlus) && MoreTypes.equalLists(declaredType.getTypeArguments(), declaredType2.getTypeArguments(), visitingSetPlus)) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        public Boolean visitError(ErrorType errorType, EqualVisitorParam equalVisitorParam) {
            return Boolean.valueOf(errorType.equals(equalVisitorParam.type));
        }

        public Boolean visitExecutable(ExecutableType executableType, EqualVisitorParam equalVisitorParam) {
            boolean z = false;
            if (!equalVisitorParam.type.getKind().equals(TypeKind.EXECUTABLE)) {
                return false;
            }
            ExecutableType executableType2 = equalVisitorParam.type;
            if (MoreTypes.equalLists(executableType.getParameterTypes(), executableType2.getParameterTypes(), equalVisitorParam.visiting) && MoreTypes.equal(executableType.getReturnType(), executableType2.getReturnType(), equalVisitorParam.visiting) && MoreTypes.equalLists(executableType.getThrownTypes(), executableType2.getThrownTypes(), equalVisitorParam.visiting) && MoreTypes.equalLists(executableType.getTypeVariables(), executableType2.getTypeVariables(), equalVisitorParam.visiting)) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        public Boolean visitTypeVariable(TypeVariable typeVariable, EqualVisitorParam equalVisitorParam) {
            boolean z = false;
            if (!equalVisitorParam.type.getKind().equals(TypeKind.TYPEVAR)) {
                return false;
            }
            TypeVariable typeVariable2 = equalVisitorParam.type;
            TypeParameterElement asElement = typeVariable.asElement();
            TypeParameterElement asElement2 = typeVariable2.asElement();
            Set<ComparedElements> visitingSetPlus = visitingSetPlus(equalVisitorParam.visiting, asElement, asElement2);
            if (visitingSetPlus.equals(equalVisitorParam.visiting)) {
                return true;
            }
            if (MoreTypes.equalLists(asElement.getBounds(), asElement2.getBounds(), visitingSetPlus) && MoreTypes.equal(typeVariable.getLowerBound(), typeVariable2.getLowerBound(), visitingSetPlus) && typeVariable.asElement().getSimpleName().equals(typeVariable2.asElement().getSimpleName())) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        public Boolean visitWildcard(WildcardType wildcardType, EqualVisitorParam equalVisitorParam) {
            boolean z = false;
            if (!equalVisitorParam.type.getKind().equals(TypeKind.WILDCARD)) {
                return false;
            }
            WildcardType wildcardType2 = equalVisitorParam.type;
            if (MoreTypes.equal(wildcardType.getExtendsBound(), wildcardType2.getExtendsBound(), equalVisitorParam.visiting) && MoreTypes.equal(wildcardType.getSuperBound(), wildcardType2.getSuperBound(), equalVisitorParam.visiting)) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        public Boolean visitUnknown(TypeMirror typeMirror, EqualVisitorParam equalVisitorParam) {
            throw new UnsupportedOperationException();
        }

        private Set<ComparedElements> visitingSetPlus(Set<ComparedElements> set, Element element, Element element2) {
            ImmutableList of = ImmutableList.m38373of();
            return visitingSetPlus(set, element, of, element2, of);
        }

        private Set<ComparedElements> visitingSetPlus(Set<ComparedElements> set, Element element, List<? extends TypeMirror> list, Element element2, List<? extends TypeMirror> list2) {
            ComparedElements comparedElements = new ComparedElements(element, ImmutableList.copyOf(list), element2, ImmutableList.copyOf(list2));
            HashSet hashSet = new HashSet(set);
            hashSet.add(comparedElements);
            return hashSet;
        }
    }

    static {
        Method method;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("javax.lang.model.type.IntersectionType");
            Class<?> cls3 = cls2;
            method = cls2.getMethod("getBounds", new Class[0]);
            cls = cls3;
        } catch (Exception unused) {
            method = null;
        }
        INTERSECTION_TYPE = cls;
        GET_BOUNDS = method;
    }

    /* access modifiers changed from: private */
    public static boolean equal(TypeMirror typeMirror, TypeMirror typeMirror2, Set<ComparedElements> set) {
        if (Objects.equal(typeMirror, typeMirror2) && !(typeMirror instanceof ExecutableType)) {
            return true;
        }
        EqualVisitorParam equalVisitorParam = new EqualVisitorParam();
        equalVisitorParam.type = typeMirror2;
        equalVisitorParam.visiting = set;
        if (INTERSECTION_TYPE != null) {
            if (isIntersectionType(typeMirror)) {
                return equalIntersectionTypes(typeMirror, typeMirror2, set);
            }
            if (isIntersectionType(typeMirror2)) {
                return false;
            }
        }
        if (typeMirror == typeMirror2) {
            return true;
        }
        if (typeMirror == null || typeMirror2 == null || !((Boolean) typeMirror.accept(EqualVisitor.INSTANCE, equalVisitorParam)).booleanValue()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static TypeMirror enclosingType(DeclaredType declaredType) {
        TypeMirror enclosingType = declaredType.getEnclosingType();
        if (enclosingType.getKind().equals(TypeKind.NONE) || declaredType.asElement().getModifiers().contains(Modifier.STATIC)) {
            return null;
        }
        return enclosingType;
    }

    private static boolean isIntersectionType(TypeMirror typeMirror) {
        return typeMirror != null && typeMirror.getKind().name().equals("INTERSECTION");
    }

    private static boolean equalIntersectionTypes(TypeMirror typeMirror, TypeMirror typeMirror2, Set<ComparedElements> set) {
        if (!isIntersectionType(typeMirror2)) {
            return false;
        }
        try {
            return equalLists((List) GET_BOUNDS.invoke(typeMirror, new Object[0]), (List) GET_BOUNDS.invoke(typeMirror2, new Object[0]), set);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean equalLists(java.util.List<? extends javax.lang.model.type.TypeMirror> r3, java.util.List<? extends javax.lang.model.type.TypeMirror> r4, java.util.Set<com.google.auto.common.MoreTypes.ComparedElements> r5) {
        /*
            int r0 = r3.size()
            int r1 = r4.size()
            r2 = 0
            if (r0 == r1) goto L_0x000c
            return r2
        L_0x000c:
            java.util.Iterator r3 = r3.iterator()
            java.util.Iterator r4 = r4.iterator()
        L_0x0014:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0034
            boolean r0 = r4.hasNext()
            if (r0 != 0) goto L_0x0021
            return r2
        L_0x0021:
            java.lang.Object r0 = r3.next()
            javax.lang.model.type.TypeMirror r0 = (javax.lang.model.type.TypeMirror) r0
            java.lang.Object r1 = r4.next()
            javax.lang.model.type.TypeMirror r1 = (javax.lang.model.type.TypeMirror) r1
            boolean r0 = equal(r0, r1, r5)
            if (r0 != 0) goto L_0x0014
            return r2
        L_0x0034:
            boolean r3 = r3.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.auto.common.MoreTypes.equalLists(java.util.List, java.util.List, java.util.Set):boolean");
    }

    private static final class HashVisitor extends SimpleTypeVisitor6<Integer, Set<Element>> {
        /* access modifiers changed from: private */
        public static final HashVisitor INSTANCE = new HashVisitor();

        private HashVisitor() {
        }

        /* access modifiers changed from: package-private */
        public int hashKind(int i, TypeMirror typeMirror) {
            return (i * 31) + typeMirror.getKind().hashCode();
        }

        /* access modifiers changed from: protected */
        public Integer defaultAction(TypeMirror typeMirror, Set<Element> set) {
            return Integer.valueOf(hashKind(17, typeMirror));
        }

        public Integer visitArray(ArrayType arrayType, Set<Element> set) {
            return Integer.valueOf((hashKind(17, arrayType) * 31) + ((Integer) arrayType.getComponentType().accept(this, set)).intValue());
        }

        public Integer visitDeclared(DeclaredType declaredType, Set<Element> set) {
            Element asElement = declaredType.asElement();
            if (set.contains(asElement)) {
                return 0;
            }
            HashSet hashSet = new HashSet(set);
            hashSet.add(asElement);
            return Integer.valueOf((((((hashKind(17, declaredType) * 31) + declaredType.asElement().hashCode()) * 31) + ((Integer) declaredType.getEnclosingType().accept(this, hashSet)).intValue()) * 31) + MoreTypes.hashList(declaredType.getTypeArguments(), hashSet));
        }

        public Integer visitExecutable(ExecutableType executableType, Set<Element> set) {
            return Integer.valueOf((((((((hashKind(17, executableType) * 31) + MoreTypes.hashList(executableType.getParameterTypes(), set)) * 31) + ((Integer) executableType.getReturnType().accept(this, set)).intValue()) * 31) + MoreTypes.hashList(executableType.getThrownTypes(), set)) * 31) + MoreTypes.hashList(executableType.getTypeVariables(), set));
        }

        public Integer visitTypeVariable(TypeVariable typeVariable, Set<Element> set) {
            int hashKind = (hashKind(17, typeVariable) * 31) + ((Integer) typeVariable.getLowerBound().accept(this, set)).intValue();
            for (TypeMirror accept : typeVariable.asElement().getBounds()) {
                hashKind = (hashKind * 31) + ((Integer) accept.accept(this, set)).intValue();
            }
            return Integer.valueOf(hashKind);
        }

        public Integer visitWildcard(WildcardType wildcardType, Set<Element> set) {
            int i = 0;
            int hashKind = ((hashKind(17, wildcardType) * 31) + (wildcardType.getExtendsBound() == null ? 0 : ((Integer) wildcardType.getExtendsBound().accept(this, set)).intValue())) * 31;
            if (wildcardType.getSuperBound() != null) {
                i = ((Integer) wildcardType.getSuperBound().accept(this, set)).intValue();
            }
            return Integer.valueOf(hashKind + i);
        }

        public Integer visitUnknown(TypeMirror typeMirror, Set<Element> set) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    public static int hashList(List<? extends TypeMirror> list, Set<Element> set) {
        int i = 17;
        for (TypeMirror hash : list) {
            i = (i * 31) + hash(hash, set);
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static int hash(TypeMirror typeMirror, Set<Element> set) {
        if (typeMirror == null) {
            return 0;
        }
        return ((Integer) typeMirror.accept(HashVisitor.INSTANCE, set)).intValue();
    }

    public static ImmutableSet<TypeElement> referencedTypes(TypeMirror typeMirror) {
        Preconditions.checkNotNull(typeMirror);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        typeMirror.accept(ReferencedTypes.INSTANCE, builder);
        return builder.build();
    }

    private static final class ReferencedTypes extends SimpleTypeVisitor6<Void, ImmutableSet.Builder<TypeElement>> {
        /* access modifiers changed from: private */
        public static final ReferencedTypes INSTANCE = new ReferencedTypes();

        private ReferencedTypes() {
        }

        public Void visitArray(ArrayType arrayType, ImmutableSet.Builder<TypeElement> builder) {
            arrayType.getComponentType().accept(this, builder);
            return null;
        }

        public Void visitDeclared(DeclaredType declaredType, ImmutableSet.Builder<TypeElement> builder) {
            builder.add((Object) MoreElements.asType(declaredType.asElement()));
            for (TypeMirror accept : declaredType.getTypeArguments()) {
                accept.accept(this, builder);
            }
            return null;
        }

        public Void visitTypeVariable(TypeVariable typeVariable, ImmutableSet.Builder<TypeElement> builder) {
            typeVariable.getLowerBound().accept(this, builder);
            typeVariable.getUpperBound().accept(this, builder);
            return null;
        }

        public Void visitWildcard(WildcardType wildcardType, ImmutableSet.Builder<TypeElement> builder) {
            TypeMirror extendsBound = wildcardType.getExtendsBound();
            if (extendsBound != null) {
                extendsBound.accept(this, builder);
            }
            TypeMirror superBound = wildcardType.getSuperBound();
            if (superBound == null) {
                return null;
            }
            superBound.accept(this, builder);
            return null;
        }
    }

    public static Element asElement(TypeMirror typeMirror) {
        return (Element) typeMirror.accept(AsElementVisitor.INSTANCE, (Object) null);
    }

    private static final class AsElementVisitor extends SimpleTypeVisitor6<Element, Void> {
        /* access modifiers changed from: private */
        public static final AsElementVisitor INSTANCE = new AsElementVisitor();

        private AsElementVisitor() {
        }

        /* access modifiers changed from: protected */
        public Element defaultAction(TypeMirror typeMirror, Void voidR) {
            throw new IllegalArgumentException(typeMirror + " cannot be converted to an Element");
        }

        public Element visitDeclared(DeclaredType declaredType, Void voidR) {
            return declaredType.asElement();
        }

        public Element visitError(ErrorType errorType, Void voidR) {
            return errorType.asElement();
        }

        public Element visitTypeVariable(TypeVariable typeVariable, Void voidR) {
            return typeVariable.asElement();
        }
    }

    public static TypeElement asTypeElement(TypeMirror typeMirror) {
        return MoreElements.asType(asElement(typeMirror));
    }

    public static ImmutableSet<TypeElement> asTypeElements(Iterable<? extends TypeMirror> iterable) {
        Preconditions.checkNotNull(iterable);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (TypeMirror asTypeElement : iterable) {
            builder.add((Object) asTypeElement(asTypeElement));
        }
        return builder.build();
    }

    public static ArrayType asArray(TypeMirror typeMirror) {
        return (ArrayType) typeMirror.accept(ArrayTypeVisitor.INSTANCE, (Object) null);
    }

    private static final class ArrayTypeVisitor extends CastingTypeVisitor<ArrayType> {
        /* access modifiers changed from: private */
        public static final ArrayTypeVisitor INSTANCE = new ArrayTypeVisitor();

        public ArrayType visitArray(ArrayType arrayType, Void voidR) {
            return arrayType;
        }

        ArrayTypeVisitor() {
            super("primitive array");
        }
    }

    public static DeclaredType asDeclared(TypeMirror typeMirror) {
        return (DeclaredType) typeMirror.accept(DeclaredTypeVisitor.INSTANCE, (Object) null);
    }

    private static final class DeclaredTypeVisitor extends CastingTypeVisitor<DeclaredType> {
        /* access modifiers changed from: private */
        public static final DeclaredTypeVisitor INSTANCE = new DeclaredTypeVisitor();

        public DeclaredType visitDeclared(DeclaredType declaredType, Void voidR) {
            return declaredType;
        }

        DeclaredTypeVisitor() {
            super("declared type");
        }
    }

    public static ErrorType asError(TypeMirror typeMirror) {
        return (ErrorType) typeMirror.accept(ErrorTypeVisitor.INSTANCE, (Object) null);
    }

    private static final class ErrorTypeVisitor extends CastingTypeVisitor<ErrorType> {
        /* access modifiers changed from: private */
        public static final ErrorTypeVisitor INSTANCE = new ErrorTypeVisitor();

        public ErrorType visitError(ErrorType errorType, Void voidR) {
            return errorType;
        }

        ErrorTypeVisitor() {
            super("error type");
        }
    }

    public static ExecutableType asExecutable(TypeMirror typeMirror) {
        return (ExecutableType) typeMirror.accept(ExecutableTypeVisitor.INSTANCE, (Object) null);
    }

    private static final class ExecutableTypeVisitor extends CastingTypeVisitor<ExecutableType> {
        /* access modifiers changed from: private */
        public static final ExecutableTypeVisitor INSTANCE = new ExecutableTypeVisitor();

        public ExecutableType visitExecutable(ExecutableType executableType, Void voidR) {
            return executableType;
        }

        ExecutableTypeVisitor() {
            super("executable type");
        }
    }

    public static NoType asNoType(TypeMirror typeMirror) {
        return (NoType) typeMirror.accept(NoTypeVisitor.INSTANCE, (Object) null);
    }

    private static final class NoTypeVisitor extends CastingTypeVisitor<NoType> {
        /* access modifiers changed from: private */
        public static final NoTypeVisitor INSTANCE = new NoTypeVisitor();

        public NoType visitNoType(NoType noType, Void voidR) {
            return noType;
        }

        NoTypeVisitor() {
            super("non-type");
        }
    }

    public static NullType asNullType(TypeMirror typeMirror) {
        return (NullType) typeMirror.accept(NullTypeVisitor.INSTANCE, (Object) null);
    }

    private static final class NullTypeVisitor extends CastingTypeVisitor<NullType> {
        /* access modifiers changed from: private */
        public static final NullTypeVisitor INSTANCE = new NullTypeVisitor();

        public NullType visitNull(NullType nullType, Void voidR) {
            return nullType;
        }

        NullTypeVisitor() {
            super("null");
        }
    }

    public static PrimitiveType asPrimitiveType(TypeMirror typeMirror) {
        return (PrimitiveType) typeMirror.accept(PrimitiveTypeVisitor.INSTANCE, (Object) null);
    }

    private static final class PrimitiveTypeVisitor extends CastingTypeVisitor<PrimitiveType> {
        /* access modifiers changed from: private */
        public static final PrimitiveTypeVisitor INSTANCE = new PrimitiveTypeVisitor();

        public PrimitiveType visitPrimitive(PrimitiveType primitiveType, Void voidR) {
            return primitiveType;
        }

        PrimitiveTypeVisitor() {
            super("primitive type");
        }
    }

    public static TypeVariable asTypeVariable(TypeMirror typeMirror) {
        return (TypeVariable) typeMirror.accept(TypeVariableVisitor.INSTANCE, (Object) null);
    }

    private static final class TypeVariableVisitor extends CastingTypeVisitor<TypeVariable> {
        /* access modifiers changed from: private */
        public static final TypeVariableVisitor INSTANCE = new TypeVariableVisitor();

        public TypeVariable visitTypeVariable(TypeVariable typeVariable, Void voidR) {
            return typeVariable;
        }

        TypeVariableVisitor() {
            super("type variable");
        }
    }

    public static WildcardType asWildcard(TypeMirror typeMirror) {
        return (WildcardType) typeMirror.accept(WildcardTypeVisitor.INSTANCE, (Object) null);
    }

    private static final class WildcardTypeVisitor extends CastingTypeVisitor<WildcardType> {
        /* access modifiers changed from: private */
        public static final WildcardTypeVisitor INSTANCE = new WildcardTypeVisitor();

        public WildcardType visitWildcard(WildcardType wildcardType, Void voidR) {
            return wildcardType;
        }

        WildcardTypeVisitor() {
            super("wildcard type");
        }
    }

    public static boolean isType(TypeMirror typeMirror) {
        return ((Boolean) typeMirror.accept(IsTypeVisitor.INSTANCE, (Object) null)).booleanValue();
    }

    private static final class IsTypeVisitor extends SimpleTypeVisitor6<Boolean, Void> {
        /* access modifiers changed from: private */
        public static final IsTypeVisitor INSTANCE = new IsTypeVisitor();

        private IsTypeVisitor() {
        }

        /* access modifiers changed from: protected */
        public Boolean defaultAction(TypeMirror typeMirror, Void voidR) {
            return false;
        }

        public Boolean visitNoType(NoType noType, Void voidR) {
            return Boolean.valueOf(noType.getKind().equals(TypeKind.VOID));
        }

        public Boolean visitPrimitive(PrimitiveType primitiveType, Void voidR) {
            return true;
        }

        public Boolean visitArray(ArrayType arrayType, Void voidR) {
            return true;
        }

        public Boolean visitDeclared(DeclaredType declaredType, Void voidR) {
            return Boolean.valueOf(MoreElements.isType(declaredType.asElement()));
        }
    }

    public static boolean isTypeOf(Class<?> cls, TypeMirror typeMirror) {
        Preconditions.checkNotNull(cls);
        return ((Boolean) typeMirror.accept(new IsTypeOf(cls), (Object) null)).booleanValue();
    }

    private static final class IsTypeOf extends SimpleTypeVisitor6<Boolean, Void> {
        private final Class<?> clazz;

        IsTypeOf(Class<?> cls) {
            this.clazz = cls;
        }

        /* access modifiers changed from: protected */
        public Boolean defaultAction(TypeMirror typeMirror, Void voidR) {
            throw new IllegalArgumentException(typeMirror + " cannot be represented as a Class<?>.");
        }

        public Boolean visitNoType(NoType noType, Void voidR) {
            if (noType.getKind().equals(TypeKind.VOID)) {
                return Boolean.valueOf(this.clazz.equals(Void.TYPE));
            }
            throw new IllegalArgumentException(noType + " cannot be represented as a Class<?>.");
        }

        public Boolean visitPrimitive(PrimitiveType primitiveType, Void voidR) {
            switch (C186972.$SwitchMap$javax$lang$model$type$TypeKind[primitiveType.getKind().ordinal()]) {
                case 1:
                    return Boolean.valueOf(this.clazz.equals(Boolean.TYPE));
                case 2:
                    return Boolean.valueOf(this.clazz.equals(Byte.TYPE));
                case 3:
                    return Boolean.valueOf(this.clazz.equals(Character.TYPE));
                case 4:
                    return Boolean.valueOf(this.clazz.equals(Double.TYPE));
                case 5:
                    return Boolean.valueOf(this.clazz.equals(Float.TYPE));
                case 6:
                    return Boolean.valueOf(this.clazz.equals(Integer.TYPE));
                case 7:
                    return Boolean.valueOf(this.clazz.equals(Long.TYPE));
                case 8:
                    return Boolean.valueOf(this.clazz.equals(Short.TYPE));
                default:
                    throw new IllegalArgumentException(primitiveType + " cannot be represented as a Class<?>.");
            }
        }

        public Boolean visitArray(ArrayType arrayType, Void voidR) {
            return Boolean.valueOf(this.clazz.isArray() && MoreTypes.isTypeOf(this.clazz.getComponentType(), arrayType.getComponentType()));
        }

        public Boolean visitDeclared(DeclaredType declaredType, Void voidR) {
            try {
                return Boolean.valueOf(MoreElements.asType(declaredType.asElement()).getQualifiedName().contentEquals(this.clazz.getCanonicalName()));
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException(declaredType + " does not represent a class or interface.");
            }
        }
    }

    /* renamed from: com.google.auto.common.MoreTypes$2 */
    static /* synthetic */ class C186972 {
        static final /* synthetic */ int[] $SwitchMap$javax$lang$model$type$TypeKind;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                javax.lang.model.type.TypeKind[] r0 = javax.lang.model.type.TypeKind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$javax$lang$model$type$TypeKind = r0
                javax.lang.model.type.TypeKind r1 = javax.lang.model.type.TypeKind.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$javax$lang$model$type$TypeKind     // Catch:{ NoSuchFieldError -> 0x001d }
                javax.lang.model.type.TypeKind r1 = javax.lang.model.type.TypeKind.BYTE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$javax$lang$model$type$TypeKind     // Catch:{ NoSuchFieldError -> 0x0028 }
                javax.lang.model.type.TypeKind r1 = javax.lang.model.type.TypeKind.CHAR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$javax$lang$model$type$TypeKind     // Catch:{ NoSuchFieldError -> 0x0033 }
                javax.lang.model.type.TypeKind r1 = javax.lang.model.type.TypeKind.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$javax$lang$model$type$TypeKind     // Catch:{ NoSuchFieldError -> 0x003e }
                javax.lang.model.type.TypeKind r1 = javax.lang.model.type.TypeKind.FLOAT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$javax$lang$model$type$TypeKind     // Catch:{ NoSuchFieldError -> 0x0049 }
                javax.lang.model.type.TypeKind r1 = javax.lang.model.type.TypeKind.INT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$javax$lang$model$type$TypeKind     // Catch:{ NoSuchFieldError -> 0x0054 }
                javax.lang.model.type.TypeKind r1 = javax.lang.model.type.TypeKind.LONG     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$javax$lang$model$type$TypeKind     // Catch:{ NoSuchFieldError -> 0x0060 }
                javax.lang.model.type.TypeKind r1 = javax.lang.model.type.TypeKind.SHORT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.auto.common.MoreTypes.C186972.<clinit>():void");
        }
    }

    public static Optional<DeclaredType> nonObjectSuperclass(final Types types, Elements elements, DeclaredType declaredType) {
        Preconditions.checkNotNull(types);
        Preconditions.checkNotNull(elements);
        Preconditions.checkNotNull(declaredType);
        final TypeMirror asType = elements.getTypeElement(Object.class.getCanonicalName()).asType();
        TypeMirror typeMirror = (TypeMirror) Iterables.getOnlyElement(FluentIterable.from(types.directSupertypes(declaredType)).filter(new Predicate<TypeMirror>() {
            public boolean apply(TypeMirror typeMirror) {
                return typeMirror.getKind().equals(TypeKind.DECLARED) && MoreElements.asType(MoreTypes.asDeclared(typeMirror).asElement()).getKind().equals(ElementKind.CLASS) && !types.isSameType(asType, typeMirror);
            }
        }), null);
        if (typeMirror != null) {
            return Optional.m38344of(asDeclared(typeMirror));
        }
        return Optional.absent();
    }

    public static TypeMirror asMemberOf(Types types, DeclaredType declaredType, VariableElement variableElement) {
        if (!variableElement.getKind().equals(ElementKind.PARAMETER)) {
            return types.asMemberOf(declaredType, variableElement);
        }
        ExecutableElement asExecutable = MoreElements.asExecutable(variableElement.getEnclosingElement());
        ExecutableType asExecutable2 = asExecutable(types.asMemberOf(declaredType, asExecutable));
        List parameters = asExecutable.getParameters();
        List parameterTypes = asExecutable2.getParameterTypes();
        Preconditions.checkState(parameters.size() == parameterTypes.size());
        for (int i = 0; i < parameters.size(); i++) {
            if (((VariableElement) parameters.get(i)).equals(variableElement)) {
                return (TypeMirror) parameterTypes.get(i);
            }
        }
        throw new IllegalStateException("Could not find variable: " + variableElement);
    }

    private static abstract class CastingTypeVisitor<T> extends SimpleTypeVisitor6<T, Void> {
        private final String label;

        CastingTypeVisitor(String str) {
            this.label = str;
        }

        /* access modifiers changed from: protected */
        public T defaultAction(TypeMirror typeMirror, Void voidR) {
            throw new IllegalArgumentException(typeMirror + " does not represent a " + this.label);
        }
    }

    private MoreTypes() {
    }
}
