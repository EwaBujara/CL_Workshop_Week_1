package pl.coderslab.mostRecentWords;

import org.apache.commons.lang3.ArrayUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static String[] excludedWords = {"<span class=\"title\">","</span>","oraz", "ponieważ", "a", "i", "o"};

    public static void main(String[] args) {
        //getData();
        wordFrequency();

    }
    private static void wordFrequency (){
        String[] words = putDataIntoTable();
        String [][] wordsList = null;

        for (String word: words){
            String[] arr = new String[2];
            int frequency=1;
            for (String str: words){

                if(word.equals(str)){
                   frequency++;
                    ArrayUtils.removeElement(words, str);
                }
            }
            arr[0]= word;
            arr[1]= String.valueOf(frequency);
            wordsList = ArrayUtils.add(wordsList, arr);
        }
        for(String[] str: wordsList){
            System.out.println(Arrays.toString(str));
        }
    }

    private static String[] putDataIntoTable(){
        String[] words = new String[0];
        try {
            File file = new File("./popular_words.txt");
            Scanner scanFile = new Scanner(file);

            while(scanFile.hasNextLine()) {
                Scanner scanWord = new Scanner(scanFile.nextLine());
                while (scanWord.hasNext()) {
                    String word = scanWord.next();
                    word  = word.toLowerCase();
                    word = word.replaceAll("!<.>", "");
                    word = word.replace(".", "");
                    //copy array and add new element
                    words = Arrays.copyOf(words, words.length + 1);
                    words[words.length - 1] = word;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
                return words;
    }


    private static void getData(){
        try {

            Connection connect = Jsoup.connect("http://www.onet.pl/");

            File file = new File("./popular_words.txt");
            PrintWriter pw = new PrintWriter(file);

            Document document = connect.get();
            Elements links = document.select("span.title");
            for
            (Element elem : links) {
                System.out.println(elem.text());
            }
            pw.println(links);

            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
