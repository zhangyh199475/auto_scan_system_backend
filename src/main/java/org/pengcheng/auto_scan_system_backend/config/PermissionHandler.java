package org.pengcheng.auto_scan_system_backend.config;

import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class PermissionHandler {
    @ExceptionHandler(value = {SignatureException.class})
    @ResponseBody
    public ResponseEntity<?> authorizationException(SignatureException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
