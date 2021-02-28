import java.io.*;
import java.util.*;
class A {
  String name;
  int price;

  public A(String n, int p) {
    this.name = n;
    this.price = p;
  }

  public String toString() { 
      return this.name + ": " + this.price;
  }
}

public class Main2 {
  public static void main(String[] args) throws Exception {
    File file=new File("C:\\Users\\katti.DESKTOP-JKFICR7\\OneDrive\\Desktop\\qp\\input.txt");       
    Scanner sc=new Scanner(file);
    int ne = Integer.parseInt(sc.nextLine().split(": ")[1]);
    sc.nextLine(); sc.nextLine(); sc.nextLine();

    ArrayList<A> git = new ArrayList<A>();

    while(sc.hasNextLine())  
    {
      String current[] = sc.nextLine().split(": ");
      git.add(new A(current[0], Integer.parseInt(current[1])));
    }
    sc.close();

    Collections.sort(git, new Comparator<A>(){
      public int compare(A a, A b) { 
        return a.price - b.price; 
      } 
    });

    int mindi = git.get(git.size()-1).price;
    int min_index = 0;
    for(int i=0;i<git.size()-ne+1;i++) {
      int diff = git.get(ne+i-1).price-git.get(i).price;

      if(diff<=mindi) {
        mindi = diff;
        min_index = i;
      }
    }
    
    

    FileWriter fw = new FileWriter("C:\\Users\\katti.DESKTOP-JKFICR7\\OneDrive\\Desktop\\qp\\output.txt");
    fw.write("Here the goodies that are selected for distribution are:\n\n");
    for(int i=min_index;i<min_index + ne; i++) {
      fw.write(git.get(i).toString() + "\n");
    }

    fw.write("\nAnd the difference between the chosen goodie with highest price and the lowest price is " + mindi);
	  fw.close();
  }
}