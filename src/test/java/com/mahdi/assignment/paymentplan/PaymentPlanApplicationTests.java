package com.mahdi.assignment.paymentplan;

import com.mahdi.assignment.paymentplan.conroller.CustomizedResponseEntityExceptionHandler;
import com.mahdi.assignment.paymentplan.conroller.PaymentPlanController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentPlanApplicationTests {

    @Autowired
    PaymentPlanController paymentPlanController;
    @Autowired
    CustomizedResponseEntityExceptionHandler customizedResponseEntityExceptionHandler;

    @Test
    public void contextLoads() {
        assertThat(paymentPlanController).isNotNull();
        assertThat(customizedResponseEntityExceptionHandler).isNotNull();
    }

}
