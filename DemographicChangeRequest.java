package VotingAppn;
public class DemographicChangeRequest {

    private String epicNo;
    private String newName;


    public DemographicChangeRequest(String epicNo, String newName){
            this.epicNo = epicNo;
            this.newName = newName;
    }

    public String getEpicNo() {
        return epicNo;
    }

    public String getNewName() {
        return newName;
    }

    @Override
    public String toString() {
        return "DemographicChangeRequest{" +
                "epicNo='" + epicNo + '\'' +
                ", newName='" + newName + '\'' +
                '}';
    }
}
