import javax.swing.*;
boolean cooldown;
File niveaux;

void setup()
  {
    btn = new bouton[56];
    size(1802,892);
    debut();
    setupNiveau();
  }
    
    
void draw()
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

void save()
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
  }
