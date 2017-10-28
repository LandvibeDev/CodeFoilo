package com.landvibe.codefolio.error.handler;

import com.landvibe.codefolio.error.NotFoundException;
import com.landvibe.codefolio.error.UserExistException;
import com.landvibe.codefolio.error.model.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ErrorInfo handleUsernameNotFoundException(HttpServletRequest req, UsernameNotFoundException e) {
        return new ErrorInfo(req.getRequestURL().toString(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = BadCredentialsException.class)
    public ErrorInfo handleBadCredentialsException(HttpServletRequest req, BadCredentialsException e) {
        return new ErrorInfo(req.getRequestURL().toString(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NotFoundException.class)
    public ErrorInfo handleNotFoundException(HttpServletRequest req, NotFoundException e) {
        return new ErrorInfo(req.getRequestURL().toString(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = UserExistException.class)
    public ErrorInfo handleUserExistException(HttpServletRequest req, UserExistException e) {
        return new ErrorInfo(req.getRequestURL().toString(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = AccessDeniedException.class)
    public ErrorInfo handleAccessDeniedException(HttpServletRequest req, AccessDeniedException e) {
        return new ErrorInfo(req.getRequestURL().toString(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ErrorInfo handleException(HttpServletRequest req, Exception e) {
        return new ErrorInfo(req.getRequestURL().toString(), e.getMessage());
    }

}
