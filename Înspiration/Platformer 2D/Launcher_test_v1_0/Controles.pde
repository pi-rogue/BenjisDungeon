boolean controle[]=new boolean[6];


void keyPressed()
{
    if (keyCode == UP)
    {
      controle[0]=true;  //haut                              // controle[0] correspond à la flèche du haut sur le clavier
    }
    if (keyCode == DOWN)
    {
      controle[1]=true;  //bas                               // controle[1] -> bas
    }
    if (keyCode == RIGHT)
    {
      controle[2]=true;  //droite
    }
    if (keyCode ==  LEFT)
    {
      controle[3]=true;  //gauche
    }
    if (keyCode == ENTER)
    {
     controle[4]=true; 
    }
    if (keyCode == TAB)
    {
     controle[5]=true; 
    }
}


void keyReleased()
{
    if (keyCode == UP)                                   // le perso est en mouvement quand ces valeurs sont à 1, et arrêté quand elles sont à 0
    {
      controle[0]=false;
    }
    if (keyCode == DOWN)
    {
      controle[1]=false;
    }
    if (keyCode == RIGHT)
    {
      controle[2]=false;
    }
    if (keyCode ==  LEFT)
    {
      controle[3]=false;
    }
    if (keyCode == ENTER)
    {
      controle[4]=false;
    }
    if (keyCode == TAB)
    {
      controle[5]=false;
    }
}
