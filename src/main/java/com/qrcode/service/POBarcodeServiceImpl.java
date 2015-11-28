/**
 * 
 */
package com.qrcode.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.qrcode.dao.POBarcodeDao;
import com.qrcode.model.MainGRN;
import com.qrcode.model.POBarcode;

/**
 * @author harikrishna.trivedi
 *
 */
@Service("pOBarcodeService")
@Transactional
public class POBarcodeServiceImpl implements POBarcodeService {
 
    @Autowired
    private POBarcodeDao dao;
     
    public POBarcode findByBarCode(String barCode) {
        return dao.findByBarCode(barCode);
    }
 
    public void savePOBarcode(POBarcode pOBarcode) {
        dao.savePOBarcode(pOBarcode);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updatePOBarcode(POBarcode pOBarcode) {
    	POBarcode entity = dao.findByBarCode(pOBarcode.getBarCode());
        if(entity!=null){
            entity.setBarCode(pOBarcode.getBarCode());
            entity.setBarcodeSlNo(pOBarcode.getBarcodeSlNo());
            entity.setBatchNo(pOBarcode.getBatchNo());;
            entity.setControlId(pOBarcode.getControlId());
            entity.setCuttingStatus(pOBarcode.getCuttingStatus());
            entity.setDimeter(pOBarcode.getDimeter());
            entity.setDocNo(pOBarcode.getDocNo());
            entity.setGrnNo(pOBarcode.getGrnNo());
            entity.setHeatNo(pOBarcode.getHeatNo());
            entity.setIssueNo(pOBarcode.getIssueNo());
            entity.setItem(pOBarcode.getItem());
            entity.setJobNo(pOBarcode.getJobNo());
            entity.setLastUpdatedDate(pOBarcode.getLastUpdatedDate());
            entity.setLength(pOBarcode.getLength());
            entity.setLineNo(pOBarcode.getLineNo());
            entity.setLocation(pOBarcode.getLocation());
            entity.setMake(pOBarcode.getMake());
            entity.setManualIssueFlag(pOBarcode.getManualIssueFlag());
            entity.setMrnIssueDate(pOBarcode.getMrnIssueDate());
            entity.setMrnNo(pOBarcode.getMrnNo());
            entity.setNewControl(pOBarcode.getNewControl());
            entity.setNewHeat(pOBarcode.getNewHeat());
            entity.setOrderNo(pOBarcode.getOrderNo());
            entity.setPrintStatus(pOBarcode.getPrintStatus());
            entity.setProductName(pOBarcode.getProductName());
            entity.setQtyCheck(pOBarcode.getQtyCheck());
            entity.setRemainLength(pOBarcode.getRemainLength());
            entity.setRemarks(pOBarcode.getRemarks());
            entity.setSlNo1x1(pOBarcode.getSlNo1x1());
            entity.setsNo(pOBarcode.getsNo());
            entity.setStatus(pOBarcode.getStatus());
            entity.setTcNo(pOBarcode.getTcNo());
            entity.setUserId(pOBarcode.getUserId());
            entity.setWidth(pOBarcode.getWidth());
        }
    }
 
    public void deletePOBarcodeByBarCode(String barCode) {
        dao.deletePOBarcodeByBarCode(barCode);
    }
     
    public List<POBarcode> findAllPOBarcode() {
        return dao.findAllPOBarcode();
    }
    
    public boolean isPOBarcodeBarCodeUnique(String barCode) {
    	POBarcode pObarcode = findByBarCode(barCode);
        return ( pObarcode == null || (pObarcode.getBarCode().isEmpty()));
    }
    
    public BigDecimal countBarcodeByDocNo(int docNo) {
    	return dao.countBarcodeByDocNo(docNo);
    }
     
}
