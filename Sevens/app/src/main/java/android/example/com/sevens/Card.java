package android.example.com.sevens;

/**
 * Created by lenovo on 24.12.2016.
 */

public class Card {
    private int imgid;
    private int value;
    private String kind;

    public Card(int _imgid,int _value,String _kind){
        imgid=_imgid;
        value=_value;
        kind=_kind;
    }

    public Card(){
        imgid=0;
        value=0;
        kind="";
    }

    public void setImgid(int _imgid){
        imgid=_imgid;
    }
    public void setCardValue(int _value){
        value=_value;
    }
    public void setCardKind(String _kind){
        kind=_kind;
    }


    public int getImgid(){
        return imgid;
    }
    public int getCardValue(){
        return value;
    }
    public String getCardKind(){
        return kind;
    }

    public String getCardInfo() {return kind.charAt(0) +"" + value;}
}
