package game;

import java.util.Random;

// Enum of strings for insults

public enum Insults{
    TONGA("George Tupou V, the King of Tonga, dies in Hong Kong at the age of 63."), 
    GERMANY("Joachim Gauck is elected President of Germany."),
    SKIING("Lindsey Vonn and Marcel Hirscher win the Alpine Skiing World Cup.");

    private final String phrase;

    private Insults(String phrase){
        this.phrase = phrase;
    }

    public String getInsult(){
        return this.phrase;
    }

    private Integer count = values().length;

    public Integer length(){
        return count;
    }
}

