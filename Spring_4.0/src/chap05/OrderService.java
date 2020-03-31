package chap05;

import java.awt.SecondaryLoop;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import chap022.SearchClientFactory;
import chap022.SearchDocument;
import chap04.ErpClient;
import chap04.ErpClientFactory;
import chap04.ErpOrderData;

@Component("orderSvc")
public class OrderService
{
    private ErpClientFactory erpClientFactory;
    private SearchClientFactory searchClientFactory;
    @Inject
    public void setErpClientFactory(ErpClientFactory erpClientFactory)
    {
        this.erpClientFactory = erpClientFactory;
    }
    @Autowired
    public void setSearClientFactory(@Qualifier("order")
    SearchClientFactory searchClientFactory)
    {
        this.searchClientFactory = searchClientFactory;
    }
    public void order(OrderInfo oi)
    {
        sendOrderInfoToErp(oi);
        addOrderInfoToSearch(oi);
    }
    private void addOrderInfoToSearch(OrderInfo oi)
    {
        searchClientFactory.create().addDocument(toSearchDocument(oi));
        
    }
    private SearchDocument toSearchDocument(OrderInfo oi)
    {
        // TODO Auto-generated method stub
        return new SearchDocument();
    }
    private void sendOrderInfoToErp(OrderInfo oi)
    {
        ErpClient erpClient = erpClientFactory.create();
        erpClient.connect();
        erpClient.sendPurchaseInfo(toErpOrderData(oi));
        erpClient.close();
        
    }
    private ErpOrderData toErpOrderData(OrderInfo oi)
    {
        // TODO Auto-generated method stub
        return new ErpOrderData();
    }
}
