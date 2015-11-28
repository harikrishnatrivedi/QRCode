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
 
import com.qrcode.model.QualityTest;

/**
 * @author harikrishna.trivedi
 *
 */ 
@Repository("qltyTestCode")
public class QualityTestDaoImpl extends AbstractDao<Integer, QualityTest> implements QualityTestDao {
 
    public QualityTest findByQltyTestCode(String qltyTestCode) {
    	Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("qltyTestCode", qltyTestCode));
        System.out.println("Before error");
        //System.out.println("criteria.uniqueResult() :::: "+criteria.uniqueResult());
        return (QualityTest) criteria.uniqueResult();
        //return (POBarcode) criteria.list().get(0);
    }
    
    public void saveQualityTest(QualityTest qualityTest) {
        persist(qualityTest);
    }
 
    public void deleteQualityTestByQltyTestCode(String qltyTestCode) {
        Query query = getSession().createSQLQuery("delete from QUALITY_TEST where qltyTestCode = :qltyTestCode");
        query.setString("qltyTestCode", qltyTestCode);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<QualityTest> findAllQualityTest() {
        Criteria criteria = createEntityCriteria();
        return (List<QualityTest>) criteria.list();
    }
 
   /*public QualityTest findQutalityTestByqltyTestCode(String qltyTestCode) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("qltyTestCode", qltyTestCode));
        return (QualityTest) criteria.uniqueResult();
    }*/
}
