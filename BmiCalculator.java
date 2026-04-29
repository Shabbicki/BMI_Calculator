package bmiCalculator;

import java.util.Scanner;
import java.util.Locale;

public class BmiCalculator{


public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	s.useLocale(Locale.US);
	
	char repeat = 0;
	do{
		//all code
		int unitChoice = getUnitChoice(s);
		double weight = (unitChoice == 1)? getValidInput(s,"Enter your weight in kilograms: ",10,600)
				:getValidInput(s, "Enter your weight pounds: ",22,1300);
		double height = (unitChoice == 1)? getValidInput(s, "Enter your height in meters : ",0.5,2.5)
				:getValidInput(s, "Enter your weight in inches: ", 20,100);
		double bmi = calculateBMI(unitChoice, weight, height);
		System.out.println("Your BMI is: " +  bmi);
		bmiStatus(bmi);
		//repeat=askToRepeat(s);
		System.out.println();
	} while(repeat == 'Y' || repeat == 'y');
	s.close();
}
// Unit - Metric and Imperial

public static int getUnitChoice(Scanner s){
	int choice;
	
	while(true){
		System.out.println("Select a preferred unit:\n"
		+"1. Metric (kg,m)\n"
		+"2. Imperial (lbs, in)\n"
		+"Please select either option 1 or option 2"
		);
		
		if(s.hasNextInt()) {
			choice = s.nextInt();
			if(choice ==1 || choice ==2){
				break;
			}else{
				System.out.println("Invalid choice. Please enter either 1 or 2");
			}
		}else{
				System.out.println("Invalid input. Please enter a number (1 or 2)");
				s.next();
		}
		
	}
	
	
	return choice;
	
}

public static double getValidInput(Scanner s, String prompt, double min, double max){
	double value;
	
	while(true){
		System.out.println(prompt);
		
		if(s.hasNextDouble()){
			value = s.nextDouble();
			if(value >= min && value <=max){
				break;
			}else{
				System.out.printf("Please enter a value between %1f and 1f,\n",min,max);
				}
		}else{//
				System.out.println("Invalid input: Please enter a value");
				s.next();
			}
		}
			return value;
	}
	
public static double calculateBMI(int unitChoice, double weight, double height){
	double totalBMI;
	if(unitChoice==1){
		totalBMI = (weight/ (height * height));
	}else{
		totalBMI = (703 * weight)/(height * height);
	}
	return totalBMI;
}

public static double bmiStatus(double bmi){
	if(bmi<18.5){
		System.out.println("You are underweight");
	}
	else if(bmi<25){
		System.out.println("Great! Your weight is normal");
	}
	else if(bmi<30){
		System.out.println("You are overweight");
	}
	else if(bmi<35){
		System.out.println("You are obese");
	}
	else if(bmi>=35){
		System.out.println("Oh no, you are severely obese");
	}
	
	
	return bmi;
}

}