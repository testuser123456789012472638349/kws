package sec12;

/**
 * 멀티 테스킹 - 병행 처리
 *
 * 프로세스: 실행 중인 독립적인 프로그램 - 운영체제 관리
 * 스레드: 프로세스의 최소 작업단위 - 하나의 프로그램에서 관리
 */

import java.awt.Toolkit;


public class _info {
    public static void main(String[] args) {
        // Toolkit toolkit = Toolkit.getDefaultToolkit();
        // toolkit.beep();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++) {
                    System.out.print("삐");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                }
            }
        });
        thread.start();

        Thread thread2 = new BeepTask2();
        thread2.start();

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++) {
                    System.out.print("땅");
                    // try {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                    // } catch(Exception e) {}
                }
            }
        };
        thread3.start();

        for(int i = 0; i < 5; i++) {
            System.out.print("띵");
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class BeepTask implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.print("삐");
            // try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
            // } catch(Exception e) {}
        }
    }
}

class BeepTask2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.print("뿡");
            // try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
            // } catch(Exception e) {}
        }
    }
}

//----------------------------------------------------------

class ThreadName {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());

        ThreadA threadA = new ThreadA();
        System.out.println("작업 스레드 이름: " + threadA.getName());
        threadA.start();

        ThreadB threadB = new ThreadB();
        System.out.println("작업 스레드 이름: " + threadB.getName());
        threadB.start();
    }
}

class ThreadA extends Thread {
    ThreadA() {
        setName("ThreadA");
    }

    @Override
    public void run() {
        for(int i = 0; i < 2; i++) {
            System.out.println(getName() + "가 출력한 내용");
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 2; i++) {
            System.out.println(getName() + "가 출력한 내용");
        }
    }
}


//---------------------------------------------------
//1. User를 하나로 변경
//2. Calculator를 인터페이스를 사용으로 변경
class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    public synchronized void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch(Exception e) {}
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }
}

class User1 extends Thread {
    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.setName("User1");
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(100);
    }
}

class User2 extends Thread {
    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.setName("User2");
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(50);
    }
}

class MainThreadExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        User1 user1 = new User1();
        user1.setCalculator(calculator);
        user1.start();

        User2 user2 = new User2();
        user2.setCalculator(calculator);
        user2.start();
    }
}


//------------------------------------------------
//우선순위
// 실행되기 전에 지정
// 한 번 사용한 쓰레드는 두 번 사용 못함.
class Priority {
    public static void main(String[] args) {
        DrawLine drawLine1 = new DrawLine('-');
        drawLine1.setPriority(Thread.MAX_PRIORITY);
        DrawLine drawLine2 = new DrawLine('|');
        // drawLine2.setPriority(Thread.MAX_PRIORITY);

        drawLine1.start();
        drawLine2.start();

        // drawLine1 = new DrawLine('1');
    }
}

class DrawLine extends Thread {
    char line;
    boolean stop;

    DrawLine(char line) {
        this.line = line;
        if(line == '-') {
            System.out.println("우선순위 기본 값: 5");
            System.out.println("우선순위 최고 값: " + MAX_PRIORITY);
            System.out.println("우선순위 최소 값: " + MIN_PRIORITY);
        }
    }
    @Override
    public void run() {
        while(!stop) {
            System.out.println(getName() + ": " + getPriority());
            // tsleep(500);
            for(int i = 0; i < 10; i++) {
                System.out.print(line);
                // tsleep(500);
                for(long j = 0; j < 100L; j++) {
                    // System.out.println(stop);
                    if(j == 50) stop = true;
                }

                if(stop) {
                    break;
                }
            }
        }
    }

    static void tsleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException e) {}
    }
}

//----------------------------
// interrupt()
class InterruptExample {
    public static void main(String[] args) {
        PrintThread2 printThread2 = new PrintThread2();
        printThread2.setDaemon(true);
        printThread2.start();

        DrawLine.tsleep(1000); //main 1초 sleep

        // printThread2.interrupt();
        System.out.println("END Main");
    }
}

class PrintThread2 extends Thread {
    @Override
    public void run() {
        // try {
        while(true) {
            System.out.println("실행 중");
            DrawLine.tsleep(1000);
            // Thread.sleep(1);
            if(Thread.interrupted()) {
                break;
            }
        }
        // } catch(InterruptedException e) {}


        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}