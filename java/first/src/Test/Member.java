package Test;

public class Member {
    public String id;
    public int number;

    public Member(String id) {
        this.id = id;
    }

    public Member(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member) {
            Member member = (Member) obj;
            if(id.equals(member.id)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj instanceof Member) {
//            Member compareKey = (Member) obj;
//            if(this.number == compareKey.number) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return number;
//    }
}

