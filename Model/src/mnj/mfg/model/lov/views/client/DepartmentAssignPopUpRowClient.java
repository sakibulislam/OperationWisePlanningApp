package mnj.mfg.model.lov.views.client;

import oracle.jbo.client.remote.RowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Apr 12 13:26:57 BDT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DepartmentAssignPopUpRowClient extends RowImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public DepartmentAssignPopUpRowClient() {
    }

    public String getDepartment() {
        return (String)getAttribute("Department");
    }

    public void setDepartment(String value) {
        setAttribute("Department", value);
    }

    public String getSelectBox() {
        return (String)getAttribute("SelectBox");
    }

    public void setSelectBox(String value) {
        setAttribute("SelectBox", value);
    }
}
