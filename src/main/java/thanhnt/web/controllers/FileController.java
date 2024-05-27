//package thanhnt.web.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import thanhnt.web.entities.FileEntity;
//import thanhnt.web.services.FileSystemStorageService;
//import thanhnt.web.services.StorageService;
//
//@Controller
//@RequestMapping("/admin")
//public class FileController {
//
//    private final StorageService storageService;
//
//    @Autowired
//    public FileController(StorageService storageService) {
//        this.storageService = storageService;
//    }
//
//    @GetMapping("/media")
//    public String listAllFiles(Model model) {
//        List<FileEntity> files = storageService.getAllFiles();
//        model.addAttribute("files", files);
//        return "file/fileslist";
//    }
//
//    @GetMapping("/media/{id}")
//    public String getFile(@PathVariable Long id, Model model) {
//        FileEntity fileEntity = storageService.getFile(id);
//        if (fileEntity != null) {
//            model.addAttribute("file", fileEntity);
//            return "file/filedetails";
//        } else {
//            return "file/errors";
//        }
//    }
//
//    @GetMapping("/media/upload")
//    public String showUploadForm() {
//        return "file/upload";
//    }
//
//    @PostMapping("/media/upload")
//    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
//        storageService.store(file);
//        model.addAttribute("message", "File uploaded successfully");
//        return "redirect:/admin/media";
//    }
//
//    @GetMapping("/media/delete/{id}")
//    public String deleteFile(@PathVariable Long id, Model model) {
//        storageService.deleteFile(id);
//        model.addAttribute("message", "File deleted successfully");
//        return "redirect:/admin/media";
//    }
//}
