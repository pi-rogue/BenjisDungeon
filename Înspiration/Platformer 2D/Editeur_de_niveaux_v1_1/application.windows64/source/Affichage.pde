void affiche()
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

void loadimage()
  {
    for(int i=0; i<56; i++)
      {
       Bloc[i]=loadImage("Blocs/Bloc "+str(i)+".png");
      }
  }

void affichageBlock()
  {
    for(int i=0; i<56; i++)
      {
        for(int Y=0; Y<42; Y++)
          {
            for(int X=0; X<42; X++)
              {
                color pixel=Bloc[i].get(X,Y),blanc=Bloc[1].get(0,0);
                if(pixel != blanc) set(btn[i].minX+4+X,btn[i].minY+4+Y,pixel);
              }
          }
      }
  }
  
int posX, posY;

void changeBlock()
  {
    if (mouseX > 6 && mouseX < 1546 && mouseY > 7 && mouseY < 887)
      {
        posX = int((mouseX - 6) / 22);
        posY = int((mouseY - 7) / 22);
        if(mousePressed && mouseButton == LEFT) {tabBlock[posY][posX] = dataBlock;}
      }
  }
