package ana1;
import java.util.Scanner;
public class bptmain extends BTreedemo{
    @SuppressWarnings({ "resource", "unchecked" })
	public static  void main (String [] args)  {
     BPlusTree<Integer, String> b=bpgen();
		while(true)
		{  System.out.println("............BTREE...........");
		   System.out.println("ENTER YOUR CHOICE");
		   System.out.println("1.BPLUSTREE GENERATION");
		   System.out.println("2.DISPLAY");
		   System.out.println("3.SEARCH IN BPLUSTREE");
           System.out.println("4.INSERT IN BPLUSTREE");
           System.out.println("5.EXIT");
		   Scanner s = new Scanner(System.in); 
		   int n=s.nextInt();
		   switch(n)
		   {
		   case 1:long st=System.nanoTime();
		               bpgen();
                       long stp=System.nanoTime();
                       long tot=stp-st;
                       tot=tot/100000;
                       System.out.println("THE TIME TAKEN FOR GENERATION OF B PLUS TREE IS "+tot+" nano seconds.");
		               break;
		   case 2:System.out.println(b);
		          break; 
		   case 3:System.out.println("ENTER THE ID TO BE SEARCHED");
		          String var=s.next();
		          long st1=System.nanoTime();
		          search(var,b);    
		      	  long stp1=System.nanoTime();
                  long tot1=stp1-st1;
                  tot1=tot1/100000;
                  System.out.println("THE TIME TAKEN TO SEARCH A RECORD IN B PLUS TREE "+tot1+" mili seconds.");	 
                  break;
		 case 4:System.out.println("ENTER THE DATA TO BE INSERTED\n");
		        System.out.println("ENTER BOOK ID:\n");
		        String Book_id=s.next();
			    System.out.println("ENTER BOOK NAME:\n");
			    String Book_Title=s.next();
			    System.out.println("ENTER AUTHOR NAME:\n");
			    String Author =s.next();
			    System.out.println("ENTER PUBLISHER NAME:\n");
			    String Publisher =s.next();
			    String vt=Book_id +","+ Book_Title +","+ Author +","+ Publisher;
		        long st2=System.nanoTime();  
                insert(vt.toString(),b);
                long stp2=System.nanoTime();
                long tot2=stp2-st2;
                tot2=tot2/100000;
                System.out.println("THE TIME TAKEN TO INSERT A NEW RECORD IS "+tot2+" mili seconds.");
			    break;
		   case 5:System.exit(0);
          default:System.out.println("ENTER A VALID OPTION");
		   }
		   }
        }
}
