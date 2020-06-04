package com.nsu.spring2020.ID1711661;

import java.io.File; 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap; 

public class SP2020_CSE373_Final_Q2_1711661 {
	
	public static void main(String[] args) throws Exception 
	 { 
		File file = new File("C:\\Program Files\\Git\\1711661_SP2020_CSE373_Final\\Final\\Question 02\\FinalQ1Input.txt"); 
	    Scanner sc = new Scanner(file); 
	  
	    while (sc.hasNextLine()) 
	    System.out.println(sc.nextLine()); 
	  
		new SP2020_CSE373_Final_Q2_1711661();
	  
	 } 
	
	int N; 
	boolean[][] G;
	
	TreeMap<String,Integer> people;
	ArrayList<String> namelist;
	
	SP2020_CSE373_Final_Q2_1711661() throws Exception
	{
		setupgraph();
				
		System.out.println("------------------------------");
		System.out.println();
		
		DFS();
		
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
	}	

void setupgraph() throws Exception {
	File file = new File("C:\\Program Files\\Git\\1711661_SP2020_CSE373_Final\\Final\\Question 02\\FinalQ1Input.txt"); 
    Scanner fin = new Scanner(file); 
    
    //int numv  = fin.nextInt();
    int numEdges = fin.nextInt();
	N = numEdges+1;
	
	G=new boolean[N][N];
	System.out.print(" " +numEdges);
	System.out.print(N);
	System.out.print("\n");
	namelist = new ArrayList<String>();
	people = new TreeMap<String,Integer>();
	
	for (int i=0; i<numEdges; i++) 
	{
		String student1 = fin.next();
		String student2 = fin.next();
		
		String dummy = fin.next();
		// Get the index of the parent in our graph.
		Integer index1;
		if (people.containsKey(student1))
			index1 = (Integer)people.get(student1);
		
		else 
		{
			index1 = people.size();
			namelist.add(student1);
			System.out.println("Added "+student1+" as "+index1);
			people.put(student1, index1);
		}			
		
		Integer index2;
		if (people.containsKey(student2))
			index2 = (Integer)people.get(student2);
		
		else 
		{	
			index2 = people.size();
			namelist.add(student2);
			System.out.println("Added "+student2+" as "+index2);
			people.put(student2, index2);
		}								
		G[index1][index2] = true;
		G[index2][index1] = true;
	}  
}

void DFS()
{
	boolean[] V=new boolean[N]; 
	int numComponets=0; // the number of components in the graph
	for (int i=0; i<N; ++i)
		if (!V[i])
		{
			++numComponets;
			System.out.printf("Starting a DFS for  %d and starting at node %s%n",numComponets,namelist.get(i));
			DFS(i,V);
		}
	System.out.println();
	System.out.printf("DFS - found %d components.%n", numComponets);
}

void DFS(int at, boolean[] V)
{
	System.out.printf("Node %s in the DFS%n",namelist.get(at));
	
	V[at]=true;
	for (int i=0; i<N; ++i)
		if (G[at][i] && !V[i])
		{
			System.out.printf("node %s:",namelist.get(i));
			DFS(i,V);
		}
	System.out.printf("done node: %s%n", namelist.get(at));
	}
}