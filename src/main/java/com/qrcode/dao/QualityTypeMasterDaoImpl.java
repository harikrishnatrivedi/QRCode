/**
 * 
 */
package com.qrcode.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.qrcode.model.QualityTypeMaster;

/**
 * @author harikrishna.trivedi
 *
 */ 
@Repository("qyalityTypeMaster")
public class QualityTypeMasterDaoImpl extends AbstractDao<Integer, QualityTypeMaster> implements QualityTypeMasterDao {
 
    public QualityTypeMaster findByQltyTypeMstCode(String qltyTypeMstCode) {
    	Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("qltyTypeMstCode", qltyTypeMstCode));
        System.out.println("Before error");
        //System.out.println("criteria.uniqueResult() :::: "+criteria.uniqueResult());
        return (QualityTypeMaster) criteria.uniqueResult();
        //return (POBarcode) criteria.list().get(0);
    }

    public void saveQualityTypeMaster(QualityTypeMaster qualityTypeMaster) {
        persist(qualityTypeMaster);
    }

    public void deleteQualityTypeMasterByQltyTypeMstCode(String qltyTypeMstCode) {
        Query query = getSession().createSQLQuery("delete from QUALITY_SUB_TYPE_MST where QTY_TYPE_CODE= :qltyTypeMstCode");
        query.setString("qltyTypeMstCode", qltyTypeMstCode);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<QualityTypeMaster> findAllQualityTypeMaster() {
        Criteria criteria = createEntityCriteria();
        return (List<QualityTypeMaster>) criteria.list();
    }

   public QualityTypeMaster findPOBarcodeByBarCode(String qltyTypeMstCode) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("qtyTypeCode", qltyTypeMstCode));
        return (QualityTypeMaster) criteria.uniqueResult();
    }   
}
