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
        
     void setupBlock()
       {
         minX=1563 + 60*x;
         maxX=minX + 49;
         minY=11 + 60*y;
         maxY=minY + 49;
       }
  }
