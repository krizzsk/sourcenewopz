package com.p222hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;

/* renamed from: com.hp.hpl.sparta.xpath.Step */
public class Step {
    public static Step DOT = new Step(ThisNodeTest.f53980a, TrueExpr.f53981a);

    /* renamed from: a */
    private final NodeTest f53974a;

    /* renamed from: b */
    private final BooleanExpr f53975b;

    /* renamed from: c */
    private final boolean f53976c;

    Step(NodeTest nodeTest, BooleanExpr booleanExpr) {
        this.f53974a = nodeTest;
        this.f53975b = booleanExpr;
        this.f53976c = false;
    }

    Step(XPath xPath, boolean z, SimpleStreamTokenizer simpleStreamTokenizer) throws XPathException, IOException {
        this.f53976c = z;
        int i = simpleStreamTokenizer.ttype;
        if (i != -3) {
            if (i == 42) {
                this.f53974a = AllElementTest.f53958a;
            } else if (i != 46) {
                if (i != 64) {
                    throw new XPathException(xPath, "at begininning of step", simpleStreamTokenizer, "'.' or '*' or name");
                } else if (simpleStreamTokenizer.nextToken() == -3) {
                    this.f53974a = new AttrTest(simpleStreamTokenizer.sval);
                } else {
                    throw new XPathException(xPath, "after @ in node test", simpleStreamTokenizer, "name");
                }
            } else if (simpleStreamTokenizer.nextToken() == 46) {
                this.f53974a = ParentNodeTest.f53964a;
            } else {
                simpleStreamTokenizer.pushBack();
                this.f53974a = ThisNodeTest.f53980a;
            }
        } else if (!simpleStreamTokenizer.sval.equals("text")) {
            this.f53974a = new ElementTest(simpleStreamTokenizer.sval);
        } else if (simpleStreamTokenizer.nextToken() == 40 && simpleStreamTokenizer.nextToken() == 41) {
            this.f53974a = TextTest.f53979a;
        } else {
            throw new XPathException(xPath, "after text", simpleStreamTokenizer, "()");
        }
        if (simpleStreamTokenizer.nextToken() == 91) {
            simpleStreamTokenizer.nextToken();
            this.f53975b = ExprFactory.m38644a(xPath, simpleStreamTokenizer);
            if (simpleStreamTokenizer.ttype == 93) {
                simpleStreamTokenizer.nextToken();
                return;
            }
            throw new XPathException(xPath, "after predicate expression", simpleStreamTokenizer, Const.jaRight);
        }
        this.f53975b = TrueExpr.f53981a;
    }

    public String toString() {
        return this.f53974a.toString() + this.f53975b.toString();
    }

    public boolean isMultiLevel() {
        return this.f53976c;
    }

    public boolean isStringValue() {
        return this.f53974a.isStringValue();
    }

    public NodeTest getNodeTest() {
        return this.f53974a;
    }

    public BooleanExpr getPredicate() {
        return this.f53975b;
    }
}
