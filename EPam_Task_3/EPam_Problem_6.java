/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.util.*;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class EPam_Problem_6 {
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
        int n=s.nextInt();
        int k=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=s.nextInt();
        ArrayList<Integer> arr[]=new ArrayList[k];
        for(int i=0;i<k;i++)
            arr[i]=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            int weight=a[i]%k;
            arr[weight].add(a[i]);
        }
        for(int j=k-1;j>=0;j--)
        {
            Collections.sort(arr[j]);
            for(int i=0;i<=arr[j].size()-1;i++)
            {
                System.out.print(arr[j].get(i)+" ");
            }
        }
    }
}

