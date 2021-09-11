package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Memes extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String message = e.getMessage().getContentRaw();
        if (message.equalsIgnoreCase("|meme")){
            JSONParser parser = new JSONParser();
            String postLink = "";
            String title = "";
            String url = "";
            try {
                URL memeUrl = new URL("https://meme-api.herokuapp.com/gimme");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(memeUrl.openConnection().getInputStream()));

                String lines;
                while ((lines = bufferedReader.readLine())!=null){
                    JSONArray array = new JSONArray();
                    array.add(parser.parse(lines));

                    for (Object o : array){
                        JSONObject jsonObject = (JSONObject) o;
                        postLink = (String) jsonObject.get("postLink");
                        title = (String) jsonObject.get("title");
                        url = (String) jsonObject.get("url");
                    }
                }
                bufferedReader.close();

                e.getMessage().delete().queue();
                EmbedBuilder embedBuilder = new EmbedBuilder().setTitle(title,postLink).setImage(url).setColor(Color.CYAN);
                e.getChannel().sendMessage(embedBuilder.build()).queue();

            } catch (Exception ex) {
                e.getChannel().sendMessage("Akhn ar meme khuj te iccha kortese na").queue();
                ex.printStackTrace();
            }
        }

    }
}
