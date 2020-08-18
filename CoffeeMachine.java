package machine;
import java.util.Scanner;
import java.lang.*;

public class CoffeeMachine {
    private Scanner scan = new Scanner(System.in);

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();
        boolean status;
        do {
            status = machine.writeAction();
        }
        while (status);

    }

    private CoffeeMachine() {
        this.scan = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
        this.money = 550;
    }

    private boolean writeAction(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String num6 = scan.next();
        switch (num6) {
            case "buy":
                System.out.println("");
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String num7 = scan.next();
                buy(num7);
                break;
            case "take":
                System.out.println("");
                take();
                break;
            case "fill":
                System.out.println("");
                System.out.println("Write how many ml of water do you want to add:");
                //Scanner scan6 = new Scanner(System.in);
                int num8 = scan.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                //Scanner scan6 = new Scanner(System.in);
                int num9 = scan.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                //Scanner scan6 = new Scanner(System.in);
                int num10 = scan.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                //Scanner scan6 = new Scanner(System.in);
                int num11 = scan.nextInt();
                fill(num8, num9, num10, num11);
                break;
            case "remaining":
                System.out.println("");
                remaining();
                break;
            case "exit":
                return false;
        }
        return true;
    }
    private void enoughAmount(int num1, int num2, int num3, int num4) {

        if (num1 / 200 < num4 || num2 / 50 < num4 || num3 / 15 < num4) {
            double small = Math.floor(num1 / 200);
            if (small > Math.floor(num2 / 50)) {
                small = num2 / 50;
            }
            else if (small > Math.floor(num3 / 15)) {
                small = Math.floor(num3 / 15);
            }
            int smallest = (int)Math.round(small);
            System.out.println("No, I can make only " + smallest + " cup(s) of coffee");
        }

        if (num1 / 200 >= num4 && num2 / 50 >= num4 && num3 / 15 >= num4
                && (Math.floor(num1 / 200) == num4 || Math.floor(num2 / 50) == num4 || Math.floor(num3 / 15) == num4)) {
            System.out.println("Yes, I can make that amount of coffee");
        }

        if (num1 / 200 > num4 && num2 / 50 > num4 && num3 / 15 > num4
                && !(Math.floor(num1 / 200) == num4 || Math.floor(num2 / 50) == num4
                || Math.floor(num3 / 15) == num4)) {
            double small = Math.floor(num1 / 200);
            if (small > Math.floor(num2 / 50)) {
                small = num2 / 50;
            }
            else if (small > Math.floor(num3 / 15)) {
                small = Math.floor(num3 / 15);
            }
            int smallest = (int)Math.round(small);
            int more = smallest - num4;
            System.out.println("Yes, I can make that amount of coffee (and even " + more + " more than that)");
        }

    }
    private void buy(String kind) {
        switch (kind) {
            case "3":
                if (water >= 200 && milk >= 100 && cups > 0 && coffeeBeans > 12) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water += - 200;
                    milk += -100;
                    cups += -1;
                    coffeeBeans += -12;
                    money += 6;
                }else if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                }else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                }else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                }else if (water < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                break;
            case "2":
                if (water >= 350 && milk >= 75 && cups > 0 && coffeeBeans > 20) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water += - 350;
                    milk += -75;
                    cups += -1;
                    coffeeBeans += -20;
                    money += 7;
                }else if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                }else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                }else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                }else if (water < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                break;
            case "1":
                if (water >= 250 && cups > 0 && coffeeBeans > 16) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water += - 250;
                    cups += -1;
                    coffeeBeans += -16;
                    money += 4;
                }else if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                }else if (cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                }else if (water < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                break;
            case "back":
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
        }
    }
    private void take() {
        System.out.print("I gave you $");
        System.out.println(money);
        money = 0;
    }
    private void fill(int num1, int num2, int num3, int num4) {
        water += num1;
        milk += num2;
        coffeeBeans += num3;
        cups += num4;
    }
    private void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.print("$");
        System.out.println(money + " of money");
    }
}
