package com.mprog.servlet;

import com.mprog.util.PropertiesUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.regex.Pattern;


@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    private final String basePath = PropertiesUtil.get("image.base.url");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var bookPart = req.getParameter("bookPart");


        findFileName(bookPart).ifPresentOrElse(
                s -> resp.setHeader("Content-Disposition", "attachment; filename=\"" + s.substring(1) + "\""),
                () -> resp.setHeader("Content-Disposition", "attachment; filename=\"new.txt\"")
        );

        resp.setContentType("application/octet-stream");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var outputStream = resp.getOutputStream()){
            var path = Path.of(basePath, bookPart);
            System.out.println(path.toAbsolutePath());

            var bytes = Files.readAllBytes(path);
            outputStream.write(bytes);
        }

    }

    private Optional<String> findFileName(String test){
//        String test = "/images/javaCore2.jpg";
        String result = null;
        String regex = "/\\w+\\.\\w+";
        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(test);
        while (matcher.find()){
            result = matcher.group();
        }
        return Optional.ofNullable(result);
    }
}