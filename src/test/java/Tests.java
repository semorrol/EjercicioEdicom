import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Tests {
    @Test
    void checkHttp200()
    {
        JSONObject body = new JSONObject();
        body.put("firstname", "Andrei");
        body.put("lastname", "Suslov");
        body.put("totalprice", 150);
        body.put("depositpaid", false);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2021-03-13");
        bookingDates.put("checkout", "2021-03-19");
        body.put("bookingdates", bookingDates);
        body.put("additionalneeds", "Cold Air Conditioner");

        given()
                .contentType("application/json")
                .accept("application/json")
                .body(body.toString())
                .post("https://restful-booker.herokuapp.com/booking")
                .then().assertThat().statusCode(200);
    }

    @Test
    void checkBookingDates()
    {
        JSONObject body = new JSONObject();
        body.put("firstname", "Andrei");
        body.put("lastname", "Suslov");
        body.put("totalprice", 150);
        body.put("depositpaid", false);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2021-03-13");
        bookingDates.put("checkout", "2021-03-19");
        body.put("bookingdates", bookingDates);
        body.put("additionalneeds", "Cold Air Conditioner");

        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .body(body.toString())
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .assertThat()
                .extract()
                .response();

        assert response != null;
    }
}
