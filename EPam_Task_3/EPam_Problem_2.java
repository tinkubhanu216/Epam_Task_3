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

class EPam_Problem_2 {
        static Set<Integer> list = new TreeSet<>();
        static List<Integer> swi_list = new ArrayList<>(12);

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

        Scanner s1 = new Scanner( System.in ); 
        int t = s1.nextInt();
 
        List<Integer> result = new ArrayList<>();
        long k, l, q, m = 0;
        int i;
        long ans = 0;
 
        while ( s1.hasNextLine() ) {
            list.clear();
            swi_list.clear();
            result.clear();
            s1.nextLine();
            String switchString = s1.nextLine();
            k = s1.nextLong();
 
            for(i =0 ; i< switchString.length(); i++){
                if(switchString.charAt( i )-48 == 1) swi_list.add( i+1 );
            }
 
            l=1; q= 1000000000000000L;
 
            while ( l <= q ){
                m = (l+q) >> 1;
                long res=0;
                int j;
                for(i=1; i< (1 << swi_list.size()); i++ ){
                    long pr = 1;
                    int sign = -1 ;
                    for(j =0; j < swi_list.size(); j++ ){
                        if(((i>>j)&1) == 1){
                            pr = pr * swi_list.get( j );
                            sign *= -1;
                        }
                    }
                    res += sign*(m/pr);
                }

                if(res >= k){
                    ans = m;
                    q = m-1;
 
                }
                else  l = m+1;
            }
 
            System.out.println(ans);
 
        }
    }
}
