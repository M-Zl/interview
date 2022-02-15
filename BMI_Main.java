package BMI;

import java.util.Scanner;

public class BMI_Main {
//	Scanner sanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		// 이름을 입력받는 함수
		// 나이를 입력받는 함수
		// 성별을 입력받는 함수
		// 키 입력받는 함수
		// 몸무게 입력받는 함수
		// BMI 계산하는 함수
		// 판정하는 함수
		// 결과 출력하는 함수
		
		// 출력예시
		
		// --------------- BMI 계산 결과 -------------------
		// 이름 : ??
		// 나이 : ??살
		// 성별 : ??
		// 키 : ?? cm
		// 몸무게 : ?? kg
		// BMI 지수 : ??
		// 판정결과 : ??
		
		// BIM 지수 소수점 2자리까지
		
		BMI_Main main = new BMI_Main();
		
		String name = main.userName();
		int userAge = main.userAge();
		String gender = main.userGender();
		Double height = main.userHeight();
		Double weight = main.userWeight();
		Double userBMI = main.userBMI(weight,height);
		String result = main.BMIresult(userBMI);
		String message = main.message(name, userAge, gender, height, weight, userBMI, result);
		
	}
	
	public String userName() {
		Scanner sanner = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요. : ");
		
		String name = sanner.nextLine();
		
		boolean stringChk = name.matches(".*\\d.*");
		
		while(stringChk) {
			System.out.println("올바른 이름을 입력해 주세요.");
			System.out.print("이름을 입력해주세요. : ");
			
			name = sanner.nextLine();
			stringChk = name.matches(".*\\d.*");
		}
		
		sanner.close();
		
		return name;
	}
	
	public int userAge() {
		Scanner sanner = new Scanner(System.in);
		
		System.out.print("나이를 입력해주세요. : ");
		
		int age = 0;
		
		while(!sanner.hasNextInt()) {
			sanner.next();
			System.out.println("올바른 숫자를 입력해주세요.");
			System.out.print("나이를 입력해주세요. : ");
		}
		
		age = sanner.nextInt();
		
		sanner.close();
		
		return age;
	}
	
	public String userGender() {
		Scanner sanner = new Scanner(System.in);
		
		System.out.print("성별을 입력해주세요.(남자/여자) : ");
		
		String gender = sanner.nextLine();
		boolean genderChk = false;
		
		while(!genderChk) {
			switch(gender) {
				case "여자" :
					genderChk = true;
					break;
				case "남자" :
					genderChk = true;
					break;
				default :
					System.out.println("남자 또는 여자로 입력해주세요.");
					System.out.print("성별을 입력해주세요.(남자/여자) : ");
					gender = sanner.nextLine();
					
					if(gender.equals("여자") || gender.equals("남자")) {
						genderChk = true;
					}
					break;
			}
		}
		
		sanner.close();
		
		return gender;
	}
	
	public Double userHeight() {
		Scanner sanner = new Scanner(System.in);
		
		System.out.print("키를 입력해주세요. : ");
		Double height;
		
		while(!sanner.hasNextDouble()) {
			sanner.next();
			System.out.println("올바른 숫자를 입력해주세요.");
			System.out.print("키를 입력해주세요. : ");
		}
		
		height = sanner.nextDouble();
		
		sanner.close();
		
		return height;
	}
	
	public Double userWeight() {
		Scanner sanner = new Scanner(System.in);
		
		System.out.print("몸무게를 입력해주세요. : ");
		Double weight;
		
		while(!sanner.hasNextDouble()) {
			sanner.next();
			System.out.println("올바른 숫자를 입력해주세요.");
			System.out.print("몸무게를 입력해주세요. : ");
		}
		
		weight = sanner.nextDouble();
		
		sanner.close();
		
		return weight;
	}
	
	public Double userBMI(Double weight, Double height) {
		Scanner sanner = new Scanner(System.in);
		
		Double BMI = weight / (height * height) * 10000;
		BMI = Math.floor(BMI * 100) / 100.0;
		
		sanner.close();

		return BMI;
	}
	
	public String BMIresult(Double BMI) {
		String result = "";
		
		if(BMI > 30) {
			result = "비만";
		} else if(BMI > 24) {
			result = "과체중";
		} else if(BMI > 19) {			
			result = "정상";
		} else {
			result = "저체중";
		}
		
		return result;
	}
	
	public String message(String userName, int userAge, String userGender,Double userHeight, Double userWeight, Double userBMI, String BMIresult) {
		String msg = "--------------- BMI 계산 결과 -------------------" + 
				   "\n이름 : " + userName + 
				   "\n나이 : " + userAge + "살" +
				   "\n성별 : " + userGender +
				   "\n키 : " + userHeight + "cm" +
				   "\n몸무게 : " + userWeight + "kg" +
				   "\nBMI 지수 : " + userBMI +
				   "\n판정결과 : " + BMIresult;
		
		System.out.println(msg);
		
		return msg;
	}
}
