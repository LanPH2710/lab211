/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.SalaryHistory;
import entity.Worker;
import java.time.LocalDate;
import java.util.ArrayList;
import utils.Validator;

/**
 *
 * @author ADMIN
 */
public class WorkerService {

    //khai bao mang list worker
    ArrayList<Worker> listWorker;
    //khai bao mang list history
    ArrayList<SalaryHistory> listHistory;

    public WorkerService(ArrayList<Worker> listWorker, ArrayList<SalaryHistory> listHistory) {
        this.listWorker = listWorker;
        this.listHistory = listHistory;
    }

    //get 1 object worker
    public Worker getWorkerByCode(String code) {
        //loop list worker
        for (Worker worker : listWorker) {
            // so sanh id trong list worker voi code(input cua nguoi dung)
            if (worker.getId().equalsIgnoreCase(code)) {
                return worker;//equal -> return object worker
            }
        }
        return null;// khong equal -> return null 
    }

    public void addWorker(String code, String name, int age, int salary, String location) {
        listWorker.add(new Worker(code, name, age, salary, location));
    }

    public void changeSalary(Worker workerFound, String change, int salary) {
        if (change.equals("up")) {
            workerFound.setSalary(workerFound.getSalary() + salary);
        } else if (change.equals("down")) {
            if (salary >= workerFound.getSalary()) {
                System.out.println("salary must greater than 0");
            } else {
                workerFound.setSalary(workerFound.getSalary() - salary);
            }
        }
        Worker workerHistory = new Worker(workerFound.getId(), workerFound.getName(), workerFound.getAge(), workerFound.getSalary(), workerFound.getWorkLocation()
        );
        listHistory.add(new SalaryHistory(workerHistory, change, Validator.getDate()));
    }

    public ArrayList<SalaryHistory> displayWorker() {
        return listHistory;
    }

    public ArrayList<Worker> displayWorker1() {
        return listWorker;
    }

    public ArrayList<Worker> getWorkerNotChanged() {
        ArrayList<Worker> result = new ArrayList<>();

        for (Worker worker : listWorker) {
            boolean isChanged = false;

            for (SalaryHistory history : listHistory) {
                if (history.getWorker().getId().equalsIgnoreCase(worker.getId())) {
                    isChanged = true;
                    break;
                }
            }

            if (isChanged = false) {
                result.add(worker);
            }
        }

        return result;
    }

    

}
