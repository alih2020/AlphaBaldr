

    public Hamza() {
    }

    /**
     * @param args the command line arguments
     * @hidden Java Doc
     * this class is just a random text in order to generate JavaDoc of this 
     * classe named hamza
     */
    public static void main(String[] args) {
        System.out.println("Ant generates Java Doc");           // Ant generates Java Doc
        System.out.println(" ");
      String a = "Hamza";
      String b = "Priya";
      
        System.out.println(a.equals(b)); // Is Hamza Priya or Priya Hamza as person ==    //false
          System.out.println(" ");      // saut de ligne
          String c = a.substring(4);    // élément 4 de Hamza = a vaut il élément 4 de Priya qui est a     ==    //true
          String d = b.substring(4);
          System.out.println(c.equals(d));
          System.out.println(" ");                // saut de ligne
          String e = a.substring(3);              // e;ement 3 de hamza = z
          String f = b.substring(3);              // element 3 de priya = y
          System.out.println(e.equals(f));        // does x = y and y = x           // false
          System.out.println(" ");
    }
    
}
