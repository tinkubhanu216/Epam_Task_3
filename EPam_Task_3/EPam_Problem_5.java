/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.io.*;
import java.util.*;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class EPam_Problem_5 {
    static int[] d;
	static int power(int a, int b, int m)
	{
		if (b == 0)
			return 1;
		int p = power(a,b/2,m);
		p = (int) ((long) p * p % m);
		if (b % 2 == 1)
			p = (int) ((long) p * a % m);
		return p;
	}
	
	static int find(int i) 
	{
		return d[i] < 0 ? i : (d[i] = find(d[i]));
	}
	
	static boolean join(int i, int j)
	{
		i = find(i);
		j = find(j);
		if (i == j)
			return false;
		if (d[i] > d[j])
			d[i] = j;
		else {
			if (d[i] == d[j])
				d[i]--;
			d[j] = i;
		}
		return true;
	}
	static int solve_(int k, int v, int n, int a, int m)
	{
		Arrays.fill(d, -1);
		int bcnt = 0, cnt = n;
		for (int i = 1; i < n; i++)
			if ((v & 1 << i) > 0) {
				for (int j = i; j < i + k; j++)
					if (join(j, j - i))
						cnt--;
				bcnt++;
			}
		int sum = power(a, cnt, m);
		return bcnt % 2 == 1 ? sum : (m - sum) % m;
	}

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
        Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int m = sc.nextInt();
		
		d = new int[n];
		
		int sum = 0;
		
		for (int k = 1; k < n; k++)
		{
		    for (int v = 2; v < 1 << n - k + 1; v += 2)
		    {
		        sum = (sum + solve_(k, v, n, a, m)) % m;
		    }
		}
		System.out.println(sum);
    }
}

