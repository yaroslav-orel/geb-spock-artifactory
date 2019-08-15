package utils


import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.when

class ArtifactManager {

    def static deployArtifact(name, repo){
        given()
                .multiPart(new File("src/test/resources/${name}"))
        .when()
                .put("${repo}/${name}")
        .then()
                .statusCode(201)
    }

    def static deleteArtifact(name, repo) {
        when()
                .delete("${repo}/${name}")
        .then()
                .statusCode(204)
    }

}
