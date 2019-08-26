package com.mahdi.assignment.paymentplan;

import com.mahdi.assignment.paymentplan.conroller.PaymentPlanController;
import com.mahdi.assignment.paymentplan.model.Annuity;
import com.mahdi.assignment.paymentplan.model.LoanCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PaymentPlanControllerTest {

    @Autowired
    PaymentPlanController paymentPlanController;

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;




    @Test
    public void calculatePlanWithZeroNominalRate() throws Exception {
        Date startDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse("2018-01-01T00:00:01Z");
        LoanCondition loanCondition = new LoanCondition(5000f,0.0f,5,startDate);

        String sampleInputJSON="{\n" +
                "\"loanAmount\": 5000,\n" +
                "\"nominalRate\": \"0.00\",\n" +
                "\"duration\": 5,\n" +
                "\"startDate\": \"2018-01-01T00:00:01Z\"\n" +
                "}";

        List<Annuity> mockResult = Arrays.asList(
                                                new Annuity("1000",
                                                         addSpecificMonth(startDate,0),
                                                        "5000",
                                                        "0",
                                                        "1000",
                                                        "4000"),
                                                new Annuity("1000",
                                                        addSpecificMonth(startDate,1),
                                                        "4000",
                                                        "0",
                                                        "1000",
                                                        "3000"),
                                                new Annuity("1000",
                                                        addSpecificMonth(startDate,2),
                                                        "3000",
                                                        "0",
                                                        "1000",
                                                        "2000"),
                                                new Annuity("1000",
                                                        addSpecificMonth(startDate,3),
                                                        "2000",
                                                        "0",
                                                        "1000",
                                                                                        "1000"),
                                                new Annuity("1000",
                                                        addSpecificMonth(startDate,4),
                                                        "1000",
                                                        "0",
                                                        "1000",
                                                        "0")

                                    );

        String sampleResultJSON ="[{" +
                                        "\"borrowerPaymentAmount\":\"1000.0\"," +
                                        "\"date\":\"2018-01-01T00:00:01Z\"," +
                                        "\"initialOutstandingPrincipal\":\"5000.0\"," +
                                        "\"interest\":\"0.0\",\"principal\":\"1000.0\"," +
                                        "\"remainingOutstandingPrincipal\":\"4000.0\"}," +
                                    "{" +
                                        "\"borrowerPaymentAmount\":\"1000.0\"," +
                                        "\"date\":\"2018-02-01T00:00:01Z\"," +
                                        "\"initialOutstandingPrincipal\":\"4000.0\"," +
                                        "\"interest\":\"0.0\"," +
                                        "\"principal\":\"1000.0\"," +
                                        "\"remainingOutstandingPrincipal\":\"3000.0\"}," +
                                    "{" +
                                        "\"borrowerPaymentAmount\":\"1000.0\"," +
                                        "\"date\":\"2018-03-01T00:00:01Z\"," +
                                        "\"initialOutstandingPrincipal\":\"3000.0\"," +
                                        "\"interest\":\"0.0\"," +
                                        "\"principal\":\"1000.0\"," +
                                        "\"remainingOutstandingPrincipal\":\"2000.0\"}," +
                                    "{" +
                                        "\"borrowerPaymentAmount\":\"1000.0\"," +
                                        "\"date\":\"2018-04-01T00:00:01Z\"," +
                                        "\"initialOutstandingPrincipal\":\"2000.0\"," +
                                        "\"interest\":\"0.0\"," +
                                        "\"principal\":\"1000.0\"," +
                                        "\"remainingOutstandingPrincipal\":\"1000.0\"}," +
                                    "{" +
                                        "\"borrowerPaymentAmount\":\"0.0\"," +
                                        "\"date\":\"2018-05-01T00:00:01Z\"," +
                                        "\"initialOutstandingPrincipal\":\"1000.0\"," +
                                        "\"interest\":\"0.0\",\"principal\":\"1000.0\"," +
                                        "\"remainingOutstandingPrincipal\":\"0.0\"}]";

        PaymentPlanController mock = org.mockito.Mockito.mock(PaymentPlanController.class);
        when(mock.calculatePlan(loanCondition)).thenReturn(mockResult);
        this.mockMvc.perform(post("http://localhost:" + port + "/generate-plan")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sampleInputJSON)
                .content(sampleInputJSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string(sampleResultJSON));
    }

    private String addSpecificMonth(Date refranceDate,int monthToAdd){

        Calendar cal = Calendar.getInstance();
        cal.setTime(refranceDate);
        cal.add(Calendar.MONTH,monthToAdd);

        return cal.getTime().toString();

    }

}
