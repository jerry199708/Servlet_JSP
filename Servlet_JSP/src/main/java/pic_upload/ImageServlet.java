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
        // 獲取上傳的圖片文件
        Part imagePart = req.getPart("imageFile");

        // 指定保存圖片的路徑
        String imagePath = "D:/images";
        System.out.println(imagePath);
        // 獲取上傳的圖片文件名
        String fileName = getFileName(imagePart);

        // 組合完整的目標路徑
        Path targetPath = Path.of(imagePath, fileName);

        // 將圖片保存到指定位置
        try (InputStream inputStream = imagePart.getInputStream()) {
            Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }
        req.setAttribute("fileName", fileName);
        // 重定向到顯示圖片的頁面
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
