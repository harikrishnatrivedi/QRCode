/**
 * 
 */
package com.qrcode.dao;

import java.util.List;
import com.qrcode.model.QualityTest;;

/**
 * @author harikrishna.trivedi
 *
 */
public interface QualityTestDao {
 
	QualityTest findByQltyTestCode(String qltyTestCode);
 
    void saveQualityTest(QualityTest qltyTest);
     
    void deleteQualityTestByQltyTestCode(String qltyTestCode);
     
    List<QualityTest> findAllQualityTest();
    
}