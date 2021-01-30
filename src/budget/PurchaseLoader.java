package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PurchaseLoader {

    private List<Purchase> loadedPurchases = new ArrayList<>();

    public List<Purchase> loadPurchaseListFromFile(Data data) throws FileNotFoundException {
        File file = new File("purchases.txt");
        Scanner readFile = new Scanner(file);
        if (readFile.hasNextLine()) {
            data.setBalance(Double.parseDouble(readFile.nextLine()));
        }
        while (readFile.hasNextLine()) {
            String[] loadedStringTable = readFile.nextLine().split("@");
            data.purchases.add(new Purchase(loadedStringTable[0], BigDecimal.valueOf(Double.parseDouble(loadedStringTable[1])).setScale(2, RoundingMode.HALF_UP), Category.valueOf(loadedStringTable[2])));
        }
        readFile.close();
        System.out.println("\nPurchases were loaded!\n");
        return loadedPurchases;
    }
}
