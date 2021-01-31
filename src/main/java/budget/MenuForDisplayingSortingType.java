package budget;

public class MenuForDisplayingSortingType {

    public void controllByMenuForDisplayingPurchases(Data data){
        showMenu();
        switch (CollectorDataFromUser.getChoiceFromUser("[^1234]{1}")) {
            case "1":
                System.out.println("\nFood:");
                data.printFilteredAndSortedListAccToCategory(Category.FOOD);
                break;
            case "2":
                System.out.println("\nClothes:");
                data.printFilteredAndSortedListAccToCategory(Category.CLOTHES);
                break;
            case "3":
                System.out.println("\nEntertainment:");
                data.printFilteredAndSortedListAccToCategory(Category.ENTERTAIMENT);
                break;
            case "4":
                System.out.println("\nOther:");
                data.printFilteredAndSortedListAccToCategory(Category.OTHER);
                break;
        }
        return;
    }

    private void showMenu() {
        System.out.println("\nChoose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
    }
}
