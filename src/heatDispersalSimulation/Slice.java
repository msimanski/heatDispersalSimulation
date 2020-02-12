package heatDispersalSimulation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class Slice
{
	public static int size = 25;
	public double[][] particleStates;
	
	public Slice()
	{
		particleStates = new double[size][size];
		
		for (int i = 0; i < this.particleStates.length; i++)
		{
			for (int j = 0; j < this.particleStates.length; j++)
			{
				particleStates[i][j] = 0.000;
			}
		}
		
		pokeTemp();
		processInstance();
	}
	
	public void print() 
	{
		for (int i = 0; i < this.particleStates.length; i++)
		{
			for (int j = 0; j < this.particleStates.length; j++)
			{
				System.out.print(particleStates[i][j] + " ");
			}
			
			System.out.println("");
		}
	}
	
	private void pokeTemp() 
	{
		particleStates[1][1] = 100.0;
	}
	
	private static double round(double value, int places) 
	{
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public void processInstance() 
	{
		double [][] newSliceStates = new double[size][size];
		
//		double a;
//		double b;
//		double c;
//		double d;
//		double e;
//		double f;
//		double g;
//		double h;
//		double curr;
//		double tru;
		
		System.arraycopy(particleStates, 0, newSliceStates, 0, size);
		
		for (int i = 0; i < this.particleStates.length; i++)
		{
			for (int j = 0; j < this.particleStates.length; j++)
			{
				/*
				 * 
				    array[i-1][j-1]
					array[i-1][j]
					array[i-1][j+1]
					
					array[i][j-1]
					array[i][j+1]
					
					array[i+1][j-1]
					array[i+1][j]
					array[i+1][j+1]
				 */
				
				// If in bounds
				if (i - 1 != -1 && i + 1 != size && j - 1 != -1 && j + 1 != size)
				{
					
					// Don't count top
					
					// Don't count left
					
					// Don't count right
					
					// Don't count bottom
					
					// Average the cell up
//					a = newSliceStates[i-1][j-1];
//					b = newSliceStates[i-1][j];
//					c = newSliceStates[i-1][j+1];
//					d = newSliceStates[i][j-1];
//					e = newSliceStates[i][j+1];
//					f = newSliceStates[i+1][j-1];
//					g = newSliceStates[i+1][j];
//					h = newSliceStates[i+1][j+1];
//					tru = a + b + c + d + e + f + g + h;
//					curr = newSliceStates[i][j];
					
					//System.out.println("True answer: " + (a + b + c + d + e + f + g + h + curr) / 8.0);
					
					newSliceStates[i][j] = (newSliceStates[i-1][j-1] + newSliceStates[i-1][j] + newSliceStates[i-1][j+1] + newSliceStates[i][j-1] + newSliceStates[i][j+1] + newSliceStates[i+1][j-1] + newSliceStates[i+1][j] + newSliceStates[i+1][j+1] + newSliceStates[i][j]) / 8.0;
				}
			}
		}
		
		System.arraycopy(newSliceStates, 0, particleStates, 0, size);
	}
}
