package android.example.com.sevens;

import java.util.Scanner;

/**
 * Created by lenovo on 25.12.2016.
 */

public class Player
{
    public static boolean a;

    //Scanner scan = new Scanner(System.in);
    private String name;
    private int score;
    private Hand hand;
    private boolean oneCardLeft;
    private int drawnCards;
    public Player(String name)
    {
        this.hand = new Hand();
        this.name = name;
        this.score = 0;
        this.oneCardLeft = false;
        this.drawnCards = 0;
    }

    // kart atma
    public void firstPlayCard(Card c, Deck d2)
    {
        hand.RemoveFromHand(c);
        d2.addCard(c);
    }

    public void playCard(Card c, Deck d2, int joker)
    {
        if(this.isOK(c, d2, joker))
        {
            hand.RemoveFromHand(c);
            d2.addCard(c);
         /*   if(d2.getCard(d2.getDeckSize()-1).getCardValue() == joker)
            {
                System.out.println("Kind ? :");
                char ch = scan.next().charAt(0);
                while(!(ch == 'C' || ch == 'D' || ch == 'H' || ch == 'S'))
                    ch = scan.next().charAt(0);
                if(ch == 'C' || ch == 'D' || ch == 'H' || ch == 'S')
                    d2.getCard(d2.getDeckSize()-1).setCardKind(ch);
            }*/
        }
    }


    public boolean botPlayCard(Hand h, Deck d2, int joker)
    {
        for(int i=0; i<h.getHandSize(); i++)
        {
            if(this.isOK(h.getCard(i), d2, joker))
            {
                d2.addCard(hand.RemoveFromHand(h.getCard(i)));
                return true;
            }
        }
        return false;
    }

    // oynanacak card oyun kurallarına uygun mu
    public boolean isOK(Card c, Deck d2, int joker)
    {

        // en üstteki card 7 ve atılacak kart 7 ise
        if((d2.getCard(d2.getDeckSize()-1).getCardValue() % 13 == 7 || d2.getCard(d2.getDeckSize()-1).getCardValue() % 13 == 14) && c.getCardValue() % 13 == 7){

            return true;
        }
            // en üstteki card J(11) ve oynanacak kart J değilse
        else if(d2.getCard(d2.getDeckSize()-1).getCardValue() % 13 == joker && c.getCardValue() %13 != joker && c.getCardKind() == d2.getCard(d2.getDeckSize()-1).getCardKind()){

            return true;
        }
        else if(d2.getCard(d2.getDeckSize()-1).getCardValue() % 13 != joker && d2.getCard(d2.getDeckSize()-1).getCardValue() % 13 !=7 && c.getCardValue() == joker){

            return true;
        }
        else if(d2.getCard(d2.getDeckSize()-1).getCardValue() % 13 != joker && d2.getCard(d2.getDeckSize()-1).getCardValue() % 13 !=7 && (d2.getCard(d2.getDeckSize()-1).getCardKind() == c.getCardKind() || d2.getCard(d2.getDeckSize()-1).getCardValue() == c.getCardValue())){

            return true;
        }

        return false;

		/*
		if(d2.getCard(d2.getDeckSize()-1).getCardKind() == c.getCardKind() || d2.getCard(d2.getDeckSize()-1).getCardValue() == c.getCardValue())
			return true;
		return false;
		*/
    }

    // kart çekme
    public void drawCard(Card c)
    {
        System.out.println("Karti p ye vercez");
        try {
            hand.addToHand(c);
        }finally {
            System.out.println("Karti p ye verdik harbi");
        }

    }

    // score arttırma
    public void setScore(int score)
    {
        this.score += score;
    }

    public Hand getHand()
    {
        return hand;
    }

    public void setOneCardLeft(boolean b)
    {
        oneCardLeft = b;
    }

    public boolean getOneCardLeft()
    {
        return oneCardLeft;
    }

    public void updateDrawnCards()
    {
        this.drawnCards++;
    }

    public void setDrawnCards()
    {
        this.drawnCards = 0;
    }

    public int getDrawnCards()
    {
        return this.drawnCards;
    }
    // turn: her player oynadığında artıyor eğer 10 atılırsa(10 atılırsa boolean direction değişiyor) azalmaya başlıyor.
    // order: player ya da botun sırası
    // player: toplam player sayısı
    public boolean turn(int turn, int order, int player)
    {
        // Sıra - turn sayısı player modunda 0 ise oynayabilir
        if((( turn - order ) % player ) == 0 )
            return true;
        return false;
    }
}