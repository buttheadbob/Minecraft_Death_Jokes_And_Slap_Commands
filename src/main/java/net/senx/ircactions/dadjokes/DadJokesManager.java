package net.senx.ircactions.dadjokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DadJokesManager
{
    private static List<String> jokes = new ArrayList<>();

    static
    {
        jokes.add("I'm afraid for the calendar. Its days are numbered.");
        jokes.add("My wife said I should do lunges to stay in shape. That would be a big step forward.");
        jokes.add("Why do fathers take an extra pair of socks when they go golfing? In case they get a hole in one!");
        jokes.add("Singing in the shower is fun until you get soap in your mouth. Then it's a soap opera.");
        jokes.add("What do a tick and the Eiffel Tower have in common? They're both Paris sites.");
        jokes.add("What do you call a fish wearing a bowtie?....... Sofishticated.");
        jokes.add("How do you follow Will Smith in the snow? You follow the fresh prints.");
        jokes.add("If April showers bring May flowers, what do May flowers bring? Pilgrims.");
        jokes.add("I thought the dryer was shrinking my clothes. Turns out it was the refrigerator all along.");
        jokes.add("How does dry skin affect you at work? You don’t have any elbow grease to put into it.");
        jokes.add("What do you call a factory that makes okay products? A satisfactory.");
        jokes.add("Dear Math, grow up and solve your own problems.");
        jokes.add("What did the janitor say when he jumped out of the closet?.... Supplies!");
        jokes.add("Have you heard about the chocolate record player? It sounds pretty sweet.");
    }

    public static String GetRandomJoke()
    {
        Random random = new Random();
        int index = random.nextInt(jokes.size());
        return jokes.get(index);
    }
}
