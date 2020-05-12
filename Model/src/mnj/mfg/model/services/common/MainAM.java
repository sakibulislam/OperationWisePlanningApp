package mnj.mfg.model.services.common;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jun 21 13:15:06 BDT 2016
// ---------------------------------------------------------------------
public interface MainAM extends ApplicationModule {
    void setSTNWhereClause();

    void popSTN();

    void SplitFunctionality(String SplitQuantity);

    void setSessionValues(String orgId, String userId, String respId,
                          String respAppl);

    String MiscReceiptCreation();

    String JobCreation();

    String ItemCreation();

    String BpoCreation();

    String AssignOperation();

    String AddMaterial();

    void selectAllStn(String flag);

    void OrgAssignToStns();

    String AssignSubInventories();

    void DeptAssignToStns();

    void selectAllAssignOrg(String flag);

    void OrgAssignToPrinting();

    void OrgAssignToEmbriodery();

    void OrgAssignToPrintEmbriodery();
}
