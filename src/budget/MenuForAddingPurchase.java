package budget;

public class MenuForAddingPurchase {

    boolean isMenuForAddingCategoryOn = false;

    public void controllByMenuForChoosingCategory(Data data) {
        Category category = null;
        isMenuForAddingCategoryOn = true;
        while (isMenuForAddingCategoryOn) {
            showMenuForChoosingCategoryOfNewPurchase();
            switch (CollectorDataFromUser.getChoiceFromUser("[^12345]{1}")) {
                case "1":
                    category = Category.FOOD;
                    data.addPurchase(category);
                    break;
                case "2":
                    category = Category.CLOTHES;
                    data.addPurchase(category);
                    break;
                case "3":
                    category = Category.ENTERTAIMENT;
                    data.addPurchase(category);
                    break;
                case "4":
                    category = Category.OTHER;
                    data.addPurchase(category);
                    break;
                case "5":
                    this.isMenuForAddingCategoryOn = false;
                    System.out.println();
                    break;
            }
        }
    }

    public void showMenuForChoosingCategoryOfNewPurchase() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");
    }
}
