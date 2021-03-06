package Application.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminRequestsControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getAdminPage() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/admin", String.class);
        assertTrue("Could not find /admin page", responseEntity.getStatusCode().is2xxSuccessful());
    }
}