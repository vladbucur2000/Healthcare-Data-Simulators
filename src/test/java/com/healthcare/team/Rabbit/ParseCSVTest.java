package com.healthcare.team.Rabbit;

import com.healthcare.team.Rabbit.ParseCSV;
import com.healthcare.team.csv.objects.Patient;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseCSVTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test(expected = RuntimeException.class)
    public void ifWrongRegionThrowErrorWhenReadCsv() {
        new ParseCSV().readPatientsFile("Bucharest", Patient.class);
    }

    @Test(expected = RuntimeException.class)
    public void ifEmptyFileThrowError (){
        try {
            File file = testFolder.newFile("testFile.csv");
            new ParseCSV().readPatientsFile(file.getAbsolutePath(), Patient.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parseCSVWithSuccess(){
        try {
            File file = testFolder.newFile("testFile.csv");
            List<String[]> dataLines = new ArrayList<>();
            dataLines.add(new Patient().getHeaderColumnNames().split(","));

            dataLines.add(new String[]
                    { "45464-234234-342342-444-sad-2ede", "", "", "19", "", "","",
                            "John", "Doe", "", "", "no", "green", "", "other", "", "NY", "5th", "","", "","","", "888", "88" });

            try (PrintWriter pw = new PrintWriter(file)) {
                dataLines.stream()
                        .map(this::convertToCSV)
                        .forEach(pw::println);
            }
            String anonymizedData = new ParseCSV().readPatientsFile(file.getAbsolutePath(), Patient.class);
            assertEquals("com.healthcare.team.csv.objects.Patient: Id='12387D6B953EC62C88E85EEAA2089406ABFD7E2E93FB3E4BEAA8F6BD1E0B6335'| ssn='19'| birthDate=''| deathDate=''| drivers=''| passport=''| prefix=''| first='John'| last='Doe'| suffix=''| maiden='null'| marital='no'| race='green'| ethnicity=''| gender='other'| birthplace=''| address='NY'| city='5th'| state=''| county=''| zip=''| lat=''| lon=''| healthcareExpenses='888'| healthcareCoverage='88'", anonymizedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .collect(Collectors.joining(","));
    }
}
