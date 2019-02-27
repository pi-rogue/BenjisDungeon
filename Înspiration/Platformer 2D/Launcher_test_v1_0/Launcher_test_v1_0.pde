boolean cooldown, win;
File niveaux;

void setup()
    {
      size(1470,840);                                          // taille du tableau (69x21px,40x21px) -> 1 bloc (21px,21px)
      background(223, 242, 255);                               // couleur du fond (bleu clair)
      texture = loadImage("texture.png");
      niveaux = new File(pathFinding(sketchPath(""))+"/niveaux/");
      for(int w=0;w<40;w++)
        {
          for(int v=0;v<70;v++)
            {
              tabBlock[w][v]="29,29";
            }
        }
      selectInput("séléctionnez un fichier :","edit",niveaux); cooldown = false;
      testCouleur();
      affiche();
    }

void draw()
    {
      if(win == false)
          {
            background(223, 242, 255);                         // couleur du fond (bleu clair)
            affiche();
            gravite();
            anime();
            if (controle[5] && cooldown == true) {selectInput("séléctionnez un fichier :","edit",niveaux); cooldown = false;}
            if((posy>588 && posy<630) && (posx>1428 && posx<1449)) {win=true;}
            if(!keyPressed) {cooldown = true;}
          }
      else if(win == true)
          {
            background(0);
            fill(255);
            text("YOU WON !!!",700,420);
            if (controle[4]==true)
                {
                  mort();
                  win=false;
                }
          }
    }

void testCouleur()
    {
      transparent = texture.get(0,5);                          // variable "transparent" prend la valeur du pixel qui a pour coordonnées (287,20) dans le tabl texture
      vert1 = texture.get(35,94);                              // idem
      vert2 = texture.get(35,95);
      marron1 = texture.get(35,100);
      marron2 = texture.get(35,103);
      marron3 = texture.get(35,107);                           // les coordonnées se font par pixel (pas comme pour celles du niveau -> par bloc)
      lave1 = texture.get(282,14);
      lave2 = texture.get(282,17);
      lave3 = texture.get(287,20);
      gris1 = texture.get(235,66);
      bleuechelle = texture.get(289,83);
      marronechelle1 = texture.get(289,79);
      marronechelle2 = texture.get(282,78);
    }
