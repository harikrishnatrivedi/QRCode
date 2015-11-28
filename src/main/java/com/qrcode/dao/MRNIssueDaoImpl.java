/**
 * 
 */
package com.qrcode.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.qrcode.model.MRNIssue;

/**
 * @author harikrishna.trivedi
 *
 */ 
@Repository("mRNIssue")
public class MRNIssueDaoImpl extends AbstractDao<Integer, MRNIssue> implements MRNIssueDao {
 
    public MRNIssue findByItemNo(Integer itemNo) {
    	Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("itemNo", itemNo));
        System.out.println("Before error");
        //System.out.println("criteria.uniqueResult() :::: "+criteria.uniqueResult());
        return (MRNIssue) criteria.uniqueResult();
        //return (POBarcode) criteria.list().get(0);
    }
    
    public void saveMRNIssue(MRNIssue mRNIssue) {
        persist(mRNIssue);
    }
 
    public void deleteMRNIssueByItemNo(Integer itemNo) {
        Query query = getSession().createSQLQuery("delete from  where ItemNo= :ItemNo");
        query.setString("itemNo", itemNo.toString());
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<MRNIssue> findAllMRNIssue() {
        Criteria criteria = createEntityCriteria();
        return (List<MRNIssue>) criteria.list();
    }
 
/*  public MRNIssue findMRNIssueByItemNo(Integer itemNo) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("itemNo", itemNo.toString()));
        return (MRNIssue) criteria.uniqueResult();
    }*/
   
   
}
