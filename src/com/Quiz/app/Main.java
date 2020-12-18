package com.Quiz.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
public class Main {
 static	JFrame JF;
 static JLayeredPane Pl;
 static JLayeredPane Pll;
 static JButton btnsuivant;
 static JLabel qte;
 static ButtonGroup buttonGroup;
 static quiz q;
 static Niveau N1;
 static Niveau N2;
 static Niveau N3;
 static Timer timer;
 static TimerTask task;
 static  List<Question> Qte;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //Map<Réponse, Integer> reponse = new HashMap<Réponse, Integer>();
		
		  String[] réponses = {"Compilé et interpreté","Object","commence\r\n" + "par une\r\n" + "majuscule","oui","Interfacce",".classe","Bonjour\r\n" + "Nous\r\n" + "sommes en\r\n" + "2020 !\r\n","vrai","final","aucun\r\n" + "des choix","surchargée","vrai","faux","vrai","aucun\r\n" + "des choix"};
		  Instanciation();
		class Listner implements ActionListener{
			public void actionPerformed(ActionEvent event){
				// TODO Auto-generated method stub
			String votrechoix = "";
			
			try {
				votrechoix = buttonGroup.getSelection().getActionCommand().toString();
			}catch(Exception e) {
				
				//
			}  
			
			System.out.println(N1.getPts() + " " + q.getQ());
				if(votrechoix.toString().equals(réponses[q.getQ()])){
					if(q.getQ() == 0 && q.getQ() <5) {
						N1.setPts(N1.getPts() + 20);
						
						
					}else if(q.getQ() == 5 && q.getQ() <10) {
						
						N2.setPts(N2.getPts() + 20);
						
					}else {
						
						N3.setPts(N3.getPts() + 20);
						
					}	
				}

				
				if(q.getQ()==4){
					if(N1.getPts()>=40) {
						JOptionPane.showMessageDialog(null, "Congratulation passez au niveau 2 votre score " + N1.getPts() , "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
						N1.setPts(0);
					}else {	
					JOptionPane.showMessageDialog(null, "Erreur votre score " + N1.getPts() , "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);	
					}
				}else if(q.getQ()==9){
					
                    if(N2.getPts()>=60){
						
						JOptionPane.showMessageDialog(null, "Congratulation passez au niveau 3 votre et : " + N2.getPts(), "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
						N2.setPts(0);
					}else {
						
						JOptionPane.showMessageDialog(null, "Erreur votre score  " + N2.getPts() , "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
						
						System.exit(0);
						
					}
					
				}else if(q.getQ()==14) {
					
					if(N3.getPts() >= 80) {
						JOptionPane.showMessageDialog(null, "Congratulation" + N3.getPts(), "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
					}else {
						
						JOptionPane.showMessageDialog(null, "Erreur votre score  " + N3.getPts() , "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
						
						System.exit(0);
						
					}
				}
				
				q.setQ(q.getQ() + 1);
				if(q.getQ() < 15) {
					Afficher(q.getQ());
				}
				
				
				
			}	
				
			}
		Listner L = new Listner();
        btnsuivant.addActionListener(L);
        timer.scheduleAtFixedRate(task, 0, 1000);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*Methode*/
	
	public static void Instanciation() {
		
		 Qte = new ArrayList<Question>();
		 q = new quiz("Quiz JAVA",DateTimeFormatter.ofPattern("2020/04/16 05:00:00"));
		 JF = new JFrame();
		  N1 = new Niveau(1);
		  N2 = new Niveau(2);
		  N3 = new Niveau(3);
		  q.AddNiveau(N1);
		  q.AddNiveau(N2);
		  q.AddNiveau(N3);
	      btnsuivant = new JButton("Suivant");
		  Pl = new JLayeredPane();
          Afficher(q.getQ());
          Timer();
		
	}
	
	public static void Afficher(int pos) {
		
		RemplirNiveau();
		RemplirePanelNiveau(pos);
		AjouterFrame();
		
		
	}
	
    public static void AjouterFrame() {
    	
        JF.getContentPane().add(Pl);
        JF.setSize(500,400);
        JF.setVisible(true);
   	 
   	 
    }
    
    public static void RemplirePanelNiveau(int pst){
   	    
     	JLabel qte = new JLabel(Qte.get(pst).getDesc());
     	buttonGroup = new ButtonGroup();
     	btnsuivant.setBounds(50,200,100,30);
     	//btnsuivant.setVisible(true);
    	qte.setBounds(40,40,1000,50);
        Pl.removeAll();
        Pl.add(btnsuivant);
        Pl.add(qte);
        int y = 80;
        for(int i = 0;i<3;i++) {
        	JRadioButton radioButton1;
        	radioButton1	= new JRadioButton(Qte.get(pst).getChoix().get(i).getDesc());
        	radioButton1.setActionCommand(Qte.get(pst).getChoix().get(i).getDesc());
        	buttonGroup.add(radioButton1);
        	radioButton1.setBounds(40,y,200,30);
        	y+=30;
        	Pl.add(radioButton1);
        }

        
    	 
     }
    
    public static void RemplirNiveau(){
    	String[] Question = {"JAVA est un langage","Toutes les classes héritent de la classe","Par convention une classe","Est-ce que on peut avoir plusieurs constructeurs\r\n" + "pour la même classe","Dans la ligne \"public class A implements B\", B\r\n" + "est :","Après la compilation, un programme écrit en\r\n" + "JAVA, il se transforme en programme en bytecode\r\n" + "Quelle est l’extension du programme en\r\n" + "bytecode ?","Class Test{\r\n" + "Public Test () {\r\n" + "System.out.println(”Bonjour”);}\r\n" + "public Test (int i) {\r\n" + "this();\r\n" + 	"System.out.println(”Nous sommes en ”+i+ ” !”);};\r\n" + 	"}\r\n" + "qu’affichera l’instruction suivante?\r\n" + "Test t1=new Test (2018)","Voici un constructeur de la classe Employee, y-at'il un problème ?\r\n" + "Public void Employe(String n){\r\n" + "Nom=n;}","Pour spécifier que la variable ne pourra plus être\r\n" + "modifiée et doit être initialisée dès sa déclaration,\r\n" + "on la déclare comme une constante avec le mot\r\n" + "réservé\r\n" + "","Dans une classe, on accède à ses variables grâce au\r\n" + "mot clé","calculerSalaire(int)\r\n" + "calculerSalaire(int, double)\r\n" + "La méthode calculerSalaire est :","Une classe qui contient au moins une méthode\r\n" + "abstraite doit être déclarée abstraite.","Est-ce qu’une classe peut implémenter plusieurs\r\n" + "interfaces ?\r\n" + "","La déclaration d'une méthode suivante :\r\n" + "public void traitement() throws IOException\r\n" + "précise que la méthode propage une exception\r\n" + "contrôlée\r\n" + "","class Test{\r\n" + "public static void main (String[] args) {\r\n" + "try {\r\n" + 	"int a =10;\r\n" + "System.out.println (\"a = \" + a );\r\n" + "int b = 0 / a;\r\n" + "System.out.println (\"b = \" + b);\r\n" + "}\r\n" + "catch(ArithmeticException e)\r\n" + "{System.out.println (\"diviser par 0!\"); }\r\n" + "finally\r\n" + "{System.out.println (\"je suis à l’intérieur de\r\n" + "finally\");}}}"};
		 String[] choix = {"Compilé","Interprété","Compilé et interpreté","Main","Object","AWT","est en\r\n" + "minuscule","commence\r\n" + "par une\r\n" + "majuscule","est en\r\n" + "majuscules" ,"oui","non","Aucun reponse","Interfacce","Classe parent","Package","aucun\r\n","JAVA",".Class","aucun\r\n" + "des choix","Bonjour\r\n" + "Nous\r\n" + "sommes en\r\n" + "2020","Nous\r\n" + "sommes en\r\n" + "2020","vrai","faux","Aucun reponse","aucun\r\n" + "des choix","final","const","aucun\r\n" + "des choix","this","super","aucun\r\n" + "des choix\r\n" + "","surchargée","redéfinie","vrai","faux","Aucun reponse","vrai","faux","Aucun reponse","vrai","faux","Aucun reponse","aucun\r\n" + "des choix","a=10\r\n" + "b=0\r\n" + "Je suis à\r\n" + "l’intérieur de\r\n" + "finally","a=10\r\n" + "b=0\r\n" + "diviser par 0!\r\n" + "je suis à\r\n" + "l’intérieur de\r\n" + "final"};
		 
		 
		 

		
		 //Add au niveau

		 
		 int cpt = 0,fin = 3;
        for(int i =0;i<15;i++) {
       	 
       	 Qte.add(new Question(i,Question[i]));
       	 
       	 for(int j = cpt;j<fin;j++) {
				 
			 Qte.get(i).AddChoix(new Choix(i,choix[j]));
				
				 
			 }
       	 
       	 cpt = fin;
       	 fin += 3;
     
       	
       	 
           if(i<5) {
				 
				 N1.AddQuestion(Qte.get(i));
				 
			 }else if(i>5 && i<10) {
				 
				 N2.AddQuestion(Qte.get(i));
				 
			 }else {
				 
				 N3.AddQuestion(Qte.get(i));
				 
			 }
       	 
        }  
        
    	
    }
    
    public static void Timer(){
        JLabel lab3 = new JLabel();
        timer = new Timer();
        task = new TimerTask() {
        	int i = 300;
            public void run(){
            	JLabel   lab4 = new JLabel();
            	//lab4.setText("");
                if (i >= 0) {
                	lab3.setText("Timer " + i--);
                }
                String time = String.format("%02d:%02d", i / 60, i % 60);
                lab4.setText(time);
                lab4.setBounds(400,205,100,100);
                Pl.add(lab4);
                if(i == 0){
                	System.exit(0);
                }
            }
           
            
            

        };
    	
    }

}

