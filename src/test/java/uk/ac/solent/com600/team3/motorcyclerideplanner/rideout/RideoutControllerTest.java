package uk.ac.solent.com600.team3.motorcyclerideplanner.rideout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import uk.ac.solent.com600.team3.motorcyclerideplanner.MvcResultAssert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(RideoutController.class)
public class RideoutControllerTest {
    @Autowired private MockMvc mockMvc;

    @MockBean private RideoutService rideoutService;

    @Test
    public void getTest() throws Exception {
//        when(rideoutService.test()).thenReturn("Hello, world!");

        MvcResultAssert.assertThat(mockMvc.perform(get("/rideout/test")))
                .hasStatus(HttpStatus.OK)
                .hasContent("Hello, world!");
    }
}
