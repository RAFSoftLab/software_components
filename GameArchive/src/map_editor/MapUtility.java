package map_editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * his is utility class for map editing.It contains methods for map functionalities.
 */


public final class MapUtility 
{
	private MapUtility()
	{
		
	}
	
	/**
	 * This method load map from file.
	 * @param file map file
	 * @return map matrix
	 */
	public static String[][] loadMap(File file)
	{
		String map[][];
		ArrayList<ArrayList<String>> tempMap=new ArrayList<ArrayList<String>>();
		try 
		{
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line;
			
			while((line=reader.readLine())!=null)
			{
				if(line.isEmpty())
				{
					continue;
				}
				String values[]=line.trim().split(" ");
				ArrayList<String> row=new ArrayList<String>();
				for(String value : values)
				{
					//System.out.println(value);
					if(!value.isEmpty())
					{
						//System.out.println(Integer.parseInt(value));
						row.add(value);
					}
				}
				tempMap.add(row);
			}
			reader.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
	    {
			
			e.printStackTrace();
	    }
		
		int width=tempMap.get(0).size();
		int height=tempMap.size();
		map=new String[height][width];
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				//System.out.println(tempMap.get(i).get(j));
				map[i][j]=tempMap.get(i).get(j);
			}
		}	
		return map;
	}
	
	/**
	 * This method save map in file
	 * @param map map matrix
	 * @param path path to file
	 */
	public static void saveMap(int[][] map,String path)
	{
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(new File(path)));
			for(int i=0;i<map.length;i++)
			{
			    String linija="";
			    for(int j=0;j<map[i].length;j++)
			    {
			    	linija+=map[i][j]+" ";
			    }
			    writer.write(linija);
			    writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Print map to console.User can use this method for debuging.
	 * 
	 * @param map map matrix
	 */
	public static void printMap(String[][] map)
	{
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[i].length;j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	

}
