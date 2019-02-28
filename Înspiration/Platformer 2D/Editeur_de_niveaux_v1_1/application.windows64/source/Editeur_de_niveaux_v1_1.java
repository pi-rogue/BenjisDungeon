import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class Editeur_de_niveaux_v1_1 extends PApplet {


boolean cooldown;
File niveaux;

public void setup()
  {
    btn = new bouton[56];
    debut();
    setupNiveau();
  }


public void draw()
  {
    affiche();
    hover();
    click();
    affichageBlock();
    changeBlock();

    if(!mousePressed){cooldown=true;}
    if (mouseX > 1627 && mouseX < 1731 && mouseY > 849 && mouseY < 885 && mousePressed && mouseButton == LEFT && cooldown==true){save(); cooldown=false;}
    if (mouseX > 1563 && mouseX < 1613 && mouseY > 849 && mouseY < 885 && mousePressed && mouseButton == LEFT && cooldown==true){selectInput("séléctionnez un fichier :","edit",niveaux); cooldown=false;}
  }

public void save()
  {
    String data = JOptionPane.showInputDialog(frame,"Entrez le nom du niveau :", "Sauvegarder",3);
    if (!data.equals("null"))
      {
        String[] transfo = new String[tabBlock.length*tabBlock[0].length];
        int cpt=0;
        for(int i=0; i<tabBlock.length; i++)
           {
             for(int j=0; j<tabBlock[i].length; j++)
                {
                  transfo[cpt] = tabBlock[i][j];
                  cpt++;
                }
           }
        saveStrings(pathFinding(sketchPath(""))+"/niveaux/"+data+".txt", transfo);
        System.out.printf("Niveau sauvegardé avec succès. Le fichier s'apelle '%s'.\n", data);
      }
  }

public void edit(File selection)
  {
    if (selection == null) {println("Error, name not found");}
    else {
            println("Niveau sélectionné : " + selection.getName());
            String[] transfo = loadStrings(selection.getAbsolutePath());
            int cpt=0;
            for(int i=0; i<tabBlock.length; i++)
              {
                for(int j=0; j<tabBlock[i].length; j++)
                  {
                    tabBlock[i][j] = transfo[cpt];
                    cpt++;
                  }
              }
          }
  }
public void affiche()
  {
    background(255);
      line(0,0,1800,0);
      fill(255);
      rect(5,6,1540,880);
      affichageNiveau();//affichage de la grille
      for(int i=1; i<70; i++)
          {
            line(5+22*i,7,6+22*i,886);
          }
      for(int j=1; j<40; j++)
          {
            line(6,6+22*j,1545,5+22*j);
          }
      line(1552,0,1552,892);
//----------------------------------------------------------------------------------------------
      fill(255);    //affichage des boutons
      for(int i=0; i<56; i++)
        {
          rect(btn[i].minX,btn[i].minY,btn[i].maxX-btn[i].minX,btn[i].maxY-btn[i].minY);
        }
//----------------------------------------------------------------------------------------------
        fill(255);
        textSize(20); //affichage du boutton validation
        rect(1627,849,104,36);
        fill(0);
        text("Validation",1630,874);
//----------------------------------------------------------------------------------------------
        fill(255);
        textSize(15); //affichage du boutton editer
        rect(1563,849,50,36);
        fill(0);
        text("Éditer",1568,874);
  }

PImage Bloc[] = new PImage[56];

public void loadimage()
  {
    for(int i=0; i<56; i++)
      {
       Bloc[i]=loadImage("Blocs/Bloc "+str(i)+".png");
      }
  }

public void affichageBlock()
  {
    for(int i=0; i<56; i++)
      {
        for(int Y=0; Y<42; Y++)
          {
            for(int X=0; X<42; X++)
              {
                int pixel=Bloc[i].get(X,Y),blanc=Bloc[1].get(0,0);
                if(pixel != blanc) set(btn[i].minX+4+X,btn[i].minY+4+Y,pixel);
              }
          }
      }
  }

int posX, posY;

public void changeBlock()
  {
    if (mouseX > 6 && mouseX < 1546 && mouseY > 7 && mouseY < 887)
      {
        posX = PApplet.parseInt((mouseX - 6) / 22);
        posY = PApplet.parseInt((mouseY - 7) / 22);
        if(mousePressed && mouseButton == LEFT) {tabBlock[posY][posX] = dataBlock;}
      }
  }
bouton[] btn;
int x, y;
bouton boutonValidation;
boolean blockClicked[] = new boolean[56];
String dataBlock="0";


public void debut()
{
  for(int h=0; h<56; h++)
    {
      btn[h] = new bouton();
    }

  for(int i=0; i<56; i++)
    {
      if(x>3) {x=0; y++;}
      btn[i].setupBlock();
      x++;
    }
  blockClicked[0] = true;
  loadimage();
}

public void hover()
  {
    for(int i=0; i<56; i++)
        {
          btn[i].hover();
        }
  }

public void click()
  {
    for(int i=0; i<56; i++)
        {
          if(btn[i].hover && mousePressed && (mouseButton == LEFT))
            {
              for(int j=0; j<56; j++)
                {
                  blockClicked[j] = false;
                }
              blockClicked[i] = true;
            }
        }
    for(int i=0; i<56; i++)
      {
        if(blockClicked[i]){fill(200); rect(btn[i].minX,btn[i].minY,btn[i].maxX-btn[i].minX,btn[i].maxY-btn[i].minY); dataBlock=tabVal[i];}
      }
  }
class bouton    // ceci et un modèle
  {
      private   //domaine fixe

      boolean hover = false;
      int minX, minY, maxX, maxY;

      public   //domaine libre

      void hover()
        {
          if(minX <= mouseX && mouseX <= maxX && minY <= mouseY && mouseY <= maxY)
            {hover = true; fill(230); rect(minX,minY,maxX-minX,maxY-minY);}
          else {hover = false;}
        }

     public void setupBlock()
       {
         minX=1563 + 60*x;
         maxX=minX + 49;
         minY=11 + 60*y;
         maxY=minY + 49;
       }
  }
PImage texture;
String tabBlock[][] = new String[40][70];
int transparent;
String tabVal[] = new String[56];


public void affichageNiveau()
  {
    for(int i=0;i<40;i++)
        {
          for(int j=0;j<70;j++)
            {
              int[] val= PApplet.parseInt(split(tabBlock[i][j],','));
              int data1=PApplet.parseInt(val[0]);
              int data2=PApplet.parseInt(val[1]);
              int posydata=data1*23+2;
              int posxdata=data2*23+2;
              for(int k=0; k<21; k++)
                  {
                    for(int l=0; l<21; l++)
                      {
                        int pixel=texture.get(posxdata+l,posydata+k);
                        if(pixel != transparent) {set((j*22+l+6),(i*22+k+7),pixel);}
                        else {set((j*22+l+6),(i*22+k+7),color(223, 242, 255));}                              // != -> "différent"
                      }                                                                                  // coordonnées en pixels -> j = nbr de blocs  &  l = nbr de pixels entre 0 et 21
                  }                                                                                      // un bloc fait 21px par 21px
            }
        }
  }

public void setupNiveau()
  {
    niveaux = new File(pathFinding(sketchPath(""))+"/niveaux/");
    texture = loadImage("Blocs/texture.png");
    transparent = texture.get(0,5);
    for(int i=0; i<40; i++)
      {
        for(int j=0; j<70; j++)
          {
            tabBlock[i][j] = "29,29";
          }
      }
     tabVal[0]="29,29";
     tabVal[1]="04,01";
     tabVal[2]="04,02";
     tabVal[3]="04,03";
     tabVal[4]="04,04";
     tabVal[5]="04,05";
     tabVal[6]="04,06";
     tabVal[7]="04,07";
     tabVal[8]="05,01";
     tabVal[9]="05,02";
    tabVal[10]="05,03";
    tabVal[11]="05,04";
    tabVal[12]="05,05";
    tabVal[13]="05,06";
    tabVal[14]="05,07";
    tabVal[15]="00,13";
    tabVal[16]="10,10";
    tabVal[17]="01,12";
    tabVal[18]="00,11";
    tabVal[19]="10,11";
    tabVal[20]="01,10";
    tabVal[21]="03,12";
    tabVal[22]="03,13";
    tabVal[23]="05,17";
    tabVal[24]="05,16";
    tabVal[25]="04,17";
    tabVal[26]="04,16";
    tabVal[27]="19,05";
    tabVal[28]="19,04";
    tabVal[29]="19,03";
    tabVal[30]="10,12";
    tabVal[31]="26,16";
    tabVal[32]="26,14";
    tabVal[33]="27,14";
    tabVal[34]="27,23";
    tabVal[35]="27,24";
    tabVal[36]="26,24";
    tabVal[37]="26,23";
    tabVal[38]="26,25";
    tabVal[39]="26,26";
    tabVal[40]="27,21";
    tabVal[41]="27,20";
    tabVal[42]="27,19";
    tabVal[43]="27,18";
    tabVal[44]="26,19";
    tabVal[45]="26,18";
    tabVal[46]="26,20";
    tabVal[47]="26,22";
    tabVal[48]="25,21";
    tabVal[49]="24,20";
    tabVal[50]="24,19";
    tabVal[51]="25,18";
    tabVal[52]="25,14";
    tabVal[53]="25,20";
    tabVal[54]="24,18";
    tabVal[55]="24,16";
  }

public String pathFinding(String path)           //syntaxe : pathFinding(sketchPath(""))
  {
    String[] Path = split(path,'\\');
    path = Path[0];
    for (int w=1; w<Path.length-2; w++) {path = path + "/" + Path[w];}
    return(path);
  }
  public void settings() {  size(1802,892); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Editeur_de_niveaux_v1_1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
