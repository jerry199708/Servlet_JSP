package pic_upload;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // ����W�Ǫ��Ϥ����
        Part imagePart = req.getPart("imageFile");

        // ���w�O�s�Ϥ������|
        String imagePath = "D:/images";
        System.out.println(imagePath);
        // ����W�Ǫ��Ϥ����W
        String fileName = getFileName(imagePart);

        // �զX���㪺�ؼи��|
        Path targetPath = Path.of(imagePath, fileName);

        // �N�Ϥ��O�s����w��m
        try (InputStream inputStream = imagePart.getInputStream()) {
            Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }
        req.setAttribute("fileName", fileName);
        // ���w�V����ܹϤ�������
        res.sendRedirect("display.jsp");
    }

    private String getFileName(Part part) {
        String contentDispositionHeader = part.getHeader("content-disposition");
        String[] elements = contentDispositionHeader.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
