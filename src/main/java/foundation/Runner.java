package foundation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import foundation.jsonInstruments.Commenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class ParseJSON {
    static String path = "C:\\Users\\Viento\\Downloads\\";
    static String filename = "[2-8-22] Recrent - 24 ЧАСА СТРИМ Новый сезон в 2100 мск - Chat";
    static String json;

    static {
        try {
            json = Files.readString(Paths.get(path + filename + ".json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();


        JsonArray comments = jsonObject.getAsJsonArray("comments");
        List<Commenter> commenters = getCommenters(comments);
        ArrayList<String> patternsOfLaught = getPatternsOfLaught();

        ArrayList<String> chatStrings = makeChat(comments, commenters, patternsOfLaught);

//        String resultString = makeResultString(commenters, chatStrings);
        String newFilename = filename + "_updated.txt";

//        print(chatStrings);


        String resultStringLogo = makeResultStringLogo(commenters);
        System.out.println(resultStringLogo);
        makeTextFile(newFilename);
//        updateTextFile(resultString, newFilename);
        updateTextFile(resultStringLogo, newFilename);
    }

    private static String makeResultStringLogo(List<Commenter> commenters) {
        StringBuilder result = new StringBuilder();

        ArrayList<String> listOfLogo = new ArrayList<>();
        for (Commenter commenter : commenters) {
            if (!listOfLogo.contains(commenter.getLogo())) {
                listOfLogo.add(commenter.getLogo().substring(1, commenter.getLogo().length() - 1));
            }
        }
        for (String ofLogo : listOfLogo) {
            result.append(ofLogo + "\n");
        }

        return result.toString();

    }

    private static void print(ArrayList<String> chatStrings) {
        for (int i = 0; i < chatStrings.size(); i++) {
            if (chatStrings.get(i).contains("#lol_moment")) System.err.println(chatStrings.get(i));
            else System.out.println(chatStrings.get(i));
        }
    }

    private static String makeResultString(List<Commenter> commenters, ArrayList<String> chatStrings) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < chatStrings.size(); i++) {
            resultString.append(i).append(") ").append(commenters.get(i).getDisplayName()).append(" ").append(chatStrings.get(i)).append("\n");
        }
        return resultString.toString();
    }

    private static ArrayList<String> makeChat(JsonArray comments, List<Commenter> commenters, ArrayList<String> patternsOfLaught) {
        ArrayList<String> chatStrings = new ArrayList<>();
        for (int i = 0; i < commenters.size(); i++) {
            Commenter com = commenters.get(i);
            String message = String.valueOf(comments.get(i).getAsJsonObject().get("message").getAsJsonObject().get("body"));
            String time = getContentOffSetSeconds(comments.get(i));
            long mills = (long) Double.parseDouble(time) * 1000;
            String resultTime = timeToString(mills);
            for (int j = 0; j < patternsOfLaught.size(); j++) {
                if (message.contains(patternsOfLaught.get(j))) {
                    if (!chatStrings.contains(com.getId()))
                        chatStrings.add(resultTime + " #lol_moment " + message);
                    break;

                } else if (j + 1 == patternsOfLaught.size() && !chatStrings.contains(com.getId())) {
                    chatStrings.add(resultTime + "     " + message);
                }
            }
        }
        return chatStrings;
    }

    private static List<Commenter> getCommenters(JsonArray arr) {
        List<Commenter> commenters = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            String displayName = String.valueOf(arr.get(i).getAsJsonObject().get("commenter").getAsJsonObject().get("display_name"));
            String id = String.valueOf(arr.get(i).getAsJsonObject().get("commenter").getAsJsonObject().get("_id"));
            String name = String.valueOf(arr.get(i).getAsJsonObject().get("commenter").getAsJsonObject().get("name"));
            String type = String.valueOf(arr.get(i).getAsJsonObject().get("commenter").getAsJsonObject().get("type"));
            String bio = String.valueOf(arr.get(i).getAsJsonObject().get("commenter").getAsJsonObject().get("bio"));
            String createdAt = String.valueOf(arr.get(i).getAsJsonObject().get("commenter").getAsJsonObject().get("created_at"));
            String updatedAd = String.valueOf(arr.get(i).getAsJsonObject().get("commenter").getAsJsonObject().get("updated_at"));
            String logo = String.valueOf(arr.get(i).getAsJsonObject().get("commenter").getAsJsonObject().get("logo"));
            commenters.add(new Commenter(displayName, id, name, type, bio, createdAt, updatedAd, logo));
        }
        return commenters;
    }

    private static void updateTextFile(String text, String newFilename) {
        try (FileWriter writer = new FileWriter(newFilename, false)) {
            // запись всей строки
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void makeTextFile(String newFilename) {
        File f = new File(newFilename);
        try {
            if (f.createNewFile()) System.out.println("File created.\n File name:" + newFilename);
            else System.out.println("File not Created");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> getPatternsOfLaught() {
        ArrayList<String> patternsOfLaught = new ArrayList<>();
        patternsOfLaught.add("lol");
        patternsOfLaught.add("lul");
        patternsOfLaught.add("лол");
        patternsOfLaught.add("кек");
        patternsOfLaught.add("kek");
        patternsOfLaught.add("хах");
        patternsOfLaught.add("аха");
        patternsOfLaught.add("hah");
        patternsOfLaught.add("aha");
        patternsOfLaught.add("хъх");
        patternsOfLaught.add("Pog");
        patternsOfLaught.add("pog");
        int size = patternsOfLaught.size();
        for (int i = 0; i < size; i++) {
            patternsOfLaught.add(patternsOfLaught.get(i).toUpperCase(Locale.ROOT));
        }
        return patternsOfLaught;
    }

    private static String timeToString(long secs) {
        secs = secs / 1000;
        long hour = secs / 3600;
        long min = secs / 60 % 60;
        long sec = secs % 60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }


    private static String getContentOffSetSeconds(JsonElement jsonElement) {
        return String.valueOf(jsonElement.getAsJsonObject().get("content_offset_seconds"));
    }

//    public static boolean contains(String str, String symbol) {
//        return str.contains(symbol);
//    }
}
