/**
 * 
 */
package com.qrcode.service;

import java.util.List;

import com.qrcode.model.QualityTest;

/**
 * @author harikrishna.trivedi
 *
 */
 
public interface QualityTestService {
 
	QualityTest findByQltyTestCode(String qltyTestCode);
     
    void saveQualityTest(QualityTest qualityTest);
     
    void updateQualityTest(QualityTest qualityTest);
     
    void deleteQualityTestByQltyTestCode(String qltyTestCode);
 
    List<QualityTest> findAllQualityTest(); 
     
    //boolean isQualityTestCodeUnique(String qltyTestCode);
 
    //BigDecimal countQulityTestByQltyTestCode(String qltyTestCode);
}