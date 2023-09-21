// generated with ast extension for cup
// version 0.8
// 13/8/2023 0:3:14


package rs.ac.bg.etf.pp1.ast;

public class BracketsName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String bracketsName;

    public BracketsName (String bracketsName) {
        this.bracketsName=bracketsName;
    }

    public String getBracketsName() {
        return bracketsName;
    }

    public void setBracketsName(String bracketsName) {
        this.bracketsName=bracketsName;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BracketsName(\n");

        buffer.append(" "+tab+bracketsName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BracketsName]");
        return buffer.toString();
    }
}
