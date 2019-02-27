bouton[] btn;
int x, y;
bouton boutonValidation;
boolean blockClicked[] = new boolean[56];
String dataBlock="0";


void debut()
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

void hover()
  {
    for(int i=0; i<56; i++)
        {
          btn[i].hover();
        }
  }
  
void click()
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
