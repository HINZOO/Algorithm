package chapter08;

import java.util.Comparator;
import java.util.Scanner;


public class LinkedListTester {
	static Scanner stdIn = new Scanner(System.in);

	// 데이터(회원번호+이름)
	static class Data {
		static final int NO = 1; // 번호입력받기
		static final int NAME = 2; // 이름입력받기
		private Integer no; // 회원번호
		private String name; // 이름

		// 문자열 출력을 반환
		public String toString() {
			return "(" + no + ")" + name;
		}

		// 데이터 입력받기
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");

			if ((sw & NO) == NO) {// 비트마스크
				System.out.print("번호: ");
				no = stdIn.nextInt();
			}

			if ((sw & NAME) == NAME) {
				System.out.print("이름: ");
				name = stdIn.next();
			}
		}

		// 회원번호로 순서를 정하는 comparator
		public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

		private static class NoOrderComparator implements Comparator<Data> {
			@Override
			public int compare(Data d1, Data d2) {
				return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
			}
		}

		// 이름으로 순서를 정하는 comparator
		public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

		private static class NameOrderComparator implements Comparator<Data> {
			@Override
			public int compare(Data d1, Data d2) {
				return d1.name.compareTo(d2.name);
			}
		}
	}
	
	enum Menu{
		ADD_FIRST("머리에 노드를 삽입"),//0
		ADD_LAST("꼬리에 노드를 삽입"),
		RMV_FIRST("머리 노드를 삭제"),
		RMV_LAST("꼬리 노드를 삭제"),
		RMV_CRNT("선택 노드를 삭제"),
		CLEAR("모든 노드를 삭제"),
		SEARCH_NO("번호로 검색"),
		SEARCH_NAME("이름으로 검색"),
		NEXT("선택 노드를 하나 뒤쪽으로 진행"),
		PRINT_CRNT("선택 노드를 출력"),
		DUMP("모든 노드를 출력"),
		TERMINATE("종료");
		
		private final String message; //출력할 문자열
		
		//생성자
		Menu(String string) {
			message = string;
		}

		// 순서가 idx인 열거를 반환
		static Menu MenuAt(int idx) {
			for (Menu m : Menu.values()) {
				if (m.ordinal() == idx) {
					return m;
				}
			}
			return null;
		}

		// 출력할 문자열 반환
		String getMessage() {
			return message;
		}
	}
	
	//메뉴선택
	static Menu SelectMenu() {
		int key;
		do {
			for(Menu m : Menu.values()) {
				System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
				if((m.ordinal()%3)==2 && m.ordinal() != Menu.TERMINATE.ordinal()) {
					System.out.println();
				}
			}
			System.out.print(" : ");
			key= stdIn.nextInt();
		}while(key < Menu.ADD_FIRST.ordinal() || key> Menu.TERMINATE.ordinal());
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data ptr;
		Data temp = new Data();

		LinkedList<Data> list = new LinkedList<>();

		do {
			switch (menu = SelectMenu()) {
			case ADD_FIRST:
				data = new Data();
				data.scanData("머리에 삽입", Data.NO | Data.NAME);
				list.addFirst(data);
				break;

			case ADD_LAST:
				data = new Data();
				data.scanData("꼬리에 삽입", Data.NO | Data.NAME);
				list.addLast(data);
				break;

			case RMV_FIRST: // RMV = REMOVE
				list.removeFirst();
				break;

			case RMV_LAST:
				list.removeLast();
				break;

			case RMV_CRNT:
				list.removeCurrentNode();
				break;

			case SEARCH_NO:
				temp.scanData("검색", Data.NO);
				ptr = list.search(temp, Data.NO_ORDER);
				if (ptr == null) {
					System.out.println("그 번호의 데이터가 없습니다.");
				} else {
					System.out.println("검색 성공: " + ptr);
				}
				break;

			case SEARCH_NAME:
				temp.scanData("검색", Data.NAME);
				ptr = list.search(temp, Data.NAME_ORDER);
				if (ptr == null) {
					System.out.println("그 이름의 데이터가 없습니다.");
				} else {
					System.out.println("검색 성공: " + ptr);
				}
				break;

			case NEXT:
				list.next();
				break;

			case PRINT_CRNT:
				list.printCurrentNode();
				break;

			case DUMP:
				list.dump();
				break;

			case CLEAR:
				list.clear();
				break;
			default:
				break;
			}
		} while (menu != Menu.TERMINATE);
	}
}
