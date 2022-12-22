package org.mozilla.javascript.ast;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class ElementGet extends AstNode {
    private AstNode element;

    /* renamed from: lb */
    private int f6630lb = -1;

    /* renamed from: rb */
    private int f6631rb = -1;
    private AstNode target;

    public ElementGet() {
        this.type = 36;
    }

    public ElementGet(int i) {
        super(i);
        this.type = 36;
    }

    public ElementGet(int i, int i2) {
        super(i, i2);
        this.type = 36;
    }

    public ElementGet(AstNode astNode, AstNode astNode2) {
        this.type = 36;
        setTarget(astNode);
        setElement(astNode2);
    }

    public AstNode getTarget() {
        return this.target;
    }

    public void setTarget(AstNode astNode) {
        assertNotNull(astNode);
        this.target = astNode;
        astNode.setParent(this);
    }

    public AstNode getElement() {
        return this.element;
    }

    public void setElement(AstNode astNode) {
        assertNotNull(astNode);
        this.element = astNode;
        astNode.setParent(this);
    }

    public int getLb() {
        return this.f6630lb;
    }

    public void setLb(int i) {
        this.f6630lb = i;
    }

    public int getRb() {
        return this.f6631rb;
    }

    public void setRb(int i) {
        this.f6631rb = i;
    }

    public void setParens(int i, int i2) {
        this.f6630lb = i;
        this.f6631rb = i2;
    }

    public String toSource(int i) {
        return makeIndent(i) + this.target.toSource(0) + Const.jaLeft + this.element.toSource(0) + Const.jaRight;
    }

    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            this.element.visit(nodeVisitor);
        }
    }
}
