import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReadMain {

    public static void main(String[] args) throws IOException {

        File metaFile = new File("Metamorphosis.txt");
        String metaText = "Metamorphosis.txt";
        Scanner metaRead = new Scanner(metaFile);
        FileInputStream metaInput = new FileInputStream(metaFile);

        //VARIABLES to set values for what I need to find
        int wordCounted = 0;
        int sentenceCharCounter = 0;
        int metaParaCounter = 0;
        String space;

        //METAMORPHOSIS READER
        while (metaRead.hasNextLine()) {
            System.out.println(metaRead.nextLine());
        }

        //CHARACTERS COUNTER
        byte[] metaBytes = new byte[(int) metaFile.length()];

        //WORDS COUNTER
        metaInput.read(metaBytes);
        String wordCountTot = new String(metaBytes);
        String[] wordCounter = wordCountTot.split(" ");
        for (int i = 0; i < wordCounter.length; i++) {
            wordCounted++;
        }

        //SENTENCES COUNTER
        BufferedReader metaReader = new BufferedReader(new FileReader("Metamorphosis.txt"));
        String toLookFor = ".!?";
        while ((space = metaReader.readLine()) != null) {
            for (int i = 0; i < space.length(); i++) {
                if (toLookFor.indexOf(space.charAt(i)) != -1) {
                    sentenceCharCounter++;
                }
            }
            //PARAGRAPHS COUNTER
            if (space.equals("")) {
                metaParaCounter++;
            }
        }
            //FREQUENCY COUNTER
            try {
                String fileWords = Files.readString(Paths.get(metaText));
                fileWords.toLowerCase(Locale.ROOT);
                List <String> freq = Stream.of(fileWords).map(w -> w.split("\\b")).flatMap(Arrays::stream)
                        .collect(Collectors.toList());
                Map <String, Integer> freqCounter = freq.stream()
                        .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

                PrintWriter externalFile = new PrintWriter("wordsFrequency.txt");
                externalFile.println(freqCounter);
                externalFile.close();
                metaReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println();
        System.out.println("Here we have some stats about the Metamorphosis extract:");
        System.out.println();
        System.out.println("The number of characters in Metamorphosis is: " + metaFile.length() + ".");
        System.out.println("The word count for Metamorphosis is: " + wordCounted + ".");
        System.out.println("The number of sentences in Metamorphosis is: " + sentenceCharCounter + ".");
        System.out.println("The number of paragraphs in Metamorphosis is: " + metaParaCounter + ".");
    }
}