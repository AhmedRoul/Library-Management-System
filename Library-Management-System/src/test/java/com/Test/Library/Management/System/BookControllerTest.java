package com.Test.Library.Management.System;

import com.Test.Library.Management.System.Controllers.BookController;
import com.Test.Library.Management.System.Controllers.LoginController;
import com.Test.Library.Management.System.Entitys.Book;
import com.Test.Library.Management.System.Entitys.RequestsBody.BookRequest;
import com.Test.Library.Management.System.Entitys.RequestsBody.loginRequest;
import com.Test.Library.Management.System.Repositorys.BookRepository;
import com.Test.Library.Management.System.Utils.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BookControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtUtil jwtUtils;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private LoginController loginController;

    @InjectMocks
    private BookController bookController;

    @Autowired
    private MockMvc mockMvc;

    private String jwtToken;

    @BeforeEach
    public void setup() throws Exception {

        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        AuthTestHelper authHelper = new AuthTestHelper();
        authHelper.setup();
        this.jwtToken = authHelper.loginAndGetToken();

    }

    @Test
    public void testGetBook_Success() throws Exception {
        Book book = new Book();
        book.setId(1L);
        when(bookRepository.findById(anyInt())).thenReturn(Optional.of(book));

        mockMvc.perform(get("/api/Books/1")
                        .header("Authorization", "Bearer " + jwtToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    /*@Test
    public void testAddBook_Success() throws Exception {
        BookRequest bookRequest = BookRequest.builder()
                .title("New Book")
                .author("Author Name")
                .isbn("9780262033848")
                .publisherYear((short) 2014)
                .numOfCopies(5)
                .type("Fiction")
                .build();

        Book book = bookRequest.getNewBook();
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        mockMvc.perform(post("/api/Books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwtToken)
                        .content("{\"title\":\"New Book\", \"author\":\"Author Name\", \"isbn\":\"9780262033848\", \"publisherYear\":2014, \"numOfCopies\":5, \"type\":\"Fiction\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("done"))
                .andDo(print());
    }
*/

}
