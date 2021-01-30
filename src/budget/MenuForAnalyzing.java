package budget;

class MenuForAnalizing {

    boolean isMenuForAnalizingOn = false;
    MenuForDisplayingSortingType menuForDisplayingSortingType=new MenuForDisplayingSortingType();

    public void controllByMenuForDisplayingPurchases(Data data) {
        isMenuForAnalizingOn = true;
        System.out.println();
        while (isMenuForAnalizingOn) {
            showMenu();
            switch (CollectorDataFromUser.getChoiceFromUser("[^1234]{1}")) {
                case "1":
                    System.out.println("\nAll:");
                    data.printSortedList();
                    break;
                case "2":
                    System.out.println("");
                    data.printSpentMoneyAccToCategory();
                    break;
                case "3":
                    menuForDisplayingSortingType.controllByMenuForDisplayingPurchases(data);
                    break;
                case "4":
                    this.isMenuForAnalizingOn = false;
                    System.out.println();
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("How do you want to sort?");
        System.out.println("1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort certain type");
        System.out.println("4) Back");
    }
}
