/**
 * 
 */
package com.qrcode.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.qrcode.model.UpdateLength;
import com.qrcode.service.UpdateLengthService;

/**
 * @author harikrishna.trivedi
 *
 */ 
@Repository("updateLengthDao")
public class UpdateLengthDaoImpl extends AbstractDao<Integer, UpdateLength> implements UpdateLengthDao {
 
    public UpdateLength findByBarCode(String barCode) {
    	 Query query = getSession().createSQLQuery("select item,ProductName from po_barcode where barcode = :barCode");
         query.setString("barCode", barCode);
         List<UpdateLength> updateLength = query.list();
         if(updateLength==null || updateLength.isEmpty()) {
        	 return null;
         }else
         {
        	 return updateLength.get(0);
         }
    }
    
    public void saveUpdateLength(UpdateLength lengthUpdate) {
    	
    	
    }
 
    public void deleteUpdateLengthByBarCode(String barCode) {
        Query query = getSession().createSQLQuery("");//("delete from STORE_INVENTORY_DTL where BARCODE = :barCode");
        query.setString("barCode", barCode);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<UpdateLength> findAllLengthUpdateDtls() {
        Criteria criteria = createEntityCriteria();
        return (List<UpdateLength>) criteria.list();
    }
}
