package budget;

import java.util.Scanner;

public class CollectorDataFromUser {

    public static Scanner in = new Scanner(System.in);

    public static String getChoiceFromUser(String txtForRegex) {
        String choiceFromUser = in.nextLine();
        while (validation(choiceFromUser, txtForRegex)) {
            System.out.println("Bad choice,try again.");
            choiceFromUser = in.nextLine();
        }
        return choiceFromUser;
    }

    private static boolean validation(String dataFromUser, String txtForRegex) {
        return dataFromUser.matches(txtForRegex);
    }
}
