package com.example.assignment;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.example.assignment.service.EmployeeService;

//@RunWith(SpringRunner.class)
//@WebMvcTest(EmployeesController.class)
//public class EmployeeControllerTests {
//
//	@Autowired
//    private MockMvc mvc;
// 
//    @MockBean
//    private EmployeeService service;
//	
//    @Test
//    public void list() throws Exception {
//         
//        mvc.perform(get("/employees")
//          .contentType(MediaType.APPLICATION_JSON))
//          .andExpect(status().isOk())
//          .andExpect(jsonPath("$", hasSize(1)))
//          .andExpect(jsonPath("$[0].firstName", is(alex.getFirstName())));
//    }
//}
