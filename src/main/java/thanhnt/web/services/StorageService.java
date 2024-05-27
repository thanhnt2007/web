package thanhnt.web.services;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void store(MultipartFile file);
	void init();
	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

//	void deleteAll();
}
