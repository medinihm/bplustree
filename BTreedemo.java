package ana1;
import java.util.HashMap;
import java.io.*;
public  class BTreedemo extends BPlusTree{
     BPlusTree<Integer, String> bpt = new BPlusTree<Integer, String>(3);
	static int i=1;
    static HashMap<Integer, String> mat = new HashMap<>();
    public static BPlusTree bpgen()
     {
        String fileName = "Book.csv";
        String fn ="n.txt";
        BPlusTree<Integer, String> bpt = new BPlusTree<Integer, String>(10);
        String line = null;
       try {
            FileReader fileReader = new FileReader(fileName);
            FileWriter fileWriter = new FileWriter(fn);
            PrintWriter pw =new PrintWriter(fn);
            BufferedReader bufferedReader = new BufferedReader(fileReader); 
             while((line = bufferedReader.readLine()) != null) {
                //StringBuffer sb = new StringBuffer(line);
               // String sg = sb.toString();
                 String[] af=line.split(",+");
                 bpt.insert(i, line);
                //System.out.println(line.length()+line+line.hashCode());
                mat.put(i,line);
                i++;
                 } 		 
             pw.close();
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex);                
        }
        catch(IOException ex) {
            System.out.println(ex);                  
            
        }
         return bpt;   
}
    public static boolean search(String a,BPlusTree<Integer, String> f)
    {
        int k=Integer.parseInt(a);
        BPlusTree<Integer, String> pt = new BPlusTree<Integer, String>(10);
      String s="o";
      if(f.search(k)!=null)
      {
              s= f.search(k);
               String []sd= s.split(",+");
                   System.out.println("BOOK ID:"+sd[0]);
		 System.out.println("NAME:"+sd[1]);
		 System.out.println("AUTHOR:"+sd[2]);
		 System.out.println("PUBLISHER:"+sd[3]);
                 return true;
      }
      else
      {
          System.out.println("SEARCHED RECORD NOT FOUND");    
    	  return false;
              
              }
}
    public static void insert(String o,BPlusTree<Integer, String> f)
    {
        BPlusTree<Integer, String> pt = new BPlusTree<Integer, String>(10);
        String []sd= o.split(",+");
        boolean er=search(sd[0],f); 
      if(er==true)
      {
          System.out.println("value already present in tree");
      }
      else
      {
          f.insert(i+1, o);
          String filename="Book.csv";
            try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true));
           PrintWriter pw =new PrintWriter(bw);
           pw.println(o);
           bw.close();
            }
            catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  filename + "'");    
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + filename + "'");                  
            
    }
}  
    }
}

