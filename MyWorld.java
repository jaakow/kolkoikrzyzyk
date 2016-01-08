import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.lang.Math;

public class MyWorld extends World
{
    boolean[][] o = new boolean [12][8]; 
    boolean[][] x = new boolean [12][8];
    int ktoTeraz;
    public MyWorld()
    {    
        super(600, 400, 1);
        ktoTeraz=Greenfoot.getRandomNumber(2);
        JOptionPane.showMessageDialog(null, "Aby grać kółkiem wciskaj 'o' i klikaj, krzyżykiem - 'x' i klikaj." + "\n" + "Gra dla dwóch graczy!");
        if (ktoTeraz==0) JOptionPane.showMessageDialog(null,"Zaczynają O");
        else JOptionPane.showMessageDialog(null,"Zaczynają X");
    }
    
    public boolean sprawdzPiatkeKolek(){
      for (int i= 0; i<12 ; i++){
        for (int j= 0; j<4 ; j++){
          if(o[i][j]&&o[i][j+1]&&o[i][j+2]&&o[i][j+3]&&o[i][j+4]) return true;
        }
      }
      for (int i= 0; i<8 ; i++){
        for (int j= 0; j<8 ; j++){
          if(o[i][j]&&o[i+1][j]&&o[i+2][j]&&o[i+3][j]&&o[i+4][j]) return true;
        }
      }  
      ktoTeraz=1;
      Greenfoot.delay(10);
      JOptionPane.showMessageDialog(null,"Teraz X");
      return false;
    }
    
    public boolean sprawdzPiatkeKrzyzykow(){
      for (int i= 0; i<12 ; i++){
        for (int j= 0; j<4 ; j++){
          if(x[i][j]&&x[i][j+1]&&x[i][j+2]&&x[i][j+3]&&x[i][j+4]) return true;
        }
      }
      for (int i= 0; i<8 ; i++){
        for (int j= 0; j<8 ; j++){
          if(x[i][j]&&x[i+1][j]&&x[i+2][j]&&x[i+3][j]&&x[i+4][j]) return true;
        }
      }  
      ktoTeraz=0;
      Greenfoot.delay(10);
      JOptionPane.showMessageDialog(null,"Teraz O");
      return false;
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            MouseInfo mouse=Greenfoot.getMouseInfo();
            int mX=mouse.getX(), mY=mouse.getY();
            int indexX=(int)Math.floor(mX/50);
            int indexY=(int)Math.floor(mY/50);
            int nrX = 50* indexX + 25;
            int nrY = 50* indexY + 25;
     
                if(Greenfoot.isKeyDown("o")&&ktoTeraz==0)
                {
                    if(o[indexX][indexY]){JOptionPane.showMessageDialog(null, "Tu jest kółko ");}
                    else if(x[indexX][indexY]){JOptionPane.showMessageDialog(null, "Tu jest krzyżyk ");}
                    else{Kolko kolko = new Kolko();
                    addObject(kolko, nrX, nrY);
                    o[indexX][indexY]=true;
                      if(sprawdzPiatkeKolek()){
                       Greenfoot.delay(10);
                       JOptionPane.showMessageDialog(null, "Wygrały O");
                       Greenfoot.stop();
                      }
                    }
                }
                else if(Greenfoot.isKeyDown("x")&&ktoTeraz==1)
                {
                    if(o[indexX][indexY]){JOptionPane.showMessageDialog(null, "Tu jest kółko ");}
                    else if(x[indexX][indexY]){JOptionPane.showMessageDialog(null, "Tu jest krzyżyk ");}
                    else{Krzyzyk krzyzyk = new Krzyzyk();
                    addObject(krzyzyk, nrX, nrY);
                    x[indexX][indexY]=true;
                      if(sprawdzPiatkeKrzyzykow()){
                       Greenfoot.delay(10);
                       JOptionPane.showMessageDialog(null, "Wygrały X");
                       Greenfoot.stop();
                      }
                    }
                 }
        
   
    
        }
    }
 }

