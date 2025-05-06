package com.example.mvpbookingsystem.DTO;

public class ServiceTypeList {
    private Long serviceTypeId;
    private String serviceType;
    private int serviceTypePrice;
    private int estimatedTimer;

    public ServiceTypeList(Long serviceTypeId, String serviceType, int serviceTypePrice, int estimatedTimer) {
        this.serviceTypeId = serviceTypeId;
        this.serviceType = serviceType;
        this.serviceTypePrice = serviceTypePrice;
        this.estimatedTimer = estimatedTimer;
    }
    public Long getServiceTypeId() {
        return serviceTypeId;
    }
    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public int getServiceTypePrice() {
        return serviceTypePrice;
    }
    public void setServiceTypePrice(int serviceTypePrice) {
        this.serviceTypePrice = serviceTypePrice;
    }
    public int getEstimatedTimer() {
        return estimatedTimer;
    }
    public void setEstimatedTimer(int estimatedTimer) {
        this.estimatedTimer = estimatedTimer;
    }
}
