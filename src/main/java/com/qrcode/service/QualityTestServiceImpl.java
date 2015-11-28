/**
 * 
 */
package com.qrcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.qrcode.dao.QualityTestDao;
import com.qrcode.model.QualityTest;

/**
 * @author harikrishna.trivedi
 *
 */
@Service("qualityTestService")
@Transactional
public class QualityTestServiceImpl implements QualityTestService {
 
    @Autowired
    private QualityTestDao dao;
     
    public QualityTest findByQltyTestCode(String qltyTestCode) {
        return dao.findByQltyTestCode(qltyTestCode);
    }
 
    public void saveQualityTest(QualityTest qualityTest) {
        dao.saveQualityTest(qualityTest);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateQualityTest(QualityTest qualityTest) {
    	QualityTest entity = dao.findByQltyTestCode(qualityTest.getQtyTypeCode());
        if(entity!=null){
            entity.setControlNo(qualityTest.getControlNo());
            entity.setFittingHeightMax(qualityTest.getFittingHeightMax());
            entity.setFittingHeightMin(qualityTest.getFittingHeightMin());
            entity.setFittingHeightMmMax(qualityTest.getFittingHeightMmMax());
            entity.setFittingHeightMmMin(qualityTest.getFittingHeightMmMin());
            entity.setFittingInsideDiaMax1(qualityTest.getFittingInsideDiaMax1());
            entity.setFittingInsideDiaMax2(qualityTest.getFittingInsideDiaMax2());
            entity.setFittingInsideDiaMin1(qualityTest.getFittingInsideDiaMin1());
            entity.setFittingInsideDiaMin2(qualityTest.getFittingInsideDiaMin2());
            entity.setFittingOutsideDiaMax1(qualityTest.getFittingOutsideDiaMax1());
            entity.setFittingOutsideDiaMax2(qualityTest.getFittingOutsideDiaMax2());
            entity.setFittingOutsideDiaMin1(qualityTest.getFittingOutsideDiaMin1());
            entity.setFittingOutsideDiaMin2(qualityTest.getFittingOutsideDiaMin2());
            entity.setFittingThiknessMax1(qualityTest.getFittingThiknessMax1());
            entity.setFittingThiknessMax2(qualityTest.getFittingThiknessMax2());
            entity.setFittingThiknessMin1(qualityTest.getFittingThiknessMin1());
            entity.setFittingThiknessMin2(qualityTest.getFittingThiknessMin2());
            entity.setFlangeHoldDia(qualityTest.getFlangeHoldDia());
            entity.setFlangeHoleNo(qualityTest.getFlangeHoleNo());
            entity.setFlangeIdOd(qualityTest.getFlangeIdOd());
            entity.setFlangeOutsideDia(qualityTest.getFlangeOutsideDia());
            entity.setFlangePCD(qualityTest.getFlangePCD());
            entity.setFlangeRtjDia(qualityTest.getFlangeRtjDia());
            entity.setFlangeThikness(qualityTest.getFlangeThikness());
            entity.setFlangeYLengthWidth(qualityTest.getFlangeYLengthWidth());
            entity.setHeatNo(qualityTest.getHeatNo());
            entity.setItemCode(qualityTest.getItemCode());
            entity.setItemDesc(qualityTest.getItemDesc());
            entity.setMrnIssueDate(qualityTest.getMrnIssueDate());
            entity.setMrnNo(qualityTest.getMrnNo());
            entity.setMrnNumber(qualityTest.getMrnNumber());
            entity.setPipeLength(qualityTest.getPipeLength());
            entity.setPipeOutsideDiaMax(qualityTest.getPipeOutsideDiaMax());
            entity.setPipeOutsideDiaMin(qualityTest.getPipeOutsideDiaMin());
            entity.setPipeThiknessMin(qualityTest.getPipeThiknessMin());
            entity.setQtyAll(qualityTest.getQtyAll());
            entity.setQtyRegFlag(qualityTest.getQtyRegFlag());
            entity.setQtyRegRemarks(qualityTest.getQtyRegRemarks());
            entity.setQtyStatus(qualityTest.getQtyStatus());
            entity.setQtySubTypeCode(qualityTest.getQtySubTypeCode());
            entity.setQtySubTypeName(qualityTest.getQtySubTypeName());
            entity.setQtyTestCode(qualityTest.getQtyTestCode());
            entity.setQtyTestDate(qualityTest.getQtyTestDate());
            entity.setQtyTestTime(qualityTest.getQtyTestTime());
            entity.setQtyTypeCode(qualityTest.getQtyTypeCode());
            entity.setQtyTypeName(qualityTest.getQtyTypeName());
            entity.setSlNo(qualityTest.getSlNo());
        }
    }
 
    public void deleteQualityTestByQltyTestCode(String qualityTestCode) {
        dao.deleteQualityTestByQltyTestCode(qualityTestCode);
    }
     
    public List<QualityTest> findAllQualityTest() {
        return dao.findAllQualityTest();
    }
    
    public boolean isPOBarcodeBarCodeUnique(String qltyTestCode) {
    	QualityTest qualityTest = findByQltyTestCode(qltyTestCode);
        return ( qualityTest == null || (qualityTest.getQtyTypeCode().isEmpty()));
    }
    
     
}
