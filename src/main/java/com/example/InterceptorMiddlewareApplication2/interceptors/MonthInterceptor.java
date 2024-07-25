package com.example.InterceptorMiddlewareApplication2.interceptors;

import com.example.InterceptorMiddlewareApplication2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private final List<Month> months;

    public MonthInterceptor() {
        months = new ArrayList<>();
        months.add(new Month(1, 1, "January", "Gennaio", "Januar"));
        months.add(new Month(2, 2, "February", "Febbraio", "Februar"));
        months.add(new Month(3, 3, "March", "Marzo", "März"));
        months.add(new Month(4, 4, "April", "Aprile", "April"));
        months.add(new Month(5, 5, "May", "Maggio", "Mai"));
        months.add(new Month(6, 6, "June", "Giugno", "Juni"));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberHeader = request.getHeader("monthNumber");

        if (monthNumberHeader == null || monthNumberHeader.isEmpty()) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), "monthNumber header is missing or empty");
            return false;
        }

        Integer monthNumber;
        try {
            monthNumber = Integer.valueOf(monthNumberHeader);
        } catch (NumberFormatException e) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), "Invalid monthNumber format");
            return false;
        }

        Month month = findMonthByNumber(monthNumber);

        if (month != null) {
            request.setAttribute("month", month);
            return true;
        } else {
            Month emptyMonth = new Month(0, 0, "nope", "nope", "nope");
            request.setAttribute("month", emptyMonth);
            return true;
        }
    }

    private Month findMonthByNumber(Integer monthNumber) {
        for (Month month : months) {
            if (month.getMonthNumber().equals(monthNumber)) {
                return month;
            }
        }
        return null;
    }
}