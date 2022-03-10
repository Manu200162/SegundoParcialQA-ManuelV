package api_test.runner;

import api_test.factoryRequest.FactoryRequest;
import api_test.factoryRequest.RequestInformation;
import api_test.helpers.Configuration;
import api_test.helpers.JsonAssert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class MyStepClean {

    Response response;
    RequestInformation requestInformation = new RequestInformation();
    Map<String,String> dynamicVar = new HashMap<>();

    @Given("uso autentificacion {}")
    public void usoAutentificacionNone(String auth) {
        String authBasic="Basic "+ Base64.getEncoder().encodeToString((Configuration.user+":"+Configuration.pwd).getBytes());
        if(auth.equals("basic")){
            requestInformation.setHeaders("Authorization",authBasic);
        }

    }

    @When("uso request {} al enlace{} con el json")
    public void usoRequestPOSTHAlEnlaceApiUserJsonConElJson(String request, String url, String boby) {
        requestInformation.setUrl(Configuration.host+replaceVar(url))
                .setBody(replaceVar(boby));
        response = FactoryRequest.make(request).send(requestInformation);
    }




    @Then("recivo una respuesta {int}")
    public void recivoUnaRespuesta(int expected) {
        response.then().statusCode(expected);
    }

    @And("verifico que el body de respuesta sea")
    public void verificoQueElBodyDeRespuestaSea(String expectedJson) throws Exception {
        JsonAssert.areEqualJson(replaceVar(expectedJson),response.body().asPrettyString(),"Error jsons distintos");
    }

    @When("actualizo con el link {} con el usuario {} y password {} con el json")
    public void actualizoConElLinkApiUserJsonConElUsuarioExamenExamplemanuelUpbComYPasswordPruebaConElJson(String url, String user, String pwd, String body) {
        String authBasic="Basic "+ Base64.getEncoder().encodeToString((user+":"+pwd).getBytes());
        requestInformation.setHeaders("Authorization",authBasic);
        requestInformation.setUrl(Configuration.host+replaceVar(url))
                .setBody(replaceVar(body));
        response = FactoryRequest.make("put").send(requestInformation);
    }

    private String replaceVar(String value){
        for (String attribute: dynamicVar.keySet() ) {
            value=value.replace(attribute,dynamicVar.get(attribute));
        }
        return value;
    }
}
