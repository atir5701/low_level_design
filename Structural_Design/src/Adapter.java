///*
//The Adapter Design Pattern is a structural design pattern that allows
//incompatible interfaces to work together by converting the interface of
//one class into another that the client expects.
//The Adapter acts as a bridge between an incompatible interface and
//what the client actually expects.
//
//Components:
//1. Target Interface : INterface that the client code expects and uses
//2. Adpatee : Existing class with an incompatible interface that needs adapting
//3. Adpater : Class that implements the Target interface and uses Adaptee internally
//*/
//
//class LegacyGateway {
//    private long transactionReference;
//    private boolean isPaymentSuccessful;
//
//    public void executeTransaction(double totalAmount, String currency) {
//        System.out.println("LegacyGateway: Executing transaction for "
//                + currency + " " + totalAmount);
//        transactionReference = System.nanoTime();
//        isPaymentSuccessful = true;
//        System.out.println("LegacyGateway: Transaction executed successfully. Txn ID: "
//                + transactionReference);
//    }
//
//    public boolean checkStatus(long transactionReference) {
//        System.out.println("LegacyGateway: Checking status for ref: " + transactionReference);
//        return isPaymentSuccessful;
//    }
//
//    public long getReferenceNumber() {
//        return transactionReference;
//    }
//}
//
//interface PaymentProcessor {
//    void processPayment(double amount, String currency);
//    boolean isPaymentSuccessful();
//    String getTransactionId();
//}
//
//class LegacyAdapater implements PaymentProcessor{
//    private final LegacyGateway legacyGateway;
//
//    public LegacyAdapater(LegacyGateway l){
//        this.l = l;
//    }
//
//    @Override
//    public void processPayment(double amount, String currency) {
//        System.out.println("Adapter: Translating processPayment() for " + amount + " " + currency);
//        legacyGateway.executeTransaction(amount, currency);
//        currentRef = legacyGateway.getReferenceNumber(); // Store for later use
//    }
//
//    @Override
//    public boolean isPaymentSuccessful() {
//        return legacyGateway.checkStatus(currentRef);
//    }
//
//    @Override
//    public String getTransactionId() {
//        return "LEGACY_TXN_" + currentRef;
//    }
//}
//
//
//public class Adapter {
//    public void main(){
//        System.out.println("\n--- Using Legacy Gateway via Adapter ---");
//        LegacyGateway legacy = new LegacyGateway();
//        processor = new LegacyGatewayAdapter(legacy);
//        CheckoutService legacyCheckout = new CheckoutService(processor);
//        legacyCheckout.checkout(75.50, "USD");
//    }
//}
