import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

import java.util.Map.Entry;
import java.util.*;
import java.io.*;
import java.lang.Comparable; 

import weka.associations.*;
import weka.core.*;
import weka.associations.Item;
//import weka.filters.supervised.attribute.Discretize;
import weka.filters.unsupervised.attribute.Discretize;
import weka.filters.Filter;

public class hi extends JFrame {

	File file;
    String confidence,support,rules_no,h_conf;
  
    int int1,int2,int3;
    double d1,d2,d3;
    int int4,int5,int6;
    double d4,d5,d6;
   
    JTextField jtxt1; 
    JTextField jtxt2;
    JTextField jtxt3;
    JTextField jtxt4; 
    JTextField jtxt5;
    JTextField jtxt6;
    
    int flag=0,flag2=0;
   // JButton mbutt; 
    int tes;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;
    JButton b9;
    JButton b10;
    
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JPanel p4;
    JPanel p11;
    
    
    JFrame f2;
    JFrame f3;
    
	CardLayout card;
	
	 JTable jTable1;
     JTable jTable2;
     JTable jTable3;
     JScrollPane scrollPane1;
     JScrollPane scrollPane2;
     JScrollPane scrollPane3;
     String file_name;


    public hi(){

 //--ALWAYS USE A JPANEL OVER JFRAME, I DID THIS TO KEEP IT SIMPLE FOR U--//
    	

        this.setSize(600,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setComponent();
        this.setHandler();
    }

    public void setComponent(){
    	
    	p11=new JPanel();
    	p1=new JPanel();
    	p2=new JPanel();
    	p3=new JPanel(new BorderLayout(2,2));
    	p4=new JPanel(new BorderLayout(2,2));

    	
    	

    	card=new CardLayout();
    	p11.setLayout(card);
       
    	

        
    //	p1.setLayout(null);
    	
        jtxt1 =  new JTextField(10);
        jtxt2 =  new JTextField(10);
        jtxt3 =  new JTextField(10);
        jtxt4 =  new JTextField(10);
        jtxt5 =  new JTextField(10);
        jtxt6 =  new JTextField(10);
        
       /* l1=new JLabel("Set Min Metric");
        l2=new JLabel("Set Support");
        l3=new JLabel("Number of Rules");*/

        //b1 = new JButton("Browse"); 
        b2 = new JButton("Apply Missing"); 
        b3 = new JButton("Detect Noise"); 
        b4 = new JButton("Display Original"); 
        b5 = new JButton("Undo"); 
        b6 = new JButton("Edit Parameters"); 
        b7 = new JButton("Apply");
        b8 = new JButton("OK");
        b9 = new JButton("OK");
        b10 = new JButton("Back");
     
        //p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p2.add(b4);
       // p1.add(b5);
        
        p2.add(b6);
        p2.add(b7);
        p2.add(b10);
        
     
        p2.setVisible(false);
        p1.setVisible(false); 
        p2.setSize(1000, 800);
      
       
       
        JPanel gui = new JPanel(new BorderLayout(2,2));
        
        
        

        JPanel p3 = new JPanel(new BorderLayout(2,2));
        p3.setBorder(new TitledBorder("Parameters"));

        JPanel labels = new JPanel(new GridLayout(0,1,1,1));
       // labels.setBorder(new TitledBorder("GridLayout"));
        JPanel fields = new JPanel(new GridLayout(0,1,1,1));
      
            labels.add(new JLabel("Set Min Confidence"));
            labels.add(new JLabel("Set Support"));
            labels.add(new JLabel("Number of Rules"));
            labels.add(new JLabel("Set Min h_confidence"));
            
            // if these were of different size, it would be necessary to
            // constrain them using another panel
            fields.add(jtxt1);
            fields.add(jtxt2);
            fields.add(jtxt3);
            fields.add(jtxt4);
           
        

        p3.add(labels, BorderLayout.CENTER);
        p3.add(fields, BorderLayout.EAST);
        
       
        JPanel pok = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //pok.setBorder(new TitledBorder("FlowLayout"));
        pok.add(b8);
        gui.add( p3, BorderLayout.NORTH );
        gui.add( pok, BorderLayout.CENTER );
      
        
        p11.add(p1, "one"); // id one refers panelOne
        p11.add(p2, "two"); // id two refers panelTwo
        p11.add(gui, "three"); // id one refers panelOne
 
       this.add(p11);
     

    }

	public void setHandler(){
    	 b4.addActionListener(new ActionListener(){   //display original
    		 
    		 
    		 public void actionPerformed(ActionEvent ae){
         	
         	String command = ae.getActionCommand();

             if (command.equals("Display Original")) {

           
            	 if(flag2==1)
            	 scrollPane2.setVisible(false);
            	 else
            	 scrollPane3.setVisible(false);
            	 scrollPane1.setVisible(true);
            	 
             }
         
         	
 	        scrollPane1.setVisible(true);
 	       //
         	
             }});
    	
    	 
    	

        b8.addActionListener(new ActionListener() {                                                    //ok

            @Override
            public void actionPerformed(ActionEvent e) {

                confidence = jtxt1.getText().toString();
                support = jtxt2.getText().toString();
                rules_no = jtxt3.getText().toString();
                h_conf=jtxt4.getText().toString();
            
                String command = e.getActionCommand();

                if (command.equals("OK")) {
                	
                                try {
                                	
                                	
                                	
						myMethod();
						flag=1;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                
                p2.add(scrollPane1);
               
               
                card.show(p11, "two"); // shows panelTwo
                if(flag2==1)
                {
                	 p2.add(scrollPane2);
                scrollPane1.setVisible(false);
                scrollPane2.setVisible(true);
                }
                else
                {
                	 p2.add(scrollPane3);
                	scrollPane1.setVisible(false);
                    scrollPane3.setVisible(true);	
                }
               

          

            }
        });
        
        
        
        
  
        
        b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){ //apply missing
            card.show(p11, "two"); // shows panelTwo
            if(flag==1){
                p2.remove(scrollPane1);
                p2.remove(scrollPane2);
                p2.remove(scrollPane3);
            	
            }
            
            flag2=1;

            
            }});
        
        
        
     
        b5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){  //undo
        	//card.show(p11, "one");
       // 	jTable2.setVisible(false);
        	scrollPane2.setVisible(false);
        //	jTable1.setVisible(true);
	        scrollPane1.setVisible(true);
	        
	        
            
        }});
        
        
        
        b6.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){  //edit parameters
            card.show(p11, "three"); // shows panelTwo
            if(flag==1)
            {
            	if(flag2==1)
            p2.remove(scrollPane2);
            	else
            p2.remove(scrollPane3);
            p2.remove(scrollPane1);
            }
            }});
        
        
        b3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){                         //detect Noise
            card.show(p11, "two"); // shows panelTwo
            if(flag==1)
            {
            	if(flag2==1)
            p2.remove(scrollPane2);
            	else
            p2.remove(scrollPane3);
            p2.remove(scrollPane1);
            }
            flag2=2;
            }});
        


        

        b7.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){  //apply
            
        	    card.show(p11, "two");
        	    
        	 //   jTable1.setVisible(false);
	        	scrollPane1.setVisible(false);
        	//    jTable2.setVisible(true);
	        	if(flag2==1)
	        	scrollPane2.setVisible(true);
	        	else
	        		scrollPane3.setVisible(true);
            }});
        
        
        b10.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){                                      //back
            
    	    card.show(p11, "one");
    	    if(flag2==1)
                p2.remove(scrollPane2);
                	else
                p2.remove(scrollPane3);
                p2.remove(scrollPane1);
    	    flag=0;
    	    
    	
        	
        }});
        

    }
    public static void main(String[] args){


         EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {

                hi t = new hi();
                t.setVisible(true);
       
            }

         });
    }
   
    public void myMethod() throws Exception {
    	
    	 confidence=jtxt1.getText();
    	 int1=Integer.parseInt(confidence);
    	 double d1=((double) int1)/100;
    	 
    	 support=jtxt2.getText();
    	 int2=Integer.parseInt(support);
    	 double d2=((double) int2)/100;
    	 
    	 rules_no=jtxt3.getText();
    	 int3=Integer.parseInt(rules_no);
    	 double d3=(double) int3;
    	
    	file = new File("mm.arff");
		BufferedReader br = new BufferedReader(new FileReader(file));
		

		Apriori ap = new Apriori();
		Discretize d = new Discretize();
		List<AssociationRule> association_rules = new ArrayList<AssociationRule>();
//		List<AssociationRule> ar = new ArrayList<AssociationRule>();
		AssociationRules ar = new AssociationRules(association_rules);
		br = new BufferedReader(new FileReader(file));
		Instances input = new Instances(br);
		String[] tuple;
		 Object[][] rowData=new Object[input.numInstances()][input.numAttributes()+1];  
         Object columnNames[]=new Object[input.numAttributes()+1];  
         Object[][] rowData2=new Object[input.numInstances()][input.numAttributes()+1];  
         Object columnNames2[]=new Object[input.numAttributes()+1];  
         Object[][] rowData3=new Object[input.numInstances()][input.numAttributes()+1];  
         Object columnNames3[]=new Object[input.numAttributes()+1];  
        
		columnNames[0]="Sr No.";
		columnNames2[0]="Sr No";
		columnNames3[0]="Sr No";
	
		for (int i = 1;i<=input.numAttributes(); i++)
		{
			columnNames[i]=input.attribute(i-1).name();
			columnNames2[i]=input.attribute(i-1).name();
			columnNames3[i]=input.attribute(i-1).name();
			
		}
		
		for (int i = 0;i<input.numInstances(); i++)
		{
			
			tuple=input.instance(i).toString().split(",");
			rowData[i][0]=i+1;
			rowData2[i][0]=i+1;
			rowData3[i][0]=i+1;
			
			for(int j=1;j<=(tuple.length);j++)
			{
				
				rowData[i][j]=tuple[j-1];
				rowData2[i][j]=tuple[j-1];
				rowData3[i][j]=tuple[j-1];
				
			}
		}
		 jTable1= new JTable(rowData,columnNames ); 
		
		 
		 scrollPane1 = new JScrollPane(jTable1);
		 scrollPane1.setVisible(true);
		 scrollPane1.setViewportView(jTable1);
		// jTable1.setBounds(16, 103, 800, 800);
		 jTable1.setVisible(true);
		
		br = new BufferedReader(new FileReader(file));
		Instances discretized = new Instances(br);
		br = new BufferedReader(new FileReader(file));
		Instances missing_test = new Instances(br);
/*		PrintStream out = new PrintStream(new FileOutputStream("output2.txt"));
		System.setOut(out);*/
		
		File file1 = new File("output3.txt");
		FileWriter fw = new FileWriter(file1.getAbsoluteFile());
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		input.setClassIndex(input.numAttributes()-1);
		discretized.setClassIndex(discretized.numAttributes()-1);
		d.setAttributeIndices("first-last");		
		d.setInputFormat(input);
		discretized = Filter.useFilter(input, d);
		
		int [] missingInstance= new int[10000];
		int count = 0;
		for (int i = discretized.numInstances() - 1; i >= 0; i--) {
		    Instance inst = discretized.instance(i);
		    if (inst.toString().contains("?")) {
		    	missingInstance[count]=i;
		    	if(flag2==1)
		        discretized.delete(i);
				bw.write(inst.toString());
				bw.newLine();
				//System.out.println(count+"   "+inst.toString()+"   "+missingInstance[count]);
		        count++;
		        
		    }
		}


		ap.setMinMetric(d1);
		ap.setLowerBoundMinSupport(d2);
		ap.setNumRules(int3);

		ap.buildAssociations(discretized);
		ap.setOutputItemSets(true);
		ar = ap.getAssociationRules();
		association_rules = ar.getRules();

		//		int count = 0;
		
		System.out.println("Association Rules:");
		Iterator<AssociationRule> iterator = association_rules.iterator();
		for(;iterator.hasNext();)
		{
			System.out.println(iterator.next());
		}
		
		
		bw.close();
	
		if(flag2 == 2)
		{
			create_HC(file1, discretized, association_rules, input, rowData3, columnNames3);
		}
		else
		{
	
		/* compute missing starts */
		br = new BufferedReader(new FileReader(file1));
		String test = null;
		int line=0;
		int line_no=0;
		int ptr=0;
		while((test = br.readLine())!=null)
		{
			test = test.replaceAll("\'", "");
			
			int missing_column[]=new int[10];
		    int index=0,missing_index=0;
			String items[] = new String[30];
			String test_antecedent[] = new String[30];
			items = test.split(",");
			for(int i=0; i<items.length; i++)
			{
				if(items[i].equals("?"))
				{
					missing_column[missing_index] = i;
					missing_index++;
				}
				else
				{
					String attribute[] = new String[30];
					attribute = input.attribute(i).toString().split(" ");
					test_antecedent[index] = attribute[1]+"="+items[i];
					index++;
				}
			}
		
		for(int i=0;i<missing_index;i++)
			{
				
				String answer=generateRM( association_rules, missing_column[i],test_antecedent,input);
				rowData2[missingInstance[ptr]][missing_column[i]+1]=answer;
		
				line++;
				
			}
		ptr++;
		}
		
		 jTable2= new JTable(rowData2,columnNames2 ); 
		 
		 scrollPane2 = new JScrollPane(jTable2);
		 scrollPane2.setVisible(false);
		}
	
	}
	
	
	public static String generateRM( List<AssociationRule> association_rules, int missing_column, String test_antecedent[],Instances input) throws FileNotFoundException
	{
		String ans=null;
		String attribute[] = new String[10];
		attribute = input.attribute(missing_column).toString().split(" ");
		Collection<Item> premise = new ArrayList<Item>();
		Collection<Item> consequent = new ArrayList<Item>();
		List<AssociationRule> RM = new ArrayList<AssociationRule>();
		
		/* RM generation */
		
		Iterator<AssociationRule> iter = association_rules.iterator();
		for(; iter.hasNext(); )
		{
			AssociationRule a_rule = iter.next();
			premise = a_rule.getPremise();						/* premise and consequent have to be arraylist */
			consequent = a_rule.getConsequence();				/* check all functions if u want... a_rule(dot).. */
		
			
			if(consequent.toString().contains(attribute[1]) )			
			{
//				if(consequent.size() == 1)
				{

				
				int flag = 0;
				Iterator<Item> iter1 = premise.iterator();					/* premise is also an arraylist and may contain multiple items. */
				for(;iter1.hasNext();)										/* iterator to arraylist premise will help u access one item of the premise at a time */
				{
					String premise_part = iter1.next().toString();			/* premise_part = individual item */		

					for (String item : test_antecedent) {
//						System.out.println(premise_part+"     "+item);
					    if (premise_part.equals(item)) 						/* check if this item is test_antecedent */
					    {
					        flag++;
					        break; 											/* No need to look further. */
					    } 
					}
				}
				
				if(flag == premise.size())									/* test_antecedent contains all items of the premise of that rule */
				{
//					System.out.println("premise= "+premise);
					flag = 0;
					RM.add(a_rule);	/* RM done */
				}
				}
			}
		}
	
		if(RM.size()>0)
			 ans=group_by(RM);
			
		else
			 ans=String.valueOf(input.meanOrMode(missing_column));
			//ans="?";
		
		RM = new ArrayList<AssociationRule>();
		return(ans);
	}

	
	public static String group_by(List<AssociationRule> RM) throws FileNotFoundException{
		
		RM.toArray();
		int rm_index=RM.size();
//		System.out.println("rmindex= "+rm_index);
		String group_name[]= new String[1000];
		double confidence[]= new double[1000];
		double support[]= new double[1000];
		int wt[]= new int[1000];
		int index=0,flag=0;
		
		group_name[index]=RM.get(0).getConsequence().toString();
		group_name[index] = group_name[index].replaceAll("]", "");
		group_name[index] = group_name[index].replaceAll("\\[", "");

	//	System.out.println("first group "+group_name[index]+ "    "+rm_index);
		
		wt[index] = RM.get(0).getPremise().size();
		confidence[index]=RM.get(0).getPrimaryMetricValue();
		support[index]=RM.get(0).getTotalSupport();
		index++;
		
		for(int i=1; i<rm_index; i++){
			flag=0;
			String cons1=RM.get(i).getConsequence().toString();
			cons1 = cons1.replaceAll("]", "");
			cons1 = cons1.replaceAll("\\[", "");
			String cons_parts[] = cons1.split(",");
			for(int j=0;j<index;j++)
			{
				for(int k=0; k<cons_parts.length; k++)
				{
				//	System.out.println("*"+cons_parts[k]+"*     *"+group_name[j]+"*    *"+cons1.contains(group_name[j]));
					if(cons_parts[k].contains(group_name[j]) || group_name[j].contains(cons_parts[k]))
					{
							wt[j]+=RM.get(i).getPremise().size();
							confidence[j]+=RM.get(i).getPrimaryMetricValue();
							support[j]+=RM.get(i).getTotalSupport();
							flag=1;
							break;
					}
					if(flag==1)
					break;
				}
			}
			if(flag==0)
			{
			group_name[index]=RM.get(i).getConsequence().toString();
			group_name[index] = group_name[index].replaceAll("]", "");
			group_name[index] = group_name[index].replaceAll("\\[", "");
			System.out.println("group added   "+group_name[index]);
			wt[index] = RM.get(i).getPremise().size();
			confidence[index]=RM.get(i).getPrimaryMetricValue();
			support[index]=RM.get(i).getTotalSupport();
			index++;
			}
			
		}
		
	
		double max=0;
		int max_index = 0, flag1 = 0;
		for(int i=0; i<index+1; i++)
		{			
			if(max < wt[i])
			{
				max = wt[i];
				max_index = i;
			}
			if(max == wt[i])
			{
				flag1 = 1;
				break;
			}
		}
		max = 0;
		if(flag1 == 1)
		{
			for(int i=0; i<index+1; i++)
			{
				if(max < confidence[i])
				{
					max = confidence[i];
					max_index = i;
				}
			}
		}
		
	
		
		System.out.println("Answer: ");
	
		return(group_name[max_index].toString());
	}
	
	
	public  void create_HC(File file, Instances instance, List<AssociationRule> association_rules, Instances input,Object [][] rowData3, Object[] columnData3 ) throws Exception
	{

		BufferedReader br = new BufferedReader(new FileReader(file));
        Map<String,Integer> support = new HashMap<String,Integer>();
        Map<String,Integer> l1 = new HashMap<String,Integer>();
        Map<String,Integer> newl1 = new HashMap<String,Integer>();
        
		for(int i=0; i<instance.numInstances(); i++)
		{
			for(int j=0; j<instance.numAttributes(); j++)
			{
				String str1=instance.instance(i).attribute(j).name()+"="+instance.instance(i).stringValue(j);
				if(support.containsKey(str1)){
					int count = (support.get(str1));
					support.remove(str1);
					support.put(str1, count+1);
				}
				else
					support.put(str1, 1);
			}
		}
        
		double fraction=0.0;

		l1 = prune(support, l1, 1);
		newl1.putAll(l1);
	
		ArrayList<String> candidates = generate_candidate_sets(l1, 2);
		System.out.println("L2");
		Map<String, Integer> c2 = new HashMap<String, Integer>();
		c2 = get_count(candidates, c2, br, instance);
		Map<String,Integer> l2 = new HashMap<String,Integer>();
		l2 = prune(c2, l2, 1);
		
		System.out.println("size L2 = "+l2.size());
		for(Iterator<Entry<String, Integer>> iter = l2.entrySet().iterator(); iter.hasNext(); ){
			Map.Entry<String, Integer> entry = iter.next();

			String items[] = entry.getKey().split(";");
			
				int count1=newl1.get(items[0]);
				int count2=newl1.get(items[1]);
		
				if(count1>count2)
				{
					fraction=((double)count2)/count1;
					if(fraction<0.5)
					{
						iter.remove();
					}
				}
				else
				{
					fraction=((double)count1)/count2;
					if(fraction<0.5)
					{
						iter.remove();
					}
					
				}
		
		}
		System.out.println("size L2 after cross = "+l2.size());
		
		ArrayList<String> candidates2 = generate_candidate_sets(l2, 3);
		Map<String, Integer> c3 = new HashMap<String, Integer>();
		c3 = get_count(candidates2, c3, br, instance);
		Map<String,Integer> l3 = new HashMap<String,Integer>();
		l3 = prune(c3, l3, 1);

		System.out.println("Size L3 = "+l3.size());
		for(Iterator<Entry<String, Integer>> iter = l3.entrySet().iterator(); iter.hasNext(); ){
			Map.Entry<String, Integer> entry = iter.next();
	
			int int4=Integer.parseInt(h_conf);
			d4=((double)int4);
			String items[] = entry.getKey().split(";");
			
				int count1=newl1.get(items[0]);
				int count2=newl1.get(items[1]);
				int count3=newl1.get(items[2]);
		
				if(count1>count2 && count1>count3)
				{
					fraction=(((double)entry.getValue())/count1)*100;
					
					if(fraction<d4)
					{
						iter.remove();
					}
				}
				else if(count2>count3 && count2>count3)
				{
					fraction=(((double)entry.getValue())/count2)*100;
					if(fraction<d4)
					{
						iter.remove();
					}
					
				}
				else
				{
					fraction=(((double)entry.getValue())/count3)*100;
					if(fraction<d4)
					{
						iter.remove();
					}
				}
			
		
		}	
		
		System.out.println("size L3 after hc = "+ l3.size());
		System.out.println(l3);
		
		
		/* checking */
		boolean[] instance_covered = new boolean[instance.numInstances()];
		Iterator<Entry<String, Integer>> iter;
		for(int i=0; i<instance.numInstances(); i++)
		{
			ArrayList<String> inst = new ArrayList<String>();
			ArrayList<Boolean> obj_present = new ArrayList<Boolean>();
			for(int j=0; j<instance.numAttributes(); j++)
			{
				if(instance.instance(i).isMissing(j))
					inst.add(instance.instance(i).attribute(j).name()+"=?");
				else
					inst.add(instance.instance(i).attribute(j).name()+"="+instance.instance(i).stringValue(j));
				obj_present.add(false);
			}
			System.out.println("-----"+inst.toString()+"   "+i);
			iter = l3.entrySet().iterator();
			for(;iter.hasNext();)
			{
				String[] h_pattern = iter.next().getKey().split(";");
				if(inst.contains(h_pattern[0]) && inst.contains(h_pattern[1]) && inst.contains(h_pattern[2]))
				{
					instance_covered[i] = true;
					obj_present.set(inst.indexOf(h_pattern[0]),true);
					obj_present.set(inst.indexOf(h_pattern[1]),true);
					obj_present.set(inst.indexOf(h_pattern[2]),true);
				}
				
			}
			System.out.println("++++"+instance.instance(i));
			System.out.println("after cancelling in "+i+" = "+obj_present+"  "+inst);
			System.out.println();
			
			if(obj_present.contains(false))
				System.out.println("Instance no. "+i+"  "+obj_present+inst);
			
			int missing_column[]=new int[10];
			int missing_index = 0, index = 0;
			String test_antecedent[] = new String[30];
			
			
			for(int k=0; k<obj_present.size(); k++)
			{
				if(obj_present.get(k)==false || inst.contains("?"))
				{
					missing_column[missing_index] = k;
					missing_index++;
					System.out.println("rgsergerh"+inst.toString());
				}
				else
				{
					test_antecedent[index] = inst.get(k);
					index++;
				}
			}
		
		
			for(int k=0;k<missing_index;k++)
			{
				String answer=generateRM( association_rules, missing_column[k],test_antecedent,input);
				rowData3[i][missing_column[k]+1]=answer;
				System.out.println("noise index= "+i+"    previous= "+inst.get(missing_column[k])+"    answer= "+answer);
			}
			
		}
		jTable3= new JTable(rowData3,columnData3 ); 
		 scrollPane3 = new JScrollPane(jTable3);
		 scrollPane3.setVisible(false);
		
	}
	
	
	public static Map<String, Integer> prune(Map<String, Integer> first, Map<String, Integer> second, int min_support)
	{
		second = first;
		for(Iterator<Entry<String, Integer>> iter = second.entrySet().iterator(); iter.hasNext(); ){
			Map.Entry<String, Integer> entry = iter.next();
			if (entry.getValue() < min_support) {
			iter.remove();
			}
		}

		return second;
	}
	
	
	public static ArrayList<String> generate_candidate_sets(Map<String, Integer> c, int pass){
		
		ArrayList<String> combi = new ArrayList<String>();
		ArrayList<String> combi2 = new ArrayList<String>();
		Map<String, Integer> x = new HashMap<String, Integer>();
		x = c;
		
		/* Take all items (only items, not value) in ArrayList */
		Iterator<Entry<String, Integer>> iter = x.entrySet().iterator();
	    while (iter.hasNext()) {
	        Map.Entry<String, Integer> pairs = (Map.Entry<String, Integer>)iter.next();
	        combi.add(pairs.getKey().toString());
	        iter.remove(); 
	    }
	    
	    /* Join */
	    for(int i=0; i<combi.size(); i++){
	    	for(int j=i+1; j<combi.size(); j++){
	    		String set1[] = null;
	    		set1 = combi.get(i).toString().split(";|\0");
	    		String set2[] = null;
	    		set2 = combi.get(j).toString().split(";|\0");
	    		int flag = 0;
	    		String str = null;
	    		
	    		for(int k=0; k<(pass-2); k++){
	    			if(!set1[k].equals(set2[k])){			/* check k-2 items */
	    				flag = 1; 
	    				break;
	    			}
	    			str = str+";"+set1[k];
	    		}
	    	
	    		/* New itemset */
	    		if(flag == 0)
	    		{
	    			for(int q=(pass-2); q<set1.length; q++){
	    				str = str+";"+set1[q]+";"+set2[q];
	    			}
	    			str = str.replaceFirst("null;","");
	    			combi2.add(str);						/* combi2 = final list of candidates */
	    		}
	    	}
	    }
	    
	    return combi2;
	}
	
	
	public static Map<String, Integer> get_count(ArrayList<String> candidates, Map<String, Integer> c, BufferedReader br, Instances input) throws IOException{

    Map<String,Integer> support = new HashMap<String,Integer>();
    
	
	int flag=0;
	for(int i=0; i<input.numInstances(); i++)
	{
		
		String str1 = new String();;
		for(int j=0; j<input.numAttributes(); j++)
		{
			str1= str1 + input.instance(i).attribute(j).name()+"="+input.instance(i).stringValue(j);
		}

		for(int ii=0; ii<candidates.size(); ii++){
			String items[] = candidates.get(ii).toString().split(";");
			flag = 0;
			for(int jj=0; jj<items.length; jj++){
				if(!str1.contains(items[jj])){			/* check if line contains all items */
					flag = 1;							
					break;
				}
			}

			if(flag == 0){								/* flag = 0 indicates that all items are present in the tuple */
				if(support.containsKey(candidates.get(ii))){
					int count = (support.get(candidates.get(ii)));
					support.remove(candidates.get(ii));
					support.put(candidates.get(ii), count+1);
				}
				else
					support.put(candidates.get(ii), 1);
			}
		}
	}
	
	return support;
}

}

