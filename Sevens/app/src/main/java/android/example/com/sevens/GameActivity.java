package android.example.com.sevens;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.example.com.sevens.R.id.deck1;
import static android.example.com.sevens.R.id.newGame;

/**
 * Created by lenovo on 24.12.2016.
 */

public class GameActivity extends AppCompatActivity {
    ImageView drop;
    Game newGame;
    public static int gChoice = 0;
    public static String gString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        newGame=new Game(3,1,2,1,10,11);
        System.out.println("NewGame ypasdf");
        /*
        ArrayList<Card> cards= new ArrayList<>();
        cards.add(new Card(R.drawable.h13,13,"hearts"));
        cards.add(new Card(R.drawable.h12,12,"hearts"));
        cards.add(new Card(R.drawable.h11,11,"hearts"));
        cards.add(new Card(R.drawable.h10,10,"hearts"));
        cards.add(new Card(R.drawable.h9,9,"hearts"));
        cards.add(new Card(R.drawable.h8,8,"hearts"));
        cards.add(new Card(R.drawable.h7,7,"hearts"));
        cards.add(new Card(R.drawable.h6,6,"hearts"));
        cards.add(new Card(R.drawable.h5,5,"hearts"));
        cards.add(new Card(R.drawable.h4,4,"hearts"));
        cards.add(new Card(R.drawable.h3,3,"hearts"));
        cards.add(new Card(R.drawable.h2,2,"hearts"));
        cards.add(new Card(R.drawable.h1,1,"hearts"));

        cards.add(new Card(R.drawable.d13,13,"diamonds"));
        cards.add(new Card(R.drawable.d12,12,"diamonds"));
        cards.add(new Card(R.drawable.d11,11,"diamonds"));
        cards.add(new Card(R.drawable.d10,10,"diamonds"));
        cards.add(new Card(R.drawable.d9,9,"diamonds"));
        cards.add(new Card(R.drawable.d8,8,"diamonds"));
        cards.add(new Card(R.drawable.d7,7,"diamonds"));
        cards.add(new Card(R.drawable.d6,6,"diamonds"));
        cards.add(new Card(R.drawable.d5,5,"diamonds"));
        cards.add(new Card(R.drawable.d4,4,"diamonds"));
        cards.add(new Card(R.drawable.d3,3,"diamonds"));
        cards.add(new Card(R.drawable.d2,2,"diamonds"));
        cards.add(new Card(R.drawable.d1,1,"diamonds"));

        cards.add(new Card(R.drawable.c13,13,"clubs"));
        cards.add(new Card(R.drawable.c12,12,"clubs"));
        cards.add(new Card(R.drawable.c11,11,"clubs"));
        cards.add(new Card(R.drawable.c10,10,"clubs"));
        cards.add(new Card(R.drawable.c9,9,"clubs"));
        cards.add(new Card(R.drawable.c8,8,"clubs"));
        cards.add(new Card(R.drawable.c7,7,"clubs"));
        cards.add(new Card(R.drawable.c6,6,"clubs"));
        cards.add(new Card(R.drawable.c5,5,"clubs"));
        cards.add(new Card(R.drawable.c4,4,"clubs"));
        cards.add(new Card(R.drawable.c3,3,"clubs"));
        cards.add(new Card(R.drawable.c2,2,"clubs"));
        cards.add(new Card(R.drawable.c1,1,"clubs"));

        cards.add(new Card(R.drawable.s13,13,"spades"));
        cards.add(new Card(R.drawable.s12,12,"spades"));
        cards.add(new Card(R.drawable.s11,11,"spades"));
        cards.add(new Card(R.drawable.s10,10,"spades"));
        cards.add(new Card(R.drawable.s9,9,"spades"));
        cards.add(new Card(R.drawable.s8,8,"spades"));
        cards.add(new Card(R.drawable.s7,7,"spades"));
        cards.add(new Card(R.drawable.s6,6,"spades"));
        cards.add(new Card(R.drawable.s5,5,"spades"));
        cards.add(new Card(R.drawable.s4,4,"spades"));
        cards.add(new Card(R.drawable.s3,3,"spades"));
        cards.add(new Card(R.drawable.s2,2,"spades"));
        cards.add(new Card(R.drawable.s1,1,"spades"));

        final ArrayList<Card> hand=new ArrayList<>();
        hand.add(cards.get(8));
        hand.add(cards.get(21));
        hand.add(cards.get(14));
        hand.add(cards.get(44));
        hand.add(cards.get(3));
        hand.add(cards.get(12));
        hand.add(cards.get(20));

        final ArrayList<Card> cardDeck1= new ArrayList<>();
        for(int i=30;i<43;i++) {
            cardDeck1.add(cards.get(i));
        }*/
        ImageView img1= (ImageView) findViewById(R.id.imageView1);
        img1.setImageResource(newGame.getPlayer(0).getHand().getCard(0).getImgid());
        img1.setTag(newGame.getPlayer(0).getHand().getCard(0).getCardInfo());

        ImageView img2= (ImageView) findViewById(R.id.imageView2);
        img2.setImageResource(newGame.getPlayer(0).getHand().getCard(1).getImgid());
        img2.setTag(newGame.getPlayer(0).getHand().getCard(1).getCardInfo());

        ImageView img3= (ImageView) findViewById(R.id.imageView3);
        img3.setImageResource(newGame.getPlayer(0).getHand().getCard(2).getImgid());
        img3.setTag(newGame.getPlayer(0).getHand().getCard(2).getCardInfo());

        ImageView img4= (ImageView) findViewById(R.id.imageView4);
        img4.setImageResource(newGame.getPlayer(0).getHand().getCard(3).getImgid());
        img4.setTag(newGame.getPlayer(0).getHand().getCard(3).getCardInfo());

        ImageView img5= (ImageView) findViewById(R.id.imageView5);
        img5.setImageResource(newGame.getPlayer(0).getHand().getCard(4).getImgid());
        img5.setTag(newGame.getPlayer(0).getHand().getCard(4).getCardInfo());

        ImageView img6= (ImageView) findViewById(R.id.imageView6);
        img6.setImageResource(newGame.getPlayer(0).getHand().getCard(5).getImgid());
        img6.setTag(newGame.getPlayer(0).getHand().getCard(5).getCardInfo());

        ImageView img7= (ImageView) findViewById(R.id.imageView7);
        img7.setImageResource(newGame.getPlayer(0).getHand().getCard(6).getImgid());
        img7.setTag(newGame.getPlayer(0).getHand().getCard(6).getCardInfo());

        img1.setOnTouchListener(new MyTouchListener());
        img2.setOnTouchListener(new MyTouchListener());
        img3.setOnTouchListener(new MyTouchListener());
        img4.setOnTouchListener(new MyTouchListener());
        img5.setOnTouchListener(new MyTouchListener());
        img6.setOnTouchListener(new MyTouchListener());
        img7.setOnTouchListener(new MyTouchListener());

        System.out.println("Touch listenerlsri koyfu");

        ImageView deck1=(ImageView) findViewById(R.id.deck1);
        deck1.setImageResource(R.drawable.cardback);
        deck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hand.add(cardDeck1.get(0));
                gChoice=2;
                System.out.println("Bastipimiz an");
                newGame.successing(2);
                System.out.println("d den kart aldik ve p ye verdik");

                String str = newGame.getPlayer(0).getHand().getCard(newGame.getPlayer(0).getHand().getHandSize()-1).getCardInfo();
                System.out.println("p ye ver'len son kart " + str);
                //cardDeck1.remove(0);
                LinearLayout layout1=(LinearLayout) findViewById(R.id.layout_h1);
                LinearLayout layout2=(LinearLayout) findViewById(R.id.layout_h2);

                ImageView imageView = new ImageView(getApplicationContext());

                imageView.setImageResource(newGame.getPlayer(0).getHand().getCard(newGame.getPlayer(0).getHand().getHandSize()-1).getImgid());
                imageView.setOnTouchListener(new MyTouchListener());
                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT,0.02f));
                imageView.setTag(str);
                System.out.println("Kart geldi " + str);
                if(newGame.d.getDeckSize()%2==0)
                    layout1.addView(imageView);
                else
                    layout2.addView(imageView);
            }
        });
        drop=(ImageView) findViewById(R.id.image_view2);
        drop.setOnDragListener(new MyDragListener());
        System.out.println("start oncesi");
        if(gChoice == 1 && newGame.d2.getDeckSize() == 0) {
            System.out.println("start oncesi harbi");
            newGame.startGame();
            System.out.println("start somrasi harbi");
        }

        //newGame.startGame();
        System.out.println("s sonrasi");
    }

    protected final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {

            //System.out.println("Image Buttton "+ (ImageButton)view.getDrawable().getConstantState() + "");
            //System.out.println("Mesudd " + view.getId() + "viec to stirng" + view.toString() +"Bu dam motiaon" + motionEvent.toString());
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.VISIBLE);

                return true;
            } else {
                return false;
            }
        }

    }



    class MyDragListener implements View.OnDragListener {

        //Drawable normalShape;
        //Drawable nS=getResources().getDrawable(R.drawable.d08);

        int id=0;
        @Override
        public boolean onDrag(View v, DragEvent event) {
            System.out.println(event.toString());

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    View v2 = (View) event.getLocalState();
                    v2.setVisibility(View.VISIBLE);
                    //id = v2.getId();
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    View v1 = (View) event.getLocalState();
                    v1.setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    View v3 = (View) event.getLocalState();
                    v3.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup

                    View view;
                    view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    String str = (String) view.getTag();
                    gString=(String)view.getTag();
                    gChoice=1;
                    newGame.successing(1);
                    //System.out.println("Hacı naber"+event.toString() +"asd");
                    int id = getResources().getIdentifier(str, "drawable", getPackageName());
                    drop.setImageResource(id);
                    System.out.println("Kart verdik " + str);
                    System.out.println("Aha bu da id  " + id);
                    if (str.equals("h1")) {
                        Intent myIntent = new Intent(GameActivity.this, ShowPopUpWindow.class);
                        startActivity(myIntent);
                    }
                    //Log.e("tEST" , view.get() + "");
                    owner.removeView(view);
                    view.setVisibility(View.VISIBLE);
                    //v.setForeground(getDrawable(R.drawable.front));
                        //v.setBackgroundDrawable(normalShape);

                        //LinearLayout container = (LinearLayout) v;
                        //container.addView(view);

                    view = (View) event.getLocalState();
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;

                default:
                    break;
            }
            return true;
        }

    }
}
