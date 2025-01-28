package com.mse.mzad.signing.business.services;

import com.mse.mzad.signing.business.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailTemplate {
    @Autowired
    private ResourceLoader resourceLoader;

    public String template(AppUser appUser, String url, String path) {
        // Load the HTML template
        String htmlTemplate = loadHtmlTemplate("classpath:templates/emailTemplates/" + path);
        // Replace placeholders with actual values
        Map<String, String> placeholders = new HashMap<>();
        placeholders.put("{{firstName}}", appUser.getFirstName());
        placeholders.put("{{lastName}}", appUser.getLastName());
        placeholders.put("{{url}}", url);
        return replacePlaceholders(htmlTemplate, placeholders);
    }

    private String loadHtmlTemplate(String templatePath) {
        try {
            Resource resource = resourceLoader.getResource(templatePath);
            Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load HTML template", e);
        }
    }

    private String replacePlaceholders(String template, Map<String, String> placeholders) {
        String result = template;
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
