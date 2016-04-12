package com.springbatch.demo.model;

/**
 * Created by huyan on 2016/4/12.
 */
public class PayRecord {

    private Long id;
    private Bill bill;
    private Double paidFees;
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Bill getBill() {return bill;}
    public void setBill(Bill bill) {this.bill = bill;}
    public Double getPaidFees() {return paidFees;}
    public void setPaidFees(Double paidFees) {this.paidFees = paidFees;}

}
