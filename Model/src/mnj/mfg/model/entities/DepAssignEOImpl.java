package mnj.mfg.model.entities;

import java.sql.SQLException;

import java.util.Map;

import oracle.adf.share.ADFContext;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jun 16 14:29:05 BDT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DepAssignEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        DepAssignId {
            public Object get(DepAssignEOImpl obj) {
                return obj.getDepAssignId();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setDepAssignId((Number)value);
            }
        }
        ,
        StnLineId {
            public Object get(DepAssignEOImpl obj) {
                return obj.getStnLineId();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setStnLineId((Number)value);
            }
        }
        ,
        PrimaryMfgOrgId {
            public Object get(DepAssignEOImpl obj) {
                return obj.getPrimaryMfgOrgId();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setPrimaryMfgOrgId((Number)value);
            }
        }
        ,
        PrimaryDepartment {
            public Object get(DepAssignEOImpl obj) {
                return obj.getPrimaryDepartment();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setPrimaryDepartment((String)value);
            }
        }
        ,
        FinalMfgOrgId {
            public Object get(DepAssignEOImpl obj) {
                return obj.getFinalMfgOrgId();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setFinalMfgOrgId((Number)value);
            }
        }
        ,
        FinalDepartment {
            public Object get(DepAssignEOImpl obj) {
                return obj.getFinalDepartment();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setFinalDepartment((String)value);
            }
        }
        ,
        CreationDate {
            public Object get(DepAssignEOImpl obj) {
                return obj.getCreationDate();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setCreationDate((Date)value);
            }
        }
        ,
        CreatedBy {
            public Object get(DepAssignEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setCreatedBy((Number)value);
            }
        }
        ,
        LastUpdatedBy {
            public Object get(DepAssignEOImpl obj) {
                return obj.getLastUpdatedBy();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setLastUpdatedBy((Number)value);
            }
        }
        ,
        OrgId {
            public Object get(DepAssignEOImpl obj) {
                return obj.getOrgId();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setOrgId((Number)value);
            }
        }
        ,
        LastUpdatedDate {
            public Object get(DepAssignEOImpl obj) {
                return obj.getLastUpdatedDate();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setLastUpdatedDate((Date)value);
            }
        }
        ,
        Userid {
            public Object get(DepAssignEOImpl obj) {
                return obj.getUserid();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setUserid((Number)value);
            }
        }
        ,
        Respid {
            public Object get(DepAssignEOImpl obj) {
                return obj.getRespid();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setRespid((Number)value);
            }
        }
        ,
        Respapplid {
            public Object get(DepAssignEOImpl obj) {
                return obj.getRespapplid();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setRespapplid((Number)value);
            }
        }
        ,
        NegotiablePrice {
            public Object get(DepAssignEOImpl obj) {
                return obj.getNegotiablePrice();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setNegotiablePrice((Number)value);
            }
        }
        ,
        OperationSequence {
            public Object get(DepAssignEOImpl obj) {
                return obj.getOperationSequence();
            }

            public void put(DepAssignEOImpl obj, Object value) {
                obj.setOperationSequence((Number)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(DepAssignEOImpl object);

        public abstract void put(DepAssignEOImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int DEPASSIGNID = AttributesEnum.DepAssignId.index();
    public static final int STNLINEID = AttributesEnum.StnLineId.index();
    public static final int PRIMARYMFGORGID = AttributesEnum.PrimaryMfgOrgId.index();
    public static final int PRIMARYDEPARTMENT = AttributesEnum.PrimaryDepartment.index();
    public static final int FINALMFGORGID = AttributesEnum.FinalMfgOrgId.index();
    public static final int FINALDEPARTMENT = AttributesEnum.FinalDepartment.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int ORGID = AttributesEnum.OrgId.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int USERID = AttributesEnum.Userid.index();
    public static final int RESPID = AttributesEnum.Respid.index();
    public static final int RESPAPPLID = AttributesEnum.Respapplid.index();
    public static final int NEGOTIABLEPRICE = AttributesEnum.NegotiablePrice.index();
    public static final int OPERATIONSEQUENCE = AttributesEnum.OperationSequence.index();

    /**
     * This is the default constructor (do not remove).
     */
    public DepAssignEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("mnj.mfg.model.entities.DepAssignEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for DepAssignId, using the alias name DepAssignId.
     * @return the DepAssignId
     */
    public Number getDepAssignId() {
        return (Number)getAttributeInternal(DEPASSIGNID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DepAssignId.
     * @param value value to set the DepAssignId
     */
    public void setDepAssignId(Number value) {
        setAttributeInternal(DEPASSIGNID, value);
    }

    /**
     * Gets the attribute value for StnLineId, using the alias name StnLineId.
     * @return the StnLineId
     */
    public Number getStnLineId() {
        return (Number)getAttributeInternal(STNLINEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for StnLineId.
     * @param value value to set the StnLineId
     */
    public void setStnLineId(Number value) {
        setAttributeInternal(STNLINEID, value);
    }

    /**
     * Gets the attribute value for PrimaryMfgOrgId, using the alias name PrimaryMfgOrgId.
     * @return the PrimaryMfgOrgId
     */
    public Number getPrimaryMfgOrgId() {
        return (Number)getAttributeInternal(PRIMARYMFGORGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for PrimaryMfgOrgId.
     * @param value value to set the PrimaryMfgOrgId
     */
    public void setPrimaryMfgOrgId(Number value) {
        setAttributeInternal(PRIMARYMFGORGID, value);
    }

    /**
     * Gets the attribute value for PrimaryDepartment, using the alias name PrimaryDepartment.
     * @return the PrimaryDepartment
     */
    public String getPrimaryDepartment() {
        return (String)getAttributeInternal(PRIMARYDEPARTMENT);
    }

    /**
     * Sets <code>value</code> as the attribute value for PrimaryDepartment.
     * @param value value to set the PrimaryDepartment
     */
    public void setPrimaryDepartment(String value) {
        setAttributeInternal(PRIMARYDEPARTMENT, value);
    }

    /**
     * Gets the attribute value for FinalMfgOrgId, using the alias name FinalMfgOrgId.
     * @return the FinalMfgOrgId
     */
    public Number getFinalMfgOrgId() {
        return (Number)getAttributeInternal(FINALMFGORGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for FinalMfgOrgId.
     * @param value value to set the FinalMfgOrgId
     */
    public void setFinalMfgOrgId(Number value) {
        setAttributeInternal(FINALMFGORGID, value);
    }

    /**
     * Gets the attribute value for FinalDepartment, using the alias name FinalDepartment.
     * @return the FinalDepartment
     */
    public String getFinalDepartment() {
        return (String)getAttributeInternal(FINALDEPARTMENT);
    }

    /**
     * Sets <code>value</code> as the attribute value for FinalDepartment.
     * @param value value to set the FinalDepartment
     */
    public void setFinalDepartment(String value) {
        setAttributeInternal(FINALDEPARTMENT, value);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the CreationDate
     */
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreationDate.
     * @param value value to set the CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public Number getCreatedBy() {
        return (Number)getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number)getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedBy.
     * @param value value to set the LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for OrgId, using the alias name OrgId.
     * @return the OrgId
     */
    public Number getOrgId() {
        return (Number)getAttributeInternal(ORGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrgId.
     * @param value value to set the OrgId
     */
    public void setOrgId(Number value) {
        setAttributeInternal(ORGID, value);
    }

    /**
     * Gets the attribute value for LastUpdatedDate, using the alias name LastUpdatedDate.
     * @return the LastUpdatedDate
     */
    public Date getLastUpdatedDate() {
        return (Date)getAttributeInternal(LASTUPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedDate.
     * @param value value to set the LastUpdatedDate
     */
    public void setLastUpdatedDate(Date value) {
        setAttributeInternal(LASTUPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for Userid, using the alias name Userid.
     * @return the Userid
     */
    public Number getUserid() {
        return (Number)getAttributeInternal(USERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Userid.
     * @param value value to set the Userid
     */
    public void setUserid(Number value) {
        setAttributeInternal(USERID, value);
    }

    /**
     * Gets the attribute value for Respid, using the alias name Respid.
     * @return the Respid
     */
    public Number getRespid() {
        return (Number)getAttributeInternal(RESPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Respid.
     * @param value value to set the Respid
     */
    public void setRespid(Number value) {
        setAttributeInternal(RESPID, value);
    }

    /**
     * Gets the attribute value for Respapplid, using the alias name Respapplid.
     * @return the Respapplid
     */
    public Number getRespapplid() {
        return (Number)getAttributeInternal(RESPAPPLID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Respapplid.
     * @param value value to set the Respapplid
     */
    public void setRespapplid(Number value) {
        setAttributeInternal(RESPAPPLID, value);
    }

    /**
     * Gets the attribute value for NegotiablePrice, using the alias name NegotiablePrice.
     * @return the NegotiablePrice
     */
    public Number getNegotiablePrice() {
        return (Number)getAttributeInternal(NEGOTIABLEPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for NegotiablePrice.
     * @param value value to set the NegotiablePrice
     */
    public void setNegotiablePrice(Number value) {
        setAttributeInternal(NEGOTIABLEPRICE, value);
    }

    /**
     * Gets the attribute value for OperationSequence, using the alias name OperationSequence.
     * @return the OperationSequence
     */
    public Number getOperationSequence() {
        return (Number)getAttributeInternal(OPERATIONSEQUENCE);
    }

    /**
     * Sets <code>value</code> as the attribute value for OperationSequence.
     * @param value value to set the OperationSequence
     */
    public void setOperationSequence(Number value) {
        setAttributeInternal(OPERATIONSEQUENCE, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }


    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
  //  protected void create(AttributeList attributeList) {
    //    super.create(attributeList);
   // }


    /**
     * @param depAssignId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number depAssignId) {
        return new Key(new Object[]{depAssignId});
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
     //  ---------------Method in EO For WHO Columns and Org -----------------------------------------------
           protected void doDML(int operation, TransactionEvent e) {
              
               Map sessionScope = ADFContext.getCurrent().getSessionScope();   
               String user = (String)sessionScope.get("userId");
               String org = (String)sessionScope.get("orgId");
               String RespId = (String)sessionScope.get("respId");
               if(DML_UPDATE == operation){
                   try {
                       setLastUpdatedDate((Date)Date.getCurrentDate()); 
                       setLastUpdatedBy(new oracle.jbo.domain.Number(user));
                   } catch (SQLException f) {
                       System.out.println(f.getMessage());
                   }
               }
               else if (DML_INSERT == operation){
                
                   try {
            
                       setCreationDate((Date)Date.getCurrentDate());  
                       setCreatedBy(new oracle.jbo.domain.Number(user));
                       setOrgId(new oracle.jbo.domain.Number(org));
                       setRespid(new oracle.jbo.domain.Number(RespId));
                   
                   } catch (SQLException f) {
                       ;
                   }
               }
               super.doDML(operation, e);
           }

    
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        /* Sequence Generation Code of Header by PwC */  
        oracle.jbo.server.SequenceImpl s = new oracle.jbo.server.SequenceImpl("MNJ_MFG_OSP_DEP_ASSIGN_S",getDBTransaction());          
        oracle.jbo.domain.Number sVal = s.getSequenceNumber();          
        setDepAssignId(sVal);
        /* End Sequence Generation Code of Header by PwC */
    }
}