package model;

public class Medical {
    private int id;
    private String name;
    private String birthday;
    private Integer gender;
    private String nationality;
    private String identityCard;
    private String travelInfo;
    private String idVehicle;
    private String idSeat;
    private String startDate;
    private String endDate;
    private String address;
    private String phone;
    private String email;
    private String[] symptom;
    private String[] exposureHistory;

    public Medical() {
    }

    public Medical(int id, String name, String birthday, Integer gender, String nationality, String identityCard, String travelInfo, String idVehicle, String idSeat, String startDate, String endDate, String address, String phone, String email, String[] symptom, String[] exposureHistory) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.nationality = nationality;
        this.identityCard = identityCard;
        this.travelInfo = travelInfo;
        this.idVehicle = idVehicle;
        this.idSeat = idSeat;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptom = symptom;
        this.exposureHistory = exposureHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(String travelInfo) {
        this.travelInfo = travelInfo;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(String idSeat) {
        this.idSeat = idSeat;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSymptom() {
        return symptom;
    }

    public void setSymptom(String[] symptom) {
        this.symptom = symptom;
    }

    public String[] getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(String[] exposureHistory) {
        this.exposureHistory = exposureHistory;
    }
}
