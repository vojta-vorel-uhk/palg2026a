package palg.Cviko01;

public class Car {
    private String type = "VW Touran";
    private int drivingProblemsCount = 10;

    public int GetDrivingProblemsCount(){
        return drivingProblemsCount;
    }

    public void SetDrivingProblemsCount(int value){
        drivingProblemsCount = value;
    }

    @Override
    public String toString() {
        return type + " with "+drivingProblemsCount+" problems";
    }
}
