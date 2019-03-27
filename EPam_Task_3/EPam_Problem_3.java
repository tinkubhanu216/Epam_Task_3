/* IMPORTANT: Multiple classes and nested static classes are supported */
import java.util.*;
/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class EPam_Problem_3 {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        long S=s.nextLong();
        long E=s.nextLong();
        long[] x=new long[N];
        long[] p=new long[N];
        int[] c=new int[N];
        for(int i=0;i<N;i++){
            x[i]=s.nextLong();
            p[i]=s.nextLong();
            c[i]=0;
        }
        long m=S;
        long dist=0;
        while(m<=E){
            long min=E;
            int index=0;
            for(int i=0;i<N;i++){
                if((x[i]-p[i])<min && c[i]==0){
                    min=x[i]-p[i];
                    index=i;
                }
            }
            if(m<(x[index]-p[index])){
                dist=dist+x[index]-p[index]-m;
            }
	    if(m<(x[index]+p[index])){
	            m=x[index]+p[index];
	    }
            c[index]=1;
        }
        System.out.println(dist);
    }
}
