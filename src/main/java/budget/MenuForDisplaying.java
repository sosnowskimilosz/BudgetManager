package budget;

import java.util.Scanner;

public class MenuForDisplaying {

    boolean isMenuForDisplayingPurchasesOn = false;

    public void controllByMenuForDisplayingPurchases(Data data) {
        isMenuForDisplayingPurchasesOn = true;
        while (isMenuForDisplayingPurchasesOn) {
            showMenuForDisplaingCategoryOfPurchase();
            switch (CollectorDataFromUser.getChoiceFromUser("[^123456]{1}")) {
                case "1":
                    System.out.println("\nFood:");
                    data.printFilteredList(Category.FOOD);
                    break;
                case "2":
                    System.out.println("\nClothes:");
                    data.printFilteredList(Category.CLOTHES);
                    break;
                case "3":
                    System.out.println("\nEntertaiment:");
                    data.printFilteredList(Category.ENTERTAIMENT);
                    break;
                case "4":
                    System.out.println("\nOther:");
                    data.printFilteredList(Category.OTHER);
                    break;
                case "5":
                    System.out.println("\nAll:");
                    data.printPurchases(data.purchases);
                    break;
                case "6":
                    this.isMenuForDisplayingPurchasesOn = false;
                    System.out.println();
                    break;
            }
        }
    }

    private void showMenuForDisplaingCategoryOfPurchase() {
        System.out.println("Choose the type of purchases");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");
    }
}
