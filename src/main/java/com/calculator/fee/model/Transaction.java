package com.calculator.fee.model;


import java.util.Objects;

/**
 *
 */
public class Transaction {

    private String externalTransactionId = "";
    private String clientId = "";
    private String securityId = "";
    private String transactionType = "";
    private String transactionDate = "";
    private String marketValue = "";
    private String priorityFlag = "";

    public Transaction() {
        // Default constructor
    }


    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getPriorityFlag() {
        return priorityFlag;
    }

    public void setPriorityFlag(String priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "externalTransactionId='" + externalTransactionId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", securityId='" + securityId + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", marketValue='" + marketValue + '\'' +
                ", priorityFlag='" + priorityFlag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return externalTransactionId.equals(that.externalTransactionId) &&
                clientId.equals(that.clientId) &&
                securityId.equals(that.securityId) &&
                transactionType.equals(that.transactionType) &&
                transactionDate.equals(that.transactionDate) &&
                marketValue.equals(that.marketValue) &&
                priorityFlag.equals(that.priorityFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalTransactionId, clientId, securityId, transactionType, transactionDate, marketValue, priorityFlag);
    }


}
