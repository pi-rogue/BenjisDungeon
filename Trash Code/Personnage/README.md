Importation dans Eclipse :
	File > Import... > Gradle > Existing Gradle Project


	Bon, alors pour faire simple le principe de LibGDX c'est d'avoir un unique code qui marche sur toutes les plateformes (même android btw). Ce code là est dans le dossier 'core'.

	Les autres dossiers ('desktop', 'android', 'html', 'ios') contiennent le code qui est spécifique à la plateforme, basiquement c'est juste le main qui va créer l'objet qui va contenir l'application, faire la config etc. DU COUP c'est ces projets qui doivent être run pour pouvoir tester (dans notre cas on garde que desktop mais c'est bon à savoir, si on veut en faire une app ce sera déjà fait).

	Pour la map j'ai utilisé un logiciel qui fait des maps en .tmx qui sont assez bien gérées par libGDX (https://www.mapeditor.org/)

Pour le code je conseille de lire dans cet ordre :
- Constants.java
- DesktopLauncher.java
- PiRogue.java
- GameScreen.java
- map.tmx (en bonus)

______________
Pour le lancer

* Run > Run Configurations
* Clic droit sur Java Application, New Configuration
	Name : DesktopLauncher
	Project : pirogue-desktop
	Main class : com.pirogue.game.desktop.DesktopLauncher
* RUN
___________________________________________________
Je vous conseille de changer les réglages d'eclipse

* Window > Preferences > Run/Debug > Launching
* Tout en bas dans Launch Operations, cocher "Always launch the previously launched application".
Comme ça pour démarrer le projet vous aurez plus qu'à faire : CTRL + F11
_____________________________________________
Si vous avez un problème pour load les images

* Dans pirogue-core, clic droit sur le dossier 'assets', Build Path, Use as source folder.
* A chaque fois que vous ajoutez ou enlevez une image dans le dossier assets, il faut faire clic
  droit n'importe où dans le panneau de gauche et Refresh.