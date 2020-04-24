package chap12.store.service;

import chap12.store.domain.ItemNotFoundException;

public interface PlaceOrderService
{
    
    public PurchaseOrderResult order(PurchaseOrderRequest buyRequest) throws ItemNotFoundException;
}
