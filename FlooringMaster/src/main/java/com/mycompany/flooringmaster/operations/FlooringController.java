/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.operations;

import com.mycompany.flooringmaster.dao.FlooringDAO;
import com.mycompany.flooringmaster.dto.Material;
import com.mycompany.flooringmaster.dto.Order;
import com.mycompany.flooringmaster.ui.ConsoleIO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author apprentice
 */
public class FlooringController {

    ConsoleIO console = new ConsoleIO();
    FlooringDAO dao;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
    String date;
    
    public FlooringController(FlooringDAO j){
            dao=j;
    }


    public void ui() {
        console.write("\nFlooring Program");
        console.write("\n\n1. Display Orders"
                + "\n2. Add an Order"
                + "\n3. Edit an Order"
                + "\n4. Remove an Order"
                + "\n5. Save Current Work"
                + "\n6. Quit");
        int choice = console.readInteger("\n>", 1, 6);
        switch (choice) {
            case 1:
                display();
                ui();
                break;
            case 2:
                add();
                ui();
                break;
            case 3:
                edit();
                ui();
                break;
            case 4:
                remove();
                ui();
                break;
            case 5:
                console.write("Your work was saved all along. Do you really think I'd let you lose data?");
                ui();
                break;
            case 6:
                console.write("Have a nice day!");
                break;
        }

    }

    private void display() {
        date = console.readString("\nEnter the date of the orders you'd like to display(please format MMDDYYYY):");
        if (dao.displayOrders(date).isEmpty()) {
            console.write("\nHmm..nothing found for the date entered.\n\n");
        } else {
            for (int i = 0; i < dao.displayOrders(date).size(); i++) {
                console.write(dao.displayOrders(date).get(i) + dao.displayOrders(date).get(i).getMaterialType().getProductType()
                        + "\n\tTotal $" + String.format("%.2f", dao.displayOrders(date).get(i).calcTotal(dao.displayOrders(date).get(i))) + "\n");
            }
        }
    }

    private void add() {
        boolean check;
        String custName = console.readString("\nOkay. I'm going to need some information from you."
                + "\nPlease Enter the Customer's Name: ");
        String state = console.readString("\nPlease enter the postal abbreviation for the State where the work will be performed: ");
        do {
            if (!dao.findStateTaxes().keySet().contains(state)) {
                console.write("\nWe only do business in ");
                dao.findStateTaxes().keySet().stream().forEach(a -> console.write(a + ", "));
                state = console.readString("\nPlease pick one of the listed states: ");
            }
        } while (!dao.findStateTaxes().keySet().contains(state));
        double area = console.readDouble("\nPlease enter the area in SqFt of project: ");
        do {
            if (area < 0.0) {
                console.write("Good grief. You can't give me a negative number here....");
                area = console.readDouble("\nPlease enter the area in SqFt of project: ");
            }
        } while (area < 0.0);
        console.write("\nPlease pick a stocked material ");
        for (int i = 1; i < dao.readMaterial().size() + 1; i++) {
            console.write("\n" + i + ". " + dao.readMaterial().get(i - 1).getProductType());
        }
        int matPosition = console.readInteger("\n>", 1, dao.readMaterial().size());
        String dateTemp = LocalDate.now().format(formatter);
        int orderNum;
        if (dao.displayOrders(dateTemp).isEmpty()) {
            orderNum = 1;
        } else {
            orderNum = dao.displayOrders(dateTemp).get(dao.displayOrders(dateTemp).size() - 1).getOrderNum() + 1;
        }
        Order hold = new Order(orderNum, custName, state, dao.findStateTaxes().get(state), area, dao.readMaterial().get(matPosition - 1));
        console.write("\nYour order is as follows:"
                + "\nName: " + custName
                + "\nState: " + state
                + "\nArea: " + area + " SqFt"
                + "\nMaterial: " + dao.readMaterial().get(matPosition - 1).getProductType()
                + "\nLabor cost: " + hold.calcLabCost(hold)
                + "\nMaterial cost: " + hold.calcMatCost(hold)
                + "\nTax: $" + String.format("%.2f", hold.calcTax(hold))
                + "\nTotal: $" + String.format("%.2f", hold.calcTotal(hold))
        );
        hold.setDate(dateTemp);
        int choice = console.readInteger("\nWould you like to commit this order 1-Yes, 2-No: ", 1, 2);
        if (choice == 1) {
            dao.addOrder(hold);
            console.write("Order Saved\n");
        } else {
            console.write("Order discarded\n");
        }
    }

    public void edit() {
        display();
        if (dao.displayOrders(date).isEmpty()) {
            return;
        } else {
            Order toEdit = dao.findOrder(console.readInteger("\nPlease enter the order number of the order you'd like to work with: ", 1, dao.displayOrders(date).get((dao.displayOrders(date).size()) - 1).getOrderNum()));
            console.write("\nIf you'd like to edit a field, please type a replacement or hit enter to make no changes.");
            String custName = console.readString("\nPlease Enter the Customer's Name(" + toEdit.getCustName() + "): ");
            if (checkString(custName)) {
                toEdit.setCustName(custName);
            }
            String state = console.readString("\nPlease enter the state(" + toEdit.getState() + "): ");
            if (checkString(state)) {
                do {
                    if (!dao.findStateTaxes().keySet().contains(state)) {
                        console.write("\nWe only do business in ");
                        dao.findStateTaxes().keySet().stream().forEach(a -> console.write(a + ", "));
                        state = console.readString("\nPlease pick one of the listed states: ");
                    }
                } while (!dao.findStateTaxes().keySet().contains(state));
                toEdit.setState(state);
            }
            String area = console.readString("Please enter the SqFt of the project(" + toEdit.getArea() + "): ");
            int loop = 0;
            do {
                if (checkString(area)) {
                    if (checkIfParse(area)) {
                        Double area1 = Double.parseDouble(area);
                        do {
                            if (area1 < 0.0) {
                                console.write("\nGood grief. You can't give me a negative number here....");
                                area1 = console.readDouble("\nPlease enter the area in SqFt of project: ");
                            } else {
                                toEdit.setArea(area1);
                                loop = 1;
                            }
                        } while (area1 < 0.0);

                    } else {
                        area = console.readString("\nPlease enter the SqFt of the project(" + toEdit.getArea() + "): ");
                    }
                }
                loop=1;
            } while (loop == 0);
            String material = console.readString("\nPlease enter the Material Type(" + toEdit.getMaterialType().getProductType() + "): ");
            if (checkString(material)) {
                int repeat = 0;
                do {
                    for (Material a : dao.readMaterial()) {
                        if (a.getProductType().equals(material)) {
                            toEdit.setMaterialType(a);
                            repeat = 1;
                        }
                    }
                    if (repeat == 0) {
                        console.write("\nRemember we only stock ");
                        for (Material b : dao.readMaterial()) {
                            console.write(b.getProductType() + " ");
                        }
                        material = console.readString("\nPlease enter the Material Type(" + toEdit.getMaterialType().getProductType() + "): ");
                    }

                } while (repeat == 0);
            }
            dao.editOrder(toEdit);
        }
    }

    public void remove() {
        display();
        if (dao.displayOrders(date).isEmpty()) {
            return;
        } else {
            int orderNumber = console.readInteger("\nPlease enter the order number of the order you'd like to remove:", 1, dao.displayOrders(date).get((dao.displayOrders(date).size()) - 1).getOrderNum());
            int position = 0;
            for (int i = 0; i < dao.displayOrders(date).size(); i++) {
                if (dao.displayOrders(date).get(i).getOrderNum() == orderNumber) {
                    position = i;

                }
            }
            int choice = console.readInteger("\nAre you sure you want to remove this order? 1-Yes, 2-No: ", 1, 2);
            if (choice == 1) {
                dao.removeOrder(position);
                console.write("Order Removed\n");
            } else {
                console.write("Okay we'll keep it\n");

            }
        }
    }

    boolean checkString(String toCheck
    ) {
        if (toCheck.length() == 0) {
            return false;
        }
        return true;
    }

    boolean checkIfParse(String toCheck
    ) {
        boolean answer;
        try {
            Double.parseDouble(toCheck);
            answer = true;
        } catch (NumberFormatException e) {
            console.write("\nI need a number there! ");
            answer = false;
        }
        return answer;

    }
}
