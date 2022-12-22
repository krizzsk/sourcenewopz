package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

public final class DescriptorResolverUtils {
    /* renamed from: a */
    private static /* synthetic */ void m44598a(int i) {
        String str = i != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i != 18 ? 3 : 2)];
        switch (i) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
            default:
                objArr[0] = "name";
                break;
        }
        if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        throw (i != 18 ? new IllegalArgumentException(format) : new IllegalStateException(format));
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, ErrorReporter errorReporter, OverridingUtil overridingUtil) {
        if (name == null) {
            m44598a(0);
        }
        if (collection == null) {
            m44598a(1);
        }
        if (collection2 == null) {
            m44598a(2);
        }
        if (classDescriptor == null) {
            m44598a(3);
        }
        if (errorReporter == null) {
            m44598a(4);
        }
        if (overridingUtil == null) {
            m44598a(5);
        }
        return m44597a(name, collection, collection2, classDescriptor, errorReporter, overridingUtil, false);
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, ErrorReporter errorReporter, OverridingUtil overridingUtil) {
        if (name == null) {
            m44598a(6);
        }
        if (collection == null) {
            m44598a(7);
        }
        if (collection2 == null) {
            m44598a(8);
        }
        if (classDescriptor == null) {
            m44598a(9);
        }
        if (errorReporter == null) {
            m44598a(10);
        }
        if (overridingUtil == null) {
            m44598a(11);
        }
        return m44597a(name, collection, collection2, classDescriptor, errorReporter, overridingUtil, true);
    }

    /* renamed from: a */
    private static <D extends CallableMemberDescriptor> Collection<D> m44597a(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, final ErrorReporter errorReporter, OverridingUtil overridingUtil, final boolean z) {
        if (name == null) {
            m44598a(12);
        }
        if (collection == null) {
            m44598a(13);
        }
        if (collection2 == null) {
            m44598a(14);
        }
        if (classDescriptor == null) {
            m44598a(15);
        }
        if (errorReporter == null) {
            m44598a(16);
        }
        if (overridingUtil == null) {
            m44598a(17);
        }
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        overridingUtil.generateOverridesInFunctionGroup(name, collection, collection2, classDescriptor, new NonReportingOverrideStrategy() {
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "fromSuper";
                } else if (i == 2) {
                    objArr[0] = "fromCurrent";
                } else if (i == 3) {
                    objArr[0] = "member";
                } else if (i != 4) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "overridden";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
                if (i == 1 || i == 2) {
                    objArr[2] = "conflict";
                } else if (i == 3 || i == 4) {
                    objArr[2] = "setOverriddenDescriptors";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                if (callableMemberDescriptor2 == null) {
                    $$$reportNull$$$0(2);
                }
            }

            public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    $$$reportNull$$$0(0);
                }
                OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, new Function1<CallableMemberDescriptor, Unit>() {
                    private static /* synthetic */ void $$$reportNull$$$0(int i) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"}));
                    }

                    public Unit invoke(CallableMemberDescriptor callableMemberDescriptor) {
                        if (callableMemberDescriptor == null) {
                            $$$reportNull$$$0(0);
                        }
                        errorReporter.reportCannotInferVisibility(callableMemberDescriptor);
                        return Unit.INSTANCE;
                    }
                });
                linkedHashSet.add(callableMemberDescriptor);
            }

            public void setOverriddenDescriptors(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection) {
                if (callableMemberDescriptor == null) {
                    $$$reportNull$$$0(3);
                }
                if (collection == null) {
                    $$$reportNull$$$0(4);
                }
                if (!z || callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                    super.setOverriddenDescriptors(callableMemberDescriptor, collection);
                }
            }
        });
        return linkedHashSet;
    }

    public static ValueParameterDescriptor getAnnotationParameterByName(Name name, ClassDescriptor classDescriptor) {
        if (name == null) {
            m44598a(19);
        }
        if (classDescriptor == null) {
            m44598a(20);
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        if (constructors.size() != 1) {
            return null;
        }
        for (ValueParameterDescriptor next : constructors.iterator().next().getValueParameters()) {
            if (next.getName().equals(name)) {
                return next;
            }
        }
        return null;
    }
}
