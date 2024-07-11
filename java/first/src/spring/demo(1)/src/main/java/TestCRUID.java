//import com.example.demo.entity.Member;
//import com.example.demo.lib.ConsoleColor;
//import com.example.demo.repository.MemberCrudRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.InputMismatchException;
//import java.util.Optional;
//import java.util.Scanner;
//
//
//
//public class TestCRUID {
//
//    public static void main(String[] args) {
////        SpringApplication.run(DemoApplication.class, args)
////                .getBean(DemoApplication.class).execute();
//    }
//
//    @Autowired
//    MemberCrudRepository repository;
//
//    private void execute() {
//        Scanner s = new Scanner(System.in, "UTF-8");
//        String input;
//
//        System.out.print("한글테스트: ");
//        input = s.nextLine();
//        System.out.println(input);
//
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
//        Member member = new Member(null, name.replaceAll("\u0000", ""));
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
//                        Scanner scanner = new Scanner(System.in, "UTF-8");
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
//                        Scanner scanner = new Scanner(System.in, "UTF-8");
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
//                System.out.println(ConsoleColor.ANSI_GREEN);
//                System.out.println("ID만 입력하세요.");
//                System.out.println(ConsoleColor.ANSI_RESET);
//                s.nextLine();
//            }
//        }
//    }
//}