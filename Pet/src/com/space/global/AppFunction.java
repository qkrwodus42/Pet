package com.space.global;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppFunction {
private static Scanner sc = new Scanner(System.in);
	
	public static String inputString() { //문자를 입력받는 곳에서 사용
		return sc.nextLine();   
	}

	public static int inputInteger() { //숫자를 입력받는 곳에서 사용
		int inputNum = 0;
		try {
			inputNum = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("정수로 입력해 주세요.");				
		} finally {
			sc.nextLine();
		}

		return inputNum;
	}
	
	//DATE 입력받는 곳에서 사용
	public static Date inputDate() {
		Date sqlDate = null;
		
		System.out.println("Enter a date in 'YY/MM/DD' format: ");
		String inputDate = sc.nextLine();
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yy/MM/dd");
		try {
            LocalDate date = LocalDate.parse(inputDate, inputFormatter);
            sqlDate = Date.valueOf(date);
     
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use 'yy/MM/dd'.");
        }
		
		return sqlDate;
    }

	
	
	//시간 간격 함수
	public static String BlockTime(LocalDateTime depart,LocalDateTime arrive) {	
		Duration duration = Duration.between(depart, arrive);
		
		// 차이를 시간, 분, 초로 출력
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
		
        return "[시간 간격: " + hours + "시간 " + minutes + "분]";
	}

	//강제종료
	public static void shutdown() {
		System.out.println("프로그램을 종료합니다.");				
		sc.close();
		System.exit(0);
	}

}
