package android.example.com.sevens;

import java.util.ArrayList;

/**
 * Created by lenovo on 25.12.2016.
 */

public class Hand {
    private ArrayList<Card> hand;

    public Hand()
    {
        hand = new ArrayList<Card>();
    }

    public void addToHand(Card c)
    {
        System.out.println("p ye Kart vercez");
        hand.add(c);
        System.out.println("p ye Kart verdik harbi");
    }

    public Card RemoveFromHand(Card c)
    {
        hand.remove(c);
        return c;
    }

    public int getHandSize()
    {
        return hand.size();
    }

    public Card getCard(int x)
    {
        return hand.get(x);
    }

    public ArrayList<Card> getHandCard()
    {
        return hand;
    }
}