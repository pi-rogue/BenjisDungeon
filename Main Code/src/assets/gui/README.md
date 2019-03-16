L'idée c'est d'avoir tout l'inventaire dessiné sur une image, et d'utiliser une autre 
image pour charger l'emplacement des cases. Les deux images peuvent faire la taille que l'on veut, sachant que l'écran fait du 1366x768, mais doivent avoir la même taille.

Sur la première image on peut dessiner ce qu'on veut, et sur la deuxième image il n'y a donc que des carrés (dont la taille doit être spécifiée dans Constants.cellSize) sur fond
blanc. La couleur des carrés définit le type de case (en respectant le code RGB).
Les couleurs peuvent aussi être modifiées dans les constantes.

. Rouge (255,0,0)     - Casque
. Vert (0,255,0)      - Armure
. Bleu (0,0,255)      - Pantalon
. Jaune (255,255,0)   - Bottes
. Cyan (0,255,255)    - Main gauche
. Magenta (255,0,255) - Main droite
. Gris (128,128,128)  - Cases d'inventaire

Les rectangles d'autres couleurs ne sont pas interprétées, plus tard on pourra rajouter :
. Gris clair (216,216,216) - Personnage (il faudra que ce soit un carré par contre, pas comme sur mon exemple)

Ce qu'on peut faire aussi c'est ajouter dans une image à part l'image à afficher quand
on passe la souris sur une case (un sorte de voile blanc transparent pour qu'on voie
quand c'est sélectionné > selected.png).