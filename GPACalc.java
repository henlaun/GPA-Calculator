package misc;

import java.util.*;

public class GPACalc { //start class

		public static void main(String[] args) {		// Start main method

			Scanner input = new Scanner(System.in);

			String[] LetterGrades = new String[] {"A", "Bplus", "B", "Cplus", "C", "Dplus", "D"} ;

			double totalcredits = 0.0, FinalGrade = 0.0, RTotalGrade = 0.0, HTotalGrade = 0.0;

			System.out.println("How many classes are you taking?");
			int NumberOfClasses = input.nextInt();

			for (int i = 0; i < NumberOfClasses; i++) { // start for loop
				System.out.println("How many credits is Class #" + (i + 1) + " worth?");
				double credits = input.nextDouble();
				totalcredits = totalcredits + credits;

				System.out.println("Is Class #" + (i + 1) + " an honors course? Reply yes or no.");
				String HOrNot = input.next();

				if (HOrNot.equalsIgnoreCase("Yes")) { // start honors if statement
					System.out.print("What letter grade did you get in Honors Class #" + (i + 1) + "? If it is a plus grade, please specify by typing ' 'plus. For example, Bplus.");
					String HLetter = input.next();
				  HTotalGrade = HTotalGrade + ConvertHLetter(HLetter, LetterGrades) * credits;

				}
				else if ((HOrNot.equalsIgnoreCase("No"))) {
					System.out.print("What letter grade did you get in Regular Class #" + (i + 1) + "? If it is a plus grade, please specify by typing ' 'plus. For example, Bplus.");
					String RLetter = input.next();
				  RTotalGrade = RTotalGrade + ConvertRLetter(RLetter, LetterGrades) * credits;

				}
				else { // start else
					System.out.println("That doesn't seem right.");
					break;
				} // end else
			} // end for loop

			input.close();

			FinalGrade = (HTotalGrade + RTotalGrade) / totalcredits;
			System.out.println("Your final grade is " + FinalGrade);

		} // end main method

		public static double ConvertHLetter(String HLetter, String[] LetterGrades) { // start method

			double[] HNumberGrades = new double[] {5.0, 4.67, 4.0, 3.67, 3.0, 1.67, 1.0} ;
			double HNumber = 0;

			for (int j = 0; j < LetterGrades.length; j++) { // start for class to check array
				if (HLetter.equalsIgnoreCase(LetterGrades[j])) {
					HNumber = HNumberGrades[j];
				}
			} // End for loop to check array
			return HNumber;

		}

		public static double ConvertRLetter(String RLetter, String[] LetterGrades) { // start method

			double[] RNumberGrades = new double [] {4.0, 3.67, 3.0, 2.67, 2.0, 1.67, 1.0} ;
			double RNumber = 0;

			for (int j = 0; j < LetterGrades.length; j++) { // start for class to check array
				if (RLetter.equalsIgnoreCase(LetterGrades[j])) {
					RNumber = RNumberGrades[j];
				}
			} // End for loop to check array
			return RNumber;

		} // End method
}	// End Class
