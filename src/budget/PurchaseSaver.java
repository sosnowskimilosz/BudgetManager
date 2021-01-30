package budget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PurchaseSaver {

    public void savePurchases(Data data) throws IOException {
        File file = new File("purchases.txt");
        FileWriter writer = new FileWriter(file);
        writer.write(data.getBalance() + "\n");
        for (Purchase record : data.purchases) {
            writer.write(String.valueOf(record));
            writer.write("\n");
        }
        writer.close();
        System.out.println("\nPurchases were saved!\n");
    }
}
