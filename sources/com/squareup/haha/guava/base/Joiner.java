package com.squareup.haha.guava.base;

import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.squareup.haha.guava.collect.ImmutableList;
import com.squareup.haha.guava.collect.Iterators;
import com.squareup.haha.guava.collect.Lists$RandomAccessReverseList;
import com.squareup.haha.guava.collect.Lists$ReverseList;
import com.squareup.haha.guava.collect.Multiset;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import org.osgi.framework.VersionRange;

public class Joiner {
    private final String separator;

    /* synthetic */ Joiner(Joiner joiner, byte b) {
        this(joiner);
    }

    public Joiner(String str) {
        this.separator = (String) checkNotNull(str);
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    @CheckReturnValue
    public Joiner useForNull(final String str) {
        checkNotNull(str);
        return new Joiner(this) {
            /* access modifiers changed from: package-private */
            public final CharSequence toString(@Nullable Object obj) {
                return obj == null ? str : Joiner.this.toString(obj);
            }

            public final Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    public static final class MapJoiner {
        public /* synthetic */ MapJoiner(Joiner joiner, String str, byte b) {
            this(joiner, str);
        }

        private MapJoiner(Joiner joiner, String str) {
            Joiner.checkNotNull(str);
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence toString(Object obj) {
        checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final StringBuilder appendTo(StringBuilder sb, Iterator<?> it) {
        try {
            checkNotNull(sb);
            if (it.hasNext()) {
                sb.append(toString(it.next()));
                while (it.hasNext()) {
                    sb.append(this.separator);
                    sb.append(toString(it.next()));
                }
            }
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CheckReturnValue
    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static int checkElementIndex(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = format("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            str = format("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static int checkPositionIndex(int i, int i2) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(badPositionIndex(i, i2, "index"));
    }

    static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException("negative size: " + i2);
        }
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = badPositionIndex(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = badPositionIndex(i2, i3, "end index");
            } else {
                str = format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    static String format(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i = 0;
        int i2 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf(InvitationTrackFragment.INVITE_DATE, i2)) != -1) {
            sb.append(valueOf.substring(i2, indexOf));
            sb.append(objArr[i]);
            int i3 = i + 1;
            i2 = indexOf + 2;
            i = i3;
        }
        sb.append(valueOf.substring(i2));
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(VersionRange.RIGHT_CLOSED);
        }
        return sb.toString();
    }

    public static void checkRemove(boolean z) {
        if (!z) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof Lists$ReverseList) {
            return ((Lists$ReverseList) list).forwardList;
        }
        if (list instanceof RandomAccess) {
            return new Lists$RandomAccessReverseList(list);
        }
        return new Lists$ReverseList(list);
    }

    public static boolean equalsImpl(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    public static boolean removeAllImpl(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static boolean removeAllImpl(Set<?> set, Collection<?> collection) {
        checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return removeAllImpl(set, collection.iterator());
        }
        return Iterators.removeAll(set.iterator(), collection);
    }

    public static int hash(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
