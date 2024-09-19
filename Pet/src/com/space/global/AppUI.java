package com.space.global;

public class AppUI {
	//Messages
		public static void DefaultMessages() {
			System.out.println("# please input again");
		}
		
		public static void TerminateProgramMessages() {
			System.out.println("### 99999. 프로그램 종료하기 ");
		}
		
		public static void PressEnter() {
			System.out.println("\n======계속 진행하시려면 ENTER를 누르세요======");
		}	
			
		//UIs
		// 0. 시작화면 출력(Main)
		public static void startScreen() {
			System.out.println("\n========== 애견 정보 관리 시스템 ==========");
			System.out.println("### 1. 애견 정보 추가하기");
			System.out.println("### 2. 애견 정보 조회하기");
			System.out.println("### 3. 애견 정보수정하기");
			System.out.println("### 4. 애견 정보 삭제하기");
			TerminateProgramMessages();
			System.out.println("--------------------------------------");
			System.out.print(">>>");
		}
		
		// 1. 여행패키지 추가
		public static void InsertScreen() {
			System.out.println("\n========== 여행패키지 추가 ==========");
			System.out.println("### 11. 애견인 정보 추가");
			System.out.println("### 12. 애견 정보 추가");
			System.out.println("### 13. 동물 병원 추가");
			System.out.println("### 14. 동물 약국 추가");
			System.out.println("### 15. 동물 미용실 추가");
			System.out.println("### 9. 메인 페이지로 돌아가기");
			TerminateProgramMessages();
			System.out.println("--------------------------------------");
			System.out.print(">>>"); 
		}
		
		// 2. 여행패키지 조회
		public static void TravelSearchScreen() {
			System.out.println("\n========== 여행패키지 조회 ==========");
			System.out.println("### 20. 예약 조회");
			System.out.println("### 21. 여행패키지 조회");
			System.out.println("### 22. 여행지 조회");
			System.out.println("### 23. 숙박시설 조회");
			System.out.println("### 24. 음식 조회");
			System.out.println("### 9. 메인 페이지로 돌아가기");
			TerminateProgramMessages();
			System.out.println("--------------------------------------");
			System.out.print(">>>"); 
		}
		
		// 3. 여행패키지 수정
		public static void TravelUpdateScreen() {
			System.out.println("\n========== 여행패키지 수정 ==========");
			System.out.println("### 31. 여행패키지 수정");
			System.out.println("### 32. 여행지 수정");
			System.out.println("### 33. 숙박시설 수정");
			System.out.println("### 34. 음식 수정");
			System.out.println("### 9. 메인 페이지로 돌아가기");
			TerminateProgramMessages();
			System.out.println("--------------------------------------");
			System.out.print(">>>");
		}
		
		// 4. 여행패키지 취소
		public static void TravelDeleteScreen() {
			System.out.println("\n========== 여행패키지 삭제 ==========");
			System.out.println("### 40. 예약 삭제");
			System.out.println("### 41. 여행패키지 삭제");
			System.out.println("### 42. 여행지 삭제");
			System.out.println("### 43. 숙박시설 삭제");
			System.out.println("### 44. 음식 삭제");
			System.out.println("### 45. 고객 정보 삭제");
			System.out.println("### 9. 메인 페이지로 돌아가기");
			TerminateProgramMessages();
			System.out.println("--------------------------------------");
			System.out.print(">>>");
		}
		
		// 7. 여행패키지 기록
		public static void TravelHistoryScreen() {
			System.out.println("\n========= 여행패키지 기록 =========");
			System.out.println("### 71. 여행패키지기록 조회");
			System.out.println("### 72. 여행패키지기록 삭제");
			System.out.println("### 9. 메인 페이지로 돌아가기");
			TerminateProgramMessages();
			System.out.println("----------------------------------------");
			System.out.print(">>> ");
		}

		// 8. ID 번호 요청
		public static void SelectID(){
			System.out.println("번호를 입력해주세요");
		}
		
		// 9. 삭제 완료 기록
		public static void DeleteCompleteMessage(){
			System.out.println("삭제를 완료했습니다.");
		}
}
