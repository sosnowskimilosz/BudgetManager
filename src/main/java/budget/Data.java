package budget;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Data {

    Double balance = 0.00;
    List<Purchase> purchases = new ArrayList<>();

    public void addIncome() {
        System.out.println("\nEnter income:");
        this.balance += Double.parseDouble(getDataFromUser());
        System.out.println("Income was added!\n");
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getDataFromUser() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void printPurchases(List<Purchase> purchases) {
        if (purchases.isEmpty()) {
            System.out.println("Purchase list is empty");
        } else {
            for (Purchase purchase : purchases) {
                System.out.println(purchase.getTitle() + " $" + purchase.getPriceFromBigDecimal());
            }
            System.out.println("Total sum: $" + getSumOfPurchases(purchases));
            System.out.println();
        }
    }

    public void addPurchase(Category category) {
        System.out.println("\nEnter purchase name:");
        String name = getDataFromUser();
        System.out.println("Enter its price:");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(getDataFromUser())).setScale(2, RoundingMode.HALF_UP);
        this.balance -= price.doubleValue();
        purchases.add(new Purchase(name, price, category));
        System.out.println("Purchase was added!\n");
    }

    public Double getSumOfPurchases(List<Purchase> purchases) {
        return purchases.stream().mapToDouble(a -> a.getPriceInDouble()).sum();
    }

    public void printFilteredList(Category category) {
        List<Purchase> localList;
        localList = purchases.stream().filter(a -> category.equals(a.getCategory())).collect(Collectors.toList());
        printPurchases(localList);
    }

    public void printSortedList() {
        List<Purchase> localList;
        localList = purchases.stream().sorted((o1, o2) -> o2.price.compareTo(o1.price)).collect(Collectors.toList());
        printPurchases(localList);
    }

    public void printFilteredAndSortedListAccToCategory(Category category) {
        List<Purchase> localList;
        localList = purchases.stream()
                .filter(a -> category.equals(a.getCategory()))
                .sorted((o1, o2) -> o2.price.compareTo(o1.price))
                .collect(Collectors.toList());
        printPurchases(localList);
    }

    public void printSpentMoneyAccToCategory(){
        System.out.println("Types:");
        System.out.println("Food - $"+getSumOfPurchasesAccToCategory(Category.FOOD));
        System.out.println("Entertainment - $"+getSumOfPurchasesAccToCategory(Category.ENTERTAIMENT));
        System.out.println("Clothes - $"+getSumOfPurchasesAccToCategory(Category.CLOTHES));
        System.out.println("Other - $"+getSumOfPurchasesAccToCategory(Category.OTHER));
        System.out.println();
    }

    public Double getSumOfPurchasesAccToCategory(Category category){
        return (new BigDecimal(purchases.stream()
                .filter(o->o.category==category).mapToDouble(o->o.price.doubleValue()).sum()).setScale(2, RoundingMode.HALF_UP)).doubleValue();
    }
}
