package VotingAppn;
public class VoterIdApp {
    private String epicNo;
    private String name;
    private int age;
    private String gender;
    private String status;


    public VoterIdApp(String epicNo, String name, int age, String gender) {
        this.epicNo = epicNo;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public void display() {
        System.out.println("Epic No: " + getEpicNo());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
    }

    public String getEpicNo() {
        return epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VoterIdApp{" +
                "epicNo='" + epicNo + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}