/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public class SalaryHistory {
    private Worker worker;
    private String status;
    private LocalDate Date;

    public SalaryHistory() {
    }

    public SalaryHistory(Worker worker, String status, LocalDate Date) {
        this.worker = worker;
        this.status = status;
        this.Date = Date;
    }

    
    
    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }
    
    
}
