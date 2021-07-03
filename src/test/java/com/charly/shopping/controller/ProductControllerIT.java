package com.charly.shopping.controller;

import com.charly.shopping.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Inspiration pour le controller :
 * https://spring.io/guides/gs/spring-boot/
 * https://www.baeldung.com/spring-rest-template-list
 *
 * Inspiration pour les tests d'intégration :
 * https://www.baeldung.com/maven-integration-test
 * https://www.baeldung.com/maven-failsafe-plugin
 * http://maven.apache.org/surefire/maven-failsafe-plugin/
 * */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    private void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port);
    }

    @Test
    public void getProducts() throws Exception {
        ResponseEntity<Product[]> response = template.getForEntity(String.format("%s/product", base.toString()), Product[].class);
        assertThat(response.getBody()).isNotEmpty();
        assertThat(response.getBody()[0].getName()).isEqualTo("TAMA drum");
    }

}
