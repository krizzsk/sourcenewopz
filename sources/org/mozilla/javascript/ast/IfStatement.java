package org.mozilla.javascript.ast;

public class IfStatement extends AstNode {
    private AstNode condition;
    private AstNode elsePart;
    private int elsePosition = -1;

    /* renamed from: lp */
    private int f6638lp = -1;

    /* renamed from: rp */
    private int f6639rp = -1;
    private AstNode thenPart;

    public IfStatement() {
        this.type = 112;
    }

    public IfStatement(int i) {
        super(i);
        this.type = 112;
    }

    public IfStatement(int i, int i2) {
        super(i, i2);
        this.type = 112;
    }

    public AstNode getCondition() {
        return this.condition;
    }

    public void setCondition(AstNode astNode) {
        assertNotNull(astNode);
        this.condition = astNode;
        astNode.setParent(this);
    }

    public AstNode getThenPart() {
        return this.thenPart;
    }

    public void setThenPart(AstNode astNode) {
        assertNotNull(astNode);
        this.thenPart = astNode;
        astNode.setParent(this);
    }

    public AstNode getElsePart() {
        return this.elsePart;
    }

    public void setElsePart(AstNode astNode) {
        this.elsePart = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public int getElsePosition() {
        return this.elsePosition;
    }

    public void setElsePosition(int i) {
        this.elsePosition = i;
    }

    public int getLp() {
        return this.f6638lp;
    }

    public void setLp(int i) {
        this.f6638lp = i;
    }

    public int getRp() {
        return this.f6639rp;
    }

    public void setRp(int i) {
        this.f6639rp = i;
    }

    public void setParens(int i, int i2) {
        this.f6638lp = i;
        this.f6639rp = i2;
    }

    public String toSource(int i) {
        String makeIndent = makeIndent(i);
        StringBuilder sb = new StringBuilder(32);
        sb.append(makeIndent);
        sb.append("if (");
        sb.append(this.condition.toSource(0));
        sb.append(") ");
        if (this.thenPart.getType() != 129) {
            sb.append("\n");
            sb.append(makeIndent(i + 1));
        }
        sb.append(this.thenPart.toSource(i).trim());
        if (this.elsePart != null) {
            if (this.thenPart.getType() != 129) {
                sb.append("\n");
                sb.append(makeIndent);
                sb.append("else ");
            } else {
                sb.append(" else ");
            }
            if (!(this.elsePart.getType() == 129 || this.elsePart.getType() == 112)) {
                sb.append("\n");
                sb.append(makeIndent(i + 1));
            }
            sb.append(this.elsePart.toSource(i).trim());
        }
        sb.append("\n");
        return sb.toString();
    }

    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.condition.visit(nodeVisitor);
            this.thenPart.visit(nodeVisitor);
            AstNode astNode = this.elsePart;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
        }
    }
}
