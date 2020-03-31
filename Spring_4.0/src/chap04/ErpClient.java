package chap04;

public interface ErpClient
{
    public void connect() ;
  
    public void close() ;
   
    public void sendPurchaseInfo(ErpOrderData oi) ;
   
}
