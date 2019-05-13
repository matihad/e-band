package mahdihadian.gholhak.ehealth.Utils;

public class UserModel {
    private String name, status;
    private int age;
    private double heartBeat, bloodPressure;


    public UserModel() {
    }

    public UserModel(String name, String status, int age, double heartBeat, double bloodPressure) {
        this.name = name;
        this.status = status;
        this.age = age;
        this.heartBeat = heartBeat;
        this.bloodPressure = bloodPressure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(double heartBeat) {
        this.heartBeat = heartBeat;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }


}
