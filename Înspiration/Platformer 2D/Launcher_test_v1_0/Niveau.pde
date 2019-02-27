PImage texture;
color transparent;
String bloc, niveau = "1";
String tabBlock[][] = new String[40][70];
import javax.swing.*;
  
void edit(File selection)
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
    controle[5]=false;
  }

void affiche()
    {
      for(int i=0;i<40;i++)
        {
          for(int j=0;j<70;j++)
            {
              if(niveau == "1") {bloc=tabBlock[i][j];}
              int[] val= int(split(bloc,','));
              int data1=int(val[0]); 
              int data2=int(val[1]);
              int posydata=data1*23+2;
              int posxdata=data2*23+2;
              for(int k=0; k<21; k++)
                  {
                    for(int l=0; l<21; l++)
                      {
                        color pixel=texture.get(posxdata+l,posydata+k);
                        if(pixel != transparent){set((j*21+l),(i*21+k),pixel);}                          // != -> "différent"
                      }                                                                                  // coordonnées en pixels -> j = nbr de blocs  &  l = nbr de pixels entre 0 et 21
                  }                                                                                      // un bloc fait 21px par 21px
            }       
        }
    }
