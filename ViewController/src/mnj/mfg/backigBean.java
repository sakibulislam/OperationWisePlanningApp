package mnj.mfg;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import mnj.mfg.model.services.MainAMImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

public class backigBean {

    // Coding For Pop-Up of STN

    private RichTable stnTable;
    private RichInputText splitValue;
    private RichInputText stnLineStnQty;
    private RichTable detailTable;
    private RichTable stnPopUpTable;
    private RichPopup orgSelectionPopUpBind;
    private RichPopup bindingDeptAssignPopUp;
    private RichTable bindingAssignDepartment;
    private RichCommandButton popUpAssignOrgTable;
    private RichPopup orgSelectionForPrintingPopUpBind;
    private RichPopup organizationSelectionForEmbrioderyPopUpBind;

    public void editPopupFetchListener(PopupFetchEvent popupFetchEvent) {

        OperationBinding operationBinding =
            executeOperation("setSTNWhereClause");
        operationBinding.execute();
    }
    
    public ApplicationModule getAppM(){
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContainer.findDataControl("MainAMDataControl"); // Name of application module in datacontrolBinding.cpx
        MainAMImpl appM = (MainAMImpl)dc.getDataProvider();
        return appM;
    }
    MainAMImpl am = (MainAMImpl)this.getAppM();

    public void editDialogLisSTNNew(DialogEvent dialogEvent) {//TODO
        if (dialogEvent.getOutcome().name().equals("ok")) {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            getBindingDeptAssignPopUp().show(hints); // assign department pop up will appear
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();

        }
    }

    public void editPopupCancelListener(PopupCanceledEvent popupCanceledEvent) {


    }

    /*****Generic Method to Get Bindings**/
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    /*****Generic Method to Get BindingContainer**/
    public BindingContainer getBindingsCont() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    /**
     * Generic Method to execute operation
     * */
    public OperationBinding executeOperation(String operation) {
        OperationBinding createParam =
            getBindingsCont().getOperationBinding(operation);


        return createParam;

    }

    // End Coding For Pop-Up of STN

    // Code for Split Value

    public void editPopupFetchListenerSplit(PopupFetchEvent popupFetchEvent) {

        OperationBinding operationBinding =
            executeOperation("setSTNWhereClause");
        operationBinding.execute();
    }

    public void editDialogListenerSplit(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {

            int SpliTValue = 0;
            int StnLineSpliTValue = 0;
            int Result = 0;


            SpliTValue = Integer.parseInt(splitValue.getValue().toString());
            System.out.println("SpliTValue...!" + SpliTValue);
            // StnLineSpliTValue = Integer.parseInt(getStnLineStnQty().getValue().toString());
            StnLineSpliTValue = getStnLineQty();
            System.out.println("StnLineSpliTValue...!" + StnLineSpliTValue);
            Result = StnLineSpliTValue - SpliTValue;

            //  System.out.println("Result...!"+Result);

            if (Result < 0) {

                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage message =
                    new FacesMessage("Split Value Can Not Exceed More Than the Line Value");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, message);

            }

            if (Result > 0) {
                OperationBinding operationBinding =
                    executeOperation("SplitFunctionality");
                operationBinding.getParamsMap().put("SplitQuantity",
                                                    splitValue.getValue().toString());
                operationBinding.execute();

                System.out.println("Split Value ... !" +
                                   splitValue.getValue().toString());
            }

            AdfFacesContext.getCurrentInstance().addPartialTarget(stnTable);

        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();

        }
    }


    // End Code for Split Value


    // Code to Get Stn Line Total Value


    public int getStnLineQty() {

        oracle.adf.view.rich.component.UIXTable table = getStnTable();
        // Get the Selected Row key set iterator
        java.util.Iterator selectionIt = table.getSelectedRowKeys().iterator();
        double ply = 0.0;
        int val = 0;
        while (selectionIt.hasNext()) {
            Object rowKey = selectionIt.next();
            table.setRowKey(rowKey);
            int index = table.getRowIndex();
            FacesCtrlHierNodeBinding row =
                (FacesCtrlHierNodeBinding)table.getRowData(index);
            Row selectedRow = row.getRow();
            val =
Integer.parseInt(selectedRow.getAttribute("StnQty").toString());
        }
        return val;
    }


    // End Code to Get Stn Line Total Value

    public void setStnTable(RichTable stnTable) {
        this.stnTable = stnTable;
    }

    public RichTable getStnTable() {
        return stnTable;
    }

    public void setSplitValue(RichInputText splitValue) {
        this.splitValue = splitValue;
    }

    public RichInputText getSplitValue() {
        return splitValue;
    }

    public void setStnLineStnQty(RichInputText stnLineStnQty) {
        this.stnLineStnQty = stnLineStnQty;
    }

    public RichInputText getStnLineStnQty() {
        return stnLineStnQty;
    }

    public void setDetailTable(RichTable detailTable) {
        this.detailTable = detailTable;
    }

    public RichTable getDetailTable() {
        return detailTable;
    }

    public void ItemCreation(ActionEvent actionEvent) {
        // Add event code here...

        OperationBinding operationBinding = executeOperation("ItemCreation");
        Object result = operationBinding.execute();
        //        String Message = result.toString();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);

    }

    public void BpoCreation(ActionEvent actionEvent) {
        // Add event code here...

        OperationBinding operationBinding = executeOperation("BpoCreation");
        Object result = operationBinding.execute();
        //        String Message = result.toString();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);


    }

    public void JobCreation(ActionEvent actionEvent) {
        // Add event code here...

        OperationBinding operationBinding = executeOperation("JobCreation");
        Object result = operationBinding.execute();
        //        String Message = result.toString();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }

    public void MiscReceipt(ActionEvent actionEvent) {
        // Add event code here...

        OperationBinding operationBinding =
            executeOperation("MiscReceiptCreation");
        Object result = operationBinding.execute();
        //        String Message = result.toString();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }

    public void AssignOperation(ActionEvent actionEvent) {
        // Add event code here...

        OperationBinding operationBinding =
            executeOperation("AssignOperation");
        Object result = operationBinding.execute();
        //        String Message = result.toString();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }

    public void AddMaterial(ActionEvent actionEvent) {
        // Add event code here...

        OperationBinding operationBinding = executeOperation("AddMaterial");
        Object result = operationBinding.execute();
        //        String Message = result.toString();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }

    public void SelectAllStn(ActionEvent actionEvent) {
        // Add event code here...
        // Add event code here...
        OperationBinding operationBinding = executeOperation("selectAllStn");
        operationBinding.getParamsMap().put("flag", "Y");
        
        //System.out.println(".........flag");
        operationBinding.execute();
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(stnPopUpTable);
    }

    public void DeSelectAllStn(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding = executeOperation("selectAllStn");
        operationBinding.getParamsMap().put("flag", "N");
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(stnPopUpTable);
    }

    public void setStnPopUpTable(RichTable stnPopUpTable) {
        this.stnPopUpTable = stnPopUpTable;
    }

    public RichTable getStnPopUpTable() {
        return stnPopUpTable;
    }

    public void setOrgSelectionPopUpBind(RichPopup orgSelectionPopUpBind) {
        this.orgSelectionPopUpBind = orgSelectionPopUpBind;
    }

    public RichPopup getOrgSelectionPopUpBind() {
        return orgSelectionPopUpBind;
    }

    public void StnOrganizationAssignLitener(DialogEvent dialogEvent) {
        // Add event code here...
        if (dialogEvent.getOutcome().name().equals("ok")) {
            
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            getOrgSelectionPopUpBind().show(hints);

            //       AdfFacesContext.getCurrentInstance().addPartialTarget(piTable);
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            ;
        }


    }

    public void OrgSelectionListener(DialogEvent dialogEvent) {
        // Add event code here...

        if (dialogEvent.getOutcome().name().equals("ok")) {

            OperationBinding operationBinding =
                executeOperation("OrgAssignToStns");
            System.out.println("In Org Assign To STNs");
            operationBinding.execute();

            AdfFacesContext.getCurrentInstance().addPartialTarget(detailTable);
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            ;
        }
    }
    
    

    public void AssignSubInventory(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding =
            executeOperation("AssignSubInventories");
        Object result = operationBinding.execute();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
        }

        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }

    public void setBindingDeptAssignPopUp(RichPopup bindingDeptAssignPopUp) {
        this.bindingDeptAssignPopUp = bindingDeptAssignPopUp;
    }

    public RichPopup getBindingDeptAssignPopUp() {
        return bindingDeptAssignPopUp;
    }

    public void DeptSelectionListner(DialogEvent dialogEvent) {//TODO
        
        try {
            if (dialogEvent.getOutcome().name().equals("ok")) {
                System.out.println("  In @OK  ");
                OperationBinding operationBinding1 = executeOperation("DeptAssignToStns"); //Unit check Done 
                operationBinding1.execute();
                
                OperationBinding operationBinding2 = executeOperation("OrgAssignToPrintEmbriodery"); //method for selecting Org for printing and embroidery dept 
                operationBinding2.execute();
                
                OperationBinding operationBinding = executeOperation("popSTN"); //Insert in STNLineVO from FillSTN Data
                operationBinding.execute();
                
                
                
                AdfFacesContext.getCurrentInstance().addPartialTarget(stnTable);
                AdfFacesContext.getCurrentInstance().addPartialTarget(detailTable);

               // AdfFacesContext.getCurrentInstance().addPartialTarget(detailTable);
            } else if (dialogEvent.getOutcome().name().equals("cancel")) {
                ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        
    }

    public void setBindingAssignDepartment(RichTable bindingAssignDepartment) {
        this.bindingAssignDepartment = bindingAssignDepartment;
    }

    public RichTable getBindingAssignDepartment() {
        return bindingAssignDepartment;
    }

    public void SelectAllAssignOrg(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding = executeOperation("selectAllAssignOrg");
        operationBinding.getParamsMap().put("flag", "Y");
        
        
        System.out.println("Call Select All " );
        operationBinding.execute();
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(stnPopUpTable);
    }

    public void DeSelectAllAssignOrg(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding = executeOperation("selectAllAssignOrg");
        operationBinding.getParamsMap().put("flag", "N");
        
        System.out.println("Call De-select All " );
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(stnPopUpTable);
        
    }

    public void setPopUpAssignOrgTable(RichCommandButton popUpAssignOrgTable) {
        this.popUpAssignOrgTable = popUpAssignOrgTable;
    }

    public RichCommandButton getPopUpAssignOrgTable() {
        return popUpAssignOrgTable;
    }

    public void OrgAssignToPrintingListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            getOrgSelectionForPrintingPopUpBind().show(hints);

            //       AdfFacesContext.getCurrentInstance().addPartialTarget(piTable);
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            ;
        }
    }

    public void setOrgSelectionForPrintingPopUpBind(RichPopup orgSelectionForPrintingPopUpBind) {
        this.orgSelectionForPrintingPopUpBind = orgSelectionForPrintingPopUpBind;
    }

    public RichPopup getOrgSelectionForPrintingPopUpBind() {
        return orgSelectionForPrintingPopUpBind;
    }

    public void OrgAssignToPrinting(DialogEvent dialogEvent) {
        // Add event code here...

        if (dialogEvent.getOutcome().name().equals("ok")) {

            OperationBinding operationBinding =
                executeOperation("OrgAssignToPrinting");
            System.out.println("In Org Assign To Printing Block");
            operationBinding.execute();

            AdfFacesContext.getCurrentInstance().addPartialTarget(detailTable);
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            ;
        }
    }

    

    

    public void OrgAssignToEmbrioderyListener(DialogEvent dialogEvent) {
        // Add event code here...
        
        if (dialogEvent.getOutcome().name().equals("ok")) {
            
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            getOrganizationSelectionForEmbrioderyPopUpBind().show(hints);
          

            //       AdfFacesContext.getCurrentInstance().addPartialTarget(piTable);
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            ;
        }
    }

    public void setOrganizationSelectionForEmbrioderyPopUpBind(RichPopup organizationSelectionForEmbrioderyPopUpBind) {
        this.organizationSelectionForEmbrioderyPopUpBind = organizationSelectionForEmbrioderyPopUpBind;
    }

    public RichPopup getOrganizationSelectionForEmbrioderyPopUpBind() {
        return organizationSelectionForEmbrioderyPopUpBind;
    }

    public void OrgAssignToEmbriodery(DialogEvent dialogEvent) {
        // Add event code here...
        if (dialogEvent.getOutcome().name().equals("ok")) {

            OperationBinding operationBinding =
                executeOperation("OrgAssignToEmbriodery");
            System.out.println("In Org Assign To Embriodery Block");
            operationBinding.execute();

            AdfFacesContext.getCurrentInstance().addPartialTarget(detailTable);
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            ;
        }
    }

    public void deleteOnCondition(ActionEvent actionEvent) {
        ViewObject deptAssignVo=am.getDepAssignVO1();
        ViewObject stnLVo=am.getStnLineVO1();
        String flag=null;
        
        String query= "SELECT distinct stn.stn_no exist FROM  MNJ_MFG_RATIOPLAN_STNS_ALL stn where stn.stn_no= ?";
       
          ResultSet rs=null;  
          String isStnExist = null;
          String stn=null;
          try{
               stn=stnLVo.getCurrentRow().getAttribute("Stn").toString();
              System.out.println("spo No="+stn);
          }
          catch(Exception e){
               stn=null;
          }
        System.out.println("spo No="+stn);
          PreparedStatement createStatement= am.getDBTransaction().createPreparedStatement(query,0);
        try {
            createStatement.setString(1,stn);
            rs = createStatement.executeQuery();
            if (rs.next()) {
                    isStnExist =  rs.getString(1);
                    System.out.println(".......check+= "+isStnExist);
                }
            
        } catch (SQLException e) {
            
           System.out.println("print prblrm with finidng stn"); 
        }
        //rs = am.getDBTransaction().createStatement(0).executeQuery(query);
       
        //System.out.println("--------asdasd-----"+isBPOExist);
        
        if(isStnExist == null){
            deptAssignVo.removeCurrentRow();
        }
        else{
            flag="STN's which are already Generated on MarkerRatio Plan Form";
                    FacesMessage fm = new FacesMessage(flag);
                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, fm);
        }
         
        AdfFacesContext.getCurrentInstance().addPartialTarget(detailTable);
        
        
        // Add event code here...
    }

    public void deleteOnConditionFromLine(ActionEvent actionEvent) {
        // Add event code here...
        
       // ViewObject deptAssignVo=am.getDepAssignVO1();
        ViewObject stnLVo=am.getStnLineVO1();
        String flag=null;
        
        String query= "SELECT distinct stn.stn_no exist FROM  MNJ_MFG_RATIOPLAN_STNS_ALL stn where stn.stn_no= ?";
        
          ResultSet rs=null;  
          String isStnExist = null;
          String stn=null;
          try{
               stn=stnLVo.getCurrentRow().getAttribute("Stn").toString();
              System.out.println("spo No="+stn);
          }
          catch(Exception e){
               stn=null;
          }
        System.out.println("spo No="+stn);
          PreparedStatement createStatement= am.getDBTransaction().createPreparedStatement(query,0);
        try {
            createStatement.setString(1,stn);
            rs = createStatement.executeQuery();
            if (rs.next()) {
                    isStnExist =  rs.getString(1);
                    System.out.println(".......check+= "+isStnExist);
                }
            
        } catch (SQLException e) {
            
           System.out.println("print prblrm with finidng stn"); 
        }
        //rs = am.getDBTransaction().createStatement(0).executeQuery(query);
        
        //System.out.println("--------asdasd-----"+isBPOExist);
        
        if(isStnExist == null){
            stnLVo.removeCurrentRow();
        }
        else{
            flag="STN's which are already Generated on MarkerRatio Plan Form";
                    FacesMessage fm = new FacesMessage(flag);
                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, fm);
        }
         
        AdfFacesContext.getCurrentInstance().addPartialTarget(stnTable);
        
    }

    public String refresh() {
        System.out.println("call refresh...");
         am.getHeaderVO1().executeQuery();
        return null;
    }
}
