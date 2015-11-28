/**
 * 
 */
package com.qrcode.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.qrcode.model.StoreInventoryDtl;

/**
 * @author harikrishna.trivedi
 *
 */ 
@Repository("storeInventoryDtlDao")
public class StoreInventoryDtlDaoImpl extends AbstractDao<Integer, StoreInventoryDtl> implements StoreInventoryDtlDao {
 
    public StoreInventoryDtl findByBarCode(String barCode) {
    	Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("barCode", barCode));
        return (StoreInventoryDtl) criteria.uniqueResult();
    }
    
    public void saveStoreInventoryDtl(StoreInventoryDtl storeInventoryDtl) {
        persist(storeInventoryDtl);
    }
 
    public void deleteStoreInventoryDtlByBarCode(String barCode) {
        Query query = getSession().createSQLQuery("delete from STORE_INVENTORY_DTL where BARCODE = :barCode");
        query.setString("barCode", barCode);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<StoreInventoryDtl> findAllStoreInventoryDtls() {
        Criteria criteria = createEntityCriteria();
        return (List<StoreInventoryDtl>) criteria.list();
    }
 
   public StoreInventoryDtl findStoreInventoryDtlByBarCode(String barCode) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("barCode", barCode));
        return (StoreInventoryDtl) criteria.uniqueResult();
    }
}
