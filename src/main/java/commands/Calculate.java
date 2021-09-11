package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Calculate extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e){

        String[] q = e.getMessage().getContentRaw().split(" ");

        if(q.length == 1 && q[0].equalsIgnoreCase("|c"))
        {
            e.getChannel().sendMessage("Amne na lekhle math pari na: |c [add/sub/mul/duv] [first-num] [second-num]").queue();
        }
        else if (q.length != 4 && q[0].equalsIgnoreCase("|c")){
            e.getChannel().sendMessage("Sob kichu thik moto lekhosni").queue();
        }
        else if (q.length == 4 && q[0].equalsIgnoreCase("|c")){
            if(q[0].equalsIgnoreCase("|c") && q[1].equalsIgnoreCase("add"))
            {
                int num1 = Integer.parseInt(q[2]);
                int num2 = Integer.parseInt(q[3]);
                e.getChannel().sendMessage("Add kre aita paisi " + (num1 + num2)).queue();
            }
            else if(q[0].equalsIgnoreCase("|c") && q[1].equalsIgnoreCase("sub"))
            {
                int num1 = Integer.parseInt(q[2]);
                int num2 = Integer.parseInt(q[3]);
                e.getChannel().sendMessage("Substract kre aita paisi " + (num1 - num2)).queue();
            }
            else if(q[0].equalsIgnoreCase("|c") && q[1].equalsIgnoreCase("mul"))
            {
                double num1 = Double.parseDouble(q[2]);
                double num2 = Double.parseDouble(q[3]);
                e.getChannel().sendMessage("Multiply kre aita paisi " + (num1 * num2)).queue();
            }
            else if(q[0].equalsIgnoreCase("|c") && q[1].equalsIgnoreCase("div"))
            {
                double num1 = Double.parseDouble(q[2]);
                double num2 = Double.parseDouble(q[3]);
                e.getChannel().sendMessage("Divides kre aita paisi " + (num1 / num2)).queue();
            }
        }







    }
}
