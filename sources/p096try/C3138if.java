package p096try;

import com.iproov.sdk.core.C19887for;
import com.iproov.sdk.core.exception.IProovException;
import p092super.C3103this;
import p093switch.C3127throw;
import p096try.C3138if;
import p235for.C20836do;

/* renamed from: try.if */
/* compiled from: State */
public abstract class C3138if {

    /* renamed from: do */
    private String f6989do;

    /* renamed from: try.if$break */
    /* compiled from: State */
    public static final class C3139break extends C3138if {

        /* renamed from: for  reason: not valid java name */
        private final String f61727for;

        /* renamed from: if */
        private final double f6990if;

        public C3139break(double d, String str) {
            this.f6990if = d;
            this.f61727for = str;
        }

        /* renamed from: do */
        public void mo38671do(C3147this thisR) {
            C3138if.super.m46219for(thisR);
            thisR.mo38687do(this);
        }

        /* renamed from: do */
        public boolean mo38672do() {
            return true;
        }

        /* renamed from: new  reason: not valid java name */
        public String m46221new() {
            return this.f61727for;
        }

        public String toString() {
            return C3138if.super.toString() + " (" + this.f6990if + " - " + this.f61727for + ")";
        }

        /* renamed from: try  reason: not valid java name */
        public double m46222try() {
            return this.f6990if;
        }
    }

    /* renamed from: try.if$case */
    /* compiled from: State */
    public static final class C3140case extends C3138if {

        /* renamed from: if */
        private final C19887for f6991if;

        public C3140case(C19887for forR) {
            this.f6991if = forR;
        }

        /* renamed from: do */
        public void mo38671do(C3147this thisR) {
            C3138if.super.m46219for(thisR);
            thisR.mo38688do(this);
        }

        /* renamed from: if */
        public boolean mo38675if() {
            return true;
        }

        /* renamed from: new  reason: not valid java name */
        public C19887for m46223new() {
            return this.f6991if;
        }
    }

    /* renamed from: try.if$do */
    /* compiled from: State */
    public static final class C3141do extends C3138if {
        /* renamed from: do */
        public void mo38671do(C3147this thisR) {
            C3138if.super.m46219for(thisR);
            thisR.mo38689do(this);
        }

        /* renamed from: if */
        public boolean mo38675if() {
            return true;
        }
    }

    /* renamed from: try.if$for */
    /* compiled from: State */
    public static final class C3143for extends C3138if {

        /* renamed from: if */
        private final String f6993if;

        public C3143for(String str) {
            this.f6993if = str;
        }

        /* renamed from: do */
        public void mo38671do(C3147this thisR) {
            C3138if.super.m46219for(thisR);
            thisR.mo38691do(this);
        }

        /* renamed from: new  reason: not valid java name */
        public String m46228new() {
            return this.f6993if;
        }
    }

    /* renamed from: try.if$goto */
    /* compiled from: State */
    public static final class C3144goto extends C3138if {
    }

    /* renamed from: try.if$if */
    /* compiled from: State */
    public static final class C3145if extends C3138if {

        /* renamed from: for  reason: not valid java name */
        private final C3103this f61731for;

        /* renamed from: if */
        private final C3136do f6994if;

        public C3145if(C3136do doVar, C3103this thisR) {
            this.f6994if = doVar;
            this.f61731for = thisR;
        }

        /* renamed from: do */
        public void mo38671do(C3147this thisR) {
            C3138if.super.m46219for(thisR);
            thisR.mo38692do(this);
        }

        /* renamed from: do */
        public boolean mo38672do() {
            return true;
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m46229for() {
            return this.f6994if == C3136do.READY;
        }

        /* renamed from: new  reason: not valid java name */
        public C3136do m46230new() {
            return this.f6994if;
        }

        public String toString() {
            return C3145if.class.getSimpleName() + " (" + this.f6994if + ")";
        }

        /* renamed from: try  reason: not valid java name */
        public C3103this m46231try() {
            return this.f61731for;
        }
    }

    /* renamed from: try.if$new */
    /* compiled from: State */
    public static final class C3146new extends C3138if {
        /* renamed from: do */
        public void mo38671do(C3147this thisR) {
            C3138if.super.m46219for(thisR);
            thisR.mo38693do(this);
        }
    }

    /* renamed from: try.if$this */
    /* compiled from: State */
    public interface C3147this {
        /* renamed from: do */
        void mo38687do(C3139break breakR);

        /* renamed from: do */
        void mo38688do(C3140case caseR);

        /* renamed from: do */
        void mo38689do(C3141do doVar);

        /* renamed from: do */
        void mo38690do(C3142else elseR);

        /* renamed from: do */
        void mo38691do(C3143for forR);

        /* renamed from: do */
        void mo38692do(C3145if ifVar);

        /* renamed from: do */
        void mo38693do(C3146new newR);

        /* renamed from: do */
        void mo38694do(C3148try tryR);

        /* renamed from: do */
        void mo38695do(C3138if ifVar);
    }

    /* renamed from: try.if$try */
    /* compiled from: State */
    public static final class C3148try extends C3138if {

        /* renamed from: if */
        private final IProovException f6995if;

        public C3148try(IProovException iProovException) {
            this.f6995if = iProovException;
        }

        /* renamed from: do */
        public void mo38671do(C3147this thisR) {
            C3138if.super.m46219for(thisR);
            thisR.mo38694do(this);
        }

        /* renamed from: if */
        public boolean mo38675if() {
            return true;
        }

        /* renamed from: new  reason: not valid java name */
        public IProovException m46232new() {
            return this.f6995if;
        }

        public String toString() {
            return C3138if.super.toString() + " - " + this.f6995if.getReason() + " - " + this.f6995if.getMessage();
        }
    }

    /* renamed from: do */
    public void m46219for(C3147this thisR) {
        thisR.mo38695do(this);
    }

    /* renamed from: do */
    public boolean mo38672do() {
        return false;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m46220for() {
        return false;
    }

    /* renamed from: if */
    public final void mo38674if(C3147this thisR) {
        C3127throw.m4052do((Runnable) new Runnable(thisR) {
            public final /* synthetic */ C3138if.C3147this f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                C3138if.this.m46219for(this.f$1);
            }
        });
    }

    /* renamed from: if */
    public boolean mo38675if() {
        return false;
    }

    public String toString() {
        if (this.f6989do == null) {
            this.f6989do = getClass().getSimpleName();
        }
        return this.f6989do;
    }

    /* renamed from: try.if$else */
    /* compiled from: State */
    public static final class C3142else extends C3138if {

        /* renamed from: for  reason: not valid java name */
        private final int f61728for;

        /* renamed from: if */
        private final C20836do f6992if;

        /* renamed from: new  reason: not valid java name */
        private final float f61729new;

        /* renamed from: try  reason: not valid java name */
        private final C3103this f61730try;

        public C3142else(C20836do doVar, int i, float f, float f2) {
            this.f6992if = doVar;
            this.f61728for = i;
            this.f61729new = f2;
            this.f61730try = null;
        }

        /* renamed from: case  reason: not valid java name */
        public float m46224case() {
            return this.f61729new;
        }

        /* renamed from: do */
        public void mo38671do(C3147this thisR) {
            C3138if.super.m46219for(thisR);
            thisR.mo38690do(this);
        }

        /* renamed from: do */
        public boolean mo38672do() {
            return true;
        }

        /* renamed from: else  reason: not valid java name */
        public boolean m46225else() {
            return this.f6992if == null;
        }

        /* renamed from: new  reason: not valid java name */
        public int m46226new() {
            return this.f61728for;
        }

        public String toString() {
            return C3138if.super.toString() + " (" + this.f6992if + ")";
        }

        /* renamed from: try  reason: not valid java name */
        public C3103this m46227try() {
            return this.f61730try;
        }

        public C3142else(C3103this thisR) {
            this.f6992if = null;
            this.f61728for = 0;
            this.f61729new = 0.0f;
            this.f61730try = thisR;
        }
    }
}
