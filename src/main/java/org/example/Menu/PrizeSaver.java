package org.example.Menu;

import org.example.Model.Toy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.example.Menu.View.YELLOW;
import static org.example.Model.Prizes.getPrizes;

public class PrizeSaver {

    public static void savePrizesInFile() {

        String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        File result = new File("prizes" + formattedDateTime.replace(" ", "_").replace(":", "-") + ".txt");
        try (FileWriter writer = new FileWriter(result)){
            List<Toy> prizes = getPrizes();
            writer.write("+-----------------PRIZES----------------+\n");
            for (Toy toy : prizes) {
                writer.write(String.format("|   %-2s %-18s %-5s %-8s|%n",
                        " ", toy.getName(), " ", toy.getChance() + "%"));
            }
            writer.write("+---------------------------------------+");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
