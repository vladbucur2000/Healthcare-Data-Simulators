package com.healthcare.team.BashProcess;

import com.healthcare.team.BashProcess.Compute;
import com.healthcare.team.InitialSetup;
import org.apache.commons.io.FileUtils;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ComputeTest {
    private Compute compute;

    /*
        this class ensures no JOptionPanes are created
         which require user input to continue, hence, Tests pass.
    */
   public static class ComputeWithNoJOptionPane extends Compute {
        public ComputeWithNoJOptionPane(String population, String minAge,
                                        String maxAge, String gender,
                                        String module, String state) {
            super(population, minAge, maxAge, gender, module, state);
        }

        @Override
        protected void alertUser() {}

        @Override
        protected void informUser() {}
    }

    @BeforeClass
    public static void beforeClass() {
        //extract files first before running any test
        InitialSetup initialSetup = new InitialSetup();
        initialSetup.setup();
    }

    @AfterClass
    public static void afterClass() throws IOException {
        File file = new File("lib");
        Assert.assertTrue(file.exists() && file.isDirectory());
        FileUtils.deleteDirectory(file);
        Assert.assertFalse(new File("lib").exists());
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testEmptyPopulationShouldThrow() {
        compute = new Compute(
                "",
                "0",
                "1",
                "female",
                "Lupus",
                "Angus"
        );
        compute.generatePatient();
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testEmptyMinAgeShouldThrow() {
        compute = new Compute(
                "1",
                "",
                "1",
                "female",
                "Lupus",
                "Angus"
        );
        compute.generatePatient();
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testEmptyMaxAgeShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "",
                "female",
                "Lupus",
                "Angus"
        );
        compute.generatePatient();
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testEmptyGenderShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "1",
                "",
                "Lupus",
                "Angus"
        );
        compute.generatePatient();
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testEmptyModuleShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "1",
                "female",
                "",
                "Angus"
        );
        compute.generatePatient();
    }

    @Test(expected = IllegalArgumentException.class, timeout = 30000)
    public void testEmptyStateShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "1",
                "female",
                "Lupus",
                ""
        );
    }

    @Test(expected = NullPointerException.class, timeout = 15000)
    public void testNullPopulationShouldThrow() {
        compute = new Compute(
                null,
                "0",
                "1",
                "female",
                "Lupus",
                "Angus"
        );
    }

    @Test(expected = NullPointerException.class, timeout = 15000)
    public void testNullMinAgeShouldThrow() {
        compute = new Compute(
                "1",
                null,
                "1",
                "female",
                "Lupus",
                "Angus"
        );
    }

    @Test(expected = NullPointerException.class, timeout = 15000)
    public void testNullMaxAgeShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                null,
                "female",
                "Lupus",
                "Angus"
        );
    }

    @Test(expected = NullPointerException.class, timeout = 15000)
    public void testNullGenderShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "1",
                null,
                "Lupus",
                "Angus"
        );
    }

    @Test(expected = NullPointerException.class, timeout = 15000)
    public void testNullModuleShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "1",
                "female",
                null,
                "Angus"
        );
    }

    @Test(expected = NullPointerException.class, timeout = 15000)
    public void testNullStateShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "1",
                "female",
                "Lupus",
                null
        );
    }


    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testImpossiblePopulationShouldThrow() {
        compute = new Compute(
                "happy",
                "0",
                "1",
                "female",
                "Lupus",
                "Angus"
        );
        compute.generatePatient();
        compute = new Compute(
                "-1",
                "0",
                "1",
                "female",
                "Lupus",
                "Angus"
        );
        compute.generatePatient();
        compute = new Compute(
                "10000",
                "0",
                "1",
                "female",
                "Lupus",
                "Angus"
        );
        compute.generatePatient();
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testImpossibleMinAgeShouldThrow() {
        compute = new Compute(
                "1",
                "-6",
                "1",
                "female",
                "Lupus",
                "Angus"
        );
        compute.generatePatient();
        compute = new Compute(
                "1",
                "happy",
                "1",
                "female",
                "Lupus",
                "Angus"
        );
        compute.generatePatient();
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testImpossibleMaxAgeShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "201",
                "female",
                "Lupus",
                "Shropshire"
        );
        compute = new Compute(
                "1",
                "0",
                "happy",
                "female",
                "Lupus",
                "Shropshire"
        );
        compute = new Compute(
                "1",
                "0",
                "-1",
                "female",
                "Lupus",
                "Shropshire"
        );
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testImpossibleGenderShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "1",
                "R",
                "Allergic_Rhinitis",
                "Shropshire"
        );
        compute.generatePatient();
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testImpossibleModuleShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "1",
                "female",
                "coding",
                "Shropshire"
        );
        compute.generatePatient();
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void testImpossibleStateShouldThrow() {
        compute = new Compute(
                "1",
                "0",
                "1",
                "female",
                "Lupus",
                "California"
        );
    }

    @Test(timeout = 100000)
    public void testAllCorrectValuesShouldPass() {
        ComputeWithNoJOptionPane computeWithNoJOptionPane = new ComputeWithNoJOptionPane(
                "1",
                "0",
                "1",
                "male",
                "Allergic_Rhinitis",
                "Somerset"
        );
        assertEquals(computeWithNoJOptionPane.getPopulation(), "1");
        assertEquals(computeWithNoJOptionPane.getMinAge(), "0");
        assertEquals(computeWithNoJOptionPane.getMaxAge(), "1");
        assertEquals(computeWithNoJOptionPane.getGender(), "male");
        assertEquals(computeWithNoJOptionPane.getModule(), "Allergic_Rhinitis");
        assertEquals(computeWithNoJOptionPane.getStateSynthea(), "Somerset");
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void maxAgeSmallerThanMinAge() {
        compute = new Compute(
                "1",
                "22",
                "11",
                "female",
                "Lupus",
                "Angus"
        );
    }

    @Test(expected = IllegalArgumentException.class, timeout = 15000)
    public void maxPopulation() {
        compute = new Compute(
                "100000",
                "11",
                "12",
                "female",
                "Lupus",
                "Angus"
        );
    }

    @Test(timeout = 10000)
    public void checkProcessParameters() {
        ComputeWithNoJOptionPane computeWithNoJOptionPane = new ComputeWithNoJOptionPane(
                "1",
                "0",
                "1",
                "male",
                "Allergic_Rhinitis",
                "Somerset"
        );
        String region = computeWithNoJOptionPane.getStateSynthea();
        String syntheaParams = new StringBuilder().append(" -p ").append(computeWithNoJOptionPane.getPopulation()).append(" -g ")
                .append(computeWithNoJOptionPane.getGender().equals("male") ? "M" : "F").append(" -a ")
                .append(computeWithNoJOptionPane.getMinAge()).append("-").append(computeWithNoJOptionPane.getMaxAge()).append(" -m ")
                .append(computeWithNoJOptionPane.getModule()).append(" ").append(region).toString();
        String command = new StringBuilder("java -jar ./lib/synthea-with-dependencies.jar")
                .append(syntheaParams)
                .append(" --exporter.baseDirectory ./Regions/")
                .append(region)
                .append(" --exporter.csv.export true").toString();
        List<String> actual = computeWithNoJOptionPane.processParameters(region);
        assertThat(actual, hasItems("-c"));
        assertThat(actual, hasSize(3));
        assertThat(actual, contains("bash", "-c", command));
        assertThat(actual, not(IsEmptyCollection.empty()));
    }

    @Test
    public void checkShowAlertDialogInSpecificCondition() {
        ComputeWithNoJOptionPane computeWithNoJOptionPane = new ComputeWithNoJOptionPane(
                "100",
                "18",
                "39",
                "female",
                "Food_Allergies",
                "Gloucestershire"
        );
        assertTrue(computeWithNoJOptionPane.showAlert("   "));
        assertTrue(computeWithNoJOptionPane.showAlert(null));
        assertTrue(computeWithNoJOptionPane.showAlert("Usage: do it!"));
        assertFalse(computeWithNoJOptionPane.showAlert("some string here"));
    }
}
