package budget;

import java.io.IOException;

public class MainController {

    Data data = new Data();
    boolean isAppTurningOn = true;
    MenuForDisplaying menuForDisplaying = new MenuForDisplaying();
    MenuForAddingPurchase menuForAddingPurchase = new MenuForAddingPurchase();
    PurchaseSaver purchaseSaver = new PurchaseSaver();
    PurchaseLoader purchaseLoader = new PurchaseLoader();
    MenuForAnalizing menuForAnalizing = new MenuForAnalizing();

    public void controllByMenu() throws IOException {
        while (isAppTurningOn) {
            showBasicMenu();
            switch (CollectorDataFromUser.getChoiceFromUser("[^12345670]{1}")) {
                case "1":
                    data.addIncome();
                    break;
                case "2":
                    System.out.println("");
                    menuForAddingPurchase.controllByMenuForChoosingCategory(data);
                    break;
                case "3":
                    System.out.println("");
                    menuForDisplaying.controllByMenuForDisplayingPurchases(data);
                    break;
                case "4":
                    System.out.println("\nBalance: $"+data.getBalance()+"\n");
                    break;
                case "5":
                    purchaseSaver.savePurchases(data);
                    break;
                case "6":
                    data.purchases.addAll(purchaseLoader.loadPurchaseListFromFile(data));
                    break;
                case "7":
                    menuForAnalizing.controllByMenuForDisplayingPurchases(data);
                    break;
                case "0":
                    System.out.println("\nBye!");
                    this.isAppTurningOn = false;
                    break;
            }
        }
    }

    public void showBasicMenu() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("7) Analyze (Sort)");
        System.out.println("0) Exit");
    }
}
