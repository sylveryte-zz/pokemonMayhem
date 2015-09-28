import javax.swing.*;
import java.io.*;
import java.util.*;

/*Pokemon(name,movement,attack,defence,id);
 *setMaster(masterNAme);
 *displayInfo();
 */

 
class Engine extends Thread
{
   final public static int xMAX=10;
   final public static int yMAX=10;
   static Scanner sc=new Scanner(System.in);	
   static Pokemon[] pokemon=new Pokemon[11];
	 
   
    
   static char[][] battleBoard = new char[xMAX][yMAX]; 
   static boolean[][] booleanBattleBoard = new boolean[xMAX][yMAX];
   
  

   
   static void printXys()
   {
     for(int i=0;i<pokemon[0].getCount();i++)
	  { if(pokemon[i].getAlive())
	     System.out.println(pokemon[i].getName()+"x=" +pokemon[i].getxPos()+"y="+pokemon[i].getyPos());
     
   }}
   
   static void buildBattleBoard()
   {//building battleBoard
    
     for(char[] g : battleBoard)
	 Arrays.fill(g,'.');
	  for(boolean[] g : booleanBattleBoard)
	 Arrays.fill(g,false);
	  
	 
	  
	 for(int i=0;i<pokemon[0].getCount();i++)
	  { if(pokemon[i].getAlive())
	    {
         // System.out.print("  i="+i+pokemon[i].getName()+"\nPos="+pokemon[i].getxPos() +" "+ pokemon[i].getyPos());
		  battleBoard[pokemon[i].getxPos()][pokemon[i].getyPos()]=pokemon[i].getFirstInitial();
	     booleanBattleBoard[pokemon[i].getxPos()][pokemon[i].getyPos()]=true;
	    }
      }
	 
   }
    
   /*static void drawBattleBoardManual()
   {//drawing battleBoard
   
    
	for(int i=0;i<21;i++)
	   System.out.print("-");
        		 System.out.println();
	   
	for(int i=0;i<xMAX;i++)
	   {for(int j=0;j<yMAX;j++)
	      System.out.print("|"+battleBoard[i][j]);
		 System.out.print("|");
		 System.out.println();
		} 
     for(int i=0;i<21;i++)
	   System.out.print("-");
      System.out.println();
	 
		 }
	*/	  
   
   
   static void help()
   {
      
	  System.out.println("Choice :\nh = for this message");
	  System.out.println("s = score board");
	  System.out.println("u = Rapid Attack(Health restored + 10 health BONUS");
	  System.out.println("y = continue battle");
	  System.out.println("p = to set no of moves/iteration per execution(default is 5)");
      
   }
   
   static void drawBattleBoard(Thread thr)
   {//drawing battleBoard
   
    
	for(int i=0;i<21;i++)
	   System.out.print("-");
        		 System.out.println();
	   
	 for(char[] c : battleBoard)
	   {for(char m : c)
	     System.out.print("|"+m);
		 System.out.print("|");
		 System.out.println();
		 }
     for(int i=0;i<21;i++)
	   System.out.print("-");
      System.out.println();
	 try
	 {
			thr.sleep(500);
	 }
	 catch(InterruptedException e)
	 {
		 System.out.println("wo thread ka "+e);
	 }
	 
		 }
		  
		  
   static void getPlayers()
   {//pokemon data & getting players
	 int nplayer,k;

     
	  //players & selection of pokemon 
	 do{
	 System.out.print("Enter number of players[max10] (atleast 5 recommended)	 : ");
	 nplayer=sc.nextInt();
	 if(nplayer>10||nplayer<1)
	    System.out.println("MAX 10 :|     y u do this?? ");
	 }while(nplayer>10||nplayer<1);
	 for(;nplayer!=0;)
	 {
	    System.out.println("\nSelect Your Pokemon!!");
		System.out.println("ID\tPOKEMON\t\tATTACK\tDEFENCE");
		for(int j=0;j<10;j++)
		   if(!pokemon[j].getTaken())
		     System.out.println(((pokemon[j].getId())+1)+"\t"+pokemon[j].getName()+"\t"+pokemon[j].getAttack()+"\t"+pokemon[j].getDefence());
	    
	    System.out.print("Choose : ");
	    k=sc.nextInt();
		
		if(k>10||k<0)
		 System.out.println(":|    #kahihi Amoyla bulau kya!!!");
		 else if(!pokemon[k-1].getTaken())
		   {System.out.print("Enter Your Name : ");
		    pokemon[k-1].setMaster(sc.next());
			 nplayer--;
			 }
			 else
			   System.out.println(pokemon[k-1].getMasterName()+" took "+pokemon[k-1].getName()+" already!!\nTry Again!!");
	}
	
	
	}
	
static class Enc implements Runnable 
{
	public void run()
	{
		str.append("Health 		Name		Master \n");
		//StringBuffer str=new StringBuffer()
	//this.masterName+"\t"+this.name+"\t"+this.health+"\t"+this.firstInitial);
	for(int i=0;i<10;i++)
	{ 
	  //if(pokemon[i].getTaken())
	  {
		//  str.append("||");
	  
	//    str.append(pokemon[i].displayInfo());
     }
     str.append(pokemon[0].getHealth());
	 str.append("||");
	 String str1=" "+str;
	 b.setText(str1);
	 try
	 {
		 Thread.sleep(1000);
	 }
	 catch(InterruptedException e){}
	System.out.println("hello\n\n\n\n\n\n");
	}}
	StringBuffer str=new StringBuffer(" ");
	JFrame f=new JFrame();
	JLabel b=new JLabel();
	
	 void displayInfo()
	{//displayInfo
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.getContentPane().add(b);
			f.setSize(400,400);
			f.setVisible(true);	
			b.setText("hello");
	}
}
	static void move()
	 {//moving pokemon
	    for(int i=0;i<pokemon[0].getCount();i++)
	      { if(pokemon[i].getAlive())
	       moveMethod(i);
		   }
		 }
	
	static void moveMethod(int id)
	{//moving pokemon method only
	
	    int xi=pokemon[id].getxPos();
		int yi=pokemon[id].getyPos();
		booleanBattleBoard[xi][yi]=false;
		int k=0;
		int x=xi,y=yi;
		
		//System.out.println(x+"alpha " +y+pokemon[id].getFirstInitial());
		//System.out.println(xi+" omega" +yi);
		
		boolean bad=true;
		while(bad)
		{int d=0;
		  x=xi;
		  y=yi;
		  k++;
		 // System.out.println(x+" "+y+"first before anything ");
		  if(bad)
		    d=(int)(Math.random()*4);
			  else d=(d+1)%4;
	    //System.out.println(x+" "+y+"middle ");
			  
		if(d==0)
		   y-=1;
		   else if(d==1)
		     x++;
			else if(d==2)
              y++;
              else 
                 x-=1;
        
        if(x>0&&y>0&&x<xMAX&&y<yMAX&&booleanBattleBoard[x][y]==false)
          bad=false;
		  // System.out.println(x+" "+y+"last k="+k);
		  
            else 
              bad=true;
		
		if(k>14)
		  break;
		
         }		
		 if(k>8){
        pokemon[id].setxPos(xi);
        pokemon[id].setyPos(yi);} 
	 
		pokemon[id].setxPos(x);
        pokemon[id].setyPos(y); 
	 }
	 
	 static void matter(Thread thr)
	 {//maater hota h na wo!!
	    int x,y,d;
		for(int i=0;i<pokemon[0].getCount();i++)
		 {  if(pokemon[i].getAlive())
		    {
		      x=pokemon[i].getxPos();
			  y=pokemon[i].getyPos();
			   if(y<9)
			    {if(battleBoard[x][y+1]!='.')
				   { for(d=0;d<pokemon[0].getCount();d++)
				        if(pokemon[d].getAlive())
						 if(pokemon[d].getIdOf(x,y+1))
						   {
						    System.out.println("\n"+pokemon[i].getName() + " VS " + pokemon[d].getName());
						    pokemon[d].takeAttack(pokemon[i].getAttack());
try
	 {
			thr.sleep(2000);
	 }
	 catch(InterruptedException e)
	 {
		 System.out.println("wo thread ka "+e);
	 }		
		// System.out.println(pokemon[i].getName() + " attacked " + pokemon[d].getName());
							if(pokemon[d].getAlive())
							 pokemon[i].takeAttack(pokemon[d].getAttack());
		try
	 {
			thr.sleep(2000);
	 }
	 catch(InterruptedException e)
	 {
		 System.out.println("wo thread ka "+e);
	 }					
							 }
							 }
							 }
			   if(x<9)
			    {if(battleBoard[x+1][y]!='.')
				   { for(d=0;d<pokemon[0].getCount();d++)
				        if(pokemon[d].getAlive())
						 if(pokemon[d].getIdOf(x+1,y))
						   {
						   System.out.println("\n"+pokemon[i].getName() + " VS " + pokemon[d].getName());
						    pokemon[d].takeAttack(pokemon[i].getAttack());
try
	 {
			thr.sleep(2000);
	 }
	 catch(InterruptedException e)
	 {
		 System.out.println("wo thread ka "+e);
	 }	
	//System.out.println(pokemon[i].getName() + " attacked " + pokemon[d].getName());
							 if(pokemon[d].getAlive())
							 pokemon[i].takeAttack(pokemon[d].getAttack());
							try
	 {
			thr.sleep(2000);
	 }
	 catch(InterruptedException e)
	 {
		 System.out.println("wo thread ka "+e);
	 }
							 
							 }
							 }
							 }
			  
							 
			 }
			}

       }
   
   static int getAliveCount()
   {
   int k=0;
   for(int i=0;i<pokemon[0].getCount();i++)
		 {  if(pokemon[i].getAlive())
		       k++;   
     }
	 return k;
   
   }
   
      static void rapidAttack(char i1, char i2,Thread thr)
   {  int x=0,y=0;
      
	 
	 
	 for(int i=0;i<pokemon[0].getCount();i++)
		  { if(pokemon[i].getFirstInitial()==i1)
		      {x=i;
			    break;
			  }}
	 for(int i=0;i<pokemon[0].getCount();i++)
		  { if(pokemon[i].getFirstInitial()==i2)
		      {if(i==x)
			    continue;
			     y=i;
			     break;
			  }
			}
			
	pokemon[x].setHealth(60);
	pokemon[y].setHealth(60);
	System.out.println("\n||***************************RAPID ATTACK**************************||\n");
      System.out.println("\n||*******************"+pokemon[x].getName().toUpperCase() + " VS " + pokemon[y].getName().toUpperCase() +"*******************||\n");
	for(;pokemon[x].getAlive()&&pokemon[y].getAlive();)		  
	{pokemon[x].takeAttack(pokemon[y].getAttack());
      try
	 {
			thr.sleep(2000);
	 }
	 catch(InterruptedException e)
	 {
		 System.out.println("wo thread ka "+e);
	 }
	  if(!pokemon[x].getAlive())
           break;	  
	 pokemon[y].takeAttack(pokemon[x].getAttack());
	 try
	 {
			thr.sleep(2000);
	 }
	 catch(InterruptedException e)
	 {
		 System.out.println("wo thread ka "+e);
	 }
	 if(!pokemon[y].getAlive())
           break;
	 }
	 
	 if(pokemon[y].getAlive())
	     { //System.out.println(pokemon[y].getName()+" is alive");
          pokemon[y].addHealth(15);
		  }
	if(pokemon[x].getAlive())
         {  //System.out.println(pokemon[x].getName()+" is alive");
		    pokemon[y].addHealth(15);
	         }
   }
   
   static void rapidAttack(Thread thr)
   {  int x=0,y=0;
      
	 
	 
	 for(int i=0;i<pokemon[0].getCount();i++)
		  { if(pokemon[i].getAlive())
		      {x=i;
			    break;
			  }}
	 for(int i=0;i<pokemon[0].getCount();i++)
		  { if(pokemon[i].getAlive())
		      {if(i==x)
			    continue;
			     y=i;
			     break;
			  }
			}  
	pokemon[x].setHealth(60);
	pokemon[y].setHealth(60);
	System.out.println("\n||***************************RAPID ATTACK**************************||\n");
      System.out.println("\n||*******************"+pokemon[x].getName().toUpperCase() + " VS " + pokemon[y].getName().toUpperCase() +"*******************||\n");
	for(;pokemon[x].getAlive()&&pokemon[y].getAlive();)		  
	{pokemon[x].takeAttack(pokemon[y].getAttack());
      try
	 {
			thr.sleep(2000);
	 }
	 catch(InterruptedException e)
	 {
		 System.out.println("wo thread ka "+e);
	 }
	  if(!pokemon[x].getAlive())
           break;	  
	 pokemon[y].takeAttack(pokemon[x].getAttack());
	 try
	 {
			thr.sleep(2000);
	 }
	 catch(InterruptedException e)
	 {
		 System.out.println("wo thread ka "+e);
	 }
	 if(!pokemon[y].getAlive())
           break;
	 }
   }
  
  public static void main(String[] args)
  {
  
     //3rd attack 4th defence
    Scanner sc=new Scanner(System.in);
    pokemon[0]=new Pokemon("Pikachu  ",2,15,14,0,5,6);
    pokemon[1]=new Pokemon("Squirtle  ",2,13,18,1,3,2);
    pokemon[2]=new Pokemon("Bulbasaur",2,14,9,2,7,3);
    pokemon[3]=new Pokemon("Charmendar",2,17,15,3,2,1);
    pokemon[4]=new Pokemon("Metapod ",2,10,20,4,4,8);
    pokemon[5]=new Pokemon("Onix    ",2,11,16,5,0,4);
    pokemon[6]=new Pokemon("Raticate",2,9,18,6,8,6);
    pokemon[7]=new Pokemon("Gastly   ",2,17,12,7,7,7);
    pokemon[8]=new Pokemon("Kraby   ",2,9,21,8,8,1);
    pokemon[9]=new Pokemon("Jiglypuff",2,7,7,9,1,8);	
	
	Thread thr=Thread.currentThread();
	
	System.out.println("CO5G and Starx INC proudly presents!!\nPOKEMON MAYHEM\n");

	
	 getPlayers();
	System.out.println("Let the battle begin!!");
	Enc eng=new Enc();
	eng.displayInfo();
	new Thread(eng).start();
	 
	for(int i=0;i<27;i++)
	   System.out.print("##");
        		 System.out.println();
	
				
	int it=5,alive;
	char m='h';
	 while(m!='n')
	  {
	  
	    alive=getAliveCount();
		if(alive==2)
		  break;
			

	    for(int i=0;i<it;i++) 
	    {buildBattleBoard();
	    drawBattleBoard(thr);
		matter(thr);
		//printXys();
		move();
		 }
		System.out.print("\n(h=help)Choice?? : ");
	    m=sc.next().toLowerCase().charAt(0);
		for(int i=0;i<27;i++)
	   System.out.print("##");
        		 System.out.println();
	  if(m=='h')
		 { help();
		 	System.out.print("\n(h=help)Choice?? : ");
	    m=sc.next().toLowerCase().charAt(0);
		for(int i=0;i<27;i++)
	   System.out.print("##");
        		 System.out.println();} 
				 
				 
		if(m=='u')
		  {      
		     System.out.print("\nName of pokemon 1 : ");
			 char p1=sc.next().toUpperCase().charAt(0);
			 System.out.print("\nName of pokemon 2 : ");
			 char p2=sc.next().toUpperCase().charAt(0);
		     
		     rapidAttack(p1,p2,thr);  
            System.out.print("##");
        		 System.out.println();
		    System.out.print("\n(h=help)Choice?? : ");
		   m=sc.next().toLowerCase().charAt(0);
			}		
					
		if(m=='s')
		  {//displayInfo();
		    		System.out.print("\n(h=help)Choice?? : ");
	    m=sc.next().toLowerCase().charAt(0);
		for(int i=0;i<27;i++)
	   System.out.print("##");
        		 System.out.println();}
		if(m=='p')
		  {System.out.print("\nNo of Iteration : ");
	      it=sc.nextInt();}
		  
	   //clearConsole();
	   }
      rapidAttack(thr);  
		//displayInfo();
	int x=0;	 
	for(int i=0;i<pokemon[0].getCount();i++)
		   {
		   //System.out.println(pokemon[i].getName()+" is checked and alive is "+   pokemon[i].getAlive());
		   if(pokemon[i].getAlive())//tHealth()!=0);
		      {x=i;
			    break;
			  }}
       System.out.println("\n||#######################"+pokemon[x].getName().toUpperCase() + " of " + pokemon[x].getMasterName().toUpperCase() +" is WINNNER#####################||\n");
	 it=sc.nextInt();
  }
}
