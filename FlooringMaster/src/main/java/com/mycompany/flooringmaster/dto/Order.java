/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dto;

/**
 *
 * @author apprentice
 */
public class Order {
    private int orderNum;
    private String custName;
    private String state;
    private double taxRate;
    private double area;
    private Material materialType;
    private String date;
    
    public Order(int orderNum, String custName, String state, double taxRate, double area, Material materialType){
        this.orderNum=orderNum;
        this.custName=custName;
        this.state=state;
        this.taxRate=taxRate;
        this.area=area;
        this.materialType=materialType;
    }

    /**
     * @return the orderNum
     */
    public int getOrderNum() {
        return orderNum;
    }

    /**
     * @param orderNum the orderNum to set
     */
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the taxRate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the materialType
     */
    public Material getMaterialType() {
        return materialType;
    }

    /**
     * @param materialType the materialType to set
     */
    public void setMaterialType(Material materialType) {
        this.materialType = materialType;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    public String toString(){
        return "\nOrder Number: "+orderNum
                +"\n\n\tCustName: "+custName
                +"\n\tState:"+state
                +"\n\t"+area+" SqFt of ";
    }
       
    public double calcMatCost(Order a) {
        return a.getMaterialType().getCostPerSqFt() * a.getArea();
    }

    
    public double calcLabCost(Order a) {
        return a.getMaterialType().getLaborPerSqFt() * a.getArea();
    }

  
    public double calcTax(Order a) {
        return (calcLabCost(a) + calcMatCost(a)) * (a.getTaxRate() / 100);
    }

    
    public double calcTotal(Order a) {
        return calcLabCost(a) + calcMatCost(a) + calcTax(a);
}
}
