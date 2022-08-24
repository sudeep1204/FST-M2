package liveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GitHubProject {
    RequestSpecification requestSpec;
    String sshKey;
    int sshKeyId;

    public void setUp{
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token -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")
                .setBaseUri("https://api.github.com")
                .build();

        sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCprfXiwD9aAYl+8pEG+qJsOCEqMeQn0mLCB0332V9qcDSSuDkvOnTptsAFhcwbtXOLK1HB1NB2nEVMH4p1Y2sHLHdnBTrcDnK43XxiiW5Hi3TSkVzEAUfwPlOH0PZgCBgQPDASzzo+8pASIqAqjtEyNmuxu7mLpCVLTAWpGTEKlui2GbDMpV4HYypsZXuwlF9uF///r4eafyM0C0h6XvlCSahyCj+Hj8mzEeDGmUx9pGrlZv5Dx5ZyH8kVnsloutBNlXCntKjjT4HdJ8jInRwfMPfrhZnvvQF+v+r3rqOVp6adnGAqP2iFilvBmpA2xMiuNKRqW0sejg1aEI/8CZ69";

    }

   @Test(priority = 1)
    public void postRequest(){
        String reqBody = "{\title\": \"TestAPIKey\", \"Key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCprfXiwD9aAYl+8pEG+qJsOCEqMeQn0mLCB0332V9qcDSSuDkvOnTptsAFhcwbtXOLK1HB1NB2nEVMH4p1Y2sHLHdnBTrcDnK43XxiiW5Hi3TSkVzEAUfwPlOH0PZgCBgQPDASzzo+8pASIqAqjtEyNmuxu7mLpCVLTAWpGTEKlui2GbDMpV4HYypsZXuwlF9uF///r4eafyM0C0h6XvlCSahyCj+Hj8mzEeDGmUx9pGrlZv5Dx5ZyH8kVnsloutBNlXCntKjjT4HdJ8jInRwfMPfrhZnvvQF+v+r3rqOVp6adnGAqP2iFilvBmpA2xMiuNKRqW0sejg1aEI/8CZ69";
        Response response= given().spec(requestSpec)
                .body(reqBody)
                .when().post();
        System.out.println(response.getBody().asString());
        id = response.then().extract().path("id");
        System.out.println("Id is "+id);
        response.then().body("code", equalTo(201));

    }
    @Test(priority=2)
    public void GET(){
        Response response= given().spec(requestSpec)
                .pathParam("keyId", Id)
                .when().get("/{keyId}");

        System.out.println(response.getBody().asString());
        response.then().statusCode(200);

    }
    @Test(priority=3)
    public void DELETE(){
        Response response= given().spec(requestSpec)
                .pathParam("keyId", Id)
                .when().get("/{keyId}");

        System.out.println(response.getBody().asString());
        response.then().statusCode(204);

}

