package com.example.tests;

import com.example.models.Usario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServeRestTest {

    private static String userId;
    private static long randomNum;
    private static String token;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        randomNum = System.currentTimeMillis();
    }
    @Order(1)
    @Test
    public void shouldGetAllUsers() {
        given()
                .when()
                    .get("/usuarios")
                .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                .body("quantidade", greaterThan(0))
                .body("usuarios", not(empty()));
    }

    @Order(2)
    @Test
    public void shouldFindUserByEmail() {
        String email = given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .extract()
                .path("usuarios[0].email");
        given()
                .queryParam("email", email)
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .body("usuarios[0].email", equalTo(email));

    }

    @Order(3)
    @Test
    public void shouldCreateNewUser() {
        String body = """
                {
                          "nome": "Тайный Покупатель",
                          "email": "spy_%d@qa.com",
                          "password": "secret123",
                          "administrador": "true"
                        }
                """.formatted(randomNum);
        userId = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", notNullValue())
                .extract()
                .response()
                .path("_id");
    }

    @Order(4)
    @Test
    public void shouldUpdateNewUser() {
        String body = """
                {
                          "nome": "Обновлённый Покупатель",
                          "email": "spy_%d@qa.com",
                          "password": "secret123",
                          "administrador": "false"
                        }
                """.formatted(randomNum);
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", userId)
                .body(body)
                .when()
                .put("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));
    }

    @Order(5)
    @Test
    public void shouldLogin() {
        String body = """
                {
                          "email": "spy_%d@qa.com",
                          "password": "secret123"
                        }
                """.formatted(randomNum);
        token = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("message", equalTo("Login realizado com sucesso"))
                .body("authorization", notNullValue())
                .extract()
                .response()
                .path("authorization");
    }

    @Order(6)
    @Test
    public void shouldDeleteUser() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", userId)
                .header("Authorization", token)
                .when()
                .delete("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", userId)
                .when()
                .get("/usuarios/{id}")
                .then()
                .statusCode(400)
                .body("message", equalTo("Usuário não encontrado"));
    }

    @Order(7)
    @Test
    public void shouldGetAllProducts() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .body("quantidade ", greaterThan(0))
                .body("produtos.preco", everyItem(greaterThan(0)))
                .body("produtos.nome", everyItem(not(empty())))
                .body("produtos.nome", hasItem("Logitech MX Vertical"));
    }

    @Order(8)
    @Test
    public void shouldCreateUserFromDto() {
        randomNum = System.currentTimeMillis();
        Usario newUser = new Usario("Тайный Покупатель dto", "spy_%d@qa.com".formatted(randomNum), "secret123", "true");
        given()
                .contentType(ContentType.JSON)
                .body(newUser)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", notNullValue());
    }
}
