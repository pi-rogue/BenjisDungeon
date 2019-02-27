PImage texture;
String tabBlock[][] = new String[40][70];
color transparent;
String tabVal[] = new String[56];


void affichageNiveau()
  {
    for(int i=0;i<40;i++)
        {
          for(int j=0;j<70;j++)
            {
              int[] val= int(split(tabBlock[i][j],','));
              int data1=int(val[0]); 
              int data2=int(val[1]);
              int posydata=data1*23+2;
              int posxdata=data2*23+2;
              for(int k=0; k<21; k++)
                  {
                    for(int l=0; l<21; l++)
                      {
                        color pixel=texture.get(posxdata+l,posydata+k);
                        if(pixel != transparent) {set((j*22+l+6),(i*22+k+7),pixel);}
                        else {set((j*22+l+6),(i*22+k+7),color(223, 242, 255));}                              // != -> "différent"
                      }                                                                                  // coordonnées en pixels -> j = nbr de blocs  &  l = nbr de pixels entre 0 et 21
                  }                                                                                      // un bloc fait 21px par 21px
            }       
        }
  }
  
void setupNiveau()
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
  
