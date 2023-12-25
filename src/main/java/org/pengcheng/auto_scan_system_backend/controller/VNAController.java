package org.pengcheng.auto_scan_system_backend.controller;

import org.pengcheng.auto_scan_system_backend.constant.VNAConstant;
import org.pengcheng.auto_scan_system_backend.service.impl.Instrument;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/vna")
public class VNAController {

    private static Logger logger = Logger.getLogger(VNAConstant.VNA_LOGGER_CONTROLLER);

    @GetMapping("/getVNA")
    public ResponseEntity<String> getVNA() {
        logger.info(VNAConstant.VNA_CONTROLLER_GET_VNA);
        Instrument instrument = new Instrument();
//        int start = 10 ^ 9 * 1, end = 10 ^ 9 * 2;
        instrument.open();
        instrument.writeCmd("*CLS");
        instrument.writeCmd("*IDN?");
//        instrument.writeCmd("CALC:PAR:SEL 'CH1_S11_1'");
//        instrument.writeCmd("FORM:DATA ASCII");
//        instrument.writeCmd("SENS:FREQ:STAR " + start);
//        instrument.writeCmd("SENS:FREQ:STOP " + end);
//        instrument.writeCmd("SENS:SWE:POIN 11;*OPC?");
//        System.out.println(instrument.readResult());
//        instrument.writeCmd("CALC:DATA? SDATA");
        String res = instrument.readResult();
        System.out.println(res);
        instrument.close();
        return new ResponseEntity(res, HttpStatus.OK);
    }
}
