package bmiCalculator;

import java.util.Scanner;
import java.util.Locale;

public class BmiCalculator{


public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	s.useLocale(Locale.US);
	
	char repeat;
	do{
		//all code
		int unitChoice = getUnitChoice(s);
		double weight = (unitChoice == 1)? getValidInput(s,"Enter your weight in kilograms: ",10,600)
				:getValidInput(s, "Enter your weight pounds: ",22,1300);
		double height = (unitChoice == 1)? getValidInput(s, "Enter your height in meters : ",0.5,2.5)
				:getValidInput(s, "Enter your weight in inches: ", 20,100);
		double bmi = calculateBMI(unitChoice, weight, height);
		System.out.println("\n  -----  Your BMI Summary -----");
		System.out.println("Your BMI is: " +  bmi);
		String stat = bmiStatus(bmi);
		System.out.println("Category: "+ stat);
		tips(String stat);
		repeat=askToRepeat(s);
		System.out.println();
	} while(repeat == 'Y' || repeat == 'y');
	s.close();
}
public static char askToRepeat(Scanner s){
	System.out.println("Do you want to repeat? Please type Y or N");
	char choice = s.next().charAt(0);
	return choice;
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

public static String bmiStatus(double bmi){
	if(bmi<18.5){
		return "You are underweight";
	}
	else if(bmi<25){
		return "Great! Your weight is normal";
	}
	else if(bmi<30){
		return "You are overweight";
	}
	else if(bmi<35){
		return "You are obese";
	}
	else{
		return "Oh no, you are severely obese";
	}
}

public static void tips(String stat){
	switch(stat){
		case "You are underweight":
		System.out.println("Tip: Try eating a well-balanced diet and consult a professional if needed.");
		case "Great! Your weight is normal":
		System.out.println("Nice! Keep maintaining your healthy lifestyle");
		case "You are overweight":
		System.out.println("Tip: Consider doing some light exercise and healthier food choices");
		case "You are obese":
		case "You are obese":
		System.out.println("Tip: It may help to seek professional guidance");
		break;
	}
	
}
}