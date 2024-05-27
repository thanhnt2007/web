package thanhnt.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thanhnt.web.entities.Category;
import thanhnt.web.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll();
	}

	@Override
	public Boolean create(Category category) {
		// TODO Auto-generated method stub
		try {
			this.categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(id).get();
	}

	@Override
	public Boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			this.categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			this.categoryRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Category> searchCategory(String keyword) {
		// TODO Auto-generated method stub
		return this.categoryRepository.searchCategory(keyword);
	}

	@Override
	public Page<Category> getAll(Integer pageNo) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo-1, 9);
	    return this.categoryRepository.findAll(pageable);
	}

	@Override
	public Page<Category> searchCategory(String keyword, Integer pageNo) {
		// TODO Auto-generated method stub
		List list = this.searchCategory(keyword);
		Pageable pageable = PageRequest.of(pageNo-1, 9);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > 
		list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start, end);
		return new PageImpl<>(list, pageable, this.searchCategory(keyword).size());
	}

}
