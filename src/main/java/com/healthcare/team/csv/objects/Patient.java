package com.healthcare.team.csv.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.healthcare.team.Anonymization.Anonymization;
import java.util.TreeMap;

public class Patient extends CsvPojo{

    @JsonProperty("Id")
    private String id;
    @JsonProperty("SSN")
    private String ssn;
    @JsonProperty("BIRTHDATE")
    private String birthDate;
    @JsonProperty("DEATHDATE")
    private String deathDate;
    @JsonProperty("DRIVERS")
    private String drivers;
    @JsonProperty("PASSPORT")
    private String passport;
    @JsonProperty("PREFIX")
    private String prefix;
    @JsonProperty("FIRST")
    private String first;
    @JsonProperty("LAST")
    private String last;
    @JsonProperty("SUFFIX")
    private String suffix;
    @JsonProperty("MAIDEN")
    private String maiden;
    @JsonProperty("MARITAL")
    private String marital;
    @JsonProperty("RACE")
    private String race;
    @JsonProperty("ETHNICITY")
    private String ethnicity;
    @JsonProperty("GENDER")
    private String gender;
    @JsonProperty("BIRTHPLACE")
    private String birthplace;
    @JsonProperty("ADDRESS")
    private String address;
    @JsonProperty("CITY")
    private String city;
    @JsonProperty("STATE")
    private String state;
    @JsonProperty("COUNTY")
    private String county;
    @JsonProperty("ZIP")
    private String zip;
    @JsonProperty("LAT")
    private String lat;
    @JsonProperty("LON")
    private String lon;
    @JsonProperty("HEALTHCARE_EXPENSES")
    private String healthcareExpenses;
    @JsonProperty("HEALTHCARE_COVERAGE")
    private String healthcareCoverage;


    public Patient(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getDrivers() {
        return drivers;
    }

    public void setDrivers(String drivers) {
        this.drivers = drivers;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getMaiden() {
        return maiden;
    }

    public void setMaiden(String maideN) {
        this.maiden = maiden;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getHealthcareExpenses() {
        return healthcareExpenses;
    }

    public void setHealthcareExpenses(String healthcareExpenses) {
        this.healthcareExpenses = healthcareExpenses;
    }

    public String getHealthcareCoverage() {
        return healthcareCoverage;
    }

    public void setHealthcareCoverage(String healthcareCoverage) {
        this.healthcareCoverage = healthcareCoverage;
    }

    @Override
    public String toString() {

        TreeMap<String, String> map = new TreeMap<>();
        map.put("NHSNumber", id);

        return Patient.class.getCanonicalName() + ": " +
                "Id='" + Anonymization.mask(map) + '\'' +
                "| ssn='" + ssn + '\'' +
                "| birthDate='" + birthDate + '\'' +
                "| deathDate='" + deathDate + '\'' +
                "| drivers='" + drivers + '\'' +
                "| passport='" + passport + '\'' +
                "| prefix='" + prefix + '\'' +
                "| first='" + first + '\'' +
                "| last='" + last + '\'' +
                "| suffix='" + suffix + '\'' +
                "| maiden='" + maiden + '\'' +
                "| marital='" + marital + '\'' +
                "| race='" + race + '\'' +
                "| ethnicity='" + ethnicity + '\'' +
                "| gender='" + gender + '\'' +
                "| birthplace='" + birthplace + '\'' +
                "| address='" + address + '\'' +
                "| city='" + city + '\'' +
                "| state='" + state + '\'' +
                "| county='" + county + '\'' +
                "| zip='" + zip + '\'' +
                "| lat='" + lat + '\'' +
                "| lon='" + lon + '\'' +
                "| healthcareExpenses='" + healthcareExpenses + '\'' +
                "| healthcareCoverage='" + healthcareCoverage + '\'';
    }

    public String toCsvString() {
       return Anonymization.mask(buildAnonymizeMap()) + ',' +
                birthDate + ',' +
                deathDate + ',' +
                ssn + ',' +
                drivers + ',' +
                passport + ',' +
                prefix + ',' +
                first + ',' +
                last + ',' +
                suffix + ',' +
               (maiden != null ? maiden : "")+ ',' +
                marital + ',' +
                race + ',' +
                ethnicity + ',' +
                gender + ',' +
                birthplace + ',' +
                address + ',' +
                city + ',' +
                state + ',' +
                county + ',' +
                zip + ',' +
                lat + ',' +
                lon + ',' +
                healthcareExpenses + ',' +
                healthcareCoverage;
    }

    @Override
    public String getHeaderColumnNames() {
        return "Id,BIRTHDATE,DEATHDATE,SSN,DRIVERS,PASSPORT,PREFIX,FIRST,LAST,SUFFIX,MAIDEN,MARITAL,RACE,ETHNICITY,GENDER,BIRTHPLACE,ADDRESS,CITY,STATE,COUNTY,ZIP,LAT,LON,HEALTHCARE_EXPENSES,HEALTHCARE_COVERAGE ";
    }

    private TreeMap<String, String> buildAnonymizeMap() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("NHSNumber", id);
        return map;
    }
}
