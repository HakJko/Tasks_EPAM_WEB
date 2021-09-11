package com.epam.rd.autotasks.springstatefulcalc.controller;

import com.epam.rd.autotasks.springstatefulcalc.service.Validation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/calc")
public class ExpressionController {

    @PutMapping("/expression")
    public ResponseEntity putExpression(@RequestBody String expression,
                                        HttpSession session)
            throws IOException {

        if (Validation.validationExpression(expression)) {
            if (session.getAttribute("expression") == null) {
                addExpressionToSession(session, expression);

                return new ResponseEntity(HttpStatus.CREATED);
            } else {
                addExpressionToSession(session, expression);

                return new ResponseEntity(HttpStatus.OK);
            }
        }
        return new ResponseEntity("Wrong Format", HttpStatus.BAD_REQUEST);
    }

    private void addExpressionToSession(HttpSession session, String expression) {
        session.setAttribute("expression", expression);
    }

    @DeleteMapping
    public ResponseEntity deleteExpression(@RequestBody String body,
                                           HttpSession session) {
        session.setAttribute(body, null);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
