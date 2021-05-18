package IteratorPattern;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import IteratorPattern.company.*;
import IteratorPattern.iterator.*;
import IteratorPattern.movie.Movie;

public class MainGUI{

	static JFrame f;
	
	static JTable list = new JTable();
	
	
	static JPanel panel = new JPanel();
	static JScrollPane pane = new JScrollPane();
	
	
	public static void main(String[] args) throws Exception {
		
		f = new JFrame("Iterator GUI");
		
		

		pane = new JScrollPane(list);
		pane.setViewportView(list);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		panel.add(pane);
		
		

		//pane.setBounds(110,10,365,345);
		//panel.setBounds(110,10,365,345);
		pane.setPreferredSize(new Dimension(365,345));
		

		panel.setLocation(110, 10);
		//panel.setPreferredSize(new Dimension(100,100));
		
		String[] selection = {
				"Disney",
				"Netflix",
				"Amazon",
				"Hulu",
				"All"};
		
		
		JComboBox selectionList = new JComboBox(selection);
		selectionList.setBounds(17, 10, 75, 25);
		selectionList.setSelectedIndex(4);
		//selectionList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		
		/*JButton btn = new JButton("Search");
		btn.setBounds(17, 100, 75, 25);*/

		
		selectionList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectionList.getSelectedIndex() != -1) {
					try {
						GetIterator(selectionList.getSelectedIndex());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		
		//f.add(btn);
		f.add(selectionList);
		
		f.add(panel);
		
		f.setSize(700, 400);
		f.setVisible(true);
		
		

		GetIterator(4);
	}
	
	
	static void GetIterator(int iteratorType) throws Exception{
		
        NetflixIterator netflixIterator = new NetflixIterator();
        HuluIterator huluIterator = new HuluIterator();
        DisneyIterator disneyIterator = new DisneyIterator();
        AmazonIterator amazonIterator = new AmazonIterator();

        Iterator<Movie> i_netflix = netflixIterator.createIterator();
        Iterator<Movie> i_hulu = huluIterator.createIterator();
        Iterator<Movie> i_disney = disneyIterator.createIterator();
        Iterator<Movie> i_amazon = amazonIterator.createIterator();
        
		ArrayList<ArrayList<Object>> rt = new ArrayList<>();
		
		if (iteratorType == 4) {
			

			rt.addAll(getTheMovies(i_netflix, "Netflix"));
			rt.addAll(getTheMovies(i_hulu, "Hulu"));
			rt.addAll(getTheMovies(i_disney, "Disney"));
			rt.addAll(getTheMovies(i_amazon, "Amazon"));
			

			String[] columnNames = {"Company", "Title",
	                "Year"};

			Object[][] l = arrayListToArray(rt);
			//l.AddElement()
			//iterate and add stuff
			//list = new JList<>(l);
			list = new JTable(l, columnNames);
			list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);


			pane.setViewportView(list);
		} else  {
			
			ArrayList<String> clm = new ArrayList<>();
			clm.add("Title");
			clm.add("Year");
			
		if(iteratorType == 0) {
			rt.addAll(getTheMovies(i_disney, "!Disney"));
			clm.add("Country");
			clm.add("Rotten");
			//list = new JList<>(l);
		} else if(iteratorType == 1) {
			rt.addAll(getTheMovies(i_netflix, "!Netflix"));
			clm.add("Age");
			clm.add("Language");
			//list = new JList<>(l);
		} else if(iteratorType == 2) {
			rt.addAll(getTheMovies(i_amazon, "!Amazon"));
			clm.add("Type");
			clm.add("Runtime");
			//list = new JList<>(l);
		} else if(iteratorType == 3) {
			rt.addAll(getTheMovies(i_hulu, "!Hulu"));
			clm.add("Imdb");
			clm.add("Language");
			//list = new JList<>(l);
		} else {
			//an error has been occured
		}
		 

		 String[] columnNames = (String[]) clm.toArray();

			Object[][] l = arrayListToArray(rt);
			

			list = new JTable(l, columnNames);
			list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);


			pane.setViewportView(list);
		 }
		


		
		
		f.repaint();
		
	}
	
	
    public static ArrayList<ArrayList<Object>> getTheMovies(Iterator<Movie> iterator, String company) {
    	
    	ArrayList<ArrayList<Object>> rt = new ArrayList<>();
    	
        while(iterator.hasNext()) {
            Movie movie = iterator.next();
            ArrayList<Object> tmp = new ArrayList<>();
            if (!company.contains("!")) {
            	tmp.add(company);
            } 
            
            tmp.add(movie.getTitle());
            tmp.add(movie.getYear());
            
            
            if (company.contains("!")) {

                tmp.add(movie.getA());
                tmp.add(movie.getB());
            } 
            
            
            
            rt.add(tmp);
        }
        
		return rt;
    }
    
    public static Object[][] arrayListToArray(ArrayList<ArrayList<Object>> arrayList){
    	
    	Object[][] array = new Object[arrayList.size()][];
    	
    	for (int i = 0; i < arrayList.size(); i++) {
    	    ArrayList<Object> row = arrayList.get(i);
    	    array[i] = row.toArray(new String[row.size()]);
    	}
    	
    	
    	return array;
    }
}