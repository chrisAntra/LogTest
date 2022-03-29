package com.example.logtest.controller;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import com.example.logtest.Employee;
import com.example.logtest.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




//LoggerFactory vs LogManager?
@RestController
public class Controller {
    @Autowired
    private EmployeeRepository eR;
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    @GetMapping("/log")
    public ResponseEntity<?> logTest(){
        logger.info("this is a log");
        logger.error("this is an error, should be write into app.log file!");
        return new ResponseEntity<String>("this is a log", HttpStatus.OK);
    }
    @GetMapping("/employee")
    public ResponseEntity<?> allEmployee(){
        return new ResponseEntity<>(eR.findAll(), HttpStatus.OK);
    }
    @PostMapping("/employee")
    public ResponseEntity<?> newEmployee(@RequestBody Employee em){
        Employee created = eR.save(em);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }
}
