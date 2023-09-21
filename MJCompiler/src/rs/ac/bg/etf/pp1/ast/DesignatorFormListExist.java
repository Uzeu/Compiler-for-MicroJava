// generated with ast extension for cup
// version 0.8
// 13/8/2023 0:3:14


package rs.ac.bg.etf.pp1.ast;

public class DesignatorFormListExist extends DesignatorFormList {

    private DesignatorFormList DesignatorFormList;
    private DesignatorForm DesignatorForm;

    public DesignatorFormListExist (DesignatorFormList DesignatorFormList, DesignatorForm DesignatorForm) {
        this.DesignatorFormList=DesignatorFormList;
        if(DesignatorFormList!=null) DesignatorFormList.setParent(this);
        this.DesignatorForm=DesignatorForm;
        if(DesignatorForm!=null) DesignatorForm.setParent(this);
    }

    public DesignatorFormList getDesignatorFormList() {
        return DesignatorFormList;
    }

    public void setDesignatorFormList(DesignatorFormList DesignatorFormList) {
        this.DesignatorFormList=DesignatorFormList;
    }

    public DesignatorForm getDesignatorForm() {
        return DesignatorForm;
    }

    public void setDesignatorForm(DesignatorForm DesignatorForm) {
        this.DesignatorForm=DesignatorForm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorFormList!=null) DesignatorFormList.accept(visitor);
        if(DesignatorForm!=null) DesignatorForm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorFormList!=null) DesignatorFormList.traverseTopDown(visitor);
        if(DesignatorForm!=null) DesignatorForm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorFormList!=null) DesignatorFormList.traverseBottomUp(visitor);
        if(DesignatorForm!=null) DesignatorForm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorFormListExist(\n");

        if(DesignatorFormList!=null)
            buffer.append(DesignatorFormList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorForm!=null)
            buffer.append(DesignatorForm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorFormListExist]");
        return buffer.toString();
    }
}
