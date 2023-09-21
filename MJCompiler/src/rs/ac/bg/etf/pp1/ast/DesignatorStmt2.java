// generated with ast extension for cup
// version 0.8
// 13/8/2023 0:3:14


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmt2 extends DesignatorStatement {

    private DesignatorForm DesignatorForm;
    private DesignatorFormList DesignatorFormList;
    private Designator Designator;

    public DesignatorStmt2 (DesignatorForm DesignatorForm, DesignatorFormList DesignatorFormList, Designator Designator) {
        this.DesignatorForm=DesignatorForm;
        if(DesignatorForm!=null) DesignatorForm.setParent(this);
        this.DesignatorFormList=DesignatorFormList;
        if(DesignatorFormList!=null) DesignatorFormList.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public DesignatorForm getDesignatorForm() {
        return DesignatorForm;
    }

    public void setDesignatorForm(DesignatorForm DesignatorForm) {
        this.DesignatorForm=DesignatorForm;
    }

    public DesignatorFormList getDesignatorFormList() {
        return DesignatorFormList;
    }

    public void setDesignatorFormList(DesignatorFormList DesignatorFormList) {
        this.DesignatorFormList=DesignatorFormList;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorForm!=null) DesignatorForm.accept(visitor);
        if(DesignatorFormList!=null) DesignatorFormList.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorForm!=null) DesignatorForm.traverseTopDown(visitor);
        if(DesignatorFormList!=null) DesignatorFormList.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorForm!=null) DesignatorForm.traverseBottomUp(visitor);
        if(DesignatorFormList!=null) DesignatorFormList.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmt2(\n");

        if(DesignatorForm!=null)
            buffer.append(DesignatorForm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorFormList!=null)
            buffer.append(DesignatorFormList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmt2]");
        return buffer.toString();
    }
}
