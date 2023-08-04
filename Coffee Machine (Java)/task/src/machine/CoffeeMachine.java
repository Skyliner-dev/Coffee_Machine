package machine;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.Integer.min;

public class CoffeeMachine {
         private static class Stats {
        void printStats() {
            System.out.println("The coffee machine has:");
            System.out.println(water + " ml of water");
            System.out.println(milk + " ml of milk");
            System.out.println(cb + " g of coffee beans");
            System.out.println(dc + " disposable cups");
            System.out.println("$"+cash + " of money");
        }
        int water = 400;
        int milk = 540;
        int cb = 120;
        int dc = 9;
        int cash = 550;
    }


    public static void main(String[] args) {
        Stats coffee = new Stats();
        String op;
        Scanner scanner = new Scanner(System.in);
        do {
            printAct();
            op = scanner.next();
            OuterLoop: switch (op) {
                case "buy" -> {
                    buyList();
                    String n = scanner.next();
                    if (Objects.equals(n, "1")) {
                        if (coffee.water<250) {
                            Invalid("water");
                        }
                        else if (coffee.cb<16) {
                            Invalid("coffee beans");
                        }
                        else {
                            Valid();
                            coffee.dc--;
                            coffee.water -= 250;
                            coffee.cb -= 16;
                            coffee.cash += 4;
                        }
                    } else if (Objects.equals(n, "2")) {
                        if (coffee.water<350) {
                            Invalid("water");
                        }
                        else if (coffee.milk<75) {
                            Invalid("milk");
                        }
                        else if (coffee.cb<20) {
                            Invalid("");
                        }
                        else {
                            Valid();
                            coffee.dc--;
                            coffee.water -= 350;
                            coffee.milk -= 75;
                            coffee.cb -= 20;
                            coffee.cash += 7;
                        }
                    } else if (Objects.equals(n, "3")) {
                        if (coffee.water<200) {
                            Invalid("water");
                        } else if(coffee.milk<100) {
                            Invalid("milk");
                        } else if(coffee.cb<12) {
                            Invalid("coffee beans");
                        } else {
                            Valid();
                            coffee.water -= 200;
                            coffee.milk -= 100;
                            coffee.cb -= 12;
                            coffee.cash += 6;
                            coffee.dc--;
                        }
                    } else if(Objects.equals(n,"back")) {
                         break OuterLoop;
                    }
                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add: ");
                    coffee.water += scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add: ");
                    coffee.milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    coffee.cb += scanner.nextInt();
                    System.out.println("Write how many disposable cups you want to add: ");
                    coffee.dc += scanner.nextInt();
                }
                case "take" -> {
                    System.out.println("I gave you $" + coffee.cash + "\n");
                    coffee.cash = 0;
                }
                case "remaining" -> coffee.printStats();
                case "exit" -> op = "exit";
            }
        } while (!op.equals("exit"));
    }
    static void Valid() {
        System.out.println("I have enough resources, making you a coffee!");
    }
    static void Invalid(String ing) {
        System.out.println("Sorry, not enough "+ing+"!");
    }
    static void printAct() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
    static void buyList() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
    }
}
