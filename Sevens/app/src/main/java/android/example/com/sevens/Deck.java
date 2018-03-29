package android.example.com.sevens;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lenovo on 25.12.2016.
 */

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    int numberOfDecks;
    public Deck()
    {
    }
    public Deck(int num)
    {
        this.numberOfDecks = num;

        for(int k=0; k< numberOfDecks; k++)
        {
            deck.add(new Card(R.drawable.h13,13,"hearts"));
            deck.add(new Card(R.drawable.h12,12,"hearts"));
            deck.add(new Card(R.drawable.h11,11,"hearts"));
            deck.add(new Card(R.drawable.h10,10,"hearts"));
            deck.add(new Card(R.drawable.h9,9,"hearts"));
            deck.add(new Card(R.drawable.h8,8,"hearts"));
            deck.add(new Card(R.drawable.h7,7,"hearts"));
            deck.add(new Card(R.drawable.h6,6,"hearts"));
            deck.add(new Card(R.drawable.h5,5,"hearts"));
            deck.add(new Card(R.drawable.h4,4,"hearts"));
            deck.add(new Card(R.drawable.h3,3,"hearts"));
            deck.add(new Card(R.drawable.h2,2,"hearts"));
            deck.add(new Card(R.drawable.h1,1,"hearts"));

            deck.add(new Card(R.drawable.d13,13,"diamonds"));
            deck.add(new Card(R.drawable.d12,12,"diamonds"));
            deck.add(new Card(R.drawable.d11,11,"diamonds"));
            deck.add(new Card(R.drawable.d10,10,"diamonds"));
            deck.add(new Card(R.drawable.d9,9,"diamonds"));
            deck.add(new Card(R.drawable.d8,8,"diamonds"));
            deck.add(new Card(R.drawable.d7,7,"diamonds"));
            deck.add(new Card(R.drawable.d6,6,"diamonds"));
            deck.add(new Card(R.drawable.d5,5,"diamonds"));
            deck.add(new Card(R.drawable.d4,4,"diamonds"));
            deck.add(new Card(R.drawable.d3,3,"diamonds"));
            deck.add(new Card(R.drawable.d2,2,"diamonds"));
            deck.add(new Card(R.drawable.d1,1,"diamonds"));

            deck.add(new Card(R.drawable.c13,13,"clubs"));
            deck.add(new Card(R.drawable.c12,12,"clubs"));
            deck.add(new Card(R.drawable.c11,11,"clubs"));
            deck.add(new Card(R.drawable.c10,10,"clubs"));
            deck.add(new Card(R.drawable.c9,9,"clubs"));
            deck.add(new Card(R.drawable.c8,8,"clubs"));
            deck.add(new Card(R.drawable.c7,7,"clubs"));
            deck.add(new Card(R.drawable.c6,6,"clubs"));
            deck.add(new Card(R.drawable.c5,5,"clubs"));
            deck.add(new Card(R.drawable.c4,4,"clubs"));
            deck.add(new Card(R.drawable.c3,3,"clubs"));
            deck.add(new Card(R.drawable.c2,2,"clubs"));
            deck.add(new Card(R.drawable.c1,1,"clubs"));

            deck.add(new Card(R.drawable.s13,13,"spades"));
            deck.add(new Card(R.drawable.s12,12,"spades"));
            deck.add(new Card(R.drawable.s11,11,"spades"));
            deck.add(new Card(R.drawable.s10,10,"spades"));
            deck.add(new Card(R.drawable.s9,9,"spades"));
            deck.add(new Card(R.drawable.s8,8,"spades"));
            deck.add(new Card(R.drawable.s7,7,"spades"));
            deck.add(new Card(R.drawable.s6,6,"spades"));
            deck.add(new Card(R.drawable.s5,5,"spades"));
            deck.add(new Card(R.drawable.s4,4,"spades"));
            deck.add(new Card(R.drawable.s3,3,"spades"));
            deck.add(new Card(R.drawable.s2,2,"spades"));
            deck.add(new Card(R.drawable.s1,1,"spades"));
        }
    }
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public int getDeckSize()
    {
        return deck.size();
    }

    public Card drawCard()
    {
        return (Card)deck.remove(0);
    }
    public Card drawCard(Deck d2)
    {
        System.out.println("Kart cekecez");
        if(this.deck.size() == 0)
        {
            System.out.println("d size 0");
            boolean b = false;
            if(d2.getDeckSize() > 1)
            {

                //d2 de en az 1 tane 7li dışında bir kart varsa b = true
                for(int i=0; i<d2.getDeckSize();i++)
                {
                    if(d2.getCard(i).getCardValue() != 7)
                        b = true;
                }
                while(b == true)
                {
                    b = false;
                    for(int i=0; i<d2.getDeckSize();i++)
                    {
                        if(d2.getCard(i).getCardValue() != 7)
                            b = true;
                    }
                    if(d2.getDeckSize() > 1 && b == true)
                    {
                        if(d2.getCard(0).getCardValue() == 14)
                            d2.getCard(0).setCardValue(7);
                        this.deck.add(d2.deck.remove(0));
                    }
                    else
                        b = false;
                }
                Collections.shuffle(deck);
            }
            else
            {
                deck.add(new Card(R.drawable.h13,13,"hearts"));
                deck.add(new Card(R.drawable.h12,12,"hearts"));
                deck.add(new Card(R.drawable.h11,11,"hearts"));
                deck.add(new Card(R.drawable.h10,10,"hearts"));
                deck.add(new Card(R.drawable.h9,9,"hearts"));
                deck.add(new Card(R.drawable.h8,8,"hearts"));
                deck.add(new Card(R.drawable.h7,7,"hearts"));
                deck.add(new Card(R.drawable.h6,6,"hearts"));
                deck.add(new Card(R.drawable.h5,5,"hearts"));
                deck.add(new Card(R.drawable.h4,4,"hearts"));
                deck.add(new Card(R.drawable.h3,3,"hearts"));
                deck.add(new Card(R.drawable.h2,2,"hearts"));
                deck.add(new Card(R.drawable.h1,1,"hearts"));

                deck.add(new Card(R.drawable.d13,13,"diamonds"));
                deck.add(new Card(R.drawable.d12,12,"diamonds"));
                deck.add(new Card(R.drawable.d11,11,"diamonds"));
                deck.add(new Card(R.drawable.d10,10,"diamonds"));
                deck.add(new Card(R.drawable.d9,9,"diamonds"));
                deck.add(new Card(R.drawable.d8,8,"diamonds"));
                deck.add(new Card(R.drawable.d7,7,"diamonds"));
                deck.add(new Card(R.drawable.d6,6,"diamonds"));
                deck.add(new Card(R.drawable.d5,5,"diamonds"));
                deck.add(new Card(R.drawable.d4,4,"diamonds"));
                deck.add(new Card(R.drawable.d3,3,"diamonds"));
                deck.add(new Card(R.drawable.d2,2,"diamonds"));
                deck.add(new Card(R.drawable.d1,1,"diamonds"));

                deck.add(new Card(R.drawable.c13,13,"clubs"));
                deck.add(new Card(R.drawable.c12,12,"clubs"));
                deck.add(new Card(R.drawable.c11,11,"clubs"));
                deck.add(new Card(R.drawable.c10,10,"clubs"));
                deck.add(new Card(R.drawable.c9,9,"clubs"));
                deck.add(new Card(R.drawable.c8,8,"clubs"));
                deck.add(new Card(R.drawable.c7,7,"clubs"));
                deck.add(new Card(R.drawable.c6,6,"clubs"));
                deck.add(new Card(R.drawable.c5,5,"clubs"));
                deck.add(new Card(R.drawable.c4,4,"clubs"));
                deck.add(new Card(R.drawable.c3,3,"clubs"));
                deck.add(new Card(R.drawable.c2,2,"clubs"));
                deck.add(new Card(R.drawable.c1,1,"clubs"));

                deck.add(new Card(R.drawable.s13,13,"spades"));
                deck.add(new Card(R.drawable.s12,12,"spades"));
                deck.add(new Card(R.drawable.s11,11,"spades"));
                deck.add(new Card(R.drawable.s10,10,"spades"));
                deck.add(new Card(R.drawable.s9,9,"spades"));
                deck.add(new Card(R.drawable.s8,8,"spades"));
                deck.add(new Card(R.drawable.s7,7,"spades"));
                deck.add(new Card(R.drawable.s6,6,"spades"));
                deck.add(new Card(R.drawable.s5,5,"spades"));
                deck.add(new Card(R.drawable.s4,4,"spades"));
                deck.add(new Card(R.drawable.s3,3,"spades"));
                deck.add(new Card(R.drawable.s2,2,"spades"));
                deck.add(new Card(R.drawable.s1,1,"spades"));

                Collections.shuffle(deck);
            }
        }
        System.out.println("Kart cektik remove oncesi");
        try {
            return this.deck.remove(0);
        }
        finally {
            System.out.println("Kart cektik harbi");
        }
    }

    public Card getCard(int index)
    {
        System.out.println("Kart get ettiik");
        return (Card)deck.get(index);
    }
    public void addCard(Card c)
    {
        deck.add(c);
    }

    public void removeCard(int x)
    {
        deck.remove(x);
    }


    public void deckTable()
    {
        for(int i=0; i<deck.size(); i++)
        {
            System.out.print(deck.get(i) + " || ");
        }
    }
}
