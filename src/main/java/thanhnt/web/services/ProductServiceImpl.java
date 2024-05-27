package thanhnt.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thanhnt.web.entities.Product;
import thanhnt.web.repositories.ProductRepository;

@Service

public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}

	@Override
	public Boolean create(Product product) {
		// TODO Auto-generated method stub
		try {
			this.productRepository.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(id).get();
	}

	@Override
	public Boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			this.productRepository.save(product);
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
			this.productRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> searchProduct(String keyword) {
		// TODO Auto-generated method stub
		return this.productRepository.searchProduct(keyword);
	}

	@Override
	public Page<Product> getAll(Integer pageNo) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo-1, 6);
		return this.productRepository.findAll(pageable);
	}

	@Override
	public Page<Product> searchProduct(String keyword, Integer pageNo) {
		// TODO Auto-generated method stub
		List list = this.searchProduct(keyword);
		Pageable pageable = PageRequest.of(pageNo-1, 6);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > 
		list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start, end);
		return new PageImpl<>(list, pageable, this.searchProduct(keyword).size());
	}

}
