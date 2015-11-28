/**
 * 
 */
package com.qrcode.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.qrcode.model.MainGRN;

/**
 * @author harikrishna.trivedi
 *
 */ 
@Repository("mainGRNDao")
public class MainGRNDaoImpl extends AbstractDao<Integer, MainGRN> implements MainGRNDao {
 
    public MainGRN findByDocNo(Integer id) {
    	Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("docNo", id));
        return (MainGRN) criteria.uniqueResult();
    }
    
    public void saveMainGRN(MainGRN mainGRN) {
        persist(mainGRN);
    }
 
    public void deleteMainGRNByBarCode(String barCode) {
        Query query = getSession().createSQLQuery("delete from  where BARCODE = :barCode");
        query.setString("barCode", barCode);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<MainGRN> findAllMainGRN() {
        Criteria criteria = createEntityCriteria();
        return (List<MainGRN>) criteria.list();
    }
 
   public MainGRN findMainGRNByBarCode(String barCode) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("barCode", barCode));
        return (MainGRN) criteria.uniqueResult();
    }
}
