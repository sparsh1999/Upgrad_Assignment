import java.io.*;
import java.util.*;
public class Main{

     public static void main(String []args){
	 
        // the below class uses a buffered Reader to read input which is faster than 
        // scanner due to use of buffer.
		
        FastReader r = new FastReader();
        
        // total no of events {Assumed that total no of events are in a range of integer}
        int n = r.nextInt();
        
        // PriorityQueue to store the students by specific order
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // stringbuilder to append the result . To provide faster output in one System.out command
        StringBuilder s = new StringBuilder();
        
        // iterate through all the events
        while (n-->0)
        {
            // check what type of event is this
            String str = r.next();
            
            if (str.equals("ENTER"))
            {
                pq.add(new Node(r.next(),r.nextDouble(),r.nextInt()));
            }
            else
            {
                pq.poll();
            }
        }
        
        // if queue is empty then all students are served so print empty and exit 
        if (pq.size()==0)
        {
            System.out.println("EMPTY");
            System.exit(1);
        }
        // if queue is not empty then print all the student in order.
        while (pq.size()>0){
            Node node = pq.poll();
            s.append(node.name+"\n");
        }
        // print the final result on the screen
        System.out.println(s);
     }
     
     // Comparable class node to store all the details of an student
     static class Node implements Comparable<Node>{
        public String name ;
        public double  CGPA;
        public int token ;
        
        public Node(String name ,double CGPA,int token){
            this.name = name ;
            this.CGPA = CGPA;
            this.token = token;
        }
        
        @Override
        public int compareTo(Node other)
        {
            int temp = (-1)*Double.valueOf(this.CGPA).compareTo(other.CGPA);
            
            // if both cgpa are different then return compare result
            if (temp!=0)
            return temp;
            // if both cgpa are same then sort according to other conditions
            else 
            {
                // check if the two name are different in character or length
                int res = String.CASE_INSENSITIVE_ORDER.compare(this.name,other.name);
                
                // if both are same then do a comare with case sensitive order
                if (res == 0) {
                res = this.name.compareTo(other.name);
                
                // if both name are case sensitivily similar then check for lower token value
                if (res==0)
                {
                    return Integer.valueOf(this.token).compareTo(other.token);
                }
                 
                }
                return res;
            }
        }
     }
    static class FastReader
        {
            BufferedReader br;
            StringTokenizer st;
 
            public FastReader()
            {
                br = new BufferedReader(new
                        InputStreamReader(System.in));
            }
 
            String next()
            {
                while (st == null || !st.hasMoreElements())
                {
                    try
                    {
                        st = new StringTokenizer(br.readLine());
                    }
                    catch (IOException  e)
                    {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }
 
            int nextInt()
            {
                return Integer.parseInt(next());
            }
 
            long nextLong()
            {
                return Long.parseLong(next());
            }
 
            double nextDouble()
            {
                return Double.parseDouble(next());
            }
 
            String nextLine()
            {
                String str = "";
                try
                {
                    str = br.readLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                return str;
            }
        }
}