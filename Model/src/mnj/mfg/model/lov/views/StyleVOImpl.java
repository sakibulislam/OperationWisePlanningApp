package mnj.mfg.model.lov.views;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jun 20 13:50:12 BDT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class StyleVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public StyleVOImpl() {
    }

    /**
     * Returns the bind variable value for p_buyerId.
     * @return bind variable value for p_buyerId
     */
    public String getp_buyerId() {
        return (String)getNamedWhereClauseParam("p_buyerId");
    }

    /**
     * Sets <code>value</code> for bind variable p_buyerId.
     * @param value value to bind as p_buyerId
     */
    public void setp_buyerId(String value) {
        setNamedWhereClauseParam("p_buyerId", value);
    }

    /**
     * Returns the bind variable value for p_org_id.
     * @return bind variable value for p_org_id
     */
    public String getp_org_id() {
        return (String)getNamedWhereClauseParam("p_org_id");
    }

}
