String pathFinding(String path)           //syntaxe : pathFinding(sketchPath(""))
  {
    String[] Path = split(path,'\\');
    path = Path[0];
    for (int w=1; w<Path.length-2; w++) {path = path + "/" + Path[w];}
    return(path);
  }
