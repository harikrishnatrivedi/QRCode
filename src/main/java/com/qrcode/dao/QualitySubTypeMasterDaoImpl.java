/**
 * 
 */
package com.qrcode.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.qrcode.model.QualitySubTypeMaster;

/**
 * @author harikrishna.trivedi
 *
 */ 
@Repository("qualitySubTypeMaster")
public class QualitySubTypeMasterDaoImpl extends AbstractDao<Integer, QualitySubTypeMaster> implements QualitySubTypeMasterDao {
 
    public QualitySubTypeMaster findByQltySubTypeMasterCode(String qltySubTypeMasterCode) {
    	Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("qltySubTypeMasterCode", qltySubTypeMasterCode));
        System.out.println("Before error");
        return (QualitySubTypeMaster) criteria.uniqueResult();
    }
    
    public void saveQualitySubTypeMaster(QualitySubTypeMaster qualitySubTypeMaster) {
        persist(qualitySubTypeMaster);
    }
 
    public void deleteQualitySubTypeMasterByQltySubTypeMasterCode(String qltySubTypeMasterCode) {
        Query query = getSession().createSQLQuery("delete from QUALITY_SUB_TYPE_MST where QTY_SUB_TYPE_CODE = :qltySubTypeMasterCode");
        query.setString("qltySubTypeMasterCode", qltySubTypeMasterCode);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<QualitySubTypeMaster> findAllQualitySubTypeMaster() {
        Criteria criteria = createEntityCriteria();
        return (List<QualitySubTypeMaster>) criteria.list();
    }
 
   public QualitySubTypeMaster findPOBarcodeByQltySubTypeMasterCode(String qltySubTypeMasterCode) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("qltySubTypeMasterCode", qltySubTypeMasterCode));
        return (QualitySubTypeMaster) criteria.uniqueResult();
    }
}
