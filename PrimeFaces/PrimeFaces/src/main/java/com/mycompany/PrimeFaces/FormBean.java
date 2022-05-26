/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.PrimeFaces;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author micha
 */
@Named(value = "formBean")
@RequestScoped
public class FormBean {
    
    private Integer firstNumber;
    private Integer secondNumber;
    private Integer result;
    private Date date;

    /**
     * Creates a new instance of FormBean
     */
    public FormBean() {
        date = new Date();
    }
    
    public void calculate() {
        result = firstNumber + secondNumber;
        updateMessage();
    }
    
    private void updateMessage() {
        String message = firstNumber + " + " + secondNumber + " = " + result;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Result", message));
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Integer secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}