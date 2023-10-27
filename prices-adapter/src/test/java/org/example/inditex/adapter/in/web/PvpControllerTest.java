package org.example.inditex.adapter.in.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.example.inditex.application.port.in.GetPvpUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PvpController.class)
class PvpControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetPvpUseCase getPvpUseCase;

  @DisplayName("Test path not found")
  @Test
  void testNotFoundRequest() throws Exception {
    this.mockMvc.perform(get("/prices")).andDo(print()).andExpect(status().isNotFound());
  }

  @DisplayName("Test invalid media type")
  @Test
  void testBadMediaType() throws Exception {
    this.mockMvc
        .perform(get("/prices/pvp"))
        .andDo(print())
        .andExpect(status().isUnsupportedMediaType());
  }

  @DisplayName("Test empty request")
  @Test
  void testBadRequest() throws Exception {
    this.mockMvc
        .perform(
            get("/prices/pvp")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isBadRequest());
  }

  @DisplayName("Test incomplete request")
  @Test
  void testBadRequestWithIncompleteParams() throws Exception {
    this.mockMvc
        .perform(
            get("/prices/pvp")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"productId\": 1}"))
        .andDo(print())
        .andExpect(status().isBadRequest());
  }

  @DisplayName("Test invalid date format")
  @Test
  void testBadDateFormatRequest() throws Exception {
    this.mockMvc
        .perform(
            get("/prices/pvp?productId=1&brandId=1&date=2020-06-14")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isBadRequest());
  }

  @DisplayName("Test 404")
  @Test
  void test404Request() throws Exception {
    Mockito.when(getPvpUseCase.resolve(Mockito.any())).thenThrow(new NoSuchElementException());

    this.mockMvc
            .perform(
                    get("/prices/pvp?productId=1&brandId=1&date=" + LocalDateTime.of(2020, 6, 14, 15, 0, 0))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isNotFound());
  }

  @DisplayName("Test OK request")
  @Test
  void testOkRequest() throws Exception {
    this.mockMvc
        .perform(
            get("/prices/pvp?productId=1&brandId=1&date=" + LocalDateTime.of(2020, 6, 14, 15, 0, 0))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }
}
