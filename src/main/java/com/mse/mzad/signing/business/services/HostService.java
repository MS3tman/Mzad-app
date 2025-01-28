package com.mse.mzad.signing.business.services;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class HostService {

//    public static String getCurrentDomain(HttpServletRequest request) {
//        String scheme = request.getScheme(); // http or https
//        String serverName = request.getServerName(); // domain or host
//        int serverPort = request.getServerPort(); // port number
//        // Construct the domain URL
//        String domain = scheme + "://" + serverName;
//        // Include the port if it's not the default (80 for HTTP, 443 for HTTPS)
//        if (!(scheme.equals("http") && serverPort == 80) && !(scheme.equals("https") && serverPort == 443)) {
//            domain += ":" + serverPort;
//        }
//        return domain;
//    }

    public static String getCurrentDomain(String endpoint, String otp) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path(endpoint).path(otp)
                .build()
                .toUriString();
    }
}
