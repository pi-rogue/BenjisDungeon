  int gauche, droite, posx=10, haut,  posy=814, nbsaut=2, ymax=0, ymin=835, traj, xmin=5, xmax=1444;                                                                                              // limite en pixels
  color marronechelle1, marronechelle2, bleuechelle, pixelmilieu, pixelbas, pixelhaut, pixeldroite, pixelgauche, vert1, vert2, marron1, marron2, marron3, lave1, lave2, lave3, gris1;
  float y=0, x=0, cpt, saut;
  String blocdroite, blocgauche, blocbas, blochaut, blocmilieu;
  boolean tempo;
  
  void gravite()
  {
    if(saut>0) saut=saut-0.20;                                                                    // vitesse a laquelle tombe le perso
    posy=int(posy-saut);                                                                          
    if(blocmilieu == "echelle") {saut=3.5; nbsaut=2;}
    testhaut();
    testbas();
    
   if ((controle[0] == true) && (nbsaut>0) && (tempo == false) && (blocmilieu != "echelle"))             // saut
        {
          nbsaut = nbsaut-1;
          for(int i=0; i<10; i++) {saut=7;}                                                       // taille, hauteur du saut
          tempo = true;
        }
   else if((controle[0] == true) && blocmilieu == "echelle")
        {
          posy=posy-5;
        }
   else if((controle[1] == true) && blocmilieu == "echelle")
        {
          posy=posy+5;
        }        
   if (controle[0] == false)
        {
          tempo =false;
        }        
   if(controle[3] == true)
        {
          for(int i=0; i<3; i++) 
              {
                posx=posx-1;
                if(posx<xmin) {posx=xmin;}
                testPixel();
                if(blocgauche == "bloc" && (blocdroite == "air" || blocdroite == "mort")) {xmin=posx;} else {xmin=5;}                  // déplacements vers la gauche (si solide, bloqué)
                if(blocgauche == "mort") {mort();}
              }
        }
        
    if(controle[2] == true)
        {
          for(int i=0; i<3; i++) 
              {
                posx=posx+1;
                if(posx>xmax) {posx=xmax;}
                testPixel();
                if(blocdroite == "bloc" && (blocgauche == "air" || blocgauche == "mort")) {xmax=posx;} else {xmax=1444;}               // idem vers la droite
                if(blocdroite == "mort") {mort();}
              }
        }
  }
  
void anime()
  {
    cpt=cpt+1.25;
    if(cpt>60) {cpt=0;}
    if(cpt<20) {ellipse(posx,posy,9,11);}
    else if(cpt<40) {ellipse(posx,posy,10,10);}
    else {ellipse(posx,posy,11,9);}
  }
    
void testbas()
    {
      for(int i=0; i<7; i++)
          {
            posy=posy+1;
            if(posy>ymin) {posy=ymin; nbsaut=2;}                                                // nbsaut = nombre de sauts possibles en l'air
            testPixel();
            if(blocbas == "bloc") {ymin=posy;} else {ymin=835;}
            if(blocbas == "mort") {mort();}
          }
    }

void testhaut()
    {
      traj = int(saut);
      while(traj>0)
          {
            posy=posy-1;
            if(posy<ymax) {posy=ymax; traj=0; saut=saut-1;}
            testPixel();
            if(blochaut == "bloc") {ymax=posy;} else {ymax=0;}
            if(blochaut == "mort") {mort();}
            traj=traj-1;
          }
    }
    
void testPixel()
    {
      pixeldroite = get(posx+6,posy);
      pixelgauche = get(posx-6,posy);
      pixelbas = get(posx,posy+6);
      pixelhaut = get(posx,posy+1);
      pixelmilieu = get(posx,posy);
      if(pixeldroite == vert1 || pixeldroite == vert2 || pixeldroite == marron1 || pixeldroite == marron2 || pixeldroite == marron3) {blocdroite="bloc";} else if(pixeldroite == lave1 || pixeldroite == lave2 || pixeldroite == lave3 || pixeldroite == gris1) {blocdroite="mort";} else {blocdroite="air";}
      if(pixelgauche == vert1 || pixelgauche == vert2 || pixelgauche == marron1 || pixelgauche == marron2 || pixelgauche == marron3) {blocgauche="bloc";} else if(pixelgauche == lave1 || pixelgauche == lave2 || pixelgauche == lave3 || pixelgauche == gris1) {blocgauche="mort";} else {blocgauche="air";}
      if(pixelbas == vert1 || pixelbas == vert2 || pixelbas == marron1 || pixelbas == marron2 || pixelbas == marron3) {blocbas="bloc";}                   else if(pixelbas == lave1 || pixelbas == lave2 || pixelbas == lave3 || pixelbas == gris1) {blocbas="mort";}                else {blocbas="air";}
      if(pixelhaut == vert1 || pixelhaut == vert2 || pixelhaut == marron1 || pixelhaut == marron2 || pixelhaut == marron3) {blochaut="bloc";}             else if(pixelhaut == lave1 || pixelhaut == lave2 || pixelhaut == lave3 || pixelhaut == gris1) {blochaut="mort";}           else {blochaut="air";}
      if(pixelmilieu == marronechelle1 || pixelmilieu == marronechelle2 || pixelmilieu == bleuechelle) {blocmilieu="echelle";} else {blocmilieu="inutile";}
    }
    
void mort()
    {
      background(255,10,15);

         posx=10;
         posy=810;
         controle[0]=false;
         controle[1]=false;
         controle[2]=false;
         controle[3]=false;
         ymin=872;
         xmax=872;
    }
