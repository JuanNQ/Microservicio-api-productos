package com.ong.microservicioapiproductos.Controladores;

import com.ong.microservicioapiproductos.Repositorios.CategoriasRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CategoriasControladorTest {

    @Autowired
    CategoriasControlador categoriasControlador;

    @Autowired
    MockMvc mockMvc;

    private String url = "/v1/categorias";

    @Test
    void traerCategorias() throws Exception {
        String url2 = this.url + "/traerCategorias";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url2)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status =mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}