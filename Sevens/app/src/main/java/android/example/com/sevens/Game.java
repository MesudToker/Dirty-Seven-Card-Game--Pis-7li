package android.example.com.sevens;

import java.util.ArrayList;
import java.util.Scanner;

import static android.example.com.sevens.R.drawable.c2;

/**
 * Created by lenovo on 25.12.2016.
 */
public class Game
{

    Scanner scan = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList<Player>();
    private boolean status;
    private int noOfBots;
    private int turn;
    private boolean direction;
    private int playerNum;
    public Deck d;
    public Deck d2;
    private int maxDraw;
    private int ace;
    private int ten;
    private int joker;
    private boolean success;
    private Player p;
    public Game(int noOfBots, int deckNumber, int maxDraw, int ace, int ten, int joker)
    {
        this.noOfBots = noOfBots;
        this.d = new Deck(deckNumber);
        this.d2 = new Deck();
        this.status = false;
        this.turn = 0;
        this.direction = true;
        this.maxDraw = maxDraw;
        this.ace = ace;
        this.ten = ten;
        this.joker = joker;
        playerNum = this.getTurn() % this.getNumberOfPlayers();
        players.add(new Player("Player"));
        players.add(new Bot("bot1"));
        p = this.getPlayer(this.getTurn());
        players.add(new Bot("bot2"));
        players.add(new Bot("bot3"));


        if(noOfBots >3)
            players.add(new Bot("bot4"));
        if(noOfBots >4)
            players.add(new Bot("bot5"));
        if(noOfBots >5)
            players.add(new Bot("bot6"));
        if(noOfBots >6)
            players.add(new Bot("bot7"));
        this.dealCards(d);
    }
    public void startGame()
    {
        //this.dealCards(d);
        //this.tables(d, d2);
        //p = this.getPlayer(this.getTurn());
        System.out.println("aaaaasdsd");
        System.out.println("1Player " + (( this.getTurn() % this.getNumberOfPlayers() ) + 1 ) + "'s Turn ");

        success = false;

        if((this.getPlayerNum()) == 0)
        {
            System.out.println("Play a card: (1) ");
            System.out.println("Draw a card: (2) ");
            int choice = GameActivity.gChoice;
            System.out.println("gChoice "+ GameActivity.gChoice);
            successing(choice);

        }
        for(int j=0; j<this.getNumberOfPlayers()-1; j++)
        {
            success = false;
            p = this.getPlayer(this.getTurn());
            System.out.println("2Player " + (( this.getTurn() % this.getNumberOfPlayers() ) + 1 ) + "'s Turn ");
            int i=0;
            while(i < p.getHand().getHandSize() && success == false)
            {
                if(p.getHand().getCard(i).getCardKind().equals('c'))
                {
                    p.firstPlayCard(p.getHand().getCard(i), d2);
                    success = true;
                    this.setTurn(p, this.getDirection());
                    //Tables
                    this.tables(d, d2);
                }
                else if(i == p.getHand().getHandSize() - 1 )
                    p.drawCard(d.drawCard(d2));
                i++;
            }
        }
        if(d2.getCard(d2.getDeckSize()-1).getCardValue() == 7)
            d2.getCard(d2.getDeckSize()-1).setCardValue(14);
        this.gamePlay();
    }

    public void successing(int choice){
        System.out.println("deck size "+d2.getDeckSize());
        if(d2.getDeckSize()==0) {
            boolean success = false;
            while (success == false) {
                System.out.println("succes false");

                if (choice == 1) {
                        System.out.println("Index of the card: ");
                        //int index = scan.nextInt();
                        int index = -1;
                        if (true)//index >= 0 && index < p.getHand().getHandSize())
                        {
                            if (GameActivity.gString.substring(0, 1).equals("c")) {
                                System.out.println("GsTRING"+GameActivity.gString);
                                for (int i = 0; i < p.getHand().getHandSize(); i++) {
                                    if (p.getHand().getCard(i).getCardInfo().equals(GameActivity.gString))
                                        index = i;
                                }

                                p.firstPlayCard((p.getHand().getCard(index)), d2);
                                success = true;
                                this.setTurn(p, this.getDirection());
                                //Tables
                                this.tables(d, d2);

                            }
                            //else {
                                //System.out.println("You can't play that card");
                                //System.out.println("Play a card: (1) ");
                                //System.out.println("Draw a card: (2) ");
                                //choice = scan.nextInt();
                            //}
                        }
                    break;
                } else if (choice == 2) {
                    System.out.println("Kart cekecez");
                    p.drawCard((Card) (d.drawCard(d2)));
                    System.out.println("Kart cektik");
                    break;
                    //Tables
                /*
                this.tables(d, d2);
                System.out.println("Play a card: (1) ");
                System.out.println("Draw a card: (2) ");
                choice = scan.nextInt();
                */
                } /*else {
                    System.out.println("Wrong choice");
                    System.out.println("Play a card: (1) ");
                    System.out.println("Draw a card: (2) ");
                    //choice = scan.nextInt();
                }*/
            }
        }
        else{
            System.out.println("3Player " + (( this.getTurn() % this.getNumberOfPlayers() ) + 1 ) + "'s Turn ");
            this.tables(d, d2);
            Player p = this.getPlayer(this.getTurn());
            //Human
            boolean b = false, b2 = false;
            if(this.getPlayerNum() == 0)
            {
                System.out.println("Play a card: (1) ");
                System.out.println("Draw a card: (2) ");
                System.out.println("Pass: (3)");
                System.out.println("One Card Left: (4)");
                //int choice = scan.nextInt();

                if(choice == 1)
                {
                    System.out.println("Index of the card: ");
                    //int index = scan.nextInt();
                    int index=-1;
                    if(true)//index >= 0 && index < p.getHand().getHandSize())
                    {
                        for(int i=0;i<p.getHand().getHandSize();i++){
                            if(GameActivity.gString.equals(p.getHand().getCard(i).getCardInfo())){
                                index=i;
                            }
                        }
                        b = p.isOK(this.getPlayer(this.getPlayerNum()).getHand().getCard(index), d2, this.joker);
                        p.playCard(this.getPlayer(this.getPlayerNum()).getHand().getCard(index), d2, this.joker);
                        //sıra değişimi
                        if(b)
                            this.next(p, d2);
                        if(d2.getCard(d2.getDeckSize()-1).getCardValue() != this.ace)
                        {
                            p.setOneCardLeft(false);
                        }
                    }


                }
                else if(choice == 2)
                {
                    if(d2.getCard(d2.getDeckSize()-1).getCardValue() == 7)
                    {
                        int i = 1;

                        while(d2.getCard(d2.getDeckSize()-i).getCardValue() == 7)
                        {
                            if(d2.getDeckSize() >= i)
                            {
                                for(int j=0; j<this.maxDraw; j++)
                                {
                                    p.drawCard(d.drawCard(d2));
                                    p.updateDrawnCards();
                                }
                                i++;
                            }
                        }
                    }
                    else
                    {
                        if(p.getDrawnCards() < this.maxDraw && d2.getCard(d2.getDeckSize()-1).getCardValue() != this.ace)
                        {
                            p.drawCard(d.drawCard(d2));
                            p.updateDrawnCards();
                        }
                        else
                            System.out.println("!!! Max card drawn !!!");
                    }

                }

                else if(choice == 3)
                {
                    if(p.getDrawnCards() >= this.maxDraw && d2.getCard(d2.getDeckSize()-1).getCardValue() != this.ace)
                        this.next(p, d2);
                    else if(d2.getCard(d2.getDeckSize()-1).getCardValue() == this.ace)
                    {
                        while(d2.getCard(d2.getDeckSize()-1).getCardValue() == this.ace)
                        {
                            p.getHand().addToHand(d2.getCard(d2.getDeckSize()-1));
                            d2.removeCard(d2.getDeckSize()-1);
                        }
                        if(p.getDrawnCards() >= this.maxDraw)
                            this.next(p, d2);
                    }
                }

                else if(choice == 4)
                {
                    b = true;
                }

                else
                {
                    System.out.println("!!! Wrong choice !!!");
                }
            }


            //Bot
            else
            {
                //Sıra bottayken onecardleft basılmış mı ve human'ın hand size'ı 1 mi
                if(b == true && this.getPlayer(0).getHand().getHandSize() == 1)
                    this.getPlayer(0).setOneCardLeft(true);
                else
                    this.getPlayer(0).setOneCardLeft(false);

                //botun sırası

                //b2 bot kart oynarsa true
                b2 = p.botPlayCard(p.getHand(), d2, this.joker);
                if(b2 == true)
                {
                    this.next(p, d2);
                }

                if(p.getDrawnCards() < this.maxDraw)
                {
                    if(b2 == false)
                    {
                        if(d2.getCard(d2.getDeckSize()-1).getCardValue() == 7)
                        {
                            int i = d2.getDeckSize()-1;

                            while(d2.getCard(i).getCardValue() == 7)
                            {
                                if(i>=0)
                                {
                                    for(int j=0; j<this.maxDraw; j++)
                                    {
                                        p.drawCard(d.drawCard(d2));
                                        p.updateDrawnCards();
                                    }
                                    i++;
                                }
                            }
                        }
                        else
                        {
                            p.drawCard(d.drawCard(d2));
                            p.updateDrawnCards();
                        }
                    }
                }
                else
                    this.setTurn(p, direction);

                if(b2 == false && d2.getCard(d2.getDeckSize()-1).getCardValue() == 7)
                    d2.getCard(d2.getDeckSize()-1).setCardValue(14);
                //Bot oyunu bitirirse
                if(p.getHand().getHandSize() == 0)
                    this.setStatus(true);
            }
        }

    }

    public void gamePlay()
    {
        successing(GameActivity.gChoice);
    }

    public void loadConfig()
    {

    }

    public void next(Player p, Deck d2)
    {
        if(p.getHand().getHandSize() == 0)
        {
            if(this.getPlayerNum() == 0)
            {
                if( p.getOneCardLeft() == true || d2.getCard(d2.getDeckSize()-2).getCardValue() == this.ace)
                    this.setStatus(true);
            }
            else
                this.setStatus(true);
        }
        else
        {
            if(d2.getCard(d2.getDeckSize()-1).getCardValue() != this.ace)
            {
                if(d2.getCard(d2.getDeckSize()-1).getCardValue() != this.ten)
                {
                    this.setTurn(p, direction);
                }
                else
                {
                    this.direction = !direction;
                    this.setTurn(p, direction);
                }
                this.setPlayerNum();
            }
        }

        //if(d2.getCard(d2.getDeckSize()-1).getCardValue() == 7)

    }

    public void setTurn(Player p, boolean direction)
    {
        if(direction == true)
            this.turn++;
        else
            this.turn--;
        if(this.turn < 0)
            this.turn = this.turn + this.getNumberOfPlayers();
        p.setDrawnCards();
    }
    public int getTurn()
    {
        return turn;
    }
    public void setDirection(boolean d)
    {
        this.direction = d;
    }

    public boolean getDirection()
    {
        return direction;
    }

    public void setPlayerNum()
    {
        this.playerNum = this.getTurn() % this.getNumberOfPlayers();
    }

    public int getPlayerNum()
    {
        return this.playerNum;
    }

    public Player getPlayer(int x)
    {
        return this.players.get(x%(noOfBots+1));
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public boolean getStatus()
    {
        return this.status;
    }

    public int getNumberOfPlayers()
    {
        return this.noOfBots + 1;
    }

    public void dealCards( Deck deck)
    {
        deck.shuffle();
        for(int i=0; i<(noOfBots+1);i++)
        {
            for(int j=0;j<7;j++)
            {
                this.players.get(i).drawCard(deck.drawCard());
            }
        }
    }

    public void cardTable()
    {
        for(int i=0; i< this.getNumberOfPlayers(); i++)
        {
            System.out.println("Player " + (i+1) + "'s cards: ");
            for(int j=0; j< this.getPlayer(i).getHand().getHandSize(); j++)
                System.out.print(this.getPlayer(i).getHand().getCard(j).toString() + " || " );
            System.out.println(" ");
        }
    }
    public void tables(Deck d, Deck d2)
    {
        System.out.println("");
        this.cardTable();
        System.out.println("Deck Cards: ");
        d.deckTable();
        System.out.println("");
        System.out.println("Cards On Table: ");
        d2.deckTable();
        System.out.println("");
        System.out.println("-------------------------------------------------------");
    }

}
