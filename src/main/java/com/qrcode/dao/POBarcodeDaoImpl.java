/**
 * 
 */
package com.qrcode.dao;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.qrcode.model.POBarcode;

/**
 * @author harikrishna.trivedi
 *
 */ 
@Repository("pOBarcode")
public class POBarcodeDaoImpl extends AbstractDao<Integer, POBarcode> implements POBarcodeDao {
 
    public POBarcode findByBarCode(String barCode) {
    	Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("barCode", barCode));
        System.out.println("Before error");
        //System.out.println("criteria.uniqueResult() :::: "+criteria.uniqueResult());
        return (POBarcode) criteria.uniqueResult();
        //return (POBarcode) criteria.list().get(0);
    }
    
    public void savePOBarcode(POBarcode pOBarcode) {
        persist(pOBarcode);
    }
 
    public void deletePOBarcodeByBarCode(String barCode) {
        Query query = getSession().createSQLQuery("delete from  where BARCODE = :barCode");
        query.setString("barCode", barCode);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<POBarcode> findAllPOBarcode() {
        Criteria criteria = createEntityCriteria();
        return (List<POBarcode>) criteria.list();
    }
 
   public POBarcode findPOBarcodeByBarCode(String barCode) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("barCode", barCode));
        return (POBarcode) criteria.uniqueResult();
    }
   
   public BigDecimal countBarcodeByDocNo(Integer docNo) {
	   Criteria criteria = createEntityCriteria();
	   criteria.add(Restrictions.eq("docNo", docNo));
	   
	   Query query = getSession().createQuery("select sum(length) from Po_barcode where docno = :docNo");
	   query.setString("docNo", docNo+"");
	   Object[] row = (Object[]) query.uniqueResult();
	   return new BigDecimal(row[0].toString());  

   }
}
