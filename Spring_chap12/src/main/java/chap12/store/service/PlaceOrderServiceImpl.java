package chap12.store.service;

import chap12.store.dao.ItemDao;
import chap12.store.domain.ItemNotFoundException;
import chap12.store.dao.PaymentInfoDao;
import chap12.store.dao.PurchaseOrderDao;
import chap12.store.domain.Item;
import chap12.store.domain.PaymentInfo;
import chap12.store.domain.PurchaseOrder;
import chap12.store.service.PlaceOrderService;
import chap12.store.service.PurchaseOrderRequest;
import chap12.store.service.PurchaseOrderResult;

public class PlaceOrderServiceImpl implements PlaceOrderService
{
    
    private ItemDao itemDao;
    
    private PaymentInfoDao paymentInfoDao;
    
    private PurchaseOrderDao purchaseOrderDao;
    
    public void setItemDao(ItemDao itemDao)
    {
        this.itemDao = itemDao;
    }
    
    public void setPaymentInfoDao(PaymentInfoDao paymentInformationDao)
    {
        this.paymentInfoDao = paymentInformationDao;
    }
    
    public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao)
    {
        this.purchaseOrderDao = purchaseOrderDao;
    }
    
    @Override
    public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException
    {
        Item item = itemDao.findById(orderRequest.getItemId());
        if (item == null) 
            throw new ItemNotFoundException(orderRequest.getItemId());
        
        PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
        paymentInfoDao.insert(paymentInfo);
        
        PurchaseOrder order = new PurchaseOrder(item.getId(), orderRequest.getAddress(), paymentInfo.getId());
        purchaseOrderDao.insert(order);
        return new PurchaseOrderResult(item, paymentInfo, order);
    }
    
}
