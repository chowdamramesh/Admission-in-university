
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.Date;

class Student {
	private String nameOfstudent;
	private double averageGpa;
	private double mathematicsGrade;
	private double generalScienceGrade;
	private double englishGrade;
	private double socialStudiesGrade;
	private double firstLanguageGrade;
	private String dateOfBirth;
	private int hallticketNumber;
	public Student(String nameOfstudent, double mathematicsGrade,
			double generalScienceGrade, double englishGrade,
			double socialStudiesGrade, double firstLanguageGrade,
			String dateOfBirth, int hallticketNumber) {
		super();
		this.nameOfstudent = nameOfstudent;
		this.mathematicsGrade = mathematicsGrade;
		this.generalScienceGrade = generalScienceGrade;
		this.englishGrade = englishGrade;
		this.socialStudiesGrade = socialStudiesGrade;
		this.firstLanguageGrade = firstLanguageGrade;
		this.dateOfBirth = dateOfBirth;
		this.hallticketNumber = hallticketNumber;
	}
	public String getNameOfstudent() {
		return nameOfstudent;
	}
	public double getAverageGpa() {
		return averageGpa;
	}
	public double getMathematicsGrade() {
		return mathematicsGrade;
	}
	public double getGeneralScienceGrade() {
		return generalScienceGrade;
	}
	public double getEnglishGrade() {
		return englishGrade;
	}
	public double getSocialStudiesGrade() {
		return socialStudiesGrade;
	}
	public double getFirstLanguageGrade() {
		return firstLanguageGrade;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public int getHallticketNumber() {
		return hallticketNumber;
	}
	public void setAverageGpa(double avg) {
		this.averageGpa = avg;
	}

	public String toString() {
		return "Student [nameOfstudent=" + nameOfstudent + ", averageGpa="
				+ averageGpa + ", mathematicsGrade=" + mathematicsGrade
				+ ", generalScienceGrade=" + generalScienceGrade
				+ ", englishGrade=" + englishGrade + ", socialStudiesGrade="
				+ socialStudiesGrade + ", firstLanguageGrade="
				+ firstLanguageGrade + ", dateOfBirth=" + dateOfBirth
				+ ", hallticketNumber=" + hallticketNumber + "]" + "\n";
	}
		
}

class AllComparator implements Comparator<Student> {
	//@Override
	public int compare(Student name1, Student name2) {
		double student1gpa = name1.getAverageGpa();
		double student2gpa = name2.getAverageGpa();

		double student1math = name1.getMathematicsGrade();
		double student2math = name2.getMathematicsGrade();

		double student1science = name1.getGeneralScienceGrade();
		double student2science = name2.getGeneralScienceGrade();

		double student1english = name1.getEnglishGrade();
		double student2english = name2.getEnglishGrade();

		double student1social = name1.getSocialStudiesGrade();
		double student2social = name2.getSocialStudiesGrade();

		double student1firstlang = name1.getFirstLanguageGrade();
		double student2firstlang = name2.getFirstLanguageGrade();
 		
 		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date d1 = null;
 		Date d2 = null; 
		try{
 			d1 = format.parse(name1.getDateOfBirth());
			d2 = format.parse(name2.getDateOfBirth());	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
 		

 		int student1hallTicket = name1.getHallticketNumber();
 		int student2hallTicket = name2.getHallticketNumber();

 		if (student1gpa > student2gpa) {
			return 1;
		} else if (student1gpa < student2gpa) {
			return -1;
		} else if (student1gpa == student2gpa) {
			if (student1math > student2math) {
			return 1;
			} else if (student1math < student2math) {
			return -1;
			} else if(student1math == student2math) {
				if (student1science > student2science) {
				return 1;
				} else if (student1science < student2science) {
				return -1;
				} else if (student1science == student2science) {
					if (student1english > student2english) {
					return 1;
					} else if (student1english < student2english) {
					return -1;
					} else if (student1english == student2english) {
						if(student1social > student2social) {
							return 1;
						} else if (student1social < student2social) {
							return -1;
						} else if (student1social == student2social) {
							if(student1firstlang > student2firstlang) {
								return 1;
							} else if(student1firstlang < student2firstlang) {
								return -1;
							} else if (student1firstlang == student2firstlang) {
								if (d1.before(d2)){
									return 1;
								} else if(d1.after(d2)) {
									return -1;
								} else if (d1.equals(d2)) {
									if(student1hallTicket < student1hallTicket) {
										return 1;
									} else if(student1hallTicket > student2hallTicket) {
										return -1;
									} else {
										return 0;
									}
								} 
								else {
									return 0;
								}
							}
							else {
								return 0;
							}
						}
						else {
							return 0;
						}
					} else {
						return 0;
					} 
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}	
}

public class Admission {
	public static void main(String[] args) {

		Student s1 = new Student("Ram",40,40,40,40,40,"01/04/1993",random());
		Student s2 = new Student("chandu",40,40,40,40,40,"01/04/1994",random());
		Student s3 = new Student("Ramesh",40,40,40,40,40,"01/04/1992",random());
		Student s4 = new Student("chandra",40,40,40,40,40,"01/04/1993",random());
 		
 		Scanner keyboard = new Scanner(System.in);
        System.out.println("enter maximum number of university admissions");
 		int maxAdmission = keyboard.nextInt();

 		averageOfGpa(s1);
 		averageOfGpa(s2);
 		averageOfGpa(s3);
 		averageOfGpa(s4);

		ArrayList<Student> admissionList = new ArrayList<Student>();
		admissionList.add(s1);
		admissionList.add(s2);
		admissionList.add(s3);
		admissionList.add(s4);


		Collections.sort(admissionList, new AllComparator());
		Collections.reverse(admissionList);
		/*for (Student printList : admissionList) {
			//System.out.println(print.getNameOfstudent());
			System.out.println(printList);
		}*/
		ArrayList<Student> finalAdmissionList = new ArrayList<Student>();

		for (int j = 0; j < maxAdmission ; j++) {
			finalAdmissionList.add(admissionList.get(j));
			//System.out.println(admissionList.get(j));
		}

		System.out.println(finalAdmissionList);

	}

	public static void averageOfGpa(Student s) {
		double sum = s.getMathematicsGrade() + s.getEnglishGrade() + 
						s.getSocialStudiesGrade() + s.getGeneralScienceGrade()
						 + s.getFirstLanguageGrade();
		double avg = sum/5;
		s.setAverageGpa(avg);
	}

	public static int random () {
		int hallTicket;
		Random rand = new Random();
		hallTicket = rand.nextInt(500);
		//System.out.println("hallTicket :: " + hallTicket);
		return hallTicket;
	}
}
