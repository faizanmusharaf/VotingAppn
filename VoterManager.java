package VotingAppn;
public class VoterManager {
    private VoterIdApp[] voters;
    private int count = 0;

    private static final int MAX_REQUESTS = 50;

    int requestCount = 0;


    private DemographicChangeRequest[] changeRequests;


    public VoterManager() {
        voters = new VoterIdApp[50];
        changeRequests = new DemographicChangeRequest[MAX_REQUESTS];

    }

    public int getVoterCount() {
        return count;
    }

    // Method to add a voter, checks credentials first
    public void addVoter(String epicNo, String name, int age, String gender) {
            if (count < voters.length) {
                voters[count] = new VoterIdApp(epicNo, name, age, gender);
                count++;
                System.out.println("Voter added successfully!");
            } else {
                System.out.println("Voter array is full.");
            }
    }


    public void submitDemographicChangeRequest(String epicNo, String newName){
            boolean voterFound = false;
            for(int i= 0; i< count; i++){
                if(voters[i].getEpicNo().equals(epicNo)){
                    voterFound = true;
                    if(requestCount < changeRequests.length){
                        changeRequests[requestCount] = new DemographicChangeRequest(epicNo, newName);
                            requestCount++;
                        System.out.println("Request Submitted for EPIC No: " + epicNo);
                    }else{
                        System.out.println("Request Array is full");
                    }break;
                }
            }
            if(!voterFound){
                System.out.println("Voter Not found for EPIC No: " + epicNo);
            }
    }

    public void approveOrDenyRequests(int requestIndex, boolean approve){
        if(requestIndex<0 || requestIndex >=requestCount){
            System.out.println("Invalid Request Number");
            return;
        }
        DemographicChangeRequest request = changeRequests[requestIndex];
        if(approve){
            for(int i = 0; i<count; i++){
                if(voters[i].getEpicNo().equals(request.getEpicNo())){
                    voters[i].setName(request.getNewName());
                    System.out.println("Request approved, Voter Name approved");
                }
            }
        }else {
            System.out.println("Request Denied");
        }
        // Shift remaining requests to fill the gap
        for (int i = requestIndex; i < requestCount - 1; i++) {
            changeRequests[i] = changeRequests[i + 1];
        }
        //changeRequests[requestCount - 1] = null;
        requestCount--;
    }

    public void viewDemographicChangeRequests() {
        if (requestCount == 0) {
            System.out.println("No demographic change requests.");
            return;
        }
        for (int i = 0; i < requestCount; i++) {
            System.out.println("Request " + (i + 1) + ": " + changeRequests[i]);
        }
    }

    public void checkRequestStatus(String epicNo) {
        // Check pending requests first
        for (int i = 0; i < requestCount; i++) {
            if (changeRequests[i].getEpicNo().equals(epicNo)) {
                System.out.println("Your request for EPIC No: " + epicNo + " is still pending.");
                return;
            }
        }

        // Check if the request has been approved in the voter list
        for (int i = 0; i < count; i++) {
            if (voters[i].getEpicNo().equals(epicNo)) {
                System.out.println("Your demographic change request for EPIC No: " + epicNo + " has been approved.");
                return;
            }
        }

        // If no request was found
        System.out.println("No request found for EPIC No: " + epicNo + ".");
    }

    public static boolean isVoterPresent(String epicNo, VoterIdApp[] voters, int voterCount) {
        for (int i = 0; i < voterCount; i++) {
            if (voters[i].getEpicNo().equals(epicNo)) {
                return true;
            }
        }
        return false;
    }

    // Method to display all voters
    public void displayVoters() {
        for (int i = 0; i < count; i++) {
            voters[i].display();
        }
    }

    public VoterIdApp[] getVoters() {
        return voters;
    }

}

