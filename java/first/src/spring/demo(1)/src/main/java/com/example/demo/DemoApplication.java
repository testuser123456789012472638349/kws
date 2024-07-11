//package com.example.demo;
//
////import com.example.demo.chapter03.used.EveningGreet;
////import com.example.demo.chapter03.used.Greet;
//import com.example.demo.entity.Member;
//import com.example.demo.repository.MemberCrudRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//
//// class Member {
//// 	String name;
//// 	int age;
//
//// 	Member(String name, int age) {
//// 		this.name = name;
//// 		this.age = age;
//// 	}
//
//// 	Member() {
//// 		this("홍길동", 18);
//// 	}
//
//// 	@Override
//// 	public String toString() {
//// 		return this.name + "/" + this.age;
//// 	}
//// }
//
//
//@SpringBootApplication
//public class DemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args)
//				.getBean(DemoApplication.class).execute();
//
//
//		// List<Member> names = new ArrayList<>();
//
//		// names.add(new Member());
//		// names.add(new Member("김선비", 18));
//		// names.add(new Member("James", 25));
//
//		// for(Member name : names) {
//		// 	System.out.println(name);
//		// }
//	}
//
//	// @Autowired
//	// Greet greet;
//
//	// private void execute() {
//	// 	greet.greeting();
//
//	// 	greet.showFace();
//	// }
//
//	@Autowired
//	MemberCrudRepository repository;
//
//	private void execute() {
//		executeInsert();
//		executeSelect();
//	}
//
//	private void executeInsert() {
//		Member member = new Member(null, "이순신");
//		member = repository.save(member);
//		System.out.println("등록 데이터: " + member);
//	}
//
//	private void executeSelect() {
//		System.out.println("---- 전체 데이터를 취득합니다. ----");
//		Iterable<Member> members = repository.findAll();
//		for(Member member : members) {
//			System.out.println(member);
//		}
//	}
//}







//package com.example.demo;
//
//import com.example.demo.entity.Member;
//import com.example.demo.lib.ConsoleColor;
//import com.example.demo.repository.MemberCrudRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.InputMismatchException;
//import java.util.Optional;
//import java.util.Scanner;
//
//
//@SpringBootApplication
//public class DemoApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args)
//                .getBean(DemoApplication.class).execute();
//    }
//
//    @Autowired
//    MemberCrudRepository repository;
//
//    private void execute() {
//        Scanner s = new Scanner(System.in);
//        String input;
//        OUT:
//        while(true) {
//            showHelp();
//            System.out.print("명령어: ");
//            input = getUserChoice(s);
//            switch (input) {
//                case "1":
//                    executeSelect();
//                    break;
//                case "2":
//                    executeInsert(s);
//                    executeSelect();
//                    break;
//                case "3":
//                    executeDelete(s);
//                    break;
//                case "4":
//                    executeUpdate(s);
//                    break;
//                case "q":
//                    break OUT;
//                default:
//                    System.out.println(ConsoleColor.ANSI_RED);
//                    System.out.println("잘못된 명령어: " + input);
//                    System.out.println("1, 2, 3, 4 또는 q 만 입력");
//                    System.out.println(ConsoleColor.ANSI_RESET);
//                    break;
//            }
//        }
//
//        s.close();
//    }
//
//    private void showHelp() {
//        System.out.println();
//        System.out.println();
//        System.out.println("사용 방법");
//        System.out.println("=======================");
//        System.out.println("# 1: 리스트");
//        System.out.println("# 2: 입력");
//        System.out.println("# 3: 삭제");
//        System.out.println("# 4: 업데이트");
//        System.out.println("# q: 종료");
//        System.out.println("=======================");
//    }
//
//    private String getUserChoice(Scanner s) {
//        return s.nextLine().toLowerCase();
//    }
//
//    private void executeInsert(Scanner s) {
//        System.out.println("입력할 이름을 입력하세요.");
//        System.out.print("이름: ");
//        String name = s.nextLine();
//        Member member = new Member(null, name);
//        member = repository.save(member);
//        System.out.println(member.getName() + " 이/가 입력되었습니다.");
//    }
//
//    private void executeSelect() {
//        System.out.println("---- 멤버 리스트 ----");
//        Iterable<Member> members = repository.findAll();
//        System.out.println("ID     Name");
//        for(Member member : members) {
//            int id = member.getId();
//            if(id < 10) System.out.printf("%s %8s\n", member.getId(), member.getName());
//            else System.out.printf("%s %7s\n", member.getId(), member.getName());
//        }
//    }
//
//    private void executeDelete(Scanner s) {
//        while(true) {
//            System.out.println("삭제할 ID를 입력하세요(취소: 0).");
//            System.out.print("ID: ");
//            int id = 0;
//            try {
//                id = s.nextInt();
//                s.nextLine();
//                if(id == 0) {
//                    break;
//                }
//                if(repository.existsById(id)) {
//                    Optional<Member> m = repository.findById(id);
//                    if(m.isPresent()) {
//                        Scanner scanner = new Scanner(System.in);
//                        String name = m.get().getName();
//                        System.out.println(name + "을/를 지우시겠습니까?(Y/N)");
//                        String delOk = scanner.nextLine();
//                        if(delOk.equalsIgnoreCase("y")) {
//                            repository.deleteById(id);
//                            System.out.println(name + "을/를 삭제하였습니다.");
//                        } else System.out.println("취소되었습니다.");
//                    }
//                    break;
//                } else
//                    System.out.println(id + "의 데이터가 없습니다.");
//            } catch (InputMismatchException e) {
//                System.out.println(ConsoleColor.ANSI_GREEN);
//                System.out.println("ID만 입력하세요.");
//                System.out.println(ConsoleColor.ANSI_RESET);
//                s.nextLine();
//            }
//        }
//    }
//
//    private void executeUpdate(Scanner s) {
//        while(true) {
//            System.out.println("업데이트할 ID를 입력하세요(취소: 0).");
//            System.out.print("ID: ");
//            int id = 0;
//            try {
//                id = s.nextInt();
//                s.nextLine();
//                if(id == 0) {
//                    break;
//                }
//                if(repository.existsById(id)) {
//                    Optional<Member> m = repository.findById(id);
//                    if(m.isPresent()) {
//                        Scanner scanner = new Scanner(System.in);
//                        System.out.println("변경할 이름을 입력하세요.");
//                        System.out.print("변경할 이름: ");
//                        String changeName = scanner.nextLine();
//                        String name = m.get().getName();
//                        System.out.println(name + "을/를 " + changeName + "으로 변경하시겠습니까?(Y/N)");
//                        String upOk = scanner.nextLine();
//                        if(upOk.equalsIgnoreCase("y")) {
//                            Member changeMember = new Member(id, changeName);
//                            repository.save(changeMember);
//                            System.out.println(name + "을/를 " + changeName + "으로 변경하였습니다.");
//                        } else System.out.println("취소되었습니다.");
//                    }
//                    break;
//                } else
//                    System.out.println(id + "의 데이터가 없습니다.");
//            } catch (InputMismatchException e) {
//                System.out.println(ConsoleColor.ANSI_GREEN);
//                System.out.println("ID만 입력하세요.");
//                System.out.println(ConsoleColor.ANSI_RESET);
//                s.nextLine();
//            }
//        }
//    }
//}


//package com.example.demo;
//
//import java.util.Optional;
//import java.util.Scanner;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import com.example.demo.entity.Member;
//import com.example.demo.repository.MemberCrudRepository;
//
//@SpringBootApplication
//public class DemoApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args).getBean(DemoApplication.class).execute();
//    }
//
//    private void execute() {
//        Scanner s = new Scanner(System.in, "MS949");
//        String input = "";
//
//        OUT:
//        while(true) {
//            showHelp();
//            System.out.print("명령어: ");
//            input = s.nextLine().toLowerCase();
//
//            switch(input) {
//                case "1":
//                    executeSelect();
//                    break;
//                case "2":
//                    executeInsert(s);
//                    executeSelect();
//                    break;
//                case "3":
//                    executeDelete(s);
//                    executeSelect();
//                    break;
//                case "4":
//                    executeUpdate(s);
//                    executeSelect();
//                    break;
//                case "q":
//                    break OUT;
//            }
//        }
//
//        s.close();
//    }
//
//    private void showHelp() {
//        System.out.println();
//        System.out.println();
//        System.out.println("사용 방법");
//        System.out.println("=======================");
//        System.out.println("# 1: 리스트");
//        System.out.println("# 2: 입력");
//        System.out.println("# 3: 삭제");
//        System.out.println("# 4: 업데이트");
//        System.out.println("# q: 종료");
//        System.out.println("=======================");
//    }
//
//    @Autowired
//    MemberCrudRepository repository;
//
//    private void executeSelect() {
//        System.out.println("----------");
//        Iterable<Member> members = repository.findAll();
//        System.out.println("ID     Name");
//        for(Member m : members) {
//            System.out.printf("%d %5s%n", m.getId(), m.getName());
//        }
//    }
//
//    private void executeInsert(Scanner s) {
//        System.out.print("이름: ");
//        String name = s.nextLine();
//        Member m = new Member(null, name);
//        m = repository.save(m);
//        System.out.println(m.getName() + "을 저장했습니다.");
//    }
//
//    private void executeDelete(Scanner s) {
//        System.out.print("삭제 ID: ");
//
//        try {
//            String id = s.nextLine();
//            int intId = Integer.valueOf(id);
//            if(repository.existsById(intId)) {
//                repository.deleteById(intId);
//            } else {
//                System.out.println("삭제할 내용 없음.");
//            }
//        } catch(Exception e) {
//            System.out.println("숫자만 입력해주세요.");
//        }
//
//    }
//
//    private void executeUpdate(Scanner s) {
//        System.out.print("업데이트 ID: ");
//        int id = s.nextInt();
//        s.nextLine();
//        if(repository.existsById(id)) {
//            Optional<Member> m = repository.findById(id);
//            if(m.isPresent()) {
//                Member member = (Member)m.get();
//                System.out.print(member.getName() + "을 수정할 이름: ");
//                String newName = s.nextLine();
//                Member newMember = new Member(id, newName);
//                repository.save(newMember);
//            }
//        } else {
//            System.out.println("없는 아이디");
//        }
//    }
//}




//package com.example.demo;
//
//import com.example.demo.entity.Member;
//import com.example.demo.repository.MemberCrudRepository;
//import com.example.demo.repository.MemberPagingAndSortingRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//
//import java.util.InputMismatchException;
//import java.util.Optional;
//import java.util.Scanner;
//
//
//@SpringBootApplication
//public class DemoApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args)
//                .getBean(DemoApplication.class).execute();
//    }
//
//    @Autowired
//    MemberCrudRepository repository;
//
//    @Autowired
//    MemberPagingAndSortingRepository pagingAndSortingRepository;
//
//    private void execute() {
//        Scanner s = new Scanner(System.in, "MS949");
//        String input;
//
//        OUT:
//        while(true) {
//            showHelp();
//            System.out.print("명령어: ");
//            input = getUserChoice(s);
//            switch (input) {
//                case "1":
//                    executeSelect(s);
//                    break;
//                case "2":
//                    executeInsert(s);
//                    executeSelect(s);
//                    break;
//                case "3":
//                    executeDelete(s);
//                    break;
//                case "4":
//                    executeUpdate(s);
//                    break;
//                case "5":
//                    executeSearch(s);
//                    break;
//                case "q":
//                    break OUT;
//                default:
//                    System.out.println("잘못된 명령어: " + input);
//                    System.out.println("1, 2, 3, 4 또는 q 만 입력");
//                    break;
//            }
//        }
//
//        s.close();
//    }
//
//    private void showHelp() {
//        System.out.println();
//        System.out.println();
//        System.out.println("사용 방법");
//        System.out.println("=======================");
//        System.out.println("# 1: 리스트");
//        System.out.println("# 2: 입력");
//        System.out.println("# 3: 삭제");
//        System.out.println("# 4: 업데이트");
//        System.out.println("# 5: 검색");
//        System.out.println("# q: 종료");
//        System.out.println("=======================");
//    }
//
//    private String getUserChoice(Scanner s) {
//        return s.nextLine().toLowerCase();
//    }
//
//    private void executeInsert(Scanner s) {
//        System.out.println("입력할 이름을 입력하세요.");
//        System.out.print("이름: ");
//        String name = s.nextLine();
//        Member member = new Member(null, name.replaceAll("\u0000", ""));
//        member = repository.save(member);
//        System.out.println(member.getName() + " 이/가 입력되었습니다.");
//    }
//
//    private void executeSelect(Scanner s) {
//        System.out.println("---- 멤버 리스트 ----");
//        //단순 선택
//        // Iterable<Member> members = repository.findAll();
//
//        //정렬 선택
//        // Iterable<Member> members = repository.sortById();
//        // showMember(members);
//
//        //페이징 정렬 선택
//        int start = 0;
//        final int pagePerRows = 10;
//        long total = repository.count();
//        int lastPage = getLastPage(total, pagePerRows);
//
//        OUT:
//        while(true) {
//            Page<Member> members = pagingAndSortingRepository.findAll(PageRequest.of(start, pagePerRows, Sort.by("id").ascending()));
//
//            dispaly(members, total, start, lastPage);
//
//            switch (s.nextInt()) {
//                case 1:
//                    start = --start > 0 ? start : 0;
//                    break;
//                case 2:
//                    start = ++start < lastPage - 1 ? start : lastPage - 1;
//                    break;
//                case 3:
//                    break OUT;
//                default:
//                    System.out.println("잘못된 명령어");
//            }
//        }
//
//        s.nextLine();
//    }
//
//    private int getLastPage(long total, int pagePerRows) {
//        return (int)((total / pagePerRows) + (total % pagePerRows > 0 ? 1 : 0));
//    }
//
//    private void dispaly(Page<Member> members, long total, int start, int lastPage) {
//
//        showMember(members);
//
//        System.out.println();
//        System.out.printf("현재페이지/전체페이지: %d/%d%n", start + 1, lastPage);
//        System.out.println("총 레코드 수: " + total);
//        System.out.println("1. 이전\t2. 다음\t3. 종료");
//        System.out.print("페이지 명령: ");
//    }
//
//    private void executeDelete(Scanner s) {
//        while(true) {
//            System.out.println("삭제할 ID를 입력하세요(취소: 0).");
//            System.out.print("ID: ");
//            int id = 0;
//            try {
//                id = s.nextInt();
//                s.nextLine();
//                if(id == 0) {
//                    break;
//                }
//                if(repository.existsById(id)) {
//                    Optional<Member> m = repository.findById(id);
//                    if(m.isPresent()) {
//                        Scanner scanner = new Scanner(System.in, "MS949");
//                        String name = m.get().getName();
//                        System.out.println(name + "을/를 지우시겠습니까?(Y/N)");
//                        String delOk = scanner.nextLine();
//                        if(delOk.equalsIgnoreCase("y")) {
//                            repository.deleteById(id);
//                            System.out.println(name + "을/를 삭제하였습니다.");
//                        } else System.out.println("취소되었습니다.");
//                    }
//                    break;
//                } else
//                    System.out.println(id + "의 데이터가 없습니다.");
//            } catch (InputMismatchException e) {
//                System.out.println("ID만 입력하세요.");
//                s.nextLine();
//            }
//        }
//    }
//
//    private void executeUpdate(Scanner s) {
//        while(true) {
//            System.out.println("업데이트할 ID를 입력하세요(취소: 0).");
//            System.out.print("ID: ");
//            int id = 0;
//            try {
//                id = s.nextInt();
//                s.nextLine();
//                if(id == 0) {
//                    break;
//                }
//                if(repository.existsById(id)) {
//                    Optional<Member> m = repository.findById(id);
//                    if(m.isPresent()) {
//                        Scanner scanner = new Scanner(System.in, "MS949");
//                        System.out.println("변경할 이름을 입력하세요.");
//                        System.out.print("변경할 이름: ");
//                        String changeName = scanner.nextLine();
//                        String name = m.get().getName();
//                        System.out.println(name + "을/를 " + changeName + "으로 변경하시겠습니까?(Y/N)");
//                        String upOk = scanner.nextLine();
//                        if(upOk.equalsIgnoreCase("y")) {
//                            Member changeMember = new Member(id, changeName.replaceAll("\u0000", ""));
//                            repository.save(changeMember);
//                            System.out.println(name + "을/를 " + changeName + "으로 변경하였습니다.");
//                        } else System.out.println("취소되었습니다.");
//                    }
//                    break;
//                } else
//                    System.out.println(id + "의 데이터가 없습니다.");
//            } catch (InputMismatchException e) {
//                System.out.println("ID만 입력하세요.");
//                s.nextLine();
//            }
//        }
//    }
//
//    private void executeSearch(Scanner s) {
//        System.out.println("검색어를 입력하세요(취소: 0).");
//        System.out.print("검색어: ");
//        String key = s.nextLine();
//
//        Iterable<Member> members = repository.searchByName(key);
//
//        showMember(members);
//    }
//
//    private void showMember(Iterable<Member> members) {
//        System.out.println("ID     Name");
//        for(Member member : members) {
//            int id = member.getId();
//            if(id < 10) System.out.printf("%d %8s\n", member.getId(), member.getName());
//            else System.out.printf("%d %7s\n", member.getId(), member.getName());
//        }
//    }
//}